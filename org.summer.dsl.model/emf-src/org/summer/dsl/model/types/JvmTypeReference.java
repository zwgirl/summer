/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.util.ITypeReferenceVisitor;
import org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmTypeReference()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeReference extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmType getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The identifier of a JvmTypeReference is a canonical representation of the referenced type 
	 * including its type arguments.</p>
	 * <p>The types fully qualified name is used ('$' is the delimiter for inner types).</p>
	 * <p>Examples for reference identifiers are:</p>
	 * <ul>
	 * <li>java.lang.String for a reference to an object type</li>
	 * <li>java.util.Map$Entry<java.lang.Object,java.lang.Integer> for a parameterized type</li>
	 * <li>java.util.List<? extends java.lang.String>[] for a generic array type</li>
	 * </ul>
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getQualifiedName(char innerClassDelimiter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="org.summer.dsl.model.types.ITypeReferenceVisitor<Result>"
	 * @generated
	 */
	<Result> Result accept(ITypeReferenceVisitor<Result> visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="org.summer.dsl.model.types.ITypeReferenceVisitorWithParameter<Parameter, Result>"
	 * @generated
	 */
	<Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter, Result> visitor, Parameter parameter);

} // JvmTypeReference
