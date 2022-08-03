package mule.util

import org.eclipse.emf.ecore.EObject
import de.ubt.ai1.mule.muLE.*

class MuLEObjectCopyProvider {
	/**
	 * Creates copies of specific MuLE Objects, required in QuickFixProvider, TypeProvider
	 */
	def static EObject copyMuLEObject(EObject obj) {
		/*
				var newObj = MuLEFactory.eINSTANCE.
				newObj.
				return newObj
		*/
		if (obj === null) {
//			println("Null reference in MuLEObjectCopyProvider.copyMuLEObject")
			return null
		}
		else if (obj.eIsProxy) {
//			println("Proxy in MuLEObjectCopyProvider.copyMuLEObject")
			return obj
		}
		switch (obj) {
			Enumeration: {
				var newObj = MuLEFactory.eINSTANCE.createEnumeration
				newObj.visibility = obj.visibility
				newObj.name = obj.name
				for (v : obj.values)
					newObj.values.add(v.copyMuLEObject as EnumerationValue)
				return newObj
			}
			EnumerationValue: {
				var newObj = MuLEFactory.eINSTANCE.createEnumerationValue
				newObj.name = obj.name
				return newObj
			}
			Composition: {
				var newObj = MuLEFactory.eINSTANCE.createComposition
				newObj.abstract = obj.abstract
				newObj.visibility = obj.visibility
				newObj.name = obj.name
				for (tp : obj.typeParams) 
					newObj.typeParams.add(tp.copyMuLEObject as TypeParameter)
				if (obj.superType !== null){
					newObj.superType = obj.superType.copyMuLEObject as Composition
					for (stp : obj.superTypeParams)
						newObj.superTypeParams.add(stp.copyMuLEObject as TypeParameter)
				}
				return newObj
			}
			TypeParameter: {
				var newObj = MuLEFactory.eINSTANCE.createTypeParameter
				newObj.name = obj.name
				if (obj.superType !== null)
					newObj.superType = obj.superType.copyMuLEObject as Composition
				return newObj
			}
			Operation: {
				var newObj = MuLEFactory.eINSTANCE.createOperation
				newObj.name = obj.name
				if (obj.type !== null)
					newObj.type = copyMuLEObject(obj.type) as DataType
				for (p : obj.params)
					newObj.params.add(p.copyMuLEObject as Parameter)
				return newObj
			}
			Parameter: {
				var newObj = MuLEFactory.eINSTANCE.createParameter
				newObj.name = obj.name
				newObj.type = copyMuLEObject(obj.type) as DataType
				return newObj
			}
			VariableDeclaration: {
				var newObj = MuLEFactory.eINSTANCE.createVariableDeclaration
				newObj.name = obj.name
				newObj.type = obj.type.copyMuLEObject as DataType
				return newObj
			}
			BasicType: {
				var newObj = MuLEFactory.eINSTANCE.createBasicType
				newObj.typeName = obj.typeName
				return newObj
			}
			DeclaredType: {
				var newObj = MuLEFactory.eINSTANCE.createDeclaredType
				newObj.type = copyMuLEObject(obj.type) as TypeDeclaration
				return newObj
			}
			ReferenceType: {
				var newObj = MuLEFactory.eINSTANCE.createReferenceType
				newObj.type = obj.type.copyMuLEObject as DataType
				return newObj
			}
			ListType: {
				var newObj = MuLEFactory.eINSTANCE.createListType
				newObj.type = obj.type.copyMuLEObject as DataType
				return newObj
			}
			OperationType: {
				var newObj = MuLEFactory.eINSTANCE.createOperationType
				if (obj.type !== null)
					newObj.type = obj.type.copyMuLEObject as DataType
				for (pType : obj.paramTypes)
					newObj.paramTypes.add(pType.copyMuLEObject as DataType)
				return newObj
			}
			default: {
				if (obj.eIsProxy) {
					if (obj instanceof TypeDeclaration) {
						var uri = obj.eResource.URI.toString
						if (uri.contains("Lists.mule")) {
							var typeDec = MuLEFactory.eINSTANCE.createTypeParameter
							typeDec.name = "T"
							return typeDec
						}
					}
				}
				var e = new Exception("Unimplemented case in MuLEObjectCopyProvider")
				e.printStackTrace
				throw e
			}
		}
	}
}