/**
 */
package org.summer.dsl.builder.trace;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debug Location Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.builder.trace.DebugLocationData#getLabel <em>Label</em>}</li>
 *   <li>{@link org.summer.dsl.builder.trace.DebugLocationData#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.summer.dsl.builder.trace.DebugLocationData#getLength <em>Length</em>}</li>
 *   <li>{@link org.summer.dsl.builder.trace.DebugLocationData#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.summer.dsl.builder.trace.DebugLocationData#getEndLineNumber <em>End Line Number</em>}</li>
 *   <li>{@link org.summer.dsl.builder.trace.DebugLocationData#getPath <em>Path</em>}</li>
 *   <li>{@link org.summer.dsl.builder.trace.DebugLocationData#getEndOffset <em>End Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData()
 * @model
 * @generated
 */
public interface DebugLocationData extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData_Label()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData_Offset()
	 * @model unique="false"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.summer.dsl.builder.trace.DebugLocationData#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData_Length()
	 * @model unique="false"
	 * @generated
	 */
	int getLength();

	/**
	 * Sets the value of the '{@link org.summer.dsl.builder.trace.DebugLocationData#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData_LineNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link org.summer.dsl.builder.trace.DebugLocationData#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>End Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Line Number</em>' attribute.
	 * @see #setEndLineNumber(int)
	 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData_EndLineNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getEndLineNumber();

	/**
	 * Sets the value of the '{@link org.summer.dsl.builder.trace.DebugLocationData#getEndLineNumber <em>End Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line Number</em>' attribute.
	 * @see #getEndLineNumber()
	 * @generated
	 */
	void setEndLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(URI)
	 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData_Path()
	 * @model unique="false" dataType="org.summer.dsl.builder.trace.URI"
	 * @generated
	 */
	URI getPath();

	/**
	 * Sets the value of the '{@link org.summer.dsl.builder.trace.DebugLocationData#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(URI value);

	/**
	 * Returns the value of the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Offset</em>' attribute.
	 * @see org.summer.dsl.builder.trace.TracePackage#getDebugLocationData_EndOffset()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getEndOffset();

} // DebugLocationData
