/**
 */
package org.summer.dsl.model.ss.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.summer.dsl.model.ss.*;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForEachExpression;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XVariableDeclaration;

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
 * @see org.summer.dsl.model.ss.SsPackage
 * @generated
 */
public class SsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsSwitch() {
		if (modelPackage == null) {
			modelPackage = SsPackage.eINSTANCE;
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
			case SsPackage.XMODULE: {
				XModule xModule = (XModule)theEObject;
				T result = caseXModule(xModule);
				if (result == null) result = caseJvmType(xModule);
				if (result == null) result = caseJvmIdentifiableElement(xModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_CLASS: {
				XtendClass xtendClass = (XtendClass)theEObject;
				T result = caseXtendClass(xtendClass);
				if (result == null) result = caseXtendTypeDeclaration(xtendClass);
				if (result == null) result = caseXtendMember(xtendClass);
				if (result == null) result = caseXtendAnnotationTarget(xtendClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_ANNOTATION_TARGET: {
				XtendAnnotationTarget xtendAnnotationTarget = (XtendAnnotationTarget)theEObject;
				T result = caseXtendAnnotationTarget(xtendAnnotationTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_MEMBER: {
				XtendMember xtendMember = (XtendMember)theEObject;
				T result = caseXtendMember(xtendMember);
				if (result == null) result = caseXtendAnnotationTarget(xtendMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_FUNCTION: {
				XtendFunction xtendFunction = (XtendFunction)theEObject;
				T result = caseXtendFunction(xtendFunction);
				if (result == null) result = caseXtendMember(xtendFunction);
				if (result == null) result = caseXtendAnnotationTarget(xtendFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_FIELD: {
				XtendField xtendField = (XtendField)theEObject;
				T result = caseXtendField(xtendField);
				if (result == null) result = caseXtendMember(xtendField);
				if (result == null) result = caseXtendAnnotationTarget(xtendField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_PARAMETER: {
				XtendParameter xtendParameter = (XtendParameter)theEObject;
				T result = caseXtendParameter(xtendParameter);
				if (result == null) result = caseXtendAnnotationTarget(xtendParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.RICH_STRING: {
				RichString richString = (RichString)theEObject;
				T result = caseRichString(richString);
				if (result == null) result = caseXBlockExpression(richString);
				if (result == null) result = caseXExpression(richString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.RICH_STRING_LITERAL: {
				RichStringLiteral richStringLiteral = (RichStringLiteral)theEObject;
				T result = caseRichStringLiteral(richStringLiteral);
				if (result == null) result = caseXStringLiteral(richStringLiteral);
				if (result == null) result = caseXExpression(richStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.RICH_STRING_FOR_LOOP: {
				RichStringForLoop richStringForLoop = (RichStringForLoop)theEObject;
				T result = caseRichStringForLoop(richStringForLoop);
				if (result == null) result = caseXForEachExpression(richStringForLoop);
				if (result == null) result = caseXExpression(richStringForLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.RICH_STRING_IF: {
				RichStringIf richStringIf = (RichStringIf)theEObject;
				T result = caseRichStringIf(richStringIf);
				if (result == null) result = caseXExpression(richStringIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.RICH_STRING_ELSE_IF: {
				RichStringElseIf richStringElseIf = (RichStringElseIf)theEObject;
				T result = caseRichStringElseIf(richStringElseIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.CREATE_EXTENSION_INFO: {
				CreateExtensionInfo createExtensionInfo = (CreateExtensionInfo)theEObject;
				T result = caseCreateExtensionInfo(createExtensionInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_CONSTRUCTOR: {
				XtendConstructor xtendConstructor = (XtendConstructor)theEObject;
				T result = caseXtendConstructor(xtendConstructor);
				if (result == null) result = caseXtendMember(xtendConstructor);
				if (result == null) result = caseXtendAnnotationTarget(xtendConstructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_TYPE_DECLARATION: {
				XtendTypeDeclaration xtendTypeDeclaration = (XtendTypeDeclaration)theEObject;
				T result = caseXtendTypeDeclaration(xtendTypeDeclaration);
				if (result == null) result = caseXtendMember(xtendTypeDeclaration);
				if (result == null) result = caseXtendAnnotationTarget(xtendTypeDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_ANNOTATION_TYPE: {
				XtendAnnotationType xtendAnnotationType = (XtendAnnotationType)theEObject;
				T result = caseXtendAnnotationType(xtendAnnotationType);
				if (result == null) result = caseXtendTypeDeclaration(xtendAnnotationType);
				if (result == null) result = caseXtendMember(xtendAnnotationType);
				if (result == null) result = caseXtendAnnotationTarget(xtendAnnotationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_INTERFACE: {
				XtendInterface xtendInterface = (XtendInterface)theEObject;
				T result = caseXtendInterface(xtendInterface);
				if (result == null) result = caseXtendTypeDeclaration(xtendInterface);
				if (result == null) result = caseXtendMember(xtendInterface);
				if (result == null) result = caseXtendAnnotationTarget(xtendInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_ENUM: {
				XtendEnum xtendEnum = (XtendEnum)theEObject;
				T result = caseXtendEnum(xtendEnum);
				if (result == null) result = caseXtendTypeDeclaration(xtendEnum);
				if (result == null) result = caseXtendMember(xtendEnum);
				if (result == null) result = caseXtendAnnotationTarget(xtendEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_ENUM_LITERAL: {
				XtendEnumLiteral xtendEnumLiteral = (XtendEnumLiteral)theEObject;
				T result = caseXtendEnumLiteral(xtendEnumLiteral);
				if (result == null) result = caseXtendMember(xtendEnumLiteral);
				if (result == null) result = caseXtendAnnotationTarget(xtendEnumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_VARIABLE_DECLARATION: {
				XtendVariableDeclaration xtendVariableDeclaration = (XtendVariableDeclaration)theEObject;
				T result = caseXtendVariableDeclaration(xtendVariableDeclaration);
				if (result == null) result = caseXVariableDeclaration(xtendVariableDeclaration);
				if (result == null) result = caseXExpression(xtendVariableDeclaration);
				if (result == null) result = caseJvmIdentifiableElement(xtendVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_FORMAL_PARAMETER: {
				XtendFormalParameter xtendFormalParameter = (XtendFormalParameter)theEObject;
				T result = caseXtendFormalParameter(xtendFormalParameter);
				if (result == null) result = caseJvmFormalParameter(xtendFormalParameter);
				if (result == null) result = caseJvmAnnotationTarget(xtendFormalParameter);
				if (result == null) result = caseJvmIdentifiableElement(xtendFormalParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_DELEGATE: {
				XtendDelegate xtendDelegate = (XtendDelegate)theEObject;
				T result = caseXtendDelegate(xtendDelegate);
				if (result == null) result = caseXtendTypeDeclaration(xtendDelegate);
				if (result == null) result = caseXtendMember(xtendDelegate);
				if (result == null) result = caseXtendAnnotationTarget(xtendDelegate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SsPackage.XTEND_EVENT: {
				XtendEvent xtendEvent = (XtendEvent)theEObject;
				T result = caseXtendEvent(xtendEvent);
				if (result == null) result = caseXtendMember(xtendEvent);
				if (result == null) result = caseXtendAnnotationTarget(xtendEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XModule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XModule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXModule(XModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendClass(XtendClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendAnnotationTarget(XtendAnnotationTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendMember(XtendMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendFunction(XtendFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendField(XtendField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendParameter(XtendParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichString(RichString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringLiteral(RichStringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String For Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String For Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringForLoop(RichStringForLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringIf(RichStringIf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String Else If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String Else If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringElseIf(RichStringElseIf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Extension Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Extension Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateExtensionInfo(CreateExtensionInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendConstructor(XtendConstructor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Type Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendTypeDeclaration(XtendTypeDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Annotation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Annotation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendAnnotationType(XtendAnnotationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendInterface(XtendInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendEnum(XtendEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendEnumLiteral(XtendEnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendVariableDeclaration(XtendVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendFormalParameter(XtendFormalParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Delegate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Delegate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendDelegate(XtendDelegate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendEvent(XtendEvent object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>XBlock Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBlock Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBlockExpression(XBlockExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXStringLiteral(XStringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFor Each Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFor Each Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXForEachExpression(XForEachExpression object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmType(JvmType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXVariableDeclaration(XVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationTarget(JvmAnnotationTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmFormalParameter(JvmFormalParameter object) {
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

} //SsSwitch
