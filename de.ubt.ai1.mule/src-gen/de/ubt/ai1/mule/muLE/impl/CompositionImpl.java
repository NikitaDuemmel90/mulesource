/**
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.muLE.impl;

import de.ubt.ai1.mule.muLE.Attribute;
import de.ubt.ai1.mule.muLE.Composition;
import de.ubt.ai1.mule.muLE.MuLEPackage;
import de.ubt.ai1.mule.muLE.Operation;
import de.ubt.ai1.mule.muLE.TypeDeclaration;
import de.ubt.ai1.mule.muLE.TypeParameter;

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
 * An implementation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#getTypeParams <em>Type Params</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#getSuperTypeParams <em>Super Type Params</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#getTypeDeclarations <em>Type Declarations</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.ubt.ai1.mule.muLE.impl.CompositionImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositionImpl extends TypeDeclarationImpl implements Composition
{
  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final String VISIBILITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected String visibility = VISIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeParams() <em>Type Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeParams()
   * @generated
   * @ordered
   */
  protected EList<TypeParameter> typeParams;

  /**
   * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperType()
   * @generated
   * @ordered
   */
  protected Composition superType;

  /**
   * The cached value of the '{@link #getSuperTypeParams() <em>Super Type Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperTypeParams()
   * @generated
   * @ordered
   */
  protected EList<TypeParameter> superTypeParams;

  /**
   * The cached value of the '{@link #getTypeDeclarations() <em>Type Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeDeclarations()
   * @generated
   * @ordered
   */
  protected EList<TypeDeclaration> typeDeclarations;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<Operation> operations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompositionImpl()
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
    return MuLEPackage.Literals.COMPOSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVisibility(String newVisibility)
  {
    String oldVisibility = visibility;
    visibility = newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.COMPOSITION__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.COMPOSITION__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TypeParameter> getTypeParams()
  {
    if (typeParams == null)
    {
      typeParams = new EObjectContainmentEList<TypeParameter>(TypeParameter.class, this, MuLEPackage.COMPOSITION__TYPE_PARAMS);
    }
    return typeParams;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Composition getSuperType()
  {
    if (superType != null && superType.eIsProxy())
    {
      InternalEObject oldSuperType = (InternalEObject)superType;
      superType = (Composition)eResolveProxy(oldSuperType);
      if (superType != oldSuperType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MuLEPackage.COMPOSITION__SUPER_TYPE, oldSuperType, superType));
      }
    }
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Composition basicGetSuperType()
  {
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSuperType(Composition newSuperType)
  {
    Composition oldSuperType = superType;
    superType = newSuperType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MuLEPackage.COMPOSITION__SUPER_TYPE, oldSuperType, superType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TypeParameter> getSuperTypeParams()
  {
    if (superTypeParams == null)
    {
      superTypeParams = new EObjectContainmentEList<TypeParameter>(TypeParameter.class, this, MuLEPackage.COMPOSITION__SUPER_TYPE_PARAMS);
    }
    return superTypeParams;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TypeDeclaration> getTypeDeclarations()
  {
    if (typeDeclarations == null)
    {
      typeDeclarations = new EObjectContainmentEList<TypeDeclaration>(TypeDeclaration.class, this, MuLEPackage.COMPOSITION__TYPE_DECLARATIONS);
    }
    return typeDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, MuLEPackage.COMPOSITION__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Operation> getOperations()
  {
    if (operations == null)
    {
      operations = new EObjectContainmentEList<Operation>(Operation.class, this, MuLEPackage.COMPOSITION__OPERATIONS);
    }
    return operations;
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
      case MuLEPackage.COMPOSITION__TYPE_PARAMS:
        return ((InternalEList<?>)getTypeParams()).basicRemove(otherEnd, msgs);
      case MuLEPackage.COMPOSITION__SUPER_TYPE_PARAMS:
        return ((InternalEList<?>)getSuperTypeParams()).basicRemove(otherEnd, msgs);
      case MuLEPackage.COMPOSITION__TYPE_DECLARATIONS:
        return ((InternalEList<?>)getTypeDeclarations()).basicRemove(otherEnd, msgs);
      case MuLEPackage.COMPOSITION__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case MuLEPackage.COMPOSITION__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
      case MuLEPackage.COMPOSITION__VISIBILITY:
        return getVisibility();
      case MuLEPackage.COMPOSITION__ABSTRACT:
        return isAbstract();
      case MuLEPackage.COMPOSITION__TYPE_PARAMS:
        return getTypeParams();
      case MuLEPackage.COMPOSITION__SUPER_TYPE:
        if (resolve) return getSuperType();
        return basicGetSuperType();
      case MuLEPackage.COMPOSITION__SUPER_TYPE_PARAMS:
        return getSuperTypeParams();
      case MuLEPackage.COMPOSITION__TYPE_DECLARATIONS:
        return getTypeDeclarations();
      case MuLEPackage.COMPOSITION__ATTRIBUTES:
        return getAttributes();
      case MuLEPackage.COMPOSITION__OPERATIONS:
        return getOperations();
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
      case MuLEPackage.COMPOSITION__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case MuLEPackage.COMPOSITION__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case MuLEPackage.COMPOSITION__TYPE_PARAMS:
        getTypeParams().clear();
        getTypeParams().addAll((Collection<? extends TypeParameter>)newValue);
        return;
      case MuLEPackage.COMPOSITION__SUPER_TYPE:
        setSuperType((Composition)newValue);
        return;
      case MuLEPackage.COMPOSITION__SUPER_TYPE_PARAMS:
        getSuperTypeParams().clear();
        getSuperTypeParams().addAll((Collection<? extends TypeParameter>)newValue);
        return;
      case MuLEPackage.COMPOSITION__TYPE_DECLARATIONS:
        getTypeDeclarations().clear();
        getTypeDeclarations().addAll((Collection<? extends TypeDeclaration>)newValue);
        return;
      case MuLEPackage.COMPOSITION__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case MuLEPackage.COMPOSITION__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends Operation>)newValue);
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
      case MuLEPackage.COMPOSITION__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case MuLEPackage.COMPOSITION__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case MuLEPackage.COMPOSITION__TYPE_PARAMS:
        getTypeParams().clear();
        return;
      case MuLEPackage.COMPOSITION__SUPER_TYPE:
        setSuperType((Composition)null);
        return;
      case MuLEPackage.COMPOSITION__SUPER_TYPE_PARAMS:
        getSuperTypeParams().clear();
        return;
      case MuLEPackage.COMPOSITION__TYPE_DECLARATIONS:
        getTypeDeclarations().clear();
        return;
      case MuLEPackage.COMPOSITION__ATTRIBUTES:
        getAttributes().clear();
        return;
      case MuLEPackage.COMPOSITION__OPERATIONS:
        getOperations().clear();
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
      case MuLEPackage.COMPOSITION__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case MuLEPackage.COMPOSITION__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case MuLEPackage.COMPOSITION__TYPE_PARAMS:
        return typeParams != null && !typeParams.isEmpty();
      case MuLEPackage.COMPOSITION__SUPER_TYPE:
        return superType != null;
      case MuLEPackage.COMPOSITION__SUPER_TYPE_PARAMS:
        return superTypeParams != null && !superTypeParams.isEmpty();
      case MuLEPackage.COMPOSITION__TYPE_DECLARATIONS:
        return typeDeclarations != null && !typeDeclarations.isEmpty();
      case MuLEPackage.COMPOSITION__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case MuLEPackage.COMPOSITION__OPERATIONS:
        return operations != null && !operations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(')');
    return result.toString();
  }

} //CompositionImpl
