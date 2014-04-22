/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.access.impl.URIHelperConstants;
import org.summer.dsl.model.types.util.Primitives.Primitive;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This method is not intended to be referenced by clients.
 */
public class WrapperTypeLookup {

	//cym comment
//	@Nullable
//	private static LightweightTypeReference findTopLevelType(LightweightTypeReference context, String typeName) {
//		ITypeReferenceOwner owner = context.getOwner();
//		ResourceSet resourceSet = owner.getContextResourceSet();
//		Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(typeName), true);
//		if(typeResource.getContents().isEmpty()){  //cym modified
//			return null;
//		}
//		JvmType type = (JvmType) typeResource.getContents().get(0);
//		if (type == null)
//			return null;
//		return new ParameterizedTypeReference(owner, type);
//	}
	
	@Nullable
	private static LightweightTypeReference findTopLevelType(LightweightTypeReference context, JvmType type) {
		ITypeReferenceOwner owner = context.getOwner();
		return new ParameterizedTypeReference(owner, type);
	}
	
	
	//cym comment
//	@Nullable
//	public static LightweightTypeReference getWrapperType(LightweightTypeReference context, Primitive primitiveKind) {
//		switch(primitiveKind) {
//			case Boolean:
//				return findTopLevelType(context, "java.lang.Boolean");
//			case Byte:
//				return findTopLevelType(context, "java.lang.Byte");
//			case Char:
//				return findTopLevelType(context, "java.lang.Character");
//			case Double:
//				return findTopLevelType(context, "java.lang.Double");
//			case Float:
//				return findTopLevelType(context, "java.lang.Float");
//			case Int:
//				return findTopLevelType(context, "java.lang.Integer");
//			case Long:
//				return findTopLevelType(context, "java.lang.Long");
//			case Short:
//				return findTopLevelType(context, "java.lang.Short");
//			case Void:
//				return findTopLevelType(context, "java.lang.Void");
//			default:
//				throw new IllegalArgumentException("Unknown primitive type: " + primitiveKind);
//		}
//	}
	
	@Nullable
	public static LightweightTypeReference getWrapperType(LightweightTypeReference context, Primitive primitiveKind) {
		switch(primitiveKind) {
			case Boolean:
				return findTopLevelType(context, BuildInTypes.getInstance().getBooleanType(context.getOwner().getContextResourceSet()));
			case Byte:
				return findTopLevelType(context, BuildInTypes.getInstance().getByteType(context.getOwner().getContextResourceSet()));
//			case Char:
//				return findTopLevelType(context, "java.lang.Character");
			case Double:
				return findTopLevelType(context, BuildInTypes.getInstance().getDoubleType(context.getOwner().getContextResourceSet()));
			case Float:
				return findTopLevelType(context, BuildInTypes.getInstance().getFloatType(context.getOwner().getContextResourceSet()));
			case Int:
				return findTopLevelType(context, BuildInTypes.getInstance().getIntegerType(context.getOwner().getContextResourceSet()));
//			case Long:
//				return findTopLevelType(context, "java.lang.Long");
			case Short:
				return findTopLevelType(context, BuildInTypes.getInstance().getShortType(context.getOwner().getContextResourceSet()));
//			case Void:
//				return findTopLevelType(context, "java.lang.Void");
			default:
				throw new IllegalArgumentException("Unknown primitive type: " + primitiveKind);
		}
	}
	
}
