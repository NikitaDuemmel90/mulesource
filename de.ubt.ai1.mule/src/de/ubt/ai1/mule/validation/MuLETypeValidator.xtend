package de.ubt.ai1.mule.validation

import com.google.inject.Inject
import de.ubt.ai1.mule.muLE.AdditiveExpression
import de.ubt.ai1.mule.muLE.AndExpression
import de.ubt.ai1.mule.muLE.AssignmentOrOperationCall
import de.ubt.ai1.mule.muLE.BasicType
import de.ubt.ai1.mule.muLE.BooleanConstant
import de.ubt.ai1.mule.muLE.ComparisonExpression
import de.ubt.ai1.mule.muLE.CompilationUnit
import de.ubt.ai1.mule.muLE.DeclaredType
import de.ubt.ai1.mule.muLE.Composition
import de.ubt.ai1.mule.muLE.DataType
import de.ubt.ai1.mule.muLE.Dereference
import de.ubt.ai1.mule.muLE.Enumeration
import de.ubt.ai1.mule.muLE.EqualityExpression
import de.ubt.ai1.mule.muLE.ExitStatement
import de.ubt.ai1.mule.muLE.ExponentExpression
import de.ubt.ai1.mule.muLE.Expression
import de.ubt.ai1.mule.muLE.Feature
import de.ubt.ai1.mule.muLE.SymbolReference
import de.ubt.ai1.mule.muLE.SymbolRefAccessModifier
import de.ubt.ai1.mule.muLE.SymbolRefCompositionAttribute
import de.ubt.ai1.mule.muLE.IfStatement
import de.ubt.ai1.mule.muLE.IntegerConstant
import de.ubt.ai1.mule.muLE.LambdaExpression
import de.ubt.ai1.mule.muLE.LetStatement
import de.ubt.ai1.mule.muLE.ListAccess
import de.ubt.ai1.mule.muLE.ListInit
import de.ubt.ai1.mule.muLE.ListInitElements
import de.ubt.ai1.mule.muLE.ListInitFunction
import de.ubt.ai1.mule.muLE.ListType
import de.ubt.ai1.mule.muLE.LoopStatement
import de.ubt.ai1.mule.muLE.MainProcedure
import de.ubt.ai1.mule.muLE.MuLEPackage
import de.ubt.ai1.mule.muLE.MultiplicativeExpression
import de.ubt.ai1.mule.muLE.Null
import de.ubt.ai1.mule.muLE.Operation
import de.ubt.ai1.mule.muLE.OperationInvocation
import de.ubt.ai1.mule.muLE.OperationType
import de.ubt.ai1.mule.muLE.OrExpression
import de.ubt.ai1.mule.muLE.Parameter
import de.ubt.ai1.mule.muLE.ParenthesizedExpression
import de.ubt.ai1.mule.muLE.RationalConstant
import de.ubt.ai1.mule.muLE.Reference
import de.ubt.ai1.mule.muLE.ReferenceType
import de.ubt.ai1.mule.muLE.ReturnStatement
import de.ubt.ai1.mule.muLE.Statement
import de.ubt.ai1.mule.muLE.StringConstant
import de.ubt.ai1.mule.muLE.SuperExpression
import de.ubt.ai1.mule.muLE.TypeParameter
import de.ubt.ai1.mule.muLE.Unary
import de.ubt.ai1.mule.muLE.VariableDeclaration
import de.ubt.ai1.mule.typing.MuLETypeProvider
import java.util.ArrayList
import mule.util.Util
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.validation.Check
import de.ubt.ai1.mule.muLE.Import
import org.eclipse.xtext.validation.EValidatorRegistrar
import de.ubt.ai1.mule.muLE.Attribute
import de.ubt.ai1.mule.muLE.MuLEFactory
import de.ubt.ai1.mule.muLE.ElseIf
import java.util.List

class MuLETypeValidator extends AbstractMuLEValidator {
	@Inject extension MuLETypeProvider

	public static val ERROR_ILLEGAL_EXIT = "IllegalExitStatement"
	public static val ERROR_ILLEGAL_RETURN = "IllegalReturnStatement"
	public static val ERROR_ILLEGAL_RETURN_NO_VALUE = "IllegalReturnStatementNoValue"
	public static val ERROR_SHOULD_BE_REFERENCE_TYPE = "ShouldBeReferenceType"
	public static val ERROR_INCOMPATIBLE_TYPE_PARAMETER = "IncompatibleTypeParameter"
	public static val ERROR_COMPOSITION_INIT_REQUIRED = "CompositionInitRequired"
	public static val ERROR_ACCESS_MODIFIER_NOT_ALLOWED = "AccessModifierNotAllowed"
	public static val ERROR_COMPOSITION_INIT_NOT_ALLOWED = "CompositionInitNotAllowed"
	public static val ERROR_OPERATION_REQUIRES_PARAMETER_PROFILE = "OperationRequiresParameterProfile"
	public static val ERROR_ILLEGAL_ACCESS_MODIFIER = "IllegalAccessModifier"

	override void register(EValidatorRegistrar registrar) {}

