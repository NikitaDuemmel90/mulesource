package de.ubt.ai1.mule.typing

import de.ubt.ai1.mule.muLE.AdditiveExpression
import de.ubt.ai1.mule.muLE.AndExpression
import de.ubt.ai1.mule.muLE.BasicType
import de.ubt.ai1.mule.muLE.BooleanConstant
import de.ubt.ai1.mule.muLE.ComparisonExpression
import de.ubt.ai1.mule.muLE.CompilationUnit
import de.ubt.ai1.mule.muLE.Composition
import de.ubt.ai1.mule.muLE.DataType
import de.ubt.ai1.mule.muLE.DeclaredType
import de.ubt.ai1.mule.muLE.Dereference
import de.ubt.ai1.mule.muLE.Enumeration
import de.ubt.ai1.mule.muLE.EnumerationValue
import de.ubt.ai1.mule.muLE.EqualityExpression
import de.ubt.ai1.mule.muLE.ExponentExpression
import de.ubt.ai1.mule.muLE.Feature
import de.ubt.ai1.mule.muLE.Import
import de.ubt.ai1.mule.muLE.IntegerConstant
import de.ubt.ai1.mule.muLE.LambdaExpression
import de.ubt.ai1.mule.muLE.ListAccess
import de.ubt.ai1.mule.muLE.ListInit
import de.ubt.ai1.mule.muLE.ListInitElements
import de.ubt.ai1.mule.muLE.ListInitFunction
import de.ubt.ai1.mule.muLE.ListType
import de.ubt.ai1.mule.muLE.MuLEFactory
import de.ubt.ai1.mule.muLE.MultiplicativeExpression
import de.ubt.ai1.mule.muLE.Null
import de.ubt.ai1.mule.muLE.Operation
import de.ubt.ai1.mule.muLE.OperationInvocation
import de.ubt.ai1.mule.muLE.OperationType
import de.ubt.ai1.mule.muLE.OrExpression
import de.ubt.ai1.mule.muLE.ParenthesizedExpression
import de.ubt.ai1.mule.muLE.RationalConstant
import de.ubt.ai1.mule.muLE.Reference
import de.ubt.ai1.mule.muLE.ReferenceType
import de.ubt.ai1.mule.muLE.ReturnStatement
import de.ubt.ai1.mule.muLE.StringConstant
import de.ubt.ai1.mule.muLE.SuperExpression
import de.ubt.ai1.mule.muLE.SymbolReference
import de.ubt.ai1.mule.muLE.TypeDeclaration
import de.ubt.ai1.mule.muLE.TypeParameter
import de.ubt.ai1.mule.muLE.Unary
import mule.util.MuLEObjectCopyProvider
import org.eclipse.emf.ecore.EObject

class MuLETypeProvider {

	public static val STRING_TYPE = MuLEFactory.eINSTANCE.createBasicType() => [typeName = "string"]
	public static val INTEGER_TYPE = MuLEFactory.eINSTANCE.createBasicType() => [typeName = "integer"]
	public static val RATIONAL_TYPE = MuLEFactory.eINSTANCE.createBasicType() => [typeName = "rational"]
	public static val BOOLEAN_TYPE = MuLEFactory.eINSTANCE.createBasicType() => [typeName = "boolean"]
	
