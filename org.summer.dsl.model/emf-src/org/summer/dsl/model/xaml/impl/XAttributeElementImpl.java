/**
 */
package org.summer.dsl.model.xaml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.xaml.XAttributeElement;
import org.summer.dsl.model.xaml.XamlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAttribute Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xaml.impl.XAttributeElementImpl#getField <em>Field</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.impl.XAttributeElementImpl#getCloseField <em>Close Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XAttributeElementImpl extends XElementImpl implements XAttributeElement {
	/**
	 * The cached value of the '{@link #getField() <em>Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected JvmField field;

	/**
	 * The cached value of the '{@link #getCloseField() <em>Close Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloseField()
	 * @generated
	 * @ordered
	 */
	protected JvmField closeField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XAttributeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XamlPackage.Literals.XATTRIBUTE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmField getField() {
		if (field != null && field.eIsProxy()) {
			InternalEObject oldField = (InternalEObject)field;
			field = (JvmField)eResolveProxy(oldField);
			if (field != oldField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XamlPackage.XATTRIBUTE_ELEMENT__FIELD, oldField, field));
			}
		}
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmField basicGetField() {
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField(JvmField newField) {
		JvmField oldField = field;
		field = newField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XamlPackage.XATTRIBUTE_ELEMENT__FIELD, oldField, field));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmField getCloseField() {
		if (closeField != null && closeField.eIsProxy()) {
			InternalEObject oldCloseField = (InternalEObject)closeField;
			closeField = (JvmField)eResolveProxy(oldCloseField);
			if (closeField != oldCloseField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XamlPackage.XATTRIBUTE_ELEMENT__CLOSE_FIELD, oldCloseField, closeField));
			}
		}
		return closeField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmField basicGetCloseField() {
		return closeField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloseField(JvmField newCloseField) {
		JvmField oldCloseField = closeField;
		closeField = newCloseField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XamlPackage.XATTRIBUTE_ELEMENT__CLOSE_FIELD, oldCloseField, closeField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XamlPackage.XATTRIBUTE_ELEMENT__FIELD:
				if (resolve) return getField();
				return basicGetField();
			case XamlPackage.XATTRIBUTE_ELEMENT__CLOSE_FIELD:
				if (resolve) return getCloseField();
				return basicGetCloseField();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XamlPackage.XATTRIBUTE_ELEMENT__FIELD:
				setField((JvmField)newValue);
				return;
			case XamlPackage.XATTRIBUTE_ELEMENT__CLOSE_FIELD:
				setCloseField((JvmField)newValue);
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
			case XamlPackage.XATTRIBUTE_ELEMENT__FIELD:
				setField((JvmField)null);
				return;
			case XamlPackage.XATTRIBUTE_ELEMENT__CLOSE_FIELD:
				setCloseField((JvmField)null);
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
			case XamlPackage.XATTRIBUTE_ELEMENT__FIELD:
				return field != null;
			case XamlPackage.XATTRIBUTE_ELEMENT__CLOSE_FIELD:
				return closeField != null;
		}
		return super.eIsSet(featureID);
	}

} //XAttributeElementImpl
