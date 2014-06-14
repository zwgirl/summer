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
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAbstract Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl#isValidFeature <em>Valid Feature</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl#getImplicitFirstArgument <em>Implicit First Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XAbstractFeatureCallImpl extends XExpressionImpl implements XAbstractFeatureCall {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected JvmIdentifiableElement feature;

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
	 * The cached value of the '{@link #getImplicitReceiver() <em>Implicit Receiver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitReceiver()
	 * @generated
	 * @ordered
	 */
	protected XExpression implicitReceiver;

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
	 * The cached value of the '{@link #getImplicitFirstArgument() <em>Implicit First Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitFirstArgument()
	 * @generated
	 * @ordered
	 */
	protected XExpression implicitFirstArgument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XAbstractFeatureCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIdentifiableElement getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (JvmIdentifiableElement)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIdentifiableElement basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(JvmIdentifiableElement newFeature) {
		JvmIdentifiableElement oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getTypeArguments() {
		if (typeArguments == null) {
			typeArguments = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS);
		}
		return typeArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getImplicitReceiver() {
		return implicitReceiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplicitReceiver(XExpression newImplicitReceiver, NotificationChain msgs) {
		XExpression oldImplicitReceiver = implicitReceiver;
		implicitReceiver = newImplicitReceiver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER, oldImplicitReceiver, newImplicitReceiver);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitReceiver(XExpression newImplicitReceiver) {
		if (newImplicitReceiver != implicitReceiver) {
			NotificationChain msgs = null;
			if (implicitReceiver != null)
				msgs = ((InternalEObject)implicitReceiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER, null, msgs);
			if (newImplicitReceiver != null)
				msgs = ((InternalEObject)newImplicitReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER, null, msgs);
			msgs = basicSetImplicitReceiver(newImplicitReceiver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER, newImplicitReceiver, newImplicitReceiver));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE, oldInvalidFeatureIssueCode, invalidFeatureIssueCode));
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
	public XExpression getImplicitFirstArgument() {
		return implicitFirstArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplicitFirstArgument(XExpression newImplicitFirstArgument, NotificationChain msgs) {
		XExpression oldImplicitFirstArgument = implicitFirstArgument;
		implicitFirstArgument = newImplicitFirstArgument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, oldImplicitFirstArgument, newImplicitFirstArgument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitFirstArgument(XExpression newImplicitFirstArgument) {
		if (newImplicitFirstArgument != implicitFirstArgument) {
			NotificationChain msgs = null;
			if (implicitFirstArgument != null)
				msgs = ((InternalEObject)implicitFirstArgument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, null, msgs);
			if (newImplicitFirstArgument != null)
				msgs = ((InternalEObject)newImplicitFirstArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, null, msgs);
			msgs = basicSetImplicitFirstArgument(newImplicitFirstArgument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT, newImplicitFirstArgument, newImplicitFirstArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcreteSyntaxFeatureName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getExplicitArguments() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExplicitOperationCallOrBuilderSyntax() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getActualReceiver() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getActualArguments() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtension() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPackageFragment() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypeLiteral() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOperation() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				return ((InternalEList<?>)getTypeArguments()).basicRemove(otherEnd, msgs);
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				return basicSetImplicitReceiver(null, msgs);
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				return basicSetImplicitFirstArgument(null, msgs);
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				return getTypeArguments();
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				return getImplicitReceiver();
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				return getInvalidFeatureIssueCode();
			case XbasePackage.XABSTRACT_FEATURE_CALL__VALID_FEATURE:
				return isValidFeature();
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				return getImplicitFirstArgument();
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				setFeature((JvmIdentifiableElement)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				getTypeArguments().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((XExpression)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				setInvalidFeatureIssueCode((String)newValue);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				setImplicitFirstArgument((XExpression)newValue);
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				setFeature((JvmIdentifiableElement)null);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				setImplicitReceiver((XExpression)null);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				setInvalidFeatureIssueCode(INVALID_FEATURE_ISSUE_CODE_EDEFAULT);
				return;
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				setImplicitFirstArgument((XExpression)null);
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
			case XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE:
				return feature != null;
			case XbasePackage.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS:
				return typeArguments != null && !typeArguments.isEmpty();
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER:
				return implicitReceiver != null;
			case XbasePackage.XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE:
				return INVALID_FEATURE_ISSUE_CODE_EDEFAULT == null ? invalidFeatureIssueCode != null : !INVALID_FEATURE_ISSUE_CODE_EDEFAULT.equals(invalidFeatureIssueCode);
			case XbasePackage.XABSTRACT_FEATURE_CALL__VALID_FEATURE:
				return validFeature != VALID_FEATURE_EDEFAULT;
			case XbasePackage.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT:
				return implicitFirstArgument != null;
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

} //XAbstractFeatureCallImpl
