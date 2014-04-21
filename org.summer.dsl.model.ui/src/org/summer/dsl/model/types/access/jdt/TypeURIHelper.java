/*******************************************************************************
 * Copyright (c) 2009-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access.jdt;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.SegmentSequence;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.summer.dsl.model.types.access.impl.URIHelperConstants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Ed Merks - Performance Improvements
 */
public class TypeURIHelper implements URIHelperConstants {

	/**
	 * An array indexed by the first character of the type binding {@link ITypeBinding#getKey()} of a primitive type.
	 */
	static final URI[] PRIMITIVE_URIS = {
		PRIMITIVES_URI.appendFragment("byte"), // 'B'
		PRIMITIVES_URI.appendFragment("char"), // 'C'
		PRIMITIVES_URI.appendFragment("double"), // 'D'
		null, // 'E'
		PRIMITIVES_URI.appendFragment("float"), // 'F'
		null, // 'G'
		null, // 'H'
		PRIMITIVES_URI.appendFragment("int"), // 'I'
		PRIMITIVES_URI.appendFragment("long"), // 'J'
		null, // 'K'
		null, // 'L'
		null, // 'M'
		null, // 'N'
		null, // 'O'
		null, // 'P'
		null, // 'Q'
		null, // 'R'
		PRIMITIVES_URI.appendFragment("short"), // 'S'
		null, // 'T'
		null, // 'U'
		PRIMITIVES_URI.appendFragment("void"), // 'V'
		null, // 'W'
		null, // 'X'
		null, // 'Y'
		PRIMITIVES_URI.appendFragment("boolean"), // 'Z'
	};

	/**
	 * Names of commonly used classes for which we'll {@link #COMMON_URIS cache} their corresponding URIs.
	 */
	static final String[] COMMON_CLASS_NAMES = {
		"java.lang.annotation.Annotation",

		"java.io.Serializable",
		"java.io.IOException",

		"java.lang.Boolean",
		"java.lang.Byte",
		"java.lang.Character",
		"java.lang.CharSequence",
		"java.lang.Class",
		"java.lang.Comparable",
		"java.lang.Double",
		"java.lang.Exception",
		"java.lang.Float",
		"java.lang.Integer",
		"java.lang.Iterable",
		"java.lang.Long",
		"java.lang.Math",
		"java.lang.Object",
		"java.lang.Short",
		"java.lang.String",
		"java.lang.StringBuilder",
		"java.lang.StringBuffer",
		"java.lang.Throwable",
		"java.lang.Void",

		"java.math.BigDecimal",
		"java.math.BigInteger",

		"java.util.ArrayList",
		"java.util.Collection",
		"java.util.HashMap",
		"java.util.HashSet",
		"java.util.Iterator",
		"java.util.List",
		"java.util.Map",
		"java.util.Set",
	};

	/**
	 * Names of commonly used annotations and their methods for which we'll {@link #COMMON_URIS cache} their corresponding full URIs and {@link #COMMON_METHOD_URIS method} URIs.
	 */
	static final String[][] COMMON_ANNOTATIONS = {
		new String[] { "com.google.common.annotations.Beta" },
		new String[] { "com.google.common.annotations.GwtCompatible", "emulated", "serializable" },
		new String[] { "com.google.common.annotations.GwtIncompatible", "value" },

		new String[] { "java.lang.annotation.Documented" },
		new String[] { "java.lang.annotation.Target", "value" },
		new String[] { "java.lang.annotation.Retention", "value" },

		new String[] { "java.lang.Deprecated" },
		new String[] { "java.lang.Override" },
		new String[] { "java.lang.SuppressWarnings", "value" },

		new String[] { "org.summer.dsl.xbase.lib.Inline", "value", "imported", "statementExpression" },
		new String[] { "org.summer.dsl.xbase.lib.Pure" },
	};

	/**
	 * A cache of commonly used full URIs.
	 */
	static final Map<String, URI> COMMON_URIS = new HashMap<String, URI>();
	
	/**
	 * A cache of commonly used full method URIs.
	 */
	static final Map<String, URI[]> COMMON_METHOD_URIS = new HashMap<String, URI[]>();

