/**
 */
package org.summer.dsl.model.types.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xaml.XObjectElement;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmModuleImpl#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmModuleImpl#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmModuleImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmModuleImpl#getExportSection <em>Export Section</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmModuleImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmModuleImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JvmModuleImpl extends JvmTypeImpl implements JvmModule {
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
	 * The cached value of the '{@link #getImportSection() <em>Import Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportSection()
	 * @generated
	 * @ordered
	 */
	protected XImportSection importSection;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> contents;

	/**
	 * The cached value of the '{@link #getExportSection() <em>Export Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportSection()
	 * @generated
	 * @ordered
	 */
	protected XExportSection exportSection;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected XObjectElement root;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_MODULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__SIMPLE_NAME, oldSimpleName, simpleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XImportSection getImportSection() {
		return importSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImportSection(XImportSection newImportSection, NotificationChain msgs) {
		XImportSection oldImportSection = importSection;
		importSection = newImportSection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__IMPORT_SECTION, oldImportSection, newImportSection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportSection(XImportSection newImportSection) {
		if (newImportSection != importSection) {
			NotificationChain msgs = null;
			if (importSection != null)
				msgs = ((InternalEObject)importSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MODULE__IMPORT_SECTION, null, msgs);
			if (newImportSection != null)
				msgs = ((InternalEObject)newImportSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MODULE__IMPORT_SECTION, null, msgs);
			msgs = basicSetImportSection(newImportSection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__IMPORT_SECTION, newImportSection, newImportSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<EObject>(EObject.class, this, TypesPackage.JVM_MODULE__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExportSection getExportSection() {
		return exportSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExportSection(XExportSection newExportSection, NotificationChain msgs) {
		XExportSection oldExportSection = exportSection;
		exportSection = newExportSection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__EXPORT_SECTION, oldExportSection, newExportSection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportSection(XExportSection newExportSection) {
		if (newExportSection != exportSection) {
			NotificationChain msgs = null;
			if (exportSection != null)
				msgs = ((InternalEObject)exportSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MODULE__EXPORT_SECTION, null, msgs);
			if (newExportSection != null)
				msgs = ((InternalEObject)newExportSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MODULE__EXPORT_SECTION, null, msgs);
			msgs = basicSetExportSection(newExportSection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__EXPORT_SECTION, newExportSection, newExportSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XObjectElement getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(XObjectElement newRoot, NotificationChain msgs) {
		XObjectElement oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(XObjectElement newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MODULE__ROOT, null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_MODULE__ROOT, null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__ROOT, newRoot, newRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_MODULE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_MODULE__IMPORT_SECTION:
				return basicSetImportSection(null, msgs);
			case TypesPackage.JVM_MODULE__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case TypesPackage.JVM_MODULE__EXPORT_SECTION:
				return basicSetExportSection(null, msgs);
			case TypesPackage.JVM_MODULE__ROOT:
				return basicSetRoot(null, msgs);
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
			case TypesPackage.JVM_MODULE__SIMPLE_NAME:
				return getSimpleName();
			case TypesPackage.JVM_MODULE__IMPORT_SECTION:
				return getImportSection();
			case TypesPackage.JVM_MODULE__CONTENTS:
				return getContents();
			case TypesPackage.JVM_MODULE__EXPORT_SECTION:
				return getExportSection();
			case TypesPackage.JVM_MODULE__ROOT:
				return getRoot();
			case TypesPackage.JVM_MODULE__PACKAGE:
				return getPackage();
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
			case TypesPackage.JVM_MODULE__SIMPLE_NAME:
				setSimpleName((String)newValue);
				return;
			case TypesPackage.JVM_MODULE__IMPORT_SECTION:
				setImportSection((XImportSection)newValue);
				return;
			case TypesPackage.JVM_MODULE__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends EObject>)newValue);
				return;
			case TypesPackage.JVM_MODULE__EXPORT_SECTION:
				setExportSection((XExportSection)newValue);
				return;
			case TypesPackage.JVM_MODULE__ROOT:
				setRoot((XObjectElement)newValue);
				return;
			case TypesPackage.JVM_MODULE__PACKAGE:
				setPackage((String)newValue);
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
			case TypesPackage.JVM_MODULE__SIMPLE_NAME:
				setSimpleName(SIMPLE_NAME_EDEFAULT);
				return;
			case TypesPackage.JVM_MODULE__IMPORT_SECTION:
				setImportSection((XImportSection)null);
				return;
			case TypesPackage.JVM_MODULE__CONTENTS:
				getContents().clear();
				return;
			case TypesPackage.JVM_MODULE__EXPORT_SECTION:
				setExportSection((XExportSection)null);
				return;
			case TypesPackage.JVM_MODULE__ROOT:
				setRoot((XObjectElement)null);
				return;
			case TypesPackage.JVM_MODULE__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
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
			case TypesPackage.JVM_MODULE__SIMPLE_NAME:
				return SIMPLE_NAME_EDEFAULT == null ? simpleName != null : !SIMPLE_NAME_EDEFAULT.equals(simpleName);
			case TypesPackage.JVM_MODULE__IMPORT_SECTION:
				return importSection != null;
			case TypesPackage.JVM_MODULE__CONTENTS:
				return contents != null && !contents.isEmpty();
			case TypesPackage.JVM_MODULE__EXPORT_SECTION:
				return exportSection != null;
			case TypesPackage.JVM_MODULE__ROOT:
				return root != null;
			case TypesPackage.JVM_MODULE__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
		}
		return super.eIsSet(featureID);
	}
	
	public String getModuleName() {
		String[] segments = simpleName.split("\\.");
		return segments[segments.length-1];
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
		result.append(" (simpleName: ");
		result.append(simpleName);
		result.append(", package: ");
		result.append(package_);
		result.append(')');
		return result.toString();
	}

	public Iterable<JvmDeclaredType> getJvmDeclaredTypes() {
		List<JvmDeclaredType> result = new LinkedList<JvmDeclaredType>();
		for(EObject object : getContents()){
			if(object instanceof JvmDeclaredType){
				result.add((JvmDeclaredType) object);
			}
		}
		return result;
	}

} //JvmModuleImpl
