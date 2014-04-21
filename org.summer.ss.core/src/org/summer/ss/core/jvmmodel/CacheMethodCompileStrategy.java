/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.jvmmodel;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.ss.CreateExtensionInfo;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.util.TypeReferences;
import org.summer.dsl.xbase.compiler.XbaseCompiler;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

public class CacheMethodCompileStrategy implements Procedures.Procedure1<ITreeAppendable> {
	@Inject
	private TypeReferences typeReferences;

	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;

	@Inject
	private XbaseCompiler compiler;
	
	@Inject 
	private CommonTypeComputationServices services;
	
	private CreateExtensionInfo createExtensionInfo;

	private JvmOperation initializerMethod;

	private JvmField cacheField;

	protected void init(CreateExtensionInfo createExtensionInfo, JvmField cacheField, JvmOperation initializerMethod) {
		this.createExtensionInfo = createExtensionInfo;
		this.initializerMethod = initializerMethod;
		this.cacheField = cacheField; 
	}

	public void apply(ITreeAppendable appendable) {
		JvmOperation cacheMethod = (JvmOperation) logicalContainerProvider
				.getLogicalContainer(createExtensionInfo.getCreateExpression());
		JvmDeclaredType containerType = cacheMethod.getDeclaringType();
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(containerType);
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, containerType);
		ParameterizedTypeReference listType = new ParameterizedTypeReference(owner, typeReferences.findDeclaredType(ArrayList.class, containerType));
		listType.addTypeArgument(new WildcardTypeReference(owner));
		JvmType collectonLiterals = typeReferences.findDeclaredType(CollectionLiterals.class, containerType);

		String cacheVarName = cacheField.getSimpleName();
		String cacheKeyVarName = appendable.declareSyntheticVariable("CacheKey", "_cacheKey");
		appendable.append("final ").append(listType).append(" ").append(cacheKeyVarName)
			.append(" = ").append(collectonLiterals).append(".newArrayList(");
		EList<JvmFormalParameter> list = cacheMethod.getParameters();
		for (Iterator<JvmFormalParameter> iterator = list.iterator(); iterator.hasNext();) {
			JvmFormalParameter jvmFormalParameter = iterator.next();
			appendable.append(getVarName(jvmFormalParameter));
			if (iterator.hasNext()) {
				appendable.append(", ");
			}
		}
		appendable.append(");");
		// declare result variable
		LightweightTypeReference returnType = resolvedTypes.getActualType(createExtensionInfo.getCreateExpression());
		appendable.newLine().append("final ").append(returnType);
		String resultVarName = "_result";
		appendable.append(" ").append(resultVarName).append(";");
		// open synchronize block
		appendable.newLine().append("synchronized (").append(cacheVarName).append(") {");
		appendable.increaseIndentation();
		// if the cache contains the key return the previously created object.
		appendable.newLine().append("if (").append(cacheVarName).append(".containsKey(").append(cacheKeyVarName)
				.append(")) {");
		appendable.increaseIndentation();
		appendable.newLine().append("return ").append(cacheVarName).append(".get(").append(cacheKeyVarName).append(");");
		appendable.decreaseIndentation().newLine().append("}");
		
		// execute the creation
		compiler.toJavaStatement(createExtensionInfo.getCreateExpression(), appendable, true);
		appendable.newLine();
		appendable.append(resultVarName).append(" = ");
		compiler.toJavaExpression(createExtensionInfo.getCreateExpression(), appendable);
		appendable.append(";");

		// store the newly created object in the cache
		appendable.newLine().append(cacheVarName).append(".put(").append(cacheKeyVarName).append(", ")
				.append(resultVarName).append(");");

		// close synchronize block
		appendable.decreaseIndentation();
		appendable.newLine().append("}");
		appendable.newLine().append(initializerMethod.getSimpleName()).append("(").append(resultVarName);
		for (JvmFormalParameter parameter : cacheMethod.getParameters()) {
			appendable.append(", ").append(parameter.getName());
		}
		appendable.append(");");
		// return the result
		appendable.newLine().append("return ");
		appendable.append(resultVarName).append(";");
	}

	protected String getVarName(JvmIdentifiableElement ex) {
		return ex.getSimpleName();
	}
}