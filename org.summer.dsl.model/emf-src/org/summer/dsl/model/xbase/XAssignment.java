/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAssignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XAssignment#getAssignable <em>Assignable</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAssignment#getValue <em>Value</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAssignment#isIndexedOperation <em>Indexed Operation</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAssignment#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXAssignment()
 * @model
 * @generated
 */
public interface XAssignment extends XAbstractFeatureCall {
	/**
	 * Returns the value of the '<em><b>Assignable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignable</em>' containment reference.
	 * @see #setAssignable(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAssignment_Assignable()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getAssignable();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAssignment#getAssignable <em>Assignable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignable</em>' containment reference.
	 * @see #getAssignable()
	 * @generated
	 */
	void setAssignable(XExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAssignment_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAssignment#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Static</em>' attribute.
	 * @see #setExplicitStatic(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAssignment_ExplicitStatic()
	 * @model
	 * @generated
	 */
	boolean isExplicitStatic();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Static</em>' attribute.
	 * @see #isExplicitStatic()
	 * @generated
	 */
	void setExplicitStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Indexed Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexed Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexed Operation</em>' attribute.
	 * @see #setIndexedOperation(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAssignment_IndexedOperation()
	 * @model
	 * @generated
	 */
	boolean isIndexedOperation();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAssignment#isIndexedOperation <em>Indexed Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indexed Operation</em>' attribute.
	 * @see #isIndexedOperation()
	 * @generated
	 */
	void setIndexedOperation(boolean value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' containment reference.
	 * @see #setIndex(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAssignment_Index()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getIndex();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAssignment#getIndex <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' containment reference.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(XExpression value);

} // XAssignment
