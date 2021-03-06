/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

/**
 * Default implementation of folded position. It uses a relative offset to determine the
 * significant content and its length.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultFoldedPosition extends FoldedPosition {

	static final int UNSET = -1;
	
	private final int contentStart;
	private final int contentLength;

	public DefaultFoldedPosition(int offset, int length, int contentStart, int contentLength) {
		super(offset, length);
		this.contentStart = contentStart;
		this.contentLength = contentLength;
	}
	
	public IRegion[] computeProjectionRegions(IDocument document) throws BadLocationException {
		if (contentStart == UNSET) {
			int line= document.getLineOfOffset(offset);
			int offset= document.getLineOffset(line + 1);
	
			int length= this.length - (offset - this.offset);
			if (length > 0) {
				return new IRegion[] {
					new Region(offset, length)
				};
			}
			return null;
		} else {
			int firstLine = document.getLineOfOffset(offset);
			int captionLine = document.getLineOfOffset(offset + contentStart);
			int captionEndLine = document.getLineOfOffset(offset + contentStart + contentLength);
			int lastLine = document.getLineOfOffset(offset + length) - 1;
			IRegion preRegion;
			if (firstLine < captionLine) {
				int preOffset= document.getLineOffset(firstLine);
				IRegion preEndLineInfo= document.getLineInformation(captionLine);
				int preEnd= preEndLineInfo.getOffset();
				preRegion= new Region(preOffset, preEnd - preOffset);
			} else {
				preRegion= null;
			}
			if (captionEndLine < lastLine) {
				int postOffset= document.getLineOffset(captionLine + 1);
				IRegion postRegion= new Region(postOffset, offset + length - postOffset);

				if (preRegion == null)
					return new IRegion[] { postRegion };

				return new IRegion[] { preRegion, postRegion };
			}

			if (preRegion != null)
				return new IRegion[] { preRegion };

			return null;
		}
	}

	public int computeCaptionOffset(IDocument document) throws BadLocationException {
		if (contentStart == UNSET) {
			return 0;
		}
		return contentStart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + contentLength;
		result = prime * result + contentStart;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultFoldedPosition other = (DefaultFoldedPosition) obj;
		if (contentLength != other.contentLength)
			return false;
		if (contentStart != other.contentStart)
			return false;
		return true;
	}


}
