/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Mark Christiaens - Serialization support
 * @noextend This class is not intended to be subclassed by clients.
 */
public class RootNode extends CompositeNodeWithSemanticElementAndSyntaxError {

	private String completeContent;
	
	private int[] lineBreakOffsets;
	
	/**
	 * @return <code>null</code> the root node does not have any parent.
	 */
	@Override
	public CompositeNode getParent() {
		return null;
	}

	@Override
	public ICompositeNode getRootNode() {
		return this;
	}
	
	@Override
	public int getTotalOffset() {
		return 0;
	}

	@Override
	public int getTotalLength() {
		return getCompleteContent().length();
	}

	@Override
	public String getText() {
		return getCompleteContent();
	}

	public int getIndex() {
		return 0;
	}
	
	protected void basicSetCompleteContent(String completeContent) {
		this.completeContent = completeContent;
		this.lineBreakOffsets = computeLineBreaks(completeContent);
	}
	
	/**
	 * Returns an array that contains the offsets of each line break in the input.
	 * Note that the result is not a copy but the actually internal data structure of 
	 * this node.
	 * @return an array of offsets of each line break in the input or <code>null</code> 
	 *   if the {@link #completeContent} has not been set.
	 * @since 2.0
	 */
	protected int[] basicGetLineBreakOffsets() {
		return lineBreakOffsets;
	}
	
	public String getCompleteContent() {
		return completeContent;
	}
	
	@Override
	public INode getNextSibling() {
		return null;
	}
	
	@Override
	public INode getPreviousSibling() {
		return null;
	}
	
	@Override
	protected AbstractNode basicGetNextSibling() {
		return this;
	}
	
	@Override
	protected AbstractNode basicGetPreviousSibling() {
		return this;
	}
	
	@Override
	protected boolean basicHasPreviousSibling() {
		return false;
	}
	
	@Override
	protected boolean basicHasNextSibling() {
		return false;
	}
	
	@Override
	public boolean hasPreviousSibling() {
		return false;
	}
	
	@Override
	public boolean hasNextSibling() {
		return false;
	}
	
	@Override
	public boolean hasSiblings() {
		return false;
	}
	
	@Override
	protected void basicSetNextSibling(AbstractNode next) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void basicSetPreviousSibling(AbstractNode prev) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void basicSetParent(CompositeNode parent) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <p>Computes the line breaks in the given text and returns an array of offsets.
	 * A line break is either <code>\r\n</code>, <code>\n</code>, or a single <code>\r</code>.</p>
	 * This implementation was heavily adapted from <code>org.eclipse.jface.text.DefaultLineTracker</code>.
	 * @param text the text whose line-breaks should be computed. May not be <code>null</code>.
	 * @return the array of line-break offsets in the given text. May be empty but is never <code>null</code>.
	 * @since 2.0
	 */
	protected int[] computeLineBreaks(String text) {
		List<Integer> list = Lists.newArrayListWithExpectedSize(50);
		char ch;
		int length= text.length();
		for (int i= 0; i < length; i++) {
			ch= text.charAt(i);
			if (ch == '\r') {
				list.add(i);
				if (i + 1 < length) {
					if (text.charAt(i + 1) == '\n') {
						i++;
					}
				}
			} else if (ch == '\n') {
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = list.get(i).intValue();
		}
		return result;
	}
	
	@Override
	void readData(DataInputStream in, DeserializationConversionContext context) throws IOException {
		super.readData(in, context);

		basicSetCompleteContent(context.getCompleteContent());

		int totalLength = fixupOffsets(this, 0);

		if (totalLength != getCompleteContent().length()) {
			throw new IllegalStateException("The length of the resource's content was " + getCompleteContent().length()
					+ " but the length calculated based upon the serialized form of the RootNode was " + totalLength);
		}
	}
	
	private int fixupOffsets(INode node, int nodeOffset) {
		if (node instanceof LeafNode) {
			LeafNode leafNode = (LeafNode) node;
			leafNode.basicSetTotalOffset(nodeOffset);
			return leafNode.getTotalLength() + nodeOffset;
		}

		if (node instanceof CompositeNode) {
			CompositeNode compositeNode = (CompositeNode) node;

			int currentOffset = nodeOffset;

			AbstractNode firstChild = compositeNode.basicGetFirstChild();

			if (firstChild != null) {
				AbstractNode it = firstChild;

				do {
					currentOffset = fixupOffsets(it, currentOffset);
					it = it.basicGetNextSibling();
				} while (it != firstChild);
			}

			return currentOffset;
		}

		return 0;
	}

	@Override
	NodeType getNodeId() {
		return NodeType.RootNode;
	}

	/**
	 * @since 2.3
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void fillGrammarElementToIdMap(Map<EObject, Integer> grammarElementToIdMap,
			List<String> grammarIdToURIMap) {
		fillGrammarElementToIdMap(0, grammarElementToIdMap, grammarIdToURIMap);
	}
}
