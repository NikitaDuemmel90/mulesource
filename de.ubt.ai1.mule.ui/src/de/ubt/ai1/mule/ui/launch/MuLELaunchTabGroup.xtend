package de.ubt.ai1.mule.ui.launch

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.ILaunchConfigurationDialog
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaMainTab
import org.eclipse.debug.ui.RefreshTab
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaArgumentsTab
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaJRETab
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab
import org.eclipse.debug.ui.EnvironmentTab
import org.eclipse.debug.ui.CommonTab

class MuLELaunchTabGroup extends AbstractLaunchConfigurationTabGroup { 
	
	override createTabs(ILaunchConfigurationDialog dialog, String mode) {
		// These tabs will be displayed when a new launchconfiguration is created
		val tabs = newArrayList(
			new JavaMainTab,
			new RefreshTab,
			new JavaArgumentsTab,
			new JavaJRETab,
			new JavaClasspathTab,
			new SourceLookupTab,
			new EnvironmentTab,
			new CommonTab
		)
		setTabs(tabs)
	}	
	
}
