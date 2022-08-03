package mule.guifactory;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mule.guifactory.GUIFactory.Alignment;
import mule.guifactory.GUIFactory.Colour;
import mule.guifactory.GUIFactoryComponents.Component;
import mule.guifactory.GUIFactory.Window;
import mule.guifactory.GUIFactoryBorders.Border;
import mule.guifactory.GUIFactoryComponents.Ellipse;
import mule.guifactory.GUIFactoryComponents.Image;
import mule.guifactory.GUIFactoryComponents.Polygon;
import mule.guifactory.GUIFactoryComponents.Rectangle;
import mule.guifactory.GUIFactoryComponents.Shape;
import mule.util.MuLEReferenceType;

public class GUIFactoryPanes {
	// PANES

	public static MuLEReferenceType<HorizontalPane> createHorizontalPane(Alignment alignment, int spacing) {
		return new MuLEReferenceType<HorizontalPane>(new HorizontalPane(alignment, spacing));
	}

	public static HorizontalPane createHorizontalPane(Alignment alignment, Component... components) {
		return new HorizontalPane(alignment, components);
	}

	public static HorizontalPane createHorizontalPane(Alignment alignment, int spacing, Component... components) {
		return new HorizontalPane(alignment, spacing, components);
	}

	public static MuLEReferenceType<BorderPane> createBorderPane(int hgap, int vgap) {
		return new MuLEReferenceType<BorderPane>(new BorderPane(hgap, vgap));
	}

	public static MuLEReferenceType<EmptyPane> createEmptyPane() {
		return new MuLEReferenceType<>(new EmptyPane());
	}

	public static EmptyPane createEmptyPane(Component component) {
		return new EmptyPane(component);
	}

	public static EmptyPane createEmptyPane(Component... components) {
		return new EmptyPane(components);
	}

	public static MuLEReferenceType<GridPane> createGridPane(int columnSpace, int rowSpace) {
		return new MuLEReferenceType<GridPane>(new GridPane(columnSpace, rowSpace));
	}

	public static MuLEReferenceType<VerticalPane> createVerticalPane(Alignment alignment, int spacing) {
		return new MuLEReferenceType<VerticalPane>(new VerticalPane(alignment, spacing));
	}

	public static VerticalPane createVerticalPane(Alignment alignment, int spacing, Component... components) {
		return new VerticalPane(alignment, spacing, components);
	}

	public static VerticalPane createVerticalPane(Alignment alignment, Component... components) {
		return new VerticalPane(alignment, components);
	}
	
	// PANES
	public static abstract class Pane extends Component {

		protected Image image;
		protected boolean visible = true;
		protected Window window;

		protected final JPanel panel = new JPanel() {

			protected void paintComponent(Graphics g) {
				if (!visible)
					return;

				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setRenderingHints(antialiasing);

				if (image != null) {
					this.setBackground(new Color(0, 0, 0, 0));
					AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, image.getTransparency());
					g2.setComposite(ac);

					g.drawImage(image.getImage().getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				}
			}
		};

		protected void updatePane() {
			Window w = findWindow(this);
			if (w != null) {
				w.showWindow();
			}
		}
		
		public abstract void setBorder(MuLEReferenceType<? extends Border> border);

		public void setWindow(Window window) {
			this.window = window;
			this.parent = null;
		}

		public JPanel getPanel() {
			return panel;
		}

		private Window findWindow(Pane pane) {
			if (pane.parent == null && pane.window == null)
				return null;
			else if (pane.parent == null && pane.window != null)
				return pane.window;
			else if (pane.parent != null && pane.window == null) {
				if (pane.parent instanceof Pane)
					return findWindow((Pane) pane.parent);
				else
					return null;
			} else
				return pane.window;
		}
	}

	public static class BorderPane extends Pane {
		private List<Component> componentList = new ArrayList<Component>();
		private Component top;
		private Component left;
		private Component center;
		private Component right;
		private Component bottom;

		// CONSTRUCTORS

		public BorderPane(int hgap, int vgap) {
			this.autoScalable = true;
			panel.setLayout(new BorderLayout(hgap, vgap));
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return panel;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void setParent(Component component) {
			this.parent = component;
		}

		public List<Component> getComponents() {
			List<Component> componentList = new ArrayList<Component>();

			if (top != null)
				componentList.add(top);
			if (left != null)
				componentList.add(left);
			if (center != null)
				componentList.add(center);
			if (right != null)
				componentList.add(right);
			if (bottom != null)
				componentList.add(bottom);

			return componentList;
		}

		// INHERITED METHODS (Visible)

		public void setVisible(boolean visible) {
			this.visible = visible;

			if (top != null)
				top.setVisible(visible);
			if (left != null)
				left.setVisible(visible);
			if (center != null)
				center.setVisible(visible);
			if (right != null)
				right.setVisible(visible);
			if (bottom != null)
				bottom.setVisible(visible);

			panel.repaint();
		}

		public void hideComponents(boolean hide) {
			if (top != null)
				top.setVisible(!hide);
			if (left != null)
				left.setVisible(!hide);
			if (center != null)
				center.setVisible(!hide);
			if (right != null)
				right.setVisible(!hide);
			if (bottom != null)
				bottom.setVisible(!hide);
		}

		public Component getParent() {
			return parent;
		}

		// SETTER

		public void setBackground(Colour colour) {
			this.panel.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setBackground(Image image) {
			this.image = (Image) image;
			this.panel.repaint();
		}

		public void setBorder(MuLEReferenceType<? extends Border> border) {
			javax.swing.border.Border b = panel.getBorder();
			Border aB = (Border) border.value;

			if (b == null)
				this.panel.setBorder(aB.getBorder());
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(aB.getBorder(), b));
		}

		public void setPadding(int top, int left, int bottom, int right) {
			javax.swing.border.Border b = panel.getBorder();
			if (b == null)
				this.panel.setBorder(new EmptyBorder(top, left, bottom, right));
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(top, left, bottom, right), b));
		}

		public void setTop(MuLEReferenceType<? extends Component> component) {
			if (top != null) {
				Component aTop = (Component) top;
				aTop.setParent(null);
			}
			top = component.value;

			Component aC = (Component) component.value;
			aC.setParent(this);
			panel.add(aC.getComponent(), BorderLayout.NORTH);

			updatePane();
		}

		public void setLeft(MuLEReferenceType<? extends Component> component) {
			if (left != null) {
				Component aLeft = (Component) left;
				aLeft.setParent(null);
			}
			left = component.value;

			Component aC = (Component) component.value;
			aC.setParent(this);
			panel.add(aC.getComponent(), BorderLayout.WEST);

			updatePane();
		}

