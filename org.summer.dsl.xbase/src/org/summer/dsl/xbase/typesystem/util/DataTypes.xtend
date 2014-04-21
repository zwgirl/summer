/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util

import com.google.inject.Inject
import java.util.Set
import org.summer.dsl.model.types.JvmTypeParameter
import org.summer.dsl.model.types.JvmTypeParameterDeclarator
import org.summer.dsl.model.types.TypesFactory
import org.summer.dsl.model.types.util.Primitives
import org.summer.dsl.model.types.util.TypeReferences
import org.summer.dsl.xbase.typesystem.conformance.IRawTypeHelper
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputer
import org.summer.dsl.model.xtype.XtypeFactory
import org.summer.dsl.xbase.typesystem.references.FunctionTypes
import org.summer.dsl.xbase.typesystem.computation.SynonymTypesProvider
import org.summer.dsl.xbase.typesystem.references.ArrayTypes
import com.google.inject.Singleton
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Singleton
class CommonTypeComputationServices {
	@Inject
	@Property
	TypeReferences typeReferences
	
	@Inject
	@Property
	TypeConformanceComputer typeConformanceComputer;

	@Inject
	@Property
	IRawTypeHelper rawTypeHelper
	
	@Inject
	@Property
	Primitives primitives;
	
	@Inject
	@Property
	FunctionTypes functionTypes;
	
	@Inject
	@Property
	ArrayTypes arrayTypes;
	
	@Inject
	@Property
	BoundTypeArgumentMerger boundTypeArgumentMerger

	@Inject
	@Property
	SynonymTypesProvider synonymTypesProvider
	
	@Inject
	@Property
	IJvmModelAssociations jvmModelAssociations
	
	@Inject
	@Property
	ExtendedEarlyExitComputer earlyExitComputer
	
	@Inject(optional = true)
	@Property
	XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;
	
	@Inject(optional = true)
	@Property
	TypesFactory typesFactory = TypesFactory.eINSTANCE;
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
class ConstraintVisitingInfo {
	Set<JvmTypeParameter> visiting
	JvmTypeParameterDeclarator declarator
	int idx
	
	new() {
		visiting = newHashSet
	}
	new(JvmTypeParameter initial) {
		visiting = newHashSet(initial)
	}
	def boolean tryVisit(JvmTypeParameter parameter) {
		return visiting.add(parameter);
	}
	def boolean canVisit(JvmTypeParameter parameter) {
		return !visiting.contains(parameter)
	}
	def void didVisit(JvmTypeParameter parameter) {
		visiting.remove(parameter);
	}
	def void pushInfo(JvmTypeParameterDeclarator declarator, int idx) {
		if (declarator == null)
			throw new NullPointerException("declarator may not be null")
		this.declarator = declarator;
		this.idx = idx;
	}
	def getCurrentDeclarator() {
		return declarator
	}
	def getCurrentIndex() {
		return idx
	}
}