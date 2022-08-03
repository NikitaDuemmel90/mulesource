package de.ubt.ai1.mule.ui.syntaxhighlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.SWT

class MuLEHighlightingConfiguration extends DefaultHighlightingConfiguration {
	
    public static final String DATATYPE_ID = "datatype";
    
    override configure(IHighlightingConfigurationAcceptor acceptor){
    	super.configure(acceptor)
    	acceptor.acceptDefaultHighlighting(DATATYPE_ID, "Datatype", dataTypeTextStyle());
    }
    
	def TextStyle dataTypeTextStyle() {
		var textStyle = defaultTextStyle().copy()
		textStyle.setColor(new RGB(204, 102, 0))
		textStyle.style = SWT.BOLD
		return textStyle
	}
	
}
