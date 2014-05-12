/**
 */
package org.summer.dsl.model.types;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmEvent#isStatic <em>Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmEvent#isNative <em>Native</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmEvent#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmEvent#getAdd <em>Add</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmEvent#getRemove <em>Remove</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmEvent()
 * @model
 * @generated
 */
public interface JvmEvent extends JvmFeature {
	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmEvent_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmEvent#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native</em>' attribute.
	 * @see #setNative(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmEvent_Native()
	 * @model
	 * @generated
	 */
	boolean isNative();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmEvent#isNative <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 */
	void setNative(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(JvmTypeReference)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmEvent_Type()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmEvent#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Add</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add</em>' containment reference.
	 * @see #setAdd(XExpression)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmEvent_Add()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getAdd();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmEvent#getAdd <em>Add</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add</em>' containment reference.
	 * @see #getAdd()
	 * @generated
	 */
	void setAdd(XExpression value);

	/**
	 * Returns the value of the '<em><b>Remove</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove</em>' containment reference.
	 * @see #setRemove(XExpression)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmEvent_Remove()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getRemove();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmEvent#getRemove <em>Remove</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove</em>' containment reference.
	 * @see #getRemove()
	 * @generated
	 */
	void setRemove(XExpression value);

} // JvmEvent
