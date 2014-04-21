/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.lib.macro;

import org.summer.ss.lib.macro.file.FileLocations;
import org.summer.ss.lib.macro.file.FileSystemSupport;
import org.summer.ss.lib.macro.services.ProblemSupport;
import org.summer.ss.lib.macro.services.Tracability;
import org.summer.ss.lib.macro.services.TypeLookup;
import org.summer.ss.lib.macro.services.TypeReferenceProvider;

import com.google.common.annotations.Beta;

/**
 * Services provided during transformation phase
 * 
 * @author Sven Efftinge
 * 
 * @see TransformationParticipant
 */
@Beta
public interface TransformationContext extends Tracability, ProblemSupport, TypeReferenceProvider, TypeLookup, FileSystemSupport, FileLocations {

}
