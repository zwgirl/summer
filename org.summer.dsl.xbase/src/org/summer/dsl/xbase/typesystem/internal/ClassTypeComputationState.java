/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.model.types.JvmAnnotationAnnotationValue;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmCustomAnnotationValue;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.scoping.batch.IFeatureNames;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.InferredTypeIndicator;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ImmutableMap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ClassTypeComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public ClassTypeComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmGenericType type) {
		super(resolvedTypes, featureScopeSession, type);
//		for(JvmFormalParameter parameter: module.getParameters()) {
//			addLocalToCurrentScope(parameter);
//		}
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result;
		if (type != null) {
			result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState, true);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		return getResolvedTypes().getConverter().toLightweightReference(getTypeReferences().getTypeForName(Buildin.Void.JvmType, getContainer()));
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
//		JvmOperation operation = (JvmOperation) getContainer();
//		LightweightTypeReference expectedType = ((LogicalContainerAwareReentrantTypeResolver)getResolver()).getReturnTypeOfOverriddenOperation(operation, resolvedTypes, getFeatureScopeSession());
//		if (expectedType != null) {
//			InferredTypeIndicator.resolveTo(operation.getReturnType(), expectedType.toJavaCompliantTypeReference());
//		}
		return new NoTypeResult(getContainer(), resolvedTypes.getReferenceOwner());
	}
	
	@Override
	protected JvmGenericType getContainer() {
		return (JvmGenericType) super.getContainer();
	}

	@Override
	public void computeTypes() {
		
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, resolvedTypes.getReferenceOwner(), getContainer());
		
		StackedResolvedTypes classResolvedTypes = declareTypeParameters(resolvedTypes, getContainer());
		
		JvmTypeReference superType = getExtendedClass(getContainer());
		if (superType != null) {
			LightweightTypeReference lightweightSuperType = resolvedTypes.getConverter().toLightweightReference(superType);
			classResolvedTypes.reassignTypeWithoutMerge(superType.getType(), lightweightSuperType);
			/* 
			 * We use reassignType to make sure that the following works:
			 *
			 * StringList extends AbstractList<String> {
			 *   NestedIntList extends AbstractList<Integer> {
			 *   }
			 *   SubType extends StringList {}
			 * }
			 */
		}
		JvmParameterizedTypeReference thisType = getResolver().getServices().getTypeReferences().createTypeRef(getContainer());
		LightweightTypeReference lightweightThisType = resolvedTypes.getConverter().toLightweightReference(thisType);
		classResolvedTypes.reassignTypeWithoutMerge(getContainer(), lightweightThisType);
		
		List<JvmMember> members = getContainer().getMembers();
		for (JvmMember member : members) {
			if (member instanceof JvmField) {
				JvmField field = (JvmField) member;
				StackedResolvedTypes fieldResolvedTypes = declareTypeParameters(classResolvedTypes, field);
				
				LightweightTypeReference lightweightReference = fieldResolvedTypes.getConverter().toLightweightReference(field.getType());
				fieldResolvedTypes.setType(field, lightweightReference);
				
				FieldTypeComputationState state = new FieldTypeComputationState(fieldResolvedTypes, field.isStatic() ? childSession : childSession.toInstanceContext(), field);
				state.computeTypes();
				
				computeAnnotationTypes(fieldResolvedTypes, childSession, field);
				fieldResolvedTypes.mergeIntoParent();
			} else if (member instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) member;
				StackedResolvedTypes operationResolvedTypes = declareTypeParameters(classResolvedTypes, operation);
				
				LightweightTypeReference lightweightReference = operationResolvedTypes.getConverter().toLightweightReference(operation.getReturnType());
				operationResolvedTypes.setType(operation, lightweightReference);
				
				OperationComputationState state = new OperationComputationState(operationResolvedTypes, operation.isStatic() ? childSession : childSession.toInstanceContext(), operation);
				state.computeTypes();
				
				computeAnnotationTypes(operationResolvedTypes, childSession, operation);
				operationResolvedTypes.mergeIntoParent();
			} else if (member instanceof JvmConstructor) {
				JvmConstructor constructor = (JvmConstructor) member;
				StackedResolvedTypes constructorResolvedTypes = declareTypeParameters(classResolvedTypes, constructor);
				
				JvmDeclaredType producedType = constructor.getDeclaringType();
				JvmParameterizedTypeReference asReference = getResolver().getServices().getTypeReferences().createTypeRef(producedType);
				LightweightTypeReference lightweightReference = constructorResolvedTypes.getConverter().toLightweightReference(asReference);
				constructorResolvedTypes.setType(constructor, lightweightReference);
				
				ConstructorBodyComputationState state = new ConstructorBodyComputationState(constructorResolvedTypes, childSession, constructor);
				state.computeTypes();
				
				computeAnnotationTypes(constructorResolvedTypes, childSession, constructor);
				for(JvmFormalParameter parameter: constructor.getParameters()) {
					computeAnnotationTypes(constructorResolvedTypes, childSession, parameter);
				}
				
				constructorResolvedTypes.mergeIntoParent();
			}
		}
		
		classResolvedTypes.mergeIntoParent();
	}
	
	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession sessions, JvmExecutable operation) {
		computeAnnotationTypes(resolvedTypes, sessions, (JvmAnnotationTarget) operation);
		for(JvmFormalParameter parameter: operation.getParameters()) {
			computeAnnotationTypes(resolvedTypes, sessions, parameter);
		}
	}
	
	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmAnnotationTarget annotable) {
		List<JvmAnnotationReference> annotations = annotable.getAnnotations();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, annotations);
	}

	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, List<JvmAnnotationReference> annotations) {
		for(JvmAnnotationReference annotation: annotations) {
			for(JvmAnnotationValue value: annotation.getValues()) {
				if (value instanceof JvmCustomAnnotationValue) {
					JvmCustomAnnotationValue custom = (JvmCustomAnnotationValue) value;
					for(Object object: custom.getValues()) {
						if (object instanceof XExpression) {
							AnnotationValueTypeComputationState state = new AnnotationValueTypeComputationState(resolvedTypes, featureScopeSession, value, (XExpression) object);
							state.computeTypes();
						}
					}
				} else if (value instanceof JvmAnnotationAnnotationValue) {
					computeAnnotationTypes(resolvedTypes, featureScopeSession, ((JvmAnnotationAnnotationValue) value).getValues());
				}
			}
		}
	}
	
	protected StackedResolvedTypes declareTypeParameters(ResolvedTypes resolvedTypes, JvmIdentifiableElement declarator) {
		StackedResolvedTypes childResolvedTypes = resolvedTypes.pushTypes();
		if (declarator instanceof JvmTypeParameterDeclarator) {
			JvmTypeParameterDeclarator casted = (JvmTypeParameterDeclarator) declarator;
			if (isStatic(declarator) && !(declarator instanceof JvmConstructor)) {
				childResolvedTypes.replaceDeclaredTypeParameters(casted.getTypeParameters());
			} else {
				childResolvedTypes.addDeclaredTypeParameters(casted.getTypeParameters());
			}
		}
		return childResolvedTypes;
	}
	
	protected boolean isStatic(JvmIdentifiableElement declarator) {
		if (declarator instanceof JvmFeature) {
			return ((JvmFeature) declarator).isStatic();
		}
//		if (declarator instanceof JvmDeclaredType) {
//			return ((JvmDeclaredType) declarator).isStatic();
//		}
		return false;
	}

