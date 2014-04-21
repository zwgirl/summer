/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.contentassist.javadoc;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

/**
 * @author Holger Schill - Initial contribution and API
 */
public abstract class AbstractJavaDocContentAssistProcessor implements IContentAssistProcessor {

	/**
	 * Not needed in JavaDoc
	 */
	public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
		return null;
	}

	/**
	 * Not needed in JavaDoc
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	/**
	 * Not needed in JavaDoc
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	/**
	 * Not needed in JavaDoc
	 */
	public String getErrorMessage() {
		return null;
	}
	/**
	 * Not needed in JavaDoc
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

}
