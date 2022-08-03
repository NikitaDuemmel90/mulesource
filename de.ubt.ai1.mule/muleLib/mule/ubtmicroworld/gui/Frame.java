package mule.ubtmicroworld.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.plaf.LayerUI;

import mule.ubtmicroworld.data.BibKeyEventListener;
import mule.ubtmicroworld.data.IGameState;

/**
 * This class represents the Frame.
 * @author Marco Jantos
 * 
 */
public class Frame extends JFrame implements PanelEventListener, GuiEventEmmitter{

	private static final long serialVersionUID = 1L;

	private GuiController guiController;
	
	private OverlayPanel overlayPanel;
	private BackgroundPanel backgroundPanel;
	
	private GamePanel gamePanel;

	
	protected List<GuiEventListener> listeners = new Vector<GuiEventListener>();
	

	public Frame(GuiController guiController) {
		this.guiController = guiController;
		
		IGameState gameState = guiController.getGameState();
		
		GameBoardPanel gameBoardPanel = new GameBoardPanel(gameState);
		GameCounterPanel gameCounterPanel = new GameCounterPanel(gameState);
		
		guiController.registerListener(gameBoardPanel);
		guiController.registerListener(gameCounterPanel);
		
		gameBoardPanel.registerListener(guiController);
		gameCounterPanel.registerListener(guiController);
		
		LayerUI<JPanel> layerUI = new TopLayerUI(gameState, gameBoardPanel);
		JLayer<JPanel> jLayer = new JLayer(gameBoardPanel, layerUI);
		
		guiController.registerListener((PanelEventListener) layerUI);
		
		this.gamePanel = new GamePanel(gameState, jLayer, gameBoardPanel, gameCounterPanel);
		
		
		this.backgroundPanel = new BackgroundPanel(null);
		  
		Color backgroundColor = new Color(0, 0, 0);
		backgroundPanel.setBackground(backgroundColor);
		
		gamePanel.registerListener(guiController);
		
		guiController.registerListener(this);
		guiController.registerListener(gamePanel);
			
		
		this.setTitle("UbtMicroworld");
		Dimension dimension = new Dimension(1050, 770);
		this.setMinimumSize(dimension);
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		changePanel(gamePanel);
		
	}
	
	public void refreshGamePanel() {
		gamePanel.refreshView();
	}
	
	private void changePanel(JPanel panel) {

		overlayPanel = new OverlayPanel(panel, backgroundPanel);

		this.getContentPane().removeAll();
		this.getContentPane().invalidate();
		this.getContentPane().add(overlayPanel);
		this.getContentPane().revalidate();
		this.repaint();
	}
	
	public void registerBibKeyListener(BibKeyEventListener listener) {
		if(gamePanel != null) {
			gamePanel.registerBibKeyListener(listener);
		}
		else {
			System.out.println("--------------Error-Message----------------------");
			System.out.println("Fehler beim registrieren des BibKeyEventListener.");
			System.out.println("-------------------------------------------------");
		}
	}


	@Override
	public void registerListener(GuiEventListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(GuiEventListener listener) {
		this.listeners.remove(listener);
		
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
		PanelEventType panelEventType = event.getType();
		switch(panelEventType) {
		case TILE_REQUEST_ANSWER:
			//nothing to do here
			break;
		case GAME_PANEL:
			changePanel(gamePanel);
			break;
		default:
			break;
		
		}
		
	}
}