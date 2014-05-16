/**
 */
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.summer.dsl.model.types.JvmAnnotationAnnotationValue;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.JvmBooleanAnnotationValue;
import org.summer.dsl.model.types.JvmByteAnnotationValue;
import org.summer.dsl.model.types.JvmCharAnnotationValue;
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
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFloatAnnotationValue;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
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
import org.summer.dsl.model.types.JvmShortAnnotationValue;
import org.summer.dsl.model.types.JvmStringAnnotationValue;
import org.summer.dsl.model.types.JvmStructType;
import org.summer.dsl.model.types.JvmSynonymTypeReference;
import org.summer.dsl.model.types.JvmTypeAnnotationValue;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypesFactory init() {
		try {
			TypesFactory theTypesFactory = (TypesFactory)EPackage.Registry.INSTANCE.getEFactory(TypesPackage.eNS_URI);
			if (theTypesFactory != null) {
				return theTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TypesPackage.JVM_VOID: return createJvmVoid();
			case TypesPackage.JVM_MODULE: return createJvmModule();
			case TypesPackage.JVM_DECLARED_TYPE: return createJvmDeclaredType();
			case TypesPackage.JVM_ARRAY_TYPE: return createJvmArrayType();
			case TypesPackage.JVM_TYPE_PARAMETER: return createJvmTypeParameter();
			case TypesPackage.JVM_MEMBER: return createJvmMember();
			case TypesPackage.JVM_UPPER_BOUND: return createJvmUpperBound();
			case TypesPackage.JVM_LOWER_BOUND: return createJvmLowerBound();
			case TypesPackage.JVM_ANNOTATION_TYPE: return createJvmAnnotationType();
			case TypesPackage.JVM_ENUMERATION_TYPE: return createJvmEnumerationType();
			case TypesPackage.JVM_ENUMERATION_LITERAL: return createJvmEnumerationLiteral();
			case TypesPackage.JVM_GENERIC_TYPE: return createJvmGenericType();
			case TypesPackage.JVM_INTERFACE_TYPE: return createJvmInterfaceType();
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE: return createJvmParameterizedTypeReference();
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE: return createJvmGenericArrayTypeReference();
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE: return createJvmWildcardTypeReference();
			case TypesPackage.JVM_ANY_TYPE_REFERENCE: return createJvmAnyTypeReference();
			case TypesPackage.JVM_MULTI_TYPE_REFERENCE: return createJvmMultiTypeReference();
			case TypesPackage.JVM_FIELD: return createJvmField();
			case TypesPackage.JVM_CONSTRUCTOR: return createJvmConstructor();
			case TypesPackage.JVM_OPERATION: return createJvmOperation();
			case TypesPackage.JVM_FORMAL_PARAMETER: return createJvmFormalParameter();
			case TypesPackage.JVM_ANNOTATION_REFERENCE: return createJvmAnnotationReference();
			case TypesPackage.JVM_ANNOTATION_VALUE: return createJvmAnnotationValue();
			case TypesPackage.JVM_INT_ANNOTATION_VALUE: return createJvmIntAnnotationValue();
			case TypesPackage.JVM_BOOLEAN_ANNOTATION_VALUE: return createJvmBooleanAnnotationValue();
			case TypesPackage.JVM_BYTE_ANNOTATION_VALUE: return createJvmByteAnnotationValue();
			case TypesPackage.JVM_SHORT_ANNOTATION_VALUE: return createJvmShortAnnotationValue();
			case TypesPackage.JVM_LONG_ANNOTATION_VALUE: return createJvmLongAnnotationValue();
			case TypesPackage.JVM_DOUBLE_ANNOTATION_VALUE: return createJvmDoubleAnnotationValue();
			case TypesPackage.JVM_FLOAT_ANNOTATION_VALUE: return createJvmFloatAnnotationValue();
			case TypesPackage.JVM_CHAR_ANNOTATION_VALUE: return createJvmCharAnnotationValue();
			case TypesPackage.JVM_STRING_ANNOTATION_VALUE: return createJvmStringAnnotationValue();
			case TypesPackage.JVM_TYPE_ANNOTATION_VALUE: return createJvmTypeAnnotationValue();
			case TypesPackage.JVM_ANNOTATION_ANNOTATION_VALUE: return createJvmAnnotationAnnotationValue();
			case TypesPackage.JVM_ENUM_ANNOTATION_VALUE: return createJvmEnumAnnotationValue();
			case TypesPackage.JVM_DELEGATE_TYPE_REFERENCE: return createJvmDelegateTypeReference();
			case TypesPackage.JVM_SYNONYM_TYPE_REFERENCE: return createJvmSynonymTypeReference();
			case TypesPackage.JVM_UNKNOWN_TYPE_REFERENCE: return createJvmUnknownTypeReference();
			case TypesPackage.JVM_CUSTOM_ANNOTATION_VALUE: return createJvmCustomAnnotationValue();
			case TypesPackage.JVM_STRUCT_TYPE: return createJvmStructType();
			case TypesPackage.JVM_DELEGATE_TYPE: return createJvmDelegateType();
			case TypesPackage.JVM_EVENT: return createJvmEvent();

			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case TypesPackage.JVM_VISIBILITY:
				return createJvmVisibilityFromString(eDataType, initialValue);
			case TypesPackage.ITERABLE:
				return createIterableFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case TypesPackage.JVM_VISIBILITY:
				return convertJvmVisibilityToString(eDataType, instanceValue);
			case TypesPackage.ITERABLE:
				return convertIterableToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmVoid createJvmVoid()
	{
		JvmVoidImplCustom jvmVoid = new JvmVoidImplCustom();
		return jvmVoid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmPrimitiveType createJvmPrimitiveType()
	{
		JvmPrimitiveTypeImplCustom jvmPrimitiveType = new JvmPrimitiveTypeImplCustom();
		return jvmPrimitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmArrayType createJvmArrayType()
	{
		JvmArrayTypeImplCustom jvmArrayType = new JvmArrayTypeImplCustom();
		return jvmArrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeParameter createJvmTypeParameter()
	{
		JvmTypeParameterImplCustom jvmTypeParameter = new JvmTypeParameterImplCustom();
		return jvmTypeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmUpperBound createJvmUpperBound()
	{
		JvmUpperBoundImplCustom jvmUpperBound = new JvmUpperBoundImplCustom();
		return jvmUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmLowerBound createJvmLowerBound()
	{
		JvmLowerBoundImplCustom jvmLowerBound = new JvmLowerBoundImplCustom();
		return jvmLowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationType createJvmAnnotationType()
	{
		JvmAnnotationTypeImpl jvmAnnotationType = new JvmAnnotationTypeImpl();
		return jvmAnnotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmEnumerationType createJvmEnumerationType()
	{
		JvmEnumerationTypeImplCustom jvmEnumerationType = new JvmEnumerationTypeImplCustom();
		return jvmEnumerationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmEnumerationLiteral createJvmEnumerationLiteral()
	{
		JvmEnumerationLiteralImplCustom jvmEnumerationLiteral = new JvmEnumerationLiteralImplCustom();
		return jvmEnumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmGenericType createJvmGenericType()
	{
		JvmGenericTypeImplCustom jvmGenericType = new JvmGenericTypeImplCustom();
		return jvmGenericType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmParameterizedTypeReference createJvmParameterizedTypeReference()
	{
		JvmParameterizedTypeReferenceImplCustom jvmParameterizedTypeReference = new JvmParameterizedTypeReferenceImplCustom();
		return jvmParameterizedTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmGenericArrayTypeReference createJvmGenericArrayTypeReference()
	{
		JvmGenericArrayTypeReferenceImplCustom jvmGenericArrayTypeReference = new JvmGenericArrayTypeReferenceImplCustom();
		return jvmGenericArrayTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmWildcardTypeReference createJvmWildcardTypeReference()
	{
		JvmWildcardTypeReferenceImplCustom jvmWildcardTypeReference = new JvmWildcardTypeReferenceImplCustom();
		return jvmWildcardTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnyTypeReference createJvmAnyTypeReference()
	{
		JvmAnyTypeReferenceImplCustom jvmAnyTypeReference = new JvmAnyTypeReferenceImplCustom();
		return jvmAnyTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmMultiTypeReference createJvmMultiTypeReference()
	{
		JvmMultiTypeReferenceImplCustom jvmMultiTypeReference = new JvmMultiTypeReferenceImplCustom();
		return jvmMultiTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmField createJvmField()
	{
		JvmFieldImpl jvmField = new JvmFieldImpl();
		return jvmField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmConstructor createJvmConstructor()
	{
		JvmConstructorImplCustom jvmConstructor = new JvmConstructorImplCustom();
		return jvmConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmOperation createJvmOperation()
	{
		JvmOperationImpl jvmOperation = new JvmOperationImpl();
		return jvmOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmFormalParameter createJvmFormalParameter()
	{
		JvmFormalParameterImplCustom jvmFormalParameter = new JvmFormalParameterImplCustom();
		return jvmFormalParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationReference createJvmAnnotationReference()
	{
		JvmAnnotationReferenceImpl jvmAnnotationReference = new JvmAnnotationReferenceImpl();
		return jvmAnnotationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmIntAnnotationValue createJvmIntAnnotationValue()
	{
		JvmIntAnnotationValueImpl jvmIntAnnotationValue = new JvmIntAnnotationValueImpl();
		return jvmIntAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmBooleanAnnotationValue createJvmBooleanAnnotationValue()
	{
		JvmBooleanAnnotationValueImpl jvmBooleanAnnotationValue = new JvmBooleanAnnotationValueImpl();
		return jvmBooleanAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmByteAnnotationValue createJvmByteAnnotationValue()
	{
		JvmByteAnnotationValueImpl jvmByteAnnotationValue = new JvmByteAnnotationValueImpl();
		return jvmByteAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmShortAnnotationValue createJvmShortAnnotationValue()
	{
		JvmShortAnnotationValueImpl jvmShortAnnotationValue = new JvmShortAnnotationValueImpl();
		return jvmShortAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmLongAnnotationValue createJvmLongAnnotationValue()
	{
		JvmLongAnnotationValueImpl jvmLongAnnotationValue = new JvmLongAnnotationValueImpl();
		return jvmLongAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmDoubleAnnotationValue createJvmDoubleAnnotationValue()
	{
		JvmDoubleAnnotationValueImpl jvmDoubleAnnotationValue = new JvmDoubleAnnotationValueImpl();
		return jvmDoubleAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmFloatAnnotationValue createJvmFloatAnnotationValue()
	{
		JvmFloatAnnotationValueImpl jvmFloatAnnotationValue = new JvmFloatAnnotationValueImpl();
		return jvmFloatAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmCharAnnotationValue createJvmCharAnnotationValue()
	{
		JvmCharAnnotationValueImpl jvmCharAnnotationValue = new JvmCharAnnotationValueImpl();
		return jvmCharAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmStringAnnotationValue createJvmStringAnnotationValue()
	{
		JvmStringAnnotationValueImpl jvmStringAnnotationValue = new JvmStringAnnotationValueImpl();
		return jvmStringAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeAnnotationValue createJvmTypeAnnotationValue()
	{
		JvmTypeAnnotationValueImpl jvmTypeAnnotationValue = new JvmTypeAnnotationValueImpl();
		return jvmTypeAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationAnnotationValue createJvmAnnotationAnnotationValue()
	{
		JvmAnnotationAnnotationValueImplCustom jvmAnnotationAnnotationValue = new JvmAnnotationAnnotationValueImplCustom();
		return jvmAnnotationAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmEnumAnnotationValue createJvmEnumAnnotationValue()
	{
		JvmEnumAnnotationValueImpl jvmEnumAnnotationValue = new JvmEnumAnnotationValueImpl();
		return jvmEnumAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmDelegateTypeReference createJvmDelegateTypeReference()
	{
		JvmDelegateTypeReferenceImplCustom jvmDelegateTypeReference = new JvmDelegateTypeReferenceImplCustom();
		return jvmDelegateTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmSynonymTypeReference createJvmSynonymTypeReference()
	{
		JvmSynonymTypeReferenceImplCustom jvmSynonymTypeReference = new JvmSynonymTypeReferenceImplCustom();
		return jvmSynonymTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmUnknownTypeReference createJvmUnknownTypeReference()
	{
		JvmUnknownTypeReferenceImplCustom jvmUnknownTypeReference = new JvmUnknownTypeReferenceImplCustom();
		return jvmUnknownTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmCustomAnnotationValue createJvmCustomAnnotationValue()
	{
		JvmCustomAnnotationValueImpl jvmCustomAnnotationValue = new JvmCustomAnnotationValueImpl();
		return jvmCustomAnnotationValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmVisibility createJvmVisibilityFromString(EDataType eDataType, String initialValue)
	{
		JvmVisibility result = JvmVisibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJvmVisibilityToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<?> createIterableFromString(EDataType eDataType, String initialValue)
	{
		return (Iterable<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIterableToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesPackage getTypesPackage() {
		return (TypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TypesPackage getPackage() {
		return TypesPackage.eINSTANCE;
	}

	public JvmDeclaredType createJvmDeclaredType() {
		return new JvmDeclaredTypeImplCustom(); 
	}

	public JvmMember createJvmMember() {
		return new JvmMemberImplCustom();
	}

	public JvmModule createJvmModule() {
		return new JvmModuleImpl();
	}

	public JvmAnnotationValue createJvmAnnotationValue() {
		return new JvmAnnotationValueImplCustom();
	}

	@Override
	public JvmStructType createJvmStructType() {
		return new JvmStructTypeImpl();
	}

	@Override
	public JvmDelegateType createJvmDelegateType() {
		return new JvmDelegateTypeImpl();
	}

	@Override
	public JvmEvent createJvmEvent() {
		return new JvmEventImpl();
	}

	@Override
	public JvmInterfaceType createJvmInterfaceType() {
		return new JvmInterfaceTypeImpl();
	}

} //TypesFactoryImpl
