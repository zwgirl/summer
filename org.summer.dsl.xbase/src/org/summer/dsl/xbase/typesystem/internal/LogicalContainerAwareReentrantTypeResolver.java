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
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmCustomAnnotationValue;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDelegateType;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmEvent;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.util.AnnotationLookup;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImplCustom;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.lib.Extension;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.scoping.batch.IFeatureNames;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.InferredTypeIndicator;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationState;
import org.summer.dsl.xbase.typesystem.override.OverrideHelper;
import org.summer.dsl.xbase.typesystem.references.AnyTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.summer.dsl.xbase.typesystem.util.Maps2;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class LogicalContainerAwareReentrantTypeResolver extends DefaultReentrantTypeResolver {

	public static class DemandTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final JvmMember member;
		private final ResolvedTypes resolvedTypes;
		private final boolean returnType;
		private final IFeatureScopeSession session;
		private final XExpression expression;
		private final Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext;
		private final LogicalContainerAwareReentrantTypeResolver typeResolver;

		public DemandTypeReferenceProvider(
				JvmMember member, 
				XExpression expression, 
				Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext, 
				ResolvedTypes resolvedTypes, 
				IFeatureScopeSession session, 
				boolean returnType,
				LogicalContainerAwareReentrantTypeResolver typeResolver) {
			this.member = member;
			this.expression = expression;
			this.resolvedTypesByContext = resolvedTypesByContext;
			this.resolvedTypes = resolvedTypes;
			this.session = session;
			this.returnType = returnType;
			this.typeResolver = typeResolver;
		}

		@Override
		@Nullable
		protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
			try {
				LightweightTypeReference actualType = returnType ? resolvedTypes.getReturnType(expression) : resolvedTypes.getActualType(expression);
				if (actualType == null) {
					typeResolver.computeTypes(resolvedTypesByContext, resolvedTypes, session, member);
					actualType = returnType ? resolvedTypes.getExpectedReturnType(expression) : resolvedTypes.getExpectedType(expression);
					if (actualType == null)
						actualType = returnType ? resolvedTypes.getReturnType(expression) : resolvedTypes.getActualType(expression);
				}
				if (actualType == null)
					return null;
				return typeResolver.toJavaCompliantTypeReference(actualType, session);
			} finally {
				context.setTypeProvider(null);
			}
		}
		
		@Override
		protected JvmTypeReference handleReentrantInvocation(XComputedTypeReferenceImplCustom context) {
			EObject sourceElement = typeResolver.getSourceElement(member);
			EStructuralFeature feature = sourceElement.eClass().getEStructuralFeature("name");
			resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.WARNING, 
					IssueCodes.TOO_LITTLE_TYPE_INFORMATION, 
					"Cannot infer type from recursive usage. Type 'Object' is used.",
					sourceElement, 
					feature, 
					-1, 
					null));
			AnyTypeReference result = new AnyTypeReference(resolvedTypes.getReferenceOwner());
			return typeResolver.toJavaCompliantTypeReference(result, session);
		}

		/*
		 * Allows invocation from within the context of the class
		 */
		@Override
		protected void markComputing() {
			super.markComputing();
		}
		
	}
	
	public static class AnyTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final JvmMember member;
		private final ResolvedTypes resolvedTypes;
		private final LogicalContainerAwareReentrantTypeResolver typeResolver;

		public AnyTypeReferenceProvider(JvmMember member, ResolvedTypes resolvedTypes, LogicalContainerAwareReentrantTypeResolver typeResolver) {
			this.member = member;
			this.resolvedTypes = resolvedTypes;
			this.typeResolver = typeResolver;
		}

		@Override
		@Nullable
		protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
			try {
				resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
						Severity.ERROR, 
						IssueCodes.TOO_LITTLE_TYPE_INFORMATION, 
						"Cannot infer type",
						typeResolver.getSourceElement(member), 
						null, 
						-1, 
						null));
				return TypesFactory.eINSTANCE.createJvmAnyTypeReference();
			} finally {
				context.setTypeProvider(null);
			}
		}
	}

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private OverrideHelper overrideHelper;
	
	@Inject
	private AnnotationLookup annotationLookup;
	
	protected JvmType getRootJvmType() {
		EObject result = getRoot();
		if (result instanceof JvmType)
			return (JvmType) result;
//		throw new IllegalStateException();   
		
		return null;
	}
	
	@Override
	protected boolean isHandled(JvmIdentifiableElement identifiableElement) {
		if (identifiableElement instanceof XExpression) {
			return isHandled((XExpression) identifiableElement);
		}
		JvmIdentifiableElement container = logicalContainerProvider.getNearestLogicalContainer(identifiableElement);
		if (container != null) {
			return super.isHandled(container);
		}
		return super.isHandled(identifiableElement);
	}
	
	@Override
	protected boolean isHandled(XExpression expression) {
		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(expression);
		if (logicalContainer == null)
			return false;
		return isHandled(logicalContainer);
	}
	
	@Override
	protected boolean isHandled(EObject context) {
		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(context);
		if (logicalContainer == null)
			return false;
		return isHandled(logicalContainer);
	}
	
	/**
	 * Assign computed type references to the identifiable structural elements in the processed type.
	 * @return the stacked resolved types that shall be used in the computation.
	 */
	
	//cym comment
