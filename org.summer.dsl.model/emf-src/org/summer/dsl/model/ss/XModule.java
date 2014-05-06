/**
 */
package org.summer.dsl.model.ss;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XImportSection1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.ss.XModule#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XModule#getXtendTypes <em>Xtend Types</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XModule#getPackage <em>Package</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XModule#getContents <em>Contents</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XModule#getExportSection <em>Export Section</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.ss.SsPackage#getXModule()
 * @model
 * @generated
 */
public interface XModule extends JvmType {
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
	 * @see org.summer.dsl.model.ss.SsPackage#getXModule_ImportSection()
	 * @model containment="true"
	 * @generated
	 */
	XImportSection1 getImportSection();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XModule#getImportSection <em>Import Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Section</em>' containment reference.
	 * @see #getImportSection()
	 * @generated
	 */
	void setImportSection(XImportSection1 value);

	/**
	 * Returns the value of the '<em><b>Xtend Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.ss.XtendTypeDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xtend Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xtend Types</em>' containment reference list.
	 * @see org.summer.dsl.model.ss.SsPackage#getXModule_XtendTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<XtendTypeDeclaration> getXtendTypes();

	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see org.summer.dsl.model.ss.SsPackage#getXModule_Package()
	 * @model
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XModule#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

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
	 * @see org.summer.dsl.model.ss.SsPackage#getXModule_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getContents();

	/**
	 * Returns the value of the '<em><b>Export Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Section</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Section</em>' containment reference.
	 * @see #setExportSection(XExportSection)
	 * @see org.summer.dsl.model.ss.SsPackage#getXModule_ExportSection()
	 * @model containment="true"
	 * @generated
	 */
	XExportSection getExportSection();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XModule#getExportSection <em>Export Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Section</em>' containment reference.
	 * @see #getExportSection()
	 * @generated
	 */
	void setExportSection(XExportSection value);

} // XtendFile
