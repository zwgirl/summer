/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XCatch Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XCatchClause#getStatment <em>Statment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XCatchClause#getDeclaredParam <em>Declared Param</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XCatchClause#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXCatchClause()
 * @model
 * @generated
 */
public interface XCatchClause extends EObject {
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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCatchClause_Statment()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getStatment();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XCatchClause#getStatment <em>Statment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statment</em>' containment reference.
	 * @see #getStatment()
	 * @generated
	 */
	void setStatment(XStatment value);

	/**
	 * Returns the value of the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Param</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Param</em>' containment reference.
	 * @see #setDeclaredParam(JvmFormalParameter)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCatchClause_DeclaredParam()
	 * @model containment="true"
	 * @generated
	 */
	JvmFormalParameter getDeclaredParam();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XCatchClause#getDeclaredParam <em>Declared Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Param</em>' containment reference.
	 * @see #getDeclaredParam()
	 * @generated
	 */
	void setDeclaredParam(JvmFormalParameter value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCatchClause_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XCatchClause#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

} // XCatchClause
