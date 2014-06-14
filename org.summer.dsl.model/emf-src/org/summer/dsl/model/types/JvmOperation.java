/**
 */
package org.summer.dsl.model.types;

import org.summer.dsl.model.xbase.XStatment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isStatic <em>Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isVirtaul <em>Virtaul</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isOverride <em>Override</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isNative <em>Native</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isOverload <em>Overload</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#getBody <em>Body</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmOperation#isOperator <em>Operator</em>}</li>
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
	 * Returns the value of the '<em><b>Virtaul</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtaul</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtaul</em>' attribute.
	 * @see #setVirtaul(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Virtaul()
	 * @model
	 * @generated
	 */
	boolean isVirtaul();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isVirtaul <em>Virtaul</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtaul</em>' attribute.
	 * @see #isVirtaul()
	 * @generated
	 */
	void setVirtaul(boolean value);

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

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(XStatment)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Body()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getBody();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(XStatment value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmOperation_Operator()
	 * @model default="false"
	 * @generated
	 */
	boolean isOperator();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmOperation#isOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #isOperator()
	 * @generated
	 */
	void setOperator(boolean value);

} // JvmOperation
