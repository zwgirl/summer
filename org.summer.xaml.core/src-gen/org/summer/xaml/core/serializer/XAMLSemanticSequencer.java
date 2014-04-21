package org.summer.xaml.core.serializer;

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
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ss.XtendEnumLiteral;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;
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
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueExpression;
import org.summer.dsl.model.xbase.XDoWhileExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XForEachExpression;
import org.summer.dsl.model.xbase.XForLoopExpression;
import org.summer.dsl.model.xbase.XIfExpression;
import org.summer.dsl.model.xbase.XIndexOperation;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall1;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XObjectLiteralPart;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XReturnExpression;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XSwitchExpression;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowExpression;
import org.summer.dsl.model.xbase.XTryCatchFinallyExpression;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportItem;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.model.xtype.XImportDeclaration1;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection1;
import org.summer.dsl.model.xtype.XtypePackage;
import org.summer.ss.core.serializer.SsSemanticSequencer;
import org.summer.xaml.core.services.XAMLGrammarAccess;
import org.summer.xaml.core.xAML.AttributeElement;
import org.summer.xaml.core.xAML.Document;
import org.summer.xaml.core.xAML.MarkupExtenson;
import org.summer.xaml.core.xAML.ObjectElement;
import org.summer.xaml.core.xAML.Property;
import org.summer.xaml.core.xAML.XAMLPackage;

@SuppressWarnings("all")
public class XAMLSemanticSequencer extends SsSemanticSequencer {

