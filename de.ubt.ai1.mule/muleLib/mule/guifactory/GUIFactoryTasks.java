package mule.guifactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GUIFactoryTasks {
	// TASKS

	public static abstract class Task {

	}

	public static abstract class ActionTask extends Task implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
//			actionPerformed(arg0.getActionCommand());
			actionPerformed();
		}

//		public abstract void actionPerformed(String taskCommand);
		public abstract void actionPerformed();
	}

	public static abstract class KeyTask extends Task implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			keyPressed(KeyEvent.getKeyText(arg0.getKeyCode()));
		}

		public abstract void keyPressed(String key);

		@Override
		public void keyReleased(KeyEvent arg0) {
			keyReleased(KeyEvent.getKeyText(arg0.getKeyCode()));
		}

		public abstract void keyReleased(String key);

		@Override
		public void keyTyped(KeyEvent arg0) {
			keyTyped(KeyEvent.getKeyText(arg0.getKeyCode()));
		}

		public abstract void keyTyped(String key);
	}

	public static abstract class MouseTask extends Task implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mouseClicked(arg0.getButton(), arg0.getX(), arg0.getY(), arg0.getXOnScreen(), arg0.getYOnScreen());
		}

		public abstract void mouseClicked(int id, int xComponent, int yComponent, int xWindow, int yWindow);

		@Override
		public void mouseEntered(MouseEvent arg0) {
			mouseEntered();
		}

		public abstract void mouseEntered();

		@Override
		public void mouseExited(MouseEvent arg0) {
			mouseExited();
		}

		public abstract void mouseExited();

		@Override
		public void mousePressed(MouseEvent arg0) {
			mousePressed(arg0.getButton(), arg0.getX(), arg0.getY(), arg0.getXOnScreen(), arg0.getYOnScreen());
		}

		public abstract void mousePressed(int id, int xComponent, int yComponent, int xWindow, int yWindow);

		@Override
		public void mouseReleased(MouseEvent arg0) {
			mouseReleased(arg0.getButton(), arg0.getX(), arg0.getY(), arg0.getXOnScreen(), arg0.getYOnScreen());
		}

		public abstract void mouseReleased(int id, int xComponent, int yComponent, int xWindow, int yWindow);

		@Override
		public void mouseDragged(MouseEvent arg0) {
			mouseDragged(arg0.getButton(), arg0.getX(), arg0.getY(), arg0.getXOnScreen(), arg0.getYOnScreen());
		}

		public abstract void mouseDragged(int id, int xComponent, int yComponent, int xWindow, int yWindow);

		@Override
		public void mouseMoved(MouseEvent arg0) {
			mouseMoved(arg0.getX(), arg0.getY(), arg0.getXOnScreen(), arg0.getYOnScreen());
		}

		public abstract void mouseMoved(int xComponent, int yComponent, int xWindow, int yWindow);

	}

	public static abstract class ValueChangedTask implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			valueChanged(((JSlider) e.getSource()).getValue());
		}

		public abstract void valueChanged(int value);

	}

	public static abstract class WindowTask extends Task
			implements WindowListener, WindowFocusListener, WindowStateListener {
		@Override
		public void windowActivated(WindowEvent arg0) {
			windowActivated();
		}

		public abstract void windowActivated();

		@Override
		public void windowClosed(WindowEvent arg0) {
			windowClosed();
		}

		public abstract void windowClosed();

		@Override
		public void windowClosing(WindowEvent arg0) {
			windowClosing();
		}

		public abstract void windowClosing();

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			windowDeactivated();
		}

		public abstract void windowDeactivated();

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			windowDeiconified();
		}

		public abstract void windowDeiconified();

		@Override
		public void windowIconified(WindowEvent arg0) {
			windowIconified();
		}

		public abstract void windowIconified();

		@Override
		public void windowOpened(WindowEvent arg0) {
			windowOpened();
		}

		public abstract void windowOpened();

		@Override
		public void windowGainedFocus(WindowEvent arg0) {
			windowGainedFocus();
		}

		public abstract void windowGainedFocus();

		@Override
		public void windowLostFocus(WindowEvent arg0) {
			windowLostFocus();
		}

		public abstract void windowLostFocus();

		@Override
		public void windowStateChanged(WindowEvent arg0) {
			windowStateChanged();
		}

		public abstract void windowStateChanged();
	}
}
