/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Map;
import java.util.RandomAccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

import com.google.common.collect.Interner;
import com.google.common.collect.Maps;

/**
 * A stateful (!) builder that provides call back methods for clients who
 * want to create a node model and maintain its invariants. 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
@NonNullByDefault
public class NodeModelBuilder {

	private static class ArrayInterner<T> implements Interner<T[]> {

		private static class ArrayAsList<T> extends AbstractList<T> implements RandomAccess {
			final T[] array;
			private int hashCode = -1;

			ArrayAsList(@Nullable T[] array) {
				this.array = array;
			}

			@Override public int size() {
				return array.length;
			}

			@Override @Nullable public T get(int index) {
				return array[index];
			}

			@Override public int hashCode() {
				if (hashCode == -1)
					hashCode = Arrays.hashCode(array);
				return hashCode;
			}

			@SuppressWarnings("rawtypes")
			@Override public boolean equals(@Nullable Object o) {
				if (this == o)
					return true;
				return o instanceof ArrayAsList && Arrays.equals(array, ((ArrayAsList) o).array);
			}
		}

		private Map<ArrayAsList<T>, T[]> map = Maps.newHashMap();

		public @Nullable T[] intern(@Nullable T[] sample) {
			ArrayAsList<T> key = new ArrayAsList<T>(sample);
			T[] canonical = map.get(key);
			if (canonical == null) {
				canonical = sample;
				map.put(key, canonical);
			}
	        return canonical;
		}
	}

	private EObject forcedGrammarElement;

	private ArrayInterner<EObject> cachedFoldedGrammarElements = new ArrayInterner<EObject>();

	private boolean compressRoot = true;
	
	public void addChild(ICompositeNode node, AbstractNode child) {
		checkValidNewChild(child);
		CompositeNode composite = (CompositeNode) node;
		AbstractNode firstChild = composite.basicGetFirstChild();
		if (firstChild == null) {
			composite.basicSetFirstChild(child);
			initializeFirstChildInvariant(composite, child);
		} else {
			child.basicSetParent(composite);
			AbstractNode nodePreviousSibling = firstChild.basicGetPreviousSibling();
			child.basicSetPreviousSibling(nodePreviousSibling);
			child.basicSetNextSibling(firstChild);
			if (nodePreviousSibling != null) {
				nodePreviousSibling.basicSetNextSibling(child);
			}
			firstChild.basicSetPreviousSibling(child);
		}
	}
	
	public void associateWithSemanticElement(ICompositeNode node, EObject astElement) {
		CompositeNodeWithSemanticElement casted = (CompositeNodeWithSemanticElement) node;
		astElement.eAdapters().add(casted);
	}
	
	public ICompositeNode newCompositeNodeAsParentOf(EObject grammarElement, int lookahead, ICompositeNode existing) {
		CompositeNodeWithSemanticElement newComposite = new CompositeNodeWithSemanticElement();
		AbstractNode castedExisting = (AbstractNode) existing;
		newComposite.basicSetGrammarElement(grammarElement);
		newComposite.basicSetLookAhead(lookahead);
		CompositeNode existingParent = castedExisting.basicGetParent();
		newComposite.basicSetParent(existingParent);
		if (existingParent.basicGetFirstChild() == castedExisting) {
			existingParent.basicSetFirstChild(newComposite);
		}
		AbstractNode existingNextSibling = castedExisting.basicGetNextSibling();
		if (existingNextSibling == castedExisting) {
			newComposite.basicSetNextSibling(newComposite);
			newComposite.basicSetPreviousSibling(newComposite);
		} else {
			newComposite.basicSetNextSibling(existingNextSibling);
			existingNextSibling.basicSetPreviousSibling(newComposite);
			AbstractNode existingPreviousSibling = castedExisting.basicGetPreviousSibling();
			newComposite.basicSetPreviousSibling(existingPreviousSibling);
			existingPreviousSibling.basicSetNextSibling(newComposite);
		}
		newComposite.basicSetFirstChild(castedExisting);
		initializeFirstChildInvariant(newComposite, castedExisting);
		return compressAndReturnParent(existing);
	}

	protected void initializeFirstChildInvariant(CompositeNode node, AbstractNode child) {
		child.basicSetParent(node);
		child.basicSetNextSibling(child);
		child.basicSetPreviousSibling(child);
	}

	protected void checkValidNewChild(@Nullable AbstractNode child) {
		if (child == null)
			throw new IllegalArgumentException("child may not be null");
		if (child.basicGetNextSibling() != null || child.basicGetPreviousSibling() != null)
			throw new IllegalStateException("child has already a next or prev");
	}
	
	public ICompositeNode newCompositeNode(EObject grammarElement, int lookahead, ICompositeNode parent) {
		CompositeNodeWithSemanticElement result = new CompositeNodeWithSemanticElement();
		if (forcedGrammarElement != null) {
			result.basicSetGrammarElement(forcedGrammarElement);
			forcedGrammarElement = null;
		} else {
			result.basicSetGrammarElement(grammarElement);
		}
		result.basicSetLookAhead(lookahead);
		addChild(parent, result);
		return result;
	}
	
	public ICompositeNode newRootNode(String input) {
		RootNode result = new RootNode();
		result.basicSetCompleteContent(input);
		return result;
	}

	public ILeafNode newLeafNode(int offset, int length, EObject grammarElement, boolean isHidden, @Nullable SyntaxErrorMessage errorMessage,
			ICompositeNode parent) {
		LeafNode result = null;
		if (errorMessage != null) {
			if (isHidden) {
				result = new HiddenLeafNodeWithSyntaxError();
				((HiddenLeafNodeWithSyntaxError)result).basicSetSyntaxErrorMessage(errorMessage);
			} else {
				result = new LeafNodeWithSyntaxError();
				((LeafNodeWithSyntaxError)result).basicSetSyntaxErrorMessage(errorMessage);
			}
		} else {
			if (isHidden) {
				result = new HiddenLeafNode();
			} else {
				result = new LeafNode();
			}
		}
		result.basicSetGrammarElement(grammarElement);
		result.basicSetTotalOffset(offset);
		result.basicSetTotalLength(length);
		addChild(parent, result);
		return result;
	}
	
	public ICompositeNode compressAndReturnParent(ICompositeNode compositeNode) {
		CompositeNode casted = (CompositeNode) compositeNode;
		if (casted.basicGetParent() != null && casted.hasChildren() && casted.basicGetFirstChild() instanceof CompositeNode) {
			CompositeNode firstChild = (CompositeNode) casted.basicGetFirstChild();
			// it is our only child
			if (!firstChild.basicHasSiblings() && !firstChild.hasDirectSemanticElement()
					&& firstChild.getLookAhead() == casted.getLookAhead()
					&& firstChild.getSyntaxErrorMessage() == null) {
				// it is our only child and has no direct semantic element
				// so we can fold its grammar element into our own grammar elements
				// it refers not to a syntax error or a semantic object
				EObject myGrammarElement = casted.getGrammarElement();
				Object childGrammarElement = firstChild.basicGetGrammarElement();
				EObject[] list = null;
				if (childGrammarElement instanceof EObject) {
					list = new EObject[] {myGrammarElement, (EObject) childGrammarElement};
				} else {
					list = newEObjectArray(myGrammarElement, (EObject[]) childGrammarElement);
				}
				casted.basicSetGrammarElement(cachedFoldedGrammarElements.intern(list));
				replaceChildren(firstChild, casted);
			}
		}
		CompositeNode result = null;
		if (casted.basicGetSemanticElement() == null) {
			if (casted instanceof CompositeNodeWithSemanticElement) {
				if (casted.getSyntaxErrorMessage() == null) {
					CompositeNode compressed = new CompositeNode();
					compressed.basicSetGrammarElement(casted.basicGetGrammarElement());
					compressed.basicSetLookAhead(compositeNode.getLookAhead());
					replace(casted, compressed);
					result = compressed.basicGetParent();
				} else {
					CompositeNodeWithSyntaxError compressed = new CompositeNodeWithSyntaxError();
					compressed.basicSetGrammarElement(casted.basicGetGrammarElement());
					compressed.basicSetLookAhead(compositeNode.getLookAhead());
					compressed.basicSetSyntaxErrorMessage(casted.getSyntaxErrorMessage());
					replace(casted, compressed);
					result = compressed.basicGetParent();
				}
			}
		} 
		if (result == null) {
			result = casted.basicGetParent();
		}
		if (compressRoot && result instanceof RootNode) {
			if (casted.hasSiblings())
				throw new IllegalStateException("Root's child should never have siblings");
			RootNode root = (RootNode) result;
			if (casted.basicGetFirstChild() != null) {
				AbstractNode firstChild = casted.basicGetFirstChild();
				if (firstChild instanceof ILeafNode && !firstChild.basicHasNextSibling()) {
					return result;
				}
				root.basicSetFirstChild(firstChild);
				firstChild.basicSetParent(root);
				AbstractNode child = firstChild;
				while(child.basicHasNextSibling()) {
					child = child.basicGetNextSibling();
					child.basicSetParent(root);
				}
				root.basicSetGrammarElement(casted.basicGetGrammarElement());
				root.basicSetSemanticElement(casted.basicGetSemanticElement());
				root.basicSetSyntaxErrorMessage(casted.getSyntaxErrorMessage());
				root.basicSetLookAhead(casted.getLookAhead());
				EObject semanticElement = casted.getSemanticElement();
				if (semanticElement != null) {
					semanticElement.eAdapters().remove(casted);
					root.getSemanticElement().eAdapters().add(root);
				}
			}
		}
		return result;
	}
	
	private @Nullable EObject[] newEObjectArray(@Nullable EObject first, EObject[] rest) {
		EObject[] array = new EObject[rest.length + 1];
		array[0] = first;
		System.arraycopy(rest, 0, array, 1, rest.length);
		return array;
	}

	public INode setSyntaxError(INode node, SyntaxErrorMessage errorMessage) {
		if (node instanceof LeafNode) {
			LeafNode oldNode = (LeafNode) node;
			LeafNode newNode = null;
			if (oldNode.isHidden()) {
				HiddenLeafNodeWithSyntaxError newLeaf = new HiddenLeafNodeWithSyntaxError();
				newLeaf.basicSetSyntaxErrorMessage(errorMessage);
				newNode = newLeaf;
			} else {
				LeafNodeWithSyntaxError newLeaf = new LeafNodeWithSyntaxError();
				newLeaf.basicSetSyntaxErrorMessage(errorMessage);
				newNode = newLeaf;
			}
			newNode.basicSetTotalLength(oldNode.getTotalLength());
			newNode.basicSetTotalOffset(oldNode.getTotalOffset());
			newNode.basicSetGrammarElement(oldNode.basicGetGrammarElement());
			replace(oldNode, newNode);
			return newNode;
		} else {
			CompositeNode oldNode = (CompositeNode) node;
			CompositeNode newNode = null;
			if (oldNode.basicGetSemanticElement() != null) {
				CompositeNodeWithSemanticElementAndSyntaxError newComposite = new CompositeNodeWithSemanticElementAndSyntaxError();
				newComposite.basicSetSemanticElement(oldNode.basicGetSemanticElement());
				newComposite.basicSetSyntaxErrorMessage(errorMessage);
				oldNode.basicGetSemanticElement().eAdapters().remove(oldNode);
				newComposite.basicGetSemanticElement().eAdapters().add(newComposite);
				newNode = newComposite;
			} else {
				CompositeNodeWithSyntaxError newComposite = new CompositeNodeWithSyntaxError();
				newComposite.basicSetSyntaxErrorMessage(errorMessage);
				newNode = newComposite;
			}
			newNode.basicSetGrammarElement(oldNode.basicGetGrammarElement());
			newNode.basicSetLookAhead(oldNode.getLookAhead());
			replace(oldNode, newNode);
			return newNode;
		}
	}

	protected void replace(AbstractNode oldNode, AbstractNode newNode) {
		replaceWithoutChildren(oldNode, newNode);
		replaceChildren(oldNode, newNode);
	}

	protected void replaceChildren(AbstractNode oldNode, AbstractNode newNode) {
		if (oldNode instanceof CompositeNode) {
			CompositeNode oldComposite = (CompositeNode) oldNode;
			CompositeNode newComposite = (CompositeNode) newNode;
			AbstractNode child = oldComposite.basicGetFirstChild();
			if (child != null) {
				newComposite.basicSetFirstChild(child);
				while(child.basicGetParent() != newComposite) {
					child.basicSetParent(newComposite);
					child = child.basicGetNextSibling();
				}
			}
		}
	}
	
	public void replaceAndTransferLookAhead(INode oldNode, INode newRootNode) {
		AbstractNode newNode = ((CompositeNode) newRootNode).basicGetFirstChild();
		replaceWithoutChildren((AbstractNode) oldNode, newNode);
		if (oldNode instanceof ICompositeNode && newNode instanceof CompositeNode) {
			CompositeNode newCompositeNode = (CompositeNode) newNode;
			newCompositeNode.basicSetLookAhead(((ICompositeNode) oldNode).getLookAhead());
			// todo: unfold both nodes and compress afterwards
		}
		ICompositeNode root = newNode.getRootNode();
		BidiTreeIterator<AbstractNode> iterator = ((AbstractNode) root).basicIterator();
		int offset = 0;
		while(iterator.hasNext()) {
			AbstractNode node = iterator.next();
			if (node instanceof LeafNode) {
				((LeafNode) node).basicSetTotalOffset(offset);
				offset += node.getTotalLength();
			}
		}
	}

	protected void replaceWithoutChildren(AbstractNode oldNode, AbstractNode newNode) {
		CompositeNode parent = oldNode.basicGetParent();
		newNode.basicSetParent(parent);
		if (parent.basicGetFirstChild() == oldNode) {
			parent.basicSetFirstChild(newNode);
		}
		AbstractNode nextSibling = oldNode.basicGetNextSibling();
		if (nextSibling == oldNode) {
			newNode.basicSetNextSibling(newNode);
		} else {
			newNode.basicSetNextSibling(nextSibling);
			nextSibling.basicSetPreviousSibling(newNode);
		}
		AbstractNode previousSibling = oldNode.basicGetPreviousSibling();
		if (previousSibling == oldNode) {
			newNode.basicSetPreviousSibling(newNode);
		} else {
			newNode.basicSetPreviousSibling(previousSibling);
			previousSibling.basicSetNextSibling(newNode);
		}
	}

	public void setCompleteContent(ICompositeNode rootNode, String completeContent) {
		((RootNode)rootNode).basicSetCompleteContent(completeContent);
	}

	public void setForcedFirstGrammarElement(RuleCall ruleCall) {
		this.forcedGrammarElement = ruleCall;
		compressRoot = false;
	}

}
