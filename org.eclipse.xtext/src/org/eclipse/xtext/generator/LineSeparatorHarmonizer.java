/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.CharArrayWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;

import com.google.inject.Inject;

/**
 * Replaces all line breaks with the configured line separator.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@NonNullByDefault
public class LineSeparatorHarmonizer implements IFilePostProcessor {

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;

	public CharSequence postProcess(URI fileURI, CharSequence content) {
		String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(fileURI).getLineSeparator();
		return replaceLineSeparators(content, lineSeparator);
	}

	protected String replaceLineSeparators(CharSequence content, String newLineSeparator) {
		CharArrayWriter writer = new CharArrayWriter(content.length());
		boolean isLookahead = false;
		char ignoreNext = '\u0000';
		for(int i=0; i<content.length(); ++i) {
			char c = content.charAt(i);
			if (isLookahead) {
				isLookahead = false;
				if (c == ignoreNext)
					continue;
			}
			switch (c) {
				case '\n':
					writer.append(newLineSeparator);
					isLookahead = true;
					ignoreNext = '\r';
					break;
				case '\r':
					writer.append(newLineSeparator);
					isLookahead = true;
					ignoreNext = '\n';
					break;
				default:
					writer.append(c);
			}
		}
		return writer.toString();
	}
	
	protected IWhitespaceInformationProvider getWhitespaceInformationProvider() {
		return whitespaceInformationProvider;
	}
}
