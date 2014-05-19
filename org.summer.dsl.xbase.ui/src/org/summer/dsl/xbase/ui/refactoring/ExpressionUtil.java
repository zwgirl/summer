/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.refactoring;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.summer.dsl.model.xbase.XbasePackage.Literals.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExpressionUtil {

	/**
	 * @returns the smallest single expression containing the selection.  
	 */
	public XStatment findSelectedExpression(XtextResource resource, ITextSelection selection) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			INode node = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), selection.getOffset());
			if (node != null &&
					(((ILeafNode) node).isHidden() || isBeginOfASymbol(node, selection))) {
				node = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(),
						selection.getOffset() - 1);
			}
			if(node != null) {
				EObject currentSemanticElement =  NodeModelUtils.findActualSemanticObjectFor(node);
				while (!(nodeContainsSelection(node, selection)
							&& currentSemanticElement instanceof XExpression)) {
					node = node.getParent();
					if(node == null)
						return null;
					currentSemanticElement = NodeModelUtils.findActualSemanticObjectFor(node);
				}
				return (XStatment) currentSemanticElement;
			}
		}
		return null;
	}

	/**
	 * @returns the list of sibling expressions (expressions in the same block expression) containing the selection.  
	 */
	public List<XStatment> findSelectedSiblingExpressions(XtextResource resource, ITextSelection selection) {
		ITextSelection trimmedSelection = trimSelection(resource, selection);
		XStatment selectedExpression = findSelectedExpression(resource, trimmedSelection);
		if(selectedExpression instanceof XBlockStatment) {
			List<XStatment> selectedExpressions = newArrayList();
			for(XStatment subExpression: ((XBlockStatment) selectedExpression).getStatments()) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(subExpression);
				if(node != null && nodeIntersectsWithSelection(trimmedSelection, node)) {
					selectedExpressions.add(subExpression);
				}
			}
			return selectedExpressions; 
		} else if(selectedExpression == null)
			return emptyList();
		return singletonList(selectedExpression);
	}

	protected ITextSelection trimSelection(XtextResource resource, ITextSelection selection) {
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null) {
			String model = parseResult.getRootNode().getText();
			String selectedText = model.substring(selection.getOffset(), selection.getOffset() + selection.getLength());
			String trimmedSelection = selectedText.trim();
			return new TextSelection(selection.getOffset() + selectedText.indexOf(trimmedSelection), 
					trimmedSelection.length()); 
		}
		return null;
	}
	
	protected boolean isBeginOfASymbol(INode node, ITextSelection selection) {
		ITextRegion textRegion = node.getTextRegion();
		return textRegion.getOffset() == selection.getOffset() 
				&& textRegion.getLength() > 0 
				&& !Character.isLetterOrDigit(node.getText().charAt(0))
				&& node.getText().charAt(0) != '['
				&& node.getText().charAt(0) != '(';
	}

	protected boolean nodeContainsSelection(INode node, ITextSelection selection) {
		ITextRegion textRegion = node.getTextRegion();
		return textRegion.getOffset() <= selection.getOffset()
				&& textRegion.getOffset() + textRegion.getLength() >= selection.getOffset() + selection.getLength();
	}

	protected boolean nodeIntersectsWithSelection(ITextSelection trimmedSelection, ICompositeNode node) {
		ITextRegion textRegion = node.getTextRegion();
		return textRegion.getOffset() <= trimmedSelection.getOffset() + trimmedSelection.getLength()
				&& textRegion.getOffset() + textRegion.getLength() >= trimmedSelection.getOffset();
	}
	
	public XExpression findSuccessorExpressionForVariableDeclaration(EObject expression) {
		EObject eContainer = expression.eContainer();
		if (eContainer == null)
			return null;
		if (expression instanceof XExpression) {
			if (eContainer instanceof XBlockStatment)
				return (XExpression) expression;
			else if (isBlockInsertable(eContainer, expression))
				return (XExpression) expression;
		}
		return findSuccessorExpressionForVariableDeclaration(eContainer);
	}

	protected boolean isBlockInsertable(EObject eContainer, EObject expression) {
		EReference ref = expression.eContainmentFeature();
		return ref == XCLOSURE__EXPRESSION 
				|| ref == XIF_STATMENT__THEN 
				|| ref == XIF_STATMENT__ELSE
				|| ref == XCASE_PART__THEN
				|| ref == XSWITCH_STATMENT__DEFAULT
				|| ref == XFOR_LOOP_STATMENT__STATMENT
				|| ref == XABSTRACT_WHILE_STATMENT__BODY
				|| ref == XTRY_CATCH_FINALLY_STATMENT__STATMENT
				|| ref == XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT
				|| ref == XCATCH_CLAUSE__STATMENT;
	}
	
}
