/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.quickfix;

import static org.eclipse.xtext.ui.util.DisplayRunHelper.*;
import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.summer.ss.ide.codebuilder.AbstractAnnotationBuilder;
import org.summer.ss.ide.codebuilder.AbstractClassBuilder;
import org.summer.ss.ide.codebuilder.AbstractInterfaceBuilder;
import org.summer.ss.ide.codebuilder.CodeBuilderFactory;
import org.summer.ss.ide.wizards.NewSsAnnotationWizard;
import org.summer.ss.ide.wizards.NewSsAnnotationWizardPage;
import org.summer.ss.ide.wizards.NewSsClassWizard;
import org.summer.ss.ide.wizards.NewSsClassWizardPage;
import org.summer.ss.ide.wizards.NewSsInterfaceWizard;
import org.summer.ss.ide.wizards.NewSsInterfaceWizardPage;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.TypesPackage;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Issue;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xannotation.XannotationPackage;
import org.summer.dsl.xbase.ui.quickfix.CreateJavaTypeQuickfixes;
import org.summer.dsl.xbase.ui.quickfix.TypeNameGuesser;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Quickfixes to create new Xtend types.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@NonNullByDefault
public class CreateXtendTypeQuickfixes extends CreateJavaTypeQuickfixes {

	@Inject
	private Provider<NewSsClassWizard> newXtendClassWizardProvider;
	
	@Inject
	private Provider<NewSsInterfaceWizard> newXtendInterfaceWizardProvider;

	@Inject
	private Provider<NewSsAnnotationWizard> newXtendAnnotationWizardProvider;

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private CodeBuilderFactory codeBuilderFactory;
	
	@Inject
	private CodeBuilderQuickfix codeBuilderQuickfix;

	@Inject
	private TypeNameGuesser typeNameGuesser;
	
	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private IQualifiedNameConverter converter;
	
