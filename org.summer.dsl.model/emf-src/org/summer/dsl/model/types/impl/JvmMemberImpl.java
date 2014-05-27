/**
 */
package org.summer.dsl.model.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmMemberImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmMemberImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmMemberImpl#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmMemberImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmMemberImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmMemberImpl#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class JvmMemberImpl extends JvmAnnotationTargetImplCustom implements JvmMember {
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final JvmVisibility VISIBILITY_EDEFAULT = JvmVisibility.PUBLIC;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected JvmVisibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected String simpleName = SIMPLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnnotationInfo() <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationInfo()
	 * @generated
	 * @ordered
	 */
	protected JvmAnnotationTarget annotationInfo;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> modifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmDeclaredType getDeclaringType() {
		if (eContainerFeatureID() != TypesPackage.JVM_MEMBER__DECLARING_TYPE) return null;
		return (JvmDeclaredType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringType(JvmDeclaredType newDeclaringType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclaringType, TypesPackage.JVM_MEMBER__DECLARING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringType(JvmDeclaredType newDeclaringType) {
		if (newDeclaringType != eInternalContainer() || (eContainerFeatureID() != TypesPackage.JVM_MEMBER__DECLARING_TYPE && newDeclaringType != null)) {
			if (EcoreUtil.isAncestor(this, newDeclaringType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaringType != null)
				msgs = ((InternalEObject)newDeclaringType).eInverseAdd(this, TypesPackage.JVM_DECLARED_TYPE__MEMBERS, JvmDeclaredType.class, msgs);
			msgs = basicSetDeclaringType(newDeclaringType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MEMBER__DECLARING_TYPE, newDeclaringType, newDeclaringType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmVisibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(JvmVisibility newVisibility) {
		JvmVisibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MEMBER__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleName(String newSimpleName) {
		String oldSimpleName = simpleName;
		simpleName = newSimpleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MEMBER__SIMPLE_NAME, oldSimpleName, simpleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationTarget getAnnotationInfo() {
		return annotationInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotationInfo(JvmAnnotationTarget newAnnotationInfo, NotificationChain msgs) {
		JvmAnnotationTarget oldAnnotationInfo = annotationInfo;
		annotationInfo = newAnnotationInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MEMBER__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotationInfo(JvmAnnotationTarget newAnnotationInfo) {
		if (newAnnotationInfo != annotationInfo) {
			NotificationChain msgs = null;
			if (annotationInfo != null)
				msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MEMBER__ANNOTATION_INFO, null, msgs);
			if (newAnnotationInfo != null)
				msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MEMBER__ANNOTATION_INFO, null, msgs);
			msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MEMBER__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiers() {
		if (modifiers == null) {
			modifiers = new EDataTypeEList<String>(String.class, this, TypesPackage.JVM_MEMBER__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void internalSetIdentifier(String identifier) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_MEMBER__DECLARING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringType((JvmDeclaredType)otherEnd, msgs);
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
			case TypesPackage.JVM_MEMBER__DECLARING_TYPE:
				return basicSetDeclaringType(null, msgs);
			case TypesPackage.JVM_MEMBER__ANNOTATION_INFO:
				return basicSetAnnotationInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TypesPackage.JVM_MEMBER__DECLARING_TYPE:
				return eInternalContainer().eInverseRemove(this, TypesPackage.JVM_DECLARED_TYPE__MEMBERS, JvmDeclaredType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.JVM_MEMBER__DECLARING_TYPE:
				return getDeclaringType();
			case TypesPackage.JVM_MEMBER__VISIBILITY:
				return getVisibility();
			case TypesPackage.JVM_MEMBER__SIMPLE_NAME:
				return getSimpleName();
			case TypesPackage.JVM_MEMBER__IDENTIFIER:
				return getIdentifier();
			case TypesPackage.JVM_MEMBER__ANNOTATION_INFO:
				return getAnnotationInfo();
			case TypesPackage.JVM_MEMBER__MODIFIERS:
				return getModifiers();
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
			case TypesPackage.JVM_MEMBER__DECLARING_TYPE:
				setDeclaringType((JvmDeclaredType)newValue);
				return;
			case TypesPackage.JVM_MEMBER__VISIBILITY:
				setVisibility((JvmVisibility)newValue);
				return;
			case TypesPackage.JVM_MEMBER__SIMPLE_NAME:
				setSimpleName((String)newValue);
				return;
			case TypesPackage.JVM_MEMBER__ANNOTATION_INFO:
				setAnnotationInfo((JvmAnnotationTarget)newValue);
				return;
			case TypesPackage.JVM_MEMBER__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends String>)newValue);
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
			case TypesPackage.JVM_MEMBER__DECLARING_TYPE:
				setDeclaringType((JvmDeclaredType)null);
				return;
			case TypesPackage.JVM_MEMBER__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case TypesPackage.JVM_MEMBER__SIMPLE_NAME:
				setSimpleName(SIMPLE_NAME_EDEFAULT);
				return;
			case TypesPackage.JVM_MEMBER__ANNOTATION_INFO:
				setAnnotationInfo((JvmAnnotationTarget)null);
				return;
			case TypesPackage.JVM_MEMBER__MODIFIERS:
				getModifiers().clear();
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
			case TypesPackage.JVM_MEMBER__DECLARING_TYPE:
				return getDeclaringType() != null;
			case TypesPackage.JVM_MEMBER__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case TypesPackage.JVM_MEMBER__SIMPLE_NAME:
				return SIMPLE_NAME_EDEFAULT == null ? simpleName != null : !SIMPLE_NAME_EDEFAULT.equals(simpleName);
			case TypesPackage.JVM_MEMBER__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case TypesPackage.JVM_MEMBER__ANNOTATION_INFO:
				return annotationInfo != null;
			case TypesPackage.JVM_MEMBER__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
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
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(", simpleName: ");
		result.append(simpleName);
		result.append(", identifier: ");
		result.append(identifier);
		result.append(", modifiers: ");
		result.append(modifiers);
		result.append(')');
		return result.toString();
	}

} //JvmMemberImpl
