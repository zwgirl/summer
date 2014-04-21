package org.summer.ss.ide.codebuilder

import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import java.util.Set
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.summer.dsl.model.types.JvmTypeParameter
import org.summer.dsl.model.types.xtext.ui.JdtVariableCompletions
import org.summer.dsl.xbase.compiler.ISourceAppender
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference

import static org.summer.dsl.model.types.JvmVisibility.*
import org.eclipse.emf.ecore.EObject

/**
 * @author Jan Koehnlein
 */
abstract class AbstractExecutableBuilder extends AbstractCodeBuilder {
	
	public static val DEFAULT_BODY = 'throw new UnsupportedOperationException("TODO: auto-generated method stub")'

	@Inject extension JdtVariableCompletions
	@Inject extension CodeBuilderFactory 

	@Property List<AbstractParameterBuilder> parameterBuilders = emptyList
	@Property List<LightweightTypeReference> exceptions = emptyList
	@Property List<JvmTypeParameter> typeParameters = emptyList
	@Property String body
	@Property boolean varArgsFlag

	def appendBody(ISourceAppender appendable, String statementSeparator) {
		appendable.append(' {').increaseIndentation.newLine.append(body ?: defaultBody).append(statementSeparator).
			decreaseIndentation.newLine.append('}')
	}

	def protected String defaultBody() {
		DEFAULT_BODY		
	}

	override setContext(EObject ctx) {
		super.setContext(ctx)
		parameterBuilders.forEach[context = ctx]
	}

	def newParameterBuilder() {
		if(parameterBuilders.empty)
			parameterBuilders = newArrayList
		val builder = createParameterBuilder(owner)
		builder.context = context
		parameterBuilders.add(builder)
		builder
	}

	def protected appendParameters(ISourceAppender appendable) {
		appendable.append("(")
		val notAllowed = newHashSet
		if(!parameterBuilders.isEmpty)
			parameterBuilders.last.varArgsFlag = varArgsFlag
		for (i : 0 ..< parameterBuilders.size) {
			val parameterBuilder = parameterBuilders.get(i)
			val acceptor = new VariableNameAcceptor(notAllowed)
			if(parameterBuilder.name == null) {
				getVariableProposals(parameterBuilder.type.identifier, context,
					JdtVariableCompletions.VariableType.PARAMETER, notAllowed, acceptor)
				parameterBuilder.name = acceptor.variableName
			}
			parameterBuilder.build(appendable)
			if (i != parameterBuilders.size - 1)
				appendable.append(", ")
		}
		appendable.append(")")
	}

	def protected appendThrowsClause(ISourceAppender appendable) {
		val iterator = exceptions.iterator
		if (iterator.hasNext()) {
			appendable.append(" throws ")
			do {
				val typeRef = iterator.next()
				if (typeRef != null) {
					appendable.appendType(typeRef, "Exception")
				}
				if (iterator.hasNext())
					appendable.append(", ")
			} while (iterator.hasNext())
		}
		appendable
	}

	override getImage() {
		switch visibility {
			case PRIVATE: 'methpri_obj.gif'
//			case PROTECTED: 'methpro_obj.gif'  //cym comment
			case PUBLIC: 'methpub_obj.gif'
			default: 'methdef_obj.gif'
		}
	}
	
	override isValid() {
		parameterBuilders.forall[isValid]
		 && !exceptions.contains(null)
		 && !typeParameters.contains(null)
		 && super.isValid
	}

}

class VariableNameAcceptor implements JdtVariableCompletions.CompletionDataAcceptor {

	val Set<String> notallowed
	val Set<String> variableNames = newHashSet()

	new(Set<String> notallowed) {
		this.notallowed = notallowed;
	}

	override accept(String replaceText, StyledString label, Image img) {
		variableNames.add(replaceText);
		notallowed.add(replaceText);
	}

	def getVariableName() {
		val candidates = Lists.newArrayList(variableNames);
		Collections.sort(candidates, [left, right|left.length() - right.length()])
		if (candidates.size > 0)
			return candidates.get(0)
		return ""
	}
}


