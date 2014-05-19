/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.debug;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.debug.IStratumBreakpointSupport;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseStratumBreakpointSupport implements IStratumBreakpointSupport {

	public boolean isValidLineForBreakPoint(XtextResource resource, int line) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			return false;
		ICompositeNode node = parseResult.getRootNode();
		return isValidLineForBreakpoint(node, line);
	}

	protected boolean isValidLineForBreakpoint(ICompositeNode node, int line) {
		for (INode n : node.getChildren()) {
			ITextRegionWithLineInformation textRegion = n.getTextRegionWithLineInformation();
			if (textRegion.getLineNumber()<= line && textRegion.getEndLineNumber() >= line) {
				EObject eObject = n.getSemanticElement();
				if (eObject instanceof XExpression && !(eObject.eClass() == XbasePackage.Literals.XBLOCK_STATMENT)) {
					return true;
				}
				if (n instanceof ICompositeNode && isValidLineForBreakpoint((ICompositeNode) n, line)) {
					return true;
				}
			}
			if (textRegion.getLineNumber() > line) {
				return false;
			}
		}
		return false;
	}

}