//	protected Map<JvmIdentifiableElement, ResolvedTypes> prepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession) {
//		Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext = Maps.newHashMapWithExpectedSize(3); 
//		doPrepare(resolvedTypes, featureScopeSession, getRootJvmType(), resolvedTypesByContext);
//		return resolvedTypesByContext;
//	}
	
	protected Map<JvmIdentifiableElement, ResolvedTypes> prepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession) {
		Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext = Maps.newHashMapWithExpectedSize(3); 
		
		EObject result = getRoot();
		if (result instanceof XModule){
			XModule file = (XModule) result;
			List<EObject> contents = file.getContents();
			for(EObject obj: contents){
				if(obj instanceof JvmDeclaredType || obj instanceof JvmDelegateType){
					doPrepare(resolvedTypes, featureScopeSession, (JvmIdentifiableElement)obj, resolvedTypesByContext);
				}
			}
		}

		return resolvedTypesByContext;
	}
	
	protected void doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmIdentifiableElement element, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		if (element instanceof JvmDeclaredType) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmDeclaredType) element, resolvedTypesByContext);
		} else if (element instanceof JvmConstructor) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmConstructor) element, resolvedTypesByContext);
		} else if (element instanceof JvmField) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmField) element, resolvedTypesByContext);
		} else if (element instanceof JvmEvent) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmEvent) element, resolvedTypesByContext);
		} else if (element instanceof JvmOperation) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmOperation) element, resolvedTypesByContext);
		} else if (element instanceof JvmDelegateType) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmDelegateType) element, resolvedTypesByContext);
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDelegateType delegate, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByType) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, delegate, resolvedTypesByType);
		
