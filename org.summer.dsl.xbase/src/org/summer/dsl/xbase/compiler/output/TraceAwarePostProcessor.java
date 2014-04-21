/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler.output;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.generator.LineSeparatorHarmonizer;

/**
 * Specializes the {@link LineSeparatorHarmonizer} and is aware of {@link TreeAppendable} thus
 * it can harmonize the line breaks and still maintain the trace information.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TraceAwarePostProcessor extends LineSeparatorHarmonizer {

	@Override
	public CharSequence postProcess(URI fileURI, CharSequence content) {
		if (content instanceof TreeAppendable) {
			final String lineSeparator = getWhitespaceInformationProvider().getLineSeparatorInformation(fileURI).getLineSeparator();
			return ((TreeAppendable) content).acceptVisitor(new TreeAppendable.Visitor() {
				@Override
				protected String visit(String string) {
					return replaceLineSeparators(string, lineSeparator);
				}
			});
		} else {
			return super.postProcess(fileURI, content);
		}
	}
	
}
