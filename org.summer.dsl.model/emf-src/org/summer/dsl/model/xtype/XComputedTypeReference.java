/**
 */
package org.summer.dsl.model.xtype;

import org.summer.dsl.model.types.JvmSpecializedTypeReference;
import org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XComputed Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XComputedTypeReference#getTypeProvider <em>Type Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXComputedTypeReference()
 * @model
 * @generated
 */
public interface XComputedTypeReference extends JvmSpecializedTypeReference {
	/**
	 * Returns the value of the '<em><b>Type Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Provider</em>' attribute.
	 * @see #setTypeProvider(IJvmTypeReferenceProvider)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXComputedTypeReference_TypeProvider()
	 * @model dataType="org.summer.dsl.model.xtype.IJvmTypeReferenceProvider" transient="true"
	 * @generated
	 */
	IJvmTypeReferenceProvider getTypeProvider();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XComputedTypeReference#getTypeProvider <em>Type Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Provider</em>' attribute.
	 * @see #getTypeProvider()
	 * @generated
	 */
	void setTypeProvider(IJvmTypeReferenceProvider value);

} // XComputedTypeReference
