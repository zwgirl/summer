/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newLinkedHashSet;
import static org.eclipse.xtext.util.Strings.equal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.xbase.scoping.batch.Buildin;

import com.google.common.collect.Sets;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportManager {

	private Map<String, String> imports = newHashMap();

	private boolean organizeImports;

	private Set<String> thisTypeSimpleNames = Sets.newHashSet();
	private Set<String> thisTypeQualifiedNames = Sets.newHashSet();

	private final char innerTypeSeparator;

	public ImportManager(boolean organizeImports, char innerTypeSeparator) {
		this(organizeImports, null, innerTypeSeparator);
	}

	public ImportManager() {
		this(true, null);
	}

	public ImportManager(boolean organizeImports) {
		this(organizeImports, null);
	}

	public ImportManager(boolean organizeImports, JvmModule thisModule) {
		this(organizeImports, thisModule, '.');
	}

	public ImportManager(boolean organizeImports, JvmModule thisModule, char innerTypeSeparator) {
		this.organizeImports = organizeImports;
		this.innerTypeSeparator = innerTypeSeparator;
		if (thisModule != null) {
			thisTypeSimpleNames.add(thisModule.getSimpleName());
			thisTypeQualifiedNames.add(thisModule.getQualifiedName(innerTypeSeparator));
		}
	}

	public CharSequence serialize(JvmType type) {
		StringBuilder sb = new StringBuilder();
		appendType(type, sb);
		return sb;
	}

	public CharSequence serialize(Class<?> type) {
		StringBuilder sb = new StringBuilder();
		appendType(type, sb);
		return sb;
	}


	public void appendType(final JvmType type, StringBuilder builder) {
//		if (type instanceof JvmPrimitiveType || type instanceof JvmVoid || type instanceof JvmTypeParameter) {
		if (type.isPrimitive() || type == Buildin.Void.JvmType || type instanceof JvmTypeParameter) {
			builder.append(type.getQualifiedName(innerTypeSeparator));
		} else if (type instanceof JvmArrayType) {
			appendType(((JvmArrayType) type).getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getQualifiedName(innerTypeSeparator);
			String nameToImport = qualifiedName;
			String shortName = type.getSimpleName();
			appendType(qualifiedName, shortName, nameToImport, builder);
		}
	}

	public void appendType(final Class<?> type, StringBuilder builder) {
		if (type.isPrimitive()) {
			builder.append(type.getSimpleName());
		} else if (type.isArray()) {
			appendType(type.getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getCanonicalName();
			String nameToImport = qualifiedName;
			String shortName = type.getSimpleName();
			appendType(qualifiedName, shortName, nameToImport, builder);
		}
	}

	protected void appendType(final String qualifiedName, final String shortName, final String namespaceImport, StringBuilder builder) {
		if (allowsSimpleName(namespaceImport, shortName)) {
			builder.append(shortName);
		} else if (needsQualifiedName(namespaceImport, shortName)) {
			builder.append(qualifiedName);
		} else {
			if (imports.containsKey(shortName)) {
				if (namespaceImport.equals(imports.get(shortName))) {
					builder.append(shortName);
				} else {
					builder.append(qualifiedName);
				}
			} else {
				imports.put(shortName, namespaceImport);
				builder.append(shortName);
			}
		}
	}

	protected boolean allowsSimpleName(String qualifiedName, String simpleName) {
		return thisTypeQualifiedNames.contains(qualifiedName) || equal(qualifiedName, simpleName);
	}

	protected boolean needsQualifiedName(String qualifiedName, String simpleName) {
		return !organizeImports || (thisTypeSimpleNames.contains(simpleName) && !thisTypeQualifiedNames.contains(qualifiedName))
				|| CodeGenUtil.isJavaLangType(simpleName);
	}

	public boolean addImportFor(JvmType type) {
		final String qualifiedName = type.getQualifiedName(innerTypeSeparator);
		final String simpleName = type.getSimpleName();
		if (!allowsSimpleName(qualifiedName, simpleName) && !needsQualifiedName(qualifiedName, simpleName) && !imports.containsKey(simpleName)) {
			imports.put(simpleName, qualifiedName);
			return true;
		}
		return false;
	}

	public List<String> getImports() {
		ArrayList<String> result = newArrayList(newLinkedHashSet(imports.values()));
		Collections.sort(result);
		return result;
	}
}
