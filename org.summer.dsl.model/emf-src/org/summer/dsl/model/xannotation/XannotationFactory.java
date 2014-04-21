/**
 */
package org.summer.dsl.model.xannotation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xannotation.XannotationPackage
 * @generated
 */
public interface XannotationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XannotationFactory eINSTANCE = org.summer.dsl.model.xannotation.impl.XannotationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAnnotation</em>'.
	 * @generated
	 */
	XAnnotation createXAnnotation();

	/**
	 * Returns a new object of class '<em>XAnnotation Element Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAnnotation Element Value Pair</em>'.
	 * @generated
	 */
	XAnnotationElementValuePair createXAnnotationElementValuePair();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XannotationPackage getXannotationPackage();

} //XannotationFactory
