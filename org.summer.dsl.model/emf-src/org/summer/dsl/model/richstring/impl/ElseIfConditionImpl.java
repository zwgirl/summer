/**
 */
package org.summer.dsl.model.richstring.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.summer.dsl.model.richstring.ElseIfCondition;
import org.summer.dsl.model.richstring.IfConditionStart;
import org.summer.dsl.model.richstring.RichstringPackage;

import org.summer.dsl.model.ss.RichStringElseIf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Else If Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.richstring.impl.ElseIfConditionImpl#getRichStringElseIf <em>Rich String Else If</em>}</li>
 *   <li>{@link org.summer.dsl.model.richstring.impl.ElseIfConditionImpl#getIfConditionStart <em>If Condition Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElseIfConditionImpl extends LinePartImpl implements ElseIfCondition {
	/**
	 * The cached value of the '{@link #getRichStringElseIf() <em>Rich String Else If</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRichStringElseIf()
	 * @generated
	 * @ordered
	 */
	protected RichStringElseIf richStringElseIf;

	/**
	 * The cached value of the '{@link #getIfConditionStart() <em>If Condition Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfConditionStart()
	 * @generated
	 * @ordered
	 */
	protected IfConditionStart ifConditionStart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElseIfConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RichstringPackage.Literals.ELSE_IF_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringElseIf getRichStringElseIf() {
		if (richStringElseIf != null && richStringElseIf.eIsProxy()) {
			InternalEObject oldRichStringElseIf = (InternalEObject)richStringElseIf;
			richStringElseIf = (RichStringElseIf)eResolveProxy(oldRichStringElseIf);
			if (richStringElseIf != oldRichStringElseIf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RichstringPackage.ELSE_IF_CONDITION__RICH_STRING_ELSE_IF, oldRichStringElseIf, richStringElseIf));
			}
		}
		return richStringElseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringElseIf basicGetRichStringElseIf() {
		return richStringElseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRichStringElseIf(RichStringElseIf newRichStringElseIf) {
		RichStringElseIf oldRichStringElseIf = richStringElseIf;
		richStringElseIf = newRichStringElseIf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RichstringPackage.ELSE_IF_CONDITION__RICH_STRING_ELSE_IF, oldRichStringElseIf, richStringElseIf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfConditionStart getIfConditionStart() {
		if (ifConditionStart != null && ifConditionStart.eIsProxy()) {
			InternalEObject oldIfConditionStart = (InternalEObject)ifConditionStart;
			ifConditionStart = (IfConditionStart)eResolveProxy(oldIfConditionStart);
			if (ifConditionStart != oldIfConditionStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START, oldIfConditionStart, ifConditionStart));
			}
		}
		return ifConditionStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfConditionStart basicGetIfConditionStart() {
		return ifConditionStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfConditionStart(IfConditionStart newIfConditionStart, NotificationChain msgs) {
		IfConditionStart oldIfConditionStart = ifConditionStart;
		ifConditionStart = newIfConditionStart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START, oldIfConditionStart, newIfConditionStart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfConditionStart(IfConditionStart newIfConditionStart) {
		if (newIfConditionStart != ifConditionStart) {
			NotificationChain msgs = null;
			if (ifConditionStart != null)
				msgs = ((InternalEObject)ifConditionStart).eInverseRemove(this, RichstringPackage.IF_CONDITION_START__ELSE_IF_CONDITIONS, IfConditionStart.class, msgs);
			if (newIfConditionStart != null)
				msgs = ((InternalEObject)newIfConditionStart).eInverseAdd(this, RichstringPackage.IF_CONDITION_START__ELSE_IF_CONDITIONS, IfConditionStart.class, msgs);
			msgs = basicSetIfConditionStart(newIfConditionStart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START, newIfConditionStart, newIfConditionStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START:
				if (ifConditionStart != null)
					msgs = ((InternalEObject)ifConditionStart).eInverseRemove(this, RichstringPackage.IF_CONDITION_START__ELSE_IF_CONDITIONS, IfConditionStart.class, msgs);
				return basicSetIfConditionStart((IfConditionStart)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START:
				return basicSetIfConditionStart(null, msgs);
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
			case RichstringPackage.ELSE_IF_CONDITION__RICH_STRING_ELSE_IF:
				if (resolve) return getRichStringElseIf();
				return basicGetRichStringElseIf();
			case RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START:
				if (resolve) return getIfConditionStart();
				return basicGetIfConditionStart();
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
			case RichstringPackage.ELSE_IF_CONDITION__RICH_STRING_ELSE_IF:
				setRichStringElseIf((RichStringElseIf)newValue);
				return;
			case RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START:
				setIfConditionStart((IfConditionStart)newValue);
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
			case RichstringPackage.ELSE_IF_CONDITION__RICH_STRING_ELSE_IF:
				setRichStringElseIf((RichStringElseIf)null);
				return;
			case RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START:
				setIfConditionStart((IfConditionStart)null);
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
			case RichstringPackage.ELSE_IF_CONDITION__RICH_STRING_ELSE_IF:
				return richStringElseIf != null;
			case RichstringPackage.ELSE_IF_CONDITION__IF_CONDITION_START:
				return ifConditionStart != null;
		}
		return super.eIsSet(featureID);
	}

} //ElseIfConditionImpl
