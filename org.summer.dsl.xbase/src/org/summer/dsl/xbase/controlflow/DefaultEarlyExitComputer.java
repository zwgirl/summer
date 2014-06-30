/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.controlflow;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XBreakStatment;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XContinueStatment;
import org.summer.dsl.model.xbase.XDoWhileStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XThrowStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileStatment;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class DefaultEarlyExitComputer implements IEarlyExitComputer {

	private PolymorphicDispatcher<Collection<ExitPoint>> dispatcher = PolymorphicDispatcher.createForSingleTarget("_exitPoints", this);
	
	public boolean isEarlyExit(XStatment expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression);
		if (isNotEmpty(exitPoints))
			return true;
		return false;
	}
	
	protected boolean isNotEmpty(Collection<ExitPoint> exitPoints) {
		return exitPoints != null && !exitPoints.isEmpty();
	}

	public Collection<ExitPoint> getExitPoints(XStatment expression) {
		if (expression == null)
			return Collections.emptyList();
		return dispatcher.invoke(expression);
	}
	
	/**
	 * @param expression unused in this context but required in dispatch signature 
	 */
	protected Collection<ExitPoint> _exitPoints(XExpression expression) {
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XReturnStatment expression) {
		return Collections.singletonList(new ExitPoint(expression, false));
	}
	
	protected Collection<ExitPoint> _exitPoints(XForLoopStatment statment) {
		Collection<ExitPoint> exitPoints = getExitPoints(statment.getStatment());
		if (isNotEmpty(exitPoints))
			return exitPoints;
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XThrowStatment expression) {
		return Collections.singletonList(new ExitPoint(expression, true));
	}
	
	protected Collection<ExitPoint> _exitPoints(XFunctionDeclaration function) {
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XVariableDeclarationList statment) {
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XExpressionStatment expression) {
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XBlockStatment expression) {
		for(XStatment child: expression.getStatments()) {
			Collection<ExitPoint> exitPoints = getExitPoints(child);
			if (isNotEmpty(exitPoints))
				return exitPoints;
		}
		return Collections.emptyList();
	}

	protected Collection<ExitPoint> _exitPoints(XForEachStatment expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression.getStatment());
		if (isNotEmpty(exitPoints))
			return exitPoints;
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XBreakStatment expression) {
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XContinueStatment expression) {
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XWhileStatment expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression.getBody());
		if (isNotEmpty(exitPoints))
			return exitPoints;
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XDoWhileStatment expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression.getBody());
		if (isNotEmpty(exitPoints))
			return exitPoints;
		return getExitPoints(expression.getBody());
	}
	
	protected Collection<ExitPoint> _exitPoints(XIfStatment expression) {
		Collection<ExitPoint> thenExitPoints = getExitPoints(expression.getThen());
		Collection<ExitPoint> elseExitPoints = getExitPoints(expression.getElse());
		if (isNotEmpty(thenExitPoints) && isNotEmpty(elseExitPoints)) {
			Collection<ExitPoint> result = Lists.newArrayList(thenExitPoints);
			result.addAll(elseExitPoints);
			return result;
		}
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XSwitchStatment expression) {
		Collection<ExitPoint> result = Lists.newArrayList();
		for(XCasePart casePart: expression.getCases()) {
			// TODO do we have an early exit if the first case condition is an early exit?
			if(casePart.getStatments() != null){
				for(XStatment statment : casePart.getStatments()){
					Collection<ExitPoint> caseExit = getExitPoints(statment);
					if (!isNotEmpty(caseExit))
						return Collections.emptyList();
					else
						result.addAll(caseExit);
				}
			}
		}
//		Collection<ExitPoint> defaultExit = getExitPoints(expression.getDefault());
//		if (!isNotEmpty(defaultExit))
//			return Collections.emptyList();
//		else
//			result.addAll(defaultExit);
		return result;
	}
	
	protected Collection<ExitPoint> _exitPoints(XTryCatchFinallyStatment expression) {
		Collection<ExitPoint> tryExitPoints = getExitPoints(expression.getStatment());
		if (isNotEmpty(tryExitPoints)) {
			Collection<ExitPoint> result = Lists.newArrayList(tryExitPoints);
			// TODO validate tryExitPoints against catch clauses
			
			//cym comment
//			for(XCatchClause catchClause: expression.getCatchClauses()) {
//				Collection<ExitPoint> catchExitPoints = getExitPoints(catchClause.getExpression());
//				if (isNotEmpty(catchExitPoints)) {
//					result.addAll(catchExitPoints);
//				} else {
//					Collection<ExitPoint> finallyExitPoints = getExitPoints(expression.getFinallyExpression());
//					return finallyExitPoints;
//				}
//			}
			
			XCatchClause catchClause = expression.getCatchClause();
			Collection<ExitPoint> catchExitPoints = getExitPoints(catchClause.getStatment());
			if (isNotEmpty(catchExitPoints)) {
				result.addAll(catchExitPoints);
			} else {
				Collection<ExitPoint> finallyExitPoints = getExitPoints(expression.getFinallyStatment());
				return finallyExitPoints;
			}
			
			
			return result;
		} 
		Collection<ExitPoint> finallyExitPoints = getExitPoints(expression.getFinallyStatment());
		return finallyExitPoints;
	}
	
}
