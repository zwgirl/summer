/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.codetemplates.ui.partialEditing;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialContentAssistContextFactory extends ParserBasedContentAssistContextFactory {

	private AbstractRule rule;

	@Inject
	public void setPartialParser(final IPartialContentAssistParser partialContentAssistParser) {
		final Provider<StatefulFactory> delegate = super.getStatefulFactoryProvider();
		super.setStatefulFactoryProvider(new Provider<StatefulFactory>() {
			public StatefulFactory get() {
				StatefulFactory result = delegate.get();
				result.setParser(partialContentAssistParser);
				if (rule != null) {
					partialContentAssistParser.initializeFor(rule);
				}
				return result;
			}
		});
	}

	public void initializeFor(AbstractRule rule) {
		this.rule = rule;
	}
	
}
