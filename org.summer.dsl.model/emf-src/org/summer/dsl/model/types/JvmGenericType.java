/**
 */
package org.summer.dsl.model.types;

import java.lang.Iterable;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Generic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmGenericType#isInterface <em>Interface</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmGenericType#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmGenericType#getImplements <em>Implements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmGenericType()
 * @model
 * @generated
 */
public interface JvmGenericType extends JvmDeclaredType, JvmTypeParameterDeclarator {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmGenericType_Interface()
	 * @model
	 * @generated
	 */
	boolean isInterface();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmGenericType#isInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #isInterface()
	 * @generated
	 */
	void setInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict Floating Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #setStrictFloatingPoint(boolean)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmGenericType_StrictFloatingPoint()
	 * @model
	 * @generated
	 */
	boolean isStrictFloatingPoint();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #isStrictFloatingPoint()
	 * @generated
	 */
	void setStrictFloatingPoint(boolean value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference.
	 * @see #setExtends(JvmParameterizedTypeReference)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmGenericType_Extends()
	 * @model containment="true"
	 * @generated
	 */
	JvmParameterizedTypeReference getExtends();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmGenericType#getExtends <em>Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' containment reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(JvmParameterizedTypeReference value);

	/**
	 * Returns the value of the '<em><b>Implements</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmParameterizedTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' containment reference list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmGenericType_Implements()
	 * @model containment="true"
	 * @generated NOT
	 */
	List<JvmParameterizedTypeReference> getImplements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.summer.dsl.model.types.Iterable<org.summer.dsl.model.types.JvmTypeReference>"
	 * @generated
	 */
	Iterable<JvmTypeReference> getExtendedInterfaces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmTypeReference getExtendedClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isInstantiateable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.summer.dsl.model.types.List<org.summer.dsl.model.types.JvmConstructor>" required="true" many="false"
	 * @generated
	 */
	List<JvmConstructor> getDeclaredConstructors();

} // JvmGenericType
