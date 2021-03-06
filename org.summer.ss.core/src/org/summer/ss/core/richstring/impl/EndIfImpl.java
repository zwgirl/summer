/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.ss.core.richstring.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.summer.ss.core.richstring.EndIf;
import org.summer.ss.core.richstring.IfConditionStart;
import org.summer.ss.core.richstring.ProcessedRichStringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.ss.core.richstring.impl.EndIfImpl#getIfConditionStart <em>If Condition Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndIfImpl extends LinePartImpl implements EndIf
{
	/**
	 * The cached value of the '{@link #getIfConditionStart() <em>If Condition Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfConditionStart()
	 * @generated
	 * @ordered
	 */
	protected IfConditionStart ifConditionStart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndIfImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ProcessedRichStringPackage.Literals.END_IF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfConditionStart getIfConditionStart()
	{
		if (ifConditionStart != null && ifConditionStart.eIsProxy())
		{
			InternalEObject oldIfConditionStart = (InternalEObject)ifConditionStart;
			ifConditionStart = (IfConditionStart)eResolveProxy(oldIfConditionStart);
			if (ifConditionStart != oldIfConditionStart)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessedRichStringPackage.END_IF__IF_CONDITION_START, oldIfConditionStart, ifConditionStart));
			}
		}
		return ifConditionStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfConditionStart basicGetIfConditionStart()
	{
		return ifConditionStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfConditionStart(IfConditionStart newIfConditionStart)
	{
		IfConditionStart oldIfConditionStart = ifConditionStart;
		ifConditionStart = newIfConditionStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessedRichStringPackage.END_IF__IF_CONDITION_START, oldIfConditionStart, ifConditionStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ProcessedRichStringPackage.END_IF__IF_CONDITION_START:
				if (resolve) return getIfConditionStart();
				return basicGetIfConditionStart();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ProcessedRichStringPackage.END_IF__IF_CONDITION_START:
				setIfConditionStart((IfConditionStart)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ProcessedRichStringPackage.END_IF__IF_CONDITION_START:
				setIfConditionStart((IfConditionStart)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ProcessedRichStringPackage.END_IF__IF_CONDITION_START:
				return ifConditionStart != null;
		}
		return super.eIsSet(featureID);
	}

} //EndIfImpl
