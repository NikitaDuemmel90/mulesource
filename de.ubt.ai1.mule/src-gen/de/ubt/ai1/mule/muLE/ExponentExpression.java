/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exponent Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.ExponentExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.ExponentExpression#getOp <em>Op</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.ExponentExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see de.ubt.ai1.mule.muLE.MuLEPackage#getExponentExpression()
 * @model
 * @generated
 */
public interface ExponentExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getExponentExpression_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.ExponentExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getExponentExpression_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.ExponentExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see de.ubt.ai1.mule.muLE.MuLEPackage#getExponentExpression_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link de.ubt.ai1.mule.muLE.ExponentExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // ExponentExpression
