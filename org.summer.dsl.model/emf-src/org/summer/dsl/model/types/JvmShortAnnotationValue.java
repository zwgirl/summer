/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Short Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmShortAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmShortAnnotationValue()
 * @model
 * @generated
 */
public interface JvmShortAnnotationValue extends JvmAnnotationValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Short}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmShortAnnotationValue_Values()
	 * @model unique="false"
	 * @generated
	 */
	EList<Short> getValues();

} // JvmShortAnnotationValue
