/**
 */
package org.summer.xaml.core.xAML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmType;

import org.summer.xaml.core.xAML.AttributeElement;
import org.summer.xaml.core.xAML.XAMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.impl.AttributeElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.impl.AttributeElementImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.impl.AttributeElementImpl#getClose <em>Close</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.impl.AttributeElementImpl#getCloseAttribute <em>Close Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeElementImpl extends ElementContentImpl implements AttributeElement
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected JvmType type;

  /**
   * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttribute()
   * @generated
   * @ordered
   */
  protected JvmField attribute;

  /**
   * The cached value of the '{@link #getClose() <em>Close</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClose()
   * @generated
   * @ordered
   */
  protected JvmType close;

  /**
   * The cached value of the '{@link #getCloseAttribute() <em>Close Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCloseAttribute()
   * @generated
   * @ordered
   */
  protected JvmField closeAttribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeElementImpl()
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
    return XAMLPackage.Literals.ATTRIBUTE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (JvmType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XAMLPackage.ATTRIBUTE_ELEMENT__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(JvmType newType)
  {
    JvmType oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XAMLPackage.ATTRIBUTE_ELEMENT__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmField getAttribute()
  {
    if (attribute != null && attribute.eIsProxy())
    {
      InternalEObject oldAttribute = (InternalEObject)attribute;
      attribute = (JvmField)eResolveProxy(oldAttribute);
      if (attribute != oldAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XAMLPackage.ATTRIBUTE_ELEMENT__ATTRIBUTE, oldAttribute, attribute));
      }
    }
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmField basicGetAttribute()
  {
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttribute(JvmField newAttribute)
  {
    JvmField oldAttribute = attribute;
    attribute = newAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XAMLPackage.ATTRIBUTE_ELEMENT__ATTRIBUTE, oldAttribute, attribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getClose()
  {
    if (close != null && close.eIsProxy())
    {
      InternalEObject oldClose = (InternalEObject)close;
      close = (JvmType)eResolveProxy(oldClose);
      if (close != oldClose)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE, oldClose, close));
      }
    }
    return close;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetClose()
  {
    return close;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClose(JvmType newClose)
  {
    JvmType oldClose = close;
    close = newClose;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE, oldClose, close));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmField getCloseAttribute()
  {
    if (closeAttribute != null && closeAttribute.eIsProxy())
    {
      InternalEObject oldCloseAttribute = (InternalEObject)closeAttribute;
      closeAttribute = (JvmField)eResolveProxy(oldCloseAttribute);
      if (closeAttribute != oldCloseAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE, oldCloseAttribute, closeAttribute));
      }
    }
    return closeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmField basicGetCloseAttribute()
  {
    return closeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCloseAttribute(JvmField newCloseAttribute)
  {
    JvmField oldCloseAttribute = closeAttribute;
    closeAttribute = newCloseAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE, oldCloseAttribute, closeAttribute));
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
      case XAMLPackage.ATTRIBUTE_ELEMENT__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case XAMLPackage.ATTRIBUTE_ELEMENT__ATTRIBUTE:
        if (resolve) return getAttribute();
        return basicGetAttribute();
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE:
        if (resolve) return getClose();
        return basicGetClose();
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE:
        if (resolve) return getCloseAttribute();
        return basicGetCloseAttribute();
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
      case XAMLPackage.ATTRIBUTE_ELEMENT__TYPE:
        setType((JvmType)newValue);
        return;
      case XAMLPackage.ATTRIBUTE_ELEMENT__ATTRIBUTE:
        setAttribute((JvmField)newValue);
        return;
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE:
        setClose((JvmType)newValue);
        return;
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE:
        setCloseAttribute((JvmField)newValue);
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
      case XAMLPackage.ATTRIBUTE_ELEMENT__TYPE:
        setType((JvmType)null);
        return;
      case XAMLPackage.ATTRIBUTE_ELEMENT__ATTRIBUTE:
        setAttribute((JvmField)null);
        return;
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE:
        setClose((JvmType)null);
        return;
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE:
        setCloseAttribute((JvmField)null);
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
      case XAMLPackage.ATTRIBUTE_ELEMENT__TYPE:
        return type != null;
      case XAMLPackage.ATTRIBUTE_ELEMENT__ATTRIBUTE:
        return attribute != null;
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE:
        return close != null;
      case XAMLPackage.ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE:
        return closeAttribute != null;
    }
    return super.eIsSet(featureID);
  }

} //AttributeElementImpl
