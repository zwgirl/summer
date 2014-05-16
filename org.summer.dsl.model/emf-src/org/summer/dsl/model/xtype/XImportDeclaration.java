/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmModule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImport Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration#getImportItems <em>Import Items</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration#isWildcard <em>Wildcard</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration#getModule <em>Module</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration()
 * @model
 * @generated
 */
public interface XImportDeclaration extends JvmIdentifiableElement {
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
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration_ImportItems()
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
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportDeclaration#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wildcard</em>' attribute.
	 * @see #setWildcard(boolean)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration_Wildcard()
	 * @model default="false"
	 * @generated
	 */
	boolean isWildcard();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportDeclaration#isWildcard <em>Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wildcard</em>' attribute.
	 * @see #isWildcard()
	 * @generated
	 */
	void setWildcard(boolean value);

	/**
	 * Returns the value of the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' reference.
	 * @see #setModule(JvmModule)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration_Module()
	 * @model
	 * @generated
	 */
	JvmModule getModule();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportDeclaration#getModule <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(JvmModule value);

	/**
	 * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Namespace</em>' attribute.
	 * @see #setImportedNamespace(String)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportDeclaration_ImportedNamespace()
	 * @model
	 * @generated
	 */
	String getImportedNamespace();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Namespace</em>' attribute.
	 * @see #getImportedNamespace()
	 * @generated
	 */
	void setImportedNamespace(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getModuleName();

} // XImportDeclaration
