/**
 */
package org.summer.dsl.model.xannotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.summer.dsl.model.xannotation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XannotationFactoryImpl extends EFactoryImpl implements XannotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XannotationFactory init() {
		try {
			XannotationFactory theXannotationFactory = (XannotationFactory)EPackage.Registry.INSTANCE.getEFactory(XannotationPackage.eNS_URI);
			if (theXannotationFactory != null) {
				return theXannotationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XannotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XannotationFactoryImpl() {
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
			case XannotationPackage.XANNOTATION: return createXAnnotation();
			case XannotationPackage.XANNOTATION_ELEMENT_VALUE_PAIR: return createXAnnotationElementValuePair();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAnnotation createXAnnotation() {
		XAnnotationImpl xAnnotation = new XAnnotationImpl();
		return xAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAnnotationElementValuePair createXAnnotationElementValuePair() {
		XAnnotationElementValuePairImpl xAnnotationElementValuePair = new XAnnotationElementValuePairImpl();
		return xAnnotationElementValuePair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XannotationPackage getXannotationPackage() {
		return (XannotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XannotationPackage getPackage() {
		return XannotationPackage.eINSTANCE;
	}

} //XannotationFactoryImpl
