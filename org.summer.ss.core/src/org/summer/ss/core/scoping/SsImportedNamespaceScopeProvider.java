/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.scoping;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.access.IJvmTypeProvider;
import org.summer.dsl.model.types.access.impl.Primitives;
import org.summer.dsl.model.types.xtext.AbstractTypeScope;
import org.summer.dsl.model.types.xtext.AbstractTypeScopeProvider;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XFieldLiteralPart;
import org.summer.dsl.model.xbase.XStructLiteral;
import org.summer.dsl.model.xtype.XImportDeclaration1;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection1;
import org.summer.dsl.model.xtype.XtypePackage;
import org.summer.dsl.xbase.scoping.AbstractNestedTypeAwareImportNormalizer;
import org.summer.dsl.xbase.scoping.XImportSectionNamespaceScopeProvider;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.scoping.batch.ConstructorTypeScopeWrapper;
import org.summer.dsl.xbase.typesystem.util.IVisibilityHelper;
import org.summer.ss.core.resource.ImportScope;
import org.summer.ss.core.resource.PrimitivesScope;
import org.summer.ss.core.resource.RootScope;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Improved support for nested types in connection with imports
 */
public class SsImportedNamespaceScopeProvider extends XImportSectionNamespaceScopeProvider {

	public static final QualifiedName XTEND_LIB = QualifiedName.create("org","eclipse","xtend","lib");
	public static final QualifiedName XBASE_LIB = XImportSectionNamespaceScopeProvider.XBASE_LIB;
	public static final QualifiedName JAVA_LANG = XImportSectionNamespaceScopeProvider.JAVA_LANG;
	
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private IResourceScopeCache resourceScopeCache;
	
	@Inject
	private CompilerPhases compilerPhases;
	
	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		if(context instanceof XImportItem){
			XImportDeclaration1 importDecl = (XImportDeclaration1) context.eContainer();
			String uriStr = importDecl.getImportURI();
			XtextResourceSet resourceSet = (XtextResourceSet) context.eResource().getResourceSet();
			IPath path = resourceSet.getProject().getLocation().append(uriStr);
			URI uri = URI.createFileURI(path.toOSString());
			if(resourceSet!=null){
				final Resource resource = resourceSet.getResource(uri, true);
				return new ImportResourceScope(resource);
			}
		}
		EClass referenceType = reference.getEReferenceType();
		if (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(referenceType)) {
			if (context instanceof XImportDeclaration1) {
				Resource resource = context.eResource();
				IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(resource.getResourceSet());
				AbstractTypeScope typeScope = typeScopeProvider.createTypeScope(typeProvider, null);
				RecordingTypeScope recordingTypeScope = new RecordingTypeScope(typeScope, getImportedNamesSet(resource));
				//TODO this scope doesn't support binary syntax for inner types. It should be a KnownTypes scope which doesn't allow simple names
				// Unfortunately I cannot use a RecordingTypeScope as a parent as it is not compatible...
				IScope scope = SelectableBasedScope.createScope(recordingTypeScope, getAllDescriptions(resource), reference.getEReferenceType(), false);
				return scope;
			}
			final XtendFile xtendFile = getXtendFile(context);
//			final Resource resource = xtendFile.eResource();
//			IScope result = resourceScopeCache.get("type.scope", xtendFile.eResource(), new Provider<IScope>() {
//				public IScope get() {
//					IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(resource.getResourceSet());
//					AbstractTypeScope typeScope = typeScopeProvider.createTypeScope(typeProvider, null);
//					RecordingTypeScope recordingTypeScope = new RecordingTypeScope(typeScope, getImportedNamesSet(resource));
//					AbstractScope rootTypeScope = getRootTypeScope(xtendFile, recordingTypeScope);
//					AbstractScope importScope = getImportScope(xtendFile.getImportSection(), rootTypeScope, recordingTypeScope);
//					AbstractScope localTypes = getLocalTypeScope(xtendFile.eResource(), xtendFile.getPackage(), importScope);
//					AbstractScope primitiveAware = new PrimitiveAwareScope(localTypes, typeScope);
//					AbstractScope caching = new CachingTypeScope(primitiveAware);
//					return caching;
//				}
//				
//			});
//			XtendMember syntacticContainer = EcoreUtil2.getContainerOfType(context, XtendMember.class);
//			if (syntacticContainer != null) {
//				result = getContainerScope(syntacticContainer, result);
//			}
//			return result;
			
			Resource fileResource = xtendFile.eResource();
//			XtextResourceSet resourceSet = (XtextResourceSet) fileResource.getResourceSet();
//			IPath path = resourceSet.getProject().getLocation().append("src/summer/lang/BuildIns.ss");
			
			
			IScope importScope = null;
			//如果当前的文件是BuildIns.ss的话，就不需要再隐含导入本身了。
			if(fileResource.getURI().toString().indexOf("BuildIns.ss")<0){
				
				IScope implicitScope = new ImportResourceScope(Buildin.Resource);
				importScope = new ImportScope(fileResource, implicitScope);
			}else{
				importScope = new ImportScope(fileResource, IScope.NULLSCOPE);
			}
			
			AbstractScope primitivesScope = new PrimitivesScope(importScope, fileResource);
			
			//处理原始类型
			AbstractScope result = new RootScope(fileResource, primitivesScope);
			//处理泛型参数，添加到当前的Scope上。
			JvmMember syntacticContainer = EcoreUtil2.getContainerOfType(context, JvmMember.class);
			if (syntacticContainer != null) {
				result = getContainerScope(syntacticContainer, result);
			}
			
			
			return result;
			
		} else if (TypesPackage.Literals.JVM_CONSTRUCTOR.isSuperTypeOf(referenceType)) {
			IScope typeScope = getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
			// this is not called from the type resolution where we want to allow constructors to link to interfaces
			// in order to improve the error message, therefore we use a strict wrapper here
			IScope result = new ConstructorTypeScopeWrapper(context, IVisibilityHelper.ALL, typeScope, true /* strict scope */);
			return result;
		} else if (TypesPackage.Literals.JVM_FIELD.isSuperTypeOf(referenceType) && context instanceof XFieldLiteralPart) {   //cym added
			XFieldLiteralPart fieldPart = (XFieldLiteralPart) context;
			XStructLiteral structLiteral = (XStructLiteral) fieldPart.eContainer();
			IScope scope = new StructTypeScope(structLiteral.getType());
			return scope;
		} else if (TypesPackage.Literals.JVM_FIELD.isSuperTypeOf(referenceType) && context instanceof XStructLiteral) {   //cym added
			XStructLiteral structLiteral = (XStructLiteral) context;
			IScope scope = new StructTypeScope(structLiteral.getType());
			return scope;
		}
		
