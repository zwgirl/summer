/**
 */
package org.summer.dsl.builder.builderState;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.builder.builderState.ReferenceDescription#getExternalFormOfEReference <em>External Form Of EReference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.builder.builderState.BuilderStatePackage#getReferenceDescription()
 * @model superTypes="org.summer.dsl.builder.builderState.IReferenceDescription"
 * @generated
 */
public interface ReferenceDescription extends EObject, IReferenceDescription {
	/**
	 * Returns the value of the '<em><b>External Form Of EReference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Form Of EReference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Form Of EReference</em>' attribute.
	 * @see #setExternalFormOfEReference(String)
	 * @see org.summer.dsl.builder.builderState.BuilderStatePackage#getReferenceDescription_ExternalFormOfEReference()
	 * @model
	 * @generated
	 */
	String getExternalFormOfEReference();

	/**
	 * Sets the value of the '{@link org.summer.dsl.builder.builderState.ReferenceDescription#getExternalFormOfEReference <em>External Form Of EReference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Form Of EReference</em>' attribute.
	 * @see #getExternalFormOfEReference()
	 * @generated
	 */
	void setExternalFormOfEReference(String value);

} // ReferenceDescription
