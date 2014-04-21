/**
 */
package org.summer.dsl.ui.codetemplates.templates.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.summer.dsl.ui.codetemplates.templates.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplatesFactoryImpl extends EFactoryImpl implements TemplatesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TemplatesFactory init()
  {
    try
    {
      TemplatesFactory theTemplatesFactory = (TemplatesFactory)EPackage.Registry.INSTANCE.getEFactory(TemplatesPackage.eNS_URI);
      if (theTemplatesFactory != null)
      {
        return theTemplatesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TemplatesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplatesFactoryImpl()
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
      case TemplatesPackage.CODETEMPLATES: return createCodetemplates();
      case TemplatesPackage.CODETEMPLATE: return createCodetemplate();
      case TemplatesPackage.TEMPLATE_BODY: return createTemplateBody();
      case TemplatesPackage.TEMPLATE_PART: return createTemplatePart();
      case TemplatesPackage.VARIABLE: return createVariable();
      case TemplatesPackage.LITERAL: return createLiteral();
      case TemplatesPackage.DOLLAR: return createDollar();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Codetemplates createCodetemplates()
  {
    CodetemplatesImpl codetemplates = new CodetemplatesImpl();
    return codetemplates;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Codetemplate createCodetemplate()
  {
    CodetemplateImpl codetemplate = new CodetemplateImpl();
    return codetemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateBody createTemplateBody()
  {
    TemplateBodyImpl templateBody = new TemplateBodyImpl();
    return templateBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplatePart createTemplatePart()
  {
    TemplatePartImpl templatePart = new TemplatePartImpl();
    return templatePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Dollar createDollar()
  {
    DollarImpl dollar = new DollarImpl();
    return dollar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplatesPackage getTemplatesPackage()
  {
    return (TemplatesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TemplatesPackage getPackage()
  {
    return TemplatesPackage.eINSTANCE;
  }

} //TemplatesFactoryImpl
