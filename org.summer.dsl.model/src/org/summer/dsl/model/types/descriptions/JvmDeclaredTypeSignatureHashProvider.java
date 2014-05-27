/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.descriptions;

import static com.google.common.collect.Iterables.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Set;

import org.apache.log4j.Logger;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.access.IMirror;
import org.summer.dsl.model.types.access.IMirrorExtension;
import org.summer.dsl.model.types.access.TypeResource;
import org.summer.dsl.model.types.util.SuperTypeCollector;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Calculates the hash of the signature of a {@link JvmDeclaredType}.
 * The signature spans everything that could change the linking of clients.
 * The hash is stored in the {@link IEObjectDescription} of the type to allow fast calculation of 
 * {@link org.eclipse.xtext.resource.IResourceDescription.Manager#isAffected(org.eclipse.xtext.resource.IResourceDescription.Delta, IResourceDescription)}.
 *
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class JvmDeclaredTypeSignatureHashProvider {

	private static final Logger LOG = Logger.getLogger(JvmDeclaredTypeSignatureHashProvider.class);

	@Inject
	private IResourceScopeCache cache;

	@Inject
	private Provider<SignatureHashBuilder> signatureBuilderProvider;

	private static final String HASH_CACHE_KEY = "SignatureHash";

	public String getHash(final JvmDeclaredType type) {
		if(type.eResource() instanceof TypeResource) {
			IMirror mirror = ((TypeResource)type.eResource()).getMirror();
			if(mirror instanceof IMirrorExtension && ((IMirrorExtension) mirror).isSealed())
				return type.getIdentifier();
		}
		return cache.get(Tuples.create(HASH_CACHE_KEY, type), type.eResource(), new Provider<String>() {
			public String get() {
				return signatureBuilderProvider.get().appendSignature(type).hash();
			}
		});
	}
	
	public static class SignatureHashBuilder {

		@Inject
		private SuperTypeCollector superTypeCollector;

		@Inject
		private JvmDeclaredTypeSignatureHashProvider hashProvider;

		@Inject
		private AnnotationSignatureRelevanceUtil annotationRelevance;
		
		private MessageDigest digest;

		private StringBuilder builder;
		
		public SignatureHashBuilder() {
			digest = createDigest();
			if(digest == null)
				builder = new StringBuilder();
		}
		
		protected MessageDigest createDigest() {
			try {
				return MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				LOG.error("Error creating message digest", e);
				return null;
			}
		}

		protected SignatureHashBuilder append(String s) {
			if(digest != null)
				try {
					digest.update(s.getBytes("UTF8"));
				} catch (UnsupportedEncodingException e) {
					LOG.error("Error encoding String", e);
				}
			if(builder != null)
				builder.append(s);
			return this;
		}

		public SignatureHashBuilder appendSignature(JvmDeclaredType type) {
			if (type.getVisibility() != JvmVisibility.PRIVATE) {
				appendAnnotationReferences(type);
				appendVisibility(type.getVisibility()).append(" ");
				if (type.isAbstract())
					append("abstract ");
//				if (type.isStatic())
//					append("static ");
				if (type.isFinal())
					append("final ");
				append("class ").append(type.getIdentifier());
				if (type instanceof JvmTypeParameterDeclarator)
					appendTypeParameters((JvmTypeParameterDeclarator) type);
				append("\n").appendSuperTypeSignatures(type).appendMemberSignatures(type, false);
			}
			return this;
		}

		protected SignatureHashBuilder appendMemberSignatures(JvmDeclaredType type, boolean innerTypesOnly) {
			Iterable<? extends JvmMember> members = type.getMembers();
			if(innerTypesOnly)
				members = filter(members, JvmDeclaredType.class);
			for (JvmMember member : members) {
				if (member.getVisibility() != JvmVisibility.PRIVATE && member.getSimpleName() != null) {
					appendAnnotationReferences(member);
					if (member instanceof JvmOperation) 
						appendSignature((JvmOperation) member);
					else if (member instanceof JvmConstructor) 
						appendSignature((JvmConstructor) member);
					else if (member instanceof JvmField) 
						appendSignature((JvmField) member);
					else if (member instanceof JvmDeclaredType) {
						append(member.getQualifiedName());
						appendMemberSignatures((JvmDeclaredType) member, true);
					}
					append("\n");
				}
			}
			return this;
		}

		protected void appendAnnotationReferences(JvmAnnotationTarget target) {
			for(JvmAnnotationReference annotationReference: target.getAnnotations()) {
				if(annotationRelevance.isRelevant(annotationReference)) 
					append(hashProvider.getHash(annotationReference.getAnnotation()))
						.append(" ");
			}
		}

		protected SignatureHashBuilder appendSuperTypeSignatures(JvmDeclaredType type) {
			Set<JvmTypeReference> allSuperTypes = superTypeCollector.collectSuperTypes(type);
			Collection<JvmType> transformedSuperTypes = Lists.newArrayList((Iterables.transform(allSuperTypes, new Function<JvmTypeReference, JvmType>() {
				public JvmType apply(JvmTypeReference input){
					return input.getType();
				}
			})));
			// The inheritance hierarchy contains cycles -> stop calculation here
			if(transformedSuperTypes.contains(type))
				return this;
			for (JvmTypeReference superType : allSuperTypes) {
				append("super ");
				superType
						.accept(new org.summer.dsl.model.types.util.AbstractTypeReferenceVisitor.InheritanceAware<Void>() {
							@Override
							public Void doVisitTypeReference(JvmTypeReference reference) {
								if (reference.getType() instanceof JvmDeclaredType)
									append(hashProvider.getHash((JvmDeclaredType) reference.getType()));
								else
									append(reference.getIdentifier());
								return null;
							}

							@Override
							public Void doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
								doVisitTypeReference(reference);
								append("<");
								for (JvmTypeReference typeArgument : reference.getArguments()) {
									append(typeArgument.getIdentifier());
									append(",");
								}
								append(">");
								return null;
							}
						});
				append("\n");
			}
			return this;
		}

		protected SignatureHashBuilder appendSignature(JvmOperation operation) {
			appendVisibility(operation.getVisibility()).append(" ");
			if (operation.isAbstract())
				append("abstract ");
			if (operation.isStatic())
				append("static ");
//			if (operation.isFinal())
//				append("final ");
			appendType(operation.getReturnType()).appendTypeParameters(operation).append(" ")
					.append(operation.getSimpleName()).append("(");
			for (JvmFormalParameter p : operation.getParameters()) {
				appendType(p.getParameterType());
				append(" ");
			}
			append(") ");
			for (JvmTypeReference ex : operation.getExceptions()) {
				appendType(ex).append(" ");
			}
			return this;
		}

		protected SignatureHashBuilder appendSignature(JvmField field) {
			appendVisibility(field.getVisibility()).append(" ");
			if (field.isStatic())
				append("static ");
//			if (field.isFinal())
				append("final ");
			return appendType(field.getType()).append(" ").append(field.getSimpleName());
		}

		protected SignatureHashBuilder appendSignature(JvmConstructor operation) {
			appendVisibility(operation.getVisibility()).appendTypeParameters(operation).append("(");
			for (JvmFormalParameter p : operation.getParameters()) {
				appendType(p.getParameterType()).append(" ");
			}
			append(") ");
			for (JvmTypeReference ex : operation.getExceptions()) {
				appendType(ex).append(" ");
			}
			return this;
		}

		protected SignatureHashBuilder appendTypeParameters(JvmTypeParameterDeclarator decl) {
			append("<");
			for (JvmTypeParameter tp : decl.getTypeParameters()) {
				appendTypeParameter(tp).append(",");
			}
			append(">");
			return this;
		}

		protected SignatureHashBuilder appendType(JvmTypeReference ref) {
			if (ref != null && ref.getIdentifier() != null) {
				append(ref.getIdentifier());
			} else {
				append("*unresolved*");
			}
			return this;
		}

		protected SignatureHashBuilder appendVisibility(JvmVisibility v) {
			append(v.getLiteral());
			return this;
		}

		protected SignatureHashBuilder appendTypeParameter(JvmTypeParameter p) {
			if (p != null && p.getIdentifier() != null) {
				append(p.getIdentifier());
			} else {
				append("*unresolved*");
			}
			return this;
		}

		public String hash() {
			try {
				if(digest != null) {
					byte[] digestBytes = digest.digest();
					return new BigInteger(digestBytes).toString(16);
				} else {
					return builder.toString();
				}
			} catch (Exception e) {
				LOG.error("Error hashing JvmDeclaredType signature", e);
				return "";
			}
		}
	}
}
