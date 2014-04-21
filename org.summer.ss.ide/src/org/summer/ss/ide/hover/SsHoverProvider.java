/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.summer.dsl.model.ss.XtendParameter;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.util.Pair;
import org.summer.dsl.xbase.ui.hover.XbaseHoverProvider;
import org.summer.dsl.xbase.ui.hover.XbaseInformationControlInput;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class SsHoverProvider extends XbaseHoverProvider {

	@Inject
	private SsHoverSerializer xtendHoverSerializer;

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		XtextBrowserInformationControlInput hoverInfo = super.getHoverInfo(element, hoverRegion, previous);
		if(hoverInfo instanceof XbaseInformationControlInput){
			XbaseInformationControlInput xbaseHoverInfo = (XbaseInformationControlInput) hoverInfo;
			Pair<String, String> prefixAndSuffixPair = xtendHoverSerializer.computePreAndSuffix(element);
			String unsugaredExpression = xtendHoverSerializer.computeUnsugaredExpression(element);
			return new XbaseInformationControlInput(previous, xbaseHoverInfo, prefixAndSuffixPair.getFirst(), unsugaredExpression, prefixAndSuffixPair.getSecond());
		}
		return hoverInfo;
	}
	
	@Override
	protected boolean hasHover(EObject o) {
		return super.hasHover(o) || o instanceof XtendParameter;
	}
}
