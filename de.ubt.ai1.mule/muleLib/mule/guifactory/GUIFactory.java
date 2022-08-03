package mule.guifactory;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JFrame;

import mule.guifactory.GUIFactoryComponents.Image;
import mule.guifactory.GUIFactoryPanes.Pane;
import mule.guifactory.GUIFactoryTasks.KeyTask;
import mule.guifactory.GUIFactoryTasks.MouseTask;
import mule.guifactory.GUIFactoryTasks.WindowTask;
import mule.util.MuLEReferenceType;

public class GUIFactory {
	// WINDOW

	public static MuLEReferenceType<Window> createWindow(String title, int width, int height) {
		return new MuLEReferenceType<Window>(new Window(title, width, height));
	}

	public static MuLEReferenceType<Window> createWindow(String title, int width, int height, int x, int y) {
		return new MuLEReferenceType<Window>(new Window(title, width, height, x, y));
	}

	// COLORS

	public static Colour createColour(int r, int g, int b, int a) {
		return new Colour(r, g, b, a);
	}

	public static Colour createColour(int r, int g, int b) {
		return new Colour(r, g, b);
	}

	public static Colour createColourFromPalette(Palette colour) {
		return new Colour(colour.r, colour.g, colour.b, colour.a);
	}





	// ENUMS

	public enum Palette {
		LIGHT_RED(255, 51, 51, 255), RED(255, 0, 0, 255), DARK_RED(204, 0, 0, 255), CYAN(135, 211, 248, 255),
		LIGHT_BLUE(51, 153, 255, 255), BLUE(0, 0, 255, 255), DARK_BLUE(0, 0, 204, 255),
		LIGHT_YELLOW(255, 255, 204, 255), YELLOW(255, 255, 0, 255), DARK_YELLOW(255, 204, 0, 255),
		LIGHT_GREEN(0, 255, 51, 255), GREEN(0, 204, 0, 255), DARK_GREEN(0, 153, 0, 255), ORANGE(255, 102, 0, 255),
		GOLD(255, 204, 51, 255), LIGHT_GREY(204, 204, 204, 255), GREY(102, 102, 102, 255), DARK_GREY(51, 51, 51, 255),
		LIGHT_BROWN(153, 102, 0, 255), BROWN(102, 51, 0, 255), DARK_BROWN(51, 0, 0, 255), PURPLE(102, 0, 153, 255),
		BLACK(0, 0, 0, 255), WHITE(255, 255, 255, 255), TRANSPARENT(0, 0, 0, 0);

		public final int r;
		public final int g;
		public final int b;
		public final int a;

		Palette(int r, int g, int b, int a) {
			this.r = r;
			this.g = g;
			this.b = b;
			this.a = a;
		}
	}

	public enum HorizontalAlignment {
		LEFT, CENTER, RIGHT
	}

	public enum FontType {
		PLAIN, ITALIC, BOLD, ITALIC_BOLD
	}

	public enum CheckBoxAlignment {
		NONE, ICON_LEFT_TEXT_RIGHT, ICON_RIGHT_TEXT_LEFT, ICON_TEXT_LEFT, ICON_TEXT_RIGHT
	}

	public enum Alignment {
		TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT,
		NONE
	}

	// MAIN TYPES

	public static class Window implements Serializable {
		private JFrame window = new JFrame();

		private Pane currentPane;

		// CONSTRUCTORS
		public Window() {
		}

		public Window(String title, int width, int height) {
			window.setTitle(title);
			window.setSize(width, height);
			window.setLocationRelativeTo(null);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setFocusable(true);
			window.setFocusTraversalKeysEnabled(false);
		}

		public Window(String title, int width, int height, int x, int y) {
			window.setTitle(title);
			window.setBounds(x, y, width, height);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setFocusable(true);
			window.setFocusTraversalKeysEnabled(false);
		}

		// TASKS

		public void handleWindowTask(WindowTask windowTask) {
			window.addWindowListener(windowTask);
			window.addWindowFocusListener(windowTask);
			window.addWindowStateListener(windowTask);
		}

		public void handleKeyTask(KeyTask keyTask) {
			window.addKeyListener(keyTask);
		}

		public void handleMouseTask(MouseTask mouseTask) {
			window.addMouseListener(mouseTask);
			window.addMouseMotionListener(mouseTask);
		}

		// SETTER

		public void setPane(MuLEReferenceType<? extends Pane> pane) {
			currentPane = pane.value; // To know what Pane is currently showen by the window
			Pane aP = (Pane) pane.value;
			aP.setWindow(this); // Pane has to know that it sits on this window
			window.add(aP.getPanel());
		}

		public void setIconImage(Image image) {
			Image icon = (Image) image;
			window.setIconImage(icon.getImage().getImage());
		}

		public void setSize(int width, int height) {
			window.setSize(width, height);
		}

		public void setPosition(int x, int y) {
			window.setLocation(x, y);
		}

		public void setToScreenSize() {
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}

		public void setTitle(String title) {
			window.setTitle(title);
		}

		public void setVisible(boolean visible) {
			window.setVisible(visible);
		}

		public void setResizable(boolean resizable) {
			window.setResizable(resizable);
		}

		// SHOW

		public void showWindow() {
			window.setVisible(true);
		}

		// REQUESTS

		public boolean isResizable() {
			return window.isResizable();
		}

		public boolean hasFocus() {
			return window.hasFocus();
		}

		// GETTER

		public Pane getPane() {
			return currentPane;
		}

		public String getTitle() {
			return window.getTitle();
		}
	}

	public static class Colour implements Serializable {
		private Color color;
		public int r;
		public int g;
		public int b;
		public int a;

		public Colour(int r, int g, int b) {
			color = new Color(r, g, b);
			this.r = r;
			this.g = g;
			this.b = b;
			this.a = 255;
		}

		public Colour(int r, int g, int b, int a) {
			color = new Color(r, g, b, a);
			this.r = r;
			this.g = g;
			this.b = b;
			this.a = a;
		}

		public void setColour(Colour colour) {
			color = new Color(colour.r, colour.g, colour.b, colour.a);
		}
	}
}
