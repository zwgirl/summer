/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmIdentifiableElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmTypeParameterImplCustom extends JvmTypeParameterImpl {
	
	@Override
	public String getIdentifier() {
		return simpleName;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return simpleName;
	}
	
	@Override
	public String getSimpleName() {
		return simpleName;
	}
	
	@Override
	public String toString() {
		//cym comment
//		EObject container = eContainer();
//		if (container instanceof JvmIdentifiableElement) {
//			StringBuilder result = new StringBuilder(eClass().getName());
//			result.append(" <");
//			result.append(name);
//			result.append("> ");
//			result.append(((JvmIdentifiableElement) container).getQualifiedName());
//			return result.toString();
//		} else {
//			StringBuilder result = new StringBuilder(eClass().getName());
//			result.append(" <");
//			result.append(name);
//			result.append(">");
//			if (constraints != null) {
//				result.append(constraints);
//			}
//			return result.toString();
//		}
		
	       return getClass().getName() + "@" + Integer.toHexString(hashCode());
	}

}
