package de.ubt.ai1.mule.ui.syntaxhighlighting

import de.ubt.ai1.mule.muLE.TypeDeclaration
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

class MuLESemanticHighlightingCalculator implements ISemanticHighlightingCalculator {
		
	override provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		val root = resource.getParseResult().getRootNode();
        for(INode node : root.getAsTreeIterable()) {   
            val grammarElement = node.getGrammarElement(); 
            if(grammarElement instanceof RuleCall) {
            	val rc = grammarElement as RuleCall
                val rule = rc.getRule();
				if(rule.name.equals("DataType")){
                	acceptor.addPosition(node.getOffset(), node.getLength(), MuLEHighlightingConfiguration.DATATYPE_ID);					
				}
				if(rule.name.equals("ID")){
					val p = node.getParent();
                    if (p !== null && p.semanticElement instanceof TypeDeclaration) {
                		acceptor.addPosition(node.getOffset(), node.getLength(), MuLEHighlightingConfiguration.DATATYPE_ID);	
                    }
				}
            }
        }
	}
	
}
