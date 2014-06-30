/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSwitch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XSwitchStatment#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XSwitchStatment#getCases <em>Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchStatment()
 * @model
 * @generated
 */
public interface XSwitchStatment extends XStatment {
	/**
	 * Returns the value of the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch</em>' containment reference.
	 * @see #setSwitch(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchStatment_Switch()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getSwitch();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XSwitchStatment#getSwitch <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch</em>' containment reference.
	 * @see #getSwitch()
	 * @generated
	 */
	void setSwitch(XExpression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XCasePart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchStatment_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCasePart> getCases();

} // XSwitchExpression
