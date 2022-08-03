package de.ubt.ai1.mule.ui.wizard;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

import de.ubt.ai1.mule.validation.ReservedNames;

@SuppressWarnings("restriction")
public class MuLEWizardNewProjectCreationPage extends WizardNewProjectCreationPage {

	public MuLEWizardNewProjectCreationPage(String pageName) {
		super(pageName);
		setPageComplete(false);
	}

	@Override
	protected boolean validatePage() {
		IWorkspace workspace = IDEWorkbenchPlugin.getPluginWorkspace();
//		System.out.println(getProjectName());

		String projectFieldContents = getProjectName();
		
		if (projectFieldContents.equals("")) { //$NON-NLS-1$
			setErrorMessage(null);
			setMessage(IDEWorkbenchMessages.WizardNewProjectCreationPage_projectNameEmpty);
			return false;
		}
		
		if (projectFieldContents.endsWith("src")) { //$NON-NLS-1$
			setErrorMessage("Project name may not end with src.");
			return false;
		}
		
		if (!projectFieldContents.matches("\\S+")) {
			setErrorMessage("Project name may not contain whitespaces.");
			return false;			
		}		
		
		if (!projectFieldContents.matches("[a-zA-Z_][a-z0-9A-Z_.]*(/[a-z][a-z0-9_.]*)*")) {
			setErrorMessage("Invalid project name.");
			return false;			
		}
		
		if (Arrays.asList(ReservedNames.reservedJavaKeywords).contains(projectFieldContents) || Arrays.asList(ReservedNames.reservedMuLEKeywords).contains(projectFieldContents)) {
			setErrorMessage("Invalid project name.");
			return false;			
		}
		
		IStatus nameStatus = workspace.validateName(projectFieldContents, IResource.PROJECT);
		if (!nameStatus.isOK()) {
			setErrorMessage(nameStatus.getMessage());
			return false;
		}

		IProject handle = getProjectHandle();
		if (handle.exists()) {
			setErrorMessage(IDEWorkbenchMessages.WizardNewProjectCreationPage_projectExistsMessage);
			return false;
		}

//		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
//		locationArea.setExistingProject(project);
//
//		String validLocationMessage = locationArea.checkValidLocation();
//		if (validLocationMessage != null) { // there is no destination location given
//			setErrorMessage(validLocationMessage);
//			return false;
//		}

		setErrorMessage(null);
		setMessage(null);
		return true;
	}
}
