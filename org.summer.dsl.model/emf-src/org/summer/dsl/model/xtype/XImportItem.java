/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImport Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XImportItem#getImportedId <em>Imported Id</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XImportItem#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportItem()
 * @model
 * @generated
 */
public interface XImportItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Imported Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Id</em>' reference.
	 * @see #setImportedId(JvmIdentifiableElement)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportItem_ImportedId()
	 * @model
	 * @generated
	 */
	JvmIdentifiableElement getImportedId();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportItem#getImportedId <em>Imported Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Id</em>' reference.
	 * @see #getImportedId()
	 * @generated
	 */
	void setImportedId(JvmIdentifiableElement value);

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
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXImportItem_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XImportItem#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

} // XImportItem
