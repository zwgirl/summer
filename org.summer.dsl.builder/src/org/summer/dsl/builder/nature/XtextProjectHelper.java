package org.summer.dsl.builder.nature;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextProjectHelper {

	public static final String NATURE_ID = "org.summer.dsl.ui.shared.xtextNature"; //$NON-NLS-1$
	public static final String BUILDER_ID = "org.summer.dsl.ui.shared.xtextBuilder"; //$NON-NLS-1$

	private static final Logger log = Logger.getLogger(XtextProjectHelper.class);

	public static boolean hasNature(IProject project) {
		try {
			if (project.isAccessible()) {
				return project.hasNature(NATURE_ID);
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * @since 2.4
	 */
	public static boolean hasBuilder(IProject project) {
		if (project.isAccessible()) {
			try {
				for (ICommand command : project.getDescription().getBuildSpec()) {
					if (BUILDER_ID.equals(command.getBuilderName())) {
						return true;
					}
				}
			} catch (CoreException e) {
				log.error("Can't build due to an exception.", e);
			}
		}
		return false;
	}

}
