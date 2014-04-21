/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IEnumLiteralSerializer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EnumLiteralSerializer implements IEnumLiteralSerializer {

	public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node) {
		Keyword nodeLit = getLiteral(node);
		Keyword modelLit = getLiteral(context, ruleCall, value);
		return nodeLit != null && nodeLit.equals(modelLit);
	}

	protected Keyword getLiteral(INode node) {
		if (node != null) {
			for(ILeafNode leaf: node.getLeafNodes()) {
				if (leaf.getGrammarElement() instanceof EnumLiteralDeclaration)
					return ((EnumLiteralDeclaration) leaf.getGrammarElement()).getLiteral();
			}
		}
		return null;
	}

	protected Keyword getLiteral(EObject context, RuleCall ruleCall, Object value) {
		EnumRule rule = (EnumRule) ruleCall.getRule();
		if (rule.getAlternatives() instanceof EnumLiteralDeclaration) {
			EnumLiteralDeclaration decl = (EnumLiteralDeclaration) rule.getAlternatives();
			if (decl.getEnumLiteral().getInstance().equals(value)) {
				return decl.getLiteral();
			}
		} else {
			for (AbstractElement element : ((Alternatives) rule.getAlternatives()).getElements()) {
				EnumLiteralDeclaration decl = (EnumLiteralDeclaration) element;
				if (decl.getEnumLiteral().getInstance().equals(value)) {
					return decl.getLiteral();
				}
			}
		}
		return null;
	}

	public boolean isValid(EObject context, RuleCall ruleCall, Object value, IErrorAcceptor errorAcceptor) {
		return getLiteral(context, ruleCall, value) != null;
	}

	public String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, INode node) {
		Keyword nodeLit = getLiteral(node);
		Keyword modelLit = getLiteral(context, ruleCall, value);
		if (nodeLit != null && nodeLit.equals(modelLit))
			return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		return modelLit.getValue();
	}
}