	static {
		for (int i = 0; i < COMMON_CLASS_NAMES.length; ++i) {
			String segment = COMMON_CLASS_NAMES[i];
			COMMON_URIS.put(segment, OBJECTS_URI.appendSegment(segment).appendFragment(segment));
		}

		for (int i = 0; i < COMMON_ANNOTATIONS.length; ++i) {
			String[] annotations = COMMON_ANNOTATIONS[i];
			String annotation = annotations[0];
			COMMON_URIS.put(annotation, OBJECTS_URI.appendSegment(annotation).appendFragment(annotation));
			if (annotations.length > 1) {
				URI[] methodURIs = new URI[annotations.length - 1];
				for (int j = 1; j < annotations.length; ++j) {
					String method = annotation + "." + annotations[j] + "()";
					methodURIs[j - 1] = OBJECTS_URI.appendSegment(annotation).appendFragment(method);
				}
				COMMON_METHOD_URIS.put(annotation, methodURIs);
			}
		}
	}

	/**
	 * A cache of mappings from signatures to their corresponding resources URI.
	 */
	static final Map<String, URI> COMMON_SIGNATURE_URIS = new HashMap<String, URI>();

	static {
		for (Map.Entry<String, URI> entry : COMMON_URIS.entrySet()) {
			COMMON_SIGNATURE_URIS.put(Signature.createTypeSignature(entry.getKey(), true), entry.getValue().trimFragment());
		}
		for (int i = 0; i < PRIMITIVE_URIS.length; ++i) {
			URI uri = PRIMITIVE_URIS[i];
			if (uri != null) {
				COMMON_SIGNATURE_URIS.put(uri.fragment(), PRIMITIVES_URI);
			}
		}
	}

	public String getFragment(String signature) {
		StringBuilder uriBuilder = new StringBuilder(32);
		createFragment(signature, uriBuilder);
		return uriBuilder.toString();
	}

	public URI createResourceURI(String signature) {
		URI uri = COMMON_SIGNATURE_URIS.get(signature);
		if (uri != null) {
			return uri;
		}
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(signature, uriBuilder);
		return createURI(uriBuilder);
	}

	public URI createResourceURIFromString(String withoutProtocol) {
		StringBuilder uriBuilder = new StringBuilder(URIHelperConstants.PROTOCOL.length() + 1 + withoutProtocol.length());
		uriBuilder.append(URIHelperConstants.PROTOCOL).append(":").append(withoutProtocol);
		return createURI(uriBuilder);
	}

	public URI createResourceURIForFQN(String fqn) {
		return OBJECTS_URI.appendSegment(fqn);
	}

