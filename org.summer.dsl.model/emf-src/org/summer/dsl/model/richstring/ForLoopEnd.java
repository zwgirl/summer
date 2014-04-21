/**
 */
package org.summer.dsl.model.richstring;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Loop End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.richstring.ForLoopEnd#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.richstring.RichstringPackage#getForLoopEnd()
 * @model
 * @generated
 */
public interface ForLoopEnd extends LinePart {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.summer.dsl.model.richstring.ForLoopStart#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' reference.
	 * @see #setStart(ForLoopStart)
	 * @see org.summer.dsl.model.richstring.RichstringPackage#getForLoopEnd_Start()
	 * @see org.summer.dsl.model.richstring.ForLoopStart#getEnd
	 * @model opposite="end"
	 * @generated
	 */
	ForLoopStart getStart();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.richstring.ForLoopEnd#getStart <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(ForLoopStart value);

} // ForLoopEnd
