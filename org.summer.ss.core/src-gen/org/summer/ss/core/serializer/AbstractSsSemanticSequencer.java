package org.summer.ss.core.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmBeanType;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDelegateType;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmEvent;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmRemoteType;
import org.summer.dsl.model.types.JvmStructType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xaml.XAttachAttribute;
import org.summer.dsl.model.xaml.XAttributeElement;
import org.summer.dsl.model.xaml.XGeneralAttribute;
import org.summer.dsl.model.xaml.XMarkupExtenson;
import org.summer.dsl.model.xaml.XObjectElement;
import org.summer.dsl.model.xaml.XamlPackage;
import org.summer.dsl.model.xbase.RichStringLiteral;
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
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueStatment;
import org.summer.dsl.model.xbase.XDoWhileStatment;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XFieldLiteralPart;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XIndexer;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XObjectLiteralPart;
import org.summer.dsl.model.xbase.XParenthesizedExpression;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XReturnStatment;
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
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportItem;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.model.xtype.XtypePackage;
import org.summer.dsl.xbase.serializer.XbaseSemanticSequencer;
import org.summer.ss.core.services.SsGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractSsSemanticSequencer extends XbaseSemanticSequencer {

	@Inject
	private SsGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_ANNOTATION_REFERENCE:
				if(context == grammarAccess.getJvmAnnotationRule()) {
					sequence_JvmAnnotation(context, (JvmAnnotationReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_ANNOTATION_TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (JvmAnnotationType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_ANNOTATION_VALUE:
				if(context == grammarAccess.getJvmAnnotationValueRule()) {
					sequence_JvmAnnotationValue(context, (JvmAnnotationValue) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_BEAN_TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (JvmBeanType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_CONSTRUCTOR:
				if(context == grammarAccess.getMemberRule()) {
					sequence_Member(context, (JvmConstructor) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_DECLARED_TYPE:
				if(context == grammarAccess.getTypeAccess().getJvmAnnotationTypeAnnotationInfoAction_2_6_0() ||
				   context == grammarAccess.getTypeAccess().getJvmBeanTypeAnnotationInfoAction_2_3_0() ||
				   context == grammarAccess.getTypeAccess().getJvmEnumerationTypeAnnotationInfoAction_2_5_0() ||
				   context == grammarAccess.getTypeAccess().getJvmGenericTypeAnnotationInfoAction_2_0_0() ||
				   context == grammarAccess.getTypeAccess().getJvmInterfaceTypeAnnotationInfoAction_2_1_0() ||
				   context == grammarAccess.getTypeAccess().getJvmRemoteTypeAnnotationInfoAction_2_2_0() ||
				   context == grammarAccess.getTypeAccess().getJvmStructTypeAnnotationInfoAction_2_4_0()) {
					sequence_Type_JvmAnnotationType_2_6_0_JvmBeanType_2_3_0_JvmEnumerationType_2_5_0_JvmGenericType_2_0_0_JvmInterfaceType_2_1_0_JvmRemoteType_2_2_0_JvmStructType_2_4_0(context, (JvmDeclaredType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_DELEGATE_TYPE:
				if(context == grammarAccess.getDelegateTypeRule()) {
					sequence_DelegateType(context, (JvmDelegateType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_ENUMERATION_LITERAL:
				if(context == grammarAccess.getJvmEnumerationLiteralRule()) {
					sequence_JvmEnumerationLiteral(context, (JvmEnumerationLiteral) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_ENUMERATION_TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (JvmEnumerationType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_EVENT:
				if(context == grammarAccess.getMemberRule()) {
					sequence_Member(context, (JvmEvent) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_FIELD:
				if(context == grammarAccess.getAnnotationFieldRule()) {
					sequence_AnnotationField(context, (JvmField) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMemberRule()) {
					sequence_Member(context, (JvmField) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if(context == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (JvmGenericType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_INTERFACE_TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (JvmInterfaceType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_LOWER_BOUND:
				if(context == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_MEMBER:
				if(context == grammarAccess.getMemberAccess().getJvmConstructorAnnotationInfoAction_2_2_0() ||
				   context == grammarAccess.getMemberAccess().getJvmEventAnnotationInfoAction_2_3_0() ||
				   context == grammarAccess.getMemberAccess().getJvmFieldAnnotationInfoAction_2_0_0() ||
				   context == grammarAccess.getMemberAccess().getJvmOperationAnnotationInfoAction_2_1_0()) {
					sequence_Member_JvmConstructor_2_2_0_JvmEvent_2_3_0_JvmField_2_0_0_JvmOperation_2_1_0(context, (JvmMember) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_MODULE:
				if(context == grammarAccess.getJvmModuleRule()) {
					sequence_JvmModule(context, (JvmModule) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_OPERATION:
				if(context == grammarAccess.getMemberRule()) {
					sequence_Member(context, (JvmOperation) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_REMOTE_TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (JvmRemoteType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_STRUCT_TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (JvmStructType) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				if(context == grammarAccess.getJvmTypeParameterRule()) {
					sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_UPPER_BOUND:
				if(context == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmWildcardTypeReferenceRule()) {
					sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XamlPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XamlPackage.XATTACH_ATTRIBUTE:
				if(context == grammarAccess.getXAbstractAttributeRule() ||
				   context == grammarAccess.getXAttachAttributeRule()) {
					sequence_XAttachAttribute(context, (XAttachAttribute) semanticObject); 
					return; 
				}
				else break;
			case XamlPackage.XATTRIBUTE_ELEMENT:
				if(context == grammarAccess.getXAttributeElementRule() ||
				   context == grammarAccess.getXElementRule()) {
					sequence_XAttributeElement(context, (XAttributeElement) semanticObject); 
					return; 
				}
				else break;
			case XamlPackage.XGENERAL_ATTRIBUTE:
				if(context == grammarAccess.getXAbstractAttributeRule() ||
				   context == grammarAccess.getXGeneralAttributeRule()) {
					sequence_XGeneralAttribute(context, (XGeneralAttribute) semanticObject); 
					return; 
				}
				else break;
			case XamlPackage.XMARKUP_EXTENSON:
				if(context == grammarAccess.getXMarkupExtensonRule() ||
				   context == grammarAccess.getXPropertyExpressionRule()) {
					sequence_XMarkupExtenson(context, (XMarkupExtenson) semanticObject); 
					return; 
				}
				else break;
			case XamlPackage.XOBJECT_ELEMENT:
				if(context == grammarAccess.getXElementRule() ||
				   context == grammarAccess.getXObjectElementRule()) {
					sequence_XObjectElement(context, (XObjectElement) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XbasePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XbasePackage.RICH_STRING_LITERAL:
				if(context == grammarAccess.getRichStringLiteralEndRule()) {
					sequence_RichStringLiteralEnd(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRichStringLiteralInbetweenRule()) {
					sequence_RichStringLiteralInbetween(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRichStringLiteralStartRule()) {
					sequence_RichStringLiteralStart(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRichStringLiteralRule()) {
					sequence_RichStringLiteral(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XARGUMENT:
				if(context == grammarAccess.getXArgumentRule()) {
					sequence_XArgument(context, (XArgument) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XARRAY_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXArrayLiteralRule() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XArrayLiteral(context, (XArrayLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XASSIGNMENT:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XMemberFeatureCall(context, (XAssignment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XASSIGNMENT1:
				if(context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXExpressionRule()) {
					sequence_XAssignment1(context, (XAssignment1) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBINARY_OPERATION:
				if(context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()) {
					sequence_XAdditiveExpression_XAndExpression_XBitwiseExpression_XEqualityExpression_XMultiAssignment_XMultiplicativeExpression_XOrExpression_XRelationalExpression_XShiftExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()) {
					sequence_XAdditiveExpression_XAndExpression_XBitwiseExpression_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XRelationalExpression_XShiftExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()) {
					sequence_XAdditiveExpression_XAndExpression_XBitwiseExpression_XEqualityExpression_XMultiplicativeExpression_XRelationalExpression_XShiftExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()) {
					sequence_XAdditiveExpression_XBitwiseExpression_XEqualityExpression_XMultiplicativeExpression_XRelationalExpression_XShiftExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()) {
					sequence_XAdditiveExpression_XBitwiseExpression_XMultiplicativeExpression_XRelationalExpression_XShiftExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()) {
					sequence_XAdditiveExpression_XBitwiseExpression_XMultiplicativeExpression_XShiftExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()) {
					sequence_XAdditiveExpression_XMultiplicativeExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()) {
					sequence_XAdditiveExpression_XMultiplicativeExpression_XShiftExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0()) {
					sequence_XMultiplicativeExpression(context, (XBinaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBLOCK_STATMENT:
				if(context == grammarAccess.getXBlockStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XBlockStatment(context, (XBlockStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXBooleanLiteralRule() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBREAK_STATMENT:
				if(context == grammarAccess.getXBreakStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XBreakStatment(context, (XBreakStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCALLER:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XMemberFeatureCall(context, (XCaller) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASE_PART:
				if(context == grammarAccess.getXCasePartRule()) {
					sequence_XCasePart(context, (XCasePart) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCASTED_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XCastedExpression(context, (XCastedExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCATCH_CLAUSE:
				if(context == grammarAccess.getXCatchClauseRule()) {
					sequence_XCatchClause(context, (XCatchClause) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCLOSURE:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXClosureRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXConstructorCallRule() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONTINUE_STATMENT:
				if(context == grammarAccess.getXContinueStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XContinueStatment(context, (XContinueStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XDO_WHILE_STATMENT:
				if(context == grammarAccess.getXDoWhileStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XDoWhileStatment(context, (XDoWhileStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XEXPRESSION_STATMENT:
				if(context == grammarAccess.getXExpressionStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XExpressionStatment(context, (XExpressionStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFEATURE_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFIELD_LITERAL_PART:
				if(context == grammarAccess.getXFieldLiteralPartRule()) {
					sequence_XFieldLiteralPart(context, (XFieldLiteralPart) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFOR_EACH_STATMENT:
				if(context == grammarAccess.getXForEachStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XForEachStatment(context, (XForEachStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFOR_LOOP_STATMENT:
				if(context == grammarAccess.getXForLoopStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XForLoopStatment(context, (XForLoopStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFUNCTION_DECLARATION:
				if(context == grammarAccess.getXFunctionDeclarationRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XFunctionDeclaration(context, (XFunctionDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XIF_STATMENT:
				if(context == grammarAccess.getXIfStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XIfStatment(context, (XIfStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINDEXER:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XMemberFeatureCall(context, (XIndexer) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				if(context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()) {
					sequence_XRelationalExpression(context, (XInstanceOfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XMEMBER_FEATURE_CALL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNULL_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXNullLiteralRule() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNUMBER_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXNumberLiteralRule() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XOBJECT_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXObjectLiteralRule() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XObjectLiteral(context, (XObjectLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XOBJECT_LITERAL_PART:
				if(context == grammarAccess.getXObjectLiteralPartRule()) {
					sequence_XObjectLiteralPart(context, (XObjectLiteralPart) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XPARENTHESIZED_EXPRESSION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XParenthesizedExpression(context, (XParenthesizedExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XPOSTFIX_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0()) {
					sequence_XPostfixOperation(context, (XPostfixOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XRETURN_STATMENT:
				if(context == grammarAccess.getXReturnStatmentRule() ||
				   context == grammarAccess.getXStatmentRule()) {
					sequence_XReturnStatment(context, (XReturnStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSTRING_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXPropertyExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXStringLiteralRule() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSTRUCT_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXStructLiteralRule() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XStructLiteral(context, (XStructLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSWITCH_STATMENT:
				if(context == grammarAccess.getXStatmentRule() ||
				   context == grammarAccess.getXSwitchStatmentRule()) {
					sequence_XSwitchStatment(context, (XSwitchStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTEMPLATE:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTemplateLiteralRule() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XTemplateLiteral(context, (XTemplate) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTERNARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0()) {
					sequence_XTernaryOperation(context, (XTernaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTHROW_STATMENT:
				if(context == grammarAccess.getXStatmentRule() ||
				   context == grammarAccess.getXThrowStatmentRule()) {
					sequence_XThrowStatment(context, (XThrowStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT:
				if(context == grammarAccess.getXStatmentRule() ||
				   context == grammarAccess.getXTryCatchFinallyStatmentRule()) {
					sequence_XTryCatchFinallyStatment(context, (XTryCatchFinallyStatment) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTYPE_LITERAL:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXCallerExecutableAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXIndexerSourceAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXPrimaryExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXTypeLiteralRule() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XUNARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignment1Rule() ||
				   context == grammarAccess.getXAssignment1Access().getXAssignment1AssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXPostfixOperationRule() ||
				   context == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0() ||
				   context == grammarAccess.getXRelationalExpressionRule() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0() ||
				   context == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0() ||
				   context == grammarAccess.getXShiftExpressionRule() ||
				   context == grammarAccess.getXShiftExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XVARIABLE_DECLARATION:
				if(context == grammarAccess.getXVariableDeclarationRule()) {
					sequence_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XVARIABLE_DECLARATION_LIST:
				if(context == grammarAccess.getXStatmentRule() ||
				   context == grammarAccess.getXVariableDeclarationListRule()) {
					sequence_XVariableDeclarationList(context, (XVariableDeclarationList) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XWHILE_STATMENT:
				if(context == grammarAccess.getXStatmentRule() ||
				   context == grammarAccess.getXWhileStatmentRule()) {
					sequence_XWhileStatment(context, (XWhileStatment) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XEXPORT_DECLARATION:
				if(context == grammarAccess.getXExportDeclarationRule()) {
					sequence_XExportDeclaration(context, (XExportDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XEXPORT_ITEM:
				if(context == grammarAccess.getXExportItemRule()) {
					sequence_XExportItem(context, (XExportItem) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XEXPORT_SECTION:
				if(context == grammarAccess.getXExportSectionRule()) {
					sequence_XExportSection(context, (XExportSection) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XFUNCTION_TYPE_REF:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getXFunctionTypeRefRule()) {
					sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_DECLARATION:
				if(context == grammarAccess.getXImportDeclarationRule()) {
					sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_ITEM:
				if(context == grammarAccess.getXImportItemRule()) {
					sequence_XImportItem(context, (XImportItem) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_SECTION:
				if(context == grammarAccess.getXImportSectionRule()) {
					sequence_XImportSection(context, (XImportSection) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (annotations+=JvmAnnotation* type=JvmTypeReference simpleName=ValidID defaultValue=XLiteral?)
	 */
	protected void sequence_AnnotationField(EObject context, JvmField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         exported?='export'? 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         returnType=JvmTypeReference 
	 *         simpleName=ValidID 
	 *         (parameters+=JvmFormalParameter parameters+=JvmFormalParameter*)?
	 *     )
	 */
	protected void sequence_DelegateType(EObject context, JvmDelegateType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (simpleName=ValidID defaultValue=XNumberLiteral?)
	 */
	protected void sequence_JvmEnumerationLiteral(EObject context, JvmEnumerationLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         packageName=QualifiedName? 
	 *         simpleName=ID 
	 *         importSection=XImportSection? 
	 *         root=XObjectElement? 
	 *         (contents+=Type | contents+=DelegateType | contents+=XStatment)* 
	 *         exportSection=XExportSection?
	 *     )
	 */
	protected void sequence_JvmModule(EObject context, JvmModule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 (
	 *                     (
	 *                         (
	 *                             annotationInfo=Member_JvmConstructor_2_2_0 
	 *                             modifiers+=ConstructorModofier* 
	 *                             (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)?
	 *                         ) | 
	 *                         (annotationInfo=Member_JvmConstructor_2_2_0 (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)?)
	 *                     ) 
	 *                     (parameters+=JvmFormalParameter parameters+=JvmFormalParameter*)?
	 *                 ) | 
	 *                 (annotationInfo=Member_JvmConstructor_2_2_0 (parameters+=JvmFormalParameter parameters+=JvmFormalParameter*)?)
	 *             ) 
	 *             body=XBlockStatment
	 *         ) | 
	 *         (annotationInfo=Member_JvmConstructor_2_2_0 body=XBlockStatment)
	 *     )
	 */
	protected void sequence_Member(EObject context, JvmConstructor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     annotations+=JvmAnnotation+
	 */
	protected void sequence_Member_JvmConstructor_2_2_0_JvmEvent_2_3_0_JvmField_2_0_0_JvmOperation_2_1_0(EObject context, JvmMember semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (annotationInfo=Member_JvmEvent_2_3_0 modifiers+=FieldModifier* type=JvmTypeReference) | 
	 *             (annotationInfo=Member_JvmEvent_2_3_0 type=JvmTypeReference)
	 *         ) 
	 *         simpleName=ValidID 
	 *         (add=XBlockStatment remove=XBlockStatment?)?
	 *     )
	 */
	protected void sequence_Member(EObject context, JvmEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 annotationInfo=Member_JvmField_2_0_0 
	 *                 modifiers+=FieldModifier* 
	 *                 (type=JvmTypeReference (simpleName=FeatureCallID | (indexer?='this' (parameters+=JvmFormalParameter parameters+=JvmFormalParameter*)?)))
	 *             ) | 
	 *             (
	 *                 annotationInfo=Member_JvmField_2_0_0 
	 *                 (type=JvmTypeReference (simpleName=FeatureCallID | (indexer?='this' (parameters+=JvmFormalParameter parameters+=JvmFormalParameter*)?)))
	 *             )
	 *         ) 
	 *         (defaultValue=XExpression? | (property?='{' get=XBlockStatment? set=XBlockStatment?))
	 *     )
	 */
	protected void sequence_Member(EObject context, JvmField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 (
	 *                     (annotationInfo=Member_JvmOperation_2_1_0 modifiers+=MethodModifier* (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)?) | 
	 *                     (annotationInfo=Member_JvmOperation_2_1_0 (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)?)
	 *                 ) 
	 *                 returnType=JvmTypeReference
	 *             ) | 
	 *             (annotationInfo=Member_JvmOperation_2_1_0 returnType=JvmTypeReference)
	 *         ) 
	 *         (simpleName=FeatureCallID | (operator?='operator' simpleName=Operators)) 
	 *         (parameters+=JvmFormalParameter parameters+=JvmFormalParameter*)? 
	 *         (exceptions+=JvmTypeReference exceptions+=JvmTypeReference*)? 
	 *         body=XBlockStatment?
	 *     )
	 */
	protected void sequence_Member(EObject context, JvmOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (annotationInfo=Type_JvmAnnotationType_2_6_0 exported?='export'? simpleName=ValidID) | 
	 *             (annotationInfo=Type_JvmAnnotationType_2_6_0 simpleName=ValidID)
	 *         ) 
	 *         members+=AnnotationField*
	 *     )
	 */
	protected void sequence_Type(EObject context, JvmAnnotationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     annotations+=JvmAnnotation+
	 */
	protected void sequence_Type_JvmAnnotationType_2_6_0_JvmBeanType_2_3_0_JvmEnumerationType_2_5_0_JvmGenericType_2_0_0_JvmInterfaceType_2_1_0_JvmRemoteType_2_2_0_JvmStructType_2_4_0(EObject context, JvmDeclaredType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((annotationInfo=Type_JvmBeanType_2_3_0 exported?='export'? simpleName=ValidID) | (annotationInfo=Type_JvmBeanType_2_3_0 simpleName=ValidID)) 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (implements+=JvmParameterizedTypeReference implements+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Type(EObject context, JvmBeanType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (annotationInfo=Type_JvmEnumerationType_2_5_0 exported?='export'? simpleName=ValidID) | 
	 *             (annotationInfo=Type_JvmEnumerationType_2_5_0 simpleName=ValidID)
	 *         ) 
	 *         (members+=JvmEnumerationLiteral members+=JvmEnumerationLiteral*)?
	 *     )
	 */
	protected void sequence_Type(EObject context, JvmEnumerationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 (
	 *                     (annotationInfo=Type_JvmGenericType_2_0_0 exported?='export'? modifiers+=ClassModofier*) | 
	 *                     (annotationInfo=Type_JvmGenericType_2_0_0 modifiers+=ClassModofier*)
	 *                 ) 
	 *                 simpleName=ValidID
	 *             ) | 
	 *             (annotationInfo=Type_JvmGenericType_2_0_0 simpleName=ValidID)
	 *         ) 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         extends=JvmParameterizedTypeReference? 
	 *         (implements+=JvmParameterizedTypeReference implements+=JvmParameterizedTypeReference*)? 
	 *         root=XObjectElement? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Type(EObject context, JvmGenericType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (annotationInfo=Type_JvmInterfaceType_2_1_0 exported?='export'? simpleName=ValidID) | 
	 *             (annotationInfo=Type_JvmInterfaceType_2_1_0 simpleName=ValidID)
	 *         ) 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (implements+=JvmParameterizedTypeReference implements+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Type(EObject context, JvmInterfaceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((annotationInfo=Type_JvmRemoteType_2_2_0 exported?='export'? simpleName=ValidID) | (annotationInfo=Type_JvmRemoteType_2_2_0 simpleName=ValidID)) 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (implements+=JvmParameterizedTypeReference implements+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Type(EObject context, JvmRemoteType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((annotationInfo=Type_JvmStructType_2_4_0 exported?='export'? simpleName=ValidID) | (annotationInfo=Type_JvmStructType_2_4_0 simpleName=ValidID)) 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (implements+=JvmParameterizedTypeReference implements+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Type(EObject context, JvmStructType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] field=[JvmField|ID] value=XPropertyExpression)
	 */
	protected void sequence_XAttachAttribute(EObject context, XAttachAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XamlPackage.Literals.XABSTRACT_ATTRIBUTE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XamlPackage.Literals.XABSTRACT_ATTRIBUTE__TYPE));
			if(transientValues.isValueTransient(semanticObject, XamlPackage.Literals.XABSTRACT_ATTRIBUTE__FIELD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XamlPackage.Literals.XABSTRACT_ATTRIBUTE__FIELD));
			if(transientValues.isValueTransient(semanticObject, XamlPackage.Literals.XABSTRACT_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XamlPackage.Literals.XABSTRACT_ATTRIBUTE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getXAttachAttributeAccess().getTypeJvmTypeQualifiedNameParserRuleCall_1_0_1(), semanticObject.getType());
		feeder.accept(grammarAccess.getXAttachAttributeAccess().getFieldJvmFieldIDTerminalRuleCall_4_0_1(), semanticObject.getField());
		feeder.accept(grammarAccess.getXAttachAttributeAccess().getValueXPropertyExpressionParserRuleCall_6_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] field=[JvmField|ID] (contents+=XElement* closeType=[JvmType|QualifiedName] closeField=[JvmField|ID])?)
	 */
	protected void sequence_XAttributeElement(EObject context, XAttributeElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((exportItems+=XExportItem exportItems+=XExportItem* importURI=STRING?) | (importURI=STRING alias=ID))
	 */
	protected void sequence_XExportDeclaration(EObject context, XExportDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exportedId=[JvmIdentifiableElement|ID] alias=ID?)
	 */
	protected void sequence_XExportItem(EObject context, XExportItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     exportDeclarations+=XExportDeclaration+
	 */
	protected void sequence_XExportSection(EObject context, XExportSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (field=[JvmField|ID] value=XPropertyExpression)
	 */
	protected void sequence_XGeneralAttribute(EObject context, XGeneralAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((importItems+=XImportItem importItems+=XImportItem*) | wildcard?='*') importedNamespace=QualifiedName alias=ValidID)
	 */
	protected void sequence_XImportDeclaration(EObject context, XImportDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (importedId=[JvmIdentifiableElement|ID] alias=ID?)
	 */
	protected void sequence_XImportItem(EObject context, XImportItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importDeclarations+=XImportDeclaration+
	 */
	protected void sequence_XImportSection(EObject context, XImportSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] properties+=XAbstractAttribute*)
	 */
	protected void sequence_XMarkupExtenson(EObject context, XMarkupExtenson semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] properties+=XAbstractAttribute* (contents+=XElement* closeType=[JvmType|QualifiedName])?)
	 */
	protected void sequence_XObjectElement(EObject context, XObjectElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
