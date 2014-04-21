/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Inject
	protected MultiLineTerminalsEditStrategyInRichString.Factory multiLineTerminalsInRichString;
	
	@Inject
	protected Provider<RichStringPartitionDelimiterSkippingStrategy> richStringPartitionEndSkippingEditStrategy;
	
	@Override
	protected void configureIndentationEditStrategy(IEditStrategyAcceptor acceptor) {
		super.configureIndentationEditStrategy(acceptor);
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(), TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(), TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION);
	}
	
	@Override
	protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
		super.configureMultilineComments(acceptor);
		acceptor.accept(multiLineTerminals.newInstance("/*"," * ", " */"),TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
	}

	@Override
	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		super.configureCurlyBracesBlock(acceptor);
		acceptor.accept(multiLineTerminalsInRichString.newInstance("{", null, "}"), TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION);
	}
	
	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsert.newInstance("'''", "'''"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(richStringPartitionEndSkippingEditStrategy.get(), TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION);
		acceptor.accept(partitionInsert.newInstance("\"","\""), TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION);
		acceptor.accept(partitionInsert.newInstance("\u00AB","\u00BB"), TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION);
		acceptor.accept(partitionDeletion.newInstance("\u00AB","\u00BB"), TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION);
		acceptor.accept(singleLineTerminals.newInstance("\u00AB","\u00BB"), IDocument.DEFAULT_CONTENT_TYPE);
		super.configureStringLiteral(acceptor);
	}
	
	public static class MultiLineTerminalsEditStrategyInRichString extends MultiLineTerminalsEditStrategy {
		
		public static class Factory {
			@Inject
			private MembersInjector<MultiLineTerminalsEditStrategy> injector;
			@Inject
			private IIndentationInformation indentationInformation;
			
			public MultiLineTerminalsEditStrategy newInstance(String leftTerminal, String indentationString, String rightTerminal) {
				indentationString = indentationString == null ? indentationInformation.getIndentString()
						: indentationString;
				MultiLineTerminalsEditStrategyInRichString strategy = new MultiLineTerminalsEditStrategyInRichString(leftTerminal, indentationString, rightTerminal);
				injector.injectMembers(strategy);
				return strategy;
			}
		}
		
		public MultiLineTerminalsEditStrategyInRichString(String leftTerminal, String indentationString,
				String rightTerminal) {
			super(leftTerminal, indentationString, rightTerminal);
		}
		
		@Override
		protected IRegion findStartTerminal(IDocument document, int offset) throws BadLocationException {
			IRegion result = super.findStartTerminal(document, offset);
			if (result == null)
				return result;
			String textBetween = document.get(result.getOffset() + result.getLength(), offset - (result.getOffset() + result.getLength()));
			if (textBetween.trim().length() != 0)
				return null;
			return result;
		}

		@Override
		protected boolean atEndOfLineInput(IDocument document, int offset) throws BadLocationException {
			IRegion line = document.getLineInformation(document.getLineOfOffset(offset));
			String trimmedSubsequentCharacters = document.get(offset, line.getOffset() + line.getLength() - offset).trim();
			if (trimmedSubsequentCharacters.length() == 0) {
				return true;
			}
			if (trimmedSubsequentCharacters.startsWith("'''"))
				return true;
			return false;
		}
	}
	
}
