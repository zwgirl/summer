/**
 */
package org.summer.dsl.model.ss.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.summer.dsl.model.ss.CreateExtensionInfo;
import org.summer.dsl.model.ss.RichString;
import org.summer.dsl.model.ss.RichStringElseIf;
import org.summer.dsl.model.ss.RichStringForLoop;
import org.summer.dsl.model.ss.RichStringIf;
import org.summer.dsl.model.ss.RichStringLiteral;
import org.summer.dsl.model.ss.XtendAnnotationType;
import org.summer.dsl.model.ss.XtendClass;
import org.summer.dsl.model.ss.XtendConstructor;
import org.summer.dsl.model.ss.XtendDelegate;
import org.summer.dsl.model.ss.XtendEnum;
import org.summer.dsl.model.ss.XtendEnumLiteral;
import org.summer.dsl.model.ss.XtendEvent;
import org.summer.dsl.model.ss.XtendField;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.ss.XtendFormalParameter;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.ss.XtendInterface;
import org.summer.dsl.model.ss.XtendMember;
import org.summer.dsl.model.ss.XtendParameter;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.summer.dsl.model.ss.XtendVariableDeclaration;
import org.summer.dsl.model.ss.impl.CreateExtensionInfoImpl;
import org.summer.dsl.model.ss.impl.RichStringElseIfImpl;
import org.summer.dsl.model.ss.impl.RichStringForLoopImpl;
import org.summer.dsl.model.ss.impl.RichStringIfImpl;
import org.summer.dsl.model.ss.impl.RichStringImpl;
import org.summer.dsl.model.ss.impl.RichStringLiteralImpl;
import org.summer.dsl.model.ss.impl.XtendAnnotationTypeImplCustom;
import org.summer.dsl.model.ss.impl.XtendClassImplCustom;
import org.summer.dsl.model.ss.impl.XtendConstructorImpl;
import org.summer.dsl.model.ss.impl.XtendEnumImplCustom;
import org.summer.dsl.model.ss.impl.XtendEnumLiteralImplCustom;
import org.summer.dsl.model.ss.impl.XtendFieldImplCustom;
import org.summer.dsl.model.ss.impl.XModuleImpl;
import org.summer.dsl.model.ss.impl.XtendFormalParameterImpl;
import org.summer.dsl.model.ss.impl.XtendFunctionImplCustom;
import org.summer.dsl.model.ss.impl.XtendInterfaceImplCustom;
import org.summer.dsl.model.ss.impl.XtendMemberImplCustom;
import org.summer.dsl.model.ss.impl.XtendParameterImpl;
import org.summer.dsl.model.ss.impl.XtendTypeDeclarationImpl;
import org.summer.dsl.model.ss.impl.XtendVariableDeclarationImpl;
import org.summer.dsl.model.ss.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class SsFactoryImpl extends EFactoryImpl implements SsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SsFactory init() {
		try {
			SsFactory theSsFactory = (SsFactory)EPackage.Registry.INSTANCE.getEFactory(SsPackage.eNS_URI);
			if (theSsFactory != null) {
				return theSsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsFactoryImpl() {
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
			case SsPackage.XMODULE: return createXModule();
			case SsPackage.XTEND_CLASS: return createXtendClass();
			case SsPackage.XTEND_MEMBER: return createXtendMember();
			case SsPackage.XTEND_FUNCTION: return createXtendFunction();
			case SsPackage.XTEND_FIELD: return createXtendField();
			case SsPackage.XTEND_PARAMETER: return createXtendParameter();
			case SsPackage.RICH_STRING: return createRichString();
			case SsPackage.RICH_STRING_LITERAL: return createRichStringLiteral();
			case SsPackage.RICH_STRING_FOR_LOOP: return createRichStringForLoop();
			case SsPackage.RICH_STRING_IF: return createRichStringIf();
			case SsPackage.RICH_STRING_ELSE_IF: return createRichStringElseIf();
			case SsPackage.CREATE_EXTENSION_INFO: return createCreateExtensionInfo();
			case SsPackage.XTEND_CONSTRUCTOR: return createXtendConstructor();
			case SsPackage.XTEND_TYPE_DECLARATION: return createXtendTypeDeclaration();
			case SsPackage.XTEND_ANNOTATION_TYPE: return createXtendAnnotationType();
			case SsPackage.XTEND_INTERFACE: return createXtendInterface();
			case SsPackage.XTEND_ENUM: return createXtendEnum();
			case SsPackage.XTEND_ENUM_LITERAL: return createXtendEnumLiteral();
			case SsPackage.XTEND_VARIABLE_DECLARATION: return createXtendVariableDeclaration();
			case SsPackage.XTEND_FORMAL_PARAMETER: return createXtendFormalParameter();
			case SsPackage.XTEND_DELEGATE: return createXtendDelegate();
			case SsPackage.XTEND_EVENT: return createXtendEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendClass createXtendClass()
	{
		XtendClassImplCustom xtendClass = new XtendClassImplCustom();
		return xtendClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendMember createXtendMember()
	{
		XtendMemberImplCustom xtendMember = new XtendMemberImplCustom();
		return xtendMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendFunction createXtendFunction()
	{
		XtendFunctionImplCustom xtendFunction = new XtendFunctionImplCustom();
		return xtendFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendField createXtendField()
	{
		XtendFieldImplCustom xtendField = new XtendFieldImplCustom();
		return xtendField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendParameter createXtendParameter()
	{
		XtendParameterImpl xtendParameter = new XtendParameterImpl();
		return xtendParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichString createRichString()
	{
		RichStringImpl richString = new RichStringImpl();
		return richString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringLiteral createRichStringLiteral()
	{
		RichStringLiteralImpl richStringLiteral = new RichStringLiteralImpl();
		return richStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringForLoop createRichStringForLoop()
	{
		RichStringForLoopImpl richStringForLoop = new RichStringForLoopImpl();
		return richStringForLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringIf createRichStringIf()
	{
		RichStringIfImpl richStringIf = new RichStringIfImpl();
		return richStringIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringElseIf createRichStringElseIf()
	{
		RichStringElseIfImpl richStringElseIf = new RichStringElseIfImpl();
		return richStringElseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateExtensionInfo createCreateExtensionInfo()
	{
		CreateExtensionInfoImpl createExtensionInfo = new CreateExtensionInfoImpl();
		return createExtensionInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendConstructor createXtendConstructor()
	{
		XtendConstructorImpl xtendConstructor = new XtendConstructorImpl();
		return xtendConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendTypeDeclaration createXtendTypeDeclaration()
	{
		XtendTypeDeclarationImpl xtendTypeDeclaration = new XtendTypeDeclarationImpl();
		return xtendTypeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendAnnotationType createXtendAnnotationType()
	{
		XtendAnnotationTypeImplCustom xtendAnnotationType = new XtendAnnotationTypeImplCustom();
		return xtendAnnotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendInterface createXtendInterface()
	{
		XtendInterfaceImplCustom xtendInterface = new XtendInterfaceImplCustom();
		return xtendInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendEnum createXtendEnum()
	{
		XtendEnumImplCustom xtendEnum = new XtendEnumImplCustom();
		return xtendEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendEnumLiteral createXtendEnumLiteral()
	{
		XtendEnumLiteralImplCustom xtendEnumLiteral = new XtendEnumLiteralImplCustom();
		return xtendEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendVariableDeclaration createXtendVariableDeclaration()
	{
		XtendVariableDeclarationImpl xtendVariableDeclaration = new XtendVariableDeclarationImpl();
		return xtendVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendFormalParameter createXtendFormalParameter()
	{
		XtendFormalParameterImpl xtendFormalParameter = new XtendFormalParameterImpl();
		return xtendFormalParameter;
	}
	
	public XtendDelegate createXtendDelegate() {
		return new XtendDelegateImpl();
	}
	
	public XtendEvent createXtendEvent() {
		return new XtendEventImpl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsPackage getSsPackage() {
		return (SsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SsPackage getPackage() {
		return SsPackage.eINSTANCE;
	}

	@Override
	public XModule createXModule() {
		return new XModuleImpl();
	}

} //SsFactoryImpl