	/*
	 * This method calculates type for a specific feature call ignoring its member calls unlike the typeFor method.
	 * Currently this is used by the ScopeProvider.
	 */
	def DataType typeFor2(SymbolReference obj) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var symbol = obj.symbol
		if (symbol instanceof Feature) {
			var type = symbol.type
			var accessModifier = obj.accessModifier
			while (accessModifier !== null) {
				if (type instanceof ListType && accessModifier instanceof ListAccess)
					type = (type as ListType).type
				else if (type instanceof ReferenceType && accessModifier instanceof Dereference)
					type = (type as ReferenceType).type
				else if (type instanceof OperationType && accessModifier instanceof OperationInvocation)
					type = (type as OperationType).type
				accessModifier = accessModifier.accessModifier
			}
			type = resolveTypeParameter(type, obj, obj, obj)
			return type
		}
		return null
	}

	def DataType typeFor(EObject obj, EObject context) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		switch (obj) {
			SymbolReference: {
				var receiver = obj
				while (receiver.memberCall !== null)
					receiver = receiver.memberCall
				var symbol = receiver.symbol
				if (symbol instanceof Feature) {
					var type = symbol.type
					if (symbol instanceof Operation && symbol.eContainer instanceof CompilationUnit &&
						(symbol.eContainer as CompilationUnit).name.equals("Lists")) { // fix for Lists operations
						if (type instanceof ListType && (receiver.accessModifier instanceof OperationInvocation)) {
							var param = (receiver.accessModifier as OperationInvocation).params.get(0)
							if (param instanceof ListInit && (param as ListInit).left === null &&
								(param as ListInit).right === null) {
								if ((receiver.accessModifier as OperationInvocation).params.size > 1) {
									if (symbol instanceof Operation &&
										(symbol as Operation).params.get(1).type instanceof DeclaredType) {
										param = (receiver.accessModifier as OperationInvocation).params.get(1)
										var actualType = MuLEFactory.eINSTANCE.createListType
										actualType.type = param.typeFor(obj)
										return actualType
									}
								}
							}
							var actualType = param.typeFor(obj)
							var accessModifier = receiver.accessModifier
							while (accessModifier !== null) {
								if (actualType instanceof ListType && accessModifier instanceof ListAccess)
									actualType = (actualType as ListType).type
								else if (actualType instanceof ReferenceType && accessModifier instanceof Dereference)
									actualType = (actualType as ReferenceType).type
								else if (actualType instanceof OperationType && accessModifier instanceof OperationInvocation)
									actualType = (actualType as OperationType).type
								accessModifier = accessModifier.accessModifier
							}
							return actualType
						} else if (type instanceof DeclaredType && (type as DeclaredType).type.eIsProxy) {
							var param = (receiver.accessModifier as OperationInvocation).params.get(0)
							var actualType = param.typeFor(obj)
							if (actualType instanceof ListType)
								return actualType.type
						}
					}
					if (symbol instanceof Operation) {
						var temp = MuLEFactory.eINSTANCE.createOperationType
						temp.type = MuLEObjectCopyProvider.copyMuLEObject(symbol.type) as DataType
						for (param : symbol.params) {
							var paramType = MuLEObjectCopyProvider.copyMuLEObject(param.type) as DataType
							temp.paramTypes.add(paramType)
						}
						type = temp
					}
					var accessModifier = receiver.accessModifier
					while (accessModifier !== null) {
						if (type instanceof ListType && accessModifier instanceof ListAccess)
							type = (type as ListType).type
						else if (type instanceof ReferenceType && accessModifier instanceof Dereference)
							type = (type as ReferenceType).type
						else if (type instanceof OperationType && accessModifier instanceof OperationInvocation)
							type = (type as OperationType).type
						accessModifier = accessModifier.accessModifier
					}
					type = resolveTypeParameter(type, obj, receiver, context)
					return type
				} else if (symbol instanceof Composition) {
					var type = MuLEFactory.eINSTANCE.createDeclaredType()
					type.type = symbol
					return type
				} else if (symbol instanceof EnumerationValue) {
					var enumeration = symbol.eContainer as Enumeration
					var type = MuLEFactory.eINSTANCE.createDeclaredType()
					type.type = enumeration
					return type
				}
				return null
			}
			OperationInvocation: {
				var container = obj.eContainer
				if (container instanceof SymbolReference) {
					var symbol = container.symbol
					if (symbol instanceof Feature) {
						var symbolType = symbol.type
						if (symbolType instanceof OperationType) {
							return symbolType
						}
					}
				}
				var containerType = container.typeFor(context)
				var type = null as DataType
				if (containerType instanceof OperationType)
					type = containerType.type
				return type
			}
			Feature: {
				return obj.type
			}
			SuperExpression: {
				var receiver = obj.memberCall
				while (receiver.memberCall !== null) {
					receiver = receiver.memberCall
				}
				receiver.typeFor(context)
			}
			OrExpression:
				BOOLEAN_TYPE
			AndExpression:
				BOOLEAN_TYPE
			EqualityExpression:
				BOOLEAN_TYPE
			ComparisonExpression:
				BOOLEAN_TYPE
			AdditiveExpression: {
				val left = obj.left.typeFor(context)
				val right = obj.right.typeFor(context)
				if (obj.op.equals("&")) {
					return STRING_TYPE
				} else if (left == RATIONAL_TYPE || right == RATIONAL_TYPE) {
					return RATIONAL_TYPE
				} else {
					return INTEGER_TYPE
				}
			}
			MultiplicativeExpression: {
				val left = obj.left.typeFor(context)
				val right = obj.right.typeFor(context)
				if (left == RATIONAL_TYPE || right == RATIONAL_TYPE || obj.op == "/") {
					return RATIONAL_TYPE
				} else {
					return INTEGER_TYPE
				}
			}
			EnumerationValue: {
				var typeDec = obj.eContainer as Enumeration
				var type = MuLEFactory.eINSTANCE.createDeclaredType()
				type.type = typeDec
				return type
			}
			ExponentExpression:
				RATIONAL_TYPE
			StringConstant:
				STRING_TYPE
			IntegerConstant:
				INTEGER_TYPE
			RationalConstant:
				RATIONAL_TYPE
			BooleanConstant:
				BOOLEAN_TYPE
			ParenthesizedExpression:
				obj.expression.typeFor(context)
			Unary: {
				if (obj.op.equals("not"))
					return BOOLEAN_TYPE
				else
					return obj.expression.typeFor(context)
			}
			Null: {
				var type = MuLEFactory.eINSTANCE.createReferenceType()
				type.type = MuLEFactory.eINSTANCE.createBasicType()
				(type.type as BasicType).typeName = "DataType"
				return type
			}
			Reference: {
				var refType = MuLEFactory.eINSTANCE.createReferenceType()
				var exprType = obj.expression.typeFor(context)
				if (exprType !== null) {
					var typeCpy = MuLEObjectCopyProvider.copyMuLEObject(exprType)
					if (typeCpy !== null) {
						refType.type = typeCpy as DataType
						return refType
					}
					return null
				}
				return null
			}
			ListInit: {
				if (obj.right === null) {
					if (obj.left === null) {
						var type = MuLEFactory.eINSTANCE.createListType()
						type.type = MuLEFactory.eINSTANCE.createBasicType()
						(type.type as BasicType).typeName = "DataType"
						return type
					} else {
						var type = MuLEFactory.eINSTANCE.createListType()
						type.type = MuLEObjectCopyProvider.copyMuLEObject(obj.left.typeFor(context)) as DataType
						return type
					}
				} else {
					/*
					 * the type of a list init with elements with different types from the same hierarchy
					 * is the type of the element with the highest type in the hierarchy
					 */
					if (obj.right instanceof ListInitElements) {
						var type = obj.left.typeFor(context)
						for (expr : (obj.right as ListInitElements).elements) {
							var exprType = expr.typeFor(context)
							if (type instanceof DeclaredType && exprType instanceof DeclaredType) {
								var typeDec = (type as DeclaredType).type
								var exprTypeDec = (exprType as DeclaredType).type
								if (typeDec instanceof Composition && exprTypeDec instanceof Composition) {
									if ((typeDec as Composition).superType === (exprTypeDec as Composition)) {
										type = exprType
									}
								}
							} else if (type instanceof BasicType && (type as BasicType).typeName.equals("integer")) {
								if (expr.typeFor(context) instanceof BasicType &&
									(expr.typeFor(context) as BasicType).typeName.equals("rational")) {
									type = RATIONAL_TYPE
								}
							}
						}
						var result = MuLEFactory.eINSTANCE.createListType()
						result.type = MuLEObjectCopyProvider.copyMuLEObject(type) as DataType
						return result
					} else if (obj.right instanceof ListInitFunction) {
						var result = MuLEFactory.eINSTANCE.createListType()
						var exprType = (obj.right as ListInitFunction).expression.typeFor(context)
						result.type = MuLEObjectCopyProvider.copyMuLEObject(exprType) as DataType
						return result
					}
				}
			}
			ReturnStatement: {
				if (obj.expression !== null)
					return obj.expression.typeFor(context)
				else
					return null
			}
			LambdaExpression: {
				var paramTypes = newArrayList
				for (param : obj.parameters) {
					var type = param.typeFor(context)
					var typeCpy = MuLEObjectCopyProvider.copyMuLEObject(type) as DataType
					paramTypes.add(typeCpy)
				}
				var returnType = MuLEObjectCopyProvider.copyMuLEObject(obj.type) as DataType
				var opType = MuLEFactory.eINSTANCE.createOperationType()
				opType.type = returnType
				opType.paramTypes.addAll(paramTypes)
				return opType
			}
			Import: {
				return null
			}
			default: {
				return null
			}
		}
	}

	def DataType resolveTypeParameter(DataType type, SymbolReference obj, SymbolReference receiver, EObject context) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (type instanceof ReferenceType) {
			var typeType = resolveTypeParameter(type.type, obj, receiver, context)
			var refType = MuLEFactory.eINSTANCE.createReferenceType
			refType.type = MuLEObjectCopyProvider.copyMuLEObject(typeType) as DataType
			return refType
		}
		if (type instanceof ListType) {
			var typeType = resolveTypeParameter(type.type, obj, receiver, context)
			var listType = MuLEFactory.eINSTANCE.createListType
			listType.type = MuLEObjectCopyProvider.copyMuLEObject(typeType) as DataType
			return listType
		}
		if (type instanceof DeclaredType) {
			var typeDec = type.type
			if (typeDec instanceof TypeParameter) {
				var symbolType = obj.symbol.typeFor(context)
				while (symbolType instanceof ReferenceType || symbolType instanceof ListType) {
					if (symbolType instanceof ReferenceType)
						symbolType = symbolType.type
					if (symbolType instanceof ListType)
						symbolType = symbolType.type
				}
				if (symbolType instanceof DeclaredType) {
					var symbolTypeTypeDec = symbolType.type
					if (symbolTypeTypeDec instanceof Composition) {
						var index = -1
						var counter = 0
						for (tP : symbolTypeTypeDec.typeParams) {
							if (typeDec.name == tP.name) {
								index = counter
							}
							counter++
							}
						var actualTypeParameter = symbolType.typeParams.get(index)
						return actualTypeParameter
					}
				}
			}
		}
		return type
	}

	def String dataTypeToString(DataType type) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (type instanceof ReferenceType)
			return "reference<" + type.type.dataTypeToString + ">"
		if (type instanceof ListType)
			return "list<" + type.type.dataTypeToString + ">"
		if (type instanceof BasicType)
			return type.typeName
		if (type instanceof DeclaredType) {
			var result = type.type.name
			if (type.type.eIsProxy) {
				if (type.type instanceof TypeDeclaration) {
					return "DataType"
				}
			}
			return result
		}
		if (type instanceof OperationType) {
			var result = "operation("
			for (paramType : type.paramTypes) {
				result += paramType.dataTypeToString
				if (!type.paramTypes.last.equals(paramType))
					result += ", "
			}
			result += ")"
			if (type.type !== null)
				result += " : " + type.type.dataTypeToString
			return result
		}
		return "null"
	}
}
