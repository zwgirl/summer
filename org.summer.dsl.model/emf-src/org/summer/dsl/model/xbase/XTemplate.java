/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XTemplate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XTemplate#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXTemplate()
 * @model
 * @generated
 */
public interface XTemplate extends XExpression {

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTemplate_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getExpressions();
} // XTemplate
