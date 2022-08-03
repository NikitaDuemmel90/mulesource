package de.ubt.ai1.mule.ui.perspective;
 
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.xtext.util.Arrays;

@SuppressWarnings("restriction")
public class MuLEPerspective implements IPerspectiveFactory {

	private IPageLayout layout;
	private IWorkbenchWindow window;
	private IWorkbenchPage workbenchPage;

	public MuLEPerspective() {
		super();
	}

	public void createInitialLayout(IPageLayout layout) {
		window = Workbench.getInstance().getActiveWorkbenchWindow();
		workbenchPage = window.getActivePage();
		
		this.layout = layout;
		layout.setEditorAreaVisible(true);
		layout.setFixed(true);
				
		modifyMenu();
		addViews();
		addActionSets();
		addNewWizardShortcuts();
	}

	private void modifyMenu() {
		if (window instanceof WorkbenchWindow) {
			MenuManager menuManager = ((WorkbenchWindow) window).getMenuManager();
			String[] necessaryItemIds = { "edit", "window", "help", "file"};
			IContributionItem preferencesItem = null;
			for (IContributionItem item : menuManager.getItems()) {
				if (!Arrays.contains(necessaryItemIds, item.getId())) {
					item.setVisible(false);
				}
				else if (item.getId().contentEquals("edit") && item instanceof MenuManager) {
					String[] necessaryIds = {"undo", "redo", "cut", "copy", "paste"};
					MenuManager editMenu = (MenuManager) item;
					for (IContributionItem editMenuItem : editMenu.getItems()) {
						String itemId = editMenuItem.getId();
						if(itemId == null || !Arrays.contains(necessaryIds, itemId)) {
							editMenuItem.setVisible(false);
						} 
					}
				}
				else if (item.getId().contentEquals("window") && item instanceof MenuManager) {
					MenuManager windowMenu = (MenuManager) item;
					for (IContributionItem windowMenuItem : windowMenu.getItems()) {
						if (windowMenuItem.getId() != null && windowMenuItem.getId().contentEquals("preferences")) {
							preferencesItem = windowMenuItem;
							windowMenu.remove(preferencesItem);
						}
						item.setVisible(false);
					}
				}
				else if (item.getId().contentEquals("help") && item instanceof MenuManager) {					
					MenuManager helpMenu = (MenuManager) item;
					String[] necessaryIds = {"muleHelp", "about", "preferences", "org.eclipse.equinox.p2.ui.sdk.update"};
					for (IContributionItem helpMenuItem : helpMenu.getItems()) {
						String itemId = helpMenuItem.getId();
						if(itemId == null || !Arrays.contains(necessaryIds, itemId)) {
							helpMenuItem.setVisible(false);
						} 
					}
					if (preferencesItem != null) {
						helpMenu.add(preferencesItem);
						preferencesItem.setParent(helpMenu);
					}
				}
				else if (item.getId().contentEquals("file") && item instanceof MenuManager) {					
					MenuManager fileMenu = (MenuManager) item;
					String[] necessaryIds = {"new", "save", "saveAll", "refresh", "import", "export", "properties"};
					for (IContributionItem fileMenuItem : fileMenu.getItems()) {
						String itemId = fileMenuItem.getId();
						if(itemId == null || !Arrays.contains(necessaryIds, itemId)) {
							fileMenuItem.setVisible(false);
						} 						
					}
				}
			}
			menuManager.update();		
		}
	}

	private void addViews() {		
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.2f, layout.getEditorArea());		
		topLeft.addView(IPageLayout.ID_PROJECT_EXPLORER);
		modifyView(IPageLayout.ID_PROJECT_EXPLORER);

		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.5f, "topLeft");
		bottomLeft.addView(IPageLayout.ID_OUTLINE);
		modifyView(IPageLayout.ID_OUTLINE);

		IFolderLayout bottom = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.8f, layout.getEditorArea());
		bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		modifyView(IConsoleConstants.ID_CONSOLE_VIEW);

		IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.RIGHT, 0.8f, layout.getEditorArea());
		topRight.addView("org.eclipse.debug.ui.VariableView");
		topRight.addView("org.eclipse.debug.ui.BreakpointView");
		modifyView("org.eclipse.debug.ui.VariableView");
		modifyView("org.eclipse.debug.ui.BreakpointView");

		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.5f, "topRight");
		bottomRight.addView("org.eclipse.debug.ui.DebugView");
		modifyView("org.eclipse.debug.ui.DebugView");
	}
	
	private void modifyView(String viewID) {
		IViewLayout viewLayout = layout.getViewLayout(viewID);
		viewLayout.setCloseable(false);
		viewLayout.setMoveable(false);
		IViewPart view = workbenchPage.findView(viewID);
		if (view != null) {
			IViewSite viewSite = view.getViewSite();
			IActionBars actionBars = viewSite.getActionBars(); 
			IToolBarManager tBM = actionBars.getToolBarManager();
//			String[] necessaryIds = {IPageLayout.ID_OUTLINE, IConsoleConstants.ID_CONSOLE_VIEW};
			if (viewID.equals("org.eclipse.debug.ui.BreakpointView")) {
				IContributionItem[] items = tBM.getItems();
				for (IContributionItem item : items) {
					if (item.getId() != null && !item.getId().equals("org.eclipse.debug.ui.breakpointsView.toolbar.remove") 
							&& !item.getId().equals("org.eclipse.debug.ui.breakpointsView.toolbar.removeAll")) {
//						tBM.remove(item.getId());
						item.setVisible(false);
					}
				}
			} else {
//			else if (!Arrays.contains(necessaryIds, viewID)) {
				for (IContributionItem item : tBM.getItems()) {
					item.setVisible(false);
				}
//				tBM.removeAll();
			}
			tBM.update(true);
		}
	}

	private void addNewWizardShortcuts() {
		layout.addNewWizardShortcut("de.ubt.ai1.mule.ui.wizard.MuLENewProjectWizard");
		layout.addNewWizardShortcut("de.ubt.ai1.mule.ui.wizard.MuLENewFileWizard");
	}

	private void addActionSets() {
		layout.addActionSet("org.eclipse.debug.ui.debugActionSet");
		layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
	}
}
