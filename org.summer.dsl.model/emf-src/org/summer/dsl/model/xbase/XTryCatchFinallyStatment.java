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
 *   <li>{@link org.summer.dsl.model.xbase.XTryCatchFinallyStatment#getStatment <em>Statment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XTryCatchFinallyStatment#getFinallyStatment <em>Finally Statment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XTryCatchFinallyStatment#getCatchClause <em>Catch Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyStatment()
 * @model
 * @generated
 */
public interface XTryCatchFinallyStatment extends XStatment {
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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyStatment_Statment()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getStatment();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTryCatchFinallyStatment#getStatment <em>Statment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statment</em>' containment reference.
	 * @see #getStatment()
	 * @generated
	 */
	void setStatment(XStatment value);

	/**
	 * Returns the value of the '<em><b>Finally Statment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally Statment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally Statment</em>' containment reference.
	 * @see #setFinallyStatment(XStatment)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyStatment_FinallyStatment()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getFinallyStatment();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTryCatchFinallyStatment#getFinallyStatment <em>Finally Statment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally Statment</em>' containment reference.
	 * @see #getFinallyStatment()
	 * @generated
	 */
	void setFinallyStatment(XStatment value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTryCatchFinallyStatment_CatchClause()
	 * @model containment="true"
	 * @generated
	 */
	XCatchClause getCatchClause();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTryCatchFinallyStatment#getCatchClause <em>Catch Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch Clause</em>' containment reference.
	 * @see #getCatchClause()
	 * @generated
	 */
	void setCatchClause(XCatchClause value);

} // XTryCatchFinallyExpression
