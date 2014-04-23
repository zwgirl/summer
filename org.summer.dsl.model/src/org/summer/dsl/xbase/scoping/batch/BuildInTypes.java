package org.summer.dsl.xbase.scoping.batch;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.types.JvmType;

public final class BuildInTypes {
	private static final BuildInTypes _INSTANCE  = new BuildInTypes();
	private JvmType objectType, stringType, numberType, functionType, arrayType, iterableType,booleanType,
		byteType, shortType,integerType,floatType,doubleType;
	private BuildInTypes(){
		
	}
	
	public static BuildInTypes getInstance() {
		return _INSTANCE;
	}
	
	public JvmType getObjectType(Resource resource){
		if(objectType!=null){
			return objectType;
		}
		objectType = getJvmType(resource, "Object");

		return objectType;
		
	}
	
	public JvmType getBooleanType(Resource resource){
		if(booleanType!=null){
			return objectType;
		}
		booleanType = getJvmType(resource, "Boolean");

		return booleanType;
		
	}
	
	public JvmType getStringType(Resource resource){
		if(stringType!=null){
			return stringType;
		}
		stringType = getJvmType(resource, "String");

		return stringType;
		
	}
	
	public JvmType getNumberType(Resource resource){
		if(numberType!=null){
			return numberType;
		}
		numberType = getJvmType(resource, "Number");

		return numberType;
		
	}

	public JvmType getJvmType(Resource resource, String name) {
		return getJvmType(resource.getResourceSet(), name);
	}
	
	public JvmType getJvmType(ResourceSet rs, String name) {
		synchronized(this){
			if(rs ==null || !(rs instanceof XtextResourceSet)){
				return null;
			}
			XtextResourceSet xrs = (XtextResourceSet) rs;
			IPath path = xrs.getProject().getLocation().append("src/summer/lang/BuildIns.ss");
			Resource buildInsRes = rs.getResource(URI.createFileURI(path.toOSString()), true);
			List<EObject> contents = ((XtendFile)buildInsRes.getContents().get(0)).getContents();
			for(EObject obj  : contents){
				if(obj instanceof JvmType){
					JvmType type = (JvmType) obj;
					if(type.getSimpleName().equals(name)){
						return type;
					}
				}
			}
		}
		return null;
	}
	
	public JvmType getFunctionType(Resource resource){
		if(functionType!=null){
			return functionType;
		}
		functionType = getJvmType(resource, "Function");

		return functionType;
		
	}
	
	public JvmType getFunctionType(ResourceSet rs){
		if(functionType!=null){
			return functionType;
		}
		functionType = getJvmType(rs, "Function");

		return functionType;
		
	}
	
	public JvmType getBooleanType(ResourceSet rs){
		if(booleanType!=null){
			return booleanType;
		}
		booleanType = getJvmType(rs, "Boolean");

		return booleanType;
		
	}
	
	public JvmType getObjectType(ResourceSet rs){
		if(objectType!=null){
			return objectType;
		}
		objectType = getJvmType(rs, "Object");

		return objectType;
		
	}

	public JvmType getArrayType(Resource resource) {
		if(arrayType!=null){
			return arrayType;
		}
		arrayType = getJvmType(resource, "Array");

		return arrayType;
	}
	
	public JvmType getArrayType(ResourceSet rs) {
		if(arrayType!=null){
			return arrayType;
		}
		arrayType = getJvmType(rs, "Array");

		return arrayType;
	}

	public JvmType getIterableType(Resource resource) {
		if(iterableType!=null){
			return iterableType;
		}
		iterableType = getJvmType(resource, "Iterable");

		return iterableType;
	}
	
	public JvmType getIterableType(ResourceSet rs){
		if(iterableType!=null){
			return iterableType;
		}
		iterableType = getJvmType(rs, "Iterable");

		return iterableType;
		
	}
	
	public JvmType getIntegerType(Resource resource) {
		if(integerType!=null){
			return integerType;
		}
		integerType = getJvmType(resource, "Integer");

		return integerType;
	}
	
	public JvmType getIntegerType(ResourceSet rs){
		if(integerType!=null){
			return integerType;
		}
		integerType = getJvmType(rs, "Boolean");

		return integerType;
	}
	
	
	public JvmType getByteType(Resource resource) {
		if(byteType!=null){
			return byteType;
		}
		byteType = getJvmType(resource, "Byte");

		return byteType;
	}
	
	public JvmType getByteType(ResourceSet rs){
		if(byteType!=null){
			return integerType;
		}
		byteType = getJvmType(rs, "Byte");

		return byteType;
	}
	
	public JvmType getShortType(Resource resource) {
		if(shortType!=null){
			return shortType;
		}
		shortType = getJvmType(resource, "Short");

		return shortType;
	}
	
	public JvmType getShortType(ResourceSet rs){
		if(shortType!=null){
			return integerType;
		}
		shortType = getJvmType(rs, "Short");

		return shortType;
	}
	
	public JvmType getFloatType(Resource resource) {
		if(floatType!=null){
			return floatType;
		}
		floatType = getJvmType(resource, "Float");

		return floatType;
	}
	
	public JvmType getFloatType(ResourceSet rs){
		if(floatType!=null){
			return floatType;
		}
		floatType = getJvmType(rs, "Float");

		return floatType;
	}
	
	public JvmType getDoubleType(Resource resource) {
		if(doubleType!=null){
			return doubleType;
		}
		doubleType = getJvmType(resource, "Double");

		return doubleType;
	}
	
	public JvmType getDoubleType(ResourceSet rs){
		if(doubleType!=null){
			return doubleType;
		}
		doubleType = getJvmType(rs, "Double");

		return doubleType;
	}
}
