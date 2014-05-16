/**
 */
package org.summer.dsl.model.xtype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportItem;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.model.xtype.XtypeFactory;
import org.summer.dsl.model.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class XtypeFactoryImpl extends EFactoryImpl implements XtypeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XtypeFactory init() {
		try {
			XtypeFactory theXtypeFactory = (XtypeFactory)EPackage.Registry.INSTANCE.getEFactory(XtypePackage.eNS_URI);
			if (theXtypeFactory != null) {
				return theXtypeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XtypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypeFactoryImpl() {
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
			case XtypePackage.XFUNCTION_TYPE_REF: return createXFunctionTypeRef();
			case XtypePackage.XCOMPUTED_TYPE_REFERENCE: return createXComputedTypeReference();
			case XtypePackage.XIMPORT_SECTION: return createXImportSection();
			case XtypePackage.XIMPORT_DECLARATION: return createXImportDeclaration();
			case XtypePackage.XIMPORT_ITEM: return createXImportItem();
			case XtypePackage.XEXPORT_SECTION: return createXExportSection();
			case XtypePackage.XEXPORT_DECLARATION: return createXExportDeclaration();
			case XtypePackage.XEXPORT_ITEM: return createXExportItem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XFunctionTypeRef createXFunctionTypeRef()
	{
		XFunctionTypeRefImplCustom xFunctionTypeRef = new XFunctionTypeRefImplCustom();
		return xFunctionTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XComputedTypeReference createXComputedTypeReference()
	{
		XComputedTypeReferenceImplCustom xComputedTypeReference = new XComputedTypeReferenceImplCustom();
		return xComputedTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XImportSection createXImportSection()
	{
		XImportSectionImpl xImportSection = new XImportSectionImpl();
		return xImportSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XImportDeclaration createXImportDeclaration()
	{
		XImportDeclarationImplCustom xImportDeclaration = new XImportDeclarationImplCustom();
		return xImportDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypePackage getXtypePackage() {
		return (XtypePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XtypePackage getPackage() {
		return XtypePackage.eINSTANCE;
	}

	public XImportItem createXImportItem() {
		return new XImportItemImpl();
	}

	public XExportSection createXExportSection() {
		return new XExportSectionImpl();
	}

	public XExportDeclaration createXExportDeclaration() {
		return new XExportDeclarationImpl();
	}

	public XExportItem createXExportItem() {
		return new XExportItemImpl();
	}

} //XtypeFactoryImpl
