/**
 */
package org.summer.xaml.core.xAML;

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
 * @see org.summer.xaml.core.xAML.XAMLFactory
 * @model kind="package"
 * @generated
 */
public interface XAMLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xAML";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.summer.org/markup/xaml/XAML";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xAML";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XAMLPackage eINSTANCE = org.summer.xaml.core.xAML.impl.XAMLPackageImpl.init();

  /**
   * The meta object id for the '{@link org.summer.xaml.core.xAML.impl.DocumentImpl <em>Document</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.summer.xaml.core.xAML.impl.DocumentImpl
   * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getDocument()
   * @generated
   */
  int DOCUMENT = 0;

  /**
   * The feature id for the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT__IMPORT_SECTION = 0;

  /**
   * The feature id for the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT__ROOT = 1;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT__CONTENTS = 2;

  /**
   * The number of structural features of the '<em>Document</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.summer.xaml.core.xAML.impl.ElementContentImpl <em>Element Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.summer.xaml.core.xAML.impl.ElementContentImpl
   * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getElementContent()
   * @generated
   */
  int ELEMENT_CONTENT = 1;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_CONTENT__CONTENTS = 0;

  /**
   * The number of structural features of the '<em>Element Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_CONTENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.summer.xaml.core.xAML.impl.ObjectElementImpl <em>Object Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.summer.xaml.core.xAML.impl.ObjectElementImpl
   * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getObjectElement()
   * @generated
   */
  int OBJECT_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_ELEMENT__CONTENTS = ELEMENT_CONTENT__CONTENTS;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_ELEMENT__TYPE = ELEMENT_CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_ELEMENT__PROPERTIES = ELEMENT_CONTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Close</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_ELEMENT__CLOSE = ELEMENT_CONTENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Object Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_ELEMENT_FEATURE_COUNT = ELEMENT_CONTENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.summer.xaml.core.xAML.impl.AttributeElementImpl <em>Attribute Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.summer.xaml.core.xAML.impl.AttributeElementImpl
   * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getAttributeElement()
   * @generated
   */
  int ATTRIBUTE_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ELEMENT__CONTENTS = ELEMENT_CONTENT__CONTENTS;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ELEMENT__TYPE = ELEMENT_CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ELEMENT__ATTRIBUTE = ELEMENT_CONTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Close</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ELEMENT__CLOSE = ELEMENT_CONTENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Close Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE = ELEMENT_CONTENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Attribute Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ELEMENT_FEATURE_COUNT = ELEMENT_CONTENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.summer.xaml.core.xAML.impl.AbstractPropertyImpl <em>Abstract Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.summer.xaml.core.xAML.impl.AbstractPropertyImpl
   * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getAbstractProperty()
   * @generated
   */
  int ABSTRACT_PROPERTY = 4;

  /**
   * The number of structural features of the '<em>Abstract Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_PROPERTY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.summer.xaml.core.xAML.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.summer.xaml.core.xAML.impl.PropertyImpl
   * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__TYPE = ABSTRACT_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__PROPERTY = ABSTRACT_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__VALUE = ABSTRACT_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = ABSTRACT_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.summer.xaml.core.xAML.impl.MarkupExtensonImpl <em>Markup Extenson</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.summer.xaml.core.xAML.impl.MarkupExtensonImpl
   * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getMarkupExtenson()
   * @generated
   */
  int MARKUP_EXTENSON = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARKUP_EXTENSON__TYPE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARKUP_EXTENSON__PROPERTIES = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Markup Extenson</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARKUP_EXTENSON_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.summer.xaml.core.xAML.Document <em>Document</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document</em>'.
   * @see org.summer.xaml.core.xAML.Document
   * @generated
   */
  EClass getDocument();

  /**
   * Returns the meta object for the containment reference '{@link org.summer.xaml.core.xAML.Document#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see org.summer.xaml.core.xAML.Document#getImportSection()
   * @see #getDocument()
   * @generated
   */
  EReference getDocument_ImportSection();

  /**
   * Returns the meta object for the containment reference '{@link org.summer.xaml.core.xAML.Document#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root</em>'.
   * @see org.summer.xaml.core.xAML.Document#getRoot()
   * @see #getDocument()
   * @generated
   */
  EReference getDocument_Root();

  /**
   * Returns the meta object for the containment reference list '{@link org.summer.xaml.core.xAML.Document#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.summer.xaml.core.xAML.Document#getContents()
   * @see #getDocument()
   * @generated
   */
  EReference getDocument_Contents();

  /**
   * Returns the meta object for class '{@link org.summer.xaml.core.xAML.ElementContent <em>Element Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Content</em>'.
   * @see org.summer.xaml.core.xAML.ElementContent
   * @generated
   */
  EClass getElementContent();

  /**
   * Returns the meta object for the containment reference list '{@link org.summer.xaml.core.xAML.ElementContent#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.summer.xaml.core.xAML.ElementContent#getContents()
   * @see #getElementContent()
   * @generated
   */
  EReference getElementContent_Contents();

  /**
   * Returns the meta object for class '{@link org.summer.xaml.core.xAML.ObjectElement <em>Object Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Element</em>'.
   * @see org.summer.xaml.core.xAML.ObjectElement
   * @generated
   */
  EClass getObjectElement();

  /**
   * Returns the meta object for the containment reference '{@link org.summer.xaml.core.xAML.ObjectElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.summer.xaml.core.xAML.ObjectElement#getType()
   * @see #getObjectElement()
   * @generated
   */
  EReference getObjectElement_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.summer.xaml.core.xAML.ObjectElement#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.summer.xaml.core.xAML.ObjectElement#getProperties()
   * @see #getObjectElement()
   * @generated
   */
  EReference getObjectElement_Properties();

  /**
   * Returns the meta object for the containment reference '{@link org.summer.xaml.core.xAML.ObjectElement#getClose <em>Close</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Close</em>'.
   * @see org.summer.xaml.core.xAML.ObjectElement#getClose()
   * @see #getObjectElement()
   * @generated
   */
  EReference getObjectElement_Close();

  /**
   * Returns the meta object for class '{@link org.summer.xaml.core.xAML.AttributeElement <em>Attribute Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Element</em>'.
   * @see org.summer.xaml.core.xAML.AttributeElement
   * @generated
   */
  EClass getAttributeElement();

  /**
   * Returns the meta object for the reference '{@link org.summer.xaml.core.xAML.AttributeElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.summer.xaml.core.xAML.AttributeElement#getType()
   * @see #getAttributeElement()
   * @generated
   */
  EReference getAttributeElement_Type();

  /**
   * Returns the meta object for the reference '{@link org.summer.xaml.core.xAML.AttributeElement#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.summer.xaml.core.xAML.AttributeElement#getAttribute()
   * @see #getAttributeElement()
   * @generated
   */
  EReference getAttributeElement_Attribute();

  /**
   * Returns the meta object for the reference '{@link org.summer.xaml.core.xAML.AttributeElement#getClose <em>Close</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Close</em>'.
   * @see org.summer.xaml.core.xAML.AttributeElement#getClose()
   * @see #getAttributeElement()
   * @generated
   */
  EReference getAttributeElement_Close();

  /**
   * Returns the meta object for the reference '{@link org.summer.xaml.core.xAML.AttributeElement#getCloseAttribute <em>Close Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Close Attribute</em>'.
   * @see org.summer.xaml.core.xAML.AttributeElement#getCloseAttribute()
   * @see #getAttributeElement()
   * @generated
   */
  EReference getAttributeElement_CloseAttribute();

  /**
   * Returns the meta object for class '{@link org.summer.xaml.core.xAML.AbstractProperty <em>Abstract Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Property</em>'.
   * @see org.summer.xaml.core.xAML.AbstractProperty
   * @generated
   */
  EClass getAbstractProperty();

  /**
   * Returns the meta object for class '{@link org.summer.xaml.core.xAML.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see org.summer.xaml.core.xAML.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the reference '{@link org.summer.xaml.core.xAML.Property#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.summer.xaml.core.xAML.Property#getType()
   * @see #getProperty()
   * @generated
   */
  EReference getProperty_Type();

  /**
   * Returns the meta object for the reference '{@link org.summer.xaml.core.xAML.Property#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.summer.xaml.core.xAML.Property#getProperty()
   * @see #getProperty()
   * @generated
   */
  EReference getProperty_Property();

  /**
   * Returns the meta object for the containment reference '{@link org.summer.xaml.core.xAML.Property#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.summer.xaml.core.xAML.Property#getValue()
   * @see #getProperty()
   * @generated
   */
  EReference getProperty_Value();

  /**
   * Returns the meta object for class '{@link org.summer.xaml.core.xAML.MarkupExtenson <em>Markup Extenson</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Markup Extenson</em>'.
   * @see org.summer.xaml.core.xAML.MarkupExtenson
   * @generated
   */
  EClass getMarkupExtenson();

  /**
   * Returns the meta object for the containment reference '{@link org.summer.xaml.core.xAML.MarkupExtenson#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.summer.xaml.core.xAML.MarkupExtenson#getType()
   * @see #getMarkupExtenson()
   * @generated
   */
  EReference getMarkupExtenson_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.summer.xaml.core.xAML.MarkupExtenson#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.summer.xaml.core.xAML.MarkupExtenson#getProperties()
   * @see #getMarkupExtenson()
   * @generated
   */
  EReference getMarkupExtenson_Properties();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XAMLFactory getXAMLFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.summer.xaml.core.xAML.impl.DocumentImpl <em>Document</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.summer.xaml.core.xAML.impl.DocumentImpl
     * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getDocument()
     * @generated
     */
    EClass DOCUMENT = eINSTANCE.getDocument();

    /**
     * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT__IMPORT_SECTION = eINSTANCE.getDocument_ImportSection();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT__ROOT = eINSTANCE.getDocument_Root();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT__CONTENTS = eINSTANCE.getDocument_Contents();

    /**
     * The meta object literal for the '{@link org.summer.xaml.core.xAML.impl.ElementContentImpl <em>Element Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.summer.xaml.core.xAML.impl.ElementContentImpl
     * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getElementContent()
     * @generated
     */
    EClass ELEMENT_CONTENT = eINSTANCE.getElementContent();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_CONTENT__CONTENTS = eINSTANCE.getElementContent_Contents();

    /**
     * The meta object literal for the '{@link org.summer.xaml.core.xAML.impl.ObjectElementImpl <em>Object Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.summer.xaml.core.xAML.impl.ObjectElementImpl
     * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getObjectElement()
     * @generated
     */
    EClass OBJECT_ELEMENT = eINSTANCE.getObjectElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_ELEMENT__TYPE = eINSTANCE.getObjectElement_Type();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_ELEMENT__PROPERTIES = eINSTANCE.getObjectElement_Properties();

    /**
     * The meta object literal for the '<em><b>Close</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_ELEMENT__CLOSE = eINSTANCE.getObjectElement_Close();

    /**
     * The meta object literal for the '{@link org.summer.xaml.core.xAML.impl.AttributeElementImpl <em>Attribute Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.summer.xaml.core.xAML.impl.AttributeElementImpl
     * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getAttributeElement()
     * @generated
     */
    EClass ATTRIBUTE_ELEMENT = eINSTANCE.getAttributeElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_ELEMENT__TYPE = eINSTANCE.getAttributeElement_Type();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_ELEMENT__ATTRIBUTE = eINSTANCE.getAttributeElement_Attribute();

    /**
     * The meta object literal for the '<em><b>Close</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_ELEMENT__CLOSE = eINSTANCE.getAttributeElement_Close();

    /**
     * The meta object literal for the '<em><b>Close Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_ELEMENT__CLOSE_ATTRIBUTE = eINSTANCE.getAttributeElement_CloseAttribute();

    /**
     * The meta object literal for the '{@link org.summer.xaml.core.xAML.impl.AbstractPropertyImpl <em>Abstract Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.summer.xaml.core.xAML.impl.AbstractPropertyImpl
     * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getAbstractProperty()
     * @generated
     */
    EClass ABSTRACT_PROPERTY = eINSTANCE.getAbstractProperty();

    /**
     * The meta object literal for the '{@link org.summer.xaml.core.xAML.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.summer.xaml.core.xAML.impl.PropertyImpl
     * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY__PROPERTY = eINSTANCE.getProperty_Property();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY__VALUE = eINSTANCE.getProperty_Value();

    /**
     * The meta object literal for the '{@link org.summer.xaml.core.xAML.impl.MarkupExtensonImpl <em>Markup Extenson</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.summer.xaml.core.xAML.impl.MarkupExtensonImpl
     * @see org.summer.xaml.core.xAML.impl.XAMLPackageImpl#getMarkupExtenson()
     * @generated
     */
    EClass MARKUP_EXTENSON = eINSTANCE.getMarkupExtenson();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MARKUP_EXTENSON__TYPE = eINSTANCE.getMarkupExtenson_Type();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MARKUP_EXTENSON__PROPERTIES = eINSTANCE.getMarkupExtenson_Properties();

  }

} //XAMLPackage
