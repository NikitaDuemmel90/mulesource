package mule.ubtmicroworld.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class represents the BackgroundPanel.
 * @author Marco Jantos
 * 
 */
public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	ImageIcon icon;
	ImageIcon originalIcon;


	/**
	 * This constructor sets the class internal ImageIcon
	 * @param icon  the ImageIcon
	 */
	public BackgroundPanel(ImageIcon icon) {
		this.icon = icon;
		this.originalIcon = icon;
	}

	/**
	 * This method paints a graphic
	 * @param g the graphic
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.icon != null) {
			int width = this.getWidth();
			int height = this.getHeight();

			Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
			icon = new ImageIcon(scaledImage);

			g.drawImage(icon.getImage(), 0, 0, width, height, 0, 0, 0 + width, height, null);
		}
	}

	/**
	 * This method returns the PreferredSize
	 * @return 	the preferred size as a dimension
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = this.getWidth();
		int height = this.getHeight();
		if (icon != null) {
			return new Dimension(width, height);
		} else {
			return new Dimension(width, height);
		}
	}
	
}
