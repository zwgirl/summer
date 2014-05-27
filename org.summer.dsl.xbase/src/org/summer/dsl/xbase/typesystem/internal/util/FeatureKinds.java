/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal.util;

import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclaration;

/**
 * Allows to retrieve a human readable representation of the various
 * possible linking targets.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This method is not intended to be referenced by clients.
 */
public class FeatureKinds {
	public static String getTypeName(JvmIdentifiableElement feature) {
		if (feature instanceof JvmFormalParameter) {
			return "parameter";
		}
		if (feature instanceof XVariableDeclaration) {
			return "local variable";
		}
		if (feature instanceof JvmEnumerationLiteral) {
			return "enum literal";
		}
		if (feature instanceof JvmField) {
			return "field";
		}
		if (feature instanceof JvmOperation) {
			return "method";
		}
		if (feature instanceof JvmConstructor) {
			return "constructor";
		}
		if (feature instanceof JvmType) {
			return "type";
		}
		
		//cym add
		if (feature instanceof XClosure) {
			return "closure";
		}
		if (feature instanceof XFunctionDeclaration) {
			return "function";
		}
		throw new IllegalStateException("unknow feature " + feature);
	}
}
