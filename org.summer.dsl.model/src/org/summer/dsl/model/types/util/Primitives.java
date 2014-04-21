/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import static com.google.common.collect.Iterables.*;

import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMultiTypeReference;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class Primitives {
	
	@Inject
	private TypeReferences typeReferences;
	
	public static enum Primitive {
		Byte,Short,
//		Char,
		Int,
//		Long,
		Float,
		Double,
//		Void, 
		Boolean
	}
	
	public Primitive primitiveKind(JvmPrimitiveType primitiveType) {
		final String name = primitiveType.getIdentifier();
		if (Boolean.TYPE.getName().equals(name)) {
			return Primitive.Boolean;
		}
		if (Integer.TYPE.getName().equals(name)) {
			return Primitive.Int;
		}
		if (Byte.TYPE.getName().equals(name)) {
			return Primitive.Byte;
		}
		if (Short.TYPE.getName().equals(name)) {
			return Primitive.Short;
		}
//		if (Character.TYPE.getName().equals(name)) {
//			return Primitive.Char;
//		}
//		if (Long.TYPE.getName().equals(name)) {
//			return Primitive.Long;
//		}
		if (Float.TYPE.getName().equals(name)) {
			return Primitive.Float;
		}
		if (Double.TYPE.getName().equals(name)) {
			return Primitive.Double;
		}
//		if (Void.TYPE.getName().equals(name)) {
//			return Primitive.Void;
//		}
		throw new IllegalArgumentException("Unkown primitive "+name);
	}
	
	public JvmTypeReference asWrapperTypeIfPrimitive(JvmTypeReference primitive) {
		if (primitive == null || !isPrimitive(primitive)) {
			return primitive;
		}
		final JvmType wrapperType = getWrapperType((JvmPrimitiveType) primitive.getType());
		if (wrapperType == null)
			return primitive;
		return typeReferences.createTypeRef(wrapperType);
	}
	
	//cym comment
//	public JvmType getWrapperType(JvmPrimitiveType primitive) {
//		switch (primitiveKind(primitive)) {
//			case Byte :
//				return getType(Byte.class, primitive);
//			case Short :
//				return getType(Short.class, primitive);
//			case Char :
//				return getType(Character.class, primitive);
//			case Int :
//				return getType(Integer.class, primitive);
//			case Long :
//				return getType(Long.class, primitive);
//			case Float :
//				return getType(Float.class, primitive);
//			case Double :
//				return getType(Double.class, primitive);
//			case Boolean :
//				return getType(Boolean.class, primitive);
//			case Void :
//				return getType(Void.class, primitive);
//			default :
//				throw new IllegalArgumentException("Not a primitive : "+primitive);
//		}
//	}
	
	public JvmType getWrapperType(JvmPrimitiveType primitive) {
		switch (primitiveKind(primitive)) {
			case Byte :
				return BuildInTypes.getInstance().getByteType(primitive.eResource());
			case Short :
				return BuildInTypes.getInstance().getByteType(primitive.eResource());
//			case Char :
//				return BuildInTypes.getInstance().getByteType(primitive.eResource());
			case Int :
				return BuildInTypes.getInstance().getByteType(primitive.eResource());
//			case Long :
//				return BuildInTypes.getInstance().getByteType(primitive.eResource());
			case Float :
				return BuildInTypes.getInstance().getByteType(primitive.eResource());
			case Double :
				return BuildInTypes.getInstance().getByteType(primitive.eResource());
			case Boolean :
				return BuildInTypes.getInstance().getByteType(primitive.eResource());
//			case Void :
//				return BuildInTypes.getInstance().getByteType(primitive.eResource());
			default :
				throw new IllegalArgumentException("Not a primitive : "+primitive);
		}
	}
	
	public JvmType getPrimitiveTypeIfWrapper(JvmDeclaredType type) {
		if (typeReferences.is(type, Byte.class)) {
			return typeReferences.findDeclaredType(Byte.TYPE, type);
		} else if (typeReferences.is(type, Short.class)) {
			return typeReferences.findDeclaredType(Short.TYPE, type);
//		} else if (typeReferences.is(type, Character.class)) {
//			return typeReferences.findDeclaredType(Character.TYPE, type);
		} else if (typeReferences.is(type, Integer.class)) {
			return typeReferences.findDeclaredType(Integer.TYPE, type);
//		} else if (typeReferences.is(type, Long.class)) {
//			return typeReferences.findDeclaredType(Long.TYPE, type);
		} else if (typeReferences.is(type, Float.class)) {
			return typeReferences.findDeclaredType(Float.TYPE, type);
		} else if (typeReferences.is(type, Double.class)) {
			return typeReferences.findDeclaredType(Double.TYPE, type);
		} else if (typeReferences.is(type, Boolean.class)) {
			return typeReferences.findDeclaredType(Boolean.TYPE, type);
//		} else if (typeReferences.is(type, Void.class)) {
//			return typeReferences.findDeclaredType(Void.TYPE, type);
		}
		return null;
	}

	protected JvmType getType(Class<?> class1, Notifier context) {
		return typeReferences.findDeclaredType(class1, context);
	}
	
	public boolean isPrimitive(JvmTypeReference type) {
		return type!=null && type.getType() instanceof JvmPrimitiveType && !type.getType().eIsProxy();
	}

	public boolean isWrapperType(JvmTypeReference type) {
		JvmTypeReference result = asPrimitiveIfWrapperType(type);
		return result != type && result != null;
	}

	public boolean isWrapperType(JvmType type) {
		if (typeReferences.is(type, BuildInTypes.getInstance().getBooleanType(type.eResource()), type)) {
			return true;
		} else if (typeReferences.is(type, Short.class)) {
			return true;
//		} else if (typeReferences.is(type, Character.class)) {
//			return true;
		} else if (typeReferences.is(type, Integer.class)) {
			return true;
//		} else if (typeReferences.is(type, Long.class)) {
//			return true;
		} else if (typeReferences.is(type, Float.class)) {
			return true;
		} else if (typeReferences.is(type, Double.class)) {
			return true;
		} else if (typeReferences.is(type, Boolean.class)) {
			return true;
//		} else if (typeReferences.is(type, Void.class)) {
//			return true;
		}
		if (type instanceof JvmTypeParameter) {
			EList<JvmTypeConstraint> constraints = ((JvmTypeParameter)type).getConstraints();
			for(JvmUpperBound upperBound: filter(constraints, JvmUpperBound.class)) {
				JvmTypeReference upperBoundType = upperBound.getTypeReference();
				if (isWrapperType(upperBoundType))
					return true;
			}
		}
		return false;
	}
	
	public JvmTypeReference asPrimitiveIfWrapperType(JvmTypeReference type) {
		return new AbstractTypeReferenceVisitor.InheritanceAware<JvmTypeReference>() {

			private Set<JvmType> visiting = Sets.newHashSetWithExpectedSize(2);
			
			@Override
			public JvmTypeReference doVisitMultiTypeReference(JvmMultiTypeReference reference) {
				for(JvmTypeReference ref: reference.getReferences()) {
					JvmTypeReference refAsPrimitiveIfWrapper = visit(ref);
					if(refAsPrimitiveIfWrapper != ref)
						return refAsPrimitiveIfWrapper;
				}
				return reference;
			}
			
			//cym comment
//			@Override
//			public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference type) {
//				if(type.getType() instanceof JvmTypeParameter && visiting.add(type.getType())) {
//					EList<JvmTypeConstraint> constraints = ((JvmTypeParameter)type.getType()).getConstraints();
//					for(JvmUpperBound upperBound: filter(constraints, JvmUpperBound.class)) {
//						JvmTypeReference upperBoundType = upperBound.getTypeReference();
//						JvmTypeReference asPrimitive = visit(upperBoundType);
//						if(asPrimitive != upperBoundType) 
//							return asPrimitive;
//					}
//					return type;
//				} else if (typeReferences.is(type, Byte.class)) {
//					return typeReferences.getTypeForName(Byte.TYPE, type.getType());
//				} else if (typeReferences.is(type, Short.class)) {
//					return typeReferences.getTypeForName(Short.TYPE, type.getType());
////				} else if (typeReferences.is(type, Character.class)) {
////					return typeReferences.getTypeForName(Character.TYPE, type.getType());
//				} else if (typeReferences.is(type, Integer.class)) {
//					return typeReferences.getTypeForName(Integer.TYPE, type.getType());
////				} else if (typeReferences.is(type, Long.class)) {
////					return typeReferences.getTypeForName(Long.TYPE, type.getType());
//				} else if (typeReferences.is(type, Float.class)) {
//					return typeReferences.getTypeForName(Float.TYPE, type.getType());
//				} else if (typeReferences.is(type, Double.class)) {
//					return typeReferences.getTypeForName(Double.TYPE, type.getType());
//				} else if (typeReferences.is(type, Boolean.class)) {
//					return typeReferences.getTypeForName(Boolean.TYPE, type.getType());
////				} else if (typeReferences.is(type, Void.class)) {
////					return typeReferences.getTypeForName(Void.TYPE, type.getType());
//				}
//				return type;
//			}
			
			@Override
			public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference type) {
				if(type.getType() instanceof JvmTypeParameter && visiting.add(type.getType())) {
					EList<JvmTypeConstraint> constraints = ((JvmTypeParameter)type.getType()).getConstraints();
					for(JvmUpperBound upperBound: filter(constraints, JvmUpperBound.class)) {
						JvmTypeReference upperBoundType = upperBound.getTypeReference();
						JvmTypeReference asPrimitive = visit(upperBoundType);
						if(asPrimitive != upperBoundType) 
							return asPrimitive;
					}
					return type;
				} else if (typeReferences.is(type, BuildInTypes.getInstance().getByteType(type.eResource()))) {
					return typeReferences.getTypeForName(BuildInTypes.getInstance().getByteType(type.eResource()), type.getType());
				} else if (typeReferences.is(type, BuildInTypes.getInstance().getShortType(type.eResource()))) {
					return typeReferences.getTypeForName(BuildInTypes.getInstance().getShortType(type.eResource()), type.getType());
//				} else if (typeReferences.is(type, Character.class)) {
//					return typeReferences.getTypeForName(Character.TYPE, type.getType());
				} else if (typeReferences.is(type, BuildInTypes.getInstance().getIntegerType(type.eResource()))) {
					return typeReferences.getTypeForName(BuildInTypes.getInstance().getIntegerType(type.eResource()), type.getType());
//				} else if (typeReferences.is(type, Long.class)) {
//					return typeReferences.getTypeForName(Long.TYPE, type.getType());
				} else if (typeReferences.is(type, BuildInTypes.getInstance().getFloatType(type.eResource()))) {
					return typeReferences.getTypeForName(BuildInTypes.getInstance().getFloatType(type.eResource()), type.getType());
				} else if (typeReferences.is(type, BuildInTypes.getInstance().getDoubleType(type.eResource()))) {
					return typeReferences.getTypeForName(BuildInTypes.getInstance().getDoubleType(type.eResource()), type.getType());
				} else if (typeReferences.is(type, BuildInTypes.getInstance().getBooleanType(type.eResource()))) {
					return typeReferences.getTypeForName(BuildInTypes.getInstance().getBooleanType(type.eResource()), type.getType());
//				} else if (typeReferences.is(type, Void.class)) {
//					return typeReferences.getTypeForName(Void.TYPE, type.getType());
				}
				return type;
			}
			
			@Override
			public JvmTypeReference doVisitTypeReference(JvmTypeReference reference) {
				return reference;
			}
			
			@Override
			protected JvmTypeReference handleNullReference() {
				return null;
			}
		}.visit(type);
		
	}
}
