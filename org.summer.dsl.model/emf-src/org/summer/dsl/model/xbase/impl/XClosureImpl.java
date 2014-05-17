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
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XClosure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#getDeclaredFormalParameters <em>Declared Formal Parameters</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#isExplicitSyntax <em>Explicit Syntax</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#getImplicitParameter <em>Implicit Parameter</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#isOperator <em>Operator</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XClosureImpl#isExported <em>Exported</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XClosureImpl extends XExpressionImpl implements XClosure { 
	/**
	 * The cached value of the '{@link #getDeclaredFormalParameters() <em>Declared Formal Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredFormalParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmFormalParameter> declaredFormalParameters;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression expression;

	/**
	 * The default value of the '{@link #isExplicitSyntax() <em>Explicit Syntax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitSyntax()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPLICIT_SYNTAX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExplicitSyntax() <em>Explicit Syntax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplicitSyntax()
	 * @generated
	 * @ordered
	 */
	protected boolean explicitSyntax = EXPLICIT_SYNTAX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplicitParameter() <em>Implicit Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitParameter()
	 * @generated
	 * @ordered
	 */
	protected JvmFormalParameter implicitParameter;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference returnType;

	/**
	 * The default value of the '{@link #isOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperator()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPERATOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperator()
	 * @generated
	 * @ordered
	 */
	protected boolean operator = OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeParameter> typeParameters;

	/**
	 * The default value of the '{@link #isExported() <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExported() <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected boolean exported = EXPORTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XClosureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XCLOSURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmFormalParameter> getDeclaredFormalParameters() {
		if (declaredFormalParameters == null) {
			declaredFormalParameters = new EObjectContainmentEList<JvmFormalParameter>(JvmFormalParameter.class, this, XbasePackage.XCLOSURE__DECLARED_FORMAL_PARAMETERS);
		}
		return declaredFormalParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs) {
		XExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(XExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLOSURE__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLOSURE__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExplicitSyntax() {
		return explicitSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExplicitSyntax(boolean newExplicitSyntax) {
		boolean oldExplicitSyntax = explicitSyntax;
		explicitSyntax = newExplicitSyntax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__EXPLICIT_SYNTAX, oldExplicitSyntax, explicitSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmFormalParameter getImplicitParameter() {
		return implicitParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplicitParameter(JvmFormalParameter newImplicitParameter, NotificationChain msgs) {
		JvmFormalParameter oldImplicitParameter = implicitParameter;
		implicitParameter = newImplicitParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__IMPLICIT_PARAMETER, oldImplicitParameter, newImplicitParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitParameter(JvmFormalParameter newImplicitParameter) {
		if (newImplicitParameter != implicitParameter) {
			NotificationChain msgs = null;
			if (implicitParameter != null)
				msgs = ((InternalEObject)implicitParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLOSURE__IMPLICIT_PARAMETER, null, msgs);
			if (newImplicitParameter != null)
				msgs = ((InternalEObject)newImplicitParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLOSURE__IMPLICIT_PARAMETER, null, msgs);
			msgs = basicSetImplicitParameter(newImplicitParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__IMPLICIT_PARAMETER, newImplicitParameter, newImplicitParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(JvmTypeReference newReturnType, NotificationChain msgs) {
		JvmTypeReference oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(JvmTypeReference newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLOSURE__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCLOSURE__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(boolean newOperator) {
		boolean oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeParameter> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, XbasePackage.XCLOSURE__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExported() {
		return exported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExported(boolean newExported) {
		boolean oldExported = exported;
		exported = newExported;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCLOSURE__EXPORTED, oldExported, exported));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmFormalParameter> getFormalParameters() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public String getIdentifier() {
		return name;
	}
	
	public String getSimpleName() {
		return name;
	}
	
	public String getQualifiedName() {
		return name;
	}
	
	public String getQualifiedName(char innerClassDelimiter) {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XCLOSURE__DECLARED_FORMAL_PARAMETERS:
				return ((InternalEList<?>)getDeclaredFormalParameters()).basicRemove(otherEnd, msgs);
			case XbasePackage.XCLOSURE__EXPRESSION:
				return basicSetExpression(null, msgs);
			case XbasePackage.XCLOSURE__IMPLICIT_PARAMETER:
				return basicSetImplicitParameter(null, msgs);
			case XbasePackage.XCLOSURE__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case XbasePackage.XCLOSURE__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
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
			case XbasePackage.XCLOSURE__DECLARED_FORMAL_PARAMETERS:
				return getDeclaredFormalParameters();
			case XbasePackage.XCLOSURE__EXPRESSION:
				return getExpression();
			case XbasePackage.XCLOSURE__EXPLICIT_SYNTAX:
				return isExplicitSyntax();
			case XbasePackage.XCLOSURE__IMPLICIT_PARAMETER:
				return getImplicitParameter();
			case XbasePackage.XCLOSURE__NAME:
				return getName();
			case XbasePackage.XCLOSURE__RETURN_TYPE:
				return getReturnType();
			case XbasePackage.XCLOSURE__OPERATOR:
				return isOperator();
			case XbasePackage.XCLOSURE__TYPE_PARAMETERS:
				return getTypeParameters();
			case XbasePackage.XCLOSURE__EXPORTED:
				return isExported();
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
			case XbasePackage.XCLOSURE__DECLARED_FORMAL_PARAMETERS:
				getDeclaredFormalParameters().clear();
				getDeclaredFormalParameters().addAll((Collection<? extends JvmFormalParameter>)newValue);
				return;
			case XbasePackage.XCLOSURE__EXPRESSION:
				setExpression((XExpression)newValue);
				return;
			case XbasePackage.XCLOSURE__EXPLICIT_SYNTAX:
				setExplicitSyntax((Boolean)newValue);
				return;
			case XbasePackage.XCLOSURE__IMPLICIT_PARAMETER:
				setImplicitParameter((JvmFormalParameter)newValue);
				return;
			case XbasePackage.XCLOSURE__NAME:
				setName((String)newValue);
				return;
			case XbasePackage.XCLOSURE__RETURN_TYPE:
				setReturnType((JvmTypeReference)newValue);
				return;
			case XbasePackage.XCLOSURE__OPERATOR:
				setOperator((Boolean)newValue);
				return;
			case XbasePackage.XCLOSURE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
				return;
			case XbasePackage.XCLOSURE__EXPORTED:
				setExported((Boolean)newValue);
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
			case XbasePackage.XCLOSURE__DECLARED_FORMAL_PARAMETERS:
				getDeclaredFormalParameters().clear();
				return;
			case XbasePackage.XCLOSURE__EXPRESSION:
				setExpression((XExpression)null);
				return;
			case XbasePackage.XCLOSURE__EXPLICIT_SYNTAX:
				setExplicitSyntax(EXPLICIT_SYNTAX_EDEFAULT);
				return;
			case XbasePackage.XCLOSURE__IMPLICIT_PARAMETER:
				setImplicitParameter((JvmFormalParameter)null);
				return;
			case XbasePackage.XCLOSURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XbasePackage.XCLOSURE__RETURN_TYPE:
				setReturnType((JvmTypeReference)null);
				return;
			case XbasePackage.XCLOSURE__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case XbasePackage.XCLOSURE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case XbasePackage.XCLOSURE__EXPORTED:
				setExported(EXPORTED_EDEFAULT);
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
			case XbasePackage.XCLOSURE__DECLARED_FORMAL_PARAMETERS:
				return declaredFormalParameters != null && !declaredFormalParameters.isEmpty();
			case XbasePackage.XCLOSURE__EXPRESSION:
				return expression != null;
			case XbasePackage.XCLOSURE__EXPLICIT_SYNTAX:
				return explicitSyntax != EXPLICIT_SYNTAX_EDEFAULT;
			case XbasePackage.XCLOSURE__IMPLICIT_PARAMETER:
				return implicitParameter != null;
			case XbasePackage.XCLOSURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XbasePackage.XCLOSURE__RETURN_TYPE:
				return returnType != null;
			case XbasePackage.XCLOSURE__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case XbasePackage.XCLOSURE__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case XbasePackage.XCLOSURE__EXPORTED:
				return exported != EXPORTED_EDEFAULT;
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
		result.append(" (explicitSyntax: ");
		result.append(explicitSyntax);
		result.append(", name: ");
		result.append(name);
		result.append(", operator: ");
		result.append(operator);
		result.append(", exported: ");
		result.append(exported);
		result.append(')');
		return result.toString();
	}

} //XClosureImpl
