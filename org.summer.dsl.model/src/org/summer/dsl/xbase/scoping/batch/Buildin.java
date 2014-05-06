package org.summer.dsl.xbase.scoping.batch;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.ResourceSetFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmType;


public enum Buildin {
	Object("object"), Boolean("boolean"), Function("function"), String("string"), Number("number"), Array(
			"array"), Date("date"), Integer("int"), Byte("byte"), Short("short"), Float("float"), Double("double"),
			Iterable("iterable"), List("list"), Type("Type"), Void("Void");

	private Buildin(String name) {
		this.JvmType = getType(this);
		this.PrimitiveName = name;
	}

	public final JvmDeclaredType JvmType;
	public final String PrimitiveName;

	private JvmDeclaredType getType(Buildin bi) {
		List<EObject> contents = ((XModule) Dual.getResource().getContents()
				.get(0)).getContents();
		for (EObject obj : contents) {
			if (obj instanceof JvmType) {
				JvmDeclaredType type = (JvmDeclaredType) obj;
				if (type.getSimpleName().equals(bi.name())) {
					return type;
				}
			}
		}
		return null;

	}
	
	public static Resource getResource(){
		return Dual.getResource();
	}

	private static class Dual {
		public static Resource Resource; // = Dual.getResource();
		private static Resource getResource() {
			if(Resource != null){
				return Resource;
			}
			URL url = Buildin.class.getResource("BuildIns.ss");
//			URL fileUrl = null;
//			try {
//				fileUrl = FileLocator.toFileURL(url);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			URI uri = URI.createURI(url.toString());
//			XtextResourceSet rs = new XtextResourceSet();
//			XtextResourceSet rs = (XtextResourceSet) XtextResourceSetProvider.getInstance().get(null);
			XtextResourceSet rs = ResourceSetFactory.getInstanceof().getResourceSet();
			Resource =  rs.getResource(uri, true);
			
			return Resource;
		}
	}

	public static void main(String[] args) {
		XtextResourceSet rs = (XtextResourceSet) XtextResourceSetProvider.getInstance().get(null);
		System.out.println(Buildin.Array.JvmType);
	}

}