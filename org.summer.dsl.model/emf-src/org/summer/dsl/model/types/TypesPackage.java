/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.summer.dsl.model.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.summer.org/dsl/model/types";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "types";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesPackage eINSTANCE = org.summer.dsl.model.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmIdentifiableElementImpl <em>Jvm Identifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmIdentifiableElementImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmIdentifiableElement()
	 * @generated
	 */
	int JVM_IDENTIFIABLE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Jvm Identifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmModuleImpl <em>Jvm Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmModuleImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmModule()
	 * @generated
	 */
	int JVM_MODULE = 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmNoModuleImpl <em>Jvm No Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmNoModuleImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmNoModule()
	 * @generated
	 */
	int JVM_NO_MODULE = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmTypeImpl <em>Jvm Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmType()
	 * @generated
	 */
	int JVM_TYPE = 3;

	/**
	 * The number of structural features of the '<em>Jvm Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_FEATURE_COUNT = JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MODULE__SIMPLE_NAME = JVM_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Import Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MODULE__IMPORT_SECTION = JVM_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MODULE__CONTENTS = JVM_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Export Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MODULE__EXPORT_SECTION = JVM_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Jvm Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MODULE_FEATURE_COUNT = JVM_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Import Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_NO_MODULE__IMPORT_SECTION = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_NO_MODULE__CONTENTS = 1;

	/**
	 * The number of structural features of the '<em>Jvm No Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_NO_MODULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmVoidImpl <em>Jvm Void</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmVoidImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmVoid()
	 * @generated
	 */
	int JVM_VOID = 4;

	/**
	 * The number of structural features of the '<em>Jvm Void</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_VOID_FEATURE_COUNT = JVM_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmComponentTypeImpl <em>Jvm Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmComponentTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmComponentType()
	 * @generated
	 */
	int JVM_COMPONENT_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPONENT_TYPE__ARRAY_TYPE = JVM_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPONENT_TYPE_FEATURE_COUNT = JVM_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmPrimitiveTypeImpl <em>Jvm Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmPrimitiveTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmPrimitiveType()
	 * @generated
	 */
	int JVM_PRIMITIVE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PRIMITIVE_TYPE__ARRAY_TYPE = JVM_COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PRIMITIVE_TYPE__SIMPLE_NAME = JVM_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PRIMITIVE_TYPE_FEATURE_COUNT = JVM_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmArrayTypeImpl <em>Jvm Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmArrayTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmArrayType()
	 * @generated
	 */
	int JVM_ARRAY_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ARRAY_TYPE__ARRAY_TYPE = JVM_COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ARRAY_TYPE__COMPONENT_TYPE = JVM_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ARRAY_TYPE_FEATURE_COUNT = JVM_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationTargetImpl <em>Jvm Annotation Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmAnnotationTargetImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationTarget()
	 * @generated
	 */
	int JVM_ANNOTATION_TARGET = 33;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TARGET__ANNOTATIONS = JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TARGET_FEATURE_COUNT = JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmMemberImpl <em>Jvm Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmMemberImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmMember()
	 * @generated
	 */
	int JVM_MEMBER = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__ANNOTATIONS = JVM_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__DECLARING_TYPE = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__VISIBILITY = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__SIMPLE_NAME = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__IDENTIFIER = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__ANNOTATION_INFO = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER__MODIFIERS = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Jvm Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MEMBER_FEATURE_COUNT = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl <em>Jvm Declared Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmDeclaredType()
	 * @generated
	 */
	int JVM_DECLARED_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__ANNOTATIONS = JVM_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__DECLARING_TYPE = JVM_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__VISIBILITY = JVM_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__SIMPLE_NAME = JVM_MEMBER__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__IDENTIFIER = JVM_MEMBER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__ANNOTATION_INFO = JVM_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__MODIFIERS = JVM_MEMBER__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__ARRAY_TYPE = JVM_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__SUPER_TYPES = JVM_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__MEMBERS = JVM_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__ABSTRACT = JVM_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__STATIC = JVM_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__FINAL = JVM_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__PACKAGE_NAME = JVM_MEMBER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE__EXPORTED = JVM_MEMBER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Jvm Declared Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DECLARED_TYPE_FEATURE_COUNT = JVM_MEMBER_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmStructTypeImpl <em>Jvm Struct Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmStructTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmStructType()
	 * @generated
	 */
	int JVM_STRUCT_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__ANNOTATIONS = JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__DECLARING_TYPE = JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__VISIBILITY = JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__SIMPLE_NAME = JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__IDENTIFIER = JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__ANNOTATION_INFO = JVM_DECLARED_TYPE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__MODIFIERS = JVM_DECLARED_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__ARRAY_TYPE = JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__SUPER_TYPES = JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__MEMBERS = JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__ABSTRACT = JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__STATIC = JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__FINAL = JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__PACKAGE_NAME = JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__EXPORTED = JVM_DECLARED_TYPE__EXPORTED;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__TYPE_PARAMETERS = JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__IMPLEMENTS = JVM_DECLARED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE__PARAMETERS = JVM_DECLARED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Jvm Struct Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRUCT_TYPE_FEATURE_COUNT = JVM_DECLARED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmTypeParameterImpl <em>Jvm Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmTypeParameterImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeParameter()
	 * @generated
	 */
	int JVM_TYPE_PARAMETER = 10;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__ARRAY_TYPE = JVM_COMPONENT_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__CONSTRAINTS = JVM_COMPONENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__NAME = JVM_COMPONENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declarator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER__DECLARATOR = JVM_COMPONENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Jvm Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER_FEATURE_COUNT = JVM_COMPONENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmTypeParameterDeclaratorImpl <em>Jvm Type Parameter Declarator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmTypeParameterDeclaratorImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeParameterDeclarator()
	 * @generated
	 */
	int JVM_TYPE_PARAMETER_DECLARATOR = 11;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Jvm Type Parameter Declarator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_PARAMETER_DECLARATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmConstraintOwnerImpl <em>Jvm Constraint Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmConstraintOwnerImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmConstraintOwner()
	 * @generated
	 */
	int JVM_CONSTRAINT_OWNER = 12;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRAINT_OWNER__CONSTRAINTS = 0;

	/**
	 * The number of structural features of the '<em>Jvm Constraint Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRAINT_OWNER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmTypeConstraintImpl <em>Jvm Type Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmTypeConstraintImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeConstraint()
	 * @generated
	 */
	int JVM_TYPE_CONSTRAINT = 13;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_CONSTRAINT__TYPE_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_CONSTRAINT__OWNER = 1;

	/**
	 * The number of structural features of the '<em>Jvm Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmUpperBoundImpl <em>Jvm Upper Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmUpperBoundImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmUpperBound()
	 * @generated
	 */
	int JVM_UPPER_BOUND = 14;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UPPER_BOUND__TYPE_REFERENCE = JVM_TYPE_CONSTRAINT__TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UPPER_BOUND__OWNER = JVM_TYPE_CONSTRAINT__OWNER;

	/**
	 * The number of structural features of the '<em>Jvm Upper Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UPPER_BOUND_FEATURE_COUNT = JVM_TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmLowerBoundImpl <em>Jvm Lower Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmLowerBoundImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmLowerBound()
	 * @generated
	 */
	int JVM_LOWER_BOUND = 15;

	/**
	 * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LOWER_BOUND__TYPE_REFERENCE = JVM_TYPE_CONSTRAINT__TYPE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LOWER_BOUND__OWNER = JVM_TYPE_CONSTRAINT__OWNER;

	/**
	 * The number of structural features of the '<em>Jvm Lower Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LOWER_BOUND_FEATURE_COUNT = JVM_TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationTypeImpl <em>Jvm Annotation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmAnnotationTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationType()
	 * @generated
	 */
	int JVM_ANNOTATION_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__ANNOTATIONS = JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__DECLARING_TYPE = JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__VISIBILITY = JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__SIMPLE_NAME = JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__IDENTIFIER = JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__ANNOTATION_INFO = JVM_DECLARED_TYPE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__MODIFIERS = JVM_DECLARED_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__ARRAY_TYPE = JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__SUPER_TYPES = JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__MEMBERS = JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__ABSTRACT = JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__STATIC = JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__FINAL = JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__PACKAGE_NAME = JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE__EXPORTED = JVM_DECLARED_TYPE__EXPORTED;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_TYPE_FEATURE_COUNT = JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmEnumerationTypeImpl <em>Jvm Enumeration Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmEnumerationTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmEnumerationType()
	 * @generated
	 */
	int JVM_ENUMERATION_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__ANNOTATIONS = JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__DECLARING_TYPE = JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__VISIBILITY = JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__SIMPLE_NAME = JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__IDENTIFIER = JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__ANNOTATION_INFO = JVM_DECLARED_TYPE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__MODIFIERS = JVM_DECLARED_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__ARRAY_TYPE = JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__SUPER_TYPES = JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__MEMBERS = JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__ABSTRACT = JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__STATIC = JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__FINAL = JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__PACKAGE_NAME = JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__EXPORTED = JVM_DECLARED_TYPE__EXPORTED;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE__LITERALS = JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_TYPE_FEATURE_COUNT = JVM_DECLARED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmFeatureImpl <em>Jvm Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmFeatureImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmFeature()
	 * @generated
	 */
	int JVM_FEATURE = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__ANNOTATIONS = JVM_MEMBER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__DECLARING_TYPE = JVM_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__VISIBILITY = JVM_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__SIMPLE_NAME = JVM_MEMBER__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__IDENTIFIER = JVM_MEMBER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__ANNOTATION_INFO = JVM_MEMBER__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE__MODIFIERS = JVM_MEMBER__MODIFIERS;

	/**
	 * The number of structural features of the '<em>Jvm Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FEATURE_FEATURE_COUNT = JVM_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmFieldImpl <em>Jvm Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmFieldImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmField()
	 * @generated
	 */
	int JVM_FIELD = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__ANNOTATIONS = JVM_FEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__DECLARING_TYPE = JVM_FEATURE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__VISIBILITY = JVM_FEATURE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__SIMPLE_NAME = JVM_FEATURE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__IDENTIFIER = JVM_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__ANNOTATION_INFO = JVM_FEATURE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__MODIFIERS = JVM_FEATURE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__STATIC = JVM_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__FINAL = JVM_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__TYPE = JVM_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__VOLATILE = JVM_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__TRANSIENT = JVM_FEATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__DEFAULT_VALUE = JVM_FEATURE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__SET = JVM_FEATURE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Get</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD__GET = JVM_FEATURE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Jvm Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FIELD_FEATURE_COUNT = JVM_FEATURE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmEnumerationLiteralImpl <em>Jvm Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmEnumerationLiteralImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmEnumerationLiteral()
	 * @generated
	 */
	int JVM_ENUMERATION_LITERAL = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__ANNOTATIONS = JVM_FIELD__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__DECLARING_TYPE = JVM_FIELD__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__VISIBILITY = JVM_FIELD__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__SIMPLE_NAME = JVM_FIELD__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__IDENTIFIER = JVM_FIELD__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__ANNOTATION_INFO = JVM_FIELD__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__MODIFIERS = JVM_FIELD__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__STATIC = JVM_FIELD__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__FINAL = JVM_FIELD__FINAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__TYPE = JVM_FIELD__TYPE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__VOLATILE = JVM_FIELD__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__TRANSIENT = JVM_FIELD__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__DEFAULT_VALUE = JVM_FIELD__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__SET = JVM_FIELD__SET;

	/**
	 * The feature id for the '<em><b>Get</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__GET = JVM_FIELD__GET;

	/**
	 * The feature id for the '<em><b>Ordinal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL__ORDINAL = JVM_FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUMERATION_LITERAL_FEATURE_COUNT = JVM_FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmGenericTypeImpl <em>Jvm Generic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmGenericTypeImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmGenericType()
	 * @generated
	 */
	int JVM_GENERIC_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ANNOTATIONS = JVM_DECLARED_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__DECLARING_TYPE = JVM_DECLARED_TYPE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__VISIBILITY = JVM_DECLARED_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__SIMPLE_NAME = JVM_DECLARED_TYPE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__IDENTIFIER = JVM_DECLARED_TYPE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ANNOTATION_INFO = JVM_DECLARED_TYPE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__MODIFIERS = JVM_DECLARED_TYPE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ARRAY_TYPE = JVM_DECLARED_TYPE__ARRAY_TYPE;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__SUPER_TYPES = JVM_DECLARED_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__MEMBERS = JVM_DECLARED_TYPE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__ABSTRACT = JVM_DECLARED_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__STATIC = JVM_DECLARED_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__FINAL = JVM_DECLARED_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__PACKAGE_NAME = JVM_DECLARED_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__EXPORTED = JVM_DECLARED_TYPE__EXPORTED;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__TYPE_PARAMETERS = JVM_DECLARED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__INTERFACE = JVM_DECLARED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__STRICT_FLOATING_POINT = JVM_DECLARED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__EXTENDS = JVM_DECLARED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE__IMPLEMENTS = JVM_DECLARED_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Jvm Generic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_TYPE_FEATURE_COUNT = JVM_DECLARED_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmTypeReferenceImpl <em>Jvm Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeReference()
	 * @generated
	 */
	int JVM_TYPE_REFERENCE = 20;

	/**
	 * The number of structural features of the '<em>Jvm Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_REFERENCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmParameterizedTypeReferenceImpl <em>Jvm Parameterized Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmParameterizedTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmParameterizedTypeReference()
	 * @generated
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE = 21;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Jvm Parameterized Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_PARAMETERIZED_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmGenericArrayTypeReferenceImpl <em>Jvm Generic Array Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmGenericArrayTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmGenericArrayTypeReference()
	 * @generated
	 */
	int JVM_GENERIC_ARRAY_TYPE_REFERENCE = 22;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Generic Array Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_GENERIC_ARRAY_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmWildcardTypeReferenceImpl <em>Jvm Wildcard Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmWildcardTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmWildcardTypeReference()
	 * @generated
	 */
	int JVM_WILDCARD_TYPE_REFERENCE = 23;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Wildcard Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_WILDCARD_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmAnyTypeReferenceImpl <em>Jvm Any Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmAnyTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnyTypeReference()
	 * @generated
	 */
	int JVM_ANY_TYPE_REFERENCE = 24;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANY_TYPE_REFERENCE__TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Any Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANY_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmCompoundTypeReferenceImpl <em>Jvm Compound Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmCompoundTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmCompoundTypeReference()
	 * @generated
	 */
	int JVM_COMPOUND_TYPE_REFERENCE = 52;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPOUND_TYPE_REFERENCE__TYPE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPOUND_TYPE_REFERENCE__REFERENCES = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Jvm Compound Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_COMPOUND_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmMultiTypeReferenceImpl <em>Jvm Multi Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmMultiTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmMultiTypeReference()
	 * @generated
	 */
	int JVM_MULTI_TYPE_REFERENCE = 25;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MULTI_TYPE_REFERENCE__TYPE = JVM_COMPOUND_TYPE_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MULTI_TYPE_REFERENCE__REFERENCES = JVM_COMPOUND_TYPE_REFERENCE__REFERENCES;

	/**
	 * The number of structural features of the '<em>Jvm Multi Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_MULTI_TYPE_REFERENCE_FEATURE_COUNT = JVM_COMPOUND_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmExecutableImpl <em>Jvm Executable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmExecutableImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmExecutable()
	 * @generated
	 */
	int JVM_EXECUTABLE = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__ANNOTATIONS = JVM_FEATURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__DECLARING_TYPE = JVM_FEATURE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__VISIBILITY = JVM_FEATURE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__SIMPLE_NAME = JVM_FEATURE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__IDENTIFIER = JVM_FEATURE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__ANNOTATION_INFO = JVM_FEATURE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__MODIFIERS = JVM_FEATURE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__TYPE_PARAMETERS = JVM_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__PARAMETERS = JVM_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__EXCEPTIONS = JVM_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE__VAR_ARGS = JVM_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Jvm Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_EXECUTABLE_FEATURE_COUNT = JVM_FEATURE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmConstructorImpl <em>Jvm Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmConstructorImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmConstructor()
	 * @generated
	 */
	int JVM_CONSTRUCTOR = 30;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__ANNOTATIONS = JVM_EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__DECLARING_TYPE = JVM_EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__VISIBILITY = JVM_EXECUTABLE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__SIMPLE_NAME = JVM_EXECUTABLE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__IDENTIFIER = JVM_EXECUTABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__ANNOTATION_INFO = JVM_EXECUTABLE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__MODIFIERS = JVM_EXECUTABLE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__TYPE_PARAMETERS = JVM_EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__PARAMETERS = JVM_EXECUTABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__EXCEPTIONS = JVM_EXECUTABLE__EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__VAR_ARGS = JVM_EXECUTABLE__VAR_ARGS;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR__EXPRESSION = JVM_EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONSTRUCTOR_FEATURE_COUNT = JVM_EXECUTABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmOperationImpl <em>Jvm Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmOperationImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmOperation()
	 * @generated
	 */
	int JVM_OPERATION = 31;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__ANNOTATIONS = JVM_EXECUTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__DECLARING_TYPE = JVM_EXECUTABLE__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__VISIBILITY = JVM_EXECUTABLE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__SIMPLE_NAME = JVM_EXECUTABLE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__IDENTIFIER = JVM_EXECUTABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__ANNOTATION_INFO = JVM_EXECUTABLE__ANNOTATION_INFO;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__MODIFIERS = JVM_EXECUTABLE__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__TYPE_PARAMETERS = JVM_EXECUTABLE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__PARAMETERS = JVM_EXECUTABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__EXCEPTIONS = JVM_EXECUTABLE__EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__VAR_ARGS = JVM_EXECUTABLE__VAR_ARGS;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__STATIC = JVM_EXECUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__FINAL = JVM_EXECUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__ABSTRACT = JVM_EXECUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__RETURN_TYPE = JVM_EXECUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__DEFAULT_VALUE = JVM_EXECUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__SYNCHRONIZED = JVM_EXECUTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__DEFAULT = JVM_EXECUTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__NATIVE = JVM_EXECUTABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__STRICT_FLOATING_POINT = JVM_EXECUTABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__EXPRESSION = JVM_EXECUTABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__FUNCTION = JVM_EXECUTABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Overload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION__OVERLOAD = JVM_EXECUTABLE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Jvm Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_OPERATION_FEATURE_COUNT = JVM_EXECUTABLE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmFormalParameterImpl <em>Jvm Formal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmFormalParameterImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmFormalParameter()
	 * @generated
	 */
	int JVM_FORMAL_PARAMETER = 32;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__ANNOTATIONS = JVM_ANNOTATION_TARGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__NAME = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__PARAMETER_TYPE = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var Arg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__VAR_ARG = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER__DEFAULT_VALUE = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Jvm Formal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FORMAL_PARAMETER_FEATURE_COUNT = JVM_ANNOTATION_TARGET_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationReferenceImpl <em>Jvm Annotation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmAnnotationReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationReference()
	 * @generated
	 */
	int JVM_ANNOTATION_REFERENCE = 34;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_REFERENCE__ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_REFERENCE__VALUES = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_REFERENCE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationValueImpl <em>Jvm Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationValue()
	 * @generated
	 */
	int JVM_ANNOTATION_VALUE = 35;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_VALUE__FIELD = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmIntAnnotationValueImpl <em>Jvm Int Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmIntAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmIntAnnotationValue()
	 * @generated
	 */
	int JVM_INT_ANNOTATION_VALUE = 36;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INT_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INT_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INT_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Int Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_INT_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmBooleanAnnotationValueImpl <em>Jvm Boolean Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmBooleanAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmBooleanAnnotationValue()
	 * @generated
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE = 37;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Boolean Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BOOLEAN_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmByteAnnotationValueImpl <em>Jvm Byte Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmByteAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmByteAnnotationValue()
	 * @generated
	 */
	int JVM_BYTE_ANNOTATION_VALUE = 38;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BYTE_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BYTE_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BYTE_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Byte Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_BYTE_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmShortAnnotationValueImpl <em>Jvm Short Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmShortAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmShortAnnotationValue()
	 * @generated
	 */
	int JVM_SHORT_ANNOTATION_VALUE = 39;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SHORT_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SHORT_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SHORT_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Short Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SHORT_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmLongAnnotationValueImpl <em>Jvm Long Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmLongAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmLongAnnotationValue()
	 * @generated
	 */
	int JVM_LONG_ANNOTATION_VALUE = 40;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LONG_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LONG_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LONG_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Long Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_LONG_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmDoubleAnnotationValueImpl <em>Jvm Double Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmDoubleAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmDoubleAnnotationValue()
	 * @generated
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE = 41;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Double Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DOUBLE_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmFloatAnnotationValueImpl <em>Jvm Float Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmFloatAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmFloatAnnotationValue()
	 * @generated
	 */
	int JVM_FLOAT_ANNOTATION_VALUE = 42;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FLOAT_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FLOAT_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FLOAT_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Float Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_FLOAT_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmCharAnnotationValueImpl <em>Jvm Char Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmCharAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmCharAnnotationValue()
	 * @generated
	 */
	int JVM_CHAR_ANNOTATION_VALUE = 43;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CHAR_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CHAR_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CHAR_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Char Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CHAR_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmStringAnnotationValueImpl <em>Jvm String Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmStringAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmStringAnnotationValue()
	 * @generated
	 */
	int JVM_STRING_ANNOTATION_VALUE = 44;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRING_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRING_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRING_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm String Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_STRING_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmTypeAnnotationValueImpl <em>Jvm Type Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmTypeAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeAnnotationValue()
	 * @generated
	 */
	int JVM_TYPE_ANNOTATION_VALUE = 45;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Type Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_TYPE_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationAnnotationValueImpl <em>Jvm Annotation Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmAnnotationAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationAnnotationValue()
	 * @generated
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE = 46;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Annotation Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ANNOTATION_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmEnumAnnotationValueImpl <em>Jvm Enum Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmEnumAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmEnumAnnotationValue()
	 * @generated
	 */
	int JVM_ENUM_ANNOTATION_VALUE = 47;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUM_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUM_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUM_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Enum Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_ENUM_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmDelegateTypeReferenceImpl <em>Jvm Delegate Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmDelegateTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmDelegateTypeReference()
	 * @generated
	 */
	int JVM_DELEGATE_TYPE_REFERENCE = 48;

	/**
	 * The feature id for the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DELEGATE_TYPE_REFERENCE__DELEGATE = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Delegate Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_DELEGATE_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmSpecializedTypeReferenceImpl <em>Jvm Specialized Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmSpecializedTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmSpecializedTypeReference()
	 * @generated
	 */
	int JVM_SPECIALIZED_TYPE_REFERENCE = 49;

	/**
	 * The feature id for the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Specialized Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmSynonymTypeReferenceImpl <em>Jvm Synonym Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmSynonymTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmSynonymTypeReference()
	 * @generated
	 */
	int JVM_SYNONYM_TYPE_REFERENCE = 50;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SYNONYM_TYPE_REFERENCE__TYPE = JVM_COMPOUND_TYPE_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SYNONYM_TYPE_REFERENCE__REFERENCES = JVM_COMPOUND_TYPE_REFERENCE__REFERENCES;

	/**
	 * The number of structural features of the '<em>Jvm Synonym Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_SYNONYM_TYPE_REFERENCE_FEATURE_COUNT = JVM_COMPOUND_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmUnknownTypeReferenceImpl <em>Jvm Unknown Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmUnknownTypeReferenceImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmUnknownTypeReference()
	 * @generated
	 */
	int JVM_UNKNOWN_TYPE_REFERENCE = 51;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME = JVM_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Unknown Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_UNKNOWN_TYPE_REFERENCE_FEATURE_COUNT = JVM_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.impl.JvmCustomAnnotationValueImpl <em>Jvm Custom Annotation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.impl.JvmCustomAnnotationValueImpl
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmCustomAnnotationValue()
	 * @generated
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE = 53;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE__FIELD = JVM_ANNOTATION_VALUE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE__VALUE = JVM_ANNOTATION_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE__VALUES = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Jvm Custom Annotation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CUSTOM_ANNOTATION_VALUE_FEATURE_COUNT = JVM_ANNOTATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.types.JvmVisibility <em>Jvm Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.JvmVisibility
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmVisibility()
	 * @generated
	 */
	int JVM_VISIBILITY = 54;

	/**
	 * The meta object id for the '<em>Iterable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Iterable
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getIterable()
	 * @generated
	 */
	int ITERABLE = 55;

	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getList()
	 * @generated
	 */
	int LIST = 56;

	/**
	 * The meta object id for the '<em>IType Reference Visitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.util.ITypeReferenceVisitor
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getITypeReferenceVisitor()
	 * @generated
	 */
	int ITYPE_REFERENCE_VISITOR = 57;

	/**
	 * The meta object id for the '<em>IType Reference Visitor With Parameter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter
	 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getITypeReferenceVisitorWithParameter()
	 * @generated
	 */
	int ITYPE_REFERENCE_VISITOR_WITH_PARAMETER = 58;


	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Identifiable Element</em>'.
	 * @see org.summer.dsl.model.types.JvmIdentifiableElement
	 * @generated
	 */
	EClass getJvmIdentifiableElement();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmModule <em>Jvm Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Module</em>'.
	 * @see org.summer.dsl.model.types.JvmModule
	 * @generated
	 */
	EClass getJvmModule();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmModule#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.summer.dsl.model.types.JvmModule#getSimpleName()
	 * @see #getJvmModule()
	 * @generated
	 */
	EAttribute getJvmModule_SimpleName();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmModule#getImportSection <em>Import Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Import Section</em>'.
	 * @see org.summer.dsl.model.types.JvmModule#getImportSection()
	 * @see #getJvmModule()
	 * @generated
	 */
	EReference getJvmModule_ImportSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmModule#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.summer.dsl.model.types.JvmModule#getContents()
	 * @see #getJvmModule()
	 * @generated
	 */
	EReference getJvmModule_Contents();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmModule#getExportSection <em>Export Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Export Section</em>'.
	 * @see org.summer.dsl.model.types.JvmModule#getExportSection()
	 * @see #getJvmModule()
	 * @generated
	 */
	EReference getJvmModule_ExportSection();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmNoModule <em>Jvm No Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm No Module</em>'.
	 * @see org.summer.dsl.model.types.JvmNoModule
	 * @generated
	 */
	EClass getJvmNoModule();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmNoModule#getImportSection <em>Import Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Import Section</em>'.
	 * @see org.summer.dsl.model.types.JvmNoModule#getImportSection()
	 * @see #getJvmNoModule()
	 * @generated
	 */
	EReference getJvmNoModule_ImportSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmNoModule#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.summer.dsl.model.types.JvmNoModule#getContents()
	 * @see #getJvmNoModule()
	 * @generated
	 */
	EReference getJvmNoModule_Contents();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmType <em>Jvm Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type</em>'.
	 * @see org.summer.dsl.model.types.JvmType
	 * @generated
	 */
	EClass getJvmType();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmVoid <em>Jvm Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Void</em>'.
	 * @see org.summer.dsl.model.types.JvmVoid
	 * @generated
	 */
	EClass getJvmVoid();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmComponentType <em>Jvm Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Component Type</em>'.
	 * @see org.summer.dsl.model.types.JvmComponentType
	 * @generated
	 */
	EClass getJvmComponentType();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmComponentType#getArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array Type</em>'.
	 * @see org.summer.dsl.model.types.JvmComponentType#getArrayType()
	 * @see #getJvmComponentType()
	 * @generated
	 */
	EReference getJvmComponentType_ArrayType();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmPrimitiveType <em>Jvm Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Primitive Type</em>'.
	 * @see org.summer.dsl.model.types.JvmPrimitiveType
	 * @generated
	 */
	EClass getJvmPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmPrimitiveType#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.summer.dsl.model.types.JvmPrimitiveType#getSimpleName()
	 * @see #getJvmPrimitiveType()
	 * @generated
	 */
	EAttribute getJvmPrimitiveType_SimpleName();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmArrayType <em>Jvm Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Array Type</em>'.
	 * @see org.summer.dsl.model.types.JvmArrayType
	 * @generated
	 */
	EClass getJvmArrayType();

	/**
	 * Returns the meta object for the container reference '{@link org.summer.dsl.model.types.JvmArrayType#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component Type</em>'.
	 * @see org.summer.dsl.model.types.JvmArrayType#getComponentType()
	 * @see #getJvmArrayType()
	 * @generated
	 */
	EReference getJvmArrayType_ComponentType();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmDeclaredType <em>Jvm Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Declared Type</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType
	 * @generated
	 */
	EClass getJvmDeclaredType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmDeclaredType#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Types</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType#getSuperTypes()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EReference getJvmDeclaredType_SuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmDeclaredType#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType#getMembers()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EReference getJvmDeclaredType_Members();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmDeclaredType#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType#isAbstract()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmDeclaredType#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType#isStatic()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmDeclaredType#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType#isFinal()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmDeclaredType#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType#getPackageName()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmDeclaredType#isExported <em>Exported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exported</em>'.
	 * @see org.summer.dsl.model.types.JvmDeclaredType#isExported()
	 * @see #getJvmDeclaredType()
	 * @generated
	 */
	EAttribute getJvmDeclaredType_Exported();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmStructType <em>Jvm Struct Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Struct Type</em>'.
	 * @see org.summer.dsl.model.types.JvmStructType
	 * @generated
	 */
	EClass getJvmStructType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmStructType#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implements</em>'.
	 * @see org.summer.dsl.model.types.JvmStructType#getImplements()
	 * @see #getJvmStructType()
	 * @generated
	 */
	EReference getJvmStructType_Implements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmStructType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.summer.dsl.model.types.JvmStructType#getParameters()
	 * @see #getJvmStructType()
	 * @generated
	 */
	EReference getJvmStructType_Parameters();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmTypeParameter <em>Jvm Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Parameter</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeParameter
	 * @generated
	 */
	EClass getJvmTypeParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmTypeParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeParameter#getName()
	 * @see #getJvmTypeParameter()
	 * @generated
	 */
	EAttribute getJvmTypeParameter_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.summer.dsl.model.types.JvmTypeParameter#getDeclarator <em>Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declarator</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeParameter#getDeclarator()
	 * @see #getJvmTypeParameter()
	 * @generated
	 */
	EReference getJvmTypeParameter_Declarator();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmTypeParameterDeclarator <em>Jvm Type Parameter Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Parameter Declarator</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeParameterDeclarator
	 * @generated
	 */
	EClass getJvmTypeParameterDeclarator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmTypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeParameterDeclarator#getTypeParameters()
	 * @see #getJvmTypeParameterDeclarator()
	 * @generated
	 */
	EReference getJvmTypeParameterDeclarator_TypeParameters();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmConstraintOwner <em>Jvm Constraint Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Constraint Owner</em>'.
	 * @see org.summer.dsl.model.types.JvmConstraintOwner
	 * @generated
	 */
	EClass getJvmConstraintOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmConstraintOwner#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.summer.dsl.model.types.JvmConstraintOwner#getConstraints()
	 * @see #getJvmConstraintOwner()
	 * @generated
	 */
	EReference getJvmConstraintOwner_Constraints();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmTypeConstraint <em>Jvm Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Constraint</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeConstraint
	 * @generated
	 */
	EClass getJvmTypeConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmTypeConstraint#getTypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeConstraint#getTypeReference()
	 * @see #getJvmTypeConstraint()
	 * @generated
	 */
	EReference getJvmTypeConstraint_TypeReference();

	/**
	 * Returns the meta object for the container reference '{@link org.summer.dsl.model.types.JvmTypeConstraint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeConstraint#getOwner()
	 * @see #getJvmTypeConstraint()
	 * @generated
	 */
	EReference getJvmTypeConstraint_Owner();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmUpperBound <em>Jvm Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Upper Bound</em>'.
	 * @see org.summer.dsl.model.types.JvmUpperBound
	 * @generated
	 */
	EClass getJvmUpperBound();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmLowerBound <em>Jvm Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Lower Bound</em>'.
	 * @see org.summer.dsl.model.types.JvmLowerBound
	 * @generated
	 */
	EClass getJvmLowerBound();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmAnnotationType <em>Jvm Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Type</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationType
	 * @generated
	 */
	EClass getJvmAnnotationType();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmEnumerationType <em>Jvm Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Enumeration Type</em>'.
	 * @see org.summer.dsl.model.types.JvmEnumerationType
	 * @generated
	 */
	EClass getJvmEnumerationType();

	/**
	 * Returns the meta object for the reference list '{@link org.summer.dsl.model.types.JvmEnumerationType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Literals</em>'.
	 * @see org.summer.dsl.model.types.JvmEnumerationType#getLiterals()
	 * @see #getJvmEnumerationType()
	 * @generated
	 */
	EReference getJvmEnumerationType_Literals();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmEnumerationLiteral <em>Jvm Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Enumeration Literal</em>'.
	 * @see org.summer.dsl.model.types.JvmEnumerationLiteral
	 * @generated
	 */
	EClass getJvmEnumerationLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmEnumerationLiteral#getOrdinal <em>Ordinal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordinal</em>'.
	 * @see org.summer.dsl.model.types.JvmEnumerationLiteral#getOrdinal()
	 * @see #getJvmEnumerationLiteral()
	 * @generated
	 */
	EAttribute getJvmEnumerationLiteral_Ordinal();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmGenericType <em>Jvm Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Generic Type</em>'.
	 * @see org.summer.dsl.model.types.JvmGenericType
	 * @generated
	 */
	EClass getJvmGenericType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmGenericType#isInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see org.summer.dsl.model.types.JvmGenericType#isInterface()
	 * @see #getJvmGenericType()
	 * @generated
	 */
	EAttribute getJvmGenericType_Interface();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict Floating Point</em>'.
	 * @see org.summer.dsl.model.types.JvmGenericType#isStrictFloatingPoint()
	 * @see #getJvmGenericType()
	 * @generated
	 */
	EAttribute getJvmGenericType_StrictFloatingPoint();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmGenericType#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.summer.dsl.model.types.JvmGenericType#getExtends()
	 * @see #getJvmGenericType()
	 * @generated
	 */
	EReference getJvmGenericType_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmGenericType#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implements</em>'.
	 * @see org.summer.dsl.model.types.JvmGenericType#getImplements()
	 * @see #getJvmGenericType()
	 * @generated
	 */
	EReference getJvmGenericType_Implements();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmTypeReference <em>Jvm Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeReference
	 * @generated
	 */
	EClass getJvmTypeReference();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmParameterizedTypeReference <em>Jvm Parameterized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Parameterized Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmParameterizedTypeReference
	 * @generated
	 */
	EClass getJvmParameterizedTypeReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmParameterizedTypeReference#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.summer.dsl.model.types.JvmParameterizedTypeReference#getArguments()
	 * @see #getJvmParameterizedTypeReference()
	 * @generated
	 */
	EReference getJvmParameterizedTypeReference_Arguments();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.types.JvmParameterizedTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.types.JvmParameterizedTypeReference#getType()
	 * @see #getJvmParameterizedTypeReference()
	 * @generated
	 */
	EReference getJvmParameterizedTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmGenericArrayTypeReference <em>Jvm Generic Array Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Generic Array Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmGenericArrayTypeReference
	 * @generated
	 */
	EClass getJvmGenericArrayTypeReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmGenericArrayTypeReference#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Type</em>'.
	 * @see org.summer.dsl.model.types.JvmGenericArrayTypeReference#getComponentType()
	 * @see #getJvmGenericArrayTypeReference()
	 * @generated
	 */
	EReference getJvmGenericArrayTypeReference_ComponentType();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmWildcardTypeReference <em>Jvm Wildcard Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Wildcard Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmWildcardTypeReference
	 * @generated
	 */
	EClass getJvmWildcardTypeReference();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmAnyTypeReference <em>Jvm Any Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Any Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmAnyTypeReference
	 * @generated
	 */
	EClass getJvmAnyTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.types.JvmAnyTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.types.JvmAnyTypeReference#getType()
	 * @see #getJvmAnyTypeReference()
	 * @generated
	 */
	EReference getJvmAnyTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmMultiTypeReference <em>Jvm Multi Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Multi Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmMultiTypeReference
	 * @generated
	 */
	EClass getJvmMultiTypeReference();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmMember <em>Jvm Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Member</em>'.
	 * @see org.summer.dsl.model.types.JvmMember
	 * @generated
	 */
	EClass getJvmMember();

	/**
	 * Returns the meta object for the container reference '{@link org.summer.dsl.model.types.JvmMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Type</em>'.
	 * @see org.summer.dsl.model.types.JvmMember#getDeclaringType()
	 * @see #getJvmMember()
	 * @generated
	 */
	EReference getJvmMember_DeclaringType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmMember#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.summer.dsl.model.types.JvmMember#getVisibility()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmMember#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.summer.dsl.model.types.JvmMember#getSimpleName()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_SimpleName();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmMember#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.summer.dsl.model.types.JvmMember#getIdentifier()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmMember#getAnnotationInfo <em>Annotation Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation Info</em>'.
	 * @see org.summer.dsl.model.types.JvmMember#getAnnotationInfo()
	 * @see #getJvmMember()
	 * @generated
	 */
	EReference getJvmMember_AnnotationInfo();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmMember#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifiers</em>'.
	 * @see org.summer.dsl.model.types.JvmMember#getModifiers()
	 * @see #getJvmMember()
	 * @generated
	 */
	EAttribute getJvmMember_Modifiers();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmFeature <em>Jvm Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Feature</em>'.
	 * @see org.summer.dsl.model.types.JvmFeature
	 * @generated
	 */
	EClass getJvmFeature();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmField <em>Jvm Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Field</em>'.
	 * @see org.summer.dsl.model.types.JvmField
	 * @generated
	 */
	EClass getJvmField();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmField#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.summer.dsl.model.types.JvmField#isStatic()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmField#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.summer.dsl.model.types.JvmField#isFinal()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Final();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.types.JvmField#getType()
	 * @see #getJvmField()
	 * @generated
	 */
	EReference getJvmField_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmField#isVolatile <em>Volatile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volatile</em>'.
	 * @see org.summer.dsl.model.types.JvmField#isVolatile()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Volatile();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmField#isTransient <em>Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transient</em>'.
	 * @see org.summer.dsl.model.types.JvmField#isTransient()
	 * @see #getJvmField()
	 * @generated
	 */
	EAttribute getJvmField_Transient();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmField#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.summer.dsl.model.types.JvmField#getDefaultValue()
	 * @see #getJvmField()
	 * @generated
	 */
	EReference getJvmField_DefaultValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmField#getSet <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Set</em>'.
	 * @see org.summer.dsl.model.types.JvmField#getSet()
	 * @see #getJvmField()
	 * @generated
	 */
	EReference getJvmField_Set();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmField#getGet <em>Get</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Get</em>'.
	 * @see org.summer.dsl.model.types.JvmField#getGet()
	 * @see #getJvmField()
	 * @generated
	 */
	EReference getJvmField_Get();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmExecutable <em>Jvm Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Executable</em>'.
	 * @see org.summer.dsl.model.types.JvmExecutable
	 * @generated
	 */
	EClass getJvmExecutable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmExecutable#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.summer.dsl.model.types.JvmExecutable#getParameters()
	 * @see #getJvmExecutable()
	 * @generated
	 */
	EReference getJvmExecutable_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmExecutable#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.summer.dsl.model.types.JvmExecutable#getExceptions()
	 * @see #getJvmExecutable()
	 * @generated
	 */
	EReference getJvmExecutable_Exceptions();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmExecutable#isVarArgs <em>Var Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Args</em>'.
	 * @see org.summer.dsl.model.types.JvmExecutable#isVarArgs()
	 * @see #getJvmExecutable()
	 * @generated
	 */
	EAttribute getJvmExecutable_VarArgs();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmConstructor <em>Jvm Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Constructor</em>'.
	 * @see org.summer.dsl.model.types.JvmConstructor
	 * @generated
	 */
	EClass getJvmConstructor();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmConstructor#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.types.JvmConstructor#getExpression()
	 * @see #getJvmConstructor()
	 * @generated
	 */
	EReference getJvmConstructor_Expression();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmOperation <em>Jvm Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Operation</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation
	 * @generated
	 */
	EClass getJvmOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isStatic()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isFinal()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isAbstract()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Abstract();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmOperation#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#getReturnType()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EReference getJvmOperation_ReturnType();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmOperation#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#getDefaultValue()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EReference getJvmOperation_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isSynchronized <em>Synchronized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synchronized</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isSynchronized()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Synchronized();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isDefault()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isNative()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Native();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isStrictFloatingPoint <em>Strict Floating Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict Floating Point</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isStrictFloatingPoint()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_StrictFloatingPoint();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmOperation#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#getExpression()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EReference getJvmOperation_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmOperation#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#getFunction()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EReference getJvmOperation_Function();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmOperation#isOverload <em>Overload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overload</em>'.
	 * @see org.summer.dsl.model.types.JvmOperation#isOverload()
	 * @see #getJvmOperation()
	 * @generated
	 */
	EAttribute getJvmOperation_Overload();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmFormalParameter <em>Jvm Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Formal Parameter</em>'.
	 * @see org.summer.dsl.model.types.JvmFormalParameter
	 * @generated
	 */
	EClass getJvmFormalParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmFormalParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.types.JvmFormalParameter#getName()
	 * @see #getJvmFormalParameter()
	 * @generated
	 */
	EAttribute getJvmFormalParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmFormalParameter#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter Type</em>'.
	 * @see org.summer.dsl.model.types.JvmFormalParameter#getParameterType()
	 * @see #getJvmFormalParameter()
	 * @generated
	 */
	EReference getJvmFormalParameter_ParameterType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmFormalParameter#isVarArg <em>Var Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Arg</em>'.
	 * @see org.summer.dsl.model.types.JvmFormalParameter#isVarArg()
	 * @see #getJvmFormalParameter()
	 * @generated
	 */
	EAttribute getJvmFormalParameter_VarArg();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmFormalParameter#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.summer.dsl.model.types.JvmFormalParameter#getDefaultValue()
	 * @see #getJvmFormalParameter()
	 * @generated
	 */
	EReference getJvmFormalParameter_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmAnnotationTarget <em>Jvm Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Target</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationTarget
	 * @generated
	 */
	EClass getJvmAnnotationTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmAnnotationTarget#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationTarget#getAnnotations()
	 * @see #getJvmAnnotationTarget()
	 * @generated
	 */
	EReference getJvmAnnotationTarget_Annotations();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmAnnotationReference <em>Jvm Annotation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationReference
	 * @generated
	 */
	EClass getJvmAnnotationReference();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.types.JvmAnnotationReference#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotation</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationReference#getAnnotation()
	 * @see #getJvmAnnotationReference()
	 * @generated
	 */
	EReference getJvmAnnotationReference_Annotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmAnnotationReference#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationReference#getValues()
	 * @see #getJvmAnnotationReference()
	 * @generated
	 */
	EReference getJvmAnnotationReference_Values();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmAnnotationReference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationReference#getValue()
	 * @see #getJvmAnnotationReference()
	 * @generated
	 */
	EReference getJvmAnnotationReference_Value();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmAnnotationValue <em>Jvm Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationValue
	 * @generated
	 */
	EClass getJvmAnnotationValue();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.types.JvmAnnotationValue#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Field</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationValue#getField()
	 * @see #getJvmAnnotationValue()
	 * @generated
	 */
	EReference getJvmAnnotationValue_Field();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmAnnotationValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationValue#getValue()
	 * @see #getJvmAnnotationValue()
	 * @generated
	 */
	EReference getJvmAnnotationValue_Value();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmIntAnnotationValue <em>Jvm Int Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Int Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmIntAnnotationValue
	 * @generated
	 */
	EClass getJvmIntAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmIntAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmIntAnnotationValue#getValues()
	 * @see #getJvmIntAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmIntAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmBooleanAnnotationValue <em>Jvm Boolean Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Boolean Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmBooleanAnnotationValue
	 * @generated
	 */
	EClass getJvmBooleanAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmBooleanAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmBooleanAnnotationValue#getValues()
	 * @see #getJvmBooleanAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmBooleanAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmByteAnnotationValue <em>Jvm Byte Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Byte Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmByteAnnotationValue
	 * @generated
	 */
	EClass getJvmByteAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmByteAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmByteAnnotationValue#getValues()
	 * @see #getJvmByteAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmByteAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmShortAnnotationValue <em>Jvm Short Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Short Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmShortAnnotationValue
	 * @generated
	 */
	EClass getJvmShortAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmShortAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmShortAnnotationValue#getValues()
	 * @see #getJvmShortAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmShortAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmLongAnnotationValue <em>Jvm Long Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Long Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmLongAnnotationValue
	 * @generated
	 */
	EClass getJvmLongAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmLongAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmLongAnnotationValue#getValues()
	 * @see #getJvmLongAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmLongAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmDoubleAnnotationValue <em>Jvm Double Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Double Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmDoubleAnnotationValue
	 * @generated
	 */
	EClass getJvmDoubleAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmDoubleAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmDoubleAnnotationValue#getValues()
	 * @see #getJvmDoubleAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmDoubleAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmFloatAnnotationValue <em>Jvm Float Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Float Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmFloatAnnotationValue
	 * @generated
	 */
	EClass getJvmFloatAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmFloatAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmFloatAnnotationValue#getValues()
	 * @see #getJvmFloatAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmFloatAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmCharAnnotationValue <em>Jvm Char Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Char Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmCharAnnotationValue
	 * @generated
	 */
	EClass getJvmCharAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmCharAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmCharAnnotationValue#getValues()
	 * @see #getJvmCharAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmCharAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmStringAnnotationValue <em>Jvm String Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm String Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmStringAnnotationValue
	 * @generated
	 */
	EClass getJvmStringAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmStringAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmStringAnnotationValue#getValues()
	 * @see #getJvmStringAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmStringAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmTypeAnnotationValue <em>Jvm Type Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Type Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeAnnotationValue
	 * @generated
	 */
	EClass getJvmTypeAnnotationValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmTypeAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmTypeAnnotationValue#getValues()
	 * @see #getJvmTypeAnnotationValue()
	 * @generated
	 */
	EReference getJvmTypeAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmAnnotationAnnotationValue <em>Jvm Annotation Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Annotation Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationAnnotationValue
	 * @generated
	 */
	EClass getJvmAnnotationAnnotationValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmAnnotationAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmAnnotationAnnotationValue#getValues()
	 * @see #getJvmAnnotationAnnotationValue()
	 * @generated
	 */
	EReference getJvmAnnotationAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmEnumAnnotationValue <em>Jvm Enum Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Enum Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmEnumAnnotationValue
	 * @generated
	 */
	EClass getJvmEnumAnnotationValue();

	/**
	 * Returns the meta object for the reference list '{@link org.summer.dsl.model.types.JvmEnumAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmEnumAnnotationValue#getValues()
	 * @see #getJvmEnumAnnotationValue()
	 * @generated
	 */
	EReference getJvmEnumAnnotationValue_Values();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmDelegateTypeReference <em>Jvm Delegate Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Delegate Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmDelegateTypeReference
	 * @generated
	 */
	EClass getJvmDelegateTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.types.JvmDelegateTypeReference#getDelegate <em>Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delegate</em>'.
	 * @see org.summer.dsl.model.types.JvmDelegateTypeReference#getDelegate()
	 * @see #getJvmDelegateTypeReference()
	 * @generated
	 */
	EReference getJvmDelegateTypeReference_Delegate();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmSpecializedTypeReference <em>Jvm Specialized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Specialized Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmSpecializedTypeReference
	 * @generated
	 */
	EClass getJvmSpecializedTypeReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.types.JvmSpecializedTypeReference#getEquivalent <em>Equivalent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Equivalent</em>'.
	 * @see org.summer.dsl.model.types.JvmSpecializedTypeReference#getEquivalent()
	 * @see #getJvmSpecializedTypeReference()
	 * @generated
	 */
	EReference getJvmSpecializedTypeReference_Equivalent();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmSynonymTypeReference <em>Jvm Synonym Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Synonym Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmSynonymTypeReference
	 * @generated
	 */
	EClass getJvmSynonymTypeReference();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmUnknownTypeReference <em>Jvm Unknown Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Unknown Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmUnknownTypeReference
	 * @generated
	 */
	EClass getJvmUnknownTypeReference();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.types.JvmUnknownTypeReference#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.summer.dsl.model.types.JvmUnknownTypeReference#getQualifiedName()
	 * @see #getJvmUnknownTypeReference()
	 * @generated
	 */
	EAttribute getJvmUnknownTypeReference_QualifiedName();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmCompoundTypeReference <em>Jvm Compound Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Compound Type Reference</em>'.
	 * @see org.summer.dsl.model.types.JvmCompoundTypeReference
	 * @generated
	 */
	EClass getJvmCompoundTypeReference();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.types.JvmCompoundTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.types.JvmCompoundTypeReference#getType()
	 * @see #getJvmCompoundTypeReference()
	 * @generated
	 */
	EReference getJvmCompoundTypeReference_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.types.JvmCompoundTypeReference#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.summer.dsl.model.types.JvmCompoundTypeReference#getReferences()
	 * @see #getJvmCompoundTypeReference()
	 * @generated
	 */
	EReference getJvmCompoundTypeReference_References();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.types.JvmCustomAnnotationValue <em>Jvm Custom Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jvm Custom Annotation Value</em>'.
	 * @see org.summer.dsl.model.types.JvmCustomAnnotationValue
	 * @generated
	 */
	EClass getJvmCustomAnnotationValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.summer.dsl.model.types.JvmCustomAnnotationValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.summer.dsl.model.types.JvmCustomAnnotationValue#getValues()
	 * @see #getJvmCustomAnnotationValue()
	 * @generated
	 */
	EAttribute getJvmCustomAnnotationValue_Values();

	/**
	 * Returns the meta object for enum '{@link org.summer.dsl.model.types.JvmVisibility <em>Jvm Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Jvm Visibility</em>'.
	 * @see org.summer.dsl.model.types.JvmVisibility
	 * @generated
	 */
	EEnum getJvmVisibility();

	/**
	 * Returns the meta object for data type '{@link java.lang.Iterable <em>Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iterable</em>'.
	 * @see java.lang.Iterable
	 * @model instanceClass="java.lang.Iterable" typeParameters="E"
	 * @generated
	 */
	EDataType getIterable();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" typeParameters="E"
	 * @generated
	 */
	EDataType getList();

	/**
	 * Returns the meta object for data type '{@link org.summer.dsl.model.types.util.ITypeReferenceVisitor <em>IType Reference Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IType Reference Visitor</em>'.
	 * @see org.summer.dsl.model.types.util.ITypeReferenceVisitor
	 * @model instanceClass="org.summer.dsl.model.types.util.ITypeReferenceVisitor" serializeable="false" typeParameters="Result"
	 * @generated
	 */
	EDataType getITypeReferenceVisitor();

	/**
	 * Returns the meta object for data type '{@link org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter <em>IType Reference Visitor With Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IType Reference Visitor With Parameter</em>'.
	 * @see org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter
	 * @model instanceClass="org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter" serializeable="false" typeParameters="Parameter Result"
	 * @generated
	 */
	EDataType getITypeReferenceVisitorWithParameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

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
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmIdentifiableElementImpl <em>Jvm Identifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmIdentifiableElementImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmIdentifiableElement()
		 * @generated
		 */
		EClass JVM_IDENTIFIABLE_ELEMENT = eINSTANCE.getJvmIdentifiableElement();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmModuleImpl <em>Jvm Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmModuleImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmModule()
		 * @generated
		 */
		EClass JVM_MODULE = eINSTANCE.getJvmModule();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MODULE__SIMPLE_NAME = eINSTANCE.getJvmModule_SimpleName();

		/**
		 * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_MODULE__IMPORT_SECTION = eINSTANCE.getJvmModule_ImportSection();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_MODULE__CONTENTS = eINSTANCE.getJvmModule_Contents();

		/**
		 * The meta object literal for the '<em><b>Export Section</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_MODULE__EXPORT_SECTION = eINSTANCE.getJvmModule_ExportSection();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmNoModuleImpl <em>Jvm No Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmNoModuleImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmNoModule()
		 * @generated
		 */
		EClass JVM_NO_MODULE = eINSTANCE.getJvmNoModule();

		/**
		 * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_NO_MODULE__IMPORT_SECTION = eINSTANCE.getJvmNoModule_ImportSection();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_NO_MODULE__CONTENTS = eINSTANCE.getJvmNoModule_Contents();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmTypeImpl <em>Jvm Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmType()
		 * @generated
		 */
		EClass JVM_TYPE = eINSTANCE.getJvmType();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmVoidImpl <em>Jvm Void</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmVoidImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmVoid()
		 * @generated
		 */
		EClass JVM_VOID = eINSTANCE.getJvmVoid();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmComponentTypeImpl <em>Jvm Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmComponentTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmComponentType()
		 * @generated
		 */
		EClass JVM_COMPONENT_TYPE = eINSTANCE.getJvmComponentType();

		/**
		 * The meta object literal for the '<em><b>Array Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_COMPONENT_TYPE__ARRAY_TYPE = eINSTANCE.getJvmComponentType_ArrayType();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmPrimitiveTypeImpl <em>Jvm Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmPrimitiveTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmPrimitiveType()
		 * @generated
		 */
		EClass JVM_PRIMITIVE_TYPE = eINSTANCE.getJvmPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_PRIMITIVE_TYPE__SIMPLE_NAME = eINSTANCE.getJvmPrimitiveType_SimpleName();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmArrayTypeImpl <em>Jvm Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmArrayTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmArrayType()
		 * @generated
		 */
		EClass JVM_ARRAY_TYPE = eINSTANCE.getJvmArrayType();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ARRAY_TYPE__COMPONENT_TYPE = eINSTANCE.getJvmArrayType_ComponentType();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl <em>Jvm Declared Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmDeclaredType()
		 * @generated
		 */
		EClass JVM_DECLARED_TYPE = eINSTANCE.getJvmDeclaredType();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_DECLARED_TYPE__SUPER_TYPES = eINSTANCE.getJvmDeclaredType_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_DECLARED_TYPE__MEMBERS = eINSTANCE.getJvmDeclaredType_Members();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__ABSTRACT = eINSTANCE.getJvmDeclaredType_Abstract();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__STATIC = eINSTANCE.getJvmDeclaredType_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__FINAL = eINSTANCE.getJvmDeclaredType_Final();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__PACKAGE_NAME = eINSTANCE.getJvmDeclaredType_PackageName();

		/**
		 * The meta object literal for the '<em><b>Exported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DECLARED_TYPE__EXPORTED = eINSTANCE.getJvmDeclaredType_Exported();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmStructTypeImpl <em>Jvm Struct Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmStructTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmStructType()
		 * @generated
		 */
		EClass JVM_STRUCT_TYPE = eINSTANCE.getJvmStructType();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_STRUCT_TYPE__IMPLEMENTS = eINSTANCE.getJvmStructType_Implements();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_STRUCT_TYPE__PARAMETERS = eINSTANCE.getJvmStructType_Parameters();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmTypeParameterImpl <em>Jvm Type Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmTypeParameterImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeParameter()
		 * @generated
		 */
		EClass JVM_TYPE_PARAMETER = eINSTANCE.getJvmTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_TYPE_PARAMETER__NAME = eINSTANCE.getJvmTypeParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Declarator</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_PARAMETER__DECLARATOR = eINSTANCE.getJvmTypeParameter_Declarator();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmTypeParameterDeclaratorImpl <em>Jvm Type Parameter Declarator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmTypeParameterDeclaratorImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeParameterDeclarator()
		 * @generated
		 */
		EClass JVM_TYPE_PARAMETER_DECLARATOR = eINSTANCE.getJvmTypeParameterDeclarator();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS = eINSTANCE.getJvmTypeParameterDeclarator_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmConstraintOwnerImpl <em>Jvm Constraint Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmConstraintOwnerImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmConstraintOwner()
		 * @generated
		 */
		EClass JVM_CONSTRAINT_OWNER = eINSTANCE.getJvmConstraintOwner();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_CONSTRAINT_OWNER__CONSTRAINTS = eINSTANCE.getJvmConstraintOwner_Constraints();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmTypeConstraintImpl <em>Jvm Type Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmTypeConstraintImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeConstraint()
		 * @generated
		 */
		EClass JVM_TYPE_CONSTRAINT = eINSTANCE.getJvmTypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Type Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_CONSTRAINT__TYPE_REFERENCE = eINSTANCE.getJvmTypeConstraint_TypeReference();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_CONSTRAINT__OWNER = eINSTANCE.getJvmTypeConstraint_Owner();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmUpperBoundImpl <em>Jvm Upper Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmUpperBoundImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmUpperBound()
		 * @generated
		 */
		EClass JVM_UPPER_BOUND = eINSTANCE.getJvmUpperBound();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmLowerBoundImpl <em>Jvm Lower Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmLowerBoundImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmLowerBound()
		 * @generated
		 */
		EClass JVM_LOWER_BOUND = eINSTANCE.getJvmLowerBound();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationTypeImpl <em>Jvm Annotation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmAnnotationTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationType()
		 * @generated
		 */
		EClass JVM_ANNOTATION_TYPE = eINSTANCE.getJvmAnnotationType();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmEnumerationTypeImpl <em>Jvm Enumeration Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmEnumerationTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmEnumerationType()
		 * @generated
		 */
		EClass JVM_ENUMERATION_TYPE = eINSTANCE.getJvmEnumerationType();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ENUMERATION_TYPE__LITERALS = eINSTANCE.getJvmEnumerationType_Literals();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmEnumerationLiteralImpl <em>Jvm Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmEnumerationLiteralImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmEnumerationLiteral()
		 * @generated
		 */
		EClass JVM_ENUMERATION_LITERAL = eINSTANCE.getJvmEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Ordinal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_ENUMERATION_LITERAL__ORDINAL = eINSTANCE.getJvmEnumerationLiteral_Ordinal();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmGenericTypeImpl <em>Jvm Generic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmGenericTypeImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmGenericType()
		 * @generated
		 */
		EClass JVM_GENERIC_TYPE = eINSTANCE.getJvmGenericType();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_GENERIC_TYPE__INTERFACE = eINSTANCE.getJvmGenericType_Interface();

		/**
		 * The meta object literal for the '<em><b>Strict Floating Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_GENERIC_TYPE__STRICT_FLOATING_POINT = eINSTANCE.getJvmGenericType_StrictFloatingPoint();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_GENERIC_TYPE__EXTENDS = eINSTANCE.getJvmGenericType_Extends();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_GENERIC_TYPE__IMPLEMENTS = eINSTANCE.getJvmGenericType_Implements();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmTypeReferenceImpl <em>Jvm Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeReference()
		 * @generated
		 */
		EClass JVM_TYPE_REFERENCE = eINSTANCE.getJvmTypeReference();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmParameterizedTypeReferenceImpl <em>Jvm Parameterized Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmParameterizedTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmParameterizedTypeReference()
		 * @generated
		 */
		EClass JVM_PARAMETERIZED_TYPE_REFERENCE = eINSTANCE.getJvmParameterizedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS = eINSTANCE.getJvmParameterizedTypeReference_Arguments();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE = eINSTANCE.getJvmParameterizedTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmGenericArrayTypeReferenceImpl <em>Jvm Generic Array Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmGenericArrayTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmGenericArrayTypeReference()
		 * @generated
		 */
		EClass JVM_GENERIC_ARRAY_TYPE_REFERENCE = eINSTANCE.getJvmGenericArrayTypeReference();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE = eINSTANCE.getJvmGenericArrayTypeReference_ComponentType();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmWildcardTypeReferenceImpl <em>Jvm Wildcard Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmWildcardTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmWildcardTypeReference()
		 * @generated
		 */
		EClass JVM_WILDCARD_TYPE_REFERENCE = eINSTANCE.getJvmWildcardTypeReference();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmAnyTypeReferenceImpl <em>Jvm Any Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmAnyTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnyTypeReference()
		 * @generated
		 */
		EClass JVM_ANY_TYPE_REFERENCE = eINSTANCE.getJvmAnyTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANY_TYPE_REFERENCE__TYPE = eINSTANCE.getJvmAnyTypeReference_Type();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmMultiTypeReferenceImpl <em>Jvm Multi Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmMultiTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmMultiTypeReference()
		 * @generated
		 */
		EClass JVM_MULTI_TYPE_REFERENCE = eINSTANCE.getJvmMultiTypeReference();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmMemberImpl <em>Jvm Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmMemberImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmMember()
		 * @generated
		 */
		EClass JVM_MEMBER = eINSTANCE.getJvmMember();

		/**
		 * The meta object literal for the '<em><b>Declaring Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_MEMBER__DECLARING_TYPE = eINSTANCE.getJvmMember_DeclaringType();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__VISIBILITY = eINSTANCE.getJvmMember_Visibility();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__SIMPLE_NAME = eINSTANCE.getJvmMember_SimpleName();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__IDENTIFIER = eINSTANCE.getJvmMember_Identifier();

		/**
		 * The meta object literal for the '<em><b>Annotation Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_MEMBER__ANNOTATION_INFO = eINSTANCE.getJvmMember_AnnotationInfo();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_MEMBER__MODIFIERS = eINSTANCE.getJvmMember_Modifiers();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmFeatureImpl <em>Jvm Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmFeatureImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmFeature()
		 * @generated
		 */
		EClass JVM_FEATURE = eINSTANCE.getJvmFeature();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmFieldImpl <em>Jvm Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmFieldImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmField()
		 * @generated
		 */
		EClass JVM_FIELD = eINSTANCE.getJvmField();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__STATIC = eINSTANCE.getJvmField_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__FINAL = eINSTANCE.getJvmField_Final();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FIELD__TYPE = eINSTANCE.getJvmField_Type();

		/**
		 * The meta object literal for the '<em><b>Volatile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__VOLATILE = eINSTANCE.getJvmField_Volatile();

		/**
		 * The meta object literal for the '<em><b>Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FIELD__TRANSIENT = eINSTANCE.getJvmField_Transient();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FIELD__DEFAULT_VALUE = eINSTANCE.getJvmField_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FIELD__SET = eINSTANCE.getJvmField_Set();

		/**
		 * The meta object literal for the '<em><b>Get</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FIELD__GET = eINSTANCE.getJvmField_Get();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmExecutableImpl <em>Jvm Executable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmExecutableImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmExecutable()
		 * @generated
		 */
		EClass JVM_EXECUTABLE = eINSTANCE.getJvmExecutable();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_EXECUTABLE__PARAMETERS = eINSTANCE.getJvmExecutable_Parameters();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_EXECUTABLE__EXCEPTIONS = eINSTANCE.getJvmExecutable_Exceptions();

		/**
		 * The meta object literal for the '<em><b>Var Args</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_EXECUTABLE__VAR_ARGS = eINSTANCE.getJvmExecutable_VarArgs();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmConstructorImpl <em>Jvm Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmConstructorImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmConstructor()
		 * @generated
		 */
		EClass JVM_CONSTRUCTOR = eINSTANCE.getJvmConstructor();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_CONSTRUCTOR__EXPRESSION = eINSTANCE.getJvmConstructor_Expression();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmOperationImpl <em>Jvm Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmOperationImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmOperation()
		 * @generated
		 */
		EClass JVM_OPERATION = eINSTANCE.getJvmOperation();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__STATIC = eINSTANCE.getJvmOperation_Static();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__FINAL = eINSTANCE.getJvmOperation_Final();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__ABSTRACT = eINSTANCE.getJvmOperation_Abstract();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_OPERATION__RETURN_TYPE = eINSTANCE.getJvmOperation_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_OPERATION__DEFAULT_VALUE = eINSTANCE.getJvmOperation_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__SYNCHRONIZED = eINSTANCE.getJvmOperation_Synchronized();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__DEFAULT = eINSTANCE.getJvmOperation_Default();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__NATIVE = eINSTANCE.getJvmOperation_Native();

		/**
		 * The meta object literal for the '<em><b>Strict Floating Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__STRICT_FLOATING_POINT = eINSTANCE.getJvmOperation_StrictFloatingPoint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_OPERATION__EXPRESSION = eINSTANCE.getJvmOperation_Expression();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_OPERATION__FUNCTION = eINSTANCE.getJvmOperation_Function();

		/**
		 * The meta object literal for the '<em><b>Overload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_OPERATION__OVERLOAD = eINSTANCE.getJvmOperation_Overload();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmFormalParameterImpl <em>Jvm Formal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmFormalParameterImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmFormalParameter()
		 * @generated
		 */
		EClass JVM_FORMAL_PARAMETER = eINSTANCE.getJvmFormalParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FORMAL_PARAMETER__NAME = eINSTANCE.getJvmFormalParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FORMAL_PARAMETER__PARAMETER_TYPE = eINSTANCE.getJvmFormalParameter_ParameterType();

		/**
		 * The meta object literal for the '<em><b>Var Arg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FORMAL_PARAMETER__VAR_ARG = eINSTANCE.getJvmFormalParameter_VarArg();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_FORMAL_PARAMETER__DEFAULT_VALUE = eINSTANCE.getJvmFormalParameter_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationTargetImpl <em>Jvm Annotation Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmAnnotationTargetImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationTarget()
		 * @generated
		 */
		EClass JVM_ANNOTATION_TARGET = eINSTANCE.getJvmAnnotationTarget();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_TARGET__ANNOTATIONS = eINSTANCE.getJvmAnnotationTarget_Annotations();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationReferenceImpl <em>Jvm Annotation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmAnnotationReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationReference()
		 * @generated
		 */
		EClass JVM_ANNOTATION_REFERENCE = eINSTANCE.getJvmAnnotationReference();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_REFERENCE__ANNOTATION = eINSTANCE.getJvmAnnotationReference_Annotation();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_REFERENCE__VALUES = eINSTANCE.getJvmAnnotationReference_Values();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_REFERENCE__VALUE = eINSTANCE.getJvmAnnotationReference_Value();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationValueImpl <em>Jvm Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationValue()
		 * @generated
		 */
		EClass JVM_ANNOTATION_VALUE = eINSTANCE.getJvmAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_VALUE__FIELD = eINSTANCE.getJvmAnnotationValue_Field();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_VALUE__VALUE = eINSTANCE.getJvmAnnotationValue_Value();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmIntAnnotationValueImpl <em>Jvm Int Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmIntAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmIntAnnotationValue()
		 * @generated
		 */
		EClass JVM_INT_ANNOTATION_VALUE = eINSTANCE.getJvmIntAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_INT_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmIntAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmBooleanAnnotationValueImpl <em>Jvm Boolean Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmBooleanAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmBooleanAnnotationValue()
		 * @generated
		 */
		EClass JVM_BOOLEAN_ANNOTATION_VALUE = eINSTANCE.getJvmBooleanAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_BOOLEAN_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmBooleanAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmByteAnnotationValueImpl <em>Jvm Byte Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmByteAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmByteAnnotationValue()
		 * @generated
		 */
		EClass JVM_BYTE_ANNOTATION_VALUE = eINSTANCE.getJvmByteAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_BYTE_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmByteAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmShortAnnotationValueImpl <em>Jvm Short Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmShortAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmShortAnnotationValue()
		 * @generated
		 */
		EClass JVM_SHORT_ANNOTATION_VALUE = eINSTANCE.getJvmShortAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_SHORT_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmShortAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmLongAnnotationValueImpl <em>Jvm Long Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmLongAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmLongAnnotationValue()
		 * @generated
		 */
		EClass JVM_LONG_ANNOTATION_VALUE = eINSTANCE.getJvmLongAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_LONG_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmLongAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmDoubleAnnotationValueImpl <em>Jvm Double Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmDoubleAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmDoubleAnnotationValue()
		 * @generated
		 */
		EClass JVM_DOUBLE_ANNOTATION_VALUE = eINSTANCE.getJvmDoubleAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_DOUBLE_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmDoubleAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmFloatAnnotationValueImpl <em>Jvm Float Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmFloatAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmFloatAnnotationValue()
		 * @generated
		 */
		EClass JVM_FLOAT_ANNOTATION_VALUE = eINSTANCE.getJvmFloatAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_FLOAT_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmFloatAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmCharAnnotationValueImpl <em>Jvm Char Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmCharAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmCharAnnotationValue()
		 * @generated
		 */
		EClass JVM_CHAR_ANNOTATION_VALUE = eINSTANCE.getJvmCharAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CHAR_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmCharAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmStringAnnotationValueImpl <em>Jvm String Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmStringAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmStringAnnotationValue()
		 * @generated
		 */
		EClass JVM_STRING_ANNOTATION_VALUE = eINSTANCE.getJvmStringAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_STRING_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmStringAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmTypeAnnotationValueImpl <em>Jvm Type Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmTypeAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmTypeAnnotationValue()
		 * @generated
		 */
		EClass JVM_TYPE_ANNOTATION_VALUE = eINSTANCE.getJvmTypeAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_TYPE_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmTypeAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmAnnotationAnnotationValueImpl <em>Jvm Annotation Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmAnnotationAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmAnnotationAnnotationValue()
		 * @generated
		 */
		EClass JVM_ANNOTATION_ANNOTATION_VALUE = eINSTANCE.getJvmAnnotationAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ANNOTATION_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmAnnotationAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmEnumAnnotationValueImpl <em>Jvm Enum Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmEnumAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmEnumAnnotationValue()
		 * @generated
		 */
		EClass JVM_ENUM_ANNOTATION_VALUE = eINSTANCE.getJvmEnumAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_ENUM_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmEnumAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmDelegateTypeReferenceImpl <em>Jvm Delegate Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmDelegateTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmDelegateTypeReference()
		 * @generated
		 */
		EClass JVM_DELEGATE_TYPE_REFERENCE = eINSTANCE.getJvmDelegateTypeReference();

		/**
		 * The meta object literal for the '<em><b>Delegate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_DELEGATE_TYPE_REFERENCE__DELEGATE = eINSTANCE.getJvmDelegateTypeReference_Delegate();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmSpecializedTypeReferenceImpl <em>Jvm Specialized Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmSpecializedTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmSpecializedTypeReference()
		 * @generated
		 */
		EClass JVM_SPECIALIZED_TYPE_REFERENCE = eINSTANCE.getJvmSpecializedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Equivalent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT = eINSTANCE.getJvmSpecializedTypeReference_Equivalent();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmSynonymTypeReferenceImpl <em>Jvm Synonym Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmSynonymTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmSynonymTypeReference()
		 * @generated
		 */
		EClass JVM_SYNONYM_TYPE_REFERENCE = eINSTANCE.getJvmSynonymTypeReference();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmUnknownTypeReferenceImpl <em>Jvm Unknown Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmUnknownTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmUnknownTypeReference()
		 * @generated
		 */
		EClass JVM_UNKNOWN_TYPE_REFERENCE = eINSTANCE.getJvmUnknownTypeReference();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME = eINSTANCE.getJvmUnknownTypeReference_QualifiedName();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmCompoundTypeReferenceImpl <em>Jvm Compound Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmCompoundTypeReferenceImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmCompoundTypeReference()
		 * @generated
		 */
		EClass JVM_COMPOUND_TYPE_REFERENCE = eINSTANCE.getJvmCompoundTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_COMPOUND_TYPE_REFERENCE__TYPE = eINSTANCE.getJvmCompoundTypeReference_Type();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVM_COMPOUND_TYPE_REFERENCE__REFERENCES = eINSTANCE.getJvmCompoundTypeReference_References();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.impl.JvmCustomAnnotationValueImpl <em>Jvm Custom Annotation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.impl.JvmCustomAnnotationValueImpl
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmCustomAnnotationValue()
		 * @generated
		 */
		EClass JVM_CUSTOM_ANNOTATION_VALUE = eINSTANCE.getJvmCustomAnnotationValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CUSTOM_ANNOTATION_VALUE__VALUES = eINSTANCE.getJvmCustomAnnotationValue_Values();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.types.JvmVisibility <em>Jvm Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.JvmVisibility
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getJvmVisibility()
		 * @generated
		 */
		EEnum JVM_VISIBILITY = eINSTANCE.getJvmVisibility();

		/**
		 * The meta object literal for the '<em>Iterable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Iterable
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getIterable()
		 * @generated
		 */
		EDataType ITERABLE = eINSTANCE.getIterable();

		/**
		 * The meta object literal for the '<em>List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getList()
		 * @generated
		 */
		EDataType LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em>IType Reference Visitor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.util.ITypeReferenceVisitor
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getITypeReferenceVisitor()
		 * @generated
		 */
		EDataType ITYPE_REFERENCE_VISITOR = eINSTANCE.getITypeReferenceVisitor();

		/**
		 * The meta object literal for the '<em>IType Reference Visitor With Parameter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter
		 * @see org.summer.dsl.model.types.impl.TypesPackageImpl#getITypeReferenceVisitorWithParameter()
		 * @generated
		 */
		EDataType ITYPE_REFERENCE_VISITOR_WITH_PARAMETER = eINSTANCE.getITypeReferenceVisitorWithParameter();

	}

} //TypesPackage
