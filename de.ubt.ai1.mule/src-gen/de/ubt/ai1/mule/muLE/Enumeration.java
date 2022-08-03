/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.Enumeration#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Enumeration#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.mule.muLE.MuLEPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends TypeDeclaration
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see #setVisibility(String)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getEnumeration_Visibility()
   * @model
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.Enumeration#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(String value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.EnumerationValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getEnumeration_Values()
   * @model containment="true"
   * @generated
   */
  EList<EnumerationValue> getValues();

} // Enumeration
