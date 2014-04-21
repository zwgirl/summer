/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractStatefulTraceRegion extends AbstractTraceRegion {

	private final ITextRegionWithLineInformation myRegion;
	private final List<ILocationData> associatedLocations;

	protected AbstractStatefulTraceRegion(ITextRegionWithLineInformation myRegion, ILocationData associatedLocation, @Nullable AbstractTraceRegion parent) {
		this(myRegion, Lists.newArrayList(associatedLocation), parent);
	}
	
	protected AbstractStatefulTraceRegion(ITextRegionWithLineInformation myRegion, List<ILocationData> associatedLocations, @Nullable AbstractTraceRegion parent) {
		super(parent);
		this.myRegion = myRegion;
		this.associatedLocations = associatedLocations;
		if (!isConsistentWithParent()) {
			throw new IllegalArgumentException("Produced region is inconsisten with parent, this: " + this + ", parent: " + parent);
		}
	}
	
	@Override
	public int getMyLength() {
		return myRegion.getLength();
	}

	@Override
	public int getMyOffset() {
		return myRegion.getOffset();
	}
	
	@Override
	public int getMyEndLineNumber() {
		return myRegion.getEndLineNumber();
	}
	
	@Override
	public int getMyLineNumber() {
		return myRegion.getLineNumber();
	}
	
	@Override
	public ITextRegionWithLineInformation getMyRegion() {
		return myRegion;
	}

	@Override
	public List<ILocationData> getAssociatedLocations() {
		return Collections.unmodifiableList(associatedLocations);
	}
	
	protected List<ILocationData> getWritableAssociatedLocations() {
		return associatedLocations;
	}
	
}
