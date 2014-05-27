/**
 */
package org.summer.dsl.model.xtype.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xtype.XtypePackage
 * @generated
 */
public class XtypeAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XtypePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XtypePackage.eINSTANCE;
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
	protected XtypeSwitch<Adapter> modelSwitch =
		new XtypeSwitch<Adapter>() {
			@Override
			public Adapter caseXFunctionTypeRef(XFunctionTypeRef object) {
				return createXFunctionTypeRefAdapter();
			}
			@Override
			public Adapter caseXComputedTypeReference(XComputedTypeReference object) {
				return createXComputedTypeReferenceAdapter();
			}
			@Override
			public Adapter caseXImportSection(XImportSection object) {
				return createXImportSectionAdapter();
			}
			@Override
			public Adapter caseXImportDeclaration(XImportDeclaration object) {
				return createXImportDeclarationAdapter();
			}
			@Override
			public Adapter caseXImportItem(XImportItem object) {
				return createXImportItemAdapter();
			}
			@Override
			public Adapter caseXExportSection(XExportSection object) {
				return createXExportSectionAdapter();
			}
			@Override
			public Adapter caseXExportDeclaration(XExportDeclaration object) {
				return createXExportDeclarationAdapter();
			}
			@Override
			public Adapter caseXExportItem(XExportItem object) {
				return createXExportItemAdapter();
			}
			@Override
			public Adapter caseJvmTypeReference(JvmTypeReference object) {
				return createJvmTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmSpecializedTypeReference(JvmSpecializedTypeReference object) {
				return createJvmSpecializedTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmIdentifiableElement(JvmIdentifiableElement object) {
				return createJvmIdentifiableElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XFunctionTypeRef <em>XFunction Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XFunctionTypeRef
	 * @generated
	 */
	public Adapter createXFunctionTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XComputedTypeReference <em>XComputed Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XComputedTypeReference
	 * @generated
	 */
	public Adapter createXComputedTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XImportSection <em>XImport Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XImportSection
	 * @generated
	 */
	public Adapter createXImportSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XImportDeclaration <em>XImport Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XImportDeclaration
	 * @generated
	 */
	public Adapter createXImportDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XImportItem <em>XImport Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XImportItem
	 * @generated
	 */
	public Adapter createXImportItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XExportSection <em>XExport Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XExportSection
	 * @generated
	 */
	public Adapter createXExportSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XExportDeclaration <em>XExport Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XExportDeclaration
	 * @generated
	 */
	public Adapter createXExportDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xtype.XExportItem <em>XExport Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xtype.XExportItem
	 * @generated
	 */
	public Adapter createXExportItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmTypeReference <em>Jvm Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmTypeReference
	 * @generated
	 */
	public Adapter createJvmTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmSpecializedTypeReference <em>Jvm Specialized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmSpecializedTypeReference
	 * @generated
	 */
	public Adapter createJvmSpecializedTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmIdentifiableElement
	 * @generated
	 */
	public Adapter createJvmIdentifiableElementAdapter() {
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

} //XtypeAdapterFactory
