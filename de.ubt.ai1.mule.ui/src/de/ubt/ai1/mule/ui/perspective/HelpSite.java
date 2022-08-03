package de.ubt.ai1.mule.ui.perspective;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class HelpSite extends AbstractHandler {

	private String siteURI = "https://nikitaduemmel90.github.io/mulehome/";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Desktop.isDesktopSupported()) {
			Desktop desk = Desktop.getDesktop();
			try {
				desk.browse(new URI(siteURI));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
