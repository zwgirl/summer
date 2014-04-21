/**
 */
package org.summer.dsl.model.ss.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XImportSection1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xtend File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.ss.impl.XtendFileImpl#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.impl.XtendFileImpl#getXtendTypes <em>Xtend Types</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.impl.XtendFileImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.impl.XtendFileImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.impl.XtendFileImpl#getExportSection <em>Export Section</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XtendFileImpl extends MinimalEObjectImpl.Container implements XtendFile {
	/**
	 * The cached value of the '{@link #getImportSection() <em>Import Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportSection()
	 * @generated
	 * @ordered
	 */
	protected XImportSection1 importSection;

	/**
	 * The cached value of the '{@link #getXtendTypes() <em>Xtend Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtendTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<XtendTypeDeclaration> xtendTypes;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XtendFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SsPackage.Literals.XTEND_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XImportSection1 getImportSection() {
		return importSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImportSection(XImportSection1 newImportSection, NotificationChain msgs) {
		XImportSection1 oldImportSection = importSection;
		importSection = newImportSection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SsPackage.XTEND_FILE__IMPORT_SECTION, oldImportSection, newImportSection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportSection(XImportSection1 newImportSection) {
		if (newImportSection != importSection) {
			NotificationChain msgs = null;
			if (importSection != null)
				msgs = ((InternalEObject)importSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SsPackage.XTEND_FILE__IMPORT_SECTION, null, msgs);
			if (newImportSection != null)
				msgs = ((InternalEObject)newImportSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SsPackage.XTEND_FILE__IMPORT_SECTION, null, msgs);
			msgs = basicSetImportSection(newImportSection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SsPackage.XTEND_FILE__IMPORT_SECTION, newImportSection, newImportSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XtendTypeDeclaration> getXtendTypes() {
		if (xtendTypes == null) {
			xtendTypes = new EObjectContainmentEList<XtendTypeDeclaration>(XtendTypeDeclaration.class, this, SsPackage.XTEND_FILE__XTEND_TYPES);
		}
		return xtendTypes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SsPackage.XTEND_FILE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<EObject>(EObject.class, this, SsPackage.XTEND_FILE__CONTENTS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SsPackage.XTEND_FILE__EXPORT_SECTION, oldExportSection, newExportSection);
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
				msgs = ((InternalEObject)exportSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SsPackage.XTEND_FILE__EXPORT_SECTION, null, msgs);
			if (newExportSection != null)
				msgs = ((InternalEObject)newExportSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SsPackage.XTEND_FILE__EXPORT_SECTION, null, msgs);
			msgs = basicSetExportSection(newExportSection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SsPackage.XTEND_FILE__EXPORT_SECTION, newExportSection, newExportSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SsPackage.XTEND_FILE__IMPORT_SECTION:
				return basicSetImportSection(null, msgs);
			case SsPackage.XTEND_FILE__XTEND_TYPES:
				return ((InternalEList<?>)getXtendTypes()).basicRemove(otherEnd, msgs);
			case SsPackage.XTEND_FILE__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case SsPackage.XTEND_FILE__EXPORT_SECTION:
				return basicSetExportSection(null, msgs);
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
			case SsPackage.XTEND_FILE__IMPORT_SECTION:
				return getImportSection();
			case SsPackage.XTEND_FILE__XTEND_TYPES:
				return getXtendTypes();
			case SsPackage.XTEND_FILE__PACKAGE:
				return getPackage();
			case SsPackage.XTEND_FILE__CONTENTS:
				return getContents();
			case SsPackage.XTEND_FILE__EXPORT_SECTION:
				return getExportSection();
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
			case SsPackage.XTEND_FILE__IMPORT_SECTION:
				setImportSection((XImportSection1)newValue);
				return;
			case SsPackage.XTEND_FILE__XTEND_TYPES:
				getXtendTypes().clear();
				getXtendTypes().addAll((Collection<? extends XtendTypeDeclaration>)newValue);
				return;
			case SsPackage.XTEND_FILE__PACKAGE:
				setPackage((String)newValue);
				return;
			case SsPackage.XTEND_FILE__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends EObject>)newValue);
				return;
			case SsPackage.XTEND_FILE__EXPORT_SECTION:
				setExportSection((XExportSection)newValue);
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
			case SsPackage.XTEND_FILE__IMPORT_SECTION:
				setImportSection((XImportSection1)null);
				return;
			case SsPackage.XTEND_FILE__XTEND_TYPES:
				getXtendTypes().clear();
				return;
			case SsPackage.XTEND_FILE__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case SsPackage.XTEND_FILE__CONTENTS:
				getContents().clear();
				return;
			case SsPackage.XTEND_FILE__EXPORT_SECTION:
				setExportSection((XExportSection)null);
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
			case SsPackage.XTEND_FILE__IMPORT_SECTION:
				return importSection != null;
			case SsPackage.XTEND_FILE__XTEND_TYPES:
				return xtendTypes != null && !xtendTypes.isEmpty();
			case SsPackage.XTEND_FILE__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case SsPackage.XTEND_FILE__CONTENTS:
				return contents != null && !contents.isEmpty();
			case SsPackage.XTEND_FILE__EXPORT_SECTION:
				return exportSection != null;
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
		result.append(" (package: ");
		result.append(package_);
		result.append(')');
		return result.toString();
	}

} //XtendFileImpl
