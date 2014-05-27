/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.contentassist;

import static com.google.common.collect.Iterables.contains;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static com.google.common.collect.Sets.newHashSet;
import static org.eclipse.xtext.util.Strings.notNull;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.util.FeatureOverridesService;
import org.summer.dsl.model.types.util.ITypeArgumentContext;
import org.summer.dsl.model.types.util.TypeArgumentContextProvider;
import org.summer.dsl.model.types.util.TypeReferences;
import org.summer.dsl.model.types.util.VisibilityService;
import org.summer.dsl.xbase.ui.contentassist.ImportOrganizingProposal;
import org.summer.dsl.xbase.ui.contentassist.ReplacingAppendable;
import org.summer.dsl.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters;
import org.summer.dsl.xbase.ui.labeling.XbaseImageAdornments;
import org.summer.dsl.xbase.validation.UIStrings;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.ss.core.validation.TypeErasedSignature;
import org.summer.ss.ide.codebuilder.MemberFromSuperImplementor;
import org.summer.ss.ide.labeling.SsImages;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class ImplementMemberFromSuperAssist {

	@Inject
	private TypeErasedSignature.Provider signatureProvider;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private FeatureOverridesService featureOverridesService;

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private VisibilityService visibilityService;

	@Inject
	private SsImages images;
	
	@Inject XbaseImageAdornments adornments;

	@Inject
	private MemberFromSuperImplementor implementor;

	@Inject
	private UIStrings uiStrings;

	@Inject
	private ReplacingAppendable.Factory appendableFactory;
	
	@Inject
	private IImageHelper imageHelper;

	private static Pattern bodyExpressionPattern = Pattern.compile("\\{\\s*(.*?)\\s*$\\s*\\}", Pattern.MULTILINE
			| Pattern.DOTALL);

	protected Iterable<JvmExecutable> getImplementationCandidates(JvmDeclaredType clazz) {
//		final JvmGenericType inferredType = associations.getInferredType(clazz);
//		if (inferredType == null)
//			return emptySet();
		ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.ReceiverRequest(typeReferences.createTypeRef(clazz)));
		Set<TypeErasedSignature> erasureKeys = newHashSet();
		for (JvmOperation op : clazz.getDeclaredOperations()) {
			erasureKeys.add(signatureProvider.get(op));
		}
		List<JvmExecutable> result = newArrayList();
		for (JvmExecutable executable : filter(
				featureOverridesService.getAllJvmFeatures(clazz, typeArgumentContext), JvmExecutable.class)) {
			if (isCandidate(executable, clazz)) {
				TypeErasedSignature erasureKey = signatureProvider.get(executable);
				if (erasureKeys.add(erasureKey)) {
					result.add(executable);
				}
			}
		}
		return result;
	}

	protected boolean isCandidate(JvmExecutable executable, JvmDeclaredType overrider) {
		if (executable.getDeclaringType() != overrider && visibilityService.isVisible(executable, overrider)) {
			if (executable instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) executable;
				return /*!operation.isFinal() &&*/ !operation.isStatic();
			} else {
				return executable instanceof JvmConstructor
						&& contains(transform(overrider.getSuperTypes(), new Function<JvmTypeReference, JvmType>() {
							public JvmType apply(JvmTypeReference from) {
								return from.getType();
							}
						}), executable.getDeclaringType());
			}
		}
		return false;
	}

	public void createOverrideProposals(JvmDeclaredType model, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, IProposalConflictHelper conflictHelper) {
		Iterable<JvmExecutable> overrideables = getImplementationCandidates(model);
		for (JvmExecutable overridden : overrideables) {
			ICompletionProposal completionProposal = createOverrideMethodProposal(model, overridden, context,
					conflictHelper);
			if (completionProposal != null)
				acceptor.accept(completionProposal);
		}
	}

	protected ICompletionProposal createOverrideMethodProposal(JvmDeclaredType model, JvmExecutable overridden,
			final ContentAssistContext context, IProposalConflictHelper conflictHelper) {
		ReplacingAppendable appendable = appendableFactory.create(context.getDocument(), (XtextResource) model.eResource(), context.getReplaceRegion()
				.getOffset(), context.getReplaceRegion().getLength(), new OptionalParameters() {{ 
					ensureEmptyLinesAround = true;
					baseIndentationLevel = 1;	
				}});
		final String simpleName;
		if (overridden instanceof JvmOperation) {
			implementor.appendOverrideFunction((JvmGenericType) model, (JvmOperation) overridden, appendable);
			simpleName = overridden.getSimpleName();
		} else {
			implementor.appendConstructorFromSuper((JvmGenericType) model, (JvmConstructor) overridden, appendable);
			simpleName = "new";
		}
		String code = appendable.getCode();
		if (!isValidProposal(code.trim(), context, conflictHelper) && !isValidProposal(simpleName, context, conflictHelper))
			return null;
		ImageDescriptor imageDescriptor = images.forOperation(overridden.getVisibility(), adornments.getOverrideAdornment(overridden));
		ImportOrganizingProposal completionProposal = createCompletionProposal(appendable, context.getReplaceRegion(),
				getLabel(overridden), imageHelper.getImage(imageDescriptor));
		Matcher matcher = bodyExpressionPattern.matcher(code);
		if (matcher.find()) {
			int bodyExpressionLength = matcher.end(1) - matcher.start(1);
			int bodyExpressionStart = matcher.start(1) + appendable.getTotalOffset() - completionProposal.getReplacementOffset();
			if (bodyExpressionLength == 0) {
				completionProposal.setCursorPosition(bodyExpressionStart);
			} else {
				completionProposal.setSelectionStart(completionProposal.getReplacementOffset() + bodyExpressionStart);
				completionProposal.setSelectionLength(bodyExpressionLength);
				completionProposal.setAutoInsertable(false);
				completionProposal.setCursorPosition(bodyExpressionStart + bodyExpressionLength);
				completionProposal.setSimpleLinkedMode(context.getViewer(), '\t');
			}
		}
		completionProposal.setPriority(getPriority(model, overridden, context));
		completionProposal.setMatcher(new PrefixMatcher() {

			@Override
			public boolean isCandidateMatchingPrefix(String name, String prefix) {
				PrefixMatcher delegate = context.getMatcher();
				boolean result = delegate.isCandidateMatchingPrefix(simpleName, prefix);
				return result;
			}
			
		});
		return completionProposal;
	}

	protected boolean isValidProposal(String proposal, ContentAssistContext context,
			IProposalConflictHelper conflictHelper) {
		if (proposal == null)
			return false;
		if (!context.getMatcher().isCandidateMatchingPrefix(proposal, context.getPrefix()))
			return false;
		if (conflictHelper.existsConflict(proposal, context))
			return false;
		return true;
	}

	protected int getPriority(JvmDeclaredType model, JvmExecutable overridden, ContentAssistContext context) {
		return (overridden instanceof JvmOperation && ((JvmOperation) overridden).isAbstract()) ? 400 : 350;
	}

	protected ImportOrganizingProposal createCompletionProposal(ReplacingAppendable appendable, Region replaceRegion,
			StyledString displayString, Image image) {
		return new ImportOrganizingProposal(appendable, replaceRegion.getOffset(), replaceRegion.getLength(),
				replaceRegion.getOffset(), image, displayString);
	}

	protected StyledString getLabel(JvmExecutable executable) {
		if (executable instanceof JvmOperation) {
			return new StyledString(uiStrings.signature(executable)).append(new StyledString(" - Override method from "
					+ notNull(((JvmOperation) executable).getDeclaringType().getSimpleName()),
					StyledString.QUALIFIER_STYLER));
		} else {
			return new StyledString("Add constructor 'new" + uiStrings.parameters(executable) + "'");
		}
	}

}
