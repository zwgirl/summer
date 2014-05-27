/**
 */
package org.summer.dsl.model.xaml;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAbstract Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xaml.XAbstractAttribute#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.XAbstractAttribute#getField <em>Field</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.XAbstractAttribute#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xaml.XamlPackage#getXAbstractAttribute()
 * @model
 * @generated
 */
public interface XAbstractAttribute extends EObject {
	/**
	 * Returns the value of the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' reference.
	 * @see #setField(JvmField)
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXAbstractAttribute_Field()
	 * @model
	 * @generated
	 */
	JvmField getField();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xaml.XAbstractAttribute#getField <em>Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' reference.
	 * @see #getField()
	 * @generated
	 */
	void setField(JvmField value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXAbstractAttribute_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xaml.XAbstractAttribute#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

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
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXAbstractAttribute_Type()
	 * @model
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xaml.XAbstractAttribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

} // XAbstractAttribute
