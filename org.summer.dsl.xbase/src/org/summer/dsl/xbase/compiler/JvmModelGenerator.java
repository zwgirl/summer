/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.dsl.xbase.compiler;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.summer.dsl.model.types.JvmAnnotationAnnotationValue;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmBooleanAnnotationValue;
import org.summer.dsl.model.types.JvmByteAnnotationValue;
import org.summer.dsl.model.types.JvmCharAnnotationValue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmCustomAnnotationValue;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDoubleAnnotationValue;
import org.summer.dsl.model.types.JvmEnumAnnotationValue;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFloatAnnotationValue;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmIntAnnotationValue;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmLongAnnotationValue;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmShortAnnotationValue;
import org.summer.dsl.model.types.JvmStringAnnotationValue;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeAnnotationValue;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.util.TypeReferences;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportItem;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.compiler.output.ImportingStringConcatenation;
import org.summer.dsl.xbase.compiler.output.SharedAppendableState;
import org.summer.dsl.xbase.compiler.output.TreeAppendable;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;
import org.summer.dsl.xbase.jvmmodel.IJvmModelInferrer;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.jvmmodel.JvmTypeExtensions;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.ss2.lib.StringConcatenationClient;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * A generator implementation that processes the
 * derived {@link IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
@SuppressWarnings("all")
public class JvmModelGenerator implements IGenerator {
  @Inject
  @Extension
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  @Inject
  @Extension
  private TypeReferences _typeReferences;
  
  @Inject
  @Extension
  private TreeAppendableUtil _treeAppendableUtil;
  
  @Inject
  @Extension
  private JvmTypeExtensions _jvmTypeExtensions;
  
  @Inject
  @Extension
  private LoopExtensions _loopExtensions;
  
  @Inject
  @Extension
  private ErrorSafeExtensions _errorSafeExtensions;
  
  @Inject
  private CommonTypeComputationServices commonServices;
  
  @Inject
  private XbaseCompiler compiler;
  
  @Inject
  private ILocationInFileProvider locationProvider;
  
  @Inject
  private IEObjectDocumentationProvider documentationProvider;
  
  @Inject
  private IFileHeaderProvider fileHeaderProvider;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Inject
  private JavaKeywords keywords;
  
  @Inject
  private IGeneratorConfigProvider generatorConfigProvider;
  
  @Inject
  private ITraceURIConverter converter;
  
  @Inject
  private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;
  
  @Inject
  private IScopeProvider scopeProvider;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
	    JvmModule module = (JvmModule) input.getContents().get(0);
    GeneratorConfig config = this.generatorConfigProvider.get(module);
//    ImportManager _importManager = new ImportManager(true, module);
    
    final TreeAppendable header = this.createAppendable(module, null);
    header.append("define([\'dojo/_base/declare\', \'system/Type\' ");
    
    TreeAppendable body  = this.createAppendable(module, null);
    body.append(", function(declare, Type");
    
    XImportSection importSection = module.getImportSection();
    if(importSection != null){
        for(XImportDeclaration decl : importSection.getImportDeclarations()){
        	header.append(",");
        	header.append("\'").append(decl.getModuleName()).append("\'");
        	body.append(",");
        	body.append(decl.getModuleName());
        }
    }
    
    header.append("]");
    body.append(") {");
    body.newLine();
    body.increaseIndentation();
    
    List<JvmIdentifiableElement> exportObjects = new LinkedList<JvmIdentifiableElement>();
    for (final EObject obj : module.getContents()) {
    	if(obj instanceof XVariableDeclarationList){
    		XVariableDeclarationList declList = (XVariableDeclarationList) obj;
    		if(declList.isExported()){
    			for(XExpression varDecl : declList.getDeclarations()){
        			exportObjects.add((JvmIdentifiableElement) varDecl);
    			}
    		}
    	}else if(obj instanceof XClosure){
    		XClosure closure = (XClosure) obj;
    		if(closure.isExported()){
    			exportObjects.add(closure);
    		}
    	}else if (obj instanceof JvmDeclaredType){
    		JvmDeclaredType jvmType = (JvmDeclaredType) obj;
    		if(jvmType.isExported()){
    			exportObjects.add(jvmType);
    		}
    	}
    	this.internalDoGenerate(obj, body);
    }
    
    XExportSection exportSection = module.getExportSection();
    if(exportSection != null){
        for(XExportDeclaration expDecl :exportSection.getExportDeclarations()){
        	List<XExportItem> items = expDecl.getExportItems();
        	for(XExportItem item : items){
        		exportObjects.add(item.getExportedId());
        	}
        }
    }

    body.newLine();
    body.append("return {");
    body.increaseIndentation();
    boolean comaFlag = false;
    for(JvmIdentifiableElement idElement : exportObjects){
    	if(comaFlag){
    		body.append(",");
    		body.newLine();
    	}
    	comaFlag = true;
    	
    	body.append(idElement.getSimpleName()).append(":").append(idElement.getSimpleName());
    }
    body.decreaseIndentation();
    body.newLine();
    body.append("};");
    
    body.decreaseIndentation();
    body.newLine();
    body.append("});");
    
	 String fileName = input.getURI().lastSegment();
	 fileName = (fileName + ".js");

	 header.append(body);
    fsa.generateFile(fileName, header);
  }
  
	public void internalDoGenerate(EObject obj, TreeAppendable b) {
		if(obj instanceof JvmEnumerationType){
			_generateEnumeration((JvmEnumerationType) obj, b);
		} else if(obj instanceof JvmGenericType){
			_generateGenericType((JvmGenericType) obj, b);
		} if(obj instanceof XVariableDeclarationList){
			_generateVariableDeclaration((XVariableDeclarationList) obj, b);
		} if(obj instanceof XClosure){
			_generateClosure((XClosure) obj, b);
		}
	}
  
  private void _generateClosure(XClosure obj, TreeAppendable b) {
		// TODO Auto-generated method stub
		
	}

private void _generateVariableDeclaration(XVariableDeclarationList obj,
			TreeAppendable b) {
		// TODO Auto-generated method stub
		
	}

protected void _generateEnumeration(JvmEnumerationType enumType, TreeAppendable b){
	  b.newLine();
	  b.append("var ").append(enumType.getSimpleName()).append(" = ").append("{");
	  b.increaseIndentation();
	  b.newLine();
	  List<JvmEnumerationLiteral> literals = enumType.getLiterals();
	  
	  boolean commaFlag = false;
	  for(JvmEnumerationLiteral literal : literals){
		  if(commaFlag){
			  b.append(",");
			  b.newLine();
		  }
		  b.append(literal.getSimpleName()).append(":" + literal.getOrdinal());
		  commaFlag = true;
	  }
	  b.decreaseIndentation();
	  b.newLine();
	  b.append("};");
  }
  
  protected void _generateGenericType(final JvmGenericType type, TreeAppendable b) {
    boolean _isDisabled = DisableCodeGenerationAdapter.isDisabled(type);
    if (_isDisabled) {
      return;
    }
    
    b.newLine();
    b.append("function ").append(type.getSimpleName()).append("( ) {");
    b.increaseIndentation();
    b.newLine();
    b.append(type.getSimpleName()).append(".prototype.__ctor__[arguments[0]].apply(this, arguments[1]);");
	b.decreaseIndentation();
	b.newLine();
    b.append("};");
    
    //设置继承关系
	//  ClassType.prototype.__proto__ = ParentClass.prototype;
	  JvmParameterizedTypeReference baseTypeRef = type.getExtends();
	  if(baseTypeRef != null){
	      JvmGenericType baseType = (JvmGenericType) baseTypeRef.getType();
	      b.newLine();
	      b.append(type.getSimpleName()).append(".prototype.__proto__ = ").append(baseType.getSimpleName()).append(".prototype;");
	  }
	  
	  
	//  ClassType.Type = new Type(’类名称‘，父类们，是否是接口);
	  b.newLine();
	  b.append(type.getSimpleName()).append(".Type = ").append("new Type(\'").append(type.getSimpleName()).append("\', ");
	  b.append("[");
	  if(baseTypeRef != null){
	      JvmGenericType baseType = (JvmGenericType) baseTypeRef.getType();
	      b.append(baseType.getSimpleName());
	  }
	  
	  List<JvmParameterizedTypeReference> implementTypes = type.getImplements();
	  
	  boolean commaFlag = false;
	  for(JvmParameterizedTypeReference typeRef : implementTypes){
		  if(commaFlag){
			  b.append(",");
		  }
	  	b.append(typeRef.getType().getSimpleName());
	  	commaFlag = true;
	  }
	  
	  b.append("], ");
  
	  b.append(type instanceof JvmInterfaceType ? "true" : "false").append(");");
	  
//	  function ClassType(构造函数签名、其他参数){
//		　　//如果有调用父类构造函数的语句，但是不是第一条语句，给出错误
//		　　//如果没有调用父类构造函数的语句，增加调用父类缺省构造函数的语句；如果有当然就不需要了。
//		　　//如果没有缺省的构造函数，就创建一个；
//		　　ClassType.prototype.constructor.call(this,签名，其他参数);
//		}
//
//		//构造函数
//		ClassType.prototype.constructor = function(){
//		　　ParentType.prototype.constructor.call(“”, 其他参数)；
//		　　ClassType.prototype.constructor.dispatch[签名].call(this, 其他参数)；
//		}
//		//其中的一个构造函数
//		ClassType.prototype.constructor.dispatch = {
//		　　cots1:function(参数){
//		　　本身的其他语句；
//		　　}
//		}
	  
	  b.newLine();
	  b.append(type.getSimpleName()).append(".protoype.__ctor__ = {");
	  b.increaseIndentation();
	  b.newLine();
	  commaFlag = false;
	  List<JvmConstructor> contructors = type.getDeclaredConstructors();
	  for(JvmConstructor contructor : contructors){
		  if(commaFlag){
			  b.append(", ");
			  b.newLine();
		  }
		  b.append("constructor").append(":").append("function(");
		  List<JvmFormalParameter> parameters = contructor.getParameters();
		  
		  boolean flag = false;
		  for(JvmFormalParameter parameter : parameters){
			  if(flag){
				  b.append(",");
			  }
		  	b.append(parameter.getSimpleName());
		  	flag = true;
		  }
		  b.append(") {");
		  
		  b.increaseIndentation().newLine();
		  compiler.internalToJavaStatement(contructor.getBody(), b, false);
		  b.decreaseIndentation().newLine();
		  
		  b.append("}");
		  commaFlag = true;
	  }
	  b.decreaseIndentation();
	  b.newLine();
	  b.append("};");
	  
	  //process overload operator
	  Map<String, Set<JvmOperation>> groups = new HashMap<String, Set<JvmOperation>>();
	  Iterable<JvmOperation> operations = type.getDeclaredOperations();
	  for(JvmOperation operation : operations){
		  if(operation.isOverload()){
			  Set<JvmOperation> group = groups.get(operation.getSimpleName());
			  if(group == null){
				  group = new HashSet<JvmOperation>();
				  groups.put(operation.getSimpleName(), group);
			  }
			  
			  group.add(operation);
		  }
	  }
	  
	  for(String name : groups.keySet()){
		  Set<JvmOperation> overloads = groups.get(name);
		  b.newLine();
		  b.append(type.getSimpleName()).append(".prototype.").append(name).append(" = function(){");
		  b.increaseIndentation().newLine();
		  b.append(type.getSimpleName()).append(".prototype.").append(name).
		  	append(".dispatch[arguments[0]].apply(this, arguments[1]);");
		  b.decreaseIndentation().newLine();
		  b.append("};");
		  
		  b.newLine();
		  b.append(type.getSimpleName()).append(".prototype.").append(name).append(".dispatch = {");
		  b.increaseIndentation().newLine();
		  
		  commaFlag = false;
		  for(JvmOperation operation : overloads){
			  if(commaFlag){
				  b.append(",");
				  b.newLine();
			  }
			  
			  commaFlag = true;
			  b.append(operation.getSimpleName()).append(" : function(");
			  List<JvmFormalParameter> parameters  = operation.getParameters();
			  
			  boolean flag = false;
			  for(JvmFormalParameter parameter : parameters){
				  if(flag){
					  b.append(", ");
				  }
				  b.append(parameter.getSimpleName());
				  flag = true;
			  }
			  
			  b.append("){");
			  
			  b.increaseIndentation().newLine();
			  compiler.toJavaStatement(operation.getBody(), b, false);
			  b.decreaseIndentation().newLine();
			  
			  b.append("}");
		  }
		  
		  b.decreaseIndentation().newLine();
		  b.append("};");
	  }
	  		
	  this._generateBody(type, b);
  }
  
  protected void _generateBody(final JvmGenericType it, final ITreeAppendable b) {
      final ITreeAppendable sfb = b.trace(it);
      final ITreeAppendable fb = b.trace(it);
      final ITreeAppendable sob = b.trace(it);
      final ITreeAppendable ob = b.trace(it);
      final ITreeAppendable cb = b.trace(it);
      
      List<JvmMember> memebers = it.getMembers();
      for(JvmMember member : memebers){
    	  if(member instanceof JvmField){
    		  
    		  JvmField field  = (JvmField) member;
    		  if(field.isStatic()){
    			  sfb.newLine();
    			  sfb.append("Object.defineProperty(").append(it.getSimpleName()).append(", ")
    			  	.append(field.getSimpleName()).append(", {");  
    			  sfb.increaseIndentation();
				  sfb.newLine();
				  
				  boolean commaFlag = false;
    			  if(field.getGet()!=null){
    				  sfb.append("get:function(){");
    				  XStatment stat = field.getGet();
    				  b.increaseIndentation();
    				  b.newLine();
    				  compiler.toJavaStatement(stat, sfb, false);
    				  sfb.decreaseIndentation();
    				  sfb.newLine();
    				  sfb.append("}");
    				  commaFlag = true;
    			  }
    			  
    			  if(field.getSet()!=null){
    				  if(commaFlag){
    					  sfb.append(",");
    					  sfb.newLine();
    				  }
    				  
    				  sfb.append("set:function(value){");
    				  XStatment stat = field.getSet();
    				  sfb.increaseIndentation();
//    				  sfb.newLine();
    				  compiler.toJavaStatement(stat, sfb, false);
    				  sfb.decreaseIndentation();
    				  sfb.newLine();
    				  sfb.append("}");
    			  }
    			  
    			  sfb.decreaseIndentation().newLine();
    			  sfb.append("});");
    		  } else{
    			  fb.newLine();
    			  fb.append("Object.defineProperty(").append(it.getSimpleName())
    			  	.append(".prototype, ").append(field.getSimpleName()).append(", {");  
    			  fb.newLine();
    			  fb.increaseIndentation();
    			  
    			  fb.decreaseIndentation();
    			  fb.append("});");
    		  }
    	  } else if(member instanceof JvmOperation){
    		  JvmOperation operation = (JvmOperation) member;
    		  if(operation.isOverload()){
    			  continue;
    		  }
    		  if(operation.isStatic()){
    			  sob.newLine();
    			  sob.append(it.getSimpleName()).append(".")
    			  	.append(operation.getSimpleName()).append("= function(");
    			  List<JvmFormalParameter> parameters = operation.getParameters();
    			  
    			  boolean commaFlag = false;
    			  for(JvmFormalParameter parameter : parameters){
    				  if(commaFlag){
    					  sob.append(", ");
    				  }
    				  sob.append(parameter.getSimpleName());
    				  commaFlag = true;
    			  }
    			  
    			  sob.append(") {");  

    			  sob.increaseIndentation().newLine();
    			  compiler.toJavaStatement(operation.getBody(), sob, false);
    			  sob.decreaseIndentation().newLine();
    			  sob.append("};");
    		  }else{
    			  ob.newLine();
    			  ob.append(it.getSimpleName()).append(".prototype.")
    			  	.append(operation.getSimpleName()).append("= function(");
    			  List<JvmFormalParameter> parameters = operation.getParameters();
    			  
    			  boolean commaFlag = false;
    			  for(JvmFormalParameter parameter : parameters){
    				  if(commaFlag){
    					  ob.append(", ");
    				  }
    				  ob.append(parameter.getSimpleName());
    				  commaFlag = true;
    			  }
    			  
    			  ob.append(") {");  
    			  ob.newLine();
    			  ob.increaseIndentation().newLine();
    			  compiler.toJavaStatement(operation.getBody(), ob, false);
    			  ob.decreaseIndentation().newLine();
    			  ob.append("};");
    		  }
    	  } 
      }
  }
  
	public TreeAppendable createAppendable(final EObject context,
			final ImportManager importManager) {
		TreeAppendable appendable = new TreeAppendable(importManager,
				this.converter, this.locationProvider,
				this.jvmModelAssociations, context, "  ", "\n");
		if ((!Objects.equal(this.containerType(context), null))) {
			appendable.declareVariable(this.containerType(context), "this");
			final JvmTypeReference superType = this.containerType(context)
					.getExtendedClass();
			if ((!Objects.equal(superType, null))) {
				appendable.declareVariable(superType.getType(), "super");
			}
		}
		return appendable;
	}
 
  
	public JvmGenericType containerType(final EObject context) {
		if (Objects.equal(context, null)) {
			return null;
		} else {
			if ((context instanceof JvmGenericType)) {
				return (JvmGenericType) context;
			} else {
				return this.containerType(context.eContainer());
			}
		}
	}
}
