/**
 */
package org.summer.dsl.model.xtype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XExport Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xtype.impl.XExportSectionImpl#getExportDeclarations <em>Export Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XExportSectionImpl extends MinimalEObjectImpl.Container implements XExportSection {
	/**
	 * The cached value of the '{@link #getExportDeclarations() <em>Export Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<XExportDeclaration> exportDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XExportSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtypePackage.Literals.XEXPORT_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExportDeclaration> getExportDeclarations() {
		if (exportDeclarations == null) {
			exportDeclarations = new EObjectContainmentEList<XExportDeclaration>(XExportDeclaration.class, this, XtypePackage.XEXPORT_SECTION__EXPORT_DECLARATIONS);
		}
		return exportDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XtypePackage.XEXPORT_SECTION__EXPORT_DECLARATIONS:
				return ((InternalEList<?>)getExportDeclarations()).basicRemove(otherEnd, msgs);
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
			case XtypePackage.XEXPORT_SECTION__EXPORT_DECLARATIONS:
				return getExportDeclarations();
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
			case XtypePackage.XEXPORT_SECTION__EXPORT_DECLARATIONS:
				getExportDeclarations().clear();
				getExportDeclarations().addAll((Collection<? extends XExportDeclaration>)newValue);
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
			case XtypePackage.XEXPORT_SECTION__EXPORT_DECLARATIONS:
				getExportDeclarations().clear();
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
			case XtypePackage.XEXPORT_SECTION__EXPORT_DECLARATIONS:
				return exportDeclarations != null && !exportDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XExportSectionImpl
