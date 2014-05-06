package org.eclipse.xtext.resource;


public class ResourceSetFactory {
	private static final ResourceSetFactory _INSTANCEOF = new ResourceSetFactory();
	
	private final XtextResourceSet rs = new XtextResourceSet();
	
	public static ResourceSetFactory getInstanceof() {
		return _INSTANCEOF;
	}
	
	public XtextResourceSet getResourceSet(){
		return rs;
	}
}