//		JvmParameterizedTypeReference thisType = getServices().getTypeReferences().createTypeRef(delegate);
//		LightweightTypeReference lightweightThisType = resolvedTypes.getConverter().toLightweightReference(thisType);
//		childResolvedTypes.reassignTypeWithoutMerge(delegate, lightweightThisType);
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByType) {
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, resolvedTypes.getReferenceOwner(), type);
		prepareMembers(resolvedTypes, childSession, type, resolvedTypesByType);
	}

	protected void prepareMembers(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByType) {
		IFeatureScopeSession childSession = addExtensionsToMemberSession(resolvedTypes, featureScopeSession, type);
		
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, type, resolvedTypesByType);
		
		JvmTypeReference superType = getExtendedClass(type);
		if (superType != null) {
			LightweightTypeReference lightweightSuperType = resolvedTypes.getConverter().toLightweightReference(superType);
			childResolvedTypes.reassignTypeWithoutMerge(superType.getType(), lightweightSuperType);
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
		JvmParameterizedTypeReference thisType = getServices().getTypeReferences().createTypeRef(type);
		LightweightTypeReference lightweightThisType = resolvedTypes.getConverter().toLightweightReference(thisType);
		childResolvedTypes.reassignTypeWithoutMerge(type, lightweightThisType);
		
		List<JvmMember> members = type.getMembers();
		int size = members.size();
		for(int i = 0; i < size; i++) {
			doPrepare(childResolvedTypes, childSession, members.get(i), resolvedTypesByType);
		}
	}

	protected StackedResolvedTypes declareTypeParameters(ResolvedTypes resolvedTypes, JvmIdentifiableElement declarator,
			Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = resolvedTypes.pushTypes();
		if (declarator instanceof JvmTypeParameterDeclarator) {
			JvmTypeParameterDeclarator casted = (JvmTypeParameterDeclarator) declarator;
			if (isStatic(declarator) && !(declarator instanceof JvmConstructor)) {
				childResolvedTypes.replaceDeclaredTypeParameters(casted.getTypeParameters());
			} else {
				childResolvedTypes.addDeclaredTypeParameters(casted.getTypeParameters());
			}
		}
		resolvedTypesByContext.put(declarator, childResolvedTypes);
		return childResolvedTypes;
	}
	
	protected boolean isStatic(JvmIdentifiableElement declarator) {
		if (declarator instanceof JvmFeature) {
			return ((JvmFeature) declarator).isStatic();
		}
		if (declarator instanceof JvmDeclaredType) {
			return ((JvmDeclaredType) declarator).isStatic();
		}
		return false;
	}

	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmField field, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, field, resolvedTypesByContext);
		
		JvmTypeReference knownType = field.getType();
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, field, (InferredTypeIndicator) casted.getTypeProvider(), false);
			casted.setEquivalent(reference);
		} else if (knownType != null) {
			LightweightTypeReference lightweightReference = childResolvedTypes.getConverter().toLightweightReference(knownType);
			childResolvedTypes.setType(field, lightweightReference);
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, field, null, false);
			field.setType(reference);
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmEvent event, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, event, resolvedTypesByContext);
		
		JvmTypeReference knownType = event.getType();
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, event, (InferredTypeIndicator) casted.getTypeProvider(), false);
			casted.setEquivalent(reference);
		} else if (knownType != null) {
			LightweightTypeReference lightweightReference = childResolvedTypes.getConverter().toLightweightReference(knownType);
			childResolvedTypes.setType(event, lightweightReference);
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, event, null, false);
			event.setType(reference);
		}
	}
	
	@Nullable
	protected DemandTypeReferenceProvider getComputedTypeReference(JvmTypeReference knownType) {
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference equivalent = casted.getEquivalent();
			if (equivalent instanceof XComputedTypeReference) {
				IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) equivalent).getTypeProvider();
				if (typeProvider instanceof DemandTypeReferenceProvider) {
					return (DemandTypeReferenceProvider) typeProvider;
				}
			}
		}
		return null;
	}
	
	protected void markComputing(JvmTypeReference knownType) {
		DemandTypeReferenceProvider demandTypeReferenceProvider = getComputedTypeReference(knownType);
		if (demandTypeReferenceProvider != null) {
			demandTypeReferenceProvider.markComputing();
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, constructor, resolvedTypesByContext);
		
		JvmDeclaredType producedType = constructor.getDeclaringType();
		JvmParameterizedTypeReference asReference = getServices().getTypeReferences().createTypeRef(producedType);
		LightweightTypeReference lightweightReference = childResolvedTypes.getConverter().toLightweightReference(asReference);
		childResolvedTypes.setType(constructor, lightweightReference);
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, operation, resolvedTypesByContext);
		
		JvmTypeReference knownType = operation.getReturnType();
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference reference = createComputedTypeReference(
					resolvedTypesByContext, childResolvedTypes, featureScopeSession, operation, (InferredTypeIndicator) casted.getTypeProvider(), true);
			casted.setEquivalent(reference);
		} else if (knownType != null) {
			LightweightTypeReference lightweightReference = childResolvedTypes.getConverter().toLightweightReference(knownType);
			childResolvedTypes.setType(operation, lightweightReference);
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, operation, null, true);
			operation.setReturnType(reference);
		}
	}
	
	protected JvmTypeReference createComputedTypeReference(
			Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext,
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmMember member,
			@Nullable InferredTypeIndicator indicator,
			boolean returnType) {
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		if (indicator == null || indicator.getExpression() == null)
			result.setTypeProvider(createTypeProvider(resolvedTypesByContext, resolvedTypes, featureScopeSession, member, returnType));
		else
			result.setTypeProvider(createTypeProvider(resolvedTypesByContext, resolvedTypes, featureScopeSession, member, indicator.getExpression(), returnType));
		// TODO do we need a lightweight computed type reference?
//		resolvedTypes.setType(member, result);
		return result;
	}
	
	protected AbstractReentrantTypeReferenceProvider createTypeProvider(Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member, boolean returnType) {
		XExpression expression = logicalContainerProvider.getAssociatedExpression(member);
		return createTypeProvider(resolvedTypesByContext, resolvedTypes, featureScopeSession, member, expression, returnType);
	}
	
	protected AbstractReentrantTypeReferenceProvider createTypeProvider(
			Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member, 
			@Nullable XExpression expression, boolean returnType) {
		if (expression != null) {
			resolvedTypes.markToBeInferred(expression);
			return new DemandTypeReferenceProvider(member, expression, resolvedTypesByContext, resolvedTypes, featureScopeSession, returnType, this);
		}
		return new AnyTypeReferenceProvider(member, resolvedTypes, this); 
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes = prepare(resolvedTypes, session);
		computeTypes(preparedResolvedTypes, resolvedTypes, session, getRoot());
	}
	
	//cym comment
