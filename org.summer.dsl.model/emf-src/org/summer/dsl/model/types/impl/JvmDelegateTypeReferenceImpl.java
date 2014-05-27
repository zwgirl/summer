/**
 */
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Delegate Type Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDelegateTypeReferenceImpl#getDelegate <em>Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class JvmDelegateTypeReferenceImpl extends JvmTypeReferenceImplCustom implements JvmDelegateTypeReference {
	/**
	 * The cached value of the '{@link #getDelegate() <em>Delegate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegate()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference delegate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmDelegateTypeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_DELEGATE_TYPE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getDelegate() {
		if (delegate != null && delegate.eIsProxy()) {
			InternalEObject oldDelegate = (InternalEObject)delegate;
			delegate = (JvmTypeReference)eResolveProxy(oldDelegate);
			if (delegate != oldDelegate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.JVM_DELEGATE_TYPE_REFERENCE__DELEGATE, oldDelegate, delegate));
			}
		}
		return delegate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference basicGetDelegate() {
		return delegate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegate(JvmTypeReference newDelegate) {
		JvmTypeReference oldDelegate = delegate;
		delegate = newDelegate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_DELEGATE_TYPE_REFERENCE__DELEGATE, oldDelegate, delegate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.JVM_DELEGATE_TYPE_REFERENCE__DELEGATE:
				if (resolve) return getDelegate();
				return basicGetDelegate();
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
			case TypesPackage.JVM_DELEGATE_TYPE_REFERENCE__DELEGATE:
				setDelegate((JvmTypeReference)newValue);
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
			case TypesPackage.JVM_DELEGATE_TYPE_REFERENCE__DELEGATE:
				setDelegate((JvmTypeReference)null);
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
			case TypesPackage.JVM_DELEGATE_TYPE_REFERENCE__DELEGATE:
				return delegate != null;
		}
		return super.eIsSet(featureID);
	}

} //JvmDelegateTypeReferenceImpl
