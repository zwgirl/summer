/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Enum Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmEnumAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmEnumAnnotationValue()
 * @model
 * @generated
 */
public interface JvmEnumAnnotationValue extends JvmAnnotationValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmEnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmEnumAnnotationValue_Values()
	 * @model
	 * @generated
	 */
	EList<JvmEnumerationLiteral> getValues();

} // JvmEnumAnnotationValue
