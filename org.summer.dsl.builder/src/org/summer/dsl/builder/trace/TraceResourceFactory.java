/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.trace;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer.Callback;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceResourceFactory extends ResourceFactoryImpl {
	
	protected class Strategy implements TraceRegionSerializer.Strategy<DebugTraceRegion, DebugLocationData> {

		public DebugLocationData createLocation(int offset, int length, int lineNumber, int endLineNumber, URI path) {
			DebugLocationData result = TraceFactory.eINSTANCE.createDebugLocationData();
			result.setOffset(offset);
			result.setLength(length);
			result.setLineNumber(lineNumber);
			result.setEndLineNumber(endLineNumber);
			result.setPath(path);
			return result;
		}

		public DebugTraceRegion createRegion(int offset, int length, int lineNumber, int endLineNumber, List<DebugLocationData> associations,
				DebugTraceRegion parent) {
			DebugTraceRegion result = TraceFactory.eINSTANCE.createDebugTraceRegion();
			result.setMyOffset(offset);
			result.setMyLength(length);
			result.setMyLineNumber(lineNumber);
			result.setMyEndLineNumber(endLineNumber);
			result.getAssociations().addAll(associations);
			if (parent != null)
				parent.getNestedRegions().add(result);
			return result;
		}

		public void writeRegion(DebugTraceRegion region, Callback<DebugTraceRegion, DebugLocationData> callback)
				throws IOException {
			callback.doWriteRegion(region.getMyOffset(), region.getMyLength(), region.getMyLineNumber(), region.getMyEndLineNumber(), region.getAssociations(), region.getNestedRegions());
		}

		public void writeLocation(DebugLocationData location, Callback<DebugTraceRegion, DebugLocationData> callback)
				throws IOException {
			callback.doWriteLocation(location.getOffset(), location.getLength(), location.getLineNumber(), location.getEndLineNumber(), location.getPath());
		}
	}

	@Override
	public Resource createResource(URI uri) {
		Resource result = new ResourceImpl(uri) {
			@Override
			protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
				TraceRegionSerializer serializer = new TraceRegionSerializer();
				DebugTraceRegion result = serializer.doReadFrom(inputStream, new Strategy());
				getContents().add(result);
			}

			@Override
			protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
				TraceRegionSerializer serializer = new TraceRegionSerializer();
				serializer.doWriteTo(new Strategy(), (DebugTraceRegion) getContents().get(0), outputStream);
			}
		};
		return result;
	}
}
