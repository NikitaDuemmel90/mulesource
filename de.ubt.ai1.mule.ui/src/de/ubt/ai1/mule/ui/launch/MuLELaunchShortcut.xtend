package de.ubt.ai1.mule.ui.launch

import org.eclipse.core.resources.IFile
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.debug.ui.ILaunchShortcut
import org.eclipse.debug.ui.RefreshTab
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.IFileEditorInput
import org.eclipse.xtext.util.Strings 

import static org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants.*
import static org.eclipse.jface.dialogs.MessageDialog.*
import de.ubt.ai1.mule.ui.debugsupport.MuLEEditor

class MuLELaunchShortcut implements ILaunchShortcut { 

	override launch(ISelection selection, String mode) {
		val file = (selection as IStructuredSelection).firstElement as IFile
		val name = file.name
		val clazz = "generated." + name.substring(0, name.lastIndexOf('.'))
		val project = file.project.name		
		launch(mode, new LaunchConfigurationInfo(project, clazz))
	}

	override launch(IEditorPart editor, String mode) {
		if(editor instanceof MuLEEditor){
			val editorInput = editor.editorInput
			if (editorInput instanceof IFileEditorInput) {
				val project = editorInput.file.project.name
				val info = editor.document.readOnly [
					val javaFile = "generated." + it.URI.trimFileExtension.lastSegment
					new LaunchConfigurationInfo(project, javaFile)
				]
				launch(mode, info)
				return
			}
		}
		openError(null, "Wrong editor kind.", "")
	}

	def launch(String mode, LaunchConfigurationInfo info) {
		val configs = DebugPlugin.getDefault.launchManager.launchConfigurations
		val config = configs.findFirst [
			var res = info.configEquals(it)
			return res
		] ?: info.createConfiguration
		DebugUITools.launch(config, mode)
	}
}

class LaunchConfigurationInfo {
	public static val String LAUNCH_TYPE = "de.ubt.ai1.mule.ui.MuLELaunchConfigurationType"

	val String project
	val String clazz
	
	new(String project, String clazz) {
		this.project = project
		this.clazz = clazz
	}

	def getProject() {
		project
	}

	def getClazz() {
		clazz
	}
	
	def getName() {
		Strings.lastToken(clazz, ".")
	}
	
	def createConfiguration()  {
		val launchManager = DebugPlugin.getDefault.launchManager
		val configType = launchManager.getLaunchConfigurationType(LAUNCH_TYPE)
		val wc = configType.newInstance(null, launchManager.generateLaunchConfigurationName(name))
		wc.setAttribute(ATTR_PROJECT_NAME, project)
		wc.setAttribute(ATTR_MAIN_TYPE_NAME, clazz)
		wc.setAttribute(ATTR_STOP_IN_MAIN, false)
		wc.setAttribute(RefreshTab.ATTR_REFRESH_SCOPE, "${workspace}")
		wc.setAttribute(RefreshTab.ATTR_REFRESH_RECURSIVE, true)
		wc.doSave
	}

	def configEquals(ILaunchConfiguration a) {
		a.getAttribute(ATTR_MAIN_TYPE_NAME, "X") == clazz && 
		a.getAttribute(ATTR_PROJECT_NAME, "X") == project && 
		a.type.identifier == LAUNCH_TYPE
	}
	
	def isValid() {
		!clazz.nullOrEmpty && !project.nullOrEmpty
	}
}
