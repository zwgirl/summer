/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.lib.macro;

import org.summer.ss.lib.macro.file.FileLocations;
import org.summer.ss.lib.macro.file.MutableFileSystemSupport;

import com.google.common.annotations.Beta;

/**
 * Provides services for the code generation phase.
 * 
 * @see CodeGenerationParticipant
 * 
 * @author Sven Efftinge
 */
@Beta
public interface CodeGenerationContext extends MutableFileSystemSupport, FileLocations {

}
