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
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
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
		  compiler.internalToJavaStatement(contructor.getExpression(), b, false);
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
			  compiler.toJavaStatement(operation.getExpression(), b, false);
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
    				  XExpression exp = field.getGet();
    				  b.increaseIndentation();
    				  b.newLine();
    				  compiler.toJavaStatement(exp, sfb, false);
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
    				  XExpression exp = field.getSet();
    				  sfb.increaseIndentation();
//    				  sfb.newLine();
    				  compiler.toJavaStatement(exp, sfb, false);
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
    			  compiler.toJavaStatement(operation.getExpression(), sob, false);
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
    			  compiler.toJavaStatement(operation.getExpression(), ob, false);
    			  ob.decreaseIndentation().newLine();
    			  ob.append("};");
    		  }
    	  } 
      }
  }
  
  public ITreeAppendable generateAnnotationsWithSyntheticSuppressWarnings(final JvmDeclaredType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      final Function1<JvmAnnotationReference,Boolean> _function = new Function1<JvmAnnotationReference,Boolean>() {
        public Boolean apply(final JvmAnnotationReference it) {
          JvmAnnotationType _annotation = it.getAnnotation();
          String _identifier = null;
          if (_annotation!=null) {
            _identifier=_annotation.getIdentifier();
          }
          String _name = SuppressWarnings.class.getName();
          boolean _notEquals = (!Objects.equal(_identifier, _name));
          return _notEquals;
        }
      };
      final Function1<JvmAnnotationReference,Boolean> noSuppressWarningsFilter = _function;
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      Iterable<JvmAnnotationReference> _filter = IterableExtensions.<JvmAnnotationReference>filter(_annotations, noSuppressWarningsFilter);
      this.generateAnnotations(_filter, appendable, true);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@SuppressWarnings(\"all\")");
      ITreeAppendable _append = appendable.append(_builder);
      ITreeAppendable _newLine = _append.newLine();
      _xblockexpression = (_newLine);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateBody(final JvmEnumerationType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable childAppendable = appendable.trace(it);
      boolean _isGenerateSyntheticSuppressWarnings = false;//config.isGenerateSyntheticSuppressWarnings();
      if (_isGenerateSyntheticSuppressWarnings) {
        this.generateAnnotationsWithSyntheticSuppressWarnings(it, childAppendable);
      } else {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        this.generateAnnotations(_annotations, childAppendable, true);
      }
      this.generateModifier(it, childAppendable);
      childAppendable.append("enum ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      childAppendable.append(" ");
      this.generateExtendsClause(it, childAppendable);
      ITreeAppendable _append = childAppendable.append("{");
      _append.increaseIndentation();
      EList<JvmEnumerationLiteral> _literals = it.getLiterals();
      final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
            public ITreeAppendable apply(final ITreeAppendable it) {
              ITreeAppendable _append = it.append(",");
              ITreeAppendable _newLine = _append.newLine();
              return _newLine;
            }
          };
          it.setSeparator(_function);
          it.setSuffix(";");
        }
      };
      final Procedure1<JvmEnumerationLiteral> _function_1 = new Procedure1<JvmEnumerationLiteral>() {
        public void apply(final JvmEnumerationLiteral it) {
          ITreeAppendable _trace = childAppendable.trace(it);
          JvmModelGenerator.this.generateEnumLiteral(it, _trace);
        }
      };
      this._loopExtensions.<JvmEnumerationLiteral>forEach(childAppendable, _literals, _function, _function_1);
      Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
      final Function1<JvmMember,Boolean> _function_2 = new Function1<JvmMember,Boolean>() {
        public Boolean apply(final JvmMember it) {
          return Boolean.valueOf((!(it instanceof JvmEnumerationLiteral)));
        }
      };
      Iterable<JvmMember> _filter = IterableExtensions.<JvmMember>filter(_membersToBeCompiled, _function_2);
      final Procedure1<LoopParams> _function_3 = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
            public ITreeAppendable apply(final ITreeAppendable it) {
              ITreeAppendable _newLine = it.newLine();
              return _newLine;
            }
          };
          it.setSeparator(_function);
        }
      };
      final Procedure1<JvmMember> _function_4 = new Procedure1<JvmMember>() {
        public void apply(final JvmMember it) {
          ITreeAppendable _trace = childAppendable.trace(it);
          JvmModelGenerator.this.generateMember(it, _trace);
        }
      };
      this._loopExtensions.<JvmMember>forEach(childAppendable, _filter, _function_3, _function_4);
      ITreeAppendable _decreaseIndentation = childAppendable.decreaseIndentation();
      ITreeAppendable _newLine = _decreaseIndentation.newLine();
      _newLine.append("}");
      ITreeAppendable _newLine_1 = appendable.newLine();
      _xblockexpression = (_newLine_1);
    }
    return _xblockexpression;
  }
  
  public void generateEnumLiteral(final JvmEnumerationLiteral it, final ITreeAppendable appendable) {
    appendable.newLine();
    this.generateJavaDoc(it, appendable);
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    this.generateAnnotations(_annotations, appendable, true);
    String _simpleName = it.getSimpleName();
    appendable.append(_simpleName);
  }
  
  protected ITreeAppendable _generateBody(final JvmAnnotationType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable childAppendable = appendable.trace(it);
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, childAppendable, true);
      this.generateModifier(it, childAppendable);
      childAppendable.append("@interface ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      childAppendable.append(" {");
      Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
      Iterable<JvmOperation> _filter = Iterables.<JvmOperation>filter(_membersToBeCompiled, JvmOperation.class);
      for (final JvmOperation operation : _filter) {
        this.generateAnnotationMethod(operation, childAppendable);
      }
      ITreeAppendable _newLine = childAppendable.newLine();
      _newLine.append("}");
      ITreeAppendable _newLine_1 = appendable.newLine();
      _xblockexpression = (_newLine_1);
    }
    return _xblockexpression;
  }
  
  public void generateAnnotationMethod(final JvmOperation it, final ITreeAppendable appendable) {
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    appendable.openScope();
    this.generateJavaDoc(it, appendable);
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    this.generateAnnotations(_annotations, tracedAppendable, true);
    this.generateModifier(it, tracedAppendable);
    JvmTypeReference _returnType = it.getReturnType();
    this._errorSafeExtensions.serializeSafely(_returnType, "Object", tracedAppendable);
    tracedAppendable.append(" ");
    boolean _isStatic = it.isStatic();
    if (_isStatic) {
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
    } else {
      ITreeAppendable _traceSignificant_1 = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName_1 = it.getSimpleName();
      ITreeAppendable _append = _traceSignificant_1.append(_simpleName_1);
      _append.append(":function");
    }
    tracedAppendable.append("()");
    this.generateDefaultExpression(it, tracedAppendable);
    tracedAppendable.append(";");
    appendable.decreaseIndentation();
    appendable.closeScope();
  }
  
  public void generateDefaultExpression(final JvmOperation it, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      appendable.append(" default ");
      appendable.increaseIndentation();
      Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(it);
      _compilationStrategy_1.apply(appendable);
      appendable.decreaseIndentation();
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
      boolean _notEquals_1 = (!Objects.equal(_compilationTemplate, null));
      if (_notEquals_1) {
        ITreeAppendable _append = appendable.append(" default ");
        _append.increaseIndentation();
        this.appendCompilationTemplate(appendable, it);
        appendable.decreaseIndentation();
      } else {
        boolean _isGenerateExpressions = false; //config.isGenerateExpressions();
        if (_isGenerateExpressions) {
          final XExpression body = this._iLogicalContainerProvider.getAssociatedExpression(it);
          boolean _notEquals_2 = (!Objects.equal(body, null));
          if (_notEquals_2) {
            boolean _hasErrors = this._errorSafeExtensions.hasErrors(body);
            if (_hasErrors) {
              appendable.append("/* skipped default expression with errors */");
            } else {
              appendable.append(" default ");
              JvmTypeReference _returnType = it.getReturnType();
              this.compiler.compileAsJavaExpression(body, appendable, _returnType);
            }
          } else {
            JvmAnnotationValue _defaultValue = it.getDefaultValue();
            boolean _notEquals_3 = (!Objects.equal(_defaultValue, null));
            if (_notEquals_3) {
              JvmAnnotationValue _defaultValue_1 = it.getDefaultValue();
              boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(_defaultValue_1);
              if (_hasErrors_1) {
                appendable.append("/* skipped default expression with errors */");
              } else {
                appendable.append(" default ");
                JvmAnnotationValue _defaultValue_2 = it.getDefaultValue();
                this.toJavaLiteral(_defaultValue_2, appendable);
              }
            }
          }
        }
      }
    }
  }
  
  private void appendCompilationTemplate(final ITreeAppendable appendable, final JvmIdentifiableElement it) {
    boolean _matched = false;
    if (!_matched) {
      if (appendable instanceof TreeAppendable) {
        _matched=true;
        SharedAppendableState _state = ((TreeAppendable)appendable).getState();
        StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.commonServices, it);
        ImportingStringConcatenation _importingStringConcatenation = new ImportingStringConcatenation(_state, _standardTypeReferenceOwner);
        final ImportingStringConcatenation target = _importingStringConcatenation;
        StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
        target.append(_compilationTemplate);
        ((TreeAppendable)appendable).append(target);
      }
    }
    if (!_matched) {
      Class<? extends ITreeAppendable> _class = appendable.getClass();
      String _name = _class.getName();
      String _plus = ("unexpected appendable: " + _name);
      IllegalStateException _illegalStateException = new IllegalStateException(_plus);
      throw _illegalStateException;
    }
  }
  
  protected ITreeAppendable _generateModifier(final JvmGenericType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      ITreeAppendable _xifexpression = null;
//      boolean _isStrictFloatingPoint = it.isStrictFloatingPoint();
//      if (_isStrictFloatingPoint) {
//        ITreeAppendable _append = appendable.append("strictfp ");
//        _xifexpression = _append;
//      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmDeclaredType it, final ITreeAppendable appendable) {
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    ITreeAppendable _append = appendable.append(_javaName);
    return _append;
  }
  
  protected ITreeAppendable _generateModifier(final JvmField it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      boolean _isTransient = it.isTransient();
      if (_isTransient) {
        appendable.append("transient ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isVolatile = it.isVolatile();
      if (_isVolatile) {
        ITreeAppendable _append = appendable.append("volatile ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmOperation it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      boolean _isSynchronized = it.isSynchronized();
      if (_isSynchronized) {
        appendable.append("synchronized ");
      }
      boolean _isStrictFloatingPoint = it.isStrictFloatingPoint();
      if (_isStrictFloatingPoint) {
        appendable.append("strictfp ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isNative = it.isNative();
      if (_isNative) {
        ITreeAppendable _append = appendable.append("native ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmConstructor it, final ITreeAppendable appendable) {
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    ITreeAppendable _append = appendable.append(_javaName);
    return _append;
  }
  
  /**
   * Returns the visibility modifier and a space as suffix if not empty
   */
  public String javaName(final JvmVisibility visibility) {
    boolean _notEquals = (!Objects.equal(visibility, null));
    if (_notEquals) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PRIVATE)) {
          _matched=true;
          _switchResult = "private ";
        }
      }
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PUBLIC)) {
          _matched=true;
          _switchResult = "public ";
        }
      }
      return _switchResult;
    } else {
      return "";
    }
  }
  
  public void generateExtendsClause(final JvmDeclaredType it, final ITreeAppendable appendable) {
  }
  
  protected ITreeAppendable _generateMember(final JvmMember it, final ITreeAppendable appendable) {
    Class<? extends JvmMember> _class = null;
    if (it!=null) {
      _class=it.getClass();
    }
    String _name = null;
    if (_class!=null) {
      _name=_class.getName();
    }
    String _plus = ("generateMember not implemented for elements of type " + _name);
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_plus);
    throw _unsupportedOperationException;
  }
  
  protected ITreeAppendable _generateMember(final JvmGenericType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
//      ITreeAppendable _generateBody = this.generateBody(it, appendable);
//      _xblockexpression = (_generateBody);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateMember(final JvmField it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, tracedAppendable, true);
      this.generateModifier(it, tracedAppendable);
      JvmTypeReference _type = it.getType();
      this._errorSafeExtensions.serializeSafely(_type, "Object", tracedAppendable);
      tracedAppendable.append(" ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      this.generateInitialization(it, tracedAppendable);
      ITreeAppendable _append = tracedAppendable.append(";");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateMember(final JvmOperation it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      appendable.openScope();
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, tracedAppendable, true);
      tracedAppendable.append(" ");
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
        ITreeAppendable _append = _traceSignificant.append(" function ");
        String _simpleName = it.getSimpleName();
        _append.append(_simpleName);
      } else {
        ITreeAppendable _traceSignificant_1 = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
        String _simpleName_1 = it.getSimpleName();
        ITreeAppendable _append_1 = _traceSignificant_1.append(_simpleName_1);
        _append_1.append(":function");
      }
      tracedAppendable.append("(");
      this.generateParameters(it, tracedAppendable);
      tracedAppendable.append(")");
      this.generateThrowsClause(it, tracedAppendable);
      boolean _or = false;
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        _or = true;
      } else {
        boolean _hasBody = this.hasBody(it);
        boolean _not = (!_hasBody);
        _or = (_isAbstract || _not);
      }
      if (_or) {
        tracedAppendable.append(";");
      } else {
        tracedAppendable.append(" ");
        this.generateExecutableBody(it, tracedAppendable);
      }
      appendable.closeScope();
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateMember(final JvmConstructor it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      appendable.openScope();
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      _traceSignificant.append("constructor");
      tracedAppendable.append(":function(");
      this.generateParameters(it, tracedAppendable);
      tracedAppendable.append(")");
      tracedAppendable.append(" ");
      this.generateExecutableBody(it, tracedAppendable);
      appendable.closeScope();
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public void generateInitialization(final JvmField it, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      appendable.append(" = ");
      appendable.increaseIndentation();
      Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(it);
      _compilationStrategy_1.apply(appendable);
      appendable.decreaseIndentation();
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
      boolean _notEquals_1 = (!Objects.equal(_compilationTemplate, null));
      if (_notEquals_1) {
        ITreeAppendable _append = appendable.append(" = ");
        _append.increaseIndentation();
        this.appendCompilationTemplate(appendable, it);
        appendable.decreaseIndentation();
      } else {
        final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(it);
        boolean _and = false;
        boolean _notEquals_2 = (!Objects.equal(expression, null));
        if (!_notEquals_2) {
          _and = false;
        } else {
          boolean _isGenerateExpressions = false; //config.isGenerateExpressions();
          _and = (_notEquals_2 && _isGenerateExpressions);
        }
        if (_and) {
          boolean _hasErrors = this._errorSafeExtensions.hasErrors(expression);
          if (_hasErrors) {
            appendable.append(" /* Skipped initializer because of errors */");
          } else {
            appendable.append(" = ");
            JvmTypeReference _type = it.getType();
            this.compiler.compileAsJavaExpression(expression, appendable, _type);
          }
        }
      }
    }
  }
  
  public void generateTypeParameterDeclaration(final JvmTypeParameterDeclarator it, final ITreeAppendable appendable) {
    EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
      public void apply(final LoopParams it) {
        it.setPrefix("<");
        it.setSeparator(", ");
        it.setSuffix("> ");
      }
    };
    final Procedure1<JvmTypeParameter> _function_1 = new Procedure1<JvmTypeParameter>() {
      public void apply(final JvmTypeParameter it) {
        JvmModelGenerator.this.generateTypeParameterDeclaration(it, appendable);
      }
    };
    this._loopExtensions.<JvmTypeParameter>forEach(appendable, _typeParameters, _function, _function_1);
  }
  
  public void generateTypeParameterDeclaration(final JvmTypeParameter it, final ITreeAppendable appendable) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _name = it.getName();
    _traceSignificant.append(_name);
    this.generateTypeParameterConstraints(it, tracedAppendable);
  }
  
  public void generateTypeParameterConstraints(final JvmTypeParameter it, final ITreeAppendable appendable) {
    EList<JvmTypeConstraint> _constraints = it.getConstraints();
    final Iterable<JvmUpperBound> upperBounds = Iterables.<JvmUpperBound>filter(_constraints, JvmUpperBound.class);
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
      public void apply(final LoopParams it) {
        it.setPrefix(" extends ");
        it.setSeparator(" & ");
      }
    };
    final Procedure2<JvmUpperBound,ITreeAppendable> _function_1 = new Procedure2<JvmUpperBound,ITreeAppendable>() {
      public void apply(final JvmUpperBound it, final ITreeAppendable app) {
        JvmTypeReference _typeReference = it.getTypeReference();
        JvmModelGenerator.this._errorSafeExtensions.serializeSafely(_typeReference, app);
      }
    };
    this._errorSafeExtensions.<JvmUpperBound>forEachSafely(appendable, upperBounds, _function, _function_1);
  }
  
  public void generateThrowsClause(final JvmExecutable it, final ITreeAppendable appendable) {
    final LinkedHashMap<JvmType,JvmTypeReference> toBeGenerated = CollectionLiterals.<JvmType, JvmTypeReference>newLinkedHashMap();
    EList<JvmTypeReference> _exceptions = it.getExceptions();
    final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
      public void apply(final JvmTypeReference it) {
        JvmType _type = it.getType();
        boolean _containsKey = toBeGenerated.containsKey(_type);
        boolean _not = (!_containsKey);
        if (_not) {
          JvmType _type_1 = it.getType();
          toBeGenerated.put(_type_1, it);
        }
      }
    };
    IterableExtensions.<JvmTypeReference>forEach(_exceptions, _function);
    Collection<JvmTypeReference> _values = toBeGenerated.values();
    final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
      public void apply(final LoopParams it) {
        it.setPrefix(" throws ");
        it.setSeparator(", ");
      }
    };
    final Procedure2<JvmTypeReference,ITreeAppendable> _function_2 = new Procedure2<JvmTypeReference,ITreeAppendable>() {
      public void apply(final JvmTypeReference it, final ITreeAppendable app) {
        ITreeAppendable _trace = app.trace(it);
        JvmType _type = it.getType();
        _trace.append(_type);
      }
    };
    this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, _values, _function_1, _function_2);
  }
  
  public void generateParameters(final JvmExecutable it, final ITreeAppendable appendable) {
    EList<JvmFormalParameter> _parameters = it.getParameters();
    boolean _isEmpty = _parameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      int _size = _parameters_1.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          EList<JvmFormalParameter> _parameters_2 = it.getParameters();
          int _size_1 = _parameters_2.size();
          final boolean last = (((i).intValue() + 1) == _size_1);
          EList<JvmFormalParameter> _parameters_3 = it.getParameters();
          final JvmFormalParameter p = _parameters_3.get((i).intValue());
          boolean _and = false;
          if (!last) {
            _and = false;
          } else {
            boolean _isVarArgs = it.isVarArgs();
            _and = (last && _isVarArgs);
          }
          this.generateParameter(p, appendable, _and);
          if ((!last)) {
            appendable.append(", ");
          }
        }
      }
    }
  }
  
  public void generateParameter(final JvmFormalParameter it, final ITreeAppendable appendable, final boolean vararg) {
    appendable.append(" ");
    String _simpleName = it.getSimpleName();
    String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
    final String name = appendable.declareVariable(it, _makeJavaIdentifier);
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(appendable, it);
    _traceSignificant.append(name);
  }
  
  public boolean hasBody(final JvmExecutable it) {
    boolean _or = false;
    boolean _or_1 = false;
    StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
    boolean _notEquals = (!Objects.equal(_compilationTemplate, null));
    if (_notEquals) {
      _or_1 = true;
    } else {
      Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
      boolean _notEquals_1 = (!Objects.equal(_compilationStrategy, null));
      _or_1 = (_notEquals || _notEquals_1);
    }
    if (_or_1) {
      _or = true;
    } else {
      XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _notEquals_2 = (!Objects.equal(_associatedExpression, null));
      _or = (_or_1 || _notEquals_2);
    }
    return _or;
  }
  
  public void generateExecutableBody(final JvmExecutable op, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(op);
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      final Iterable<Issue> errors = this._errorSafeExtensions.getErrors(op);
      boolean _isEmpty = IterableExtensions.isEmpty(errors);
      if (_isEmpty) {
        ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
        ITreeAppendable _append = _increaseIndentation.append("{");
        _append.newLine();
        Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(op);
        _compilationStrategy_1.apply(appendable);
        ITreeAppendable _decreaseIndentation = appendable.decreaseIndentation();
        ITreeAppendable _newLine = _decreaseIndentation.newLine();
        _newLine.append("}");
      } else {
        this.generateBodyWithIssues(appendable, errors);
      }
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(op);
      boolean _notEquals_1 = (!Objects.equal(_compilationTemplate, null));
      if (_notEquals_1) {
        final Iterable<Issue> errors_1 = this._errorSafeExtensions.getErrors(op);
        boolean _isEmpty_1 = IterableExtensions.isEmpty(errors_1);
        if (_isEmpty_1) {
          ITreeAppendable _increaseIndentation_1 = appendable.increaseIndentation();
          ITreeAppendable _append_1 = _increaseIndentation_1.append("{");
          _append_1.newLine();
          this.appendCompilationTemplate(appendable, op);
          ITreeAppendable _decreaseIndentation_1 = appendable.decreaseIndentation();
          ITreeAppendable _newLine_1 = _decreaseIndentation_1.newLine();
          _newLine_1.append("}");
        } else {
          this.generateBodyWithIssues(appendable, errors_1);
        }
      } else {
        final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(op);
        boolean _and = false;
        boolean _notEquals_2 = (!Objects.equal(expression, null));
        if (!_notEquals_2) {
          _and = false;
        } else {
          boolean _isGenerateExpressions = false; //config.isGenerateExpressions();
          _and = (_notEquals_2 && _isGenerateExpressions);
        }
        if (_and) {
          final Iterable<Issue> errors_2 = this._errorSafeExtensions.getErrors(expression);
          boolean _isEmpty_2 = IterableExtensions.isEmpty(errors_2);
          if (_isEmpty_2) {
            JvmTypeReference _switchResult = null;
            boolean _matched = false;
            if (!_matched) {
              if (op instanceof JvmOperation) {
                _matched=true;
                JvmTypeReference _returnType = ((JvmOperation)op).getReturnType();
                _switchResult = _returnType;
              }
            }
            if (!_matched) {
              if (op instanceof JvmConstructor) {
                _matched=true;
                JvmTypeReference _typeForName = this._typeReferences.getTypeForName(Void.TYPE, op);
                _switchResult = _typeForName;
              }
            }
            if (!_matched) {
              _switchResult = null;
            }
            final JvmTypeReference returnType = _switchResult;
            boolean _and_1 = false;
            boolean _and_2 = false;
            if (!(expression instanceof XBlockExpression)) {
              _and_2 = false;
            } else {
              EList<XExpression> _expressions = ((XBlockExpression) expression).getExpressions();
              int _size = _expressions.size();
              boolean _notEquals_3 = (_size != 1);
              _and_2 = ((expression instanceof XBlockExpression) && _notEquals_3);
            }
            if (!_and_2) {
              _and_1 = false;
            } else {
              _and_1 = (_and_2 && (returnType instanceof JvmVoid));
            }
            if (_and_1) {
              final XBlockExpression block = ((XBlockExpression) expression);
              EList<XExpression> _expressions_1 = block.getExpressions();
              boolean _isEmpty_3 = _expressions_1.isEmpty();
              if (_isEmpty_3) {
                appendable.append("{}");
              } else {
                EList<JvmTypeReference> _exceptions = op.getExceptions();
                Set<JvmTypeReference> _set = IterableExtensions.<JvmTypeReference>toSet(_exceptions);
                this.compiler.compile(expression, appendable, returnType, _set);
              }
            } else {
              ITreeAppendable _append_2 = appendable.append("{");
              _append_2.increaseIndentation();
              EList<JvmTypeReference> _exceptions_1 = op.getExceptions();
              Set<JvmTypeReference> _set_1 = IterableExtensions.<JvmTypeReference>toSet(_exceptions_1);
              this.compiler.compile(expression, appendable, returnType, _set_1);
              ITreeAppendable _decreaseIndentation_2 = appendable.decreaseIndentation();
              ITreeAppendable _newLine_2 = _decreaseIndentation_2.newLine();
              _newLine_2.append("}");
            }
          } else {
            this.generateBodyWithIssues(appendable, errors_2);
          }
        } else {
          if ((op instanceof JvmOperation)) {
            ITreeAppendable _increaseIndentation_2 = appendable.increaseIndentation();
            ITreeAppendable _append_3 = _increaseIndentation_2.append("{");
            _append_3.newLine();
            appendable.append("throw new UnsupportedOperationException(\"");
            String _simpleName = ((JvmOperation)op).getSimpleName();
            appendable.append(_simpleName);
            appendable.append(" is not implemented\");");
            ITreeAppendable _decreaseIndentation_3 = appendable.decreaseIndentation();
            ITreeAppendable _newLine_3 = _decreaseIndentation_3.newLine();
            _newLine_3.append("}");
          } else {
            if ((op instanceof JvmConstructor)) {
              ITreeAppendable _append_4 = appendable.append("{");
              ITreeAppendable _newLine_4 = _append_4.newLine();
              _newLine_4.append("}");
            }
          }
        }
      }
    }
  }
  
  public ITreeAppendable generateBodyWithIssues(final ITreeAppendable appendable, final Iterable<Issue> errors) {
    ITreeAppendable _xblockexpression = null;
    {
      ITreeAppendable _append = appendable.append("{");
      ITreeAppendable _increaseIndentation = _append.increaseIndentation();
      ITreeAppendable _newLine = _increaseIndentation.newLine();
      _newLine.append("throw new Error(\"Unresolved compilation problems:\"");
      appendable.increaseIndentation();
      final Procedure1<Issue> _function = new Procedure1<Issue>() {
        public void apply(final Issue it) {
          ITreeAppendable _newLine = appendable.newLine();
          ITreeAppendable _append = _newLine.append("+ \"\\n");
          String _message = it.getMessage();
          String _doConvertToJavaString = JvmModelGenerator.this.doConvertToJavaString(_message);
          ITreeAppendable _append_1 = _append.append(_doConvertToJavaString);
          _append_1.append("\"");
        }
      };
      IterableExtensions.<Issue>forEach(errors, _function);
      ITreeAppendable _append_1 = appendable.append(");");
      ITreeAppendable _decreaseIndentation = _append_1.decreaseIndentation();
      ITreeAppendable _decreaseIndentation_1 = _decreaseIndentation.decreaseIndentation();
      ITreeAppendable _newLine_1 = _decreaseIndentation_1.newLine();
      ITreeAppendable _append_2 = _newLine_1.append("}");
      _xblockexpression = (_append_2);
    }
    return _xblockexpression;
  }
  
  /**
   * Convert a given input string to a Java string. Non-ascii characters will
   * be replaced by a unicode escape sequence by default.
   */
  protected String doConvertToJavaString(final String input) {
    String _convertToJavaString = Strings.convertToJavaString(input, true);
    return _convertToJavaString;
  }
  
  public void generateFileHeader(final JvmDeclaredType it, final ITreeAppendable appendable) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<FileHeaderAdapter> _filter = Iterables.<FileHeaderAdapter>filter(_eAdapters, FileHeaderAdapter.class);
    final FileHeaderAdapter fileHeaderAdapter = IterableExtensions.<FileHeaderAdapter>head(_filter);
    String _headerText = null;
    if (fileHeaderAdapter!=null) {
      _headerText=fileHeaderAdapter.getHeaderText();
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_headerText);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      String _headerText_1 = fileHeaderAdapter.getHeaderText();
      Resource _eResource = it.eResource();
      List<INode> _fileHeaderNodes = this.fileHeaderProvider.getFileHeaderNodes(_eResource);
      this.generateDocumentation(_headerText_1, _fileHeaderNodes, appendable);
    }
  }
  
  public void generateJavaDoc(final EObject it, final ITreeAppendable appendable) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<DocumentationAdapter> _filter = Iterables.<DocumentationAdapter>filter(_eAdapters, DocumentationAdapter.class);
    final DocumentationAdapter adapter = IterableExtensions.<DocumentationAdapter>head(_filter);
    String _documentation = null;
    if (adapter!=null) {
      _documentation=adapter.getDocumentation();
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_documentation);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      final Set<EObject> sourceElements = this.jvmModelAssociations.getSourceElements(it);
      boolean _and = false;
      int _size = sourceElements.size();
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        _and = (_equals && (this.documentationProvider instanceof IEObjectDocumentationProviderExtension));
      }
      if (_and) {
        EObject _head = IterableExtensions.<EObject>head(sourceElements);
        final List<INode> documentationNodes = ((IEObjectDocumentationProviderExtension) this.documentationProvider).getDocumentationNodes(_head);
        this.addJavaDocImports(it, appendable, documentationNodes);
        String _documentation_1 = adapter.getDocumentation();
        this.generateDocumentation(_documentation_1, documentationNodes, appendable);
      } else {
        String _documentation_2 = adapter.getDocumentation();
        List<INode> _emptyList = CollectionLiterals.<INode>emptyList();
        this.generateDocumentation(_documentation_2, _emptyList, appendable);
      }
    }
  }
  
  public void addJavaDocImports(final EObject it, final ITreeAppendable appendable, final List<INode> documentationNodes) {
    for (final INode node : documentationNodes) {
      List<ReplaceRegion> _computeTypeRefRegions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(node);
      for (final ReplaceRegion region : _computeTypeRefRegions) {
        {
          final String text = region.getText();
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(text, null));
          if (!_notEquals) {
            _and = false;
          } else {
            int _length = text.length();
            boolean _greaterThan = (_length > 0);
            _and = (_notEquals && _greaterThan);
          }
          if (_and) {
            final QualifiedName fqn = this.qualifiedNameConverter.toQualifiedName(text);
            final EObject context = NodeModelUtils.findActualSemanticObjectFor(node);
            boolean _and_1 = false;
            int _segmentCount = fqn.getSegmentCount();
            boolean _equals = (_segmentCount == 1);
            if (!_equals) {
              _and_1 = false;
            } else {
              boolean _notEquals_1 = (!Objects.equal(context, null));
              _and_1 = (_equals && _notEquals_1);
            }
            if (_and_1) {
              final IScope scope = this.scopeProvider.getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
              final IEObjectDescription candidate = scope.getSingleElement(fqn);
              boolean _notEquals_2 = (!Objects.equal(candidate, null));
              if (_notEquals_2) {
                EObject _xifexpression = null;
                EObject _eObjectOrProxy = candidate.getEObjectOrProxy();
                boolean _eIsProxy = _eObjectOrProxy.eIsProxy();
                if (_eIsProxy) {
                  EObject _eObjectOrProxy_1 = candidate.getEObjectOrProxy();
                  EObject _resolve = EcoreUtil.resolve(_eObjectOrProxy_1, context);
                  _xifexpression = _resolve;
                } else {
                  EObject _eObjectOrProxy_2 = candidate.getEObjectOrProxy();
                  _xifexpression = _eObjectOrProxy_2;
                }
                final JvmType jvmType = ((JvmType) _xifexpression);
                boolean _and_2 = false;
                if (!(jvmType instanceof JvmDeclaredType)) {
                  _and_2 = false;
                } else {
                  boolean _eIsProxy_1 = jvmType.eIsProxy();
                  boolean _not = (!_eIsProxy_1);
                  _and_2 = ((jvmType instanceof JvmDeclaredType) && _not);
                }
                if (_and_2) {
                  final JvmDeclaredType referencedType = ((JvmDeclaredType) jvmType);
                  final JvmDeclaredType contextDeclarator = EcoreUtil2.<JvmDeclaredType>getContainerOfType(it, JvmDeclaredType.class);
                  String _packageName = referencedType.getPackageName();
                  String _packageName_1 = contextDeclarator.getPackageName();
                  boolean _notEquals_3 = (!Objects.equal(_packageName, _packageName_1));
                  if (_notEquals_3) {
                    final ImportManager importManager = this.getImportManager(appendable);
                    importManager.addImportFor(jvmType);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public ImportManager getImportManager(final ITreeAppendable appendable) {
    try {
      ImportManager _xblockexpression = null;
      {
        Class<? extends ITreeAppendable> _class = appendable.getClass();
        final Field stateField = _class.getDeclaredField("state");
        stateField.setAccessible(true);
        final Object stateValue = stateField.get(appendable);
        Class<? extends Object> _class_1 = stateValue.getClass();
        final Field importManagerField = _class_1.getDeclaredField("importManager");
        importManagerField.setAccessible(true);
        Object _get = importManagerField.get(stateValue);
        _xblockexpression = (((ImportManager) _get));
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ITreeAppendable generateDocumentation(final String text, final List<INode> documentationNodes, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      final StringConcatenation doc = ((StringConcatenation) _builder);
      doc.newLine();
      doc.append(" * ");
      doc.append(text, " * ");
      doc.newLine();
      doc.append(" */");
      ITreeAppendable _xifexpression = null;
      boolean _isEmpty = documentationNodes.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        ITreeAppendable _xblockexpression_1 = null;
        {
          ITextRegionWithLineInformation documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION;
          for (final INode node : documentationNodes) {
            ITextRegionWithLineInformation _textRegionWithLineInformation = node.getTextRegionWithLineInformation();
            ITextRegionWithLineInformation _merge = documentationTrace.merge(_textRegionWithLineInformation);
            documentationTrace = _merge;
          }
          LocationData _locationData = new LocationData(documentationTrace, null);
          ITreeAppendable _trace = appendable.trace(_locationData);
          String _string = doc.toString();
          _trace.append(_string);
          ITreeAppendable _newLine = appendable.newLine();
          _xblockexpression_1 = (_newLine);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _string = doc.toString();
        ITreeAppendable _append = appendable.append(_string);
        ITreeAppendable _newLine = _append.newLine();
        _xifexpression = _newLine;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public void generateAnnotations(final Iterable<JvmAnnotationReference> annotations, final ITreeAppendable appendable, final boolean withLineBreak) {
    final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
      public ITreeAppendable apply(final ITreeAppendable it) {
        ITreeAppendable _xifexpression = null;
        if (withLineBreak) {
          ITreeAppendable _newLine = it.newLine();
          _xifexpression = _newLine;
        } else {
          ITreeAppendable _append = it.append(" ");
          _xifexpression = _append;
        }
        return _xifexpression;
      }
    };
    final Function1<ITreeAppendable,ITreeAppendable> sep = _function;
    final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
      public void apply(final LoopParams it) {
        it.setSeparator(sep);
        it.setSuffix(sep);
      }
    };
    final Procedure2<JvmAnnotationReference,ITreeAppendable> _function_2 = new Procedure2<JvmAnnotationReference,ITreeAppendable>() {
      public void apply(final JvmAnnotationReference it, final ITreeAppendable app) {
        JvmModelGenerator.this.generateAnnotation(it, app);
      }
    };
    this._errorSafeExtensions.<JvmAnnotationReference>forEachSafely(appendable, annotations, _function_1, _function_2);
  }
  
  public void generateAnnotation(final JvmAnnotationReference it, final ITreeAppendable appendable) {
    appendable.append("@");
    JvmAnnotationType _annotation = it.getAnnotation();
    appendable.append(_annotation);
    EList<JvmAnnotationValue> _values = it.getValues();
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
      public void apply(final LoopParams it) {
        it.setPrefix("(");
        it.setSeparator(", ");
        it.setSuffix(")");
      }
    };
    final Procedure1<JvmAnnotationValue> _function_1 = new Procedure1<JvmAnnotationValue>() {
      public void apply(final JvmAnnotationValue it) {
//        JvmModelGenerator.this.toJava(it, appendable);
      }
    };
    this._loopExtensions.<JvmAnnotationValue>forEach(appendable, _values, _function, _function_1);
  }
  
  public void toJava(final JvmAnnotationValue it, final ITreeAppendable appendable, GeneratorConfig generatorConfig) {
    JvmField _operation = it.getField();
    boolean _notEquals = (!Objects.equal(_operation, null));
    if (_notEquals) {
    	JvmField _operation_1 = it.getField();
      String _simpleName = _operation_1.getSimpleName();
      appendable.append(_simpleName);
      appendable.append(" = ");
    } else {
      EObject _eContainer = it.eContainer();
      EList<JvmAnnotationValue> _values = ((JvmAnnotationReference) _eContainer).getValues();
      int _size = _values.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        appendable.append("value = ");
      }
    }
    this.toJavaLiteral(it, appendable);
  }
  
  protected void _toJavaLiteral(final JvmAnnotationAnnotationValue value, final ITreeAppendable appendable) {
    EList<JvmAnnotationReference> _values = value.getValues();
    final Procedure1<JvmAnnotationReference> _function = new Procedure1<JvmAnnotationReference>() {
      public void apply(final JvmAnnotationReference it) {
        JvmModelGenerator.this.generateAnnotation(it, appendable);
      }
    };
    this._loopExtensions.<JvmAnnotationReference>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmShortAnnotationValue it, final ITreeAppendable appendable) {
    EList<Short> _values = it.getValues();
    final Procedure1<Short> _function = new Procedure1<Short>() {
      public void apply(final Short it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Short>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmIntAnnotationValue it, final ITreeAppendable appendable) {
    EList<Integer> _values = it.getValues();
    final Procedure1<Integer> _function = new Procedure1<Integer>() {
      public void apply(final Integer it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Integer>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmLongAnnotationValue it, final ITreeAppendable appendable) {
    EList<Long> _values = it.getValues();
    final Procedure1<Long> _function = new Procedure1<Long>() {
      public void apply(final Long it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Long>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmByteAnnotationValue it, final ITreeAppendable appendable) {
    EList<Byte> _values = it.getValues();
    final Procedure1<Byte> _function = new Procedure1<Byte>() {
      public void apply(final Byte it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Byte>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmDoubleAnnotationValue it, final ITreeAppendable appendable) {
    EList<Double> _values = it.getValues();
    final Procedure1<Double> _function = new Procedure1<Double>() {
      public void apply(final Double it) {
        String _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          boolean _isNaN = Double.isNaN((it).doubleValue());
          if (_isNaN) {
            _matched=true;
            _switchResult = "Double.NaN";
          }
        }
        if (!_matched) {
          if (Objects.equal(it,Double.POSITIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Double.POSITIVE_INFINITY";
          }
        }
        if (!_matched) {
          if (Objects.equal(it,Double.NEGATIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Double.NEGATIVE_INFINITY";
          }
        }
        if (!_matched) {
          String _string = it.toString();
          String _plus = (_string + "d");
          _switchResult = _plus;
        }
        appendable.append(_switchResult);
      }
    };
    this._loopExtensions.<Double>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmFloatAnnotationValue it, final ITreeAppendable appendable) {
    EList<Float> _values = it.getValues();
    final Procedure1<Float> _function = new Procedure1<Float>() {
      public void apply(final Float it) {
        String _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          boolean _isNaN = Float.isNaN((it).floatValue());
          if (_isNaN) {
            _matched=true;
            _switchResult = "Float.NaN";
          }
        }
        if (!_matched) {
          if (Objects.equal(it,Float.POSITIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Float.POSITIVE_INFINITY";
          }
        }
        if (!_matched) {
          if (Objects.equal(it,Float.NEGATIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Float.NEGATIVE_INFINITY";
          }
        }
        if (!_matched) {
          String _string = it.toString();
          String _plus = (_string + "f");
          _switchResult = _plus;
        }
        appendable.append(_switchResult);
      }
    };
    this._loopExtensions.<Float>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmCharAnnotationValue it, final ITreeAppendable appendable) {
    EList<Character> _values = it.getValues();
    final Procedure1<Character> _function = new Procedure1<Character>() {
      public void apply(final Character it) {
        String _string = it.toString();
        String _doConvertToJavaString = JvmModelGenerator.this.doConvertToJavaString(_string);
        String _plus = ("\'" + _doConvertToJavaString);
        String _plus_1 = (_plus + "\'");
        appendable.append(_plus_1);
      }
    };
    this._loopExtensions.<Character>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmStringAnnotationValue it, final ITreeAppendable appendable) {
    EList<String> _values = it.getValues();
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String it) {
        String _string = it.toString();
        String _doConvertToJavaString = JvmModelGenerator.this.doConvertToJavaString(_string);
        String _plus = ("\"" + _doConvertToJavaString);
        String _plus_1 = (_plus + "\"");
        appendable.append(_plus_1);
      }
    };
    this._loopExtensions.<String>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmTypeAnnotationValue it, final ITreeAppendable appendable) {
    EList<JvmTypeReference> _values = it.getValues();
    final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
      public void apply(final JvmTypeReference it) {
        JvmType _type = it.getType();
        ITreeAppendable _append = appendable.append(_type);
        _append.append(".class");
      }
    };
    this._loopExtensions.<JvmTypeReference>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmEnumAnnotationValue it, final ITreeAppendable appendable) {
    EList<JvmEnumerationLiteral> _values = it.getValues();
    final Procedure1<JvmEnumerationLiteral> _function = new Procedure1<JvmEnumerationLiteral>() {
      public void apply(final JvmEnumerationLiteral it) {
        JvmDeclaredType _declaringType = it.getDeclaringType();
        appendable.append(_declaringType);
        appendable.append(".");
        String _simpleName = it.getSimpleName();
        appendable.append(_simpleName);
      }
    };
    this._loopExtensions.<JvmEnumerationLiteral>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmBooleanAnnotationValue it, final ITreeAppendable appendable) {
    EList<Boolean> _values = it.getValues();
    final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
      public void apply(final Boolean it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Boolean>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmCustomAnnotationValue it, final ITreeAppendable appendable) {
    EList<Object> _values = it.getValues();
    boolean _isEmpty = _values.isEmpty();
    if (_isEmpty) {
      appendable.append("{}");
    } else {
      EList<Object> _values_1 = it.getValues();
      Iterable<XExpression> _filter = Iterables.<XExpression>filter(_values_1, XExpression.class);
      final Procedure1<XExpression> _function = new Procedure1<XExpression>() {
        public void apply(final XExpression it) {
          JvmModelGenerator.this.compiler.toJavaExpression(it, appendable);
        }
      };
      this._loopExtensions.<XExpression>forEachWithShortcut(appendable, _filter, _function);
    }
  }
  
  public TreeAppendable createAppendable(final EObject context, final ImportManager importManager) {
    TreeAppendable _treeAppendable = new TreeAppendable(importManager, this.converter, this.locationProvider, this.jvmModelAssociations, context, "  ", "\n");
    final TreeAppendable appendable = _treeAppendable;
    final JvmGenericType type = this.containerType(context);
    boolean _notEquals = (!Objects.equal(type, null));
    if (_notEquals) {
      JvmGenericType _containerType = this.containerType(context);
      appendable.declareVariable(_containerType, "this");
      JvmGenericType _containerType_1 = this.containerType(context);
      final JvmTypeReference superType = _containerType_1.getExtendedClass();
      boolean _notEquals_1 = (!Objects.equal(superType, null));
      if (_notEquals_1) {
        JvmType _type = superType.getType();
        appendable.declareVariable(_type, "super");
      }
    }
    return appendable;
  }
  
  public JvmGenericType containerType(final EObject context) {
    JvmGenericType _xifexpression = null;
    boolean _equals = Objects.equal(context, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      JvmGenericType _xifexpression_1 = null;
      if ((context instanceof JvmGenericType)) {
        _xifexpression_1 = ((JvmGenericType)context);
      } else {
        EObject _eContainer = context.eContainer();
        JvmGenericType _containerType = this.containerType(_eContainer);
        _xifexpression_1 = _containerType;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String makeJavaIdentifier(final String name) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(name, null);
    if (_equals) {
      return "__unknown__";
    } else {
      String _xifexpression_1 = null;
      boolean _isJavaKeyword = this.keywords.isJavaKeyword(name);
      if (_isJavaKeyword) {
        _xifexpression_1 = (name + "_");
      } else {
        _xifexpression_1 = name;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmEnumerationType type) {
    Iterable<JvmMember> _xblockexpression = null;
    {
      String _identifier = type.getIdentifier();
      String _plus = (_identifier + ".");
      String _plus_1 = (_plus + "valueOf(java.lang.String)");
      String _identifier_1 = type.getIdentifier();
      String _plus_2 = (_identifier_1 + ".");
      String _plus_3 = (_plus_2 + "values()");
      final Set<String> syntheticEnumMethods = Collections.<String>unmodifiableSet(Sets.<String>newHashSet(_plus_1, _plus_3));
      EList<JvmMember> _members = type.getMembers();
      final Function1<JvmMember,Boolean> _function = new Function1<JvmMember,Boolean>() {
        public Boolean apply(final JvmMember it) {
          boolean _and = false;
          if (!(it instanceof JvmOperation)) {
            _and = false;
          } else {
            String _identifier = it.getIdentifier();
            boolean _contains = syntheticEnumMethods.contains(_identifier);
            _and = ((it instanceof JvmOperation) && _contains);
          }
          boolean _not = (!_and);
          return Boolean.valueOf(_not);
        }
      };
      Iterable<JvmMember> _filter = IterableExtensions.<JvmMember>filter(_members, _function);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmDeclaredType it) {
    EList<JvmMember> _members = it.getMembers();
    final Function1<JvmMember,Boolean> _function = new Function1<JvmMember,Boolean>() {
      public Boolean apply(final JvmMember it) {
        boolean _and = false;
        if (!(it instanceof JvmConstructor)) {
          _and = false;
        } else {
          boolean _isSingleSyntheticDefaultConstructor = JvmModelGenerator.this._jvmTypeExtensions.isSingleSyntheticDefaultConstructor(((JvmConstructor) it));
          _and = ((it instanceof JvmConstructor) && _isSingleSyntheticDefaultConstructor);
        }
        boolean _not = (!_and);
        return Boolean.valueOf(_not);
      }
    };
    Iterable<JvmMember> _filter = IterableExtensions.<JvmMember>filter(_members, _function);
    return _filter;
  }
  
//
//  public ITreeAppendable generateBody(final JvmDeclaredType it, final ITreeAppendable appendable) {
//    if (it instanceof JvmAnnotationType) {
//      return _generateBody((JvmAnnotationType)it, appendable);
//    } else if (it instanceof JvmEnumerationType) {
//      return _generateBody((JvmEnumerationType)it, appendable);
//    } else if (it instanceof JvmGenericType) {
//      return _generateBody((JvmGenericType)it, appendable);
//    } else {
//      throw new IllegalArgumentException("Unhandled parameter types: " +
//        Arrays.<Object>asList(it, appendable).toString());
//    }
//  }
  
  public ITreeAppendable generateModifier(final JvmMember it, final ITreeAppendable appendable) {
    if (it instanceof JvmConstructor) {
      return _generateModifier((JvmConstructor)it, appendable);
    } else if (it instanceof JvmOperation) {
      return _generateModifier((JvmOperation)it, appendable);
    } else if (it instanceof JvmField) {
      return _generateModifier((JvmField)it, appendable);
    } else if (it instanceof JvmGenericType) {
      return _generateModifier((JvmGenericType)it, appendable);
    } else if (it instanceof JvmDeclaredType) {
      return _generateModifier((JvmDeclaredType)it, appendable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
  
  public ITreeAppendable generateMember(final JvmMember it, final ITreeAppendable appendable) {
    if (it instanceof JvmConstructor) {
      return _generateMember((JvmConstructor)it, appendable);
    } else if (it instanceof JvmOperation) {
      return _generateMember((JvmOperation)it, appendable);
    } else if (it instanceof JvmField) {
      return _generateMember((JvmField)it, appendable);
    } else if (it instanceof JvmGenericType) {
      return _generateMember((JvmGenericType)it, appendable);
    } else if (it != null) {
      return _generateMember(it, appendable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
  
  public void toJavaLiteral(final JvmAnnotationValue value, final ITreeAppendable appendable) {
    if (value instanceof JvmAnnotationAnnotationValue) {
      _toJavaLiteral((JvmAnnotationAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmBooleanAnnotationValue) {
      _toJavaLiteral((JvmBooleanAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmByteAnnotationValue) {
      _toJavaLiteral((JvmByteAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmCharAnnotationValue) {
      _toJavaLiteral((JvmCharAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmCustomAnnotationValue) {
      _toJavaLiteral((JvmCustomAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmDoubleAnnotationValue) {
      _toJavaLiteral((JvmDoubleAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmEnumAnnotationValue) {
      _toJavaLiteral((JvmEnumAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmFloatAnnotationValue) {
      _toJavaLiteral((JvmFloatAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmIntAnnotationValue) {
      _toJavaLiteral((JvmIntAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmLongAnnotationValue) {
      _toJavaLiteral((JvmLongAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmShortAnnotationValue) {
      _toJavaLiteral((JvmShortAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmStringAnnotationValue) {
      _toJavaLiteral((JvmStringAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmTypeAnnotationValue) {
      _toJavaLiteral((JvmTypeAnnotationValue)value, appendable);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value, appendable).toString());
    }
  }
  
  public Iterable<JvmMember> getMembersToBeCompiled(final JvmDeclaredType type) {
    if (type instanceof JvmEnumerationType) {
      return _getMembersToBeCompiled((JvmEnumerationType)type);
    } else if (type != null) {
      return _getMembersToBeCompiled(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