	public StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(URIHelperConstants.PROTOCOL);
		builder.append(':');
		return builder;
	}

	protected URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public URI getFullURI(ITypeBinding typeBinding) {
		// The URIs for primitive types are cached and indexed by their one character key representation.
		//
		if (typeBinding.isPrimitive()) {
			return PRIMITIVE_URIS[typeBinding.getKey().charAt(0) - 'B'];
		}
		if (typeBinding.isClass() || typeBinding.isInterface() || typeBinding.isAnnotation() || typeBinding.isEnum()) {
			ITypeBinding declaringClass = typeBinding.getDeclaringClass();
			if (declaringClass == null) {
				// This special case handling for common case of top level types that avoids creating a builder.
				//
				String qualifiedName = typeBinding.getErasure().getQualifiedName();
				URI uri = COMMON_URIS.get(qualifiedName);
				if (uri != null) {
					return uri;
				}
				uri = OBJECTS_URI.appendSegment(qualifiedName);
				return uri.appendFragment(uri.lastSegment());
			}
			SegmentSequence.Builder builder = SegmentSequence.newBuilder("");
			URI uri = getFullURI(declaringClass, builder);
			builder.append("$");
			builder.append(typeBinding.getName());
			return uri.appendFragment(builder.toString());
		}
		SegmentSequence.Builder builder = SegmentSequence.newBuilder("");
		URI uri = getFullURI(typeBinding, builder);
		return uri.appendFragment(builder.toString());
	}

	/**
	 * @since 2.4
	 */
	protected URI getFullURI(ITypeBinding typeBinding, SegmentSequence.Builder builder) {
		if (typeBinding.isPrimitive()) {
			builder.append(PRIMITIVE_URIS[typeBinding.getKey().charAt(0) - 'B'].fragment());
			return PRIMITIVES_URI;
		}
		if (typeBinding.isClass() || typeBinding.isInterface() || typeBinding.isAnnotation() || typeBinding.isEnum()) {
			ITypeBinding declaringClass = typeBinding.getDeclaringClass();
			if (declaringClass != null) {
				URI uri = getFullURI(declaringClass, builder);
				builder.append("$");
				builder.append(typeBinding.getName());
				return uri;
			}
			String qualifiedName = typeBinding.getErasure().getQualifiedName();
			URI uri = COMMON_URIS.get(qualifiedName);
			if (uri == null) {
				uri = OBJECTS_URI.appendSegment(qualifiedName);
			}
			builder.append(uri.lastSegment());
			return uri;
		}
		if (typeBinding.isArray()) {
			URI uri = getFullURI(typeBinding.getComponentType(), builder);
			builder.append("[]");
			return uri;
		}
		if (typeBinding.isTypeVariable()) {
			ITypeBinding declaringClass = typeBinding.getDeclaringClass();
			if (declaringClass != null) {
				URI uri = getFullURI(declaringClass, builder);
				builder.append("/");
				builder.append(typeBinding.getName());
				return uri;
			}
			IMethodBinding declaringMethod = typeBinding.getDeclaringMethod();
			URI uri = getFullURI(declaringMethod.getDeclaringClass(), builder);
			builder.append(".");
			builder.append(declaringMethod.getName());
			builder.append("(");
			ITypeBinding[] parameterTypes = declaringMethod.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				if (i != 0) {
					builder.append(",");
				}
				getQualifiedName(parameterTypes[i], builder);
			}
			builder.append(")");
			builder.append("/");
			builder.append(typeBinding.getName());
			return uri;
		}
		throw new IllegalStateException("Unexpected type: " + typeBinding);
	}

	protected void getFullURI(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		createResourceURI(typeBinding, uriBuilder);
		uriBuilder.append('#');
		createFragment(typeBinding, uriBuilder);
	}
	
	public URI getFullURI(IVariableBinding binding) {
		SegmentSequence.Builder builder = SegmentSequence.newBuilder("");
		URI uri = getFullURI(binding.getDeclaringClass(), builder);
		builder.append(".");
		builder.append(binding.getName());
		return uri.appendFragment(builder.toString());
	}
	
	public URI getFullURI(IMethodBinding binding) {
		StringBuilder uriBuilder = createURIBuilder();
		getFullURI(binding.getDeclaringClass(), uriBuilder);
		uriBuilder.append(".");
		uriBuilder.append(binding.getName());
		uriBuilder.append("(");
		ITypeBinding[] parameterTypes = binding.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0)
				uriBuilder.append(',');
			uriBuilder.append(getQualifiedName(parameterTypes[i]));
		}
		uriBuilder.append(")");
		return createURI(uriBuilder);
	}
	
	public URI getFullURI(IBinding binding) {
		// TODO could use the kind
		if (binding instanceof ITypeBinding)
			return getFullURI((ITypeBinding) binding);
		if (binding instanceof IMethodBinding)
			return getFullURI((IMethodBinding) binding);
		if (binding instanceof IVariableBinding)
			return getFullURI((IVariableBinding) binding);
		return null;
	}
	
	public URI getFullURI(IJavaElement javaElement) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setProject(javaElement.getJavaProject());
		IBinding[] bindings = parser.createBindings(new IJavaElement[] { javaElement }, null);
		if (bindings[0] != null) {
			return getFullURI(bindings[0]);
		}
		return null;
	}
	
	public URI getFullURIForClass(String fqn) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURIForClassImpl2(fqn, uriBuilder);
		uriBuilder.append('#');
		createFragmentForClass2(fqn, uriBuilder);
		return createURI(uriBuilder);
	}
	
	public URI getFullURI(ITypeBinding typeBinding, String method) {
		SegmentSequence.Builder builder = SegmentSequence.newBuilder("");
		URI uri = getFullURI(typeBinding, builder);
		URI[] uris = COMMON_METHOD_URIS.get(uri.lastSegment());
		if (uris != null) {
			for (URI methodURI : uris) {
				String fragment = methodURI.fragment();
				if (fragment.startsWith(method, fragment.length() - method.length() - 2)) {
					return methodURI;
				}
			}
		}
		builder.append(".").append(method).append("()");
		return uri.appendFragment(builder.toString());
	}
	
	protected void createFragment(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.isPrimitive()) {
			createFragmentForPrimitive(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isArray()) {
			createFragmentForArray(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isTypeVariable()) {
			createFragmentForTypeVariable(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isAnnotation() || typeBinding.isClass() || typeBinding.isInterface() || typeBinding.isEnum()) {
			createFragmentForClass(typeBinding, uriBuilder);
			return;
		}
		throw new IllegalStateException("Unexpected type binding: " + typeBinding);
	}

	protected void createFragment(String signature, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.BASE_TYPE_SIGNATURE:
				createFragmentForPrimitive(signature, uriBuilder);
				return;
			case Signature.CLASS_TYPE_SIGNATURE:
				createFragmentForClass(signature, uriBuilder);
				return;
			case Signature.ARRAY_TYPE_SIGNATURE:
				createFragmentForArray(signature, uriBuilder);
				return;
			case Signature.TYPE_VARIABLE_SIGNATURE:
				createFragmentForTypeVariable(signature, uriBuilder);
				return;
			default:
				throw new IllegalStateException("Unexpected Signature: " + signature);
		}
	}
	
	protected void createFragmentForTypeVariable(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.getDeclaringMethod() != null) {
			createFragmentForMethod(typeBinding.getDeclaringMethod(), uriBuilder);
		} else {
			createFragment(typeBinding.getDeclaringClass(), uriBuilder);
		}
		uriBuilder.append('/');
		uriBuilder.append(typeBinding.getName());
	}

	protected void createFragmentForTypeVariable(String signature, StringBuilder uriBuilder) {
		String readable = Signature.toString(signature);
		uriBuilder.append('/');
		uriBuilder.append(readable);
	}

	protected void createFragmentForMethod(IMethodBinding method, StringBuilder uriBuilder) {
		ITypeBinding declaringType = method.getDeclaringClass();
		createFragmentForClass(declaringType, uriBuilder);
		uriBuilder.append('.');
		uriBuilder.append(method.getName());
		uriBuilder.append('(');
		ITypeBinding[] parameterTypes = method.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0) {
				uriBuilder.append(',');
			}
			getQualifiedName(parameterTypes[i], uriBuilder);
		}
		uriBuilder.append(')');
	}
	
	public String getQualifiedName(ITypeBinding binding) {
		if (binding.isParameterizedType()) {
			return getQualifiedName(binding.getErasure());
		}
		if (binding.isArray()) {
			return getQualifiedName(binding.getComponentType(), new StringBuilder()).append("[]").toString();
		}
		if (binding.isTopLevel() || binding.isTypeVariable() || binding.isPrimitive())
			return binding.getQualifiedName();
		return getQualifiedName(binding.getDeclaringClass(), new StringBuilder()).append('$').append(binding.getName()).toString();
	}

	/**
	 * @since 2.4
	 */
	public StringBuilder getQualifiedName(ITypeBinding binding, StringBuilder stringBuilder) {
		if (binding.isParameterizedType()) {
			getQualifiedName(binding.getErasure(), stringBuilder);
		}
		else if (binding.isArray()) {
			getQualifiedName(binding.getComponentType(), stringBuilder).append("[]");
		}
		else if (binding.isTopLevel() || binding.isTypeVariable() || binding.isPrimitive()) {
			stringBuilder.append(binding.getQualifiedName());
		} else {
			getQualifiedName(binding.getDeclaringClass(), stringBuilder).append('$').append(binding.getName());
		}
		return stringBuilder;
	}

	/**
	 * @since 2.4
	 */
	protected SegmentSequence.Builder getQualifiedName(ITypeBinding binding, SegmentSequence.Builder builder) {
		if (binding.isParameterizedType()) {
			getQualifiedName(binding.getErasure(), builder);
		}
		else if (binding.isArray()) {
			getQualifiedName(binding.getComponentType(), builder).append("[]");
		}
		else if (binding.isTopLevel() || binding.isTypeVariable() || binding.isPrimitive()) {
			builder.append(binding.getQualifiedName());
		} else {
			getQualifiedName(binding.getDeclaringClass(), builder).append('$').append(binding.getName());
		}
		return builder;
	}

	public String computeTypeName(String signature) {
		StringBuilder result = new StringBuilder(64);
		computeTypeName(signature, result);
		return result.toString();
	}

	public void computeTypeName(String signature, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.CLASS_TYPE_SIGNATURE:
			case Signature.BASE_TYPE_SIGNATURE:
			case Signature.ARRAY_TYPE_SIGNATURE:
			case Signature.TYPE_VARIABLE_SIGNATURE:
				String erased = getTypeErasure(signature);
				uriBuilder.append(Signature.toString(erased));
				return;
			default:
				throw new IllegalStateException("Unexpected Signature: " + signature);
		}
	}

	public String getTypeErasure(String signature) {
		String fixedSignature = signature.replaceAll(">\\.", ">\\$");
		return Signature.getTypeErasure(fixedSignature);
	}

	public String computeParameterizedTypeName(String signature) {
		StringBuilder result = new StringBuilder(64);
		computeParameterizedTypeName(signature, result);
		return result.toString();
	}

	public void computeParameterizedTypeName(String signature, StringBuilder uriBuilder) {
		computeTypeName(signature, uriBuilder);
		String[] typeArguments = Signature.getTypeArguments(signature);
		if (typeArguments.length != 0) {
			uriBuilder.append('<');
			for (int i = 0; i < typeArguments.length; i++) {
				if (i != 0)
					uriBuilder.append(',');
				computeParameter(typeArguments[i], uriBuilder);
			}
			uriBuilder.append('>');
		}
	}

	public void computeParameter(String signature, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		if (signatureKind == Signature.WILDCARD_TYPE_SIGNATURE) {
			switch (signature.charAt(0)) {
				case '*': {
					uriBuilder.append("? extends java.lang.Object");
				}
					break;
				case '+': {
					uriBuilder.append("? extends ");
					String upperBoundSignature = signature.substring(1);
					computeParameterizedTypeName(upperBoundSignature, uriBuilder);
				}
					break;
				case '-': {
					uriBuilder.append("? extends java.lang.Object & super ");
					String lowerBoundSignature = signature.substring(1);
					computeParameterizedTypeName(lowerBoundSignature, uriBuilder);
				}
					break;
				default:
					throw new IllegalArgumentException("Signature: " + signature);
			}
		}
		else {
			computeParameterizedTypeName(signature, uriBuilder);
		}
	}

	protected void createFragmentForPrimitive(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		uriBuilder.append(typeBinding.getName());
	}
	
	protected void createFragmentForPrimitive(String signature, StringBuilder uriBuilder) {
		uriBuilder.append(Signature.toString(signature));
	}

	protected void createFragmentForArray(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		createFragment(typeBinding.getComponentType(), uriBuilder);
		uriBuilder.append("[]");
	}
	
	protected void createFragmentForArray(String signature, StringBuilder uriBuilder) {
		String elementType = Signature.getElementType(signature);
		createFragment(elementType, uriBuilder);
		int dim = Signature.getArrayCount(signature);
		for (int i = 0; i < dim; i++) {
			uriBuilder.append("[]");
		}
	}

	protected void createFragmentForClass(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		createFragmentForClass2(getQualifiedName(typeBinding), uriBuilder);
	}
	
	protected void createFragmentForClass2(String fqn, StringBuilder uriBuilder) {
		uriBuilder.append(fqn);
	}
	
	protected void createFragmentForClass(String signature, StringBuilder uriBuilder) {
		String fragment = Signature.toString(signature);
		int start = signature.length();
		int lastDot = fragment.length();
		while ((start = signature.lastIndexOf('$', start)) >= 0) {
			lastDot = fragment.lastIndexOf('.', lastDot);
			fragment = fragment.substring(0, lastDot) + '$' + fragment.substring(lastDot + 1);
			start--;
		}
		uriBuilder.append(fragment);
	}

	protected void createResourceURI(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.isPrimitive()) {
			createResourceURIForPrimitive(uriBuilder);
			return;
		}
		if (typeBinding.isClass() || typeBinding.isInterface() || typeBinding.isAnnotation() || typeBinding.isEnum()) {
			createResourceURIForClass(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isArray()) {
			createResourceURIForArray(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isTypeVariable()) {
			createResourceURIForTypeVariable(typeBinding, uriBuilder);
			return;
		}
		throw new IllegalStateException("Unexpected type: " + typeBinding);
	}
	
	protected void createResourceURI(String signature, StringBuilder uriBuilder) {
		try {
			int signatureKind = Signature.getTypeSignatureKind(signature);
			switch (signatureKind) {
				case Signature.BASE_TYPE_SIGNATURE:
					createResourceURIForPrimitive(uriBuilder);
					return;
				case Signature.CLASS_TYPE_SIGNATURE:
					createResourceURIForClass(signature, uriBuilder);
					return;
				case Signature.ARRAY_TYPE_SIGNATURE:
					createResourceURIForArray(signature, uriBuilder);
					return;
				default:
					throw new IllegalStateException("Unexpected Signature: " + signature);
			}
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage() + " was: " + signature, e);
		}
	}

	/**
	 * @since 2.4
	 */
	protected URI createResourceURIForPrimitive() {
		return PRIMITIVES_URI;
	}

	protected void createResourceURIForPrimitive(StringBuilder uriBuilder) {
		uriBuilder.append(URIHelperConstants.PRIMITIVES);
	}

	protected void createResourceURIForArray(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		ITypeBinding componentType = typeBinding.getComponentType();
		createResourceURI(componentType, uriBuilder);
	}
	
	protected void createResourceURIForArray(String signature, StringBuilder uriBuilder) {
		String elementType = Signature.getElementType(signature);
		createResourceURI(elementType, uriBuilder);
	}

	protected void createResourceURIForClass(ITypeBinding typeBinding, StringBuilder uriBuilder) { 
		ITypeBinding declaringClass = typeBinding.getDeclaringClass();
		if (declaringClass != null) {
			createResourceURIForClass(declaringClass, uriBuilder);
		} else {
			createResourceURIForClassImpl2(typeBinding.getErasure().getQualifiedName(), uriBuilder);
		}
	}
	
	protected void createResourceURIForClass(String signature, StringBuilder uriBuilder) {
		createResourceURIForClassImpl(signature, uriBuilder);
	}

	protected void createResourceURIForClassImpl2(String fqn, StringBuilder uriBuilder) {
		uriBuilder.append(URIHelperConstants.OBJECTS).append(fqn);
	}
	
	protected void createResourceURIForClassImpl(String signature, StringBuilder uriBuilder) {
		String topLevel = signature;
		int idx = topLevel.indexOf('$');
		if (idx != -1) {
			topLevel = topLevel.substring(0, idx) + ';';
			if (topLevel.endsWith(".;") || topLevel.endsWith("$;")) {
				topLevel = signature.substring(1, signature.length() - 1);
			} else {
				topLevel = Signature.toString(topLevel);
			}
		} else {
			topLevel = Signature.toString(topLevel);
		}
		uriBuilder.append(URIHelperConstants.OBJECTS).append(topLevel);
	}
	
	protected void createResourceURIForTypeVariable(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.getDeclaringClass() != null) {
			ITypeBinding declaringClass = typeBinding.getDeclaringClass();
			createResourceURIForClass(declaringClass, uriBuilder);
		}
		else {
			IMethodBinding declaringMethod = typeBinding.getDeclaringMethod();
			ITypeBinding declaringClass = declaringMethod.getDeclaringClass();
			createResourceURIForClass(declaringClass, uriBuilder);
		}
	}

}
