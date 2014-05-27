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
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XConstructor Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XConstructorCallImpl#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XConstructorCallImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XConstructorCallImpl#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XConstructorCallImpl#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XConstructorCallImpl#isValidFeature <em>Valid Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XConstructorCallImpl extends XExpressionImpl implements XConstructorCall {
	/**
	 * The cached value of the '{@link #getConstructor() <em>Constructor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructor()
	 * @generated
	 * @ordered
	 */
	protected JvmConstructor constructor;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> arguments;

	/**
	 * The cached value of the '{@link #getTypeArguments() <em>Type Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> typeArguments;

	/**
	 * The default value of the '{@link #getInvalidFeatureIssueCode() <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 * @ordered
	 */
	protected static final String INVALID_FEATURE_ISSUE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInvalidFeatureIssueCode() <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 * @ordered
	 */
	protected String invalidFeatureIssueCode = INVALID_FEATURE_ISSUE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isValidFeature() <em>Valid Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidFeature()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_FEATURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidFeature() <em>Valid Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidFeature()
	 * @generated
	 * @ordered
	 */
	protected boolean validFeature = VALID_FEATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XConstructorCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XCONSTRUCTOR_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmConstructor getConstructor() {
		if (constructor != null && constructor.eIsProxy()) {
			InternalEObject oldConstructor = (InternalEObject)constructor;
			constructor = (JvmConstructor)eResolveProxy(oldConstructor);
			if (constructor != oldConstructor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR, oldConstructor, constructor));
			}
		}
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmConstructor basicGetConstructor() {
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructor(JvmConstructor newConstructor) {
		JvmConstructor oldConstructor = constructor;
		constructor = newConstructor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR, oldConstructor, constructor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<XExpression>(XExpression.class, this, XbasePackage.XCONSTRUCTOR_CALL__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getTypeArguments() {
		if (typeArguments == null) {
			typeArguments = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, XbasePackage.XCONSTRUCTOR_CALL__TYPE_ARGUMENTS);
		}
		return typeArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInvalidFeatureIssueCode() {
		return invalidFeatureIssueCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvalidFeatureIssueCode(String newInvalidFeatureIssueCode) {
		String oldInvalidFeatureIssueCode = invalidFeatureIssueCode;
		invalidFeatureIssueCode = newInvalidFeatureIssueCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE, oldInvalidFeatureIssueCode, invalidFeatureIssueCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidFeature() {
		return validFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XCONSTRUCTOR_CALL__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
			case XbasePackage.XCONSTRUCTOR_CALL__TYPE_ARGUMENTS:
				return ((InternalEList<?>)getTypeArguments()).basicRemove(otherEnd, msgs);
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
			case XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR:
				if (resolve) return getConstructor();
				return basicGetConstructor();
			case XbasePackage.XCONSTRUCTOR_CALL__ARGUMENTS:
				return getArguments();
			case XbasePackage.XCONSTRUCTOR_CALL__TYPE_ARGUMENTS:
				return getTypeArguments();
			case XbasePackage.XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE:
				return getInvalidFeatureIssueCode();
			case XbasePackage.XCONSTRUCTOR_CALL__VALID_FEATURE:
				return isValidFeature();
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
			case XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR:
				setConstructor((JvmConstructor)newValue);
				return;
			case XbasePackage.XCONSTRUCTOR_CALL__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends XExpression>)newValue);
				return;
			case XbasePackage.XCONSTRUCTOR_CALL__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				getTypeArguments().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case XbasePackage.XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE:
				setInvalidFeatureIssueCode((String)newValue);
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
			case XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR:
				setConstructor((JvmConstructor)null);
				return;
			case XbasePackage.XCONSTRUCTOR_CALL__ARGUMENTS:
				getArguments().clear();
				return;
			case XbasePackage.XCONSTRUCTOR_CALL__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				return;
			case XbasePackage.XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE:
				setInvalidFeatureIssueCode(INVALID_FEATURE_ISSUE_CODE_EDEFAULT);
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
			case XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR:
				return constructor != null;
			case XbasePackage.XCONSTRUCTOR_CALL__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case XbasePackage.XCONSTRUCTOR_CALL__TYPE_ARGUMENTS:
				return typeArguments != null && !typeArguments.isEmpty();
			case XbasePackage.XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE:
				return INVALID_FEATURE_ISSUE_CODE_EDEFAULT == null ? invalidFeatureIssueCode != null : !INVALID_FEATURE_ISSUE_CODE_EDEFAULT.equals(invalidFeatureIssueCode);
			case XbasePackage.XCONSTRUCTOR_CALL__VALID_FEATURE:
				return validFeature != VALID_FEATURE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (invalidFeatureIssueCode: ");
		result.append(invalidFeatureIssueCode);
		result.append(", validFeature: ");
		result.append(validFeature);
		result.append(')');
		return result.toString();
	}

} //XConstructorCallImpl
