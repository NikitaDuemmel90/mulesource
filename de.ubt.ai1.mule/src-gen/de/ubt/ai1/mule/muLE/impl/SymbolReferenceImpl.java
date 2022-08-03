/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE.impl;

import de.ubt.ai1.mule.muLE.MuLEPackage;
import de.ubt.ai1.mule.muLE.NamedElement;
import de.ubt.ai1.mule.muLE.SymbolRefAccessModifier;
import de.ubt.ai1.mule.muLE.SymbolRefCompositionInit;
import de.ubt.ai1.mule.muLE.SymbolReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.SymbolReferenceImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.SymbolReferenceImpl#getCompositionInit <em>Composition Init</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.SymbolReferenceImpl#getAccessModifier <em>Access Modifier</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.SymbolReferenceImpl#getMemberCall <em>Member Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymbolReferenceImpl extends AssignmentOrOperationCallImpl implements SymbolReference
{
  /**
   * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbol()
   * @generated
   * @ordered
   */
  protected NamedElement symbol;

  /**
   * The cached value of the '{@link #getCompositionInit() <em>Composition Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompositionInit()
   * @generated
   * @ordered
   */
  protected SymbolRefCompositionInit compositionInit;

  /**
   * The cached value of the '{@link #getAccessModifier() <em>Access Modifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessModifier()
   * @generated
   * @ordered
   */
  protected SymbolRefAccessModifier accessModifier;

  /**
   * The cached value of the '{@link #getMemberCall() <em>Member Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMemberCall()
   * @generated
   * @ordered
   */
  protected SymbolReference memberCall;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SymbolReferenceImpl()
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
    return MuLEPackage.Literals.SYMBOL_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElement getSymbol()
  {
    if (symbol != null && symbol.eIsProxy())
    {
      InternalEObject oldSymbol = (InternalEObject)symbol;
      symbol = (NamedElement)eResolveProxy(oldSymbol);
      if (symbol != oldSymbol)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MuLEPackage.SYMBOL_REFERENCE__SYMBOL, oldSymbol, symbol));
      }
    }
    return symbol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetSymbol()
  {
    return symbol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSymbol(NamedElement newSymbol)
  {
    NamedElement oldSymbol = symbol;
    symbol = newSymbol;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.SYMBOL_REFERENCE__SYMBOL, oldSymbol, symbol));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SymbolRefCompositionInit getCompositionInit()
  {
    return compositionInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCompositionInit(SymbolRefCompositionInit newCompositionInit, NotificationChain msgs)
  {
    SymbolRefCompositionInit oldCompositionInit = compositionInit;
    compositionInit = newCompositionInit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT, oldCompositionInit, newCompositionInit);
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
  public void setCompositionInit(SymbolRefCompositionInit newCompositionInit)
  {
    if (newCompositionInit != compositionInit)
    {
      NotificationChain msgs = null;
      if (compositionInit != null)
        msgs = ((InternalEObject)compositionInit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT, null, msgs);
      if (newCompositionInit != null)
        msgs = ((InternalEObject)newCompositionInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT, null, msgs);
      msgs = basicSetCompositionInit(newCompositionInit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT, newCompositionInit, newCompositionInit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SymbolRefAccessModifier getAccessModifier()
  {
    return accessModifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccessModifier(SymbolRefAccessModifier newAccessModifier, NotificationChain msgs)
  {
    SymbolRefAccessModifier oldAccessModifier = accessModifier;
    accessModifier = newAccessModifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER, oldAccessModifier, newAccessModifier);
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
  public void setAccessModifier(SymbolRefAccessModifier newAccessModifier)
  {
    if (newAccessModifier != accessModifier)
    {
      NotificationChain msgs = null;
      if (accessModifier != null)
        msgs = ((InternalEObject)accessModifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER, null, msgs);
      if (newAccessModifier != null)
        msgs = ((InternalEObject)newAccessModifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER, null, msgs);
      msgs = basicSetAccessModifier(newAccessModifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER, newAccessModifier, newAccessModifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SymbolReference getMemberCall()
  {
    return memberCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMemberCall(SymbolReference newMemberCall, NotificationChain msgs)
  {
    SymbolReference oldMemberCall = memberCall;
    memberCall = newMemberCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL, oldMemberCall, newMemberCall);
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
  public void setMemberCall(SymbolReference newMemberCall)
  {
    if (newMemberCall != memberCall)
    {
      NotificationChain msgs = null;
      if (memberCall != null)
        msgs = ((InternalEObject)memberCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL, null, msgs);
      if (newMemberCall != null)
        msgs = ((InternalEObject)newMemberCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL, null, msgs);
      msgs = basicSetMemberCall(newMemberCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL, newMemberCall, newMemberCall));
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
      case MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT:
        return basicSetCompositionInit(null, msgs);
      case MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER:
        return basicSetAccessModifier(null, msgs);
      case MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL:
        return basicSetMemberCall(null, msgs);
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
      case MuLEPackage.SYMBOL_REFERENCE__SYMBOL:
        if (resolve) return getSymbol();
        return basicGetSymbol();
      case MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT:
        return getCompositionInit();
      case MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER:
        return getAccessModifier();
      case MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL:
        return getMemberCall();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MuLEPackage.SYMBOL_REFERENCE__SYMBOL:
        setSymbol((NamedElement)newValue);
        return;
      case MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT:
        setCompositionInit((SymbolRefCompositionInit)newValue);
        return;
      case MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER:
        setAccessModifier((SymbolRefAccessModifier)newValue);
        return;
      case MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL:
        setMemberCall((SymbolReference)newValue);
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
      case MuLEPackage.SYMBOL_REFERENCE__SYMBOL:
        setSymbol((NamedElement)null);
        return;
      case MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT:
        setCompositionInit((SymbolRefCompositionInit)null);
        return;
      case MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER:
        setAccessModifier((SymbolRefAccessModifier)null);
        return;
      case MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL:
        setMemberCall((SymbolReference)null);
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
      case MuLEPackage.SYMBOL_REFERENCE__SYMBOL:
        return symbol != null;
      case MuLEPackage.SYMBOL_REFERENCE__COMPOSITION_INIT:
        return compositionInit != null;
      case MuLEPackage.SYMBOL_REFERENCE__ACCESS_MODIFIER:
        return accessModifier != null;
      case MuLEPackage.SYMBOL_REFERENCE__MEMBER_CALL:
        return memberCall != null;
    }
    return super.eIsSet(featureID);
  }

} //SymbolReferenceImpl