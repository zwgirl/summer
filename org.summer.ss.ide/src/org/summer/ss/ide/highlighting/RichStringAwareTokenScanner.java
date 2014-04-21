/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.highlighting;

import java.util.Map;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.syntaxcoloring.TokenScanner;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringAwareTokenScanner extends TokenScanner {

	protected RichTextToken createRichTextToken(String id, ILexerTokenRegion token) {
		int tokenOffset = token.getOffset();
		int tokenLength = token.getLength();
		RichTextToken result = new RichTextToken();
		if ("RULE_RICH_TEXT_START".equals(id)) {
			result.delimiter = false;
			result.offsets = new int[] { tokenOffset, tokenOffset + tokenLength - 1 };
			result.lengths = new int[] { tokenLength - 1, 1 };
		} else if ("RULE_RICH_TEXT_END".equals(id)) {
			result.delimiter = true;
			result.offsets = new int[] { tokenOffset, tokenOffset + 1 };
			result.lengths = new int[] { 1, tokenLength - 1 };
		} else if ("RULE_RICH_TEXT_INBETWEEN".equals(id)) {
			result.delimiter = true;
			if (tokenLength == 2) {
				result.offsets = new int[] { tokenOffset };
				result.lengths = new int[] { tokenLength };
			} else {
				result.offsets = new int[] { tokenOffset, tokenOffset + 1, tokenOffset + tokenLength - 1 };
				result.lengths = new int[] { 1, tokenLength - 2, 1 };
			}
		} else if ("RULE_COMMENT_RICH_TEXT_END".equals(id)) {
			result.delimiter = true;
			result.offsets = new int[] { tokenOffset, tokenOffset + 2 };
			result.lengths = new int[] { 2, tokenLength - 2 };
		} else if ("RULE_COMMENT_RICH_TEXT_INBETWEEN".equals(id)) {
			result.delimiter = true;
			result.offsets = new int[] { tokenOffset, tokenOffset + 2, tokenOffset + tokenLength - 1 };
			result.lengths = new int[] { 2, tokenLength - 3, 1 };
		} else 
			throw new IllegalArgumentException(id);
		return result;
	}
	
	protected class RichTextToken {
		
		private int index = -1;
		private int[] offsets;
		private int[] lengths;
		private boolean delimiter; 
		
		public int getTokenLength() {
			return lengths[index];
		}

		public int getTokenOffset() {
			return offsets[index];
		}
		
		public boolean hasNext() {
			return index < offsets.length - 1;
		}

		public IToken nextToken() {
			IToken result = createToken();
			index++;
			delimiter = !delimiter;
			return result;
		}
		
		protected IToken createToken() {
			String attributeId = delimiter ? SsHighlightingConfiguration.RICH_TEXT_DELIMITER_ID : SsHighlightingConfiguration.RICH_TEXT_ID;
			Token token = new Token(getAttribute(attributeId));
			return token;
		}
	}
	
	private RichTextToken currentRichTextToken;
	private String[] allTokenTypesAsString;
	
	@Inject
	public void setTokenDefProvider(@Named(LexerUIBindings.HIGHLIGHTING) ITokenDefProvider tokenDefProvider) {
		Map<Integer, String> map = tokenDefProvider.getTokenDefMap();
		int minTokenType = org.antlr.runtime.Token.MIN_TOKEN_TYPE;
		allTokenTypesAsString = new String[map.size() + minTokenType];
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			String tokenName = entry.getValue();
			if ("RULE_RICH_TEXT_START".equals(tokenName) ||
				"RULE_RICH_TEXT_END".equals(tokenName) ||
				"RULE_RICH_TEXT_INBETWEEN".equals(tokenName) ||
				"RULE_COMMENT_RICH_TEXT_END".equals(tokenName) ||
				"RULE_COMMENT_RICH_TEXT_INBETWEEN".equals(tokenName)) {
				allTokenTypesAsString[entry.getKey()] = tokenName;
			}
		}
	}
	
	@Override
	public void setRange(IDocument document, int offset, int length) {
		currentRichTextToken = null;
		super.setRange(document, offset, length);
	}
	
	@Override
	public IToken nextToken() {
		if (currentRichTextToken != null) {
			if (currentRichTextToken.hasNext())
				return currentRichTextToken.nextToken();
			else
				currentRichTextToken = null;
		}
		if (!getIterator().hasNext())
			return Token.EOF;
		ILexerTokenRegion next = getIterator().next();
		if (allTokenTypesAsString[next.getLexerTokenType()] != null) {
			currentRichTextToken = createRichTextToken(allTokenTypesAsString[next.getLexerTokenType()], next);
			return currentRichTextToken.nextToken();
		} else {
			setCurrentToken(next);
			return createToken(next);	
		}
	}

	@Override
	public int getTokenLength() {
		if (currentRichTextToken != null) {
			return currentRichTextToken.getTokenLength();
		}
		return super.getTokenLength();
	}
	
	@Override
	public int getTokenOffset() {
		if (currentRichTextToken != null) {
			return currentRichTextToken.getTokenOffset();
		}
		return super.getTokenOffset();
	}
	
}
