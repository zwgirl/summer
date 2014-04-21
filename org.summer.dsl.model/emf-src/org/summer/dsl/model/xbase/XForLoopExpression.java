/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFor Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopExpression#getLoop <em>Loop</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopExpression#getInit <em>Init</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopExpression()
 * @model
 * @generated
 */
public interface XForLoopExpression extends XExpression {
	/**
	 * Returns the value of the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Each Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Each Expression</em>' containment reference.
	 * @see #setEachExpression(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopExpression_EachExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getEachExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Each Expression</em>' containment reference.
	 * @see #getEachExpression()
	 * @generated
	 */
	void setEachExpression(XExpression value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopExpression_Condition()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCondition();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopExpression#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(XExpression value);

	/**
	 * Returns the value of the '<em><b>Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' containment reference.
	 * @see #setLoop(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopExpression_Loop()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getLoop();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopExpression#getLoop <em>Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop</em>' containment reference.
	 * @see #getLoop()
	 * @generated
	 */
	void setLoop(XExpression value);

	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' containment reference.
	 * @see #setInit(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForLoopExpression_Init()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getInit();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForLoopExpression#getInit <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' containment reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(XExpression value);

} // XForLoopExpression
