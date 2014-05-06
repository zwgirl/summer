/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.summer.dsl.model.xtype.XtypeFactory
 * @model kind="package"
 * @generated
 */
public interface XtypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xtype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.summer.org/dsl/model/xtype";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xtype";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtypePackage eINSTANCE = org.summer.dsl.model.xtype.impl.XtypePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XFunctionTypeRefImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
	 * @generated
	 */
	int XFUNCTION_TYPE_REF = 0;

	/**
	 * The feature id for the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__EQUIVALENT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT;

	/**
	 * The feature id for the '<em><b>Param Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__PARAM_TYPES = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__RETURN_TYPE = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__TYPE = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instance Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF__INSTANCE_CONTEXT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XFunction Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFUNCTION_TYPE_REF_FEATURE_COUNT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImpl <em>XComputed Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXComputedTypeReference()
	 * @generated
	 */
	int XCOMPUTED_TYPE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE__EQUIVALENT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT;

	/**
	 * The feature id for the '<em><b>Type Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XComputed Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOMPUTED_TYPE_REFERENCE_FEATURE_COUNT = TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XImportSectionImpl <em>XImport Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XImportSectionImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportSection()
	 * @generated
	 */
	int XIMPORT_SECTION = 2;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_SECTION__IMPORT_DECLARATIONS = 0;

	/**
	 * The number of structural features of the '<em>XImport Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_SECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XImportDeclarationImpl <em>XImport Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XImportDeclarationImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportDeclaration()
	 * @generated
	 */
	int XIMPORT_DECLARATION = 3;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__STATIC = 1;

	/**
	 * The feature id for the '<em><b>Imported Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__IMPORTED_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__IMPORTED_NAMESPACE = 3;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION__WILDCARD = 4;

	/**
	 * The number of structural features of the '<em>XImport Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XImportSection1Impl <em>XImport Section1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XImportSection1Impl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportSection1()
	 * @generated
	 */
	int XIMPORT_SECTION1 = 4;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_SECTION1__IMPORT_DECLARATIONS = 0;

	/**
	 * The number of structural features of the '<em>XImport Section1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_SECTION1_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XImportDeclaration1Impl <em>XImport Declaration1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XImportDeclaration1Impl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportDeclaration1()
	 * @generated
	 */
	int XIMPORT_DECLARATION1 = 5;

	/**
	 * The feature id for the '<em><b>Import Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION1__IMPORT_ITEMS = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION1__ALIAS = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION1__IMPORT_URI = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION1__NAME = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION1__WILDCARD = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>XImport Declaration1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_DECLARATION1_FEATURE_COUNT = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XImportItemImpl <em>XImport Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XImportItemImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportItem()
	 * @generated
	 */
	int XIMPORT_ITEM = 6;

	/**
	 * The feature id for the '<em><b>Imported Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_ITEM__IMPORTED_ID = 0;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_ITEM__ALIAS = 1;

	/**
	 * The number of structural features of the '<em>XImport Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIMPORT_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XExportSectionImpl <em>XExport Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XExportSectionImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXExportSection()
	 * @generated
	 */
	int XEXPORT_SECTION = 7;

	/**
	 * The feature id for the '<em><b>Export Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_SECTION__EXPORT_DECLARATIONS = 0;

	/**
	 * The number of structural features of the '<em>XExport Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_SECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XExportDeclarationImpl <em>XExport Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XExportDeclarationImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXExportDeclaration()
	 * @generated
	 */
	int XEXPORT_DECLARATION = 8;

	/**
	 * The feature id for the '<em><b>Export Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_DECLARATION__EXPORT_ITEMS = 0;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_DECLARATION__ALIAS = 1;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_DECLARATION__WILDCARD = 2;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_DECLARATION__IMPORT_URI = 3;

	/**
	 * The number of structural features of the '<em>XExport Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_DECLARATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xtype.impl.XExportItemImpl <em>XExport Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xtype.impl.XExportItemImpl
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXExportItem()
	 * @generated
	 */
	int XEXPORT_ITEM = 9;

	/**
	 * The feature id for the '<em><b>Exported Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_ITEM__EXPORTED_ID = 0;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_ITEM__ALIAS = 1;

	/**
	 * The number of structural features of the '<em>XExport Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPORT_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>IJvm Type Reference Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider
	 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getIJvmTypeReferenceProvider()
	 * @generated
	 */
	int IJVM_TYPE_REFERENCE_PROVIDER = 10;


	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XFunctionTypeRef <em>XFunction Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFunction Type Ref</em>'.
	 * @see org.summer.dsl.model.xtype.XFunctionTypeRef
	 * @generated
	 */
	EClass getXFunctionTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getParamTypes <em>Param Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param Types</em>'.
	 * @see org.summer.dsl.model.xtype.XFunctionTypeRef#getParamTypes()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_ParamTypes();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.summer.dsl.model.xtype.XFunctionTypeRef#getReturnType()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_ReturnType();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xtype.XFunctionTypeRef#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xtype.XFunctionTypeRef#getType()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EReference getXFunctionTypeRef_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XFunctionTypeRef#isInstanceContext <em>Instance Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Context</em>'.
	 * @see org.summer.dsl.model.xtype.XFunctionTypeRef#isInstanceContext()
	 * @see #getXFunctionTypeRef()
	 * @generated
	 */
	EAttribute getXFunctionTypeRef_InstanceContext();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XComputedTypeReference <em>XComputed Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XComputed Type Reference</em>'.
	 * @see org.summer.dsl.model.xtype.XComputedTypeReference
	 * @generated
	 */
	EClass getXComputedTypeReference();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XComputedTypeReference#getTypeProvider <em>Type Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Provider</em>'.
	 * @see org.summer.dsl.model.xtype.XComputedTypeReference#getTypeProvider()
	 * @see #getXComputedTypeReference()
	 * @generated
	 */
	EAttribute getXComputedTypeReference_TypeProvider();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XImportSection <em>XImport Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XImport Section</em>'.
	 * @see org.summer.dsl.model.xtype.XImportSection
	 * @generated
	 */
	EClass getXImportSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xtype.XImportSection#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.summer.dsl.model.xtype.XImportSection#getImportDeclarations()
	 * @see #getXImportSection()
	 * @generated
	 */
	EReference getXImportSection_ImportDeclarations();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XImportDeclaration <em>XImport Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XImport Declaration</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration
	 * @generated
	 */
	EClass getXImportDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration#isExtension()
	 * @see #getXImportDeclaration()
	 * @generated
	 */
	EAttribute getXImportDeclaration_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration#isStatic()
	 * @see #getXImportDeclaration()
	 * @generated
	 */
	EAttribute getXImportDeclaration_Static();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xtype.XImportDeclaration#getImportedType <em>Imported Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Type</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration#getImportedType()
	 * @see #getXImportDeclaration()
	 * @generated
	 */
	EReference getXImportDeclaration_ImportedType();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration#getImportedNamespace()
	 * @see #getXImportDeclaration()
	 * @generated
	 */
	EAttribute getXImportDeclaration_ImportedNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration#isWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wildcard</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration#isWildcard()
	 * @see #getXImportDeclaration()
	 * @generated
	 */
	EAttribute getXImportDeclaration_Wildcard();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XImportSection1 <em>XImport Section1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XImport Section1</em>'.
	 * @see org.summer.dsl.model.xtype.XImportSection1
	 * @generated
	 */
	EClass getXImportSection1();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xtype.XImportSection1#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.summer.dsl.model.xtype.XImportSection1#getImportDeclarations()
	 * @see #getXImportSection1()
	 * @generated
	 */
	EReference getXImportSection1_ImportDeclarations();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XImportDeclaration1 <em>XImport Declaration1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XImport Declaration1</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration1
	 * @generated
	 */
	EClass getXImportDeclaration1();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xtype.XImportDeclaration1#getImportItems <em>Import Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Items</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration1#getImportItems()
	 * @see #getXImportDeclaration1()
	 * @generated
	 */
	EReference getXImportDeclaration1_ImportItems();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration1#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration1#getAlias()
	 * @see #getXImportDeclaration1()
	 * @generated
	 */
	EAttribute getXImportDeclaration1_Alias();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration1#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration1#getImportURI()
	 * @see #getXImportDeclaration1()
	 * @generated
	 */
	EAttribute getXImportDeclaration1_ImportURI();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration1#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration1#getName()
	 * @see #getXImportDeclaration1()
	 * @generated
	 */
	EAttribute getXImportDeclaration1_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportDeclaration1#isWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wildcard</em>'.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration1#isWildcard()
	 * @see #getXImportDeclaration1()
	 * @generated
	 */
	EAttribute getXImportDeclaration1_Wildcard();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XImportItem <em>XImport Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XImport Item</em>'.
	 * @see org.summer.dsl.model.xtype.XImportItem
	 * @generated
	 */
	EClass getXImportItem();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xtype.XImportItem#getImportedId <em>Imported Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Id</em>'.
	 * @see org.summer.dsl.model.xtype.XImportItem#getImportedId()
	 * @see #getXImportItem()
	 * @generated
	 */
	EReference getXImportItem_ImportedId();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XImportItem#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.summer.dsl.model.xtype.XImportItem#getAlias()
	 * @see #getXImportItem()
	 * @generated
	 */
	EAttribute getXImportItem_Alias();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XExportSection <em>XExport Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XExport Section</em>'.
	 * @see org.summer.dsl.model.xtype.XExportSection
	 * @generated
	 */
	EClass getXExportSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xtype.XExportSection#getExportDeclarations <em>Export Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Export Declarations</em>'.
	 * @see org.summer.dsl.model.xtype.XExportSection#getExportDeclarations()
	 * @see #getXExportSection()
	 * @generated
	 */
	EReference getXExportSection_ExportDeclarations();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XExportDeclaration <em>XExport Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XExport Declaration</em>'.
	 * @see org.summer.dsl.model.xtype.XExportDeclaration
	 * @generated
	 */
	EClass getXExportDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xtype.XExportDeclaration#getExportItems <em>Export Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Export Items</em>'.
	 * @see org.summer.dsl.model.xtype.XExportDeclaration#getExportItems()
	 * @see #getXExportDeclaration()
	 * @generated
	 */
	EReference getXExportDeclaration_ExportItems();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XExportDeclaration#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.summer.dsl.model.xtype.XExportDeclaration#getAlias()
	 * @see #getXExportDeclaration()
	 * @generated
	 */
	EAttribute getXExportDeclaration_Alias();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XExportDeclaration#isWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wildcard</em>'.
	 * @see org.summer.dsl.model.xtype.XExportDeclaration#isWildcard()
	 * @see #getXExportDeclaration()
	 * @generated
	 */
	EAttribute getXExportDeclaration_Wildcard();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XExportDeclaration#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see org.summer.dsl.model.xtype.XExportDeclaration#getImportURI()
	 * @see #getXExportDeclaration()
	 * @generated
	 */
	EAttribute getXExportDeclaration_ImportURI();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xtype.XExportItem <em>XExport Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XExport Item</em>'.
	 * @see org.summer.dsl.model.xtype.XExportItem
	 * @generated
	 */
	EClass getXExportItem();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xtype.XExportItem#getExportedId <em>Exported Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exported Id</em>'.
	 * @see org.summer.dsl.model.xtype.XExportItem#getExportedId()
	 * @see #getXExportItem()
	 * @generated
	 */
	EReference getXExportItem_ExportedId();

	/**
	 * Returns the meta object for the attribute '{@link org.summer.dsl.model.xtype.XExportItem#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.summer.dsl.model.xtype.XExportItem#getAlias()
	 * @see #getXExportItem()
	 * @generated
	 */
	EAttribute getXExportItem_Alias();

	/**
	 * Returns the meta object for data type '{@link org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider <em>IJvm Type Reference Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IJvm Type Reference Provider</em>'.
	 * @see org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider
	 * @model instanceClass="org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider" serializeable="false"
	 * @generated
	 */
	EDataType getIJvmTypeReferenceProvider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XtypeFactory getXtypeFactory();

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
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XFunctionTypeRefImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
		 * @generated
		 */
		EClass XFUNCTION_TYPE_REF = eINSTANCE.getXFunctionTypeRef();

		/**
		 * The meta object literal for the '<em><b>Param Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__PARAM_TYPES = eINSTANCE.getXFunctionTypeRef_ParamTypes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__RETURN_TYPE = eINSTANCE.getXFunctionTypeRef_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFUNCTION_TYPE_REF__TYPE = eINSTANCE.getXFunctionTypeRef_Type();

		/**
		 * The meta object literal for the '<em><b>Instance Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFUNCTION_TYPE_REF__INSTANCE_CONTEXT = eINSTANCE.getXFunctionTypeRef_InstanceContext();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImpl <em>XComputed Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXComputedTypeReference()
		 * @generated
		 */
		EClass XCOMPUTED_TYPE_REFERENCE = eINSTANCE.getXComputedTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER = eINSTANCE.getXComputedTypeReference_TypeProvider();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XImportSectionImpl <em>XImport Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XImportSectionImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportSection()
		 * @generated
		 */
		EClass XIMPORT_SECTION = eINSTANCE.getXImportSection();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIMPORT_SECTION__IMPORT_DECLARATIONS = eINSTANCE.getXImportSection_ImportDeclarations();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XImportDeclarationImpl <em>XImport Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XImportDeclarationImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportDeclaration()
		 * @generated
		 */
		EClass XIMPORT_DECLARATION = eINSTANCE.getXImportDeclaration();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__EXTENSION = eINSTANCE.getXImportDeclaration_Extension();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__STATIC = eINSTANCE.getXImportDeclaration_Static();

		/**
		 * The meta object literal for the '<em><b>Imported Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIMPORT_DECLARATION__IMPORTED_TYPE = eINSTANCE.getXImportDeclaration_ImportedType();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__IMPORTED_NAMESPACE = eINSTANCE.getXImportDeclaration_ImportedNamespace();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION__WILDCARD = eINSTANCE.getXImportDeclaration_Wildcard();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XImportSection1Impl <em>XImport Section1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XImportSection1Impl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportSection1()
		 * @generated
		 */
		EClass XIMPORT_SECTION1 = eINSTANCE.getXImportSection1();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIMPORT_SECTION1__IMPORT_DECLARATIONS = eINSTANCE.getXImportSection1_ImportDeclarations();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XImportDeclaration1Impl <em>XImport Declaration1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XImportDeclaration1Impl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportDeclaration1()
		 * @generated
		 */
		EClass XIMPORT_DECLARATION1 = eINSTANCE.getXImportDeclaration1();

		/**
		 * The meta object literal for the '<em><b>Import Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIMPORT_DECLARATION1__IMPORT_ITEMS = eINSTANCE.getXImportDeclaration1_ImportItems();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION1__ALIAS = eINSTANCE.getXImportDeclaration1_Alias();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION1__IMPORT_URI = eINSTANCE.getXImportDeclaration1_ImportURI();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION1__NAME = eINSTANCE.getXImportDeclaration1_Name();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_DECLARATION1__WILDCARD = eINSTANCE.getXImportDeclaration1_Wildcard();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XImportItemImpl <em>XImport Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XImportItemImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXImportItem()
		 * @generated
		 */
		EClass XIMPORT_ITEM = eINSTANCE.getXImportItem();

		/**
		 * The meta object literal for the '<em><b>Imported Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIMPORT_ITEM__IMPORTED_ID = eINSTANCE.getXImportItem_ImportedId();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIMPORT_ITEM__ALIAS = eINSTANCE.getXImportItem_Alias();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XExportSectionImpl <em>XExport Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XExportSectionImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXExportSection()
		 * @generated
		 */
		EClass XEXPORT_SECTION = eINSTANCE.getXExportSection();

		/**
		 * The meta object literal for the '<em><b>Export Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XEXPORT_SECTION__EXPORT_DECLARATIONS = eINSTANCE.getXExportSection_ExportDeclarations();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XExportDeclarationImpl <em>XExport Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XExportDeclarationImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXExportDeclaration()
		 * @generated
		 */
		EClass XEXPORT_DECLARATION = eINSTANCE.getXExportDeclaration();

		/**
		 * The meta object literal for the '<em><b>Export Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XEXPORT_DECLARATION__EXPORT_ITEMS = eINSTANCE.getXExportDeclaration_ExportItems();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEXPORT_DECLARATION__ALIAS = eINSTANCE.getXExportDeclaration_Alias();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEXPORT_DECLARATION__WILDCARD = eINSTANCE.getXExportDeclaration_Wildcard();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEXPORT_DECLARATION__IMPORT_URI = eINSTANCE.getXExportDeclaration_ImportURI();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xtype.impl.XExportItemImpl <em>XExport Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xtype.impl.XExportItemImpl
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getXExportItem()
		 * @generated
		 */
		EClass XEXPORT_ITEM = eINSTANCE.getXExportItem();

		/**
		 * The meta object literal for the '<em><b>Exported Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XEXPORT_ITEM__EXPORTED_ID = eINSTANCE.getXExportItem_ExportedId();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEXPORT_ITEM__ALIAS = eINSTANCE.getXExportItem_Alias();

		/**
		 * The meta object literal for the '<em>IJvm Type Reference Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider
		 * @see org.summer.dsl.model.xtype.impl.XtypePackageImpl#getIJvmTypeReferenceProvider()
		 * @generated
		 */
		EDataType IJVM_TYPE_REFERENCE_PROVIDER = eINSTANCE.getIJvmTypeReferenceProvider();

	}

} //XtypePackage
