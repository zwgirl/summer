/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmVisibility;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.util.IVisibilityHelper;

import com.google.inject.ImplementedBy;

/**
 * A feature scope session allows to successively enhance the reachable features
 * by adding local variables, parameters from the context or the list of imports.
 * Afterwards it's possible to ask for an {@link IScope} by means of 
 * {@link #getScope(EObject, EReference, IResolvedTypes)}. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO More JavaDoc
 * TODO cleanup
 */
@NonNullByDefault
@ImplementedBy(RootFeatureScopeSession.class)
public interface IFeatureScopeSession extends IVisibilityHelper {

	/**
	 * Return the scope for the given {@code context} and {@code reference} based on the
	 * known resolved {@code types}.
	 * @param context the context object. May not be <code>null</code>.
	 * @param reference the reference that holds the unresolved proxy. May not be <code>null</code>.
	 * @param types the already computed types.
	 * @see IScopeProvider#getScope(EObject, EReference)
	 */
	IScope getScope(EObject context, EReference reference, IResolvedTypes types);
	
	/**
	 * Add types to the session that are imported statically either as plain static imports 
	 * or with an extension semantic.
	 * @param staticFeatureProviders the static feature providers. May not be <code>null</code>.
	 * @param staticExtensionProviders the static extension providers. May not be <code>null</code>.
	 * @return a configured session.
	 */
	IFeatureScopeSession addTypesToStaticScope(List<? extends JvmType> staticFeatureProviders, List<? extends JvmType> staticExtensionProviders);

	/**
	 * Add receivers to the session that contribute extensions. The expressions in the map
	 * will be cloned on demand prior to adding them to the model. They are prototypes.
	 * 
	 * @param extensionProviders the expressions that yield extension receivers.
	 * @return a configured session.
	 */
	IFeatureScopeSession addToExtensionScope(Map<XExpression, LightweightTypeReference> extensionProviders);
	
	/**
	 * Forks this session with an instance context. References to 'this' are only valid in instance contexts.
	 * @see #isInstanceContext()
	 */
	IFeatureScopeSession toInstanceContext();
	
	/**
	 * Returns <code>true</code> if <code>this</code> can be validly resolved in the current scope.
	 * @see #toInstanceContext()
	 */
	boolean isInstanceContext();
	
	/**
	 * All extension providers as expression buckets.
	 * 
	 * @return the list of extension providers.
	 */
	List<ExpressionBucket> getExtensionProviders();
	
	/**
	 * Add a locally defined identifiable to this scope. It will shadow previously registered locals.
	 * 
	 * No validation of the given name is performed.
	 * 
	 * @param name the qualified name of the identifiable.
	 * @param element the element itself.
	 * @return a configured session.
	 */
	IFeatureScopeSession addLocalElement(QualifiedName name, JvmIdentifiableElement element, ITypeReferenceOwner owner);
	
	/**
	 * Add locally defined identifiables to this scope. Since the elements have unique names, they cannot shadow
	 * each other. However, they will shadow previously added local elements.
	 * 
	 * @param elements the local elements.
	 * @return a configured session.
	 */
	IFeatureScopeSession addLocalElements(Map<QualifiedName, JvmIdentifiableElement> elements, ITypeReferenceOwner owner);
	
	/**
	 * Find a local element with the given qualified name.
	 * @return the known element or <code>null</code>.
	 */
	@Nullable IEObjectDescription getLocalElement(QualifiedName name);
	
	/**
	 * Return all local elements that are known in this session.
	 * @return all local elements. Never <code>null</code>.
	 */
	Collection<IEObjectDescription> getLocalElements();

	/**
	 * All statically imported types as type buckets. The list has usually two elements:
	 * <ol>
	 *   <li>The implicitly imported types as a single bucket.</li>
	 *   <li>The explicitly imported types as a single bucket.</li>
	 * </ol>
	 * Scenarios with more than two buckets are especially nested structures with multiple
	 * import sections or ordered imports.
	 */
	List<TypeBucket> getStaticallyImportedTypes();
	
	/**
	 * All statically imported extension types as type buckets. The list has usually two elements:
	 * <ol>
	 *   <li>The implicitly available extensions as a single bucket.</li>
	 *   <li>The explicitly imported extensions as a single bucket.</li>
	 * </ol>
	 * Scenarios with more than two buckets are especially nested structures with multiple
	 * import sections or ordered imports.
	 */
	List<TypeBucket> getStaticallyImportedExtensionTypes();
	
	/**
	 * Returns <code>true</code> if the member is visible according to the {@link JvmVisibility} and the local context
	 * when invoked on the given receiver feature which resolves to the given type.
	 * 
	 * @param member the member that shall be accessed.
	 * @param receiverFeature the links the receiver of the feature call to the given member. May be unknown.
	 * @return <code>true</code> if the feature can be accessed.
	 */
	boolean isVisible(JvmMember member, @Nullable JvmIdentifiableElement receiverFeature);

}