//	protected void computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, EObject element) {
//		if (element instanceof JvmDeclaredType) {
//			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmDeclaredType) element);
//		} else if (element instanceof JvmConstructor) {
//			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmConstructor) element);
//		} else if (element instanceof JvmField) {
//			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmField) element);
//		} else if (element instanceof JvmOperation) {
//			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmOperation) element);
//		} else {
//			computeTypes(resolvedTypes, featureScopeSession, element);
//		}
//	}
	
	protected void computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, EObject element) {
		if (element instanceof XModule) {
			XModule module = (XModule) element;
			List<EObject> contents = module.getContents();
			
			for(EObject obj: contents){
				if(obj instanceof JvmDeclaredType){
					computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession,  obj);
				}else if(obj instanceof XVariableDeclarationList){
					_computeTypes( resolvedTypes, featureScopeSession, (XVariableDeclarationList) obj);
				} else if(obj instanceof XClosure){
					_computeTypes( resolvedTypes, featureScopeSession, (XClosure) obj);
				}  else if(obj instanceof JvmDelegateType){
					computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession,  obj);
				} else {
					_computeTypes( resolvedTypes, featureScopeSession, (XExpression) obj);
				}
			}
		} else if (element instanceof JvmEnumerationType) { //cym added
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmEnumerationType) element);
		} else if (element instanceof JvmDeclaredType) {  
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmDeclaredType) element);
		} else if (element instanceof JvmDelegateType) {  
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmDelegateType) element);
		} else if (element instanceof JvmConstructor) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmOperation) element);
		} else if (element instanceof JvmEvent) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmEvent) element);
		} else {
			computeTypes(resolvedTypes, featureScopeSession, element);
		}
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, EObject element) {
		if (element instanceof JvmConstructor) {
			throw new IllegalStateException();
		} else if (element instanceof JvmField) {
			throw new IllegalStateException();
		} else if (element instanceof JvmOperation) {
			throw new IllegalStateException();
		} else if (element instanceof JvmDeclaredType) {
			throw new IllegalStateException();
		} else {
			super.computeTypes(resolvedTypes, featureScopeSession, element);
		}
	}
	
