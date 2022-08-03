/*
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.mule.formatting2

import com.google.inject.Inject
import de.ubt.ai1.mule.muLE.AdditiveExpression
import de.ubt.ai1.mule.muLE.AndExpression
import de.ubt.ai1.mule.muLE.AssignmentOrOperationCall
import de.ubt.ai1.mule.muLE.Block
import de.ubt.ai1.mule.muLE.ComparisonExpression
import de.ubt.ai1.mule.muLE.CompilationUnit
import de.ubt.ai1.mule.muLE.Composition
import de.ubt.ai1.mule.muLE.DataType
import de.ubt.ai1.mule.muLE.Dereference
import de.ubt.ai1.mule.muLE.Enumeration
import de.ubt.ai1.mule.muLE.EqualityExpression
import de.ubt.ai1.mule.muLE.ExitStatement
import de.ubt.ai1.mule.muLE.ExponentExpression
import de.ubt.ai1.mule.muLE.Expression
import de.ubt.ai1.mule.muLE.IfStatement
import de.ubt.ai1.mule.muLE.Import
import de.ubt.ai1.mule.muLE.LambdaExpression
import de.ubt.ai1.mule.muLE.LetStatement
import de.ubt.ai1.mule.muLE.ListAccess
import de.ubt.ai1.mule.muLE.ListInit
import de.ubt.ai1.mule.muLE.ListInitElements
import de.ubt.ai1.mule.muLE.ListInitFunction
import de.ubt.ai1.mule.muLE.ListType
import de.ubt.ai1.mule.muLE.LoopStatement
import de.ubt.ai1.mule.muLE.MainProcedure
import de.ubt.ai1.mule.muLE.MultiplicativeExpression
import de.ubt.ai1.mule.muLE.Operation
import de.ubt.ai1.mule.muLE.OperationInvocation
import de.ubt.ai1.mule.muLE.OrExpression
import de.ubt.ai1.mule.muLE.Parameter
import de.ubt.ai1.mule.muLE.ParenthesizedExpression
import de.ubt.ai1.mule.muLE.Reference
import de.ubt.ai1.mule.muLE.ReferenceType
import de.ubt.ai1.mule.muLE.ReturnStatement
import de.ubt.ai1.mule.muLE.Statement
import de.ubt.ai1.mule.muLE.SuperExpression
import de.ubt.ai1.mule.muLE.SymbolReference
import de.ubt.ai1.mule.muLE.TypeDeclaration
import de.ubt.ai1.mule.muLE.VariableDeclaration
import de.ubt.ai1.mule.services.MuLEGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.resource.XtextResource

class MuLEFormatter extends AbstractFormatter2 {

	@Inject extension MuLEGrammarAccess

	override protected void _format(XtextResource resource, IFormattableDocument document) {
		if (resource.errors.size > 0)
			return
		else
			super._format(resource, document)
	}

	def dispatch void format(CompilationUnit program, extension IFormattableDocument document) {
		append(prepend(regionFor(program).keyword('library'), [noSpace]), [oneSpace])
		append(prepend(regionFor(program).keyword('program'), [noSpace]), [oneSpace])
		for (importStatement : program.imports) {
			prepend(importStatement, [newLine])
			format(importStatement, document)
		}
		for (programElement : program.programElements) {
			format(programElement, document)
			prepend(programElement, [newLines = 2])
		}
		prepend(program.main, [newLines = 2])
		append(program.main, [newLines = 3])
		format(program.main, document)
	}

	def dispatch void format(Import importStatement, extension IFormattableDocument document) {
		importStatement.regionFor.keyword(importAccess.importKeyword_0).append[oneSpace]
	}

	def dispatch void format(MainProcedure mp, extension IFormattableDocument document) {
		interior(
			mp.regionFor.keyword('main'),
			mp.regionFor.keyword('endmain').prepend[newLine]
		)[indent]

		for (statement : mp.block.statements) {
			statement.format(document)
		}
	}

	def dispatch void format(Operation op, extension IFormattableDocument document) {
		interior(
			op.regionFor.keyword('operation'),
			op.regionFor.keyword('endoperation').prepend[newLine]
		)[indent]
		if (op.abstract) {
			op.prepend[newLine];
		} else {
			op.prepend[newLines = 2];
		}
		op.regionFor.keyword('abstract')?.append[oneSpace]
		op.regionFor.keyword('private')?.append[oneSpace]
		op.regionFor.keyword('protected')?.append[oneSpace]
		op.regionFor.keyword('(').surround[noSpace]
		op.regionFor.keyword(')').prepend[noSpace]
		op.regionFor.keyword('operation').append[oneSpace]
		op.regionFor.keyword(':')?.surround[oneSpace]
		op.regionFor.keyword(',')?.append[oneSpace].prepend[noSpace]
		for (Parameter p : op.params) {
			p.regionFor.keyword('parameter').append[oneSpace]
			p.regionFor.keyword(':').surround[oneSpace]
		}
		if (op.block !== null)
			for (statement : op.block.statements) {
				statement.format(document)
			}
		if (op.type !== null)
			op.type.format(document)
	}

	def dispatch void format(TypeDeclaration typeDec, extension IFormattableDocument document) {
		typeDec.regionFor.keyword('type').append[oneSpace]
		typeDec.regionFor.keyword(':').prepend[oneSpace]
		if (typeDec instanceof Enumeration) {
			interior(
				typeDec.regionFor.keyword('enumeration').prepend[oneSpace].append[newLine],
				typeDec.regionFor.keyword('endtype').prepend[newLine]
			)[indent]
			typeDec.values.forEach[prepend[oneSpace].append[noSpace]]
		}
		if (typeDec instanceof Composition) {
			interior(
				typeDec.regionFor.keyword('composition').prepend[oneSpace],
				typeDec.regionFor.keyword('endtype').prepend[newLine]
			)[indent]
			typeDec.regionFor.keyword('abstract')?.surround[oneSpace]
			typeDec.regionFor.keyword('composition')?.surround[oneSpace]
			typeDec.regionFor.keyword('extends')?.surround[oneSpace]
			typeDec.regionFor.keyword('implements')?.surround[oneSpace]
			typeDec.regionFor.keyword('<')?.surround[noSpace]
			typeDec.regionFor.keyword('>')?.prepend[noSpace]
			typeDec.regionFor.keyword(',')?.surround[noSpace]
			typeDec.attributes.forEach [
				prepend[newLine]
				regionFor.keyword('private')?.append[oneSpace]
				regionFor.keyword('protected')?.append[oneSpace]
				regionFor.keyword('attribute')?.append[oneSpace]
				regionFor.keyword(':')?.surround[oneSpace]
				type.format(document)
			]
			typeDec.operations.forEach [
				format()
			]
		}
		typeDec.regionFor.keyword('endtype').prepend[oneSpace]
	}

	def dispatch void format(DataType type, extension IFormattableDocument document) {
		type.regionFor.keyword('<').surround[noSpace]
		type.regionFor.keyword('>').surround[noSpace]
		type.regionFor.keyword('(').surround[noSpace]
		type.regionFor.keyword(')').surround[noSpace]
		type.regionFor.keyword(':').surround[oneSpace]
		type.regionFor.keyword(',').prepend[noSpace].append[oneSpace]
		if (type instanceof ReferenceType) {
			type.type.format(document)
		}
		if (type instanceof ListType) {
			type.type.format(document)
		}
	}

	def dispatch void format(Statement statement, extension IFormattableDocument document) {
		var container = statement.eContainer as Block
		if (statement instanceof VariableDeclaration) {
			statement.prepend[newLine]
			statement.regionFor.keyword('variable').append[oneSpace]
			statement.regionFor.keyword(':').surround[oneSpace]
			statement.type.format(document)
		}
		if (statement instanceof IfStatement) {
			if (container.statements.indexOf(statement) === 0) {
				statement.prepend[newLine]
			} else {
				statement.prepend[newLines = 2]
			}
			interior(
				statement.regionFor.keyword('then').prepend[oneSpace].append[newLine],
				statement.regionFor.keyword('else').prepend[newLine]
			)[indent]
			interior(
				statement.regionFor.keyword('else').append[newLine],
				statement.regionFor.keyword('endif').prepend[newLine]
			)[indent]
			interior(
				statement.regionFor.keyword('then').prepend[oneSpace].append[newLine],
				statement.regionFor.keyword('elseif').prepend[newLine]
			)[indent]
			if (statement.elseBlock === null) {
				interior(
					statement.regionFor.keyword('then').prepend[oneSpace].append[newLine],
					statement.regionFor.keyword('endif').prepend[newLine]
				)[indent]
			}
			statement.expression.surround[oneSpace]
			statement.expression.format(document)
			statement.regionFor.keyword('then').surround[oneSpace]
			statement.regionFor.keyword('else').surround[oneSpace]
			var stmts = statement.block.statements
			for (elif : statement.elseIfs) {
				stmts.addAll(elif.block.statements)
			}
			if (statement.elseBlock !== null) {
				stmts.addAll(statement.elseBlock.statements)
			}

			for (s : stmts) {
				s.format(document)
			}
		}
		if (statement instanceof LoopStatement) {
			if (container.statements.indexOf(statement) === 0) {
				statement.prepend[newLine]
			} else {
				statement.prepend[newLines = 2]
			}
			interior(
				statement.regionFor.keyword('loop'),
				statement.regionFor.keyword('endloop').prepend[newLine]
			)[indent]
			for (s : statement.block.statements) {
				s.format(document)
			}
		}
		if (statement instanceof LetStatement) {
			if (container.statements.indexOf(statement) === 0) {
				statement.prepend[newLine]
			} else {
				statement.prepend[newLines = 2]
			}
			interior(
				statement.regionFor.keyword('do').prepend[oneSpace],
				statement.regionFor.keyword('endlet').prepend[newLine]
			)[indent]
			statement.variable.surround[oneSpace]
			statement.variable.format(document)
			statement.regionFor.keyword('be').surround[oneSpace]
			statement.regionFor.keyword('do').surround[oneSpace]
			statement.expression.format(document)
			for (s : statement.block.statements) {
				s.format(document)
			}
		}
		if (statement instanceof ReturnStatement) {
			statement.prepend[newLine]
			statement.regionFor.keyword('return').append[oneSpace]
			statement.expression.format(document)
		}
		if (statement instanceof ExitStatement) {
			statement.prepend[newLine]
		}
		if (statement instanceof AssignmentOrOperationCall) {
			statement.prepend[newLine]
			statement.regionFor.keyword(':=').surround[oneSpace]
			statement.left.format(document)
			statement.right.format(document)
		}
	}

	def dispatch void format(Expression expression, extension IFormattableDocument document) {
		expression.regionFor.keyword(',')?.append[oneSpace].prepend[noSpace]
		if (expression instanceof OrExpression) {
			expression.left.format(document)
			expression.right.format(document)
			expression.regionFor.keyword('or').surround[oneSpace]
		}
		if (expression instanceof AndExpression) {
			expression.left.format(document)
			expression.right.format(document)
			expression.regionFor.keyword('and').surround[oneSpace]
		}
		if (expression instanceof EqualityExpression) {
			expression.left.format(document)
			expression.right.format(document)
			expression.regionFor.keyword('=').surround[oneSpace]
			expression.regionFor.keyword('/=').surround[oneSpace]
		}
		if (expression instanceof ComparisonExpression) {
			expression.left.format(document)
			expression.right.format(document)
			expression.regionFor.keyword('<').surround[oneSpace]
			expression.regionFor.keyword('<=').surround[oneSpace]
			expression.regionFor.keyword('>').surround[oneSpace]
			expression.regionFor.keyword('>=').surround[oneSpace]
		}
		if (expression instanceof AdditiveExpression) {
			expression.left.format(document)
			expression.right.format(document)
			expression.regionFor.keyword('+').surround[oneSpace]
			expression.regionFor.keyword('-').surround[oneSpace]
			expression.regionFor.keyword('&').surround[oneSpace]
		}
		if (expression instanceof MultiplicativeExpression) {
			expression.left.format(document)
			expression.right.format(document)
			expression.regionFor.keyword('*').surround[oneSpace]
			expression.regionFor.keyword('/').surround[oneSpace]
			expression.regionFor.keyword('mod').surround[oneSpace]
		}
		if (expression instanceof ExponentExpression) {
			expression.left.format(document)
			expression.right.format(document)
			expression.regionFor.keyword('exp').surround[oneSpace]
		}
		if (expression instanceof ParenthesizedExpression) {
			expression.regionFor.keyword('(').append[noSpace]
			expression.regionFor.keyword(')').prepend[noSpace]
			expression.expression.format(document)
		}
		if (expression instanceof SymbolReference) {
			if (expression.eContainer instanceof Block) {
				expression.prepend[newLine]
			}
			expression.regionFor.keyword('.').surround[noSpace]
			var accessMod = expression.accessModifier
			while (accessMod !== null) {
				if (accessMod instanceof OperationInvocation) {
					accessMod.regionFor.keyword(',').prepend[noSpace].append[oneSpace]
					accessMod.regionFor.keyword('(').surround[noSpace]
					accessMod.regionFor.keyword(')').prepend[noSpace]
					for (p : accessMod.params) {
						p.format(document)
					}
				}
				if (accessMod instanceof ListAccess) {
					accessMod.regionFor.keyword('[').surround[noSpace]
					accessMod.regionFor.keyword(']').prepend[noSpace]
					accessMod.index.format(document)
				}
				if (accessMod instanceof Dereference) {
					accessMod.regionFor.keyword('@').prepend[noSpace]
				}
				accessMod = accessMod.accessModifier
			}
			if (expression.compositionInit !== null) {
				expression.compositionInit.regionFor.keyword('{').surround[noSpace]
				expression.compositionInit.regionFor.keyword('}').prepend[noSpace]
				expression.compositionInit.regionFor.keyword(',').prepend[noSpace].append[oneSpace]
				expression.compositionInit.regionFor.keyword('=').surround[oneSpace]
			}
			expression.memberCall.format(document)
		}
		if (expression instanceof SuperExpression) {
			expression.regionFor.keyword('.').surround[noSpace]
			expression.memberCall.format(document)
		}
		if (expression instanceof ListInit) {
			expression.regionFor.keyword('[').append[noSpace]
			expression.regionFor.keyword(']').prepend[noSpace]
			expression.left.format(document)
			if (expression.right instanceof ListInitFunction) {
				(expression.right as ListInitFunction).regionFor.keyword('**').surround[oneSpace]
				(expression.right as ListInitFunction).regionFor.keyword('..').surround[oneSpace]
				(expression.right as ListInitFunction).expression.format(document)
			}
			if (expression.right instanceof ListInitElements) {
				(expression.right as ListInitElements).regionFor.keyword(',')?.append[oneSpace].prepend[noSpace]
				(expression.right as ListInitElements).elements.forEach[format(document)]
			}
		}
		if (expression instanceof Reference) {
			expression.regionFor.keyword('reference').append[oneSpace]
			expression.expression.format(document)
		}
		if (expression instanceof LambdaExpression) {
			interior(
				expression.regionFor.keyword('operation'),
				expression.regionFor.keyword('endoperation').prepend[newLine]
			)[indent]
			expression.regionFor.keyword('operation').append[noSpace]
			expression.regionFor.keyword('(').surround[noSpace]
			expression.regionFor.keyword(',').prepend[noSpace].append[oneSpace]
			expression.regionFor.keyword(')').prepend[noSpace]
			expression.regionFor.keyword(':').surround[oneSpace]
			for (p : expression.parameters) {
				p.regionFor.keyword('parameter').append[oneSpace]
				p.regionFor.keyword(':').surround[oneSpace]
			}
			if (expression.block.statements !== null) {
				for (statement : expression.block.statements) {
					statement.format(document)
				}
			}
		}
	}
}
