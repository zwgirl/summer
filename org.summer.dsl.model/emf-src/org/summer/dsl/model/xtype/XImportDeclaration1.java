/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImport Declaration1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration1#getImportItems <em>Import Items</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration1#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration1#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration1()
 * @model
 * @generated
 */
public interface XImportDeclaration1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Import Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xtype.XImportItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Items</em>' containment reference list.
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration1_ImportItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<XImportItem> getImportItems();

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
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration1_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportDeclaration1#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

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
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration1_ImportURI()
	 * @model
	 * @generated
	 */
	String getImportURI();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportDeclaration1#getImportURI <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import URI</em>' attribute.
	 * @see #getImportURI()
	 * @generated
	 */
	void setImportURI(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isWildcard();

} // XImportDeclaration1
