/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GrammarAliasFactory;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISerState.SerStateType;
import org.eclipse.xtext.serializer.sequencer.RuleCallStack;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaToProduction;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class SyntacticSequencerPDAProvider implements ISyntacticSequencerPDAProvider {

	protected static class NavigablePDA implements Pda<ISynState, RuleCall> {

		protected ISynNavigable navigable;

		public NavigablePDA(ISynNavigable navigable) {
			super();
			this.navigable = navigable;
		}

		public ISynState getStop() {
			return navigable.getTarget();
		}

		public Iterable<ISynState> getFollowers(ISynState node) {
			if (node instanceof ISynAbsorberState) {
				if (navigable instanceof ISynTransition && ((ISynTransition) navigable).getSource() == node)
					return navigable.getFollowers();
				return Collections.emptyList();
			}
			return node.getFollowers();
		}

		public RuleCall getPop(ISynState state) {
			return state.getType() == SynStateType.UNASSIGNED_PARSER_RULE_EXIT ? (RuleCall) state.getGrammarElement()
					: null;
		}

		public RuleCall getPush(ISynState state) {
			return state.getType() == SynStateType.UNASSIGNED_PARSER_RULE_ENTER ? (RuleCall) state.getGrammarElement()
					: null;
		}

		public ISynState getStart() {
			if (navigable instanceof ISynTransition)
				return ((ISynTransition) navigable).getSource();
			return (ISynState) navigable;
		}

	}

	protected static class SynAbsorberState extends SynState implements ISynAbsorberState {

		protected EObject context;

		protected EClass eClass;

		protected Map<AbstractElement, ISynTransition> outTransitionsByElement = Maps.newHashMap();

		protected List<ISynAbsorberState> outAbsorber = Lists.newArrayList();

		public SynAbsorberState(SynStateType type, AbstractElement element, EObject context, EClass eClass) {
			super(type, element);
			this.context = context;
			this.eClass = eClass;
		}

		protected void addTransition(ISynTransition transition) {
			addFollower(transition.getFollowers());
			outAbsorber.add(transition.getTarget());
			switch (transition.getTarget().getType().getSimpleType()) {
				case START:
					throw new UnsupportedOperationException("StartStates can not have incoming transitions");
				case ELEMENT:
				case STOP:
					if (outTransitionsByElement.isEmpty())
						outTransitionsByElement = Maps.newHashMap();
					outTransitionsByElement.put(transition.getTarget().getGrammarElement(), transition);
					break;
				case RULECALL_ENTER:
				case RULECALL_EXIT:
			}

		}

		public EObject getContext() {
			return context;
		}

		public EClass getEClass() {
			return eClass;
		}

		public List<ISynTransition> getOutTransitions() {
			List<ISynTransition> result = Lists.newArrayList();
			result.addAll(outTransitionsByElement.values());
			return result;
		}

		public Map<AbstractElement, ISynTransition> getOutTransitionsByElement() {
			return outTransitionsByElement;
		}

		public List<ISynAbsorberState> getOutAbsorbers() {
			return outAbsorber;
		}

	}

	protected static class SynEmitterState extends SynNavigable implements ISynEmitterState {

		public SynEmitterState(SynStateType type, AbstractElement element, SynAbsorberState target) {
			super(type, element, target);
		}

	}

	protected static class SynNavigable extends SynState implements ISynNavigable {

		protected final static List<ISynState> RULE_EXIT_DEPENDENT = Lists.newArrayList();

		protected int distanceToAbsorber = -1;

		protected Boolean involvesRuleExit;

		protected Boolean involvesUnassignedTokenRuleCalls = null;

		protected List<ISynState> shortestPathToAbsorber = null;

		protected Boolean syntacticallyAmbiguous = null;

		protected ISynAbsorberState target;

		public SynNavigable(SynStateType type, AbstractElement element, ISynAbsorberState target) {
			super(type, element);
			this.target = target;
		}

		public EObject getContext() {
			return target.getContext();
		}

		public EClass getEClass() {
			return target.getEClass();
		}

		public Pda<ISynState, RuleCall> getPathToTarget() {
			return new NavigablePDA(this);
		}

		public List<ISynState> getShortestPathTo(final AbstractElement ele, RuleCallStack stack) {
			return shortestPathTo(stack.iterator(), new Predicate<ISynState>() {
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele;
				}
			}, true);
		}

		public List<ISynState> getShortestPathToAbsorber(RuleCallStack stack) {
			if (involvesRuleExit())
				return shortestPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()), false);
			if (shortestPathToAbsorber == null)
				shortestPathToAbsorber = shortestPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()),
						false);
			return shortestPathToAbsorber;
		}

		public List<ISynState> getShortestStackpruningPathTo(final AbstractElement ele, RuleCallStack stack) {
			return shortestStackpruningPathTo(stack.iterator(), new Predicate<ISynState>() {
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele;
				}
			}, true);
		}

		public List<ISynState> getShortestStackpruningPathToAbsorber(RuleCallStack stack) {
			if (involvesRuleExit())
				return shortestStackpruningPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()), false);
			if (shortestPathToAbsorber == null)
				shortestPathToAbsorber = shortestPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()),
						false);
			return shortestPathToAbsorber;
		}

		public ISynAbsorberState getTarget() {
			return target;
		}

		public boolean hasEmitters() {
			if (getFollowers().size() == 1 && getFollowers().get(0) instanceof ISynAbsorberState)
				return false;
			return true;
		}

		protected boolean involves(ISynState from, Set<SynStateType> types, Set<ISynState> visited) {
			if (types.contains(from.getType()))
				return true;
			if (!visited.add(from))
				return false;
			for (ISynState state : from.getFollowers())
				if (!(state instanceof ISynAbsorberState) && involves(state, types, visited))
					return true;
			return false;
		}

		protected boolean involves(Set<SynStateType> types) {
			Set<ISynState> visited = Sets.newHashSet();
			for (ISynState state : followers)
				if (involves(state, types, visited))
					return true;
			return false;
		}

		protected Boolean involvesRuleExit() {
			if (involvesRuleExit == null)
				involvesRuleExit = involves(EnumSet.of(SynStateType.UNASSIGNED_PARSER_RULE_EXIT));
			return involvesRuleExit;
		}

		public boolean involvesUnassignedTokenRuleCalls() {
			if (involvesUnassignedTokenRuleCalls == null)
				involvesUnassignedTokenRuleCalls = involves(EnumSet.of(SynStateType.UNASSIGNED_DATATYPE_RULE_CALL,
						SynStateType.UNASSIGNED_TERMINAL_RULE_CALL));
			return involvesUnassignedTokenRuleCalls;
		}

		public boolean isSyntacticallyAmbiguous() {
			if (syntacticallyAmbiguous == null)
				syntacticallyAmbiguous = isSyntacticallyAmbiguous(followers);
			return syntacticallyAmbiguous;
		}

		protected boolean isSyntacticallyAmbiguous(ISynState state, RuleCallStack exits, RuleCallStack stack,
				List<RuleCallStack> results, Set<ISynState> visited) {
			if (!visited.add(state))
				return true;
			if (state instanceof ISynAbsorberState) {
				results.add(exits);
				return false;
			}
			switch (state.getType().getSimpleType()) {
				case RULECALL_ENTER:
					stack = stack.cloneAndPush((RuleCall) state.getGrammarElement());
					break;
				case RULECALL_EXIT:
					RuleCall rc = (RuleCall) state.getGrammarElement();
					if (!stack.isEmpty()) {
						if (rc == stack.peek())
							stack = stack.cloneAndPop();
						else
							return false;
					} else {
						if (exits.contains(rc))
							return false;
						else {
							visited = Sets.newHashSet();
							exits = exits.cloneAndPush(rc);
						}
					}
					break;
				default:
					break;
			}
			for (ISynState follower : state.getFollowers())
				if (isSyntacticallyAmbiguous(follower, exits, stack, results, visited))
					return true;
			return false;
		}

		protected boolean isSyntacticallyAmbiguous(List<ISynState> states) {
			RuleCallStack exits = new RuleCallStack();
			RuleCallStack stack = new RuleCallStack();
			List<RuleCallStack> results = Lists.newArrayList();
			Set<ISynState> visited = Sets.newHashSet();
			for (ISynState state : states)
				if (isSyntacticallyAmbiguous(state, exits, stack, results, visited))
					return true;
			return results.size() != Sets.newHashSet(results).size();
		}

		protected List<ISynState> shortestPathTo(Iterator<RuleCall> stack, Predicate<ISynState> matches,
				boolean includeMatch) {
			List<ISynState> pathTo = new PdaUtil().shortestPathTo(getPathToTarget(), stack, matches);
			if (pathTo != null)
				return pathTo.subList(1, pathTo.size() - (includeMatch ? 0 : 1));
			return null;
		}

		protected List<ISynState> shortestStackpruningPathTo(Iterator<RuleCall> stack, Predicate<ISynState> matches,
				boolean includeMatch) {
			List<ISynState> pathTo = new PdaUtil().shortestStackpruningPathTo(getPathToTarget(), stack, matches);
			if (pathTo != null)
				return pathTo.subList(1, pathTo.size() - (includeMatch ? 0 : 1));
			return null;
		}

	}

	protected abstract static class SynState implements ISynState {

		protected AbstractElement element;

		protected List<ISynState> followers = Collections.emptyList();

		protected SynStateType type;

		public SynState(SynStateType type, AbstractElement element) {
			super();
			this.type = type;
			this.element = element;
			this.followers = Collections.emptyList();
		}

		protected void addFollower(ISynState follower) {
			if (followers.isEmpty())
				followers = Lists.newArrayList();
			followers.add(follower);
		}

		protected void addFollower(List<ISynState> follower) {
			if (followers.isEmpty())
				followers = Lists.newArrayList();
			followers.addAll(follower);
		}

		public List<ISynState> getFollowers() {
			return followers;
		}

		public AbstractElement getGrammarElement() {
			return element;
		}

		public SynStateType getType() {
			return type;
		}

		protected void setFollowers(List<ISynState> followers) {
			this.followers = followers;
		}

		@Override
		public String toString() {
			return toString(new GrammarElementTitleSwitch().showAssignments().showQualified());
		}

		public String toString(Function<AbstractElement, String> elementFormatter) {
			if (type == null)
				return "(type is null)";
			switch (type.getSimpleType()) {
				case ELEMENT:
					return element == null ? "(null)" : elementFormatter.apply(element);
				case RULECALL_ENTER:
					return ">>" + (element == null ? "(null)" : elementFormatter.apply(element));
				case RULECALL_EXIT:
					return "<<" + (element == null ? "(null)" : elementFormatter.apply(element));
				case START:
					return "start";
				case STOP:
					return "stop";
			}
			return "";
		}

	}

	protected static class SynTransition extends SynNavigable implements ISynTransition {

		private final static class Filter implements Predicate<ISynState> {
			public boolean apply(ISynState input) {
				AbstractElement ge = input.getGrammarElement();
				return ge instanceof Keyword || GrammarUtil.isDatatypeRuleCall(ge) || GrammarUtil.isEnumRuleCall(ge)
						|| GrammarUtil.isTerminalRuleCall(ge);
			}
		}

		protected static final AbstractElementAlias UNINITIALIZED = new TokenAlias(false, false, null);

		protected AbstractElementAlias ambiguousSyntax = UNINITIALIZED;

		protected List<AbstractElementAlias> ambiguousSyntaxes;

		protected ISynAbsorberState source;

		public SynTransition(ISynAbsorberState source, ISynAbsorberState target) {
			super(SynStateType.TRANSITION, null, target);
			this.source = source;
		}

		public AbstractElementAlias getAmbiguousSyntax() {
			if (ambiguousSyntax != UNINITIALIZED)
				return ambiguousSyntax;
			ambiguousSyntax = getShortSyntax();
			if (ambiguousSyntax instanceof GroupAlias) {
				GroupAlias group = (GroupAlias) ambiguousSyntax;
				List<AbstractElementAlias> children = group.getChildren();
				int start = 0;
				while (start < children.size() && children.get(start) instanceof TokenAlias
						&& !children.get(start).isMany() && !children.get(start).isOptional())
					start++;
				int end = children.size() - 1;
				while (end >= 0 && children.get(end) instanceof TokenAlias && !children.get(end).isMany()
						&& !children.get(end).isOptional())
					end--;
				if (start <= end) {
					ambiguousSyntax = group = new GroupAlias(false, false, children.subList(start, end + 1));
					if (group.children.size() == 1)
						ambiguousSyntax = group.children.get(0);
				} else
					ambiguousSyntax = null;
			}
			return ambiguousSyntax;
		}

		public List<AbstractElementAlias> getAmbiguousSyntaxes() {
			if (ambiguousSyntaxes != null)
				return ambiguousSyntaxes;
			if (!isSyntacticallyAmbiguous())
				return ambiguousSyntaxes = Collections.emptyList();
			ambiguousSyntaxes = Lists.newArrayList();
			Nfa<ISynState> nfa = new PdaUtil().filterUnambiguousPaths(getPathToTarget());
			nfa = new NfaUtil().filter(nfa, new Filter());
			AbstractElementAlias syntax = new NfaToProduction().nfaToGrammar(nfa, new GetGrammarElement(),
					new GrammarAliasFactory());
			if (syntax instanceof GroupAlias) {
				GroupAlias group = (GroupAlias) syntax;
				for (AbstractElementAlias child : group.getChildren())
					if (child.isMany() || child.isOptional() || child instanceof AlternativeAlias)
						ambiguousSyntaxes.add(child);
			} else
				ambiguousSyntaxes.add(syntax);
			return ambiguousSyntaxes;
		}

		public AbstractElementAlias getShortSyntax() {
			Nfa<ISynState> path = new NfaUtil().filter(getPathToTarget(), new Filter());
			return new NfaToProduction().nfaToGrammar(path, new GetGrammarElement(), new GrammarAliasFactory());
		}

		public ISynAbsorberState getSource() {
			return source;
		}

		public AbstractElementAlias getSyntax() {
			Pda<ISynState, RuleCall> pathToTarget = getPathToTarget();
			return new NfaToProduction().nfaToGrammar(pathToTarget, new GetGrammarElement(), new GrammarAliasFactory());
		}

		@Override
		public String toString() {
			return getSyntax().toString();
		}

	}

	protected Map<Pair<EObject, EClass>, ISynAbsorberState> cache = Maps.newHashMap();

	//	protected SequencerPDAProvider pdaProvider = createSequencerPDAProvider();
	@Inject
	protected ContextTypePDAProvider pdaProvider;

	protected boolean canReachAbsorber(ISerState from, ISerState to, Set<ISerState> visited) {
		if (isMandatoryAbsorber(from.getGrammarElement()) || !visited.add(from))
			return false;
		for (ISerState follower : from.getFollowers())
			if (follower == to)
				return true;
			else if (canReachAbsorber(follower, to, visited))
				return true;
		return false;
	}

	protected void collectFollowingAbsorberStates(ISerState state, boolean collect, Set<ISerState> visited,
			Set<ISerState> absorber) {
		if (collect) {
			if (!visited.add(state))
				return;
			if (isMandatoryAbsorber(state.getGrammarElement()) || state.getType() == SerStateType.STOP) {
				absorber.add(state);
				return;
			} else if (isOptionalAbsorber(state.getGrammarElement()))
				absorber.add(state);
		}
		for (ISerState follower : state.getFollowers())
			collectFollowingAbsorberStates(follower, true, visited, absorber);
	}

	protected SynAbsorberState createAbsorberState(ISerState state, Map<ISerState, SynAbsorberState> absorbers,
			Map<SynAbsorberState, Map<ISerState, SynState>> emitters, EObject context, EClass eClass) {
		SynAbsorberState result = absorbers.get(state);
		if (result != null)
			return result;
		if (state.getType() == SerStateType.STOP) {
			absorbers.put(state, result = createAbsorberState(SynStateType.STOP, null, context, eClass));
			return result;
		}
		absorbers.put(state, result = createAbsorberState(getType(state), state.getGrammarElement(), context, eClass));
		Set<ISerState> followers = Sets.newHashSet();
		collectFollowingAbsorberStates(state, false, Sets.<ISerState> newHashSet(), followers);
		for (ISerState follower : followers) {
			SynAbsorberState target = createAbsorberState(follower, absorbers, emitters, context, eClass);
			SynTransition transition = createTransition(result, target);
			Map<ISerState, SynState> emitter = emitters.get(target);
			if (emitter == null)
				emitters.put(target, emitter = Maps.newHashMap());
			transition.setFollowers(createEmitterStates(state, follower, target, emitter));
			result.addTransition(transition);
		}
		return result;
	}

	protected SynAbsorberState createAbsorberState(SynStateType type, AbstractElement element, EObject context,
			EClass eClass) {
		return new SynAbsorberState(type, element, context, eClass);
	}

	protected SynState createEmitterState(SynStateType type, AbstractElement element, SynAbsorberState target) {
		return new SynEmitterState(type, element, target);
	}

	protected List<ISynState> createEmitterStates(ISerState from, ISerState to, SynAbsorberState target,
			Map<ISerState, SynState> emitters) {
		List<ISynState> result = Lists.newArrayList();
		for (ISerState next : from.getFollowers())
			if (next == to)
				result.add(target);
			else if (canReachAbsorber(next, to, Sets.<ISerState> newHashSet())) {
				SynState emitter = emitters.get(next);
				if (emitter == null) {
					emitters.put(next, emitter = createEmitterState(getType(next), next.getGrammarElement(), target));
					emitter.setFollowers(createEmitterStates(next, to, target, emitters));
				}
				result.add(emitter);
			}
		return result;
	}

	//	protected SequencerNFAProvider createSequenceParserNFAProvider() {
	//		return new SequencerNFAProvider();
	//	}
	//
	//	protected SequencerPDAProvider createSequencerPDAProvider() {
	//		return new SequencerPDAProvider(createSequenceParserNFAProvider());
	//	}

	protected SynTransition createTransition(SynAbsorberState source, SynAbsorberState target) {
		return new SynTransition(source, target);
	}

	public ISynAbsorberState getPDA(EObject context, EClass type) {
		//		SequencerPDAContext ctx = new SequencerPDAContext(context, type);
		Pair<EObject, EClass> key = Tuples.create(context, type);
		ISynAbsorberState result = cache.get(key);
		if (result == null) {
			Map<ISerState, SynAbsorberState> absorbers = Maps.newHashMap();
			Map<SynAbsorberState, Map<ISerState, SynState>> emitters = Maps.newHashMap();
			Pda<? extends ISerState, RuleCall> pda = pdaProvider.getContextTypePDA(context, type);
			result = createAbsorberState(pda.getStart(), absorbers, emitters, context, type);
			cache.put(key, result);
		}
		return result;
	}

	protected SynStateType getType(ISerState state) {
		switch (state.getType()) {
			case ELEMENT:
				AbstractElement ele = state.getGrammarElement();
				Assignment ass;
				if (ele instanceof Action) {
					if (((Action) ele).getFeature() == null)
						return SynStateType.UNASSIGEND_ACTION_CALL;
					else
						return SynStateType.ASSIGNED_ACTION_CALL;
				} else if (GrammarUtil.containingCrossReference(ele) != null) {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule)
							return SynStateType.ASSIGNED_CROSSREF_DATATYPE_RULE_CALL;
						if (rc.getRule() instanceof TerminalRule)
							return SynStateType.ASSIGNED_CROSSREF_TERMINAL_RULE_CALL;
						if (rc.getRule() instanceof EnumRule)
							return SynStateType.ASSIGNED_CROSSREF_ENUM_RULE_CALL;
					} else if (ele instanceof Keyword)
						return SynStateType.ASSIGNED_CROSSREF_KEYWORD;
				} else if ((ass = GrammarUtil.containingAssignment(ele)) != null) {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule) {
							if (rc.getRule().getType().getClassifier() instanceof EClass)
								return SynStateType.ASSIGNED_PARSER_RULE_CALL;
							return SynStateType.ASSIGNED_DATATYPE_RULE_CALL;
						}
						if (rc.getRule() instanceof TerminalRule)
							return SynStateType.ASSIGNED_TERMINAL_RULE_CALL;
						if (rc.getRule() instanceof EnumRule)
							return SynStateType.ASSIGNED_ENUM_RULE_CALL;

					} else if (ele instanceof Keyword) {
						if (GrammarUtil.isBooleanAssignment(ass))
							return SynStateType.ASSIGNED_BOOLEAN_KEYWORD;
						else
							return SynStateType.ASSIGNED_KEYWORD;
					}
				} else {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule)
							return SynStateType.UNASSIGNED_DATATYPE_RULE_CALL;
						if (rc.getRule() instanceof TerminalRule)
							return SynStateType.UNASSIGNED_TERMINAL_RULE_CALL;
					} else if (ele instanceof Keyword)
						return SynStateType.UNASSIGEND_KEYWORD;
				}
				break;
			case PUSH:
				return SynStateType.UNASSIGNED_PARSER_RULE_ENTER;
			case POP:
				return SynStateType.UNASSIGNED_PARSER_RULE_EXIT;
			case START:
				return SynStateType.START;
			case STOP:
				return SynStateType.STOP;
		}
		throw new RuntimeException("no type found for " + state);
	}

	protected boolean isMandatoryAbsorber(AbstractElement ele) {
		if (ele == null)
			return true;
		if (GrammarUtil.isAssigned(ele))
			return true;
		if (GrammarUtil.isAssignedAction(ele))
			return true;
		//		if (GrammarUtil.isDatatypeRuleCall(ele))
		//			return true;
		return false;
	}

	protected boolean isOptionalAbsorber(AbstractElement ele) {
		return false;
	}

}