		public void setCenter(MuLEReferenceType<? extends Component> component) {
			if (center != null) {
				Component aCenter = (Component) center;
				aCenter.setParent(null);
			}
			center = component.value;

			Component aC = (Component) component.value;
			aC.setParent(this);
			panel.add(aC.getComponent(), BorderLayout.CENTER);

			updatePane();
		}

		public void setRight(MuLEReferenceType<? extends Component> component) {
			if (right != null) {
				Component aRight = (Component) right;
				aRight.setParent(null);
			}
			right = component.value;

			Component aC = (Component) component.value;
			aC.setParent(this);
			panel.add(aC.getComponent(), BorderLayout.EAST);

			updatePane();
		}

		public void setBottom(MuLEReferenceType<? extends Component> component) {
			if (bottom != null) {
				Component aBottom = (Component) bottom;
				aBottom.setParent(null);
			}
			bottom = component.value;

			Component aC = (Component) component.value;
			aC.setParent(this);
			panel.add(aC.getComponent(), BorderLayout.SOUTH);

			updatePane();
		}
	}

	public static class EmptyPane extends Pane {
		private List<Component> componentList = new ArrayList<Component>();

		// CONSTRUCTORS

		public EmptyPane() {
			this.autoScalable = true;
			panel.setLayout(null);
		}

		public EmptyPane(Component component) {
			this.autoScalable = true;
			panel.setLayout(null);
			Component aC = (Component) component;
			aC.setParent(this);
			aC.getComponent().setBounds(aC.getComponent().getX(), aC.getComponent().getY(),
					aC.getComponent().getPreferredSize().width, aC.getComponent().getPreferredSize().height);
			panel.add(aC.getComponent());
			componentList.add(component);

			updatePane();
		}

		public EmptyPane(Component... components) {
			this.autoScalable = true;
			panel.setLayout(null);
			for (Component c : components) {
				Component aC = (Component) c;
				aC.setParent(this);
				aC.getComponent().setBounds(aC.getComponent().getX(), aC.getComponent().getY(),
						aC.getComponent().getPreferredSize().width, aC.getComponent().getPreferredSize().height);
				panel.add(aC.getComponent());
				componentList.add(c);
			}

			updatePane();
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return panel;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void setParent(Component component) {
			this.parent = component;
		}

		public List<Component> getComponents() {
			return componentList;
		}

		// INHERITED METHODS (Visible)

		public void setVisible(boolean visible) {
			this.visible = visible;

			for (Component c : componentList) {
				c.setVisible(visible);
			}

			panel.repaint();
		}

		public void hideComponents(boolean hide) {
			for (Component c : componentList) {
				c.setVisible(!hide);
			}
		}

		public Component getParent() {
			return parent;
		}

		// SETTER

		public void setBackground(Colour colour) {
			this.panel.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setBackground(Image image) {
			this.image = (Image) image;
			this.panel.repaint();
		}

		public void setBorder(MuLEReferenceType<? extends Border> border) {
			javax.swing.border.Border b = panel.getBorder();
			Border aB = (Border) border.value;

			if (b == null)
				this.panel.setBorder(aB.getBorder());
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(aB.getBorder(), b));
		}

		public void setPadding(int top, int left, int bottom, int right) {
			javax.swing.border.Border b = panel.getBorder();
			if (b == null)
				this.panel.setBorder(new EmptyBorder(top, left, bottom, right));
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(top, left, bottom, right), b));
		}

		// ADD

		public void addComponent(Component component) {
			Component aC = (Component) component;
			aC.setParent(this);
			aC.getComponent().setBounds(aC.getComponent().getX(), aC.getComponent().getY(),
					aC.getComponent().getPreferredSize().width, aC.getComponent().getPreferredSize().height);
			panel.add(aC.getComponent());

			updatePane();
		}

		public void addComponents(Component... components) {
			for (Component c : components) {
				Component aC = (Component) c;
				aC.setParent(this);
				aC.getComponent().setBounds(aC.getComponent().getX(), aC.getComponent().getY(),
						aC.getComponent().getPreferredSize().width, aC.getComponent().getPreferredSize().height);
				panel.add(aC.getComponent());
				componentList.add(c);
			}

			updatePane();
		}

		// REMOVE

		public void remove(Component component) {
			Component aC = (Component) component;
			aC.setParent(null);
			panel.remove(aC.getComponent());
			componentList.remove(component);
			panel.repaint();

			updatePane();
		}

		public void removeAll() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.setParent(null);
			}
			panel.removeAll();
			componentList.clear();
			panel.repaint();

			updatePane();
		}
	}

	public static class GridPane extends Pane {
		private List<GridBagConstraints> constraintsList = new ArrayList<GridBagConstraints>();
		private List<Component> componentList = new ArrayList<Component>();

		private int columnSpace = -1;
		private int rowSpace = -1;

		private int width = -1;
		private int height = -1;

		// CONSTRUCTORS
		public GridPane() {
		}

		public GridPane(int columnSpace, int rowSpace) {
			this.autoScalable = true;
			panel.setLayout(new GridBagLayout());
			setSpacing(columnSpace, rowSpace);
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return panel;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void setParent(Component component) {
			this.parent = component;
		}

		// INHERITED METHODS (Visible)

		public void setVisible(boolean visible) {
			this.visible = visible;

			for (Component aC : componentList) {
				Component c = (Component) aC;
				c.setVisible(visible);
			}

			panel.repaint();
		}

		public void hideComponents(boolean hide) {
			for (Component aC : componentList) {
				Component c = (Component) aC;
				c.setVisible(!hide);
			}
		}

		public Component getParent() {
			return parent;
		}

		public List<Component> getComponents() {
			List<Component> returnList = new ArrayList<Component>();

			for (Component aC : componentList) {
				Component c = (Component) aC;
				returnList.add(c);
			}

			return returnList;
		}

		// SETTER

		public void setBackground(Colour colour) {
			this.panel.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setBackground(Image image) {
			this.image = (Image) image;
			this.panel.repaint();
		}

		public void setBorder(MuLEReferenceType<? extends Border> border) {
			javax.swing.border.Border b = panel.getBorder();
			Border aB = (Border) border.value;

			if (b == null)
				this.panel.setBorder(aB.getBorder());
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(aB.getBorder(), b));
		}

		public void setPadding(int top, int left, int bottom, int right) {
			javax.swing.border.Border b = panel.getBorder();
			if (b == null)
				this.panel.setBorder(new EmptyBorder(top, left, bottom, right));
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(top, left, bottom, right), b));
		}

		public void setSpacing(int columnSpace, int rowSpace) {
			panel.removeAll();
			this.columnSpace = columnSpace;
			this.rowSpace = rowSpace;

			int index = 0;
			for (GridBagConstraints constraint : constraintsList) {
				constraint.insets = new Insets(rowSpace, columnSpace, rowSpace, columnSpace);
				panel.add(componentList.get(index).getComponent(), constraint);
				index++;
			}
		}

		public void setPaddingInsideCell(int columnIndex, int rowIndex, int top, int left, int bottom, int right) {
			for (GridBagConstraints c : constraintsList) {
				if (c.gridx == columnIndex && c.gridy == rowIndex) {
					if (rowSpace == -1 && columnSpace == -1)
						c.insets = new Insets(top, left, bottom, right);
					else
						c.insets = new Insets(rowSpace + top, columnSpace + left, rowSpace + bottom,
								columnSpace + right);

					repaint();
					return;
				}
			}
		}

		public void setColumnWeight(int columnIndex, int weight) {
			for (GridBagConstraints c : constraintsList) {
				if (c.gridx == columnIndex) {
					c.weightx = weight / 100.f;
					repaint();
				}
			}
		}

		public void setRowWeight(int rowIndex, int weight) {
			for (GridBagConstraints c : constraintsList) {
				if (c.gridy == rowIndex) {
					c.weighty = weight / 100.f;
					repaint();
				}
			}
		}

		public void setCellSizes(int width, int height) {
			this.width = width;
			this.height = height;

			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC instanceof Shape) {
					((Shape) aC).setSize(width, height);
				} else {
					aC.getComponent().setMinimumSize(new Dimension(width, height));
					aC.getComponent().setPreferredSize(new Dimension(width, height));
					aC.getComponent().setMaximumSize(new Dimension(width, height));
				}
			}
			repaint();
		}

		// ADD

		public void addComponent(MuLEReferenceType<? extends Component> component, int column, int row) {
			GridBagConstraints gbc = setConstraints(column, row, 1, 1, 1);

			Component aC = (Component) component.value;
			if (aC instanceof Shape) {
				if (aC instanceof Rectangle) {
					Rectangle r = (Rectangle) aC;
					if (width == -1 && height == -1)
						r.adaptSize(r.getWidth(), r.getHeight());
					else
						r.adaptSize(width, height);
				} else if (aC instanceof Ellipse) {
					Ellipse e = (Ellipse) aC;
					if (width == -1 && height == -1)
						e.adaptSize(e.getWidth(), e.getHeight());
					else
						e.adaptSize(width, height);
				} else if (aC instanceof Polygon) {
					Polygon p = (Polygon) aC;
					if (width == -1 && height == -1)
						p.adaptSize(p.getWidth(), p.getHeight());
					else
						p.adaptSize(width, height);
				}
			} else {
				if (width != -1 && height != -1) {
					aC.getComponent().setMinimumSize(new Dimension(width, height));
					aC.getComponent().setPreferredSize(new Dimension(width, height));
					aC.getComponent().setMaximumSize(new Dimension(width, height));
				}
			}

			aC.setParent(this);
			panel.add(aC.getComponent(), gbc);
			componentList.add(aC);
			constraintsList.add(gbc);
			panel.repaint();

			updatePane();
		}

		public void addComponent(MuLEReferenceType<? extends Component> component, int column, int row, int columnSpan, int rowSpan) {
			GridBagConstraints gbc;
			if (columnSpan > 1 && rowSpan > 1)
				gbc = setConstraints(column, row, columnSpan, rowSpan, 1);
			else if (columnSpan > 1 && rowSpan <= 1)
				gbc = setConstraints(column, row, columnSpan, rowSpan, 2);
			else if (columnSpan <= 1 && rowSpan > 1)
				gbc = setConstraints(column, row, columnSpan, rowSpan, 3);
			else
				gbc = setConstraints(column, row, columnSpan, rowSpan, 0);

			Component aC = (Component) component.value;
			if (aC instanceof Shape) {
				if (aC instanceof Rectangle) {
					Rectangle r = (Rectangle) aC;
					if (columnSpan > 1 && rowSpan > 1) {
						if (width == -1 && height == -1)
							r.adaptSize(r.getWidth() * columnSpan + (columnSpan * columnSpace),
									r.getHeight() * rowSpan + (rowSpan * rowSpace) + rowSpace);
						else
							r.adaptSize(width * columnSpan + (columnSpan * columnSpace),
									height * rowSpan + (rowSpan * rowSpace) + rowSpace);
					} else if (columnSpan > 1 && rowSpan <= 1) {
						if (width == -1 && height == -1)
							r.adaptSize(r.getWidth() * columnSpan + (columnSpan * columnSpace),
									r.getHeight() * rowSpan);
						else
							r.adaptSize(width * columnSpan + (columnSpan * columnSpace), height * rowSpan);
					} else if (columnSpan <= 1 && rowSpan > 1) {
						if (width == -1 && height == -1)
							r.adaptSize(r.getWidth() * columnSpan,
									r.getHeight() * rowSpan + (rowSpan * rowSpace) + rowSpace);
						else
							r.adaptSize(width * columnSpan, height * rowSpan + (rowSpan * rowSpace) + rowSpace);
					} else {
						if (width == -1 && height == -1)
							r.adaptSize(r.getWidth() * columnSpan, r.getHeight() * rowSpan);
						else
							r.adaptSize(width * columnSpan, height * rowSpan);
					}
				} else if (aC instanceof Ellipse) {
					Ellipse e = (Ellipse) aC;
					if (columnSpan > 1 && rowSpan > 1) {
						if (width == -1 && height == -1)
							e.adaptSize(e.getWidth() * columnSpan + (columnSpan * columnSpace),
									e.getHeight() * rowSpan + (rowSpan * rowSpace) + rowSpace);
						else
							e.adaptSize(width * columnSpan + (columnSpan * columnSpace),
									height * rowSpan + (rowSpan * rowSpace) + rowSpace);
					} else if (columnSpan > 1 && rowSpan <= 1) {
						if (width == -1 && height == -1)
							e.adaptSize(e.getWidth() * columnSpan + (columnSpan * columnSpace),
									e.getHeight() * rowSpan);
						else
							e.adaptSize(width * columnSpan + (columnSpan * columnSpace), height * rowSpan);
					} else if (columnSpan <= 1 && rowSpan > 1) {
						if (width == -1 && height == -1)
							e.adaptSize(e.getWidth() * columnSpan,
									e.getHeight() * rowSpan + (rowSpan * rowSpace) + rowSpace);
						else
							e.adaptSize(width * columnSpan, height * rowSpan + (rowSpan * rowSpace) + rowSpace);
					} else {
						if (width == -1 && height == -1)
							e.adaptSize(e.getWidth() * columnSpan, e.getHeight() * rowSpan);
						else
							e.adaptSize(width * columnSpan, height * rowSpan);
					}
				} else if (aC instanceof Polygon) {
					Polygon p = (Polygon) aC;

					if (columnSpan > 1 && rowSpan > 1) {
						if (width == -1 && height == -1)
							p.adaptSize(p.getWidth() * columnSpan + (columnSpan * columnSpace),
									p.getHeight() * rowSpan + (rowSpan * rowSpace) + rowSpace);
						else
							p.adaptSize(width * columnSpan + (columnSpan * columnSpace),
									height * rowSpan + (rowSpan * rowSpace) + rowSpace);
					} else if (columnSpan > 1 && rowSpan <= 1) {
						if (width == -1 && height == -1)
							p.adaptSize(p.getWidth() * columnSpan + (columnSpan * columnSpace),
									p.getHeight() * rowSpan);
						else
							p.adaptSize(width * columnSpan + (columnSpan * columnSpace), height * rowSpan);
					} else if (columnSpan <= 1 && rowSpan > 1) {
						if (width == -1 && height == -1)
							p.adaptSize(p.getWidth() * columnSpan,
									p.getHeight() * rowSpan + (rowSpan * rowSpace) + rowSpace);
						else
							p.adaptSize(width * columnSpan, height * rowSpan + (rowSpan * rowSpace) + rowSpace);
					} else {
						if (width == -1 && height == -1)
							p.adaptSize(p.getWidth() * columnSpan, p.getHeight() * rowSpan);
						else
							p.adaptSize(width * columnSpan, height * rowSpan);
					}
				}
			} else {
				if (width != -1 && height != -1) {
					aC.getComponent().setMinimumSize(new Dimension(width, height));
					aC.getComponent().setPreferredSize(new Dimension(width, height));
					aC.getComponent().setMaximumSize(new Dimension(width, height));
				}
			}

			aC.setParent(this);
			panel.add(aC.getComponent(), gbc);
			componentList.add(aC);
			constraintsList.add(gbc);
			panel.repaint();

			updatePane();
		}

		// REMOVE

		public void removeComponent(Component component) {
			Component aC = (Component) component;
			aC.setParent(null);

			int index = 0;
			for (Component c : componentList) {
				if (c == aC) {
					constraintsList.remove(index);
					componentList.remove(index);
					panel.repaint();
					repaint();

					updatePane();
					return;
				}
				index++;
			}
		}

		public void removeComponent(int columnIndex, int rowIndex) {
			int index = 0;
			for (GridBagConstraints c : constraintsList) {
				if (c.gridx == columnIndex && c.gridy == rowIndex) {
					Component aC = componentList.get(index);
					aC.setParent(null);
					constraintsList.remove(index);
					componentList.remove(index);
					panel.repaint();
					repaint();

					updatePane();
					return;
				}
				index++;
			}
		}

		public void removeAll() {
			for (Component c : componentList) {
				c.setParent(null);
			}

			constraintsList.clear();
			componentList.clear();
			panel.repaint();
			repaint();

			updatePane();
		}

		// SCALE

		public void autoScaleCellSizes() {
			int index = 0;
			for (Component c : componentList) {
				GridBagConstraints constraint = constraintsList.get(index);
				constraint.fill = GridBagConstraints.BOTH;
				if (constraint.weightx == 0 && constraint.weighty == 0) {
					constraint.weightx = 0.5f;
					constraint.weighty = 0.5f;
				} else if (constraint.weightx == 0 && constraint.weighty > 0) {
					constraint.weightx = 0.5f;
				} else if (constraint.weightx > 0 && constraint.weighty == 0) {
					constraint.weighty = 0.5f;
				}
				index++;
			}

			repaint();
		}

		public void autoScaleCellSizesHorizontally() {
			int index = 0;
			for (Component c : componentList) {
				GridBagConstraints constraint = constraintsList.get(index);
				if (constraint.weightx == 0 && constraint.weighty == 0) {
					constraint.fill = GridBagConstraints.HORIZONTAL;
					constraint.weightx = 0.5f;
					constraint.weighty = 0;
				} else if (constraint.weightx == 0 && constraint.weighty > 0) {
					constraint.fill = GridBagConstraints.BOTH;
					constraint.weightx = 0.5f;
				}
				index++;
			}

			repaint();
		}

		public void autoScaleCellSizesVertically() {
			int index = 0;
			for (Component c : componentList) {
				GridBagConstraints constraint = constraintsList.get(index);
				if (constraint.weightx == 0 && constraint.weighty == 0) {
					constraint.fill = GridBagConstraints.VERTICAL;
					constraint.weightx = 0;
					constraint.weighty = 0.5f;
				} else if (constraint.weightx > 0 && constraint.weighty == 0) {
					constraint.fill = GridBagConstraints.BOTH;
					constraint.weighty = 0.5f;
				}

				index++;
			}

			repaint();
		}

		// PRIVATES

		private GridBagConstraints setConstraints(int column, int row, int columnSpan, int rowSpan, int fillType) {
			GridBagConstraints gbc = new GridBagConstraints();

			gbc.fill = 1;
			gbc.ipady = 0; // default
			gbc.ipadx = 0; // default
			gbc.weightx = 0; // default
			gbc.weighty = 0; // default
			gbc.anchor = GridBagConstraints.CENTER;

			if (rowSpace == -1 && columnSpace == -1)
				gbc.insets = new Insets(0, 0, 0, 0);
			else
				gbc.insets = new Insets(rowSpace, columnSpace, rowSpace, columnSpace);

			gbc.gridx = column;
			gbc.gridy = row;
			gbc.gridwidth = columnSpan;
			gbc.gridheight = rowSpan;

			return gbc;
		}

		private void repaint() {
			panel.removeAll();

			int index = 0;
			for (Component c : componentList) {
				Component aC = (Component) c;
				panel.add(aC.getComponent(), constraintsList.get(index));
				index++;
			}
		}
	}

	public static class HorizontalPane extends Pane {

		private int spacing = 0;
		private Alignment alignment = Alignment.NONE; // Default

		private int width = -1; // Default
		private int height = -1; // Default

		private boolean scalingWidth = false;
		private boolean scalingHeight = false;

		private List<Component> componentList = new ArrayList<Component>();
		private List<Integer> dynamicSpace = new ArrayList<Integer>();

		// CONSTRUCTORS

		public HorizontalPane(Alignment alignment, int spacing) {
			this.autoScalable = true;
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			this.spacing = spacing;
			this.alignment = alignment;
		}

		public HorizontalPane(Alignment alignment, int spacing, Component... components) {
			this.autoScalable = true;
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			this.spacing = spacing;
			this.alignment = alignment;
			addComponents(components);
		}

		public HorizontalPane(Alignment alignment, Component... components) {
			this.autoScalable = true;
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			this.alignment = alignment;
			addComponents(components);
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return panel;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void setParent(Component component) {
			this.parent = component;
		}

		// INHERITED METHODS (Visible)

		public void setVisible(boolean visible) {
			this.visible = visible;

			for (Component c : componentList) {
				c.setVisible(visible);
			}

			panel.repaint();
		}

		public void hideComponents(boolean hide) {
			for (Component c : componentList) {
				c.setVisible(!hide);
			}
		}

		public List<Component> getComponents() {
			return componentList;
		}

		public Component getParent() {
			return parent;
		}

		// SETTER

		public void setBackground(Colour colour) {
			this.panel.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setBackground(Image image) {
			this.image = (Image) image;
			this.panel.repaint();
		}

		public void setBorder(MuLEReferenceType<? extends Border> border) {
			javax.swing.border.Border b = panel.getBorder();
			Border aB = (Border) border.value;

			if (b == null)
				this.panel.setBorder(aB.getBorder());
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(aB.getBorder(), b));
		}

		public void setPadding(int top, int left, int bottom, int right) {
			javax.swing.border.Border b = panel.getBorder();
			if (b == null)
				this.panel.setBorder(new EmptyBorder(top, left, bottom, right));
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(top, left, bottom, right), b));
		}

		public void setSpacing(int spacing) {
			this.spacing = spacing;
			setAlignment(alignment);
		}

		public void setComponentSizes(int width, int height) {
			for (Component c : componentList) {
				adjustSize(c, width, height);
			}

			this.width = width;
			this.height = height;

			if (!scalingWidth && !scalingHeight)
				return;
			else if (!scalingWidth && scalingHeight)
				scalingHeight = false;
			else if (scalingWidth && !scalingHeight)
				autoScaleComponentWidths();
			else {
				scalingHeight = false;
				autoScaleComponentWidths();
			}
		}

		public void setComponentWidths(int width) {
			for (Component c : componentList) {
				adjustWidth(c, width);
			}

			this.width = width;

			if (!scalingWidth && !scalingHeight)
				return;
			else if (!scalingWidth && scalingHeight)
				autoScaleComponentHeights();
			else if (scalingWidth && !scalingHeight)
				autoScaleComponentWidths();
			else {
				autoScaleComponentSizes();
			}
		}

		public void setComponentHeights(int height) {
			for (Component c : componentList) {
				adjustHeight(c, height);
			}

			this.height = height;

			if (!scalingWidth && !scalingHeight)
				return;
			else if (!scalingWidth && scalingHeight)
				autoScaleComponentHeights();
			else if (scalingWidth && !scalingHeight)
				autoScaleComponentWidths();
			else {
				autoScaleComponentSizes();
			}
		}

		// SCALE

		public void autoScaleComponentSizes() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.isAutoScalable()) {
					aC.getComponent().setMinimumSize(aC.getComponent().getMinimumSize());
					aC.getComponent().setPreferredSize(aC.getComponent().getPreferredSize());
					aC.getComponent().setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
				}
			}

			scalingWidth = true;
			scalingHeight = true;
		}

		public void autoScaleComponentWidths() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.isAutoScalable()) {
					aC.getComponent().setMinimumSize(aC.getComponent().getMinimumSize());
					aC.getComponent().setPreferredSize(aC.getComponent().getPreferredSize());
					aC.getComponent()
							.setMaximumSize(new Dimension(Short.MAX_VALUE, aC.getComponent().getMaximumSize().height));
				}
			}

			scalingWidth = true;
		}

		public void autoScaleComponentHeights() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.isAutoScalable()) {
					aC.getComponent().setMinimumSize(aC.getComponent().getMinimumSize());
					aC.getComponent().setPreferredSize(aC.getComponent().getPreferredSize());
					aC.getComponent()
							.setMaximumSize(new Dimension(aC.getComponent().getMaximumSize().width, Short.MAX_VALUE));
				}
			}

			scalingHeight = true;
		}

		// ADD

		public void addComponent(MuLEReferenceType<? extends Component> component) {
			componentList.add(component.value);

			Component aC = (Component) component.value;
			aC.setParent(this);

			setSize(component.value);

			setAlignment(alignment);

			updatePane();
		}

		public void addComponent(Component component, int index) {
			if (index > componentList.size())
				componentList.add(componentList.size(), component);
			else if (index < 0)
				componentList.add(0, component);
			else
				componentList.add(index, component);

			Component aC = (Component) component;
			aC.setParent(this);

			setSize(component);

			setAlignment(alignment);

			updatePane();
		}

		public void addComponents(Component... components) {
			for (Component c : components) {
				Component aC = (Component) c;
				aC.setParent(this);
				componentList.add(c);
				setSize(c);
			}

			setAlignment(alignment);

			updatePane();
		}

		/**
		 * ADD SPACE Andere Methoden-Name: setSpaceAfter(...), createSpaceAfter(...),
		 * ...
		 * 
		 * component_index < 0: Fge "Space" am Ende hinzu component_index > elemente in
		 * componentList: Fge "Space" am Ende hinzu component_index = 0: Fge "Space" am
		 * Anfang hinzu component_index > 0 && <= comonentList.size: Fge "Space" nach
		 * angegebenen Index hinzu
		 */

		public void addDynamicSpaceAfter(int component_index) {
			dynamicSpace.add(component_index);

			setAlignment(alignment);
		}

		public void addDynamicSpaceAfter(Component component) {
			int component_index = componentList.indexOf(component);
			dynamicSpace.add(component_index + 1);

			setAlignment(alignment);
		}

		// REMOVE

		public void removeAll() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.setParent(null);
			}
			panel.removeAll();
			componentList.clear();
			panel.repaint();

			updatePane();
		}

		public void remove(Component component) {
			Component aC = (Component) component;
			aC.setParent(null);
			panel.remove(aC.getComponent());
			componentList.remove(component);
			panel.repaint();

			updatePane();
		}

		public void remove(int index) {
			if (index == -1) {
				Component aC = (Component) componentList.remove(componentList.size() - 1);
				aC.setParent(null);
				panel.remove(aC.getComponent());
				componentList.remove(componentList.size() - 1);
			} else {
				Component aC = (Component) componentList.get(index);
				aC.setParent(null);
				panel.remove(aC.getComponent());
				componentList.remove(index);
			}
			panel.repaint();

			updatePane();
		}

		public void removeAllAddedSpace() {
			dynamicSpace.clear();
			setAlignment(alignment);
		}

		// GETTER

		public int getSpacing() {
			return spacing;
		}

		public Alignment getAlignment() {
			return alignment;
		}

		public int getMaxWidth() {
			int maxWidth = 0;
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.getComponent().getMaximumSize().width > maxWidth) {
					maxWidth = aC.getComponent().getMaximumSize().width;
				}
			}

			return maxWidth;
		}

		public int getMaxHeight() {
			int maxHeight = 0;
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.getComponent().getMaximumSize().height > maxHeight) {
					maxHeight = aC.getComponent().getMaximumSize().height;
				}
			}

			return maxHeight;
		}

		public Component getComponent(int index) {
			return componentList.get(index);
		}

		// PRIVATES

		private void adjustHeight(Component c, int height) {
			Component aC = (Component) c;
			if (aC instanceof Shape) {
				((Shape) aC).setSize(aC.getComponent().getWidth(), height);
			} else {
				aC.getComponent().setMinimumSize(new Dimension(aC.getComponent().getMinimumSize().width, height));
				aC.getComponent().setPreferredSize(new Dimension(aC.getComponent().getMinimumSize().width, height));
				aC.getComponent().setMaximumSize(new Dimension(aC.getComponent().getMinimumSize().width, height));
			}
		}

		private void adjustWidth(Component c, int width) {
			Component aC = (Component) c;
			if (aC instanceof Shape) {
				((Shape) aC).setSize(width, aC.getComponent().getHeight());
			} else {
				aC.getComponent().setMinimumSize(new Dimension(width, aC.getComponent().getMinimumSize().height));
				aC.getComponent().setPreferredSize(new Dimension(width, aC.getComponent().getPreferredSize().height));
				aC.getComponent().setMaximumSize(new Dimension(width, aC.getComponent().getMaximumSize().height));
			}
		}

		private void adjustSize(Component c, int width, int height) {
			Component aC = (Component) c;
			if (aC instanceof Shape) {
				((Shape) aC).setSize(width, height);
			} else {
				aC.getComponent().setMinimumSize(new Dimension(width, height));
				aC.getComponent().setPreferredSize(new Dimension(width, height));
				aC.getComponent().setMaximumSize(new Dimension(width, height));
			}
		}

		private void setSize(Component c) {
			if (height == -1 && width == -1) {
				if (!scalingWidth && !scalingHeight) {
					return;
				} else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			} else if (height == -1 && width != -1) {
				adjustWidth(c, width);

				if (!scalingWidth && !scalingHeight)
					return;
				else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			} else if (height != -1 && width == -1) {
				adjustHeight(c, height);

				if (!scalingWidth && !scalingHeight)
					return;
				else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			} else {
				adjustSize(c, width, height);

				if (!scalingWidth && !scalingHeight)
					return;
				else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			}
		}

		private void addComponentToPanel(Component component) {
			if (componentList.isEmpty()) {
				Component aC = (Component) component;
				panel.add(aC.getComponent());
			} else {
				Component aC = (Component) component;
				panel.add(Box.createHorizontalStrut(spacing));
				panel.add(aC.getComponent());
			}

			componentList.add(component);
		}

		private void addCustomSpaces() {
			for (Integer integer : dynamicSpace) {
				boolean space_at_beginning = false;
				Component c;

				if (integer > componentList.size() || integer < 0) // Fge "Space" am Ende hinzu
					c = componentList.get(componentList.size() - 1);
				else if (integer == 0) { // Fge "Space" am Anfang hinzu
					c = componentList.get(0);
					space_at_beginning = true;
				} else // Fge "Space" am Index hinzu
					c = componentList.get(integer - 1);

				if (space_at_beginning)
					panel.add(Box.createHorizontalGlue(), 0);
				else {
					for (int i = 0; i < panel.getComponentCount(); i++) {
						Component aC = (Component) c;
						if (panel.getComponent(i) == aC.getComponent()) {
							panel.add(Box.createHorizontalGlue(), i + 1);
						}
					}
				}
			}
		}

		private void resetComponents() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}
		}

		private void setTopLeft() {
			resetComponents();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(0);
			}
		}

		private void setTopCenter() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(0);
			}
		}

		private void setTopRight() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(0);
			}
		}

		private void setCenterLeft() {
			resetComponents();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(0.5f);
			}
		}

		private void setCenter() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(0.5f);
			}
		}

		private void setCenterRight() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(0.5f);
			}
		}

		private void setBottomLeft() {
			resetComponents();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(1);
			}
		}

		private void setBottomCenter() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(1);
			}
		}

		private void setBottomRight() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentY(1);
			}
		}

		private void setDefault() {
			resetComponents();

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();
		}

		private void setAlignment(Alignment alignment) {
			this.alignment = alignment;

			switch (alignment) {
			case TOP_LEFT:
				setTopLeft();
				break;
			case TOP_CENTER:
				setTopCenter();
				break;
			case TOP_RIGHT:
				setTopRight();
				break;
			case CENTER_LEFT:
				setCenterLeft();
				break;
			case CENTER:
				setCenter();
				break;
			case CENTER_RIGHT:
				setCenterRight();
				break;
			case BOTTOM_LEFT:
				setBottomLeft();
				break;
			case BOTTOM_CENTER:
				setBottomCenter();
				break;
			case BOTTOM_RIGHT:
				setBottomRight();
				break;
			case NONE:
				setDefault();
				break;
			}
		}
	}

	public static class VerticalPane extends Pane {

		private int spacing = 0;
		private Alignment alignment = Alignment.NONE; // Default

		private int width = -1; // Default
		private int height = -1; // Default

		private boolean scalingWidth = false;
		private boolean scalingHeight = false;

		private List<Component> componentList = new ArrayList<Component>();
		private List<Integer> dynamicSpace = new ArrayList<Integer>(); // 5, 6, 9 --> an diesen Stellen "Space" einfgen

		// CONSTRUCTORS

		public VerticalPane(Alignment alignment, int spacing) {
			this.autoScalable = true;
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			this.spacing = spacing;
			this.alignment = alignment;
		}

		public VerticalPane(Alignment alignment, int spacing, Component... components) {
			this.autoScalable = true;
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			this.spacing = spacing;
			this.alignment = alignment;
			addComponents(components);
		}

		public VerticalPane(Alignment alignment, Component... components) {
			this.autoScalable = true;
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			this.alignment = alignment;
			addComponents(components);
		}

		// INHERITED METHODS (Not Visible)

		public JComponent getComponent() {
			return panel;
		}

		public boolean isAutoScalable() {
			return this.autoScalable;
		}

		public void setParent(Component component) {
			this.parent = component;
		}

		// INHERITED METHODS (Visible)

		public void setVisible(boolean visible) {
			this.visible = visible;

			for (Component c : componentList) {
				c.setVisible(visible);
			}

			panel.repaint();
		}

		public void hideComponents(boolean hide) {
			for (Component c : componentList) {
				c.setVisible(!hide);
			}
		}

		public List<Component> getComponents() {
			return componentList;
		}

		public Component getParent() {
			return parent;
		}

		// SETTER

		public void setBackground(Colour colour) {
			this.panel.setBackground(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public void setBackground(Image image) {
			this.image = (Image) image;
			this.panel.repaint();
		}

		public void setBorder(MuLEReferenceType<? extends Border> border) {
			javax.swing.border.Border b = panel.getBorder();
			Border aB = (Border) border.value;

			if (b == null)
				this.panel.setBorder(aB.getBorder());
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(aB.getBorder(), b));
		}

		public void setPadding(int top, int left, int bottom, int right) {
			javax.swing.border.Border b = panel.getBorder();
			if (b == null)
				this.panel.setBorder(new EmptyBorder(top, left, bottom, right));
			else
				this.panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(top, left, bottom, right), b));
		}

		public void setSpacing(int spacing) {
			this.spacing = spacing;
			setAlignment(alignment);
		}

		public void setComponentSizes(int width, int height) {
			for (Component c : componentList) {
				adjustSize(c, width, height);
			}

			this.width = width;
			this.height = height;

			scalingWidth = false;
			scalingHeight = false;
		}

		public void setComponentWidths(int width) {
			for (Component c : componentList) {
				adjustWidth(c, width);
			}

			this.width = width;

			if (!scalingWidth && !scalingHeight)
				return;
			else if (!scalingWidth && scalingHeight)
				autoScaleComponentHeights();
			else if (scalingWidth && !scalingHeight)
				scalingWidth = false;
			else {
				autoScaleComponentHeights();
				scalingWidth = false;
			}
		}

		public void setComponentHeights(int height) {
			for (Component c : componentList) {
				adjustHeight(c, height);
			}

			this.height = height;

			if (!scalingWidth && !scalingHeight)
				return;
			else if (!scalingWidth && scalingHeight)
				scalingHeight = false;
			else if (scalingWidth && !scalingHeight)
				autoScaleComponentWidths();
			else {
				autoScaleComponentWidths();
				scalingHeight = false;
			}
		}

		// SCALE

		public void autoScaleComponentSizes() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.isAutoScalable()) {
					aC.getComponent().setMinimumSize(aC.getComponent().getMinimumSize());
					aC.getComponent().setPreferredSize(aC.getComponent().getPreferredSize());
					aC.getComponent().setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
				}
			}

			scalingWidth = true;
			scalingHeight = true;
		}

		public void autoScaleComponentWidths() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.isAutoScalable()) {
					aC.getComponent().setMinimumSize(aC.getComponent().getMinimumSize());
					aC.getComponent().setPreferredSize(aC.getComponent().getPreferredSize());
					aC.getComponent()
							.setMaximumSize(new Dimension(Short.MAX_VALUE, aC.getComponent().getMaximumSize().height));
				}
			}

			scalingWidth = true;
		}

		public void autoScaleComponentHeights() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.isAutoScalable()) {
					aC.getComponent().setMinimumSize(aC.getComponent().getMinimumSize());
					aC.getComponent().setPreferredSize(aC.getComponent().getPreferredSize());
					aC.getComponent()
							.setMaximumSize(new Dimension(aC.getComponent().getMaximumSize().width, Short.MAX_VALUE));
				}
			}

			scalingHeight = true;
		}

		// ADD

		public void addComponent(MuLEReferenceType<? extends Component> component) {
			componentList.add(component.value);

			Component aC = (Component) component.value;
			aC.setParent(this);

			setSize(component.value);

			setAlignment(alignment);

			updatePane();
		}

		public void addComponent(Component component, int index) {
			if (index > componentList.size())
				componentList.add(componentList.size(), component);
			else if (index < 0)
				componentList.add(0, component);
			else
				componentList.add(index, component);

			Component aC = (Component) component;
			aC.setParent(this);

			setSize(component);

			setAlignment(alignment);

			updatePane();
		}

		public void addComponents(Component... components) {
			for (Component c : components) {
				Component aC = (Component) c;
				aC.setParent(this);
				componentList.add(c);
				setSize(c);
			}
			setAlignment(alignment);

			updatePane();
		}

		/**
		 * ADD SPACE Andere Methoden-Name: setSpaceAfter(...), createSpaceAfter(...),
		 * ...
		 * 
		 * component_index < 0: Fge "Space" am Ende hinzu component_index > elemente in
		 * componentList: Fge "Space" am Ende hinzu component_index = 0: Fge "Space" am
		 * Anfang hinzu component_index > 0 && <= comonentList.size: Fge "Space" nach
		 * angegebenen Index hinzu
		 */

		public void addDynamicSpaceAfter(int component_index) {
			dynamicSpace.add(component_index);

			setAlignment(alignment);
		}

		public void addDynamicSpaceAfter(Component component) {
			int component_index = componentList.indexOf(component);
			dynamicSpace.add(component_index + 1);

			setAlignment(alignment);
		}

		// REMOVE

		public void removeAll() {
			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.setParent(null);
			}

			panel.removeAll();
			componentList.clear();
			panel.repaint();

			updatePane();
		}

		public void remove(Component component) {
			Component aC = (Component) component;
			aC.setParent(null);
			panel.remove(aC.getComponent());
			componentList.remove(component);
			panel.repaint();

			updatePane();
		}

		public void remove(int index) {
			if (index == -1) {
				Component aC = (Component) componentList.remove(componentList.size() - 1);
				aC.setParent(null);
				panel.remove(aC.getComponent());
				componentList.remove(componentList.size() - 1);
			} else {
				Component aC = (Component) componentList.get(index);
				aC.setParent(null);
				panel.remove(aC.getComponent());
				componentList.remove(index);
			}
			panel.repaint();

			updatePane();
		}

		public void removeAllAddedSpace() {
			dynamicSpace.clear();
			setAlignment(alignment);
		}

		// GETTER

		public int getSpacing() {
			return spacing;
		}

		public Alignment getAlignment() {
			return alignment;
		}

		public int getMaxWidth() {
			int maxWidth = 0;
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.getComponent().getMaximumSize().width > maxWidth) {
					maxWidth = aC.getComponent().getMaximumSize().width;
				}
			}

			return maxWidth;
		}

		public int getMaxHeight() {
			int maxHeight = 0;
			for (Component c : componentList) {
				Component aC = (Component) c;
				if (aC.getComponent().getMaximumSize().height > maxHeight) {
					maxHeight = aC.getComponent().getMaximumSize().height;
				}
			}

			return maxHeight;
		}

		public Component getComponent(int index) {
			return componentList.get(index);
		}

		// PRIVATES

		private void adjustHeight(Component c, int height) {
			Component aC = (Component) c;
			if (aC instanceof Shape) {
				((Shape) aC).setSize(aC.getComponent().getWidth(), height);
			} else {
				aC.getComponent().setMinimumSize(new Dimension(aC.getComponent().getMinimumSize().width, height));
				aC.getComponent().setPreferredSize(new Dimension(aC.getComponent().getMinimumSize().width, height));
				aC.getComponent().setMaximumSize(new Dimension(aC.getComponent().getMinimumSize().width, height));
			}
		}

		private void adjustWidth(Component c, int width) {
			Component aC = (Component) c;
			if (aC instanceof Shape) {
				((Shape) aC).setSize(width, aC.getComponent().getHeight());
			} else {
				aC.getComponent().setMinimumSize(new Dimension(width, aC.getComponent().getMinimumSize().height));
				aC.getComponent().setPreferredSize(new Dimension(width, aC.getComponent().getPreferredSize().height));
				aC.getComponent().setMaximumSize(new Dimension(width, aC.getComponent().getMaximumSize().height));
			}
		}

		private void adjustSize(Component c, int width, int height) {
			Component aC = (Component) c;
			if (aC instanceof Shape) {
				((Shape) aC).setSize(width, height);
			} else {
				aC.getComponent().setMinimumSize(new Dimension(width, height));
				aC.getComponent().setPreferredSize(new Dimension(width, height));
				aC.getComponent().setMaximumSize(new Dimension(width, height));
			}
		}

		private void setSize(Component c) {
			if (height == -1 && width == -1) {
				if (!scalingWidth && !scalingHeight)
					return;
				else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			} else if (height == -1 && width != -1) {
				adjustWidth(c, width);

				if (!scalingWidth && !scalingHeight)
					return;
				else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			} else if (height != -1 && width == -1) {
				adjustHeight(c, height);

				if (!scalingWidth && !scalingHeight)
					return;
				else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			} else {
				adjustSize(c, width, height);

				if (!scalingWidth && !scalingHeight)
					return;
				else if (!scalingWidth && scalingHeight)
					autoScaleComponentHeights();
				else if (scalingWidth && !scalingHeight)
					autoScaleComponentWidths();
				else
					autoScaleComponentSizes();
			}
		}

		private void addComponentToPanel(Component component) {
			if (componentList.isEmpty()) {
				Component aC = (Component) component;
				panel.add(aC.getComponent());
			} else {
				Component aC = (Component) component;
				panel.add(Box.createVerticalStrut(spacing));
				panel.add(aC.getComponent());
			}

			componentList.add(component);
		}

		private void addCustomSpaces() {
			for (Integer integer : dynamicSpace) {
				boolean spaceAtBeginning = false;
				Component c;

				if (integer > componentList.size() || integer < 0) // Fge "Space" am Ende hinzu
					c = componentList.get(componentList.size() - 1);
				else if (integer == 0) { // Fge "Space" am Anfang hinzu
					c = componentList.get(0);
					spaceAtBeginning = true;
				} else // Fge "Space" am Index hinzu
					c = componentList.get(integer - 1);

				if (spaceAtBeginning)
					panel.add(Box.createVerticalGlue(), 0);
				else {
					for (int i = 0; i < panel.getComponentCount(); i++) {
						Component aC = (Component) c;
						if (panel.getComponent(i) == aC.getComponent()) {
							panel.add(Box.createVerticalGlue(), i + 1);
						}
					}
				}
			}
		}

		private void resetComponents() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}
		}

		private void setTopLeft() {
			resetComponents();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createHorizontalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(0);
			}
		}

		private void setTopCenter() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(0.5f);
			}
		}

		private void setTopRight() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(1);
			}
		}

		private void setCenterLeft() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(0f);
			}
		}

		private void setCenter() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(0.5f);
			}
		}

		private void setCenterRight() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());
			else
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(1);
			}
		}

		private void setBottomLeft() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(0f);
			}
		}

		private void setBottomCenter() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(0.5f);
			}
		}

		private void setBottomRight() {
			List<Component> copyOfComponentList = new ArrayList<Component>();
			for (Component c : componentList) {
				copyOfComponentList.add(c);
			}
			componentList.clear();

			panel.removeAll();

			if (dynamicSpace.isEmpty())
				panel.add(Box.createVerticalGlue());

			for (Component c : copyOfComponentList) {
				addComponentToPanel(c);
			}

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();

			for (Component c : componentList) {
				Component aC = (Component) c;
				aC.getComponent().setAlignmentX(1);
			}
		}

		private void setDefault() {
			resetComponents();

			if (!dynamicSpace.isEmpty())
				addCustomSpaces();
		}

		private void setAlignment(Alignment alignment) {
			this.alignment = alignment;

			switch (alignment) {
			case TOP_LEFT:
				setTopLeft();
				break;
			case TOP_CENTER:
				setTopCenter();
				break;
			case TOP_RIGHT:
				setTopRight();
				break;
			case CENTER_LEFT:
				setCenterLeft();
				break;
			case CENTER:
				setCenter();
				break;
			case CENTER_RIGHT:
				setCenterRight();
				break;
			case BOTTOM_LEFT:
				setBottomLeft();
				break;
			case BOTTOM_CENTER:
				setBottomCenter();
				break;
			case BOTTOM_RIGHT:
				setBottomRight();
				break;
			case NONE:
				setDefault();
				break;
			}
		}
	}
}
