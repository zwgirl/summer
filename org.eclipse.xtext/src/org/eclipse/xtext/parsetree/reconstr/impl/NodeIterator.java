/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.Sets;

/**
 * An iterator that can traverse a parse tree in forward and backward direction 
 * starting from any element in the tree. Also allows pruning of nodes. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NodeIterator implements TreeIterator<INode> {

	private INode current;

	private INode next;

	private Set<ICompositeNode> prunedComposites;

	public NodeIterator(INode node) {
		prunedComposites = Sets.newHashSet();
		current = node;
		next = findNext(node);
	}

	private INode findPrevious(INode node) {
		ICompositeNode parent = node.getParent();
		if (parent == null) {
			return null;
		}
		INode predecessor = node.getPreviousSibling();
		if (predecessor != null) {
			while (predecessor instanceof ICompositeNode && !prunedComposites.contains(predecessor)) {
				INode lastChild = ((ICompositeNode) predecessor).getLastChild();
				if (lastChild == null) {
					return predecessor;
				}
				predecessor = lastChild;
			}
			return predecessor;
		}
		return parent;
	}

	private INode findNext(INode node) {
		if (node instanceof ICompositeNode && ! prunedComposites.contains(node)) {
			INode firstChild = ((ICompositeNode) node).getFirstChild();
			if (firstChild != null) {
				return firstChild;
			}
		}
		return findNextSibling(node);
	}

	protected INode findNextSibling(INode node) {
		ICompositeNode parent = node.getParent();
		if (parent == null) {
			return null;
		}
		INode successor = node.getNextSibling();
		if (successor != null) {
			return successor;
		}
		return findNextSibling(parent);
	}

	public boolean hasNext() {
		return next != null;
	}

	public INode next() {
		current = next;
		next = findNext(next);
		return current;
	}

	public boolean hasPrevious() {
		return current != null;
	}

	public INode previous() {
		next = current;
		current = findPrevious(current);
		return next;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void prune() {
		if (current instanceof ICompositeNode) {
			prunedComposites.add((ICompositeNode) current);
			next = findNext(current);
		}
	}
}