	@Check
	def checkType(DataType dt) {
		if (dt instanceof DeclaredType) {
			var typeDec = (dt as DeclaredType).type
			if (typeDec instanceof Composition) {
				var passedTypeParams = (dt as DeclaredType).typeParams
				var expectedTypeParams = typeDec.typeParams
				if (passedTypeParams.length != expectedTypeParams.length) {
					var expectedList = newArrayList
					for (etp : expectedTypeParams) {
						var str = etp.name
						if (etp.superType !== null)
							str += " extends " + etp.superType.name
						expectedList.add(str)
					}
					var actualList = newArrayList
					for (atp : passedTypeParams) {
						var str = atp.dataTypeToString
						actualList.add(str)
					}
					error(
						"You must pass the correct number of type parameters. Expected type parameters are: " +
							expectedList + ", currently passed type parameters are: " + actualList + ".",
						MuLEPackage.Literals.DECLARED_TYPE__TYPE,
						"Wrong number of type parameters."
					)
				}
			}
		}
	}
	
	def void checkAttributeHelper(Attribute a, List<Composition> comps, Composition refComp) {
		if (comps.contains(refComp)) {
			error(
					"Cyclic referencing of compositions detected, use reference types.",
					MuLEPackage.Literals.FEATURE__TYPE, ERROR_SHOULD_BE_REFERENCE_TYPE
				)
			return
		} else {
			comps.add(refComp)
			for (refCompAttr : refComp.attributes) {				
				if (refCompAttr.type instanceof DeclaredType && (refCompAttr.type as DeclaredType).type instanceof Composition) {
					var newRefComp = (refCompAttr.type as DeclaredType).type as Composition
					checkAttributeHelper(refCompAttr, comps, newRefComp)
				}
			}		
		}
	}

	@Check
	def checkType(Feature f) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var type = f.type
		if (f instanceof Attribute) {
			var containerComposition = f.eContainer as Composition
			if (type instanceof DeclaredType && (type as DeclaredType).type === containerComposition) {
				error(
					"An attribute must not have the same type as the containing composition.\nYou can use a reference type instead.",
					MuLEPackage.Literals.FEATURE__TYPE, ERROR_SHOULD_BE_REFERENCE_TYPE
				)
			}
			if (type instanceof DeclaredType && (type as DeclaredType).type !== containerComposition && (type as DeclaredType).type instanceof Composition) {		
				var comps = newArrayList
				comps.add(containerComposition)		
				checkAttributeHelper(f, comps, (type as DeclaredType).type as Composition)
			}
		}
		if (type instanceof DeclaredType) {
			/*
			 * check that type parameter is in inheritance hierarchy
			 * type A<T extends A> ...
			 * variable a : A<integer> 	// <-- WRONG
			 * variable a : A<A> 		// <-- CORRECT
			 */
			if (!(type as DeclaredType).typeParams.empty) {
				for (tp : (type as DeclaredType).typeParams) {
					var expectedTypeDec = (type as DeclaredType).type
					if (expectedTypeDec instanceof Composition &&
						!(expectedTypeDec as Composition).typeParams.isEmpty) {
						var expectedTypeParam = (expectedTypeDec as Composition).typeParams.get(
							(type as DeclaredType).typeParams.indexOf(tp))
						if (expectedTypeParam !== null && expectedTypeParam instanceof TypeParameter) {
							var expectedDeclaredType = MuLEFactory.eINSTANCE.createDeclaredType
							expectedDeclaredType.type = expectedTypeParam
							var validType = isCompatibleType(expectedDeclaredType, tp, f)
							if (!validType) {
								error(
									"Incompatible type was used for type parameter." + "\nExpected type: " +
										getInheritanceList(expectedDeclaredType) + "\nActual type: " +
										tp.dataTypeToString,
									MuLEPackage.Literals.FEATURE__TYPE,
									ERROR_INCOMPATIBLE_TYPE_PARAMETER
								)
							}
						}
					}
				}
			}
			/*
			 * abstract types and type parameters must always be wrapped as reference type, because:
			 * 1) variables and attributes - default value can not be generated
			 * 2) operations - not possible to write a return statement in specific cases (where return null could be used)
			 * 3) parameters - for uniformity reasons
			 */
			var typeDec = type.type
			if (typeDec instanceof Composition) {
				if (typeDec.abstract) {
					error(
						"An abstract type is not allowed to be used directly in a feature declaration.\nEither use a non-abstract type or wrap the abstract type as a reference type.",
						MuLEPackage.Literals.FEATURE__TYPE, ERROR_SHOULD_BE_REFERENCE_TYPE)
				}
				var expectedTypeParamsNumber = typeDec.typeParams.size
				var actualTypeParamsNumber = type.typeParams.size
				if (expectedTypeParamsNumber != actualTypeParamsNumber) {
					error(
						"Wrong number of type parameters was passed." + "\nExpected number of type parameters: " +
							expectedTypeParamsNumber + "\nActual number of type parameters: " + actualTypeParamsNumber,
						MuLEPackage.Literals.FEATURE__TYPE)
				}
			}
			if (typeDec instanceof TypeParameter) {
				error(
					"A type parameter is not allowed to be used directly in a feature declaration.\nEither use a non-abstract type or wrap the type parameter as a reference type.",
					MuLEPackage.Literals.FEATURE__TYPE, ERROR_SHOULD_BE_REFERENCE_TYPE)
			}
		}
	}

