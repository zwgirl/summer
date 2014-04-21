/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients. TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeResolutionStateAdapter extends AbstractRootedReentrantTypeResolver implements Adapter {

	private final AbstractRootedReentrantTypeResolver context;

	protected Notifier target = null;

	public TypeResolutionStateAdapter(EObject associatedWith, AbstractRootedReentrantTypeResolver context) {
		this.context = context;
		associatedWith.eAdapters().add(this);
	}

	public boolean isAdapterForType(@Nullable Object type) {
		return TypeResolutionStateAdapter.class.equals(type);
	}

	public IReentrantTypeResolver getContext() {
		return context;
	}

	@Override
	protected EObject getRoot() {
		return context.getRoot();
	}
	
	@Override
	protected IScope getFeatureScope(XAbstractFeatureCall featureCall) {
		return context.getFeatureScope(featureCall);
	}

	@Override
	protected boolean isHandled(JvmIdentifiableElement identifiableElement) {
		return context.isHandled(identifiableElement);
	}

	@Override
	protected boolean isHandled(XExpression expression) {
		return context.isHandled(expression);
	}
	
	@Override
	protected boolean isHandled(EObject context) {
		return this.context.isHandled(context);
	}
	
	@Override
	protected IResolvedTypes getResolvedTypesInContextOf(EObject context) {
		return this.context.getResolvedTypesInContextOf(context);
	}

	public void initializeFrom(EObject root) {
		throw new IllegalStateException("Attempt to reinitialize the root resolver");
	}

	public IResolvedTypes reentrantResolve() {
		return context.reentrantResolve();
	}

	public void notifyChanged(@Nullable Notification notification) {
		// Do nothing.
	}

	public Notifier getTarget() {
		return target;
	}

	public void setTarget(@Nullable Notifier newTarget) {
		target = newTarget;
	}

}