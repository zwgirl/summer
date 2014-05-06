/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XVariable Declaration List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XVariableDeclarationList#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XVariableDeclarationList#isWriteable <em>Writeable</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XVariableDeclarationList#isExported <em>Exported</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXVariableDeclarationList()
 * @model
 * @generated
 */
public interface XVariableDeclarationList extends XExpression {
	/**
	 * Returns the value of the '<em><b>Writeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writeable</em>' attribute.
	 * @see #setWriteable(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXVariableDeclarationList_Writeable()
	 * @model
	 * @generated
	 */
	boolean isWriteable();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XVariableDeclarationList#isWriteable <em>Writeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Writeable</em>' attribute.
	 * @see #isWriteable()
	 * @generated
	 */
	void setWriteable(boolean value);

	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXVariableDeclarationList_Declarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getDeclarations();

	/**
	 * Returns the value of the '<em><b>Exported</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exported</em>' attribute.
	 * @see #setExported(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXVariableDeclarationList_Exported()
	 * @model default="false"
	 * @generated
	 */
	boolean isExported();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XVariableDeclarationList#isExported <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exported</em>' attribute.
	 * @see #isExported()
	 * @generated
	 */
	void setExported(boolean value);

} // XVariableDeclarationList
