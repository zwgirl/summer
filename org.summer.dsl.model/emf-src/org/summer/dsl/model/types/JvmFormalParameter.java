/**
 */
package org.summer.dsl.model.types;

import org.summer.dsl.model.xbase.XExpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmFormalParameter#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmFormalParameter#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmFormalParameter#isVarArg <em>Var Arg</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmFormalParameter#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmFormalParameter#isRef <em>Ref</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmFormalParameter#isOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmFormalParameter()
 * @model
 * @generated
 */
public interface JvmFormalParameter extends JvmAnnotationTarget {
	/**
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmFormalParameter_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmFormalParameter#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Type</em>' containment reference.
	 * @see #setParameterType(JvmTypeReference)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmFormalParameter_ParameterType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getParameterType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmFormalParameter#getParameterType <em>Parameter Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Type</em>' containment reference.
	 * @see #getParameterType()
	 * @generated
	 */
	void setParameterType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Var Arg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Arg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Arg</em>' attribute.
	 * @see #setVarArg(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmFormalParameter_VarArg()
	 * @model
	 * @generated
	 */
	boolean isVarArg();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmFormalParameter#isVarArg <em>Var Arg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Arg</em>' attribute.
	 * @see #isVarArg()
	 * @generated
	 */
	void setVarArg(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(XExpression)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmFormalParameter_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDefaultValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmFormalParameter#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmFormalParameter_Ref()
	 * @model default="false"
	 * @generated
	 */
	boolean isRef();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmFormalParameter#isRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #isRef()
	 * @generated
	 */
	void setRef(boolean value);

	/**
	 * Returns the value of the '<em><b>Out</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' attribute.
	 * @see #setOut(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmFormalParameter_Out()
	 * @model default="false"
	 * @generated
	 */
	boolean isOut();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmFormalParameter#isOut <em>Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out</em>' attribute.
	 * @see #isOut()
	 * @generated
	 */
	void setOut(boolean value);

} // JvmFormalParameter
