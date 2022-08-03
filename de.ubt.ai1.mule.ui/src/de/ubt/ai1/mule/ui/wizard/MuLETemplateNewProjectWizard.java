package de.ubt.ai1.mule.ui.wizard;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.ui.wizard.template.TemplateNewProjectWizard;

@SuppressWarnings("restriction")
public class MuLETemplateNewProjectWizard extends TemplateNewProjectWizard {

	@Override
	protected WizardNewProjectCreationPage createMainPage(String pageName) {
		try {
			PlatformUI.getWorkbench().showPerspective("de.ubt.ai1.mule.ui.perspectives.MuLEPerspective", PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		} catch (WorkbenchException e) {
			e.printStackTrace();
		}
		return new MuLEWizardNewProjectCreationPage(pageName);
	}
}
