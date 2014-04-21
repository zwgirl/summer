/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.contentassist;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Keyword;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IContextInformationAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContextInformationProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.summer.dsl.xbase.services.XbaseGrammarAccess;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ParameterContextInformationProvider implements IContextInformationProvider {

	@Inject
	private XbaseProposalProvider proposalProvider;
	
	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	public void getContextInformation(ContentAssistContext context, IContextInformationAcceptor acceptor) {
		XExpression containerCall = getContainerCall(eObjectAtOffsetHelper.resolveContainedElementAt(context.getResource(), context.getOffset()));
		OwnedConverter converter = proposalProvider.getTypeConverter(context.getResource());
		if (containerCall != null) {
			ICompositeNode containerCallNode = NodeModelUtils.findActualNodeFor(containerCall);
			ITextRegion containerCallRegion = containerCallNode.getTextRegion();
			if(containerCallRegion.getOffset() > context.getOffset()
					|| containerCallRegion.getOffset() + containerCallRegion.getLength() < context.getOffset()) 
				return;
			JvmIdentifiableElement calledFeature = getCalledFeature(containerCall);
			if (calledFeature instanceof JvmExecutable) {
				if(getParameterListOffset(containerCall) > context.getOffset()) 
					return;
				ParameterData parameterData = new ParameterData();
				IScope scope = getScope(containerCall);
				QualifiedName qualifiedName = QualifiedName.create(getCalledFeatureName(containerCall));
				boolean candidatesFound = false;
				for (IEObjectDescription element : scope.getElements(qualifiedName)) {
					if (element instanceof JvmFeatureDescription) {
						JvmFeatureDescription featureDescription = (JvmFeatureDescription) element;
						JvmFeature featureCandidate = featureDescription.getJvmFeature();
						if (featureCandidate instanceof JvmExecutable) {
							JvmExecutable executable = (JvmExecutable) featureCandidate;
							if(!executable.getParameters().isEmpty()) {
								StyledString styledString = new StyledString();
								proposalProvider.appendParameters(styledString, executable,
										featureDescription.getNumberOfIrrelevantArguments(), converter);
								parameterData.addOverloaded(styledString.toString(), executable.isVarArgs());
								candidatesFound = true;
							}
						}
					}
				}
				if (candidatesFound) {
					StyledString displayString = proposalProvider.getStyledDisplayString((JvmExecutable) calledFeature, true, 0, 
							qualifiedNameConverter.toString(qualifiedNameProvider.getFullyQualifiedName(calledFeature)), 
							calledFeature.getSimpleName(), converter);
					ParameterContextInformation parameterContextInformation = new ParameterContextInformation(
							parameterData, displayString.toString(), getParameterListOffset(containerCall), context.getOffset());
					acceptor.accept(parameterContextInformation);
				}
			}
		}
	}

	protected XExpression getContainerCall(EObject element) {
		if (element == null || element instanceof XClosure)
			return null;
		else if (element instanceof XConstructorCall || element instanceof XFeatureCall
				|| element instanceof XMemberFeatureCall)
			return (XExpression) element;
		else 
			return getContainerCall(element.eContainer());
	}

	protected String getCalledFeatureName(XExpression call) {
		StringBuilder b = new StringBuilder();
		for (INode node : NodeModelUtils.findNodesForFeature(call, getCalledFeatureReference(call))) {
			for (ILeafNode leafNode : node.getLeafNodes()) {
				if (!leafNode.isHidden()) 
					b.append(leafNode.getText());
			}
		}
		return b.toString();
	}

	protected JvmIdentifiableElement getCalledFeature(XExpression call) {
		if (call instanceof XConstructorCall)
			return ((XConstructorCall) call).getConstructor();
		else if (call instanceof XFeatureCall || call instanceof XMemberFeatureCall)
			return ((XAbstractFeatureCall) call).getFeature();
		else
			return null;
	}

	protected IScope getScope(XExpression containerCall) {
		IScopeProvider scopeProvider = proposalProvider.getScopeProvider();
		return scopeProvider.getScope(containerCall, getCalledFeatureReference(containerCall));
	}

	protected int getParameterListOffset(XExpression containerCall) {
		List<XExpression> arguments = getArguments(containerCall);
		if (arguments.isEmpty()) {
			Keyword parameterListOpenParenthesis = getParameterListOpenParenthesis(containerCall);
			for(ILeafNode leafNode: NodeModelUtils.findActualNodeFor(containerCall).getLeafNodes()) {
				if(leafNode.getGrammarElement() == parameterListOpenParenthesis) {
					return leafNode.getEndOffset();
				}
			}
			int offset = 0;
			for (INode node : NodeModelUtils.findNodesForFeature(containerCall,
					getCalledFeatureReference(containerCall)))
				offset = Math.max(offset, node.getEndOffset());
			return offset;
		} else {
			INode node = NodeModelUtils.findActualNodeFor(arguments.get(0));
			return node.getOffset();
		}
	}

	protected List<XExpression> getArguments(XExpression call) {
		if (call instanceof XFeatureCall)
			return ((XFeatureCall) call).getExplicitArguments();
		else if (call instanceof XMemberFeatureCall)
			return ((XMemberFeatureCall) call).getMemberCallArguments();
		else if (call instanceof XConstructorCall)
			return ((XConstructorCall) call).getArguments();
		else
			return emptyList();
	}

	protected EReference getCalledFeatureReference(XExpression call) {
		if (call instanceof XAbstractFeatureCall)
			return XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
		else if (call instanceof XConstructorCall)
			return XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
		else
			return null;
	}

	protected Keyword getParameterListOpenParenthesis(XExpression call) {
		if (call instanceof XFeatureCall)
			return grammarAccess.getXFeatureCallAccess().findKeywords("(").get(0);
		else if (call instanceof XMemberFeatureCall)
			return grammarAccess.getXMemberFeatureCallAccess().findKeywords("(").get(0);
		else if (call instanceof XConstructorCall)
			return grammarAccess.getXConstructorCallAccess().findKeywords("(").get(0);
		else
			return null;
	}
}
