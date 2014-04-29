package org.summer.dsl.xbase.scoping.batch;

import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osgi.framework.Bundle;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmType;

public enum Buildin {
	Object("object"), Boolean("boolean"), Function("function"), String("string"), Number("number"), Array(
			"array"), Date("date"), Integer("int"), Byte("byte"), Short("short"), Float("float"), Double("double"),
			Iterable("iterable"), List("list");

	private Buildin(String name) {
		this.Type = getType(this);
		this.PrimitiveName = name;
	}

	public final JvmGenericType Type;
	public final String PrimitiveName;

	private JvmGenericType getType(Buildin bi) {
		List<EObject> contents = ((XtendFile) Dual.getResource().getContents()
				.get(0)).getContents();
		for (EObject obj : contents) {
			if (obj instanceof JvmType) {
				JvmGenericType type = (JvmGenericType) obj;
				if (type.getSimpleName().equals(bi.name())) {
					return type;
				}
			}
		}
		return null;

	}
	
	public static final Resource Resource = Dual.getResource();

	static class Dual {
		
		private static Resource getResource() {

			URL url = Dual.class.getResource("BuildIns.ss");
			URI uri = URI.createURI(url.toString());
			XtextResourceSet rs = new XtextResourceSet();
			return rs.getResource(uri, true);
		}
		
		static Resource getResource1(){
			Bundle bundle = Platform.getBundle("org.summer.dsl.model");
			URL fileURL = bundle.getEntry("src/org/summer/dsl/xbase/scoping/batch/BuildIns.ss");
			URI uri = URI.createURI(fileURL.toString());
			XtextResourceSet rs = new XtextResourceSet();
			return rs.getResource(uri, true);

		}
	}

	public static void main(String[] args) {
		System.out.println(Buildin.Array.Type);
	}

}