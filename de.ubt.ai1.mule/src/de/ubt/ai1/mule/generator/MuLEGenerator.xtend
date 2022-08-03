/*
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.mule.generator

import com.google.inject.Inject
import de.ubt.ai1.mule.muLE.AdditiveExpression
import de.ubt.ai1.mule.muLE.AndExpression
import de.ubt.ai1.mule.muLE.AssignmentOrOperationCall
import de.ubt.ai1.mule.muLE.BasicType
import de.ubt.ai1.mule.muLE.Block
import de.ubt.ai1.mule.muLE.BooleanConstant
import de.ubt.ai1.mule.muLE.ComparisonExpression
import de.ubt.ai1.mule.muLE.CompilationUnit
import de.ubt.ai1.mule.muLE.Composition
import de.ubt.ai1.mule.muLE.DataType
import de.ubt.ai1.mule.muLE.DeclaredType
import de.ubt.ai1.mule.muLE.Dereference
import de.ubt.ai1.mule.muLE.Enumeration
import de.ubt.ai1.mule.muLE.EqualityExpression
import de.ubt.ai1.mule.muLE.ExitStatement
import de.ubt.ai1.mule.muLE.ExponentExpression
import de.ubt.ai1.mule.muLE.Expression
import de.ubt.ai1.mule.muLE.Feature
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
import de.ubt.ai1.mule.muLE.MuLEFactory
import de.ubt.ai1.mule.muLE.MultiplicativeExpression
import de.ubt.ai1.mule.muLE.NamedElement
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
import de.ubt.ai1.mule.muLE.SymbolReference
import de.ubt.ai1.mule.muLE.TypeDeclaration
import de.ubt.ai1.mule.muLE.TypeParameter
import de.ubt.ai1.mule.muLE.Unary
import de.ubt.ai1.mule.muLE.VariableDeclaration
import de.ubt.ai1.mule.typing.MuLETypeProvider
import mule.util.Util
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode
import org.eclipse.xtext.generator.trace.node.NewLineNode
import org.eclipse.xtext.generator.trace.node.TextNode
import org.eclipse.xtext.generator.trace.node.Traced
import org.eclipse.xtext.generator.trace.node.TracedAccessors

import static extension com.google.common.io.Files.*

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MuLEGenerator extends AbstractGenerator {

	@TracedAccessors(MuLEFactory)
	static class MuLETraceExtensions {}

	@Inject extension MuLETraceExtensions
	@Inject extension MuLETypeProvider

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val program = resource.contents.head as CompilationUnit
		if (program !== null) {
			val programName = resource.URI.lastSegment.nameWithoutExtension
			generateTracedFile(fsa, "generated/" + programName + ".java", program, '''
				package generated;
				
				import mule.util.*;
				import java.io.Serializable;
				import java.util.ArrayList;
				import java.util.Arrays;
				import java.util.function.*;
				�FOR i : program.imports�
					�var n = i.importedNamespace.name�
					�IF #["IO", "Mathematics", "Strings", "Lists", "Threads"].contains(n)�
						import mule.lang.�n�;
					�ELSEIF n.equals("Turtle")�
						import mule.turtle.Turtle;
						import mule.turtle.Turtle.Speed;
						import mule.turtle.Turtle.Orientation;
						import mule.turtle.Turtle.Colors;
					�ELSEIF n.equals("GUIFactory")�
						import mule.guifactory.GUIFactory;
					�ELSEIF n.equals("GUIFactoryTasks")�
						import mule.guifactory.GUIFactoryTasks;
					�ELSEIF n.equals("GUIFactoryBorders")�
						import mule.guifactory.GUIFactoryBorders;
					�ELSEIF n.equals("GUIFactoryComponents")�
						import mule.guifactory.GUIFactoryComponents;
					�ELSEIF n.equals("GUIFactoryPanes")�
						import mule.guifactory.GUIFactoryPanes;
					�ELSEIF n.equals("UBTMicroworld")�
						import mule.ubtmicroworld.UBTMicroworld;
						import mule.ubtmicroworld.UBTMicroworld.*;
					�ELSE�
						import generated.�n�.*;
					�ENDIF�
				�ENDFOR�
					
					/*
					* Generated Java file, do not modify it!!!
					*/
					
					@SuppressWarnings("all")
					public class �programName� {
					
					�FOR element : program.programElements�
						�IF element instanceof TypeDeclaration�
							�generateTypeDeclaration(element)�
						�ELSEIF element instanceof Operation�
							public static �generateOperation(element)�
						�ENDIF�
					�ENDFOR�
					
					�IF program.main !== null�
						public static void main(String[] args){
							�FOR s : program.main.block.statements�
								�s.generateStatement�
							�ENDFOR�
						}
					�ENDIF�
					}
			''')
		}
	}

	@Traced def private generateTypeDeclaration(TypeDeclaration typeDec) {
		'''
			�IF typeDec instanceof Composition�
				�typeDec.generateComposition�
				
			�ENDIF�
			�IF typeDec instanceof Enumeration�
				�typeDec.generateEnumeration�
				
			�ENDIF�
		'''
	}

	def private generateCompositionSignature(Composition c) {
		val n = c.trace
		n.append("public static ")
		if(c.abstract) n.append("abstract ")
		n.append("class " + c.name)
		if (!c.typeParams.isEmpty) {
			n.append("<")
			c.typeParams.forEach([ e |
				{
					n.append(e.name);
					var complexType = MuLEFactory.eINSTANCE.createDeclaredType
					complexType.type = e.superType
					if(e.superType !== null) n.append(" extends " + complexType.generateType)
					if(!c.typeParams.last.equals(e)) n.append(",");
				}
			])
			n.append("> ")
		}

		if (c.superType !== null) {
			var complexType = MuLEFactory.eINSTANCE.createDeclaredType
			complexType.type = c.superType
			n.append(" extends " + complexType.generateType)
			if (!c.superTypeParams.isEmpty) {
				n.append("<")
				c.superTypeParams.forEach([ e |
					{
						n.append(e.name);
						if(!c.superTypeParams.last.equals(e)) n.append(",");
					}
				])
				n.append("> ")
			}
		}
		n.append(" implements Serializable")
		return n;
	}

	@Traced def private generateComposition(Composition c) {
		'''
			�c.generateCompositionSignature�{
				�FOR typeDec : c.typeDeclarations�
					�typeDec.generateTypeDeclaration�
				�ENDFOR�
				�FOR attr : c.attributes�  
					public �attr.type.generateType� �attr.name� �attr.type.generateInitialValueForType�;
				�ENDFOR�
				
				�IF !Util.getListOfPublicAttributesInInheritanceRelation(c).empty�
					public �c.name� (){}
					public �c.name� (�c.generateConstructorHelper�) {
						�FOR attr : Util.getListOfPublicAttributesInInheritanceRelation(c)�
							this.�attr.name� = �attr.name�;
						�ENDFOR�
					}
				�ENDIF�
				
				�FOR m : c.operations�
					public �m.generateOperation�
				�ENDFOR�				
			
				public String toString(){
					String res = "�c.name�{";
					�c.generateToStringHelper�
					�FOR f : c.attributes�
						�IF f.type instanceof ReferenceType�
							if (�f.name� == null) res += "�f.name� = " + null;
							else res += "�f.name� = " + �f.name�.toString(); 
						�ELSE�
							res += "�f.name� = "+�f.name�;
						�ENDIF�
						�IF !c.attributes.get(c.attributes.size-1).equals(f)�
							res += ", ";
						�ENDIF�
					�ENDFOR�
					res += "}";
					return res;
				}
				
				public boolean equals(Object o){
					if(!(o instanceof �c.name�)) return false;
					�c.generateEqualsHelper�
					�FOR f : c.attributes�
						if(!(this.�f.name�.equals(((�c.name�)o).�f.name�))) return false;
					�ENDFOR�
					return true;
				}
			}
		'''
	}

	def private generateConstructorHelper(Composition c) {
		var result = ""
		var listOfAttrs = Util.getListOfPublicAttributesInInheritanceRelation(c)
		var listOfAttrStrings = newArrayList
		for (attr : listOfAttrs) {
			var attrType = attr.type.generateType
			if (attrType.startsWith("MuLEReferenceType"))
				attrType = "MuLEReferenceType"
			var str = attrType + " " + attr.name
			if (!listOfAttrStrings.contains(str))
				listOfAttrStrings.add(str)
		}
		for (str : listOfAttrStrings)	{
			result += str
			if (listOfAttrStrings.last !== str)
				result += ", "
		}
		return result
	}

	def private generateEqualsHelper(Composition c) {   
		var result = ""
		var superType = c.superType
		while (superType !== null) {
			var attrStr = ""
			for (attr : superType.attributes) {
				if (attr.visibility === null || attr.visibility.equals("protected")) {
					attrStr += "if(!(this." + attr.name + ".equals(((" + c.name + ")o)." + attr.name + "))) return false;\n"
				}
			}
			result = attrStr + result
			superType = superType.superType
		}
		return result
	}

	def private generateToStringHelper(Composition c) { 
		var result = ""
		var superType = c.superType
		while (superType !== null) {
			var attrStr = ""
			for (attr : superType.attributes) {
				if (attr.visibility === null || attr.visibility.equals("protected")) {
					attrStr += "res += \"" + attr.name + " = \"+" + attr.name + ";\n"
					if (superType.attributes.get(superType.attributes.size - 1).equals(attr) && c.attributes.empty) {
						// no comma if its the last attribute of the super type and the sub type has no attributes
					} else {
						attrStr += "res += \", \";\n"						
					}
				}
			}
			result = attrStr + result
			superType = superType.superType
		}
		return result
	}

	@Traced def private generateEnumeration(Enumeration c) {
		'''
			public static enum �c.name� {
				�FOR value : c.values�
					�value.name��IF !c.values.get(c.values.size-1).equals(value)�, �ENDIF�
				�ENDFOR�
			}
		'''
	}

	/*
	 * Generated parameters are overwritten with a copy of itself to enforce pass-by-value semantics for non basic types
	 */
	@Traced def private generateOperation(Operation op) {
		'''			
			�generateOperationSignature(op)��IF op.abstract�;�ELSE�{	
				�FOR s : op.block.statements�
					�s.generateStatement�
				�ENDFOR�			
			}
			
			�ENDIF�
		'''
	}

	def private generateOperationSignature(Operation op) {
		var n = ""
		if (op.abstract) 		n += "abstract "
		if (op.type === null) 	n += "void"
		else 					n += generateType(op.type)		
		n += " " + op.name + "("
		for (p : op.params) {
			n += generateType(p.type) + " " + p.name
			if (!op.params.get(op.params.size() - 1).equals(p))
				n += ", "
		}
		n += ")"
		return n;
	}

	@Traced(useForDebugging=true) def private generateStatement(Statement s) {
		switch s {
			VariableDeclaration: {				
				'''�generateVariableDeclaration(s)�;'''
			}
			IfStatement: {
				'''�generateIfStatement(s)�'''
			}
			LoopStatement: {
				'''�generateLoopStatement(s)�'''
			}
			ReturnStatement: {
				'''�generateReturnStatement(s)�'''
			}
			ExitStatement: {
				'''break;'''
			}
			AssignmentOrOperationCall: {
				'''�generateAssignment(s)�;'''
			}
			LetStatement: {
				'''
					�generateLetStatement(s)�
				'''
			}
		}
	}

	def private String generateVariableDeclaration(VariableDeclaration varDec) {
		var type = varDec.type
		var staticType = generateType(type)
		var result = staticType + " " + varDec.name + " " + generateInitialValueForType(varDec.type)
		return result
	}

	def private String generateReturnStatement(ReturnStatement ret) {
		var result = "return"
		if (ret.expression !== null) {
			var op = ret.eContainer
			while (!(op instanceof Operation) && !(op instanceof LambdaExpression))
				op = op.eContainer
			var expectedType = typeFor(op, null)
			if (expectedType.generateType.equals("Double"))
				result += " (double)"
			var generatedExpression = ret.expression.generateExpression
			result += " " + generatedExpression
		}
		result += ";"
		return result
	}

	def private String generateInitialValueForType(DataType type) {
		var result = ""
		if (type instanceof ReferenceType) {
			result += " = null"
		} else if (type instanceof DeclaredType && (type as DeclaredType).type instanceof Composition) {
			result += " = new " + type.generateType + "()"
		} else if (type instanceof DeclaredType && (type as DeclaredType).type instanceof Enumeration) {
			var enumType = ((type as DeclaredType).type as Enumeration)
			var compilationUnit = enumType.eContainer as CompilationUnit
			result += " = " + compilationUnit.name + "." + enumType.name + "." + enumType.values.get(0).name
		} else if (type instanceof ListType) {
			result += " = new ArrayList<>()"
		} else if (type instanceof BasicType) {
			var defaultValue = ""
			switch (type as BasicType).typeName {
				case "integer": defaultValue = "0"
				case "rational": defaultValue = "0.0"
				case "boolean": defaultValue = "false"
				case "string": defaultValue = "\"\""
			}
			result += " = new " + type.generateType + "(" + defaultValue + ")"
		} else if (type instanceof OperationType) {
			result = ""		
			if (type.paramTypes.empty)	{
				result += "()" + " -> "
			} else {			
				var iteration = "_"	
				var typeContainer = type.eContainer
				while (typeContainer instanceof OperationType) {
					iteration += "_"
					typeContainer = typeContainer.eContainer
				}
				for (DataType p : type.paramTypes) {
					result += iteration + "param_" + type.paramTypes.indexOf(p) + " -> "
				}
			}
			result += "{\n"
			if (type.type === null)	{
				result += "\treturn null;\n"	
			} else {
				result += "\treturn " + type.type.generateInitialValueForType.replaceFirst("=", "") + ";\n"
			}
			result += "}"
			return " = " + result
		}
		return result
	}

	@Traced def private String generateLoopStatement(LoopStatement l) {
		'''
			while(true){
				�FOR s : l.block.statements�
					�generateStatement(s)�
				�ENDFOR�
			}
		'''
	}

	@Traced def private String generateIfStatement(IfStatement c) {
		'''
			if(�generateExpression(c.expression)�){
				�FOR s : c.block.statements�
					�generateStatement(s)�
				�ENDFOR�
			}
			�FOR elif : c.elseIfs�
				else if (�generateExpression(elif.expression)�) {
					�FOR s : elif.block.statements�
						�generateStatement(s)�
					�ENDFOR�
				}
			�ENDFOR�
			�IF c.elseBlock !== null�
				else {
					�FOR s : c.elseBlock.statements�
						�generateStatement(s)�
					�ENDFOR�
				}
			�ENDIF�
		'''
	}

	@Traced def private String generateLetStatement(LetStatement s) {
		'''
			if (�generateLetStatementHelper(s.variable.type, s.expression.generateExpression)�) {
				�s.variable.type.generateType� �s.variable.name� = (�s.variable.type.generateType�) �s.expression.generateExpression�;
				�FOR stmt : s.block.statements�
					�stmt.generateStatement�
				�ENDFOR�
			}
			�FOR elselet : s.elseLets�
				else if (�generateLetStatementHelper(elselet.variable.type, elselet.expression.generateExpression)�) {
					�elselet.variable.type.generateType� �elselet.variable.name� = (�elselet.variable.type.generateType�) �elselet.expression.generateExpression�;
					�FOR stmt : elselet.block.statements�
						�stmt.generateStatement�
					�ENDFOR�
				}
			�ENDFOR�
			�IF s.elseBlock !== null�
				else {
					�FOR stmt : s.elseBlock.statements�
						�stmt.generateStatement�
					�ENDFOR�
				}
			�ENDIF�
		'''
	}

	def private String generateLetStatementHelper(DataType type, String expr) {
		var result = ""
		if (type instanceof ReferenceType) {
			var addCheck = generateLetStatementHelper(type.type, expr + ".value")
			result = expr + " instanceof MuLEReferenceType<?> && " + addCheck
			return result
		}
		if (type instanceof ListType) {
			var addCheck = generateLetStatementHelper(type.type, expr + ".get(0)")
			result = expr + " instanceof ArrayList<?> && " + addCheck
			return result
		}
		if (type instanceof DeclaredType) {
			var qualifiedName = type.type.name
			var container = type.type.eContainer
			while (container !== null) {
				if (container instanceof NamedElement) {
					qualifiedName = container.name + "." + qualifiedName
				}
				container = container.eContainer
			}
			return expr + " instanceof " + qualifiedName
		}
		if (type instanceof BasicType) {
			var generatedType = type.generateType
			var expr2 = "(new " + generatedType + "(" + "(" + generatedType + ")" + expr + "))"
			switch (type.typeName) {
				case "integer": {
					return expr2 + " instanceof Integer"
				}
				case "rational": {
					return expr2 + " instanceof Double"
				}
				case "boolean": {
					return expr2 + " instanceof Boolean"
				}
				case "String": {
					return expr2 + " instanceof String"
				}
			}
		}
		return result
	}

	def private String generateExpression(Expression e) {
		switch e {
			OrExpression: {
				return generateExpression(e.left) + " || " + generateExpression(e.right)
			}
			AndExpression: {
				return generateExpression(e.left) + " && " + generateExpression(e.right)
			}
			EqualityExpression: {
				var result = ""
				if (e.op.equals("/="))
					result += "!("
				result += "mule.util.Util.MuLEEquals("+ generateExpression(e.left) + ", " + generateExpression(e.right) + ")"
				if (e.op.equals("/="))
					result += ")"
				return result
			}
			ComparisonExpression: {
				return generateExpression(e.left) + e.op + generateExpression(e.right)
			}
			AdditiveExpression: {
				var result = generateExpression(e.left)
				if(e.op.equals("&")) result += " + " else result += " " + e.op + " "
				result += generateExpression(e.right)
				return result
			}
			MultiplicativeExpression: {
				var result = ""
				var left = generateExpression(e.left)
				var right= generateExpression(e.right)
				if(e.op.equals("mod")) 
					result = left + " % " + right
				else if(e.op.equals("div")) 
					result = left + " / " + right
				else if(e.op.equals("/")) 
					result = "(double)" + left + " / (double)" + right
				else if(e.op.equals("*"))
					result = left + " * " + right
				return result
			}
			ExponentExpression: {
				return "Math.pow(" + generateExpression(e.left) + "," + generateExpression(e.right) + ")"
			}
			SymbolReference: {
				return generateSymbolReference(e)
			}
			SuperExpression: {
				return generateSuperExpression(e)
			}
			Unary: {
				return e.op.replace("not", "!") + " " + generateExpression((e as Unary).expression)
			}
			ParenthesizedExpression: {
				return "(" + generateExpression(e.expression) + ")"
			}
			IntegerConstant: {
				return e.value
			}
			RationalConstant:
				return e.value
			StringConstant:
				return "\"" + generateStringConstant(e) + "\""
			BooleanConstant:
				return e.value
			Null:
				return "null"
			LambdaExpression: {
				var result = ""		
				if (e.parameters.empty)	result += "()" + " -> "
				for (Parameter p : e.parameters) 
					result += p.name + " -> "
				result += "{\n"
					for (Statement s : e.block.statements) {
						result += traceNodeToString(generateStatement(s) 
									as CompositeGeneratorNode) + "\n"
					}
					if (e.type === null) result += "\treturn null;\n"
					result += "}"
				return result
			}
			ListInit:
				return generateListInit(e)
			Reference: {
				return "new MuLEReferenceType(mule.util.Util.copyObject(" + generateExpression(e.expression) + ", \"" + copyObjectHelper(typeFor(e.expression, null), e) + "\"))"
			}
		}
	}

	def private String generateSuperExpression(SuperExpression e) {
		var result = "super"
		if (e.memberCall !== null)
			result += "." + e.memberCall.generateSymbolReference
		return result
	}

	def private String traceNodeToString(CompositeGeneratorNode node) {
		var result = ""
		for (Object o : node.children) {
			if (o instanceof TextNode)
				result += "\t" + o.text
			else if (o instanceof NewLineNode)
				result += "\n"
			else if (o instanceof CompositeGeneratorNode)
				result += o.traceNodeToString
		}
		return result
	}

	def private String generateStringConstant(StringConstant constant) {
		var result = constant.value
		result = result.replace("\\", "\\\\")
		result = result.replaceAll("(\r\n|\n)", "\\\\n")
		result = result.replaceAll("\\r", "\\\\r")
		result = result.replaceAll("\\t", "\\\\t")
		result = result.replaceAll("\\f", "\\\\f")
		result = result.replaceAll("\\\"", "\\\\\"")
		result = result.replaceAll("\\\'", "\\\\\'")
		return result
	}

	def private String generateSymbolReference(SymbolReference call) {
		var result = ""
		var currentMember = call
		while (currentMember !== null) {
			var cs = currentMember.symbol
			if (currentMember !== call) {
				// not the initial call --> member Access --> generate .
				result += "."
			}
			// case 1: composition init 
			if (cs instanceof Composition) {
				if (currentMember.compositionInit !== null) {					
					result = "new " + cs.name + "("
					if (currentMember.compositionInit !== null) {
						for (attr : currentMember.compositionInit.attributes) { 
							if (attr.attribute.type.generateType.equals("Double") &&
								typeFor(attr.expression, null).generateType.equals("Integer")) {
								result += "new Double(" + attr.expression.generateExpression + ")"
							} else {
								result += attr.expression.generateExpression
							}
							if (currentMember.compositionInit.attributes.last !== attr) {
								result += ", "
							}
						}
					}
					result += ")"
				}
				return result
			}
			// case 2: passing operation as data, i.e. generate a lambda expression based on the operation object
			else if (call.accessModifier === null && call.symbol instanceof Operation) {
				result = ""
				var op = call.symbol as Operation
				if (op.params.empty)	{
					result += "()" + " -> "
				}
				for (Parameter p : op.params) {
					result += p.name + " -> "
				}
				result += "{\n"
				for (Statement s : op.block.statements) {
					var stmt = s.generateStatement as CompositeGeneratorNode
					result += stmt.traceNodeToString + "\n"
				}
				if (op.type === null)	
					result += "\treturn null;\n"
				result += "}"
				return result
			}
			// case 3: neither of the above
			else {
				result += cs.name
				var accessModifier = currentMember.accessModifier
				while (accessModifier !== null) {			
					if(accessModifier instanceof OperationInvocation){
						var container = accessModifier.eContainer
						if (container instanceof SymbolReference) {
							var fcSymbol = container.symbol
							if (fcSymbol instanceof Operation) {
								// we invoke an operation
								result += "("
								for (param : accessModifier.params) {
									result += generateParameterExpressionHelper(param, accessModifier, currentMember)
									if (accessModifier.params.indexOf(param) != accessModifier.params.size - 1)
										result += ", "
								}
								result += ")"
							} else if (fcSymbol instanceof Feature) {
								// we apply a lambda expression
								var type = fcSymbol.type
								if (type instanceof OperationType) {									
									for (param : accessModifier.params) {
										result +=  ".apply("								
										result += generateParameterExpressionHelper(param, accessModifier, currentMember)
										result += ")"
									}	
									if (type.paramTypes.empty) {
										result +=  ".get()"
									}
								}
							} 
						} else if (container instanceof OperationInvocation) {
							var type = typeFor(container, null)
							if (type instanceof OperationType) {									
								for (param : accessModifier.params) {
									result +=  ".apply("
										result += generateParameterExpressionHelper(param, accessModifier, currentMember)
									result += ")"
								}	
								if (type.paramTypes.empty) {
									result +=  ".get()"
								}
							}
						}				
					} else if (accessModifier instanceof ListAccess) {
						result += ".get(" + accessModifier.index.generateExpression + ")"
					} else if (accessModifier instanceof Dereference) {
						result += ".value"
					}
					accessModifier = accessModifier.accessModifier
				}			
			}
			
			/*
			 * Check if we can cast the expession to a type
			 */			
			var type = typeFor2(currentMember)
			try {				
				type = resolveTypeParameter(type, call, currentMember, call.eContainer)
			} catch (Exception e){}
			var isAssignee = false
			var isProcedureCall = false
			var isSuperCall = false
			
			var cont = currentMember.eContainer
			if (currentMember.memberCall === null) {
				while (cont instanceof SymbolReference || cont instanceof AssignmentOrOperationCall) {
					if (cont instanceof AssignmentOrOperationCall) {
						if (cont.left === call) {
							isAssignee = true
						}
					}
					if (cont instanceof SuperExpression)
						isSuperCall = true
					cont = cont.eContainer
				}
			}
			
			if (cont instanceof Block && cs instanceof Operation || cs instanceof Feature && (cs as Feature).type instanceof OperationType)
				isProcedureCall = true
				
			
			var validForCasting = true
			if (isAssignee || isProcedureCall || isSuperCall)
				validForCasting = false
				
			if (validForCasting) {
				if (type !== null) {
					var generatedType = type.generateType
					if (generatedType !== null && !generatedType.contains("?")) {
						result = "((" + generatedType + ")"+ result + ")"
					}
				}
			}
			currentMember = currentMember.memberCall			
		}
		return result
	}
	
	def private String generateParameterExpressionHelper(Expression param, OperationInvocation accessModifier, SymbolReference call) {
		var result = "mule.util.Util.copyObject("
		var index = accessModifier.params.indexOf(param)
		var expectedType = null as DataType
		if (call.symbol instanceof Operation) {
			if (accessModifier.eContainer instanceof SymbolReference) {
				var temp = (call.symbol as Operation).params.get(index)
				expectedType = typeFor(temp, null)
			} else if (accessModifier.eContainer instanceof OperationInvocation) {
				var tempType = (call.symbol as Feature).type
				var am = call.accessModifier
				while (am !== null && am !== accessModifier.eContainer) {
					if (tempType instanceof OperationType) {
						tempType = tempType.type
					} else if (tempType instanceof ListType) {
						tempType = tempType.type
					} else if (tempType instanceof ReferenceType) {
						tempType = tempType.type
					}
					am = am.accessModifier
				}
				if (tempType instanceof OperationType) {
					expectedType = (tempType as OperationType).paramTypes.get(index) 
				}
			}
		} else if (call.symbol instanceof Feature && (call.symbol as Feature).type instanceof OperationType) {
			if (accessModifier.eContainer instanceof SymbolReference) {
				expectedType = ((call.symbol as Feature).type as OperationType).paramTypes.get(index) 
			} else if (accessModifier.eContainer instanceof OperationInvocation) {
				var temp = accessModifier as EObject
				var counter = 0
				while (!(temp instanceof SymbolReference)) {
					temp = temp.eContainer
					counter--
				}
				if (temp !== null && temp instanceof SymbolReference) {
					var tempType = (call.symbol as Feature).type
					while(counter < -1 && tempType instanceof OperationType) {
						tempType = (tempType as OperationType).type
						counter++
					}
					if (tempType instanceof OperationType) {
						expectedType = (tempType as OperationType).paramTypes.get(index) 
					}
				}
			}
		} else if (call.symbol instanceof Parameter) {
			expectedType = (call.symbol as Parameter).type				
		}
		var shouldBeDouble = expectedType !== null && expectedType.generateType !== null &&	expectedType.generateType.equals("Double")
		if (shouldBeDouble) {
			result += "((double)("
		}
		result += param.generateExpression			
		if (shouldBeDouble) {
			result += "))"
		}
		result += ", \"" + copyObjectHelper(expectedType, param) + "\")"
		return result
	}

	def private String generateAssignment(AssignmentOrOperationCall assignment) {
		var result = ""
		if (assignment instanceof SymbolReference) {
			result = assignment.generateSymbolReference
		} else if (assignment instanceof SuperExpression) {
			result = assignment.generateSuperExpression
		} else {
			val l = assignment.left
			val r = assignment.right
			var rightSideGenerated = r.generateExpression
			val lType = typeFor(l, null)
			var receiver = l
			var leftSideGenerated = ""
			if (l instanceof SuperExpression) {
				leftSideGenerated = l.generateExpression
				if ((l as SuperExpression).memberCall !== null)
					receiver = (l as SuperExpression).memberCall
			} else if (l instanceof SymbolReference) {
				leftSideGenerated = l.generateExpression
			}
			if (receiver instanceof SymbolReference) {
				while (receiver.memberCall !== null) {
					receiver = receiver.memberCall
				}
				var lastAccessModifier = (receiver as SymbolReference).accessModifier
				if (lastAccessModifier !== null)
					while (lastAccessModifier.accessModifier !== null)
						lastAccessModifier = lastAccessModifier.accessModifier
				if (lastAccessModifier instanceof ListAccess) {
					leftSideGenerated = leftSideGenerated.nameWithoutExtension
				}
				result += leftSideGenerated
				if (lastAccessModifier instanceof ListAccess) {
					result += ".set(" + lastAccessModifier.index.generateExpression + ", "
				} else {
					result += " = "
				}
				if (lType !== null && lType.generateType.equals("Double"))
					result += "(double)"
				if (r instanceof LambdaExpression)
					result += rightSideGenerated
				else {
					result += "mule.util.Util.copyObject(" + rightSideGenerated + ", \"" + copyObjectHelper(lType, receiver) +  "\")"
				}
				if (lastAccessModifier instanceof ListAccess) {
					result += ")"
				}
			}
		}
		return result
	}

	def private String generateListInit(Expression expr) {
		var result = ""
		if (expr instanceof ListInit) {
			var right = (expr as ListInit).right
			if (right === null) {
				result = "new ArrayList(Arrays.asList())"
			} else {
				switch right {
					ListInitElements: {
						result = "new ArrayList(Arrays.asList("
						if ((expr as ListInit).left !== null)
							result += (expr as ListInit).left.generateExpression
						for (e : right.elements) {
							result += "," + e.generateListInit
						}
						result += "))"
					}
					ListInitFunction: {
						if (right.op.equals("**")) {
							var rightType = typeFor(right.expression, null)
							result = "mule.util.Util.fillListRepetition(" + (expr as ListInit).left.generateExpression +
								", " + right.expression.generateExpression + ", \"" + copyObjectHelper(rightType, expr) + "\")"
						} else if (right.op.equals("..")) {
							result = "mule.util.Util.fillListRange(" + (expr as ListInit).left.generateExpression +
								"," + right.expression.generateExpression + ")"								
						}
					}
				}
			}
		} else {
			result += expr.generateExpression
		}
		return result
	}
	
	def private String copyObjectHelper(DataType t, EObject context) {		
		if (t instanceof DeclaredType) {
			var typeDec = t.type
			if (typeDec instanceof TypeParameter) {
				return typeDec.name
			}
			var qualifiedName = typeDec.name
			var container = typeDec.eContainer
			if (container === null) {	
				var contextContainer = context
				var found = false
				while (!(contextContainer instanceof CompilationUnit) && !found) {
					if (contextContainer instanceof Composition && (contextContainer as Composition).name == qualifiedName) {
						container = contextContainer
						found = true
					}
					contextContainer = contextContainer.eContainer
				}
				if (!found && contextContainer instanceof CompilationUnit) {
					for (elem : (contextContainer as CompilationUnit).programElements) {
						if (elem instanceof Composition) {
							if (elem.name == qualifiedName) {
								container = elem.eContainer
							}
						}
					}
				}
			}		
			while (container !== null) {
				if (container instanceof NamedElement) {
					qualifiedName = container.name + "$" + qualifiedName
				}
				container = container.eContainer
			}
			return "generated."+qualifiedName
		}
		if (t instanceof ListType) {
			return "ArrayList<" + copyObjectHelper(t.type, context) + ">"
		}
		return t.generateType
	}

	def String generateType(DataType t) {
		if (t instanceof BasicType) {
			switch t.typeName {
				case "integer": return "Integer"
				case "rational": return "Double"
				case "string": return "String"
				case "boolean": return "Boolean"
				default: return "?"
			}
		} else if (t instanceof DeclaredType) {
			var typeDec = t.type
			if (typeDec instanceof TypeParameter) {
				return typeDec.name
			}
			var qualifiedName = typeDec.name
			if (qualifiedName === null)
				return "?"
			var container = typeDec.eContainer
			while (container !== null) {
				if (container instanceof NamedElement) {
					qualifiedName = container.name + "." + qualifiedName
				}
				container = container.eContainer
			}
			return qualifiedName
		} else if (t instanceof ListType) {
			return "ArrayList<" + t.type.generateType + ">"
		} else if (t instanceof ReferenceType) {
			if (t.type instanceof DeclaredType) {
				return "MuLEReferenceType"
			} else {
				return "MuLEReferenceType<" + t.type.generateType + ">"
			}
		} else if (t instanceof OperationType) {
			var result = ""
			var retType = "Object"
			if (t.type !== null)
				retType = t.type.generateType
			if (t.paramTypes.size > 0) {
				for (var i = t.paramTypes.size() - 1; i >= 0; i--) {
					if (i == t.paramTypes.size() - 1)
						result = "Function<" + t.paramTypes.get(i).generateType + "," + retType + ">"
					else
						result = "Function<" + t.paramTypes.get(i).generateType + "," + result + ">"
				}					
			} else {
				result = "Supplier<" + retType + ">"
			}	
			return result
		}
		return "?"
	}
}