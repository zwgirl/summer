/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Set;

import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator.IQuantities;
import org.eclipse.xtext.validation.impl.AssignmentQuantityIntervalProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(AssignmentQuantityIntervalProvider.class)
public interface IAssignmentQuantityIntervalProvider {
	int MAX = Integer.MAX_VALUE;

	int UNDEF = -1;

	int getMin(IQuantities ctx, ISyntaxConstraint assignment, Set<ISyntaxConstraint> involved);

	int getMax(IQuantities ctx, ISyntaxConstraint assignment, Set<ISyntaxConstraint> involved, String excludeFeature);
}
