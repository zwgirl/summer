/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XExport Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XExportSection#getExportDeclarations <em>Export Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXExportSection()
 * @model
 * @generated
 */
public interface XExportSection extends EObject {
	/**
	 * Returns the value of the '<em><b>Export Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xtype.XExportDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Declarations</em>' containment reference list.
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXExportSection_ExportDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExportDeclaration> getExportDeclarations();

} // XExportSection
