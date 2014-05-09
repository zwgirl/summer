/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Struct Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmStructType#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmStructType#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmStructType()
 * @model
 * @generated
 */
public interface JvmStructType extends JvmDeclaredType, JvmTypeParameterDeclarator {

	/**
	 * Returns the value of the '<em><b>Implements</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmParameterizedTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' containment reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmStructType_Implements()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmParameterizedTypeReference> getImplements();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmStructType_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmFormalParameter> getParameters();
} // JvmStructType
