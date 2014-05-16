/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access.jdt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.SegmentSequence;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.core.BindingKey;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.IPackageBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.summer.dsl.model.types.JvmAnnotationAnnotationValue;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmBooleanAnnotationValue;
import org.summer.dsl.model.types.JvmByteAnnotationValue;
import org.summer.dsl.model.types.JvmCharAnnotationValue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDoubleAnnotationValue;
import org.summer.dsl.model.types.JvmEnumAnnotationValue;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFloatAnnotationValue;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIntAnnotationValue;
import org.summer.dsl.model.types.JvmLongAnnotationValue;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmShortAnnotationValue;
import org.summer.dsl.model.types.JvmStringAnnotationValue;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeAnnotationValue;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.access.IJvmTypeProvider;
import org.summer.dsl.model.types.access.impl.ITypeFactory;
import org.summer.dsl.model.types.impl.JvmExecutableImplCustom;
import org.summer.dsl.model.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.osgi.framework.Version;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Internal implementation that allows to convert Java top-level classes that
 * are represented as JDTs {@link IType ITypes} to {@link JvmType JvmTypes}.
 * 
 * Clients are not supposed to use this class directly but the {@link IJvmTypeProvider}
 * or {@link TypeReferences} instead. Those will take care of types that are requested more than
 * once and therefore should return the very same {@link JvmType type} on subsequent queries.
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedTypeFactory implements ITypeFactory<IType> {

	private final static Logger log = Logger.getLogger(JdtBasedTypeFactory.class);

	private static final String CLASS_CLASS_NAME = "java.lang.Class";
	private static final String OBJECT_CLASS_NAME = "java.lang.Object";
	private static final String STRING_CLASS_NAME = "java.lang.String";

	private static final String[] EMPTY_STRING_ARRAY = Strings.EMPTY_ARRAY;

	/**
	 * An array of proxies for primitives indexed the same way as {@link TypeURIHelper#PRIMITIVE_URIS}, i.e., indexed based on the first character of their signature.
	 */
	static final JvmType[] PRIMITIVE_PROXIES = new JvmType[TypeURIHelper.PRIMITIVE_URIS.length];
	
	private static JdtCompliance getComplianceLevel() {
		if (isJdtGreaterOrEqual(new Version(3,6,0))) {
			return JdtCompliance.Other;
		}
		return JdtCompliance.Galileo;
	}
	
	/**
	 * TODO (dennis) consider to make it accessible from other (e.g. o.e.x.common.types.tests) bundles.
	 * 
	 * Checks if JDT's (Major,Minor) Version is higher or equals the given one.<br>
	 * Service and qualifier Part will not be checked.
	 * @return <code>true</code> if the avaiable JDT's Version (Major,Minor)  is higher or equals the given one.
	 * 
	 */
	private static boolean isJdtGreaterOrEqual(Version version) {
		Version installed = JavaCore.getPlugin().getBundle().getVersion();
		int minMajor = version.getMajor();
		int minMinor = version.getMinor();
		if (installed.getMajor() < minMajor) {
			return false;
		}
		if (installed.getMajor() == minMajor && installed.getMinor() < minMinor) {
			return false;
		}
		return true;
	}
	

	enum JdtCompliance {
		Galileo {
			@Override
			ParameterNameInitializer createParameterNameInitializer(
					IMethodBinding method,
					WorkingCopyOwner workingCopyOwner,
					JvmExecutable result,
					String handleIdentifier,
					String[] path,
					String name,
					SegmentSequence signaturex) {
				if (method.isConstructor() && method.getDeclaringClass().isMember()) {
					return new ParameterNameInitializer(workingCopyOwner, result, handleIdentifier, path, name, signaturex) {
						@Override
						protected void setParameterNames(IMethod javaMethod, java.util.List<JvmFormalParameter> parameters) throws JavaModelException {
							String[] parameterNames = javaMethod.getParameterNames();
							int size = parameters.size();
							if (size == parameterNames.length) {
								super.setParameterNames(javaMethod, parameters);
							} else if (size == parameterNames.length - 1) {
								for (int i = 1; i < parameterNames.length; i++) {
									String string = parameterNames[i];
									parameters.get(i - 1).setName(string);
								}
							} else {
								throw new IllegalStateException("unmatching arity for java method "+javaMethod.toString()+" and "+getExecutable().getIdentifier());
							}
						}
					};
				}
				return new ParameterNameInitializer(workingCopyOwner, result, handleIdentifier, path, name, signaturex);
			}
		},
		Other {

		};
		ParameterNameInitializer createParameterNameInitializer(IMethodBinding method, WorkingCopyOwner workingCopyOwner,
				JvmExecutable result, String handleIdentifier, String[] path, String name, SegmentSequence signaturex) {
			return new ParameterNameInitializer(workingCopyOwner, result, handleIdentifier, path, name, signaturex);
		}
	}
	
	private static final JdtCompliance jdtCompliance = getComplianceLevel(); 
	
	static {
		// Initialize the primitive proxies at the same indices as in the PRIMITIVE_URIs.
		//
		for (int i = 0; i < TypeURIHelper.PRIMITIVE_URIS.length; ++i) {
			URI uri = TypeURIHelper.PRIMITIVE_URIS[i];
			if (uri != null) {
				JvmType proxy = TypesFactory.eINSTANCE.createJvmVoid();
				((InternalEObject)proxy).eSetProxyURI(uri);
				PRIMITIVE_PROXIES[i] = proxy;
			}
		}
	}
	
	/**
	 * Mappings from qualified type binding name to proxy instance for all the types in {@link TypeURIHelper#COMMON_CLASS_NAMES}.
	 */
	static final Map<String, JvmType> COMMON_PROXIES = new HashMap<String, JvmType>();


	static {
		// Initialize the common proxies
		//
		for (String commonClassName : TypeURIHelper.COMMON_CLASS_NAMES) {
			JvmType objectProxy = TypesFactory.eINSTANCE.createJvmVoid();
			URI uri = TypeURIHelper.COMMON_URIS.get(commonClassName);
			((InternalEObject)objectProxy).eSetProxyURI(uri);
			COMMON_PROXIES.put(uri.segment(1), objectProxy);
		}
	}

	/**
	 * The proxy for <code>java.lang.Object</code>.
	 */
	static final JvmType OBJECT_CLASS_PROXY = COMMON_PROXIES.get(OBJECT_CLASS_NAME);

	/**
	 * Mappings from qualified annotation type binding name to proxy instance for all the annotations in {@link TypeURIHelper#COMMON_ANNOTATIONS}.
	 */
	static final Map<String, JvmAnnotationType> ANNOTATION_PROXIES = new HashMap<String, JvmAnnotationType>();

	/**
	 * Mappings from qualified method name to proxy instance for all the methods in {@link TypeURIHelper#COMMON_ANNOTATIONS}.
	 */
	static final Map<String, JvmOperation[]> ANNOTATION_METHOD_PROXIES = new HashMap<String, JvmOperation[]>();

	static {
		// Initialize the common annotation proxies and their corresponding method proxies.
		//
		for (String[] annotations : TypeURIHelper.COMMON_ANNOTATIONS) {
			JvmAnnotationType objectProxy = TypesFactory.eINSTANCE.createJvmAnnotationType();
			URI uri = TypeURIHelper.COMMON_URIS.get(annotations[0]);
			((InternalEObject)objectProxy).eSetProxyURI(uri);
			String key = uri.segment(1);
			ANNOTATION_PROXIES.put(key, objectProxy);
			
			// Initialize any corresponding method proxies.
			//
			URI[] methodURIs = TypeURIHelper.COMMON_METHOD_URIS.get(annotations[0]);
			if (methodURIs != null) {
				JvmOperation[] jvmOperationProxies = new JvmOperation[methodURIs.length];
				for (int i = 0; i < methodURIs.length; ++i) {
					JvmOperation jvmOperation = TypesFactory.eINSTANCE.createJvmOperation();
					((InternalEObject)jvmOperation).eSetProxyURI(methodURIs[i]);
					jvmOperationProxies[i] = jvmOperation;
				}
				ANNOTATION_METHOD_PROXIES.put(key, jvmOperationProxies);
			}
		}
	}
	

	private final TypeURIHelper uriHelper;
	private final WorkingCopyOwner workingCopyOwner;
	
	/**
	 * A cache mapping each type binding to its corresponding type proxy.
	 * It's demand populated when {@link #createProxy(ITypeBinding) creating} a type proxy 
	 * and cleared when top-level type {@link #createType(IType) creation} completes.
	 */
	private final Map<ITypeBinding, JvmType> typeProxies = new HashMap<ITypeBinding, JvmType>();

	/**
	 * A cache mapping each method binding to its corresponding operation proxy.
	 * It's demand populated when {@link #createMethodProxy(ITypeBinding, IMethodBinding) creating} a method proxy 
	 * and cleared when top-level type {@link #createType(IType) creation} completes.
	 */
	private final Map<IMethodBinding, JvmOperation> operationProxies = new HashMap<IMethodBinding, JvmOperation>();

	/**
	 * A cache mapping each annotation type binding to its corresponding annotation proxy.
	 * It's demand populated when {@link #createAnnotationProxy(ITypeBinding) creating} an annotation proxy 
	 * and cleared when top-level type {@link #createType(IType) creation} completes.
	 */
	private final Map<ITypeBinding, JvmAnnotationType> annotationProxies = new HashMap<ITypeBinding, JvmAnnotationType>();

	/**
	 * A cache mapping each enumeration variable binding to its corresponding enumeration literal proxy.
	 * It's demand populated when {@link #createEnumLiteralProxy(IVariableBinding) creating} an enumeration literal proxy 
	 * and cleared when top-level type {@link #createType(IType) creation} completes.
	 */
	private final Map<IVariableBinding, JvmEnumerationLiteral> enumerationLiteralProxies = new HashMap<IVariableBinding, JvmEnumerationLiteral>();

	/**
	 * A cache mapping each type binding to its corresponding qualified name.
	 * It's demand populated when {@link #getQualifiedName(ITypeBinding) getting} a qualified name 
	 * and cleared when top-level type {@link #createType(IType) creation} completes.
	 */
	private final Map<ITypeBinding, String> qualifiedNames = new HashMap<ITypeBinding, String>();

	/**
	 * A cached ASP parser that's reused by top-level type {@link #createType(IType) creation}.
	 */
	private final ASTParser parser = ASTParser.newParser(AST.JLS3);

	/**
	 * The cached binding for <code>java.lang.String</code>.
	 * It's demand populated by {@link #createAnnotationValue(ITypeBinding, Object)}.
	 * and cleared when top-level type {@link #createType(IType) creation} completes.
	 */
	private ITypeBinding stringTypeBinding;

	/**
	 * The cached binding for <code>java.lang.Class</code>.
	 * It's demand populated by {@link #createAnnotationValue(ITypeBinding, Object)}.
	 * and cleared when top-level type {@link #createType(IType) creation} completes.
	 */
	private ITypeBinding classTypeBinding;
	
	private StoppedTask resolveAnnotations = Stopwatches.forTask("resolve annotations (JdtBasedTypeFactory)");
	private StoppedTask resolveMembers = Stopwatches.forTask("resolve members (JdtBasedTypeFactory)");
	private StoppedTask resolveTypeParams = Stopwatches.forTask("resolve typeParams (JdtBasedTypeFactory)");
	private StoppedTask resolveBinding = Stopwatches.forTask("resolve binding (JdtBasedTypeFactory)");
	private StoppedTask createType = Stopwatches.forTask("JdtBasedTypeFactory.createType (JdtBasedTypeFactory)");

	@Deprecated
	public JdtBasedTypeFactory(TypeURIHelper uriHelper) {
		this(uriHelper, DefaultWorkingCopyOwner.PRIMARY);
	}

	/**
	 * @since 2.4
	 */
	public JdtBasedTypeFactory(TypeURIHelper uriHelper, WorkingCopyOwner workingCopyOwner) {
		this.uriHelper = uriHelper;
		this.workingCopyOwner = workingCopyOwner;
	}

	public JvmDeclaredType createType(IType jdtType) {
		if (jdtType.getDeclaringType() != null)
			throw new IllegalArgumentException("Cannot create type from non-toplevel-type: '"
					+ jdtType.getFullyQualifiedName() + "'.");
		resolveBinding.start();

		parser.setWorkingCopyOwner(workingCopyOwner);
		parser.setIgnoreMethodBodies(true);
		
		IJavaProject project = jdtType.getJavaProject();
		parser.setProject(project);
		
		@SuppressWarnings("unchecked")
		Map<Object, Object> options = project.getOptions(true);
		
		options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.DISABLED);
		parser.setCompilerOptions(options);

		IBinding[] bindings = parser.createBindings(new IJavaElement[] { jdtType }, null);
		resolveBinding.stop();
		if (bindings[0] == null)
			throw new IllegalStateException("Could not create binding for '" + jdtType.getFullyQualifiedName() + "'.");
		IBinding binding = bindings[0];
		if (binding instanceof ITypeBinding) {
			createType.start();
			ITypeBinding typeBinding = (ITypeBinding) binding;
			
			JvmDeclaredType result = createType(jdtType, typeBinding);

			// Clear the cached information.
			//
			clearCache();
			createType.stop();
			return result;
		} else
			throw new IllegalStateException("Expected ITypeBinding for '" + jdtType.getFullyQualifiedName()
					+ "', but got '" + binding.toString() + "'.");
	}

	private void clearCache() {
		typeProxies.clear();
		operationProxies.clear();
		annotationProxies.clear();
		qualifiedNames.clear();
		enumerationLiteralProxies.clear();
		stringTypeBinding = null;
		classTypeBinding = null;
	}

	private JvmDeclaredType createType(IType type, ITypeBinding binding) {
		// Maintain a string builder we pass along during recursion 
		// that contains the prefix for the fully qualified name of binding instance being traversed.
		//
		StringBuilder fqn = new StringBuilder(100);
		IPackageBinding packageBinding = binding.getPackage();
		String packageName = null;
		if (packageBinding != null && !packageBinding.isUnnamed()) {
			packageName = packageBinding.getName();
			fqn.append(packageBinding.getName());
			fqn.append('.');
		}

		JvmDeclaredType result = createType(binding, type.getHandleIdentifier(), Lists.<String>newArrayList(), fqn);
		result.setPackageName(packageName);
		return result;
	}

	/**
	 * @since 2.4
	 */
	protected JvmDeclaredType createType(ITypeBinding typeBinding, String handleIdentifier, List<String> path, StringBuilder fqn) {
		if (typeBinding.isAnonymous() || typeBinding.isSynthetic())
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");

		// Creates the right type of instance based on the type of binding.
		//
		JvmGenericType jvmGenericType;
		JvmDeclaredType result;
		boolean hasFields;
		if (typeBinding.isAnnotation()) {
			jvmGenericType = null;
			result = TypesFactory.eINSTANCE.createJvmAnnotationType();
			hasFields = false;
		} else if (typeBinding.isEnum()) {
			jvmGenericType = null;
			result = TypesFactory.eINSTANCE.createJvmEnumerationType();
			hasFields = true;
		} else {
			result = jvmGenericType = TypesFactory.eINSTANCE.createJvmGenericType();
//			jvmGenericType.setInterface(typeBinding.isInterface());
			hasFields = true;
		}

		// Populate the information computed from the modifiers.
		//
		int modifiers = typeBinding.getModifiers();
		setTypeModifiers(result, modifiers);
		setVisibility(result, modifiers);

		// Determine the simple name and compose the fully qualified name and path, remembering the fqn length and path size so we can reset them.
		//
		String simpleName = typeBinding.getName();
		fqn.append(simpleName);
		int length = fqn.length();
		int size = path.size();
		path.add(simpleName);

		String qualifiedName = fqn.toString();
		result.internalSetIdentifier(qualifiedName);
		result.setSimpleName(simpleName);

		// Traverse the nested types using '$' as the qualified name separator.
		//
		fqn.append('$');
		createNestedTypes(typeBinding, result, handleIdentifier, path, fqn);

		// Traverse the methods using '.'as the qualifed name separator.
		//
		fqn.setLength(length);
		fqn.append('.');
		createMethods(typeBinding, handleIdentifier, path, fqn, result);
		
		// If there fields allowed, traverse them.
		//
		if (hasFields) {
			createFields(typeBinding, fqn, result);
		}

		// Set the super types.
		//
		setSuperTypes(typeBinding, qualifiedName, result);

		// If this is for a generic type, populate the type parameters.
		//
		if (jvmGenericType != null) {
			ITypeBinding[] typeParameterBindings = typeBinding.getTypeParameters();
			if (typeParameterBindings.length > 0) {
				InternalEList<JvmTypeParameter> typeParameters = (InternalEList<JvmTypeParameter>)jvmGenericType.getTypeParameters();
				for (ITypeBinding variable : typeParameterBindings) {
					typeParameters.addUnique(createTypeParameter(variable, result));
				}
			}
		}

		// Populate the annotation values.
		//
		createAnnotationValues(typeBinding, result);

		// Restore the path.
		//
		path.remove(size);

		return result;
	}

	/**
	 * @since 2.4
	 */
	protected void createFields(ITypeBinding typeBinding, StringBuilder qualifiedName, JvmDeclaredType result) {
		resolveMembers.start();
		IVariableBinding[] declaredFields = typeBinding.getDeclaredFields();
		if (declaredFields.length > 0) {
			int length = qualifiedName.length();
			InternalEList<JvmMember> members = (InternalEList<JvmMember>)result.getMembers();
			for (IVariableBinding field : declaredFields) {
				if (!field.isSynthetic()) {
					members.addUnique(createField(qualifiedName, field));
					qualifiedName.setLength(length);
				}
			}
		}
		resolveMembers.stop();
	}

	protected String getQualifiedName(ITypeBinding binding) {
		String qualifiedName = qualifiedNames.get(binding);
		if (qualifiedName == null) {
			qualifiedName = uriHelper.getQualifiedName(binding);
			qualifiedNames.put(binding, qualifiedName);
		}
		return qualifiedName;
	}

	protected void createAnnotationValues(IBinding annotated, JvmAnnotationTarget result) {
		try {
			resolveAnnotations.start();
			IAnnotationBinding[] annotationBindings = annotated.getAnnotations();
			if (annotationBindings.length != 0) {
				InternalEList<JvmAnnotationReference> annotations = (InternalEList<JvmAnnotationReference>)result.getAnnotations();
				for (IAnnotationBinding annotation : annotationBindings) {
					annotations.addUnique(createAnnotationReference(annotation));
				}
			}
		} catch(AbortCompilation aborted) {
			log.info("Couldn't resolve annotations of "+annotated, aborted);
		} finally {
			resolveAnnotations.stop();
		}
	}

	/**
	 * @since 2.4
	 */
	protected JvmAnnotationReference createAnnotationReference(IAnnotationBinding annotation) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		ITypeBinding annotationType = annotation.getAnnotationType();
		annotationReference.setAnnotation(createAnnotationProxy(annotationType));
		InternalEList<JvmAnnotationValue> values = (InternalEList<JvmAnnotationValue>)annotationReference.getValues();
		try {
			IMemberValuePairBinding[] allMemberValuePairs = annotation.getAllMemberValuePairs();
			for (IMemberValuePairBinding memberValuePair : allMemberValuePairs) {
				IMethodBinding methodBinding = memberValuePair.getMethodBinding();
				values.addUnique(createAnnotationValue(annotationType, memberValuePair.getValue(), methodBinding));
			}
		} catch(NullPointerException npe) {
			log.debug("NPE in IAnnotationBinding#getAllMemberValuePairs ?", npe);
			IMemberValuePairBinding[] declaredMemberValuePairs = annotation.getDeclaredMemberValuePairs();
			Set<IMethodBinding> seenMethodBindings = Sets.newHashSet();
			for (IMemberValuePairBinding memberValuePair : declaredMemberValuePairs) {
				IMethodBinding methodBinding = memberValuePair.getMethodBinding();
				seenMethodBindings.add(methodBinding);
				values.addUnique(createAnnotationValue(annotationType, memberValuePair.getValue(), methodBinding));
			}
			IMethodBinding[] allAnnotationMethods = annotationType.getDeclaredMethods();
			for(IMethodBinding methodBinding: allAnnotationMethods) {
				if (seenMethodBindings.add(methodBinding)) {
					try {
						values.addUnique(createAnnotationValue(annotationType, methodBinding.getDefaultValue(), methodBinding));
					} catch(NullPointerException nestedNPE) {
						log.debug("NPE in IMethodBinding#getDefaultValue ?", npe);
					}
				}
			}
		}
		return annotationReference;
	}

	/**
	 * @since 2.4
	 */
	protected JvmAnnotationValue createAnnotationValue(ITypeBinding annotationType, Object value, IMethodBinding methodBinding) {
		ITypeBinding originalTypeBinding = methodBinding.getReturnType();
		ITypeBinding typeBinding = originalTypeBinding;
		if (originalTypeBinding.isArray()) {
			typeBinding = typeBinding.getComponentType();
		}
		if (typeBinding.isParameterizedType())
			typeBinding = typeBinding.getErasure();
		JvmAnnotationValue annotationValue = createAnnotationValue(typeBinding, value);
//		annotationValue.setOperation(createMethodProxy(annotationType, methodBinding));  //cym comment
		return annotationValue;
	}

	/**
	 * @since 2.4
	 */
	protected JvmAnnotationValue createAnnotationValue( ITypeBinding type, Object value) {
		if (type == stringTypeBinding) {
			return createStringAnnotationValue(value);
		} else if (type == classTypeBinding) {
			return createTypeAnnotationValue(value);
		}

		if (type.isPrimitive()) {
			char key = type.getKey().charAt(0);
			switch(key) {
				case 'I':
					return createIntAnnotationValue(value);
				case 'Z':
					return createBooleanAnnotationValue(value);
				case 'J':
					return createLongAnnotationValue(value);
				case 'B':
					return createByteAnnotationValue(value);
				case 'S':
					return createShortAnnotationValue(value);
				case 'F':
					return createFloatAnnotationValue(value);
				case 'D':
					return createDoubleAnnotationValue(value);
				case 'C':
					return createCharAnnotationValue(value);
			default:
				throw new IllegalArgumentException("Unexpected primtive type: " + type);
			}
		}
		if (type.isAnnotation()) {
			return createAnnotationAnnotationValue(value);
		} else if (type.isEnum()) {
			return createEnumAnnotationValue(value);
		} 

		String qualifiedName = getQualifiedName(type);
		if (STRING_CLASS_NAME.equals(qualifiedName)) {
			stringTypeBinding = type;
			return createAnnotationValue(type, value);
		} else if (CLASS_CLASS_NAME.equals(qualifiedName)) {
			classTypeBinding = type;
			return createAnnotationValue(type, value);
		}
		throw new IllegalArgumentException("Unexpected type: " + type);
	}

	private JvmAnnotationValue createEnumAnnotationValue(Object value) {
		JvmEnumAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
		if (value != null) {
			InternalEList<JvmEnumerationLiteral> values = (InternalEList<JvmEnumerationLiteral>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					values.addUnique(createEnumLiteralProxy((IVariableBinding)element));
				}
			} else {
				values.addUnique(createEnumLiteralProxy((IVariableBinding)value));
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createAnnotationAnnotationValue(Object value) {
		JvmAnnotationAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
		if (value != null) {
			InternalEList<JvmAnnotationReference> values = (InternalEList<JvmAnnotationReference>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					values.addUnique(createAnnotationReference((IAnnotationBinding)element));
				}
			} else {
				values.addUnique(createAnnotationReference((IAnnotationBinding)value));
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createCharAnnotationValue(Object value) {
		JvmCharAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					values.addUnique(element);
				}
			} else {
				values.addUnique(value);
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createDoubleAnnotationValue(Object value) {
		JvmDoubleAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					if (element instanceof Double) {
						values.addUnique(element);
					} else {
						values.addUnique(((Number)element).doubleValue());
					}
				}
			} else if (value instanceof Double) {
				values.addUnique(value);
			} else {
				values.addUnique(((Number)value).doubleValue());
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createFloatAnnotationValue(Object value) {
		JvmFloatAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					if (element instanceof Float) {
						values.addUnique(element);
					} else {
						values.addUnique(((Number)element).floatValue());
					}
				}
			} else if (value instanceof Float) {
				values.addUnique(value);
			} else {
				values.addUnique(((Number)value).floatValue());
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createShortAnnotationValue(Object value) {
		JvmShortAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					if (element instanceof Short) {
						values.addUnique(element);
					} else {
						values.addUnique(((Number)element).shortValue());
					}
				}
			} else if (value instanceof Short) {
				values.addUnique(value);
			} else {
				values.addUnique(((Number)value).shortValue());
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createByteAnnotationValue(Object value) {
		JvmByteAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					if (element instanceof Byte) {
						values.addUnique(element);
					} else {
						values.addUnique(((Number)element).byteValue());
					}
				}
			} else if (value instanceof Byte) {
				values.addUnique(value);
			} else {
				values.addUnique(((Number)value).byteValue());
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createLongAnnotationValue(Object value) {
		JvmLongAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					if (element instanceof Long) {
						values.addUnique(element);
					} else {
						values.addUnique(((Number)element).longValue());
					}
				}
			} else if (value instanceof Long) {
				values.addUnique(value);
			} else {
				values.addUnique(((Number)value).longValue());
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createBooleanAnnotationValue(Object value) {
		JvmBooleanAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					values.addUnique(element);
				}
			} else {
				values.addUnique(value);
			}
		}
		return annotationValue;
	} 

	private JvmAnnotationValue createIntAnnotationValue(Object value) {
		JvmIntAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					if (element instanceof Integer) {
						values.addUnique(element);
					} else {
						values.addUnique(((Number)element).intValue());
					}
				}
			} else if (value instanceof Integer) {
				values.addUnique(value);
			} else {
				values.addUnique(((Number)value).intValue());
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createTypeAnnotationValue(Object value) {
		JvmTypeAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
		if (value != null) {
			InternalEList<JvmTypeReference> values = (InternalEList<JvmTypeReference>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					values.addUnique(createTypeReference((ITypeBinding)element));
				}
			} else {
				values.addUnique(createTypeReference((ITypeBinding)value));
			}
		}
		return annotationValue;
	}

	private JvmAnnotationValue createStringAnnotationValue(Object value) {
		JvmStringAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
		if (value != null) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)(InternalEList<?>)annotationValue.getValues();
			if (value instanceof Object[]) {
				for (Object element : (Object[])value) {
					values.addUnique(element);
				}
			} else {
				values.addUnique(value);
			}
		}
		return annotationValue;
	}

	protected JvmType createProxy(ITypeBinding typeBinding) {
		JvmType proxy = typeProxies.get(typeBinding);
		if (proxy == null) {
			if (typeBinding.isPrimitive()) {
				proxy = PRIMITIVE_PROXIES[typeBinding.getKey().charAt(0) - 'B'];
			} else {
				URI uri = uriHelper.getFullURI(typeBinding);
				proxy = COMMON_PROXIES.get(uri.fragment());
				if (proxy == null) {
					proxy = TypesFactory.eINSTANCE.createJvmVoid();
					((InternalEObject)proxy).eSetProxyURI(uri);
				}
			}
			typeProxies.put(typeBinding, proxy);
		}
		return proxy;
	}

	/**
	 * @since 2.4
	 */
	protected JvmOperation createMethodProxy(ITypeBinding typeBinding, IMethodBinding method) {
		JvmOperation proxy = operationProxies.get(method);
		if (proxy == null) {
			String methodName = method.getName();
			URI uri = uriHelper.getFullURI(typeBinding, methodName);
			JvmOperation[] jvmOperations = ANNOTATION_METHOD_PROXIES.get(uri.lastSegment());
			if (jvmOperations != null) {
				for (JvmOperation jvmOperation : jvmOperations) {
					String fragment = ((InternalEObject)jvmOperation).eProxyURI().fragment();
					if (fragment.startsWith(methodName, fragment.length() - methodName.length() - 2)) {
						operationProxies.put(method, jvmOperation);
						return jvmOperation;
					}
				}
			}
			proxy = TypesFactory.eINSTANCE.createJvmOperation();
			((InternalEObject)proxy).eSetProxyURI(uri);
			operationProxies.put(method, proxy);
		}
		return proxy;
	}

	protected JvmEnumerationLiteral createEnumLiteralProxy(IVariableBinding binding) {
		JvmEnumerationLiteral proxy = enumerationLiteralProxies.get(binding);
		if (proxy == null) {
			proxy = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
			URI uri = uriHelper.getFullURI(binding);
			((InternalEObject)proxy).eSetProxyURI(uri);
			enumerationLiteralProxies.put(binding, proxy);
		}
		return proxy;
	}

	protected JvmAnnotationType createAnnotationProxy(ITypeBinding annotation) {
		JvmAnnotationType proxy = annotationProxies.get(annotation);
		if (proxy == null) {
			URI uri = uriHelper.getFullURI(annotation);
			proxy = ANNOTATION_PROXIES.get(uri.fragment());
			if (proxy == null) {
				proxy = TypesFactory.eINSTANCE.createJvmAnnotationType();
				((InternalEObject)proxy).eSetProxyURI(uri);
			}
			annotationProxies.put(annotation, proxy);
		}
		return proxy;
	}

	/**
	 * @since 2.4
	 */
	protected void setSuperTypes(ITypeBinding binding, String qualifiedName, JvmDeclaredType result) {
		ITypeBinding superclass = binding.getSuperclass();
		InternalEList<JvmTypeReference> superTypes = (InternalEList<JvmTypeReference>)result.getSuperTypes();
		if (superclass != null) {
			superTypes.addUnique(createTypeReference(superclass));
		} 
		for (ITypeBinding intf : binding.getInterfaces()) {
			superTypes.addUnique(createTypeReference(intf));
		}
		if (superTypes.isEmpty() && !OBJECT_CLASS_NAME.equals(qualifiedName)) {
			superTypes.addUnique(createObjectClassReference());
		}
	}

	private String[] subpath(List<String> path) {
		int size = path.size();
		if (size < 2) {
			return EMPTY_STRING_ARRAY;
		} 
		String[] result = new String[size - 1];
		for (int i = 1; i < size; ++i) {
			result[i - 1] = path.get(i);
		}
		return result;
	}

	/**
	 * @since 2.4
	 */
	protected void createMethods(ITypeBinding typeBinding, String handleIdentifier, List<String> path, StringBuilder qualifiedName, JvmDeclaredType result) {
		resolveMembers.start();
		IMethodBinding[] declaredMethods = typeBinding.getDeclaredMethods();
		if (declaredMethods.length > 0) {
			int length = qualifiedName.length();
			InternalEList<JvmMember> members = (InternalEList<JvmMember>)result.getMembers();
			String[] subpath = subpath(path);
			for (IMethodBinding method : declaredMethods) {
				if (!method.isSynthetic() && !"<clinit>".equals(method.getName())) {
					if (method.isConstructor()) {
						members.addUnique(createConstructor(qualifiedName, handleIdentifier, subpath, method));
					} else {
						JvmOperation operation = createOperation(qualifiedName, handleIdentifier, subpath, method);
						if (typeBinding.isAnnotation()) {
							setDefaultValue(operation, method);
						}
						members.addUnique(operation);
					}
					qualifiedName.setLength(length);
				}
			}
		}
		resolveMembers.stop();
	}

	private void setDefaultValue(JvmOperation operation, IMethodBinding method) {
		Object defaultValue = method.getDefaultValue();
		if (defaultValue != null) {
			ITypeBinding originalTypeBinding = method.getReturnType();
			ITypeBinding typeBinding = originalTypeBinding;
			if (originalTypeBinding.isArray()) {
				typeBinding = typeBinding.getComponentType();
			}
			if (typeBinding.isParameterizedType())
				typeBinding = typeBinding.getErasure();
			JvmAnnotationValue annotationValue = createAnnotationValue(typeBinding, defaultValue);
			operation.setDefaultValue(annotationValue);
//			annotationValue.setOperation(operation);  //cym comment
		}
	}

	/**
	 * @since 2.4
	 */
	protected void createNestedTypes(ITypeBinding typeBinding, JvmDeclaredType result, String handleIdentifier, List<String> path, StringBuilder fqn) {
		resolveMembers.start();
		ITypeBinding[] declaredTypes = typeBinding.getDeclaredTypes();
		if (declaredTypes.length > 0) {
			InternalEList<JvmMember> members = (InternalEList<JvmMember>)result.getMembers();
			int length = fqn.length();
			for (ITypeBinding declaredType : declaredTypes) {
				if (!declaredType.isAnonymous() && !declaredType.isSynthetic()) {
					members.addUnique(createType(declaredType, handleIdentifier, path, fqn));
					fqn.setLength(length);
				}
			}
		}
		resolveMembers.stop();
	}

	/**
	 * @since 2.4
	 */
	protected void setTypeModifiers(JvmDeclaredType result, int modifiers) {
		result.setAbstract(Modifier.isAbstract(modifiers));
		result.setStatic(Modifier.isStatic(modifiers));
		if (!(result instanceof JvmEnumerationType))
			result.setFinal(Modifier.isFinal(modifiers));
	}

	protected JvmTypeParameter createTypeParameter(ITypeBinding parameter, JvmMember container) {
		resolveTypeParams.start();
		JvmTypeParameter result = TypesFactory.eINSTANCE.createJvmTypeParameter();
		result.setName(parameter.getName());
		InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>)result.getConstraints();
		ITypeBinding[] typeBounds = parameter.getTypeBounds();
		if (typeBounds.length != 0) {
			for (ITypeBinding bound : typeBounds) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				upperBound.setTypeReference(createTypeReference(bound));
				constraints.addUnique(upperBound);
			}
		} else {
			JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
			upperBound.setTypeReference(createObjectClassReference());
			constraints.addUnique(upperBound);
		}
		resolveTypeParams.stop();
		return result;
	}

	protected JvmTypeReference createTypeReference(ITypeBinding typeBinding) {
		if (typeBinding.isArray()) {
			ITypeBinding componentType = typeBinding.getComponentType();
			JvmTypeReference componentTypeReference = createTypeReference(componentType);
			JvmGenericArrayTypeReference typeReference = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
			typeReference.setComponentType(componentTypeReference);
			return typeReference;
		}
		ITypeBinding[] typeArguments = typeBinding.getTypeArguments();
		JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		if (typeArguments.length != 0) {
			ITypeBinding erasure = typeBinding.getErasure();
			result.setType(createProxy(erasure));
			InternalEList<JvmTypeReference> arguments = (InternalEList<JvmTypeReference>)result.getArguments();
			for (int i = 0; i < typeArguments.length; i++) {
				JvmTypeReference argument = createTypeArgument(typeArguments[i]);
				arguments.addUnique(argument);
			}
		} else {
			result.setType(createProxy(typeBinding));
		}
		return result;
	}

	/**
	 * @since 2.4
	 */
	protected JvmTypeReference createObjectClassReference() {
		JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		result.setType(OBJECT_CLASS_PROXY);
		return result;
	}

	protected JvmTypeReference createTypeArgument(ITypeBinding argument) {
		if (argument.isWildcardType()) {
			JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
			InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>)result.getConstraints();
			JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
			ITypeBinding bound = argument.getBound();
			if (argument.isUpperbound()) {
				JvmTypeReference reference = createTypeReference(bound);
				upperBound.setTypeReference(reference);
				constraints.addUnique(upperBound);
			} else {
				JvmTypeReference objectReference = createObjectClassReference();
				upperBound.setTypeReference(objectReference);
				constraints.addUnique(upperBound);
				if (bound != null) {
					JvmLowerBound lowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
					JvmTypeReference reference = createTypeReference(bound);
					lowerBound.setTypeReference(reference);
					constraints.addUnique(lowerBound);
				}
			}
			return result;
		} else {
			return createTypeReference(argument);
		}
	}

	/**
	 * @since 2.4
	 */
	protected JvmField createField(StringBuilder typeName, IVariableBinding field) {
		JvmField result;
		if (!field.isEnumConstant())
			result = TypesFactory.eINSTANCE.createJvmField();
		else
			result = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		String name = field.getName();
		result.internalSetIdentifier(typeName.append(name).toString());
		result.setSimpleName(name);
		int modifiers = field.getModifiers();
		result.setFinal(Modifier.isFinal(modifiers));
		result.setStatic(Modifier.isStatic(modifiers));
		result.setTransient(Modifier.isTransient(modifiers));
		result.setVolatile(Modifier.isVolatile(modifiers));
		setVisibility(result, modifiers);
		result.setType(createTypeReference(field.getType()));
		createAnnotationValues(field, result);
		return result;
	}

	
	// cym modified
	protected void setVisibility(JvmMember result, int modifiers) {
		if (Modifier.isPrivate(modifiers))
			result.setVisibility(JvmVisibility.PRIVATE);
//		else if (Modifier.isProtected(modifiers))
//			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(modifiers))
			result.setVisibility(JvmVisibility.PUBLIC);
//		else
//			result.setVisibility(JvmVisibility.DEFAULT);
	}

	/**
	 * @since 2.4
	 */
	protected JvmConstructor createConstructor(StringBuilder qualifiedName, String handleIdentifier, String[] path, IMethodBinding method) {
		JvmConstructor result = TypesFactory.eINSTANCE.createJvmConstructor();
		enhanceGenericDeclaration(result, method.getTypeParameters());
		enhanceExecutable(qualifiedName, handleIdentifier, path, result, method);
		createAnnotationValues(method, result);
		return result;
	}
	
	/**
	 * @since 2.4
	 */
	protected void enhanceExecutable(StringBuilder fqn, String handleIdentifier, String[] path, JvmExecutable result, IMethodBinding method) {
		String name = method.getName();
		fqn.append(name);
		fqn.append('(');
		ITypeBinding[] parameterTypes = method.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0)
				fqn.append(',');
			fqn.append(getQualifiedName(parameterTypes[i]));
		}
		fqn.append(')');
		result.internalSetIdentifier(fqn.toString());
		result.setSimpleName(name);
		setVisibility(result, method.getModifiers());

		if (parameterTypes.length > 0) {
			result.setVarArgs(method.isVarargs());
			String[] parameterNames = null;

			// If the method is derived from source, we can efficiently determine the parameter names now.
			//
			ITypeBinding declaringClass = method.getDeclaringClass();
			if (declaringClass.isFromSource()) {
				parameterNames = getParameterNamesFromSource(fqn, method);
			} else {
				// Use the key to determine the signature for the method.
				//
				SegmentSequence signaturex = getSignatureAsSegmentSequence(method);
				// String x = "Lx;.x" + key.substring(start, end + 1); //.replace('/', '.');
				if (method.isConstructor() && declaringClass.isEnum()) {
					ParameterNameInitializer initializer = new EnumConstructorParameterNameInitializer(workingCopyOwner, result, handleIdentifier, path, name, signaturex);
					((JvmExecutableImplCustom)result).setParameterNameInitializer(initializer);
				} else {
					ParameterNameInitializer initializer = jdtCompliance.createParameterNameInitializer(method, workingCopyOwner, result, handleIdentifier, path, name, signaturex);
					((JvmExecutableImplCustom)result).setParameterNameInitializer(initializer);
				}
			}

			setParameterNamesAndAnnotations(method, parameterTypes, parameterNames, result);
		}

		ITypeBinding[] exceptionTypes = method.getExceptionTypes();
		if (exceptionTypes.length > 0) {
			InternalEList<JvmTypeReference> exceptions = (InternalEList<JvmTypeReference>)result.getExceptions();
			for (ITypeBinding exceptionType : exceptionTypes) {
				exceptions.addUnique(createTypeReference(exceptionType));
			}
		}
	}

	private void setParameterNamesAndAnnotations(IMethodBinding method, ITypeBinding[] parameterTypes,
			String[] parameterNames, JvmExecutable result) {
		InternalEList<JvmFormalParameter> parameters = (InternalEList<JvmFormalParameter>)result.getParameters();
		for (int i = 0; i < parameterTypes.length; i++) {
			IAnnotationBinding[] parameterAnnotations;
			try {
				parameterAnnotations = method.getParameterAnnotations(i);
			} catch(AbortCompilation aborted) {
				parameterAnnotations = null;
			}
			ITypeBinding parameterType = parameterTypes[i];
			String parameterName = parameterNames == null ? null /* lazy */ : i < parameterNames.length ? parameterNames[i] : "arg" + i;
			JvmFormalParameter formalParameter = createFormalParameter(parameterType, parameterName, parameterAnnotations);
			parameters.addUnique(formalParameter);
		}
	}

	private SegmentSequence getSignatureAsSegmentSequence(IMethodBinding method) {
		String key = method.getKey();
		int start = key.indexOf('(');
		int end = key.lastIndexOf(')');
		SegmentSequence signaturex = SegmentSequence.create(";", key.substring(start + 1, end));
		return signaturex;
	}

	private String[] getParameterNamesFromSource(StringBuilder fqn, IMethodBinding method) {
		String[] parameterNames;
		parameterNames = EMPTY_STRING_ARRAY;
		IMethod sourceMethod = null;
		try {
			sourceMethod = (IMethod)method.getJavaElement();
		} catch (IllegalArgumentException ex) {
			// If we can't locate the element now, we'll never be able to locate it, so we can't determine parameter names.
			//
			log.debug("Cannot locate java source method for " + fqn, ex);
		}
		if (sourceMethod != null) {
			try {
				parameterNames = sourceMethod.getParameterNames();
			} catch (JavaModelException ex) {
				log.error("Source method parameter names cannot be determined for " + fqn, ex);
			}
		}
		return parameterNames;
	}

	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @since 2.4
	 */
	public static class ParameterNameInitializer implements Runnable {
		private final static Logger log = Logger.getLogger(JdtBasedTypeFactory.ParameterNameInitializer.class);
		private StoppedTask resolveParamNames = Stopwatches.forTask("resolve param names (JdtBasedTypeFactory)");
		private WorkingCopyOwner workingCopyOwner;
		private JvmExecutable executable;
		private String handleIdentifier; 
		private String[] path; 
		private String name; 
		private CharSequence signature;

		/**
		 * @noreference This constructor is not intended to be referenced by clients.
		 */
		protected ParameterNameInitializer(WorkingCopyOwner workingCopyOwner, JvmExecutable executable, String handleIdentifier, String[] path, String name, CharSequence signature) {
			super();
			this.workingCopyOwner = workingCopyOwner;
			this.executable = executable;
			this.handleIdentifier = handleIdentifier;
			this.path = path;
			this.name = name;
			this.signature = signature;
		}

		public void run() {
			try {
				resolveParamNames.start();
				
				// Use the handle to find the top level type and then use the path the traverse to the correct nested type.
				//
				IType type = findTypeByHandleIdentifier();

				List<JvmFormalParameter> parameters = executable.getParameters();
				if (type != null) {
					IMethod javaMethod = findJavaMethod(type);
					int numberOfParameters = javaMethod.getNumberOfParameters();
					if (numberOfParameters != 0) {
						try {
							setParameterNames(javaMethod, parameters);
							return;
						} catch (JavaModelException ex) {
							if (!ex.isDoesNotExist())
								log.warn("IMethod.getParameterNames failed", ex);
						}
					}
				}

				// We generally should not ever get here.
				//
				synthesizeNames(parameters);
			} finally {
				resolveParamNames.stop();
			}
		}

		/**
		 * @since 2.4
		 */
		protected void setParameterNames(IMethod javaMethod, List<JvmFormalParameter> parameters)
				throws JavaModelException {
			String[] parameterNames = javaMethod.getParameterNames();
			int size = parameters.size();
			if (size != parameterNames.length) {
				throw new IllegalStateException("unmatching arity for java method "+javaMethod.toString()+" and "+getExecutable().getIdentifier());
			}
			for (int i = 0; i < parameterNames.length; i++) {
				String string = parameterNames[i];
				parameters.get(i).setName(string);
			}
		}

		private IMethod findJavaMethod(IType type) {
			// Locate the method from its signature.
			//
			String[] parameterTypes = Signature.getParameterTypes(new BindingKey("Lx;.x(" + signature + ")").toSignature());
			IMethod javaMethod = type.getMethod(name, parameterTypes);

			// If the method doesn't exist and this is a nested type...
			//
			if (!javaMethod.exists() && type.getDeclaringType() != null) {
				// This special case handles what appears to be a JDT bug 
				// that sometimes it knows when there are implicit constructor arguments for nested types and sometimes it doesn't.
				// Infer one more initial parameter type and locate the method based on that.
				//
				String[] augmented = new String[parameterTypes.length + 1];
				System.arraycopy(parameterTypes, 0, augmented, 1, parameterTypes.length);
				String first = Signature.createTypeSignature(type.getDeclaringType().getFullyQualifiedName(), true);
				augmented[0] = first;
				javaMethod = type.getMethod(name, augmented);
			}
			return javaMethod;
		}
		
		/**
		 * @since 2.4
		 */
		protected JvmExecutable getExecutable() {
			return executable;
		}

		private void synthesizeNames(List<JvmFormalParameter> parameters) {
			int i = 0;
			for (JvmFormalParameter p : parameters) {
				if (p.getName() == null) {
					p.setName("arg"+i);
				}
				i++;
			}
		}

		private IType findTypeByHandleIdentifier() {
			IType type = (IType)JavaCore.create(handleIdentifier, workingCopyOwner);
			if (type != null) {
				for (String typeName : path) {
					type = type.getType(typeName);
					if (type == null) {
						break;
					}
				}
			}
			return type;
		}
		
	}
	
	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @since 2.4
	 */
	protected static class EnumConstructorParameterNameInitializer extends ParameterNameInitializer {

		protected EnumConstructorParameterNameInitializer(WorkingCopyOwner workingCopyOwner, JvmExecutable executable,
				String handleIdentifier, String[] path, String name, CharSequence signature) {
			super(workingCopyOwner, executable, handleIdentifier, path, name, signature);
		}
		
		@Override
		protected void setParameterNames(IMethod javaMethod, List<JvmFormalParameter> parameters)
				throws JavaModelException {
			String[] parameterNames = javaMethod.getParameterNames();
			if (parameterNames.length == parameters.size()) {
				// classes compiled with javaC look different thus here we find the correct number of arguments
				// we have to use the super implementation
				super.setParameterNames(javaMethod, parameters);
			} else {
				int size = parameters.size();
				if (size + 2 != parameterNames.length) {
					throw new IllegalStateException("unmatching arity for java method "+javaMethod.toString()+" and "+getExecutable().getIdentifier());
				}
				for (int i = 2; i < parameterNames.length; i++) {
					String string = parameterNames[i];
					parameters.get(i - 2).setName(string);
				}
			}
		}
		
	}

	protected void enhanceGenericDeclaration(JvmExecutable result, ITypeBinding[] parameters) {
		if (parameters.length > 0) {
			InternalEList<JvmTypeParameter> typeParameters = (InternalEList<JvmTypeParameter>)result.getTypeParameters();
			for (ITypeBinding parameter : parameters) {
				typeParameters.addUnique(createTypeParameter(parameter, result));
			}
		}
	}

	/**
	 * @since 2.4
	 */
	protected JvmOperation createOperation(StringBuilder qualifiedName, String handleIdentifier, String[] path, IMethodBinding method) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		enhanceGenericDeclaration(result, method.getTypeParameters());
		enhanceExecutable(qualifiedName, handleIdentifier, path, result, method);
		int modifiers = method.getModifiers();
		result.setAbstract(Modifier.isAbstract(modifiers));
		result.setFinal(Modifier.isFinal(modifiers));
		result.setStatic(Modifier.isStatic(modifiers));
		result.setStrictFloatingPoint(Modifier.isStrictfp(modifiers));
		result.setSynchronized(Modifier.isSynchronized(modifiers));
		result.setNative(Modifier.isNative(modifiers));
		result.setReturnType(createTypeReference(method.getReturnType()));
		createAnnotationValues(method, result);
		return result;
	}

	protected JvmFormalParameter createFormalParameter(ITypeBinding parameterType, String paramName, IAnnotationBinding[] annotations) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		if (paramName != null)
			result.setName(paramName);
		result.setParameterType(createTypeReference(parameterType));
		if (annotations != null && annotations.length > 0) {
			InternalEList<JvmAnnotationReference> parameterAnnotations = (InternalEList<JvmAnnotationReference>)result.getAnnotations();
			for (IAnnotationBinding annotation : annotations) {
				parameterAnnotations.addUnique(createAnnotationReference(annotation));
			}
		}
		return result;
	}
}
