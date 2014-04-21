/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XExport Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XExportDeclaration#getExportItems <em>Export Items</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XExportDeclaration#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XExportDeclaration#isWildcard <em>Wildcard</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XExportDeclaration#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXExportDeclaration()
 * @model
 * @generated
 */
public interface XExportDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Export Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xtype.XExportItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Items</em>' containment reference list.
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXExportDeclaration_ExportItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExportItem> getExportItems();

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXExportDeclaration_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XExportDeclaration#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wildcard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wildcard</em>' attribute.
	 * @see #setWildcard(boolean)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXExportDeclaration_Wildcard()
	 * @model
	 * @generated
	 */
	boolean isWildcard();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XExportDeclaration#isWildcard <em>Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wildcard</em>' attribute.
	 * @see #isWildcard()
	 * @generated
	 */
	void setWildcard(boolean value);

	/**
	 * Returns the value of the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import URI</em>' attribute.
	 * @see #setImportURI(String)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXExportDeclaration_ImportURI()
	 * @model
	 * @generated
	 */
	String getImportURI();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XExportDeclaration#getImportURI <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import URI</em>' attribute.
	 * @see #getImportURI()
	 * @generated
	 */
	void setImportURI(String value);

} // XExportDeclaration