//	@Override
//	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
//		LightweightTypeReference type = getExpectedType();
//		AbstractTypeExpectation result;
//		if (type != null) {
//			result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
//		} else {
//			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState, true);
//		}
//		return Collections.singletonList(result);
//	}
	
	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, ITypeReferenceOwner owner, JvmDeclaredType type) {
		JvmTypeReference superType = getExtendedClass(type);
		return addThisAndSuper(session, owner, type, superType);
	}
	
	@Nullable
	public JvmTypeReference getExtendedClass(JvmDeclaredType type) {
		for(JvmTypeReference candidate: type.getSuperTypes()) {
			if (candidate.getType() instanceof JvmGenericType && !(candidate.getType() instanceof JvmInterfaceType))
				return candidate;
		}
		return null;
	}

	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, ITypeReferenceOwner owner, JvmDeclaredType thisType,
			@Nullable JvmTypeReference superType) {
		IFeatureScopeSession childSession;
		if (superType != null) {
			ImmutableMap.Builder<QualifiedName, JvmIdentifiableElement> builder = ImmutableMap.builder();
			builder.put(IFeatureNames.THIS, thisType);
			builder.put(IFeatureNames.SUPER, superType.getType());
			childSession = session.addLocalElements(builder.build(), owner);
		} else {
			childSession = session.addLocalElement(IFeatureNames.THIS, thisType, owner);
		}
		childSession = addThisTypeToStaticScope(childSession, thisType);
		return childSession;
	}

	protected IFeatureScopeSession addThisTypeToStaticScope(IFeatureScopeSession session, JvmDeclaredType type) {
		return session.addTypesToStaticScope(Collections.singletonList(type), Collections.<JvmDeclaredType>emptyList());
	}

	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types,
			AbstractTypeExpectation expectation, LightweightTypeReference type,
			boolean returnType, ConformanceHint... conformanceHint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled,
			ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType,
			ConformanceHint... conformanceHint) {
		// TODO Auto-generated method stub
		return null;
	}
}
