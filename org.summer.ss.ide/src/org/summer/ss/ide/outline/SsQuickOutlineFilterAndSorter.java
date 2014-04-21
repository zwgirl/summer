/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.outline;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsQuickOutlineFilterAndSorter extends QuickOutlineFilterAndSorter {

	public SsQuickOutlineFilterAndSorter() {
		addFilter(new IFilter() {
			
			public boolean apply(IOutlineNode input) {
				if (input instanceof SsFeatureNode) {
					return !((SsFeatureNode) input).isSynthetic();
				}
				return !equal("import declarations", input.getText().toString());
			}
			
			public boolean isEnabled() {
				return true;
			}
		});
	}
}
