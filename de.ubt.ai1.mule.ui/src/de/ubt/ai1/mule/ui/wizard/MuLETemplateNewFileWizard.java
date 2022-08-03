package de.ubt.ai1.mule.ui.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ui.util.FileOpener;
import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider;
import org.eclipse.xtext.ui.wizard.template.Messages;
import org.eclipse.xtext.ui.wizard.template.NewFileWizardPrimaryPage;
import org.eclipse.xtext.ui.wizard.template.TemplateFileInfo;
import org.eclipse.xtext.ui.wizard.template.TemplateLabelProvider;
import org.eclipse.xtext.ui.wizard.template.TemplateNewFileWizard;
import org.eclipse.xtext.ui.wizard.template.TemplateParameterPage;
import org.eclipse.xtext.ui.wizard.template.TemplateVariable;
import org.eclipse.xtext.ui.wizard.template.WorkspaceFileGenerator;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class MuLETemplateNewFileWizard extends Wizard implements INewWizard {

	private static final String FILE_TEMPLATE_PROVIDER_EXTENSION_POINT_ID = "org.eclipse.xtext.ui.fileTemplate"; //$NON-NLS-1$
	private static final String FILE_TEMPLATE_PROVIDER_ID = "fileTemplateProvider"; //$NON-NLS-1$
	private static final String FILE_TEMPLATE_PROVIDER_GRAMMAR_NAME_ATTRIBUTE = "grammarName"; //$NON-NLS-1$
	private static final String FILE_TEMPLATE_PROVIDER_GRAMMAR_CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	private static final Logger logger = Logger.getLogger(TemplateNewFileWizard.class);

	protected IStructuredSelection selection;

	protected MuLENewFileWizardPrimaryPage mainPage;
	protected TemplateParameterPage templateParameterPage;

	@Inject
	private TemplateLabelProvider labelProvider;
	@Inject
	private FileOpener fileOpener;
	@Inject
	private IGrammarAccess grammarAccess;

	private IWorkbench workbench;

	private AbstractFileTemplate[] templates;

	public MuLETemplateNewFileWizard() {
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.TemplateNewFileWizard_title);
	}

	/**
	 * Use this method to add pages to the wizard. The one-time generated version of this class will add a default new project page to the
	 * wizard.
	 */
	@Override
	public void addPages() {
		templates = loadTemplatesFromExtensionPoint();

		mainPage = createMainPage("basicNewFilePage"); //$NON-NLS-1$
		addPage(mainPage);

		setForcePreviousAndNextButtons(hasMoreThenOneTemplate());
	}


	protected MuLENewFileWizardPrimaryPage createMainPage(String pageName) {
//		NewFileWizardPrimaryPage page = super.createMainPage(pageName);
		MuLENewFileWizardPrimaryPage promPage = new MuLENewFileWizardPrimaryPage(pageName, templates, selection, labelProvider);
		return promPage;
	}
	

	protected String getGrammarName() {
		return grammarAccess.getGrammar().getName();
	}

	protected TemplateFileInfo getFileInfo() {
		return mainPage.getFileInfo();
	}

	@Override
	public boolean performFinish() {
		final TemplateFileInfo info = getFileInfo();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(info, monitor);
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage(), e);
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage()); //$NON-NLS-1$
			return false;
		}
		return true;
	}

	protected void doFinish(final TemplateFileInfo info, final IProgressMonitor monitor) {
		try {
//			AbstractFileTemplate fileTemplate = info.getFileTemplate();
			WorkspaceFileGenerator fileGenerator = new WorkspaceFileGenerator();
//			fileTemplate.setTemplateInfo(info);
//			fileTemplate.generateFiles(fileGenerator);
			generateFile(fileGenerator, info);
			fileGenerator.run(monitor);
			fileOpener.selectAndReveal(fileGenerator.getResult());
			fileOpener.openFileToEdit(getShell(), fileGenerator.getResult());
		} catch (final InvocationTargetException e) {
			logger.error(e.getMessage(), e);
		} catch (final InterruptedException e) {
			// cancelled by user, ok
			return;
		}
	}
	
	private void generateFile(WorkspaceFileGenerator fileGenerator, TemplateFileInfo info) {
	    StringConcatenation _builder = new StringConcatenation();
	    String _folder = info.getFolder();
	    _builder.append(_folder);
	    _builder.append("/");
	    String _name = info.getName();
	    _builder.append(_name);
	    _builder.append(".mule");
	    StringConcatenation _builder_1 = new StringConcatenation();
	    _builder_1.append(MuLEFileTemplateProvider.getEmptyFileTemplate(_name)); 
//	    _builder_1.append("program " + _name);
//	    _builder_1.newLine();
//	    _builder_1.append("import IO");
//	    _builder_1.newLine();
//	    _builder_1.append("main");
//	    _builder_1.newLine();
//	    _builder_1.append("\t");
//	    _builder_1.newLine();
//	    _builder_1.append("endmain");
//	    _builder_1.newLine();
	    fileGenerator.generate(_builder, _builder_1);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	public IWorkbench getWorkbench() {
		return workbench;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof NewFileWizardPrimaryPage && hasMoreThenOneTemplate()) {
			AbstractFileTemplate selectedTemplate = mainPage.getSelectedTemplate();
			List<TemplateVariable> variables = selectedTemplate.getVariables();
			if (variables.isEmpty())
				return null;
//			selectedTemplate.setTemplateInfo(getFileInfo());
			TemplateParameterPage parameterPage = new TemplateParameterPage(selectedTemplate);

			parameterPage.setWizard(this);
			templateParameterPage = parameterPage;
			parameterPage.setTitle(page.getTitle());
			parameterPage.setDescription(page.getDescription());
			return parameterPage;
		}
		return super.getNextPage(page);
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		if (page instanceof TemplateParameterPage) {
			templateParameterPage = null;
			return mainPage;
		}
		return super.getPreviousPage(page);
	}

	@Override
	public boolean canFinish() {
		return super.canFinish() && (templateParameterPage == null ? true : templateParameterPage.isPageComplete());
	}

	private boolean hasMoreThenOneTemplate() {
		return templates.length > 1;
	}

	private AbstractFileTemplate[] loadTemplatesFromExtensionPoint() {
		List<AbstractFileTemplate> result = new ArrayList<>();
		for (IConfigurationElement element : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(FILE_TEMPLATE_PROVIDER_EXTENSION_POINT_ID)) {
			if (FILE_TEMPLATE_PROVIDER_ID.equals(element.getName())
					&& getGrammarName().equals(element.getAttribute(FILE_TEMPLATE_PROVIDER_GRAMMAR_NAME_ATTRIBUTE))) {
				try {
					IFileTemplateProvider provider = (IFileTemplateProvider) element
							.createExecutableExtension(FILE_TEMPLATE_PROVIDER_GRAMMAR_CLASS_ATTRIBUTE);
					result.addAll(Arrays.asList(provider.getFileTemplates()));
				} catch (CoreException e) {
					logger.error("Can not instantiate '" + element.getAttribute(FILE_TEMPLATE_PROVIDER_GRAMMAR_CLASS_ATTRIBUTE) + "'", //$NON-NLS-1$ //$NON-NLS-2$
							e);
				}
			}
		}
		return result.toArray(new AbstractFileTemplate[0]);
	}
}
