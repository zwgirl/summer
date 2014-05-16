/**
 */
package org.summer.dsl.model.xaml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.impl.TypesPackageImpl;
import org.summer.dsl.model.xaml.XAbstractAttribute;
import org.summer.dsl.model.xaml.XAttachAttribute;
import org.summer.dsl.model.xaml.XAttributeElement;
import org.summer.dsl.model.xaml.XElement;
import org.summer.dsl.model.xaml.XGeneralAttribute;
import org.summer.dsl.model.xaml.XMarkupExtenson;
import org.summer.dsl.model.xaml.XObjectElement;
import org.summer.dsl.model.xaml.XamlFactory;
import org.summer.dsl.model.xaml.XamlPackage;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xbase.impl.XbasePackageImpl;
import org.summer.dsl.model.xtype.XtypePackage;
import org.summer.dsl.model.xtype.impl.XtypePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XamlPackageImpl extends EPackageImpl implements XamlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xObjectElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAttributeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAbstractAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xMarkupExtensonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAttachAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xGeneralAttributeEClass = null;

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
	 * @see org.summer.dsl.model.xaml.XamlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XamlPackageImpl() {
		super(eNS_URI, XamlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XamlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XamlPackage init() {
		if (isInited) return (XamlPackage)EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI);

		// Obtain or create and register package
		XamlPackageImpl theXamlPackage = (XamlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XamlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XamlPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) : XbasePackage.eINSTANCE);
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);

		// Create package meta-data objects
		theXamlPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theXbasePackage.createPackageContents();
		theXtypePackage.createPackageContents();

		// Initialize created meta-data
		theXamlPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theXbasePackage.initializePackageContents();
		theXtypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXamlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XamlPackage.eNS_URI, theXamlPackage);
		return theXamlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXElement() {
		return xElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXElement_Contents() {
		return (EReference)xElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXElement_Type() {
		return (EReference)xElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXElement_CloseType() {
		return (EReference)xElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXElement_Properties() {
		return (EReference)xElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXObjectElement() {
		return xObjectElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAttributeElement() {
		return xAttributeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAttributeElement_Field() {
		return (EReference)xAttributeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAttributeElement_CloseField() {
		return (EReference)xAttributeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAbstractAttribute() {
		return xAbstractAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractAttribute_Field() {
		return (EReference)xAbstractAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractAttribute_Value() {
		return (EReference)xAbstractAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractAttribute_Type() {
		return (EReference)xAbstractAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMarkupExtenson() {
		return xMarkupExtensonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAttachAttribute() {
		return xAttachAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXGeneralAttribute() {
		return xGeneralAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XamlFactory getXamlFactory() {
		return (XamlFactory)getEFactoryInstance();
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
		xElementEClass = createEClass(XELEMENT);
		createEReference(xElementEClass, XELEMENT__CONTENTS);
		createEReference(xElementEClass, XELEMENT__TYPE);
		createEReference(xElementEClass, XELEMENT__CLOSE_TYPE);
		createEReference(xElementEClass, XELEMENT__PROPERTIES);

		xObjectElementEClass = createEClass(XOBJECT_ELEMENT);

		xAttributeElementEClass = createEClass(XATTRIBUTE_ELEMENT);
		createEReference(xAttributeElementEClass, XATTRIBUTE_ELEMENT__FIELD);
		createEReference(xAttributeElementEClass, XATTRIBUTE_ELEMENT__CLOSE_FIELD);

		xAbstractAttributeEClass = createEClass(XABSTRACT_ATTRIBUTE);
		createEReference(xAbstractAttributeEClass, XABSTRACT_ATTRIBUTE__TYPE);
		createEReference(xAbstractAttributeEClass, XABSTRACT_ATTRIBUTE__FIELD);
		createEReference(xAbstractAttributeEClass, XABSTRACT_ATTRIBUTE__VALUE);

		xMarkupExtensonEClass = createEClass(XMARKUP_EXTENSON);

		xAttachAttributeEClass = createEClass(XATTACH_ATTRIBUTE);

		xGeneralAttributeEClass = createEClass(XGENERAL_ATTRIBUTE);
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
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xObjectElementEClass.getESuperTypes().add(this.getXElement());
		xAttributeElementEClass.getESuperTypes().add(this.getXElement());
		xMarkupExtensonEClass.getESuperTypes().add(this.getXElement());
		xMarkupExtensonEClass.getESuperTypes().add(theXbasePackage.getXExpression());
		xAttachAttributeEClass.getESuperTypes().add(this.getXAbstractAttribute());
		xGeneralAttributeEClass.getESuperTypes().add(this.getXAbstractAttribute());

		// Initialize classes and features; add operations and parameters
		initEClass(xElementEClass, XElement.class, "XElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXElement_Contents(), this.getXElement(), null, "contents", null, 0, -1, XElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXElement_Type(), theTypesPackage.getJvmType(), null, "type", null, 0, 1, XElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXElement_CloseType(), theTypesPackage.getJvmType(), null, "closeType", null, 0, 1, XElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXElement_Properties(), this.getXAbstractAttribute(), null, "properties", null, 0, -1, XElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xObjectElementEClass, XObjectElement.class, "XObjectElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xAttributeElementEClass, XAttributeElement.class, "XAttributeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAttributeElement_Field(), theTypesPackage.getJvmField(), null, "field", null, 0, 1, XAttributeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAttributeElement_CloseField(), theTypesPackage.getJvmField(), null, "closeField", null, 0, 1, XAttributeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAbstractAttributeEClass, XAbstractAttribute.class, "XAbstractAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAbstractAttribute_Type(), theTypesPackage.getJvmType(), null, "type", null, 0, 1, XAbstractAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractAttribute_Field(), theTypesPackage.getJvmField(), null, "field", null, 0, 1, XAbstractAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractAttribute_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, XAbstractAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xMarkupExtensonEClass, XMarkupExtenson.class, "XMarkupExtenson", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xAttachAttributeEClass, XAttachAttribute.class, "XAttachAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xGeneralAttributeEClass, XGeneralAttribute.class, "XGeneralAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //XamlPackageImpl
