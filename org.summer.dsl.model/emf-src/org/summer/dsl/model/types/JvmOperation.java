/**
 */
package org.summer.dsl.model.types;

import org.summer.dsl.model.xbase.XExpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isStatic <em>Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isFinal <em>Final</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isSynchronized <em>Synchronized</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isDefault <em>Default</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isNative <em>Native</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isStrictFloatingPoint <em>Strict Floating Point</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#getFunction <em>Function</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isOverload <em>Overload</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isOverride <em>Override</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation()
 * @model
 * @generated
 */
public interface JvmOperation extends JvmExecutable {
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
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Final()
	 * @model
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the default value for the annotation member represented by this JvmOperation instance.</p>
	 * <p>Returns null if no default is associated with the member, or if the operation does not represent a declared member of an annotation type.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(JvmAnnotationValue)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	JvmAnnotationValue getDefaultValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(JvmAnnotationValue value);

	/**
	 * Returns the value of the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronized</em>' attribute.
	 * @see #setSynchronized(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Synchronized()
	 * @model
	 * @generated
	 */
	boolean isSynchronized();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isSynchronized <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronized</em>' attribute.
	 * @see #isSynchronized()
	 * @generated
	 */
	void setSynchronized(boolean value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Default()
	 * @model
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native</em>' attribute.
	 * @see #setNative(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Native()
	 * @model
	 * @generated
	 */
	boolean isNative();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isNative <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 */
	void setNative(boolean value);

	/**
	 * Returns the value of the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict Floating Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #setStrictFloatingPoint(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_StrictFloatingPoint()
	 * @model
	 * @generated
	 */
	boolean isStrictFloatingPoint();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isStrictFloatingPoint <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #isStrictFloatingPoint()
	 * @generated
	 */
	void setStrictFloatingPoint(boolean value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference.
	 * @see #setFunction(XExpression)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Function()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getFunction();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#getFunction <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' containment reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(XExpression value);

	/**
	 * Returns the value of the '<em><b>Overload</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overload</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overload</em>' attribute.
	 * @see #setOverload(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Overload()
	 * @model default="false"
	 * @generated
	 */
	boolean isOverload();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isOverload <em>Overload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overload</em>' attribute.
	 * @see #isOverload()
	 * @generated
	 */
	void setOverload(boolean value);

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
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Override()
	 * @model default="false"
	 * @generated
	 */
	boolean isOverride();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isOverride <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override</em>' attribute.
	 * @see #isOverride()
	 * @generated
	 */
	void setOverride(boolean value);

} // JvmOperation
