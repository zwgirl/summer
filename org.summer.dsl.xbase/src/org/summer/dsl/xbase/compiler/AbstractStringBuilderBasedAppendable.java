/*******************************************************************************

 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReferenceSerializer;

@NonNullByDefault
public abstract class AbstractStringBuilderBasedAppendable implements IAppendable {

	private StringBuilder builder = new StringBuilder(8 * 1024);
	private int indentationlevel = 0;
	private String indentation = "  ";
	private String lineSeparator = "\n";
	private boolean isJava;
	
	private LightweightTypeReferenceSerializer lightweightTypeReferenceSerializer;
	
	public AbstractStringBuilderBasedAppendable(String indentation, String lineSeparator, boolean isJava) {
		this.indentation = indentation;
		this.lineSeparator = lineSeparator;
		this.isJava = isJava;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
		openScope();
	}

	public AbstractStringBuilderBasedAppendable(boolean isJava) {
		this.isJava = isJava;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
		openScope();
	}
	
	public boolean isJava() {
		return isJava;
	}

	public IAppendable append(JvmType type) {
		appendType(type, builder);
		return this;
	}

	public IAppendable append(LightweightTypeReference typeRef) {
		typeRef.accept(lightweightTypeReferenceSerializer);
		return this;
	}

	protected LightweightTypeReferenceSerializer createLightweightTypeReferenceSerializer() {
		return new LightweightTypeReferenceSerializer(this);
	}
	
	public IAppendable append(CharSequence string) {
		String replaced = string.toString().replace(lineSeparator, getIndentationString());
		builder.append(replaced);
		return this;
	}
	
	public IAppendable newLine() {
		builder.append(getIndentationString());
		return this;
	}

	protected CharSequence getIndentationString() {
		StringBuilder sb = new StringBuilder(10);
		sb.append(lineSeparator);
		for (int i = 0; i < indentationlevel; i++) {
			sb.append(indentation);
		}
		return sb.toString();
	}
	
	protected int getIndentationLevel() {
		return indentationlevel;
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}
	
	public String getContent() {
		return toString();
	}
	
	public int length() {
		return builder.length();
	}

	public IAppendable increaseIndentation() {
		indentationlevel++;
		return this;
	}

	public IAppendable decreaseIndentation() {
		if (indentationlevel == 0)
			throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
		indentationlevel--;
		return this;
	}

	private ScopeStack scopes = new ScopeStack();
	
	public void setScopeStack(ScopeStack scopes) {
		this.scopes = scopes;
	}

	public void openScope() {
		scopes.openScope(false);
	}
	
	public void openPseudoScope() {
		scopes.openScope(true);
	}
	
	public String declareVariable(Object key, String proposedName) {
		return scopes.declareVariable(key, proposedName, false);
	}
	
	public String declareSyntheticVariable(Object key, String proposedName) {
		return scopes.declareVariable(key, proposedName, true);
	}
	
	public void closeScope() {
		scopes.closeScope();
	}

	protected abstract void appendType(final JvmType type, StringBuilder builder);
	
	@Deprecated
	public abstract List<String> getImports();

	public String getName(Object key) {
		String result = scopes.getName(key);
		if (result == null)
			throw new IllegalStateException("Cannot get name for " + key);
		return result;
	}
	
	public boolean hasName(Object key) {
		return scopes.getName(key) != null;
	}

	public Object getObject(String name) {
		Object result = scopes.get(name);
		if (result == null)
			throw new IllegalStateException("Cannot get object for " + name);
		return result;
	}
	
	public boolean hasObject(String name) {
		return scopes.get(name) != null;
	}
	
	protected String getLineSeparator() {
		return lineSeparator;
	}
	
	public char charAt(int index) {
		return builder.charAt(index);
	}
	
	public CharSequence subSequence(int start, int end) {
		return builder.subSequence(start, end);
	}
}