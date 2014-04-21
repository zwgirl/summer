/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.GlobalResourceDescriptionProvider;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextScopeProvider extends AbstractScopeProvider {
	
	@Inject
	private GlobalResourceDescriptionProvider resourceDecriptionProvider;
	
	public IScope getScope(EObject context, EReference reference) {
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Classifier()) {
			if (context instanceof TypeRef) {
				final TypeRef typeRef = (TypeRef) context;
				final AbstractMetamodelDeclaration metaModel = typeRef.getMetamodel();
				if (metaModel != null) {
					EPackage pack = metaModel.getEPackage();
					if (pack != null)
						return createClassifierScope(pack.getEClassifiers());
				} else {
					return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
				}
			} else {
				return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
			}
			return IScope.NULLSCOPE;
		}
		if (reference == XtextPackage.eINSTANCE.getEnumLiteralDeclaration_EnumLiteral()) {
			final EnumRule rule = GrammarUtil.containingEnumRule(context);
			if (rule.getType() != null && rule.getType().getClassifier() != null && rule.getType().getClassifier() instanceof EEnum) {
				return createEnumLiteralsScope((EEnum) rule.getType().getClassifier());
			}
			return IScope.NULLSCOPE;
			
		}
		return createScope(context.eResource(), reference.getEReferenceType());
	}

	protected IScope createEnumLiteralsScope(EEnum eEnum) {
		return new SimpleScope(IScope.NULLSCOPE,Iterables.transform(eEnum.getELiterals(), new Function<EEnumLiteral, IEObjectDescription>() {
							public IEObjectDescription apply(EEnumLiteral param) {
								return EObjectDescription.create(QualifiedName.create(param.getName()), param);
							}
						}));
	}

	protected IScope createClassifierScope(Iterable<EClassifier> classifiers) {
		return new SimpleScope(
				IScope.NULLSCOPE,Iterables.transform(classifiers, new Function<EClassifier, IEObjectDescription>() {
					public IEObjectDescription apply(EClassifier param) {
						return EObjectDescription.create(QualifiedName.create(param.getName()), param);
					}
				}));
	}

	protected IScope createReferencedPackagesScope(Grammar g) {
		final Collection<EClassifier> allClassifiers = new ArrayList<EClassifier>();
		for(AbstractMetamodelDeclaration decl: g.getMetamodelDeclarations()) {
			if (decl.getEPackage() != null)
				allClassifiers.addAll(decl.getEPackage().getEClassifiers());
		}
		return createClassifierScope(allClassifiers);
	}

	protected IScope createScope(Resource resource, EClass type) {
		if (resource.getContents().size() < 1)
			throw new IllegalArgumentException("resource is not as expected: contents.size == "
					+ resource.getContents().size() + " but expected: >= 1");
		final EObject firstContent = resource.getContents().get(0);
		if (!(firstContent instanceof Grammar))
			return IScope.NULLSCOPE;
		return createScope((Grammar) firstContent, type);
	}

	protected IScope createScope(final Grammar grammar, EClass type) {
		if (EcorePackage.Literals.EPACKAGE == type) {
			return createEPackageScope(grammar);
		} else if (AbstractMetamodelDeclaration.class.isAssignableFrom(type.getInstanceClass())) {
			return new SimpleScope(IScope.NULLSCOPE,Iterables.transform(grammar.getMetamodelDeclarations(),
							new Function<AbstractMetamodelDeclaration,IEObjectDescription>(){
								public IEObjectDescription apply(AbstractMetamodelDeclaration from) {
									String name = from.getAlias() != null ? from.getAlias() : "";
									return EObjectDescription.create(QualifiedName.create(name), from);
								}
							}));
		}
		final List<Grammar> allGrammars = getAllGrammars(grammar);
		IScope current = IScope.NULLSCOPE;
		for (int i = allGrammars.size() - 1; i >= 0; i--) {
			current = createScope(allGrammars.get(i), type, current);
		}
		return current;
	}

	protected IScope createScope(final Grammar grammar, final EClass type, IScope parent) {
		final IResourceDescription resourceDescription = resourceDecriptionProvider.getResourceDescription(grammar.eResource());
		return SelectableBasedScope.createScope(parent, resourceDescription, type, false);
	}

	protected List<Grammar> getAllGrammars(Grammar grammar) {
		Collection<Grammar> visitedGrammars = new LinkedHashSet<Grammar>();
		collectAllUsedGrammars(grammar, visitedGrammars);
		return new ArrayList<Grammar>(visitedGrammars);
	}

	protected void collectAllUsedGrammars(Grammar grammar, Collection<Grammar> visited) {
		if (!visited.add(grammar))
			return;
		for(Grammar usedGrammar: grammar.getUsedGrammars()) {
			collectAllUsedGrammars(usedGrammar, visited);
		}
	}

	protected IScope createEPackageScope(final Grammar grammar, IScope parent) {
		return new SimpleScope(parent,Iterables.transform(Iterables.filter(grammar.getMetamodelDeclarations(),
				new Predicate<AbstractMetamodelDeclaration>() {
					public boolean apply(AbstractMetamodelDeclaration input) {
						return input.getEPackage() != null;
					}
				}), new Function<AbstractMetamodelDeclaration, IEObjectDescription>() {
			public IEObjectDescription apply(AbstractMetamodelDeclaration from) {
				return EObjectDescription.create(QualifiedName.create(from.getEPackage().getNsURI()), from.getEPackage());
			}
		}));
	}

	protected IScope createEPackageScope(final Grammar grammar) {
		final List<Grammar> allGrammars = getAllGrammars(grammar);
		IScope current = new SimpleScope(IScope.NULLSCOPE, Iterables.transform(EPackage.Registry.INSTANCE.keySet(), new Function<String, IEObjectDescription>() {
			public IEObjectDescription apply(String from) {
				InternalEObject proxyPackage = (InternalEObject) EcoreFactory.eINSTANCE.createEPackage();
				proxyPackage.eSetProxyURI(URI.createURI(from));
				return EObjectDescription.create(QualifiedName.create(from), proxyPackage, Collections.singletonMap("nsURI", "true"));
			}
		}));
		for (int i = allGrammars.size() - 1; i >= 0; i--) {
			current = createEPackageScope(allGrammars.get(i), current);
		}
		return current;
	}

}
