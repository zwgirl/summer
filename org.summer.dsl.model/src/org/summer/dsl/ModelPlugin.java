package org.summer.dsl;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class ModelPlugin extends AbstractUIPlugin {

	public ModelPlugin() {
		// TODO Auto-generated constructor stub
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		System.out.println(this.getBundle().getLocation());
		URL url = this.getBundle().getResource("org/summer/dsl/xbase/scoping/batch/BuildIns.ss");
		System.out.println(url);
		System.out.println(FileLocator.toFileURL(url));
	 
		URL url2 = this.getBundle().getEntry("META-INF/MANIFEST.MF");
		System.out.println(url2);
		System.out.println(FileLocator.toFileURL(url2));
	}
	
	

}
