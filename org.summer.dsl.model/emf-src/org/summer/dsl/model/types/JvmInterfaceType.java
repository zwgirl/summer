/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Interface Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmInterfaceType#getImplements <em>Implements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmInterfaceType()
 * @model
 * @generated
 */
public interface JvmInterfaceType extends JvmDeclaredType, JvmTypeParameterDeclarator {
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
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmInterfaceType_Implements()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmParameterizedTypeReference> getImplements();

} // JvmInterfaceType
