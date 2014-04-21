/**
 */
package org.summer.xaml.core.xAML.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.summer.xaml.core.xAML.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XAMLFactoryImpl extends EFactoryImpl implements XAMLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XAMLFactory init()
  {
    try
    {
      XAMLFactory theXAMLFactory = (XAMLFactory)EPackage.Registry.INSTANCE.getEFactory(XAMLPackage.eNS_URI);
      if (theXAMLFactory != null)
      {
        return theXAMLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XAMLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XAMLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case XAMLPackage.DOCUMENT: return createDocument();
      case XAMLPackage.ELEMENT_CONTENT: return createElementContent();
      case XAMLPackage.OBJECT_ELEMENT: return createObjectElement();
      case XAMLPackage.ATTRIBUTE_ELEMENT: return createAttributeElement();
      case XAMLPackage.ABSTRACT_PROPERTY: return createAbstractProperty();
      case XAMLPackage.PROPERTY: return createProperty();
      case XAMLPackage.MARKUP_EXTENSON: return createMarkupExtenson();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Document createDocument()
  {
    DocumentImpl document = new DocumentImpl();
    return document;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementContent createElementContent()
  {
    ElementContentImpl elementContent = new ElementContentImpl();
    return elementContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectElement createObjectElement()
  {
    ObjectElementImpl objectElement = new ObjectElementImpl();
    return objectElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeElement createAttributeElement()
  {
    AttributeElementImpl attributeElement = new AttributeElementImpl();
    return attributeElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractProperty createAbstractProperty()
  {
    AbstractPropertyImpl abstractProperty = new AbstractPropertyImpl();
    return abstractProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MarkupExtenson createMarkupExtenson()
  {
    MarkupExtensonImpl markupExtenson = new MarkupExtensonImpl();
    return markupExtenson;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XAMLPackage getXAMLPackage()
  {
    return (XAMLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XAMLPackage getPackage()
  {
    return XAMLPackage.eINSTANCE;
  }

} //XAMLFactoryImpl
