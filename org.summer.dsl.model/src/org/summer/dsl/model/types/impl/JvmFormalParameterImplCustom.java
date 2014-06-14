/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmFormalParameterImplCustom extends JvmFormalParameterImpl {
	
	@Override
	public String getSimpleName() {
		if (simpleName == null) {
			EObject executable = eContainer();
			if (executable instanceof JvmExecutableImplCustom) {
				JvmExecutableImplCustom jvmExecutableImplCustom = (JvmExecutableImplCustom) executable;
				jvmExecutableImplCustom.runInitializer();
			}
		}
		return simpleName;
	}

	@Override
	public String getIdentifier() {
		return getSimpleName();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return getSimpleName();
	}

	@Override
	public String toString() {
		if (simpleName != null) {
			return "param " + simpleName;
		}
		String result = "param [name not computed]";
		EObject executable = eContainer();
		if (executable != null) {
			EReference containmentFeature = eContainmentFeature();
			result = result + "@" + containmentFeature.getName();
			if (containmentFeature.isMany()) {
				List<?> siblings = (List<?>) executable.eGet(eContainmentFeature());
				int idx = siblings.indexOf(this);
				result = result + "[" + idx + "]";
			}
		}
		return result; 
	}
}
