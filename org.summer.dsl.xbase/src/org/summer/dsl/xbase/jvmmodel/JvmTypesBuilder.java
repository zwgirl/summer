/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.jvmmodel;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.toArray;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmCustomAnnotationValue;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmStringAnnotationValue;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.access.impl.ClassURIHelper;
import org.summer.dsl.model.types.util.AnnotationLookup;
import org.summer.dsl.model.types.util.TypeReferences;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.model.xtype.XtypeFactory;
import org.summer.dsl.xbase.compiler.CompilationStrategyAdapter;
import org.summer.dsl.xbase.compiler.CompilationTemplateAdapter;
import org.summer.dsl.xbase.compiler.DocumentationAdapter;
import org.summer.dsl.xbase.compiler.FileHeaderAdapter;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.lib.Extension;
import org.summer.dsl.xbase.lib.util.ToStringHelper;
import org.summer.dsl.xbase.typesystem.InferredTypeIndicator;
import org.summer.ss2.lib.StringConcatenationClient;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

/**
 * A set of factory and builder functions, used to create instances of ({@link TypesPackage}).
 * 
 * It's meant to be used from an implementation of {@link IJvmModelInferrer}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
@NonNullByDefault
public class JvmTypesBuilder {

	private static Logger LOG = Logger.getLogger(JvmTypesBuilder.class);
	
	@Inject
	private IJvmModelAssociator associator;
	
	@Inject
	private ILogicalContainerProvider logicalContainerProvider;

	@Inject
	private TypeReferences references;
	
	@Inject
	private IEObjectDocumentationProvider documentationProvider;
	
	@Inject
	private TypesFactory typesFactory;
	
	@Inject(optional = true)
	private XtypeFactory xtypesFactory = XtypeFactory.eINSTANCE;
	
	@Inject
	private AnnotationLookup annotationLookup;
	
	/**
	 * Overrides  the default <code>operator_add()</code> to ignore <code>null</code> elements.
	 */
	public <T> boolean operator_add(@Nullable EList<? super T> list, @Nullable T element) {
		if(list != null && element != null)
			return list.add(element);
		else
			return false;
	}
	
	/**
	 * Overrides  the default <code>operator_add()</code> to ignore <code>null</code> elements.
	 */
	public <T> boolean operator_add(@Nullable EList<? super T> list, @Nullable Iterable<? extends T> elements) {
		boolean result = false;
		if(list != null && elements != null)
			for(T element: elements) 
				result |= operator_add(list, element);
		return result;
	}
	
	/**
	 * Sets the given {@link JvmExecutable} as the logical container for the given {@link XExpression}.
	 * This defines the context and the scope for the given expression. Also it defines how the given JvmExecutable can be executed.
	 * For instance {@link org.summer.dsl.xbase.compiler.JvmModelGenerator} automatically translates any given {@link XExpression} 
	 * into corresponding Java source code as the body of the given {@link JvmExecutable}. 
	 * 
	 * @param logicalContainer
	 *            the {@link JvmExecutable} the expression is associated with. Can be <code>null</code> in which case this
	 *            function does nothing.
	 * @param expr
	 *            the expression. Can be <code>null</code> in which case this function does nothing.
	 */
	public void setBody(@Nullable JvmExecutable logicalContainer, @Nullable XExpression expr) {
		if (logicalContainer == null || expr == null)
			return;
		removeExistingBody(logicalContainer);
		associator.associateLogicalContainer(expr, logicalContainer);
	}
	
	public void removeExistingBody(@Nullable JvmMember member) {
		if(member != null) {
			// remove old adapters
			Iterator<Adapter> iterator = member.eAdapters().iterator();
			while (iterator.hasNext()) {
				Adapter adapter = iterator.next();
				if (adapter instanceof CompilationStrategyAdapter) {
					iterator.remove();
				} else if (adapter instanceof CompilationTemplateAdapter) {
					iterator.remove();
				}
			}
			associator.removeLogicalChildAssociation(member);
		}
	}
	
	@Nullable
	public XExpression getExpression(@Nullable JvmMember member) {
		if(member != null) {
			return logicalContainerProvider.getAssociatedExpression(member);
		}
		return null;
	}
	
	@Nullable
	public XExpression getInitializer(@Nullable JvmMember member) {
		if(member != null) {
			return logicalContainerProvider.getAssociatedExpression(member);
		}
		return null;
	}
	
	@Nullable
	protected <T extends EObject> T initializeSafely(@Nullable T targetElement, @Nullable Procedure1<? super T> initializer) {
		if(targetElement != null && initializer != null) {
			try {
				initializer.apply(targetElement);
			} catch (Exception e) {
				LOG.error("Error initializing JvmElement", e);
			}
		}
		return targetElement;
	}

	/**
	 * Attaches the given compile strategy to the given {@link JvmExecutable} such that the compiler knows how to
	 * implement the {@link JvmExecutable} when it is translated to Java source code.
	 * 
	 * @param executable the operation or constructor to add the method body to. If <code>null</code> this method does nothing.
	 * @param strategy the compilation strategy. If <code>null</code> this method does nothing.
	 */
	public void setBody(@Nullable JvmExecutable executable, @Nullable Procedures.Procedure1<ITreeAppendable> strategy) {
		removeExistingBody(executable);
		setCompilationStrategy(executable, strategy);
	}
	
	/**
	 * Attaches the given compile strategy to the given {@link JvmExecutable} such that the compiler knows how to
	 * implement the {@link JvmExecutable} when it is translated to Java source code.
	 * 
	 * @param executable the operation or constructor to add the method body to. If <code>null</code> this method does nothing.
	 * @param strategy the compilation strategy. If <code>null</code> this method does nothing.
	 */
	public void setBody(@Nullable JvmExecutable executable, @Nullable StringConcatenationClient strategy) {
		removeExistingBody(executable);
		setCompilationStrategy(executable, strategy);
	}
	
	/**
	 * Retrieves the attached documentation for the given source element.
	 * By default this implementation provides the text of a multi line comment preceding the definition of the given source element.
	 * 
	 * @return the documentation of the given source, <code>null</code> if source is <code>null</code> or doesn't have any documentation.
	 */
	@Nullable
	public String getDocumentation(@Nullable EObject source) {
		if (source == null)
			return null;
		if (source instanceof JvmIdentifiableElement) {
			DocumentationAdapter adapter = (DocumentationAdapter) EcoreUtil.getAdapter(source.eAdapters(), DocumentationAdapter.class);
			if (adapter != null)
				return adapter.getDocumentation();
		}
		String documentation = documentationProvider.getDocumentation(source);
		return documentation;
	}

	/**
	 * Attaches the given documentation to the given jvmElement.
	 */
	public void setDocumentation(@Nullable JvmIdentifiableElement jvmElement, @Nullable String documentation) {
		if(jvmElement == null || documentation == null)
			return;
		DocumentationAdapter documentationAdapter = new DocumentationAdapter();
		documentationAdapter.setDocumentation(documentation);
		jvmElement.eAdapters().add(documentationAdapter);
	}

	/**
	 * Attaches the given headText to the given {@link JvmDeclaredType}.
	 */
	public void setFileHeader(@Nullable JvmDeclaredType jvmDeclaredType, @Nullable String headerText) {
		if (jvmDeclaredType == null || headerText == null) {
			return;
		}
		FileHeaderAdapter fileHeaderAdapter = (FileHeaderAdapter) EcoreUtil.getAdapter(jvmDeclaredType.eAdapters(),
				FileHeaderAdapter.class);
		if (fileHeaderAdapter == null) {
			fileHeaderAdapter = new FileHeaderAdapter();
			jvmDeclaredType.eAdapters().add(fileHeaderAdapter);
		}
		fileHeaderAdapter.setHeaderText(headerText);
	}

	/**
	 * Creates a public class declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualifiedName of the resulting class.
	 * 
	 * @return a {@link JvmGenericType} representing a Java class of the given name, <code>null</code> if either parameter is <code>null</code>.
	 */
	@Nullable 
	public JvmGenericType toClass(@Nullable EObject sourceElement, @Nullable QualifiedName name) {
		return toClass(sourceElement, name!=null ? name.toString() : null, null);
	}
	
	/**
	 * Creates a public class declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualifiedName of the resulting class.
	 * 
	 * @return a {@link JvmGenericType} representing a Java class of the given name, <code>null</code> if either parameter is <code>null</code>.
	 */
	@Nullable 
	public JvmGenericType toClass(@Nullable EObject sourceElement, @Nullable String name) {
		return toClass(sourceElement, name, null);
	}
	
	/**
	 * Creates a public class declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the {@link QualifiedName} of the resulting class.
	 * @param initializer
	 *            the initializer to apply on the created class element. If <code>null</code>, the class won't be initialized.
	 * 
	 * @return a {@link JvmGenericType} representing a Java class of the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmGenericType toClass(@Nullable EObject sourceElement, @Nullable QualifiedName name, @Nullable Procedure1<? super JvmGenericType> initializer) {
		return toClass(sourceElement, name != null ? name.toString() : null, initializer);
	}
	
	/**
	 * Creates a public class declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualified name of the resulting class.
	 * @param initializer
	 *            the initializer to apply on the created class element. If <code>null</code>, the class won't be initialized.
	 * 
	 * @return a {@link JvmGenericType} representing a Java class of the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmGenericType toClass(@Nullable EObject sourceElement, @Nullable String name, @Nullable Procedure1<? super JvmGenericType> initializer) {
		final JvmGenericType result = createJvmGenericType(sourceElement, name);
		if (result == null)
			return null;
		associate(sourceElement, result);
		return initializeSafely(result, initializer);
	}
	
	/**
	 * Creates a public interface declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualified name of the resulting class.
	 * @param initializer
	 *            the initializer to apply on the created interface element. If <code>null</code>, the interface won't be initialized.
	 * 
	 * @return a {@link JvmGenericType} representing a Java class of the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmGenericType toInterface(@Nullable EObject sourceElement, @Nullable String name, @Nullable Procedure1<? super JvmGenericType> initializer) {
		final JvmGenericType result = createJvmGenericType(sourceElement, name);
		if (result == null)
			return null;
//		result.setInterface(true);
		associate(sourceElement, result);
		return initializeSafely(result, initializer);
	}

	@Nullable 
	public JvmAnnotationType toAnnotationType(@Nullable EObject sourceElement, @Nullable String name) {
		return toAnnotationType(sourceElement, name, null);
	}
	
	/**
	 * Creates a public annotation declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualified name of the resulting class.
	 * @param initializer
	 *            the initializer to apply on the created annotation. If <code>null</code>, the annotation won't be initialized.
	 * 
	 * @return a {@link JvmAnnotationType} representing a Java annotation of the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmAnnotationType toAnnotationType(@Nullable EObject sourceElement, @Nullable String name, 
			@Nullable Procedure1<? super JvmAnnotationType> initializer) {
		if (sourceElement == null || name == null)
			return null;
		Pair<String, String> fullName = splitQualifiedName(name);
		JvmAnnotationType annotationType = typesFactory.createJvmAnnotationType();
		annotationType.setSimpleName(fullName.getSecond());
		if (fullName.getFirst() != null)
			annotationType.setPackageName(fullName.getFirst());
		associate(sourceElement, annotationType);
		return initializeSafely(annotationType, initializer);
	}
	
	/**
	 * Creates a public enum declaration, associated to the given sourceElement. It sets the given name, which might be
	 * fully qualified using the standard Java notation.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the qualified name of the resulting enum type.
	 * @param initializer
	 *            the initializer to apply on the created enumeration type. If <code>null</code>, the enum won't be initialized.
	 * 
	 * @return a result representing a Java enum type with the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmEnumerationType toEnumerationType(@Nullable EObject sourceElement, @Nullable String name, 
			@Nullable Procedure1<? super JvmEnumerationType> initializer) {
		if (sourceElement == null || name == null)
			return null;
		Pair<String, String> fullName = splitQualifiedName(name);
		JvmEnumerationType result = typesFactory.createJvmEnumerationType();
		result.setSimpleName(fullName.getSecond());
		result.setVisibility(JvmVisibility.PUBLIC);
		if (fullName.getFirst() != null)
			result.setPackageName(fullName.getFirst());
		associate(sourceElement, result);
		return initializeSafely(result, initializer);
	}
	
	/**
	 * Creates a public enumeration literal, associated to the given sourceElement.
	 * 
	 * @param sourceElement
	 *            the sourceElement the resulting element is associated with.
	 * @param name
	 *            the simple name of the resulting enumeration literal.
	 * 
	 * @return a result representing a Java enumeration literal with the given name, <code>null</code> 
	 *            if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmEnumerationLiteral toEnumerationLiteral(@Nullable EObject sourceElement, @Nullable String name) {
		return toEnumerationLiteral(sourceElement, name, null);
	}
	
	/**
	 * Same as {@link #toEnumerationLiteral(EObject, String)} but with an initializer passed as the last argument.
	 */
	@Nullable 
	public JvmEnumerationLiteral toEnumerationLiteral(@Nullable EObject sourceElement, @Nullable String name, 
			@Nullable Procedure1<? super JvmEnumerationLiteral> initializer) {
		if (sourceElement == null || name == null)
			return null;
		JvmEnumerationLiteral result = typesFactory.createJvmEnumerationLiteral();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PUBLIC);
		associate(sourceElement, result);
		return initializeSafely(result, initializer);
	}
	
	@Nullable 
	protected JvmGenericType createJvmGenericType(@Nullable EObject sourceElement, @Nullable String name) {
		if (sourceElement == null || name == null)
			return null;
		Pair<String, String> fullName = splitQualifiedName(name);
		final JvmGenericType result = typesFactory.createJvmGenericType();
		result.setSimpleName(fullName.getSecond());
		if (fullName.getFirst() != null)
			result.setPackageName(fullName.getFirst());
		result.setVisibility(JvmVisibility.PUBLIC);
		return result;
	}

	protected Pair<String, String> splitQualifiedName(String name) {
		String simpleName = name;
		String packageName = null;
		final int dotIdx = name.lastIndexOf('.');
		if (dotIdx != -1) {
			simpleName = name.substring(dotIdx + 1);
			packageName = name.substring(0, dotIdx);
		}
		Pair<String,String> fullName = Tuples.create(packageName, simpleName);
		return fullName;
	}

	/**
	 * Creates a private field with the given name and the given type associated to the given sourceElement.
	 * 
	 * @param sourceElement the sourceElement the resulting element is associated with.
	 * @param name the simple name of the resulting field.
	 * @param typeRef the type of the field
	 * 
	 * @return a {@link JvmField} representing a Java field with the given simple name and type.
	 */
	@Nullable
	public JvmField toField(@Nullable EObject sourceElement, @Nullable String name, @Nullable JvmTypeReference typeRef) {
		return toField(sourceElement, name, typeRef, null);
	}
	
	/**
	 * Same as {@link #toField(EObject, String, JvmTypeReference)} but with an initializer passed as the last argument.
	 */
	@Nullable	
	public JvmField toField(@Nullable EObject sourceElement, @Nullable String name, @Nullable JvmTypeReference typeRef, 
			@Nullable Procedure1<? super JvmField> initializer) {
		if(sourceElement == null || name == null) 
			return null;
		JvmField result = typesFactory.createJvmField();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PRIVATE);
		result.setType(cloneWithProxies(typeRef));
		associate(sourceElement, result);
		return initializeSafely(result, initializer);
	}
	
	/**
	 * Adds or removes the annotation {@link Extension @Extension} from the given field. If the annotation is
	 * already present, nothing is done if {@code value} is {@code true}. If it is not present and {@code value}
	 * is {@code false}, this is a no-op, too. 
	 * 
	 * @param field the field that will be processed
	 * @param sourceElement the context that shall be used to lookup the {@link Extension annotation type}.
	 * @param value <code>true</code> if the parameter shall be marked as extension, <code>false</code> if it should be unmarked.
	 */
	public void setExtension(@Nullable JvmField field, EObject sourceElement, boolean value) {
		if (field == null)
			return;
		internalSetExtension(field, sourceElement, value);
	}
	
	/**
	 * Adds or removes the annotation {@link Extension @Extension} from the given parameter. If the annotation is
	 * already present, nothing is done if {@code value} is {@code true}. If it is not present and {@code value}
	 * is {@code false}, this is a no-op, too. 
	 * 
	 * @param parameter the parameter that will be processed
	 * @param sourceElement the context that shall be used to lookup the {@link Extension annotation type}.
	 * @param value <code>true</code> if the parameter shall be marked as extension, <code>false</code> if it should be unmarked.
	 */
	public void setExtension(@Nullable JvmFormalParameter parameter, EObject sourceElement, boolean value) {
		if (parameter == null)
			return;
		internalSetExtension(parameter, sourceElement, value);
	}
	
	protected void internalSetExtension(JvmAnnotationTarget annotationTarget, EObject sourceElement, boolean value) {
		if (value) {
			annotationLookup.findOrAddAnnotation(annotationTarget, sourceElement, Extension.class);
		} else {
			annotationLookup.removeAnnotation(annotationTarget, Extension.class);
		}
	}
	
	/**
	 * Associates a source element with a target element. This association is used for tracing. Navigation, for
	 * instance, uses this information to find the real declaration of a Jvm element.
	 * 
	 * @see IJvmModelAssociator
	 * @see IJvmModelAssociations
	 * 
	 * @return the target for convenience.
	 */
	@Nullable
	public <T extends EObject> T associate(@Nullable EObject sourceElement, @Nullable T target) {
		if(sourceElement != null && target != null)
			associator.associate(sourceElement, target);
		return target;
	}

	/**
	 * Creates a public method with the given name and the given return type and associates it with the given
	 * sourceElement.
	 * 
	 * @param sourceElement 
	 * 		the sourceElement the method should be associated with.
	 * @param name
	 * 		the simple name of the method to be created.
	 * @param returnType
	 * 		the return type of the created method.
	 * @param initializer
	 *            the initializer to apply on the created method. If <code>null</code>, the method won't be initialized.
	 * 
	 * @return a result representing a Java method with the given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	@Nullable
	public JvmOperation toMethod(@Nullable EObject sourceElement, @Nullable String name, @Nullable JvmTypeReference returnType,
			@Nullable Procedure1<? super JvmOperation> initializer) {
		if(sourceElement == null || name == null) 
			return null;
		JvmOperation result = typesFactory.createJvmOperation();
		result.setSimpleName(name);
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setReturnType(cloneWithProxies(returnType));
		associate(sourceElement, result);
		return initializeSafely(result, initializer);
	}
	
	/**
	 * Produces an inferred type which will be resolved on demand. It should not be attempted to resolve
	 * this type during the model inference.
	 * 
	 * @return an inferred type.
	 */
	public JvmTypeReference inferredType() {
		XComputedTypeReference result = xtypesFactory.createXComputedTypeReference();
		result.setTypeProvider(new InferredTypeIndicator(null));
		return result;
	}
	
	/**
	 * Produces an inferred type which will be resolved on demand. It should not be attempted to resolve
	 * this type during the model inference.
	 * 
	 * @param expression the expression that will be used resolve the type. May not be <code>null</code>.
	 * @return an inferred type.
	 */
	public JvmTypeReference inferredType(XExpression expression) {
		Preconditions.checkNotNull(expression);
		XComputedTypeReference result = xtypesFactory.createXComputedTypeReference();
		result.setTypeProvider(new InferredTypeIndicator(expression));
		return result;
	}
	
	/**
	 * shorthand for <code>toGetter(sourceElement, name, name, typeRef)</code>.
	 */
	@Nullable
	public JvmOperation toGetter(@Nullable final EObject sourceElement, @Nullable final String name, @Nullable JvmTypeReference typeRef) {
		return toGetter(sourceElement, name, name, typeRef);
	}
	
	/**
	 * Creates a getter method for the given property name and the field name.
	 * 
	 * Example: <code>
	 * public String getPropertyName() {
	 *   return this.fieldName;
	 * }
	 * </code>
	 * 
	 * @return a getter method for a JavaBeans property, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	@Nullable
	public JvmOperation toGetter(@Nullable final EObject sourceElement, @Nullable final String propertyName, @Nullable final String fieldName, @Nullable JvmTypeReference typeRef) {
		if(sourceElement == null || propertyName == null || fieldName == null) 
			return null;
		JvmOperation result = typesFactory.createJvmOperation();
		result.setVisibility(JvmVisibility.PUBLIC);
		String prefix = "get";
		if (typeRef != null && !typeRef.eIsProxy() && !InferredTypeIndicator.isInferred(typeRef) 
				&& typeRef.getType()!=null 
				&& !typeRef.getType().eIsProxy() && "boolean".equals(typeRef.getType().getIdentifier())) {
			prefix = "is";
		}
		result.setSimpleName(prefix + Strings.toFirstUpper(propertyName));
		result.setReturnType(cloneWithProxies(typeRef));
		setBody(result, new Procedures.Procedure1<ITreeAppendable>() {
			public void apply(@Nullable ITreeAppendable p) {
				if(p != null) {
					p = p.trace(sourceElement);
					p.append("return this.");
					p.append(fieldName);
					p.append(";");
				}
			}
		});
		return associate(sourceElement, result);
	}

	/**
	 * shorthand for <code>toSetter(sourceElement, name, name, typeRef)</code>
	 */
	@Nullable
	public JvmOperation toSetter(@Nullable final EObject sourceElement, @Nullable final String name, @Nullable JvmTypeReference typeRef) {
		return toSetter(sourceElement, name, name, typeRef);
	}
	
	/**
	 * Creates a setter method for the given properties name with the standard implementation assigning the passed
	 * parameter to a similarly named field.
	 * 
	 * Example: <code>
	 * public void setFoo(String foo) {
	 *   this.foo = foo;
	 * }
	 * </code>
	 *
	 * @return a setter method for a JavaBeans property with the given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmOperation toSetter(@Nullable final EObject sourceElement, @Nullable final String propertyName, @Nullable final String fieldName, @Nullable JvmTypeReference typeRef) {
		if(sourceElement == null || propertyName == null || fieldName == null) 
			return null;
		JvmOperation result = typesFactory.createJvmOperation();
		result.setVisibility(JvmVisibility.PUBLIC);
		result.setReturnType(references.getTypeForName(Void.TYPE,sourceElement));
		result.setSimpleName("set" + Strings.toFirstUpper(propertyName));
		result.getParameters().add(toParameter(sourceElement, propertyName, cloneWithProxies(typeRef)));
		setBody(result, new Procedures.Procedure1<ITreeAppendable>() {
			public void apply(@Nullable ITreeAppendable p) {
				if(p != null) {
					p = p.trace(sourceElement);
					p.append("this.");
					p.append(fieldName);
					p.append(" = ");
					p.append(propertyName);
					p.append(";");
				}
			}
		});
		return associate(sourceElement, result);
	}

	/**
	 * Creates and returns a formal parameter for the given name and type, which is associated to the given source
	 * element.
	 * 
	 * @return a Java parameter given name, <code>null</code> if sourceElement or name are <code>null</code>.
	 */
	@Nullable 
	public JvmFormalParameter toParameter(@Nullable EObject sourceElement, @Nullable String name, @Nullable JvmTypeReference typeRef) {
		if(sourceElement == null || name == null)
			return null;
		JvmFormalParameter result = typesFactory.createJvmFormalParameter();
		result.setSimpleName(name);
		result.setParameterType(cloneWithProxies(typeRef));
		return associate(sourceElement, result);
	}

	/**
	 * Creates and returns a constructor with the given simple name associated to the given source element. By default
	 * the constructor will have an empty body and no arguments, hence the Java default constructor.
	 *
	 * @param sourceElement 
	 * 		      the sourceElement the constructor should be associated with.
	 * @param initializer
	 *            the initializer to apply on the created constructor. If <code>null</code>, the method won't be initialized.
	 * 
	 * @return a result representing a Java constructor with the given name, <code>null</code> if sourceElement is <code>null</code>.
	 */
	@Nullable 
	public JvmConstructor toConstructor(@Nullable EObject sourceElement, @Nullable Procedure1<? super JvmConstructor> initializer) {
		if(sourceElement == null)
			return null;
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		constructor.setVisibility(JvmVisibility.PUBLIC);
		associate(sourceElement, constructor);
		return initializeSafely(constructor, initializer);
	}
	
	/**
	 * Creates a <code>toString()</code> method accumulating the values of all fields.
	 *
	 * @return a result representing a Java toString() method, <code>null</code> if sourceElement or declaredType are <code>null</code>.
	 */
	@Nullable 
	public JvmOperation toToStringMethod(@Nullable final EObject sourceElement, @Nullable final JvmDeclaredType declaredType) {
		if(sourceElement == null || declaredType == null)
			return null;
		JvmOperation result = toMethod(sourceElement, "toString", newTypeRef(sourceElement, String.class), null);
		if (result == null)
			return null;
		JvmType overrideType = references.findDeclaredType(Override.class, sourceElement);
		if (overrideType != null)
			result.getAnnotations().add(toAnnotation(sourceElement, Override.class));
		setBody(result, new Procedure1<ITreeAppendable>() {
			public void apply(@Nullable ITreeAppendable p) {
				if (p == null)
					return;
				JvmType type = JvmTypesBuilder.this.references.findDeclaredType(ToStringHelper.class, sourceElement);
				p.append("String result = new ");
				if (type != null) {
					p.append(type);
				} else {
					p.append(ToStringHelper.class.getName());
				}
				p.append("().toString(this);");
				p.newLine().append("return result;");
			}
		});
		return result;
	}
	
	public @Nullable JvmOperation toHashCodeMethod(@Nullable final EObject sourceElement, final boolean extendsSomethingWithProperHashCode, @Nullable final JvmDeclaredType declaredType) {
		if (sourceElement == null || declaredType == null)
			return null;
		return toHashCodeMethod(sourceElement, extendsSomethingWithProperHashCode, toArray(filter(declaredType.getMembers(), JvmField.class), JvmField.class));
	}
	
	public @Nullable JvmOperation toHashCodeMethod(@Nullable final EObject sourceElement, final boolean extendsSomethingWithProperHashCode, final JvmField ...jvmFields) {
		if (sourceElement == null)
			return null;
		JvmOperation result = toMethod(sourceElement, "hashCode", this.references.getTypeForName(Integer.TYPE, sourceElement), null);
		if (result == null)
			return null;
		result.getAnnotations().add(toAnnotation(sourceElement, Override.class));
		setBody(result, new Procedure1<ITreeAppendable>() {
			public void apply(@Nullable ITreeAppendable p) {
				if (p == null)
					return;
				p.append("final int prime = 31;");
				if (extendsSomethingWithProperHashCode) {
					p.newLine().append("int result = super.hashCode();");
				} else{
					p.newLine().append("int result = 1;");
				}
				for (JvmField field : jvmFields) {
					String typeName = field.getType().getIdentifier();
					if (Boolean.TYPE.getName().equals(typeName)) {
						p.newLine().append("result = prime * result + (" + field.getSimpleName() +" ? 1231 : 1237);");
					} else if (Integer.TYPE.getName().equals(typeName)
							|| Character.TYPE.getName().equals(typeName)
							|| Byte.TYPE.getName().equals(typeName)
							|| Short.TYPE.getName().equals(typeName)) {
						p.newLine().append("result = prime * result + " + field.getSimpleName() +";");
					} else if (Long.TYPE.getName().equals(typeName)) {
						p.newLine().append("result = prime * result + (int) (" + field.getSimpleName() +" ^ (" + field.getSimpleName() + " >>> 32));");
					} else if (Float.TYPE.getName().equals(typeName)) {
						p.newLine().append("result = prime * result + Float.floatToIntBits(" + field.getSimpleName() +");");
					} else if (Double.TYPE.getName().equals(typeName)) {
						p.newLine().append("result = prime * result + (int) (Double.doubleToLongBits(" + field.getSimpleName() +") ^ (Double.doubleToLongBits(" + field.getSimpleName() + ") >>> 32));");
					} else {
						p.newLine().append("result = prime * result + ((" + field.getSimpleName() +"== null) ? 0 : "+field.getSimpleName()+".hashCode());");
					}
				}
				p.newLine().append("return result;");
			}
		});
		return result;
	}
	
	public @Nullable JvmOperation toEqualsMethod(@Nullable final EObject sourceElement, @Nullable final JvmDeclaredType declaredType, final boolean isDelegateToSuperEquals) {
		if (sourceElement == null || declaredType == null)
			return null;
		return toEqualsMethod(sourceElement, declaredType, isDelegateToSuperEquals, toArray(filter(declaredType.getMembers(), JvmField.class), JvmField.class));
	}
	
	public @Nullable JvmOperation toEqualsMethod(@Nullable final EObject sourceElement, @Nullable final JvmDeclaredType declaredType, final boolean isDelegateToSuperEquals, final JvmField ...jvmFields) {
		if (sourceElement == null || declaredType == null)
			return null;
		JvmOperation result = toMethod(sourceElement, "equals", references.getTypeForName(Boolean.TYPE, sourceElement), null);
		if (result == null)
			return null;
		result.getAnnotations().add(toAnnotation(sourceElement, Override.class));
		result.getParameters().add( toParameter(sourceElement, "obj", references.getTypeForName(Object.class, sourceElement)));
		setBody(result, new Procedure1<ITreeAppendable>() {
				public void apply(@Nullable ITreeAppendable p) {
					if (p == null)
						return;
					p.append("if (this == obj)").increaseIndentation();
						p.newLine().append("return true;").decreaseIndentation();
					p.newLine().append("if (obj == null)").increaseIndentation();
						p.newLine().append("return false;").decreaseIndentation();
					p.newLine().append("if (getClass() != obj.getClass())").increaseIndentation();
						p.newLine().append("return false;").decreaseIndentation();
					if (isDelegateToSuperEquals) {
						p.newLine().append("if (!super.equals(obj))").increaseIndentation();
							p.newLine().append("return false;").decreaseIndentation();
					}
					p.newLine().append(declaredType.getSimpleName()+" other = (" + declaredType.getSimpleName() + ") obj;");
					for (JvmField field : jvmFields) {
						String typeName = field.getType().getIdentifier();
						if (Boolean.TYPE.getName().equals(typeName) 
								|| Integer.TYPE.getName().equals(typeName)
								|| Long.TYPE.getName().equals(typeName)
								|| Character.TYPE.getName().equals(typeName)
								|| Byte.TYPE.getName().equals(typeName)
								|| Short.TYPE.getName().equals(typeName)) {
							p.newLine().append("if (other." + field.getSimpleName() +" != " + field.getSimpleName() + ")").increaseIndentation();
								p.newLine().append("return false;").decreaseIndentation();
							
						} else if (Double.TYPE.getName().equals(typeName)) {
							p.newLine().append("if (Double.doubleToLongBits(other." + field.getSimpleName() +") != Double.doubleToLongBits(" + field.getSimpleName() + "))").increaseIndentation();
							p.newLine().append("return false;").decreaseIndentation();
						} else if (Float.TYPE.getName().equals(typeName)) {
							p.newLine().append("if (Float.floatToIntBits(other." + field.getSimpleName() +") != Float.floatToIntBits(" + field.getSimpleName() + "))").increaseIndentation();
							p.newLine().append("return false;").decreaseIndentation();
						} else {
							p.newLine().append("if (" + field.getSimpleName() +" == null) {").increaseIndentation();
								p.newLine().append("if (other." + field.getSimpleName() +" != null)").increaseIndentation();
									p.newLine().append("return false;").decreaseIndentation();
								p.decreaseIndentation();
							p.newLine().append("} else if (!"+ field.getSimpleName() +".equals(other."+ field.getSimpleName() +"))").increaseIndentation();
								p.newLine().append("return false;").decreaseIndentation();
						}
					}
					p.newLine().append("return true;");
				}
			});
		return result;
	}
	

	/**
	 * Creates and returns an annotation reference of the given annotation type.
	 * 
	 * @see #toAnnotation(EObject, Class, Object)
	 */
	@Nullable
	public JvmAnnotationReference toAnnotation(@Nullable EObject sourceElement, @Nullable Class<?> annotationType) {
		return toAnnotation(sourceElement, annotationType, null);
	}

	/**
	 * Creates and returns an annotation reference of the given annotation type's name.
	 * 
	 * @see #toAnnotation(EObject, String, Object)
	 */
	@Nullable 
	public JvmAnnotationReference toAnnotation(@Nullable EObject sourceElement, @Nullable String annotationTypeName) {
		return toAnnotation(sourceElement, annotationTypeName, null);
	}

	/**
	 * Creates and returns an annotation reference of the given annotation type's name and the given value.
	 * 
	 * @param sourceElement
	 *            the source element to associate the created element with.
	 * @param annotationType
	 *            the type of the created annotation reference.
	 * @param value
	 *            the value of the annotation reference. Can be <code>null</code> if the reference doesn't have any value.
	 *            
	 * @return a result representing an annotation reference to the given annotation type, <code>null<code> if 
	 * 		sourceElement or annotationType are <code>null</code>.  
	 */
	@Nullable
	public JvmAnnotationReference toAnnotation(@Nullable EObject sourceElement, @Nullable Class<?> annotationType, @Nullable Object value) {
		if(sourceElement == null || annotationType == null)
			return null;
		return toAnnotation(sourceElement, annotationType.getCanonicalName(), value);
	}

	/**
	 * Creates and returns an annotation reference of the given annotation type's name and the given value.
	 * 
	 * @param sourceElement
	 *            the source element to associate the created element with.
	 * @param annotationTypeName
	 *            the type name of the created annotation.
	 * @param value
	 *            the value of the annotation reference. Can be <code>null</code> if the reference doesn't have any value.
	 *            
	 * @return a result representing an annotation reference to the given annotation type, <code>null<code> if 
	 * 		sourceElement or annotationType are <code>null</code>.  
	 */
	@Nullable 
	public JvmAnnotationReference toAnnotation(@Nullable EObject sourceElement, @Nullable String annotationTypeName, @Nullable Object value) {
		JvmAnnotationReference result = typesFactory.createJvmAnnotationReference();
		JvmType jvmType = references.findDeclaredType(annotationTypeName, sourceElement);
		if (jvmType == null) {
			throw new IllegalArgumentException("The type "+annotationTypeName +" is not on the classpath.");
		}
		if (!(jvmType instanceof JvmAnnotationType)) {
			throw new IllegalArgumentException("The given class " + annotationTypeName + " is not an annotation type.");
		}
		result.setAnnotation((JvmAnnotationType) jvmType);
		if (value != null) {
			if (value instanceof String) {
				JvmStringAnnotationValue annotationValue = typesFactory.createJvmStringAnnotationValue();
				annotationValue.getValues().add((String) value);
				result.getValues().add(annotationValue);
			}
		}
		return result;
	}

	/**
	 * Creates a clone of the given {@link JvmTypeReference} without resolving any proxies.
	 * The clone will be associated with the original element by means of {@link JvmModelAssociator associations}.
	 * 
	 * @param typeRef the type reference to be cloned.
	 * @return a clone of typeRef, <code>null</code> if typeRef is <code>null</code> or a {@link JvmUnknownTypeReference} 
	 *     if there is a problem with the typeRef. 
	 */
	@Nullable 
	public JvmTypeReference cloneWithProxies(@Nullable JvmTypeReference typeRef) {
		if(typeRef == null)
			return null;
		if (typeRef instanceof JvmParameterizedTypeReference && !typeRef.eIsProxy()
				&& !typeRef.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)) {
			JvmUnknownTypeReference unknownTypeReference = typesFactory.createJvmUnknownTypeReference();
			return unknownTypeReference;
		}
		return cloneAndAssociate(typeRef);
	}

	/**
	 * Creates a clone of the given {@link JvmIdentifiableElement} without resolving any proxies.
	 * The clone will be associated with the original element by means of {@link JvmModelAssociator associations}.
	 * 
 	 * @param original the element to be cloned.
	 * @return a clone of original associated with the original, <code>null</code> if original is <code>null</code>. 
	 */
	@Nullable 
	public <T extends JvmIdentifiableElement> T cloneWithProxies(@Nullable T original) {
		if(original == null)
			return null;
		return cloneAndAssociate(original);
	}
	
	/**
	 * Creates a deep copy of the given object and associates each copied instance with the
	 * clone. Does not resolve any proxies.
	 *	
	 * @param original the root element to be cloned.
	 * @return a clone of tree rooted in original associated with the original, <code>null</code> if original is <code>null</code>. 
	 */
	protected <T extends EObject> T cloneAndAssociate(T original) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false) {
			private static final long serialVersionUID = 1L;

			@Override@Nullable 
			protected EObject createCopy(@Nullable EObject eObject) {
				EObject result = super.createCopy(eObject);
				if (result != null && eObject != null && !eObject.eIsProxy()) {
					associator.associatePrimary(eObject, result);
				}
				return result;
			}
		};
		@SuppressWarnings("unchecked")
		T copy = (T) copier.copy(original);
		copier.copyReferences();
		return copy;
	}
	
	/**
	 * Creates a deep copy of the given object and associates each copied instance with the
	 * clone. Does not resolve any proxies.
	 *	
	 * @param original the root element to be cloned.
	 * @return a clone of tree rooted in original associated with the original, <code>null</code> if original is <code>null</code>. 
	 */
	protected <T extends JvmTypeReference> T cloneAndAssociate(T original) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false) {
			private static final long serialVersionUID = 1L;

			@Override@Nullable 
			protected EObject createCopy(@Nullable EObject eObject) {
				EObject result = super.createCopy(eObject);
				if (result != null && eObject != null && !eObject.eIsProxy()) {
					associator.associatePrimary(eObject, result);
				}
				return result;
			}
			@Override
			public EObject copy(@Nullable EObject eObject) {
				EObject result = super.copy(eObject);
				if (result instanceof JvmWildcardTypeReference) {
					boolean upperBoundSeen = false;
					for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) result).getConstraints()) {
						if (constraint instanceof JvmUpperBound) {
							upperBoundSeen = true;
							break;
						}
					}
					if (!upperBoundSeen) {
						// no upper bound found - seems to be an invalid - assume object as upper bound
						JvmTypeReference object = newObjectReference();
						JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
						upperBound.setTypeReference(object);
						((JvmWildcardTypeReference) result).getConstraints().add(0, upperBound);
					}
				}
				return result;
			}
		};
		@SuppressWarnings("unchecked")
		T copy = (T) copier.copy(original);
		copier.copyReferences();
		return copy;
	}
	
	private JvmTypeReference newObjectReference() {
		URI objectURI = new ClassURIHelper().getFullURI(Object.class);
		JvmType objectType = typesFactory.createJvmGenericType();
		((InternalEObject)objectType).eSetProxyURI(objectURI);
		JvmParameterizedTypeReference result = typesFactory.createJvmParameterizedTypeReference();
		result.setType(objectType);
		return result;
	}
	
	/**
	 * Attaches the given compile strategy to the given {@link JvmField} such that the compiler knows how to
	 * initialize the {@link JvmField} when it is translated to Java source code.
	 * 
	 * @param field the field to add the initializer to. If <code>null</code> this method does nothing. 
	 * @param strategy the compilation strategy. If <code>null</code> this method does nothing. 
	 */
	public void setInitializer(@Nullable JvmField field, @Nullable Procedures.Procedure1<ITreeAppendable> strategy) {
		if (field == null || strategy == null)
			return;
		removeExistingBody(field);
		setCompilationStrategy(field, strategy);
	}
	
	/**
	 * Attaches the given compile strategy to the given {@link JvmField} such that the compiler knows how to
	 * initialize the {@link JvmField} when it is translated to Java source code.
	 * 
	 * @param field the field to add the initializer to. If <code>null</code> this method does nothing. 
	 * @param strategy the compilation strategy. If <code>null</code> this method does nothing. 
	 */
	public void setInitializer(@Nullable JvmField field, @Nullable StringConcatenationClient strategy) {
		if (field == null || strategy == null)
			return;
		removeExistingBody(field);
		setCompilationStrategy(field, strategy);
	}
	
	/**
	 * Sets the given {@link JvmField} as the logical container for the given {@link XExpression}.
	 * This defines the context and the scope for the given expression.
	 * 
	 * @param field
	 *            the {@link JvmField} that is initialized by the expression. If <code>null</code> this method does nothing. 
	 * @param expr
	 *            the initialization expression. Can be <code>null</code> in which case this function does nothing.
	 */
	public void setInitializer(@Nullable JvmField field, @Nullable XExpression expr) {
		if (field == null || expr == null)
			return;
		removeExistingBody(field);
		associator.associateLogicalContainer(expr, field);
	}
	
	protected void setCompilationStrategy(@Nullable JvmMember member, @Nullable Procedures.Procedure1<ITreeAppendable> strategy) {
		if(member == null || strategy == null)
			return;
		CompilationStrategyAdapter adapter = new CompilationStrategyAdapter();
		adapter.setCompilationStrategy(strategy);
		member.eAdapters().add(adapter);
	}
	
	protected void setCompilationStrategy(@Nullable JvmMember member, @Nullable StringConcatenationClient strategy) {
		if(member == null || strategy == null)
			return;
		CompilationTemplateAdapter adapter = new CompilationTemplateAdapter();
		adapter.setCompilationTemplate(strategy);
		member.eAdapters().add(adapter);
	}

	/**
	 * Creates a new {@link JvmTypeReference} pointing to the given class and containing the given type arguments.
	 * 
	 * @param ctx
	 *            an EMF context, which is used to look up the {@link org.summer.dsl.model.types.JvmType} for the
	 *            given clazz.
	 * @param clazz
	 *            the class the type reference shall point to.
	 * @param typeArgs
	 *            type arguments
	 * 
	 * @return the newly created {@link JvmTypeReference}
	 */
	@Nullable 
	public JvmTypeReference newTypeRef(@Nullable EObject ctx, @Nullable Class<?> clazz, @Nullable JvmTypeReference... typeArgs) {
		return references.getTypeForName(clazz, ctx, typeArgs);
	}

	/**
	 * Creates a new {@link JvmTypeReference} pointing to the given class and containing the given type arguments.
	 * 
	 * @param ctx
	 *            an EMF context, which is used to look up the {@link org.summer.dsl.model.types.JvmType} for the
	 *            given clazz.
	 * @param typeName
	 *            the name of the type the reference shall point to.
	 * @param typeArgs
	 *            type arguments
	 * @return the newly created {@link JvmTypeReference}
	 */
	@Nullable 
	public JvmTypeReference newTypeRef(@Nullable EObject ctx, @Nullable String typeName, @Nullable JvmTypeReference... typeArgs) {
		return references.getTypeForName(typeName, ctx, typeArgs);
	}
	
	/**
	 * Creates a new {@link JvmTypeReference} pointing to the given class and containing the given type arguments.
	 * 
	 * @param type
	 *            the type the reference shall point to.
	 * @param typeArgs
	 *            type arguments
	 * @return the newly created {@link JvmTypeReference}
	 */
	@Nullable 
	public JvmTypeReference newTypeRef(@Nullable JvmType type, @Nullable JvmTypeReference... typeArgs) {
		return references.createTypeRef(type, typeArgs);
	}

	/**
	 * @return an array type of the given type reference. Add one dimension if the given {@link JvmTypeReference} is
	 *         already an array.
	 */
	@Nullable 
	public JvmTypeReference addArrayTypeDimension(@Nullable JvmTypeReference componentType) {
		return references.createArrayType(componentType);
	}

	/**
	 * Translates {@link XAnnotation XAnnotations} to {@link JvmAnnotationReference JvmAnnotationReferences} 
	 * and adds them to the given {@link JvmAnnotationTarget}.
	 * 
	 * @param target the annotation target. If <code>null</code> this method does nothing. 
	 * @param annotations the annotations. If <code>null</code> this method does nothing. 
	 */
	public void translateAnnotationsTo(@Nullable Iterable<? extends JvmAnnotationReference> annotations, @Nullable JvmAnnotationTarget target) {
		if(annotations == null || target == null) 
			return;
		for (JvmAnnotationReference anno : annotations) {
			JvmAnnotationReference annotationReference = getJvmAnnotationReference(anno);
			if(annotationReference != null) {
				target.getAnnotations().add(annotationReference);
			}
		}
	}

	@Nullable 
	public JvmAnnotationReference getJvmAnnotationReference(@Nullable JvmAnnotationReference anno) {
		if(anno == null)
			return null;
		JvmAnnotationReference reference = typesFactory.createJvmAnnotationReference();
		final JvmType annotation = (JvmType) anno.eGet(
				TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__ANNOTATION, false);
		if (annotation.eIsProxy()) {
			JvmAnnotationType copiedProxy = TypesFactory.eINSTANCE.createJvmAnnotationType();
			((InternalEObject)copiedProxy).eSetProxyURI(EcoreUtil.getURI(annotation));
			reference.setAnnotation(copiedProxy);
		} else if (annotation instanceof JvmAnnotationType){
			reference.setAnnotation((JvmAnnotationType) annotation);
		}
		
		//cym comment
//		for (XAnnotationElementValuePair val : anno.getElementValuePairs()) {
//			XExpression valueExpression = val.getValue();
//			JvmAnnotationValue annotationValue = toJvmAnnotationValue(valueExpression);
//			if (annotationValue != null) {
//				JvmOperation op = (JvmOperation) val.eGet(
//						XannotationPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT, false);
//				annotationValue.setOperation(op);
//				reference.getValues().add(annotationValue);
//			}
//		}
		if (anno.getValue() != null) {
			JvmAnnotationValue value = toJvmAnnotationValue(anno.getValue());
			if (value != null) {
				reference.getValues().add(value);
			}
		}
		associate(anno, reference);
		return reference;
	}

	/**
	 * @since 2.4
	 */
	@Nullable 
	public JvmAnnotationValue toJvmAnnotationValue(@Nullable XExpression value) {
		if (value != null) {
			JvmCustomAnnotationValue annotationValue = typesFactory.createJvmCustomAnnotationValue();
			annotationValue.getValues().add(value);
			return annotationValue;
		}
		return null;
	}
	
}
