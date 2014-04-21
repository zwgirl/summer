/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.hover;

import java.util.Iterator;

import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.validation.UIStrings;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class HoverUiStrings extends UIStrings {

	protected String formalParametersToString(Iterable<? extends JvmFormalParameter> elements, boolean isVarArgs) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		Iterator<? extends JvmFormalParameter> iterator = elements.iterator();
		while (iterator.hasNext()) {
			JvmFormalParameter parameter = iterator.next();
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			JvmTypeReference typeRef = parameter.getParameterType();
			if(typeRef != null) {
				if (typeRef instanceof JvmAnyTypeReference)
					buffer.append("Object");
				else {
					if (isVarArgs && !iterator.hasNext()) {
						if (typeRef instanceof JvmGenericArrayTypeReference) {
							buffer.append(((JvmGenericArrayTypeReference) typeRef).getComponentType().getSimpleName());
						} else {
							buffer.append(typeRef.getSimpleName());
						}
						buffer.append("...");
					} else {
						buffer.append(typeRef.getSimpleName());
					}
				}
			} else 
				buffer.append("[null]");
			buffer.append(" " + parameter.getName());
		}
		return buffer.toString();
	}
	
	@Override
	protected String parameterTypes(Iterable<JvmFormalParameter> parameters, boolean isVarArgs) {
		return formalParametersToString(parameters, isVarArgs);
	}
}
