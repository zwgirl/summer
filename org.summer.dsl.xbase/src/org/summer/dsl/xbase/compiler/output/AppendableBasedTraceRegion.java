/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler.output;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class AppendableBasedTraceRegion extends AbstractTraceRegion {
	private final List<ILocationData> locations;
	private int offset;
	private int length;
	private int lineNumber;
	private int endLineNumber;
	
	private boolean useForDebugging;
	
	@Override
	public boolean isUseForDebugging() {
		return useForDebugging;
	}

	public AppendableBasedTraceRegion(@Nullable AbstractTraceRegion parent, TreeAppendable delegate, int offset, int lineNumber) {
		super(parent);
		this.offset = offset;
		this.lineNumber = lineNumber;
		this.useForDebugging = delegate.isUseForDebugging();
		boolean useLocationsFromDelegate = true;
		if (parent != null) {
			URI parentPath = parent.getAssociatedPath();
			if (parentPath != null) {
				boolean matches = true;
				for(ILocationData locationData: delegate.getLocationData()) {
					if (!parentPath.equals(locationData.getPath())) {
						matches = false;
						break;
					}
				}
				useLocationsFromDelegate = !matches;
			}
		}
		if (useLocationsFromDelegate) {
			this.locations = Lists.newArrayList(delegate.getLocationData());
		} else {
			this.locations = Lists.newArrayList();
			for(ILocationData locationData: delegate.getLocationData()) {
				this.locations.add(new LocationData(locationData.getOffset(), locationData.getLength(), locationData.getLineNumber(), locationData.getEndLineNumber(), null));
			}
		}
		int length = 0;
		int line = lineNumber;
		for (Object child : delegate.getChildren()) {
			if (child instanceof TreeAppendable) {
				TreeAppendable castedChild = (TreeAppendable) child;
				if (hasVisibleChildren(castedChild)) {
					AppendableBasedTraceRegion childRegion = new AppendableBasedTraceRegion(
							this, castedChild, offset + length, line);
					length += childRegion.getMyLength();
					line = childRegion.getMyEndLineNumber();
				}
			} else {
				String s = child.toString();
				length += s.length();
				line += Strings.countLineBreaks(s);
			}
		}
		this.length = length;
		this.endLineNumber = line;
		if (parent == null) {
			compressTrace(delegate.getContent());
		}
	}
	
	protected void compressTrace(String completeContent) {
		leftCompressTrace(completeContent);
		rightCompressTrace(completeContent);
	}

	protected void leftCompressTrace(String completeContent) {
		List<AbstractTraceRegion> allNested = getWritableNestedRegions();
		int i = 0;
		while (i < allNested.size()) {
			AppendableBasedTraceRegion nested = (AppendableBasedTraceRegion) allNested.get(i);
			int offset = nested.getMyOffset();
			int diff = 0;
			while(completeContent.charAt(offset + diff) <= ' ' && diff < nested.length) {
				diff++;
			}
			if (diff == nested.length) {
				allNested.remove(i);
			} else {
				nested.lineNumber += Strings.countLineBreaks(completeContent.substring(offset, offset + diff));
				nested.offset += diff;
				nested.length -= diff;
				nested.leftCompressTrace(completeContent);
				i++;
			}
		}
	}
	
	protected void rightCompressTrace(String completeContent) {
		List<AbstractTraceRegion> allNested = getWritableNestedRegions();
		int i = 0;
		while (i < allNested.size()) {
			AppendableBasedTraceRegion nested = (AppendableBasedTraceRegion) allNested.get(i);
			int endOffset = nested.getMyOffset() + nested.getMyLength() - 1;
			int diff = 0;
			while(completeContent.charAt(endOffset - diff) <= ' ' && diff < nested.length) {
				diff++;
			}
			if (diff != 0) {
				nested.endLineNumber -= Strings.countLineBreaks(completeContent.substring(endOffset - diff + 1, endOffset + 1));
				nested.length -= diff;
				nested.rightCompressTrace(completeContent);
			}
			i++;
		}
	}

	protected boolean hasVisibleChildren(TreeAppendable castedChild) {
		for(Object o: castedChild.getChildren()) {
			if (o instanceof String)
				return true;
			if (hasVisibleChildren((TreeAppendable) o))
				return true;
		}
		return false;
	}

	@Override
	public int getMyLength() {
		return length;
	}

	@Override
	public int getMyOffset() {
		return offset;
	}
	
	@Override
	public int getMyLineNumber() {
		return lineNumber;
	}
	
	@Override
	public int getMyEndLineNumber() {
		return endLineNumber;
	}

	@Override
	public List<ILocationData> getAssociatedLocations() {
		return locations;
	}
	
}