	@Override
	public void addQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			IXtextDocument xtextDocument, XtextResource resource, 
			EObject referenceOwner, EReference unresolvedReference)
			throws Exception {
		String typeString = (issue.getData() != null && issue.getData().length > 0) 
				? issue.getData()[0] 
				: xtextDocument.get(issue.getOffset(), issue.getLength());
		Pair<String, String> packageAndType = typeNameGuesser.guessPackageAndTypeName(referenceOwner, typeString);
		String typeName = packageAndType.getSecond();
		if(isEmpty(typeName)) 
			return;
		String explicitPackage = packageAndType.getFirst();
		boolean isLocal = isEmpty(explicitPackage) || explicitPackage.equals(getPackage(resource));
		if(isLocal) 
			explicitPackage = "";
		if(isEmpty(packageAndType.getSecond()))
			return;
		if (unresolvedReference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR) {
			if(((XConstructorCall)referenceOwner).getConstructor().eIsProxy()) {
				if(isTypeMissing(referenceOwner, typeName, explicitPackage)) {
					newJavaClassQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
					newXtendClassQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
					if(isLocal)
						newLocalXtendClassQuickfix(typeName, resource, issue, issueResolutionAcceptor);
				}
			}
		} else if(unresolvedReference == XbasePackage.Literals.XTYPE_LITERAL__TYPE
				|| unresolvedReference == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE) {
			EStructuralFeature eContainingFeature = referenceOwner.eContainingFeature();
			if(eContainingFeature == SsPackage.Literals.XTEND_CLASS__EXTENDS) {
				newJavaClassQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				newXtendClassQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				if(isLocal)
					newLocalXtendClassQuickfix(typeName, resource, issue, issueResolutionAcceptor);
			} else if(eContainingFeature == SsPackage.Literals.XTEND_CLASS__IMPLEMENTS
					|| eContainingFeature == SsPackage.Literals.XTEND_INTERFACE__EXTENDS) {
				newJavaInterfaceQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				newXtendInterfaceQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				if(isLocal)
					newLocalXtendInterfaceQuickfix(typeName, resource, issue, issueResolutionAcceptor);
			} else {
				newJavaClassQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				newJavaInterfaceQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				newXtendClassQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				newXtendInterfaceQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
				if(isLocal) {
					newLocalXtendClassQuickfix(typeName, resource, issue, issueResolutionAcceptor);				
					newLocalXtendInterfaceQuickfix(typeName, resource, issue, issueResolutionAcceptor);
				}
			}
		} else if(unresolvedReference == XannotationPackage.Literals.XANNOTATION__ANNOTATION_TYPE) {
			newJavaAnnotationQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
			newXtendAnnotationQuickfix(typeName, explicitPackage, resource, issue, issueResolutionAcceptor);
			if(isLocal) 
				newLocalXtendAnnotationQuickfix(typeName, resource, issue, issueResolutionAcceptor);
		}
	}

	protected boolean isTypeMissing(EObject referenceOwner, String typeName, String explicitPackage) {
		QualifiedName typeQName = (!isEmpty(explicitPackage))
			? converter.toQualifiedName(explicitPackage).append(typeName)
			: converter.toQualifiedName(typeName);
		final IScope typeScope = scopeProvider.getScope(referenceOwner, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		return typeScope.getSingleElement(typeQName) == null;
	}
	
	protected void newLocalXtendClassQuickfix(String typeName, XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		EObject eObject = resource.getEObject(issue.getUriToProblem().fragment());
		XtendTypeDeclaration xtendType = getAnnotationTarget(eObject);
		if(xtendType != null) {
			JvmDeclaredType inferredType = associations.getInferredType(xtendType);
			if(inferredType != null) {
				AbstractClassBuilder classBuilder = codeBuilderFactory.createClassBuilder(inferredType);
				classBuilder.setClassName(typeName);
				classBuilder.setVisibility(JvmVisibility.PUBLIC);
				classBuilder.setContext(xtendType);
				codeBuilderQuickfix.addQuickfix(classBuilder, "Create local Xtend class '" + typeName + "'", issue, issueResolutionAcceptor);
			}
		}
	}

	protected void newLocalXtendInterfaceQuickfix(String typeName, XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		EObject eObject = resource.getEObject(issue.getUriToProblem().fragment());
		XtendTypeDeclaration xtendType = getAnnotationTarget(eObject);
		if(xtendType != null) {
			JvmDeclaredType inferredType = associations.getInferredType(xtendType);
			if(inferredType != null) {
				AbstractInterfaceBuilder interfaceBuilder = codeBuilderFactory.createInterfaceBuilder(inferredType);
				interfaceBuilder.setInterfaceName(typeName);
				interfaceBuilder.setVisibility(JvmVisibility.PUBLIC);
				interfaceBuilder.setContext(xtendType);
				codeBuilderQuickfix.addQuickfix(interfaceBuilder, "Create local Xtend interface '" + typeName + "'", issue, issueResolutionAcceptor);
			}
		}
	}

	protected void newLocalXtendAnnotationQuickfix(String typeName, XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		EObject eObject = resource.getEObject(issue.getUriToProblem().fragment());
		XtendTypeDeclaration xtendType = getAnnotationTarget(eObject);
		if(xtendType != null) {
			JvmDeclaredType inferredType = associations.getInferredType(xtendType);
			if(inferredType != null) {
				AbstractAnnotationBuilder annotationBuilder = codeBuilderFactory.createAnnotationBuilder(inferredType);
				annotationBuilder.setAnnotationName(typeName);
				annotationBuilder.setVisibility(JvmVisibility.PUBLIC);
				annotationBuilder.setContext(xtendType);
				codeBuilderQuickfix.addQuickfix(annotationBuilder, "Create local Xtend annotation '@" + typeName + "'", issue, issueResolutionAcceptor);
			}
		}
	}

	@Nullable
	protected XtendTypeDeclaration getAnnotationTarget(EObject eObject) {
		XtendTypeDeclaration containerType = EcoreUtil2.getContainerOfType(eObject, XtendTypeDeclaration.class);
		if(containerType != null && containerType.eContainingFeature() == SsPackage.Literals.XTEND_MEMBER__ANNOTATION_INFO)
			return getAnnotationTarget(containerType.eContainer());
		else 
			return containerType;
	}

	protected void newXtendClassQuickfix(final String typeName, final String explicitPackage, final XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		String packageDescription = getPackageDescription(explicitPackage);
		issueResolutionAcceptor.accept(issue, "Create Xtend class '" + typeName + "'" + packageDescription,
				"Opens the new Xtend class wizard to create the type '" + typeName + "'" + packageDescription, "xtend_file.png",
				new IModification() {
					public void apply(@Nullable IModificationContext context) throws Exception {
						runAsyncInDisplayThread(new Runnable() {
							public void run() {
								NewElementWizard newXtendClassWizard = newXtendClassWizardProvider.get();
								WizardDialog dialog = createWizardDialog(newXtendClassWizard);
								NewSsClassWizardPage page = (NewSsClassWizardPage) newXtendClassWizard.getStartingPage();
								configureWizardPage(page, resource.getURI(), typeName, explicitPackage);
								dialog.open();
							}
						});
					}
				});
	}

	protected void newXtendInterfaceQuickfix(final String typeName, final String explicitPackage, final XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		String packageDescription = getPackageDescription(explicitPackage);
		issueResolutionAcceptor.accept(issue, "Create Xtend interface '" + typeName + "'" + packageDescription,
				"Opens the new Xtend interface wizard to create the type '" + typeName + "'" + packageDescription, "xtend_file.png",
				new IModification() {
					public void apply(@Nullable IModificationContext context) throws Exception {
						runAsyncInDisplayThread(new Runnable() {
							public void run() {
								NewElementWizard newXtendInterfaceWizard = newXtendInterfaceWizardProvider.get();
								WizardDialog dialog = createWizardDialog(newXtendInterfaceWizard);
								NewSsInterfaceWizardPage page = (NewSsInterfaceWizardPage) newXtendInterfaceWizard.getStartingPage();
								configureWizardPage(page, resource.getURI(), typeName, explicitPackage);
								dialog.open();
							}
						});
					}
				});
	}

	protected void newXtendAnnotationQuickfix(final String typeName, final String explicitPackage, final XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		String packageDescription = getPackageDescription(explicitPackage);
		issueResolutionAcceptor.accept(issue, "Create Xtend annotation '" + typeName + "'" + packageDescription,
				"Opens the new Xtend annotation wizard to create the type '" + typeName + "'" + packageDescription, "xtend_file.png",
				new IModification() {
					public void apply(@Nullable IModificationContext context) throws Exception {
						runAsyncInDisplayThread(new Runnable() {
							public void run() {
								NewElementWizard newXtendAnnotationWizard = newXtendAnnotationWizardProvider.get();
								WizardDialog dialog = createWizardDialog(newXtendAnnotationWizard);
								NewSsAnnotationWizardPage page = (NewSsAnnotationWizardPage) newXtendAnnotationWizard.getStartingPage();
								configureWizardPage(page, resource.getURI(), typeName, explicitPackage);
								dialog.open();
							}
						});
					}
				});
	}

	protected String getPackage(XtextResource resource) {
		if(!resource.getContents().isEmpty()) {
			final EObject root = resource.getContents().get(0);
			if(root instanceof XtendFile) {
				return ((XtendFile) root).getPackage();
			}
		}
		return null;
	}
	
}
