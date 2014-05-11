/**
 */
package org.summer.dsl.model.xaml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.xaml.*;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xaml.XamlPackage
 * @generated
 */
public class XamlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XamlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XamlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XamlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XamlSwitch<Adapter> modelSwitch =
		new XamlSwitch<Adapter>() {
			@Override
			public Adapter caseXElement(XElement object) {
				return createXElementAdapter();
			}
			@Override
			public Adapter caseXObjectElement(XObjectElement object) {
				return createXObjectElementAdapter();
			}
			@Override
			public Adapter caseXAttributeElement(XAttributeElement object) {
				return createXAttributeElementAdapter();
			}
			@Override
			public Adapter caseXAbstractAttribute(XAbstractAttribute object) {
				return createXAbstractAttributeAdapter();
			}
			@Override
			public Adapter caseXMarkupExtenson(XMarkupExtenson object) {
				return createXMarkupExtensonAdapter();
			}
			@Override
			public Adapter caseXAttachAttribute(XAttachAttribute object) {
				return createXAttachAttributeAdapter();
			}
			@Override
			public Adapter caseXGeneralAttribute(XGeneralAttribute object) {
				return createXGeneralAttributeAdapter();
			}
			@Override
			public Adapter caseXExpression(XExpression object) {
				return createXExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xaml.XElement <em>XElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xaml.XElement
	 * @generated
	 */
	public Adapter createXElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xaml.XObjectElement <em>XObject Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xaml.XObjectElement
	 * @generated
	 */
	public Adapter createXObjectElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xaml.XAttributeElement <em>XAttribute Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xaml.XAttributeElement
	 * @generated
	 */
	public Adapter createXAttributeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xaml.XAbstractAttribute <em>XAbstract Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xaml.XAbstractAttribute
	 * @generated
	 */
	public Adapter createXAbstractAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xaml.XMarkupExtenson <em>XMarkup Extenson</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xaml.XMarkupExtenson
	 * @generated
	 */
	public Adapter createXMarkupExtensonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xaml.XAttachAttribute <em>XAttach Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xaml.XAttachAttribute
	 * @generated
	 */
	public Adapter createXAttachAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xaml.XGeneralAttribute <em>XGeneral Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xaml.XGeneralAttribute
	 * @generated
	 */
	public Adapter createXGeneralAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XExpression <em>XExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XExpression
	 * @generated
	 */
	public Adapter createXExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //XamlAdapterFactory
