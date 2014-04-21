/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler.output;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmType;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.ILocationInFileProviderExtension;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.summer.dsl.xbase.compiler.ImportManager;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReferenceSerializer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TreeAppendable implements ITreeAppendable, IAcceptor<String>, CharSequence {

	private static final Logger log = Logger.getLogger(TreeAppendable.class);
	
	/**
	 * A {@link org.summer.dsl.xbase.compiler.output.TreeAppendable.Visitor visitor} can be used
	 * to manipulate an existing {@link TreeAppendable} or to create a completely new one recursively.
	 * Implementors may override {@link #visit(String)} and {@link #visit(TreeAppendable)}
	 */
	public abstract static class Visitor {
		/**
		 * Manipulate the given appendable or return a new one.
		 * @param original the visited {@link TreeAppendable}
		 * @return the original appendable or a new one.
		 */
		protected TreeAppendable visit(TreeAppendable original) {
			visitChildren(original);
			return original;
		}

		/**
		 * Traverses the children of the given appendable and manipulates it in-place.
		 * @param parent the appendable whose children should be visited.
		 */
		protected void visitChildren(TreeAppendable parent) {
			for (int i = 0; i < parent.children.size(); i++) {
				Object o = parent.children.get(i);
				if (o instanceof String) {
					parent.children.set(i, visit((String) o));
				} else {
					parent.children.set(i, visit((TreeAppendable) o));
				}
			}
		}

		/**
		 * Manipulate the given string and return the result.
		 * @param string the visited {@link String}
		 * @return the original string or a new one.
		 */
		protected String visit(@NonNull String string) {
			return string;
		}
	}

	private List<Object> children;
	private final SharedAppendableState state;
	private final ILocationInFileProvider locationProvider;
	private final IJvmModelAssociations jvmModelAssociations;
	private final Set<ILocationData> locationData;
	private final ITraceURIConverter traceURIConverter;
	private boolean closed = false;
	private boolean useForDebugging = false;
	private LightweightTypeReferenceSerializer lightweightTypeReferenceSerializer;
	
	public TreeAppendable(ImportManager importManager, ITraceURIConverter converter, ILocationInFileProvider locationProvider, IJvmModelAssociations jvmModelAssociations, EObject source,
			String indentation, String lineSeparator) {
		this(new SharedAppendableState(indentation, lineSeparator, importManager), converter, locationProvider, jvmModelAssociations, source);
	}

	protected TreeAppendable(SharedAppendableState state, ITraceURIConverter converter, ILocationInFileProvider locationProvider, IJvmModelAssociations jvmModelAssociations, EObject source) {
		this(state, converter, locationProvider, jvmModelAssociations, createAllLocationData(converter, locationProvider, jvmModelAssociations, source, ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS), false);
	}
	
	protected TreeAppendable(SharedAppendableState state,
			ITraceURIConverter converter,
			ILocationInFileProvider locationProvider,
			IJvmModelAssociations jvmModelAssociations,
			Set<ILocationData> sourceLocations, 
			boolean useForDebugging) {
		this.state = state;
		this.traceURIConverter = converter;
		this.locationProvider = locationProvider;
		this.jvmModelAssociations = jvmModelAssociations;
		this.children = Lists.newArrayList();
		this.locationData = sourceLocations;
		this.useForDebugging = useForDebugging;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
	}
	
	protected LightweightTypeReferenceSerializer createLightweightTypeReferenceSerializer() {
		return new LightweightTypeReferenceSerializer(this);
	}
	
	public boolean isJava() {
		return true;
	}
	
	public ITraceURIConverter getTraceURIConverter() {
		return traceURIConverter;
	}
	
	/**
	 * @since 2.4
	 */
	public ErrorTreeAppendable errorChild(EObject context) {
		ErrorTreeAppendable errorChild = new ErrorTreeAppendable(state, traceURIConverter, locationProvider, jvmModelAssociations, getLocationData(), useForDebugging, context);
		children.add(errorChild);
		return errorChild;
	}

	public TreeAppendable trace(EObject object) {
		return trace(object, false);
	}
	
	public TreeAppendable trace(EObject object, boolean useForDebugging) {
		return trace(object, ILocationInFileProviderExtension.RegionDescription.FULL, useForDebugging);
	}
	
	public TreeAppendable trace(EObject object, ILocationInFileProviderExtension.RegionDescription region, boolean useForDebugging) {
		// TODO use locationProvider from service registry
		Set<ILocationData> locationData = createAllLocationData(traceURIConverter, locationProvider, jvmModelAssociations, object, region);
		if (locationData.isEmpty())
			return this;
		return trace(locationData, useForDebugging);
	}

	protected TreeAppendable trace(Set<ILocationData> newData, boolean useForDebugging) {
		if (this.useForDebugging == useForDebugging && newData.equals(locationData)) {
			return this;
		}
		TreeAppendable result = createChild(state, locationProvider, jvmModelAssociations, newData, useForDebugging);
		if(result != this)
			children.add(result);
		return result;
	}

	/**
	 * @since 2.4
	 */
	protected TreeAppendable createChild(SharedAppendableState state, ILocationInFileProvider locationProvider, IJvmModelAssociations jvmModelAssociations, Set<ILocationData> newData, boolean useForDebugging) {
		return new TreeAppendable(state, traceURIConverter, locationProvider, jvmModelAssociations, newData, useForDebugging);
	}
	
	public ITreeAppendable trace(ILocationData location) {
		return trace(location, false);
	}
	
	public ITreeAppendable trace(ILocationData location, boolean useForDebugging) {
		return trace(Collections.singleton(location), useForDebugging);
	}

	@Nullable
	protected static ILocationData createLocationData(ITraceURIConverter converter, ILocationInFileProvider locationProvider, EObject object, ILocationInFileProviderExtension.RegionDescription query) {
		ITextRegion textRegion = locationProvider instanceof ILocationInFileProviderExtension ? 
				((ILocationInFileProviderExtension) locationProvider).getTextRegion(object, query) : locationProvider.getFullTextRegion(object);
		if (!(textRegion instanceof ITextRegionWithLineInformation)) {
			if (log.isDebugEnabled())
				log.debug("location provider returned text region without line information.", new Exception());
			if (textRegion != null)
				textRegion = new TextRegionWithLineInformation(textRegion.getOffset(), textRegion.getLength(), 0, 0);
			else
				return null;
		} 
		ILocationData newData = createLocationData(converter, object, (ITextRegionWithLineInformation) textRegion);
		return newData;
	}
	
	protected static Set<ILocationData> createAllLocationData(ITraceURIConverter converter, ILocationInFileProvider locationProvider, IJvmModelAssociations jvmModelAssociations, EObject object, ILocationInFileProviderExtension.RegionDescription query) {
		Set<EObject> sourceElements = jvmModelAssociations.getSourceElements(object);
		Set<ILocationData> result = Collections.emptySet();
		if (sourceElements.isEmpty()) {
			ILocationData locationData = createLocationData(converter, locationProvider, object, query);
			if (locationData != null) {
				result = Collections.singleton(locationData);
			}
		} else {
			result = Sets.newHashSet();
			for(EObject sourceElement: sourceElements) {
				ILocationData locationData = createLocationData(converter, locationProvider, sourceElement, query);
				if (locationData != null) {
					result.add(locationData);
				}	
			}
		}
		return result;
	}
	
	public ITreeAppendable trace(Iterable<? extends EObject> objects) {
		if (Iterables.isEmpty(objects))
			throw new IllegalArgumentException("List of objects may not be empty");
		int size = Iterables.size(objects);
		if (size == 1)
			return trace(objects.iterator().next(), false);
		Set<ILocationData> newData = new LinkedHashSet<ILocationData>(size);
		for(EObject object: objects) {
			ILocationData locationData = createLocationData(traceURIConverter, locationProvider, object, ILocationInFileProviderExtension.RegionDescription.FULL);
			if (locationData != null)
				newData.add(locationData);
		}
		if (newData.isEmpty() && !isUseForDebugging())
			return this;
		return trace(newData, false);
	}
	
	public ITreeAppendable trace(EObject object, EStructuralFeature feature, int indexInList) {
		ITextRegion textRegion = locationProvider.getFullTextRegion(object, feature, indexInList);
		if (!(textRegion instanceof ITextRegionWithLineInformation)) {
			if (log.isDebugEnabled())
				log.debug("location provider returned text region without line information. Synthesized dummy data.", new Exception());
			textRegion = new TextRegionWithLineInformation(textRegion.getOffset(), textRegion.getLength(), 0, 0);
		} 
		ILocationData newData = createLocationData(traceURIConverter, object, (ITextRegionWithLineInformation) textRegion);
		return trace(Collections.singleton(newData), false);
	}

	protected static ILocationData createLocationData(ITraceURIConverter converter, EObject object, ITextRegionWithLineInformation textRegion) {
		URI uri = null;
		if (object.eResource() instanceof XtextResource)
			uri = converter.getURIForTrace((XtextResource) object.eResource());
		ILocationData newData = new LocationData(textRegion, uri);
		return newData;
	}

	public TreeAppendable acceptVisitor(TreeAppendable.Visitor visitor) {
		return visitor.visit(this);
	}

	public Set<ILocationData> getLocationData() {
		return locationData;
	}
	
	/**
	 * Access the children of the {@link TreeAppendable}. The list contains either {@link String strings}
	 * or other {@link TreeAppendable TreeAppendables}. The list may be empty.
	 * @return the children of this appendable.
	 */
	public List<? extends Object> getChildren() {
		return children;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void accept(@Nullable String text) {
		children.add(text);
	}

	protected void markClosed() {
		if (closed)
			return;
		closeLastChild();
		closed = true;
	}

	protected void closeLastChild() {
		if (closed) {
			throw new IllegalStateException("TreeAppendable was already closed");
		}
		if (!children.isEmpty()) {
			Object lastChild = children.get(children.size() - 1);
			if (lastChild instanceof TreeAppendable) {
				((TreeAppendable) lastChild).markClosed();
			}
		}
	}

	protected boolean isClosed() {
		return closed;
	}
	
	public TreeAppendable append(JvmType type) {
		closeLastChild();
		state.appendType(type, this);
		return this;
	}
	
	public TreeAppendable append(LightweightTypeReference typeRef) {
		typeRef.accept(lightweightTypeReferenceSerializer);
		return this;
	}
	
	protected ITreeAppendable appendTreeAppendable(ITreeAppendable other) {
		closeLastChild();
		if (other instanceof TreeAppendable) {
			((TreeAppendable) other).markClosed();
		} else {
			// TODO improve
			throw new IllegalArgumentException("Unexpected implementation");
		}
		children.add(other);
		return this;
	}

	public ITreeAppendable append(CharSequence content) {
		if (content instanceof ITreeAppendable) {
			return appendTreeAppendable((ITreeAppendable)content);
		}
		closeLastChild();
		appendIndented(content.toString());
		return this;
	}

	public TreeAppendable appendUnsafe(String string) {
		accept(string);
		return this;
	}

	public TreeAppendable newLine() {
		closeLastChild();
		state.appendNewLineAndIndentation(this);
		return this;
	}

	public TreeAppendable increaseIndentation() {
		closeLastChild();
		state.increaseIndentation();
		return this;
	}

	public TreeAppendable decreaseIndentation() {
		closeLastChild();
		state.decreaseIndentation();
		return this;
	}

	@Deprecated
	public List<String> getImports() {
		return state.getImports();
	}

	public void openScope() {
		state.openScope();
	}

	public void openPseudoScope() {
		state.openPseudoScope();
	}

	public String declareVariable(Object key, String proposedName) {
		return state.declareVariable(key, proposedName);
	}

	public String declareSyntheticVariable(Object key, String proposedName) {
		return state.declareSyntheticVariable(key, proposedName);
	}

	public String getName(Object key) {
		return state.getName(key);
	}

	public boolean hasName(Object key) {
		return state.hasName(key);
	}

	public Object getObject(String name) {
		return state.getObject(name);
	}

	public boolean hasObject(String name) {
		return state.hasObject(name);
	}

	public void closeScope() {
		state.closeScope();
	}

	public String getContent() {
		StringBuilder result = new StringBuilder(8 * 1024);
		doGetContent(result);
		return result.toString();
	}
	
	public char charAt(int index) {
		return toString().charAt(index);
	}
	
	public CharSequence subSequence(int start, int end) {
		return toString().subSequence(start, end);
	}
	
	@Override
	public String toString() {
		return getContent();
	}

	protected void doGetContent(StringBuilder result) {
		for (Object child : children) {
			if (child instanceof String) {
				result.append(child);
			} else {
				((TreeAppendable) child).doGetContent(result);
			}
		}
	}

	public int length() {
		return toString().length();
	}

	public AbstractTraceRegion getTraceRegion() {
		if (locationData == null) {
			throw new IllegalStateException("tree appendable was used without tracing");
		}
		return new AppendableBasedTraceRegion(null, this, 0, 0);
	}

	protected void appendIndented(String text) {
		int length = text.length();
		int nextLineOffset = 0;
		int idx = 0;
		while (idx < length) {
			char currentChar = text.charAt(idx);
			// check for \r or \r\n
			if (currentChar == '\r') {
				int delimiterLength = 1;
				if (idx + 1 < length && text.charAt(idx + 1) == '\n') {
					delimiterLength++;
					idx++;
				}
				int lineLength = idx - delimiterLength - nextLineOffset + 1;
				children.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
				state.appendNewLineAndIndentation(this);
				nextLineOffset = idx + 1;
			} else if (currentChar == '\n') {
				int lineLength = idx - nextLineOffset;
				children.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
				state.appendNewLineAndIndentation(this);
				nextLineOffset = idx + 1;
			}
			idx++;
		}
		if (nextLineOffset != length) {
			int lineLength = length - nextLineOffset;
			children.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
		}
	}

	public boolean isUseForDebugging() {
		if (useForDebugging) {
			// HACK only count if it has 'direct' content not just sub trees.
			for (Object c : children) {
				if (!(c instanceof ITreeAppendable))
					return true;
			}
		}
		return false;
	}

	/**
	 * @since 2.4
	 */
	public SharedAppendableState getState() {
		return state;
	}
	
	ImportManager getImportManager() {
		return state.getImportManager();
	}
	
	String getLineSeparator() {
		return state.getLineSeparator();
	}
	
	String getIndentationString() {
		return state.getIndentationString();
	}
	
	/**
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 2.4
	 */
	public void dump() {
		dump("");
		System.out.println();
	}
	
	/**
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 2.4
	 */
	protected void dump(String indent) {
		if(closed) 
			System.out.println(indent + "<closed>");
		StringBuilder currentChildren = null;
		for(Object child: children) {
			if(child instanceof TreeAppendable) {
				if(currentChildren != null)
					System.out.println(indent + currentChildren.toString());
				currentChildren = null; 
				((TreeAppendable) child).dump("  " + indent);
			}
			else {
				if(currentChildren == null)
					currentChildren = new StringBuilder();
				currentChildren.append(child.toString().replace(state.getLineSeparator(), "\\n"));
			}
		}
		if(currentChildren != null)
			System.out.println(indent + currentChildren.toString());
		if(closed) 
			System.out.println(indent + "</closed>");
	}
	
}
