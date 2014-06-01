/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMember Feature Call1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#getMemberCallTarget <em>Member Call Target</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#getMemberCallArguments <em>Member Call Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#isExplicitStatic <em>Explicit Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#isNullSafe <em>Null Safe</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#isTypeLiteral <em>Type Literal</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#isStaticWithDeclaringType <em>Static With Declaring Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#isPackageFragment <em>Package Fragment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIndexerCall#isIndexedOperation <em>Indexed Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1()
 * @model
 * @generated
 */
public interface XIndexerCall extends XExpression {
	/**
	 * Returns the value of the '<em><b>Member Call Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Call Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Call Target</em>' containment reference.
	 * @see #setMemberCallTarget(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_MemberCallTarget()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getMemberCallTarget();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#getMemberCallTarget <em>Member Call Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Call Target</em>' containment reference.
	 * @see #getMemberCallTarget()
	 * @generated
	 */
	void setMemberCallTarget(XExpression value);

	/**
	 * Returns the value of the '<em><b>Member Call Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Call Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Call Arguments</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_MemberCallArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getMemberCallArguments();

	/**
	 * Returns the value of the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Operation Call</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #setExplicitOperationCall(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_ExplicitOperationCall()
	 * @model
	 * @generated
	 */
	boolean isExplicitOperationCall();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#isExplicitOperationCall <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #isExplicitOperationCall()
	 * @generated
	 */
	void setExplicitOperationCall(boolean value);

	/**
	 * Returns the value of the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Static</em>' attribute.
	 * @see #setExplicitStatic(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_ExplicitStatic()
	 * @model
	 * @generated
	 */
	boolean isExplicitStatic();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#isExplicitStatic <em>Explicit Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Static</em>' attribute.
	 * @see #isExplicitStatic()
	 * @generated
	 */
	void setExplicitStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Null Safe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Null Safe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Null Safe</em>' attribute.
	 * @see #setNullSafe(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_NullSafe()
	 * @model
	 * @generated
	 */
	boolean isNullSafe();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#isNullSafe <em>Null Safe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Safe</em>' attribute.
	 * @see #isNullSafe()
	 * @generated
	 */
	void setNullSafe(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Literal</em>' attribute.
	 * @see #setTypeLiteral(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_TypeLiteral()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isTypeLiteral();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#isTypeLiteral <em>Type Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Literal</em>' attribute.
	 * @see #isTypeLiteral()
	 * @generated
	 */
	void setTypeLiteral(boolean value);

	/**
	 * Returns the value of the '<em><b>Static With Declaring Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static With Declaring Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static With Declaring Type</em>' attribute.
	 * @see #setStaticWithDeclaringType(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_StaticWithDeclaringType()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isStaticWithDeclaringType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#isStaticWithDeclaringType <em>Static With Declaring Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static With Declaring Type</em>' attribute.
	 * @see #isStaticWithDeclaringType()
	 * @generated
	 */
	void setStaticWithDeclaringType(boolean value);

	/**
	 * Returns the value of the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Fragment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Fragment</em>' attribute.
	 * @see #setPackageFragment(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_PackageFragment()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isPackageFragment();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#isPackageFragment <em>Package Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Fragment</em>' attribute.
	 * @see #isPackageFragment()
	 * @generated
	 */
	void setPackageFragment(boolean value);

	/**
	 * Returns the value of the '<em><b>Indexed Operation</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexed Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexed Operation</em>' attribute.
	 * @see #setIndexedOperation(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXMemberFeatureCall1_IndexedOperation()
	 * @model default="false"
	 * @generated
	 */
	boolean isIndexedOperation();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIndexerCall#isIndexedOperation <em>Indexed Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indexed Operation</em>' attribute.
	 * @see #isIndexedOperation()
	 * @generated
	 */
	void setIndexedOperation(boolean value);

} // XMemberFeatureCall1
