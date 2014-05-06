/*
* generated by Xtext
*/
package org.summer.ss.ide.outline;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.summer.ss.core.jvmmodel.DispatchHelper;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.ss.ide.labeling.SsImages;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmTypeReference;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.summer.dsl.xbase.jvmmodel.JvmTypeExtensions;
import org.summer.dsl.xbase.ui.labeling.XbaseImageAdornments;
import org.summer.dsl.model.xtype.XtypePackage;

import com.google.inject.Inject;

/**
 * Customization of the default outline structure.
 * 
 * @author Jan Koehnlein
 */
public class SsOutlineTreeProvider extends BackgroundOutlineTreeProvider implements  
	IOutlineTreeProvider.ModeAware {

	private static final OutlineMode HIDE_INHERITED_MODE = new OutlineMode("hide", "hide inherited members");

	private static final OutlineMode SHOW_INHERITED_MODE = new OutlineMode("show", "show inherited members");

	private static final List<OutlineMode> MODES = newArrayList(HIDE_INHERITED_MODE, SHOW_INHERITED_MODE);

	@Inject
	private SsImages images;

	@Inject
	private XbaseImageAdornments adornments;

//	@Inject
//	private IXtendJvmAssociations associations;

	@Inject
	private DispatchHelper dispatchHelper;

	@Inject
	private JvmTypeExtensions typeExtensions;

	@Inject 
	private SsOutlineNodeFactory factory;
	
	//cym modified
//	@Override
//	protected void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
//		if(modelElement instanceof XtendFile) {
//			XtendFile xtendFile = (XtendFile) modelElement;
//			if (xtendFile.getPackage() != null)
//				factory.createEStructuralFeatureNode(parentNode, xtendFile, SsPackage.Literals.XTEND_FILE__PACKAGE,
//						images.forPackage(), xtendFile.getPackage(), true);
//			if (xtendFile.getImportSection() != null && !xtendFile.getImportSection().getImportDeclarations().isEmpty())
//				factory.createEStructuralFeatureNode(parentNode, xtendFile.getImportSection(),
//						XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, images.forImportContainer(),
//						"import declarations", false);
//			
//			for (XtendTypeDeclaration xtendType : xtendFile.getXtendTypes()) {
//				EObjectNode classNode = createNode(parentNode, xtendType);
//				createFeatureNodes(classNode, xtendType);
//			}
//		}
//	}
	
	@Override
	protected void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		if(modelElement instanceof XModule) {
			XModule xModule = (XModule) modelElement;
			if (xModule.getPackage() != null)
				factory.createEStructuralFeatureNode(parentNode, xModule, SsPackage.Literals.XMODULE__PACKAGE,
						images.forPackage(), xModule.getPackage(), true);
			if (xModule.getImportSection() != null && !xModule.getImportSection().getImportDeclarations().isEmpty())
				factory.createEStructuralFeatureNode(parentNode, xModule.getImportSection(),
						XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, images.forImportContainer(),
						"import declarations", false);
			
			for (EObject obj : xModule.getContents()) {
				if(obj instanceof JvmDeclaredType){
					EObjectNode classNode = createNode(parentNode, obj);
					createFeatureNodes(classNode, (JvmDeclaredType) obj);
				}
			}
		}
	}
	//cym modified
//	protected void createFeatureNodes(IOutlineNode parentNode, XtendTypeDeclaration xtendType) {
//		final JvmDeclaredType inferredType = associations.getInferredType(xtendType);
//		if (inferredType != null) {
//			Set<JvmFeature> processedFeatures = newHashSet();
//			createFeatureNodesForType(parentNode, xtendType, inferredType, inferredType, processedFeatures, 0);
//		} else {
//			for (XtendMember member : xtendType.getMembers())
//				createNode(parentNode, member);
//		}
//	}
	
	protected void createFeatureNodes(IOutlineNode parentNode, JvmDeclaredType inferredType) {
			Set<JvmFeature> processedFeatures = newHashSet();
			createFeatureNodesForType(parentNode, inferredType, inferredType, processedFeatures, 0);
	}
	//cym modified
