/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.xtype.XImportSection1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm No Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmNoModule#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmNoModule#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmNoModule()
 * @model
 * @generated
 */
public interface JvmNoModule extends EObject {
	/**
	 * Returns the value of the '<em><b>Import Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Section</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Section</em>' containment reference.
	 * @see #setImportSection(XImportSection1)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmNoModule_ImportSection()
	 * @model containment="true"
	 * @generated
	 */
	XImportSection1 getImportSection();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmNoModule#getImportSection <em>Import Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Section</em>' containment reference.
	 * @see #getImportSection()
	 * @generated
	 */
	void setImportSection(XImportSection1 value);

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmNoModule_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getContents();

} // JvmNoModule
