package org.summer.dsl.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmDelegateType;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author cym
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class JvmDelegateComputationState extends AbstractRootTypeComputationState {
	private JvmDelegateType delegate;
	public JvmDelegateComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmDelegateType delegate) {
		super(resolvedTypes, featureScopeSession);
		this.delegate = delegate;
//		for(JvmFormalParameter parameter: delegate.getParameters()) {
//			addLocalToCurrentScope(parameter);
//		}
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result;
		if (type != null) {
			result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState, true);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		return null;
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(delegate, resolvedTypes.getReferenceOwner());
	}
	
	//cym added
	@Override
	protected XExpression getRootExpression() {
		return null;
	}
}
