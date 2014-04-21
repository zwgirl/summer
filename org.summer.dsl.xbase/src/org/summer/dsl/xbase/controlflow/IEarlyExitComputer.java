/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.controlflow;

import java.util.Collection;

import org.summer.dsl.model.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(DefaultEarlyExitComputer.class)
public interface IEarlyExitComputer {

	/**
	 * An expression is considered to be left early if all branches end with an explicit
	 * termination, e.g. a return or throw expression. 
	 * @return <code>true</code> if the given expression will definitely exit early.
	 */
	boolean isEarlyExit(XExpression expression);

	Collection<ExitPoint> getExitPoints(XExpression expression);
	
	public static class ExitPoint {
		protected boolean exceptionalExit;
		protected XExpression expression;
		
		protected ExitPoint(XExpression expression, boolean exceptionalExit) {
			this.expression = expression;
			this.exceptionalExit = exceptionalExit;
		}
		
		public XExpression getExpression() {
			return expression;
		}
	}
}
