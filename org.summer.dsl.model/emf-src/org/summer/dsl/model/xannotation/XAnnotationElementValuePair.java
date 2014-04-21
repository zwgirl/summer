/**
 */
package org.summer.dsl.model.xannotation;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.types.JvmOperation;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAnnotation Element Value Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getValue <em>Value</em>}</li>
 *   <li>{@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xannotation.XannotationPackage#getXAnnotationElementValuePair()
 * @model
 * @generated
 */
public interface XAnnotationElementValuePair extends EObject {
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
	 * @see org.summer.dsl.model.xannotation.XannotationPackage#getXAnnotationElementValuePair_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(JvmOperation)
	 * @see org.summer.dsl.model.xannotation.XannotationPackage#getXAnnotationElementValuePair_Element()
	 * @model
	 * @generated
	 */
	JvmOperation getElement();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(JvmOperation value);

} // XAnnotationElementValuePair
