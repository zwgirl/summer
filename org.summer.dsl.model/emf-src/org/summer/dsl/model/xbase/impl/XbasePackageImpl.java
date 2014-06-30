/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.impl.TypesPackageImpl;
import org.summer.dsl.model.xaml.XamlPackage;
import org.summer.dsl.model.xaml.impl.XamlPackageImpl;
import org.summer.dsl.model.xbase.RichStringLiteral;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAbstractWhileStatment;
import org.summer.dsl.model.xbase.XArgument;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XAssignment1;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XBreakStatment;
import org.summer.dsl.model.xbase.XCaller;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XCollectionLiteral;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueStatment;
import org.summer.dsl.model.xbase.XDoWhileStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XFieldLiteralPart;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XIndexer;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XListLiteral;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XObjectLiteralPart;
import org.summer.dsl.model.xbase.XParenthesizedExpression;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XSetLiteral;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XStructLiteral;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XTemplate;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileStatment;
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
	private EClass xStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xIfStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xExpressionStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xSwitchStatmentEClass = null;

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
	private EClass xBlockStatmentEClass = null;

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
	private EClass xCallerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xIndexerEClass = null;

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
	private EClass xForLoopStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xForEachStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAbstractWhileStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xDoWhileStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xWhileStatmentEClass = null;

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
	private EClass xThrowStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xTryCatchFinallyStatmentEClass = null;

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
	private EClass xReturnStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBreakStatmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xContinueStatmentEClass = null;

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
	private EClass xFunctionDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xParenthesizedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAssignment1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xArgumentEClass = null;

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
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);
		XamlPackageImpl theXamlPackage = (XamlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) instanceof XamlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XamlPackage.eNS_URI) : XamlPackage.eINSTANCE);

		// Create package meta-data objects
		theXbasePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theXtypePackage.createPackageContents();
		theXamlPackage.createPackageContents();

		// Initialize created meta-data
		theXbasePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theXtypePackage.initializePackageContents();
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
	public EClass getXStatment() {
		return xStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXIfStatment() {
		return xIfStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfStatment_If() {
		return (EReference)xIfStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfStatment_Then() {
		return (EReference)xIfStatmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfStatment_Else() {
		return (EReference)xIfStatmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXExpressionStatment() {
		return xExpressionStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXExpressionStatment_Expression() {
		return (EReference)xExpressionStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSwitchStatment() {
		return xSwitchStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchStatment_Switch() {
		return (EReference)xSwitchStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchStatment_Cases() {
		return (EReference)xSwitchStatmentEClass.getEStructuralFeatures().get(1);
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
	public EReference getXCasePart_Statments() {
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXCasePart_Default() {
		return (EAttribute)xCasePartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBlockStatment() {
		return xBlockStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBlockStatment_Statments() {
		return (EReference)xBlockStatmentEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getXVariableDeclaration_SimpleName() {
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
	public EReference getXVariableDeclarationList_Declarations() {
		return (EReference)xVariableDeclarationListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXVariableDeclarationList_Readonly() {
		return (EAttribute)xVariableDeclarationListEClass.getEStructuralFeatures().get(1);
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
	public EClass getXCaller() {
		return xCallerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCaller_Executable() {
		return (EReference)xCallerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCaller_Arguments() {
		return (EReference)xCallerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXIndexer() {
		return xIndexerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIndexer_Source() {
		return (EReference)xIndexerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIndexer_Arguments() {
		return (EReference)xIndexerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIndexer_Feature() {
		return (EReference)xIndexerEClass.getEStructuralFeatures().get(2);
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
	public EReference getXClosure_Statment() {
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
	public EAttribute getXClosure_ExplicitReturn() {
		return (EAttribute)xClosureEClass.getEStructuralFeatures().get(9);
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
	public EAttribute getXBinaryOperation_ReassignFirstArgument() {
		return (EAttribute)xBinaryOperationEClass.getEStructuralFeatures().get(2);
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
	public EClass getXForLoopStatment() {
		return xForLoopStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopStatment_Initial() {
		return (EReference)xForLoopStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopStatment_Condition() {
		return (EReference)xForLoopStatmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopStatment_Increment() {
		return (EReference)xForLoopStatmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopStatment_Statment() {
		return (EReference)xForLoopStatmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopStatment_VariableDeclarations() {
		return (EReference)xForLoopStatmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXForEachStatment() {
		return xForEachStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForEachStatment_DeclaredParam() {
		return (EReference)xForEachStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForEachStatment_Expression() {
		return (EReference)xForEachStatmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForEachStatment_Statment() {
		return (EReference)xForEachStatmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAbstractWhileStatment() {
		return xAbstractWhileStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractWhileStatment_Predicate() {
		return (EReference)xAbstractWhileStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractWhileStatment_Body() {
		return (EReference)xAbstractWhileStatmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXDoWhileStatment() {
		return xDoWhileStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXWhileStatment() {
		return xWhileStatmentEClass;
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
	public EClass getXThrowStatment() {
		return xThrowStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXThrowStatment_Expression() {
		return (EReference)xThrowStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTryCatchFinallyStatment() {
		return xTryCatchFinallyStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyStatment_Statment() {
		return (EReference)xTryCatchFinallyStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyStatment_FinallyStatment() {
		return (EReference)xTryCatchFinallyStatmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyStatment_CatchClause() {
		return (EReference)xTryCatchFinallyStatmentEClass.getEStructuralFeatures().get(2);
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
	public EReference getXCatchClause_Statment() {
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
	public EClass getXReturnStatment() {
		return xReturnStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXReturnStatment_Expression() {
		return (EReference)xReturnStatmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBreakStatment() {
		return xBreakStatmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXContinueStatment() {
		return xContinueStatmentEClass;
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
	public EClass getXFunctionDeclaration() {
		return xFunctionDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionDeclaration_DeclaredFormalParameters() {
		return (EReference)xFunctionDeclarationEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getXFunctionDeclaration_SimpleName() {
		return (EAttribute)xFunctionDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFunctionDeclaration_ReturnType() {
		return (EReference)xFunctionDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFunctionDeclaration_Exported() {
		return (EAttribute)xFunctionDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXParenthesizedExpression() {
		return xParenthesizedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXParenthesizedExpression_Expression() {
		return (EReference)xParenthesizedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAssignment1() {
		return xAssignment1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment1_Assignable() {
		return (EReference)xAssignment1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment1_Value() {
		return (EReference)xAssignment1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXArgument() {
		return xArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXArgument_Ref() {
		return (EAttribute)xArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXArgument_Out() {
		return (EAttribute)xArgumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXArgument_Expression() {
		return (EReference)xArgumentEClass.getEStructuralFeatures().get(2);
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
	public EReference getXTemplate_Expressions() {
		return (EReference)xTemplateEClass.getEStructuralFeatures().get(0);
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

		xStatmentEClass = createEClass(XSTATMENT);

		xIfStatmentEClass = createEClass(XIF_STATMENT);
		createEReference(xIfStatmentEClass, XIF_STATMENT__IF);
		createEReference(xIfStatmentEClass, XIF_STATMENT__THEN);
		createEReference(xIfStatmentEClass, XIF_STATMENT__ELSE);

		xExpressionStatmentEClass = createEClass(XEXPRESSION_STATMENT);
		createEReference(xExpressionStatmentEClass, XEXPRESSION_STATMENT__EXPRESSION);

		xSwitchStatmentEClass = createEClass(XSWITCH_STATMENT);
		createEReference(xSwitchStatmentEClass, XSWITCH_STATMENT__SWITCH);
		createEReference(xSwitchStatmentEClass, XSWITCH_STATMENT__CASES);

		xCasePartEClass = createEClass(XCASE_PART);
		createEReference(xCasePartEClass, XCASE_PART__CASE);
		createEReference(xCasePartEClass, XCASE_PART__STATMENTS);
		createEAttribute(xCasePartEClass, XCASE_PART__DEFAULT);

		xBlockStatmentEClass = createEClass(XBLOCK_STATMENT);
		createEReference(xBlockStatmentEClass, XBLOCK_STATMENT__STATMENTS);

		xVariableDeclarationEClass = createEClass(XVARIABLE_DECLARATION);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__TYPE);
		createEAttribute(xVariableDeclarationEClass, XVARIABLE_DECLARATION__SIMPLE_NAME);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__RIGHT);

		xVariableDeclarationListEClass = createEClass(XVARIABLE_DECLARATION_LIST);
		createEReference(xVariableDeclarationListEClass, XVARIABLE_DECLARATION_LIST__DECLARATIONS);
		createEAttribute(xVariableDeclarationListEClass, XVARIABLE_DECLARATION_LIST__READONLY);
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

		xCallerEClass = createEClass(XCALLER);
		createEReference(xCallerEClass, XCALLER__EXECUTABLE);
		createEReference(xCallerEClass, XCALLER__ARGUMENTS);

		xIndexerEClass = createEClass(XINDEXER);
		createEReference(xIndexerEClass, XINDEXER__SOURCE);
		createEReference(xIndexerEClass, XINDEXER__ARGUMENTS);
		createEReference(xIndexerEClass, XINDEXER__FEATURE);

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

		xSetLiteralEClass = createEClass(XSET_LITERAL);

		xClosureEClass = createEClass(XCLOSURE);
		createEReference(xClosureEClass, XCLOSURE__DECLARED_FORMAL_PARAMETERS);
		createEReference(xClosureEClass, XCLOSURE__STATMENT);
		createEAttribute(xClosureEClass, XCLOSURE__EXPLICIT_SYNTAX);
		createEReference(xClosureEClass, XCLOSURE__IMPLICIT_PARAMETER);
		createEAttribute(xClosureEClass, XCLOSURE__NAME);
		createEReference(xClosureEClass, XCLOSURE__RETURN_TYPE);
		createEAttribute(xClosureEClass, XCLOSURE__OPERATOR);
		createEReference(xClosureEClass, XCLOSURE__TYPE_PARAMETERS);
		createEAttribute(xClosureEClass, XCLOSURE__EXPORTED);
		createEAttribute(xClosureEClass, XCLOSURE__EXPLICIT_RETURN);

		xCastedExpressionEClass = createEClass(XCASTED_EXPRESSION);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TYPE);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TARGET);

		xBinaryOperationEClass = createEClass(XBINARY_OPERATION);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__LEFT_OPERAND);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__RIGHT_OPERAND);
		createEAttribute(xBinaryOperationEClass, XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT);

		xUnaryOperationEClass = createEClass(XUNARY_OPERATION);
		createEReference(xUnaryOperationEClass, XUNARY_OPERATION__OPERAND);

		xForLoopStatmentEClass = createEClass(XFOR_LOOP_STATMENT);
		createEReference(xForLoopStatmentEClass, XFOR_LOOP_STATMENT__INITIAL);
		createEReference(xForLoopStatmentEClass, XFOR_LOOP_STATMENT__VARIABLE_DECLARATIONS);
		createEReference(xForLoopStatmentEClass, XFOR_LOOP_STATMENT__CONDITION);
		createEReference(xForLoopStatmentEClass, XFOR_LOOP_STATMENT__INCREMENT);
		createEReference(xForLoopStatmentEClass, XFOR_LOOP_STATMENT__STATMENT);

		xForEachStatmentEClass = createEClass(XFOR_EACH_STATMENT);
		createEReference(xForEachStatmentEClass, XFOR_EACH_STATMENT__DECLARED_PARAM);
		createEReference(xForEachStatmentEClass, XFOR_EACH_STATMENT__EXPRESSION);
		createEReference(xForEachStatmentEClass, XFOR_EACH_STATMENT__STATMENT);

		xAbstractWhileStatmentEClass = createEClass(XABSTRACT_WHILE_STATMENT);
		createEReference(xAbstractWhileStatmentEClass, XABSTRACT_WHILE_STATMENT__PREDICATE);
		createEReference(xAbstractWhileStatmentEClass, XABSTRACT_WHILE_STATMENT__BODY);

		xDoWhileStatmentEClass = createEClass(XDO_WHILE_STATMENT);

		xWhileStatmentEClass = createEClass(XWHILE_STATMENT);

		xTypeLiteralEClass = createEClass(XTYPE_LITERAL);
		createEReference(xTypeLiteralEClass, XTYPE_LITERAL__TYPE);
		createEAttribute(xTypeLiteralEClass, XTYPE_LITERAL__ARRAY_DIMENSIONS);

		xInstanceOfExpressionEClass = createEClass(XINSTANCE_OF_EXPRESSION);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__TYPE);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__EXPRESSION);

		xThrowStatmentEClass = createEClass(XTHROW_STATMENT);
		createEReference(xThrowStatmentEClass, XTHROW_STATMENT__EXPRESSION);

		xTryCatchFinallyStatmentEClass = createEClass(XTRY_CATCH_FINALLY_STATMENT);
		createEReference(xTryCatchFinallyStatmentEClass, XTRY_CATCH_FINALLY_STATMENT__STATMENT);
		createEReference(xTryCatchFinallyStatmentEClass, XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT);
		createEReference(xTryCatchFinallyStatmentEClass, XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE);

		xCatchClauseEClass = createEClass(XCATCH_CLAUSE);
		createEReference(xCatchClauseEClass, XCATCH_CLAUSE__STATMENT);
		createEReference(xCatchClauseEClass, XCATCH_CLAUSE__DECLARED_PARAM);
		createEAttribute(xCatchClauseEClass, XCATCH_CLAUSE__IDENTIFIER);

		xAssignmentEClass = createEClass(XASSIGNMENT);
		createEReference(xAssignmentEClass, XASSIGNMENT__ASSIGNABLE);
		createEReference(xAssignmentEClass, XASSIGNMENT__VALUE);
		createEAttribute(xAssignmentEClass, XASSIGNMENT__EXPLICIT_STATIC);
		createEAttribute(xAssignmentEClass, XASSIGNMENT__INDEXED_OPERATION);
		createEReference(xAssignmentEClass, XASSIGNMENT__INDEX);

		xReturnStatmentEClass = createEClass(XRETURN_STATMENT);
		createEReference(xReturnStatmentEClass, XRETURN_STATMENT__EXPRESSION);

		xBreakStatmentEClass = createEClass(XBREAK_STATMENT);

		xContinueStatmentEClass = createEClass(XCONTINUE_STATMENT);

		xPostfixOperationEClass = createEClass(XPOSTFIX_OPERATION);
		createEReference(xPostfixOperationEClass, XPOSTFIX_OPERATION__OPERAND);

		xTernaryOperationEClass = createEClass(XTERNARY_OPERATION);
		createEReference(xTernaryOperationEClass, XTERNARY_OPERATION__TRUE_OPERAND);
		createEReference(xTernaryOperationEClass, XTERNARY_OPERATION__FALSE_OPERAND);
		createEReference(xTernaryOperationEClass, XTERNARY_OPERATION__CONDITION);

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
		createEReference(xTemplateEClass, XTEMPLATE__EXPRESSIONS);

		richStringLiteralEClass = createEClass(RICH_STRING_LITERAL);

		xFunctionDeclarationEClass = createEClass(XFUNCTION_DECLARATION);
		createEReference(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__DECLARED_FORMAL_PARAMETERS);
		createEReference(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__BODY);
		createEAttribute(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__SIMPLE_NAME);
		createEReference(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__RETURN_TYPE);
		createEAttribute(xFunctionDeclarationEClass, XFUNCTION_DECLARATION__EXPORTED);

		xParenthesizedExpressionEClass = createEClass(XPARENTHESIZED_EXPRESSION);
		createEReference(xParenthesizedExpressionEClass, XPARENTHESIZED_EXPRESSION__EXPRESSION);

		xAssignment1EClass = createEClass(XASSIGNMENT1);
		createEReference(xAssignment1EClass, XASSIGNMENT1__ASSIGNABLE);
		createEReference(xAssignment1EClass, XASSIGNMENT1__VALUE);

		xArgumentEClass = createEClass(XARGUMENT);
		createEAttribute(xArgumentEClass, XARGUMENT__REF);
		createEAttribute(xArgumentEClass, XARGUMENT__OUT);
		createEReference(xArgumentEClass, XARGUMENT__EXPRESSION);
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
		xIfStatmentEClass.getESuperTypes().add(this.getXStatment());
		xExpressionStatmentEClass.getESuperTypes().add(this.getXStatment());
		xSwitchStatmentEClass.getESuperTypes().add(this.getXStatment());
		xBlockStatmentEClass.getESuperTypes().add(this.getXExpression());
		xBlockStatmentEClass.getESuperTypes().add(this.getXStatment());
		xVariableDeclarationEClass.getESuperTypes().add(this.getXExpression());
		xVariableDeclarationEClass.getESuperTypes().add(theTypesPackage.getJvmIdentifiableElement());
		xVariableDeclarationListEClass.getESuperTypes().add(this.getXStatment());
		xAbstractFeatureCallEClass.getESuperTypes().add(this.getXExpression());
		xMemberFeatureCallEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xCallerEClass.getESuperTypes().add(this.getXExpression());
		xIndexerEClass.getESuperTypes().add(this.getXExpression());
		xFeatureCallEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xConstructorCallEClass.getESuperTypes().add(this.getXExpression());
		xBooleanLiteralEClass.getESuperTypes().add(this.getXExpression());
		xNullLiteralEClass.getESuperTypes().add(this.getXExpression());
		xNumberLiteralEClass.getESuperTypes().add(this.getXExpression());
		xStringLiteralEClass.getESuperTypes().add(this.getXExpression());
		xCollectionLiteralEClass.getESuperTypes().add(this.getXExpression());
		xListLiteralEClass.getESuperTypes().add(this.getXCollectionLiteral());
		xSetLiteralEClass.getESuperTypes().add(this.getXCollectionLiteral());
		xClosureEClass.getESuperTypes().add(this.getXExpression());
		xClosureEClass.getESuperTypes().add(theTypesPackage.getJvmIdentifiableElement());
		xCastedExpressionEClass.getESuperTypes().add(this.getXExpression());
		xBinaryOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xUnaryOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xForLoopStatmentEClass.getESuperTypes().add(this.getXStatment());
		xForEachStatmentEClass.getESuperTypes().add(this.getXStatment());
		xAbstractWhileStatmentEClass.getESuperTypes().add(this.getXStatment());
		xDoWhileStatmentEClass.getESuperTypes().add(this.getXAbstractWhileStatment());
		xWhileStatmentEClass.getESuperTypes().add(this.getXAbstractWhileStatment());
		xTypeLiteralEClass.getESuperTypes().add(this.getXExpression());
		xInstanceOfExpressionEClass.getESuperTypes().add(this.getXExpression());
		xThrowStatmentEClass.getESuperTypes().add(this.getXStatment());
		xTryCatchFinallyStatmentEClass.getESuperTypes().add(this.getXStatment());
		xAssignmentEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xReturnStatmentEClass.getESuperTypes().add(this.getXStatment());
		xBreakStatmentEClass.getESuperTypes().add(this.getXStatment());
		xContinueStatmentEClass.getESuperTypes().add(this.getXStatment());
		xPostfixOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xTernaryOperationEClass.getESuperTypes().add(this.getXExpression());
		xObjectLiteralEClass.getESuperTypes().add(theTypesPackage.getJvmDeclaredType());
		xObjectLiteralEClass.getESuperTypes().add(this.getXExpression());
		xObjectLiteralPartEClass.getESuperTypes().add(theTypesPackage.getJvmField());
		xArrayLiteralEClass.getESuperTypes().add(this.getXExpression());
		xStructLiteralEClass.getESuperTypes().add(this.getXExpression());
		xTemplateEClass.getESuperTypes().add(this.getXExpression());
		richStringLiteralEClass.getESuperTypes().add(this.getXStringLiteral());
		xFunctionDeclarationEClass.getESuperTypes().add(theTypesPackage.getJvmTypeParameterDeclarator());
		xFunctionDeclarationEClass.getESuperTypes().add(this.getXStatment());
		xFunctionDeclarationEClass.getESuperTypes().add(theTypesPackage.getJvmIdentifiableElement());
		xParenthesizedExpressionEClass.getESuperTypes().add(this.getXExpression());
		xAssignment1EClass.getESuperTypes().add(this.getXExpression());
		xArgumentEClass.getESuperTypes().add(this.getXExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(xExpressionEClass, XExpression.class, "XExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xStatmentEClass, XStatment.class, "XStatment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xIfStatmentEClass, XIfStatment.class, "XIfStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXIfStatment_If(), this.getXExpression(), null, "if", null, 0, 1, XIfStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfStatment_Then(), this.getXStatment(), null, "then", null, 0, 1, XIfStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfStatment_Else(), this.getXStatment(), null, "else", null, 0, 1, XIfStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xExpressionStatmentEClass, XExpressionStatment.class, "XExpressionStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXExpressionStatment_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XExpressionStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xSwitchStatmentEClass, XSwitchStatment.class, "XSwitchStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSwitchStatment_Switch(), this.getXExpression(), null, "switch", null, 0, 1, XSwitchStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchStatment_Cases(), this.getXCasePart(), null, "cases", null, 0, -1, XSwitchStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCasePartEClass, XCasePart.class, "XCasePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCasePart_Case(), this.getXExpression(), null, "case", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCasePart_Statments(), this.getXStatment(), null, "statments", null, 0, -1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXCasePart_Default(), ecorePackage.getEBoolean(), "default", "false", 0, 1, XCasePart.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(xBlockStatmentEClass, XBlockStatment.class, "XBlockStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBlockStatment_Statments(), this.getXStatment(), null, "statments", null, 0, -1, XBlockStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xVariableDeclarationEClass, XVariableDeclaration.class, "XVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXVariableDeclaration_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclaration_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXVariableDeclaration_Right(), this.getXExpression(), null, "right", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xVariableDeclarationEClass, ecorePackage.getEBoolean(), "isReadonly", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xVariableDeclarationListEClass, XVariableDeclarationList.class, "XVariableDeclarationList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXVariableDeclarationList_Declarations(), this.getXExpression(), null, "declarations", null, 0, -1, XVariableDeclarationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclarationList_Readonly(), ecorePackage.getEBoolean(), "readonly", "true", 0, 1, XVariableDeclarationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isOperation", 0, 1, IS_UNIQUE, IS_ORDERED);

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

		initEClass(xCallerEClass, XCaller.class, "XCaller", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCaller_Executable(), this.getXExpression(), null, "executable", null, 0, 1, XCaller.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCaller_Arguments(), this.getXExpression(), null, "arguments", null, 0, -1, XCaller.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xIndexerEClass, XIndexer.class, "XIndexer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXIndexer_Source(), this.getXExpression(), null, "source", null, 0, 1, XIndexer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIndexer_Arguments(), this.getXExpression(), null, "arguments", null, 0, -1, XIndexer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIndexer_Feature(), theTypesPackage.getJvmIdentifiableElement(), null, "feature", null, 0, 1, XIndexer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(xSetLiteralEClass, XSetLiteral.class, "XSetLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xClosureEClass, XClosure.class, "XClosure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXClosure_DeclaredFormalParameters(), theTypesPackage.getJvmFormalParameter(), null, "declaredFormalParameters", null, 0, -1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_Statment(), this.getXStatment(), null, "statment", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_ExplicitSyntax(), ecorePackage.getEBoolean(), "explicitSyntax", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_ImplicitParameter(), theTypesPackage.getJvmFormalParameter(), null, "implicitParameter", null, 0, 1, XClosure.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_Name(), ecorePackage.getEString(), "name", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_Operator(), ecorePackage.getEBoolean(), "operator", "false", 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_TypeParameters(), theTypesPackage.getJvmTypeParameter(), null, "typeParameters", null, 0, -1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_Exported(), ecorePackage.getEBoolean(), "exported", "false", 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_ExplicitReturn(), ecorePackage.getEBoolean(), "explicitReturn", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xClosureEClass, theTypesPackage.getJvmFormalParameter(), "getFormalParameters", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(xCastedExpressionEClass, XCastedExpression.class, "XCastedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCastedExpression_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCastedExpression_Target(), this.getXExpression(), null, "target", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBinaryOperationEClass, XBinaryOperation.class, "XBinaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBinaryOperation_LeftOperand(), this.getXExpression(), null, "leftOperand", null, 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXBinaryOperation_RightOperand(), this.getXExpression(), null, "rightOperand", null, 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXBinaryOperation_ReassignFirstArgument(), ecorePackage.getEBoolean(), "reassignFirstArgument", "false", 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xUnaryOperationEClass, XUnaryOperation.class, "XUnaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXUnaryOperation_Operand(), this.getXExpression(), null, "operand", null, 0, 1, XUnaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xForLoopStatmentEClass, XForLoopStatment.class, "XForLoopStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXForLoopStatment_Initial(), this.getXExpression(), null, "initial", null, 0, 1, XForLoopStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopStatment_VariableDeclarations(), this.getXExpression(), null, "variableDeclarations", null, 0, -1, XForLoopStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopStatment_Condition(), this.getXExpression(), null, "condition", null, 0, 1, XForLoopStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopStatment_Increment(), this.getXExpression(), null, "increment", null, 0, 1, XForLoopStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopStatment_Statment(), this.getXStatment(), null, "statment", null, 0, 1, XForLoopStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xForEachStatmentEClass, XForEachStatment.class, "XForEachStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXForEachStatment_DeclaredParam(), theTypesPackage.getJvmFormalParameter(), null, "declaredParam", null, 0, 1, XForEachStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForEachStatment_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XForEachStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForEachStatment_Statment(), this.getXStatment(), null, "statment", null, 0, 1, XForEachStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAbstractWhileStatmentEClass, XAbstractWhileStatment.class, "XAbstractWhileStatment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAbstractWhileStatment_Predicate(), this.getXExpression(), null, "predicate", null, 0, 1, XAbstractWhileStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractWhileStatment_Body(), this.getXStatment(), null, "body", null, 0, 1, XAbstractWhileStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xDoWhileStatmentEClass, XDoWhileStatment.class, "XDoWhileStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xWhileStatmentEClass, XWhileStatment.class, "XWhileStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xTypeLiteralEClass, XTypeLiteral.class, "XTypeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTypeLiteral_Type(), theTypesPackage.getJvmType(), null, "type", null, 1, 1, XTypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXTypeLiteral_ArrayDimensions(), ecorePackage.getEString(), "arrayDimensions", null, 0, -1, XTypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xInstanceOfExpressionEClass, XInstanceOfExpression.class, "XInstanceOfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXInstanceOfExpression_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXInstanceOfExpression_Expression(), this.getXExpression(), null, "expression", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xThrowStatmentEClass, XThrowStatment.class, "XThrowStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXThrowStatment_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XThrowStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xTryCatchFinallyStatmentEClass, XTryCatchFinallyStatment.class, "XTryCatchFinallyStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTryCatchFinallyStatment_Statment(), this.getXStatment(), null, "statment", null, 0, 1, XTryCatchFinallyStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTryCatchFinallyStatment_FinallyStatment(), this.getXStatment(), null, "finallyStatment", null, 0, 1, XTryCatchFinallyStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTryCatchFinallyStatment_CatchClause(), this.getXCatchClause(), null, "catchClause", null, 0, 1, XTryCatchFinallyStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCatchClauseEClass, XCatchClause.class, "XCatchClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCatchClause_Statment(), this.getXStatment(), null, "statment", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCatchClause_DeclaredParam(), theTypesPackage.getJvmFormalParameter(), null, "declaredParam", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXCatchClause_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAssignmentEClass, XAssignment.class, "XAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAssignment_Assignable(), this.getXExpression(), null, "assignable", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAssignment_Value(), this.getXExpression(), null, "value", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAssignment_ExplicitStatic(), ecorePackage.getEBoolean(), "explicitStatic", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAssignment_IndexedOperation(), ecorePackage.getEBoolean(), "indexedOperation", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAssignment_Index(), this.getXExpression(), null, "index", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xReturnStatmentEClass, XReturnStatment.class, "XReturnStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXReturnStatment_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XReturnStatment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBreakStatmentEClass, XBreakStatment.class, "XBreakStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xContinueStatmentEClass, XContinueStatment.class, "XContinueStatment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xPostfixOperationEClass, XPostfixOperation.class, "XPostfixOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXPostfixOperation_Operand(), this.getXExpression(), null, "operand", null, 0, 1, XPostfixOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xTernaryOperationEClass, XTernaryOperation.class, "XTernaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTernaryOperation_TrueOperand(), this.getXExpression(), null, "trueOperand", null, 0, 1, XTernaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTernaryOperation_FalseOperand(), this.getXExpression(), null, "falseOperand", null, 0, 1, XTernaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTernaryOperation_Condition(), this.getXExpression(), null, "condition", null, 0, 1, XTernaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getXTemplate_Expressions(), this.getXExpression(), null, "expressions", null, 0, -1, XTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(richStringLiteralEClass, RichStringLiteral.class, "RichStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xFunctionDeclarationEClass, XFunctionDeclaration.class, "XFunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFunctionDeclaration_DeclaredFormalParameters(), theTypesPackage.getJvmFormalParameter(), null, "declaredFormalParameters", null, 0, -1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionDeclaration_Body(), this.getXStatment(), null, "body", null, 0, 1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFunctionDeclaration_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFunctionDeclaration_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFunctionDeclaration_Exported(), ecorePackage.getEBoolean(), "exported", "false", 0, 1, XFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xFunctionDeclarationEClass, theTypesPackage.getJvmFormalParameter(), "getFormalParameters", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(xParenthesizedExpressionEClass, XParenthesizedExpression.class, "XParenthesizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXParenthesizedExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAssignment1EClass, XAssignment1.class, "XAssignment1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAssignment1_Assignable(), this.getXExpression(), null, "assignable", null, 0, 1, XAssignment1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAssignment1_Value(), this.getXExpression(), null, "value", null, 0, 1, XAssignment1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xArgumentEClass, XArgument.class, "XArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXArgument_Ref(), ecorePackage.getEBoolean(), "ref", "false", 0, 1, XArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXArgument_Out(), ecorePackage.getEBoolean(), "out", "false", 0, 1, XArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXArgument_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XbasePackageImpl
