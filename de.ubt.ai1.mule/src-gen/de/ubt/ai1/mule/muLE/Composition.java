/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#getTypeParams <em>Type Params</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#getSuperTypeParams <em>Super Type Params</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#getTypeDeclarations <em>Type Declarations</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.Composition#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition()
 * @model
 * @generated
 */
public interface Composition extends TypeDeclaration
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see #setVisibility(String)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_Visibility()
   * @model
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.Composition#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(String value);

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_Abstract()
   * @model
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.Composition#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Type Params</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.TypeParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Params</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_TypeParams()
   * @model containment="true"
   * @generated
   */
  EList<TypeParameter> getTypeParams();

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' reference.
   * @see #setSuperType(Composition)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_SuperType()
   * @model
   * @generated
   */
  Composition getSuperType();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.Composition#getSuperType <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(Composition value);

  /**
   * Returns the value of the '<em><b>Super Type Params</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.TypeParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type Params</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_SuperTypeParams()
   * @model containment="true"
   * @generated
   */
  EList<TypeParameter> getSuperTypeParams();

  /**
   * Returns the value of the '<em><b>Type Declarations</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.TypeDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Declarations</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_TypeDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<TypeDeclaration> getTypeDeclarations();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link de.ubt.ai1.mule.muLE.Operation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getComposition_Operations()
   * @model containment="true"
   * @generated
   */
  EList<Operation> getOperations();

} // Composition