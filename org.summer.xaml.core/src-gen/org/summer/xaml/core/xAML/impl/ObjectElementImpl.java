/**
 */
package org.summer.xaml.core.xAML.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.summer.dsl.model.types.JvmTypeReference;

import org.summer.xaml.core.xAML.AbstractProperty;
import org.summer.xaml.core.xAML.ObjectElement;
import org.summer.xaml.core.xAML.XAMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.impl.ObjectElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.impl.ObjectElementImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.impl.ObjectElementImpl#getClose <em>Close</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectElementImpl extends ElementContentImpl implements ObjectElement
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected JvmTypeReference type;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<AbstractProperty> properties;

  /**
   * The cached value of the '{@link #getClose() <em>Close</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClose()
   * @generated
   * @ordered
   */
  protected JvmTypeReference close;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectElementImpl()
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
    return XAMLPackage.Literals.OBJECT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(JvmTypeReference newType, NotificationChain msgs)
  {
    JvmTypeReference oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XAMLPackage.OBJECT_ELEMENT__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(JvmTypeReference newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XAMLPackage.OBJECT_ELEMENT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XAMLPackage.OBJECT_ELEMENT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XAMLPackage.OBJECT_ELEMENT__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractProperty> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<AbstractProperty>(AbstractProperty.class, this, XAMLPackage.OBJECT_ELEMENT__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getClose()
  {
    return close;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClose(JvmTypeReference newClose, NotificationChain msgs)
  {
    JvmTypeReference oldClose = close;
    close = newClose;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XAMLPackage.OBJECT_ELEMENT__CLOSE, oldClose, newClose);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClose(JvmTypeReference newClose)
  {
    if (newClose != close)
    {
      NotificationChain msgs = null;
      if (close != null)
        msgs = ((InternalEObject)close).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XAMLPackage.OBJECT_ELEMENT__CLOSE, null, msgs);
      if (newClose != null)
        msgs = ((InternalEObject)newClose).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XAMLPackage.OBJECT_ELEMENT__CLOSE, null, msgs);
      msgs = basicSetClose(newClose, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XAMLPackage.OBJECT_ELEMENT__CLOSE, newClose, newClose));
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
      case XAMLPackage.OBJECT_ELEMENT__TYPE:
        return basicSetType(null, msgs);
      case XAMLPackage.OBJECT_ELEMENT__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
      case XAMLPackage.OBJECT_ELEMENT__CLOSE:
        return basicSetClose(null, msgs);
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
      case XAMLPackage.OBJECT_ELEMENT__TYPE:
        return getType();
      case XAMLPackage.OBJECT_ELEMENT__PROPERTIES:
        return getProperties();
      case XAMLPackage.OBJECT_ELEMENT__CLOSE:
        return getClose();
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
      case XAMLPackage.OBJECT_ELEMENT__TYPE:
        setType((JvmTypeReference)newValue);
        return;
      case XAMLPackage.OBJECT_ELEMENT__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends AbstractProperty>)newValue);
        return;
      case XAMLPackage.OBJECT_ELEMENT__CLOSE:
        setClose((JvmTypeReference)newValue);
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
      case XAMLPackage.OBJECT_ELEMENT__TYPE:
        setType((JvmTypeReference)null);
        return;
      case XAMLPackage.OBJECT_ELEMENT__PROPERTIES:
        getProperties().clear();
        return;
      case XAMLPackage.OBJECT_ELEMENT__CLOSE:
        setClose((JvmTypeReference)null);
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
      case XAMLPackage.OBJECT_ELEMENT__TYPE:
        return type != null;
      case XAMLPackage.OBJECT_ELEMENT__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case XAMLPackage.OBJECT_ELEMENT__CLOSE:
        return close != null;
    }
    return super.eIsSet(featureID);
  }

} //ObjectElementImpl
