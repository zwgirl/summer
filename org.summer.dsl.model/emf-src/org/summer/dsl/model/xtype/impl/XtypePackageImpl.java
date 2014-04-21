/**
 */
package org.summer.dsl.model.xtype.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.summer.dsl.model.richstring.RichstringPackage;
import org.summer.dsl.model.richstring.impl.RichstringPackageImpl;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ss.impl.SsPackageImpl;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.impl.TypesPackageImpl;
import org.summer.dsl.model.xannotation.XannotationPackage;
import org.summer.dsl.model.xannotation.impl.XannotationPackageImpl;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xbase.impl.XbasePackageImpl;
import org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportItem;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportDeclaration1;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.model.xtype.XImportSection1;
import org.summer.dsl.model.xtype.XtypeFactory;
import org.summer.dsl.model.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtypePackageImpl extends EPackageImpl implements XtypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFunctionTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xComputedTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xImportSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xImportDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xImportSection1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xImportDeclaration1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xImportItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xExportSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xExportDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xExportItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iJvmTypeReferenceProviderEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.summer.dsl.model.xtype.XtypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XtypePackageImpl() {
		super(eNS_URI, XtypeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link XtypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XtypePackage init() {
		if (isInited) return (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);

		// Obtain or create and register package
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XtypePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) : XbasePackage.eINSTANCE);
		SsPackageImpl theSsPackage = (SsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SsPackage.eNS_URI) instanceof SsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SsPackage.eNS_URI) : SsPackage.eINSTANCE);
		XannotationPackageImpl theXannotationPackage = (XannotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XannotationPackage.eNS_URI) instanceof XannotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XannotationPackage.eNS_URI) : XannotationPackage.eINSTANCE);
		RichstringPackageImpl theRichstringPackage = (RichstringPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RichstringPackage.eNS_URI) instanceof RichstringPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RichstringPackage.eNS_URI) : RichstringPackage.eINSTANCE);

		// Create package meta-data objects
		theXtypePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theXbasePackage.createPackageContents();
		theSsPackage.createPackageContents();
		theXannotationPackage.createPackageContents();
		theRichstringPackage.createPackageContents();

		// Initialize created meta-data
		theXtypePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theXbasePackage.initializePackageContents();
		theSsPackage.initializePackageContents();
		theXannotationPackage.initializePackageContents();
		theRichstringPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXtypePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XtypePackage.eNS_URI, theXtypePackage);
		return theXtypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFunctionTypeRef() {
		return xFunctionTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionTypeRef_ParamTypes() {
		return (EReference)xFunctionTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionTypeRef_ReturnType() {
		return (EReference)xFunctionTypeRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionTypeRef_Type() {
		return (EReference)xFunctionTypeRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFunctionTypeRef_InstanceContext() {
		return (EAttribute)xFunctionTypeRefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXComputedTypeReference() {
		return xComputedTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXComputedTypeReference_TypeProvider() {
		return (EAttribute)xComputedTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXImportSection() {
		return xImportSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXImportSection_ImportDeclarations() {
		return (EReference)xImportSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXImportDeclaration() {
		return xImportDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImportDeclaration_Extension() {
		return (EAttribute)xImportDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImportDeclaration_Static() {
		return (EAttribute)xImportDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXImportDeclaration_ImportedType() {
		return (EReference)xImportDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImportDeclaration_ImportedNamespace() {
		return (EAttribute)xImportDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImportDeclaration_Wildcard() {
		return (EAttribute)xImportDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXImportSection1() {
		return xImportSection1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXImportSection1_ImportDeclarations() {
		return (EReference)xImportSection1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXImportDeclaration1() {
		return xImportDeclaration1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXImportDeclaration1_ImportItems() {
		return (EReference)xImportDeclaration1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImportDeclaration1_Alias() {
		return (EAttribute)xImportDeclaration1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImportDeclaration1_ImportURI() {
		return (EAttribute)xImportDeclaration1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXImportItem() {
		return xImportItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXImportItem_ImportedId() {
		return (EReference)xImportItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXImportItem_Alias() {
		return (EAttribute)xImportItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXExportSection() {
		return xExportSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXExportSection_ExportDeclarations() {
		return (EReference)xExportSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXExportDeclaration() {
		return xExportDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXExportDeclaration_ExportItems() {
		return (EReference)xExportDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXExportDeclaration_Alias() {
		return (EAttribute)xExportDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXExportDeclaration_Wildcard() {
		return (EAttribute)xExportDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXExportDeclaration_ImportURI() {
		return (EAttribute)xExportDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXExportItem() {
		return xExportItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXExportItem_ExportedId() {
		return (EReference)xExportItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXExportItem_Alias() {
		return (EAttribute)xExportItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIJvmTypeReferenceProvider() {
		return iJvmTypeReferenceProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypeFactory getXtypeFactory() {
		return (XtypeFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xFunctionTypeRefEClass = createEClass(XFUNCTION_TYPE_REF);
		createEReference(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__PARAM_TYPES);
		createEReference(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__RETURN_TYPE);
		createEReference(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__TYPE);
		createEAttribute(xFunctionTypeRefEClass, XFUNCTION_TYPE_REF__INSTANCE_CONTEXT);

		xComputedTypeReferenceEClass = createEClass(XCOMPUTED_TYPE_REFERENCE);
		createEAttribute(xComputedTypeReferenceEClass, XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER);

		xImportSectionEClass = createEClass(XIMPORT_SECTION);
		createEReference(xImportSectionEClass, XIMPORT_SECTION__IMPORT_DECLARATIONS);

		xImportDeclarationEClass = createEClass(XIMPORT_DECLARATION);
		createEAttribute(xImportDeclarationEClass, XIMPORT_DECLARATION__EXTENSION);
		createEAttribute(xImportDeclarationEClass, XIMPORT_DECLARATION__STATIC);
		createEReference(xImportDeclarationEClass, XIMPORT_DECLARATION__IMPORTED_TYPE);
		createEAttribute(xImportDeclarationEClass, XIMPORT_DECLARATION__IMPORTED_NAMESPACE);
		createEAttribute(xImportDeclarationEClass, XIMPORT_DECLARATION__WILDCARD);

		xImportSection1EClass = createEClass(XIMPORT_SECTION1);
		createEReference(xImportSection1EClass, XIMPORT_SECTION1__IMPORT_DECLARATIONS);

		xImportDeclaration1EClass = createEClass(XIMPORT_DECLARATION1);
		createEReference(xImportDeclaration1EClass, XIMPORT_DECLARATION1__IMPORT_ITEMS);
		createEAttribute(xImportDeclaration1EClass, XIMPORT_DECLARATION1__ALIAS);
		createEAttribute(xImportDeclaration1EClass, XIMPORT_DECLARATION1__IMPORT_URI);

		xImportItemEClass = createEClass(XIMPORT_ITEM);
		createEReference(xImportItemEClass, XIMPORT_ITEM__IMPORTED_ID);
		createEAttribute(xImportItemEClass, XIMPORT_ITEM__ALIAS);

		xExportSectionEClass = createEClass(XEXPORT_SECTION);
		createEReference(xExportSectionEClass, XEXPORT_SECTION__EXPORT_DECLARATIONS);

		xExportDeclarationEClass = createEClass(XEXPORT_DECLARATION);
		createEReference(xExportDeclarationEClass, XEXPORT_DECLARATION__EXPORT_ITEMS);
		createEAttribute(xExportDeclarationEClass, XEXPORT_DECLARATION__ALIAS);
		createEAttribute(xExportDeclarationEClass, XEXPORT_DECLARATION__WILDCARD);
		createEAttribute(xExportDeclarationEClass, XEXPORT_DECLARATION__IMPORT_URI);

		xExportItemEClass = createEClass(XEXPORT_ITEM);
		createEReference(xExportItemEClass, XEXPORT_ITEM__EXPORTED_ID);
		createEAttribute(xExportItemEClass, XEXPORT_ITEM__ALIAS);

		// Create data types
		iJvmTypeReferenceProviderEDataType = createEDataType(IJVM_TYPE_REFERENCE_PROVIDER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xFunctionTypeRefEClass.getESuperTypes().add(theTypesPackage.getJvmSpecializedTypeReference());
		xComputedTypeReferenceEClass.getESuperTypes().add(theTypesPackage.getJvmSpecializedTypeReference());

		// Initialize classes and features; add operations and parameters
		initEClass(xFunctionTypeRefEClass, XFunctionTypeRef.class, "XFunctionTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFunctionTypeRef_ParamTypes(), theTypesPackage.getJvmTypeReference(), null, "paramTypes", null, 0, -1, XFunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionTypeRef_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, XFunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionTypeRef_Type(), theTypesPackage.getJvmType(), null, "type", null, 0, 1, XFunctionTypeRef.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFunctionTypeRef_InstanceContext(), ecorePackage.getEBoolean(), "instanceContext", null, 0, 1, XFunctionTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xComputedTypeReferenceEClass, XComputedTypeReference.class, "XComputedTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXComputedTypeReference_TypeProvider(), this.getIJvmTypeReferenceProvider(), "typeProvider", null, 0, 1, XComputedTypeReference.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xImportSectionEClass, XImportSection.class, "XImportSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXImportSection_ImportDeclarations(), this.getXImportDeclaration(), null, "importDeclarations", null, 0, -1, XImportSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xImportDeclarationEClass, XImportDeclaration.class, "XImportDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXImportDeclaration_Extension(), ecorePackage.getEBoolean(), "extension", null, 0, 1, XImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXImportDeclaration_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, XImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXImportDeclaration_ImportedType(), theTypesPackage.getJvmDeclaredType(), null, "importedType", null, 0, 1, XImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXImportDeclaration_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, XImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXImportDeclaration_Wildcard(), ecorePackage.getEBoolean(), "wildcard", null, 0, 1, XImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xImportDeclarationEClass, ecorePackage.getEString(), "getImportedTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xImportSection1EClass, XImportSection1.class, "XImportSection1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXImportSection1_ImportDeclarations(), this.getXImportDeclaration1(), null, "importDeclarations", null, 0, -1, XImportSection1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xImportDeclaration1EClass, XImportDeclaration1.class, "XImportDeclaration1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXImportDeclaration1_ImportItems(), this.getXImportItem(), null, "importItems", null, 0, -1, XImportDeclaration1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXImportDeclaration1_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, XImportDeclaration1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXImportDeclaration1_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, XImportDeclaration1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xImportDeclaration1EClass, ecorePackage.getEBoolean(), "isWildcard", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xImportItemEClass, XImportItem.class, "XImportItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXImportItem_ImportedId(), theTypesPackage.getJvmIdentifiableElement(), null, "importedId", null, 0, 1, XImportItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXImportItem_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, XImportItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xExportSectionEClass, XExportSection.class, "XExportSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXExportSection_ExportDeclarations(), this.getXExportDeclaration(), null, "exportDeclarations", null, 0, -1, XExportSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xExportDeclarationEClass, XExportDeclaration.class, "XExportDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXExportDeclaration_ExportItems(), this.getXExportItem(), null, "exportItems", null, 0, -1, XExportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXExportDeclaration_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, XExportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXExportDeclaration_Wildcard(), ecorePackage.getEBoolean(), "wildcard", null, 0, 1, XExportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXExportDeclaration_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, XExportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xExportItemEClass, XExportItem.class, "XExportItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXExportItem_ExportedId(), theTypesPackage.getJvmIdentifiableElement(), null, "exportedId", null, 0, 1, XExportItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXExportItem_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, XExportItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(iJvmTypeReferenceProviderEDataType, IJvmTypeReferenceProvider.class, "IJvmTypeReferenceProvider", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //XtypePackageImpl
