/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.ss.core.richstring;

import org.summer.dsl.model.ss.RichStringElseIf;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else If Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.ss.core.richstring.ElseIfCondition#getRichStringElseIf <em>Rich String Else If</em>}</li>
 *   <li>{@link org.summer.ss.core.richstring.ElseIfCondition#getIfConditionStart <em>If Condition Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.ss.core.richstring.ProcessedRichStringPackage#getElseIfCondition()
 * @model
 * @generated
 */
public interface ElseIfCondition extends LinePart
{
	/**
	 * Returns the value of the '<em><b>Rich String Else If</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rich String Else If</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rich String Else If</em>' reference.
	 * @see #setRichStringElseIf(RichStringElseIf)
	 * @see org.summer.ss.core.richstring.ProcessedRichStringPackage#getElseIfCondition_RichStringElseIf()
	 * @model
	 * @generated
	 */
	RichStringElseIf getRichStringElseIf();

	/**
	 * Sets the value of the '{@link org.summer.ss.core.richstring.ElseIfCondition#getRichStringElseIf <em>Rich String Else If</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rich String Else If</em>' reference.
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	void setRichStringElseIf(RichStringElseIf value);

	/**
	 * Returns the value of the '<em><b>If Condition Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.summer.ss.core.richstring.IfConditionStart#getElseIfConditions <em>Else If Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Condition Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Condition Start</em>' reference.
	 * @see #setIfConditionStart(IfConditionStart)
	 * @see org.summer.ss.core.richstring.ProcessedRichStringPackage#getElseIfCondition_IfConditionStart()
	 * @see org.summer.ss.core.richstring.IfConditionStart#getElseIfConditions
	 * @model opposite="elseIfConditions"
	 * @generated
	 */
	IfConditionStart getIfConditionStart();

	/**
	 * Sets the value of the '{@link org.summer.ss.core.richstring.ElseIfCondition#getIfConditionStart <em>If Condition Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Condition Start</em>' reference.
	 * @see #getIfConditionStart()
	 * @generated
	 */
	void setIfConditionStart(IfConditionStart value);

} // ElseIfCondition
