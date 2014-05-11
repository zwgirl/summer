/**
 */
package org.summer.dsl.model.xaml.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.summer.dsl.model.xaml.*;

import org.summer.dsl.model.xbase.XExpression;

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
 * @see org.summer.dsl.model.xaml.XamlPackage
 * @generated
 */
public class XamlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XamlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XamlSwitch() {
		if (modelPackage == null) {
			modelPackage = XamlPackage.eINSTANCE;
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
			case XamlPackage.XELEMENT: {
				XElement xElement = (XElement)theEObject;
				T result = caseXElement(xElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XamlPackage.XOBJECT_ELEMENT: {
				XObjectElement xObjectElement = (XObjectElement)theEObject;
				T result = caseXObjectElement(xObjectElement);
				if (result == null) result = caseXElement(xObjectElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XamlPackage.XATTRIBUTE_ELEMENT: {
				XAttributeElement xAttributeElement = (XAttributeElement)theEObject;
				T result = caseXAttributeElement(xAttributeElement);
				if (result == null) result = caseXElement(xAttributeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XamlPackage.XABSTRACT_ATTRIBUTE: {
				XAbstractAttribute xAbstractAttribute = (XAbstractAttribute)theEObject;
				T result = caseXAbstractAttribute(xAbstractAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XamlPackage.XMARKUP_EXTENSON: {
				XMarkupExtenson xMarkupExtenson = (XMarkupExtenson)theEObject;
				T result = caseXMarkupExtenson(xMarkupExtenson);
				if (result == null) result = caseXElement(xMarkupExtenson);
				if (result == null) result = caseXExpression(xMarkupExtenson);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XamlPackage.XATTACH_ATTRIBUTE: {
				XAttachAttribute xAttachAttribute = (XAttachAttribute)theEObject;
				T result = caseXAttachAttribute(xAttachAttribute);
				if (result == null) result = caseXAbstractAttribute(xAttachAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XamlPackage.XGENERAL_ATTRIBUTE: {
				XGeneralAttribute xGeneralAttribute = (XGeneralAttribute)theEObject;
				T result = caseXGeneralAttribute(xGeneralAttribute);
				if (result == null) result = caseXAbstractAttribute(xGeneralAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXElement(XElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XObject Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XObject Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXObjectElement(XObjectElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAttribute Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAttribute Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAttributeElement(XAttributeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAbstract Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAbstract Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAbstractAttribute(XAbstractAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMarkup Extenson</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMarkup Extenson</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMarkupExtenson(XMarkupExtenson object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAttach Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAttach Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAttachAttribute(XAttachAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XGeneral Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XGeneral Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXGeneralAttribute(XGeneralAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExpression(XExpression object) {
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

} //XamlSwitch