		else {
//			return super.getScope(context, reference);
			throw new IllegalArgumentException("Unexpected global request for " + reference);  
		}
	}
	
	
	protected Set<QualifiedName> getImportedNamesSet(Resource resource) {
		ImportedNamesAdapter adapter = getImportedNamesAdapter(resource);
		return adapter.getImportedNames();
	}
	
	protected ImportedNamesAdapter getImportedNamesAdapter(Resource resource) {
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(resource);
		if (adapter!=null)
			return adapter;
		ImportedNamesAdapter importedNamesAdapter = new ImportedNamesAdapter();
		resource.eAdapters().add(importedNamesAdapter);
		return importedNamesAdapter;
	}

	protected XtendFile getXtendFile(final EObject context) {
		Resource resource = context.eResource();
		XtendFile result = (XtendFile) resource.getContents().get(0);
		return result;
	}
	
	//cym comment
//	private AbstractScope getContainerScope(XtendMember syntacticContainer, AbstractScope result) {
//		List<List<JvmTypeParameter>> typeParameters = null;
//		while(syntacticContainer != null) {
//			Set<EObject> elements = getAssociations().getJvmElements(syntacticContainer);
//			for (EObject derivedJvmElement : elements) {
//				// scope for JvmTypeParameterDeclarator
//				if (derivedJvmElement instanceof JvmTypeParameterDeclarator) {
//					JvmTypeParameterDeclarator parameterDeclarator = (JvmTypeParameterDeclarator) derivedJvmElement;
//					List<JvmTypeParameter> current = parameterDeclarator.getTypeParameters();
//					if (!current.isEmpty()) {
//						if (typeParameters == null) {
//							typeParameters = Lists.newArrayListWithCapacity(3);
//						}
//						typeParameters.add(current);
//					}
//				}
//			}
//			EObject container = syntacticContainer.eContainer();
//			if (container instanceof XtendMember) {
//				syntacticContainer = (XtendMember) container;
//			} else {
//				if (typeParameters == null)
//					return result;
//				return new TypeParameterScope(typeParameters, result);
//			}
//		}
//		return result;
//	}
	
	private AbstractScope getContainerScope(JvmMember syntacticContainer, AbstractScope result) {
		List<List<JvmTypeParameter>> typeParameters = null;
		while(syntacticContainer != null) {
			// scope for JvmTypeParameterDeclarator
			List<JvmTypeParameter> current = null;
			if(syntacticContainer instanceof JvmGenericType){
				JvmTypeParameterDeclarator tpd = (JvmTypeParameterDeclarator) syntacticContainer;
				current = tpd.getTypeParameters();
			} else if(syntacticContainer instanceof JvmOperation){
				JvmOperation jop = (JvmOperation) syntacticContainer;
				XClosure closure = (XClosure) jop.getFunction();	
				current = closure.getTypeParameters();
			}
				
			if (current!=null && !current.isEmpty()) {
				if (typeParameters == null) {
					typeParameters = Lists.newArrayListWithCapacity(3);
				}
				typeParameters.add(current);
			}

			EObject container = syntacticContainer.eContainer();
			if (container instanceof JvmGenericType) {
				syntacticContainer = (JvmGenericType) container;
			} else {
				if (typeParameters == null)
					return result;
				return new TypeParameterScope(typeParameters, result);
			}
		}
		return result;
	}

	private AbstractScope getLocalTypeScope(Resource resource, String packageName, AbstractScope parent) {
		List<EObject> contents = resource.getContents();
		List<JvmType> knownTypes = Lists.newArrayListWithExpectedSize(contents.size() - 1);
		for(EObject content: contents) {
			if (content instanceof JvmType) {
				if (content instanceof JvmDeclaredType) {
					if (Strings.equal(packageName, ((JvmDeclaredType) content).getPackageName())) {
						knownTypes.add((JvmType) content);	
					}
				} else {
					knownTypes.add((JvmType) content);
				}
			}
		}
		if (knownTypes.isEmpty())
			return parent;
		return new KnownTypesScope(knownTypes, parent);
	}

	private AbstractScope getImportScope(XImportSection1 importSection, AbstractScope parent, RecordingTypeScope typeScope) {
		if (importSection == null)
			return parent;
		List<XImportDeclaration1> importDeclarations = importSection.getImportDeclarations();
		if (importDeclarations.isEmpty()) {
			return parent;
		}
		List<ImportNormalizer> wildcardImports = null;
		List<JvmType> concreteImports = null;
		List<QualifiedName> importedNames = null;
		boolean hasLegacyImport = false;
		for(XImportDeclaration1 importDeclaration: importDeclarations) {
//			if (!importDeclaration.isStatic()) {
				if (importDeclaration.isWildcard()) {
					if (wildcardImports == null) {
						wildcardImports = Lists.newArrayListWithCapacity(4);
					}
//					String importedNamespace = importDeclaration.getImportedNamespace();
//					importedNamespace = importedNamespace.substring(0, importedNamespace.length() - 2);
//					QualifiedName qualifiedImportedNamespace = qualifiedNameConverter.toQualifiedName(importedNamespace);
//					wildcardImports.add(AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(qualifiedImportedNamespace, true, false));
				} else {
					JvmDeclaredType importedType = null;
					if (compilerPhases.isIndexing(importSection)) {
						EObject proxy = (EObject) importDeclaration.eGet(XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, false);
						if (proxy.eIsProxy()) {
							URI uri = ((InternalEObject)proxy).eProxyURI();
							importedType = (JvmDeclaredType) importSection.eResource().getResourceSet().getEObject(uri, true);
						} 
					} 
//					else {
//						importedType = importDeclaration.getImportedType();
//					}
					if (importedType != null && !importedType.eIsProxy()) {
						if (concreteImports == null || importedNames == null /* to make JDT happy */) {
							concreteImports = Lists.newArrayListWithCapacity(10);
							importedNames = Lists.newArrayListWithCapacity(10);
						}
						concreteImports.add(importedType);
						if (importedType.eContainer() instanceof JvmDeclaredType) {
//							String importSyntax = getImportsConfiguration().getLegacyImportSyntax(importDeclaration);
//							if (importSyntax != null) {
//								hasLegacyImport = true;
//								importedNames.add(getQualifiedNameConverter().toQualifiedName(importSyntax));
//							} else
								importedNames.add(null);
						} else {
							importedNames.add(null);
						}
					}
				}
//			}
		}
		return getImportScope(wildcardImports, concreteImports, hasLegacyImport ? importedNames : null, parent, typeScope);
	}

	private AbstractScope getImportScope(List<ImportNormalizer> wildcardImports, List<JvmType> concreteImports, List<QualifiedName> importedNames,
			AbstractScope parent, RecordingTypeScope typeScope) {
		AbstractScope result = parent;
		if (wildcardImports != null) {
			result = new TypeScopeWithWildcardImports(wildcardImports, typeScope, result);
		}
		if (concreteImports != null) {
			if (importedNames != null)
				result = new LegacyKnownTypesScope(concreteImports, importedNames, result);
			else
				result = new KnownTypesScope(concreteImports, result);
		}
		return result;
	}
	
	protected AbstractScope getRootTypeScope(XtendFile rootContainer, RecordingTypeScope typeScope) {
		String packageName = rootContainer.getPackage();
		final ImportNormalizer[][] implicitImports;
		if (packageName != null && packageName.length() > 0) {
			QualifiedName packageQualifiedName = qualifiedNameConverter.toQualifiedName(packageName);
			implicitImports = new ImportNormalizer[][] {
				{
					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(packageQualifiedName, true, false),
				},
				{
//					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(JAVA_LANG, true, false),
//					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(XBASE_LIB, true, false),
//					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(XTEND_LIB, true, false),
					
					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(JAVA_LANG, true, false),
				}
			};
		} else {
			implicitImports = new ImportNormalizer[][] {
				{
					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(JAVA_LANG, true, false),
//					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(XBASE_LIB, true, false),
//					AbstractNestedTypeAwareImportNormalizer.createNestedTypeAwareImportNormalizer(XTEND_LIB, true, false),
				}
			};
		}
		return new TypeScopeWithWildcardImports(implicitImports, typeScope);
	}

}
