/*
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.mule.ui.contentassist

import com.google.inject.Inject
import de.ubt.ai1.mule.muLE.Attribute
import de.ubt.ai1.mule.muLE.CompilationUnit
import de.ubt.ai1.mule.muLE.Composition
import de.ubt.ai1.mule.muLE.Enumeration
import de.ubt.ai1.mule.muLE.MuLEPackage
import de.ubt.ai1.mule.muLE.NamedElement
import de.ubt.ai1.mule.muLE.Operation
import de.ubt.ai1.mule.muLE.Parameter
import de.ubt.ai1.mule.muLE.SymbolReference
import de.ubt.ai1.mule.muLE.VariableDeclaration
import de.ubt.ai1.mule.scoping.MuLEScopeProvider
import de.ubt.ai1.mule.typing.MuLETypeProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
class MuLEProposalProvider extends AbstractMuLEProposalProvider {

	@Inject MuLEScopeProvider scopeProvider
	@Inject extension MuLETypeProvider

	override void completeSymbolReference_Symbol(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		var visibleElements = scopeProvider.getVisibleSymbols(model, model)
		if (model instanceof SymbolReference && (model as SymbolReference).memberCall !== null) {
			visibleElements  = scopeProvider.getVisibleSymbols(model,  MuLEPackage::eINSTANCE.symbolReference_Symbol)
		}
		for (objectDescription : visibleElements.allElements) {
			var actualObject = objectDescription.EObjectOrProxy
			if (actualObject instanceof NamedElement)
				createProposalForNamedElement(actualObject, acceptor, context)
		}
	}

	override void completeVariableDeclaration_Type(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.completeVariableDeclaration_Type(model, assignment, context, acceptor)
	}

	def private createProposalForNamedElement(NamedElement elem, ICompletionProposalAcceptor acceptor,
		ContentAssistContext context) {
		var name = elem.name
		var label = name
		var proposal = name
		if (elem instanceof Operation) {
			label = "operation " + label
			label += "("
			proposal += "("
			for (param : elem.params) {
				if (elem.params.indexOf(param) != 0) {
					label += ", "
					proposal += ", "
				}
				var paramType = param.typeFor(null)
				var paramTypeString = paramType.dataTypeToString 
				label += "parameter " + param.name + " : " + paramTypeString
				proposal +=
					("___" + param.name.toUpperCase + "__" + paramTypeString.toUpperCase + "___").replace(".", "_").
						replace("<", "_").replace(">", "_").replaceAll(" ", "_")
			}
			label += ")"
			proposal += ")"
			if (elem.type !== null) {
				label += " : " + elem.typeFor(null).dataTypeToString
			}
		}
		if (elem instanceof VariableDeclaration) {
			label = "variable " + label + " : " + elem.typeFor(null).dataTypeToString
		}
		if (elem instanceof Attribute) {
			label = "attribute " + label + " : " + elem.typeFor(null).dataTypeToString
		}
		if (elem instanceof Parameter) {
			label = "parameter " + label + " : " + elem.typeFor(null).dataTypeToString
		}
		if (elem instanceof CompilationUnit) {
			label = "library " + label
		}
		if (elem instanceof Composition) {
			label = "type " + label + " : composition"
		}
		if (elem instanceof Enumeration) {
			label = "type " + label + " : enumeration"
		}
		acceptor.accept(createCompletionProposal(proposal, label, null, context))
	} 
}
