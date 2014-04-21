/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.Reader;

import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
@ImplementedBy(IParser.NullImpl.class)
public interface IParser {
	
	IParseResult parse(Reader reader);
	
	IParseResult parse(ParserRule rule, Reader reader);
	
	IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead);
	
	IParseResult reparse(IParseResult previousParseResult, ReplaceRegion replaceRegion);
	
	static class NullImpl implements IParser {

		public IParseResult parse(Reader reader) {
			return null;
		}

		public IParseResult parse(ParserRule rule, Reader reader) {
			return null;
		}
		
		public IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead) {
			return null;
		}

		public IParseResult reparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
			return null;
		}
		
	}

}
