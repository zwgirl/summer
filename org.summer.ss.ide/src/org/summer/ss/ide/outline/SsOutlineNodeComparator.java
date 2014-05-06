package org.summer.ss.ide.outline;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XbasePackage;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsOutlineNodeComparator extends SortOutlineContribution.DefaultComparator {
	@Override
	public int getCategory(IOutlineNode node) {
		if(node instanceof SsFeatureNode) 
			return internalGetCategory(node) + 100 * ((SsFeatureNode)node).getInheritanceDepth();
		else
			return internalGetCategory(node);
	}
	
	//cym comment
//	protected int internalGetCategory(IOutlineNode node) {
//		if (node instanceof EStructuralFeatureNode) {
//			EStructuralFeature feature = ((EStructuralFeatureNode) node).getEStructuralFeature();
//			if (feature == SsPackage.Literals.XMODULE__PACKAGE)
//				return 0;
//			else
//				return 10;
//		}
//		boolean isStatic = node instanceof SsFeatureNode && ((SsFeatureNode) node).isStatic();
//		if (node instanceof EObjectNode) {
//			EClass eClass = ((EObjectNode) node).getEClass();
//			if (eClass == SsPackage.Literals.XTEND_CLASS)
//				return 20;
//			if (eClass == SsPackage.Literals.XTEND_FIELD || eClass == TypesPackage.Literals.JVM_FIELD) 
//				return isStatic ? 30 : 50;
//			if (eClass == SsPackage.Literals.XTEND_CONSTRUCTOR || eClass == TypesPackage.Literals.JVM_CONSTRUCTOR)
//				return 60;
//			if (eClass == SsPackage.Literals.XTEND_FUNCTION || eClass == TypesPackage.Literals.JVM_OPERATION) {
//				if(isStatic) 
//					return 40; 
//				else 
//					return (node instanceof SsFeatureNode && ((SsFeatureNode) node).isDispatch()) ? 70 : 80;
//			}
//		}
//		return Integer.MAX_VALUE;
//	}
	
	protected int internalGetCategory(IOutlineNode node) {
		if (node instanceof EStructuralFeatureNode) {
			EStructuralFeature feature = ((EStructuralFeatureNode) node).getEStructuralFeature();
			if (feature == SsPackage.Literals.XMODULE__PACKAGE)
				return 0;
			else
				return 10;
		}
		boolean isStatic = node instanceof SsFeatureNode && ((SsFeatureNode) node).isStatic();
		if (node instanceof EObjectNode) {
			EClass eClass = ((EObjectNode) node).getEClass();
			if (eClass == TypesPackage.Literals.JVM_GENERIC_TYPE)
				return 20;
			if (eClass == TypesPackage.Literals.JVM_FIELD) 
				return isStatic ? 30 : 50;
			if (eClass == TypesPackage.Literals.JVM_CONSTRUCTOR)
				return 60;
			if (eClass == TypesPackage.Literals.JVM_OPERATION) {
				if(isStatic) 
					return 40; 
				else 
					return (node instanceof SsFeatureNode && ((SsFeatureNode) node).isDispatch()) ? 70 : 80;
			}
		}
		return Integer.MAX_VALUE;
	}

}
