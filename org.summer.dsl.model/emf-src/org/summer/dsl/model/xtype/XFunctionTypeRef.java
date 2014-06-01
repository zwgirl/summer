/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFunction Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xtype.XFunctionTypeRef#isInstanceContext <em>Instance Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xtype.XtypePackage#getXFunctionTypeRef()
 * @model
 * @generated
 */
public interface XFunctionTypeRef extends JvmTypeReference {
	/**
	 * Returns the value of the '<em><b>Param Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Types</em>' containment reference list.
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXFunctionTypeRef_ParamTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getParamTypes();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXFunctionTypeRef_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmType)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXFunctionTypeRef_Type()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

	/**
	 * Returns the value of the '<em><b>Instance Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Context</em>' attribute.
	 * @see #setInstanceContext(boolean)
	 * @see org.summer.dsl.model.xtype.XtypePackage#getXFunctionTypeRef_InstanceContext()
	 * @model
	 * @generated
	 */
	boolean isInstanceContext();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xtype.XFunctionTypeRef#isInstanceContext <em>Instance Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Context</em>' attribute.
	 * @see #isInstanceContext()
	 * @generated
	 */
	void setInstanceContext(boolean value);

} // XFunctionTypeRef
