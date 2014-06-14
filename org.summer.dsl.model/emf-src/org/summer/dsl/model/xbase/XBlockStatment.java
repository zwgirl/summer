/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBlock Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XBlockStatment#getStatments <em>Statments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXBlockStatment()
 * @model
 * @generated
 */
public interface XBlockStatment extends XExpression, XStatment {
	/**
	 * Returns the value of the '<em><b>Statments</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XStatment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statments</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXBlockStatment_Statments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XStatment> getStatments();

} // XBlockExpression
