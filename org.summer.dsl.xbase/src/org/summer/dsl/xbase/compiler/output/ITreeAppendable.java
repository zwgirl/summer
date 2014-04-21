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
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.summer.dsl.xbase.compiler.IAppendable;

/**
 * A specialized appendable that can be used to trace the source location
 * for the written output.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface ITreeAppendable extends IAppendable, ITraceRegionProvider {

	/**
	 * @param object the object this part should be associated with
	 * @param useForDebugging whether the part is relevant for debugging
	 */
	ITreeAppendable trace(EObject object, boolean useForDebugging);
	
	/**
	 * same as trace(object, false) 
	 */
	ITreeAppendable trace(EObject object);
	
	/**
	 * @param objects the iterable of {@link EObject}s that contribute output. May not be empty.
	 */
	ITreeAppendable trace(Iterable<? extends EObject> objects);
	
	ITreeAppendable trace(EObject object, EStructuralFeature feature, int indexInList);
	
	ITreeAppendable trace(ILocationData location);
	
	/**
	 * @param location the location that should be traced
	 * @param useForDebugging whether the part is relevant for debugging
	 */
	ITreeAppendable trace(ILocationData location, boolean useForDebugging);
	
	ErrorTreeAppendable errorChild(EObject context);
	
	ITreeAppendable append(JvmType type);
	
	ITreeAppendable append(CharSequence content);
	
	ITreeAppendable decreaseIndentation();
	
	ITreeAppendable increaseIndentation();
	
	ITreeAppendable newLine();

}
