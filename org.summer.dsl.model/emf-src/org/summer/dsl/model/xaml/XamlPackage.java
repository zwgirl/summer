/**
 */
package org.summer.dsl.model.xaml;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.summer.dsl.model.xaml.XamlFactory
 * @model kind="package"
 * @generated
 */
public interface XamlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xaml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.summer.org/dsl/model/xaml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xaml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XamlPackage eINSTANCE = org.summer.dsl.model.xaml.impl.XamlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xaml.impl.XElementImpl <em>XElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xaml.impl.XElementImpl
	 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXElement()
	 * @generated
	 */
	int XELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XELEMENT__CONTENTS = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XELEMENT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Close Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XELEMENT__CLOSE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XELEMENT__PROPERTIES = 3;

	/**
	 * The number of structural features of the '<em>XElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XELEMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xaml.impl.XObjectElementImpl <em>XObject Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xaml.impl.XObjectElementImpl
	 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXObjectElement()
	 * @generated
	 */
	int XOBJECT_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_ELEMENT__CONTENTS = XELEMENT__CONTENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_ELEMENT__TYPE = XELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Close Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_ELEMENT__CLOSE_TYPE = XELEMENT__CLOSE_TYPE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_ELEMENT__PROPERTIES = XELEMENT__PROPERTIES;

	/**
	 * The number of structural features of the '<em>XObject Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOBJECT_ELEMENT_FEATURE_COUNT = XELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xaml.impl.XAttributeElementImpl <em>XAttribute Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xaml.impl.XAttributeElementImpl
	 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXAttributeElement()
	 * @generated
	 */
	int XATTRIBUTE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTRIBUTE_ELEMENT__CONTENTS = XELEMENT__CONTENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTRIBUTE_ELEMENT__TYPE = XELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Close Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTRIBUTE_ELEMENT__CLOSE_TYPE = XELEMENT__CLOSE_TYPE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTRIBUTE_ELEMENT__PROPERTIES = XELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTRIBUTE_ELEMENT__FIELD = XELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Close Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTRIBUTE_ELEMENT__CLOSE_FIELD = XELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XAttribute Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTRIBUTE_ELEMENT_FEATURE_COUNT = XELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xaml.impl.XAbstractAttributeImpl <em>XAbstract Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xaml.impl.XAbstractAttributeImpl
	 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXAbstractAttribute()
	 * @generated
	 */
	int XABSTRACT_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_ATTRIBUTE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_ATTRIBUTE__FIELD = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_ATTRIBUTE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>XAbstract Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_ATTRIBUTE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xaml.impl.XMarkupExtensonImpl <em>XMarkup Extenson</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xaml.impl.XMarkupExtensonImpl
	 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXMarkupExtenson()
	 * @generated
	 */
	int XMARKUP_EXTENSON = 4;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMARKUP_EXTENSON__CONTENTS = XELEMENT__CONTENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMARKUP_EXTENSON__TYPE = XELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Close Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMARKUP_EXTENSON__CLOSE_TYPE = XELEMENT__CLOSE_TYPE;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMARKUP_EXTENSON__PROPERTIES = XELEMENT__PROPERTIES;

	/**
	 * The number of structural features of the '<em>XMarkup Extenson</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMARKUP_EXTENSON_FEATURE_COUNT = XELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xaml.impl.XAttachAttributeImpl <em>XAttach Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xaml.impl.XAttachAttributeImpl
	 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXAttachAttribute()
	 * @generated
	 */
	int XATTACH_ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTACH_ATTRIBUTE__TYPE = XABSTRACT_ATTRIBUTE__TYPE;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTACH_ATTRIBUTE__FIELD = XABSTRACT_ATTRIBUTE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTACH_ATTRIBUTE__VALUE = XABSTRACT_ATTRIBUTE__VALUE;

	/**
	 * The number of structural features of the '<em>XAttach Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XATTACH_ATTRIBUTE_FEATURE_COUNT = XABSTRACT_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.summer.dsl.model.xaml.impl.XGeneralAttributeImpl <em>XGeneral Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.summer.dsl.model.xaml.impl.XGeneralAttributeImpl
	 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXGeneralAttribute()
	 * @generated
	 */
	int XGENERAL_ATTRIBUTE = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XGENERAL_ATTRIBUTE__TYPE = XABSTRACT_ATTRIBUTE__TYPE;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XGENERAL_ATTRIBUTE__FIELD = XABSTRACT_ATTRIBUTE__FIELD;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XGENERAL_ATTRIBUTE__VALUE = XABSTRACT_ATTRIBUTE__VALUE;

	/**
	 * The number of structural features of the '<em>XGeneral Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XGENERAL_ATTRIBUTE_FEATURE_COUNT = XABSTRACT_ATTRIBUTE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xaml.XElement <em>XElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XElement</em>'.
	 * @see org.summer.dsl.model.xaml.XElement
	 * @generated
	 */
	EClass getXElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xaml.XElement#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.summer.dsl.model.xaml.XElement#getContents()
	 * @see #getXElement()
	 * @generated
	 */
	EReference getXElement_Contents();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xaml.XElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xaml.XElement#getType()
	 * @see #getXElement()
	 * @generated
	 */
	EReference getXElement_Type();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xaml.XElement#getCloseType <em>Close Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Close Type</em>'.
	 * @see org.summer.dsl.model.xaml.XElement#getCloseType()
	 * @see #getXElement()
	 * @generated
	 */
	EReference getXElement_CloseType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.summer.dsl.model.xaml.XElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.summer.dsl.model.xaml.XElement#getProperties()
	 * @see #getXElement()
	 * @generated
	 */
	EReference getXElement_Properties();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xaml.XObjectElement <em>XObject Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XObject Element</em>'.
	 * @see org.summer.dsl.model.xaml.XObjectElement
	 * @generated
	 */
	EClass getXObjectElement();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xaml.XAttributeElement <em>XAttribute Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAttribute Element</em>'.
	 * @see org.summer.dsl.model.xaml.XAttributeElement
	 * @generated
	 */
	EClass getXAttributeElement();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xaml.XAttributeElement#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Field</em>'.
	 * @see org.summer.dsl.model.xaml.XAttributeElement#getField()
	 * @see #getXAttributeElement()
	 * @generated
	 */
	EReference getXAttributeElement_Field();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xaml.XAttributeElement#getCloseField <em>Close Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Close Field</em>'.
	 * @see org.summer.dsl.model.xaml.XAttributeElement#getCloseField()
	 * @see #getXAttributeElement()
	 * @generated
	 */
	EReference getXAttributeElement_CloseField();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xaml.XAbstractAttribute <em>XAbstract Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAbstract Attribute</em>'.
	 * @see org.summer.dsl.model.xaml.XAbstractAttribute
	 * @generated
	 */
	EClass getXAbstractAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xaml.XAbstractAttribute#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Field</em>'.
	 * @see org.summer.dsl.model.xaml.XAbstractAttribute#getField()
	 * @see #getXAbstractAttribute()
	 * @generated
	 */
	EReference getXAbstractAttribute_Field();

	/**
	 * Returns the meta object for the containment reference '{@link org.summer.dsl.model.xaml.XAbstractAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.summer.dsl.model.xaml.XAbstractAttribute#getValue()
	 * @see #getXAbstractAttribute()
	 * @generated
	 */
	EReference getXAbstractAttribute_Value();

	/**
	 * Returns the meta object for the reference '{@link org.summer.dsl.model.xaml.XAbstractAttribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.summer.dsl.model.xaml.XAbstractAttribute#getType()
	 * @see #getXAbstractAttribute()
	 * @generated
	 */
	EReference getXAbstractAttribute_Type();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xaml.XMarkupExtenson <em>XMarkup Extenson</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMarkup Extenson</em>'.
	 * @see org.summer.dsl.model.xaml.XMarkupExtenson
	 * @generated
	 */
	EClass getXMarkupExtenson();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xaml.XAttachAttribute <em>XAttach Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAttach Attribute</em>'.
	 * @see org.summer.dsl.model.xaml.XAttachAttribute
	 * @generated
	 */
	EClass getXAttachAttribute();

	/**
	 * Returns the meta object for class '{@link org.summer.dsl.model.xaml.XGeneralAttribute <em>XGeneral Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XGeneral Attribute</em>'.
	 * @see org.summer.dsl.model.xaml.XGeneralAttribute
	 * @generated
	 */
	EClass getXGeneralAttribute();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XamlFactory getXamlFactory();

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
		 * The meta object literal for the '{@link org.summer.dsl.model.xaml.impl.XElementImpl <em>XElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xaml.impl.XElementImpl
		 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXElement()
		 * @generated
		 */
		EClass XELEMENT = eINSTANCE.getXElement();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XELEMENT__CONTENTS = eINSTANCE.getXElement_Contents();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XELEMENT__TYPE = eINSTANCE.getXElement_Type();

		/**
		 * The meta object literal for the '<em><b>Close Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XELEMENT__CLOSE_TYPE = eINSTANCE.getXElement_CloseType();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XELEMENT__PROPERTIES = eINSTANCE.getXElement_Properties();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xaml.impl.XObjectElementImpl <em>XObject Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xaml.impl.XObjectElementImpl
		 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXObjectElement()
		 * @generated
		 */
		EClass XOBJECT_ELEMENT = eINSTANCE.getXObjectElement();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xaml.impl.XAttributeElementImpl <em>XAttribute Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xaml.impl.XAttributeElementImpl
		 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXAttributeElement()
		 * @generated
		 */
		EClass XATTRIBUTE_ELEMENT = eINSTANCE.getXAttributeElement();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XATTRIBUTE_ELEMENT__FIELD = eINSTANCE.getXAttributeElement_Field();

		/**
		 * The meta object literal for the '<em><b>Close Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XATTRIBUTE_ELEMENT__CLOSE_FIELD = eINSTANCE.getXAttributeElement_CloseField();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xaml.impl.XAbstractAttributeImpl <em>XAbstract Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xaml.impl.XAbstractAttributeImpl
		 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXAbstractAttribute()
		 * @generated
		 */
		EClass XABSTRACT_ATTRIBUTE = eINSTANCE.getXAbstractAttribute();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_ATTRIBUTE__FIELD = eINSTANCE.getXAbstractAttribute_Field();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_ATTRIBUTE__VALUE = eINSTANCE.getXAbstractAttribute_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_ATTRIBUTE__TYPE = eINSTANCE.getXAbstractAttribute_Type();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xaml.impl.XMarkupExtensonImpl <em>XMarkup Extenson</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xaml.impl.XMarkupExtensonImpl
		 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXMarkupExtenson()
		 * @generated
		 */
		EClass XMARKUP_EXTENSON = eINSTANCE.getXMarkupExtenson();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xaml.impl.XAttachAttributeImpl <em>XAttach Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xaml.impl.XAttachAttributeImpl
		 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXAttachAttribute()
		 * @generated
		 */
		EClass XATTACH_ATTRIBUTE = eINSTANCE.getXAttachAttribute();

		/**
		 * The meta object literal for the '{@link org.summer.dsl.model.xaml.impl.XGeneralAttributeImpl <em>XGeneral Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.summer.dsl.model.xaml.impl.XGeneralAttributeImpl
		 * @see org.summer.dsl.model.xaml.impl.XamlPackageImpl#getXGeneralAttribute()
		 * @generated
		 */
		EClass XGENERAL_ATTRIBUTE = eINSTANCE.getXGeneralAttribute();

	}

} //XamlPackage
