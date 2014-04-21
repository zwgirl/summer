/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typing;

import static com.google.common.collect.Lists.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.util.TypeConformanceComputer;
import org.summer.dsl.model.types.util.TypeReferences;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("deprecation")
public class JvmExceptions {
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypeConformanceComputer conformanceComputer;

	public Iterable<JvmTypeReference> findUnhandledExceptions(EObject context,
			Iterable<JvmTypeReference> thrownExceptions, Collection<JvmTypeReference> declaredExceptions) {
		JvmTypeReference runtimeException = typeReferences.getTypeForName(RuntimeException.class, context);
		List<JvmTypeReference> allowedExceptions = newArrayListWithCapacity(declaredExceptions.size() + 1);
		allowedExceptions.add(runtimeException);
		allowedExceptions.addAll(declaredExceptions);
		List<JvmTypeReference> unhandledExceptions = null;
		OUTER: for (JvmTypeReference thrownException : thrownExceptions) {
			for (JvmTypeReference allowedException : allowedExceptions) {
				if (conformanceComputer.isConformant(allowedException, thrownException))
					continue OUTER;
			}
			if (unhandledExceptions == null)
				unhandledExceptions = newArrayList();
			unhandledExceptions.add(thrownException);
		}
		return (unhandledExceptions == null) ? Collections.<JvmTypeReference> emptyList() : unhandledExceptions;
	}
}
