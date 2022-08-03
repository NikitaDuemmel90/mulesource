package mule.ubtmicroworld.gui;

import java.awt.Color;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLayer;
import javax.swing.JPanel;

import mule.ubtmicroworld.data.BibKeyEventListener;
import mule.ubtmicroworld.data.IGameState;

/**
 * This class represents the GamePanel.
 * @author Marco Jantos
 * 
 */
public class GamePanel extends JPanel implements GuiEventEmmitter, PanelEventListener{

	private static final long serialVersionUID = 1L;
	
	private GameBoardPanel boardPanel;
	private GameCounterPanel counterPanel;

	protected List<GuiEventListener> listeners = new Vector<GuiEventListener>();
		
	public GamePanel(IGameState gameState, JLayer<JPanel> jLayer, GameBoardPanel gameBoardPanel, GameCounterPanel gameCounterPanel) {
		
		this.setBackground(Color.BLACK);

		boardPanel = gameBoardPanel;
		counterPanel = gameCounterPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		this.add(jLayer);
		this.add(gameCounterPanel);
		
		boardPanel.addKeyListener(boardPanel);
		boardPanel.setFocusable(true);

		validate();
		repaint();
		
		boardPanel.runAnnimation();
		counterPanel.runAnnimation();
		
	}
	
	public void refreshView() {
		boardPanel.repaint();
		boardPanel.revalidate();
		counterPanel.repaint();
		counterPanel.revalidate();
	}
	
	public void registerBibKeyListener(BibKeyEventListener listener) {
		boardPanel.registerListener(listener);
	}
	
	
	/**
	 * This method tells all registered listeners about an event.
	 * 
	 * @param event   the guiEvent, that should be published
	 */
	private void tellAllListeners(GuiEvent event) {
		listeners.forEach(l -> l.handle(event));
	}


	@Override
	public void handle(PanelEvent event) {
		
	}


	@Override
	public void registerListener(GuiEventListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(GuiEventListener listener) {
		this.listeners.remove(listener);
	}
}
