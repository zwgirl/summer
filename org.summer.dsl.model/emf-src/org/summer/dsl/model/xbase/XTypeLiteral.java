/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

import org.summer.dsl.model.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XType Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XTypeLiteral#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XTypeLiteral#getArrayDimensions <em>Array Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXTypeLiteral()
 * @model
 * @generated
 */
public interface XTypeLiteral extends XExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmType)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTypeLiteral_Type()
	 * @model required="true"
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTypeLiteral#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

	/**
	 * Returns the value of the '<em><b>Array Dimensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Dimensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Dimensions</em>' attribute list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTypeLiteral_ArrayDimensions()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getArrayDimensions();

} // XTypeLiteral
