package mule.ubtmicroworld.gui;

import java.util.List;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mule.ubtmicroworld.Controller;
import mule.ubtmicroworld.data.BibKeyEventListener;
import mule.ubtmicroworld.data.IGameState;

/**
 * This class is the main class of the GUI.
 * @author Marco Jantos
 * 
 */
public class GuiController implements GuiEventListener, PanelEventEmmitter{

	private Frame frame;
	private Controller controller;
	
	private IGameState gameStateNew;
	
	protected List<PanelEventListener> listeners = new Vector<PanelEventListener>();
	
	public GuiController(Controller controller, IGameState gameState) {
		this.controller = controller;
		setGameState(gameState);
		
		frame = new Frame(this);
		

		
		try {
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		        
			// Set cross-platform Java L&F (also called "Metal")
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}
	}
	
	public void registerBibKeyListener(BibKeyEventListener listener) {
		frame.registerBibKeyListener(listener);
	}
	
	public void setGameState(IGameState gameState) {
		this.gameStateNew = gameState;
	}
	
	public IGameState getGameState() {
		return gameStateNew;
	}
	
	
	/**
	 * This method tells all registered PanelEventListeners about a PanelEvent
	 * @param event  The Event that should be told to the listeners
	 */
	private void tellAllListeners(PanelEvent event) {
		listeners.forEach(l -> l.handle(event));
	}

	@Override
	public void registerListener(PanelEventListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(PanelEventListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void handle(GuiEvent event) {
		PanelEvent panelEvent;
		switch(event.getType()) {
		case TILE_REQUEST:			
			
			int tileX = event.getFirstAttributeInteger(GuiEventEnumKey.TILE_POS_X);
			int tileY = event.getFirstAttributeInteger(GuiEventEnumKey.TILE_POS_Y);
			
			panelEvent = new PanelEvent(PanelEventType.TILE_REQUEST_ANSWER);
			panelEvent.addAtribute(PanelEventEnumKey.TILE_POS_X, tileX);
			panelEvent.addAtribute(PanelEventEnumKey.TILE_POS_Y, tileY);
			
			tellAllListeners(panelEvent);
			
			break;
		case GAME_PANEL:
			panelEvent = new PanelEvent(PanelEventType.GAME_PANEL);
			tellAllListeners(panelEvent);
			break;
		case REFRESH_BOARD_PANEL:
			frame.refreshGamePanel();
			break;
			
		case START_REPLAY:
			panelEvent = new PanelEvent(PanelEventType.START_REPLAY);
			panelEvent.addAtribute(PanelEventEnumKey.AGENT_ID, event.getFirstAttributeInteger(GuiEventEnumKey.AGENT_ID));
			panelEvent.addAtribute(PanelEventEnumKey.STEPS, event.getFirstAttributeInteger(GuiEventEnumKey.STEPS));
			tellAllListeners(panelEvent);
			break;
			
		case STOP_REPLAY:
			panelEvent = new PanelEvent(PanelEventType.STOP_REPLAY);
			tellAllListeners(panelEvent);
			break;
 			
		default:
			break;
		
		}
		
	}
}
