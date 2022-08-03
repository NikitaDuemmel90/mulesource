package de.ubt.ai1.mule.ui.debugsupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.debug.IStratumBreakpointSupport;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

import de.ubt.ai1.mule.muLE.AssignmentOrOperationCall;
import de.ubt.ai1.mule.muLE.Block;
import de.ubt.ai1.mule.muLE.CompilationUnit;
import de.ubt.ai1.mule.muLE.Composition;
import de.ubt.ai1.mule.muLE.Expression;
import de.ubt.ai1.mule.muLE.IfStatement;
import de.ubt.ai1.mule.muLE.LambdaExpression;
import de.ubt.ai1.mule.muLE.LetStatement;
import de.ubt.ai1.mule.muLE.LoopStatement;
import de.ubt.ai1.mule.muLE.MainProcedure;
import de.ubt.ai1.mule.muLE.Operation;
import de.ubt.ai1.mule.muLE.ReturnStatement;
import de.ubt.ai1.mule.muLE.VariableDeclaration;

@SuppressWarnings("restriction")
public class MuLEStratumBreakpointSupport implements IStratumBreakpointSupport {

	@Override
	public boolean isValidLineForBreakPoint(XtextResource resource, int line) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			return false;
		ICompositeNode node = parseResult.getRootNode();
		return isValidLineForBreakpoint(node, line);
	}

	protected boolean isValidLineForBreakpoint(ICompositeNode node, int line) {
		for (INode n : node.getChildren()) {
			ITextRegionWithLineInformation textRegion = n.getTextRegionWithLineInformation();
			if (textRegion.getLineNumber() <= line && textRegion.getEndLineNumber() >= line) {
				try {
					EObject eObject = n.getSemanticElement();
					if (eObject instanceof AssignmentOrOperationCall || eObject instanceof ReturnStatement || eObject instanceof VariableDeclaration) {
						if (textRegion.getLineNumber() != line) 
							return false;
						return true;
					}
					if (eObject instanceof CompilationUnit || eObject instanceof Composition
							|| eObject instanceof MainProcedure || eObject instanceof LoopStatement
							||  eObject instanceof IfStatement	|| eObject instanceof Operation 
							|| eObject instanceof LetStatement  || eObject instanceof Block) {
						return isValidLineForBreakpoint((ICompositeNode) n, line);
					}
				} catch (ClassCastException e) {
					return false;
				}
			}
			if (textRegion.getLineNumber() > line) {
				return false;
			}
		}
		return false;
	}
}