//	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, XVariableDeclaration field) {
//		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(field);
//		if (childResolvedTypes == null) {
//			if (preparedResolvedTypes.containsKey(field))
//				return;
//			throw new IllegalStateException("No resolved type found. Field was: " + field.getIdentifier());
//		} else {
//			preparedResolvedTypes.put(field, null);
//		}
//		FieldTypeComputationState state = new FieldTypeComputationState(childResolvedTypes, field.isStatic() ? featureScopeSession : featureScopeSession.toInstanceContext(), field);
//		
//		IFeatureScopeSession session = /*function.isStatic() ? featureScopeSession : */featureScopeSession.toInstanceContext();
//		//cym add
//		//处理get、set有关的表达式
//		XExpression get = field.getGet();
//		if (get != null ) {
////			featureScopeSession.addLocalElement(IFeatureNames.THIS, (JvmIdentifiableElement) field.eContainer(), resolvedTypes.getReferenceOwner());
//			computeTypes(resolvedTypes, session, get);
//		}
//		XExpression set = field.getSet();
//		if (set != null ) {
//			IFeatureScopeSession childScopeSession = session.addLocalElement(QualifiedName.create("value"), field.getType().getType(), resolvedTypes.getReferenceOwner());
//			computeTypes(resolvedTypes, childScopeSession, set);
//		}
//		
//		XExpression expression = field.getDefaultValue();
//		if (expression != null ) {
//			computeTypes(resolvedTypes, featureScopeSession, expression);
//		}
//		//cym add
//		// no need to unmark the computing state since we replace the equivalent in #resolveTo
//		markComputing(field.getType());
//		ITypeComputationResult result = state.computeTypes();
//		if (InferredTypeIndicator.isInferred(field.getType())) {
//			LightweightTypeReference fieldType = result.getActualExpressionType();
//			if (fieldType != null)
//				InferredTypeIndicator.resolveTo(field.getType(), toJavaCompliantTypeReference(fieldType, featureScopeSession));
//		}
//		computeAnnotationTypes(childResolvedTypes, featureScopeSession, field);
//		
//		mergeChildTypes(childResolvedTypes);
//	}
//	
//	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, XClosure field) {
//		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(field);
//		if (childResolvedTypes == null) {
//			if (preparedResolvedTypes.containsKey(field))
//				return;
//			throw new IllegalStateException("No resolved type found. Field was: " + field.getIdentifier());
//		} else {
//			preparedResolvedTypes.put(field, null);
//		}
//		FieldTypeComputationState state = new FieldTypeComputationState(childResolvedTypes, field.isStatic() ? featureScopeSession : featureScopeSession.toInstanceContext(), field);
//		
//		IFeatureScopeSession session = /*function.isStatic() ? featureScopeSession : */featureScopeSession.toInstanceContext();
//		//cym add
//		//处理get、set有关的表达式
//		XExpression get = field.getGet();
//		if (get != null ) {
////			featureScopeSession.addLocalElement(IFeatureNames.THIS, (JvmIdentifiableElement) field.eContainer(), resolvedTypes.getReferenceOwner());
//			computeTypes(resolvedTypes, session, get);
//		}
//		XExpression set = field.getSet();
//		if (set != null ) {
//			IFeatureScopeSession childScopeSession = session.addLocalElement(QualifiedName.create("value"), field.getType().getType(), resolvedTypes.getReferenceOwner());
//			computeTypes(resolvedTypes, childScopeSession, set);
//		}
//		
//		XExpression expression = field.getDefaultValue();
//		if (expression != null ) {
//			computeTypes(resolvedTypes, featureScopeSession, expression);
//		}
//		//cym add
//		// no need to unmark the computing state since we replace the equivalent in #resolveTo
//		markComputing(field.getType());
//		ITypeComputationResult result = state.computeTypes();
//		if (InferredTypeIndicator.isInferred(field.getType())) {
//			LightweightTypeReference fieldType = result.getActualExpressionType();
//			if (fieldType != null)
//				InferredTypeIndicator.resolveTo(field.getType(), toJavaCompliantTypeReference(fieldType, featureScopeSession));
//		}
//		computeAnnotationTypes(childResolvedTypes, featureScopeSession, field);
//		
//		mergeChildTypes(childResolvedTypes);
//	}

	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmField field) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(field);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(field))
				return;
			throw new IllegalStateException("No resolved type found. Field was: " + field.getIdentifier());
		} else {
			preparedResolvedTypes.put(field, null);
		}
		FieldTypeComputationState state = new FieldTypeComputationState(childResolvedTypes, field.isStatic() ? featureScopeSession : featureScopeSession.toInstanceContext(), field);
		
		IFeatureScopeSession session = /*function.isStatic() ? featureScopeSession : */featureScopeSession.toInstanceContext();
		//cym add
		//处理get、set有关的表达式
		XExpression get = field.getGet();
		if (get != null ) {
//			featureScopeSession.addLocalElement(IFeatureNames.THIS, (JvmIdentifiableElement) field.eContainer(), resolvedTypes.getReferenceOwner());
			computeTypes(resolvedTypes, session, get);
		}
		XExpression set = field.getSet();
		if (set != null ) {
			IFeatureScopeSession childScopeSession = session.addLocalElement(QualifiedName.create("value"), field.getType().getType(), resolvedTypes.getReferenceOwner());
			computeTypes(resolvedTypes, childScopeSession, set);
		}
		
		XExpression expression = field.getDefaultValue();
		if (expression != null ) {
			computeTypes(resolvedTypes, featureScopeSession, expression);
		}
		//cym add
		// no need to unmark the computing state since we replace the equivalent in #resolveTo
		markComputing(field.getType());
		ITypeComputationResult result = state.computeTypes();
		if (InferredTypeIndicator.isInferred(field.getType())) {
			LightweightTypeReference fieldType = result.getActualExpressionType();
			if (fieldType != null)
				InferredTypeIndicator.resolveTo(field.getType(), toJavaCompliantTypeReference(fieldType, featureScopeSession));
		}
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, field);
		
		mergeChildTypes(childResolvedTypes);
	}
	
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmEvent event) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(event);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(event))
				return;
			throw new IllegalStateException("No resolved type found. Field was: " + event.getIdentifier());
		} else {
			preparedResolvedTypes.put(event, null);
		}
		EventTypeComputationState state = new EventTypeComputationState(childResolvedTypes, event.isStatic() ? featureScopeSession : featureScopeSession.toInstanceContext(), event);
		
		IFeatureScopeSession session = /*function.isStatic() ? featureScopeSession : */featureScopeSession.toInstanceContext();
		//cym add
		//处理get、set有关的表达式
		XExpression get = event.getAdd();
		if (get != null ) {
//			featureScopeSession.addLocalElement(IFeatureNames.THIS, (JvmIdentifiableElement) field.eContainer(), resolvedTypes.getReferenceOwner());
			computeTypes(resolvedTypes, session, get);
		}
		XExpression set = event.getRemove();
		if (set != null ) {
			IFeatureScopeSession childScopeSession = session.addLocalElement(QualifiedName.create("value"), event.getType().getType(), resolvedTypes.getReferenceOwner());
			computeTypes(resolvedTypes, childScopeSession, set);
		}
		
		//cym add
		// no need to unmark the computing state since we replace the equivalent in #resolveTo
		markComputing(event.getType());
		ITypeComputationResult result = state.computeTypes();
		if (InferredTypeIndicator.isInferred(event.getType())) {
			LightweightTypeReference fieldType = result.getActualExpressionType();
			if (fieldType != null)
				InferredTypeIndicator.resolveTo(event.getType(), toJavaCompliantTypeReference(fieldType, featureScopeSession));
		}
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, event);
		
		mergeChildTypes(childResolvedTypes);
	}
	
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(constructor);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(constructor))
				return;
			throw new IllegalStateException("No resolved type found. Constructor was: " + constructor.getIdentifier());
		} else {
			preparedResolvedTypes.put(constructor, null);
		}
		ConstructorBodyComputationState state = new ConstructorBodyComputationState(childResolvedTypes, featureScopeSession.toInstanceContext(), constructor);

		addExtensionProviders(state, constructor.getParameters());
		state.computeTypes();
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, constructor);
		for(JvmFormalParameter parameter: constructor.getParameters()) {
			computeAnnotationTypes(childResolvedTypes, featureScopeSession, parameter);
		}
		
		mergeChildTypes(childResolvedTypes);
	}
	
	protected void addExtensionProviders(ITypeComputationState state, List<JvmFormalParameter> parameters) {
		List<JvmFormalParameter> extensionProviders = null;
		for(JvmFormalParameter parameter: parameters) {
			if (isExtensionProvider(parameter)) {
				if (extensionProviders == null)
					extensionProviders = Lists.newLinkedList();
				extensionProviders.add(parameter);
			}
		}
		if (extensionProviders != null)
			state.addExtensionsToCurrentScope(extensionProviders);
	}
	
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(operation);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(operation))
				return;
			throw new IllegalStateException("No resolved type found. Operation was: " + operation.getIdentifier());
		} else {
			preparedResolvedTypes.put(operation, null);
		}
		OperationBodyComputationState state = new OperationBodyComputationState(childResolvedTypes, operation.isStatic() ? featureScopeSession : featureScopeSession.toInstanceContext(), operation);
		
		
