package org.summer.dsl.xtype.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xtype.XExportDeclaration;
import org.summer.dsl.model.xtype.XExportItem;
import org.summer.dsl.model.xtype.XExportSection;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.model.xtype.XImportDeclaration1;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection1;
import org.summer.dsl.model.xtype.XtypePackage;
import org.summer.dsl.xtype.services.XtypeGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractXtypeSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private XtypeGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_LOWER_BOUND:
				if(context == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				if(context == grammarAccess.getJvmTypeParameterRule()) {
					sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_UPPER_BOUND:
				if(context == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmWildcardTypeReferenceRule()) {
					sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XEXPORT_DECLARATION:
				if(context == grammarAccess.getXExportDeclarationRule()) {
					sequence_XExportDeclaration(context, (XExportDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XEXPORT_ITEM:
				if(context == grammarAccess.getXExportItemRule()) {
					sequence_XExportItem(context, (XExportItem) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XEXPORT_SECTION:
				if(context == grammarAccess.getXExportSectionRule()) {
					sequence_XExportSection(context, (XExportSection) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XFUNCTION_TYPE_REF:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getXFunctionTypeRefRule()) {
					sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_DECLARATION1:
				if(context == grammarAccess.getXImportDeclaration1Rule()) {
					sequence_XImportDeclaration1(context, (XImportDeclaration1) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_ITEM:
				if(context == grammarAccess.getXImportItemRule()) {
					sequence_XImportItem(context, (XImportItem) semanticObject); 
					return; 
				}
				else break;
			case XtypePackage.XIMPORT_SECTION1:
				if(context == grammarAccess.getXImportSection1Rule()) {
					sequence_XImportSection1(context, (XImportSection1) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 */
	protected void sequence_JvmLowerBound(EObject context, JvmLowerBound semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?)
	 */
	protected void sequence_JvmParameterizedTypeReference(EObject context, JvmParameterizedTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*)?)
	 */
	protected void sequence_JvmTypeParameter(EObject context, JvmTypeParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     componentType=JvmTypeReference_JvmGenericArrayTypeReference_0_1_0_0
	 */
	protected void sequence_JvmTypeReference(EObject context, JvmGenericArrayTypeReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(), semanticObject.getComponentType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 */
	protected void sequence_JvmUpperBoundAnded(EObject context, JvmUpperBound semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 */
	protected void sequence_JvmUpperBound(EObject context, JvmUpperBound semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((constraints+=JvmUpperBound | constraints+=JvmLowerBound)?)
	 */
	protected void sequence_JvmWildcardTypeReference(EObject context, JvmWildcardTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((exportItems+=XExportItem exportItems+=XExportItem* importURI=STRING?) | (importURI=STRING alias=ID))
	 */
	protected void sequence_XExportDeclaration(EObject context, XExportDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exportedId=[JvmIdentifiableElement|ID] alias=ID?)
	 */
	protected void sequence_XExportItem(EObject context, XExportItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     exportDeclarations+=XExportDeclaration+
	 */
	protected void sequence_XExportSection(EObject context, XExportSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((paramTypes+=JvmTypeReference paramTypes+=JvmTypeReference*)? returnType=JvmTypeReference)
	 */
	protected void sequence_XFunctionTypeRef(EObject context, XFunctionTypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((importItems+=XImportItem importItems+=XImportItem*) | wildcard?='*') name=ValidID importURI=STRING)
	 */
	protected void sequence_XImportDeclaration1(EObject context, XImportDeclaration1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (importedId=[JvmIdentifiableElement|ID] alias=ID?)
	 */
	protected void sequence_XImportItem(EObject context, XImportItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importDeclarations+=XImportDeclaration1+
	 */
	protected void sequence_XImportSection1(EObject context, XImportSection1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
