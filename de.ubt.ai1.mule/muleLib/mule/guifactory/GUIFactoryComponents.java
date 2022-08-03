package mule.guifactory;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;

import mule.guifactory.GUIFactory.Alignment;
import mule.guifactory.GUIFactory.CheckBoxAlignment;
import mule.guifactory.GUIFactory.Colour;
import mule.guifactory.GUIFactory.FontType;
import mule.guifactory.GUIFactory.HorizontalAlignment;
import mule.guifactory.GUIFactoryBorders.Border;
import mule.guifactory.GUIFactoryTasks.ActionTask;
import mule.guifactory.GUIFactoryTasks.MouseTask;
import mule.guifactory.GUIFactoryTasks.ValueChangedTask;
import mule.util.MuLEReferenceType;

public class GUIFactoryComponents {
	


	public static abstract class Component implements Serializable {
		protected boolean autoScalable;
		protected Component parent;

		public abstract void setVisible(boolean visible);

		public abstract Component getParent();

		public abstract void setParent(Component parent);

		public abstract JComponent getComponent();

		public abstract boolean isAutoScalable();
	}
	
	// CONTROLS

	public static MuLEReferenceType<Image> createImage(String path) {
		return new MuLEReferenceType<>(new Image(path));
	}

	public static MuLEReferenceType<Image> createImage(String path, String description) {
		return new MuLEReferenceType<>(new Image(path, description));
	}

	public static MuLEReferenceType<Button> createButton(String text) {
		return new MuLEReferenceType<>(new Button(text));
	}

	public static MuLEReferenceType<Button> createButton(String text, int width, int height) {
		return new MuLEReferenceType<>(new Button(text, width, height));
	}

	public static MuLEReferenceType<Rectangle> createRectangle(int width, int height) {
		return new MuLEReferenceType<>(new Rectangle(width, height));
	}

	public static MuLEReferenceType<Rectangle> createRectangle(int width, int height, Colour colour) {
		return new MuLEReferenceType<>(new Rectangle(width, height, colour));
	}

	public static MuLEReferenceType<Ellipse> createEllipse(int width, int height) {
		return new MuLEReferenceType<>(new Ellipse(width, height));
	}

	public static MuLEReferenceType<Ellipse> createEllipse(int width, int height, Colour colour) {
		return new MuLEReferenceType<>(new Ellipse(width, height, colour));
	}

	public static MuLEReferenceType<Polygon> createPolygon(ArrayList<Integer> xPoints, ArrayList<Integer> yPoints, int points) {
		int[] xPoints2 = new int[xPoints.size()];
		for (int i = 0; i < xPoints.size(); i++) 
			xPoints2[i] = xPoints.get(i);
		int[] yPoints2 = new int[yPoints.size()];
		for (int i = 0; i < yPoints.size(); i++) 
			yPoints2[i] = yPoints.get(i);
		return new MuLEReferenceType<>(new Polygon(xPoints2, yPoints2, points));
	}

	public static MuLEReferenceType<Polygon> createPolygon(int[] xPoints, int[] yPoints, int points) {
		return new MuLEReferenceType<>(new Polygon(xPoints, yPoints, points));
	}

	public static MuLEReferenceType<Label> createLabel(String text) {
		return new MuLEReferenceType<Label>(new Label(text));
	}

	public static MuLEReferenceType<Label> createLabel(String text, int fontSize) {
		return new MuLEReferenceType<>(new Label(text, fontSize));
	}

	public static MuLEReferenceType<CheckBox> createCheckBox(CheckBoxAlignment alignment, String text) {
		return new MuLEReferenceType<>(new CheckBox(alignment, text));
	}

	public static MuLEReferenceType<CheckBox> createCheckBox(CheckBoxAlignment alignment, String text, boolean selected) {
		return new MuLEReferenceType<>(new CheckBox(alignment, text, selected));
	}

	public static MuLEReferenceType<Slider> createSlider(int minimum, int maximum) {
		return new MuLEReferenceType<>(new Slider(minimum, maximum));
	}

	public static MuLEReferenceType<Slider> createSlider(int minimum, int maximum, int value) {
		return new MuLEReferenceType<>(new Slider(minimum, maximum, value));
	}

	public static MuLEReferenceType<TextField> createTextField(HorizontalAlignment alignment, String text) {
		return new MuLEReferenceType<TextField>(new TextField(alignment, text));
	}

	public static MuLEReferenceType<TextArea> createTextArea(String text) {
		return new MuLEReferenceType<>(new TextArea(text));
	}

	public static MuLEReferenceType<TextArea> createTextArea(String text, int lines) {
		return new MuLEReferenceType<>(new TextArea(text, lines));
	}

	public static MuLEReferenceType<DropDownMenu> createDropDownMenu(ArrayList<String> itemNames) {
		String[] itemNames2 = new String[itemNames.size()];
		for (int i = 0; i < itemNames.size(); i++) 
			itemNames2[i] = itemNames.get(i);
		return new MuLEReferenceType<>(new DropDownMenu(itemNames2));
	}

	public static MuLEReferenceType<DropDownMenu> createDropDownMenu(String[] itemNames) {
		return new MuLEReferenceType<>(new DropDownMenu(itemNames));
	}


	public static class Image extends Component {

		private JLabel label = new JLabel() {

			protected void paintComponent(Graphics g) {
				if (!visible)
					return;

				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setRenderingHints(antialiasing);

				if (icon != null) {
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
					g2d.setComposite(ac);
					g2d.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				}
			}
		};

		private boolean visible = true;

		private ImageIcon icon;
		private String icon_path;
		private int originalWidth;
		private int originalHeight;
		private float alpha = 1;

		// CONSTRUCTORS

		public Image(String path) {
			this.autoScalable = true;

			java.net.URL imageURL = getClass().getResource(path);

			if (imageURL != null) {
				icon = new ImageIcon(imageURL);
			} else {
				icon = new ImageIcon(path);
			}
			icon_path = path;

			this.originalWidth = icon.getIconWidth();
			this.originalHeight = icon.getIconHeight();

			label.setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.setMaximumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.repaint();
		}

		public Image(String path, String description) {
			this.autoScalable = true;

			java.net.URL imageURL = getClass().getResource(path);

			if (imageURL != null) {
				icon = new ImageIcon(imageURL, description);
			} else {
				icon = new ImageIcon(path, description);
			}
			icon_path = path;

			this.originalWidth = icon.getIconWidth();
			this.originalHeight = icon.getIconHeight();

			label.setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.setMaximumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.repaint();
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return label;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
			label.repaint();
		}

		// TASKS

		public void handleMouseTask(MouseTask mouseTask) {
			this.label.addMouseListener(mouseTask);
			this.label.addMouseMotionListener(mouseTask);
		}

		// PUBLICS

		public ImageIcon getImage() {
			return icon;
		}

		// SETTER

		public void setTransparency(float alpha) {
			this.alpha = alpha;
			label.repaint();
		}

		public void setNativeSize() {
			label.setMinimumSize(new Dimension(originalWidth, originalHeight));
			label.setMaximumSize(new Dimension(originalWidth, originalHeight));
			label.setPreferredSize(new Dimension(originalWidth, originalHeight));
			label.repaint();
		}

		public void setSize(int width, int height) {
			icon = new ImageIcon(icon.getImage().getScaledInstance(width, height, 1));

			label.setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.setMaximumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			label.repaint();
		}

		public void setImage(Image image) {
			if (image.getImagePath() != null) {
				java.net.URL imageURL = getClass().getResource(image.getImagePath());

				if (imageURL != null)
					this.icon = new ImageIcon(imageURL);
				else
					this.icon = new ImageIcon(image.getImagePath());

				this.icon_path = image.getImagePath();

				label.setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
				label.setMaximumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
				label.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
				label.repaint();
			}
		}

		public void setScale(float scalingFactor) {
			label.setMinimumSize(new Dimension((int) (icon.getIconWidth() * scalingFactor),
					(int) (icon.getIconHeight() * scalingFactor)));
			label.setMaximumSize(new Dimension((int) (icon.getIconWidth() * scalingFactor),
					(int) (icon.getIconHeight() * scalingFactor)));
			label.setPreferredSize(new Dimension((int) (icon.getIconWidth() * scalingFactor),
					(int) (icon.getIconHeight() * scalingFactor)));
			label.repaint();
		}

		public void setDescription(String description) {
			icon.setDescription(description);
		}

		public void setToolTip(String text) {
			label.setToolTipText(text);
		}

		// GETTER

		public int getWidth() {
			return icon.getIconWidth();
		}

		public int getHeight() {
			return icon.getIconHeight();
		}

		public String getDescription() {
			return icon.getDescription();
		}

		public String getImagePath() {
			return icon_path;
		}

		public int getNativeWidth() {
			return originalWidth;
		}

		public int getNativeHeight() {
			return originalHeight;
		}

		public float getTransparency() {
			return alpha;
		}

	}

	public static class Label extends Component {
		private JLabel label = new JLabel() {

			protected void paintComponent(Graphics g) {
				if (!visible)
					return;

				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (backgroundColour != null)
					g2.setColor(
							new Color(backgroundColour.r, backgroundColour.g, backgroundColour.b, backgroundColour.a));
				else
					g2.setColor(new Color(0, 0, 0, 0));

				g2.fillRect(0, 0, getWidth(), getHeight());

				if (image != null) {
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, image.getTransparency());
					g2.setComposite(ac);

					g2.drawImage(image.getImage().getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				}

				paintText(g);
			}
		};

		private Alignment alignment = Alignment.NONE;
		private Image image;

		private float indentX = 0.1f;
		private float indentY = 0.1f;

		private Colour backgroundColour;
		private Colour textColour;

		private boolean visible = true;

		private Border border;

		// CONSTRUCTOS

		public Label(String text) {
			this.autoScalable = true;
			label.setText(text);
			label.setFocusable(false);
			label.setOpaque(false);
		}

		public Label(String text, int fontSize) {
			this.autoScalable = true;
			label.setText(text);
			label.setFocusable(false);
			label.setOpaque(false);
			label.setFont(new java.awt.Font(label.getFont().getFontName(), java.awt.Font.PLAIN, fontSize));
			label.repaint();
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return label;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			if (border != null && !visible)
				label.setBorder(null);
			else if (border != null && visible) {
				Border b = (Border) border;
				label.setBorder(b.getBorder());
			}

			this.visible = visible;
			label.repaint();
		}

		// TASKS

		public void handleMouseTask(MouseTask mouseTask) {
			this.label.addMouseListener(mouseTask);
			this.label.addMouseMotionListener(mouseTask);
		}

		// SETTER

		public void setText(String text) {
			label.setText(text);
		}

		public void setTextAlignment(Alignment alignment) {
			this.alignment = alignment;
			label.repaint();
		}