//		IFeatureScopeSession session = /*function.isStatic() ? featureScopeSession : */featureScopeSession.toInstanceContext();
////		computeTypes(resolvedTypes, session, createInfo.getCreateExpression());
//		//cym add
//		XClosure closure = (XClosure) operation.getFunction();
//		XExpression expression = closure.getExpression();
//		if (expression != null ) {
//			computeTypes(resolvedTypes, session, expression);
//		}
//		// cym end

		addExtensionProviders(state, operation.getParameters());
		// no need to unmark the computing state since we replace the equivalent in #resolveTo
		markComputing(operation.getReturnType());
		setReturnType(operation, state.computeTypes(), featureScopeSession);
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, operation);
		
		mergeChildTypes(childResolvedTypes);
	}
	
	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession sessions, JvmDelegateType operation) {
//		computeAnnotationTypes(resolvedTypes, sessions, (JvmAnnotationTarget) operation);
		for(JvmFormalParameter parameter: operation.getParameters()) {
			computeAnnotationTypes(resolvedTypes, sessions, parameter);
		}
	}

	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession sessions, JvmExecutable operation) {
		computeAnnotationTypes(resolvedTypes, sessions, (JvmAnnotationTarget) operation);
		for(JvmFormalParameter parameter: operation.getParameters()) {
			computeAnnotationTypes(resolvedTypes, sessions, parameter);
		}
	}

	protected void mergeChildTypes(ResolvedTypes childResolvedTypes) {
		if (childResolvedTypes instanceof StackedResolvedTypes)
			((StackedResolvedTypes) childResolvedTypes).mergeIntoParent();
	}
	
	protected void setReturnType(JvmDelegateType operation, ITypeComputationResult computedType, IFeatureScopeSession session) {
		if (InferredTypeIndicator.isInferred(operation.getReturnType())) {
			LightweightTypeReference returnType = computedType.getReturnType();
			if (returnType != null) {
				InferredTypeIndicator.resolveTo(operation.getReturnType(), toJavaCompliantTypeReference(returnType, session));
			}
		}
	}

	protected void setReturnType(JvmOperation operation, ITypeComputationResult computedType, IFeatureScopeSession session) {
		if (InferredTypeIndicator.isInferred(operation.getReturnType())) {
			LightweightTypeReference returnType = computedType.getReturnType();
			if (returnType != null) {
				InferredTypeIndicator.resolveTo(operation.getReturnType(), toJavaCompliantTypeReference(returnType, session));
			}
		}
	}
	
	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmAnnotationTarget annotable) {
		List<JvmAnnotationReference> annotations = annotable.getAnnotations();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, annotations);
	}

	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, List<JvmAnnotationReference> annotations) {
		for(JvmAnnotationReference annotation: annotations) {
			//没有JvmModelInfer了
//			EObject sourceElement = getSourceElement(annotation); //cym comment
//			if (sourceElement != annotation) {
//				computeTypes(resolvedTypes, featureScopeSession, sourceElement);
//			} else {
				for(JvmAnnotationValue value: annotation.getValues()) {
					if (value instanceof JvmCustomAnnotationValue) {
						JvmCustomAnnotationValue custom = (JvmCustomAnnotationValue) value;
						for(Object object: custom.getValues()) {
							if (object instanceof XExpression) {
								AnnotationValueTypeComputationState state = new AnnotationValueTypeComputationState(resolvedTypes, featureScopeSession, value, (XExpression) object);
								state.computeTypes();
							}
						}
					//已经不允许嵌套Annotation了
//					} else if (value instanceof JvmAnnotationAnnotationValue) {  
//						computeAnnotationTypes(resolvedTypes, featureScopeSession, ((JvmAnnotationAnnotationValue) value).getValues());
					}
				}
//			}
		}
	}
	
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDelegateType type) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(type);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(type))
				return;
			throw new IllegalStateException("No resolved type found. Operation was: " + type.getIdentifier());
		} else {
			preparedResolvedTypes.put(type, null);
		}
		JvmDelegateComputationState state = new JvmDelegateComputationState(childResolvedTypes, /*type.isStatic() ? featureScopeSession :*/ featureScopeSession.toInstanceContext(), type);

