/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE.impl;

import de.ubt.ai1.mule.muLE.DataType;
import de.ubt.ai1.mule.muLE.MuLEPackage;
import de.ubt.ai1.mule.muLE.OperationType;

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
 * An implementation of the model object '<em><b>Operation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.OperationTypeImpl#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.OperationTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationTypeImpl extends DataTypeImpl implements OperationType
{
  /**
   * The cached value of the '{@link #getParamTypes() <em>Param Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamTypes()
   * @generated
   * @ordered
   */
  protected EList<DataType> paramTypes;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected DataType type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationTypeImpl()
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
    return MuLEPackage.Literals.OPERATION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DataType> getParamTypes()
  {
    if (paramTypes == null)
    {
      paramTypes = new EObjectContainmentEList<DataType>(DataType.class, this, MuLEPackage.OPERATION_TYPE__PARAM_TYPES);
    }
    return paramTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DataType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(DataType newType, NotificationChain msgs)
  {
    DataType oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MuLEPackage.OPERATION_TYPE__TYPE, oldType, newType);
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
  public void setType(DataType newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.OPERATION_TYPE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MuLEPackage.OPERATION_TYPE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.OPERATION_TYPE__TYPE, newType, newType));
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
      case MuLEPackage.OPERATION_TYPE__PARAM_TYPES:
        return ((InternalEList<?>)getParamTypes()).basicRemove(otherEnd, msgs);
      case MuLEPackage.OPERATION_TYPE__TYPE:
        return basicSetType(null, msgs);
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
      case MuLEPackage.OPERATION_TYPE__PARAM_TYPES:
        return getParamTypes();
      case MuLEPackage.OPERATION_TYPE__TYPE:
        return getType();
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
      case MuLEPackage.OPERATION_TYPE__PARAM_TYPES:
        getParamTypes().clear();
        getParamTypes().addAll((Collection<? extends DataType>)newValue);
        return;
      case MuLEPackage.OPERATION_TYPE__TYPE:
        setType((DataType)newValue);
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
      case MuLEPackage.OPERATION_TYPE__PARAM_TYPES:
        getParamTypes().clear();
        return;
      case MuLEPackage.OPERATION_TYPE__TYPE:
        setType((DataType)null);
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
      case MuLEPackage.OPERATION_TYPE__PARAM_TYPES:
        return paramTypes != null && !paramTypes.isEmpty();
      case MuLEPackage.OPERATION_TYPE__TYPE:
        return type != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationTypeImpl
