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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xaml.XObjectElement;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ModuleComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public ModuleComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmModule module) {
		super(resolvedTypes, featureScopeSession, module);
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
		return new NoTypeResult(getContainer(), resolvedTypes.getReferenceOwner());
	}

	@Override
	public void computeTypes() {
		List<EObject> contents = getContainer().eContents();
		for (EObject obj : contents) {
			if (obj instanceof JvmGenericType) {
				ClassTypeComputationState state = new ClassTypeComputationState(resolvedTypes, featureScopeSession, (JvmGenericType) obj);
				state.computeTypes();
				
			} else if(obj instanceof XFunctionDeclaration){
				XFunctionDeclaration function = (XFunctionDeclaration) obj;
				
				StackedResolvedTypes functionResolvedTypes = declareTypeParameters(resolvedTypes, function);
				
				LightweightTypeReference lightweightReference = resolvedTypes.getConverter().toLightweightReference(function.getReturnType());
				functionResolvedTypes.setType(function, lightweightReference);
				
				FunctionComputationState state = new FunctionComputationState(functionResolvedTypes, featureScopeSession, function);
				state.computeTypes();
				functionResolvedTypes.mergeIntoParent();
			}  else if (obj instanceof XStatment) {
				XStatment statment = (XStatment) obj;
				getResolver().getTypeComputer().computeTypes(statment, this);
				
				if(statment instanceof XVariableDeclarationList){
					if (statment instanceof XVariableDeclarationList) {
						XVariableDeclarationList declList = (XVariableDeclarationList) statment;
						for(XExpression exp : declList.getDeclarations()){
							addLocalToCurrentScope((XVariableDeclaration)exp);
						}
					}
				}
			}else if(obj instanceof XObjectElement){
				System.out.println(obj);
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
