/**
 */
package org.summer.dsl.model.xannotation;

import org.eclipse.emf.common.util.EList;

import org.summer.dsl.model.types.JvmType;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xannotation.XAnnotation#getElementValuePairs <em>Element Value Pairs</em>}</li>
 *   <li>{@link org.summer.dsl.model.xannotation.XAnnotation#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xannotation.XAnnotation#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xannotation.XannotationPackage#getXAnnotation()
 * @model
 * @generated
 */
public interface XAnnotation extends XExpression {
	/**
	 * Returns the value of the '<em><b>Element Value Pairs</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Value Pairs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Value Pairs</em>' containment reference list.
	 * @see org.summer.dsl.model.xannotation.XannotationPackage#getXAnnotation_ElementValuePairs()
	 * @model containment="true"
	 * @generated
	 */
	EList<XAnnotationElementValuePair> getElementValuePairs();

	/**
	 * Returns the value of the '<em><b>Annotation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Type</em>' reference.
	 * @see #setAnnotationType(JvmType)
	 * @see org.summer.dsl.model.xannotation.XannotationPackage#getXAnnotation_AnnotationType()
	 * @model
	 * @generated
	 */
	JvmType getAnnotationType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xannotation.XAnnotation#getAnnotationType <em>Annotation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Type</em>' reference.
	 * @see #getAnnotationType()
	 * @generated
	 */
	void setAnnotationType(JvmType value);

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
	 * @see org.summer.dsl.model.xannotation.XannotationPackage#getXAnnotation_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xannotation.XAnnotation#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

} // XAnnotation
