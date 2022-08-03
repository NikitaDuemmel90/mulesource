/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Init Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.ListInitElements#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.mule.muLE.MuLEPackage#getListInitElements()
 * @model
 * @generated
 */
public interface ListInitElements extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getListInitElements_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getElements();

} // ListInitElements