/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.ss.core.richstring;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.ss.core.richstring.Line#getParts <em>Parts</em>}</li>
 *   <li>{@link org.summer.ss.core.richstring.Line#getRichString <em>Rich String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.ss.core.richstring.ProcessedRichStringPackage#getLine()
 * @model
 * @generated
 */
public interface Line extends EObject
{
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.ss.core.richstring.LinePart}.
	 * It is bidirectional and its opposite is '{@link org.summer.ss.core.richstring.LinePart#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.summer.ss.core.richstring.ProcessedRichStringPackage#getLine_Parts()
	 * @see org.summer.ss.core.richstring.LinePart#getLine
	 * @model opposite="line" containment="true"
	 * @generated
	 */
	EList<LinePart> getParts();

	/**
	 * Returns the value of the '<em><b>Rich String</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.summer.ss.core.richstring.ProcessedRichString#getLines <em>Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rich String</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rich String</em>' container reference.
	 * @see #setRichString(ProcessedRichString)
	 * @see org.summer.ss.core.richstring.ProcessedRichStringPackage#getLine_RichString()
	 * @see org.summer.ss.core.richstring.ProcessedRichString#getLines
	 * @model opposite="lines" transient="false"
	 * @generated
	 */
	ProcessedRichString getRichString();

	/**
	 * Sets the value of the '{@link org.summer.ss.core.richstring.Line#getRichString <em>Rich String</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rich String</em>' container reference.
	 * @see #getRichString()
	 * @generated
	 */
	void setRichString(ProcessedRichString value);

} // Line
