/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.jvmmodel;

import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.xbase.compiler.IAppendable;
import org.summer.dsl.xbase.compiler.Later;
import org.summer.dsl.xbase.compiler.TreeAppendableUtil;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

@NonNullByDefault
public class DispatchMethodCompileStrategy implements Procedures.Procedure1<ITreeAppendable> {
	
	@Inject
	private TypeReferences typeReferences;

	@Inject
	private TreeAppendableUtil treeAppendableUtil;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private DispatchHelper sorter;
	
	private List<JvmOperation> sortedDispatchOperations;

	private JvmOperation dispatchOperation;

	protected void initialize(JvmOperation dispatchOperation, List<JvmOperation> sortedDispatchOperations) {
		this.dispatchOperation = dispatchOperation;
		this.sortedDispatchOperations = sortedDispatchOperations;
	}

	public void apply(@Nullable ITreeAppendable a) {
		if (a == null)
			throw new IllegalArgumentException("a is never null");
		boolean needsElse = true;
		int parameterCount = dispatchOperation.getParameters().size();
		List<JvmOperation> sortedDispatchOperations = Lists.newArrayList(this.sortedDispatchOperations);
		sorter.sort(sortedDispatchOperations);
		boolean[] allCasesSameType = new boolean[parameterCount];
		for(int i = 0; i < parameterCount; i++) {
			allCasesSameType[i] = true;
			JvmTypeReference dispatchParameterType = dispatchOperation.getParameters().get(i).getParameterType();
			for (JvmOperation operation : sortedDispatchOperations) {
				JvmFormalParameter parameter = operation.getParameters().get(i);
				JvmTypeReference caseParameterType = parameter.getParameterType();
				if (!Strings.equal(dispatchParameterType.getIdentifier(), caseParameterType.getIdentifier())) {
					allCasesSameType[i] = false;
					break;
				}
			}
		}
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, dispatchOperation);
		OwnedConverter converter = new OwnedConverter(owner);
		for (JvmOperation operation : sortedDispatchOperations) {
			ITreeAppendable operationAppendable = treeAppendableUtil.traceSignificant(a, operation, true);
			final List<Later> laters = newArrayList();
			for (int i = 0; i < parameterCount; i++) {
				final JvmFormalParameter dispatchParam = dispatchOperation.getParameters().get(i);
				final LightweightTypeReference dispatchParamType = converter.toLightweightReference(dispatchParam.getParameterType());
				final JvmFormalParameter caseParam = operation.getParameters().get(i);
				final LightweightTypeReference caseParamType = converter.toLightweightReference(caseParam.getParameterType());
				final String name = getVarName(dispatchParam, operationAppendable);
				if (caseParamType.isType(Void.class)) {
					laters.add(new Later() {
						public void exec(ITreeAppendable appendable) {
							appendable.append(name).append(" == null");
						}
					});
				} else if (!allCasesSameType[i]) {
					laters.add(new Later() {
						public void exec(ITreeAppendable appendable) {
							if (caseParamType.isAssignableFrom(dispatchParamType, 
									new TypeConformanceComputationArgument(true, false, true, true, false, false)) && !dispatchParamType.isPrimitive()) {
								appendable.append(name).append(" != null");
							} else {
								appendable.append(name).append(" instanceof ");
								JvmType type = caseParamType.getWrapperTypeIfPrimitive().getType();
								if (type == null) {
									throw new IllegalStateException(String.valueOf(caseParamType));
								}
								appendable.append(type);
							}
						}
					});
				}
			}
			// if it's not the first if append an 'else'
			if (sortedDispatchOperations.get(0) != operation) {
				operationAppendable.append(" else ");
			}
			if (laters.isEmpty()) {
				needsElse = false;
				operationAppendable.append("{").increaseIndentation();
			} else {
				operationAppendable.append("if (");
				operationAppendable.increaseIndentation().increaseIndentation();
				Iterator<Later> iterator = laters.iterator();
				while (iterator.hasNext()) {
					iterator.next().exec(operationAppendable);
					if (iterator.hasNext()) {
						operationAppendable.newLine().append(" && ");
					}
				}
				operationAppendable.decreaseIndentation().decreaseIndentation();
				operationAppendable.append(") {").increaseIndentation();
			}
			operationAppendable.newLine();
			final boolean isCurrentVoid = typeReferences.is(operation.getReturnType(), Void.TYPE);
			final boolean isDispatchVoid = typeReferences.is(dispatchOperation.getReturnType(), Void.TYPE);
			if (isDispatchVoid) {
				generateActualDispatchCall(dispatchOperation, operation, operationAppendable, converter);
				// we generate a redundant return statement here to get a better debugging experience
				operationAppendable.append(";").newLine().append("return;");
			} else {
				if (isCurrentVoid) {
					generateActualDispatchCall(dispatchOperation, operation, operationAppendable, converter);
					operationAppendable.append(";").newLine().append("return null");
				} else {
					operationAppendable.append("return ");
					generateActualDispatchCall(dispatchOperation, operation, operationAppendable, converter);
				}
				operationAppendable.append(";");
			}
			operationAppendable.decreaseIndentation();
			a.newLine().append("}");
		}
		if (needsElse) {
			a.append(" else {").increaseIndentation();
			a.newLine();
			a.increaseIndentation();
			a.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +").newLine();
			JvmType jvmType = typeReferences.findDeclaredType("java.util.Arrays", dispatchOperation);
			a.append(jvmType).append(".<Object>asList(");
			Iterator<JvmFormalParameter> iterator = dispatchOperation.getParameters().iterator();
			while (iterator.hasNext()) {
				JvmFormalParameter parameter = iterator.next();
				final String name = getVarName(parameter, a);
				a.append(name);
				if (iterator.hasNext()) {
					a.append(", ");
				}
			}
			a.append(").toString());");
			a.decreaseIndentation();
			a.decreaseIndentation().newLine().append("}");
		}
	}

	protected void generateActualDispatchCall(JvmOperation dispatchOperation, JvmOperation actualOperationToCall,
			ITreeAppendable a, OwnedConverter converter) {
		a.append(actualOperationToCall.getSimpleName()).append("(");
		Iterator<JvmFormalParameter> iter1 = dispatchOperation.getParameters().iterator();
		for (Iterator<JvmFormalParameter> iter2 = actualOperationToCall.getParameters().iterator(); iter2.hasNext();) {
			JvmFormalParameter p1 = iter1.next();
			JvmFormalParameter p2 = iter2.next();
			LightweightTypeReference type1 = converter.toLightweightReference(p1.getParameterType());
			LightweightTypeReference type2 = converter.toLightweightReference(p2.getParameterType());
			if (!type2.isAssignableFrom(type1, new TypeConformanceComputationArgument(true, false, true, true, false, false))) {
				a.append("(").append(type2.getWrapperTypeIfPrimitive()).append(")");
			}
			if (typeReferences.is(p2.getParameterType(), Void.class)) {
				a.append("null");
			} else {
				a.append(getVarName(p1, a));
			}
			if (iter2.hasNext()) {
				a.append(", ");
			}
		}
		a.append(")");
	}

	/**
	 * TODO: we assume that names from the inferred JVM model are the same in the Java code. Does that assumption
	 * hold?
	 */
	protected String getVarName(JvmIdentifiableElement ex, IAppendable appendable) {
		return ex.getSimpleName();
	}
}