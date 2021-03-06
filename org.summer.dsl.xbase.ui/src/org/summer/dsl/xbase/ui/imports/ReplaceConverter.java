/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.imports;

import java.util.List;

import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplaceConverter {

	public TextEdit convertToTextEdit(List<ReplaceRegion> changes) {
		if(changes != null && !changes.isEmpty()) {
			MultiTextEdit multiTextEdit = new MultiTextEdit();
			for(ReplaceRegion change: changes) {
				multiTextEdit.addChild(new ReplaceEdit(change.getOffset(), change.getLength(), change.getText()));
			}
			return multiTextEdit;
		}
		return null;
	}
	
	public int getReplaceLengthDelta(List<ReplaceRegion> changes) {
		return getReplaceLengthDelta(changes, 0);
	}

	public int getReplaceLengthDelta(List<ReplaceRegion> changes, int caretPosition) {
		int delta = 0;
		if(changes != null && !changes.isEmpty()) {
			for(ReplaceRegion change: changes) {
				if(change.getEndOffset() < caretPosition)
					delta += change.getText().length() - change.getLength();
			}
		}
		return delta;
	}
}
