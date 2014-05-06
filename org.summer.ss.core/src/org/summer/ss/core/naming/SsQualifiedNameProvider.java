/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.naming;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.ss.XtendConstructor;
import org.summer.dsl.model.ss.XtendEnumLiteral;
import org.summer.dsl.model.ss.XtendField;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.xbase.scoping.XbaseQualifiedNameProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class SsQualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof XtendTypeDeclaration) {
			XtendTypeDeclaration typeDecl = (XtendTypeDeclaration) obj;
			String typeName = typeDecl.getName();
			if (typeName == null)
				return null;
			XModule file = (XModule) typeDecl.eContainer();
			String packageName = file.getPackage();
			if (packageName != null) {
				return qualifiedNameConverter.toQualifiedName(packageName).append(typeName);
			}
			return QualifiedName.create(typeName);
		}
		if (obj instanceof XtendConstructor) {
			return getFullyQualifiedName(obj.eContainer());
		}
		if (obj instanceof JvmIdentifiableElement && !(obj instanceof JvmTypeParameter)) {
			return getFullyQualifiedName((JvmIdentifiableElement) obj);
		}
		if (obj instanceof XtendField) {
			return concatNames(obj, ((XtendField) obj).getName());
		}
		if (obj instanceof XtendFunction) {
			return concatNames(obj, ((XtendFunction) obj).getName());
		}
		if (obj instanceof XtendEnumLiteral) {
			return concatNames(obj, ((XtendEnumLiteral) obj).getName());
		}
		return null;
	}

	protected QualifiedName concatNames(EObject obj, String name) {
		if (name == null)
			return null;
		QualifiedName parentName = getFullyQualifiedName(obj.eContainer());
		if (parentName == null)
			return null;
		return parentName.append(name);
	}

}
