/**
 */
package org.summer.dsl.model.xannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.summer.dsl.model.types.JvmType;

import org.summer.dsl.model.xannotation.XAnnotation;
import org.summer.dsl.model.xannotation.XAnnotationElementValuePair;
import org.summer.dsl.model.xannotation.XannotationPackage;

import org.summer.dsl.model.xbase.XExpression;

import org.summer.dsl.model.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xannotation.impl.XAnnotationImpl#getElementValuePairs <em>Element Value Pairs</em>}</li>
 *   <li>{@link org.summer.dsl.model.xannotation.impl.XAnnotationImpl#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xannotation.impl.XAnnotationImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XAnnotationImpl extends XExpressionImpl implements XAnnotation {
	/**
	 * The cached value of the '{@link #getElementValuePairs() <em>Element Value Pairs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementValuePairs()
	 * @generated
	 * @ordered
	 */
	protected EList<XAnnotationElementValuePair> elementValuePairs;

	/**
	 * The cached value of the '{@link #getAnnotationType() <em>Annotation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationType()
	 * @generated
	 * @ordered
	 */
	protected JvmType annotationType;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected XExpression value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XannotationPackage.Literals.XANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XAnnotationElementValuePair> getElementValuePairs() {
		if (elementValuePairs == null) {
			elementValuePairs = new EObjectContainmentEList<XAnnotationElementValuePair>(XAnnotationElementValuePair.class, this, XannotationPackage.XANNOTATION__ELEMENT_VALUE_PAIRS);
		}
		return elementValuePairs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType getAnnotationType() {
		if (annotationType != null && annotationType.eIsProxy()) {
			InternalEObject oldAnnotationType = (InternalEObject)annotationType;
			annotationType = (JvmType)eResolveProxy(oldAnnotationType);
			if (annotationType != oldAnnotationType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XannotationPackage.XANNOTATION__ANNOTATION_TYPE, oldAnnotationType, annotationType));
			}
		}
		return annotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType basicGetAnnotationType() {
		return annotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotationType(JvmType newAnnotationType) {
		JvmType oldAnnotationType = annotationType;
		annotationType = newAnnotationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XannotationPackage.XANNOTATION__ANNOTATION_TYPE, oldAnnotationType, annotationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(XExpression newValue, NotificationChain msgs) {
		XExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XannotationPackage.XANNOTATION__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(XExpression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XannotationPackage.XANNOTATION__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XannotationPackage.XANNOTATION__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XannotationPackage.XANNOTATION__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XannotationPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				return ((InternalEList<?>)getElementValuePairs()).basicRemove(otherEnd, msgs);
			case XannotationPackage.XANNOTATION__VALUE:
				return basicSetValue(null, msgs);
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
			case XannotationPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				return getElementValuePairs();
			case XannotationPackage.XANNOTATION__ANNOTATION_TYPE:
				if (resolve) return getAnnotationType();
				return basicGetAnnotationType();
			case XannotationPackage.XANNOTATION__VALUE:
				return getValue();
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
			case XannotationPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				getElementValuePairs().clear();
				getElementValuePairs().addAll((Collection<? extends XAnnotationElementValuePair>)newValue);
				return;
			case XannotationPackage.XANNOTATION__ANNOTATION_TYPE:
				setAnnotationType((JvmType)newValue);
				return;
			case XannotationPackage.XANNOTATION__VALUE:
				setValue((XExpression)newValue);
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
			case XannotationPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				getElementValuePairs().clear();
				return;
			case XannotationPackage.XANNOTATION__ANNOTATION_TYPE:
				setAnnotationType((JvmType)null);
				return;
			case XannotationPackage.XANNOTATION__VALUE:
				setValue((XExpression)null);
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
			case XannotationPackage.XANNOTATION__ELEMENT_VALUE_PAIRS:
				return elementValuePairs != null && !elementValuePairs.isEmpty();
			case XannotationPackage.XANNOTATION__ANNOTATION_TYPE:
				return annotationType != null;
			case XannotationPackage.XANNOTATION__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} //XAnnotationImpl
