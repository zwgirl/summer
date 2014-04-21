/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class KeywordSerializer implements IKeywordSerializer {

	public boolean isValid(EObject context, Keyword keyword, Object value, Acceptor errorAcceptor) {
		return keyword.getValue().equals(value);
	}

	public String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, INode node,
			Acceptor errorAcceptor) {
		if (node != null && node.getGrammarElement() == keyword)
			return node.getText();
		return keyword.getValue();
	}

	//	public boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, INode node) {
	//		return node.getGrammarElement() == keyword;
	//	}

}
