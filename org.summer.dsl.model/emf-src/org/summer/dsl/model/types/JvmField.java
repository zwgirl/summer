/**
 */
package org.summer.dsl.model.types;

import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmField#isStatic <em>Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#isConst <em>Const</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#isVirtaul <em>Virtaul</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#isOverride <em>Override</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#getSet <em>Set</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmField#getGet <em>Get</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmField()
 * @model
 * @generated
 */
public interface JvmField extends JvmFeature {
	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const</em>' attribute.
	 * @see #setConst(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Const()
	 * @model
	 * @generated
	 */
	boolean isConst();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#isConst <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' attribute.
	 * @see #isConst()
	 * @generated
	 */
	void setConst(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(JvmTypeReference)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Type()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient</em>' attribute.
	 * @see #setTransient(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Transient()
	 * @model
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#isTransient <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Virtaul</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtaul</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtaul</em>' attribute.
	 * @see #setVirtaul(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Virtaul()
	 * @model
	 * @generated
	 */
	boolean isVirtaul();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#isVirtaul <em>Virtaul</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtaul</em>' attribute.
	 * @see #isVirtaul()
	 * @generated
	 */
	void setVirtaul(boolean value);

	/**
	 * Returns the value of the '<em><b>Override</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Override</em>' attribute.
	 * @see #setOverride(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Override()
	 * @model default="false"
	 * @generated
	 */
	boolean isOverride();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#isOverride <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override</em>' attribute.
	 * @see #isOverride()
	 * @generated
	 */
	void setOverride(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the default value for the annotation member represented by this JvmOperation instance.</p>
	 * <p>Returns null if no default is associated with the member, or if the operation does not represent a declared member of an annotation type.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(XExpression)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDefaultValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set</em>' containment reference.
	 * @see #setSet(XStatment)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Set()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getSet();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#getSet <em>Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set</em>' containment reference.
	 * @see #getSet()
	 * @generated
	 */
	void setSet(XStatment value);

	/**
	 * Returns the value of the '<em><b>Get</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get</em>' containment reference.
	 * @see #setGet(XStatment)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmField_Get()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getGet();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmField#getGet <em>Get</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get</em>' containment reference.
	 * @see #getGet()
	 * @generated
	 */
	void setGet(XStatment value);

} // JvmField
