/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.contentassist;

import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.summer.ss.ide.autoedit.TokenTypeToPartitionMapper;
import org.summer.ss.ide.contentassist.javadoc.SsJavaDocContentAssistProcessor;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class SsContentAssistFactory extends DefaultContentAssistantFactory {

	@Inject
	private SsJavaDocContentAssistProcessor javaDocContentAssistProcessor;

	@Override
	protected void setContentAssistProcessor(ContentAssistant assistent, SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		super.setContentAssistProcessor(assistent, configuration, sourceViewer);
		assistent.setContentAssistProcessor(javaDocContentAssistProcessor,TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		assistent.setContentAssistProcessor(null, TerminalsTokenTypeToPartitionMapper.SL_COMMENT_PARTITION);
		assistent.setContentAssistProcessor(null, TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
	}
}
