/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.validator;

import static org.eclipse.xtext.util.Strings.isEmpty;
import static org.eclipse.xtext.util.Strings.notNull;
import static org.summer.ss.core.validation.IssueCodes.ACTIVE_ANNOTAION_IN_SAME_CONTAINER;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.access.jdt.IJavaProjectProvider;
import org.summer.dsl.xbase.ui.validation.XbaseUIValidator;
import org.summer.ss.core.macro.XAnnotationExtensions;
import org.summer.ss.core.validation.IssueCodes;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 * @since 2.4
 */
public class SsUIValidator extends XbaseUIValidator {

	private static final Logger LOG = Logger.getLogger(SsUIValidator.class);
	
	@Inject 
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject private XAnnotationExtensions annotationExtensions;
	@Inject private IJavaProjectProvider projectProvider;
	
//	@Override
//	protected List<EPackage> getEPackages() {
//		List<EPackage> packages = super.getEPackages();
//		packages.add(TypesPackage.eINSTANCE);
////		packages.add(XannotationPackage.eINSTANCE);
//		return packages;
//	}
	
	@Check
	protected void checkAnnotationInSameProject(JvmAnnotationReference annotation) throws JavaModelException {
		if (annotationExtensions.isProcessed(annotation)) {
			JvmType annotationType = annotation.getAnnotation();
			if (isSameProject(annotation, annotationType)) {
				error("The referenced active annotation cannot be used from within the same project.",TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__ANNOTATION, -1, ACTIVE_ANNOTAION_IN_SAME_CONTAINER);
			}
		}
	}

	protected boolean isSameProject(JvmAnnotationReference annotation, JvmType annotationType) throws JavaModelException {
		IJavaProject project = projectProvider.getJavaProject(annotation.eResource().getResourceSet());
		if (annotationType.eResource().getURI().isPlatformResource()) {
			String projectName = annotationType.eResource().getURI().segments()[1];
			return project.getProject().getName().equals(projectName);
		} else { // assume java type resource
			IType type = project.findType(annotationType.getIdentifier());
			if (type != null && type.getUnderlyingResource() instanceof IFile) {
				return isInSourceFolder(project, (IFile) type.getUnderlyingResource());
			}
			return false;
		}
	}
	
	protected boolean isInSourceFolder(IJavaProject javaProject, IFile resource) {
		IPath path = resource.getFullPath();
		IClasspathEntry[] classpath;
		try {
			classpath = javaProject.getResolvedClasspath(true);
		} catch(JavaModelException e){
			return false; // not a Java project
		}
		for (int i = 0; i < classpath.length; i++) {
			IClasspathEntry entry = classpath[i];
			if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				IPath entryPath = entry.getPath();
				if (entryPath.isPrefixOf(path)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private final String DEFAULT_PACKEGE = "default package";

	@Check
	public void checkModuleNamespaceConventions(JvmModule module) {
//		String expectedPackage = getExpectedPackageName(module);
//		String moduleName = module.getSimpleName();
//		String[] segments = moduleName.split("\\.");
//		String[] tag = new String[segments.length-1];
//		System.arraycopy(segments, 0, tag, 0, segments.length-1);
//		QualifiedName qfn = QualifiedName.create(tag);
//		
//		if(expectedPackage != null && !((isEmpty(expectedPackage) && moduleName == null) || expectedPackage.equals(qfn.toString()))) {
//			String packageName = expectedPackage;
//			if(expectedPackage == null ||expectedPackage.isEmpty() ){
//				packageName = DEFAULT_PACKEGE;
//			}
//			error("The declared module '" + notNull(moduleName) + "' does not match the expected namespace '" + 
//					packageName + "'",
//					TypesPackage.Literals.JVM_MODULE__SIMPLE_NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_PACKAGE, expectedPackage);
//		}
		
		String expectedPackage = getExpectedPackageName(module);
		String declaredPackage = module.getPackage();
		if(expectedPackage != null && !((isEmpty(expectedPackage) && declaredPackage == null) || expectedPackage.equals(declaredPackage))) {
			error("The declared package '" + notNull(declaredPackage) + "' does not match the expected package '" + notNull(expectedPackage) + "'",
					TypesPackage.Literals.JVM_MODULE__SIMPLE_NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_PACKAGE, expectedPackage);
		}
		
	}
	
	@Check
	public void checkFileNamingConventions(JvmModule module) {
		String fileName = getFileName(module);
		String moduleName = module.getModuleName();
		
		if( !(fileName.equals(moduleName))) {
			error("The declared module '" + notNull(moduleName) + "' does not match the file '" + 
					fileName + "'",
					TypesPackage.Literals.JVM_MODULE__SIMPLE_NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.WRONG_PACKAGE, fileName);
		}
	}
	
	private String getFileName(JvmModule module) {
		return module.eResource().getURI().trimFileExtension().lastSegment();
	}
	
	

	protected String getExpectedPackageName(JvmModule module) {
		URI fileURI = module.eResource().getURI();
		for(Pair<IStorage, IProject> storage: storage2UriMapper.getStorages(fileURI)) {
			if(storage.getFirst() instanceof IFile) {
				IPath fileWorkspacePath = storage.getFirst().getFullPath();
				IJavaProject javaProject = JavaCore.create(storage.getSecond());
				if(javaProject != null && javaProject.exists() && javaProject.isOpen()) {
					try {
						for(IPackageFragmentRoot root: javaProject.getPackageFragmentRoots()) {
							if(!root.isArchive() && !root.isExternal()) {
								IResource resource = root.getResource();
								if(resource != null) {
									IPath sourceFolderPath = resource.getFullPath();
									if(sourceFolderPath.isPrefixOf(fileWorkspacePath)) {
										IPath claspathRelativePath = fileWorkspacePath.makeRelativeTo(sourceFolderPath);
										return claspathRelativePath.removeLastSegments(1).toString().replace("/", ".");
									}
								}
							}
						}
					} catch (JavaModelException e) {
						LOG.error("Error resolving expected path for XtendFile", e);
					}
				}
			}
		}
		return null;
	}
}
