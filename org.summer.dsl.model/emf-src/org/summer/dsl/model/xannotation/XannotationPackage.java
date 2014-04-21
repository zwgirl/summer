/**
 */
package org.summer.dsl.model.xannotation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xannotation.XannotationFactory
 * @model kind="package"
 * @generated
 */
public interface XannotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xannotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.summer.org/dsl/model/xannotation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xannotation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XannotationPackage eINSTANCE = org.summer.dsl.model.xannotation.impl.XannotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xannotation.impl.XAnnotationImpl <em>XAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xannotation.impl.XAnnotationImpl
	 * @see org.summer.dsl.model.xannotation.impl.XannotationPackageImpl#getXAnnotation()
	 * @generated
	 */
	int XANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Element Value Pairs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION__ELEMENT_VALUE_PAIRS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION__ANNOTATION_TYPE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION__VALUE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xannotation.impl.XAnnotationElementValuePairImpl <em>XAnnotation Element Value Pair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xannotation.impl.XAnnotationElementValuePairImpl
	 * @see org.summer.dsl.model.xannotation.impl.XannotationPackageImpl#getXAnnotationElementValuePair()
	 * @generated
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>XAnnotation Element Value Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XANNOTATION_ELEMENT_VALUE_PAIR_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xannotation.XAnnotation <em>XAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAnnotation</em>'.
	 * @see org.summer.dsl.model.xannotation.XAnnotation
	 * @generated
	 */
	EClass getXAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xannotation.XAnnotation#getElementValuePairs <em>Element Value Pairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Value Pairs</em>'.
	 * @see org.summer.dsl.model.xannotation.XAnnotation#getElementValuePairs()
	 * @see #getXAnnotation()
	 * @generated
	 */
	EReference getXAnnotation_ElementValuePairs();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xannotation.XAnnotation#getAnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotation Type</em>'.
	 * @see org.summer.dsl.model.xannotation.XAnnotation#getAnnotationType()
	 * @see #getXAnnotation()
	 * @generated
	 */
	EReference getXAnnotation_AnnotationType();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xannotation.XAnnotation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.xannotation.XAnnotation#getValue()
	 * @see #getXAnnotation()
	 * @generated
	 */
	EReference getXAnnotation_Value();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair <em>XAnnotation Element Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAnnotation Element Value Pair</em>'.
	 * @see org.summer.dsl.model.xannotation.XAnnotationElementValuePair
	 * @generated
	 */
	EClass getXAnnotationElementValuePair();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getValue()
	 * @see #getXAnnotationElementValuePair()
	 * @generated
	 */
	EReference getXAnnotationElementValuePair_Value();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.summer.dsl.model.xannotation.XAnnotationElementValuePair#getElement()
	 * @see #getXAnnotationElementValuePair()
	 * @generated
	 */
	EReference getXAnnotationElementValuePair_Element();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XannotationFactory getXannotationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xannotation.impl.XAnnotationImpl <em>XAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xannotation.impl.XAnnotationImpl
		 * @see org.summer.dsl.model.xannotation.impl.XannotationPackageImpl#getXAnnotation()
		 * @generated
		 */
		EClass XANNOTATION = eINSTANCE.getXAnnotation();

		/**
		 * The meta object literal for the '<em><b>Element Value Pairs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION__ELEMENT_VALUE_PAIRS = eINSTANCE.getXAnnotation_ElementValuePairs();

		/**
		 * The meta object literal for the '<em><b>Annotation Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION__ANNOTATION_TYPE = eINSTANCE.getXAnnotation_AnnotationType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION__VALUE = eINSTANCE.getXAnnotation_Value();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xannotation.impl.XAnnotationElementValuePairImpl <em>XAnnotation Element Value Pair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xannotation.impl.XAnnotationElementValuePairImpl
		 * @see org.summer.dsl.model.xannotation.impl.XannotationPackageImpl#getXAnnotationElementValuePair()
		 * @generated
		 */
		EClass XANNOTATION_ELEMENT_VALUE_PAIR = eINSTANCE.getXAnnotationElementValuePair();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION_ELEMENT_VALUE_PAIR__VALUE = eINSTANCE.getXAnnotationElementValuePair_Value();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT = eINSTANCE.getXAnnotationElementValuePair_Element();

	}

} //XannotationPackage
