/**
 */
package org.summer.dsl.model.ss;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.summer.dsl.model.types.TypesPackage;

import org.summer.dsl.model.xbase.XbasePackage;

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
 * @see org.summer.dsl.model.ss.SsFactory
 * @model kind="package"
 * @generated
 */
public interface SsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ss";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.summer.org/dsl/model/ss";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ss";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SsPackage eINSTANCE = org.summer.dsl.model.ss.impl.SsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XModuleImpl <em>XModule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XModuleImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXModule()
	 * @generated
	 */
	int XMODULE = 0;

	/**
	 * The feature id for the '<em><b>Import Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMODULE__IMPORT_SECTION = TypesPackage.JVM_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Xtend Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMODULE__XTEND_TYPES = TypesPackage.JVM_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMODULE__PACKAGE = TypesPackage.JVM_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMODULE__CONTENTS = TypesPackage.JVM_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Export Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMODULE__EXPORT_SECTION = TypesPackage.JVM_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>XModule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMODULE_FEATURE_COUNT = TypesPackage.JVM_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendAnnotationTargetImpl <em>Xtend Annotation Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendAnnotationTargetImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendAnnotationTarget()
	 * @generated
	 */
	int XTEND_ANNOTATION_TARGET = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TARGET__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Xtend Annotation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TARGET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendMemberImpl <em>Xtend Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendMemberImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendMember()
	 * @generated
	 */
	int XTEND_MEMBER = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__ANNOTATIONS = XTEND_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__ANNOTATION_INFO = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__MODIFIERS = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__DECLARING_TYPE = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Xtend Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER_FEATURE_COUNT = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendTypeDeclarationImpl <em>Xtend Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendTypeDeclarationImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendTypeDeclaration()
	 * @generated
	 */
	int XTEND_TYPE_DECLARATION = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION__MEMBERS = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xtend Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_TYPE_DECLARATION_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendClassImpl <em>Xtend Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendClassImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendClass()
	 * @generated
	 */
	int XTEND_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__EXTENDS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__IMPLEMENTS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__TYPE_PARAMETERS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Xtend Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendFunctionImpl <em>Xtend Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendFunctionImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendFunction()
	 * @generated
	 */
	int XTEND_FUNCTION = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__EXPRESSION = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__RETURN_TYPE = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Create Extension Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__CREATE_EXTENSION_INFO = XTEND_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__TYPE_PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__EXCEPTIONS = XTEND_MEMBER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Xtend Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendFieldImpl <em>Xtend Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendFieldImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendField()
	 * @generated
	 */
	int XTEND_FIELD = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__TYPE = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD__INITIAL_VALUE = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Xtend Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FIELD_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendParameterImpl <em>Xtend Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendParameterImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendParameter()
	 * @generated
	 */
	int XTEND_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__ANNOTATIONS = XTEND_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__NAME = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__PARAMETER_TYPE = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var Arg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__VAR_ARG = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER__EXTENSION = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Xtend Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_PARAMETER_FEATURE_COUNT = XTEND_ANNOTATION_TARGET_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.RichStringImpl <em>Rich String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.RichStringImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichString()
	 * @generated
	 */
	int RICH_STRING = 7;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING__EXPRESSIONS = XbasePackage.XBLOCK_EXPRESSION__EXPRESSIONS;

	/**
	 * The number of structural features of the '<em>Rich String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FEATURE_COUNT = XbasePackage.XBLOCK_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.RichStringLiteralImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringLiteral()
	 * @generated
	 */
	int RICH_STRING_LITERAL = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL__VALUE = XbasePackage.XSTRING_LITERAL__VALUE;

	/**
	 * The number of structural features of the '<em>Rich String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL_FEATURE_COUNT = XbasePackage.XSTRING_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.RichStringForLoopImpl <em>Rich String For Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.RichStringForLoopImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringForLoop()
	 * @generated
	 */
	int RICH_STRING_FOR_LOOP = 9;

	/**
	 * The feature id for the '<em><b>For Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__FOR_EXPRESSION = XbasePackage.XFOR_EACH_EXPRESSION__FOR_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__EACH_EXPRESSION = XbasePackage.XFOR_EACH_EXPRESSION__EACH_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__DECLARED_PARAM = XbasePackage.XFOR_EACH_EXPRESSION__DECLARED_PARAM;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__SEPARATOR = XbasePackage.XFOR_EACH_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Before</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__BEFORE = XbasePackage.XFOR_EACH_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>After</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__AFTER = XbasePackage.XFOR_EACH_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rich String For Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP_FEATURE_COUNT = XbasePackage.XFOR_EACH_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.RichStringIfImpl <em>Rich String If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.RichStringIfImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringIf()
	 * @generated
	 */
	int RICH_STRING_IF = 10;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__IF = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__THEN = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Ifs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__ELSE_IFS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__ELSE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rich String If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.RichStringElseIfImpl <em>Rich String Else If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.RichStringElseIfImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringElseIf()
	 * @generated
	 */
	int RICH_STRING_ELSE_IF = 11;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF__IF = 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF__THEN = 1;

	/**
	 * The number of structural features of the '<em>Rich String Else If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.CreateExtensionInfoImpl <em>Create Extension Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.CreateExtensionInfoImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getCreateExtensionInfo()
	 * @generated
	 */
	int CREATE_EXTENSION_INFO = 12;

	/**
	 * The feature id for the '<em><b>Create Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_EXTENSION_INFO__CREATE_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_EXTENSION_INFO__NAME = 1;

	/**
	 * The number of structural features of the '<em>Create Extension Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_EXTENSION_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendConstructorImpl <em>Xtend Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendConstructorImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendConstructor()
	 * @generated
	 */
	int XTEND_CONSTRUCTOR = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__EXPRESSION = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__TYPE_PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR__EXCEPTIONS = XTEND_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Xtend Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CONSTRUCTOR_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendAnnotationTypeImpl <em>Xtend Annotation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendAnnotationTypeImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendAnnotationType()
	 * @generated
	 */
	int XTEND_ANNOTATION_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The number of structural features of the '<em>Xtend Annotation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ANNOTATION_TYPE_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendInterfaceImpl <em>Xtend Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendInterfaceImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendInterface()
	 * @generated
	 */
	int XTEND_INTERFACE = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__EXTENDS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE__TYPE_PARAMETERS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xtend Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_INTERFACE_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendEnumImpl <em>Xtend Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendEnumImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendEnum()
	 * @generated
	 */
	int XTEND_ENUM = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The number of structural features of the '<em>Xtend Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendEnumLiteralImpl <em>Xtend Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendEnumLiteralImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendEnumLiteral()
	 * @generated
	 */
	int XTEND_ENUM_LITERAL = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xtend Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_ENUM_LITERAL_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendVariableDeclarationImpl <em>Xtend Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendVariableDeclarationImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendVariableDeclaration()
	 * @generated
	 */
	int XTEND_VARIABLE_DECLARATION = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__TYPE = XbasePackage.XVARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__NAME = XbasePackage.XVARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__RIGHT = XbasePackage.XVARIABLE_DECLARATION__RIGHT;


	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION__EXTENSION = XbasePackage.XVARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xtend Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_VARIABLE_DECLARATION_FEATURE_COUNT = XbasePackage.XVARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendFormalParameterImpl <em>Xtend Formal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendFormalParameterImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendFormalParameter()
	 * @generated
	 */
	int XTEND_FORMAL_PARAMETER = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__ANNOTATIONS = TypesPackage.JVM_FORMAL_PARAMETER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__NAME = TypesPackage.JVM_FORMAL_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__PARAMETER_TYPE = TypesPackage.JVM_FORMAL_PARAMETER__PARAMETER_TYPE;

	/**
	 * The feature id for the '<em><b>Var Arg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__VAR_ARG = TypesPackage.JVM_FORMAL_PARAMETER__VAR_ARG;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__DEFAULT_VALUE = TypesPackage.JVM_FORMAL_PARAMETER__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER__EXTENSION = TypesPackage.JVM_FORMAL_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xtend Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FORMAL_PARAMETER_FEATURE_COUNT = TypesPackage.JVM_FORMAL_PARAMETER_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendDelegateImpl <em>Xtend Delegate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendDelegateImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendDelegate()
	 * @generated
	 */
	int XTEND_DELEGATE = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__ANNOTATIONS = XTEND_TYPE_DECLARATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__ANNOTATION_INFO = XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__MODIFIERS = XTEND_TYPE_DECLARATION__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__DECLARING_TYPE = XTEND_TYPE_DECLARATION__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__NAME = XTEND_TYPE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__MEMBERS = XTEND_TYPE_DECLARATION__MEMBERS;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__RETURN_TYPE = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__PARAMETERS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__TYPE_PARAMETERS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE__EXCEPTIONS = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Xtend Delegate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_DELEGATE_FEATURE_COUNT = XTEND_TYPE_DECLARATION_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.summer.dsl.model.ss.impl.XtendEventImpl <em>Xtend Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.ss.impl.XtendEventImpl
	 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendEvent()
	 * @generated
	 */
	int XTEND_EVENT = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT__ANNOTATIONS = XTEND_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT__ANNOTATION_INFO = XTEND_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT__MODIFIERS = XTEND_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT__NAME = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT__TYPE = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT__INITIAL_VALUE = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Xtend Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_EVENT_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XModule <em>XModule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XModule</em>'.
	 * @see org.summer.dsl.model.ss.XModule
	 * @generated
	 */
	EClass getXModule();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XModule#getImportSection <em>Import Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Import Section</em>'.
	 * @see org.summer.dsl.model.ss.XModule#getImportSection()
	 * @see #getXModule()
	 * @generated
	 */
	EReference getXModule_ImportSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XModule#getXtendTypes <em>Xtend Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Xtend Types</em>'.
	 * @see org.summer.dsl.model.ss.XModule#getXtendTypes()
	 * @see #getXModule()
	 * @generated
	 */
	EReference getXModule_XtendTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XModule#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.summer.dsl.model.ss.XModule#getPackage()
	 * @see #getXModule()
	 * @generated
	 */
	EAttribute getXModule_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XModule#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.summer.dsl.model.ss.XModule#getContents()
	 * @see #getXModule()
	 * @generated
	 */
	EReference getXModule_Contents();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XModule#getExportSection <em>Export Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Export Section</em>'.
	 * @see org.summer.dsl.model.ss.XModule#getExportSection()
	 * @see #getXModule()
	 * @generated
	 */
	EReference getXModule_ExportSection();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendClass <em>Xtend Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Class</em>'.
	 * @see org.summer.dsl.model.ss.XtendClass
	 * @generated
	 */
	EClass getXtendClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendClass#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.summer.dsl.model.ss.XtendClass#getExtends()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendClass#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implements</em>'.
	 * @see org.summer.dsl.model.ss.XtendClass#getImplements()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_Implements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendClass#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendClass#getTypeParameters()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendAnnotationTarget <em>Xtend Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Annotation Target</em>'.
	 * @see org.summer.dsl.model.ss.XtendAnnotationTarget
	 * @generated
	 */
	EClass getXtendAnnotationTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendAnnotationTarget#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.summer.dsl.model.ss.XtendAnnotationTarget#getAnnotations()
	 * @see #getXtendAnnotationTarget()
	 * @generated
	 */
	EReference getXtendAnnotationTarget_Annotations();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendMember <em>Xtend Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Member</em>'.
	 * @see org.summer.dsl.model.ss.XtendMember
	 * @generated
	 */
	EClass getXtendMember();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendMember#getAnnotationInfo <em>Annotation Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation Info</em>'.
	 * @see org.summer.dsl.model.ss.XtendMember#getAnnotationInfo()
	 * @see #getXtendMember()
	 * @generated
	 */
	EReference getXtendMember_AnnotationInfo();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.ss.XtendMember#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifiers</em>'.
	 * @see org.summer.dsl.model.ss.XtendMember#getModifiers()
	 * @see #getXtendMember()
	 * @generated
	 */
	EAttribute getXtendMember_Modifiers();

	/**
	 * Returns the meta object for the container reference '{@link org.summer.dsl.model.ss.XtendMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Type</em>'.
	 * @see org.summer.dsl.model.ss.XtendMember#getDeclaringType()
	 * @see #getXtendMember()
	 * @generated
	 */
	EReference getXtendMember_DeclaringType();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendFunction <em>Xtend Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Function</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction
	 * @generated
	 */
	EClass getXtendFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction#getName()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EAttribute getXtendFunction_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendFunction#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction#getExpression()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendFunction#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction#getReturnType()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendFunction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction#getParameters()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendFunction#getCreateExtensionInfo <em>Create Extension Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Create Extension Info</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction#getCreateExtensionInfo()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_CreateExtensionInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendFunction#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction#getTypeParameters()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_TypeParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendFunction#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.summer.dsl.model.ss.XtendFunction#getExceptions()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_Exceptions();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendField <em>Xtend Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Field</em>'.
	 * @see org.summer.dsl.model.ss.XtendField
	 * @generated
	 */
	EClass getXtendField();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.ss.XtendField#getName()
	 * @see #getXtendField()
	 * @generated
	 */
	EAttribute getXtendField_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.ss.XtendField#getType()
	 * @see #getXtendField()
	 * @generated
	 */
	EReference getXtendField_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendField#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see org.summer.dsl.model.ss.XtendField#getInitialValue()
	 * @see #getXtendField()
	 * @generated
	 */
	EReference getXtendField_InitialValue();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendParameter <em>Xtend Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Parameter</em>'.
	 * @see org.summer.dsl.model.ss.XtendParameter
	 * @generated
	 */
	EClass getXtendParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.ss.XtendParameter#getName()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EAttribute getXtendParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendParameter#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter Type</em>'.
	 * @see org.summer.dsl.model.ss.XtendParameter#getParameterType()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EReference getXtendParameter_ParameterType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendParameter#isVarArg <em>Var Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Arg</em>'.
	 * @see org.summer.dsl.model.ss.XtendParameter#isVarArg()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EAttribute getXtendParameter_VarArg();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendParameter#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.summer.dsl.model.ss.XtendParameter#isExtension()
	 * @see #getXtendParameter()
	 * @generated
	 */
	EAttribute getXtendParameter_Extension();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.RichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String</em>'.
	 * @see org.summer.dsl.model.ss.RichString
	 * @generated
	 */
	EClass getRichString();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String Literal</em>'.
	 * @see org.summer.dsl.model.ss.RichStringLiteral
	 * @generated
	 */
	EClass getRichStringLiteral();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.RichStringForLoop <em>Rich String For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String For Loop</em>'.
	 * @see org.summer.dsl.model.ss.RichStringForLoop
	 * @generated
	 */
	EClass getRichStringForLoop();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringForLoop#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Separator</em>'.
	 * @see org.summer.dsl.model.ss.RichStringForLoop#getSeparator()
	 * @see #getRichStringForLoop()
	 * @generated
	 */
	EReference getRichStringForLoop_Separator();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringForLoop#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Before</em>'.
	 * @see org.summer.dsl.model.ss.RichStringForLoop#getBefore()
	 * @see #getRichStringForLoop()
	 * @generated
	 */
	EReference getRichStringForLoop_Before();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringForLoop#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>After</em>'.
	 * @see org.summer.dsl.model.ss.RichStringForLoop#getAfter()
	 * @see #getRichStringForLoop()
	 * @generated
	 */
	EReference getRichStringForLoop_After();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.RichStringIf <em>Rich String If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String If</em>'.
	 * @see org.summer.dsl.model.ss.RichStringIf
	 * @generated
	 */
	EClass getRichStringIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringIf#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.summer.dsl.model.ss.RichStringIf#getIf()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringIf#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.summer.dsl.model.ss.RichStringIf#getThen()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_Then();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.RichStringIf#getElseIfs <em>Else Ifs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Else Ifs</em>'.
	 * @see org.summer.dsl.model.ss.RichStringIf#getElseIfs()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_ElseIfs();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringIf#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.summer.dsl.model.ss.RichStringIf#getElse()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_Else();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.RichStringElseIf <em>Rich String Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String Else If</em>'.
	 * @see org.summer.dsl.model.ss.RichStringElseIf
	 * @generated
	 */
	EClass getRichStringElseIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringElseIf#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.summer.dsl.model.ss.RichStringElseIf#getIf()
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	EReference getRichStringElseIf_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.RichStringElseIf#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.summer.dsl.model.ss.RichStringElseIf#getThen()
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	EReference getRichStringElseIf_Then();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.CreateExtensionInfo <em>Create Extension Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Extension Info</em>'.
	 * @see org.summer.dsl.model.ss.CreateExtensionInfo
	 * @generated
	 */
	EClass getCreateExtensionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Create Expression</em>'.
	 * @see org.summer.dsl.model.ss.CreateExtensionInfo#getCreateExpression()
	 * @see #getCreateExtensionInfo()
	 * @generated
	 */
	EReference getCreateExtensionInfo_CreateExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.CreateExtensionInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.ss.CreateExtensionInfo#getName()
	 * @see #getCreateExtensionInfo()
	 * @generated
	 */
	EAttribute getCreateExtensionInfo_Name();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendConstructor <em>Xtend Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Constructor</em>'.
	 * @see org.summer.dsl.model.ss.XtendConstructor
	 * @generated
	 */
	EClass getXtendConstructor();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendConstructor#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.ss.XtendConstructor#getExpression()
	 * @see #getXtendConstructor()
	 * @generated
	 */
	EReference getXtendConstructor_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendConstructor#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendConstructor#getParameters()
	 * @see #getXtendConstructor()
	 * @generated
	 */
	EReference getXtendConstructor_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendConstructor#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendConstructor#getTypeParameters()
	 * @see #getXtendConstructor()
	 * @generated
	 */
	EReference getXtendConstructor_TypeParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendConstructor#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.summer.dsl.model.ss.XtendConstructor#getExceptions()
	 * @see #getXtendConstructor()
	 * @generated
	 */
	EReference getXtendConstructor_Exceptions();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendTypeDeclaration <em>Xtend Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Type Declaration</em>'.
	 * @see org.summer.dsl.model.ss.XtendTypeDeclaration
	 * @generated
	 */
	EClass getXtendTypeDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendTypeDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.ss.XtendTypeDeclaration#getName()
	 * @see #getXtendTypeDeclaration()
	 * @generated
	 */
	EAttribute getXtendTypeDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendTypeDeclaration#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.summer.dsl.model.ss.XtendTypeDeclaration#getMembers()
	 * @see #getXtendTypeDeclaration()
	 * @generated
	 */
	EReference getXtendTypeDeclaration_Members();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendAnnotationType <em>Xtend Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Annotation Type</em>'.
	 * @see org.summer.dsl.model.ss.XtendAnnotationType
	 * @generated
	 */
	EClass getXtendAnnotationType();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendInterface <em>Xtend Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Interface</em>'.
	 * @see org.summer.dsl.model.ss.XtendInterface
	 * @generated
	 */
	EClass getXtendInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendInterface#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.summer.dsl.model.ss.XtendInterface#getExtends()
	 * @see #getXtendInterface()
	 * @generated
	 */
	EReference getXtendInterface_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendInterface#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendInterface#getTypeParameters()
	 * @see #getXtendInterface()
	 * @generated
	 */
	EReference getXtendInterface_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendEnum <em>Xtend Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Enum</em>'.
	 * @see org.summer.dsl.model.ss.XtendEnum
	 * @generated
	 */
	EClass getXtendEnum();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendEnumLiteral <em>Xtend Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Enum Literal</em>'.
	 * @see org.summer.dsl.model.ss.XtendEnumLiteral
	 * @generated
	 */
	EClass getXtendEnumLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendEnumLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.ss.XtendEnumLiteral#getName()
	 * @see #getXtendEnumLiteral()
	 * @generated
	 */
	EAttribute getXtendEnumLiteral_Name();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendVariableDeclaration <em>Xtend Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Variable Declaration</em>'.
	 * @see org.summer.dsl.model.ss.XtendVariableDeclaration
	 * @generated
	 */
	EClass getXtendVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendVariableDeclaration#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.summer.dsl.model.ss.XtendVariableDeclaration#isExtension()
	 * @see #getXtendVariableDeclaration()
	 * @generated
	 */
	EAttribute getXtendVariableDeclaration_Extension();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendFormalParameter <em>Xtend Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Formal Parameter</em>'.
	 * @see org.summer.dsl.model.ss.XtendFormalParameter
	 * @generated
	 */
	EClass getXtendFormalParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendFormalParameter#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.summer.dsl.model.ss.XtendFormalParameter#isExtension()
	 * @see #getXtendFormalParameter()
	 * @generated
	 */
	EAttribute getXtendFormalParameter_Extension();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendDelegate <em>Xtend Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Delegate</em>'.
	 * @see org.summer.dsl.model.ss.XtendDelegate
	 * @generated
	 */
	EClass getXtendDelegate();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendDelegate#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.summer.dsl.model.ss.XtendDelegate#getReturnType()
	 * @see #getXtendDelegate()
	 * @generated
	 */
	EReference getXtendDelegate_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendDelegate#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendDelegate#getParameters()
	 * @see #getXtendDelegate()
	 * @generated
	 */
	EReference getXtendDelegate_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendDelegate#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.summer.dsl.model.ss.XtendDelegate#getTypeParameters()
	 * @see #getXtendDelegate()
	 * @generated
	 */
	EReference getXtendDelegate_TypeParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.ss.XtendDelegate#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.summer.dsl.model.ss.XtendDelegate#getExceptions()
	 * @see #getXtendDelegate()
	 * @generated
	 */
	EReference getXtendDelegate_Exceptions();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.ss.XtendEvent <em>Xtend Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Event</em>'.
	 * @see org.summer.dsl.model.ss.XtendEvent
	 * @generated
	 */
	EClass getXtendEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.ss.XtendEvent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.ss.XtendEvent#getName()
	 * @see #getXtendEvent()
	 * @generated
	 */
	EAttribute getXtendEvent_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.ss.XtendEvent#getType()
	 * @see #getXtendEvent()
	 * @generated
	 */
	EReference getXtendEvent_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.ss.XtendEvent#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see org.summer.dsl.model.ss.XtendEvent#getInitialValue()
	 * @see #getXtendEvent()
	 * @generated
	 */
	EReference getXtendEvent_InitialValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SsFactory getSsFactory();

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
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XModuleImpl <em>XModule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XModuleImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXModule()
		 * @generated
		 */
		EClass XMODULE = eINSTANCE.getXModule();

		/**
		 * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMODULE__IMPORT_SECTION = eINSTANCE.getXModule_ImportSection();

		/**
		 * The meta object literal for the '<em><b>Xtend Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMODULE__XTEND_TYPES = eINSTANCE.getXModule_XtendTypes();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMODULE__PACKAGE = eINSTANCE.getXModule_Package();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMODULE__CONTENTS = eINSTANCE.getXModule_Contents();

		/**
		 * The meta object literal for the '<em><b>Export Section</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMODULE__EXPORT_SECTION = eINSTANCE.getXModule_ExportSection();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendClassImpl <em>Xtend Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendClassImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendClass()
		 * @generated
		 */
		EClass XTEND_CLASS = eINSTANCE.getXtendClass();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__EXTENDS = eINSTANCE.getXtendClass_Extends();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__IMPLEMENTS = eINSTANCE.getXtendClass_Implements();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__TYPE_PARAMETERS = eINSTANCE.getXtendClass_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendAnnotationTargetImpl <em>Xtend Annotation Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendAnnotationTargetImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendAnnotationTarget()
		 * @generated
		 */
		EClass XTEND_ANNOTATION_TARGET = eINSTANCE.getXtendAnnotationTarget();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_ANNOTATION_TARGET__ANNOTATIONS = eINSTANCE.getXtendAnnotationTarget_Annotations();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendMemberImpl <em>Xtend Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendMemberImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendMember()
		 * @generated
		 */
		EClass XTEND_MEMBER = eINSTANCE.getXtendMember();

		/**
		 * The meta object literal for the '<em><b>Annotation Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_MEMBER__ANNOTATION_INFO = eINSTANCE.getXtendMember_AnnotationInfo();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_MEMBER__MODIFIERS = eINSTANCE.getXtendMember_Modifiers();

		/**
		 * The meta object literal for the '<em><b>Declaring Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_MEMBER__DECLARING_TYPE = eINSTANCE.getXtendMember_DeclaringType();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendFunctionImpl <em>Xtend Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendFunctionImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendFunction()
		 * @generated
		 */
		EClass XTEND_FUNCTION = eINSTANCE.getXtendFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FUNCTION__NAME = eINSTANCE.getXtendFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__EXPRESSION = eINSTANCE.getXtendFunction_Expression();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__RETURN_TYPE = eINSTANCE.getXtendFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__PARAMETERS = eINSTANCE.getXtendFunction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Create Extension Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__CREATE_EXTENSION_INFO = eINSTANCE.getXtendFunction_CreateExtensionInfo();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__TYPE_PARAMETERS = eINSTANCE.getXtendFunction_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__EXCEPTIONS = eINSTANCE.getXtendFunction_Exceptions();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendFieldImpl <em>Xtend Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendFieldImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendField()
		 * @generated
		 */
		EClass XTEND_FIELD = eINSTANCE.getXtendField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FIELD__NAME = eINSTANCE.getXtendField_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FIELD__TYPE = eINSTANCE.getXtendField_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FIELD__INITIAL_VALUE = eINSTANCE.getXtendField_InitialValue();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendParameterImpl <em>Xtend Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendParameterImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendParameter()
		 * @generated
		 */
		EClass XTEND_PARAMETER = eINSTANCE.getXtendParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_PARAMETER__NAME = eINSTANCE.getXtendParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_PARAMETER__PARAMETER_TYPE = eINSTANCE.getXtendParameter_ParameterType();

		/**
		 * The meta object literal for the '<em><b>Var Arg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_PARAMETER__VAR_ARG = eINSTANCE.getXtendParameter_VarArg();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_PARAMETER__EXTENSION = eINSTANCE.getXtendParameter_Extension();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.RichStringImpl <em>Rich String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.RichStringImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichString()
		 * @generated
		 */
		EClass RICH_STRING = eINSTANCE.getRichString();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.RichStringLiteralImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringLiteral()
		 * @generated
		 */
		EClass RICH_STRING_LITERAL = eINSTANCE.getRichStringLiteral();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.RichStringForLoopImpl <em>Rich String For Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.RichStringForLoopImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringForLoop()
		 * @generated
		 */
		EClass RICH_STRING_FOR_LOOP = eINSTANCE.getRichStringForLoop();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_FOR_LOOP__SEPARATOR = eINSTANCE.getRichStringForLoop_Separator();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_FOR_LOOP__BEFORE = eINSTANCE.getRichStringForLoop_Before();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_FOR_LOOP__AFTER = eINSTANCE.getRichStringForLoop_After();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.RichStringIfImpl <em>Rich String If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.RichStringIfImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringIf()
		 * @generated
		 */
		EClass RICH_STRING_IF = eINSTANCE.getRichStringIf();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__IF = eINSTANCE.getRichStringIf_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__THEN = eINSTANCE.getRichStringIf_Then();

		/**
		 * The meta object literal for the '<em><b>Else Ifs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__ELSE_IFS = eINSTANCE.getRichStringIf_ElseIfs();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__ELSE = eINSTANCE.getRichStringIf_Else();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.RichStringElseIfImpl <em>Rich String Else If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.RichStringElseIfImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getRichStringElseIf()
		 * @generated
		 */
		EClass RICH_STRING_ELSE_IF = eINSTANCE.getRichStringElseIf();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_ELSE_IF__IF = eINSTANCE.getRichStringElseIf_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_ELSE_IF__THEN = eINSTANCE.getRichStringElseIf_Then();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.CreateExtensionInfoImpl <em>Create Extension Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.CreateExtensionInfoImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getCreateExtensionInfo()
		 * @generated
		 */
		EClass CREATE_EXTENSION_INFO = eINSTANCE.getCreateExtensionInfo();

		/**
		 * The meta object literal for the '<em><b>Create Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_EXTENSION_INFO__CREATE_EXPRESSION = eINSTANCE.getCreateExtensionInfo_CreateExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_EXTENSION_INFO__NAME = eINSTANCE.getCreateExtensionInfo_Name();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendConstructorImpl <em>Xtend Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendConstructorImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendConstructor()
		 * @generated
		 */
		EClass XTEND_CONSTRUCTOR = eINSTANCE.getXtendConstructor();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CONSTRUCTOR__EXPRESSION = eINSTANCE.getXtendConstructor_Expression();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CONSTRUCTOR__PARAMETERS = eINSTANCE.getXtendConstructor_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CONSTRUCTOR__TYPE_PARAMETERS = eINSTANCE.getXtendConstructor_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CONSTRUCTOR__EXCEPTIONS = eINSTANCE.getXtendConstructor_Exceptions();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendTypeDeclarationImpl <em>Xtend Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendTypeDeclarationImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendTypeDeclaration()
		 * @generated
		 */
		EClass XTEND_TYPE_DECLARATION = eINSTANCE.getXtendTypeDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_TYPE_DECLARATION__NAME = eINSTANCE.getXtendTypeDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_TYPE_DECLARATION__MEMBERS = eINSTANCE.getXtendTypeDeclaration_Members();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendAnnotationTypeImpl <em>Xtend Annotation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendAnnotationTypeImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendAnnotationType()
		 * @generated
		 */
		EClass XTEND_ANNOTATION_TYPE = eINSTANCE.getXtendAnnotationType();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendInterfaceImpl <em>Xtend Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendInterfaceImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendInterface()
		 * @generated
		 */
		EClass XTEND_INTERFACE = eINSTANCE.getXtendInterface();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_INTERFACE__EXTENDS = eINSTANCE.getXtendInterface_Extends();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_INTERFACE__TYPE_PARAMETERS = eINSTANCE.getXtendInterface_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendEnumImpl <em>Xtend Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendEnumImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendEnum()
		 * @generated
		 */
		EClass XTEND_ENUM = eINSTANCE.getXtendEnum();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendEnumLiteralImpl <em>Xtend Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendEnumLiteralImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendEnumLiteral()
		 * @generated
		 */
		EClass XTEND_ENUM_LITERAL = eINSTANCE.getXtendEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_ENUM_LITERAL__NAME = eINSTANCE.getXtendEnumLiteral_Name();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendVariableDeclarationImpl <em>Xtend Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendVariableDeclarationImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendVariableDeclaration()
		 * @generated
		 */
		EClass XTEND_VARIABLE_DECLARATION = eINSTANCE.getXtendVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_VARIABLE_DECLARATION__EXTENSION = eINSTANCE.getXtendVariableDeclaration_Extension();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendFormalParameterImpl <em>Xtend Formal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendFormalParameterImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendFormalParameter()
		 * @generated
		 */
		EClass XTEND_FORMAL_PARAMETER = eINSTANCE.getXtendFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FORMAL_PARAMETER__EXTENSION = eINSTANCE.getXtendFormalParameter_Extension();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendDelegateImpl <em>Xtend Delegate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendDelegateImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendDelegate()
		 * @generated
		 */
		EClass XTEND_DELEGATE = eINSTANCE.getXtendDelegate();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_DELEGATE__RETURN_TYPE = eINSTANCE.getXtendDelegate_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_DELEGATE__PARAMETERS = eINSTANCE.getXtendDelegate_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_DELEGATE__TYPE_PARAMETERS = eINSTANCE.getXtendDelegate_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_DELEGATE__EXCEPTIONS = eINSTANCE.getXtendDelegate_Exceptions();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.ss.impl.XtendEventImpl <em>Xtend Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.ss.impl.XtendEventImpl
		 * @see org.summer.dsl.model.ss.impl.SsPackageImpl#getXtendEvent()
		 * @generated
		 */
		EClass XTEND_EVENT = eINSTANCE.getXtendEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_EVENT__NAME = eINSTANCE.getXtendEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_EVENT__TYPE = eINSTANCE.getXtendEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_EVENT__INITIAL_VALUE = eINSTANCE.getXtendEvent_InitialValue();

	}

} //SsPackage
