/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xbase.XbaseFactory
 * @model kind="package"
 * @generated
 */
public interface XbasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xbase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.summer.org/dsl/model/xbase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xbase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XbasePackage eINSTANCE = org.summer.dsl.model.xbase.impl.XbasePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XExpressionImpl <em>XExpression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXExpression()
	 * @generated
	 */
	int XEXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>XExpression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XIfExpressionImpl <em>XIf Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XIfExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXIfExpression()
	 * @generated
	 */
	int XIF_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION__IF = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION__THEN = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION__ELSE = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XIf Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XSwitchExpressionImpl <em>XSwitch Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XSwitchExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXSwitchExpression()
	 * @generated
	 */
	int XSWITCH_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__SWITCH = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__CASES = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__DEFAULT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__LOCAL_VAR_NAME = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XSwitch Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XCasePartImpl <em>XCase Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XCasePartImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCasePart()
	 * @generated
	 */
	int XCASE_PART = 3;

	/**
	 * The feature id for the '<em><b>Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART__CASE = 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART__THEN = 1;

	/**
	 * The feature id for the '<em><b>Type Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART__TYPE_GUARD = 2;

	/**
	 * The number of structural features of the '<em>XCase Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XBlockExpressionImpl <em>XBlock Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XBlockExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBlockExpression()
	 * @generated
	 */
	int XBLOCK_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBLOCK_EXPRESSION__EXPRESSIONS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XBlock Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBLOCK_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XVariableDeclarationImpl <em>XVariable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XVariableDeclarationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXVariableDeclaration()
	 * @generated
	 */
	int XVARIABLE_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION__NAME = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION__RIGHT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XVariable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XVariableDeclarationListImpl <em>XVariable Declaration List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XVariableDeclarationListImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXVariableDeclarationList()
	 * @generated
	 */
	int XVARIABLE_DECLARATION_LIST = 6;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION_LIST__DECLARATIONS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Writeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION_LIST__WRITEABLE = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION_LIST__EXPORTED = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XVariable Declaration List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION_LIST_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl <em>XAbstract Feature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXAbstractFeatureCall()
	 * @generated
	 */
	int XABSTRACT_FEATURE_CALL = 7;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__FEATURE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__VALID_FEATURE = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = XEXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>XAbstract Feature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XMemberFeatureCallImpl <em>XMember Feature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XMemberFeatureCallImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXMemberFeatureCall()
	 * @generated
	 */
	int XMEMBER_FEATURE_CALL = 8;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Member Call Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member Call Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__EXPLICIT_STATIC = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Null Safe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__NULL_SAFE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__TYPE_LITERAL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Static With Declaring Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__STATIC_WITH_DECLARING_TYPE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__PACKAGE_FRAGMENT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Indexed Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__INDEXED_OPERATION = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>XMember Feature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XMemberFeatureCall1Impl <em>XMember Feature Call1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XMemberFeatureCall1Impl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXMemberFeatureCall1()
	 * @generated
	 */
	int XMEMBER_FEATURE_CALL1 = 9;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Member Call Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__MEMBER_CALL_TARGET = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member Call Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__MEMBER_CALL_ARGUMENTS = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__EXPLICIT_OPERATION_CALL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__EXPLICIT_STATIC = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Null Safe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__NULL_SAFE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__TYPE_LITERAL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Static With Declaring Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__STATIC_WITH_DECLARING_TYPE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__PACKAGE_FRAGMENT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Indexed Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1__INDEXED_OPERATION = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>XMember Feature Call1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL1_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XFeatureCallImpl <em>XFeature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XFeatureCallImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXFeatureCall()
	 * @generated
	 */
	int XFEATURE_CALL = 10;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Feature Call Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__FEATURE_CALL_ARGUMENTS = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__EXPLICIT_OPERATION_CALL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__TYPE_LITERAL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__PACKAGE_FRAGMENT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Indexed Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__INDEXED_OPERATION = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__VALUE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>XFeature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XConstructorCallImpl <em>XConstructor Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XConstructorCallImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXConstructorCall()
	 * @generated
	 */
	int XCONSTRUCTOR_CALL = 11;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__CONSTRUCTOR = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__ARGUMENTS = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__TYPE_ARGUMENTS = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__VALID_FEATURE = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>XConstructor Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XBooleanLiteralImpl <em>XBoolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XBooleanLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBooleanLiteral()
	 * @generated
	 */
	int XBOOLEAN_LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Is True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBOOLEAN_LITERAL__IS_TRUE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XBoolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBOOLEAN_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XNullLiteralImpl <em>XNull Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XNullLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXNullLiteral()
	 * @generated
	 */
	int XNULL_LITERAL = 13;

	/**
	 * The number of structural features of the '<em>XNull Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XNULL_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XNumberLiteralImpl <em>XNumber Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XNumberLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXNumberLiteral()
	 * @generated
	 */
	int XNUMBER_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XNUMBER_LITERAL__VALUE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XNumber Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XNUMBER_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XStringLiteralImpl <em>XString Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XStringLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXStringLiteral()
	 * @generated
	 */
	int XSTRING_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRING_LITERAL__VALUE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XString Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRING_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XCollectionLiteralImpl <em>XCollection Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XCollectionLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCollectionLiteral()
	 * @generated
	 */
	int XCOLLECTION_LITERAL = 16;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOLLECTION_LITERAL__ELEMENTS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XCollection Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOLLECTION_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XListLiteralImpl <em>XList Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XListLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXListLiteral()
	 * @generated
	 */
	int XLIST_LITERAL = 17;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIST_LITERAL__ELEMENTS = XCOLLECTION_LITERAL__ELEMENTS;

	/**
	 * The number of structural features of the '<em>XList Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIST_LITERAL_FEATURE_COUNT = XCOLLECTION_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XKeyValuePairImpl <em>XKey Value Pair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XKeyValuePairImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXKeyValuePair()
	 * @generated
	 */
	int XKEY_VALUE_PAIR = 18;

	/**
	 * The feature id for the '<em><b>Key1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XKEY_VALUE_PAIR__KEY1 = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XKEY_VALUE_PAIR__VALUE = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XKEY_VALUE_PAIR__KEY = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XKey Value Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XKEY_VALUE_PAIR_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XSetLiteralImpl <em>XSet Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XSetLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXSetLiteral()
	 * @generated
	 */
	int XSET_LITERAL = 19;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSET_LITERAL__ELEMENTS = XCOLLECTION_LITERAL__ELEMENTS;

	/**
	 * The number of structural features of the '<em>XSet Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSET_LITERAL_FEATURE_COUNT = XCOLLECTION_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XClosureImpl <em>XClosure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XClosureImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXClosure()
	 * @generated
	 */
	int XCLOSURE = 20;

	/**
	 * The feature id for the '<em><b>Declared Formal Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__DECLARED_FORMAL_PARAMETERS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__EXPLICIT_SYNTAX = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implicit Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__IMPLICIT_PARAMETER = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__NAME = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__RETURN_TYPE = XEXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__OPERATOR = XEXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__TYPE_PARAMETERS = XEXPRESSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__EXPORTED = XEXPRESSION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>XClosure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XCastedExpressionImpl <em>XCasted Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XCastedExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCastedExpression()
	 * @generated
	 */
	int XCASTED_EXPRESSION = 21;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASTED_EXPRESSION__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASTED_EXPRESSION__TARGET = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XCasted Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASTED_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XBinaryOperationImpl <em>XBinary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XBinaryOperationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBinaryOperation()
	 * @generated
	 */
	int XBINARY_OPERATION = 22;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__LEFT_OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__RIGHT_OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XBinary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XUnaryOperationImpl <em>XUnary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XUnaryOperationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXUnaryOperation()
	 * @generated
	 */
	int XUNARY_OPERATION = 23;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XUnary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl <em>XFor Loop Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXForLoopExpression()
	 * @generated
	 */
	int XFOR_LOOP_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION__CONDITION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION__LOOP = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION__INIT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION__EACH_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XFor Loop Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XForEachExpressionImpl <em>XFor Each Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XForEachExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXForEachExpression()
	 * @generated
	 */
	int XFOR_EACH_EXPRESSION = 25;

	/**
	 * The feature id for the '<em><b>For Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_EACH_EXPRESSION__FOR_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_EACH_EXPRESSION__EACH_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_EACH_EXPRESSION__DECLARED_PARAM = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XFor Each Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_EACH_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XAbstractWhileExpressionImpl <em>XAbstract While Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XAbstractWhileExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXAbstractWhileExpression()
	 * @generated
	 */
	int XABSTRACT_WHILE_EXPRESSION = 26;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_WHILE_EXPRESSION__PREDICATE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_WHILE_EXPRESSION__BODY = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XAbstract While Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_WHILE_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XDoWhileExpressionImpl <em>XDo While Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XDoWhileExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXDoWhileExpression()
	 * @generated
	 */
	int XDO_WHILE_EXPRESSION = 27;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDO_WHILE_EXPRESSION__PREDICATE = XABSTRACT_WHILE_EXPRESSION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDO_WHILE_EXPRESSION__BODY = XABSTRACT_WHILE_EXPRESSION__BODY;

	/**
	 * The number of structural features of the '<em>XDo While Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDO_WHILE_EXPRESSION_FEATURE_COUNT = XABSTRACT_WHILE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XWhileExpressionImpl <em>XWhile Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XWhileExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXWhileExpression()
	 * @generated
	 */
	int XWHILE_EXPRESSION = 28;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION__PREDICATE = XABSTRACT_WHILE_EXPRESSION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION__BODY = XABSTRACT_WHILE_EXPRESSION__BODY;

	/**
	 * The number of structural features of the '<em>XWhile Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION_FEATURE_COUNT = XABSTRACT_WHILE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XTypeLiteralImpl <em>XType Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XTypeLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTypeLiteral()
	 * @generated
	 */
	int XTYPE_LITERAL = 29;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL__ARRAY_DIMENSIONS = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XType Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XInstanceOfExpressionImpl <em>XInstance Of Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XInstanceOfExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXInstanceOfExpression()
	 * @generated
	 */
	int XINSTANCE_OF_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINSTANCE_OF_EXPRESSION__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINSTANCE_OF_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XInstance Of Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINSTANCE_OF_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XThrowExpressionImpl <em>XThrow Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XThrowExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXThrowExpression()
	 * @generated
	 */
	int XTHROW_EXPRESSION = 31;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTHROW_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XThrow Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTHROW_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyExpressionImpl <em>XTry Catch Finally Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XTryCatchFinallyExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTryCatchFinallyExpression()
	 * @generated
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION = 32;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Finally Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Catch Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XTry Catch Finally Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XCatchClauseImpl <em>XCatch Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XCatchClauseImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCatchClause()
	 * @generated
	 */
	int XCATCH_CLAUSE = 33;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCATCH_CLAUSE__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCATCH_CLAUSE__DECLARED_PARAM = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCATCH_CLAUSE__IDENTIFIER = 2;

	/**
	 * The number of structural features of the '<em>XCatch Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCATCH_CLAUSE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XAssignmentImpl <em>XAssignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XAssignmentImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXAssignment()
	 * @generated
	 */
	int XASSIGNMENT = 34;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Assignable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__ASSIGNABLE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__VALUE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__EXPLICIT_STATIC = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Indexed Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__INDEXED_OPERATION = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__INDEX = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>XAssignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XReturnExpressionImpl <em>XReturn Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XReturnExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXReturnExpression()
	 * @generated
	 */
	int XRETURN_EXPRESSION = 35;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRETURN_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XReturn Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRETURN_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XBreakExpressionImpl <em>XBreak Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XBreakExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBreakExpression()
	 * @generated
	 */
	int XBREAK_EXPRESSION = 36;

	/**
	 * The number of structural features of the '<em>XBreak Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBREAK_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XContinueExpressionImpl <em>XContinue Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XContinueExpressionImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXContinueExpression()
	 * @generated
	 */
	int XCONTINUE_EXPRESSION = 37;

	/**
	 * The number of structural features of the '<em>XContinue Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONTINUE_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XPrefixOperationImpl <em>XPrefix Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XPrefixOperationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXPrefixOperation()
	 * @generated
	 */
	int XPREFIX_OPERATION = 38;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION__OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XPrefix Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPREFIX_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XPostfixOperationImpl <em>XPostfix Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XPostfixOperationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXPostfixOperation()
	 * @generated
	 */
	int XPOSTFIX_OPERATION = 39;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XPostfix Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XTernaryOperationImpl <em>XTernary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XTernaryOperationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTernaryOperation()
	 * @generated
	 */
	int XTERNARY_OPERATION = 40;

	/**
	 * The feature id for the '<em><b>True Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTERNARY_OPERATION__TRUE_OPERAND = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTERNARY_OPERATION__FALSE_OPERAND = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTERNARY_OPERATION__CONDITION = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XTernary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTERNARY_OPERATION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XIndexOperationImpl <em>XIndex Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XIndexOperationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXIndexOperation()
	 * @generated
	 */
	int XINDEX_OPERATION = 41;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__EXPRESSION = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION__INDEX = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XIndex Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINDEX_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XFunctionDeclarationImpl <em>XFunction Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XFunctionDeclarationImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXFunctionDeclaration()
	 * @generated
	 */
	int XFUNCTION_DECLARATION = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_DECLARATION__NAME = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_DECLARATION__BODY = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_DECLARATION__RETURN_TYPE = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_DECLARATION__PARAMETERS = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XFunction Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_DECLARATION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XObjectLiteralImpl <em>XObject Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XObjectLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXObjectLiteral()
	 * @generated
	 */
	int XOBJECT_LITERAL = 43;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__ANNOTATIONS = TypesPackage.JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__DECLARING_TYPE = TypesPackage.JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__VISIBILITY = TypesPackage.JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__SIMPLE_NAME = TypesPackage.JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__IDENTIFIER = TypesPackage.JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__ANNOTATION_INFO = TypesPackage.JVM_DECLARED_TYPE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__MODIFIERS = TypesPackage.JVM_DECLARED_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__ARRAY_TYPE = TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__SUPER_TYPES = TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__MEMBERS = TypesPackage.JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__ABSTRACT = TypesPackage.JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__STATIC = TypesPackage.JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__FINAL = TypesPackage.JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__PACKAGE_NAME = TypesPackage.JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL__EXPORTED = TypesPackage.JVM_DECLARED_TYPE__EXPORTED;

	/**
	 * The number of structural features of the '<em>XObject Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_FEATURE_COUNT = TypesPackage.JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XObjectLiteralPartImpl <em>XObject Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XObjectLiteralPartImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXObjectLiteralPart()
	 * @generated
	 */
	int XOBJECT_LITERAL_PART = 44;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__ANNOTATIONS = TypesPackage.JVM_FIELD__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__DECLARING_TYPE = TypesPackage.JVM_FIELD__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__VISIBILITY = TypesPackage.JVM_FIELD__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__SIMPLE_NAME = TypesPackage.JVM_FIELD__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__IDENTIFIER = TypesPackage.JVM_FIELD__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__ANNOTATION_INFO = TypesPackage.JVM_FIELD__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__MODIFIERS = TypesPackage.JVM_FIELD__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__STATIC = TypesPackage.JVM_FIELD__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__FINAL = TypesPackage.JVM_FIELD__FINAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__TYPE = TypesPackage.JVM_FIELD__TYPE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__VOLATILE = TypesPackage.JVM_FIELD__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__TRANSIENT = TypesPackage.JVM_FIELD__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__DEFAULT_VALUE = TypesPackage.JVM_FIELD__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__SET = TypesPackage.JVM_FIELD__SET;

	/**
	 * The feature id for the '<em><b>Get</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART__GET = TypesPackage.JVM_FIELD__GET;

	/**
	 * The number of structural features of the '<em>XObject Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_LITERAL_PART_FEATURE_COUNT = TypesPackage.JVM_FIELD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XArrayLiteralImpl <em>XArray Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XArrayLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXArrayLiteral()
	 * @generated
	 */
	int XARRAY_LITERAL = 45;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XARRAY_LITERAL__ELEMENTS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XArray Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XARRAY_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XStructLiteralImpl <em>XStruct Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XStructLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXStructLiteral()
	 * @generated
	 */
	int XSTRUCT_LITERAL = 46;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRUCT_LITERAL__PROPERTIES = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRUCT_LITERAL__TYPE = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRUCT_LITERAL__TYPE_ARGUMENTS = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XStruct Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRUCT_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XFieldLiteralPartImpl <em>XField Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XFieldLiteralPartImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXFieldLiteralPart()
	 * @generated
	 */
	int XFIELD_LITERAL_PART = 47;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFIELD_LITERAL_PART__FIELD = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFIELD_LITERAL_PART__VALUE = 1;

	/**
	 * The number of structural features of the '<em>XField Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFIELD_LITERAL_PART_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.XTemplateImpl <em>XTemplate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.XTemplateImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTemplate()
	 * @generated
	 */
	int XTEMPLATE = 48;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEMPLATE__EXPRESSIONS = XBLOCK_EXPRESSION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>XTemplate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEMPLATE_FEATURE_COUNT = XBLOCK_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xbase.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.impl.RichStringLiteralImpl
	 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getRichStringLiteral()
	 * @generated
	 */
	int RICH_STRING_LITERAL = 49;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL__VALUE = XSTRING_LITERAL__VALUE;

	/**
	 * The number of structural features of the '<em>Rich String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL_FEATURE_COUNT = XSTRING_LITERAL_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XExpression <em>XExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XExpression</em>'.
	 * @see org.summer.dsl.model.xbase.XExpression
	 * @generated
	 */
	EClass getXExpression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XIfExpression <em>XIf Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XIf Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XIfExpression
	 * @generated
	 */
	EClass getXIfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XIfExpression#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.summer.dsl.model.xbase.XIfExpression#getIf()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XIfExpression#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.summer.dsl.model.xbase.XIfExpression#getThen()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XIfExpression#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.summer.dsl.model.xbase.XIfExpression#getElse()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_Else();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XSwitchExpression <em>XSwitch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSwitch Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XSwitchExpression
	 * @generated
	 */
	EClass getXSwitchExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XSwitchExpression#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.summer.dsl.model.xbase.XSwitchExpression#getSwitch()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Switch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XSwitchExpression#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.summer.dsl.model.xbase.XSwitchExpression#getCases()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XSwitchExpression#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.summer.dsl.model.xbase.XSwitchExpression#getDefault()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XSwitchExpression#getLocalVarName <em>Local Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Var Name</em>'.
	 * @see org.summer.dsl.model.xbase.XSwitchExpression#getLocalVarName()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EAttribute getXSwitchExpression_LocalVarName();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XCasePart <em>XCase Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCase Part</em>'.
	 * @see org.summer.dsl.model.xbase.XCasePart
	 * @generated
	 */
	EClass getXCasePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XCasePart#getCase <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Case</em>'.
	 * @see org.summer.dsl.model.xbase.XCasePart#getCase()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_Case();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XCasePart#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.summer.dsl.model.xbase.XCasePart#getThen()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XCasePart#getTypeGuard <em>Type Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Guard</em>'.
	 * @see org.summer.dsl.model.xbase.XCasePart#getTypeGuard()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_TypeGuard();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XBlockExpression <em>XBlock Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBlock Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XBlockExpression
	 * @generated
	 */
	EClass getXBlockExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XBlockExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.summer.dsl.model.xbase.XBlockExpression#getExpressions()
	 * @see #getXBlockExpression()
	 * @generated
	 */
	EReference getXBlockExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XVariableDeclaration <em>XVariable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XVariable Declaration</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclaration
	 * @generated
	 */
	EClass getXVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XVariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclaration#getType()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EReference getXVariableDeclaration_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XVariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclaration#getName()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EAttribute getXVariableDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XVariableDeclaration#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclaration#getRight()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EReference getXVariableDeclaration_Right();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XVariableDeclarationList <em>XVariable Declaration List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XVariable Declaration List</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclarationList
	 * @generated
	 */
	EClass getXVariableDeclarationList();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XVariableDeclarationList#isWriteable <em>Writeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Writeable</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclarationList#isWriteable()
	 * @see #getXVariableDeclarationList()
	 * @generated
	 */
	EAttribute getXVariableDeclarationList_Writeable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XVariableDeclarationList#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclarationList#getDeclarations()
	 * @see #getXVariableDeclarationList()
	 * @generated
	 */
	EReference getXVariableDeclarationList_Declarations();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XVariableDeclarationList#isExported <em>Exported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exported</em>'.
	 * @see org.summer.dsl.model.xbase.XVariableDeclarationList#isExported()
	 * @see #getXVariableDeclarationList()
	 * @generated
	 */
	EAttribute getXVariableDeclarationList_Exported();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall <em>XAbstract Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAbstract Feature Call</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall
	 * @generated
	 */
	EClass getXAbstractFeatureCall();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall#getFeature()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_Feature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall#getTypeArguments()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_TypeArguments();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implicit Receiver</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitReceiver()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_ImplicitReceiver();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalid Feature Issue Code</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EAttribute getXAbstractFeatureCall_InvalidFeatureIssueCode();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#isValidFeature <em>Valid Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid Feature</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall#isValidFeature()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EAttribute getXAbstractFeatureCall_ValidFeature();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitFirstArgument <em>Implicit First Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implicit First Argument</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall#getImplicitFirstArgument()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_ImplicitFirstArgument();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XMemberFeatureCall <em>XMember Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMember Feature Call</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall
	 * @generated
	 */
	EClass getXMemberFeatureCall();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#getMemberCallTarget <em>Member Call Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Member Call Target</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#getMemberCallTarget()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EReference getXMemberFeatureCall_MemberCallTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#getMemberCallArguments <em>Member Call Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Call Arguments</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#getMemberCallArguments()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EReference getXMemberFeatureCall_MemberCallArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Operation Call</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#isExplicitOperationCall()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_ExplicitOperationCall();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#isExplicitStatic <em>Explicit Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Static</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#isExplicitStatic()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_ExplicitStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#isNullSafe <em>Null Safe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Null Safe</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#isNullSafe()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_NullSafe();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#isTypeLiteral <em>Type Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#isTypeLiteral()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_TypeLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#isStaticWithDeclaringType <em>Static With Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static With Declaring Type</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#isStaticWithDeclaringType()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_StaticWithDeclaringType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#isPackageFragment <em>Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Fragment</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#isPackageFragment()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_PackageFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall#isIndexedOperation <em>Indexed Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indexed Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall#isIndexedOperation()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_IndexedOperation();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1 <em>XMember Feature Call1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMember Feature Call1</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1
	 * @generated
	 */
	EClass getXMemberFeatureCall1();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#getMemberCallTarget <em>Member Call Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Member Call Target</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#getMemberCallTarget()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EReference getXMemberFeatureCall1_MemberCallTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#getMemberCallArguments <em>Member Call Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Call Arguments</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#getMemberCallArguments()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EReference getXMemberFeatureCall1_MemberCallArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#isExplicitOperationCall <em>Explicit Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Operation Call</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#isExplicitOperationCall()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall1_ExplicitOperationCall();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#isExplicitStatic <em>Explicit Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Static</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#isExplicitStatic()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall1_ExplicitStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#isNullSafe <em>Null Safe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Null Safe</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#isNullSafe()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall1_NullSafe();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#isTypeLiteral <em>Type Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#isTypeLiteral()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall1_TypeLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#isStaticWithDeclaringType <em>Static With Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static With Declaring Type</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#isStaticWithDeclaringType()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall1_StaticWithDeclaringType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#isPackageFragment <em>Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Fragment</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#isPackageFragment()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall1_PackageFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1#isIndexedOperation <em>Indexed Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indexed Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1#isIndexedOperation()
	 * @see #getXMemberFeatureCall1()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall1_IndexedOperation();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XFeatureCall <em>XFeature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFeature Call</em>'.
	 * @see org.summer.dsl.model.xbase.XFeatureCall
	 * @generated
	 */
	EClass getXFeatureCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XFeatureCall#getFeatureCallArguments <em>Feature Call Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Call Arguments</em>'.
	 * @see org.summer.dsl.model.xbase.XFeatureCall#getFeatureCallArguments()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EReference getXFeatureCall_FeatureCallArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Operation Call</em>'.
	 * @see org.summer.dsl.model.xbase.XFeatureCall#isExplicitOperationCall()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_ExplicitOperationCall();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XFeatureCall#isTypeLiteral <em>Type Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XFeatureCall#isTypeLiteral()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_TypeLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XFeatureCall#isPackageFragment <em>Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Fragment</em>'.
	 * @see org.summer.dsl.model.xbase.XFeatureCall#isPackageFragment()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_PackageFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XFeatureCall#isIndexedOperation <em>Indexed Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indexed Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XFeatureCall#isIndexedOperation()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_IndexedOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XFeatureCall#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.xbase.XFeatureCall#getValue()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EReference getXFeatureCall_Value();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XConstructorCall <em>XConstructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XConstructor Call</em>'.
	 * @see org.summer.dsl.model.xbase.XConstructorCall
	 * @generated
	 */
	EClass getXConstructorCall();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xbase.XConstructorCall#getConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constructor</em>'.
	 * @see org.summer.dsl.model.xbase.XConstructorCall#getConstructor()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_Constructor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XConstructorCall#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.summer.dsl.model.xbase.XConstructorCall#getArguments()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_Arguments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XConstructorCall#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.summer.dsl.model.xbase.XConstructorCall#getTypeArguments()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_TypeArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XConstructorCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalid Feature Issue Code</em>'.
	 * @see org.summer.dsl.model.xbase.XConstructorCall#getInvalidFeatureIssueCode()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EAttribute getXConstructorCall_InvalidFeatureIssueCode();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XConstructorCall#isValidFeature <em>Valid Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid Feature</em>'.
	 * @see org.summer.dsl.model.xbase.XConstructorCall#isValidFeature()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EAttribute getXConstructorCall_ValidFeature();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XBooleanLiteral <em>XBoolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBoolean Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XBooleanLiteral
	 * @generated
	 */
	EClass getXBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XBooleanLiteral#isIsTrue <em>Is True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is True</em>'.
	 * @see org.summer.dsl.model.xbase.XBooleanLiteral#isIsTrue()
	 * @see #getXBooleanLiteral()
	 * @generated
	 */
	EAttribute getXBooleanLiteral_IsTrue();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XNullLiteral <em>XNull Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XNull Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XNullLiteral
	 * @generated
	 */
	EClass getXNullLiteral();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XNumberLiteral <em>XNumber Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XNumber Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XNumberLiteral
	 * @generated
	 */
	EClass getXNumberLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XNumberLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.summer.dsl.model.xbase.XNumberLiteral#getValue()
	 * @see #getXNumberLiteral()
	 * @generated
	 */
	EAttribute getXNumberLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XStringLiteral <em>XString Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XString Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XStringLiteral
	 * @generated
	 */
	EClass getXStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XStringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.summer.dsl.model.xbase.XStringLiteral#getValue()
	 * @see #getXStringLiteral()
	 * @generated
	 */
	EAttribute getXStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XCollectionLiteral <em>XCollection Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCollection Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XCollectionLiteral
	 * @generated
	 */
	EClass getXCollectionLiteral();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XCollectionLiteral#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.summer.dsl.model.xbase.XCollectionLiteral#getElements()
	 * @see #getXCollectionLiteral()
	 * @generated
	 */
	EReference getXCollectionLiteral_Elements();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XListLiteral <em>XList Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XList Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XListLiteral
	 * @generated
	 */
	EClass getXListLiteral();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XKeyValuePair <em>XKey Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XKey Value Pair</em>'.
	 * @see org.summer.dsl.model.xbase.XKeyValuePair
	 * @generated
	 */
	EClass getXKeyValuePair();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XKeyValuePair#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.summer.dsl.model.xbase.XKeyValuePair#getKey()
	 * @see #getXKeyValuePair()
	 * @generated
	 */
	EReference getXKeyValuePair_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XKeyValuePair#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.xbase.XKeyValuePair#getValue()
	 * @see #getXKeyValuePair()
	 * @generated
	 */
	EReference getXKeyValuePair_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XKeyValuePair#getKey1 <em>Key1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key1</em>'.
	 * @see org.summer.dsl.model.xbase.XKeyValuePair#getKey1()
	 * @see #getXKeyValuePair()
	 * @generated
	 */
	EAttribute getXKeyValuePair_Key1();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XSetLiteral <em>XSet Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSet Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XSetLiteral
	 * @generated
	 */
	EClass getXSetLiteral();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XClosure <em>XClosure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XClosure</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure
	 * @generated
	 */
	EClass getXClosure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XClosure#getDeclaredFormalParameters <em>Declared Formal Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Formal Parameters</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#getDeclaredFormalParameters()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_DeclaredFormalParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XClosure#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#getExpression()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XClosure#isExplicitSyntax <em>Explicit Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Syntax</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#isExplicitSyntax()
	 * @see #getXClosure()
	 * @generated
	 */
	EAttribute getXClosure_ExplicitSyntax();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XClosure#getImplicitParameter <em>Implicit Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implicit Parameter</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#getImplicitParameter()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_ImplicitParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XClosure#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#getName()
	 * @see #getXClosure()
	 * @generated
	 */
	EAttribute getXClosure_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XClosure#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#getReturnType()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_ReturnType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XClosure#isOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#isOperator()
	 * @see #getXClosure()
	 * @generated
	 */
	EAttribute getXClosure_Operator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XClosure#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#getTypeParameters()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_TypeParameters();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XClosure#isExported <em>Exported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exported</em>'.
	 * @see org.summer.dsl.model.xbase.XClosure#isExported()
	 * @see #getXClosure()
	 * @generated
	 */
	EAttribute getXClosure_Exported();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XCastedExpression <em>XCasted Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCasted Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XCastedExpression
	 * @generated
	 */
	EClass getXCastedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XCastedExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xbase.XCastedExpression#getType()
	 * @see #getXCastedExpression()
	 * @generated
	 */
	EReference getXCastedExpression_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XCastedExpression#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.summer.dsl.model.xbase.XCastedExpression#getTarget()
	 * @see #getXCastedExpression()
	 * @generated
	 */
	EReference getXCastedExpression_Target();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XBinaryOperation <em>XBinary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBinary Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XBinaryOperation
	 * @generated
	 */
	EClass getXBinaryOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XBinaryOperation#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.summer.dsl.model.xbase.XBinaryOperation#getLeftOperand()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EReference getXBinaryOperation_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XBinaryOperation#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.summer.dsl.model.xbase.XBinaryOperation#getRightOperand()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EReference getXBinaryOperation_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XUnaryOperation <em>XUnary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XUnary Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XUnaryOperation
	 * @generated
	 */
	EClass getXUnaryOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XUnaryOperation#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.summer.dsl.model.xbase.XUnaryOperation#getOperand()
	 * @see #getXUnaryOperation()
	 * @generated
	 */
	EReference getXUnaryOperation_Operand();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XForLoopExpression <em>XFor Loop Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFor Loop Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XForLoopExpression
	 * @generated
	 */
	EClass getXForLoopExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Each Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XForLoopExpression#getEachExpression()
	 * @see #getXForLoopExpression()
	 * @generated
	 */
	EReference getXForLoopExpression_EachExpression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XForEachExpression <em>XFor Each Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFor Each Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XForEachExpression
	 * @generated
	 */
	EClass getXForEachExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XForEachExpression#getForExpression <em>For Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>For Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XForEachExpression#getForExpression()
	 * @see #getXForEachExpression()
	 * @generated
	 */
	EReference getXForEachExpression_ForExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XForEachExpression#getEachExpression <em>Each Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Each Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XForEachExpression#getEachExpression()
	 * @see #getXForEachExpression()
	 * @generated
	 */
	EReference getXForEachExpression_EachExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XForEachExpression#getDeclaredParam <em>Declared Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Param</em>'.
	 * @see org.summer.dsl.model.xbase.XForEachExpression#getDeclaredParam()
	 * @see #getXForEachExpression()
	 * @generated
	 */
	EReference getXForEachExpression_DeclaredParam();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XForLoopExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.summer.dsl.model.xbase.XForLoopExpression#getCondition()
	 * @see #getXForLoopExpression()
	 * @generated
	 */
	EReference getXForLoopExpression_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XForLoopExpression#getLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop</em>'.
	 * @see org.summer.dsl.model.xbase.XForLoopExpression#getLoop()
	 * @see #getXForLoopExpression()
	 * @generated
	 */
	EReference getXForLoopExpression_Loop();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XForLoopExpression#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.summer.dsl.model.xbase.XForLoopExpression#getInit()
	 * @see #getXForLoopExpression()
	 * @generated
	 */
	EReference getXForLoopExpression_Init();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XAbstractWhileExpression <em>XAbstract While Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAbstract While Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractWhileExpression
	 * @generated
	 */
	EClass getXAbstractWhileExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XAbstractWhileExpression#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractWhileExpression#getPredicate()
	 * @see #getXAbstractWhileExpression()
	 * @generated
	 */
	EReference getXAbstractWhileExpression_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XAbstractWhileExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.summer.dsl.model.xbase.XAbstractWhileExpression#getBody()
	 * @see #getXAbstractWhileExpression()
	 * @generated
	 */
	EReference getXAbstractWhileExpression_Body();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XDoWhileExpression <em>XDo While Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XDo While Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XDoWhileExpression
	 * @generated
	 */
	EClass getXDoWhileExpression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XWhileExpression <em>XWhile Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XWhile Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XWhileExpression
	 * @generated
	 */
	EClass getXWhileExpression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XTypeLiteral <em>XType Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XType Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XTypeLiteral
	 * @generated
	 */
	EClass getXTypeLiteral();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xbase.XTypeLiteral#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xbase.XTypeLiteral#getType()
	 * @see #getXTypeLiteral()
	 * @generated
	 */
	EReference getXTypeLiteral_Type();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.xbase.XTypeLiteral#getArrayDimensions <em>Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Array Dimensions</em>'.
	 * @see org.summer.dsl.model.xbase.XTypeLiteral#getArrayDimensions()
	 * @see #getXTypeLiteral()
	 * @generated
	 */
	EAttribute getXTypeLiteral_ArrayDimensions();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XInstanceOfExpression <em>XInstance Of Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XInstance Of Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XInstanceOfExpression
	 * @generated
	 */
	EClass getXInstanceOfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XInstanceOfExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xbase.XInstanceOfExpression#getType()
	 * @see #getXInstanceOfExpression()
	 * @generated
	 */
	EReference getXInstanceOfExpression_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XInstanceOfExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XInstanceOfExpression#getExpression()
	 * @see #getXInstanceOfExpression()
	 * @generated
	 */
	EReference getXInstanceOfExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XThrowExpression <em>XThrow Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XThrow Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XThrowExpression
	 * @generated
	 */
	EClass getXThrowExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XThrowExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XThrowExpression#getExpression()
	 * @see #getXThrowExpression()
	 * @generated
	 */
	EReference getXThrowExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression <em>XTry Catch Finally Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XTry Catch Finally Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XTryCatchFinallyExpression
	 * @generated
	 */
	EClass getXTryCatchFinallyExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getExpression()
	 * @see #getXTryCatchFinallyExpression()
	 * @generated
	 */
	EReference getXTryCatchFinallyExpression_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Finally Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getFinallyExpression()
	 * @see #getXTryCatchFinallyExpression()
	 * @generated
	 */
	EReference getXTryCatchFinallyExpression_FinallyExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getCatchClause <em>Catch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Catch Clause</em>'.
	 * @see org.summer.dsl.model.xbase.XTryCatchFinallyExpression#getCatchClause()
	 * @see #getXTryCatchFinallyExpression()
	 * @generated
	 */
	EReference getXTryCatchFinallyExpression_CatchClause();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XCatchClause <em>XCatch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCatch Clause</em>'.
	 * @see org.summer.dsl.model.xbase.XCatchClause
	 * @generated
	 */
	EClass getXCatchClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XCatchClause#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XCatchClause#getExpression()
	 * @see #getXCatchClause()
	 * @generated
	 */
	EReference getXCatchClause_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XCatchClause#getDeclaredParam <em>Declared Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Param</em>'.
	 * @see org.summer.dsl.model.xbase.XCatchClause#getDeclaredParam()
	 * @see #getXCatchClause()
	 * @generated
	 */
	EReference getXCatchClause_DeclaredParam();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XCatchClause#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.summer.dsl.model.xbase.XCatchClause#getIdentifier()
	 * @see #getXCatchClause()
	 * @generated
	 */
	EAttribute getXCatchClause_Identifier();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XAssignment <em>XAssignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAssignment</em>'.
	 * @see org.summer.dsl.model.xbase.XAssignment
	 * @generated
	 */
	EClass getXAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XAssignment#getAssignable <em>Assignable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assignable</em>'.
	 * @see org.summer.dsl.model.xbase.XAssignment#getAssignable()
	 * @see #getXAssignment()
	 * @generated
	 */
	EReference getXAssignment_Assignable();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.xbase.XAssignment#getValue()
	 * @see #getXAssignment()
	 * @generated
	 */
	EReference getXAssignment_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Static</em>'.
	 * @see org.summer.dsl.model.xbase.XAssignment#isExplicitStatic()
	 * @see #getXAssignment()
	 * @generated
	 */
	EAttribute getXAssignment_ExplicitStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XAssignment#isIndexedOperation <em>Indexed Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indexed Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XAssignment#isIndexedOperation()
	 * @see #getXAssignment()
	 * @generated
	 */
	EAttribute getXAssignment_IndexedOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XAssignment#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see org.summer.dsl.model.xbase.XAssignment#getIndex()
	 * @see #getXAssignment()
	 * @generated
	 */
	EReference getXAssignment_Index();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XReturnExpression <em>XReturn Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XReturn Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XReturnExpression
	 * @generated
	 */
	EClass getXReturnExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XReturnExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XReturnExpression#getExpression()
	 * @see #getXReturnExpression()
	 * @generated
	 */
	EReference getXReturnExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XBreakExpression <em>XBreak Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBreak Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XBreakExpression
	 * @generated
	 */
	EClass getXBreakExpression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XContinueExpression <em>XContinue Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XContinue Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XContinueExpression
	 * @generated
	 */
	EClass getXContinueExpression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XPrefixOperation <em>XPrefix Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XPrefix Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XPrefixOperation
	 * @generated
	 */
	EClass getXPrefixOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XPrefixOperation#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.summer.dsl.model.xbase.XPrefixOperation#getOperand()
	 * @see #getXPrefixOperation()
	 * @generated
	 */
	EReference getXPrefixOperation_Operand();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XPostfixOperation <em>XPostfix Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XPostfix Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XPostfixOperation
	 * @generated
	 */
	EClass getXPostfixOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XPostfixOperation#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.summer.dsl.model.xbase.XPostfixOperation#getOperand()
	 * @see #getXPostfixOperation()
	 * @generated
	 */
	EReference getXPostfixOperation_Operand();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XTernaryOperation <em>XTernary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XTernary Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XTernaryOperation
	 * @generated
	 */
	EClass getXTernaryOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XTernaryOperation#getTrueOperand <em>True Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>True Operand</em>'.
	 * @see org.summer.dsl.model.xbase.XTernaryOperation#getTrueOperand()
	 * @see #getXTernaryOperation()
	 * @generated
	 */
	EReference getXTernaryOperation_TrueOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XTernaryOperation#getFalseOperand <em>False Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>False Operand</em>'.
	 * @see org.summer.dsl.model.xbase.XTernaryOperation#getFalseOperand()
	 * @see #getXTernaryOperation()
	 * @generated
	 */
	EReference getXTernaryOperation_FalseOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XTernaryOperation#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.summer.dsl.model.xbase.XTernaryOperation#getCondition()
	 * @see #getXTernaryOperation()
	 * @generated
	 */
	EReference getXTernaryOperation_Condition();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XIndexOperation <em>XIndex Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XIndex Operation</em>'.
	 * @see org.summer.dsl.model.xbase.XIndexOperation
	 * @generated
	 */
	EClass getXIndexOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XIndexOperation#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.xbase.XIndexOperation#getExpression()
	 * @see #getXIndexOperation()
	 * @generated
	 */
	EReference getXIndexOperation_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XIndexOperation#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see org.summer.dsl.model.xbase.XIndexOperation#getIndex()
	 * @see #getXIndexOperation()
	 * @generated
	 */
	EReference getXIndexOperation_Index();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XFunctionDeclaration <em>XFunction Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFunction Declaration</em>'.
	 * @see org.summer.dsl.model.xbase.XFunctionDeclaration
	 * @generated
	 */
	EClass getXFunctionDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.xbase.XFunctionDeclaration#getName()
	 * @see #getXFunctionDeclaration()
	 * @generated
	 */
	EAttribute getXFunctionDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.summer.dsl.model.xbase.XFunctionDeclaration#getBody()
	 * @see #getXFunctionDeclaration()
	 * @generated
	 */
	EReference getXFunctionDeclaration_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.summer.dsl.model.xbase.XFunctionDeclaration#getReturnType()
	 * @see #getXFunctionDeclaration()
	 * @generated
	 */
	EReference getXFunctionDeclaration_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.summer.dsl.model.xbase.XFunctionDeclaration#getParameters()
	 * @see #getXFunctionDeclaration()
	 * @generated
	 */
	EReference getXFunctionDeclaration_Parameters();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XObjectLiteral <em>XObject Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XObject Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XObjectLiteral
	 * @generated
	 */
	EClass getXObjectLiteral();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XObjectLiteralPart <em>XObject Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XObject Literal Part</em>'.
	 * @see org.summer.dsl.model.xbase.XObjectLiteralPart
	 * @generated
	 */
	EClass getXObjectLiteralPart();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XArrayLiteral <em>XArray Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XArray Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XArrayLiteral
	 * @generated
	 */
	EClass getXArrayLiteral();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XArrayLiteral#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.summer.dsl.model.xbase.XArrayLiteral#getElements()
	 * @see #getXArrayLiteral()
	 * @generated
	 */
	EReference getXArrayLiteral_Elements();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XStructLiteral <em>XStruct Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XStruct Literal</em>'.
	 * @see org.summer.dsl.model.xbase.XStructLiteral
	 * @generated
	 */
	EClass getXStructLiteral();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XStructLiteral#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.summer.dsl.model.xbase.XStructLiteral#getProperties()
	 * @see #getXStructLiteral()
	 * @generated
	 */
	EReference getXStructLiteral_Properties();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xbase.XStructLiteral#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xbase.XStructLiteral#getType()
	 * @see #getXStructLiteral()
	 * @generated
	 */
	EReference getXStructLiteral_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xbase.XStructLiteral#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.summer.dsl.model.xbase.XStructLiteral#getTypeArguments()
	 * @see #getXStructLiteral()
	 * @generated
	 */
	EReference getXStructLiteral_TypeArguments();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XFieldLiteralPart <em>XField Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XField Literal Part</em>'.
	 * @see org.summer.dsl.model.xbase.XFieldLiteralPart
	 * @generated
	 */
	EClass getXFieldLiteralPart();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xbase.XFieldLiteralPart#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Field</em>'.
	 * @see org.summer.dsl.model.xbase.XFieldLiteralPart#getField()
	 * @see #getXFieldLiteralPart()
	 * @generated
	 */
	EReference getXFieldLiteralPart_Field();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xbase.XFieldLiteralPart#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.xbase.XFieldLiteralPart#getValue()
	 * @see #getXFieldLiteralPart()
	 * @generated
	 */
	EReference getXFieldLiteralPart_Value();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.XTemplate <em>XTemplate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XTemplate</em>'.
	 * @see org.summer.dsl.model.xbase.XTemplate
	 * @generated
	 */
	EClass getXTemplate();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xbase.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String Literal</em>'.
	 * @see org.summer.dsl.model.xbase.RichStringLiteral
	 * @generated
	 */
	EClass getRichStringLiteral();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XbaseFactory getXbaseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XExpressionImpl <em>XExpression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXExpression()
		 * @generated
		 */
		EClass XEXPRESSION = eINSTANCE.getXExpression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XIfExpressionImpl <em>XIf Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XIfExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXIfExpression()
		 * @generated
		 */
		EClass XIF_EXPRESSION = eINSTANCE.getXIfExpression();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIF_EXPRESSION__IF = eINSTANCE.getXIfExpression_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIF_EXPRESSION__THEN = eINSTANCE.getXIfExpression_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIF_EXPRESSION__ELSE = eINSTANCE.getXIfExpression_Else();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XSwitchExpressionImpl <em>XSwitch Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XSwitchExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXSwitchExpression()
		 * @generated
		 */
		EClass XSWITCH_EXPRESSION = eINSTANCE.getXSwitchExpression();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSWITCH_EXPRESSION__SWITCH = eINSTANCE.getXSwitchExpression_Switch();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSWITCH_EXPRESSION__CASES = eINSTANCE.getXSwitchExpression_Cases();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSWITCH_EXPRESSION__DEFAULT = eINSTANCE.getXSwitchExpression_Default();

		/**
		 * The meta object literal for the '<em><b>Local Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XSWITCH_EXPRESSION__LOCAL_VAR_NAME = eINSTANCE.getXSwitchExpression_LocalVarName();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XCasePartImpl <em>XCase Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XCasePartImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCasePart()
		 * @generated
		 */
		EClass XCASE_PART = eINSTANCE.getXCasePart();

		/**
		 * The meta object literal for the '<em><b>Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASE_PART__CASE = eINSTANCE.getXCasePart_Case();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASE_PART__THEN = eINSTANCE.getXCasePart_Then();

		/**
		 * The meta object literal for the '<em><b>Type Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASE_PART__TYPE_GUARD = eINSTANCE.getXCasePart_TypeGuard();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XBlockExpressionImpl <em>XBlock Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XBlockExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBlockExpression()
		 * @generated
		 */
		EClass XBLOCK_EXPRESSION = eINSTANCE.getXBlockExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBLOCK_EXPRESSION__EXPRESSIONS = eINSTANCE.getXBlockExpression_Expressions();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XVariableDeclarationImpl <em>XVariable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XVariableDeclarationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXVariableDeclaration()
		 * @generated
		 */
		EClass XVARIABLE_DECLARATION = eINSTANCE.getXVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XVARIABLE_DECLARATION__TYPE = eINSTANCE.getXVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XVARIABLE_DECLARATION__NAME = eINSTANCE.getXVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XVARIABLE_DECLARATION__RIGHT = eINSTANCE.getXVariableDeclaration_Right();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XVariableDeclarationListImpl <em>XVariable Declaration List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XVariableDeclarationListImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXVariableDeclarationList()
		 * @generated
		 */
		EClass XVARIABLE_DECLARATION_LIST = eINSTANCE.getXVariableDeclarationList();

		/**
		 * The meta object literal for the '<em><b>Writeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XVARIABLE_DECLARATION_LIST__WRITEABLE = eINSTANCE.getXVariableDeclarationList_Writeable();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XVARIABLE_DECLARATION_LIST__DECLARATIONS = eINSTANCE.getXVariableDeclarationList_Declarations();

		/**
		 * The meta object literal for the '<em><b>Exported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XVARIABLE_DECLARATION_LIST__EXPORTED = eINSTANCE.getXVariableDeclarationList_Exported();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl <em>XAbstract Feature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXAbstractFeatureCall()
		 * @generated
		 */
		EClass XABSTRACT_FEATURE_CALL = eINSTANCE.getXAbstractFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__FEATURE = eINSTANCE.getXAbstractFeatureCall_Feature();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS = eINSTANCE.getXAbstractFeatureCall_TypeArguments();

		/**
		 * The meta object literal for the '<em><b>Implicit Receiver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER = eINSTANCE.getXAbstractFeatureCall_ImplicitReceiver();

		/**
		 * The meta object literal for the '<em><b>Invalid Feature Issue Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = eINSTANCE.getXAbstractFeatureCall_InvalidFeatureIssueCode();

		/**
		 * The meta object literal for the '<em><b>Valid Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XABSTRACT_FEATURE_CALL__VALID_FEATURE = eINSTANCE.getXAbstractFeatureCall_ValidFeature();

		/**
		 * The meta object literal for the '<em><b>Implicit First Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = eINSTANCE.getXAbstractFeatureCall_ImplicitFirstArgument();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XMemberFeatureCallImpl <em>XMember Feature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XMemberFeatureCallImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXMemberFeatureCall()
		 * @generated
		 */
		EClass XMEMBER_FEATURE_CALL = eINSTANCE.getXMemberFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Member Call Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET = eINSTANCE.getXMemberFeatureCall_MemberCallTarget();

		/**
		 * The meta object literal for the '<em><b>Member Call Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS = eINSTANCE.getXMemberFeatureCall_MemberCallArguments();

		/**
		 * The meta object literal for the '<em><b>Explicit Operation Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL = eINSTANCE.getXMemberFeatureCall_ExplicitOperationCall();

		/**
		 * The meta object literal for the '<em><b>Explicit Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__EXPLICIT_STATIC = eINSTANCE.getXMemberFeatureCall_ExplicitStatic();

		/**
		 * The meta object literal for the '<em><b>Null Safe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__NULL_SAFE = eINSTANCE.getXMemberFeatureCall_NullSafe();

		/**
		 * The meta object literal for the '<em><b>Type Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__TYPE_LITERAL = eINSTANCE.getXMemberFeatureCall_TypeLiteral();

		/**
		 * The meta object literal for the '<em><b>Static With Declaring Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__STATIC_WITH_DECLARING_TYPE = eINSTANCE.getXMemberFeatureCall_StaticWithDeclaringType();

		/**
		 * The meta object literal for the '<em><b>Package Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__PACKAGE_FRAGMENT = eINSTANCE.getXMemberFeatureCall_PackageFragment();

		/**
		 * The meta object literal for the '<em><b>Indexed Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__INDEXED_OPERATION = eINSTANCE.getXMemberFeatureCall_IndexedOperation();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XMemberFeatureCall1Impl <em>XMember Feature Call1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XMemberFeatureCall1Impl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXMemberFeatureCall1()
		 * @generated
		 */
		EClass XMEMBER_FEATURE_CALL1 = eINSTANCE.getXMemberFeatureCall1();

		/**
		 * The meta object literal for the '<em><b>Member Call Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMEMBER_FEATURE_CALL1__MEMBER_CALL_TARGET = eINSTANCE.getXMemberFeatureCall1_MemberCallTarget();

		/**
		 * The meta object literal for the '<em><b>Member Call Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMEMBER_FEATURE_CALL1__MEMBER_CALL_ARGUMENTS = eINSTANCE.getXMemberFeatureCall1_MemberCallArguments();

		/**
		 * The meta object literal for the '<em><b>Explicit Operation Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL1__EXPLICIT_OPERATION_CALL = eINSTANCE.getXMemberFeatureCall1_ExplicitOperationCall();

		/**
		 * The meta object literal for the '<em><b>Explicit Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL1__EXPLICIT_STATIC = eINSTANCE.getXMemberFeatureCall1_ExplicitStatic();

		/**
		 * The meta object literal for the '<em><b>Null Safe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL1__NULL_SAFE = eINSTANCE.getXMemberFeatureCall1_NullSafe();

		/**
		 * The meta object literal for the '<em><b>Type Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL1__TYPE_LITERAL = eINSTANCE.getXMemberFeatureCall1_TypeLiteral();

		/**
		 * The meta object literal for the '<em><b>Static With Declaring Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL1__STATIC_WITH_DECLARING_TYPE = eINSTANCE.getXMemberFeatureCall1_StaticWithDeclaringType();

		/**
		 * The meta object literal for the '<em><b>Package Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL1__PACKAGE_FRAGMENT = eINSTANCE.getXMemberFeatureCall1_PackageFragment();

		/**
		 * The meta object literal for the '<em><b>Indexed Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL1__INDEXED_OPERATION = eINSTANCE.getXMemberFeatureCall1_IndexedOperation();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XFeatureCallImpl <em>XFeature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XFeatureCallImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXFeatureCall()
		 * @generated
		 */
		EClass XFEATURE_CALL = eINSTANCE.getXFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Feature Call Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFEATURE_CALL__FEATURE_CALL_ARGUMENTS = eINSTANCE.getXFeatureCall_FeatureCallArguments();

		/**
		 * The meta object literal for the '<em><b>Explicit Operation Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__EXPLICIT_OPERATION_CALL = eINSTANCE.getXFeatureCall_ExplicitOperationCall();

		/**
		 * The meta object literal for the '<em><b>Type Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__TYPE_LITERAL = eINSTANCE.getXFeatureCall_TypeLiteral();

		/**
		 * The meta object literal for the '<em><b>Package Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__PACKAGE_FRAGMENT = eINSTANCE.getXFeatureCall_PackageFragment();

		/**
		 * The meta object literal for the '<em><b>Indexed Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__INDEXED_OPERATION = eINSTANCE.getXFeatureCall_IndexedOperation();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFEATURE_CALL__VALUE = eINSTANCE.getXFeatureCall_Value();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XConstructorCallImpl <em>XConstructor Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XConstructorCallImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXConstructorCall()
		 * @generated
		 */
		EClass XCONSTRUCTOR_CALL = eINSTANCE.getXConstructorCall();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__CONSTRUCTOR = eINSTANCE.getXConstructorCall_Constructor();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__ARGUMENTS = eINSTANCE.getXConstructorCall_Arguments();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__TYPE_ARGUMENTS = eINSTANCE.getXConstructorCall_TypeArguments();

		/**
		 * The meta object literal for the '<em><b>Invalid Feature Issue Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE = eINSTANCE.getXConstructorCall_InvalidFeatureIssueCode();

		/**
		 * The meta object literal for the '<em><b>Valid Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCONSTRUCTOR_CALL__VALID_FEATURE = eINSTANCE.getXConstructorCall_ValidFeature();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XBooleanLiteralImpl <em>XBoolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XBooleanLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBooleanLiteral()
		 * @generated
		 */
		EClass XBOOLEAN_LITERAL = eINSTANCE.getXBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XBOOLEAN_LITERAL__IS_TRUE = eINSTANCE.getXBooleanLiteral_IsTrue();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XNullLiteralImpl <em>XNull Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XNullLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXNullLiteral()
		 * @generated
		 */
		EClass XNULL_LITERAL = eINSTANCE.getXNullLiteral();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XNumberLiteralImpl <em>XNumber Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XNumberLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXNumberLiteral()
		 * @generated
		 */
		EClass XNUMBER_LITERAL = eINSTANCE.getXNumberLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XNUMBER_LITERAL__VALUE = eINSTANCE.getXNumberLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XStringLiteralImpl <em>XString Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XStringLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXStringLiteral()
		 * @generated
		 */
		EClass XSTRING_LITERAL = eINSTANCE.getXStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XSTRING_LITERAL__VALUE = eINSTANCE.getXStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XCollectionLiteralImpl <em>XCollection Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XCollectionLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCollectionLiteral()
		 * @generated
		 */
		EClass XCOLLECTION_LITERAL = eINSTANCE.getXCollectionLiteral();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCOLLECTION_LITERAL__ELEMENTS = eINSTANCE.getXCollectionLiteral_Elements();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XListLiteralImpl <em>XList Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XListLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXListLiteral()
		 * @generated
		 */
		EClass XLIST_LITERAL = eINSTANCE.getXListLiteral();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XKeyValuePairImpl <em>XKey Value Pair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XKeyValuePairImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXKeyValuePair()
		 * @generated
		 */
		EClass XKEY_VALUE_PAIR = eINSTANCE.getXKeyValuePair();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XKEY_VALUE_PAIR__KEY = eINSTANCE.getXKeyValuePair_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XKEY_VALUE_PAIR__VALUE = eINSTANCE.getXKeyValuePair_Value();

		/**
		 * The meta object literal for the '<em><b>Key1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XKEY_VALUE_PAIR__KEY1 = eINSTANCE.getXKeyValuePair_Key1();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XSetLiteralImpl <em>XSet Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XSetLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXSetLiteral()
		 * @generated
		 */
		EClass XSET_LITERAL = eINSTANCE.getXSetLiteral();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XClosureImpl <em>XClosure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XClosureImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXClosure()
		 * @generated
		 */
		EClass XCLOSURE = eINSTANCE.getXClosure();

		/**
		 * The meta object literal for the '<em><b>Declared Formal Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__DECLARED_FORMAL_PARAMETERS = eINSTANCE.getXClosure_DeclaredFormalParameters();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__EXPRESSION = eINSTANCE.getXClosure_Expression();

		/**
		 * The meta object literal for the '<em><b>Explicit Syntax</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLOSURE__EXPLICIT_SYNTAX = eINSTANCE.getXClosure_ExplicitSyntax();

		/**
		 * The meta object literal for the '<em><b>Implicit Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__IMPLICIT_PARAMETER = eINSTANCE.getXClosure_ImplicitParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLOSURE__NAME = eINSTANCE.getXClosure_Name();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__RETURN_TYPE = eINSTANCE.getXClosure_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLOSURE__OPERATOR = eINSTANCE.getXClosure_Operator();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__TYPE_PARAMETERS = eINSTANCE.getXClosure_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Exported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLOSURE__EXPORTED = eINSTANCE.getXClosure_Exported();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XCastedExpressionImpl <em>XCasted Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XCastedExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCastedExpression()
		 * @generated
		 */
		EClass XCASTED_EXPRESSION = eINSTANCE.getXCastedExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASTED_EXPRESSION__TYPE = eINSTANCE.getXCastedExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASTED_EXPRESSION__TARGET = eINSTANCE.getXCastedExpression_Target();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XBinaryOperationImpl <em>XBinary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XBinaryOperationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBinaryOperation()
		 * @generated
		 */
		EClass XBINARY_OPERATION = eINSTANCE.getXBinaryOperation();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBINARY_OPERATION__LEFT_OPERAND = eINSTANCE.getXBinaryOperation_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBINARY_OPERATION__RIGHT_OPERAND = eINSTANCE.getXBinaryOperation_RightOperand();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XUnaryOperationImpl <em>XUnary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XUnaryOperationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXUnaryOperation()
		 * @generated
		 */
		EClass XUNARY_OPERATION = eINSTANCE.getXUnaryOperation();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XUNARY_OPERATION__OPERAND = eINSTANCE.getXUnaryOperation_Operand();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl <em>XFor Loop Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXForLoopExpression()
		 * @generated
		 */
		EClass XFOR_LOOP_EXPRESSION = eINSTANCE.getXForLoopExpression();

		/**
		 * The meta object literal for the '<em><b>Each Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_LOOP_EXPRESSION__EACH_EXPRESSION = eINSTANCE.getXForLoopExpression_EachExpression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XForEachExpressionImpl <em>XFor Each Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XForEachExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXForEachExpression()
		 * @generated
		 */
		EClass XFOR_EACH_EXPRESSION = eINSTANCE.getXForEachExpression();

		/**
		 * The meta object literal for the '<em><b>For Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_EACH_EXPRESSION__FOR_EXPRESSION = eINSTANCE.getXForEachExpression_ForExpression();

		/**
		 * The meta object literal for the '<em><b>Each Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_EACH_EXPRESSION__EACH_EXPRESSION = eINSTANCE.getXForEachExpression_EachExpression();

		/**
		 * The meta object literal for the '<em><b>Declared Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_EACH_EXPRESSION__DECLARED_PARAM = eINSTANCE.getXForEachExpression_DeclaredParam();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_LOOP_EXPRESSION__CONDITION = eINSTANCE.getXForLoopExpression_Condition();

		/**
		 * The meta object literal for the '<em><b>Loop</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_LOOP_EXPRESSION__LOOP = eINSTANCE.getXForLoopExpression_Loop();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_LOOP_EXPRESSION__INIT = eINSTANCE.getXForLoopExpression_Init();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XAbstractWhileExpressionImpl <em>XAbstract While Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XAbstractWhileExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXAbstractWhileExpression()
		 * @generated
		 */
		EClass XABSTRACT_WHILE_EXPRESSION = eINSTANCE.getXAbstractWhileExpression();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_WHILE_EXPRESSION__PREDICATE = eINSTANCE.getXAbstractWhileExpression_Predicate();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_WHILE_EXPRESSION__BODY = eINSTANCE.getXAbstractWhileExpression_Body();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XDoWhileExpressionImpl <em>XDo While Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XDoWhileExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXDoWhileExpression()
		 * @generated
		 */
		EClass XDO_WHILE_EXPRESSION = eINSTANCE.getXDoWhileExpression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XWhileExpressionImpl <em>XWhile Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XWhileExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXWhileExpression()
		 * @generated
		 */
		EClass XWHILE_EXPRESSION = eINSTANCE.getXWhileExpression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XTypeLiteralImpl <em>XType Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XTypeLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTypeLiteral()
		 * @generated
		 */
		EClass XTYPE_LITERAL = eINSTANCE.getXTypeLiteral();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTYPE_LITERAL__TYPE = eINSTANCE.getXTypeLiteral_Type();

		/**
		 * The meta object literal for the '<em><b>Array Dimensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTYPE_LITERAL__ARRAY_DIMENSIONS = eINSTANCE.getXTypeLiteral_ArrayDimensions();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XInstanceOfExpressionImpl <em>XInstance Of Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XInstanceOfExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXInstanceOfExpression()
		 * @generated
		 */
		EClass XINSTANCE_OF_EXPRESSION = eINSTANCE.getXInstanceOfExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XINSTANCE_OF_EXPRESSION__TYPE = eINSTANCE.getXInstanceOfExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XINSTANCE_OF_EXPRESSION__EXPRESSION = eINSTANCE.getXInstanceOfExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XThrowExpressionImpl <em>XThrow Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XThrowExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXThrowExpression()
		 * @generated
		 */
		EClass XTHROW_EXPRESSION = eINSTANCE.getXThrowExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTHROW_EXPRESSION__EXPRESSION = eINSTANCE.getXThrowExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyExpressionImpl <em>XTry Catch Finally Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XTryCatchFinallyExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTryCatchFinallyExpression()
		 * @generated
		 */
		EClass XTRY_CATCH_FINALLY_EXPRESSION = eINSTANCE.getXTryCatchFinallyExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION = eINSTANCE.getXTryCatchFinallyExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Finally Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION = eINSTANCE.getXTryCatchFinallyExpression_FinallyExpression();

		/**
		 * The meta object literal for the '<em><b>Catch Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE = eINSTANCE.getXTryCatchFinallyExpression_CatchClause();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XCatchClauseImpl <em>XCatch Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XCatchClauseImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXCatchClause()
		 * @generated
		 */
		EClass XCATCH_CLAUSE = eINSTANCE.getXCatchClause();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCATCH_CLAUSE__EXPRESSION = eINSTANCE.getXCatchClause_Expression();

		/**
		 * The meta object literal for the '<em><b>Declared Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCATCH_CLAUSE__DECLARED_PARAM = eINSTANCE.getXCatchClause_DeclaredParam();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCATCH_CLAUSE__IDENTIFIER = eINSTANCE.getXCatchClause_Identifier();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XAssignmentImpl <em>XAssignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XAssignmentImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXAssignment()
		 * @generated
		 */
		EClass XASSIGNMENT = eINSTANCE.getXAssignment();

		/**
		 * The meta object literal for the '<em><b>Assignable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XASSIGNMENT__ASSIGNABLE = eINSTANCE.getXAssignment_Assignable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XASSIGNMENT__VALUE = eINSTANCE.getXAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Explicit Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XASSIGNMENT__EXPLICIT_STATIC = eINSTANCE.getXAssignment_ExplicitStatic();

		/**
		 * The meta object literal for the '<em><b>Indexed Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XASSIGNMENT__INDEXED_OPERATION = eINSTANCE.getXAssignment_IndexedOperation();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XASSIGNMENT__INDEX = eINSTANCE.getXAssignment_Index();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XReturnExpressionImpl <em>XReturn Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XReturnExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXReturnExpression()
		 * @generated
		 */
		EClass XRETURN_EXPRESSION = eINSTANCE.getXReturnExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XRETURN_EXPRESSION__EXPRESSION = eINSTANCE.getXReturnExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XBreakExpressionImpl <em>XBreak Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XBreakExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXBreakExpression()
		 * @generated
		 */
		EClass XBREAK_EXPRESSION = eINSTANCE.getXBreakExpression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XContinueExpressionImpl <em>XContinue Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XContinueExpressionImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXContinueExpression()
		 * @generated
		 */
		EClass XCONTINUE_EXPRESSION = eINSTANCE.getXContinueExpression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XPrefixOperationImpl <em>XPrefix Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XPrefixOperationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXPrefixOperation()
		 * @generated
		 */
		EClass XPREFIX_OPERATION = eINSTANCE.getXPrefixOperation();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XPREFIX_OPERATION__OPERAND = eINSTANCE.getXPrefixOperation_Operand();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XPostfixOperationImpl <em>XPostfix Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XPostfixOperationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXPostfixOperation()
		 * @generated
		 */
		EClass XPOSTFIX_OPERATION = eINSTANCE.getXPostfixOperation();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XPOSTFIX_OPERATION__OPERAND = eINSTANCE.getXPostfixOperation_Operand();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XTernaryOperationImpl <em>XTernary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XTernaryOperationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTernaryOperation()
		 * @generated
		 */
		EClass XTERNARY_OPERATION = eINSTANCE.getXTernaryOperation();

		/**
		 * The meta object literal for the '<em><b>True Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTERNARY_OPERATION__TRUE_OPERAND = eINSTANCE.getXTernaryOperation_TrueOperand();

		/**
		 * The meta object literal for the '<em><b>False Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTERNARY_OPERATION__FALSE_OPERAND = eINSTANCE.getXTernaryOperation_FalseOperand();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTERNARY_OPERATION__CONDITION = eINSTANCE.getXTernaryOperation_Condition();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XIndexOperationImpl <em>XIndex Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XIndexOperationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXIndexOperation()
		 * @generated
		 */
		EClass XINDEX_OPERATION = eINSTANCE.getXIndexOperation();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XINDEX_OPERATION__EXPRESSION = eINSTANCE.getXIndexOperation_Expression();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XINDEX_OPERATION__INDEX = eINSTANCE.getXIndexOperation_Index();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XFunctionDeclarationImpl <em>XFunction Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XFunctionDeclarationImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXFunctionDeclaration()
		 * @generated
		 */
		EClass XFUNCTION_DECLARATION = eINSTANCE.getXFunctionDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFUNCTION_DECLARATION__NAME = eINSTANCE.getXFunctionDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_DECLARATION__BODY = eINSTANCE.getXFunctionDeclaration_Body();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_DECLARATION__RETURN_TYPE = eINSTANCE.getXFunctionDeclaration_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_DECLARATION__PARAMETERS = eINSTANCE.getXFunctionDeclaration_Parameters();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XObjectLiteralImpl <em>XObject Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XObjectLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXObjectLiteral()
		 * @generated
		 */
		EClass XOBJECT_LITERAL = eINSTANCE.getXObjectLiteral();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XObjectLiteralPartImpl <em>XObject Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XObjectLiteralPartImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXObjectLiteralPart()
		 * @generated
		 */
		EClass XOBJECT_LITERAL_PART = eINSTANCE.getXObjectLiteralPart();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XArrayLiteralImpl <em>XArray Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XArrayLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXArrayLiteral()
		 * @generated
		 */
		EClass XARRAY_LITERAL = eINSTANCE.getXArrayLiteral();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XARRAY_LITERAL__ELEMENTS = eINSTANCE.getXArrayLiteral_Elements();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XStructLiteralImpl <em>XStruct Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XStructLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXStructLiteral()
		 * @generated
		 */
		EClass XSTRUCT_LITERAL = eINSTANCE.getXStructLiteral();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSTRUCT_LITERAL__PROPERTIES = eINSTANCE.getXStructLiteral_Properties();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSTRUCT_LITERAL__TYPE = eINSTANCE.getXStructLiteral_Type();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSTRUCT_LITERAL__TYPE_ARGUMENTS = eINSTANCE.getXStructLiteral_TypeArguments();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XFieldLiteralPartImpl <em>XField Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XFieldLiteralPartImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXFieldLiteralPart()
		 * @generated
		 */
		EClass XFIELD_LITERAL_PART = eINSTANCE.getXFieldLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFIELD_LITERAL_PART__FIELD = eINSTANCE.getXFieldLiteralPart_Field();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFIELD_LITERAL_PART__VALUE = eINSTANCE.getXFieldLiteralPart_Value();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.XTemplateImpl <em>XTemplate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.XTemplateImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getXTemplate()
		 * @generated
		 */
		EClass XTEMPLATE = eINSTANCE.getXTemplate();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xbase.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.impl.RichStringLiteralImpl
		 * @see org.summer.dsl.model.xbase.impl.XbasePackageImpl#getRichStringLiteral()
		 * @generated
		 */
		EClass RICH_STRING_LITERAL = eINSTANCE.getRichStringLiteral();

	}

} //XbasePackage
