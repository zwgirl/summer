/**
 */
package org.summer.dsl.model.xaml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XElement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xaml.XElement#getContents <em>Contents</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.XElement#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.XElement#getCloseType <em>Close Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.XElement#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xaml.XamlPackage#getXElement()
 * @model
 * @generated
 */
public interface XElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xaml.XElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXElement_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<XElement> getContents();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmType)
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXElement_Type()
	 * @model
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xaml.XElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

	/**
	 * Returns the value of the '<em><b>Close Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Close Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Close Type</em>' reference.
	 * @see #setCloseType(JvmType)
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXElement_CloseType()
	 * @model
	 * @generated
	 */
	JvmType getCloseType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xaml.XElement#getCloseType <em>Close Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Close Type</em>' reference.
	 * @see #getCloseType()
	 * @generated
	 */
	void setCloseType(JvmType value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xaml.XAbstractAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXElement_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<XAbstractAttribute> getProperties();

} // XElement
