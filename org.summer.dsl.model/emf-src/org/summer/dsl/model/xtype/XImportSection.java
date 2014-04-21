/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImport Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XImportSection#getImportDeclarations <em>Import Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportSection()
 * @model
 * @generated
 */
public interface XImportSection extends EObject {
	/**
	 * Returns the value of the '<em><b>Import Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xtype.XImportDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Declarations</em>' containment reference list.
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportSection_ImportDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<XImportDeclaration> getImportDeclarations();

} // XImportSection
