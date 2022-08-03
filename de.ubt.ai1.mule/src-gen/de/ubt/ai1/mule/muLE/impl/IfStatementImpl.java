/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE.impl;

import de.ubt.ai1.mule.muLE.Block;
import de.ubt.ai1.mule.muLE.ElseIf;
import de.ubt.ai1.mule.muLE.Expression;
import de.ubt.ai1.mule.muLE.IfStatement;
import de.ubt.ai1.mule.muLE.MuLEPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.IfStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.IfStatementImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.IfStatementImpl#getElseIfs <em>Else Ifs</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.IfStatementImpl#getElseBlock <em>Else Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends StatementImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlock()
   * @generated
   * @ordered
   */
  protected Block block;

  /**
   * The cached value of the '{@link #getElseIfs() <em>Else Ifs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseIfs()
   * @generated
   * @ordered
   */
  protected EList<ElseIf> elseIfs;

  /**
   * The cached value of the '{@link #getElseBlock() <em>Else Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseBlock()
   * @generated
   * @ordered
   */
  protected Block elseBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MuLEPackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MuLEPackage.IF_STATEMENT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.IF_STATEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.IF_STATEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.IF_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Block getBlock()
  {
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs)
  {
    Block oldBlock = block;
    block = newBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MuLEPackage.IF_STATEMENT__BLOCK, oldBlock, newBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBlock(Block newBlock)
  {
    if (newBlock != block)
    {
      NotificationChain msgs = null;
      if (block != null)
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.IF_STATEMENT__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.IF_STATEMENT__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.IF_STATEMENT__BLOCK, newBlock, newBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ElseIf> getElseIfs()
  {
    if (elseIfs == null)
    {
      elseIfs = new EObjectContainmentEList<ElseIf>(ElseIf.class, this, MuLEPackage.IF_STATEMENT__ELSE_IFS);
    }
    return elseIfs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Block getElseBlock()
  {
    return elseBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseBlock(Block newElseBlock, NotificationChain msgs)
  {
    Block oldElseBlock = elseBlock;
    elseBlock = newElseBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MuLEPackage.IF_STATEMENT__ELSE_BLOCK, oldElseBlock, newElseBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setElseBlock(Block newElseBlock)
  {
    if (newElseBlock != elseBlock)
    {
      NotificationChain msgs = null;
      if (elseBlock != null)
        msgs = ((InternalEObject)elseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
      if (newElseBlock != null)
        msgs = ((InternalEObject)newElseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.IF_STATEMENT__ELSE_BLOCK, null, msgs);
      msgs = basicSetElseBlock(newElseBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.IF_STATEMENT__ELSE_BLOCK, newElseBlock, newElseBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MuLEPackage.IF_STATEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
      case MuLEPackage.IF_STATEMENT__BLOCK:
        return basicSetBlock(null, msgs);
      case MuLEPackage.IF_STATEMENT__ELSE_IFS:
        return ((InternalEList<?>)getElseIfs()).basicRemove(otherEnd, msgs);
      case MuLEPackage.IF_STATEMENT__ELSE_BLOCK:
        return basicSetElseBlock(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MuLEPackage.IF_STATEMENT__EXPRESSION:
        return getExpression();
      case MuLEPackage.IF_STATEMENT__BLOCK:
        return getBlock();
      case MuLEPackage.IF_STATEMENT__ELSE_IFS:
        return getElseIfs();
      case MuLEPackage.IF_STATEMENT__ELSE_BLOCK:
        return getElseBlock();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MuLEPackage.IF_STATEMENT__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case MuLEPackage.IF_STATEMENT__BLOCK:
        setBlock((Block)newValue);
        return;
      case MuLEPackage.IF_STATEMENT__ELSE_IFS:
        getElseIfs().clear();
        getElseIfs().addAll((Collection<? extends ElseIf>)newValue);
        return;
      case MuLEPackage.IF_STATEMENT__ELSE_BLOCK:
        setElseBlock((Block)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MuLEPackage.IF_STATEMENT__EXPRESSION:
        setExpression((Expression)null);
        return;
      case MuLEPackage.IF_STATEMENT__BLOCK:
        setBlock((Block)null);
        return;
      case MuLEPackage.IF_STATEMENT__ELSE_IFS:
        getElseIfs().clear();
        return;
      case MuLEPackage.IF_STATEMENT__ELSE_BLOCK:
        setElseBlock((Block)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MuLEPackage.IF_STATEMENT__EXPRESSION:
        return expression != null;
      case MuLEPackage.IF_STATEMENT__BLOCK:
        return block != null;
      case MuLEPackage.IF_STATEMENT__ELSE_IFS:
        return elseIfs != null && !elseIfs.isEmpty();
      case MuLEPackage.IF_STATEMENT__ELSE_BLOCK:
        return elseBlock != null;
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl
