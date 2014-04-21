/**
 */
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Annotation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated NOT
 */
public class JvmAnnotationTypeImpl extends JvmDeclaredTypeImplCustom implements JvmAnnotationType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmAnnotationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_ANNOTATION_TYPE;
	}

	public JvmAnnotationTarget getAnnotationInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAnnotationInfo(JvmAnnotationTarget value) {
		// TODO Auto-generated method stub
		
	}

	public EList<String> getModifiers() {
		// TODO Auto-generated method stub
		return null;
	}

} //JvmAnnotationTypeImpl
