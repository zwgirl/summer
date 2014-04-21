/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.contentassist.javadoc;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.summer.dsl.model.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class SsJavaDocContentAssistProcessor extends AbstractJavaDocContentAssistProcessor implements  SsJavaDocState{

	@Inject
	protected IScopeProvider scopeProvider;

	@Inject
	protected SsJavaDocContentAssistContextFactory contentAssistFactory;

	@Inject
	private ITypesProposalProvider typeProposalProvider;

	@Inject
	private SsJavaDocProposalFactory proposalFactory;

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		if(viewer instanceof XtextSourceViewer){
			IXtextDocument document = (IXtextDocument) viewer.getDocument();
			return document.readOnly(createCompletionProposalComputer(viewer, offset));
		}
		return new ICompletionProposal[0];
	}

	private SsJavaDocCompletionProposalComputer createCompletionProposalComputer(ITextViewer viewer,
			int offset) {
		return new SsJavaDocCompletionProposalComputer(this, viewer, offset);
	}

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	public ContentAssistContext.Factory getContextFactory() {
		return contentAssistFactory;
	}

	public ITypesProposalProvider getTypesProposalProvider() {
		return typeProposalProvider;
	}

	public SsJavaDocProposalFactory getProposalFactory() {
		return proposalFactory;
	}
}
