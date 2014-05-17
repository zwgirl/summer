/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.xaml.XObjectElement;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmModule#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmModule#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmModule#getContents <em>Contents</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmModule#getExportSection <em>Export Section</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmModule#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmModule()
 * @model
 * @generated
 */
public interface JvmModule extends JvmType {
	/**
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmModule_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmModule#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Import Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Section</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Section</em>' containment reference.
	 * @see #setImportSection(XImportSection)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmModule_ImportSection()
	 * @model containment="true"
	 * @generated
	 */
	XImportSection getImportSection();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmModule#getImportSection <em>Import Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Section</em>' containment reference.
	 * @see #getImportSection()
	 * @generated
	 */
	void setImportSection(XImportSection value);

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
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmModule_Contents()
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
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmModule_ExportSection()
	 * @model containment="true"
	 * @generated
	 */
	XExportSection getExportSection();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmModule#getExportSection <em>Export Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Section</em>' containment reference.
	 * @see #getExportSection()
	 * @generated
	 */
	void setExportSection(XExportSection value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(XObjectElement)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmModule_Root()
	 * @model containment="true"
	 * @generated
	 */
	XObjectElement getRoot();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmModule#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(XObjectElement value);

	Iterable<JvmDeclaredType> getJvmDeclaredTypes();
	
	String getModuleName();

} // JvmModule