	@Inject
	private XAMLGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == SsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SsPackage.XTEND_ENUM_LITERAL:
				if(context == grammarAccess.getXtendEnumLiteralRule()) {
					sequence_XtendEnumLiteral(context, (XtendEnumLiteral) semanticObject); 
					return; 
				}
				else break;
			case SsPackage.XTEND_FILE:
				if(context == grammarAccess.getFileRule()) {
					sequence_File(context, (XtendFile) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_ANNOTATION_REFERENCE:
				if(context == grammarAccess.getXAnnotationRule()) {
					sequence_XAnnotation(context, (JvmAnnotationReference) semanticObject); 
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
			case TypesPackage.JVM_CONSTRUCTOR:
				if(context == grammarAccess.getMemberRule()) {
					sequence_Member(context, (JvmConstructor) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_DECLARED_TYPE:
				if(context == grammarAccess.getTypeAccess().getJvmAnnotationTypeAnnotationInfoAction_2_2_0() ||
				   context == grammarAccess.getTypeAccess().getJvmGenericTypeAnnotationInfoAction_2_0_0() ||
				   context == grammarAccess.getTypeAccess().getJvmGenericTypeAnnotationInfoAction_2_1_0()) {
					sequence_Type_JvmAnnotationType_2_2_0_JvmGenericType_2_0_0_JvmGenericType_2_1_0(context, (JvmDeclaredType) semanticObject); 
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
				if(context == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (JvmFormalParameter) semanticObject); 
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
			case TypesPackage.JVM_LOWER_BOUND:
				if(context == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_MEMBER:
				if(context == grammarAccess.getMemberAccess().getJvmConstructorAnnotationInfoAction_2_2_0() ||
				   context == grammarAccess.getMemberAccess().getJvmFieldAnnotationInfoAction_2_0_0() ||
				   context == grammarAccess.getMemberAccess().getJvmOperationAnnotationInfoAction_2_1_0()) {
					sequence_Member_JvmConstructor_2_2_0_JvmField_2_0_0_JvmOperation_2_1_0(context, (JvmMember) semanticObject); 
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
		else if(semanticObject.eClass().getEPackage() == XAMLPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XAMLPackage.ATTRIBUTE_ELEMENT:
				if(context == grammarAccess.getAttributeElementRule() ||
				   context == grammarAccess.getElementContentRule()) {
					sequence_AttributeElement(context, (AttributeElement) semanticObject); 
					return; 
				}
				else break;
			case XAMLPackage.DOCUMENT:
				if(context == grammarAccess.getDocumentRule()) {
					sequence_Document(context, (Document) semanticObject); 
					return; 
				}
				else break;
			case XAMLPackage.MARKUP_EXTENSON:
				if(context == grammarAccess.getMarkupExtensonRule() ||
				   context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXIndexOperationRule() ||
				   context == grammarAccess.getXIndexOperationAccess().getXIndexOperationExpressionAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCall1MemberCallTargetAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_2_0_0_0() ||
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
					sequence_MarkupExtenson(context, (MarkupExtenson) semanticObject); 
					return; 
				}
				else break;
			case XAMLPackage.OBJECT_ELEMENT:
				if(context == grammarAccess.getElementContentRule() ||
				   context == grammarAccess.getObjectElementRule()) {
					sequence_ObjectElement(context, (ObjectElement) semanticObject); 
					return; 
				}
				else break;
			case XAMLPackage.PROPERTY:
				if(context == grammarAccess.getAbstractPropertyRule()) {
					sequence_AbstractProperty_AttachProperty_GeneralProperty(context, (Property) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAttachPropertyRule()) {
					sequence_AttachProperty(context, (Property) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getGeneralPropertyRule()) {
					sequence_GeneralProperty(context, (Property) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XbasePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XARRAY_LITERAL:
				if(context == grammarAccess.getXArrayLiteralRule() ||
				   context == grammarAccess.getXLiteralRule()) {
					sequence_XArrayLiteral(context, (XArrayLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XASSIGNMENT:
				if(context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXParenthesizedExpressionRule()) {
					sequence_XAssignment_XMemberFeatureCall(context, (XAssignment) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXIndexOperationRule() ||
				   context == grammarAccess.getXIndexOperationAccess().getXIndexOperationExpressionAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCall1MemberCallTargetAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_2_0_0_0() ||
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
			case XbasePackage.XBINARY_OPERATION:
				if(context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule()) {
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
			case XbasePackage.XBLOCK_EXPRESSION:
				if(context == grammarAccess.getXBlockExpressionRule()) {
					sequence_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				if(context == grammarAccess.getXBooleanLiteralRule() ||
				   context == grammarAccess.getXLiteralRule()) {
					sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBREAK_EXPRESSION:
				if(context == grammarAccess.getXBreakExpressionRule()) {
					sequence_XBreakExpression(context, (XBreakExpression) semanticObject); 
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
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
				if(context == grammarAccess.getXClosureRule() ||
				   context == grammarAccess.getXLiteralRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				if(context == grammarAccess.getXConstructorCallRule()) {
					sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONTINUE_EXPRESSION:
				if(context == grammarAccess.getXContinueExpressionRule()) {
					sequence_XContinueExpression(context, (XContinueExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XDO_WHILE_EXPRESSION:
				if(context == grammarAccess.getXDoWhileExpressionRule()) {
					sequence_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFEATURE_CALL:
				if(context == grammarAccess.getXFeatureCallRule()) {
					sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFOR_EACH_EXPRESSION:
				if(context == grammarAccess.getXForEachLoopExpressionRule()) {
					sequence_XForEachLoopExpression(context, (XForEachExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				if(context == grammarAccess.getXForLoopExpressionRule()) {
					sequence_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XIF_EXPRESSION:
				if(context == grammarAccess.getXIfExpressionRule()) {
					sequence_XIfExpression(context, (XIfExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINDEX_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXIndexOperationRule() ||
				   context == grammarAccess.getXIndexOperationAccess().getXIndexOperationExpressionAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
					sequence_XIndexOperation(context, (XIndexOperation) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				if(context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXIndexOperationRule() ||
				   context == grammarAccess.getXIndexOperationAccess().getXIndexOperationExpressionAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCall1MemberCallTargetAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
			case XbasePackage.XMEMBER_FEATURE_CALL1:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXIndexOperationRule() ||
				   context == grammarAccess.getXIndexOperationAccess().getXIndexOperationExpressionAction_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCall1MemberCallTargetAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_2_0_0_0() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
					sequence_XMemberFeatureCall(context, (XMemberFeatureCall1) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNULL_LITERAL:
				if(context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXNullLiteralRule()) {
					sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XNUMBER_LITERAL:
				if(context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXNumberLiteralRule()) {
					sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XOBJECT_LITERAL:
				if(context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXObjectLiteralRule()) {
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
			case XbasePackage.XPOSTFIX_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
			case XbasePackage.XRETURN_EXPRESSION:
				if(context == grammarAccess.getXReturnExpressionRule()) {
					sequence_XReturnExpression(context, (XReturnExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSTRING_LITERAL:
				if(context == grammarAccess.getSimpleStringLiteralRule()) {
					sequence_SimpleStringLiteral(context, (XStringLiteral) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXCastedExpressionRule() ||
				   context == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXIndexOperationRule() ||
				   context == grammarAccess.getXIndexOperationAccess().getXIndexOperationExpressionAction_1_0_0_0() ||
				   context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXMemberFeatureCallRule() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_1_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCall1MemberCallTargetAction_1_0_0_0_0() ||
				   context == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_2_0_0_0() ||
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
				   context == grammarAccess.getXStringLiteralRule() ||
				   context == grammarAccess.getXTernaryOperationRule() ||
				   context == grammarAccess.getXTernaryOperationAccess().getXTernaryOperationConditionAction_1_0_0_0() ||
				   context == grammarAccess.getXUnaryOperationRule()) {
					sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XSWITCH_EXPRESSION:
				if(context == grammarAccess.getXSwitchExpressionRule()) {
					sequence_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTERNARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
			case XbasePackage.XTHROW_EXPRESSION:
				if(context == grammarAccess.getXThrowExpressionRule()) {
					sequence_XThrowExpression(context, (XThrowExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				if(context == grammarAccess.getXTryCatchFinallyExpressionRule()) {
					sequence_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XTYPE_LITERAL:
				if(context == grammarAccess.getXLiteralRule() ||
				   context == grammarAccess.getXTypeLiteralRule()) {
					sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XUNARY_OPERATION:
				if(context == grammarAccess.getXAdditiveExpressionRule() ||
				   context == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAndExpressionRule() ||
				   context == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXAssignmentRule() ||
				   context == grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0_0_0() ||
				   context == grammarAccess.getXBitwiseExpressionRule() ||
				   context == grammarAccess.getXBitwiseExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXEqualityExpressionRule() ||
				   context == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXExpressionRule() ||
				   context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXMultiAssignmentRule() ||
				   context == grammarAccess.getXMultiAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXMultiplicativeExpressionRule() ||
				   context == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXOrExpressionRule() ||
				   context == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getXParenthesizedExpressionRule() ||
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
				if(context == grammarAccess.getXExpressionInsideBlockRule() ||
				   context == grammarAccess.getXVariableDeclarationListRule()) {
					sequence_XVariableDeclarationList(context, (XVariableDeclarationList) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XWHILE_EXPRESSION:
				if(context == grammarAccess.getXWhileExpressionRule()) {
					sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
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
			case XtypePackage.XIMPORT_DECLARATION1:
				if(context == grammarAccess.getXImportDeclaration1Rule()) {
					sequence_XImportDeclaration1(context, (XImportDeclaration1) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_ITEM:
				if(context == grammarAccess.getXImportItemRule()) {
					sequence_XImportItem(context, (XImportItem) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_SECTION1:
				if(context == grammarAccess.getXImportSection1Rule()) {
					sequence_XImportSection1(context, (XImportSection1) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     ((property=[JvmField|ID] value=XPrimaryExpression) | (type=[JvmType|ID] property=[JvmField|ID] value=XPrimaryExpression))
	 */
	protected void sequence_AbstractProperty_AttachProperty_GeneralProperty(EObject context, Property semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|ID] property=[JvmField|ID] value=XPrimaryExpression)
	 */
	protected void sequence_AttachProperty(EObject context, Property semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XAMLPackage.Literals.PROPERTY__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XAMLPackage.Literals.PROPERTY__TYPE));
			if(transientValues.isValueTransient(semanticObject, XAMLPackage.Literals.PROPERTY__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XAMLPackage.Literals.PROPERTY__PROPERTY));
			if(transientValues.isValueTransient(semanticObject, XAMLPackage.Literals.PROPERTY__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XAMLPackage.Literals.PROPERTY__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAttachPropertyAccess().getTypeJvmTypeIDTerminalRuleCall_1_0_1(), semanticObject.getType());
		feeder.accept(grammarAccess.getAttachPropertyAccess().getPropertyJvmFieldIDTerminalRuleCall_3_0_1(), semanticObject.getProperty());
		feeder.accept(grammarAccess.getAttachPropertyAccess().getValueXPrimaryExpressionParserRuleCall_6_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|ID] attribute=[JvmField|ID] (contents+=ElementContent* close=[JvmType|ID] closeAttribute=[JvmField|ID])?)
	 */
	protected void sequence_AttributeElement(EObject context, AttributeElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (importSection=XImportSection1? root=ObjectElement (contents+=Type | contents+=XExpressionInsideBlock)*)
	 */
	protected void sequence_Document(EObject context, Document semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=[JvmField|ID] value=XPrimaryExpression)
	 */
	protected void sequence_GeneralProperty(EObject context, Property semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=JvmTypeReference properties+=AbstractProperty*)
	 */
	protected void sequence_MarkupExtenson(EObject context, MarkupExtenson semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=JvmTypeReference properties+=AbstractProperty* (contents+=ElementContent* close=JvmTypeReference)?)
	 */
	protected void sequence_ObjectElement(EObject context, ObjectElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation) | 
	 *         (leftOperand=XShiftExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|ShiftOp] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XBitwiseExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|BinaryBitwiseOp] rightOperand=XShiftExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XBitwiseExpression) | 
	 *         (leftOperand=XEqualityExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpEquality] rightOperand=XRelationalExpression) | 
	 *         (leftOperand=XAndExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAnd] rightOperand=XEqualityExpression) | 
	 *         (leftOperand=XOrExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOr] rightOperand=XAndExpression)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XAndExpression_XBitwiseExpression_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XRelationalExpression_XShiftExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation) | 
	 *         (leftOperand=XShiftExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|ShiftOp] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XBitwiseExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|BinaryBitwiseOp] rightOperand=XShiftExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XBitwiseExpression) | 
	 *         (leftOperand=XEqualityExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpEquality] rightOperand=XRelationalExpression) | 
	 *         (leftOperand=XAndExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAnd] rightOperand=XEqualityExpression)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XAndExpression_XBitwiseExpression_XEqualityExpression_XMultiplicativeExpression_XRelationalExpression_XShiftExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation) | 
	 *         (leftOperand=XShiftExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|ShiftOp] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XBitwiseExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|BinaryBitwiseOp] rightOperand=XShiftExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XBitwiseExpression) | 
	 *         (leftOperand=XEqualityExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpEquality] rightOperand=XRelationalExpression)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XBitwiseExpression_XEqualityExpression_XMultiplicativeExpression_XRelationalExpression_XShiftExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation) | 
	 *         (leftOperand=XShiftExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|ShiftOp] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XBitwiseExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|BinaryBitwiseOp] rightOperand=XShiftExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XBitwiseExpression)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XBitwiseExpression_XMultiplicativeExpression_XRelationalExpression_XShiftExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation) | 
	 *         (leftOperand=XShiftExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|ShiftOp] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XBitwiseExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|BinaryBitwiseOp] rightOperand=XShiftExpression)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XBitwiseExpression_XMultiplicativeExpression_XShiftExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XMultiplicativeExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation) | 
	 *         (leftOperand=XShiftExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|ShiftOp] rightOperand=XAdditiveExpression)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XMultiplicativeExpression_XShiftExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (assignable=XMemberFeatureCall_XAssignment_1_1_0_0_0 explicitStatic?='::'? feature=[JvmIdentifiableElement|FeatureCallID] value=XAssignment)
	 */
	protected void sequence_XMemberFeatureCall(EObject context, XAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XPostfixOperation)
	 */
	protected void sequence_XMultiplicativeExpression(EObject context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_XStringLiteral(EObject context, XStringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
}
