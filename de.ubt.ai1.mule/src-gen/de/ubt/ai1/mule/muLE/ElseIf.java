/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.ElseIf#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.ElseIf#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.mule.muLE.MuLEPackage#getElseIf()
 * @model
 * @generated
 */
public interface ElseIf extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getElseIf_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.ElseIf#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(Block)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getElseIf_Block()
   * @model containment="true"
   * @generated
   */
  Block getBlock();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.ElseIf#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(Block value);

} // ElseIf
