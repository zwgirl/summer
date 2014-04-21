/**
 */
package org.summer.dsl.model.ss;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.xannotation.XAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Annotation Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.ss.XtendAnnotationTarget#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.ss.SsPackage#getXtendAnnotationTarget()
 * @model abstract="true"
 * @generated
 */
public interface XtendAnnotationTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xannotation.XAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendAnnotationTarget_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<XAnnotation> getAnnotations();

} // XtendAnnotationTarget
