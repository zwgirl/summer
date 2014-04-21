/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.compiler;

import java.io.CharArrayWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.IFilePostProcessorExtension;
import org.summer.dsl.xbase.compiler.output.TraceAwarePostProcessor;
import org.summer.dsl.xbase.compiler.output.TreeAppendable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnicodeAwarePostProcessor extends TraceAwarePostProcessor implements IFilePostProcessorExtension {

	public CharSequence postProcess(URI fileURI, CharSequence content, @Nullable Charset targetCharset) {
		if (targetCharset != null && "js".equalsIgnoreCase(fileURI.fileExtension())) {
			final String lineSeparator = getWhitespaceInformationProvider().getLineSeparatorInformation(fileURI).getLineSeparator();
			final CharsetEncoder encoder = targetCharset.newEncoder();
			if (content instanceof TreeAppendable) {
				return ((TreeAppendable) content).acceptVisitor(new TreeAppendable.Visitor() {
					@Override
					protected @NonNull String visit(@NonNull String string) {
						return replaceLineSeparatorsAndEscapeChars(string, lineSeparator, encoder);
					}
				});
			} else {
				String result = replaceLineSeparatorsAndEscapeChars(content, lineSeparator, encoder);
				return result;
			}
		} else {
			return postProcess(fileURI, content);
		}
	}
	
	protected String replaceLineSeparatorsAndEscapeChars(CharSequence content, String newLineSeparator, CharsetEncoder encoder) {
		CharArrayWriter writer = new CharArrayWriter(content.length());
		boolean isLookahead = false;
		boolean changed = false;
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
					changed = true;
					writer.append(newLineSeparator);
					isLookahead = true;
					ignoreNext = '\r';
					break;
				case '\r':
					changed = true;
					writer.append(newLineSeparator);
					isLookahead = true;
					ignoreNext = '\n';
					break;
				default: {
					if (encoder.canEncode(c))
						writer.append(c);
					else {
						changed = true;
						writer.append("\\u");
						String hexString = Integer.toHexString(c);
						for(int j = hexString.length(); j < 4; j++) {
							writer.append('0');
						}
						writer.append(hexString);
					}
				}
			}
		}
		if (changed)
			return writer.toString();
		return content.toString();
	}
	
}
