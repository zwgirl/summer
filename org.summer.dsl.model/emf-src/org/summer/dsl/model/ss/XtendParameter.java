/**
 */
package org.summer.dsl.model.ss;

import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.ss.XtendParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XtendParameter#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XtendParameter#isVarArg <em>Var Arg</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XtendParameter#isExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.ss.SsPackage#getXtendParameter()
 * @model
 * @generated
 */
public interface XtendParameter extends XtendAnnotationTarget {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XtendParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendParameter_ParameterType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getParameterType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XtendParameter#getParameterType <em>Parameter Type</em>}' containment reference.
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
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendParameter_VarArg()
	 * @model
	 * @generated
	 */
	boolean isVarArg();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XtendParameter#isVarArg <em>Var Arg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Arg</em>' attribute.
	 * @see #isVarArg()
	 * @generated
	 */
	void setVarArg(boolean value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(boolean)
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendParameter_Extension()
	 * @model
	 * @generated
	 */
	boolean isExtension();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XtendParameter#isExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #isExtension()
	 * @generated
	 */
	void setExtension(boolean value);

} // XtendParameter
