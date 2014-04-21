/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

/**
 * A trace region that will not be added to the child list of the given parent.
 */
@NonNullByDefault
public class TemporaryTraceRegion extends AbstractStatefulTraceRegion {
	public TemporaryTraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, List<ILocationData> locations,
			AbstractTraceRegion parent) {
		super(new TextRegionWithLineInformation(myOffset, myLength, myLineNumber, myEndLineNumber), locations, parent);
	}

	@Override
	protected void setAsChildIn(AbstractTraceRegion parent) {
		// we don't want to add temporary regions to the parent's child list
	}
}