/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Constraint Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmConstraintOwner#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmConstraintOwner()
 * @model abstract="true"
 * @generated
 */
public interface JvmConstraintOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmTypeConstraint}.
	 * It is bidirectional and its opposite is '{@link org.summer.dsl.model.types.JvmTypeConstraint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmConstraintOwner_Constraints()
	 * @see org.summer.dsl.model.types.JvmTypeConstraint#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<JvmTypeConstraint> getConstraints();

} // JvmConstraintOwner
