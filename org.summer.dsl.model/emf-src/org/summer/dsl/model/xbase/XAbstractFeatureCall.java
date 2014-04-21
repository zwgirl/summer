/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;

import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAbstract Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#isValidFeature <em>Valid Feature</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitFirstArgument <em>Implicit First Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractFeatureCall()
 * @model abstract="true"
 * @generated
 */
public interface XAbstractFeatureCall extends XExpression {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(JvmIdentifiableElement)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractFeatureCall_Feature()
	 * @model
	 * @generated
	 */
	JvmIdentifiableElement getFeature();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(JvmIdentifiableElement value);

	/**
	 * Returns the value of the '<em><b>Type Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arguments</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractFeatureCall_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getTypeArguments();

	/**
	 * Returns the value of the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the implicit receiver of the feature call if any. Otherwise <code>null</code>.
	 * May not be used during linking.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implicit Receiver</em>' containment reference.
	 * @see #setImplicitReceiver(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractFeatureCall_ImplicitReceiver()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	XExpression getImplicitReceiver();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit Receiver</em>' containment reference.
	 * @see #getImplicitReceiver()
	 * @generated
	 */
	void setImplicitReceiver(XExpression value);

	/**
	 * Returns the value of the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @deprecated Will be removed shortly
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #setInvalidFeatureIssueCode(String)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractFeatureCall_InvalidFeatureIssueCode()
	 * @model transient="true"
	 * @generated
	 */
	String getInvalidFeatureIssueCode();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 */
	void setInvalidFeatureIssueCode(String value);

	/**
	 * Returns the value of the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @deprecated Will be removed shortly
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Valid Feature</em>' attribute.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractFeatureCall_ValidFeature()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	boolean isValidFeature();

	/**
	 * Returns the value of the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the implicit first argument of the feature call if any. Otherwise <code>null</code>.
	 * May not be used during linking.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implicit First Argument</em>' containment reference.
	 * @see #setImplicitFirstArgument(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractFeatureCall_ImplicitFirstArgument()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	XExpression getImplicitFirstArgument();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitFirstArgument <em>Implicit First Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit First Argument</em>' containment reference.
	 * @see #getImplicitFirstArgument()
	 * @generated
	 */
	void setImplicitFirstArgument(XExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getConcreteSyntaxFeatureName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @deprecated Will be removed shortly
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<XExpression> getExplicitArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isExplicitOperationCallOrBuilderSyntax();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the actual receiver of the feature call. The decision will be made according
	 * to the linking of the feature. May not be used during linking itself.
	 * <p/>
	 * <p>Static features, constructor calls (this, super), references to local variables 
	 * or parameters will return <code>null</code>.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	XExpression getActualReceiver();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the actual arguments of the feature call. The decision will be made according
	 * to the linking of the feature. May not be used during linking itself.
	 * <p/>
	 * <p>References to local variables, fields 
	 * or parameters will return an empty list. The result is never <code>null</code>.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<XExpression> getActualArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns <code>true</code> if the featuer call links to a static field or a static 
	 * operation. Otherwise <code>false</code>. May not be used during linking.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns <code>true</code> if the feature was made available by an extension. 
	 * Otherwise <code>false</code>. May not be used during linking.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isExtension();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isPackageFragment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isTypeLiteral();

} // XAbstractFeatureCall
