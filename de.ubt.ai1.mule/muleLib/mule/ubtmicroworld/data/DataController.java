package mule.ubtmicroworld.data;


import java.util.List;
import java.util.Vector;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.UBTMicroworld.DelayTime;
import mule.ubtmicroworld.gui.GuiEvent;
import mule.ubtmicroworld.gui.GuiEventEmmitter;
import mule.ubtmicroworld.gui.GuiEventListener;

/**
 * This class is the main class of the data. 
 * @author Marco Jantos
 * 
 */
public class DataController implements GuiEventEmmitter{
	
	private IGameState gameState;
	
	private IWinValidator winValidator;
	
	protected List<GuiEventListener> listeners = new Vector<GuiEventListener>();


	public DataController() {
		
	}
	
	public void setDelayTime(DelayTime delayTime) {
		AgentUtil.setDelayTime(delayTime);
	}

	
	public void generateNewGameState(IMatchfield matchfield) {
		gameState = GameStateFactory.generateGameState(matchfield, this);
	}
	
	public void setWinValidator(IWinValidator winValidator) {
		this.winValidator = winValidator;
	}
	
	public void setGameOver() {
		gameState.setGameOver();
	}
	
	public void setGameFinished() {
		gameState.setGameFinished();
	}
	
	public String getWinCondName() {
		return winValidator.getWinConditionName();
	}
	
	public String getWinCondDescription() {
		return winValidator.getDescription();
	}
	
	public boolean isAgentAllowedToMove(Agent agent) {
		
		winValidator.validate(gameState);
		
		if(gameState.isGameOver()) {
			return false;
		}
		else if(gameState.isGameFinished()) {
			return false;
		}
		
		return true; 
	}
	
	public void validate() {
		winValidator.validate(gameState);
	}
	
	
	public IGameState getGameState() {
		return gameState;
	}
	
	public List<Agent> getAgentList(){
		return gameState.getAgentList();
	}


	/**
	 * This method tells all registered PanelEventListeners about a PanelEvent
	 * @param event  The Event that should be told to the listeners
	 */
	private void tellAllListeners(GuiEvent event) {
		listeners.forEach(l -> l.handle(event));
	}

	@Override
	public void registerListener(GuiEventListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(GuiEventListener listener) {
		this.listeners.remove(listener);
	}

	public IMatchfield getMatchfield() {
		return gameState.getMatchfield();
	}
	
}
