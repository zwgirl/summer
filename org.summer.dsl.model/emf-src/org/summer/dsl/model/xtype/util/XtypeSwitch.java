/**
 */
package org.summer.dsl.model.xtype.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmSpecializedTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportItem;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.model.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xtype.XtypePackage
 * @generated
 */
public class XtypeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XtypePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypeSwitch() {
		if (modelPackage == null) {
			modelPackage = XtypePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case XtypePackage.XFUNCTION_TYPE_REF: {
				XFunctionTypeRef xFunctionTypeRef = (XFunctionTypeRef)theEObject;
				T result = caseXFunctionTypeRef(xFunctionTypeRef);
				if (result == null) result = caseJvmSpecializedTypeReference(xFunctionTypeRef);
				if (result == null) result = caseJvmTypeReference(xFunctionTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtypePackage.XCOMPUTED_TYPE_REFERENCE: {
				XComputedTypeReference xComputedTypeReference = (XComputedTypeReference)theEObject;
				T result = caseXComputedTypeReference(xComputedTypeReference);
				if (result == null) result = caseJvmSpecializedTypeReference(xComputedTypeReference);
				if (result == null) result = caseJvmTypeReference(xComputedTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtypePackage.XIMPORT_SECTION: {
				XImportSection xImportSection = (XImportSection)theEObject;
				T result = caseXImportSection(xImportSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtypePackage.XIMPORT_DECLARATION: {
				XImportDeclaration xImportDeclaration = (XImportDeclaration)theEObject;
				T result = caseXImportDeclaration(xImportDeclaration);
				if (result == null) result = caseJvmIdentifiableElement(xImportDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtypePackage.XIMPORT_ITEM: {
				XImportItem xImportItem = (XImportItem)theEObject;
				T result = caseXImportItem(xImportItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtypePackage.XEXPORT_SECTION: {
				XExportSection xExportSection = (XExportSection)theEObject;
				T result = caseXExportSection(xExportSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtypePackage.XEXPORT_DECLARATION: {
				XExportDeclaration xExportDeclaration = (XExportDeclaration)theEObject;
				T result = caseXExportDeclaration(xExportDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtypePackage.XEXPORT_ITEM: {
				XExportItem xExportItem = (XExportItem)theEObject;
				T result = caseXExportItem(xExportItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFunction Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFunction Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXFunctionTypeRef(XFunctionTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XComputed Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XComputed Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXComputedTypeReference(XComputedTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XImport Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XImport Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXImportSection(XImportSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XImport Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XImport Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXImportDeclaration(XImportDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XImport Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XImport Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXImportItem(XImportItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExport Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExport Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExportSection(XExportSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExport Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExport Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExportDeclaration(XExportDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExport Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExport Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExportItem(XExportItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypeReference(JvmTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Specialized Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Specialized Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmSpecializedTypeReference(JvmSpecializedTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmIdentifiableElement(JvmIdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //XtypeSwitch
