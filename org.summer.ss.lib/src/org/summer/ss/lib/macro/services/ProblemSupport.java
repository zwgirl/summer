/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.lib.macro.services;

import java.util.List;

import org.summer.ss.lib.macro.declaration.Element;
import org.summer.ss.lib.macro.services.Problem.Severity;

import com.google.common.annotations.Beta;

/**
 * Support for looking up and creating new {@link Problem} markers on {@link Element}s
 * 
 * @author Sven Efftinge
 */
@Beta
public interface ProblemSupport {
	/**
	 * @param element the element to look up problems
	 * @return the problems associated with the given {@link Element}
	 */
	List<Problem> getProblems(Element element);
	
	/**
	 * Adds a problem marker with severity {@link Severity}#ERROR to the given element
	 * 
	 * @param element the element to which associate the new problem marker
	 * @param message the message for the problem marker
	 */
	void addError(Element element, String message);
	
	/**
	 * Adds a problem marker with severity {@link Severity}#WARNING to the given element
	 * 
	 * @param element the element to which associate the new problem marker
	 * @param message the message for the problem marker
	 */
	void addWarning(Element element, String message);

}
