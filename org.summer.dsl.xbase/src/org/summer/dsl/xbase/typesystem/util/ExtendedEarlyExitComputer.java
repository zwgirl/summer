/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.xbase.XAbstractWhileStatment;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XThrowStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtendedEarlyExitComputer {
	
	// TODO discuss / improve
	/**
	 * Returns <code>true</code> for expressions that seem to be early exit expressions, e.g.
	 * <pre>
	 *   while(condition) {
	 *     if (anotherCondition)
	 *       return value
	 *     changeResultOfFirstCondition
	 *   }
	 * </pre>
	 */
	public boolean isIntentionalEarlyExit(@Nullable XStatment expression) {
		if (expression == null) {
			return true;
		}
		if (expression instanceof XBlockStatment) {
			XBlockStatment block = (XBlockStatment) expression;
			List<XStatment> children = block.getStatments();
			for(XStatment child: children) {
				if (isIntentionalEarlyExit(child)) {
					return true;
				}
			}
		} else if (expression instanceof XIfStatment) {
			return isIntentionalEarlyExit(((XIfStatment) expression).getThen()) && isIntentionalEarlyExit(((XIfStatment) expression).getElse());
		} else if (expression instanceof XTryCatchFinallyStatment) {
			XTryCatchFinallyStatment tryCatchFinally = (XTryCatchFinallyStatment) expression;
			
			//cym comment
//			if (isIntentionalEarlyExit(tryCatchFinally.getExpression())) {
//				for(XCatchClause catchClause: tryCatchFinally.getCatchClauses()) {
//					if (!isIntentionalEarlyExit(catchClause.getExpression()))
//						return false;
//				}
//				return true;
//			}
			
			if (isIntentionalEarlyExit(tryCatchFinally.getStatment())) {
				XCatchClause catchClause = tryCatchFinally.getCatchClause();
				if (!isIntentionalEarlyExit(catchClause.getStatment()))
					return false;
				
				return true;
			}
			return false;
		} else if (expression instanceof XAbstractWhileStatment) {
			return isIntentionalEarlyExit(((XAbstractWhileStatment) expression).getBody());
		} else if (expression instanceof XForLoopStatment) {
			return isIntentionalEarlyExit(((XForLoopStatment) expression).getStatment());
		}
		return expression instanceof XReturnStatment || expression instanceof XThrowStatment;
	}

	public boolean isDefiniteEarlyExit(XStatment expression) {
		// TODO further improvements
		if (expression instanceof XIfStatment) {
			XIfStatment ifExpression = (XIfStatment) expression;
			return isDefiniteEarlyExit(ifExpression.getThen()) && isDefiniteEarlyExit(ifExpression.getElse());
		} else if (expression instanceof XSwitchStatment) {
			XSwitchStatment switchExpression = (XSwitchStatment) expression;
			if (isDefiniteEarlyExit(switchExpression.getDefault())) {
				for(XCasePart caseExpression: switchExpression.getCases()) {
					if (!isDefiniteEarlyExit(caseExpression.getThen())) {
						return false;
					}
				}
				return true;
			}
			return false;
		} else if (expression instanceof XTryCatchFinallyStatment) {
			XTryCatchFinallyStatment tryExpression = (XTryCatchFinallyStatment) expression;
			if (isDefiniteEarlyExit(tryExpression.getFinallyStatment())) {
				return true;
			}
			
			//cym comment
//			if (isDefiniteEarlyExit(tryExpression.getExpression())) {
//				for(XCatchClause catchClause: tryExpression.getCatchClauses()) {
//					if (!isDefiniteEarlyExit(catchClause.getExpression())) {
//						return false;
//					}
//				}
//				return true;
//			}
			
			if (isDefiniteEarlyExit(tryExpression.getStatment())) {
				XCatchClause catchClause = tryExpression.getCatchClause();
				if (!isDefiniteEarlyExit(catchClause.getStatment())) {
					return false;
				}
				
				return true;
			}
			return false;
		} else if (expression instanceof XBlockStatment) {
			List<XStatment> expressions = ((XBlockStatment) expression).getStatments();
			for(int i = expressions.size() - 1; i >= 0; i--) {
				if (isDefiniteEarlyExit(expressions.get(i))) {
					return true;
				}
			}
		}
		return expression instanceof XReturnStatment || expression instanceof XThrowStatment;
	}
	
}
