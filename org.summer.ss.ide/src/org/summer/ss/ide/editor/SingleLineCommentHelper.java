/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.editor;

import org.eclipse.jface.text.source.ISourceViewer;
import org.summer.ss.ide.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.toggleComments.DefaultSingleLineCommentHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SingleLineCommentHelper extends DefaultSingleLineCommentHelper {

	@Override
	public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
		if (contentType.equals(TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION)) {
			return new String[] {"\u00AB\u00AB\u00AB"};
		}
		return super.getDefaultPrefixes(sourceViewer, contentType);
	}
	
}
