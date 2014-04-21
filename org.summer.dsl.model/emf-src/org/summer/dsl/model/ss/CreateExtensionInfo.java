/**
 */
package org.summer.dsl.model.ss;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Extension Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.ss.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.CreateExtensionInfo#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.ss.SsPackage#getCreateExtensionInfo()
 * @model
 * @generated
 */
public interface CreateExtensionInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Create Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Expression</em>' containment reference.
	 * @see #setCreateExpression(XExpression)
	 * @see org.summer.dsl.model.ss.SsPackage#getCreateExtensionInfo_CreateExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCreateExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Expression</em>' containment reference.
	 * @see #getCreateExpression()
	 * @generated
	 */
	void setCreateExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"it"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.summer.dsl.model.ss.SsPackage#getCreateExtensionInfo_Name()
	 * @model default="it"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.CreateExtensionInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CreateExtensionInfo
