/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TokenTool {
	/**
	 * @param t the token
	 * @return the parsed text or <code>null</code> if the {@link Token} t was <code>null</code> or the token's text was <code>null</code>.
	 */
	public static String getText(Token t) {
		return t!=null ? t.getText() : null;
	}
	
	/**
	 * @param t the token
	 * @return the line of the token or <code>-1</code> if the {@link Token} t was <code>null</code> or the token did not provide line information.
	 */
	public static int getLine(Token t) {
		return  t!=null ? t.getLine() : -1;
	}
	
	/**
	 * @param t the token
	 * @return the offset of the token or <code>-1</code> if the {@link Token} t was <code>null</code> or the token did not provide offset information.
	 */
	public static int getOffset(Token t) {
		if (t instanceof CommonToken) {
			return ((CommonToken)t).getStartIndex();
		}
		return -1;
	}
	
	/**
	 * @param t the token
	 * @return the length of the token or <code>0</code> if the {@link Token} t was <code>null</code> or the token did not provide line information.
	 */
	public static int getLength(Token t) {
		String text = getText(t);
		return text!=null ? text.length() : 0;
	}
	
	public static final String LEXER_RULE_PREFIX = "RULE_";
	
	public static boolean isLexerRule(String antlrTokenDef) {
		return antlrTokenDef.startsWith(LEXER_RULE_PREFIX);
	}
	
	public static String getLexerRuleName(String antlrTokenDef) {
		return antlrTokenDef.substring(LEXER_RULE_PREFIX.length());
	}

}
