/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XCase Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XCasePart#getCase <em>Case</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XCasePart#getThen <em>Then</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XCasePart#getTypeGuard <em>Type Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXCasePart()
 * @model
 * @generated
 */
public interface XCasePart extends EObject {
	/**
	 * Returns the value of the '<em><b>Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case</em>' containment reference.
	 * @see #setCase(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCasePart_Case()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCase();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XCasePart#getCase <em>Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case</em>' containment reference.
	 * @see #getCase()
	 * @generated
	 */
	void setCase(XExpression value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCasePart_Then()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getThen();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XCasePart#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(XExpression value);

	/**
	 * Returns the value of the '<em><b>Type Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Guard</em>' containment reference.
	 * @see #setTypeGuard(JvmTypeReference)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCasePart_TypeGuard()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getTypeGuard();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XCasePart#getTypeGuard <em>Type Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Guard</em>' containment reference.
	 * @see #getTypeGuard()
	 * @generated
	 */
	void setTypeGuard(JvmTypeReference value);

} // XCasePart
