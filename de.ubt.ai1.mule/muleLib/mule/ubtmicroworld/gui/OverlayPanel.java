package mule.ubtmicroworld.gui;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;

/**
 * This class represents the OverlayPanel.
 * So there is the possibility of a foreground and background panel.
 * @author Marco Jantos
 * 
 */
public class OverlayPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel currentForeground;
	private JPanel currendBackground;

	private  LayoutManager overlay;

	/**
	 * Constructor to create an instance of OverlayPanel
	 * @param foregroundPanel  panel 1
	 * @param backgroundPanel  panel 2
	 */
	public OverlayPanel(JPanel foregroundPanel, JPanel backgroundPanel) {
		overlay = new OverlayLayout(this);

		this.setLayout(overlay);

		foregroundPanel.setOpaque(false);

		this.add(foregroundPanel);
		this.add(backgroundPanel);

		currendBackground = backgroundPanel;
	}

	/**
	 * This method sets the foregroundPanel
	 * @param foregroundPanel  the foregroundPanel
	 */
	public void setForegroundPanel(JPanel foregroundPanel) {
		foregroundPanel.setOpaque(false);

		this.removeAll();
		this.invalidate();
		this.add(foregroundPanel);
		this.add(currendBackground);
		this.revalidate();
	}
}
