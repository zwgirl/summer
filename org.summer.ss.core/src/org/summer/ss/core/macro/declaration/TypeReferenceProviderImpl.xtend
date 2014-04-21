package org.summer.ss.core.macro.declaration

import org.summer.dsl.model.ss.XtendTypeDeclaration
import org.summer.ss.lib.macro.declaration.Type
import org.summer.ss.lib.macro.declaration.TypeReference
import org.summer.ss.lib.macro.services.TypeReferenceProvider
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.ss.lib.macro.declaration.PrimitiveType

class TypeReferenceProviderImpl implements TypeReferenceProvider {
	
	extension CompilationUnitImpl compilationUnit
	
	new (CompilationUnitImpl compilationUnit) {
		this.compilationUnit = compilationUnit
	}
	
	override getAnyType() {
		toTypeReference(typeReferences.createAnyTypeReference(xtendFile))
	}
	
	override getList(TypeReference param) {
		newTypeReference("java.util.List", param)
	}
	
	override getObject() {
		toTypeReference(typeReferences.createTypeRef(typeReferences.findDeclaredType(Object, xtendFile)))
	}
	
	override getPrimitiveBoolean() {
		newTypeReference("boolean")
	}
	
	override getPrimitiveByte() {
		newTypeReference("byte")
	}
	
	override getPrimitiveChar() {
		newTypeReference("char")
	}
	
	override getPrimitiveDouble() {
		newTypeReference("double")
	}
	
	override getPrimitiveFloat() {
		newTypeReference("float")
	}
	
	override getPrimitiveInt() {
		newTypeReference("int")
	}
	
	override getPrimitiveLong() {
		newTypeReference("long")
	}
	
	override getPrimitiveShort() {
		newTypeReference("short")
	}
	
	override getPrimitiveVoid() {
		newTypeReference("void")
	}
	
	override getSet(TypeReference param) {
		newTypeReference("java.util.Set", param)
	}
	
	override getString() {
		newTypeReference("java.lang.String")
	}
	
	override newArrayTypeReference(TypeReference componentType) {
		checkCanceled
		toTypeReference(typeReferences.createArrayType(componentType.toJvmTypeReference))
	}
	
	override newTypeReference(String typeName, TypeReference... typeArguments) {
		checkCanceled
		val type = typeReferences.findDeclaredType(typeName, xtendFile)
		if (type == null)
			return null
		toTypeReference(typeReferences.createTypeRef(type, typeArguments.map[toJvmTypeReference] as JvmTypeReference[]))
	}
	
	override newTypeReference(Type typeDeclaration, TypeReference... typeArguments) {
		checkCanceled
		val type = switch typeDeclaration {
			JvmTypeDeclarationImpl<? extends JvmDeclaredType> : {
				typeDeclaration.delegate
			}
			XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> : {
				jvmAssociations.getInferredType(typeDeclaration.delegate)
			}
			JvmTypeParameterDeclarationImpl : {
				typeDeclaration.delegate
			}
			PrimitiveTypeImpl : {
				return switch typeDeclaration.kind {
					case PrimitiveType.Kind.BOOLEAN : primitiveBoolean
					case PrimitiveType.Kind.BYTE : primitiveByte
					case PrimitiveType.Kind.CHAR : primitiveChar
					case PrimitiveType.Kind.DOUBLE : primitiveDouble
					case PrimitiveType.Kind.FLOAT : primitiveFloat
					case PrimitiveType.Kind.INT : primitiveInt
					case PrimitiveType.Kind.LONG : primitiveLong
					case PrimitiveType.Kind.SHORT : primitiveShort
				}
			}
			VoidTypeImpl : {
				return primitiveVoid
			}
			default : {
				throw new IllegalArgumentException("couldn't construct type reference for type "+typeDeclaration)
			}
		}
		
		if (type == null)
			return null
		toTypeReference(typeReferences.createTypeRef(type, typeArguments.map[toJvmTypeReference] as JvmTypeReference[]))
	}
	
	override newWildcardTypeReference() {
		newWildcardTypeReference(null);
	}
	
	override newWildcardTypeReference(TypeReference upperBound) {
		if (upperBound == null) {
			toTypeReference(typeReferences.wildCard())
		} else {
			toTypeReference(typeReferences.wildCardExtends(upperBound.toJvmTypeReference))
		}
	}
	
	override newWildcardTypeReferenceWithLowerBound(TypeReference lowerBound) {
		if (lowerBound == null) {
			toTypeReference(typeReferences.wildCard())
		} else {
			toTypeReference(typeReferences.wildCardSuper(lowerBound.toJvmTypeReference))
		}
	}
	
	override newTypeReference(Class<? extends Object> clazz, TypeReference... typeArguments) {
		newTypeReference(clazz.name, typeArguments)
	}
	
}