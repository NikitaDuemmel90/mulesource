/*
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractMuLEValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(de.ubt.ai1.mule.muLE.MuLEPackage.eINSTANCE);
		return result;
	}
}
