/**
 */
package org.summer.dsl.model.types.impl;

import java.lang.Iterable;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.summer.dsl.model.types.JvmAnnotationAnnotationValue;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.JvmBeanType;
import org.summer.dsl.model.types.JvmBooleanAnnotationValue;
import org.summer.dsl.model.types.JvmByteAnnotationValue;
import org.summer.dsl.model.types.JvmCharAnnotationValue;
import org.summer.dsl.model.types.JvmComponentType;
import org.summer.dsl.model.types.JvmCompoundTypeReference;
import org.summer.dsl.model.types.JvmConstraintOwner;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmCustomAnnotationValue;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDelegateType;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmDoubleAnnotationValue;
import org.summer.dsl.model.types.JvmEnumAnnotationValue;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmEvent;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFloatAnnotationValue;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmIndexer;
import org.summer.dsl.model.types.JvmIntAnnotationValue;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmLongAnnotationValue;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmMultiTypeReference;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmRemoteType;
import org.summer.dsl.model.types.JvmShortAnnotationValue;
import org.summer.dsl.model.types.JvmSpecializedTypeReference;
import org.summer.dsl.model.types.JvmStringAnnotationValue;
import org.summer.dsl.model.types.JvmStructType;
import org.summer.dsl.model.types.JvmSynonymTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeAnnotationValue;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.util.ITypeReferenceVisitor;
import org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter;
import org.summer.dsl.model.xaml.XamlPackage;
import org.summer.dsl.model.xaml.impl.XamlPackageImpl;
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
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmIdentifiableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmDelegateTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmVoidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmPrimitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmArrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmDeclaredTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmStructTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeParameterDeclaratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmConstraintOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmUpperBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmLowerBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmEnumerationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmEnumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmGenericTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmInterfaceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmRemoteTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmBeanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmParameterizedTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmGenericArrayTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmWildcardTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnyTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmMultiTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmIndexerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmExecutableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmConstructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFormalParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmIntAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmBooleanAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmByteAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmShortAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmLongAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmDoubleAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFloatAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmCharAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmStringAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmEnumAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmDelegateTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmSpecializedTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmSynonymTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmUnknownTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmCompoundTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmCustomAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jvmVisibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iterableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iTypeReferenceVisitorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iTypeReferenceVisitorWithParameterEDataType = null;

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
	 * @see org.summer.dsl.model.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl() {
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init() {
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) : XbasePackage.eINSTANCE);
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);
		XamlPackageImpl theXamlPackage = (XamlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) instanceof XamlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) : XamlPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theXbasePackage.createPackageContents();
		theXtypePackage.createPackageContents();
		theXamlPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theXbasePackage.initializePackageContents();
		theXtypePackage.initializePackageContents();
		theXamlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmIdentifiableElement() {
		return jvmIdentifiableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmModule() {
		return jvmModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmModule_SimpleName() {
		return (EAttribute)jvmModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmModule_ImportSection() {
		return (EReference)jvmModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmModule_Contents() {
		return (EReference)jvmModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmModule_ExportSection() {
		return (EReference)jvmModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmModule_Root() {
		return (EReference)jvmModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmModule_PackageName() {
		return (EAttribute)jvmModuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmModule_Identifier() {
		return (EAttribute)jvmModuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmType() {
		return jvmTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmDelegateType() {
		return jvmDelegateTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmDelegateType_ReturnType() {
		return (EReference)jvmDelegateTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmDelegateType_Parameters() {
		return (EReference)jvmDelegateTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDelegateType_VarArgs() {
		return (EAttribute)jvmDelegateTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDelegateType_SimpleName() {
		return (EAttribute)jvmDelegateTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDelegateType_Identifier() {
		return (EAttribute)jvmDelegateTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDelegateType_Exported() {
		return (EAttribute)jvmDelegateTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmDelegateType_Annotations() {
		return (EReference)jvmDelegateTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmVoid() {
		return jvmVoidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmComponentType() {
		return jvmComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmComponentType_ArrayType() {
		return (EReference)jvmComponentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmPrimitiveType() {
		return jvmPrimitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmPrimitiveType_SimpleName() {
		return (EAttribute)jvmPrimitiveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmArrayType() {
		return jvmArrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmArrayType_ComponentType() {
		return (EReference)jvmArrayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmDeclaredType() {
		return jvmDeclaredTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmDeclaredType_SuperTypes() {
		return (EReference)jvmDeclaredTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmDeclaredType_Members() {
		return (EReference)jvmDeclaredTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDeclaredType_Abstract() {
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDeclaredType_Final() {
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDeclaredType_PackageName() {
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDeclaredType_Exported() {
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmStructType() {
		return jvmStructTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmStructType_Implements() {
		return (EReference)jvmStructTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmStructType_Parameters() {
		return (EReference)jvmStructTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmTypeParameter() {
		return jvmTypeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmTypeParameter_SimpleName() {
		return (EAttribute)jvmTypeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmTypeParameter_Declarator() {
		return (EReference)jvmTypeParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmTypeParameterDeclarator() {
		return jvmTypeParameterDeclaratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmTypeParameterDeclarator_TypeParameters() {
		return (EReference)jvmTypeParameterDeclaratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmConstraintOwner() {
		return jvmConstraintOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmConstraintOwner_Constraints() {
		return (EReference)jvmConstraintOwnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmTypeConstraint() {
		return jvmTypeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmTypeConstraint_TypeReference() {
		return (EReference)jvmTypeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmTypeConstraint_Owner() {
		return (EReference)jvmTypeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmUpperBound() {
		return jvmUpperBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmLowerBound() {
		return jvmLowerBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmAnnotationType() {
		return jvmAnnotationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmEnumerationType() {
		return jvmEnumerationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmEnumerationType_Literals() {
		return (EReference)jvmEnumerationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmEnumerationLiteral() {
		return jvmEnumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmEnumerationLiteral_Ordinal() {
		return (EAttribute)jvmEnumerationLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmGenericType() {
		return jvmGenericTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmGenericType_Extends() {
		return (EReference)jvmGenericTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmGenericType_Implements() {
		return (EReference)jvmGenericTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmGenericType_Root() {
		return (EReference)jvmGenericTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmInterfaceType() {
		return jvmInterfaceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmInterfaceType_Implements() {
		return (EReference)jvmInterfaceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmRemoteType() {
		return jvmRemoteTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmRemoteType_Implements() {
		return (EReference)jvmRemoteTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmBeanType() {
		return jvmBeanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmBeanType_Implements() {
		return (EReference)jvmBeanTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmTypeReference() {
		return jvmTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmParameterizedTypeReference() {
		return jvmParameterizedTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmParameterizedTypeReference_Arguments() {
		return (EReference)jvmParameterizedTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmParameterizedTypeReference_Type() {
		return (EReference)jvmParameterizedTypeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmGenericArrayTypeReference() {
		return jvmGenericArrayTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmGenericArrayTypeReference_ComponentType() {
		return (EReference)jvmGenericArrayTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmWildcardTypeReference() {
		return jvmWildcardTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmAnyTypeReference() {
		return jvmAnyTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnyTypeReference_Type() {
		return (EReference)jvmAnyTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmMultiTypeReference() {
		return jvmMultiTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmMember() {
		return jvmMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmMember_DeclaringType() {
		return (EReference)jvmMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmMember_Visibility() {
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmMember_SimpleName() {
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmMember_Identifier() {
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmMember_AnnotationInfo() {
		return (EReference)jvmMemberEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmMember_Modifiers() {
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmFeature() {
		return jvmFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmField() {
		return jvmFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmField_Static() {
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmField_Final() {
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmField_Type() {
		return (EReference)jvmFieldEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmField_Transient() {
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmField_Virtaul() {
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmField_Override() {
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmField_Property() {
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmField_DefaultValue() {
		return (EReference)jvmFieldEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmField_Parameters() {
		return (EReference)jvmFieldEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmField_Set() {
		return (EReference)jvmFieldEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmField_Get() {
		return (EReference)jvmFieldEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmField_Indexer() {
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmIndexer() {
		return jvmIndexerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmEvent() {
		return jvmEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmEvent_Static() {
		return (EAttribute)jvmEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmEvent_Native() {
		return (EAttribute)jvmEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmEvent_Type() {
		return (EReference)jvmEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmEvent_Add() {
		return (EReference)jvmEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmEvent_Remove() {
		return (EReference)jvmEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmExecutable() {
		return jvmExecutableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmExecutable_Parameters() {
		return (EReference)jvmExecutableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmExecutable_Exceptions() {
		return (EReference)jvmExecutableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmExecutable_VarArgs() {
		return (EAttribute)jvmExecutableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmConstructor() {
		return jvmConstructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmConstructor_Body() {
		return (EReference)jvmConstructorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmOperation() {
		return jvmOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmOperation_Static() {
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmOperation_Abstract() {
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmOperation_Virtaul() {
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmOperation_ReturnType() {
		return (EReference)jvmOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmOperation_Native() {
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmOperation_Overload() {
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmOperation_Override() {
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmOperation_Body() {
		return (EReference)jvmOperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmOperation_Operator() {
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmFormalParameter() {
		return jvmFormalParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmFormalParameter_SimpleName() {
		return (EAttribute)jvmFormalParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmFormalParameter_ParameterType() {
		return (EReference)jvmFormalParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmFormalParameter_VarArg() {
		return (EAttribute)jvmFormalParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmFormalParameter_DefaultValue() {
		return (EReference)jvmFormalParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmFormalParameter_Ref() {
		return (EAttribute)jvmFormalParameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmFormalParameter_Out() {
		return (EAttribute)jvmFormalParameterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmAnnotationTarget() {
		return jvmAnnotationTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnnotationTarget_Annotations() {
		return (EReference)jvmAnnotationTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmAnnotationReference() {
		return jvmAnnotationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnnotationReference_Annotation() {
		return (EReference)jvmAnnotationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnnotationReference_Values() {
		return (EReference)jvmAnnotationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnnotationReference_Value() {
		return (EReference)jvmAnnotationReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmAnnotationValue() {
		return jvmAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnnotationValue_Field() {
		return (EReference)jvmAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnnotationValue_Value() {
		return (EReference)jvmAnnotationValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmIntAnnotationValue() {
		return jvmIntAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmIntAnnotationValue_Values() {
		return (EAttribute)jvmIntAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmBooleanAnnotationValue() {
		return jvmBooleanAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmBooleanAnnotationValue_Values() {
		return (EAttribute)jvmBooleanAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmByteAnnotationValue() {
		return jvmByteAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmByteAnnotationValue_Values() {
		return (EAttribute)jvmByteAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmShortAnnotationValue() {
		return jvmShortAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmShortAnnotationValue_Values() {
		return (EAttribute)jvmShortAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmLongAnnotationValue() {
		return jvmLongAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmLongAnnotationValue_Values() {
		return (EAttribute)jvmLongAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmDoubleAnnotationValue() {
		return jvmDoubleAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmDoubleAnnotationValue_Values() {
		return (EAttribute)jvmDoubleAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmFloatAnnotationValue() {
		return jvmFloatAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmFloatAnnotationValue_Values() {
		return (EAttribute)jvmFloatAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmCharAnnotationValue() {
		return jvmCharAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmCharAnnotationValue_Values() {
		return (EAttribute)jvmCharAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmStringAnnotationValue() {
		return jvmStringAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmStringAnnotationValue_Values() {
		return (EAttribute)jvmStringAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmTypeAnnotationValue() {
		return jvmTypeAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmTypeAnnotationValue_Values() {
		return (EReference)jvmTypeAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmAnnotationAnnotationValue() {
		return jvmAnnotationAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmAnnotationAnnotationValue_Values() {
		return (EReference)jvmAnnotationAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmEnumAnnotationValue() {
		return jvmEnumAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmEnumAnnotationValue_Values() {
		return (EReference)jvmEnumAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmDelegateTypeReference() {
		return jvmDelegateTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmDelegateTypeReference_Delegate() {
		return (EReference)jvmDelegateTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmSpecializedTypeReference() {
		return jvmSpecializedTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmSpecializedTypeReference_Equivalent() {
		return (EReference)jvmSpecializedTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmSynonymTypeReference() {
		return jvmSynonymTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmUnknownTypeReference() {
		return jvmUnknownTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmUnknownTypeReference_QualifiedName() {
		return (EAttribute)jvmUnknownTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmCompoundTypeReference() {
		return jvmCompoundTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmCompoundTypeReference_Type() {
		return (EReference)jvmCompoundTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJvmCompoundTypeReference_References() {
		return (EReference)jvmCompoundTypeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJvmCustomAnnotationValue() {
		return jvmCustomAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJvmCustomAnnotationValue_Values() {
		return (EAttribute)jvmCustomAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJvmVisibility() {
		return jvmVisibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIterable() {
		return iterableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getList() {
		return listEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getITypeReferenceVisitor() {
		return iTypeReferenceVisitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getITypeReferenceVisitorWithParameter() {
		return iTypeReferenceVisitorWithParameterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactory getTypesFactory() {
		return (TypesFactory)getEFactoryInstance();
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
		jvmIdentifiableElementEClass = createEClass(JVM_IDENTIFIABLE_ELEMENT);

		jvmModuleEClass = createEClass(JVM_MODULE);
		createEAttribute(jvmModuleEClass, JVM_MODULE__SIMPLE_NAME);
		createEReference(jvmModuleEClass, JVM_MODULE__IMPORT_SECTION);
		createEReference(jvmModuleEClass, JVM_MODULE__CONTENTS);
		createEReference(jvmModuleEClass, JVM_MODULE__EXPORT_SECTION);
		createEReference(jvmModuleEClass, JVM_MODULE__ROOT);
		createEAttribute(jvmModuleEClass, JVM_MODULE__PACKAGE_NAME);
		createEAttribute(jvmModuleEClass, JVM_MODULE__IDENTIFIER);

		jvmTypeEClass = createEClass(JVM_TYPE);

		jvmDelegateTypeEClass = createEClass(JVM_DELEGATE_TYPE);
		createEReference(jvmDelegateTypeEClass, JVM_DELEGATE_TYPE__RETURN_TYPE);
		createEReference(jvmDelegateTypeEClass, JVM_DELEGATE_TYPE__PARAMETERS);
		createEAttribute(jvmDelegateTypeEClass, JVM_DELEGATE_TYPE__VAR_ARGS);
		createEAttribute(jvmDelegateTypeEClass, JVM_DELEGATE_TYPE__SIMPLE_NAME);
		createEAttribute(jvmDelegateTypeEClass, JVM_DELEGATE_TYPE__IDENTIFIER);
		createEAttribute(jvmDelegateTypeEClass, JVM_DELEGATE_TYPE__EXPORTED);
		createEReference(jvmDelegateTypeEClass, JVM_DELEGATE_TYPE__ANNOTATIONS);

		jvmVoidEClass = createEClass(JVM_VOID);

		jvmComponentTypeEClass = createEClass(JVM_COMPONENT_TYPE);
		createEReference(jvmComponentTypeEClass, JVM_COMPONENT_TYPE__ARRAY_TYPE);

		jvmPrimitiveTypeEClass = createEClass(JVM_PRIMITIVE_TYPE);
		createEAttribute(jvmPrimitiveTypeEClass, JVM_PRIMITIVE_TYPE__SIMPLE_NAME);

		jvmArrayTypeEClass = createEClass(JVM_ARRAY_TYPE);
		createEReference(jvmArrayTypeEClass, JVM_ARRAY_TYPE__COMPONENT_TYPE);

		jvmDeclaredTypeEClass = createEClass(JVM_DECLARED_TYPE);
		createEReference(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__SUPER_TYPES);
		createEReference(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__MEMBERS);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__ABSTRACT);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__FINAL);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__PACKAGE_NAME);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__EXPORTED);

		jvmStructTypeEClass = createEClass(JVM_STRUCT_TYPE);
		createEReference(jvmStructTypeEClass, JVM_STRUCT_TYPE__IMPLEMENTS);
		createEReference(jvmStructTypeEClass, JVM_STRUCT_TYPE__PARAMETERS);

		jvmTypeParameterEClass = createEClass(JVM_TYPE_PARAMETER);
		createEAttribute(jvmTypeParameterEClass, JVM_TYPE_PARAMETER__SIMPLE_NAME);
		createEReference(jvmTypeParameterEClass, JVM_TYPE_PARAMETER__DECLARATOR);

		jvmTypeParameterDeclaratorEClass = createEClass(JVM_TYPE_PARAMETER_DECLARATOR);
		createEReference(jvmTypeParameterDeclaratorEClass, JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS);

		jvmConstraintOwnerEClass = createEClass(JVM_CONSTRAINT_OWNER);
		createEReference(jvmConstraintOwnerEClass, JVM_CONSTRAINT_OWNER__CONSTRAINTS);

		jvmTypeConstraintEClass = createEClass(JVM_TYPE_CONSTRAINT);
		createEReference(jvmTypeConstraintEClass, JVM_TYPE_CONSTRAINT__TYPE_REFERENCE);
		createEReference(jvmTypeConstraintEClass, JVM_TYPE_CONSTRAINT__OWNER);

		jvmUpperBoundEClass = createEClass(JVM_UPPER_BOUND);

		jvmLowerBoundEClass = createEClass(JVM_LOWER_BOUND);

		jvmAnnotationTypeEClass = createEClass(JVM_ANNOTATION_TYPE);

		jvmEnumerationTypeEClass = createEClass(JVM_ENUMERATION_TYPE);
		createEReference(jvmEnumerationTypeEClass, JVM_ENUMERATION_TYPE__LITERALS);

		jvmEnumerationLiteralEClass = createEClass(JVM_ENUMERATION_LITERAL);
		createEAttribute(jvmEnumerationLiteralEClass, JVM_ENUMERATION_LITERAL__ORDINAL);

		jvmGenericTypeEClass = createEClass(JVM_GENERIC_TYPE);
		createEReference(jvmGenericTypeEClass, JVM_GENERIC_TYPE__EXTENDS);
		createEReference(jvmGenericTypeEClass, JVM_GENERIC_TYPE__IMPLEMENTS);
		createEReference(jvmGenericTypeEClass, JVM_GENERIC_TYPE__ROOT);

		jvmInterfaceTypeEClass = createEClass(JVM_INTERFACE_TYPE);
		createEReference(jvmInterfaceTypeEClass, JVM_INTERFACE_TYPE__IMPLEMENTS);

		jvmRemoteTypeEClass = createEClass(JVM_REMOTE_TYPE);
		createEReference(jvmRemoteTypeEClass, JVM_REMOTE_TYPE__IMPLEMENTS);

		jvmBeanTypeEClass = createEClass(JVM_BEAN_TYPE);
		createEReference(jvmBeanTypeEClass, JVM_BEAN_TYPE__IMPLEMENTS);

		jvmTypeReferenceEClass = createEClass(JVM_TYPE_REFERENCE);

		jvmParameterizedTypeReferenceEClass = createEClass(JVM_PARAMETERIZED_TYPE_REFERENCE);
		createEReference(jvmParameterizedTypeReferenceEClass, JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS);
		createEReference(jvmParameterizedTypeReferenceEClass, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);

		jvmGenericArrayTypeReferenceEClass = createEClass(JVM_GENERIC_ARRAY_TYPE_REFERENCE);
		createEReference(jvmGenericArrayTypeReferenceEClass, JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE);

		jvmWildcardTypeReferenceEClass = createEClass(JVM_WILDCARD_TYPE_REFERENCE);

		jvmAnyTypeReferenceEClass = createEClass(JVM_ANY_TYPE_REFERENCE);
		createEReference(jvmAnyTypeReferenceEClass, JVM_ANY_TYPE_REFERENCE__TYPE);

		jvmMultiTypeReferenceEClass = createEClass(JVM_MULTI_TYPE_REFERENCE);

		jvmMemberEClass = createEClass(JVM_MEMBER);
		createEReference(jvmMemberEClass, JVM_MEMBER__DECLARING_TYPE);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__VISIBILITY);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__SIMPLE_NAME);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__IDENTIFIER);
		createEReference(jvmMemberEClass, JVM_MEMBER__ANNOTATION_INFO);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__MODIFIERS);

		jvmFeatureEClass = createEClass(JVM_FEATURE);

		jvmFieldEClass = createEClass(JVM_FIELD);
		createEAttribute(jvmFieldEClass, JVM_FIELD__STATIC);
		createEAttribute(jvmFieldEClass, JVM_FIELD__FINAL);
		createEAttribute(jvmFieldEClass, JVM_FIELD__TRANSIENT);
		createEAttribute(jvmFieldEClass, JVM_FIELD__VIRTAUL);
		createEAttribute(jvmFieldEClass, JVM_FIELD__OVERRIDE);
		createEAttribute(jvmFieldEClass, JVM_FIELD__PROPERTY);
		createEReference(jvmFieldEClass, JVM_FIELD__TYPE);
		createEReference(jvmFieldEClass, JVM_FIELD__DEFAULT_VALUE);
		createEReference(jvmFieldEClass, JVM_FIELD__PARAMETERS);
		createEReference(jvmFieldEClass, JVM_FIELD__SET);
		createEReference(jvmFieldEClass, JVM_FIELD__GET);
		createEAttribute(jvmFieldEClass, JVM_FIELD__INDEXER);

		jvmIndexerEClass = createEClass(JVM_INDEXER);

		jvmEventEClass = createEClass(JVM_EVENT);
		createEAttribute(jvmEventEClass, JVM_EVENT__STATIC);
		createEAttribute(jvmEventEClass, JVM_EVENT__NATIVE);
		createEReference(jvmEventEClass, JVM_EVENT__TYPE);
		createEReference(jvmEventEClass, JVM_EVENT__ADD);
		createEReference(jvmEventEClass, JVM_EVENT__REMOVE);

		jvmExecutableEClass = createEClass(JVM_EXECUTABLE);
		createEReference(jvmExecutableEClass, JVM_EXECUTABLE__PARAMETERS);
		createEReference(jvmExecutableEClass, JVM_EXECUTABLE__EXCEPTIONS);
		createEAttribute(jvmExecutableEClass, JVM_EXECUTABLE__VAR_ARGS);

		jvmConstructorEClass = createEClass(JVM_CONSTRUCTOR);
		createEReference(jvmConstructorEClass, JVM_CONSTRUCTOR__BODY);

		jvmOperationEClass = createEClass(JVM_OPERATION);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__STATIC);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__ABSTRACT);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__VIRTAUL);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__OVERRIDE);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__NATIVE);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__OVERLOAD);
		createEReference(jvmOperationEClass, JVM_OPERATION__RETURN_TYPE);
		createEReference(jvmOperationEClass, JVM_OPERATION__BODY);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__OPERATOR);

		jvmFormalParameterEClass = createEClass(JVM_FORMAL_PARAMETER);
		createEAttribute(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__SIMPLE_NAME);
		createEReference(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__PARAMETER_TYPE);
		createEAttribute(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__VAR_ARG);
		createEReference(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__DEFAULT_VALUE);
		createEAttribute(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__REF);
		createEAttribute(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__OUT);

		jvmAnnotationTargetEClass = createEClass(JVM_ANNOTATION_TARGET);
		createEReference(jvmAnnotationTargetEClass, JVM_ANNOTATION_TARGET__ANNOTATIONS);

		jvmAnnotationReferenceEClass = createEClass(JVM_ANNOTATION_REFERENCE);
		createEReference(jvmAnnotationReferenceEClass, JVM_ANNOTATION_REFERENCE__ANNOTATION);
		createEReference(jvmAnnotationReferenceEClass, JVM_ANNOTATION_REFERENCE__VALUES);
		createEReference(jvmAnnotationReferenceEClass, JVM_ANNOTATION_REFERENCE__VALUE);

		jvmAnnotationValueEClass = createEClass(JVM_ANNOTATION_VALUE);
		createEReference(jvmAnnotationValueEClass, JVM_ANNOTATION_VALUE__FIELD);
		createEReference(jvmAnnotationValueEClass, JVM_ANNOTATION_VALUE__VALUE);

		jvmIntAnnotationValueEClass = createEClass(JVM_INT_ANNOTATION_VALUE);
		createEAttribute(jvmIntAnnotationValueEClass, JVM_INT_ANNOTATION_VALUE__VALUES);

		jvmBooleanAnnotationValueEClass = createEClass(JVM_BOOLEAN_ANNOTATION_VALUE);
		createEAttribute(jvmBooleanAnnotationValueEClass, JVM_BOOLEAN_ANNOTATION_VALUE__VALUES);

		jvmByteAnnotationValueEClass = createEClass(JVM_BYTE_ANNOTATION_VALUE);
		createEAttribute(jvmByteAnnotationValueEClass, JVM_BYTE_ANNOTATION_VALUE__VALUES);

		jvmShortAnnotationValueEClass = createEClass(JVM_SHORT_ANNOTATION_VALUE);
		createEAttribute(jvmShortAnnotationValueEClass, JVM_SHORT_ANNOTATION_VALUE__VALUES);

		jvmLongAnnotationValueEClass = createEClass(JVM_LONG_ANNOTATION_VALUE);
		createEAttribute(jvmLongAnnotationValueEClass, JVM_LONG_ANNOTATION_VALUE__VALUES);

		jvmDoubleAnnotationValueEClass = createEClass(JVM_DOUBLE_ANNOTATION_VALUE);
		createEAttribute(jvmDoubleAnnotationValueEClass, JVM_DOUBLE_ANNOTATION_VALUE__VALUES);

		jvmFloatAnnotationValueEClass = createEClass(JVM_FLOAT_ANNOTATION_VALUE);
		createEAttribute(jvmFloatAnnotationValueEClass, JVM_FLOAT_ANNOTATION_VALUE__VALUES);

		jvmCharAnnotationValueEClass = createEClass(JVM_CHAR_ANNOTATION_VALUE);
		createEAttribute(jvmCharAnnotationValueEClass, JVM_CHAR_ANNOTATION_VALUE__VALUES);

		jvmStringAnnotationValueEClass = createEClass(JVM_STRING_ANNOTATION_VALUE);
		createEAttribute(jvmStringAnnotationValueEClass, JVM_STRING_ANNOTATION_VALUE__VALUES);

		jvmTypeAnnotationValueEClass = createEClass(JVM_TYPE_ANNOTATION_VALUE);
		createEReference(jvmTypeAnnotationValueEClass, JVM_TYPE_ANNOTATION_VALUE__VALUES);

		jvmAnnotationAnnotationValueEClass = createEClass(JVM_ANNOTATION_ANNOTATION_VALUE);
		createEReference(jvmAnnotationAnnotationValueEClass, JVM_ANNOTATION_ANNOTATION_VALUE__VALUES);

		jvmEnumAnnotationValueEClass = createEClass(JVM_ENUM_ANNOTATION_VALUE);
		createEReference(jvmEnumAnnotationValueEClass, JVM_ENUM_ANNOTATION_VALUE__VALUES);

		jvmDelegateTypeReferenceEClass = createEClass(JVM_DELEGATE_TYPE_REFERENCE);
		createEReference(jvmDelegateTypeReferenceEClass, JVM_DELEGATE_TYPE_REFERENCE__DELEGATE);

		jvmSpecializedTypeReferenceEClass = createEClass(JVM_SPECIALIZED_TYPE_REFERENCE);
		createEReference(jvmSpecializedTypeReferenceEClass, JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT);

		jvmSynonymTypeReferenceEClass = createEClass(JVM_SYNONYM_TYPE_REFERENCE);

		jvmUnknownTypeReferenceEClass = createEClass(JVM_UNKNOWN_TYPE_REFERENCE);
		createEAttribute(jvmUnknownTypeReferenceEClass, JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME);

		jvmCompoundTypeReferenceEClass = createEClass(JVM_COMPOUND_TYPE_REFERENCE);
		createEReference(jvmCompoundTypeReferenceEClass, JVM_COMPOUND_TYPE_REFERENCE__TYPE);
		createEReference(jvmCompoundTypeReferenceEClass, JVM_COMPOUND_TYPE_REFERENCE__REFERENCES);

		jvmCustomAnnotationValueEClass = createEClass(JVM_CUSTOM_ANNOTATION_VALUE);
		createEAttribute(jvmCustomAnnotationValueEClass, JVM_CUSTOM_ANNOTATION_VALUE__VALUES);

		// Create enums
		jvmVisibilityEEnum = createEEnum(JVM_VISIBILITY);

		// Create data types
		iterableEDataType = createEDataType(ITERABLE);
		listEDataType = createEDataType(LIST);
		iTypeReferenceVisitorEDataType = createEDataType(ITYPE_REFERENCE_VISITOR);
		iTypeReferenceVisitorWithParameterEDataType = createEDataType(ITYPE_REFERENCE_VISITOR_WITH_PARAMETER);
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
		XtypePackage theXtypePackage = (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);
		XamlPackage theXamlPackage = (XamlPackage)EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI);
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters
		addETypeParameter(iterableEDataType, "E");
		addETypeParameter(listEDataType, "E");
		addETypeParameter(iTypeReferenceVisitorEDataType, "Result");
		addETypeParameter(iTypeReferenceVisitorWithParameterEDataType, "Parameter");
		addETypeParameter(iTypeReferenceVisitorWithParameterEDataType, "Result");

		// Set bounds for type parameters

		// Add supertypes to classes
		jvmModuleEClass.getESuperTypes().add(this.getJvmType());
		jvmTypeEClass.getESuperTypes().add(this.getJvmIdentifiableElement());
		jvmDelegateTypeEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmDelegateTypeEClass.getESuperTypes().add(this.getJvmType());
		jvmVoidEClass.getESuperTypes().add(this.getJvmType());
		jvmComponentTypeEClass.getESuperTypes().add(this.getJvmType());
		jvmPrimitiveTypeEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmArrayTypeEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmDeclaredTypeEClass.getESuperTypes().add(this.getJvmMember());
		jvmDeclaredTypeEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmStructTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmStructTypeEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmTypeParameterEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmTypeParameterEClass.getESuperTypes().add(this.getJvmConstraintOwner());
		jvmUpperBoundEClass.getESuperTypes().add(this.getJvmTypeConstraint());
		jvmLowerBoundEClass.getESuperTypes().add(this.getJvmTypeConstraint());
		jvmAnnotationTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmEnumerationTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmEnumerationLiteralEClass.getESuperTypes().add(this.getJvmField());
		jvmGenericTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmGenericTypeEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmInterfaceTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmInterfaceTypeEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmRemoteTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmRemoteTypeEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmBeanTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmBeanTypeEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmParameterizedTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmGenericArrayTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmWildcardTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmWildcardTypeReferenceEClass.getESuperTypes().add(this.getJvmConstraintOwner());
		jvmAnyTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmMultiTypeReferenceEClass.getESuperTypes().add(this.getJvmCompoundTypeReference());
		jvmMemberEClass.getESuperTypes().add(this.getJvmAnnotationTarget());
		jvmFeatureEClass.getESuperTypes().add(this.getJvmMember());
		jvmFieldEClass.getESuperTypes().add(this.getJvmFeature());
		jvmIndexerEClass.getESuperTypes().add(this.getJvmField());
		jvmEventEClass.getESuperTypes().add(this.getJvmFeature());
		jvmExecutableEClass.getESuperTypes().add(this.getJvmFeature());
		jvmExecutableEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmConstructorEClass.getESuperTypes().add(this.getJvmExecutable());
		jvmOperationEClass.getESuperTypes().add(this.getJvmExecutable());
		jvmFormalParameterEClass.getESuperTypes().add(this.getJvmAnnotationTarget());
		jvmAnnotationTargetEClass.getESuperTypes().add(this.getJvmIdentifiableElement());
		jvmIntAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmBooleanAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmByteAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmShortAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmLongAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmDoubleAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmFloatAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmCharAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmStringAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmTypeAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmAnnotationAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmEnumAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmDelegateTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmSpecializedTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmSynonymTypeReferenceEClass.getESuperTypes().add(this.getJvmCompoundTypeReference());
		jvmUnknownTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmCompoundTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmCustomAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());

		// Initialize classes and features; add operations and parameters
		initEClass(jvmIdentifiableElementEClass, JvmIdentifiableElement.class, "JvmIdentifiableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getSimpleName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEChar(), "innerClassDelimiter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEBoolean(), "isExported", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmModuleEClass, JvmModule.class, "JvmModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmModule_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmModule_ImportSection(), theXtypePackage.getXImportSection(), null, "importSection", null, 0, 1, JvmModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmModule_Contents(), ecorePackage.getEObject(), null, "contents", null, 0, -1, JvmModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmModule_ExportSection(), theXtypePackage.getXExportSection(), null, "exportSection", null, 0, 1, JvmModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmModule_Root(), theXamlPackage.getXObjectElement(), null, "root", null, 0, 1, JvmModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmModule_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, JvmModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmModule_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, JvmModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeEClass, JvmType.class, "JvmType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmDelegateTypeEClass, JvmDelegateType.class, "JvmDelegateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmDelegateType_ReturnType(), this.getJvmTypeReference(), null, "returnType", null, 0, 1, JvmDelegateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmDelegateType_Parameters(), this.getJvmFormalParameter(), null, "parameters", null, 0, -1, JvmDelegateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDelegateType_VarArgs(), ecorePackage.getEBoolean(), "varArgs", null, 0, 1, JvmDelegateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDelegateType_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmDelegateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDelegateType_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, JvmDelegateType.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDelegateType_Exported(), ecorePackage.getEBoolean(), "exported", "false", 0, 1, JvmDelegateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmDelegateType_Annotations(), this.getJvmAnnotationReference(), null, "annotations", null, 0, -1, JvmDelegateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmVoidEClass, JvmVoid.class, "JvmVoid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmComponentTypeEClass, JvmComponentType.class, "JvmComponentType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmComponentType_ArrayType(), this.getJvmArrayType(), this.getJvmArrayType_ComponentType(), "arrayType", null, 0, 1, JvmComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmPrimitiveTypeEClass, JvmPrimitiveType.class, "JvmPrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmPrimitiveType_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmArrayTypeEClass, JvmArrayType.class, "JvmArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmArrayType_ComponentType(), this.getJvmComponentType(), this.getJvmComponentType_ArrayType(), "componentType", null, 0, 1, JvmArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmArrayTypeEClass, ecorePackage.getEInt(), "getDimensions", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmDeclaredTypeEClass, JvmDeclaredType.class, "JvmDeclaredType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmDeclaredType_SuperTypes(), this.getJvmTypeReference(), null, "superTypes", null, 0, -1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmDeclaredType_Members(), this.getJvmMember(), this.getJvmMember_DeclaringType(), "members", null, 0, -1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_Exported(), ecorePackage.getEBoolean(), "exported", "false", 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getDeclaredOperations", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getIterable());
		EGenericType g2 = createEGenericType(this.getJvmOperation());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getDeclaredFields", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmField());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "findAllFeaturesByName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "simpleName", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmFeature());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getAllFeatures", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmFeature());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(jvmStructTypeEClass, JvmStructType.class, "JvmStructType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmStructType_Implements(), this.getJvmParameterizedTypeReference(), null, "implements", null, 0, -1, JvmStructType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmStructType_Parameters(), this.getJvmFormalParameter(), null, "parameters", null, 0, -1, JvmStructType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeParameterEClass, JvmTypeParameter.class, "JvmTypeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmTypeParameter_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmTypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmTypeParameter_Declarator(), this.getJvmTypeParameterDeclarator(), this.getJvmTypeParameterDeclarator_TypeParameters(), "declarator", null, 0, 1, JvmTypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeParameterDeclaratorEClass, JvmTypeParameterDeclarator.class, "JvmTypeParameterDeclarator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmTypeParameterDeclarator_TypeParameters(), this.getJvmTypeParameter(), this.getJvmTypeParameter_Declarator(), "typeParameters", null, 0, -1, JvmTypeParameterDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmConstraintOwnerEClass, JvmConstraintOwner.class, "JvmConstraintOwner", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmConstraintOwner_Constraints(), this.getJvmTypeConstraint(), this.getJvmTypeConstraint_Owner(), "constraints", null, 0, -1, JvmConstraintOwner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeConstraintEClass, JvmTypeConstraint.class, "JvmTypeConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmTypeConstraint_TypeReference(), this.getJvmTypeReference(), null, "typeReference", null, 0, 1, JvmTypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmTypeConstraint_Owner(), this.getJvmConstraintOwner(), this.getJvmConstraintOwner_Constraints(), "owner", null, 0, 1, JvmTypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getSimpleName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEChar(), "innerClassDelimiter", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmUpperBoundEClass, JvmUpperBound.class, "JvmUpperBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmLowerBoundEClass, JvmLowerBound.class, "JvmLowerBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmAnnotationTypeEClass, JvmAnnotationType.class, "JvmAnnotationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmEnumerationTypeEClass, JvmEnumerationType.class, "JvmEnumerationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmEnumerationType_Literals(), this.getJvmEnumerationLiteral(), null, "literals", null, 0, -1, JvmEnumerationType.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(jvmEnumerationLiteralEClass, JvmEnumerationLiteral.class, "JvmEnumerationLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmEnumerationLiteral_Ordinal(), ecorePackage.getEInt(), "ordinal", "-1", 0, 1, JvmEnumerationLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmEnumerationLiteralEClass, this.getJvmEnumerationType(), "getEnumType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmGenericTypeEClass, JvmGenericType.class, "JvmGenericType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmGenericType_Extends(), this.getJvmParameterizedTypeReference(), null, "extends", null, 0, 1, JvmGenericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmGenericType_Implements(), this.getJvmParameterizedTypeReference(), null, "implements", null, 0, -1, JvmGenericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmGenericType_Root(), theXamlPackage.getXObjectElement(), null, "root", null, 0, 1, JvmGenericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(jvmGenericTypeEClass, null, "getExtendedInterfaces", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmTypeReference());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		addEOperation(jvmGenericTypeEClass, this.getJvmTypeReference(), "getExtendedClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmGenericTypeEClass, ecorePackage.getEBoolean(), "isInstantiateable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmGenericTypeEClass, null, "getDeclaredConstructors", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getList());
		g2 = createEGenericType(this.getJvmConstructor());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(jvmInterfaceTypeEClass, JvmInterfaceType.class, "JvmInterfaceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmInterfaceType_Implements(), this.getJvmParameterizedTypeReference(), null, "implements", null, 0, -1, JvmInterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmRemoteTypeEClass, JvmRemoteType.class, "JvmRemoteType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmRemoteType_Implements(), this.getJvmParameterizedTypeReference(), null, "implements", null, 0, -1, JvmRemoteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmBeanTypeEClass, JvmBeanType.class, "JvmBeanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmBeanType_Implements(), this.getJvmParameterizedTypeReference(), null, "implements", null, 0, -1, JvmBeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeReferenceEClass, JvmTypeReference.class, "JvmTypeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(jvmTypeReferenceEClass, this.getJvmType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getSimpleName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEChar(), "innerClassDelimiter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmTypeReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "Result");
		g1 = createEGenericType(this.getITypeReferenceVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = addEOperation(jvmTypeReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "Parameter");
		ETypeParameter t2 = addETypeParameter(op, "Result");
		g1 = createEGenericType(this.getITypeReferenceVisitorWithParameter());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "parameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(jvmParameterizedTypeReferenceEClass, JvmParameterizedTypeReference.class, "JvmParameterizedTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmParameterizedTypeReference_Arguments(), this.getJvmTypeReference(), null, "arguments", null, 0, -1, JvmParameterizedTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmParameterizedTypeReference_Type(), this.getJvmType(), null, "type", null, 0, 1, JvmParameterizedTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmGenericArrayTypeReferenceEClass, JvmGenericArrayTypeReference.class, "JvmGenericArrayTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmGenericArrayTypeReference_ComponentType(), this.getJvmTypeReference(), null, "componentType", null, 0, 1, JvmGenericArrayTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmGenericArrayTypeReferenceEClass, ecorePackage.getEInt(), "getDimensions", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmGenericArrayTypeReferenceEClass, this.getJvmArrayType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmWildcardTypeReferenceEClass, JvmWildcardTypeReference.class, "JvmWildcardTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmAnyTypeReferenceEClass, JvmAnyTypeReference.class, "JvmAnyTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnyTypeReference_Type(), this.getJvmType(), null, "type", null, 0, 1, JvmAnyTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmMultiTypeReferenceEClass, JvmMultiTypeReference.class, "JvmMultiTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmMemberEClass, JvmMember.class, "JvmMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmMember_DeclaringType(), this.getJvmDeclaredType(), this.getJvmDeclaredType_Members(), "declaringType", null, 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_Visibility(), this.getJvmVisibility(), "visibility", "PUBLIC", 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, JvmMember.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getJvmMember_AnnotationInfo(), this.getJvmAnnotationTarget(), null, "annotationInfo", null, 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_Modifiers(), ecorePackage.getEString(), "modifiers", null, 0, -1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(jvmMemberEClass, null, "internalSetIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "identifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmFeatureEClass, JvmFeature.class, "JvmFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(jvmFeatureEClass, ecorePackage.getEBoolean(), "isStatic", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmFieldEClass, JvmField.class, "JvmField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmField_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Transient(), ecorePackage.getEBoolean(), "transient", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Virtaul(), ecorePackage.getEBoolean(), "virtaul", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Override(), ecorePackage.getEBoolean(), "override", "false", 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Property(), ecorePackage.getEBoolean(), "property", "false", 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmField_Type(), this.getJvmTypeReference(), null, "type", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmField_DefaultValue(), theXbasePackage.getXExpression(), null, "defaultValue", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmField_Parameters(), this.getJvmFormalParameter(), null, "parameters", null, 0, -1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmField_Set(), theXbasePackage.getXStatment(), null, "set", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmField_Get(), theXbasePackage.getXStatment(), null, "get", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Indexer(), ecorePackage.getEBoolean(), "indexer", "false", 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmIndexerEClass, JvmIndexer.class, "JvmIndexer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmEventEClass, JvmEvent.class, "JvmEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmEvent_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, JvmEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmEvent_Native(), ecorePackage.getEBoolean(), "native", null, 0, 1, JvmEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmEvent_Type(), this.getJvmTypeReference(), null, "type", null, 0, 1, JvmEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmEvent_Add(), theXbasePackage.getXStatment(), null, "add", null, 0, 1, JvmEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmEvent_Remove(), theXbasePackage.getXStatment(), null, "remove", null, 0, 1, JvmEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmExecutableEClass, JvmExecutable.class, "JvmExecutable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmExecutable_Parameters(), this.getJvmFormalParameter(), null, "parameters", null, 0, -1, JvmExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmExecutable_Exceptions(), this.getJvmTypeReference(), null, "exceptions", null, 0, -1, JvmExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmExecutable_VarArgs(), ecorePackage.getEBoolean(), "varArgs", null, 0, 1, JvmExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmConstructorEClass, JvmConstructor.class, "JvmConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmConstructor_Body(), theXbasePackage.getXStatment(), null, "body", null, 0, 1, JvmConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmOperationEClass, JvmOperation.class, "JvmOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmOperation_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Virtaul(), ecorePackage.getEBoolean(), "virtaul", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Override(), ecorePackage.getEBoolean(), "override", "false", 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Native(), ecorePackage.getEBoolean(), "native", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Overload(), ecorePackage.getEBoolean(), "overload", "false", 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmOperation_ReturnType(), this.getJvmTypeReference(), null, "returnType", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmOperation_Body(), theXbasePackage.getXStatment(), null, "body", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Operator(), ecorePackage.getEBoolean(), "operator", "false", 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmFormalParameterEClass, JvmFormalParameter.class, "JvmFormalParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmFormalParameter_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmFormalParameter_ParameterType(), this.getJvmTypeReference(), null, "parameterType", null, 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmFormalParameter_VarArg(), ecorePackage.getEBoolean(), "varArg", null, 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmFormalParameter_DefaultValue(), theXbasePackage.getXExpression(), null, "defaultValue", null, 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmFormalParameter_Ref(), ecorePackage.getEBoolean(), "ref", "false", 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmFormalParameter_Out(), ecorePackage.getEBoolean(), "out", "false", 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmAnnotationTargetEClass, JvmAnnotationTarget.class, "JvmAnnotationTarget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationTarget_Annotations(), this.getJvmAnnotationReference(), null, "annotations", null, 0, -1, JvmAnnotationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmAnnotationReferenceEClass, JvmAnnotationReference.class, "JvmAnnotationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationReference_Annotation(), this.getJvmAnnotationType(), null, "annotation", null, 0, 1, JvmAnnotationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmAnnotationReference_Values(), this.getJvmAnnotationValue(), null, "values", null, 0, -1, JvmAnnotationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmAnnotationReference_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, JvmAnnotationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmAnnotationValueEClass, JvmAnnotationValue.class, "JvmAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationValue_Field(), this.getJvmField(), null, "field", null, 0, 1, JvmAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmAnnotationValue_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, JvmAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmAnnotationValueEClass, ecorePackage.getEString(), "getValueName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmIntAnnotationValueEClass, JvmIntAnnotationValue.class, "JvmIntAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmIntAnnotationValue_Values(), ecorePackage.getEInt(), "values", null, 0, -1, JvmIntAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmBooleanAnnotationValueEClass, JvmBooleanAnnotationValue.class, "JvmBooleanAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmBooleanAnnotationValue_Values(), ecorePackage.getEBoolean(), "values", null, 0, -1, JvmBooleanAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmByteAnnotationValueEClass, JvmByteAnnotationValue.class, "JvmByteAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmByteAnnotationValue_Values(), ecorePackage.getEByte(), "values", null, 0, -1, JvmByteAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmShortAnnotationValueEClass, JvmShortAnnotationValue.class, "JvmShortAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmShortAnnotationValue_Values(), ecorePackage.getEShort(), "values", null, 0, -1, JvmShortAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmLongAnnotationValueEClass, JvmLongAnnotationValue.class, "JvmLongAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmLongAnnotationValue_Values(), ecorePackage.getELong(), "values", null, 0, -1, JvmLongAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmDoubleAnnotationValueEClass, JvmDoubleAnnotationValue.class, "JvmDoubleAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmDoubleAnnotationValue_Values(), ecorePackage.getEDouble(), "values", null, 0, -1, JvmDoubleAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmFloatAnnotationValueEClass, JvmFloatAnnotationValue.class, "JvmFloatAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmFloatAnnotationValue_Values(), ecorePackage.getEFloat(), "values", null, 0, -1, JvmFloatAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmCharAnnotationValueEClass, JvmCharAnnotationValue.class, "JvmCharAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmCharAnnotationValue_Values(), ecorePackage.getEChar(), "values", null, 0, -1, JvmCharAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmStringAnnotationValueEClass, JvmStringAnnotationValue.class, "JvmStringAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmStringAnnotationValue_Values(), ecorePackage.getEString(), "values", null, 0, -1, JvmStringAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeAnnotationValueEClass, JvmTypeAnnotationValue.class, "JvmTypeAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmTypeAnnotationValue_Values(), this.getJvmTypeReference(), null, "values", null, 0, -1, JvmTypeAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmAnnotationAnnotationValueEClass, JvmAnnotationAnnotationValue.class, "JvmAnnotationAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationAnnotationValue_Values(), this.getJvmAnnotationReference(), null, "values", null, 0, -1, JvmAnnotationAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmEnumAnnotationValueEClass, JvmEnumAnnotationValue.class, "JvmEnumAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmEnumAnnotationValue_Values(), this.getJvmEnumerationLiteral(), null, "values", null, 0, -1, JvmEnumAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmDelegateTypeReferenceEClass, JvmDelegateTypeReference.class, "JvmDelegateTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmDelegateTypeReference_Delegate(), this.getJvmTypeReference(), null, "delegate", null, 0, 1, JvmDelegateTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmSpecializedTypeReferenceEClass, JvmSpecializedTypeReference.class, "JvmSpecializedTypeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmSpecializedTypeReference_Equivalent(), this.getJvmTypeReference(), null, "equivalent", null, 0, 1, JvmSpecializedTypeReference.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmSynonymTypeReferenceEClass, JvmSynonymTypeReference.class, "JvmSynonymTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmUnknownTypeReferenceEClass, JvmUnknownTypeReference.class, "JvmUnknownTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmUnknownTypeReference_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, JvmUnknownTypeReference.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmCompoundTypeReferenceEClass, JvmCompoundTypeReference.class, "JvmCompoundTypeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmCompoundTypeReference_Type(), this.getJvmType(), null, "type", null, 0, 1, JvmCompoundTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmCompoundTypeReference_References(), this.getJvmTypeReference(), null, "references", null, 0, -1, JvmCompoundTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmCustomAnnotationValueEClass, JvmCustomAnnotationValue.class, "JvmCustomAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmCustomAnnotationValue_Values(), ecorePackage.getEJavaObject(), "values", null, 0, -1, JvmCustomAnnotationValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(jvmVisibilityEEnum, JvmVisibility.class, "JvmVisibility");
		addEEnumLiteral(jvmVisibilityEEnum, JvmVisibility.PRIVATE);
		addEEnumLiteral(jvmVisibilityEEnum, JvmVisibility.PUBLIC);

		// Initialize data types
		initEDataType(iterableEDataType, Iterable.class, "Iterable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iTypeReferenceVisitorEDataType, ITypeReferenceVisitor.class, "ITypeReferenceVisitor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iTypeReferenceVisitorWithParameterEDataType, ITypeReferenceVisitorWithParameter.class, "ITypeReferenceVisitorWithParameter", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TypesPackageImpl
