/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

import org.summer.dsl.model.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSwitch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XSwitchExpression#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XSwitchExpression#getCases <em>Cases</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XSwitchExpression#getDefault <em>Default</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XSwitchExpression#getLocalVarName <em>Local Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchExpression()
 * @model
 * @generated
 */
public interface XSwitchExpression extends XExpression, JvmIdentifiableElement {
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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchExpression_Switch()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getSwitch();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XSwitchExpression#getSwitch <em>Switch</em>}' containment reference.
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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchExpression_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCasePart> getCases();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchExpression_Default()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDefault();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XSwitchExpression#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(XExpression value);

	/**
	 * Returns the value of the '<em><b>Local Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Var Name</em>' attribute.
	 * @see #setLocalVarName(String)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXSwitchExpression_LocalVarName()
	 * @model
	 * @generated
	 */
	String getLocalVarName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XSwitchExpression#getLocalVarName <em>Local Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Var Name</em>' attribute.
	 * @see #getLocalVarName()
	 * @generated
	 */
	void setLocalVarName(String value);

} // XSwitchExpression
