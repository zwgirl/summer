/*
 * generated by Xtext
 */
package org.summer.xaml.core.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractXAMLValidator extends org.summer.ss.core.validation.AbstractXtendJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.summer.xaml.core.xAML.XAMLPackage.eINSTANCE);
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.summer.org/dsl/model/xbase"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.summer.org/dsl/model/ss"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.summer.org/dsl/model/types"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.summer.org/dsl/model/xtype"));
		return result;
	}
}