//		addExtensionProviders(state, operation.getParameters());
		// no need to unmark the computing state since we replace the equivalent in #resolveTo
		markComputing(type.getReturnType());
		setReturnType(type, state.computeTypes(), featureScopeSession);
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, type);
		
		mergeChildTypes(childResolvedTypes);
	}
	
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(type);
		//检查有无extends，如果没有，就添加一个
		if(type instanceof JvmGenericType){
			JvmGenericType gType = (JvmGenericType) type;
			JvmParameterizedTypeReference baseTypeRef = (JvmParameterizedTypeReference) gType.getExtendedClass();
			if(baseTypeRef == null && !"Object".equals(gType.getSimpleName())){
				baseTypeRef =TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
				baseTypeRef.setType(Buildin.Object.JvmType);
				gType.setExtends(baseTypeRef);
			}
		}
		
		if (childResolvedTypes == null)
			throw new IllegalStateException("No resolved type found. Type was: " + type.getIdentifier());
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, childResolvedTypes.getReferenceOwner(), type);
		computeMemberTypes(preparedResolvedTypes, childResolvedTypes, childSession, type);
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, type);
		
		mergeChildTypes(childResolvedTypes);
	}
	
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmEnumerationType type) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(type);
		if (childResolvedTypes == null)
			throw new IllegalStateException("No resolved type found. Type was: " + type.getIdentifier());
//		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, childResolvedTypes.getReferenceOwner(), type);

		EList<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			JvmMember member = members.get(i);
			JvmField field = (JvmField) member;
			JvmParameterizedTypeReference typeRef = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			typeRef.setType(Buildin.Integer.JvmType);
			field.setType(typeRef);
			field.setStatic(true);
//			computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, members.get(i));
		}
		
