package de.ubt.ai1.mule.ui.launch;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.internal.launching.JavaSourceLookupDirector;

@SuppressWarnings("restriction")
public class MuLESourceLookupDirector extends JavaSourceLookupDirector {
	@Override
	public Object getSourceElement(Object element) {
		List<Object> sources = doSourceLookup(element);
		try {
			IFile jFile = (IFile) sources.get(0);
			IProject project = jFile.getProject();
			IFile aFile = project.getFile("/src/" + jFile.getName());
			String systemType = System.getProperty("os.name");
			if (systemType.contains("Windows") || systemType.contains("windows"))
				aFile = project.getFile("\\src\\" + jFile.getName());
			sources.clear();
			sources.add(aFile);
			if(sources.size() == 1) {
				return sources.get(0);
			} else if(sources.size() > 1) {
				return resolveSourceElement(element, sources);
			} else {
				return null;
			}			
		} catch (Exception e) {
			return null;
		}
	}

}
