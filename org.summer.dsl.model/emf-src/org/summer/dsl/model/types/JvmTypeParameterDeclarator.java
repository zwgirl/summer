/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Type Parameter Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmTypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmTypeParameterDeclarator()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeParameterDeclarator extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmTypeParameter}.
	 * It is bidirectional and its opposite is '{@link org.summer.dsl.model.types.JvmTypeParameter#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameters</em>' containment reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmTypeParameterDeclarator_TypeParameters()
	 * @see org.summer.dsl.model.types.JvmTypeParameter#getDeclarator
	 * @model opposite="declarator" containment="true"
	 * @generated
	 */
	EList<JvmTypeParameter> getTypeParameters();

} // JvmTypeParameterDeclarator
