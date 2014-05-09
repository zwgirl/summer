/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XTry Catch Finally Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getCatchClause <em>Catch Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyExpression()
 * @model
 * @generated
 */
public interface XTryCatchFinallyExpression extends XExpression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyExpression_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Finally Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally Expression</em>' containment reference.
	 * @see #setFinallyExpression(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyExpression_FinallyExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getFinallyExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally Expression</em>' containment reference.
	 * @see #getFinallyExpression()
	 * @generated
	 */
	void setFinallyExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Catch Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch Clause</em>' containment reference.
	 * @see #setCatchClause(XCatchClause)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyExpression_CatchClause()
	 * @model containment="true"
	 * @generated
	 */
	XCatchClause getCatchClause();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getCatchClause <em>Catch Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch Clause</em>' containment reference.
	 * @see #getCatchClause()
	 * @generated
	 */
	void setCatchClause(XCatchClause value);

} // XTryCatchFinallyExpression
