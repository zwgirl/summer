/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.jvmmodel;

import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.xtext.util.Strings.isEmpty;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * Renames synthetic elements to avoid name clashes. Dispatch methods are handled by validation.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SyntheticNameClashResolver {

	@Inject
	private IXtendJvmAssociations associations;

	public void resolveNameClashes(JvmGenericType type) {
		Multimap<String, JvmIdentifiableElement> classScope = HashMultimap.create();
		List<JvmMember> renameableMembers = newArrayList();
		for (JvmMember member : type.getMembers()) {
			String simpleName = member.getSimpleName();
			if (simpleName != null) {
				if (!isRenameable(member))
					classScope.put(simpleName, member);
				else
					renameableMembers.add(member);
			}
		}
		for (JvmMember renameable : renameableMembers) {
			String simpleName = renameable.getSimpleName();
			if (collides(renameable, simpleName, classScope)) {
				int count = 0;
				String currentName;
				do {
					if (count == Integer.MAX_VALUE)
						throw new IllegalStateException("Cannot find a collision-free name for "
								+ renameable.getIdentifier());
					currentName = simpleName + "_" + ++count;
				} while (collides(renameable, currentName, classScope));
				renameable.setSimpleName(currentName);
				classScope.put(currentName, renameable);
			} else {
				classScope.put(simpleName, renameable);
			}
		}
	}

	/*
	 * @return true or false ;-)
	 */
	protected boolean collides(JvmIdentifiableElement element, String currentName,
			Multimap<String, JvmIdentifiableElement> scope) {
		if (scope.containsKey(currentName)) {
			if (element instanceof JvmOperation) {
				for (JvmIdentifiableElement other : scope.get(currentName)) {
					if (!(other instanceof JvmOperation)
							|| ((JvmOperation) element).getParameters().size() == ((JvmOperation) other)
									.getParameters().size())
						return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	protected boolean isRenameable(JvmIdentifiableElement element) {
		String simpleName = element.getSimpleName();
		if (!simpleName.startsWith("_")) {
			return false;
		}
		EObject source = associations.getPrimarySourceElement(element);
		return (isCreateExtension(source) && (simpleName
				.startsWith(SsJvmModelInferrer.CREATE_CHACHE_VARIABLE_PREFIX) || simpleName
				.startsWith(SsJvmModelInferrer.CREATE_INITIALIZER_PREFIX)))
				|| isAnonymousExtensionField(source);
	}

	protected boolean isAnonymousExtensionField(EObject source) {
		return source instanceof JvmField /*&& ((JvmField) source).isExtension()*/
				&& isEmpty(((JvmField) source).getSimpleName());
	}

	protected boolean isCreateExtension(EObject source) {
		return false;
//		return source instanceof JvmOperation && ((JvmOperation) source).getCreateExtensionInfo() != null;
	}
}
