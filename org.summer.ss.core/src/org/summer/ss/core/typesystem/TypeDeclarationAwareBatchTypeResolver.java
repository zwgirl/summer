/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.typesystem;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.summer.dsl.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TypeDeclarationAwareBatchTypeResolver extends LogicalContainerAwareBatchTypeResolver {

//	@Override
//	protected List<EObject> getEntryPoints(EObject object) {
//		 List<EObject> result = super.getEntryPoints(object);
//		 EObject rootContainer = EcoreUtil.getRootContainer(object);
//		 if (rootContainer instanceof XtendFile) {
//			 List<EObject> resultIncludingXtendTypes = Lists.newArrayList(result);
//			 //cym modified
////			 List<XtendTypeDeclaration> typeDeclarations = ((XtendFile) rootContainer).getXtendTypes();
//			 List<EObject> typeDeclarations = ((XtendFile) rootContainer).getContents();
//			 resultIncludingXtendTypes.addAll(typeDeclarations);
//			 return resultIncludingXtendTypes;
//		 }
//		 return result;
//	}
	
}
