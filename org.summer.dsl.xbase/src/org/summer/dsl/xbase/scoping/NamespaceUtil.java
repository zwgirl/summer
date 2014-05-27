package org.summer.dsl.xbase.scoping;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.ResourceSetFactory;
import org.summer.dsl.model.xtype.XImportDeclaration;

public final class NamespaceUtil {
	
	public static Resource getResource(XImportDeclaration importDecl) {
		String namespace = importDecl.getImportedNamespace();
		namespace = namespace.replace(".", "/");
		
		IProject project = getProject(importDecl.eResource().getURI());
		IPath workspaceRootPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		IJavaProject javaProject = JavaCore.create(project);
		try {
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			for(IPackageFragmentRoot root: roots){
				if(root.getKind() != IPackageFragmentRoot.K_SOURCE){
					continue;
				}
				IPath path = root.getPath();
				path = path.append(namespace);
				path = path.addFileExtension("ss");
				path = workspaceRootPath.append(path);
				if(!path.toFile().exists()){
					continue;
				}
				URI uri = URI.createFileURI(path.toOSString());
				return ResourceSetFactory.getInstance().getResourceSet().getResource(uri, true);
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static IProject getProject(URI uri){
		if (uri.isFile()) {
			IPath path = new Path(uri.toFileString());
			if (path.isAbsolute()) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
				if(file!=null){
					return file.getProject();
				}
			}
		}
		return null;
	}
}
