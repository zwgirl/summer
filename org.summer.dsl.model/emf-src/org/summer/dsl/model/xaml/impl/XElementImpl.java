/**
 */
package org.summer.dsl.model.xaml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xaml.XAbstractAttribute;
import org.summer.dsl.model.xaml.XElement;
import org.summer.dsl.model.xaml.XamlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XElement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xaml.impl.XElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.impl.XElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.impl.XElementImpl#getCloseType <em>Close Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.impl.XElementImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XElementImpl extends MinimalEObjectImpl.Container implements XElement {
	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<XElement> contents;

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
	 * The cached value of the '{@link #getCloseType() <em>Close Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloseType()
	 * @generated
	 * @ordered
	 */
	protected JvmType closeType;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<XAbstractAttribute> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XamlPackage.Literals.XELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XElement> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<XElement>(XElement.class, this, XamlPackage.XELEMENT__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (JvmType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XamlPackage.XELEMENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(JvmType newType) {
		JvmType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XamlPackage.XELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType getCloseType() {
		if (closeType != null && closeType.eIsProxy()) {
			InternalEObject oldCloseType = (InternalEObject)closeType;
			closeType = (JvmType)eResolveProxy(oldCloseType);
			if (closeType != oldCloseType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XamlPackage.XELEMENT__CLOSE_TYPE, oldCloseType, closeType));
			}
		}
		return closeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType basicGetCloseType() {
		return closeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloseType(JvmType newCloseType) {
		JvmType oldCloseType = closeType;
		closeType = newCloseType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XamlPackage.XELEMENT__CLOSE_TYPE, oldCloseType, closeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XAbstractAttribute> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<XAbstractAttribute>(XAbstractAttribute.class, this, XamlPackage.XELEMENT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XamlPackage.XELEMENT__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case XamlPackage.XELEMENT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XamlPackage.XELEMENT__CONTENTS:
				return getContents();
			case XamlPackage.XELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case XamlPackage.XELEMENT__CLOSE_TYPE:
				if (resolve) return getCloseType();
				return basicGetCloseType();
			case XamlPackage.XELEMENT__PROPERTIES:
				return getProperties();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XamlPackage.XELEMENT__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends XElement>)newValue);
				return;
			case XamlPackage.XELEMENT__TYPE:
				setType((JvmType)newValue);
				return;
			case XamlPackage.XELEMENT__CLOSE_TYPE:
				setCloseType((JvmType)newValue);
				return;
			case XamlPackage.XELEMENT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends XAbstractAttribute>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case XamlPackage.XELEMENT__CONTENTS:
				getContents().clear();
				return;
			case XamlPackage.XELEMENT__TYPE:
				setType((JvmType)null);
				return;
			case XamlPackage.XELEMENT__CLOSE_TYPE:
				setCloseType((JvmType)null);
				return;
			case XamlPackage.XELEMENT__PROPERTIES:
				getProperties().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XamlPackage.XELEMENT__CONTENTS:
				return contents != null && !contents.isEmpty();
			case XamlPackage.XELEMENT__TYPE:
				return type != null;
			case XamlPackage.XELEMENT__CLOSE_TYPE:
				return closeType != null;
			case XamlPackage.XELEMENT__PROPERTIES:
				return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XElementImpl
