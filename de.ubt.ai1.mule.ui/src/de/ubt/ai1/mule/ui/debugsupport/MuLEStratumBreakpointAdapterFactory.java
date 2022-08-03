package de.ubt.ai1.mule.ui.debugsupport;

import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;
import org.eclipse.xtext.resource.XtextResource;

@SuppressWarnings("restriction")
public class MuLEStratumBreakpointAdapterFactory extends StratumBreakpointAdapterFactory {
	
    @Override
    protected String getClassNamePattern(XtextResource state) {
        String name = "generated."+state.getURI().trimFileExtension().lastSegment()+"*";
        return name;
    }
    
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adaptableObject instanceof MuLEEditor) {
            return this;
        }
        return null;
    }
}
