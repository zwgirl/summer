/**
 */
package org.summer.dsl.model.types.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.JvmComponentType;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Declared Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl#getArrayType <em>Array Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmDeclaredTypeImpl#isExported <em>Exported</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class JvmDeclaredTypeImpl extends JvmMemberImplCustom implements JvmDeclaredType {
	/**
	 * The cached value of the '{@link #getArrayType() <em>Array Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayType()
	 * @generated
	 * @ordered
	 */
	protected JvmArrayType arrayType;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> superTypes;

	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmMember> members;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected boolean final_ = FINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isExported() <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExported() <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected boolean exported = EXPORTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmDeclaredTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_DECLARED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmArrayType getArrayType() {
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArrayType(JvmArrayType newArrayType, NotificationChain msgs) {
		JvmArrayType oldArrayType = arrayType;
		arrayType = newArrayType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE, oldArrayType, newArrayType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayType(JvmArrayType newArrayType) {
		if (newArrayType != arrayType) {
			NotificationChain msgs = null;
			if (arrayType != null)
				msgs = ((InternalEObject)arrayType).eInverseRemove(this, TypesPackage.JVM_ARRAY_TYPE__COMPONENT_TYPE, JvmArrayType.class, msgs);
			if (newArrayType != null)
				msgs = ((InternalEObject)newArrayType).eInverseAdd(this, TypesPackage.JVM_ARRAY_TYPE__COMPONENT_TYPE, JvmArrayType.class, msgs);
			msgs = basicSetArrayType(newArrayType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE, newArrayType, newArrayType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<JvmTypeReference> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmMember> getMembers() {
		if (members == null) {
			members = new EObjectContainmentWithInverseEList<JvmMember>(JvmMember.class, this, TypesPackage.JVM_DECLARED_TYPE__MEMBERS, TypesPackage.JVM_MEMBER__DECLARING_TYPE);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_DECLARED_TYPE__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFinal() {
		return final_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinal(boolean newFinal) {
		boolean oldFinal = final_;
		final_ = newFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_DECLARED_TYPE__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_DECLARED_TYPE__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExported() {
		return exported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExported(boolean newExported) {
		boolean oldExported = exported;
		exported = newExported;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_DECLARED_TYPE__EXPORTED, oldExported, exported));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<JvmOperation> getDeclaredOperations() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<JvmField> getDeclaredFields() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<JvmFeature> findAllFeaturesByName(String simpleName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<JvmFeature> getAllFeatures() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE:
				if (arrayType != null)
					msgs = ((InternalEObject)arrayType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE, null, msgs);
				return basicSetArrayType((JvmArrayType)otherEnd, msgs);
			case TypesPackage.JVM_DECLARED_TYPE__MEMBERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembers()).basicAdd(otherEnd, msgs);
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
			case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE:
				return basicSetArrayType(null, msgs);
			case TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case TypesPackage.JVM_DECLARED_TYPE__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE:
				return getArrayType();
			case TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES:
				return getSuperTypes();
			case TypesPackage.JVM_DECLARED_TYPE__MEMBERS:
				return getMembers();
			case TypesPackage.JVM_DECLARED_TYPE__ABSTRACT:
				return isAbstract();
			case TypesPackage.JVM_DECLARED_TYPE__FINAL:
				return isFinal();
			case TypesPackage.JVM_DECLARED_TYPE__PACKAGE_NAME:
				return getPackageName();
			case TypesPackage.JVM_DECLARED_TYPE__EXPORTED:
				return isExported();
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
			case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE:
				setArrayType((JvmArrayType)newValue);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends JvmMember>)newValue);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__FINAL:
				setFinal((Boolean)newValue);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__EXPORTED:
				setExported((Boolean)newValue);
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
			case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE:
				setArrayType((JvmArrayType)null);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				return;
			case TypesPackage.JVM_DECLARED_TYPE__MEMBERS:
				getMembers().clear();
				return;
			case TypesPackage.JVM_DECLARED_TYPE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case TypesPackage.JVM_DECLARED_TYPE__EXPORTED:
				setExported(EXPORTED_EDEFAULT);
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
			case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE:
				return arrayType != null;
			case TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
			case TypesPackage.JVM_DECLARED_TYPE__MEMBERS:
				return members != null && !members.isEmpty();
			case TypesPackage.JVM_DECLARED_TYPE__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case TypesPackage.JVM_DECLARED_TYPE__FINAL:
				return final_ != FINAL_EDEFAULT;
			case TypesPackage.JVM_DECLARED_TYPE__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case TypesPackage.JVM_DECLARED_TYPE__EXPORTED:
				return exported != EXPORTED_EDEFAULT;
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
		if (baseClass == JvmType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == JvmComponentType.class) {
			switch (derivedFeatureID) {
				case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE: return TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE;
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
		if (baseClass == JvmType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == JvmComponentType.class) {
			switch (baseFeatureID) {
				case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE: return TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	private boolean flag = false;
	public void setPrimitive(boolean flag) {
		this.flag = flag;
	}
	
	public boolean isPrimitive() {
		return this.flag;
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(", final: ");
		result.append(final_);
		result.append(", packageName: ");
		result.append(packageName);
		result.append(", exported: ");
		result.append(exported);
		result.append(')');
		return result.toString();
	}

} //JvmDeclaredTypeImpl
