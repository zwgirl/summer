/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFor Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopStatment#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopStatment#getVariableDeclarations <em>Variable Declarations</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopStatment#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopStatment#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopStatment#getStatment <em>Statment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopStatment()
 * @model
 * @generated
 */
public interface XForLoopStatment extends XStatment {
	/**
	 * Returns the value of the '<em><b>Initial</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' containment reference.
	 * @see #setInitial(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopStatment_Initial()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getInitial();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopStatment#getInitial <em>Initial</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' containment reference.
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(XExpression value);

	/**
	 * Returns the value of the '<em><b>Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Declarations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Declarations</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopStatment_VariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopStatment_Condition()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCondition();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopStatment#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(XExpression value);

	/**
	 * Returns the value of the '<em><b>Increment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Increment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Increment</em>' containment reference.
	 * @see #setIncrement(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopStatment_Increment()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getIncrement();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopStatment#getIncrement <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' containment reference.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(XExpression value);

	/**
	 * Returns the value of the '<em><b>Statment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statment</em>' containment reference.
	 * @see #setStatment(XStatment)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopStatment_Statment()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getStatment();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopStatment#getStatment <em>Statment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statment</em>' containment reference.
	 * @see #getStatment()
	 * @generated
	 */
	void setStatment(XStatment value);

} // XForLoopExpression