//	def boolean containsAbstractType(DataType type) {
//		if (type instanceof DeclaredType && (type as DeclaredType).type instanceof Composition) {
//			var comp = (type as DeclaredType).type as Composition
//			if (comp.abstract) {
//				return true
//			}
//		} else {
//			if (type instanceof ReferenceType) {
//				return type.type.containsAbstractType
//			}
//			if (type instanceof ListType) {
//				return type.type.containsAbstractType
//			}
//		}
//		return false
//	}
	@Check
	def checkType(ElseIf elif) {
		checkExpectedType(elif.expression.typeFor(elif.eContainer), MuLETypeProvider::BOOLEAN_TYPE,
			MuLEPackage.Literals.ELSE_IF__EXPRESSION, elif)
	}

	@Check
	def checkType(Statement s) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		switch (s) {
			VariableDeclaration: {
			}
			ExitStatement: {
				var container = s.eContainer
				var isInLoop = false
				while (container !== null && !isInLoop) {
					if (container instanceof LoopStatement) {
						isInLoop = true
					}
					container = container.eContainer
				}
				if (!isInLoop) {
					error(
						"An exit-statement must be included in the context of a loop-statement, e.g. loop if CONDITION then exit endif STATEMENTS endloop.",
						MuLEPackage.Literals.EXIT_STATEMENT.EIDAttribute, ERROR_ILLEGAL_EXIT)
				}
			}
			LoopStatement: {
			}
			IfStatement: {
				checkExpectedType(s.expression.typeFor(s), MuLETypeProvider::BOOLEAN_TYPE,
					MuLEPackage.Literals.IF_STATEMENT__EXPRESSION, s)
			}
			ReturnStatement: {
				var op = s.eContainer
				var opType = null as DataType
				var found = false
				while (op !== null && opType === null && !found) {
					if (op instanceof Operation) {
						opType = (op as Operation).typeFor(s)
						found = true
					} else if (op instanceof LambdaExpression) {
						opType = (op as LambdaExpression).typeFor(s)
						if (opType instanceof OperationType) {
							opType = opType.type
						}
						found = true
					}
					op = op.eContainer
				}
				if (opType !== null && s.expression === null)
					error("An empty return statement is not allowed in an operation with a return type.",
						MuLEPackage.Literals.RETURN_STATEMENT__EXPRESSION, ERROR_ILLEGAL_RETURN_NO_VALUE)
				else if (opType === null && s.expression !== null)
					error("A non-empty return statement is not allowed in an operation without a return type.",
						MuLEPackage.Literals.RETURN_STATEMENT__EXPRESSION, ERROR_ILLEGAL_RETURN)
				else
					checkExpectedType(typeFor(s.expression, s), opType, MuLEPackage.Literals.RETURN_STATEMENT__EXPRESSION, s)
			}
			AssignmentOrOperationCall: {
				if (s.left !== null && s.right !== null) {
					var left = s.left.typeFor(s)
					var right = s.right.typeFor(s)
					if (right !== null && s.right instanceof Null && !(left instanceof ReferenceType))
						error("You are not allowed to assign a null-reference to a non-reference type.",
							MuLEPackage.Literals.ASSIGNMENT_OR_OPERATION_CALL__RIGHT)
					else {
						checkExpectedType(right, left, MuLEPackage.Literals.ASSIGNMENT_OR_OPERATION_CALL__RIGHT, s)
					}
				}
			}
			LetStatement: {
				var variableType = s.variable.type
				if (!(variableType instanceof ReferenceType)) {
					error("The type of this variable must be a reference type.",
						MuLEPackage.Literals.LET_STATEMENT__VARIABLE)
				}
				var expressionType = s.expression.typeFor(s)
				if (!(expressionType instanceof ReferenceType)) {
					error("The type of this expression must be a reference type.",
						MuLEPackage.Literals.LET_STATEMENT__EXPRESSION)
				}
			}
			default:
				warning("WARNING: validation checks are not implemented for this statement",
					MuLEPackage.Literals.EXPRESSION.EIDAttribute)
		}
	}

	@Check
	def checkType(Expression s) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		switch (s) {
			SymbolReference: {
				var symbol = s.symbol
				if (symbol instanceof Composition) {
					if (symbol.abstract) {
						error(
							"You must not use an abstract composition in order to create a value.\nUse one of its subtypes instead.",
							MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL)
					}
					if (s.compositionInit === null) {
						var expectedAttributes = Util.getListOfPublicAttributesInInheritanceRelation(symbol) 
						var expectedNames = newArrayList
						for (attr : expectedAttributes) {
							expectedNames.add(attr.name)
						}
						var expectedNotation = symbol.name + "{"
						for (name : expectedNames) {
							expectedNotation += name + " = EXPRESSION"
							if (expectedNames.last !== name) {
								expectedNotation += ", "
							}
						}
						expectedNotation += "}"
						error(
							"The referred element is a composition, it requires a composition initialization notation. \nThe correct notation is either: " +
								symbol.name + "{} or " + expectedNotation,
							MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL,
							ERROR_COMPOSITION_INIT_REQUIRED
						)
					}
					if (s.accessModifier !== null) {
						if (s.accessModifier instanceof OperationInvocation) {
							error(
								"You must not use operation invocation notation on a composition value constructor.",
								MuLEPackage.Literals.SYMBOL_REFERENCE__ACCESS_MODIFIER,
								ERROR_ACCESS_MODIFIER_NOT_ALLOWED
							)
						}
						if (s.accessModifier instanceof ListAccess) {
							error(
								"You must not use list index access notation on a composition value constructor.",
								MuLEPackage.Literals.SYMBOL_REFERENCE__ACCESS_MODIFIER,
								ERROR_ACCESS_MODIFIER_NOT_ALLOWED
							)
						}
						if (s.accessModifier instanceof Dereference) {
							error(
								"You must not dereference a composition value constructor.",
								MuLEPackage.Literals.SYMBOL_REFERENCE__ACCESS_MODIFIER,
								ERROR_ACCESS_MODIFIER_NOT_ALLOWED
							)
						}
					}
				} else if (symbol instanceof Feature) {
					if (s.compositionInit !== null) {
						error(
							"You must not use a composition value constructor in this context. Composition value constructors can only be used when referring to composition types in an expression.",
							MuLEPackage.Literals.SYMBOL_REFERENCE__COMPOSITION_INIT,
							ERROR_COMPOSITION_INIT_NOT_ALLOWED
						)
					}
					if (symbol instanceof Operation) {
						var accessMod = s.accessModifier
						if (accessMod === null) {
							if (symbol.eContainer instanceof Composition) {
								error(
									"You must not pass an operation which is a member of a composition to a data container since it may rely on other composition members not accessible in this context.",
									MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL, "Action not allowed.")
							}
							if (symbol.eContainer instanceof CompilationUnit) {
								var callCont = s.eContainer
								while (!(callCont instanceof CompilationUnit))
									callCont = callCont.eContainer
								if (callCont !== null && callCont instanceof CompilationUnit) {
									var symCU = (symbol.eContainer as CompilationUnit)
									var callCU = callCont as CompilationUnit
									if (!callCU.name.equals(symCU.name))
										error(
											"You must not pass an imported operation to a data container since it may rely on other content not accessible in this context.",
											MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL, "Action not allowed.")
								}

							}
						} else if (!(accessMod instanceof OperationInvocation)) {
							error(
								"The referred element is an operation, either invoke it with a parameter profile or pass it without any access modifiers to a data container with an operation type.",
								MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL,
								ERROR_OPERATION_REQUIRES_PARAMETER_PROFILE)
						} else {
							var expectedParamTypes = newArrayList
							for (param : symbol.params) {
								var paramType = param.typeFor(s)
								expectedParamTypes.add(paramType)
							}
							var actualParams = (accessMod as OperationInvocation).params
							checkPassedParameters(expectedParamTypes, actualParams, s)
						}
					} else {
						var firstAccessModifier = s.accessModifier
						var type = symbol.type
						var accessModifier = firstAccessModifier
						while (accessModifier !== null) {
							if (accessModifier instanceof Dereference && !(type instanceof ReferenceType)) {
								error("Invalid access modifier, you must not dereference a non-reference type.",
									MuLEPackage.Literals.SYMBOL_REFERENCE__ACCESS_MODIFIER,
									ERROR_ILLEGAL_ACCESS_MODIFIER)
							}
							if (accessModifier instanceof ListAccess && !(type instanceof ListType)) {
								error("Invalid access modifier, you must not use list access on a non-list type.",
									MuLEPackage.Literals.SYMBOL_REFERENCE__ACCESS_MODIFIER,
									ERROR_ILLEGAL_ACCESS_MODIFIER)
							}
							if (accessModifier instanceof OperationInvocation && !(type instanceof OperationType) &&
								!(symbol instanceof Operation)) {
								error(
									"Invalid access modifier, you must not use operation invocation on a non-operation type.",
									MuLEPackage.Literals.SYMBOL_REFERENCE__ACCESS_MODIFIER,
									ERROR_ILLEGAL_ACCESS_MODIFIER)
							}
							if ((type instanceof OperationType) && !(accessModifier instanceof OperationInvocation)) {
								error(
									"The referred element is an operation, either invoke it with a parameter profile or pass it without any access modifiers to a data container with an operation type.",
									MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL,
									ERROR_OPERATION_REQUIRES_PARAMETER_PROFILE)
							}
							if ((type instanceof OperationType) && (accessModifier instanceof OperationInvocation)) {
								var expectedParamTypes = newArrayList
								for (paramType : (type as OperationType).paramTypes) {
									expectedParamTypes.add(paramType)
								}
								var actualParams = (accessModifier as OperationInvocation).params
								checkPassedParameters(expectedParamTypes, actualParams, s)
							}

							if (type instanceof ListType && accessModifier instanceof ListAccess)
								type = (type as ListType).type
							else if (type instanceof ReferenceType && accessModifier instanceof Dereference)
								type = (type as ReferenceType).type
							else if (type instanceof OperationType && accessModifier instanceof OperationInvocation)
								type = (type as OperationType).type
							accessModifier = accessModifier.accessModifier
						}
					}
				}
			}
			OrExpression: {
				checkExpectedType(s.left.typeFor(s), MuLETypeProvider::BOOLEAN_TYPE,
					MuLEPackage.Literals.OR_EXPRESSION__LEFT, s)
				checkExpectedType(s.right.typeFor(s), MuLETypeProvider::BOOLEAN_TYPE,
					MuLEPackage.Literals.OR_EXPRESSION__RIGHT, s)
			}
			AndExpression: {
				checkExpectedType(s.left.typeFor(s), MuLETypeProvider::BOOLEAN_TYPE,
					MuLEPackage.Literals.AND_EXPRESSION__LEFT, s)
				checkExpectedType(s.right.typeFor(s), MuLETypeProvider::BOOLEAN_TYPE,
					MuLEPackage.Literals.AND_EXPRESSION__RIGHT, s)
			}
			EqualityExpression: {
				val leftType = s.left.typeFor(s)
				val rightType = s.right.typeFor(s)
				if (s.right instanceof Null && !(leftType instanceof ReferenceType) ||
					s.left instanceof Null && !(rightType instanceof ReferenceType)) {
					error("Cannot compare a non-reference type to a null-reference.",
						MuLEPackage.Literals.EQUALITY_EXPRESSION__RIGHT)
				} else {

					if (!isCompatibleType(leftType, rightType, s)) {
						if (!isCompatibleType(rightType, leftType, s)) {
							if (s.right instanceof Null && (leftType instanceof ReferenceType) ||
								s.left instanceof Null && (rightType instanceof ReferenceType)) {
							} else {
								error(
									"Types of both values must be compatible with each other. " +
										"\nType on the left-hand side: " + leftType.dataTypeToString + ". " +
										"\nType on the right-hand side: " + rightType.dataTypeToString + ". ",
									MuLEPackage.Literals.EQUALITY_EXPRESSION.EIDAttribute)
							}
						}

					}
//					checkExpectedType(rightType, leftType, MuLEPackage.Literals.EQUALITY_EXPRESSION__RIGHT, s)
				}
			}
			ComparisonExpression: {
				checkExpectedIntegerOrRational(s.left, MuLEPackage.Literals.COMPARISON_EXPRESSION__LEFT)
				checkExpectedIntegerOrRational(s.right, MuLEPackage.Literals.COMPARISON_EXPRESSION__RIGHT)
			}
			AdditiveExpression: {
				var leftType = s.left.typeFor(s)
				var rightType = s.right.typeFor(s)
				if (s.op.equals("&")) {
					checkExpectedType(leftType, MuLETypeProvider::STRING_TYPE,
						MuLEPackage.Literals.ADDITIVE_EXPRESSION__LEFT, s)
					checkExpectedType(rightType, MuLETypeProvider::STRING_TYPE,
						MuLEPackage.Literals.ADDITIVE_EXPRESSION__RIGHT, s)
				} else {
					checkExpectedIntegerOrRational(s.left, MuLEPackage.Literals.ADDITIVE_EXPRESSION__LEFT)
					checkExpectedIntegerOrRational(s.right, MuLEPackage.Literals.ADDITIVE_EXPRESSION__RIGHT)
				}
			}
			MultiplicativeExpression: {
				val leftType = s.left.typeFor(s)
				val rightType = s.right.typeFor(s)
				if (s.op.equals("div")) {
					checkExpectedType(leftType, MuLETypeProvider::INTEGER_TYPE,
						MuLEPackage.Literals.MULTIPLICATIVE_EXPRESSION__LEFT, s)
					checkExpectedType(rightType, MuLETypeProvider::INTEGER_TYPE,
						MuLEPackage.Literals.MULTIPLICATIVE_EXPRESSION__RIGHT, s)
				}
				checkExpectedIntegerOrRational(s.left, MuLEPackage.Literals.MULTIPLICATIVE_EXPRESSION__LEFT)
				checkExpectedIntegerOrRational(s.right, MuLEPackage.Literals.MULTIPLICATIVE_EXPRESSION__RIGHT)
			}
			ExponentExpression: {
				checkExpectedIntegerOrRational(s.left, MuLEPackage.Literals.EXPONENT_EXPRESSION__LEFT)
				checkExpectedIntegerOrRational(s.right, MuLEPackage.Literals.EXPONENT_EXPRESSION__RIGHT)
			}
			Unary: {
				if (s.op.equals("not"))
					checkExpectedType(s.typeFor(s), MuLETypeProvider::BOOLEAN_TYPE,
						MuLEPackage.Literals.UNARY__EXPRESSION, s)
				else
					checkExpectedIntegerOrRational(s, MuLEPackage.Literals.UNARY__EXPRESSION)
			}
			ListInit: {
				if (s.right !== null) {
					if (s.right instanceof ListInitFunction) {
						if ((s.right as ListInitFunction).op.equals("..")) {
							checkExpectedType(s.left.typeFor(s), MuLETypeProvider::INTEGER_TYPE,
								MuLEPackage.Literals.LIST_INIT__LEFT, s)
							checkExpectedType((s.right as ListInitFunction).expression.typeFor(s),
								MuLETypeProvider::INTEGER_TYPE, MuLEPackage.Literals.LIST_INIT_FUNCTION__EXPRESSION, s)
						} else {
							checkExpectedType(s.left.typeFor(s), MuLETypeProvider::INTEGER_TYPE,
								MuLEPackage.Literals.LIST_INIT__LEFT, s)
						}
					}
					if (s.right instanceof ListInitElements) {
						val expectedType = s.left.typeFor(s);
						for (Expression elem : (s.right as ListInitElements).elements) {
							checkExpectedType(expectedType, elem.typeFor(s), MuLEPackage.Literals.LIST_INIT__RIGHT, s)
						}
					}
				}
			}
			StringConstant: {
			}
			IntegerConstant: {
			}
			RationalConstant: {
			}
			BooleanConstant: {
			}
			ParenthesizedExpression: {
			}
			Null: {
			}
			Reference: {
			}
			SuperExpression: {
				var container = s.eContainer
				while (!(container instanceof CompilationUnit)) {
					if (container instanceof MainProcedure ||
						container instanceof Operation && container.eContainer instanceof CompilationUnit) {
						error(
							"The super expression is not allowed to be used in this context. This expression can only be used in operations defined in a composition.",
							MuLEPackage.Literals.SUPER_EXPRESSION.EIDAttribute)
					}
					if (container instanceof Operation && container.eContainer instanceof Composition) {
						var superType = (container.eContainer as Composition).superType
						if (superType !== null && superType !== container.eContainer) {
							var memberCall = s.memberCall as SymbolReference
							var symbol = memberCall.symbol
							if (symbol instanceof Operation) {
								var opName = (symbol as Operation).name
								for (op : superType.operations) {
									if (op.name.equals(opName) && op.abstract) {
										error(
											"You must not invoke an abstract operation in the context of a super expression.",
											MuLEPackage.Literals.SUPER_EXPRESSION__MEMBER_CALL)
									}
								}
							}
						}
					}
					container = container.eContainer
				}

			}
			LambdaExpression: {
			}
			default:
				warning("WARNING: validation checks are not implemented for this expression",
					MuLEPackage.Literals.EXPRESSION.EIDAttribute)
		}
	}

	def private checkPassedParameters(ArrayList<DataType> expectedParamTypes, EList<Expression> actualParams,
		SymbolReference fc) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (expectedParamTypes.size !== actualParams.size) {
			var types = ""
			for (expectedParamType : expectedParamTypes) {
				if (expectedParamTypes.indexOf(expectedParamType) !== 0)
					types += ", "
				types += expectedParamType.dataTypeToString

			}
			error(
				"Invalid number of arguments was passed. Expected types of arguments are: " + types + ".",
				MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL
			)
		} else {
			for (expectedParamType : expectedParamTypes) {
				var passedArg = actualParams.get(expectedParamTypes.indexOf(expectedParamType))
				var passedArgType = passedArg.typeFor(fc)
				var expectedArgType = expectedParamType
				// check if contained in a feature call, get type and check if there are typeParams
				var sCont = fc.eContainer
				if (sCont instanceof SymbolReference && (sCont as SymbolReference).symbol instanceof Feature) {
					var sContSymbolType = ((sCont as SymbolReference).symbol as Feature).type
					if (sContSymbolType instanceof DeclaredType &&
						!(sContSymbolType as DeclaredType).typeParams.empty) {
						var compDeclaration = (sContSymbolType as DeclaredType).type
						if (compDeclaration instanceof Composition) {
							for (genericTypeParam : compDeclaration.typeParams) {
								if (genericTypeParam.name.equals(expectedArgType)) {
									var index = compDeclaration.typeParams.indexOf(genericTypeParam)
									var actualTypeParam = (sContSymbolType as DeclaredType).typeParams.get(index)
									expectedArgType = actualTypeParam.typeFor(fc)
								}
							}
						}
					}
				}
				if (sCont instanceof SymbolReference && (sCont as SymbolReference).symbol instanceof Import) {
					return
				}
				checkExpectedType(passedArgType, expectedArgType, MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL,
					passedArg)
			}
		}
	}

	@Check
	def checkType(SymbolRefCompositionAttribute fcca) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var expectedType = fcca.attribute.typeFor(fcca)
		var actualType = fcca.expression.typeFor(fcca)
		checkExpectedType(actualType, expectedType, MuLEPackage.Literals.SYMBOL_REF_COMPOSITION_ATTRIBUTE__EXPRESSION,
			fcca)
	}

	def boolean isEqualType(DataType expectedType, DataType actualType, EObject context) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (expectedType instanceof ReferenceType && actualType instanceof ReferenceType) {
			return isEqualType((expectedType as ReferenceType).type, (actualType as ReferenceType).type, context)
		}
		if (expectedType instanceof ListType && actualType instanceof ListType) {
			return isEqualType((expectedType as ListType).type, (actualType as ListType).type, context)
		}
		if (expectedType instanceof BasicType && actualType instanceof BasicType) {
			var expectedTypeName = (expectedType as BasicType).typeName
			var actualTypeName = (actualType as BasicType).typeName
			if (expectedTypeName.equals(actualTypeName))
				return true
		}
		if (expectedType instanceof DeclaredType && (expectedType as DeclaredType).type instanceof TypeParameter) {
		}
		if (expectedType instanceof DeclaredType && actualType instanceof DeclaredType) {
			var expectedTypeDec = (expectedType as DeclaredType).type
			var actualTypeDec = (actualType as DeclaredType).type
			if (expectedTypeDec instanceof Composition && actualTypeDec instanceof Composition) {
				if (actualTypeDec.name.equals(expectedTypeDec.name)) {
					return true
				}
			}
		}
		return false
	}

	def boolean isCompatibleType(DataType expectedType, DataType actualType, EObject context) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (expectedType === null && actualType === null) {
			return true
		}
		if (expectedType instanceof OperationType && actualType instanceof OperationType) {
			var expectedReturnType = (expectedType as OperationType).type
			var actualReturnType = (actualType as OperationType).type
			if (!isCompatibleType(expectedReturnType, actualReturnType, context))
				return false
			var expectedParamTypes = (expectedType as OperationType).paramTypes
			var actualParamTypes = (actualType as OperationType).paramTypes
			if (expectedParamTypes.length !== actualParamTypes.length)
				return false
			var paramsAreCompatible = true
			for (var i = 0; i < expectedParamTypes.length; i++) {
				paramsAreCompatible = paramsAreCompatible &&
					isCompatibleType(expectedParamTypes.get(i), actualParamTypes.get(i), context)
			}
			return paramsAreCompatible
		}
		if (expectedType instanceof ReferenceType && actualType instanceof ReferenceType) {
			var expectedTypeType = (expectedType as ReferenceType).type
			var actualTypeType = (actualType as ReferenceType).type
			if (expectedTypeType instanceof ListType && actualTypeType instanceof ListType) {
				return isEqualType(expectedTypeType, actualTypeType, context)
			}
			return isCompatibleType(expectedTypeType, actualTypeType, context)
		}
		if (expectedType instanceof ListType && actualType instanceof ListType) {
			return isCompatibleType((expectedType as ListType).type, (actualType as ListType).type, context)
		}
		if (expectedType instanceof BasicType && actualType instanceof BasicType) {
			var expectedTypeName = (expectedType as BasicType).typeName
			var actualTypeName = (actualType as BasicType).typeName
			if (expectedTypeName.equals(actualTypeName) ||
				expectedTypeName.equals("rational") && actualTypeName.equals("integer"))
				return true
			if (context instanceof EqualityExpression &&
				(expectedTypeName.equals("rational") && actualTypeName.equals("integer") ||
					expectedTypeName.equals("integer") && actualTypeName.equals("rational"))) {
				return true
			}
		}
		if (expectedType instanceof DeclaredType && (expectedType as DeclaredType).type instanceof TypeParameter) {
			var expectedTypeParameter = (expectedType as DeclaredType).type as TypeParameter
			if (actualType instanceof DeclaredType && (actualType as DeclaredType).type instanceof TypeParameter) {
				var actualTypeParameter = (actualType as DeclaredType).type as TypeParameter
				if (actualTypeParameter.name.equals(expectedTypeParameter.name)) {
					return true
				}
			} else {
				// check if parameter type is correct
				if (context instanceof Expression) {
					var container = context.eContainer
					while (container !== null) {
						if (container instanceof SymbolReference) {
							var lastAccessMod = container.accessModifier
							while (lastAccessMod !== null && lastAccessMod.accessModifier !== null) {
								lastAccessMod = lastAccessMod.accessModifier
							}
							// we are in a method call
							if (lastAccessMod instanceof OperationInvocation) {
								if (container.eContainer instanceof SymbolReference) {
									var featureDeclaration = container.eContainer as SymbolReference
									var typeOfFeatureDeclaration = featureDeclaration.typeFor2 // type of the featureDeclaration, with the conrete type parameter
									if (container.symbol instanceof Operation) {
										var composition = container.symbol.eContainer
										if (composition instanceof Composition) {
											if (typeOfFeatureDeclaration instanceof DeclaredType) {
												if (typeOfFeatureDeclaration.type == composition) {
													// get the index of the type parameter in the type declaration
													var indexOfTypeParam = composition.typeParams.indexOf(
														(expectedType as DeclaredType).type)
													// get the corresponding type parameter in the feature declaration
													var expectedType2 = typeOfFeatureDeclaration.typeParams.get(
														indexOfTypeParam)
													// check if compatible
													return isCompatibleType(expectedType2, actualType, context)
												}
											}
										}
									}
								}
							}
						}
						container = container.eContainer
					}
				} 
				if (context instanceof AssignmentOrOperationCall) {
					var left = context.left
					if (left instanceof SymbolReference) {
						var type = left.typeFor2
						if (type instanceof DeclaredType) {
							var typeDec = type.type
							if (typeDec instanceof Composition) {
								var expectedType2 = type.typeParams.get(
									typeDec.typeParams.indexOf((expectedType as DeclaredType).type))
								return isCompatibleType(actualType, expectedType2, context)
							}
						}
					}
				}
			}
			if (expectedTypeParameter.superType !== null) {
				var expectedInheritanceList = getInheritanceList(expectedType)
				var actuelTypeString = actualType.dataTypeToString
				if (!expectedInheritanceList.contains(actuelTypeString)) {
					return false
				}
			}
			return true
		}
		if (expectedType instanceof DeclaredType && actualType instanceof DeclaredType) {
			var expectedTypeDec = (expectedType as DeclaredType).type
			var actualTypeDec = (actualType as DeclaredType).type
			if (expectedTypeDec instanceof Composition && actualTypeDec instanceof Composition) {
				if (actualTypeDec.name.equals(expectedTypeDec.name)) {
					return true
				}
				var actualSuperType = (actualTypeDec as Composition).superType as Composition
				while (actualSuperType !== null && actualSuperType !== actualTypeDec) {
					if (actualSuperType.name.equals(expectedTypeDec.name)) {
						return true
					}
					actualSuperType = actualSuperType.superType
				}
			} else if (expectedTypeDec instanceof TypeParameter && actualTypeDec instanceof TypeParameter) {
				if (expectedTypeDec.name.equals(actualTypeDec.name)) {
					return true
				}
			} else if (expectedTypeDec instanceof Enumeration && actualTypeDec instanceof Enumeration) {
				if (expectedTypeDec.name.equals(actualTypeDec.name)) {
					return true
				}
			}
		}
		return false
	}

	def private ArrayList<String> getInheritanceList(DataType type) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var list = newArrayList
		if (type instanceof DeclaredType) {
			if ((type as DeclaredType).type instanceof Composition) {
				var comp = (type as DeclaredType).type as Composition
				list.add(comp.name)
				var superType = comp.superType
				while (superType !== null && superType !== comp) {
					list.add(superType.name)
					superType = superType.superType
				}
			}
			if ((type as DeclaredType).type instanceof TypeParameter) {
				var tp = (type as DeclaredType).type as TypeParameter
				list.add(tp.name)
				var superType = tp.superType
				while (superType !== null && superType !== tp) {
					var DeclaredType = MuLEFactory.eINSTANCE.createDeclaredType
					DeclaredType.type = superType
					list.add(DeclaredType.dataTypeToString)
					superType = superType.superType
				}
			}
		}
		if (type instanceof BasicType) {
			if ((type as BasicType).typeName.equals("integer")) {
				list.add("integer")
				list.add("rational")
			} else {
				list.add(type.typeName)
			}
		}
		if (type instanceof ReferenceType) {
			var referencedTypes = type.type.inheritanceList
			for (referencedType : referencedTypes) {
				list.add("reference<" + referencedType + ">")
			}
		}
		if (type instanceof ListType) {
			var referencedTypes = type.type.inheritanceList
			for (referencedType : referencedTypes) {
				list.add("list<" + referencedType + ">")
			}
		}
		return list
	}

	def private checkExpectedIntegerOrRational(Expression exp, EReference ref) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		val actualType = exp.typeFor(null)
		val condition = actualType instanceof BasicType && !(actualType as BasicType).typeName.equals("integer") &&
			!(actualType as BasicType).typeName.equals("rational") || !(actualType instanceof BasicType)

		if (condition) {
			error("Expected type is: integer or rational.\nActual type is: " + actualType.dataTypeToString + ".", ref)
		}
	}

	def private checkExpectedType(DataType actualType, DataType expectedType, EReference ref, EObject context) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var actualTypeString = actualType.dataTypeToString
		var expectedTypeString = expectedType.dataTypeToString
		if (actualType !== null && expectedType !== null && !actualTypeString.contains("DataType") &&
			!expectedTypeString.contains("DataType")) {
			if (!isCompatibleType(expectedType, actualType, context)) {
//				var test = isCompatibleType(expectedType, actualType, context) // for debugging
//				println(test)
//				var e = new Exception
//				e.printStackTrace
//				println("expectedType: " + expectedType + " - " + expectedType.inheritanceList)
//				println("actualType: " + actualType + " - " + actualType.dataTypeToString)
//				error("Expected type are: " + expectedType.inheritanceList + "\nActual type is: " +
//					actualType.dataTypeToString, ref)
				error("Expected type is: " + expectedType.dataTypeToString + ".\nActual type is: " +
					actualType.dataTypeToString + ".", ref)
			}
		} else {
			/*
			 * A fix for using procedures in an expressions or assignments
			 */
			if (actualTypeString === "null" && expectedTypeString !== "null") {
				if (context instanceof Expression || context instanceof AssignmentOrOperationCall) {
					error("Expected type is: " + expectedType.dataTypeToString + ".\nActual type is: " +
						actualType.dataTypeToString + ".", ref)
				}
			}
			/*
			 * A fix for Lists operations due to this mule library not following mules own rules.
			 * Maybe change the library to an OO solution?
			 */
			var contextContainer = context.eContainer
			if (contextContainer instanceof OperationInvocation) {
				var fcSymbol = (contextContainer.eContainer as SymbolReference).symbol
				if (fcSymbol instanceof Operation) {
					var opContainer = fcSymbol.eContainer
					var opName = fcSymbol.name
					if (opContainer instanceof CompilationUnit &&
						(opContainer as CompilationUnit).name.equals("Lists")) {
						var opNames = newArrayList("append", "prepend", "indexOf", "removeElement", "insert")
						if (opNames.contains(opName)) {
							var firstParamType = contextContainer.params.get(0).typeFor(context)
							var secondParamType = contextContainer.params.get(1).typeFor(context)
							if (firstParamType instanceof ListType) {
								if (!firstParamType.type.dataTypeToString.contains("DataType") &&
									!isCompatibleType(firstParamType.type, secondParamType, context)) {
//									println("expected: " + firstParamType.type)
//									println("actual: " + secondParamType)
									error(
										"Expected type is: " + firstParamType.type.dataTypeToString +
											".\nActual type is: " + secondParamType.dataTypeToString + ".", ref)
								}
							}
						}
						opNames = newArrayList("forEach", "filter")
						if (opNames.contains(opName)) {
							var firstParamType = contextContainer.params.get(0).typeFor(context)
							var secondParamType = contextContainer.params.get(1).typeFor(context)
							if (firstParamType instanceof ListType && secondParamType instanceof OperationType) {
								firstParamType = (firstParamType as ListType).type
								secondParamType = (secondParamType as OperationType).paramTypes?.get(0)
								if (!isCompatibleType(firstParamType, secondParamType, context)) {
//									println("expected: " + firstParamType)
//									println("actual: " + secondParamType)
									var actualString1 = "list<" + firstParamType.dataTypeToString + ">"
									var actualString2 = "operation(" + secondParamType.dataTypeToString + ")"
									if (opName.equals("filter"))
										actualString2 = actualString2 + " : boolean"
									var actualString = opName + "(" + actualString1 + ", " + actualString2 + ")"
									var expectedString = opName + "(" + actualString1 + ", " +
										actualString2.replace(secondParamType.dataTypeToString,
											firstParamType.dataTypeToString) + ")"
									error("Expected signature is: " + expectedString + ".\nActual signature is: " +
										actualString + ".", ref)
								}
							}
						}
					}
				}
			}
		}
	}
}
