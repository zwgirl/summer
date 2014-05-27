/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Annotation Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmAnnotationReference#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmAnnotationReference#getValues <em>Values</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmAnnotationReference#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmAnnotationReference()
 * @model
 * @generated
 */
public interface JvmAnnotationReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' reference.
	 * @see #setAnnotation(JvmAnnotationType)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmAnnotationReference_Annotation()
	 * @model
	 * @generated
	 */
	JvmAnnotationType getAnnotation();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmAnnotationReference#getAnnotation <em>Annotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' reference.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(JvmAnnotationType value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmAnnotationValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmAnnotationReference_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmAnnotationValue> getValues();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmAnnotationReference_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmAnnotationReference#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

} // JvmAnnotationReference