//		computeMemberTypes(preparedResolvedTypes, childResolvedTypes, childSession, type);
		
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, type);
		
		mergeChildTypes(childResolvedTypes);
	}

	protected void computeMemberTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmDeclaredType type) {
		IFeatureScopeSession childSession = addExtensionsToMemberSession(resolvedTypes, featureScopeSession, type);
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			JvmMember member = members.get(i);
			if(member instanceof JvmField){
				JvmField field = (JvmField) member;
				if(member.getModifiers().contains("static")){
					field.setStatic(true);
				}
			}
			
			if(member instanceof JvmOperation){
				JvmOperation operation = (JvmOperation) member;
				if(member.getModifiers().contains("static")){
					operation.setStatic(true);
				}
				
				if(operation.getModifiers().contains("overload")){
					operation.setOverload(true);
				}
			}

			computeTypes(preparedResolvedTypes, resolvedTypes, childSession, members.get(i));
		}
	}
	
	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, ITypeReferenceOwner owner, JvmDeclaredType type) {
		JvmTypeReference superType = getExtendedClass(type);
		return addThisAndSuper(session, owner, type, superType);
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
	
	@Nullable
	public JvmTypeReference getExtendedClass(JvmDeclaredType type) {
		for(JvmTypeReference candidate: type.getSuperTypes()) {
			if (candidate.getType() instanceof JvmGenericType && !((JvmGenericType) candidate.getType()).isInterface())
				return candidate;
		}
		return null;
	}
	
	protected IFeatureScopeSession addExtensionsToMemberSession(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		IEObjectDescription thisDescription = featureScopeSession.getLocalElement(IFeatureNames.THIS);
		if (thisDescription == null) {
			throw new IllegalStateException("Cannot find feature 'THIS'");
		}
		JvmIdentifiableElement thisFeature = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
		IFeatureScopeSession childSession = addExtensionFieldsToMemberSession(
				resolvedTypes, featureScopeSession, type, thisFeature, Sets.<String>newHashSetWithExpectedSize(8), Sets.<JvmType>newHashSetWithExpectedSize(4));
		XFeatureCall thisAccess = getXbaseFactory().createXFeatureCall();
		thisAccess.setFeature(thisFeature);
		LightweightTypeReference thisType = resolvedTypes.getActualType(thisFeature);
		childSession = childSession.addToExtensionScope(Collections.<XExpression, LightweightTypeReference>singletonMap(thisAccess, thisType));
		return childSession;
	}
	
	protected IFeatureScopeSession addExtensionFieldsToMemberSession(
				ResolvedTypes resolvedTypes, 
				IFeatureScopeSession featureScopeSession, 
				JvmDeclaredType type, 
				JvmIdentifiableElement thisFeature,
				Set<String> seenNames,
				Set<JvmType> seenTypes) {
		if (seenTypes.add(type)) {
			Iterable<JvmField> fields = type.getDeclaredFields();
			// collect local fields first, to populate the set of names
			Map<XExpression, LightweightTypeReference> extensionProviders = null;
			for(JvmField field: fields) {
				if (featureScopeSession.isVisible(field) && seenNames.add(field.getSimpleName()) && isExtensionProvider(field)) {
					if (extensionProviders == null) {
						extensionProviders = Maps2.newLinkedHashMapWithExpectedSize(3);
					}
					XMemberFeatureCall extensionProvider = createExtensionProvider(thisFeature, field);
					LightweightTypeReference fieldType = resolvedTypes.getActualType(field);
					extensionProviders.put(extensionProvider, fieldType);
				}
			}
			// traverse the type hierarchy to create the feature scope sessions
			JvmTypeReference superType = getExtendedClass(type);
			IFeatureScopeSession result = featureScopeSession;
			if (superType != null) {
				result = addExtensionFieldsToMemberSession(resolvedTypes, featureScopeSession, (JvmDeclaredType) superType.getType(), thisFeature, seenNames, seenTypes);
			}
			if (extensionProviders != null) {
				result = result.addToExtensionScope(extensionProviders);
			}
			return result;
		}
		return featureScopeSession;
	}
	
	protected XMemberFeatureCall createExtensionProvider(JvmIdentifiableElement thisFeature, JvmField field) {
		XMemberFeatureCall extensionProvider = getXbaseFactory().createXMemberFeatureCall();
		extensionProvider.setFeature(field);
		XFeatureCall thisAccess = getXbaseFactory().createXFeatureCall();
		thisAccess.setFeature(thisFeature);
		extensionProvider.setMemberCallTarget(thisAccess);
		return extensionProvider;
	}
	
	protected boolean isExtensionProvider(JvmAnnotationTarget annotatedElement) {
		// coding style to simplify debugging
		if (annotationLookup.findAnnotation(annotatedElement, Extension.class) != null) {
			return true;
		}
		return false;
	}

	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return logicalContainerProvider;
	}
	
	/**
	 * Returns <code>null</code> if the given operation declares it's own return type or if it does not override
	 * another operation.
	 */
	@Nullable
	protected LightweightTypeReference getReturnTypeOfOverriddenOperation(JvmOperation operation, ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		if (operation.getVisibility() == JvmVisibility.PRIVATE)
			return null;
		if (InferredTypeIndicator.isInferred(operation.getReturnType())) {
			LightweightTypeReference declaringType = resolvedTypes.getActualType(operation.getDeclaringType());
			if (declaringType == null) {
				throw new IllegalStateException("Cannot determine declaring type of operation: " + operation);
			}
			LightweightTypeReference result = overrideHelper.getReturnTypeOfOverriddenOperation(operation, declaringType);
			return result;
		}
		return null;
	}

	@Override
	protected EObject getSourceElement(EObject element) {
		EObject result = associations.getPrimarySourceElement(element);
		if (result != null)
			return result;
		return element;
	}
	
	protected Set<EObject> getInferredElements(EObject element) {
		return associations.getJvmElements(element);
	}
	
	protected JvmTypeReference toJavaCompliantTypeReference(LightweightTypeReference result, IFeatureScopeSession session) {
		return result.toJavaCompliantTypeReference(session);
	}
}
