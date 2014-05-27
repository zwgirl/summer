/**
 */
package org.summer.dsl.model.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmStructType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Struct Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmStructTypeImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmStructTypeImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmStructTypeImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class JvmStructTypeImpl extends JvmDeclaredTypeImplCustom implements JvmStructType {
	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeParameter> typeParameters;
	/**
	 * The cached value of the '{@link #getImplements() <em>Implements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplements()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmParameterizedTypeReference> implements_;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmFormalParameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmStructTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_STRUCT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeParameter> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentWithInverseEList<JvmTypeParameter>(JvmTypeParameter.class, this, TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS, TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmParameterizedTypeReference> getImplements() {
		if (implements_ == null) {
			implements_ = new EObjectContainmentEList<JvmParameterizedTypeReference>(JvmParameterizedTypeReference.class, this, TypesPackage.JVM_STRUCT_TYPE__IMPLEMENTS);
		}
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmFormalParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<JvmFormalParameter>(JvmFormalParameter.class, this, TypesPackage.JVM_STRUCT_TYPE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypeParameters()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
			case TypesPackage.JVM_STRUCT_TYPE__IMPLEMENTS:
				return ((InternalEList<?>)getImplements()).basicRemove(otherEnd, msgs);
			case TypesPackage.JVM_STRUCT_TYPE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS:
				return getTypeParameters();
			case TypesPackage.JVM_STRUCT_TYPE__IMPLEMENTS:
				return getImplements();
			case TypesPackage.JVM_STRUCT_TYPE__PARAMETERS:
				return getParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
				return;
			case TypesPackage.JVM_STRUCT_TYPE__IMPLEMENTS:
				getImplements().clear();
				getImplements().addAll((Collection<? extends JvmParameterizedTypeReference>)newValue);
				return;
			case TypesPackage.JVM_STRUCT_TYPE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends JvmFormalParameter>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case TypesPackage.JVM_STRUCT_TYPE__IMPLEMENTS:
				getImplements().clear();
				return;
			case TypesPackage.JVM_STRUCT_TYPE__PARAMETERS:
				getParameters().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case TypesPackage.JVM_STRUCT_TYPE__IMPLEMENTS:
				return implements_ != null && !implements_.isEmpty();
			case TypesPackage.JVM_STRUCT_TYPE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JvmTypeParameterDeclarator.class) {
			switch (derivedFeatureID) {
				case TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS: return TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JvmTypeParameterDeclarator.class) {
			switch (baseFeatureID) {
				case TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS: return TypesPackage.JVM_STRUCT_TYPE__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //JvmStructTypeImpl
