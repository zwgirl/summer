/**
 */
package org.summer.dsl.model.xaml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.summer.dsl.model.xaml.XAbstractAttribute;
import org.summer.dsl.model.xaml.XAttachAttribute;
import org.summer.dsl.model.xaml.XAttributeElement;
import org.summer.dsl.model.xaml.XElement;
import org.summer.dsl.model.xaml.XGeneralAttribute;
import org.summer.dsl.model.xaml.XMarkupExtenson;
import org.summer.dsl.model.xaml.XObjectElement;
import org.summer.dsl.model.xaml.XamlFactory;
import org.summer.dsl.model.xaml.XamlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XamlFactoryImpl extends EFactoryImpl implements XamlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XamlFactory init() {
		try {
			XamlFactory theXamlFactory = (XamlFactory)EPackage.Registry.INSTANCE.getEFactory(XamlPackage.eNS_URI);
			if (theXamlFactory != null) {
				return theXamlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XamlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XamlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XamlPackage.XELEMENT: return createXElement();
			case XamlPackage.XOBJECT_ELEMENT: return createXObjectElement();
			case XamlPackage.XATTRIBUTE_ELEMENT: return createXAttributeElement();
			case XamlPackage.XABSTRACT_ATTRIBUTE: return createXAbstractAttribute();
			case XamlPackage.XMARKUP_EXTENSON: return createXMarkupExtenson();
			case XamlPackage.XATTACH_ATTRIBUTE: return createXAttachAttribute();
			case XamlPackage.XGENERAL_ATTRIBUTE: return createXGeneralAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XElement createXElement() {
		XElementImpl xElement = new XElementImpl();
		return xElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XObjectElement createXObjectElement() {
		XObjectElementImpl xObjectElement = new XObjectElementImpl();
		return xObjectElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAttributeElement createXAttributeElement() {
		XAttributeElementImpl xAttributeElement = new XAttributeElementImpl();
		return xAttributeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAbstractAttribute createXAbstractAttribute() {
		XAbstractAttributeImpl xAbstractAttribute = new XAbstractAttributeImpl();
		return xAbstractAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMarkupExtenson createXMarkupExtenson() {
		XMarkupExtensonImpl xMarkupExtenson = new XMarkupExtensonImpl();
		return xMarkupExtenson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAttachAttribute createXAttachAttribute() {
		XAttachAttributeImpl xAttachAttribute = new XAttachAttributeImpl();
		return xAttachAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XGeneralAttribute createXGeneralAttribute() {
		XGeneralAttributeImpl xGeneralAttribute = new XGeneralAttributeImpl();
		return xGeneralAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XamlPackage getXamlPackage() {
		return (XamlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XamlPackage getPackage() {
		return XamlPackage.eINSTANCE;
	}

} //XamlFactoryImpl
