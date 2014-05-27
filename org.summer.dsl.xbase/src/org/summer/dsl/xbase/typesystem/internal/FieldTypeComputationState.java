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
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class FieldTypeComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public FieldTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmField field) {
		super(resolvedTypes, featureScopeSession, field);
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result = returnType 
				? new TypeExpectation(type, actualState, returnType)
				: new RootTypeExpectation(type, actualState);
		return Collections.singletonList(result);
	}

	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		return getResolvedTypes().getConverter().toLightweightReference(getContainer().getType());
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		JvmField field = (JvmField) getContainer();
		JvmTypeReference type = field.getType();
		if (type != null) {
			final LightweightTypeReference result = resolvedTypes.getConverter().toLightweightReference(type);
			if (result != null) {
				return new NoTypeResult(getContainer(), result.getOwner()) {
					@Override
					public LightweightTypeReference getActualExpressionType() {
						return result;
					}
				};
			}
		}
		return new NoTypeResult(getContainer(), resolvedTypes.getReferenceOwner());
	}
	
	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression, StackedResolvedTypes typeResolution) {
		return new RootExpressionTypeComputationStateWithNonVoidExpectation(typeResolution, getFeatureScopeSession(), this, expression, getExpectedType());
		
	}
	
	@Override
	protected JvmField getContainer() {
		return (JvmField) super.getContainer();
	}

	@Override
	public void computeTypes() {
		if(getContainer().isProperty()){
			XStatment get = getContainer().getGet();
			if(get!=null){
				FieldGetTypeComputationState state = new FieldGetTypeComputationState(getResolvedTypes(), getFeatureScopeSession(), (XBlockStatment) get, getContainer().getType());
				state.computeTypes();
			}
			XStatment set = getContainer().getSet();
			if(set!=null){
				IFeatureScopeSession childScopeSession = getFeatureScopeSession().addLocalElement(QualifiedName.create("value"), getContainer().getType().getType(), resolvedTypes.getReferenceOwner());
				FieldSetTypeComputationState state = new FieldSetTypeComputationState(getResolvedTypes(), childScopeSession, (XBlockStatment) set);
				state.computeTypes();
			}
		}else{
			XExpression initial = getContainer().getDefaultValue();
			if(initial!=null){
				computeTypes(initial);
			}
		}
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
