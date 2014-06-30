/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XCase Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XCasePart#getCase <em>Case</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XCasePart#getStatments <em>Statments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XCasePart#isDefault <em>Default</em>}</li>
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
	 * Returns the value of the '<em><b>Statments</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XStatment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statments</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCasePart_Statments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XStatment> getStatments();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXCasePart_Default()
	 * @model default="false" transient="true" derived="true"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XCasePart#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

} // XCasePart
