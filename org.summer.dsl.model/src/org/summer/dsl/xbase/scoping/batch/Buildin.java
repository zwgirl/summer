package org.summer.dsl.xbase.scoping.batch;

import java.net.URL;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.ResourceSetFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmType;


public enum Buildin {
	Object("object", false), Boolean("boolean", true), Function("function", true), String("string", true), Number("number", true), Array(
			"array", false), Date("date", false), Integer("int", true), Byte("byte", true), Short("short", true), Float("float", true), Double("double", true),
			Iterable("iterable", false), List("list", false), Type("Type", false), Void("Void", true), Collection("Collection", false), Map("Map", false);

	private Buildin(String name, boolean primitive) {
		this.JvmType = getType(this);
		this.PrimitiveName = name;
		this.JvmType.setPrimitive(primitive);
	}

	public final JvmDeclaredType JvmType;
	public final String PrimitiveName;

	private JvmDeclaredType getType(Buildin bi) {
		List<EObject> contents = ((JvmModule) Dual.getResource().getContents()
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
			URI uri = URI.createURI(url.toString());
			XtextResourceSet rs = ResourceSetFactory.getInstance().getResourceSet();
			Resource =  rs.getResource(uri, true);
			
			return Resource;
		}
	}

	public static void main(String[] args) {
		XtextResourceSet rs = (XtextResourceSet) XtextResourceSetProvider.getInstance().get(null);
		System.out.println(Buildin.Array.JvmType);
	}

}