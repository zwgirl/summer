/**
 */
package org.summer.dsl.model.xannotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.summer.dsl.model.richstring.RichstringPackage;

import org.summer.dsl.model.richstring.impl.RichstringPackageImpl;

import org.summer.dsl.model.ss.SsPackage;

import org.summer.dsl.model.ss.impl.SsPackageImpl;

import org.summer.dsl.model.types.TypesPackage;

import org.summer.dsl.model.types.impl.TypesPackageImpl;

import org.summer.dsl.model.xaml.XamlPackage;
import org.summer.dsl.model.xaml.impl.XamlPackageImpl;
import org.summer.dsl.model.xannotation.XAnnotation;
import org.summer.dsl.model.xannotation.XAnnotationElementValuePair;
import org.summer.dsl.model.xannotation.XannotationFactory;
import org.summer.dsl.model.xannotation.XannotationPackage;

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
public class XannotationPackageImpl extends EPackageImpl implements XannotationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAnnotationElementValuePairEClass = null;

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
	 * @see org.summer.dsl.model.xannotation.XannotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XannotationPackageImpl() {
		super(eNS_URI, XannotationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XannotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XannotationPackage init() {
		if (isInited) return (XannotationPackage)EPackage.Registry.INSTANCE.getEPackage(XannotationPackage.eNS_URI);

		// Obtain or create and register package
		XannotationPackageImpl theXannotationPackage = (XannotationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XannotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XannotationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) : XbasePackage.eINSTANCE);
		SsPackageImpl theSsPackage = (SsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SsPackage.eNS_URI) instanceof SsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SsPackage.eNS_URI) : SsPackage.eINSTANCE);
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);
		RichstringPackageImpl theRichstringPackage = (RichstringPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RichstringPackage.eNS_URI) instanceof RichstringPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RichstringPackage.eNS_URI) : RichstringPackage.eINSTANCE);
		XamlPackageImpl theXamlPackage = (XamlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) instanceof XamlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) : XamlPackage.eINSTANCE);

		// Create package meta-data objects
		theXannotationPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theXbasePackage.createPackageContents();
		theSsPackage.createPackageContents();
		theXtypePackage.createPackageContents();
		theRichstringPackage.createPackageContents();
		theXamlPackage.createPackageContents();

		// Initialize created meta-data
		theXannotationPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theXbasePackage.initializePackageContents();
		theSsPackage.initializePackageContents();
		theXtypePackage.initializePackageContents();
		theRichstringPackage.initializePackageContents();
		theXamlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXannotationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XannotationPackage.eNS_URI, theXannotationPackage);
		return theXannotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAnnotation() {
		return xAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAnnotation_ElementValuePairs() {
		return (EReference)xAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAnnotation_AnnotationType() {
		return (EReference)xAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAnnotation_Value() {
		return (EReference)xAnnotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAnnotationElementValuePair() {
		return xAnnotationElementValuePairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAnnotationElementValuePair_Value() {
		return (EReference)xAnnotationElementValuePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAnnotationElementValuePair_Element() {
		return (EReference)xAnnotationElementValuePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XannotationFactory getXannotationFactory() {
		return (XannotationFactory)getEFactoryInstance();
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
		xAnnotationEClass = createEClass(XANNOTATION);
		createEReference(xAnnotationEClass, XANNOTATION__ELEMENT_VALUE_PAIRS);
		createEReference(xAnnotationEClass, XANNOTATION__ANNOTATION_TYPE);
		createEReference(xAnnotationEClass, XANNOTATION__VALUE);

		xAnnotationElementValuePairEClass = createEClass(XANNOTATION_ELEMENT_VALUE_PAIR);
		createEReference(xAnnotationElementValuePairEClass, XANNOTATION_ELEMENT_VALUE_PAIR__VALUE);
		createEReference(xAnnotationElementValuePairEClass, XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT);
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
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xAnnotationEClass.getESuperTypes().add(theXbasePackage.getXExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(xAnnotationEClass, XAnnotation.class, "XAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAnnotation_ElementValuePairs(), this.getXAnnotationElementValuePair(), null, "elementValuePairs", null, 0, -1, XAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAnnotation_AnnotationType(), theTypesPackage.getJvmType(), null, "annotationType", null, 0, 1, XAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAnnotation_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, XAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAnnotationElementValuePairEClass, XAnnotationElementValuePair.class, "XAnnotationElementValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAnnotationElementValuePair_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, XAnnotationElementValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAnnotationElementValuePair_Element(), theTypesPackage.getJvmOperation(), null, "element", null, 0, 1, XAnnotationElementValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XannotationPackageImpl
