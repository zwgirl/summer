package org.summer.ss.ide.wizards;

import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;

import com.google.inject.Inject;

/**
 * @author Robert von Massow - Initial contribution and API
 * @author Holger Schill
 */
public class NewSsClassWizard extends AbstractNewSsElementWizard {

	public static final String TITLE = "Xtend Class"; //$NON-NLS-1$

	@Inject
	public NewSsClassWizard(IImageDescriptorHelper imgHelper, NewSsClassWizardPage page) {
		super(imgHelper, page, TITLE);
	}
}
