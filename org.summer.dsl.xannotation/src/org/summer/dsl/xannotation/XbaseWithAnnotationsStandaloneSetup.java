/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xannotation;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XbaseWithAnnotationsStandaloneSetup extends XbaseWithAnnotationsStandaloneSetupGenerated{

	public static void doSetup() {
		new XbaseWithAnnotationsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
//	@Override
//	public Injector createInjectorAndDoEMFRegistration() {
//		EPackage.Registry.INSTANCE.put(XannotationPackage.eINSTANCE.getNsURI(),XannotationPackage.eINSTANCE);
//		return super.createInjectorAndDoEMFRegistration();
//	}
}