//	protected void createFeatureNodesForType(IOutlineNode parentNode, XtendTypeDeclaration xtendType,
//			JvmDeclaredType inferredType, final JvmDeclaredType baseType, Set<JvmFeature> processedFeatures, int inheritanceDepth) {
//		if (xtendType instanceof XtendClass) {
//			for(JvmOperation operation: inferredType.getDeclaredOperations()) {
//				if(dispatchHelper.isDispatcherFunction(operation)) {
//					JvmOperation dispatcher = operation;
//					SsFeatureNode dispatcherNode = createNodeForFeature(parentNode, baseType, dispatcher,
//							dispatcher, inheritanceDepth);
//					if (dispatcherNode != null) {
//						dispatcherNode.setDispatch(true);
//						processedFeatures.add(dispatcher);
//						boolean inheritsDispatchCases = false;
//						Iterable<JvmOperation> dispatchCases;
//						if (getCurrentMode() == SHOW_INHERITED_MODE)
//							dispatchCases = dispatchHelper.getAllDispatchCases(dispatcher);
//						else {
//							dispatchCases = newArrayList(dispatchHelper.getLocalDispatchCases(dispatcher));
//							sort((List<JvmOperation>) dispatchCases, new Comparator<JvmOperation>() {
//								public int compare(JvmOperation o1, JvmOperation o2) {
//									return baseType.getMembers().indexOf(o1) - baseType.getMembers().indexOf(o2);
//								}
//							});
//						}
//						for (JvmOperation dispatchCase : dispatchCases) {
//							inheritsDispatchCases |= dispatchCase.getDeclaringType() != baseType;
//							XtendFunction xtendFunction = associations.getXtendFunction(dispatchCase);
//							if (xtendFunction == null) {
//								createNodeForFeature(dispatcherNode, baseType, dispatchCase, dispatchCase,
//										inheritanceDepth);
//							} else {
//								createNodeForFeature(dispatcherNode, baseType, dispatchCase, xtendFunction,
//										inheritanceDepth);
//							}
//							processedFeatures.add(dispatchCase);
//						}
//						if(inheritsDispatchCases) 
//							dispatcherNode.setImageDescriptor(images.forDispatcherFunction(dispatcher.getVisibility(), 
//									adornments.get(dispatcher) | JavaElementImageDescriptor.OVERRIDES));
//					}
//				}
//			}
//		}
//		for (JvmFeature feature : filter(inferredType.getMembers(), JvmFeature.class)) {
//			if (!processedFeatures.contains(feature)) {
//				EObject primarySourceElement = associations.getPrimarySourceElement(feature);
//				createNodeForFeature(parentNode, baseType, feature,
//						primarySourceElement != null ? primarySourceElement : feature, inheritanceDepth);
//			}
//		}
//		if (getCurrentMode() == SHOW_INHERITED_MODE) {
//			if (inferredType instanceof JvmGenericType) {
//				JvmTypeReference extendedClass = ((JvmGenericType) inferredType).getExtendedClass();
//				if (extendedClass != null) 
//					createInheritedFeatureNodes(parentNode, baseType, processedFeatures, inheritanceDepth,
//							extendedClass);
//				for(JvmTypeReference extendedInterface: ((JvmGenericType) inferredType).getExtendedInterfaces()) {
//					createInheritedFeatureNodes(parentNode, baseType, processedFeatures, inheritanceDepth,
//							extendedInterface);
//				}
//			}
//		}
//	}
	
	protected void createFeatureNodesForType(IOutlineNode parentNode, /*XtendTypeDeclaration xtendType,*/
			JvmDeclaredType inferredType, final JvmDeclaredType baseType, Set<JvmFeature> processedFeatures, int inheritanceDepth) {
//		if (xtendType instanceof XtendClass) {
			for(JvmOperation operation: inferredType.getDeclaredOperations()) {
				if(dispatchHelper.isDispatcherFunction(operation)) {
					JvmOperation dispatcher = operation;
					SsFeatureNode dispatcherNode = createNodeForFeature(parentNode, baseType, dispatcher,
							dispatcher, inheritanceDepth);
					if (dispatcherNode != null) {
						dispatcherNode.setDispatch(true);
						processedFeatures.add(dispatcher);
						boolean inheritsDispatchCases = false;
						Iterable<JvmOperation> dispatchCases;
						if (getCurrentMode() == SHOW_INHERITED_MODE)
							dispatchCases = dispatchHelper.getAllDispatchCases(dispatcher);
						else {
							dispatchCases = newArrayList(dispatchHelper.getLocalDispatchCases(dispatcher));
							sort((List<JvmOperation>) dispatchCases, new Comparator<JvmOperation>() {
								public int compare(JvmOperation o1, JvmOperation o2) {
									return baseType.getMembers().indexOf(o1) - baseType.getMembers().indexOf(o2);
								}
							});
						}
						for (JvmOperation dispatchCase : dispatchCases) {
							inheritsDispatchCases |= dispatchCase.getDeclaringType() != baseType;
//							XtendFunction xtendFunction = associations.getXtendFunction(dispatchCase);
//							if (xtendFunction == null) {
//								createNodeForFeature(dispatcherNode, baseType, dispatchCase, dispatchCase,
//										inheritanceDepth);
//							} else {
								createNodeForFeature(dispatcherNode, baseType, dispatchCase, dispatchCase,
										inheritanceDepth);
//							}
							processedFeatures.add(dispatchCase);
						}
						if(inheritsDispatchCases) 
							dispatcherNode.setImageDescriptor(images.forDispatcherFunction(dispatcher.getVisibility(), 
									adornments.get(dispatcher) | JavaElementImageDescriptor.OVERRIDES));
					}
				}
			}
//		}
		for (JvmFeature feature : filter(inferredType.getMembers(), JvmFeature.class)) {
			if (!processedFeatures.contains(feature)) {
//				EObject primarySourceElement = associations.getPrimarySourceElement(feature);
				createNodeForFeature(parentNode, baseType, feature,
						feature, inheritanceDepth);
			}
		}
		if (getCurrentMode() == SHOW_INHERITED_MODE) {
			if (inferredType instanceof JvmGenericType) {
				JvmTypeReference extendedClass = ((JvmGenericType) inferredType).getExtendedClass();
				if (extendedClass != null) 
					createInheritedFeatureNodes(parentNode, baseType, processedFeatures, inheritanceDepth,
							extendedClass);
				for(JvmTypeReference extendedInterface: ((JvmGenericType) inferredType).getExtendedInterfaces()) {
					createInheritedFeatureNodes(parentNode, baseType, processedFeatures, inheritanceDepth,
							extendedInterface);
				}
			}
		}
	}

