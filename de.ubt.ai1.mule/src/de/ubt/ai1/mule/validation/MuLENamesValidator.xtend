package de.ubt.ai1.mule.validation

import com.google.inject.Inject
import de.ubt.ai1.mule.muLE.MuLEPackage
import de.ubt.ai1.mule.muLE.NamedElement
import de.ubt.ai1.mule.scoping.MuLEScopeProvider
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.resource.IEObjectDescription
import de.ubt.ai1.mule.muLE.CompilationUnit
import de.ubt.ai1.mule.muLE.Composition
import de.ubt.ai1.mule.muLE.Parameter
import de.ubt.ai1.mule.muLE.Operation
import org.eclipse.xtext.validation.EValidatorRegistrar

class MuLENamesValidator extends AbstractMuLEValidator {
	@Inject
	MuLEScopeProvider scopeProvider
	
	
		
	override void register(EValidatorRegistrar registrar) {}

	@Check
	def checkDupicateNamesForFeatures(NamedElement nElem) {		
		var reservedNames = newArrayList
		reservedNames.addAll(ReservedNames.reservedJavaKeywords)
		reservedNames.addAll(ReservedNames.reservedJavaNames)
		reservedNames.addAll(ReservedNames.reservedMuLEKeywords)		
		if (reservedNames.contains(nElem.name)) {
			error("Use of this name is not allowed. You are attempting to use a reserved word as an identifier.", MuLEPackage.Literals.NAMED_ELEMENT__NAME);
		}
		var container = nElem.eContainer
		if (container !== null) {
			var scope = scopeProvider.getVisibleSymbols(container, nElem)
			for (elem : scope.allElements) {
				var currentElement = (elem as IEObjectDescription).EObjectOrProxy
				if (nElem.name.toString().equals(elem.name.toString()) && currentElement !== nElem) {
					error("An element with such name already exists. Use a different name for this element.", MuLEPackage.Literals.NAMED_ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def checkUnitNameSameAsImportedLibrary(CompilationUnit unit) {
		for (_import : unit.imports) {
			if (unit.name.equals(_import.importedNamespace.name)) {
				error("Naming conflict, the names of the importing and imported compilation units must not be equal.",
					MuLEPackage.Literals.NAMED_ELEMENT__NAME)
			}
		}
	}
}
