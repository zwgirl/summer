/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVoid;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.scoping.batch.IIdentifiableElementDescription;
import org.summer.dsl.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TypeInsteadOfConstructorLinkingCandidate extends AbstractUnresolvableReference implements IConstructorLinkingCandidate {

	private final IIdentifiableElementDescription description;

	public TypeInsteadOfConstructorLinkingCandidate(XConstructorCall constructorCall, IIdentifiableElementDescription description, ExpressionTypeComputationState state) {
		super(constructorCall, state);
		this.description = description;
	}

	@Nullable
	public JvmConstructor getConstructor() {
		return null;
	}
	
	@Override
	protected void applyType() {
		JvmType type = (JvmType) getFeature();
		if (type == null || type.eIsProxy()) {
			throw new IllegalStateException();
		}
		ITypeReferenceOwner referenceOwner = getResolvedTypes().getReferenceOwner();
		ParameterizedTypeReference result = new ParameterizedTypeReference(referenceOwner, type);
		for(LightweightTypeReference typeArgument: getTypeArguments()) {
			result.addTypeArgument(typeArgument);
		}
		getState().acceptActualType(result);
	}
	
	public XConstructorCall getConstructorCall() {
		return (XConstructorCall) getExpression();
	}

	@Override
	protected List<XExpression> getArguments() {
		return getConstructorCall().getArguments();
	}
	
	@Override
	@Nullable
	public JvmIdentifiableElement getFeature() {
		return description.getElementOrProxy();
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		JvmType type = (JvmType) description.getElementOrProxy();
		String typeKind = "";
		if (type instanceof JvmPrimitiveType || type instanceof JvmVoid) {
			typeKind = "primitive type";
		} else if (type instanceof JvmAnnotationType) {
			typeKind = "annotation type";
		} else if (type instanceof JvmEnumerationType) {
			typeKind = "enum type";
		} else if (type instanceof JvmGenericType && type instanceof JvmInterfaceType) {
			typeKind = "interface type";
		} else if (type instanceof JvmTypeParameter) {
			typeKind = "type parameter";
		}
		String message = String.format("Cannot instantiate the %s %s", typeKind, type.getSimpleName());
		AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
				IssueCodes.ILLEGAL_CLASS_INSTANTIATION, message, getExpression(),
				XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, -1, null);
		result.accept(diagnostic);
		return false;
	}
	
	public List<LightweightTypeReference> getTypeArguments() {
		JvmType type = (JvmType) getFeature();
		if (type == null || type.eIsProxy()) {
			throw new IllegalStateException();
		}
		ITypeReferenceOwner referenceOwner = getResolvedTypes().getReferenceOwner();
		if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			if (!typeParameters.isEmpty()) {
				List<LightweightTypeReference> result = Lists.newArrayList();
				List<LightweightTypeReference> typeArguments = getSyntacticTypeArguments();
				int max = Math.min(typeParameters.size(), typeArguments.size());
				for(int i = 0; i < max; i++) {
					result.add(typeArguments.get(i));
				}
				if (max < typeParameters.size()) {
					TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(
							Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument> emptyMap(), referenceOwner);
					for(int i = max; i < typeParameters.size(); i++) {
						JvmTypeParameter typeParameter = typeParameters.get(i);
						result.add(substitutor.substitute(typeParameter));
					}
				}
				return result;
			}
		}
		return Collections.emptyList();
	}
	
	public List<LightweightTypeReference> getSyntacticTypeArguments() {
		XConstructorCall constructorCall = getConstructorCall();
		List<JvmTypeReference> typeArguments = constructorCall.getTypeArguments();
		if (typeArguments.isEmpty())
			return Collections.emptyList();
		List<LightweightTypeReference> result = Lists.newArrayList();
		for(JvmTypeReference typeArgument: typeArguments) {
			result.add(getConverter().toLightweightReference(typeArgument));
		}
		return result;
	}
	
	public void applyToModel() {
		Resource resource = getExpression().eResource();
		if (resource instanceof LazyLinkingResource) {
			LazyLinkingResource lazyLinkingResource = (LazyLinkingResource) resource;
			EObject referenced = (InternalEObject) getExpression().eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
			lazyLinkingResource.markUnresolvable(referenced);
		}
	}
	
}