		public void setFont(String fontName, FontType fontType, int fontSize, Colour colour) {
			textColour = colour;
			switch (fontType) {
			case PLAIN:
				label.setFont(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));
				break;
			case BOLD:
				label.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD, fontSize));
				break;
			case ITALIC:
				label.setFont(new java.awt.Font(fontName, java.awt.Font.ITALIC, fontSize));
				break;
			case ITALIC_BOLD:
				label.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD + java.awt.Font.ITALIC, fontSize));
				break;
			}
			label.repaint();
		}

		public void setSize(int width, int height) {
			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));
		}

		public void setPosition(int x, int y) {
			this.label.setLocation(x, y);
		}

		public void setToolTip(String text) {
			label.setToolTipText(text);
		}

		public void setBorder(Border border) {
			Border aB = (Border) border;
			this.border = border;
			label.setBorder(aB.getBorder());
		}

		public void setTextAlignment(Alignment alignment, float indentX, float indentY) {
			if (indentX > 1 || indentY > 1 || indentX < 0 || indentY < 0) {
				this.indentX = 0.1f;
				this.indentY = 0.1f;
			} else {
				this.indentX = indentX;
				this.indentY = indentY;
			}
			setTextAlignment(alignment);
		}

		public void setBackground(Image image) {
			this.image = (Image) image;
			label.repaint();
		}

		public void setBackground(Colour colour) {
			backgroundColour = colour;
			label.repaint();
		}

		// GETTER

		public int getWidth() {
			return this.label.getWidth();
		}

		public int getHeight() {
			return this.label.getHeight();
		}

		public int getX() {
			return this.label.getX();
		}

		public int getY() {
			return this.label.getY();
		}

		public Image getBackgroundImage() {
			if (image == null)
				return null;
			return this.image;
		}

		public String getText() {
			return label.getText();
		}

		public Alignment getTextAlignment() {
			return alignment;
		}

		// PRIVATES

		private void paintText(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHints(antialiasing);

			if (textColour != null)
				g2.setColor(new Color(textColour.r, textColour.g, textColour.b, textColour.a));
			else
				g2.setColor(label.getForeground());

			FontMetrics metrics = g.getFontMetrics(label.getFont());
			int x = (label.getWidth() - metrics.stringWidth(label.getText())) / 2 - label.getLocation().x;
			int y = ((label.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

			int einzugX = (int) ((int) label.getWidth() * indentX);
			int einzugY = (int) ((int) label.getHeight() * indentY);

			switch (alignment) {
			case TOP_LEFT:
				x = einzugX;
				y = einzugY + metrics.getAscent();
				break;
			case TOP_CENTER:
				x = (label.getWidth() - metrics.stringWidth(label.getText())) / 2;
				y = einzugY + metrics.getAscent();
				break;
			case TOP_RIGHT:
				x = label.getWidth() - metrics.stringWidth(label.getText()) - einzugX;
				y = einzugY + metrics.getAscent();
				break;
			case CENTER_LEFT:
				x = einzugX;
				y = ((label.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			case CENTER:
				x = (label.getWidth() - metrics.stringWidth(label.getText())) / 2;
				y = ((label.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			case CENTER_RIGHT:
				x = label.getWidth() - metrics.stringWidth(label.getText()) - einzugX;
				y = ((label.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			case BOTTOM_LEFT:
				x = einzugX;
				y = label.getHeight() - (metrics.getHeight() - metrics.getAscent()) - einzugY;
				break;
			case BOTTOM_CENTER:
				x = (label.getWidth() - metrics.stringWidth(label.getText())) / 2;
				y = label.getHeight() - (metrics.getHeight() - metrics.getAscent()) - einzugY;
				break;
			case BOTTOM_RIGHT:
				x = label.getWidth() - metrics.stringWidth(label.getText()) - einzugX;
				y = label.getHeight() - (metrics.getHeight() - metrics.getAscent()) - einzugY;
				break;
			case NONE:
				x = (label.getWidth() - metrics.stringWidth(label.getText())) / 2;// - button.getLocation().x;
				y = ((label.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			}

			g2.setFont(label.getFont());
			g2.drawString(label.getText(), x, y);
		}

	}

	public static class TextArea extends Component {

		private JTextArea textArea = new JTextArea() {
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (!stroke) {
					g2.setColor(getBackground());
					if (roundedCorners)
						g2.fillRoundRect(0, 0, getWidth(), getHeight(), roundValue, roundValue);
					else
						g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 0, 0);

					if (strokeColour == null)
						g2.setColor(getForeground());
					else
						g2.setColor(strokeColour);

					if (roundedCorners)
						g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, roundValue, roundValue);
					else
						g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 0, 0);
				} else {
					if (strokeColour == null)
						g2.setColor(getForeground());
					else
						g2.setColor(strokeColour);

					if (roundedCorners)
						g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, roundValue, roundValue);
					else
						g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 0, 0);

					g2.setColor(getBackground());
					if (roundedCorners)
						g2.fillRoundRect(thickness / 2, thickness / 2, getWidth() - 1 - (thickness * 2) / 2,
								getHeight() - 1 - (thickness * 2) / 2, roundValue - thickness, roundValue - thickness);
					else
						g2.fillRoundRect(thickness / 2, thickness / 2, getWidth() - 1 - (thickness * 2) / 2,
								getHeight() - 1 - (thickness * 2) / 2, 0, 0);
				}
				super.paintComponent(g2);
			}
		};

		private boolean stroke = false;
		private Color strokeColour;
		private int thickness = 0;
		private boolean roundedCorners = false;
		private int roundValue = 0;

		// CONSTRUCTORS

		public TextArea(String text) {
			this.autoScalable = true;
			textArea.setText(text);
			textArea.setOpaque(false);
			textArea.setBorder(null);
		}

		public TextArea(String text, int lines) {
			this.autoScalable = true;
			textArea.setRows(lines);
			textArea.setText(text);
			textArea.setOpaque(false);
			textArea.setBorder(null);
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return textArea;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			textArea.setVisible(visible);
		}

		// TASKS

		public void handleMouseTask(MouseTask mouseTask) {
			textArea.addMouseListener(mouseTask);
			textArea.addMouseMotionListener(mouseTask);
		}

		// SETTER

		public void setText(String text) {
			textArea.setText(text);
		}

		public void setLineWrap(boolean wrap) {
			textArea.setLineWrap(wrap);
		}

		public void setEditable(boolean editable) {
			textArea.setEditable(editable);
		}

		public void setSize(int width, int height) {
			textArea.setMinimumSize(new Dimension(width, height));
			textArea.setPreferredSize(new Dimension(width, height));
			textArea.setMaximumSize(new Dimension(width, height));
		}

		public void setPosition(int x, int y) {
			textArea.setLocation(x, y);
		}

		public void setToolTip(String text) {
			textArea.setToolTipText(text);
		}

		public void setFont(String fontName, FontType fontType, int fontSize, Colour colour) {
			textArea.setForeground(new Color(colour.r, colour.g, colour.b, colour.a));
			switch (fontType) {
			case PLAIN:
				textArea.setFont(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));
				break;
			case BOLD:
				textArea.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD, fontSize));
				break;
			case ITALIC:
				textArea.setFont(new java.awt.Font(fontName, java.awt.Font.ITALIC, fontSize));
				break;
			case ITALIC_BOLD:
				textArea.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD + java.awt.Font.ITALIC, fontSize));
				break;
			}
			textArea.repaint();
		}

		public void setBackground(Colour colour) {
			textArea.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setStroke(Colour colour, int thickness) {
			this.stroke = true;
			this.strokeColour = new Color(colour.r, colour.g, colour.b, colour.a);
			this.thickness = thickness;
			textArea.repaint();
		}

		public void setRoundCorners(int roundValue) {
			roundedCorners = true;
			this.roundValue = roundValue;
			textArea.repaint();
		}

		public void setCaretColour(Colour colour) {
			textArea.setCaretColor(new Color(colour.r, colour.g, colour.b, colour.a));

		}

		public void setLines(int lines) {
			textArea.setRows(lines);
		}

		// REQUESTS

		public boolean isEditable() {
			return textArea.isEditable();
		}

		// UTILITY

		public void selectAll() {
			textArea.selectAll();
		}

		public void append(String text) {
			textArea.append(text);
		}

		public void insert(String text, int position) {
			textArea.insert(text, position);
		}

		public void replace(String text, int start, int end) {
			textArea.replaceRange(text, start, end);
		}

		// GETTER

		public int getX() {
			return textArea.getX();
		}

		public int getY() {
			return textArea.getY();
		}

		public int getWidth() {
			return textArea.getWidth();
		}

		public int getHeight() {
			return textArea.getHeight();
		}

		public int getLineCount() {
			return textArea.getLineCount();
		}

		public int getLines() {
			return textArea.getRows();
		}

		public String getText() {
			return textArea.getText();
		}
	}

	// https://java-swing-tips.blogspot.com/2012/03/rounded-border-for-jtextfield.html
	// --> Rounded Border
	public static class TextField extends Component {

		private JTextField textField = new JTextField() {
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (!stroke) {
					g2.setColor(getBackground());
					if (roundedCorners)
						g2.fillRoundRect(0, 0, getWidth(), getHeight(), roundValue, roundValue);
					else
						g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 0, 0);

					if (strokeColour == null)
						g2.setColor(getForeground());
					else
						g2.setColor(strokeColour);

					if (roundedCorners)
						g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, roundValue, roundValue);
					else
						g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 0, 0);
				} else {
					if (strokeColour == null)
						g2.setColor(getForeground());
					else
						g2.setColor(strokeColour);

					if (roundedCorners)
						g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, roundValue, roundValue);
					else
						g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 0, 0);

					g2.setColor(getBackground());
					if (roundedCorners)
						g2.fillRoundRect(thickness / 2, thickness / 2, getWidth() - 1 - (thickness * 2) / 2,
								getHeight() - 1 - (thickness * 2) / 2, roundValue - thickness, roundValue - thickness);
					else
						g2.fillRoundRect(thickness / 2, thickness / 2, getWidth() - 1 - (thickness * 2) / 2,
								getHeight() - 1 - (thickness * 2) / 2, 0, 0);
				}
				super.paintComponent(g2);
			}
		};

		private boolean stroke = false;
		private Color strokeColour;
		private int thickness = 0;
		private boolean roundedCorners = false;
		private int roundValue = 0;

		// CONSTRUCTORS

		public TextField(HorizontalAlignment textAlignment, String text) {
			this.autoScalable = true;
			textField.setText(text);
			textField.setOpaque(false);
			textField.setBorder(null);
			setTextAlignment(textAlignment);
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return textField;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			textField.setVisible(visible);
		}

		// TASKS

		public void handleMouseTask(MouseTask mouseTask) {
			textField.addMouseListener(mouseTask);
			textField.addMouseMotionListener(mouseTask);
		}

		// SETTER

		public void setText(String text) {
			textField.setText(text);
		}

		public void setEditable(boolean editable) {
			textField.setEditable(editable);
		}

		public void setSize(int width, int height) {
			textField.setMinimumSize(new Dimension(width, height));
			textField.setPreferredSize(new Dimension(width, height));
			textField.setMaximumSize(new Dimension(width, height));
		}

		public void setPosition(int x, int y) {
			textField.setLocation(x, y);
		}

		public void setToolTip(String text) {
			textField.setToolTipText(text);
		}

		public void setFont(String fontName, FontType fontType, int fontSize, Colour colour) {
			textField.setForeground(new Color(colour.r, colour.g, colour.b, colour.a));
			switch (fontType) {
			case PLAIN:
				textField.setFont(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));
				break;
			case BOLD:
				textField.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD, fontSize));
				break;
			case ITALIC:
				textField.setFont(new java.awt.Font(fontName, java.awt.Font.ITALIC, fontSize));
				break;
			case ITALIC_BOLD:
				textField.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD + java.awt.Font.ITALIC, fontSize));
				break;
			}
			textField.repaint();
		}

		public void setBackground(Colour colour) {
			textField.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setStroke(Colour colour, int thickness) {
			this.stroke = true;
			this.strokeColour = new Color(colour.r, colour.g, colour.b, colour.a);
			this.thickness = thickness;
			textField.repaint();
		}

		public void setRoundCorners(int roundValue) {
			roundedCorners = true;
			this.roundValue = roundValue;
			textField.repaint();
		}

		public void setCaretColour(Colour colour) {
			textField.setCaretColor(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		// REQUESTS

		public boolean isEditable() {
			return textField.isEditable();
		}

		// GETTER

		public String getText() {
			return textField.getText();
		}

		public int getX() {
			return textField.getX();
		}

		public int getY() {
			return textField.getY();
		}

		public int getWidth() {
			return textField.getWidth();
		}

		public int getHeight() {
			return textField.getHeight();
		}

		// PRIVATES

		private void setTextAlignment(HorizontalAlignment alignment) {
			switch (alignment) {
			case RIGHT:
				textField.setHorizontalAlignment(JTextField.RIGHT);
				break;
			case LEFT:
				textField.setHorizontalAlignment(JTextField.LEFT);
				break;
			case CENTER:
				textField.setHorizontalAlignment(JTextField.CENTER);
				break;
			}
		}
	}

	public static class Button extends Component {

		private JButton button = new JButton() {

			protected void paintComponent(Graphics g) {
				if (!visible)
					return;

				// super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (getModel().isPressed()) {
					if (pressedColour != null)
						g2.setColor(new Color(pressedColour.r, pressedColour.g, pressedColour.b, pressedColour.a));
					else {
						if (image != null)
							g2.setColor(new Color(0, 0, 0, 0));
						else
							g2.setColor(button.getBackground().darker());
					}

					g2.fillRect(0, 0, getWidth(), getHeight());

					paintText(g);
					return;
				} else if (getModel().isRollover()) {
					if (hoverColour != null)
						g2.setColor(new Color(hoverColour.r, hoverColour.g, hoverColour.b, hoverColour.a));
					else {
						if (image != null)
							g2.setColor(new Color(0, 0, 0, 0));
						else
							g2.setColor(button.getBackground().brighter());
					}

					g2.fillRect(0, 0, getWidth(), getHeight());

					paintText(g);
					return;
				} else {
					if (backgroundColour != null)
						g2.setColor(new Color(backgroundColour.r, backgroundColour.g, backgroundColour.b,
								backgroundColour.a));
					else
						g2.setColor(button.getBackground());
				}

				g2.fillRect(0, 0, getWidth(), getHeight());

				if (image != null) {
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, image.getTransparency());
					g2.setComposite(ac);

					g2.drawImage(image.getImage().getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				}

				paintText(g);
			}
		};

		private boolean visible = true;
		private Image image;

		private Alignment alignment = Alignment.NONE;
		private float indentX = 0.1f;
		private float indentY = 0.1f;

		private Colour hoverColour;
		private Colour pressedColour;
		private Colour backgroundColour;
		private Colour textColour;

		private Border customBorder;
		private javax.swing.border.Border standardBorder;

		// CONSTRUCTORS

		public Button(String text) {
			this.autoScalable = true;
			button.setFocusable(false);
			button.setText(text);
			standardBorder = button.getBorder();
			button.setContentAreaFilled(false);
		}

		public Button(String text, int width, int height) {
			this.autoScalable = true;
			button.setFocusable(false);
			button.setText(text);
			setSize(width, height);
			standardBorder = button.getBorder();
			button.setContentAreaFilled(false);
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return button;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void setParent(Component component) {
			this.parent = component;
		}

		// INHERITED METHODS (Visible)

		public void setVisible(boolean visible) {
			if (isActive()) {
				setBorderEnabled(visible);
				setActive(visible);
				button.setEnabled(visible);
			}

			this.visible = visible;
			button.repaint();
		}

		public Component getParent() {
			return parent;
		}

		// TASK

		public void handleActionTask(MuLEReferenceType<? extends ActionTask> actionTask) {
			this.button.addActionListener(actionTask.value);
		}

		// SETTER

		public void setSize(int width, int height) {
			button.setMinimumSize(new Dimension(width, height));
			button.setPreferredSize(new Dimension(width, height));
			button.setMaximumSize(new Dimension(width, height));
		}

		public void setBorderEnabled(boolean enabled) {
			if (enabled) {
				if (customBorder != null) {
					Border aB = (Border) customBorder;
					button.setBorder(aB.getBorder());
				} else
					button.setBorder(standardBorder);
			} else
				button.setBorder(null);
		}

		public void setHoverEnabled(boolean enabled) {
			if (enabled)
				button.setRolloverEnabled(true);
			else
				button.setRolloverEnabled(false);
		}

		public void setBorder(Border border) {
			Border aB = (Border) border;
			customBorder = border;
			button.setBorder(aB.getBorder());
		}

		public void setToolTip(String text) {
			button.setToolTipText(text);
		}

		public void setBackground(Image image) {
			this.image = (Image) image;
			button.repaint();
		}

		public void setBackground(Colour colour) {
			backgroundColour = colour;
			button.repaint();
		}

		public void setHoverColor(Colour colour) {
			hoverColour = colour;
			button.repaint();
		}

		public void setPressedColor(Colour colour) {
			pressedColour = colour;
			button.repaint();
		}

		public void setTaskCommand(String text) {
			button.setActionCommand(text);
		}

		public void setText(String text) {
			button.setText(text);
		}

		public void setTextAlignment(Alignment alignment) {
			this.alignment = alignment;
			/**
			 * switch(alignment){ case TOP_LEFT:
			 * button.setHorizontalAlignment(SwingConstants.LEFT);
			 * button.setVerticalAlignment(SwingConstants.TOP); break; case TOP_CENTER:
			 * button.setHorizontalAlignment(SwingConstants.CENTER);
			 * button.setVerticalAlignment(SwingConstants.TOP); break; case TOP_RIGHT:
			 * button.setHorizontalAlignment(SwingConstants.RIGHT);
			 * button.setVerticalAlignment(SwingConstants.TOP); break; case CENTER_LEFT:
			 * button.setHorizontalAlignment(SwingConstants.LEFT);
			 * button.setVerticalAlignment(SwingConstants.CENTER); break; case CENTER:
			 * button.setHorizontalAlignment(SwingConstants.CENTER);
			 * button.setVerticalAlignment(SwingConstants.CENTER); break; case CENTER_RIGHT:
			 * button.setHorizontalAlignment(SwingConstants.RIGHT);
			 * button.setVerticalAlignment(SwingConstants.CENTER); break; case BOTTOM_LEFT:
			 * button.setHorizontalAlignment(SwingConstants.LEFT);
			 * button.setVerticalAlignment(SwingConstants.BOTTOM); break; case
			 * BOTTOM_CENTER: button.setHorizontalAlignment(SwingConstants.CENTER);
			 * button.setVerticalAlignment(SwingConstants.BOTTOM); break; case BOTTOM_RIGHT:
			 * button.setHorizontalAlignment(SwingConstants.RIGHT);
			 * button.setVerticalAlignment(SwingConstants.BOTTOM); break; case NONE:
			 * button.setHorizontalAlignment(SwingConstants.CENTER);
			 * button.setVerticalAlignment(SwingConstants.CENTER); break; }
			 **/
			button.repaint();
		}

		public void setTextAlignment(Alignment alignment, float indentX, float indentY) {
			if (indentX > 1 || indentY > 1 || indentX < 0 || indentY < 0) {
				this.indentX = 0.1f;
				this.indentY = 0.1f;
			} else {
				this.indentX = indentX;
				this.indentY = indentY;
			}
			setTextAlignment(alignment);
		}

		public void setFont(String fontName, FontType fontType, int fontSize, Colour colour) {
			textColour = colour;
			switch (fontType) {
			case PLAIN:
				button.setFont(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));
				break;
			case BOLD:
				button.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD, fontSize));
				break;
			case ITALIC:
				button.setFont(new java.awt.Font(fontName, java.awt.Font.ITALIC, fontSize));
				break;
			case ITALIC_BOLD:
				button.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD + java.awt.Font.ITALIC, fontSize));
				break;
			}
			button.repaint();
		}

		public void setActive(boolean active) {
			this.button.setEnabled(active);
		}

		public void setPosition(int x, int y) {
			this.button.setLocation(x, y);
		}

		// REQUEST

		public boolean isActive() {
			return this.button.isEnabled();
		}

		// GETTER

		public int getWidth() {
			return this.button.getWidth();
		}

		public int getHeight() {
			return this.button.getHeight();
		}

		public int getX() {
			return this.button.getX();
		}

		public int getY() {
			return this.button.getY();
		}

		public String getTaskCommand() {
			return this.button.getActionCommand();
		}

		public Image getBackgroundImage() {
			if (image == null)
				return null;
			return this.image;
		}

		public String getText() {
			return button.getText();
		}

		// PRIVATES

		private void paintText(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHints(antialiasing);

			if (textColour != null)
				g2.setColor(new Color(textColour.r, textColour.g, textColour.b, textColour.a));
			else
				g2.setColor(button.getForeground());

			FontMetrics metrics = g2.getFontMetrics(button.getFont());
			int x = (button.getWidth() - metrics.stringWidth(button.getText())) / 2 - button.getLocation().x;
			int y = ((button.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

			int einzugX = (int) ((int) button.getWidth() * indentX);
			int einzugY = (int) ((int) button.getHeight() * indentY);

			switch (alignment) {
			case TOP_LEFT:
				x = einzugX;
				y = einzugY + metrics.getAscent();
				break;
			case TOP_CENTER:
				x = (button.getWidth() - metrics.stringWidth(button.getText())) / 2;
				y = einzugY + metrics.getAscent();
				break;
			case TOP_RIGHT:
				x = button.getWidth() - metrics.stringWidth(button.getText()) - einzugX;
				y = einzugY + metrics.getAscent();
				break;
			case CENTER_LEFT:
				x = einzugX;
				y = ((button.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			case CENTER:
				x = (button.getWidth() - metrics.stringWidth(button.getText())) / 2;
				y = ((button.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			case CENTER_RIGHT:
				x = button.getWidth() - metrics.stringWidth(button.getText()) - einzugX;
				y = ((button.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			case BOTTOM_LEFT:
				x = einzugX;
				y = button.getHeight() - (metrics.getHeight() - metrics.getAscent()) - einzugY;
				break;
			case BOTTOM_CENTER:
				x = (button.getWidth() - metrics.stringWidth(button.getText())) / 2;
				y = button.getHeight() - (metrics.getHeight() - metrics.getAscent()) - einzugY;
				break;
			case BOTTOM_RIGHT:
				x = button.getWidth() - metrics.stringWidth(button.getText()) - einzugX;
				y = button.getHeight() - (metrics.getHeight() - metrics.getAscent()) - einzugY;
				break;
			case NONE:
				x = (button.getWidth() - metrics.stringWidth(button.getText())) / 2;// - button.getLocation().x;
				y = ((button.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				break;
			}

			g2.setFont(button.getFont());
			g2.drawString(button.getText(), x, y);
		}
	}

	public static class CheckBox extends Component {
		private JCheckBox checkBox = new JCheckBox() {

			protected void paintComponent(Graphics g) {
				if (!visible)
					return;

				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (backgroundImage != null) {
					this.setBackground(new Color(0, 0, 0, 0));
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
							backgroundImage.getTransparency());
					g2.setComposite(ac);

					g.drawImage(backgroundImage.getImage().getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				}

				super.paintComponent(g);
			}
		};

		private int contentAlignment = 0; // 0 = Both Left, 1 = Both Right, 2 = Icon Right/Text Left, 3 = Icon Left/Text
											// Right
		private float fontSize = 15f;
		private CheckBoxStyle style;
		private int roundValue = 0;
		private Border border;
		private boolean hovering = true;

		private boolean visible = true;

		private Image backgroundImage;
		private Colour backgroundColour;

		private Colour iconBackground;
		private Colour iconPressed;
		private Colour iconHovered;
		private Colour iconSelected;

		private Colour textPressed;
		private Colour textHovered;
		private Colour textSelected;
		private Colour textColour;

		private Image iconImage;
		private Image iconSelectedImage;

		private class CheckBoxStyle implements Icon {
			private int dim = 15;
			private int borderOffsetX = 4;

			public CheckBoxStyle(int dimension) {
				dim = dimension;
			}

			protected int getDimension() {
				return dim;
			}

			public void paintIcon(java.awt.Component c, Graphics g, int x, int y) {
				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				ButtonModel buttonModel = ((AbstractButton) c).getModel();

				FontMetrics metrics = g2.getFontMetrics(checkBox.getFont());

				int y_offset = (int) (c.getSize().getHeight() / 2) - (int) (getDimension() / 2);
				int x_offset;
				switch (contentAlignment) {
				case 0:
					x_offset = borderOffsetX;
					break;
				case 1:
					x_offset = (int) (c.getSize().getWidth() - getDimension() - borderOffsetX);
					break;
				case 2:
					x_offset = (int) (c.getSize().getWidth() - getDimension() - borderOffsetX);
					break;
				case 3:
					x_offset = borderOffsetX;
					break;
				default:
					x_offset = borderOffsetX;
					break;

				}

				if (buttonModel.isRollover()) {
					g2.setColor(new Color(0, 60, 120));
				} else if (buttonModel.isRollover()) {
					g2.setColor(Color.BLACK);
				} else {
					g2.setColor(Color.DARK_GRAY);
				}

				if (fontSize < dim)
					g2.fillRoundRect(x_offset, y_offset, (int) dim, (int) dim, roundValue, roundValue);
				else
					g2.fillRoundRect(x_offset, y_offset, (int) fontSize, (int) fontSize, roundValue, roundValue);

				if (buttonModel.isPressed()) {
					if (textPressed != null)
						checkBox.setForeground(new Color(textPressed.r, textPressed.g, textPressed.b, textPressed.a));

					if (iconPressed != null)
						g2.setColor(new Color(iconPressed.r, iconPressed.g, iconPressed.b, iconPressed.a));
					else
						g2.setColor(Color.GRAY);
				} else if (buttonModel.isRollover() && hovering) {
					if (textHovered != null)
						checkBox.setForeground(new Color(textHovered.r, textHovered.g, textHovered.b, textHovered.a));

					if (iconHovered != null)
						g2.setColor(new Color(iconHovered.r, iconHovered.g, iconHovered.b, iconHovered.a));
					else
						g2.setColor(new Color(240, 240, 250));
				} else {
					if (textColour != null)
						checkBox.setForeground(new Color(textColour.r, textColour.g, textColour.b, textColour.a));

					if (iconBackground != null)
						g2.setColor(new Color(iconBackground.r, iconBackground.g, iconBackground.b, iconBackground.a));
					else
						g2.setColor(Color.WHITE);
				}

				if (iconImage == null) {
					if (fontSize < dim)
						g2.fillRoundRect(1 + x_offset, y_offset + 1, (int) dim - 2, (int) dim - 2, roundValue,
								roundValue);
					else
						g2.fillRoundRect(1 + x_offset, y_offset + 1, (int) fontSize - 2, (int) fontSize - 2, roundValue,
								roundValue);
				} else if ((iconImage != null && hovering && (buttonModel.isRollover() && !buttonModel.isPressed()))) {
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.875f);
					g2.setComposite(ac);
					if (fontSize < dim)
						g2.drawImage(iconImage.getImage().getImage(), 1 + x_offset, y_offset + 1, (int) dim - 2,
								(int) dim - 2, null);
					else
						g2.drawImage(iconImage.getImage().getImage(), 1 + x_offset, y_offset + 1, (int) fontSize - 2,
								(int) fontSize - 2, null);
				} else if ((iconImage != null && (buttonModel.isRollover() && buttonModel.isPressed()))) {
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
					g2.setComposite(ac);
					if (fontSize < dim)
						g2.drawImage(iconImage.getImage().getImage(), 1 + x_offset, y_offset + 1, (int) dim - 2,
								(int) dim - 2, null);
					else
						g2.drawImage(iconImage.getImage().getImage(), 1 + x_offset, y_offset + 1, (int) fontSize - 2,
								(int) fontSize - 2, null);
				} else {
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
							iconImage.getTransparency());
					g2.setComposite(ac);
					if (fontSize < dim)
						g2.drawImage(iconImage.getImage().getImage(), 1 + x_offset, y_offset + 1, (int) dim - 2,
								(int) dim - 2, null);
					else
						g2.drawImage(iconImage.getImage().getImage(), 1 + x_offset, y_offset + 1, (int) fontSize - 2,
								(int) fontSize - 2, null);
				}

				if (buttonModel.isSelected()) {
					int r_x = 1;
					if (textSelected != null)
						checkBox.setForeground(
								new Color(textSelected.r, textSelected.g, textSelected.b, textSelected.a));

					if (iconSelected != null)
						g2.setColor(new Color(iconSelected.r, iconSelected.g, iconSelected.b, iconSelected.a));
					else
						g2.setColor(Color.GRAY);

					if (iconSelectedImage == null) {
						if (fontSize < dim)
							g2.fillRoundRect(x_offset + r_x + 3, y_offset + 3 + r_x, (int) dim - (7 + r_x),
									(int) dim - (7 + r_x), roundValue, roundValue);
						else
							g2.fillRoundRect(x_offset + r_x + 3, y_offset + 3 + r_x, (int) fontSize - (7 + r_x),
									(int) fontSize - (7 + r_x), roundValue, roundValue);
					} else {
						AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
								iconSelectedImage.getTransparency());
						g2.setComposite(ac);
						if (fontSize < dim)
							g2.drawImage(iconSelectedImage.getImage().getImage(), x_offset + r_x + 3,
									y_offset + 3 + r_x, (int) dim - (7 + r_x), (int) dim - (7 + r_x), null);
						else
							g2.drawImage(iconSelectedImage.getImage().getImage(), x_offset + r_x + 3,
									y_offset + 3 + r_x, (int) fontSize - (7 + r_x), (int) fontSize - (7 + r_x), null);
					}
				}
			}

			public int getIconWidth() {
				return getDimension();
			}

			public int getIconHeight() {
				return getDimension();
			}
		}

		// CONSTRUCTORS

		public CheckBox() {
			this.autoScalable = true;
			style = new CheckBoxStyle(15);
			checkBox.setOpaque(true);
			checkBox.setFocusable(false);
			this.checkBox.setIcon(style);
			Font font = checkBox.getFont();
			Font newFont = font.deriveFont(fontSize);
			checkBox.setFont(newFont);
		}

		public CheckBox(CheckBoxAlignment alignment, String text) {
			this.autoScalable = true;
			checkBox.setText(text);
			checkBox.setOpaque(true);
			checkBox.setFocusable(false);
			style = new CheckBoxStyle(15);
			this.checkBox.setIcon(style);
			Font font = checkBox.getFont();
			Font newFont = font.deriveFont(fontSize);
			checkBox.setFont(newFont);
			setAlignment(alignment);
		}

		public CheckBox(CheckBoxAlignment alignment, String text, boolean selected) {
			this.autoScalable = true;
			checkBox.setSelected(selected);
			checkBox.setText(text);
			checkBox.setOpaque(true);
			checkBox.setFocusable(false);
			style = new CheckBoxStyle(15);
			this.checkBox.setIcon(style);
			Font font = checkBox.getFont();
			Font newFont = font.deriveFont(fontSize);
			checkBox.setFont(newFont);
			setAlignment(alignment);
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return checkBox;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void setParent(Component component) {
			this.parent = component;
		}

		// INHERITED METHODS (Visible)

		public void setVisible(boolean visible) {
			if (border != null)
				checkBox.setBorderPainted(visible);

			checkBox.setEnabled(visible);
			this.visible = visible;
			checkBox.repaint();
		}

		public Component getParent() {
			return parent;
		}

		// TASKS

		public void handleActionTask(ActionTask actionTask) {
			this.checkBox.addActionListener(actionTask);
		}

		// SETTER

		public void setSize(int width, int height) {
			checkBox.setMinimumSize(new Dimension(width, height));
			checkBox.setPreferredSize(new Dimension(width, height));
			checkBox.setMaximumSize(new Dimension(width, height));
		}

		public void setRoundCorners(int roundValue) {
			this.roundValue = roundValue;
			checkBox.repaint();
		}

		public void setBorder(Border border) {
			Border aB = (Border) border;
			this.border = border;
			checkBox.setBorderPainted(true);
			checkBox.setBorder(aB.getBorder());
		}

		public void setHoverEnabled(boolean enabled) {
			hovering = enabled;
		}

		public void setToolTip(String text) {
			checkBox.setToolTipText(text);
		}

		public void setIconSize(int size) {
			float sizeFloat = (float) size;
			this.fontSize = sizeFloat;
			style.dim = size;
			this.checkBox.setIcon(style);
		}

		public void setFont(String fontName, FontType fontType, int fontSize, Colour colour) {
			this.textColour = colour;
			this.checkBox.setForeground(new Color(colour.r, colour.g, colour.b, colour.a));
			float sizeFloat = (float) fontSize;
			this.fontSize = sizeFloat;

			if (fontSize > style.dim) {
				style.dim = fontSize;
				this.checkBox.setIcon(style);
			} else {
				this.checkBox.setIcon(style);
			}

			switch (fontType) {
			case PLAIN:
				checkBox.setFont(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));
				break;
			case BOLD:
				checkBox.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD, fontSize));
				break;
			case ITALIC:
				checkBox.setFont(new java.awt.Font(fontName, java.awt.Font.ITALIC, fontSize));
				break;
			case ITALIC_BOLD:
				checkBox.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD + java.awt.Font.ITALIC, fontSize));
				break;
			}
		}

		public void setSelected(boolean selected) {
			checkBox.setSelected(selected);
		}

		public void setBackground(Colour colour) {
			this.backgroundColour = colour;
			checkBox.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setBackground(Image image) {
			this.backgroundImage = (Image) image;
			checkBox.repaint();
		}

		public void setTextHoverColour(Colour colour) {
			this.textHovered = colour;
			checkBox.setIcon(style);
		}

		public void setTextPressedColour(Colour colour) {
			this.textPressed = colour;
			checkBox.setIcon(style);
		}

		public void setTextSelectedColour(Colour colour) {
			this.textSelected = colour;
			checkBox.setIcon(style);
		}

		public void setTaskCommand(String text) {
			checkBox.setActionCommand(text);
		}

		public void setText(String text) {
			checkBox.setText(text);
		}

		public void setIconBackground(Image image) {
			this.iconImage = (Image) image;
			checkBox.repaint();
		}

		public void setSelectedIcon(Image image) {
			this.iconSelectedImage = (Image) image;
			checkBox.repaint();
		}

		public void setPosition(int x, int y) {
			this.checkBox.setLocation(x, y);
		}

		public void setIconColour(Colour colour) {
			this.iconBackground = colour;
			checkBox.setIcon(style);
		}

		public void setSelectedColour(Colour colour) {
			this.iconSelected = colour;
			checkBox.setIcon(style);
		}

		public void setPressedColour(Colour colour) {
			this.iconPressed = colour;
			checkBox.setIcon(style);
		}

		public void setHoverColour(Colour colour) {
			this.iconHovered = colour;
			checkBox.setIcon(style);
		}

		// REQUESTS

		public boolean isSelected() {
			return checkBox.isSelected();
		}

		// GETTER

		public String getTaskCommand() {
			return checkBox.getActionCommand();
		}

		public String getText() {
			return checkBox.getText();
		}

		public int getWidth() {
			return this.checkBox.getWidth();
		}

		public int getHeight() {
			return this.checkBox.getHeight();
		}

		public int getX() {
			return this.checkBox.getX();
		}

		public int getY() {
			return this.checkBox.getY();
		}

		public Image getBackgroundImage() {
			return backgroundImage;
		}

		public Image getIconBackgroundImage() {
			return iconImage;
		}

		public Image getSelectedIconImage() {
			return iconSelectedImage;
		}

		// PRIVATE

		private void setAlignment(CheckBoxAlignment alignment) {
			switch (alignment) {
			case ICON_LEFT_TEXT_RIGHT:
				this.contentAlignment = 3;
				this.checkBox.setHorizontalAlignment(SwingConstants.RIGHT);
				this.checkBox.setHorizontalTextPosition(SwingConstants.RIGHT);
				break;
			case ICON_RIGHT_TEXT_LEFT:
				this.contentAlignment = 2;
				this.checkBox.setHorizontalAlignment(SwingConstants.LEFT);
				this.checkBox.setHorizontalTextPosition(SwingConstants.LEFT);
				break;
			case ICON_TEXT_RIGHT:
				this.contentAlignment = 1;
				this.checkBox.setHorizontalAlignment(SwingConstants.RIGHT);
				this.checkBox.setHorizontalTextPosition(SwingConstants.LEFT);
				break;
			case ICON_TEXT_LEFT:
				this.contentAlignment = 0;
				this.checkBox.setHorizontalAlignment(SwingConstants.LEFT);
				this.checkBox.setHorizontalTextPosition(SwingConstants.RIGHT);
				break;
			case NONE:
				break;
			}
		}
	}

	public static class DropDownMenu extends Component {
		private SizedJComboBox<String> dropDownMenu;
		private AbstractButton dropDownButton;
		private boolean buttonDeleted = false;
		private boolean customPopupSize = false;
		private Color popupColor;
		private Font popupFont;
		private Color popupFontColor;
		private Color selectedColor;
		private Color fontColor;

		// CONSTRUCTORS

		public DropDownMenu(String[] itemNames) {
			this.autoScalable = true;
			this.dropDownMenu = new SizedJComboBox<String>(itemNames);
			this.dropDownButton = getDropDownButton();
		}

		// CLASSES

		public class SizedJComboBox<String> extends JComboBox<String> {
			protected int popupWidth;
			protected int popupHeight;

			public SizedJComboBox(final String[] items) {
				super(items);
			}

			public void updateUI() {
				super.updateUI();
				if (buttonDeleted) {
					UIManager.put("ComboBox.squareButton", Boolean.FALSE);
					setUI(new BasicDropDownMenuUI());
					setBorder(BorderFactory.createLineBorder(Color.GRAY));
				} else {
					setUI(new SizedComboBoxUI());
				}
			}

			public void setPopupWidth(int width) {
				popupWidth = width;
			}

			public Dimension getPopupSize() {
				Dimension size = getSize();
				if (popupWidth < 1)
					popupWidth = size.width;
				return new Dimension(popupWidth, popupHeight);
			}
		}

		public class BasicDropDownMenuUI extends BasicComboBoxUI {

			protected JButton createArrowButton() {
				JButton b = new JButton();
				b.setBorder(BorderFactory.createEmptyBorder());
				b.setVisible(false);
				return b;
			}

			protected ComboPopup createPopup() {
				BasicComboPopup popup = new BasicComboPopup(comboBox) {
					public void show() {
						if (selectedColor != null)
							list.setSelectionBackground(selectedColor);
						if (popupColor != null)
							list.setBackground(popupColor);
						if (popupFont != null) {
							list.setFont(popupFont);
							list.setForeground(popupFontColor);
						}

						Dimension popupSize = ((SizedJComboBox) comboBox).getPopupSize();
						popupSize.setSize(popupSize.width,
								popupSize.height < 1 ? getPopupHeightForRowCount(comboBox.getMaximumRowCount())
										: popupSize.height);
						java.awt.Rectangle popupBounds;
						if (buttonDeleted && !customPopupSize)
							popupBounds = computePopupBounds(0, comboBox.getBounds().height,
									popupSize.width - 2 - dropDownButton.getWidth(), popupSize.height);
						else
							popupBounds = computePopupBounds(0, comboBox.getBounds().height, popupSize.width - 2,
									popupSize.height);
						scroller.setMaximumSize(popupBounds.getSize());
						scroller.setPreferredSize(popupBounds.getSize());
						scroller.setMinimumSize(popupBounds.getSize());
						list.invalidate();
						int selectedIndex = comboBox.getSelectedIndex();
						if (selectedIndex == -1) {
							list.clearSelection();
						} else {
							list.setSelectedIndex(selectedIndex);
						}
						list.ensureIndexIsVisible(list.getSelectedIndex());

						setLightWeightPopupEnabled(comboBox.isLightWeightPopupEnabled());

						show(comboBox, popupBounds.x, popupBounds.y);
					}
				};

				popup.getAccessibleContext().setAccessibleParent(comboBox);
				return popup;
			}
		}

		public class SizedComboBoxUI extends MetalComboBoxUI {
			protected ComboPopup createPopup() {
				BasicComboPopup popup = new BasicComboPopup(comboBox) {
					public void show() {
						if (selectedColor != null)
							list.setSelectionBackground(selectedColor);
						if (popupColor != null)
							list.setBackground(popupColor);
						if (popupFont != null) {
							list.setFont(popupFont);
							list.setForeground(popupFontColor);
						}

						Dimension popupSize = ((SizedJComboBox) comboBox).getPopupSize();
						popupSize.setSize(popupSize.width,
								popupSize.height < 1 ? getPopupHeightForRowCount(comboBox.getMaximumRowCount())
										: popupSize.height);
						java.awt.Rectangle popupBounds;
						if (buttonDeleted && !customPopupSize)
							popupBounds = computePopupBounds(0, comboBox.getBounds().height,
									popupSize.width - 1 - dropDownButton.getWidth(), popupSize.height);
						else
							popupBounds = computePopupBounds(0, comboBox.getBounds().height, popupSize.width - 2,
									popupSize.height);

						scroller.setMaximumSize(popupBounds.getSize());
						scroller.setPreferredSize(popupBounds.getSize());
						scroller.setMinimumSize(popupBounds.getSize());
						list.invalidate();
						int selectedIndex = comboBox.getSelectedIndex();
						if (selectedIndex == -1) {
							list.clearSelection();
						} else {
							list.setSelectedIndex(selectedIndex);
						}
						list.ensureIndexIsVisible(list.getSelectedIndex());

						setLightWeightPopupEnabled(comboBox.isLightWeightPopupEnabled());

						show(comboBox, popupBounds.x, popupBounds.y);
					}
				};

				popup.getAccessibleContext().setAccessibleParent(comboBox);
				return popup;
			}
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return dropDownMenu;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			dropDownMenu.setVisible(visible);
		}

		// TASKS

		public void handleActionTask(ActionTask actionTask) {
			dropDownMenu.addActionListener(actionTask);
		}

		// SETTER

		public void setEditable(boolean editable) {
			dropDownMenu.setEditable(editable);
		}

		public void setSelectedIndex(int index) {
			dropDownMenu.setSelectedIndex(index);
		}

		public void setEnabled(boolean enabled) {
			dropDownMenu.setEnabled(enabled);
		}

		public void setTextAlignment(HorizontalAlignment alignment) {
			switch (alignment) {
			case RIGHT:
				((JLabel) dropDownMenu.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
				break;
			case LEFT:
				((JLabel) dropDownMenu.getRenderer()).setHorizontalAlignment(JLabel.LEFT);
				break;
			case CENTER:
				((JLabel) dropDownMenu.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
				break;
			}
		}

		public void setItemLimit(int limit) {
			dropDownMenu.setMaximumRowCount(limit);
		}

		public void setSize(int width, int height) {
			dropDownMenu.setMinimumSize(new Dimension(width, height));
			dropDownMenu.setPreferredSize(new Dimension(width, height));
			dropDownMenu.setMaximumSize(new Dimension(width, height));
		}

		public void setPosition(int x, int y) {
			dropDownMenu.setLocation(x, y);
		}

		public void setBackground(Colour colour) {
			dropDownMenu.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setSelectedColour(Colour colour) {
			selectedColor = new Color(colour.r, colour.g, colour.b, colour.a);
			dropDownMenu.updateUI();
		}

		public void setPopupBackground(Colour colour) {
			popupColor = new Color(colour.r, colour.g, colour.b, colour.a);
			dropDownMenu.updateUI();
		}

		public void setBorder(Border border) {
			Border aB = (Border) border;
			dropDownMenu.setBorder(aB.getBorder());
		}

		public void setActionCommand(String command) {
			dropDownMenu.setActionCommand(command);
		}

		public void setFont(String fontName, FontType fontType, int fontSize, Colour colour) {
			fontColor = new Color(colour.r, colour.g, colour.b, colour.a);
			dropDownMenu.setForeground(new Color(colour.r, colour.g, colour.b, colour.a));
			switch (fontType) {
			case PLAIN:
				dropDownMenu.setFont(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));
				break;
			case BOLD:
				dropDownMenu.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD, fontSize));
				break;
			case ITALIC:
				dropDownMenu.setFont(new java.awt.Font(fontName, java.awt.Font.ITALIC, fontSize));
				break;
			case ITALIC_BOLD:
				dropDownMenu.setFont(new java.awt.Font(fontName, java.awt.Font.BOLD + java.awt.Font.ITALIC, fontSize));
				break;
			}
			dropDownMenu.updateUI();
		}

		public void setPopupFont(String fontName, FontType fontType, int fontSize, Colour colour) {
			popupFontColor = new Color(colour.r, colour.g, colour.b, colour.a);
			switch (fontType) {
			case PLAIN:
				popupFont = new Font(fontName, java.awt.Font.PLAIN, fontSize);
				break;
			case BOLD:
				popupFont = new Font(fontName, java.awt.Font.PLAIN, fontSize);
				break;
			case ITALIC:
				popupFont = new Font(fontName, java.awt.Font.PLAIN, fontSize);
				break;
			case ITALIC_BOLD:
				popupFont = new Font(fontName, java.awt.Font.PLAIN, fontSize);
				break;
			}
			dropDownMenu.updateUI();
		}

		public void setSelectedItem(String itemName) {
			dropDownMenu.setSelectedItem(itemName);
		}

		public void setPopupWidth(int width) {
			dropDownMenu.setPopupWidth(width);
			customPopupSize = true;
		}

		// ADD

		public void addItem(String name) {
			dropDownMenu.addItem(name);
		}

		public void addItemAt(String name, int index) {
			dropDownMenu.insertItemAt(name, index);
		}

		// REMOVE

		public void removeItemAt(int index) {
			dropDownMenu.removeItemAt(index);
		}

		public void removeItem(String name) {
			dropDownMenu.removeItem(name);
		}

		public void removeAllItems() {
			dropDownMenu.removeAllItems();
		}

		public void removeDropDownButton() {
			dropDownButton.setVisible(false);
			dropDownButton.setEnabled(false);
			buttonDeleted = true;
			dropDownMenu.updateUI();
		}

		// GETTER

		public String getSelectedItem() {
			return (String) dropDownMenu.getSelectedItem();
		}

		public int getSelectedIndex() {
			return dropDownMenu.getSelectedIndex();
		}

		public String getItemAt(int index) {
			return (String) dropDownMenu.getItemAt(index);
		}

		public int getX() {
			return dropDownMenu.getX();
		}

		public int getY() {
			return dropDownMenu.getY();
		}

		public int getWidth() {
			return dropDownMenu.getWidth();
		}

		public int getHeight() {
			return dropDownMenu.getHeight();
		}

		public int getItemCount() {
			return dropDownMenu.getItemCount();
		}

		// PRIVATES

		private AbstractButton getDropDownButton() {
			java.awt.Component[] components = dropDownMenu.getComponents();
			for (java.awt.Component component : components) {
				if (component instanceof AbstractButton)
					return (AbstractButton) component;
			}
			return null;
		}
	}

	public static class Slider extends Component {
		private JSlider slider = new JSlider();
		Hashtable labels = new Hashtable();

		public class LightSliderUI extends BasicSliderUI {

			private transient boolean upperDragging;

			protected TrackListener createTrackListener(JSlider slider) {
				return new RangeTrackListener();
			}

			public class ChangeHandler implements ChangeListener {

				public void stateChanged(ChangeEvent arg0) {
					calculateThumbLocation();
					slider.repaint();
				}
			}

			public class RangeTrackListener extends TrackListener {

				public void mouseClicked(MouseEvent e) {
					if (!slider.isEnabled()) {
						return;
					}
					currentMouseX -= thumbRect.width / 2;
					moveUpperThumb();
				}

				public void mousePressed(MouseEvent e) {
					if (!slider.isEnabled()) {
						return;
					}

					currentMouseX = e.getX();
					currentMouseY = e.getY();

					if (slider.isRequestFocusEnabled()) {
						slider.requestFocus();
					}

					boolean upperPressed = false;
					if (slider.getMinimum() == slider.getValue()) {
						if (thumbRect.contains(currentMouseX, currentMouseY)) {
							upperPressed = true;
						}
					} else {
						if (thumbRect.contains(currentMouseX, currentMouseY)) {
							upperPressed = true;
						}
					}

					if (upperPressed) {
						switch (slider.getOrientation()) {
						case JSlider.VERTICAL:
							offset = currentMouseY - thumbRect.y;
							break;
						case JSlider.HORIZONTAL:
							offset = currentMouseX - thumbRect.x;
							break;
						}
						// upperThumbSelected = true;
						upperDragging = true;
						return;
					}

					upperDragging = false;
					slider.repaint();
				}

				public void mouseReleased(MouseEvent e) {
					upperDragging = false;
					slider.setValueIsAdjusting(false);
					super.mouseReleased(e);
					slider.repaint();
				}

				public void mouseDragged(MouseEvent e) {
					if (!slider.isEnabled()) {
						return;
					}

					currentMouseX = e.getX();
					currentMouseY = e.getY();

					if (upperDragging) {
						slider.setValueIsAdjusting(true);
						moveUpperThumb();

					}
					slider.repaint();
				}

				public boolean shouldScroll(int direction) {
					return false;
				}

				/**
				 * Moves the location of the upper thumb, and sets its corresponding value in
				 * the slider.
				 */
				public void moveUpperThumb() {
					int thumbMiddle = 0;
					switch (slider.getOrientation()) {
					case JSlider.HORIZONTAL:
						int halfThumbWidth = thumbRect.width / 2;
						int thumbLeft = currentMouseX - offset;
						int trackLeft = trackRect.x;
						int trackRight = trackRect.x + (trackRect.width - 1);
						int hMax = xPositionForValue(slider.getMaximum() - slider.getExtent());

						if (drawInverted()) {
							trackLeft = hMax;
						} else {
							trackRight = hMax;
						}
						thumbLeft = Math.max(thumbLeft, trackLeft - halfThumbWidth);
						thumbLeft = Math.min(thumbLeft, trackRight - halfThumbWidth);

						setThumbLocation(thumbLeft, thumbRect.y);

						thumbMiddle = thumbLeft + halfThumbWidth;
						slider.setValue(valueForXPosition(thumbMiddle));
						break;

					default:
						return;
					}
					slider.repaint();
				}
			}

			public LightSliderUI(JSlider b) {
				super(b);
				// b.addChangeListener(new ChangeHandler());
				// createTrackListener(b);
			}

			protected void calculateThumbSize() {
				super.calculateThumbSize();
				if (knobRadius == 0) {
					int size = Math.max(thumbRect.width, thumbRect.height);
					thumbRect.setSize(size, size);
				} else
					thumbRect.setSize(knobRadius, knobRadius);
			}

			protected void calculateThumbLocation() {
				// Call superclass method for lower thumb location.
				super.calculateThumbLocation();

				// Adjust upper value to snap to ticks if necessary.
				if (slider.getSnapToTicks()) {
					int upperValue = slider.getValue() + slider.getExtent();
					int snappedValue = upperValue;
					int majorTickSpacing = slider.getMajorTickSpacing();
					int minorTickSpacing = slider.getMinorTickSpacing();
					int tickSpacing = 0;

					if (minorTickSpacing > 0) {
						tickSpacing = minorTickSpacing;
					} else if (majorTickSpacing > 0) {
						tickSpacing = majorTickSpacing;
					}

					if (tickSpacing != 0) {
						// If it's not on a tick, change the value
						if ((upperValue - slider.getMinimum()) % tickSpacing != 0) {
							float temp = (float) (upperValue - slider.getMinimum()) / (float) tickSpacing;
							int whichTick = Math.round(temp);
							snappedValue = slider.getMinimum() + (whichTick * tickSpacing);
						}

						if (snappedValue != upperValue) {
							slider.setExtent(snappedValue - slider.getValue());
						}
					}
				}

				// Calculate upper thumb location. The thumb is centered over its
				// value on the track.
				if (slider.getOrientation() == JSlider.HORIZONTAL) {
					int upperPosition = xPositionForValue(slider.getValue() + slider.getExtent());
					thumbRect.x = upperPosition - (thumbRect.width / 2);
					thumbRect.y = trackRect.y;

				} else {
					int upperPosition = yPositionForValue(slider.getValue() + slider.getExtent());
					thumbRect.x = trackRect.x;
					thumbRect.y = upperPosition - (thumbRect.height / 2);
				}
				slider.repaint();
			}

			private java.awt.Shape createThumbShape(int width, int height) {
				Ellipse2D shape = new Ellipse2D.Double(0, 0, width, height);
				return shape;
			}

			public void paintTrack(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				Stroke old = g2d.getStroke();
				g2d.setStroke(new BasicStroke(trackThickness));
				g2d.setPaint(trackColor);
				Color oldColor = trackColor;
				java.awt.Rectangle trackBounds = trackRect;
				if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
					g2d.drawLine(trackRect.x, trackRect.y + trackRect.height / 2, trackRect.x + trackRect.width,
							trackRect.y + trackRect.height / 2);
					int lowerX = thumbRect.width / 2;
					int upperX = thumbRect.x + (thumbRect.width / 2);
					int cy = (trackBounds.height / 2) - 2;
					g2d.translate(trackBounds.x, trackBounds.y + cy);
					g2d.setColor(progressTrackColor);
					g2d.drawLine(lowerX - trackBounds.x, 2, upperX - trackBounds.x, 2);
					g2d.translate(-trackBounds.x, -(trackBounds.y + cy));
					g2d.setColor(oldColor);
				}
				g2d.setStroke(old);
			}

			public void paintThumb(Graphics g) {
				if (!hideKnob) {
					java.awt.Rectangle knobBounds = thumbRect;
					int w = knobBounds.width;
					int h = knobBounds.height;
					Graphics2D g2d = (Graphics2D) g.create();
					java.awt.Shape thumbShape = createThumbShape(w - 1, h - 1);
					g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2d.translate(knobBounds.x, knobBounds.y);
					g2d.setColor(knobFillColor);
					g2d.fill(thumbShape);

					g2d.setColor(knobStrokeColor);
					g2d.draw(thumbShape);
					g2d.dispose();
				}
			}
		}

		private Color knobFillColor = Color.BLACK;
		private Color knobStrokeColor = Color.BLACK;
		private int knobRadius = 0;
		private boolean hideKnob = false;

		private Color trackColor = Color.GRAY;
		private Color progressTrackColor = Color.BLACK;
		private int trackThickness = 5;

		// CONSTRUCTOS

		public Slider(int minimum, int maximum) {
			this.autoScalable = true;
			slider.setMinimum(minimum);
			slider.setMaximum(maximum);
			slider.setUI(new LightSliderUI(slider));
			slider.setFocusable(false);
		}

		public Slider(int minimum, int maximum, int value) {
			this.autoScalable = true;
			slider.setMinimum(minimum);
			slider.setMaximum(maximum);
			slider.setValue(value);
			slider.setUI(new LightSliderUI(slider));
			slider.setFocusable(false);
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return slider;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			slider.setVisible(visible);
		}

		// TASKS

		public void handleValueChangedTask(ValueChangedTask stateChangedTask) {
			this.slider.addChangeListener(stateChangedTask);
		}

		// SETTER

		public void setBorder(Border border) {
			Border aB = (Border) border;
			slider.setBorder(aB.getBorder());
		}

		public void setMinimum(int minimum) {
			slider.setMinimum(minimum);
		}

		public void setMaximum(int maximum) {
			slider.setMaximum(maximum);
		}

		public void setValue(int value) {
			slider.setValue(value);
		}

		public void setSize(int width, int height) {
			slider.setMinimumSize(new Dimension(width, height));
			slider.setPreferredSize(new Dimension(width, height));
			slider.setMaximumSize(new Dimension(width, height));
		}

		public void setInverted(boolean inverted) {
			slider.setInverted(inverted);
		}

		public void setEnabled(boolean enabled) {
			slider.setEnabled(enabled);
		}

		public void setPosition(int x, int y) {
			slider.setLocation(x, y);
		}

		public void setBackground(Colour colour) {
			slider.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setToolTip(String text) {
			slider.setToolTipText(text);
		}

		public void setSnapToTicks(boolean snapping) {
			slider.setSnapToTicks(snapping);
		}

		public void setMajorTickSpacing(int spacing) {
			slider.setMajorTickSpacing(spacing);
		}

		public void setMinorTickSpacing(int spacing) {
			slider.setMinorTickSpacing(spacing);
		}

		public void setLabel(Label label, int position) {
			Label Label = (Label) label;
			labels.put(position, Label.getComponent());
			slider.setLabelTable(labels);
		}

		public void setKnobProperties(Colour fillColour, Colour strokeColour, int radius) {
			this.knobFillColor = new Color(fillColour.r, fillColour.g, fillColour.b, fillColour.a);
			this.knobStrokeColor = new Color(strokeColour.r, strokeColour.g, strokeColour.b, strokeColour.a);
			this.knobRadius = radius;
			slider.setUI(new LightSliderUI(slider));
			slider.repaint();
		}

		public void setTrackProperties(Colour trackColour, Colour progressTrackColour, int thickness) {
			this.trackColor = new Color(trackColour.r, trackColour.g, trackColour.b, trackColour.a);
			this.progressTrackColor = new Color(progressTrackColour.r, progressTrackColour.g, progressTrackColour.b,
					progressTrackColour.a);
			this.trackThickness = thickness;
			slider.setUI(new LightSliderUI(slider));
			slider.repaint();
		}

		// SHOW

		public void showTicks() {
			slider.setPaintTicks(true);
		}

		public void showLabels() {
			slider.setPaintLabels(true);
		}

		public void hideKnob(boolean hide) {
			this.hideKnob = hide;
			slider.repaint();
		}

		// REQUESTS

		public boolean isInverted() {
			return slider.getInverted();
		}

		public boolean isEnabled() {
			return slider.isEnabled();
		}

		public boolean isSnapping() {
			return slider.getSnapToTicks();
		}

		// GETTER

		public int getWidth() {
			return slider.getWidth();
		}

		public int getHeight() {
			return slider.getHeight();
		}

		public int getX() {
			return slider.getX();
		}

		public int getY() {
			return slider.getY();
		}

		public int getMinimum() {
			return slider.getMinimum();
		}

		public int getMaximum() {
			return slider.getMaximum();
		}

		public int getValue() {
			return slider.getValue();
		}

	}

	public static abstract class Shape extends Component {
		public abstract void handleMouseTask(MouseTask mouseTask);
		public abstract void setSize(int width, int height);
		public abstract int getWidth();
		public abstract int getHeight();
		public abstract void setImage(Image image);
		public abstract Image getImage();
		public abstract void setColour(Colour colour);
		public abstract Colour getColour();
	}

	public static class Polygon extends Shape {

		private JLabel label = new JLabel() {

			public boolean contains(int x1, int y1) {
				if (polygon == null || !polygon.getBounds().equals(getBounds())) {
					int x0 = getSize().width / 2;
					int y0 = getSize().height / 2;
					for (int i = 0; i < pointsCounter; i++) {
						double v = i * angle;
						xPoints[i] = x0 + (int) Math.round((getWidth() / 2) * Math.cos(v));
						yPoints[i] = y0 + (int) Math.round((getHeight() / 2) * Math.sin(v));
					}
					polygon = new java.awt.Polygon(xPoints, yPoints, pointsCounter);
				}
				return polygon.contains(x1, y1);
			}

			public void paintComponent(Graphics g) {
				if (!visible)
					return;

				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (image == null) {
					if (scalingFactorX != 1 || scalingFactorY != 1)
						g2.scale(scalingFactorX, scalingFactorY);

					g2.setColor(new Color(colour.r, colour.g, colour.b, colour.a));
					// g2.fillPolygon(polygon);
					g2.fillPolygon(pPointsX, pPointsY, pointsCounter);

					if (stroke) {
						if (rounded)
							g2.setStroke(new BasicStroke(strokeWidth, BasicStroke.JOIN_ROUND, BasicStroke.CAP_ROUND));
						else
							g2.setStroke(new BasicStroke(strokeWidth));

						g2.setPaint(new Color(strokeColour.r, strokeColour.g, strokeColour.b, strokeColour.a));

						// g2.drawPolygon(polygon);
						g2.drawPolygon(pPointsX, pPointsY, pointsCounter);
					}
				} else {
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, image.getTransparency());
					g2.setComposite(ac);
					g2.drawImage(image.getImage().getImage(), 0, 0, getMaximumSize().width - 2,
							getMaximumSize().height - 2, null);
				}
			}
		};

		private boolean visible = true;

		private java.awt.Polygon polygon;
		public Image image;

		public float scalingFactorX = 1;
		public float scalingFactorY = 1;
		private Colour colour;
		public Colour strokeColour;
		public int strokeWidth = 0;
		public boolean stroke;
		public boolean rounded = false;

		private List<Integer> original_xPoints = new ArrayList<Integer>();
		private List<Integer> original_yPoints = new ArrayList<Integer>();
		private int pointsCounter = 0;

		private double angle;
		private int xPoints[];
		private int yPoints[];

		private int pPointsX[];
		private int pPointsY[];

		private int pWidth;
		private int pHeight;

		// CONSTRUCTOS

		public Polygon(int[] xPoints, int[] yPoints, int points) {
			this.autoScalable = false;
			polygon = new java.awt.Polygon();

			if (points > xPoints.length || points > yPoints.length)
				return;

			for (int i = 0; i < points; i++) {
				this.addPoint(xPoints[i], yPoints[i]);
			}

			this.colour = new Colour(0, 0, 0, 255);

			label.setBackground(new Color(0, 0, 0, 0));
			label.setMinimumSize(new Dimension(polygon.getBounds().width, polygon.getBounds().height));
			label.setPreferredSize(new Dimension(polygon.getBounds().width, polygon.getBounds().height));
			label.setMaximumSize(new Dimension(polygon.getBounds().width, polygon.getBounds().height));
			label.setOpaque(false);
			label.setEnabled(false);

			label.repaint();
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return label;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void adaptSize(int width, int height) {
			float scalingFactorX = (float) width / pWidth;
			float scalingFactorY = (float) height / pHeight;

			setScale(scalingFactorX, scalingFactorY);
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
			label.repaint();
		}

		// PUBLICS

		public void setScale(float scalingFactorX, float scalingFactorY) {
			this.scalingFactorX = scalingFactorX;
			this.scalingFactorY = scalingFactorY;

			this.pWidth = (int) ((this.pWidth) * scalingFactorX);
			this.pHeight = (int) ((this.pHeight) * scalingFactorY);

			label.setMinimumSize(new Dimension(pWidth, pHeight));
			label.setPreferredSize(new Dimension(pWidth, pHeight));
			label.setMaximumSize(new Dimension(pWidth, pHeight));

			label.setBounds(this.getX(), this.getY(), pWidth, pHeight);

			label.repaint();
		}

		// TASKS

		public void handleMouseTask(MouseTask mouseTask) {
			label.addMouseListener(mouseTask);
			label.addMouseMotionListener(mouseTask);
		}

		// SETTER

		public void setStroke(Colour colour, int thickness, boolean rounded) {
			this.rounded = rounded;

			if (scalingFactorX == 1 && scalingFactorY == 1) {
				this.pWidth = (int) ((polygon.getBounds().width + thickness * 2));
				this.pHeight = (int) ((polygon.getBounds().height + thickness * 2));

				label.setMinimumSize(new Dimension(pWidth, pHeight));
				label.setPreferredSize(new Dimension(pWidth, pHeight));
				label.setMaximumSize(new Dimension(pWidth, pHeight));

				label.setBounds(this.getX(), this.getY(), pWidth, pHeight);

				for (int i = 0; i < pointsCounter; i++) {
					polygon.xpoints[i] = polygon.xpoints[i] + thickness + 1;
					polygon.ypoints[i] = polygon.ypoints[i] + thickness - 2;
					pPointsX[i] = pPointsX[i] + thickness + 1;
					pPointsY[i] = pPointsY[i] + thickness - 2;

				}

				this.stroke = true;
				this.strokeColour = colour;
				this.strokeWidth = thickness;
				label.repaint();
			} else {
				for (int i = 0; i < pointsCounter; i++) {
					polygon.xpoints[i] = polygon.xpoints[i] + thickness + 1;
					polygon.ypoints[i] = polygon.ypoints[i] + thickness - 2;
					pPointsX[i] = pPointsX[i] + thickness + 1;
					pPointsY[i] = pPointsY[i] + thickness - 2;
				}

				float scalingFactorX = (float) (this.getWidth() + thickness * 2) / pWidth;
				float scalingFactorY = (float) (this.getHeight() + thickness * 2) / pHeight;

				this.scalingFactorX -= scalingFactorX;
				this.scalingFactorY -= scalingFactorY;

				this.stroke = true;
				this.strokeColour = colour;
				this.strokeWidth = thickness;
				label.repaint();
			}
		}

		public void setColour(Colour colour) {
			this.colour = colour;
			label.repaint();
		}

		public void setSize(int width, int height) {
			adaptSize(width, height);
		}

		public void setToolTip(String text) {
			this.label.setToolTipText(text);
		}

		public void setPosition(int x, int y) {
			label.setLocation(x, y);
			label.repaint();
		}

		public void setImage(Image image) {
			this.image = (Image) image;
			label.repaint();
		}

		// ADD

		public void addPoint(int x, int y) {
			original_xPoints.add(x);
			original_yPoints.add(y);
			pointsCounter++;

			int minWidth = Integer.MAX_VALUE;
			int minHeight = Integer.MAX_VALUE;
			int maxWidth = Integer.MIN_VALUE;
			int maxHeight = Integer.MIN_VALUE;

			for (int i = 0; i < pointsCounter; i++) {
				if (original_xPoints.get(i) < minWidth) {
					minWidth = original_xPoints.get(i);
				}
				if (original_xPoints.get(i) > maxWidth) {
					maxWidth = original_xPoints.get(i);
				}

				if (original_yPoints.get(i) < minHeight) {
					minHeight = original_yPoints.get(i);
				}
				if (original_yPoints.get(i) > maxHeight) {
					maxHeight = original_yPoints.get(i);
				}
			}

			this.pWidth = maxWidth - minWidth; // So breit muss die BoundingBox sein
			this.pHeight = maxHeight - minHeight; // So hoch muss die BoundingBox sein

			int xNew = 0;
			int yNew = 0;

			pPointsX = new int[pointsCounter];
			pPointsY = new int[pointsCounter];

			polygon.reset();
			for (int i = 0; i < pointsCounter; i++) {
				xNew = original_xPoints.get(i) - minWidth;
				yNew = original_yPoints.get(i) - minHeight;
				polygon.addPoint(xNew, yNew);
				pPointsX[i] = xNew;
				pPointsY[i] = yNew;

			}

			angle = 2 * Math.PI / pointsCounter;
			xPoints = new int[pointsCounter];
			yPoints = new int[pointsCounter];

			label.setMinimumSize(new Dimension(pWidth, pHeight));
			label.setPreferredSize(new Dimension(pWidth, pHeight));
			label.setMaximumSize(new Dimension(pWidth, pHeight));

			label.repaint();
		}

		// SHOW

		public void showBoundingBox(boolean show) {
			if (show)
				label.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0, 255)));
			else
				label.setBorder(null);
		}

		// REQUESTS

		public boolean contains(int x, int y) {
			return polygon.contains(x, y);
		}

		public boolean hasStroke() {
			return stroke;
		}

		// GETTER

		public int[] getXPoints() {
			int[] points = new int[pointsCounter];

			for (int i = 0; i < pointsCounter; i++) {
				points[i] = (int) original_xPoints.get(i);
			}

			return points;
		}

		public int[] getYPoints() {
			int[] points = new int[pointsCounter];

			for (int i = 0; i < pointsCounter; i++) {
				points[i] = (int) original_yPoints.get(i);
			}

			return points;
		}

		public int getPoints() {
			return pointsCounter;
		}

		public Colour getColour() {
			return colour;
		}

		public int getWidth() {
			return pWidth;
		}

		public int getHeight() {
			return pHeight;
		}

		public int getX() {
			return label.getLocation().x;
		}

		public int getY() {
			return label.getLocation().y;
		}

		public Image getImage() {
			return image;
		}
	}

	public static class Ellipse extends Shape {
		private JLabel label = new JLabel() {

			public boolean contains(int x, int y) {
				if (shape == null || !shape.getBounds().equals(getBounds())) {
					shape = new Ellipse2D.Float(0, 0, getMaximumSize().width - 2, getMaximumSize().height - 2);
				}
				return shape.contains(x, y);
			}

			public void paintComponent(Graphics g) {
				if (!visible)
					return;

				Graphics2D g2 = (Graphics2D) g.create();

				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (image == null) {
					if (stroke) {
						g2.setColor(new Color(strokeColour.r, strokeColour.g, strokeColour.b, strokeColour.a));
						Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, getMaximumSize().width,
								getMaximumSize().height);
						g2.fill(circle);

						g2.setColor(new Color(colour.r, colour.g, colour.b, colour.a));
						circle = new Ellipse2D.Double(strokeWidth, strokeWidth,
								getMaximumSize().width - (2 * strokeWidth),
								getMaximumSize().height - (2 * strokeWidth));
						g2.fill(circle);
					} else {
						g2.setColor(new Color(colour.r, colour.g, colour.b, colour.a));
						Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, getMaximumSize().width,
								getMaximumSize().height);
						g2.fill(circle);
					}
				} else {
					if (stroke) {
						g2.setColor(new Color(strokeColour.r, strokeColour.g, strokeColour.b, strokeColour.a));
						Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, getMaximumSize().width,
								getMaximumSize().height);
						g2.fill(circle);

						AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
								image.getTransparency());
						g2.setComposite(ac);
						g2.drawImage(image.getImage().getImage(), strokeWidth, strokeWidth,
								getMaximumSize().width - (2 * strokeWidth), getMaximumSize().height - (2 * strokeWidth),
								null);
					} else {
						AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
								image.getTransparency());
						g2.setComposite(ac);
						g2.drawImage(image.getImage().getImage(), 0, 0, getMaximumSize().width, getMaximumSize().height,
								null);
					}
				}
			}
		};

		private boolean visible = true;

		private java.awt.Shape shape;

		private int width;
		private int height;
		public int strokeWidth = 1;
		public boolean stroke;
		public Colour strokeColour;
		public Colour colour;
		public Image image;

		// CONSTRUCTORS

		public Ellipse(int width, int height) {
			this.autoScalable = false;

			this.width = width;
			this.height = height;
			this.colour = new Colour(0, 0, 0, 255);

			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));
			label.setOpaque(false);
			label.setEnabled(false);

			label.repaint();
		}

		public Ellipse(int width, int height, Colour colour) {
			this.autoScalable = false;

			this.width = width;
			this.height = height;
			this.colour = colour;

			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));
			label.setOpaque(false);
			label.setEnabled(false);

			label.repaint();
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return label;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void adaptSize(int width, int height) {
			if (this.width == this.height) {
				int minValue = Math.min(width, height);
				this.width = minValue;
				this.height = minValue;

				label.setMinimumSize(new Dimension(width, height));
				label.setPreferredSize(new Dimension(width, height));
				label.setMaximumSize(new Dimension(width, height));
			} else {
				this.width = width;
				this.height = height;

				label.setMinimumSize(new Dimension(width, height));
				label.setPreferredSize(new Dimension(width, height));
				label.setMaximumSize(new Dimension(width, height));
			}
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
			label.repaint();
		}

		// TASKS

		public void handleMouseTask(MouseTask mouseTask) {
			label.addMouseListener(mouseTask);
			label.addMouseMotionListener(mouseTask);
		}

		// SETTER

		public void setColour(Colour colour) {
			this.colour = colour;
			label.repaint();
		}

		public void setStroke(Colour colour, int thickness) {
			this.stroke = true;
			this.strokeColour = colour;
			this.strokeWidth = thickness;
			label.repaint();
		}

		public void setImage(Image image) {
			this.image = (Image) image;
			label.repaint();
		}

		public void setToolTip(String text) {
			this.label.setToolTipText(text);
		}

		public void setSize(int width, int height) {
			this.width = width;
			this.height = height;

			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));

			label.setBounds(this.getX(), this.getY(), width, height);

			label.repaint();
		}

		public void setPosition(int x, int y) {
			label.setLocation(x, y);
			label.repaint();
		}

		// REQUESTS

		public boolean hasStroke() {
			return stroke;
		}

		// GETTER

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public Colour getColour() {
			return colour;
		}

		public int getX() {
			return label.getX();
		}

		public int getY() {
			return label.getY();
		}

		public Image getImage() {
			return image;
		}
	}

	public static class Rectangle extends Shape {
		private JLabel label = new JLabel() {

			public void paintComponent(Graphics g) {
				if (!visible)
					return;

				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				g2.setColor(new Color(colour.r, colour.g, colour.b, colour.a));

				if (image == null) {
					if (!stroke)
						g2.fillRoundRect(0, 0, (int) (getMaximumSize().width), (int) (getMaximumSize().height),
								roundValue, roundValue);
					else {
						g2.setColor(new Color(strokeColour.r, strokeColour.g, strokeColour.b, strokeColour.a));
						g2.fillRoundRect(0, 0, (int) (getMaximumSize().width), (int) (getMaximumSize().height),
								roundValue, roundValue);

						g2.setColor(new Color(colour.r, colour.g, colour.b, colour.a));
						g2.fillRoundRect(strokeWidth, strokeWidth, (int) (getMaximumSize().width) - (2 * strokeWidth),
								(int) (getMaximumSize().height) - (2 * strokeWidth), roundValue, roundValue);
					}
				} else {
					if (!stroke) {
						AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
								image.getTransparency());
						g2.setComposite(ac);
						g2.drawImage(image.getImage().getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
					} else {
						g2.setColor(new Color(strokeColour.r, strokeColour.g, strokeColour.b, strokeColour.a));
						g2.fillRoundRect(0, 0, (int) (getMaximumSize().width), (int) (getMaximumSize().height), 0, 0);

						AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
								image.getTransparency());
						g2.setComposite(ac);
						g2.drawImage(image.getImage().getImage(), strokeWidth, strokeWidth,
								(int) (getMaximumSize().width) - (2 * strokeWidth),
								(int) (getMaximumSize().height) - (2 * strokeWidth), null);
					}
				}
			}
		};

		private boolean visible = true;

		private int strokeWidth = 1;
		private boolean stroke;
		private Colour strokeColour;

		private int width;
		private int height;
		private Colour colour;
		private int roundValue = 0;
		private Image image;

		// CONSTRUCTORS

		public Rectangle(int width, int height) {
			this.autoScalable = false;

			this.width = width;
			this.height = height;
			this.colour = new Colour(0, 0, 0, 255);

			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));
			label.setOpaque(false);
			label.setEnabled(false);

			label.repaint();
		}

		public Rectangle(int width, int height, Colour colour) {
			this.autoScalable = false;

			this.width = width;
			this.height = height;
			this.colour = colour;

			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));
			label.setOpaque(false);
			label.setEnabled(false);

			label.repaint();
		}

		// INHERITED METHODS

		public JComponent getComponent() {
			return label;
		}

		public void adaptSize(int width, int height) {
			this.width = width;
			this.height = height;

			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));

			label.repaint();
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public Component getParent() {
			return parent;
		}

		// INHERITED METHODS (Visible)

		public void setParent(Component component) {
			this.parent = component;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
			label.repaint();
		}

		// TASKS

		public void handleMouseTask(MouseTask mouseTask) {
			label.addMouseListener(mouseTask);
			label.addMouseMotionListener(mouseTask);
		}

		// SETTER

		public void setStroke(Colour colour, int thickness) {
			this.stroke = true;
			this.strokeColour = colour;
			this.strokeWidth = thickness;
			label.repaint();
		}

		public void setRoundCorners(int value) {
			this.roundValue = value;
			label.repaint();
		}

		public void setColour(Colour colour) {
			this.colour = colour;
			label.repaint();
		}

		public void setToolTip(String text) {
			this.label.setToolTipText(text);
		}

		public void setImage(Image image) {
			this.image = (Image) image;
			label.repaint();
		}

		public void setPosition(int x, int y) {
			label.setLocation(x, y);
			label.repaint();
		}

		public void setSize(int width, int height) {
			this.width = width;
			this.height = height;

			label.setMinimumSize(new Dimension(width, height));
			label.setPreferredSize(new Dimension(width, height));
			label.setMaximumSize(new Dimension(width, height));

			label.setBounds(this.getX(), this.getY(), width, height);

			label.repaint();
		}

		// REQUESTS

		public boolean hasStroke() {
			return stroke;
		}

		// GETTER

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public Colour getColour() {
			return colour;
		}

		public int getX() {
			return label.getX();
		}

		public int getY() {
			return label.getY();
		}

		public Image getImage() {
			return image;
		}
	}
}
