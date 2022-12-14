/*
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.mule.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.debug.IStratumBreakpointSupport
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import de.ubt.ai1.mule.ui.debugsupport.MuLEEditor
import de.ubt.ai1.mule.ui.debugsupport.MuLEStratumBreakpointSupport
import de.ubt.ai1.mule.ui.syntaxhighlighting.MuLEHighlightingConfiguration
import de.ubt.ai1.mule.ui.syntaxhighlighting.MuLESemanticHighlightingCalculator

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class MuLEUiModule extends AbstractMuLEUiModule {
	
	def Class<? extends XtextEditor> bindXtextEditor() {
		return MuLEEditor
	}
	
	def Class<? extends IStratumBreakpointSupport> bindIStratumBreakpointSupport() {
        return MuLEStratumBreakpointSupport;
    }

	def Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		MuLEHighlightingConfiguration
	}
	
	def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		MuLESemanticHighlightingCalculator
	}
}
