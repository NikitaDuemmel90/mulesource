/*
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.mule.validation

import de.ubt.ai1.mule.muLE.AssignmentOrOperationCall
import de.ubt.ai1.mule.muLE.Block
import de.ubt.ai1.mule.muLE.CompilationUnit
import de.ubt.ai1.mule.muLE.Composition
import de.ubt.ai1.mule.muLE.ElseIf
import de.ubt.ai1.mule.muLE.ElseLet
import de.ubt.ai1.mule.muLE.Enumeration
import de.ubt.ai1.mule.muLE.ExitStatement
import de.ubt.ai1.mule.muLE.SymbolReference
import de.ubt.ai1.mule.muLE.SymbolRefCompositionInit
import de.ubt.ai1.mule.muLE.IfStatement
import de.ubt.ai1.mule.muLE.Import
import de.ubt.ai1.mule.muLE.IntegerConstant
import de.ubt.ai1.mule.muLE.LetStatement
import de.ubt.ai1.mule.muLE.LoopStatement
import de.ubt.ai1.mule.muLE.MuLEPackage
import de.ubt.ai1.mule.muLE.NamedElement
import de.ubt.ai1.mule.muLE.Operation
import de.ubt.ai1.mule.muLE.OperationInvocation
import de.ubt.ai1.mule.muLE.RationalConstant
import de.ubt.ai1.mule.muLE.ReturnStatement
import de.ubt.ai1.mule.muLE.Statement
import de.ubt.ai1.mule.muLE.SuperExpression
import java.util.ArrayList
import java.util.List
import java.util.regex.Pattern
import mule.util.Util
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ComposedChecks
import de.ubt.ai1.mule.scoping.MuLEScopeProvider
import com.google.inject.Inject
import de.ubt.ai1.mule.muLE.LambdaExpression
import de.ubt.ai1.mule.muLE.Parameter
import de.ubt.ai1.mule.muLE.MainProcedure
import de.ubt.ai1.mule.muLE.VariableDeclaration
import de.ubt.ai1.mule.muLE.TypeParameter

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@ComposedChecks(validators=#[MuLETypeValidator, MuLENamesValidator])
class MuLEValidator extends AbstractMuLEValidator {

	@Inject MuLEScopeProvider sopeProvider

	public static val ERROR_NO_RETURN = "MissingReturnStatement"
	public static val ERROR_INTEGER_STARTS_WITH_ZERO = "IntegerStartsWithZeros"
	public static val ERROR_RATIONAL_STARTS_WITH_ZERO = "RationalStartsWithZeros"
	public static val ERROR_ASSIGNMENT_TO_OPERATION = "AssignmentToOperation"
	public static val ERROR_ASSIGNMENT_TO_PARAMETER = "AssignmentToParameter"
	public static val ERROR_CYCLIC_INHERITANCE = "CyclicInheritance"
	public static val ERROR_UNIMPLEMENTED_OPERATIONS = "UnimplementedOperations"
	public static val ERROR_MISSING_INHERITED_TYPE_PARAMETERS = "MissingInheritedTypeParameters"
	public static val ERROR_MISSING_OUTER_TYPE_PARAMETERS = "MissingOuterTypeParameters"
	public static val ERROR_OPERATION_BOTH_ABSTRACT_AND_OVERRIDE = "OperationBothAbstractAndOverride"
	public static val ERROR_ABSTRACT_OPERATION_IN_NON_ABSTRACT_TYPE = "AbstactOpInNonAbstractType"
	public static val ERROR_ABSTRACT_OPERATION_IN_COMPILATION_UNIT = "AbstractOpInCompilationUnit"
	public static val ERROR_ABSTRACT_OPERATION_HAS_BODY = "AbstractOpHasBody"
	public static val ERROR_NON_ABSTRACT_OPERATION_HAS_NO_BODY = "NonAbstractOpHasNoBody"
	public static val ERROR_OVERRIDE_IN_NON_OVERRIDING_OPERATION = "OverrideInNonOverridingOp"
	public static val ERROR_NO_OVERRIDE_IN_OVERRIDING_OPERATION = "NoOverrideInOverridingOp"
	public static val ERROR_DIFFERENT_VISIBILITY_OF_OVERRIDING_OPERATION = "DifferentVisibilityOfOverridingOp"
	public static val ERROR_OVERRIDING_OPERATION_DIFFERENT_PARAMETERS = "OverridingOpDifferentParams"
	public static val ERROR_OVERRIDING_OPERATION_DIFFERENT_RETURN_TYPE = "OverridingOpDifferentReturnType"
	public static val ERROR_ILLEGAL_OVERRIDE = "IllegalOverride"
	public static val ERROR_PROGRAM_HAS_NO_MAIN = "ProgramHasNoMain"
	public static val ERROR_LIBRARY_HAS_MAIN = "LibHasMain"
	public static val ERROR_FILE_NAME_DIFFERENT = "FileNameDifferent"
	public static val ERROR_INCORRECT_ATTRIBUTE_SEQUENCE = "IncorrectAttrSequence"
	public static val ERROR_ILLEGAL_VISIBILITY = "IllegalVisibility"

	public static val ERROR_MESSAGE__PROTECTED_NOT_ALLOWED = "The visibility modifier protected is not allowed in this context.\n You may use private if you wish to prevent operations and type declarations to be exported from the library."
	public static val ERROR_MESSAGE__VISIBLITY_NOT_ALLOWED = "A visibility modifier is not allowed in this context.\n You must not restrict visibility of operations and type declarations within a program unit."

	@Check
	def checkIntegerLiterals(IntegerConstant obj) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var value = obj.value
		try {
			Integer.parseInt(value)
		} catch (NumberFormatException e) {
			error("The value is out of the supported range (-2147483648..+2147483647).",
				MuLEPackage.Literals.INTEGER_CONSTANT__VALUE)
		}
		var length = value.length
		var firstChar = value.charAt(0).toString
		if (length > 1) {
			if (firstChar.equals("0")) {
				error("Invalid literal, an integer literal with multiple digits must not start with a zero.",
					MuLEPackage.Literals.INTEGER_CONSTANT__VALUE, ERROR_INTEGER_STARTS_WITH_ZERO)
			}
		}
	}

	@Check
	def checkRationalLiterals(RationalConstant obj) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var value = obj.value
		var parsedValue = Double.parseDouble(value)
		if (parsedValue.toString.equals("Infinity") ||
			parsedValue == 0.0 && !value.toString.equals(parsedValue.toString)) {
			error("The value is out of the supported range.", MuLEPackage.Literals.RATIONAL_CONSTANT__VALUE)
		}
		val tmp = value.split(Pattern.quote("."))
		var intPart = tmp.get(0)
		var length = intPart.length
		var firstChar = intPart.charAt(0).toString
		if (length > 1) {
			if (firstChar.equals("0")) {
				error(
					"Invalid literal, the integer part of a rational literal must not start with a zero when having multiple digits.",
					MuLEPackage.Literals.RATIONAL_CONSTANT__VALUE, ERROR_RATIONAL_STARTS_WITH_ZERO)
			}
		}
	}

	@Check
	def checkAssignmentToOperationCall(AssignmentOrOperationCall a) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var receiver = a.getReceiverInAssignment
		var receiverSymbol = receiver.symbol
		if (receiverSymbol instanceof Parameter && receiverSymbol.eContainer instanceof LambdaExpression) {
			error(
				"You are not allowed to assign a value to a parameter of a lambda expression.",
				MuLEPackage.Literals.ASSIGNMENT_OR_OPERATION_CALL.EIDAttribute,
				ERROR_ASSIGNMENT_TO_PARAMETER
			)
		}
		var lastAccessMod = receiver.accessModifier
		while (lastAccessMod !== null && lastAccessMod.accessModifier !== null) {
			lastAccessMod = lastAccessMod.accessModifier
		}
		if (lastAccessMod instanceof OperationInvocation && a.right !== null)
			error(
				"You are not allowed to assign a value to an operation invocation statement.",
				MuLEPackage.Literals.ASSIGNMENT_OR_OPERATION_CALL.EIDAttribute,
				ERROR_ASSIGNMENT_TO_OPERATION
			)
	}

	def SymbolReference getReceiverInAssignment(AssignmentOrOperationCall a) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var left = a.left
		if (left instanceof SymbolReference) {
			var receiver = left
			while (receiver.memberCall !== null)
				receiver = receiver.memberCall
			return receiver
		}
		if (left instanceof SuperExpression) {
			var receiver = left.memberCall
			while (receiver.memberCall !== null)
				receiver = receiver.memberCall
			return receiver
		}
		return null
	}

	@Check
	def checkForUnreachableCode(Statement s) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (s.eContainer instanceof Block) {
			var indexOfStatment = (s.eContainer as Block).statements.indexOf(s)
			var priorStatements = (s.eContainer as Block).statements.subList(0, indexOfStatment)
			var found = checkForUnreachableCodeHelper(priorStatements)
			if (found) {
				error("Unreachable code.", MuLEPackage.Literals.STATEMENT.EIDAttribute)
			}
		}
	}

	def boolean checkForUnreachableCodeHelper(List<Statement> statements) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var found = false
		for (Statement s : statements) {
			if (s instanceof ReturnStatement) {
				found = true
			}
			if (s instanceof ExitStatement) {
				found = true
			}
			if (s instanceof IfStatement) {
				var foundTemp = checkForUnreachableCodeHelper(s.block.statements)
				for (ElseIf eif : s.elseIfs) {
					foundTemp = foundTemp && checkForUnreachableCodeHelper(eif.block.statements)
				}
				if (s.elseBlock !== null)
					foundTemp = foundTemp && checkForUnreachableCodeHelper(s.elseBlock.statements)
				else
					foundTemp = false
				found = foundTemp
			}
			if (s instanceof LetStatement) {
				var foundTemp = checkForUnreachableCodeHelper(s.block.statements)
				for (ElseLet elet : s.elseLets) {
					foundTemp = foundTemp && checkForUnreachableCodeHelper(elet.block.statements)
				}
				if (s.elseBlock !== null)
					foundTemp = foundTemp && checkForUnreachableCodeHelper(s.elseBlock.statements)
				else
					foundTemp = false
				found = foundTemp
			}
			if (s instanceof LoopStatement) {
				found = checkForUnreachableCodeHelper(s.block.statements)
			}
		}
		return found
	}

	@Check
	def checkTypeParameterDeclaration(TypeParameter tp) {
		var cont = tp.eContainer
		if (cont instanceof CompilationUnit) {
			error("This declaration is not allowed in this context.", MuLEPackage.Literals.NAMED_ELEMENT__NAME)
		}
		if (cont instanceof Composition && (cont as Composition).typeDeclarations.contains(tp)) {
			error("This declaration is not allowed in this context.", MuLEPackage.Literals.NAMED_ELEMENT__NAME)
		}
	}

	@Check
	def checkReturnStatementInFunctions(Operation op) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (!op.abstract) {
			if (op.type !== null) {
				var statementsReversed = getReversedStatements(op.block.statements)
				var found = checkForReturnStatement(statementsReversed)
				if (found == false)
					error("An operation with a return type must have a return statement.",
						MuLEPackage.Literals.FEATURE__TYPE, ERROR_NO_RETURN)
			}
		}
	}

	@Check
	def checkReturnStatementInAnonymousFunctions(LambdaExpression op) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (op.type !== null) {
			var statementsReversed = getReversedStatements(op.block.statements)
			var found = checkForReturnStatement(statementsReversed)
			if (found == false)
				error("An operation with a return type must have a return statement.",
					MuLEPackage.Literals.LAMBDA_EXPRESSION__TYPE, ERROR_NO_RETURN)
		}
	}

	def ArrayList<Statement> getReversedStatements(List<Statement> statements) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var statementsReversed = newArrayList
		for (var i = statements.size - 1; i >= 0; i--) {
			statementsReversed.add(statements.get(i))
		}
		return statementsReversed
	}

	def boolean checkForReturnStatement(List<Statement> statements) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var found = false
		for (Statement s : statements) {
			if (s instanceof ReturnStatement) {
				found = true
			} else if (s instanceof LoopStatement) {
				found = found || checkForReturnStatement(s.block.statements.reversedStatements)
			} else if (s instanceof IfStatement) {
				found = found || checkForReturnStatement(s.block.statements.reversedStatements)
				for (ElseIf eif : s.elseIfs) {
					found = found || checkForReturnStatement(eif.block.statements.reversedStatements)
				}
				if (s.elseBlock !== null)
					found = found || checkForReturnStatement(s.elseBlock.statements.reversedStatements)
			} else if (s instanceof LetStatement) {
				found = found || checkForReturnStatement(s.block.statements.reversedStatements)
				for (ElseLet elet : s.elseLets) {
					found = found || checkForReturnStatement(elet.block.statements.reversedStatements)
				}
				if (s.elseBlock !== null)
					found = found || checkForReturnStatement(s.elseBlock.statements.reversedStatements)
			}
		}
		return found
	}

	@Check
	def checkForCyclicInheritanceAndUnimplementedOperations(Composition c) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		/*
		 * Check for cyclic inheritance
		 */
		var listOfNames = newArrayList
		var superType = c.superType
		while (superType !== null) {
			var qualifiedName = superType.name
			var container = superType.eContainer
			while (container !== null && (container instanceof NamedElement)) {
				qualifiedName = (container as NamedElement).name + "." + qualifiedName
				container = container.eContainer
			}
			if (listOfNames.contains(qualifiedName)) {
				error(
					"Cyclic inheritance is not permitted. \nCheck the following type declarations and remove the cycle in the inheritance: " +
						listOfNames + ".", MuLEPackage.Literals.COMPOSITION__SUPER_TYPE, ERROR_CYCLIC_INHERITANCE)
				return
			}
			listOfNames.add(qualifiedName)
			superType = superType.superType
		}
		/*
		 * Check for unimplemented operations
		 */
		if (!c.abstract) {
			/* get a list of inherited abstract operations */
			var inheritedAbstractOps = newArrayList
			superType = c.superType
			while (superType !== null) {
				for (op : superType.operations) {
					if (op.abstract) {
						inheritedAbstractOps.add(op.name)
					}
				}
				superType = superType.superType
			}
			// filter out abstract operations already implemented in super types
			superType = c.superType
			while (superType !== null) {
				for (op : superType.operations) {
					if (!op.abstract) {
						inheritedAbstractOps.remove(op.name)
					}
				}
				superType = superType.superType
			}
			/* check if the inherited operations are implemented */
			var unimplementedOps = newArrayList
			var ops = newArrayList
			for (op : c.operations) {
				ops.add(op.name)
			}
			for (inheritedOp : inheritedAbstractOps) {
				if (!ops.contains(inheritedOp)) {
					unimplementedOps.add(inheritedOp)
				}
			}
			if (!unimplementedOps.isEmpty) {
				error(
					"Composition inherits unimplemented abstract operations: " + unimplementedOps + ".",
					MuLEPackage.Literals.NAMED_ELEMENT__NAME,
					ERROR_UNIMPLEMENTED_OPERATIONS
				)
			}
		}
		/*
		 * Check for type parameters in inheritance hierarchy
		 */
		superType = c.superType
		var inheritedTypeParams = newArrayList
		while (superType !== null) {
			inheritedTypeParams.addAll(superType.typeParams)
			superType = superType.superType
		}
		var inheritedTypeParamsNames = newArrayList
		for (inhTP : inheritedTypeParams) {
			inheritedTypeParamsNames.add(inhTP.name)
		}
		var ownTypeParamsNames = newArrayList
		for (ownTP : c.typeParams) {
			ownTypeParamsNames.add(ownTP.name)
		}
		for (inhTPName : inheritedTypeParamsNames) {
			if (!ownTypeParamsNames.contains(inhTPName)) {
				error(
					"Composition declaration must include all inherited type parameters.\nInherited type parameters are: " +
						inheritedTypeParamsNames + ".\nOwned type parameters are: " + ownTypeParamsNames + ".",
					MuLEPackage.Literals.NAMED_ELEMENT__NAME,
					ERROR_MISSING_INHERITED_TYPE_PARAMETERS
				)
			}
		}
		/*
		 * check for type parameters in nested types
		 */
		if (c.eContainer instanceof Composition) {
			for (oTP : (c.eContainer as Composition).typeParams) {
				if (!ownTypeParamsNames.contains(oTP.name)) {
					error(
						"Declaration of a nested composition must include all type parameters of its outer composition.",
							MuLEPackage.Literals.NAMED_ELEMENT__NAME, ERROR_MISSING_OUTER_TYPE_PARAMETERS
					)
				}
			}
		}
	}

	@Check
	def checkAbstractOperationsAndOverrides(Operation op) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var containedInComposition = false
		var opContainer = op.eContainer
		if (op.abstract) {
			if (op.override) {
				error("An operation can not be abstract and override at the same time.",
					MuLEPackage.Literals.NAMED_ELEMENT__NAME, ERROR_OPERATION_BOTH_ABSTRACT_AND_OVERRIDE)
			}
			/* check for abstract operations in non abstract types and compilation units */
			while (!(opContainer instanceof CompilationUnit)) {
				if (opContainer instanceof Composition) {
					containedInComposition = true
					if (!opContainer.abstract) {
						error("Declaration of abstract operations is not allowed in non abstract types.",
							MuLEPackage.Literals.OPERATION__ABSTRACT, ERROR_ABSTRACT_OPERATION_IN_NON_ABSTRACT_TYPE)
					}
				}
				opContainer = opContainer.eContainer
			}
			if (opContainer instanceof CompilationUnit && !containedInComposition) {
				error("Declaration of abstract operations is not allowed in compilation units.",
					MuLEPackage.Literals.OPERATION__ABSTRACT, ERROR_ABSTRACT_OPERATION_IN_COMPILATION_UNIT)
			}
			/* check if an abstract operation has an operation body */
			if (op.block !== null) {
				error(
					"An abstract operation must not have an operation body.",
					MuLEPackage.Literals.NAMED_ELEMENT__NAME,
					ERROR_ABSTRACT_OPERATION_HAS_BODY
				)
			}
		} else {
			/* check if a non abstract operation has an operation body */
			if (op.block === null) {
				error("A non-abstract operation must have an operation body.",
					MuLEPackage.Literals.OPERATION.EIDAttribute, ERROR_NON_ABSTRACT_OPERATION_HAS_NO_BODY)
			}
			/* check if the redefining operation has the override keyword 
			 * as well as the same parameter profile
			 * */
			while (!(opContainer instanceof CompilationUnit)) {
				if (opContainer instanceof Composition) {
					containedInComposition = true
					var opName = op.name
					var inheritedOps = newArrayList
					var inheritedOpNames = newArrayList
					var superType = opContainer.superType
					while (superType !== null && superType !== opContainer) {
						for (inheritedOp : superType.operations) {
							inheritedOps.add(inheritedOp)
							inheritedOpNames.add(inheritedOp.name)
						}
						superType = superType.superType
					}
					if (!inheritedOpNames.contains(opName) && op.override) {
						error(
							"This operation does not override any inherited operation. \nThe override keyword is not allowed in this case.",
							MuLEPackage.Literals.NAMED_ELEMENT__NAME, ERROR_OVERRIDE_IN_NON_OVERRIDING_OPERATION)
					}
					/*
					 * Check that an overriding operation has an override keyword
					 * check that the overriding operation has same visibility modifier as the inherited operation
					 * Also check that overriding operation has the same parameter profile, since overloading is not allowed
					 * Also check that both operations gave the same return type
					 */
					for (inheritedOp : inheritedOps) {
						if (inheritedOp.name.equals(opName)) {
							if (!op.override) {
								error(
									"This operation overrides an inherited operation with the same name. \nPlease use the override keyword.",
									MuLEPackage.Literals.NAMED_ELEMENT__NAME, ERROR_NO_OVERRIDE_IN_OVERRIDING_OPERATION)
							}
							if ((op.visibility !== null && inheritedOp.visibility === null) ||
								(op.visibility === null && inheritedOp.visibility !== null) ||
								(op.visibility !== null && inheritedOp.visibility !== null &&
									!(op.visibility.equals(inheritedOp.visibility)))) {
								error(
									"An overriding operation must have the same visibility modifier as the overridden operation.",
									MuLEPackage.Literals.OPERATION__VISIBILITY,
									ERROR_DIFFERENT_VISIBILITY_OF_OVERRIDING_OPERATION)
							}
							var opParams = op.params
							var inheritedOpParams = inheritedOp.params
							var equal = true
							if (opParams.size != inheritedOpParams.size) {
								equal = false
							} else {
								for (opParam : opParams) {
									var inheritedOpParam = inheritedOpParams.get(opParams.indexOf(opParam))
									if (inheritedOpParam.name != opParam.name) {
										equal = false
									} else if (inheritedOpParam.type.toString.equals(opParam.type.toString)) {
										equal = false
									}
								}
							}
							if (!equal) {
								error(
									"The super type has an operation with the same name but with a different parameter profile." +
										"\nBoth operations must have either different names or the same parameter profile.",
									MuLEPackage.Literals.NAMED_ELEMENT__NAME,
									ERROR_OVERRIDING_OPERATION_DIFFERENT_PARAMETERS)
							}
							var inhTyp = inheritedOp.type
							var opType = op.type
							var check = true
							if (inhTyp !== null && opType !== null) {
								var typeValidator = new MuLETypeValidator
								check = typeValidator.isCompatibleType(inhTyp, opType, op)
							} else if (inhTyp !== null && opType === null || inhTyp === null && opType !== null) {
								check = false
							}
							if (!check) {
								error(
									"The overriding operation must have the same return type as the overridden operation.",
									MuLEPackage.Literals.FEATURE__TYPE,
									ERROR_OVERRIDING_OPERATION_DIFFERENT_RETURN_TYPE)
							}
						}
					}
				}
				opContainer = opContainer.eContainer
			}
			/* check if override is used on a non member operation */
			if (opContainer instanceof CompilationUnit && !containedInComposition) {
				if (op.override) {
					error(
						"An operation declared in a compilation unit must not be marked with the modifier override.",
						MuLEPackage.Literals.OPERATION__OVERRIDE,
						ERROR_ILLEGAL_OVERRIDE
					)
				}
			}
		}
	}

	@Check
	def checkMainInProgram(CompilationUnit p) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (p.isProgram && p.main === null) {
			error(
				"A program must have a main operation.",
				MuLEPackage.Literals.COMPILATION_UNIT__IS_PROGRAM,
				ERROR_PROGRAM_HAS_NO_MAIN
			)
		}
		if (p.isLibrary && p.main !== null) {
			error(
				"A library must not have a main operation.",
				MuLEPackage.Literals.COMPILATION_UNIT__IS_LIBRARY,
				ERROR_LIBRARY_HAS_MAIN
			)
		}
	}

	@Check
	def checkProgramName(CompilationUnit p) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var file = p.eResource.URI.lastSegment
		var fileWithoutExtension = file.substring(0, file.lastIndexOf("."))
		if (p.name != fileWithoutExtension)
			error(
				"Program name must be equal to the file name.",
				MuLEPackage.Literals.NAMED_ELEMENT__NAME,
				ERROR_FILE_NAME_DIFFERENT
			)
	}

	@Check
	def checkLooseSymbolReference(SymbolReference fc) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (fc.eContainer instanceof Block) {
			var lastMemberCall = fc
			while (lastMemberCall.memberCall !== null) {
				lastMemberCall = lastMemberCall.memberCall
			}
			var lastAccessMod = lastMemberCall.accessModifier
			while (lastAccessMod !== null && lastAccessMod.accessModifier !== null) {
				lastAccessMod = lastAccessMod.accessModifier
			}
			if (!(lastAccessMod instanceof OperationInvocation)) {
				error("Illegal use of feature call, must be either an operation call or part of an assignment.",
					MuLEPackage.Literals.ASSIGNMENT_OR_OPERATION_CALL__LEFT)
			}
		}
		var symbol = fc.symbol
		if (symbol instanceof CompilationUnit) {
			if (fc.memberCall === null) {
				error(
					"Incomplete expression, you have to access a type declaration or an operation from the imported library via its qualified name.",
					MuLEPackage.Literals.ASSIGNMENT_OR_OPERATION_CALL__RIGHT)
			}
		}
		/*
		 * check if contained in a lambda expression
		 */
		var container = fc.eContainer
		var continue = true
		while (container !== null && continue) {
			if (container instanceof LambdaExpression) {
				continue = false
				var scope = sopeProvider.getScope(fc, MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL)
				for (element : scope.allElements) {
					var referencedObject = element.EObjectOrProxy
					var containingConstruct = referencedObject.eContainer
					while (containingConstruct !== null && !(containingConstruct instanceof Block)) {
						containingConstruct = containingConstruct.eContainer
					}
					if (containingConstruct instanceof Block)
						containingConstruct = containingConstruct.eContainer
					if (containingConstruct !== container) {
						if (fc.symbol === referencedObject && (referencedObject instanceof VariableDeclaration)) {
							error(
								"You are not allowed to refer to a variable which was declared outside of the immediate lambda expression.",
								MuLEPackage.Literals.SYMBOL_REFERENCE__SYMBOL)
						}
					}
				}
			} else if (container instanceof MainProcedure || container instanceof Operation) {
				continue = false
			}
			container = container.eContainer
		}
	}

	@Check
	def checkSymbolRefCompositionInit(SymbolRefCompositionInit fcci) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var fc = fcci.eContainer as SymbolReference
		var symbol = fc.symbol
		if (symbol instanceof Composition) {
			var expectedAttributes = Util.getListOfPublicAttributesInInheritanceRelation(symbol)
			var expectedNames = newArrayList
			for (attr : expectedAttributes) {
				expectedNames.add(attr.name)
			}
			var actualnames = newArrayList
			for (attr : fcci.attributes) {
				actualnames.add(attr.attribute.name)
			}
			if (!expectedNames.equals(actualnames) && !actualnames.isEmpty) {
				var expectedNotation1 = symbol.name + "{"
				for (name : expectedNames) {
					expectedNotation1 += name + " = EXPRESSION"
					if (expectedNames.last !== name) {
						expectedNotation1 += ", "
					}
				}
				expectedNotation1 += "}"
				var expectedNotation2 = symbol.name + "{}"
				error(
					"Incorrect attribute sequence used in the composition value constructor. \nThe correct notation is either: " +
						expectedNotation1 + "\nor " + expectedNotation2,
					MuLEPackage.Literals.SYMBOL_REF_COMPOSITION_INIT.EIDAttribute,
					ERROR_INCORRECT_ATTRIBUTE_SEQUENCE
				)
			}
		} else {
			error(
				"You must not use a composition value constructor in this context. Composition value constructors can only be used when referring to composition types in an expression.",
				MuLEPackage.Literals.SYMBOL_REF_COMPOSITION_INIT.EIDAttribute)
		}
	}

	@Check
	def checkImportLibrariesOnly(Import _import) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		if (_import.importedNamespace.isIsProgram) {
			error("You can not import programs, only libraries are allowed to be imported.",
				MuLEPackage.Literals.IMPORT__IMPORTED_NAMESPACE)
		}
	}

	@Check
	def checkVisibilityModifiersForOperations(Operation op) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var vMod = op.visibility
		if (vMod !== null) {
			var opContainer = op.eContainer
			if (opContainer instanceof CompilationUnit) {
				if (opContainer.isProgram) {
					error(ERROR_MESSAGE__VISIBLITY_NOT_ALLOWED, MuLEPackage.Literals.OPERATION__VISIBILITY,
						ERROR_ILLEGAL_VISIBILITY)
				} else {
					if (vMod.equals("protected")) {
						error(ERROR_MESSAGE__PROTECTED_NOT_ALLOWED, MuLEPackage.Literals.OPERATION__VISIBILITY,
							ERROR_ILLEGAL_VISIBILITY)
					}
				}
			}
		}
	}

	@Check
	def checkVisibilityModifiersForCompositions(Composition op) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var vMod = op.visibility
		if (vMod !== null) {
			var opContainer = op.eContainer
			if (opContainer instanceof CompilationUnit) {
				if (opContainer.isProgram) {
					error(ERROR_MESSAGE__VISIBLITY_NOT_ALLOWED, MuLEPackage.Literals.COMPOSITION__VISIBILITY,
						ERROR_ILLEGAL_VISIBILITY)
				} else {
					if (vMod.equals("protected")) {
						error(ERROR_MESSAGE__PROTECTED_NOT_ALLOWED, MuLEPackage.Literals.COMPOSITION__VISIBILITY,
							ERROR_ILLEGAL_VISIBILITY)
					}
				}
			}
		}
	}

	@Check
	def checkVisibilityModifiersForEnumerations(Enumeration op) {
		// /*DEBUG*/println(new Object(){}.getClass().getEnclosingMethod().getName())
		var vMod = op.visibility
		if (vMod !== null) {
			var opContainer = op.eContainer
			if (opContainer instanceof CompilationUnit) {
				if (opContainer.isProgram) {
					error(ERROR_MESSAGE__VISIBLITY_NOT_ALLOWED, MuLEPackage.Literals.ENUMERATION__VISIBILITY)
				} else {
					if (vMod.equals("protected")) {
						error(ERROR_MESSAGE__PROTECTED_NOT_ALLOWED, MuLEPackage.Literals.ENUMERATION__VISIBILITY,
							ERROR_ILLEGAL_VISIBILITY)
					}
				}
			}
		}
	}

}