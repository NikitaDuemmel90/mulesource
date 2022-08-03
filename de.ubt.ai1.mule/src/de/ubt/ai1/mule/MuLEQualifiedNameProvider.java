package de.ubt.ai1.mule;

import org.eclipse.emf.ecore.EObject;

import de.ubt.ai1.mule.muLE.*;

public class MuLEQualifiedNameProvider {
	
	

	public static String getQualifiedName(NamedElement obj) {
		if (obj instanceof Composition || obj instanceof Enumeration) {
			String result = obj.getName();
			EObject container = obj.eContainer();
			while (container != null) {
				if (container instanceof Composition) {
					result = ((Composition) container).getName() + "." + result;
				}
				if (container instanceof CompilationUnit) {
					result = ((CompilationUnit) container).getName() + "." + result;
				}
				container = container.eContainer();
			}
			return result;
		}
		if (obj instanceof Attribute) {
			Composition container = (Composition) obj.eContainer();
			String result = getQualifiedName(container) + "." + obj.getName();
			return result;
		}

		if (obj instanceof EnumerationValue) {
			Enumeration container = (Enumeration) obj.eContainer();
			String result = getQualifiedName(container) + "." + obj.getName();
			return result;
		}
		if (obj instanceof TypeDeclaration) {
//			TypeDeclaration typeDec = (TypeDeclaration) obj;
//			if (typeDec.eIsProxy()) {
//				System.out.println(typeDec);
//			}
			return "DataType";
		}
		return "NOT_IMPLEMENTED_CASE_IN_MuLEQualifiedNameProvider";
	}
}