//	protected void createInheritedFeatureNodes(IOutlineNode parentNode, JvmDeclaredType baseType,
//			Set<JvmFeature> processedFeatures, int inheritanceDepth, JvmTypeReference superType) {
//		if(superType.getType() instanceof JvmDeclaredType) {
//			JvmDeclaredType superClass = ((JvmGenericType) superType.getType());
//			EObject xtendSuperClass = associations.getPrimarySourceElement(superType.getType());
//			createFeatureNodesForType(parentNode, (XtendTypeDeclaration) xtendSuperClass,
//					superClass, baseType, processedFeatures, inheritanceDepth + 1);
//		}
//	}
	
	protected void createInheritedFeatureNodes(IOutlineNode parentNode, JvmDeclaredType baseType,
			Set<JvmFeature> processedFeatures, int inheritanceDepth, JvmTypeReference superType) {
		if(superType.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType superClass = ((JvmGenericType) superType.getType());
//			EObject xtendSuperClass = associations.getPrimarySourceElement(superType.getType());
			createFeatureNodesForType(parentNode, /*(XtendTypeDeclaration) xtendSuperClass,*/
					superClass, baseType, processedFeatures, inheritanceDepth + 1);
		}
	}

	protected SsFeatureNode createNodeForFeature(IOutlineNode parentNode, final JvmDeclaredType inferredType,
			JvmFeature jvmFeature, EObject semanticFeature, int inheritanceDepth) {
		final boolean synthetic = typeExtensions.isSynthetic(jvmFeature);
		Object text = getText(synthetic ? jvmFeature : semanticFeature);
		ImageDescriptor image = getImageDescriptor(synthetic ? jvmFeature : semanticFeature);
		if (jvmFeature.getDeclaringType() != inferredType) {
			if (getCurrentMode() == SHOW_INHERITED_MODE) {
				StyledString label = (text instanceof StyledString) ? (StyledString) text : new StyledString(
						text.toString());
				label.append(new StyledString(" - " + jvmFeature.getDeclaringType().getIdentifier(),
						StyledString.COUNTER_STYLER));
				return factory.createXtendFeatureNode(parentNode, jvmFeature, image, label, true, synthetic, inheritanceDepth);
			}
			return null;
		} else {
			return factory.createXtendFeatureNode(parentNode, semanticFeature, image, text, true, synthetic, inheritanceDepth);
		}
	}

	private int currentModeIndex = 0;

	public List<OutlineMode> getOutlineModes() {
		return MODES;
	}
	
	public OutlineMode getCurrentMode() {
		return getOutlineModes().get(currentModeIndex);
	}
	
	public OutlineMode getNextMode() {
		return getOutlineModes().get((currentModeIndex + 1) % getOutlineModes().size());
	}
	
	public void setCurrentMode(OutlineMode outlineMode) {
		int newIndex = getOutlineModes().indexOf(outlineMode);
		if(newIndex != -1)
			currentModeIndex = newIndex;
	}
}
