/**
 */
package org.summer.dsl.model.types;

import org.summer.dsl.model.xbase.XStatment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Constructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmConstructor#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmConstructor()
 * @model
 * @generated
 */
public interface JvmConstructor extends JvmExecutable {

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(XStatment)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmConstructor_Body()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getBody();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmConstructor#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(XStatment value);
} // JvmConstructor
