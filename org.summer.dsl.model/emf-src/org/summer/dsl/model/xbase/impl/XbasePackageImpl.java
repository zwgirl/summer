/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.summer.dsl.model.richstring.RichstringPackage;
import org.summer.dsl.model.richstring.impl.RichstringPackageImpl;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ss.impl.SsPackageImpl;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.impl.TypesPackageImpl;
import org.summer.dsl.model.xaml.XamlPackage;
import org.summer.dsl.model.xaml.impl.XamlPackageImpl;
import org.summer.dsl.model.xannotation.XannotationPackage;
import org.summer.dsl.model.xannotation.impl.XannotationPackageImpl;
import org.summer.dsl.model.xbase.RichStringLiteral;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAbstractWhileExpression;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XBreakExpression;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XCollectionLiteral;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueExpression;
import org.summer.dsl.model.xbase.XDoWhileExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XFieldLiteralPart;
import org.summer.dsl.model.xbase.XForEachExpression;
import org.summer.dsl.model.xbase.XForLoopExpression;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfExpression;
import org.summer.dsl.model.xbase.XIndexOperation;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XKeyValuePair;
import org.summer.dsl.model.xbase.XListLiteral;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall1;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XObjectLiteralPart;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XPrefixOperation;
import org.summer.dsl.model.xbase.XReturnExpression;
import org.summer.dsl.model.xbase.XSetLiteral;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XStructLiteral;
import org.summer.dsl.model.xbase.XSwitchExpression;
import org.summer.dsl.model.xbase.XTemplate;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowExpression;
import org.summer.dsl.model.xbase.XTryCatchFinallyExpression;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileExpression;
import org.summer.dsl.model.xbase.XbaseFactory;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xtype.XtypePackage;
import org.summer.dsl.model.xtype.impl.XtypePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XbasePackageImpl extends EPackageImpl implements XbasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xIfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xSwitchExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCasePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBlockExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xVariableDeclarationListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAbstractFeatureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xMemberFeatureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xMemberFeatureCall1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFeatureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xConstructorCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBooleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xNullLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xNumberLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xStringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCollectionLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xListLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xKeyValuePairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xSetLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xClosureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCastedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBinaryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xUnaryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xForLoopExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xForEachExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAbstractWhileExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xDoWhileExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xWhileExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xTypeLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xInstanceOfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xThrowExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xTryCatchFinallyExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCatchClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xReturnExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBreakExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xContinueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xPrefixOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xPostfixOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xTernaryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xIndexOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFunctionDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xObjectLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xObjectLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xArrayLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xStructLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFieldLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass richStringLiteralEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.summer.dsl.model.xbase.XbasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XbasePackageImpl() {
		super(eNS_URI, XbaseFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link XbasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XbasePackage init() {
		if (isInited) return (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Obtain or create and register package
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XbasePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		SsPackageImpl theSsPackage = (SsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SsPackage.eNS_URI) instanceof SsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SsPackage.eNS_URI) : SsPackage.eINSTANCE);
		XannotationPackageImpl theXannotationPackage = (XannotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XannotationPackage.eNS_URI) instanceof XannotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XannotationPackage.eNS_URI) : XannotationPackage.eINSTANCE);
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);
		RichstringPackageImpl theRichstringPackage = (RichstringPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RichstringPackage.eNS_URI) instanceof RichstringPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RichstringPackage.eNS_URI) : RichstringPackage.eINSTANCE);
		XamlPackageImpl theXamlPackage = (XamlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) instanceof XamlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) : XamlPackage.eINSTANCE);

		// Create package meta-data objects
		theXbasePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theSsPackage.createPackageContents();
		theXannotationPackage.createPackageContents();
		theXtypePackage.createPackageContents();
		theRichstringPackage.createPackageContents();
		theXamlPackage.createPackageContents();

		// Initialize created meta-data
		theXbasePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theSsPackage.initializePackageContents();
		theXannotationPackage.initializePackageContents();
		theXtypePackage.initializePackageContents();
		theRichstringPackage.initializePackageContents();
		theXamlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXbasePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XbasePackage.eNS_URI, theXbasePackage);
		return theXbasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXExpression() {
		return xExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXIfExpression() {
		return xIfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_If() {
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_Then() {
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_Else() {
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSwitchExpression() {
		return xSwitchExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Switch() {
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Cases() {
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Default() {
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXSwitchExpression_LocalVarName() {
		return (EAttribute)xSwitchExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCasePart() {
		return xCasePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_Case() {
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_Then() {
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_TypeGuard() {
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBlockExpression() {
		return xBlockExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBlockExpression_Expressions() {
		return (EReference)xBlockExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXVariableDeclaration() {
		return xVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXVariableDeclaration_Type() {
		return (EReference)xVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXVariableDeclaration_Name() {
		return (EAttribute)xVariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXVariableDeclaration_Right() {
		return (EReference)xVariableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXVariableDeclarationList() {
		return xVariableDeclarationListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXVariableDeclarationList_Writeable() {
		return (EAttribute)xVariableDeclarationListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXVariableDeclarationList_Declarations() {
		return (EReference)xVariableDeclarationListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXVariableDeclarationList_Exported() {
		return (EAttribute)xVariableDeclarationListEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAbstractFeatureCall() {
		return xAbstractFeatureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_Feature() {
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_TypeArguments() {
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_ImplicitReceiver() {
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAbstractFeatureCall_InvalidFeatureIssueCode() {
		return (EAttribute)xAbstractFeatureCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAbstractFeatureCall_ValidFeature() {
		return (EAttribute)xAbstractFeatureCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_ImplicitFirstArgument() {
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMemberFeatureCall() {
		return xMemberFeatureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMemberFeatureCall_MemberCallTarget() {
		return (EReference)xMemberFeatureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMemberFeatureCall_MemberCallArguments() {
		return (EReference)xMemberFeatureCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_ExplicitOperationCall() {
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_ExplicitStatic() {
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_NullSafe() {
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_TypeLiteral() {
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_StaticWithDeclaringType() {
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_PackageFragment() {
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_IndexedOperation() {
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMemberFeatureCall1() {
		return xMemberFeatureCall1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMemberFeatureCall1_MemberCallTarget() {
		return (EReference)xMemberFeatureCall1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMemberFeatureCall1_MemberCallArguments() {
		return (EReference)xMemberFeatureCall1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall1_ExplicitOperationCall() {
		return (EAttribute)xMemberFeatureCall1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall1_ExplicitStatic() {
		return (EAttribute)xMemberFeatureCall1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall1_NullSafe() {
		return (EAttribute)xMemberFeatureCall1EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall1_TypeLiteral() {
		return (EAttribute)xMemberFeatureCall1EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall1_StaticWithDeclaringType() {
		return (EAttribute)xMemberFeatureCall1EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall1_PackageFragment() {
		return (EAttribute)xMemberFeatureCall1EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall1_IndexedOperation() {
		return (EAttribute)xMemberFeatureCall1EClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFeatureCall() {
		return xFeatureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFeatureCall_FeatureCallArguments() {
		return (EReference)xFeatureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_ExplicitOperationCall() {
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_TypeLiteral() {
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_PackageFragment() {
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_IndexedOperation() {
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFeatureCall_Value() {
		return (EReference)xFeatureCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXConstructorCall() {
		return xConstructorCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_Constructor() {
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_Arguments() {
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_TypeArguments() {
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXConstructorCall_InvalidFeatureIssueCode() {
		return (EAttribute)xConstructorCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXConstructorCall_ValidFeature() {
		return (EAttribute)xConstructorCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBooleanLiteral() {
		return xBooleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXBooleanLiteral_IsTrue() {
		return (EAttribute)xBooleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXNullLiteral() {
		return xNullLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXNumberLiteral() {
		return xNumberLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXNumberLiteral_Value() {
		return (EAttribute)xNumberLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXStringLiteral() {
		return xStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXStringLiteral_Value() {
		return (EAttribute)xStringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCollectionLiteral() {
		return xCollectionLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCollectionLiteral_Elements() {
		return (EReference)xCollectionLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXListLiteral() {
		return xListLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXKeyValuePair() {
		return xKeyValuePairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXKeyValuePair_Key() {
		return (EReference)xKeyValuePairEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXKeyValuePair_Value() {
		return (EReference)xKeyValuePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXKeyValuePair_Key1() {
		return (EAttribute)xKeyValuePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSetLiteral() {
		return xSetLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXClosure() {
		return xClosureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_DeclaredFormalParameters() {
		return (EReference)xClosureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_Expression() {
		return (EReference)xClosureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXClosure_ExplicitSyntax() {
		return (EAttribute)xClosureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_ImplicitParameter() {
		return (EReference)xClosureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXClosure_Name() {
		return (EAttribute)xClosureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_ReturnType() {
		return (EReference)xClosureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXClosure_Operator() {
		return (EAttribute)xClosureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_TypeParameters() {
		return (EReference)xClosureEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXClosure_Exported() {
		return (EAttribute)xClosureEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCastedExpression() {
		return xCastedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCastedExpression_Type() {
		return (EReference)xCastedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCastedExpression_Target() {
		return (EReference)xCastedExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBinaryOperation() {
		return xBinaryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBinaryOperation_LeftOperand() {
		return (EReference)xBinaryOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBinaryOperation_RightOperand() {
		return (EReference)xBinaryOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXUnaryOperation() {
		return xUnaryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXUnaryOperation_Operand() {
		return (EReference)xUnaryOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXForLoopExpression() {
		return xForLoopExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopExpression_EachExpression() {
		return (EReference)xForLoopExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXForEachExpression() {
		return xForEachExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForEachExpression_ForExpression() {
		return (EReference)xForEachExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForEachExpression_EachExpression() {
		return (EReference)xForEachExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForEachExpression_DeclaredParam() {
		return (EReference)xForEachExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopExpression_Condition() {
		return (EReference)xForLoopExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopExpression_Loop() {
		return (EReference)xForLoopExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopExpression_Init() {
		return (EReference)xForLoopExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAbstractWhileExpression() {
		return xAbstractWhileExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractWhileExpression_Predicate() {
		return (EReference)xAbstractWhileExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractWhileExpression_Body() {
		return (EReference)xAbstractWhileExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXDoWhileExpression() {
		return xDoWhileExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXWhileExpression() {
		return xWhileExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTypeLiteral() {
		return xTypeLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTypeLiteral_Type() {
		return (EReference)xTypeLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXTypeLiteral_ArrayDimensions() {
		return (EAttribute)xTypeLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXInstanceOfExpression() {
		return xInstanceOfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXInstanceOfExpression_Type() {
		return (EReference)xInstanceOfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXInstanceOfExpression_Expression() {
		return (EReference)xInstanceOfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXThrowExpression() {
		return xThrowExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXThrowExpression_Expression() {
		return (EReference)xThrowExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTryCatchFinallyExpression() {
		return xTryCatchFinallyExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyExpression_Expression() {
		return (EReference)xTryCatchFinallyExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyExpression_FinallyExpression() {
		return (EReference)xTryCatchFinallyExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyExpression_CatchClause() {
		return (EReference)xTryCatchFinallyExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCatchClause() {
		return xCatchClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCatchClause_Expression() {
		return (EReference)xCatchClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCatchClause_DeclaredParam() {
		return (EReference)xCatchClauseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXCatchClause_Identifier() {
		return (EAttribute)xCatchClauseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAssignment() {
		return xAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment_Assignable() {
		return (EReference)xAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment_Value() {
		return (EReference)xAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAssignment_ExplicitStatic() {
		return (EAttribute)xAssignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAssignment_IndexedOperation() {
		return (EAttribute)xAssignmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment_Index() {
		return (EReference)xAssignmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXReturnExpression() {
		return xReturnExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXReturnExpression_Expression() {
		return (EReference)xReturnExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBreakExpression() {
		return xBreakExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXContinueExpression() {
		return xContinueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXPrefixOperation() {
		return xPrefixOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXPrefixOperation_Operand() {
		return (EReference)xPrefixOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXPostfixOperation() {
		return xPostfixOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXPostfixOperation_Operand() {
		return (EReference)xPostfixOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTernaryOperation() {
		return xTernaryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTernaryOperation_TrueOperand() {
		return (EReference)xTernaryOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTernaryOperation_FalseOperand() {
		return (EReference)xTernaryOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTernaryOperation_Condition() {
		return (EReference)xTernaryOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXIndexOperation() {
		return xIndexOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIndexOperation_Expression() {
		return (EReference)xIndexOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIndexOperation_Index() {
		return (EReference)xIndexOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFunctionDeclaration() {
		return xFunctionDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFunctionDeclaration_Name() {
		return (EAttribute)xFunctionDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionDeclaration_Body() {
		return (EReference)xFunctionDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionDeclaration_ReturnType() {
		return (EReference)xFunctionDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionDeclaration_Parameters() {
		return (EReference)xFunctionDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXObjectLiteral() {
		return xObjectLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXObjectLiteralPart() {
		return xObjectLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXArrayLiteral() {
		return xArrayLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXArrayLiteral_Elements() {
		return (EReference)xArrayLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXStructLiteral() {
		return xStructLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXStructLiteral_Properties() {
		return (EReference)xStructLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXStructLiteral_Type() {
		return (EReference)xStructLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXStructLiteral_TypeArguments() {
		return (EReference)xStructLiteralEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFieldLiteralPart() {
		return xFieldLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFieldLiteralPart_Field() {
		return (EReference)xFieldLiteralPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFieldLiteralPart_Value() {
		return (EReference)xFieldLiteralPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTemplate() {
		return xTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRichStringLiteral() {
		return richStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseFactory getXbaseFactory() {
		return (XbaseFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xExpressionEClass = createEClass(XEXPRESSION);

		xIfExpressionEClass = createEClass(XIF_EXPRESSION);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__IF);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__THEN);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__ELSE);

		xSwitchExpressionEClass = createEClass(XSWITCH_EXPRESSION);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__SWITCH);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__CASES);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__DEFAULT);
		createEAttribute(xSwitchExpressionEClass, XSWITCH_EXPRESSION__LOCAL_VAR_NAME);

		xCasePartEClass = createEClass(XCASE_PART);
		createEReference(xCasePartEClass, XCASE_PART__CASE);
		createEReference(xCasePartEClass, XCASE_PART__THEN);
		createEReference(xCasePartEClass, XCASE_PART__TYPE_GUARD);

		xBlockExpressionEClass = createEClass(XBLOCK_EXPRESSION);
		createEReference(xBlockExpressionEClass, XBLOCK_EXPRESSION__EXPRESSIONS);

		xVariableDeclarationEClass = createEClass(XVARIABLE_DECLARATION);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__TYPE);
		createEAttribute(xVariableDeclarationEClass, XVARIABLE_DECLARATION__NAME);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__RIGHT);

		xVariableDeclarationListEClass = createEClass(XVARIABLE_DECLARATION_LIST);
		createEReference(xVariableDeclarationListEClass, XVARIABLE_DECLARATION_LIST__DECLARATIONS);
		createEAttribute(xVariableDeclarationListEClass, XVARIABLE_DECLARATION_LIST__WRITEABLE);
		createEAttribute(xVariableDeclarationListEClass, XVARIABLE_DECLARATION_LIST__EXPORTED);

		xAbstractFeatureCallEClass = createEClass(XABSTRACT_FEATURE_CALL);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__FEATURE);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER);
		createEAttribute(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE);
		createEAttribute(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__VALID_FEATURE);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT);

		xMemberFeatureCallEClass = createEClass(XMEMBER_FEATURE_CALL);
		createEReference(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET);
		createEReference(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__EXPLICIT_STATIC);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__NULL_SAFE);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__TYPE_LITERAL);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__STATIC_WITH_DECLARING_TYPE);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__PACKAGE_FRAGMENT);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__INDEXED_OPERATION);

		xMemberFeatureCall1EClass = createEClass(XMEMBER_FEATURE_CALL1);
		createEReference(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__MEMBER_CALL_TARGET);
		createEReference(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__MEMBER_CALL_ARGUMENTS);
		createEAttribute(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__EXPLICIT_OPERATION_CALL);
		createEAttribute(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__EXPLICIT_STATIC);
		createEAttribute(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__NULL_SAFE);
		createEAttribute(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__TYPE_LITERAL);
		createEAttribute(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__STATIC_WITH_DECLARING_TYPE);
		createEAttribute(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__PACKAGE_FRAGMENT);
		createEAttribute(xMemberFeatureCall1EClass, XMEMBER_FEATURE_CALL1__INDEXED_OPERATION);

		xFeatureCallEClass = createEClass(XFEATURE_CALL);
		createEReference(xFeatureCallEClass, XFEATURE_CALL__FEATURE_CALL_ARGUMENTS);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__EXPLICIT_OPERATION_CALL);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__TYPE_LITERAL);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__PACKAGE_FRAGMENT);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__INDEXED_OPERATION);
		createEReference(xFeatureCallEClass, XFEATURE_CALL__VALUE);

		xConstructorCallEClass = createEClass(XCONSTRUCTOR_CALL);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__ARGUMENTS);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__TYPE_ARGUMENTS);
		createEAttribute(xConstructorCallEClass, XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE);
		createEAttribute(xConstructorCallEClass, XCONSTRUCTOR_CALL__VALID_FEATURE);

		xBooleanLiteralEClass = createEClass(XBOOLEAN_LITERAL);
		createEAttribute(xBooleanLiteralEClass, XBOOLEAN_LITERAL__IS_TRUE);

		xNullLiteralEClass = createEClass(XNULL_LITERAL);

		xNumberLiteralEClass = createEClass(XNUMBER_LITERAL);
		createEAttribute(xNumberLiteralEClass, XNUMBER_LITERAL__VALUE);

		xStringLiteralEClass = createEClass(XSTRING_LITERAL);
		createEAttribute(xStringLiteralEClass, XSTRING_LITERAL__VALUE);

		xCollectionLiteralEClass = createEClass(XCOLLECTION_LITERAL);
		createEReference(xCollectionLiteralEClass, XCOLLECTION_LITERAL__ELEMENTS);

		xListLiteralEClass = createEClass(XLIST_LITERAL);

		xKeyValuePairEClass = createEClass(XKEY_VALUE_PAIR);
		createEAttribute(xKeyValuePairEClass, XKEY_VALUE_PAIR__KEY1);
		createEReference(xKeyValuePairEClass, XKEY_VALUE_PAIR__VALUE);
		createEReference(xKeyValuePairEClass, XKEY_VALUE_PAIR__KEY);

		xSetLiteralEClass = createEClass(XSET_LITERAL);

		xClosureEClass = createEClass(XCLOSURE);
		createEReference(xClosureEClass, XCLOSURE__DECLARED_FORMAL_PARAMETERS);
		createEReference(xClosureEClass, XCLOSURE__EXPRESSION);
		createEAttribute(xClosureEClass, XCLOSURE__EXPLICIT_SYNTAX);
		createEReference(xClosureEClass, XCLOSURE__IMPLICIT_PARAMETER);
		createEAttribute(xClosureEClass, XCLOSURE__NAME);
		createEReference(xClosureEClass, XCLOSURE__RETURN_TYPE);
		createEAttribute(xClosureEClass, XCLOSURE__OPERATOR);
		createEReference(xClosureEClass, XCLOSURE__TYPE_PARAMETERS);
		createEAttribute(xClosureEClass, XCLOSURE__EXPORTED);

		xCastedExpressionEClass = createEClass(XCASTED_EXPRESSION);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TYPE);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TARGET);

		xBinaryOperationEClass = createEClass(XBINARY_OPERATION);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__LEFT_OPERAND);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__RIGHT_OPERAND);

		xUnaryOperationEClass = createEClass(XUNARY_OPERATION);
		createEReference(xUnaryOperationEClass, XUNARY_OPERATION__OPERAND);

		xForLoopExpressionEClass = createEClass(XFOR_LOOP_EXPRESSION);
		createEReference(xForLoopExpressionEClass, XFOR_LOOP_EXPRESSION__CONDITION);
		createEReference(xForLoopExpressionEClass, XFOR_LOOP_EXPRESSION__LOOP);
		createEReference(xForLoopExpressionEClass, XFOR_LOOP_EXPRESSION__INIT);
		createEReference(xForLoopExpressionEClass, XFOR_LOOP_EXPRESSION__EACH_EXPRESSION);

		xForEachExpressionEClass = createEClass(XFOR_EACH_EXPRESSION);
		createEReference(xForEachExpressionEClass, XFOR_EACH_EXPRESSION__FOR_EXPRESSION);
		createEReference(xForEachExpressionEClass, XFOR_EACH_EXPRESSION__EACH_EXPRESSION);
		createEReference(xForEachExpressionEClass, XFOR_EACH_EXPRESSION__DECLARED_PARAM);

		xAbstractWhileExpressionEClass = createEClass(XABSTRACT_WHILE_EXPRESSION);
		createEReference(xAbstractWhileExpressionEClass, XABSTRACT_WHILE_EXPRESSION__PREDICATE);
		createEReference(xAbstractWhileExpressionEClass, XABSTRACT_WHILE_EXPRESSION__BODY);

		xDoWhileExpressionEClass = createEClass(XDO_WHILE_EXPRESSION);

		xWhileExpressionEClass = createEClass(XWHILE_EXPRESSION);

		xTypeLiteralEClass = createEClass(XTYPE_LITERAL);
		createEReference(xTypeLiteralEClass, XTYPE_LITERAL__TYPE);
		createEAttribute(xTypeLiteralEClass, XTYPE_LITERAL__ARRAY_DIMENSIONS);

		xInstanceOfExpressionEClass = createEClass(XINSTANCE_OF_EXPRESSION);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__TYPE);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__EXPRESSION);

		xThrowExpressionEClass = createEClass(XTHROW_EXPRESSION);
		createEReference(xThrowExpressionEClass, XTHROW_EXPRESSION__EXPRESSION);

		xTryCatchFinallyExpressionEClass = createEClass(XTRY_CATCH_FINALLY_EXPRESSION);
		createEReference(xTryCatchFinallyExpressionEClass, XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION);
		createEReference(xTryCatchFinallyExpressionEClass, XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION);
		createEReference(xTryCatchFinallyExpressionEClass, XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE);

		xCatchClauseEClass = createEClass(XCATCH_CLAUSE);
		createEReference(xCatchClauseEClass, XCATCH_CLAUSE__EXPRESSION);
		createEReference(xCatchClauseEClass, XCATCH_CLAUSE__DECLARED_PARAM);
		createEAttribute(xCatchClauseEClass, XCATCH_CLAUSE__IDENTIFIER);

		xAssignmentEClass = createEClass(XASSIGNMENT);
		createEReference(xAssignmentEClass, XASSIGNMENT__ASSIGNABLE);
		createEReference(xAssignmentEClass, XASSIGNMENT__VALUE);
		createEAttribute(xAssignmentEClass, XASSIGNMENT__EXPLICIT_STATIC);
		createEAttribute(xAssignmentEClass, XASSIGNMENT__INDEXED_OPERATION);
		createEReference(xAssignmentEClass, XASSIGNMENT__INDEX);

		xReturnExpressionEClass = createEClass(XRETURN_EXPRESSION);
		createEReference(xReturnExpressionEClass, XRETURN_EXPRESSION__EXPRESSION);

		xBreakExpressionEClass = createEClass(XBREAK_EXPRESSION);

		xContinueExpressionEClass = createEClass(XCONTINUE_EXPRESSION);

		xPrefixOperationEClass = createEClass(XPREFIX_OPERATION);
		createEReference(xPrefixOperationEClass, XPREFIX_OPERATION__OPERAND);

		xPostfixOperationEClass = createEClass(XPOSTFIX_OPERATION);
		createEReference(xPostfixOperationEClass, XPOSTFIX_OPERATION__OPERAND);

		xTernaryOperationEClass = createEClass(XTERNARY_OPERATION);
		createEReference(xTernaryOperationEClass, XTERNARY_OPERATION__TRUE_OPERAND);
		createEReference(xTernaryOperationEClass, XTERNARY_OPERATION__FALSE_OPERAND);
		createEReference(xTernaryOperationEClass, XTERNARY_OPERATION__CONDITION);

		xIndexOperationEClass = createEClass(XINDEX_OPERATION);
		createEReference(xIndexOperationEClass, XINDEX_OPERATION__EXPRESSION);
		createEReference(xIndexOperationEClass, XINDEX_OPERATION__INDEX);

		xFunctionDeclarationEClass = createEClass(XFUNCTION_DECLARATION);
		createEAttribute(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__NAME);
		createEReference(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__BODY);
		createEReference(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__RETURN_TYPE);
		createEReference(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__PARAMETERS);

		xObjectLiteralEClass = createEClass(XOBJECT_LITERAL);

		xObjectLiteralPartEClass = createEClass(XOBJECT_LITERAL_PART);

		xArrayLiteralEClass = createEClass(XARRAY_LITERAL);
		createEReference(xArrayLiteralEClass, XARRAY_LITERAL__ELEMENTS);

		xStructLiteralEClass = createEClass(XSTRUCT_LITERAL);
		createEReference(xStructLiteralEClass, XSTRUCT_LITERAL__PROPERTIES);
		createEReference(xStructLiteralEClass, XSTRUCT_LITERAL__TYPE);
		createEReference(xStructLiteralEClass, XSTRUCT_LITERAL__TYPE_ARGUMENTS);

		xFieldLiteralPartEClass = createEClass(XFIELD_LITERAL_PART);
		createEReference(xFieldLiteralPartEClass, XFIELD_LITERAL_PART__FIELD);
		createEReference(xFieldLiteralPartEClass, XFIELD_LITERAL_PART__VALUE);

		xTemplateEClass = createEClass(XTEMPLATE);

		richStringLiteralEClass = createEClass(RICH_STRING_LITERAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xIfExpressionEClass.getESuperTypes().add(this.getXExpression());
		xSwitchExpressionEClass.getESuperTypes().add(this.getXExpression());
		xSwitchExpressionEClass.getESuperTypes().add(theTypesPackage.getJvmIdentifiableElement());
		xBlockExpressionEClass.getESuperTypes().add(this.getXExpression());
		xVariableDeclarationEClass.getESuperTypes().add(this.getXExpression());
		xVariableDeclarationEClass.getESuperTypes().add(theTypesPackage.getJvmIdentifiableElement());
		xVariableDeclarationListEClass.getESuperTypes().add(this.getXExpression());
		xAbstractFeatureCallEClass.getESuperTypes().add(this.getXExpression());
		xMemberFeatureCallEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xMemberFeatureCall1EClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xFeatureCallEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xConstructorCallEClass.getESuperTypes().add(this.getXExpression());
		xBooleanLiteralEClass.getESuperTypes().add(this.getXExpression());
		xNullLiteralEClass.getESuperTypes().add(this.getXExpression());
		xNumberLiteralEClass.getESuperTypes().add(this.getXExpression());
		xStringLiteralEClass.getESuperTypes().add(this.getXExpression());
		xCollectionLiteralEClass.getESuperTypes().add(this.getXExpression());
		xListLiteralEClass.getESuperTypes().add(this.getXCollectionLiteral());
		xKeyValuePairEClass.getESuperTypes().add(this.getXExpression());
		xSetLiteralEClass.getESuperTypes().add(this.getXCollectionLiteral());
		xClosureEClass.getESuperTypes().add(this.getXExpression());
		xClosureEClass.getESuperTypes().add(theTypesPackage.getJvmIdentifiableElement());
		xCastedExpressionEClass.getESuperTypes().add(this.getXExpression());
		xBinaryOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xUnaryOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xForLoopExpressionEClass.getESuperTypes().add(this.getXExpression());
		xForEachExpressionEClass.getESuperTypes().add(this.getXExpression());
		xAbstractWhileExpressionEClass.getESuperTypes().add(this.getXExpression());
		xDoWhileExpressionEClass.getESuperTypes().add(this.getXAbstractWhileExpression());
		xWhileExpressionEClass.getESuperTypes().add(this.getXAbstractWhileExpression());
		xTypeLiteralEClass.getESuperTypes().add(this.getXExpression());
		xInstanceOfExpressionEClass.getESuperTypes().add(this.getXExpression());
		xThrowExpressionEClass.getESuperTypes().add(this.getXExpression());
		xTryCatchFinallyExpressionEClass.getESuperTypes().add(this.getXExpression());
		xAssignmentEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xReturnExpressionEClass.getESuperTypes().add(this.getXExpression());
		xBreakExpressionEClass.getESuperTypes().add(this.getXExpression());
		xContinueExpressionEClass.getESuperTypes().add(this.getXExpression());
		xPrefixOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xPostfixOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xTernaryOperationEClass.getESuperTypes().add(this.getXExpression());
		xIndexOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xFunctionDeclarationEClass.getESuperTypes().add(this.getXExpression());
		xObjectLiteralEClass.getESuperTypes().add(theTypesPackage.getJvmDeclaredType());
		xObjectLiteralEClass.getESuperTypes().add(this.getXExpression());
		xObjectLiteralPartEClass.getESuperTypes().add(theTypesPackage.getJvmField());
		xArrayLiteralEClass.getESuperTypes().add(this.getXExpression());
		xStructLiteralEClass.getESuperTypes().add(this.getXExpression());
		xTemplateEClass.getESuperTypes().add(this.getXBlockExpression());
		richStringLiteralEClass.getESuperTypes().add(this.getXStringLiteral());

		// Initialize classes and features; add operations and parameters
		initEClass(xExpressionEClass, XExpression.class, "XExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xIfExpressionEClass, XIfExpression.class, "XIfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXIfExpression_If(), this.getXExpression(), null, "if", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfExpression_Then(), this.getXExpression(), null, "then", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfExpression_Else(), this.getXExpression(), null, "else", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xSwitchExpressionEClass, XSwitchExpression.class, "XSwitchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSwitchExpression_Switch(), this.getXExpression(), null, "switch", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchExpression_Cases(), this.getXCasePart(), null, "cases", null, 0, -1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchExpression_Default(), this.getXExpression(), null, "default", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXSwitchExpression_LocalVarName(), ecorePackage.getEString(), "localVarName", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCasePartEClass, XCasePart.class, "XCasePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCasePart_Case(), this.getXExpression(), null, "case", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCasePart_Then(), this.getXExpression(), null, "then", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCasePart_TypeGuard(), theTypesPackage.getJvmTypeReference(), null, "typeGuard", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBlockExpressionEClass, XBlockExpression.class, "XBlockExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBlockExpression_Expressions(), this.getXExpression(), null, "expressions", null, 0, -1, XBlockExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xVariableDeclarationEClass, XVariableDeclaration.class, "XVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXVariableDeclaration_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXVariableDeclaration_Right(), this.getXExpression(), null, "right", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xVariableDeclarationListEClass, XVariableDeclarationList.class, "XVariableDeclarationList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXVariableDeclarationList_Declarations(), this.getXExpression(), null, "declarations", null, 0, -1, XVariableDeclarationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclarationList_Writeable(), ecorePackage.getEBoolean(), "writeable", null, 0, 1, XVariableDeclarationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclarationList_Exported(), ecorePackage.getEBoolean(), "exported", "false", 0, 1, XVariableDeclarationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAbstractFeatureCallEClass, XAbstractFeatureCall.class, "XAbstractFeatureCall", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAbstractFeatureCall_Feature(), theTypesPackage.getJvmIdentifiableElement(), null, "feature", null, 0, 1, XAbstractFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractFeatureCall_TypeArguments(), theTypesPackage.getJvmTypeReference(), null, "typeArguments", null, 0, -1, XAbstractFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractFeatureCall_ImplicitReceiver(), this.getXExpression(), null, "implicitReceiver", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAbstractFeatureCall_InvalidFeatureIssueCode(), ecorePackage.getEString(), "invalidFeatureIssueCode", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAbstractFeatureCall_ValidFeature(), ecorePackage.getEBoolean(), "validFeature", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractFeatureCall_ImplicitFirstArgument(), this.getXExpression(), null, "implicitFirstArgument", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEString(), "getConcreteSyntaxFeatureName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, this.getXExpression(), "getExplicitArguments", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isExplicitOperationCallOrBuilderSyntax", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, this.getXExpression(), "getActualReceiver", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, this.getXExpression(), "getActualArguments", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isStatic", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isExtension", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isPackageFragment", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isTypeLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xMemberFeatureCallEClass, XMemberFeatureCall.class, "XMemberFeatureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXMemberFeatureCall_MemberCallTarget(), this.getXExpression(), null, "memberCallTarget", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMemberFeatureCall_MemberCallArguments(), this.getXExpression(), null, "memberCallArguments", null, 0, -1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_ExplicitOperationCall(), ecorePackage.getEBoolean(), "explicitOperationCall", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_ExplicitStatic(), ecorePackage.getEBoolean(), "explicitStatic", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_NullSafe(), ecorePackage.getEBoolean(), "nullSafe", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_TypeLiteral(), ecorePackage.getEBoolean(), "typeLiteral", null, 0, 1, XMemberFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_StaticWithDeclaringType(), ecorePackage.getEBoolean(), "staticWithDeclaringType", null, 0, 1, XMemberFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_PackageFragment(), ecorePackage.getEBoolean(), "packageFragment", null, 0, 1, XMemberFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_IndexedOperation(), ecorePackage.getEBoolean(), "indexedOperation", "false", 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xMemberFeatureCall1EClass, XMemberFeatureCall1.class, "XMemberFeatureCall1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXMemberFeatureCall1_MemberCallTarget(), this.getXExpression(), null, "memberCallTarget", null, 0, 1, XMemberFeatureCall1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMemberFeatureCall1_MemberCallArguments(), this.getXExpression(), null, "memberCallArguments", null, 0, -1, XMemberFeatureCall1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall1_ExplicitOperationCall(), ecorePackage.getEBoolean(), "explicitOperationCall", null, 0, 1, XMemberFeatureCall1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall1_ExplicitStatic(), ecorePackage.getEBoolean(), "explicitStatic", null, 0, 1, XMemberFeatureCall1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall1_NullSafe(), ecorePackage.getEBoolean(), "nullSafe", null, 0, 1, XMemberFeatureCall1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall1_TypeLiteral(), ecorePackage.getEBoolean(), "typeLiteral", null, 0, 1, XMemberFeatureCall1.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall1_StaticWithDeclaringType(), ecorePackage.getEBoolean(), "staticWithDeclaringType", null, 0, 1, XMemberFeatureCall1.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall1_PackageFragment(), ecorePackage.getEBoolean(), "packageFragment", null, 0, 1, XMemberFeatureCall1.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall1_IndexedOperation(), ecorePackage.getEBoolean(), "indexedOperation", "false", 0, 1, XMemberFeatureCall1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xFeatureCallEClass, XFeatureCall.class, "XFeatureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFeatureCall_FeatureCallArguments(), this.getXExpression(), null, "featureCallArguments", null, 0, -1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_ExplicitOperationCall(), ecorePackage.getEBoolean(), "explicitOperationCall", null, 0, 1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_TypeLiteral(), ecorePackage.getEBoolean(), "typeLiteral", null, 0, 1, XFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_PackageFragment(), ecorePackage.getEBoolean(), "packageFragment", null, 0, 1, XFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_IndexedOperation(), ecorePackage.getEBoolean(), "indexedOperation", "false", 0, 1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFeatureCall_Value(), this.getXExpression(), null, "value", null, 0, 1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xConstructorCallEClass, XConstructorCall.class, "XConstructorCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXConstructorCall_Constructor(), theTypesPackage.getJvmConstructor(), null, "constructor", null, 0, 1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXConstructorCall_Arguments(), this.getXExpression(), null, "arguments", null, 0, -1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXConstructorCall_TypeArguments(), theTypesPackage.getJvmTypeReference(), null, "typeArguments", null, 0, -1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXConstructorCall_InvalidFeatureIssueCode(), ecorePackage.getEString(), "invalidFeatureIssueCode", null, 0, 1, XConstructorCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXConstructorCall_ValidFeature(), ecorePackage.getEBoolean(), "validFeature", null, 0, 1, XConstructorCall.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(xBooleanLiteralEClass, XBooleanLiteral.class, "XBooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXBooleanLiteral_IsTrue(), ecorePackage.getEBoolean(), "isTrue", null, 0, 1, XBooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xNullLiteralEClass, XNullLiteral.class, "XNullLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xNumberLiteralEClass, XNumberLiteral.class, "XNumberLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXNumberLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, XNumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xStringLiteralEClass, XStringLiteral.class, "XStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, XStringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCollectionLiteralEClass, XCollectionLiteral.class, "XCollectionLiteral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCollectionLiteral_Elements(), this.getXExpression(), null, "elements", null, 0, -1, XCollectionLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xListLiteralEClass, XListLiteral.class, "XListLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xKeyValuePairEClass, XKeyValuePair.class, "XKeyValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXKeyValuePair_Key1(), ecorePackage.getEString(), "key1", null, 0, 1, XKeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXKeyValuePair_Value(), this.getXExpression(), null, "value", null, 0, 1, XKeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXKeyValuePair_Key(), this.getXExpression(), null, "key", null, 0, 1, XKeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xSetLiteralEClass, XSetLiteral.class, "XSetLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xClosureEClass, XClosure.class, "XClosure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXClosure_DeclaredFormalParameters(), theTypesPackage.getJvmFormalParameter(), null, "declaredFormalParameters", null, 0, -1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_ExplicitSyntax(), ecorePackage.getEBoolean(), "explicitSyntax", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_ImplicitParameter(), theTypesPackage.getJvmFormalParameter(), null, "implicitParameter", null, 0, 1, XClosure.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_Name(), ecorePackage.getEString(), "name", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_Operator(), ecorePackage.getEBoolean(), "operator", "false", 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_TypeParameters(), theTypesPackage.getJvmTypeParameter(), null, "typeParameters", null, 0, -1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_Exported(), ecorePackage.getEBoolean(), "exported", "false", 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xClosureEClass, theTypesPackage.getJvmFormalParameter(), "getFormalParameters", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(xCastedExpressionEClass, XCastedExpression.class, "XCastedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCastedExpression_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCastedExpression_Target(), this.getXExpression(), null, "target", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBinaryOperationEClass, XBinaryOperation.class, "XBinaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBinaryOperation_LeftOperand(), this.getXExpression(), null, "leftOperand", null, 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXBinaryOperation_RightOperand(), this.getXExpression(), null, "rightOperand", null, 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xUnaryOperationEClass, XUnaryOperation.class, "XUnaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXUnaryOperation_Operand(), this.getXExpression(), null, "operand", null, 0, 1, XUnaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xForLoopExpressionEClass, XForLoopExpression.class, "XForLoopExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXForLoopExpression_Condition(), this.getXExpression(), null, "condition", null, 0, 1, XForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopExpression_Loop(), this.getXExpression(), null, "loop", null, 0, 1, XForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopExpression_Init(), this.getXExpression(), null, "init", null, 0, 1, XForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopExpression_EachExpression(), this.getXExpression(), null, "eachExpression", null, 0, 1, XForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xForEachExpressionEClass, XForEachExpression.class, "XForEachExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXForEachExpression_ForExpression(), this.getXExpression(), null, "forExpression", null, 0, 1, XForEachExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForEachExpression_EachExpression(), this.getXExpression(), null, "eachExpression", null, 0, 1, XForEachExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForEachExpression_DeclaredParam(), theTypesPackage.getJvmFormalParameter(), null, "declaredParam", null, 0, 1, XForEachExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAbstractWhileExpressionEClass, XAbstractWhileExpression.class, "XAbstractWhileExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAbstractWhileExpression_Predicate(), this.getXExpression(), null, "predicate", null, 0, 1, XAbstractWhileExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractWhileExpression_Body(), this.getXExpression(), null, "body", null, 0, 1, XAbstractWhileExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xDoWhileExpressionEClass, XDoWhileExpression.class, "XDoWhileExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xWhileExpressionEClass, XWhileExpression.class, "XWhileExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xTypeLiteralEClass, XTypeLiteral.class, "XTypeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTypeLiteral_Type(), theTypesPackage.getJvmType(), null, "type", null, 1, 1, XTypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXTypeLiteral_ArrayDimensions(), ecorePackage.getEString(), "arrayDimensions", null, 0, -1, XTypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xInstanceOfExpressionEClass, XInstanceOfExpression.class, "XInstanceOfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXInstanceOfExpression_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXInstanceOfExpression_Expression(), this.getXExpression(), null, "expression", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xThrowExpressionEClass, XThrowExpression.class, "XThrowExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXThrowExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XThrowExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xTryCatchFinallyExpressionEClass, XTryCatchFinallyExpression.class, "XTryCatchFinallyExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTryCatchFinallyExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XTryCatchFinallyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTryCatchFinallyExpression_FinallyExpression(), this.getXExpression(), null, "finallyExpression", null, 0, 1, XTryCatchFinallyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTryCatchFinallyExpression_CatchClause(), this.getXCatchClause(), null, "catchClause", null, 0, 1, XTryCatchFinallyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCatchClauseEClass, XCatchClause.class, "XCatchClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCatchClause_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCatchClause_DeclaredParam(), theTypesPackage.getJvmFormalParameter(), null, "declaredParam", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXCatchClause_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAssignmentEClass, XAssignment.class, "XAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAssignment_Assignable(), this.getXExpression(), null, "assignable", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAssignment_Value(), this.getXExpression(), null, "value", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAssignment_ExplicitStatic(), ecorePackage.getEBoolean(), "explicitStatic", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAssignment_IndexedOperation(), ecorePackage.getEBoolean(), "indexedOperation", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAssignment_Index(), this.getXExpression(), null, "index", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xReturnExpressionEClass, XReturnExpression.class, "XReturnExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXReturnExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XReturnExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBreakExpressionEClass, XBreakExpression.class, "XBreakExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xContinueExpressionEClass, XContinueExpression.class, "XContinueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xPrefixOperationEClass, XPrefixOperation.class, "XPrefixOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXPrefixOperation_Operand(), this.getXExpression(), null, "operand", null, 0, 1, XPrefixOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xPostfixOperationEClass, XPostfixOperation.class, "XPostfixOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXPostfixOperation_Operand(), this.getXExpression(), null, "operand", null, 0, 1, XPostfixOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xTernaryOperationEClass, XTernaryOperation.class, "XTernaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTernaryOperation_TrueOperand(), this.getXExpression(), null, "trueOperand", null, 0, 1, XTernaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTernaryOperation_FalseOperand(), this.getXExpression(), null, "falseOperand", null, 0, 1, XTernaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTernaryOperation_Condition(), this.getXExpression(), null, "condition", null, 0, 1, XTernaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xIndexOperationEClass, XIndexOperation.class, "XIndexOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXIndexOperation_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XIndexOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIndexOperation_Index(), this.getXExpression(), null, "index", null, 1, 1, XIndexOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xFunctionDeclarationEClass, XFunctionDeclaration.class, "XFunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXFunctionDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionDeclaration_Body(), this.getXExpression(), null, "body", null, 0, 1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionDeclaration_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionDeclaration_Parameters(), theTypesPackage.getJvmFormalParameter(), null, "parameters", null, 0, -1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xObjectLiteralEClass, XObjectLiteral.class, "XObjectLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xObjectLiteralPartEClass, XObjectLiteralPart.class, "XObjectLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xArrayLiteralEClass, XArrayLiteral.class, "XArrayLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXArrayLiteral_Elements(), this.getXExpression(), null, "elements", null, 0, -1, XArrayLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xStructLiteralEClass, XStructLiteral.class, "XStructLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXStructLiteral_Properties(), this.getXFieldLiteralPart(), null, "properties", null, 0, -1, XStructLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXStructLiteral_Type(), theTypesPackage.getJvmDeclaredType(), null, "type", null, 0, 1, XStructLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXStructLiteral_TypeArguments(), theTypesPackage.getJvmTypeReference(), null, "typeArguments", null, 0, -1, XStructLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xFieldLiteralPartEClass, XFieldLiteralPart.class, "XFieldLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFieldLiteralPart_Field(), theTypesPackage.getJvmField(), null, "field", null, 0, 1, XFieldLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFieldLiteralPart_Value(), this.getXExpression(), null, "value", null, 0, 1, XFieldLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xTemplateEClass, XTemplate.class, "XTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(richStringLiteralEClass, RichStringLiteral.class, "RichStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //XbasePackageImpl
