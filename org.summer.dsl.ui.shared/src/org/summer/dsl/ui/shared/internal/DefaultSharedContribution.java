/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.shared.internal;

import org.summer.dsl.builder.impl.ProjectOpenedOrClosedListener;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultSharedContribution implements Module {

	public void configure(Binder binder) {
		binder.bind(ProjectOpenedOrClosedListener.class);
		binder.bind(IEagerContribution.class).to(ListenerRegistrar.class);
		binder.bind(WorkspaceProjectsState.class);
	}

}
