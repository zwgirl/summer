/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFeature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XFeatureCall#getFeatureCallArguments <em>Feature Call Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFeatureCall#isTypeLiteral <em>Type Literal</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFeatureCall#isPackageFragment <em>Package Fragment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFeatureCall#isIndexedOperation <em>Indexed Operation</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFeatureCall#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXFeatureCall()
 * @model
 * @generated
 */
public interface XFeatureCall extends XAbstractFeatureCall {
	/**
	 * Returns the value of the '<em><b>Feature Call Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Call Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Call Arguments</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFeatureCall_FeatureCallArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getFeatureCallArguments();

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFeatureCall_ExplicitOperationCall()
	 * @model
	 * @generated
	 */
	boolean isExplicitOperationCall();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #isExplicitOperationCall()
	 * @generated
	 */
	void setExplicitOperationCall(boolean value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFeatureCall_TypeLiteral()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isTypeLiteral();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFeatureCall#isTypeLiteral <em>Type Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Literal</em>' attribute.
	 * @see #isTypeLiteral()
	 * @generated
	 */
	void setTypeLiteral(boolean value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFeatureCall_PackageFragment()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	boolean isPackageFragment();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFeatureCall#isPackageFragment <em>Package Fragment</em>}' attribute.
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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFeatureCall_IndexedOperation()
	 * @model default="false"
	 * @generated
	 */
	boolean isIndexedOperation();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFeatureCall#isIndexedOperation <em>Indexed Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indexed Operation</em>' attribute.
	 * @see #isIndexedOperation()
	 * @generated
	 */
	void setIndexedOperation(boolean value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFeatureCall_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFeatureCall#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

} // XFeatureCall
