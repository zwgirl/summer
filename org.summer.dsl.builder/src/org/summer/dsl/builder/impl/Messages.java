/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.impl;

import org.eclipse.osgi.util.NLS;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.summer.dsl.builder.impl.messages"; //$NON-NLS-1$
	public static String BuildScheduler_BuildOf;
	public static String BuildScheduler_FailedEtc;
	public static String BuildScheduler_JobName;
	public static String BuildScheduler_SingleJobName;
	public static String BuildScheduler_TwoJobsName;
	public static String BuildScheduler_ManyJobsName;
	public static String ProjectOpenedOrClosedListener_FromIndex;
	public static String ProjectOpenedOrClosedListener_RemovingProject;
	public static String RegistryBuilderParticipant_InvokingBuildParticipants;
	public static String ToBeBuiltComputer_CollectingReosurces;
	public static String XtextBuilder_Building;
	public static String XtextBuilder_CollectingResources;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
