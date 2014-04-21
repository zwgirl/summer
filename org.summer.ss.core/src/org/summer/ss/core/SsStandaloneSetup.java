
package org.summer.ss.core;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xannotation.XannotationPackage;
import org.summer.dsl.xbase.jvmmodel.JvmModelInferrerRegistry;
import org.summer.dsl.model.xtype.XtypePackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SsStandaloneSetup extends SsStandaloneSetupGenerated{
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		// don't call super, since that would create useless injectors for all the super languages.
		// register default ePackages
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xtextbin"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xtextbin", new org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl());
		if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI, org.eclipse.xtext.XtextPackage.eINSTANCE);
		
//		// register used EPackages
		EPackage.Registry.INSTANCE.put(SsPackage.eINSTANCE.getNsURI(),SsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XbasePackage.eINSTANCE.getNsURI(),XbasePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XannotationPackage.eINSTANCE.getNsURI(),XannotationPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TypesPackage.eINSTANCE.getNsURI(), TypesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XtypePackage.eINSTANCE.getNsURI(), XtypePackage.eINSTANCE);
		
		JvmModelInferrerRegistry.INSTANCE.setUseRegistry(false);
		
		Injector injector = createInjector();
		register(injector);
		return injector;
	}

	public static void doSetup() {
		new SsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

}

