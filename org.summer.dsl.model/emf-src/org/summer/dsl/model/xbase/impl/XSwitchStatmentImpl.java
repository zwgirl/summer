/**
 */
package org.summer.dsl.model.xbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XSwitch Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XSwitchStatmentImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XSwitchStatmentImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XSwitchStatmentImpl#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XSwitchStatmentImpl extends XStatmentImpl implements XSwitchStatment {
	/**
	 * The cached value of the '{@link #getSwitch() <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitch()
	 * @generated
	 * @ordered
	 */
	protected XExpression switch_;

	/**
	 * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCases()
	 * @generated
	 * @ordered
	 */
	protected EList<XCasePart> cases;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected XStatment default_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XSwitchStatmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XSWITCH_STATMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getSwitch() {
		return switch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwitch(XExpression newSwitch, NotificationChain msgs) {
		XExpression oldSwitch = switch_;
		switch_ = newSwitch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_STATMENT__SWITCH, oldSwitch, newSwitch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitch(XExpression newSwitch) {
		if (newSwitch != switch_) {
			NotificationChain msgs = null;
			if (switch_ != null)
				msgs = ((InternalEObject)switch_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_STATMENT__SWITCH, null, msgs);
			if (newSwitch != null)
				msgs = ((InternalEObject)newSwitch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_STATMENT__SWITCH, null, msgs);
			msgs = basicSetSwitch(newSwitch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_STATMENT__SWITCH, newSwitch, newSwitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XCasePart> getCases() {
		if (cases == null) {
			cases = new EObjectContainmentEList<XCasePart>(XCasePart.class, this, XbasePackage.XSWITCH_STATMENT__CASES);
		}
		return cases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStatment getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefault(XStatment newDefault, NotificationChain msgs) {
		XStatment oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_STATMENT__DEFAULT, oldDefault, newDefault);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(XStatment newDefault) {
		if (newDefault != default_) {
			NotificationChain msgs = null;
			if (default_ != null)
				msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_STATMENT__DEFAULT, null, msgs);
			if (newDefault != null)
				msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XSWITCH_STATMENT__DEFAULT, null, msgs);
			msgs = basicSetDefault(newDefault, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XSWITCH_STATMENT__DEFAULT, newDefault, newDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XSWITCH_STATMENT__SWITCH:
				return basicSetSwitch(null, msgs);
			case XbasePackage.XSWITCH_STATMENT__CASES:
				return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
			case XbasePackage.XSWITCH_STATMENT__DEFAULT:
				return basicSetDefault(null, msgs);
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
			case XbasePackage.XSWITCH_STATMENT__SWITCH:
				return getSwitch();
			case XbasePackage.XSWITCH_STATMENT__CASES:
				return getCases();
			case XbasePackage.XSWITCH_STATMENT__DEFAULT:
				return getDefault();
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
			case XbasePackage.XSWITCH_STATMENT__SWITCH:
				setSwitch((XExpression)newValue);
				return;
			case XbasePackage.XSWITCH_STATMENT__CASES:
				getCases().clear();
				getCases().addAll((Collection<? extends XCasePart>)newValue);
				return;
			case XbasePackage.XSWITCH_STATMENT__DEFAULT:
				setDefault((XStatment)newValue);
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
			case XbasePackage.XSWITCH_STATMENT__SWITCH:
				setSwitch((XExpression)null);
				return;
			case XbasePackage.XSWITCH_STATMENT__CASES:
				getCases().clear();
				return;
			case XbasePackage.XSWITCH_STATMENT__DEFAULT:
				setDefault((XStatment)null);
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
			case XbasePackage.XSWITCH_STATMENT__SWITCH:
				return switch_ != null;
			case XbasePackage.XSWITCH_STATMENT__CASES:
				return cases != null && !cases.isEmpty();
			case XbasePackage.XSWITCH_STATMENT__DEFAULT:
				return default_ != null;
		}
		return super.eIsSet(featureID);
	}

} //XSwitchExpressionImpl
