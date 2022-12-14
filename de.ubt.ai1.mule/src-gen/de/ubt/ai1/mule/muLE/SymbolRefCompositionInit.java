/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol Ref Composition Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.SymbolRefCompositionInit#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.mule.muLE.MuLEPackage#getSymbolRefCompositionInit()
 * @model
 * @generated
 */
public interface SymbolRefCompositionInit extends EObject
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.SymbolRefCompositionAttribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getSymbolRefCompositionInit_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<SymbolRefCompositionAttribute> getAttributes();

} // SymbolRefCompositionInit
