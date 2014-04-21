/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmMultiTypeReference;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmSpecializedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.util.Primitives;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
public class TypeReferenceSerializer {
	
	@Inject
	private Primitives primitives;
	
	@Inject 
	private ILogicalContainerProvider contextProvider;
	
	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private CommonTypeComputationServices services;
	
	public boolean isLocalTypeParameter(EObject context, JvmTypeParameter parameter) {
		if (context == parameter.getDeclarator()) 
			return true;
		if (context instanceof JvmOperation && ((JvmOperation) context).isStatic())
			return false;
		if (context instanceof JvmDeclaredType && ((JvmDeclaredType) context).isStatic())
			return false;
		JvmIdentifiableElement jvmElement = contextProvider.getLogicalContainer(context);
		if (jvmElement != null) {
			return isLocalTypeParameter(jvmElement, parameter);
		}
		EObject container = context.eContainer();
		if (container == null) {
			return false;
		}
		return isLocalTypeParameter(container, parameter);
	}
	
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable) {
		serialize(type, context, appendable, false, true);
	}
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard) {
		serialize(type, context, appendable, withoutConstraints, paramsToWildcard, false, true);
	}
	
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard, boolean paramsToObject, boolean allowPrimitives) {
		IAppendable tracedAppendable = appendable;
		boolean tracing = false;
		if (appendable instanceof ITreeAppendable && type.eResource() == context.eResource()) {
			tracedAppendable = ((ITreeAppendable) appendable).trace(type);
			tracing = true;
		}
		if (type instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcard = (JvmWildcardTypeReference) type;
			if (!withoutConstraints) {
				tracedAppendable.append("?");
			}
			if (!wildcard.getConstraints().isEmpty()) {
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmLowerBound) {
						if (!withoutConstraints)
							tracedAppendable.append(" super ");
						serialize(constraint.getTypeReference(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
						return;
					}
				}
				boolean first = true;
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						if (first) {
							if (!withoutConstraints)
								tracedAppendable.append(" extends ");
							first = false;
						} else {
							if (withoutConstraints)
								throw new IllegalStateException("cannot have two upperbounds if type should be printed without constraints");
							tracedAppendable.append(" & ");
						}
						serialize(constraint.getTypeReference(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
					}
				}
			} else if (withoutConstraints) {
				tracedAppendable.append("Object");
			}
		} else if (type instanceof JvmGenericArrayTypeReference) {
			serialize(((JvmGenericArrayTypeReference) type).getComponentType(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, true);
			tracedAppendable.append("[]");
		} else if (type instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) type;
			if ((paramsToWildcard || paramsToObject) && parameterized.getType() instanceof JvmTypeParameter) {
				JvmTypeParameter parameter = (JvmTypeParameter) parameterized.getType();
				if (!isLocalTypeParameter(context, parameter)) {
					if (paramsToWildcard)
						tracedAppendable.append("?");
					else
						tracedAppendable.append("Object");
					return;
				}
			}
			JvmType jvmType = allowPrimitives ? type.getType() : primitives.asWrapperTypeIfPrimitive(type).getType();
			if (tracing) {
				ITextRegion region = locationProvider.getFullTextRegion(type, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, 0);
				if (region instanceof ITextRegionWithLineInformation) {
					((ITreeAppendable) tracedAppendable).trace(new LocationData((ITextRegionWithLineInformation) region, null)).append(jvmType);
				} else {
					tracedAppendable.append(jvmType);
				}
			} else {
				tracedAppendable.append(jvmType);
			}
			if (!parameterized.getArguments().isEmpty()) {
				tracedAppendable.append("<");
				for(int i = 0; i < parameterized.getArguments().size(); i++) {
					if (i != 0) {
						tracedAppendable.append(",");
					}
					serialize(parameterized.getArguments().get(i), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
				}
				tracedAppendable.append(">");
			}
		} else if (type instanceof JvmAnyTypeReference) {
			tracedAppendable.append("Object");
		} else if (type instanceof JvmMultiTypeReference) {
			serialize(resolveMultiType(type, context), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else if (type instanceof JvmDelegateTypeReference) {
			JvmTypeReference delegate = ((JvmDelegateTypeReference) type).getDelegate();
			if(delegate != null)
				serialize(delegate, context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
			else
				tracedAppendable.append("Object");
		} else if (type instanceof JvmSpecializedTypeReference) {
			serialize(((JvmSpecializedTypeReference) type).getEquivalent(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else if (type instanceof JvmUnknownTypeReference) {
			if (type.eIsSet(TypesPackage.Literals.JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME)) {
				tracedAppendable.append(type.getQualifiedName());
			} else {
				tracedAppendable.append("Object");
			}
		} else {
			throw new IllegalArgumentException(String.valueOf(type));
		}
	}
	
	public JvmTypeReference resolveMultiType(JvmTypeReference reference, EObject context) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, context.eResource().getResourceSet());
		return new OwnedConverter(owner).toLightweightReference(reference).toJavaCompliantTypeReference();
	}
}
