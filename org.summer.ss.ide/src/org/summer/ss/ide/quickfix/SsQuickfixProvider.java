/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.quickfix;

import static com.google.common.collect.Sets.newHashSet;
import static org.eclipse.xtext.util.Strings.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.validation.Issue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.access.jdt.IJavaProjectProvider;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.ui.contentassist.ReplacingAppendable;
import org.summer.dsl.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters;
import org.summer.dsl.xbase.ui.quickfix.XbaseQuickfixProvider;
import org.summer.ss.core.services.SsGrammarAccess;
import org.summer.ss.core.validation.IssueCodes;
import org.summer.ss.ide.buildpath.SsLibClasspathAdder;
import org.summer.ss.ide.codebuilder.InsertionOffsets;
import org.summer.ss.ide.codebuilder.MemberFromSuperImplementor;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
/**
 * @author Jan Koehnlein - Quickfixes for inconsistent indentation
 * @author Sebastian Zarnekow - Quickfixes for misspelled types and constructors
 * @author Holger Schill - Quickfixes for missing methods / fields / localVars
 */
@Singleton
public class SsQuickfixProvider extends XbaseQuickfixProvider {

	private static final Logger logger = Logger.getLogger(SsQuickfixProvider.class);
	
	@Inject	private ReplacingAppendable.Factory appendableFactory;
	
	@Inject private SsGrammarAccess grammarAccess;
	
	@Inject private InsertionOffsets insertionOffsets;

	@Inject private MemberFromSuperImplementor superMemberImplementor;
	
	@Inject	private SsLibClasspathAdder xtendLibAdder;
	
	@Inject private IJavaProjectProvider projectProvider;

	@Inject private CreateXtendTypeQuickfixes createTypeQuickfixes;

	@Inject private CreateMemberQuickfixes createMemberQuickfixes;
	
	private static final Set<String> LINKING_ISSUE_CODES = newHashSet(
			IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, 
			Diagnostic.LINKING_DIAGNOSTIC,
			IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC,
			org.summer.dsl.xbase.validation.IssueCodes.INVALID_ARGUMENT_TYPES,
			org.summer.dsl.xbase.validation.IssueCodes.INVALID_NUMBER_OF_ARGUMENTS);
	
	@Override
	public boolean hasResolutionFor(String issueCode) {
		return LINKING_ISSUE_CODES.contains(issueCode) || super.hasResolutionFor(issueCode);
	}

	@Override
	public List<IssueResolution> getResolutions(Issue issue) {
		StopWatch stopWatch = new StopWatch(logger);
		try {
			if(LINKING_ISSUE_CODES.contains(issue.getCode())){
				List<IssueResolution> result = new ArrayList<IssueResolution>();
				result.addAll(getResolutionsForLinkingIssue(issue));
				return result;
			} else
				return super.getResolutions(issue);
		} finally {
			stopWatch.resetAndLog("#getResolutions");
		}
	}
	
	@Override
	protected EReference getUnresolvedEReference(Issue issue, EObject target) {
		EReference reference = super.getUnresolvedEReference(issue, target);
		if(reference == null){
			if(issue.getCode().equals(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC)){
				return TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE;
			}
		}
		return reference;
	}

