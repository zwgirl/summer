/**
 */
package org.summer.dsl.model.xtype.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.types.impl.JvmSpecializedTypeReferenceImplCustom;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.model.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XComputed Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImpl#getTypeProvider <em>Type Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class XComputedTypeReferenceImpl extends JvmSpecializedTypeReferenceImplCustom implements XComputedTypeReference {
	/**
	 * The default value of the '{@link #getTypeProvider() <em>Type Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeProvider()
	 * @generated
	 * @ordered
	 */
	protected static final org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider TYPE_PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeProvider() <em>Type Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeProvider()
	 * @generated
	 * @ordered
	 */
	protected org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider typeProvider = TYPE_PROVIDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XComputedTypeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtypePackage.Literals.XCOMPUTED_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider getTypeProvider() {
		return typeProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeProvider(org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider newTypeProvider) {
		org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider oldTypeProvider = typeProvider;
		typeProvider = newTypeProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtypePackage.XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER, oldTypeProvider, typeProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XtypePackage.XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER:
				return getTypeProvider();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XtypePackage.XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER:
				setTypeProvider((org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider)newValue);
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
			case XtypePackage.XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER:
				setTypeProvider(TYPE_PROVIDER_EDEFAULT);
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
			case XtypePackage.XCOMPUTED_TYPE_REFERENCE__TYPE_PROVIDER:
				return TYPE_PROVIDER_EDEFAULT == null ? typeProvider != null : !TYPE_PROVIDER_EDEFAULT.equals(typeProvider);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (typeProvider: ");
		result.append(typeProvider);
		result.append(')');
		return result.toString();
	}

} //XComputedTypeReferenceImpl
