/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.featurecalls;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.util.Primitives;
import org.eclipse.xtext.util.ReflectionUtil;
import org.summer.dsl.xbase.lib.ArrayExtensions;
import org.summer.dsl.xbase.lib.ArrayLiterals;
import org.summer.dsl.xbase.lib.BigDecimalExtensions;
import org.summer.dsl.xbase.lib.BigIntegerExtensions;
import org.summer.dsl.xbase.lib.BooleanExtensions;
import org.summer.dsl.xbase.lib.ByteExtensions;
import org.summer.dsl.xbase.lib.CharacterExtensions;
import org.summer.dsl.xbase.lib.CollectionExtensions;
import org.summer.dsl.xbase.lib.CollectionLiterals;
import org.summer.dsl.xbase.lib.ComparableExtensions;
import org.summer.dsl.xbase.lib.DoubleExtensions;
import org.summer.dsl.xbase.lib.FloatExtensions;
import org.summer.dsl.xbase.lib.FunctionExtensions;
import org.summer.dsl.xbase.lib.Functions;
import org.summer.dsl.xbase.lib.InputOutput;
import org.summer.dsl.xbase.lib.IntegerExtensions;
import org.summer.dsl.xbase.lib.IterableExtensions;
import org.summer.dsl.xbase.lib.IteratorExtensions;
import org.summer.dsl.xbase.lib.ListExtensions;
import org.summer.dsl.xbase.lib.LongExtensions;
import org.summer.dsl.xbase.lib.MapExtensions;
import org.summer.dsl.xbase.lib.ObjectExtensions;
import org.summer.dsl.xbase.lib.ProcedureExtensions;
import org.summer.dsl.xbase.lib.Procedures;
import org.summer.dsl.xbase.lib.ShortExtensions;
import org.summer.dsl.xbase.lib.StringExtensions;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * use {@link org.summer.dsl.xbase.scoping.batch.ImplicitlyImportedTypes} instead.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated()
public class StaticImplicitMethodsFeatureForTypeProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	@Singleton
	public static class ExtensionClassNameProvider {
	
		private Collection<String> literalClassNames;
		private Map<String, Collection<String>> extensionClassNames;
		
		public ExtensionClassNameProvider() {
		}

		protected Map<String, Collection<String>> computeExtensionClassNames() {
			return denormalize(simpleComputeExtensionClasses());
		}
		
		protected Map<String, Collection<String>> denormalize(Multimap<Class<?>, Class<?>> classMapping) {
			Multimap<String, String> result = LinkedHashMultimap.create();
			for(Map.Entry<Class<?>, Class<?>> entry: classMapping.entries()) {
				Class<?> key = entry.getKey();
				Class<?> keyObjectType = ReflectionUtil.getObjectType(key);
				Class<?> value = entry.getValue();
				for(Method method: value.getDeclaredMethods()) {
					if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length > 0) {
						Class<?> paramType = method.getParameterTypes()[0];
						Class<?> paramObjectType = ReflectionUtil.getObjectType(paramType);		
						if (keyObjectType.isAssignableFrom(paramObjectType)) {
							result.put(paramObjectType.getCanonicalName(), value.getCanonicalName());
						}
					}
				}
			}
			return ImmutableMultimap.copyOf(result).asMap();
		}

		protected Collection<String> getLiteralClassNames() {
			if (literalClassNames == null) {
				literalClassNames = computeLiteralClassNames();
			}
			return literalClassNames;
		}
		
		protected Map<String, Collection<String>> getExtensionClassNames() {
			if (extensionClassNames == null) {
				this.extensionClassNames = computeExtensionClassNames();
			}
			return extensionClassNames;
		}
		
		protected Collection<String> computeLiteralClassNames() {
			return Lists.newArrayList(
					ArrayLiterals.class.getName(),
					CollectionLiterals.class.getName(),
					InputOutput.class.getName()
			);
		}
		
		protected Multimap<Class<?>, Class<?>> simpleComputeExtensionClasses() {
			Multimap<Class<?>, Class<?>> result = ArrayListMultimap.create();
			
			//cym comment
//			result.put(String.class, StringExtensions.class);
//			result.put(Double.TYPE, DoubleExtensions.class);
//			result.put(Float.TYPE, FloatExtensions.class);
//			result.put(Long.TYPE, LongExtensions.class);
//			result.put(Integer.TYPE, IntegerExtensions.class);
//			result.put(Character.TYPE, CharacterExtensions.class);
//			result.put(Short.TYPE, ShortExtensions.class);
//			result.put(Byte.TYPE, ByteExtensions.class);
//			result.put(Boolean.TYPE, BooleanExtensions.class);
//			result.put(double[].class, ArrayExtensions.class);
//			result.put(float[].class, ArrayExtensions.class);
//			result.put(long[].class, ArrayExtensions.class);
//			result.put(int[].class, ArrayExtensions.class);
//			result.put(char[].class, ArrayExtensions.class);
//			result.put(short[].class, ArrayExtensions.class);
//			result.put(byte[].class, ArrayExtensions.class);
//			result.put(boolean[].class, ArrayExtensions.class);
//			result.put(BigInteger.class, BigIntegerExtensions.class);
//			result.put(BigDecimal.class, BigDecimalExtensions.class);
//			result.put(Comparable.class, ComparableExtensions.class);
//			result.put(Object.class, ObjectExtensions.class);
//			result.put(List.class, ListExtensions.class);
//			result.put(Collection.class, CollectionExtensions.class);
//			result.put(Map.class, CollectionExtensions.class);
//			result.put(Map.class, MapExtensions.class);
//			result.put(Iterable.class, IterableExtensions.class);
//			result.put(Iterator.class, IteratorExtensions.class);
//			result.put(Functions.Function0.class, FunctionExtensions.class);
//			result.put(Functions.Function1.class, FunctionExtensions.class);
//			result.put(Functions.Function2.class, FunctionExtensions.class);
//			result.put(Functions.Function3.class, FunctionExtensions.class);
//			result.put(Functions.Function4.class, FunctionExtensions.class);
//			result.put(Functions.Function5.class, FunctionExtensions.class);
//			result.put(Functions.Function6.class, FunctionExtensions.class);
//			result.put(Procedures.Procedure0.class, ProcedureExtensions.class);
//			result.put(Procedures.Procedure1.class, ProcedureExtensions.class);
//			result.put(Procedures.Procedure2.class, ProcedureExtensions.class);
//			result.put(Procedures.Procedure3.class, ProcedureExtensions.class);
//			result.put(Procedures.Procedure4.class, ProcedureExtensions.class);
//			result.put(Procedures.Procedure5.class, ProcedureExtensions.class);
//			result.put(Procedures.Procedure6.class, ProcedureExtensions.class);
			return result;
		}
	}

	@Inject
	private Primitives primitives;
	
	@Inject
	private ExtensionClassNameProvider extensionClassProvider;
	
	@Override
	protected Map<JvmTypeReference, Collection<String>> getVisibleTypesContainingStaticMethods(Iterable<JvmTypeReference> hierarchy) {
		if (hierarchy == null) {
			return Collections.singletonMap(null, getLiteralClassNames());
		}
		Iterator<JvmTypeReference> iterator = hierarchy.iterator();
		if (!iterator.hasNext())
			return Collections.singletonMap(null, getLiteralClassNames());
		Map<JvmTypeReference, Collection<String>> result = Maps.newLinkedHashMap();
		while(iterator.hasNext()) {
			JvmTypeReference reference = iterator.next();
			if (reference.getType() != null) {
				JvmTypeReference wrapped = primitives.asWrapperTypeIfPrimitive(reference);
				String typeName = wrapped.getType().getQualifiedName('.');
				Collection<String> extensionTypes = getExtensionClassNames().get(typeName);
				if (extensionTypes != null) {
					result.put(reference, extensionTypes);
				}
			} else {
				if (result.isEmpty() && !iterator.hasNext()) {
					return Collections.singletonMap(null, getLiteralClassNames()); 
				}
			}
		}
		return result;
	}

	protected Collection<String> getLiteralClassNames() {
		return extensionClassProvider.getLiteralClassNames();
	}
	
	protected Map<String, Collection<String>> getExtensionClassNames() {
		return extensionClassProvider.getExtensionClassNames();
	}
	
}