	@Override
	protected void createLinkingIssueQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, 
			IXtextDocument xtextDocument, XtextResource resource, 
			EObject referenceOwner, EReference unresolvedReference) throws Exception {
		javaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
		createTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
		createMemberQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
	}

	@Fix(IssueCodes.INCONSISTENT_INDENTATION)
	public void fixIndentation(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Correct indentation", "Correctly indents this line in this rich string",
				"fix_indent.gif", new IModification() {
					public void apply(IModificationContext context) throws Exception {
						context.getXtextDocument().replace(issue.getOffset(), issue.getLength(), issue.getData()[0]);
					}
				});
	}
	
	@Fix(IssueCodes.MISSING_OVERRIDE)
	public void fixMissingOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change 'def' to 'override'", "Marks this function as 'override'", "fix_indent.gif",
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
//						replaceKeyword(grammarAccess.getMethodModifierAccess().findKeywords("def").get(0), "override", element,
//								context.getXtextDocument());
					}
				});
	}

	@Fix(IssueCodes.OBSOLETE_OVERRIDE)
	public void fixObsoleteOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change 'override' to 'def'", "Removes 'override' from this function", "fix_indent.gif",
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
//						replaceKeyword(grammarAccess.getMethodModifierAccess().findKeywords("override").get(0), "def", element,
//								context.getXtextDocument());
					}
				});
	}

	protected void replaceKeyword(Keyword keyword, String replacement, EObject container, IXtextDocument document)
			throws BadLocationException {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(container);
		if (node != null) {
			for (ILeafNode leafNode : node.getLeafNodes()) {
				if (leafNode.getGrammarElement() == keyword) {
					ITextRegion leafRegion = leafNode.getTextRegion();
					String actualReplacement = replacement;
					if (!Character.isWhitespace(document.getChar(leafRegion.getOffset() - 1))) {
						actualReplacement = " " + replacement;
					}
					document.replace(leafRegion.getOffset(), leafRegion.getLength(), actualReplacement);
				}
			}
		}
	}

	@Fix(IssueCodes.MISSING_CONSTRUCTOR)
	public void addConstuctorFromSuper(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null) {
			for(int i=0; i<issue.getData().length; i+=2) {
				final URI constructorURI = URI.createURI(issue.getData()[i]);
				String javaSignature = issue.getData()[i+1];
				String xtendSignature = "new" + javaSignature.substring(javaSignature.indexOf('('));
				acceptor.accept(issue, "Add constructor " + xtendSignature, "Add constructor " + xtendSignature, "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							JvmGenericType clazz = (JvmGenericType) element;
							ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(), (XtextResource) clazz.eResource(),
									insertionOffsets.getNewConstructorInsertOffset(null, clazz), 0, new OptionalParameters() {{ 
										ensureEmptyLinesAround = true;
										baseIndentationLevel = 1;	
									}});
							EObject constructor = clazz.eResource().getResourceSet().getEObject(constructorURI, true);
							if (constructor instanceof JvmConstructor) {
								superMemberImplementor.appendConstructorFromSuper(clazz, (JvmConstructor) constructor,
										appendable);
							}
							appendable.commitChanges();
						}
					});
			}
		}
	}
	
	@Fix(IssueCodes.CLASS_MUST_BE_ABSTRACT)
	public void implementAbstractMethods(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length > 0) {
			acceptor.accept(issue, "Add unimplemented methods", "Add unimplemented methods", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							JvmGenericType clazz = (JvmGenericType) element;
							IXtextDocument document = context.getXtextDocument();
							ReplacingAppendable appendable = appendableFactory.create(document, (XtextResource) clazz.eResource(),
									insertionOffsets.getNewMethodInsertOffset(null, clazz), 0, new OptionalParameters() {{ 
										ensureEmptyLinesAround = true;
										baseIndentationLevel = 1;	
									}});
							boolean isFirst = true;
							for (String operationUriAsString : issue.getData()) {
								URI operationURI = URI.createURI(operationUriAsString);
								EObject overridden = clazz.eResource().getResourceSet().getEObject(operationURI, true);
								if (overridden instanceof JvmOperation) {
									if(!isFirst) 
										appendable.newLine().newLine();
									isFirst = false;
									superMemberImplementor.appendOverrideFunction(clazz, (JvmOperation) overridden,
											appendable);
								}
							}
							appendable.commitChanges();
						}
					});
		}
		acceptor.accept(issue, "Make class abstract", "Make class abstract", "fix_indent.gif",
				new ISemanticModification() {
			public void apply(EObject element, IModificationContext context) throws Exception {
				internalDoAddAbstractKeyword(element, context);
			}
		});
	}

	@Fix(org.summer.dsl.xbase.validation.IssueCodes.UNHANDLED_EXCEPTION)
	public void addThrowsDeclaration(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length > 0)
			acceptor.accept(issue, "Add throws declaration", "Add throws declaration", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							String[] issueData = issue.getData(); 
							JvmOperation xtendFunction = EcoreUtil2.getContainerOfType(element, JvmOperation.class);
							XtextResource xtextResource = (XtextResource) xtendFunction.eResource();
							List<JvmType> exceptions = getExceptions(issueData, xtextResource);
							if (exceptions.size() > 0) {
								int insertPosition;
								if (xtendFunction.getExpression() == null) {
									ICompositeNode functionNode = NodeModelUtils.findActualNodeFor(xtendFunction);
									if (functionNode == null)
										throw new IllegalStateException("functionNode may not be null");
									insertPosition = functionNode.getEndOffset();
								} else {
									ICompositeNode expressionNode = NodeModelUtils.findActualNodeFor(xtendFunction.getExpression());
									if (expressionNode == null)
										throw new IllegalStateException("expressionNode may not be null");
									insertPosition = expressionNode.getOffset();
								}
								ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
										(XtextResource) xtendFunction.eResource(), insertPosition, 0);
								if (xtendFunction.getExpression() == null) 
									appendable.append(" ");
								EList<JvmTypeReference> thrownExceptions = xtendFunction.getExceptions();
								if (thrownExceptions.isEmpty())
									appendable.append("throws ");
								else
									appendable.append(", ");
								for(int i = 0; i < exceptions.size(); i++) {
									// TODO type ref?
									appendable.append(exceptions.get(i));
									if (i != exceptions.size() - 1) {
										appendable.append(", ");
									}
								}
								if (xtendFunction.getExpression() != null) 
									appendable.append(" ");
								appendable.commitChanges();
							}
						}
					});
	}

	/**
	 * @param all but the last element in the issue data is considered to be a URI to an exception type.
	 */
	protected List<JvmType> getExceptions(String[] issueData, XtextResource resource) {
		List<JvmType> exceptions = Lists.newArrayList();
		for(int i = 0; i < issueData.length - 1; i++) {
			URI exceptionURI = URI.createURI(issueData[i]);
			EObject exception = resource.getResourceSet().getEObject(exceptionURI, true);
			if (exception instanceof JvmType) {
				exceptions.add((JvmType) exception);
			}
		}
		return exceptions;
	}
	
	@Fix(org.summer.dsl.xbase.validation.IssueCodes.UNHANDLED_EXCEPTION)
	public void surroundWithTryCatch(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length > 1)
			acceptor.accept(issue, "Surround with try/catch block", "Surround with try/catch block", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							String[] issueData = issue.getData();
							URI childURI = URI.createURI(issueData[issueData.length - 1]);
							XtextResource xtextResource = (XtextResource) element.eResource();
							List<JvmType> exceptions = getExceptions(issueData, xtextResource);
							if (exceptions.size() > 0) {
								EObject childThrowingException = xtextResource.getResourceSet().getEObject(childURI, true);
								XExpression toBeSurrounded = findContainerExpressionInBlockExpression(childThrowingException);
								IXtextDocument xtextDocument = context.getXtextDocument();
								if (toBeSurrounded != null) {
									ICompositeNode toBeSurroundedNode = NodeModelUtils.findActualNodeFor(toBeSurrounded);
									if (toBeSurroundedNode == null)
										throw new IllegalStateException("toBeSurroundedNode may not be null");
									ITextRegion toBeSurroundedRegion = toBeSurroundedNode.getTextRegion();
									ReplacingAppendable appendable = appendableFactory.create(
											context.getXtextDocument(),
											(XtextResource) childThrowingException.eResource(), 
											toBeSurroundedRegion.getOffset(),
											toBeSurroundedRegion.getLength());
									appendable
											.append("try {")
											.increaseIndentation()
												.newLine()
												.append(xtextDocument.get(toBeSurroundedRegion.getOffset(),
														toBeSurroundedRegion.getLength()))
											.decreaseIndentation()
											.newLine();
									for(JvmType exceptionType: exceptions) {
										appendable
											.append("} catch (")
										// TODO type ref?
											.append(exceptionType).append(" exc) {").increaseIndentation()
												.newLine()
												.append("throw new RuntimeException(\"auto-generated try/catch\", exc)").decreaseIndentation()
											.newLine();
									}
									appendable.append("}");
									appendable.commitChanges();
								}
							}
						}
					});
	}
	
	@Fix(IssueCodes.WRONG_PACKAGE)
	public void fixPackageName(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length == 1) {
			final String expectedPackage = issue.getData()[0];
			acceptor.accept(issue, "Change package declaration to '" + expectedPackage + "'", "Change package declaration to '" + expectedPackage + "'", "package_obj.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							((JvmModule) element).setSimpleName(isEmpty(expectedPackage) ? null : expectedPackage);
						}
			});
		}
	}

	protected XExpression findContainerExpressionInBlockExpression(EObject expr) {
		if (expr == null)
			return null;
		EObject container = expr.eContainer();
		if (container instanceof XBlockExpression)
			return (XExpression) expr;
		else
			return findContainerExpressionInBlockExpression(container);
	}
	
	@Fix(IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH)
	public void putXtendOnClasspath(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add Xtend libs to classpath", "Add Xtend libs to classpath", "fix_indent.gif", new ISemanticModification() {
			public void apply(EObject element, IModificationContext context) throws Exception {
				ResourceSet resourceSet = element.eResource().getResourceSet();
				IJavaProject javaProject = projectProvider.getJavaProject(resourceSet);
				xtendLibAdder.addLibsToClasspath(javaProject, new NullProgressMonitor());
			}
		});
	}
	
	@Fix(IssueCodes.MISSING_ABSTRACT)
	public void makeClassAbstract(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make class abstract", "Make class abstract", "fix_indent.gif",
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
						internalDoAddAbstractKeyword(element, context);
					}
				});
	}
	
	protected void internalDoAddAbstractKeyword(EObject element, IModificationContext context)
			throws BadLocationException {
		if (element instanceof JvmOperation) {
			element = element.eContainer();
		}
		if (element instanceof JvmGenericType) {
			JvmGenericType clazz = (JvmGenericType) element;
			IXtextDocument document = context.getXtextDocument();
			ICompositeNode clazzNode = NodeModelUtils.findActualNodeFor(clazz);
			if (clazzNode == null)
				throw new IllegalStateException("Cannot determine node for clazz " + clazz.getSimpleName());
			int offset = -1;
			for (ILeafNode leafNode : clazzNode.getLeafNodes()) {
				if (leafNode.getText().equals("class")) {
					offset = leafNode.getOffset();
				}
			}
			ReplacingAppendable appendable = appendableFactory.create(document, (XtextResource) clazz.eResource(),
					offset, 0);
			appendable.append("abstract ");
			appendable.commitChanges();
		}
	}

}
