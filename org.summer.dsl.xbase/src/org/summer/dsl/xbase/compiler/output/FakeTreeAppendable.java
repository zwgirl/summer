/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler.output;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmType;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.summer.dsl.xbase.compiler.ImportManager;
import org.summer.dsl.xbase.compiler.StringBuilderBasedAppendable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FakeTreeAppendable extends StringBuilderBasedAppendable implements ITreeAppendable {

	public FakeTreeAppendable() {
		super();
	}

	public FakeTreeAppendable(ImportManager typeSerializer, String indentation, String lineSeparator) {
		super(typeSerializer, indentation, lineSeparator);
	}

	public FakeTreeAppendable(ImportManager typeSerializer) {
		super(typeSerializer);
	}

	@Override
	public ITreeAppendable append(JvmType type) {
		super.append(type);
		return this;
	}
	
	@Override
	public ITreeAppendable append(CharSequence string) {
		super.append(string);
		return this;
	}
	
	@Override
	public ITreeAppendable decreaseIndentation() {
		super.decreaseIndentation();
		return this;
	}
	
	@Override
	public ITreeAppendable increaseIndentation() {
		super.increaseIndentation();
		return this;
	}
	
	@Override
	public ITreeAppendable newLine() {
		super.newLine();
		return this;
	}
	
	public AbstractTraceRegion getTraceRegion() {
		throw new UnsupportedOperationException("FakeTreeAppendable cannot provide trace information");
	}

	public ITreeAppendable trace(EObject object, boolean useForDebugging) {
		return this;
	}
	
	public ITreeAppendable trace(ILocationData location) {
		return this;
	}
	
	public ITreeAppendable trace(ILocationData location, boolean useForDebugging) {
		return this;
	}

	public ITreeAppendable trace(Iterable<? extends EObject> objects) {
		return this;
	}
	
	public ITreeAppendable trace(EObject object, EStructuralFeature feature, int indexInList) {
		return this;
	}

	public ITreeAppendable trace(EObject object) {
		return this;
	}

	public ErrorTreeAppendable errorChild(EObject context) {
		throw new UnsupportedOperationException();
	}

}