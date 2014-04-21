/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XObject Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XObjectLiteral#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XObjectLiteral#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXObjectLiteral()
 * @model
 * @generated
 */
public interface XObjectLiteral extends XExpression {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XObjectLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXObjectLiteral_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<XObjectLiteralPart> getProperties();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(JvmType)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXObjectLiteral_Type()
	 * @model containment="true"
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XObjectLiteral#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

} // XObjectLiteral
