/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.quickfix;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.ss.XtendClass;
import org.summer.dsl.model.ss.XtendMember;
import org.summer.ss.ide.codebuilder.AbstractConstructorBuilder;
import org.summer.ss.ide.codebuilder.AbstractFieldBuilder;
import org.summer.ss.ide.codebuilder.AbstractMethodBuilder;
import org.summer.ss.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.util.Primitives;
import org.summer.dsl.model.types.util.Primitives.Primitive;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.model.edit.SemanticModificationWrapper;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.compiler.StringBuilderBasedAppendable;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.scoping.featurecalls.OperatorMapping;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.dsl.xbase.ui.contentassist.ReplacingAppendable;
import org.summer.dsl.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters;
import org.summer.dsl.xbase.ui.quickfix.ILinkingIssueQuickfixProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@NonNullByDefault
public class CreateMemberQuickfixes implements ILinkingIssueQuickfixProvider {
	
	@Inject 
	private CommonTypeComputationServices services;
	
	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	@Inject
	private Primitives primitives;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject 
	private OperatorMapping operatorMapping;
	
	@Inject
	private CodeBuilderFactory codeBuilderFactory;
	
	@Inject
	private CodeBuilderQuickfix quickfixFactory;
	
	public void addQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			IXtextDocument xtextDocument, XtextResource resource, EObject referenceOwner, EReference unresolvedReference)
			throws Exception {
		if (referenceOwner instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall call = (XAbstractFeatureCall) referenceOwner;
			
			String newMemberName = (issue.getData() != null && issue.getData().length > 0) ? issue.getData()[0] : null;
			if(newMemberName != null) {
				if (call instanceof XMemberFeatureCall) {
					if(!call.isExplicitOperationCallOrBuilderSyntax()) { 
						newFieldQuickfix(newMemberName, call, issue, issueResolutionAcceptor);
						newGetterQuickfixes(newMemberName, call, issue, issueResolutionAcceptor);
					}
					newMethodQuickfixes(newMemberName, call, issue, issueResolutionAcceptor);
					
				} else if(call instanceof XFeatureCall) {
					if(!call.isExplicitOperationCallOrBuilderSyntax()) {
						if(logicalContainerProvider.getNearestLogicalContainer(call) instanceof JvmExecutable)
							newLocalVariableQuickfix(newMemberName, call, issue, issueResolutionAcceptor);
						newFieldQuickfix(newMemberName, call, issue, issueResolutionAcceptor);
						newGetterQuickfixes(newMemberName, call, issue, issueResolutionAcceptor);
					}
					newMethodQuickfixes(newMemberName, call, issue, issueResolutionAcceptor);
					
				} else if (call instanceof XAssignment) {
					newSetterQuickfix(issue, issueResolutionAcceptor, newMemberName, call);
					XAssignment assigment = (XAssignment) call;
					if(assigment.getAssignable() == null) {
						newLocalVariableQuickfix(newMemberName, call, issue, issueResolutionAcceptor);
						newFieldQuickfix(newMemberName, call, issue, issueResolutionAcceptor);
					} else if (isThis(assigment)) {
						newFieldQuickfix(newMemberName, call, issue, issueResolutionAcceptor);
					}
				}
			} 
			if (call instanceof XBinaryOperation || call instanceof XUnaryOperation) {
				JvmIdentifiableElement feature = call.getFeature();
				if(feature.eIsProxy()) {
					String operatorMethodName = getOperatorMethodName(call);
					if(operatorMethodName != null) 
						newMethodQuickfixes(operatorMethodName, call, issue, issueResolutionAcceptor);
				}
			}
			if(call instanceof XFeatureCall && call.getFeature() instanceof JvmConstructor) {
				newConstructorQuickfix(issue, issueResolutionAcceptor, (XFeatureCall) call);
			}
		}
		if(referenceOwner instanceof XConstructorCall) {
			newConstructorQuickfix(issue, issueResolutionAcceptor, (XConstructorCall) referenceOwner);
		}
	}

	protected boolean isThis(XAssignment assigment) {
		XExpression assignable = assigment.getAssignable();
		if (!(assignable instanceof XAbstractFeatureCall)) {
			return false;
		}
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) assignable;
		return featureCall.getFeature() instanceof JvmDeclaredType
				&& !featureCall.isExplicitOperationCallOrBuilderSyntax() && !featureCall.isTypeLiteral();
	}

	protected String getAccessorMethodName(String prefix, String fieldName) {
		return prefix + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
	}

	protected boolean isStaticAccess(XAbstractFeatureCall call) {
		if (call instanceof XMemberFeatureCall) {
			XMemberFeatureCall featureCall = (XMemberFeatureCall) call;
			if (featureCall.isExplicitStatic()) {
				return true;
			}
			if (featureCall.getMemberCallTarget() instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall targetCall = (XAbstractFeatureCall) featureCall.getMemberCallTarget();
				if ( targetCall.isTypeLiteral()) {
					return true;
				}
			}
		}
		return isStatic(logicalContainerProvider.getNearestLogicalContainer(call)); 
	}
	
	protected boolean isStatic(JvmIdentifiableElement element) {
		if(element instanceof JvmOperation)
			return ((JvmOperation) element).isStatic();
		else if(element instanceof JvmField)
			return ((JvmField) element).isStatic();
		else 
			return false;
	}
	
	@Nullable
	protected LightweightTypeReference getNewMemberType(XAbstractFeatureCall call) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(call);
		if(call instanceof XAssignment) {
			XExpression value = ((XAssignment) call).getValue();
			return resolvedTypes.getActualType(value);
		} else {
			return resolvedTypes.getExpectedType(call);
		}
	}
	
	@Nullable
	protected LightweightTypeReference getReceiverType(XAbstractFeatureCall featureCall) {
		XExpression actualReceiver = featureCall.getActualReceiver();
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, featureCall);
		if(actualReceiver == null) {
			return new ParameterizedTypeReference(owner, getCallersType(featureCall));
		} else if (actualReceiver instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) actualReceiver).isTypeLiteral()) {
			JvmType type = (JvmType) ((XAbstractFeatureCall) actualReceiver).getFeature();
			ParameterizedTypeReference reference = new ParameterizedTypeReference(owner, type);
			return reference;
		} else {
			LightweightTypeReference typeRef = typeResolver.resolveTypes(featureCall).getActualType(actualReceiver);
			if(typeRef != null && typeRef.getType() instanceof JvmDeclaredType)
				return typeRef;
		}
		return null;
	}

	@Nullable
	protected JvmDeclaredType getCallersType(XExpression call) {
		JvmIdentifiableElement nearestLogicalContainer = logicalContainerProvider.getNearestLogicalContainer(call);
		return EcoreUtil2.getContainerOfType(nearestLogicalContainer, JvmDeclaredType.class);
	}
	
	@Nullable
	protected String getOperatorMethodName(XAbstractFeatureCall call) {
		for(INode node: NodeModelUtils.findNodesForFeature(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE)) {
			for(ILeafNode leafNode: node.getLeafNodes()) {
				if(!leafNode.isHidden()) {
					String symbol = leafNode.getText();
					QualifiedName methodName = operatorMapping.getMethodName(QualifiedName.create(symbol));
					if(methodName != null)
						return methodName.getFirstSegment();
				}
			}
		}
		return null;
	}
	
	protected void newLocalVariableQuickfix(final String variableName, XAbstractFeatureCall call, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		LightweightTypeReference variableType = getNewMemberType(call);
		final StringBuilderBasedAppendable localVarDescriptionBuilder = new StringBuilderBasedAppendable();
		localVarDescriptionBuilder.append("...").newLine();
		final String defaultValueLiteral = getDefaultValueLiteral(variableType);
		localVarDescriptionBuilder.append("val ").append(variableName).append(" = ").append(defaultValueLiteral);
		localVarDescriptionBuilder.newLine().append("...");
		issueResolutionAcceptor.accept(issue, "Create local variable '" + variableName + "'",
				localVarDescriptionBuilder.toString(), "fix_local_var.png",
				new SemanticModificationWrapper(issue.getUriToProblem(), new ISemanticModification() {
					public void apply(@Nullable final EObject element, @Nullable final IModificationContext context) throws Exception {
						if (element != null) {
							XtendMember xtendMember = EcoreUtil2.getContainerOfType(element, XtendMember.class);
							if (xtendMember != null) {
								int offset = getFirstOffsetOfKeyword(xtendMember, "{");
								IXtextDocument xtextDocument = context.getXtextDocument();
								if (offset != -1 && xtextDocument != null) {
									final ReplacingAppendable appendable = appendableFactory.create(xtextDocument,
											(XtextResource) element.eResource(), offset, 0, new OptionalParameters() {{ 
												baseIndentationLevel = 1;	
											}});
									appendable.increaseIndentation().newLine().append("val ").append(variableName).append(" = ")
											.append(defaultValueLiteral);
									appendable.commitChanges();
								}
							}
						}
					}
				}));
	}
	
	protected void newMethodQuickfixes(String newMemberName, XAbstractFeatureCall call, 
			final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		JvmDeclaredType callersType = getCallersType(call);
		LightweightTypeReference receiverType = getReceiverType(call);
		LightweightTypeReference returnType = getNewMemberType(call);
		if(callersType == null || receiverType == null)
			return;
		List<LightweightTypeReference> argumentTypes = getResolvedArgumentTypes(call, call.getActualArguments());
		newMethodQuickfixes(receiverType, newMemberName, returnType, argumentTypes, call, callersType, issue,
				issueResolutionAcceptor);
	}

	protected void newMethodQuickfixes(LightweightTypeReference containerType, String name, @Nullable LightweightTypeReference returnType,
		List<LightweightTypeReference> argumentTypes, XAbstractFeatureCall call, JvmDeclaredType callersType,
		final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		boolean isLocal = callersType == containerType.getType();
		boolean isStatic = isStaticAccess(call);
		boolean isAbstract = true;
		if(containerType.getType() instanceof JvmGenericType) {
			isAbstract = !((JvmGenericType) containerType.getType()).isInstantiateable();
		} else if(containerType.getType() instanceof JvmDeclaredType) {
			isAbstract = ((JvmDeclaredType) containerType.getType()).isAbstract();
		}
		if(containerType.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType declaredType = (JvmDeclaredType) containerType.getType();
			newMethodQuickfix(declaredType, name, returnType, argumentTypes, isStatic, isAbstract, false, isLocal, call, issue, issueResolutionAcceptor);
		}
		if(!isLocal && !isStatic) {
			List<LightweightTypeReference> extensionMethodParameterTypes = newArrayList(argumentTypes);
			extensionMethodParameterTypes.add(0, containerType);
			newMethodQuickfix(callersType, name, returnType, extensionMethodParameterTypes, false, isAbstract, true, true, call, issue, issueResolutionAcceptor);
		}
	}
	
	protected void newMethodQuickfix(JvmDeclaredType containerType, String name, @Nullable LightweightTypeReference returnType,
		List<LightweightTypeReference> parameterTypes, boolean isStatic, boolean isAbstract, boolean isExtension, boolean isLocal, XAbstractFeatureCall call, 
		final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		AbstractMethodBuilder methodBuilder = codeBuilderFactory.createMethodBuilder(containerType);
		methodBuilder.setMethodName(name);
		methodBuilder.setReturnType(returnType);
		for(LightweightTypeReference parameterType: parameterTypes) 
			methodBuilder.newParameterBuilder().setType(parameterType);
		methodBuilder.setContext(call);
		methodBuilder.setVisibility(JvmVisibility.PUBLIC);
		methodBuilder.setStaticFlag(isStatic);
		methodBuilder.setAbstractFlag(isAbstract);
		StringBuffer label = new StringBuffer("Create ");
		if(isStatic)
			label.append("static ");
		if(isExtension)
			label.append("extension ");
		label.append("method '").append(name).append("(");
		boolean isFirst = true;
		for(LightweightTypeReference parameterType: parameterTypes) {
			if(!isFirst) 
				label.append(", ");
			isFirst = false;
			label.append(parameterType.getSimpleName());
		}
		label.append(")'");
		if(!isLocal)
			label.append(" in '" + containerType.getSimpleName() + "'");
		quickfixFactory.addQuickfix(methodBuilder, label.toString(), issue, issueResolutionAcceptor);
	}
	
	protected void newSetterQuickfix(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			String newMemberName, XAbstractFeatureCall call) {
		newMethodQuickfixes(getAccessorMethodName("set", newMemberName), call, issue, issueResolutionAcceptor);
	}

	protected void newGetterQuickfixes(String name, XAbstractFeatureCall call, 
			final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		JvmDeclaredType callersType = getCallersType(call);
		LightweightTypeReference receiverType = getReceiverType(call);
		LightweightTypeReference fieldType = getNewMemberType(call);
		if(callersType != null && receiverType != null) {
			newMethodQuickfixes(receiverType, getAccessorMethodName("get", name), 
					fieldType, Collections.<LightweightTypeReference>emptyList(), call, 
					callersType, issue, issueResolutionAcceptor);
		}
	}

	protected void newFieldQuickfix(String name, XAbstractFeatureCall call, 
			final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		JvmDeclaredType callersType = getCallersType(call);
		LightweightTypeReference receiverType = getReceiverType(call);
		LightweightTypeReference fieldType = getNewMemberType(call);
		if(callersType != null && receiverType != null && callersType == receiverType.getType()) 
			newFieldQuickfix(callersType, name, fieldType, isStaticAccess(call), call, issue, issueResolutionAcceptor);
	}

	protected void newFieldQuickfix(JvmDeclaredType containerType, String name, @Nullable LightweightTypeReference fieldType,
			boolean isStatic, XAbstractFeatureCall call, final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		AbstractFieldBuilder fieldBuilder = codeBuilderFactory.createFieldBuilder(containerType);
		fieldBuilder.setFieldName(name);
		fieldBuilder.setFieldType(fieldType);
		fieldBuilder.setContext(call);
		fieldBuilder.setVisibility(JvmVisibility.PRIVATE);
		fieldBuilder.setStaticFlag(isStatic);
		StringBuilder label = new StringBuilder("Create ");
		if(isStatic) 
			label.append("static ");
		label.append("field '").append(name).append("'");
		quickfixFactory.addQuickfix(fieldBuilder, label.toString(), issue, issueResolutionAcceptor);
	}
	
	protected void newConstructorQuickfix(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			XConstructorCall call) {
		JvmDeclaredType ownerType = call.getConstructor().getDeclaringType();
		newConstructorQuickfix(issue, issueResolutionAcceptor, ownerType, call, call.getArguments());
	}
	
	protected void newConstructorQuickfix(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			XFeatureCall call) {
		JvmDeclaredType ownerType = ((JvmConstructor) call.getFeature()).getDeclaringType();
		newConstructorQuickfix(issue, issueResolutionAcceptor, ownerType, call, call.getActualArguments());
	}
	
	protected void newConstructorQuickfix(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			JvmDeclaredType ownerType, XExpression call, List<XExpression> arguments) {
		if(ownerType != null) {
			List<LightweightTypeReference> parameterTypes = getResolvedArgumentTypes(call, arguments);
			AbstractConstructorBuilder constructorBuilder = codeBuilderFactory.createConstructorBuilder(ownerType);
			constructorBuilder.setContext(call);
			for(LightweightTypeReference parameterType: parameterTypes) 
				constructorBuilder.newParameterBuilder().setType(parameterType);
			constructorBuilder.setVisibility(JvmVisibility.PUBLIC);
			StringBuffer label = new StringBuffer("Create constructor '");
			if(constructorBuilder.getOwnerSource() instanceof XtendClass)
				label.append("new");
			else
				label.append(ownerType.getSimpleName());
			label.append("(");
			boolean isFirst = true;
			for(LightweightTypeReference parameterType: parameterTypes) {
				if(!isFirst) 
					label.append(", ");
				isFirst = false;
				label.append(parameterType.getSimpleName());
			}
			label.append(")'");
			if(getCallersType(call) != ownerType) 
				label.append(" in '").append(ownerType.getSimpleName()).append("'");
			quickfixFactory.addQuickfix(constructorBuilder, label.toString(), issue, issueResolutionAcceptor);
		}
	}
	
	/**
	 * @since 2.3
	 */
	protected int getFirstOffsetOfKeyword(EObject object, String keyword) {
		int offset = -1;
		ICompositeNode node = NodeModelUtils.getNode(object);
		if (node != null) {
			for (ILeafNode leafNode : node.getLeafNodes()) {
				if (leafNode.getGrammarElement() instanceof Keyword
						&& equal(keyword, ((Keyword) leafNode.getGrammarElement()).getValue())) {
					return leafNode.getOffset() + 1;
				}
			}
		}
		return offset;
	}

	/**
	 * @since 2.3
	 */
	protected String getDefaultValueLiteral(@Nullable LightweightTypeReference type) {
		if (type != null && type.isPrimitive()) {
			Primitive primitiveKind = primitives.primitiveKind((JvmPrimitiveType) type.getType());
			if (primitiveKind == Primitive.Boolean)
				return "false";
			else
				return "0 as " + type.getSimpleName();
		}
		return "null";
	}

	protected List<LightweightTypeReference> getResolvedArgumentTypes(EObject context, List<XExpression> arguments) {
		List<LightweightTypeReference> argumentTypes = newArrayList();
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(context);
		for(XExpression argument: arguments) {
			LightweightTypeReference resolved = resolvedTypes.getActualType(argument);
			if(resolved == null) {
				StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, context);
				argumentTypes.add(new ParameterizedTypeReference(owner, services.getTypeReferences().findDeclaredType(Object.class, context)));
			} else {
				argumentTypes.add(resolved);
			}
		}
		return argumentTypes;

	}
}
