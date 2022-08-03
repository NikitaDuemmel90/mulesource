package mule.ubtmicroworld.data;

import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;

/**
 * This class holds information for the current state of the level.
 * @author Marco Jantos
 * 
 */
public class GameState implements IGameState{

	private IMatchfield matchfield;
	
	private List<Agent> playerList;
	private List<ITile> targetTiles;	
	private List<ITile> startTiles;
	
	private boolean isGameOver = false;	
	private boolean isGameFinished = false;
	
	private boolean isGameOverFinished = false;

	private String winCondName = "";	
	private String winCondDescription = "";
	
	
	public GameState(IMatchfield matchfield, List<Agent> agentList, String winCondName, String winCondDescription) {
		this.matchfield = matchfield;
		this.playerList = agentList;
		this.winCondName = winCondName;
		this.winCondDescription = winCondDescription;
		
		targetTiles = matchfield.getTargetTiles();		
		startTiles = matchfield.getStartTiles();
	}
	
	@Override
	public IMatchfield getMatchfield() {
		return matchfield;
	}
	
	@Override
	public List<Agent> getAgentList(){
		return playerList;
	}
	

	@Override
	public boolean isGameOver() {
		return isGameOver;
	}

	@Override
	public boolean isGameFinished() {
		return isGameFinished;
	}


	@Override
	public void setGameOver() {
		if(isGameOverFinished) {
			return;
		}		
		
		if(!isGameFinished) {
			isGameOver = true;
			isGameOverFinished = true;
		}
		else {
			System.out.println("--------------------Message-----------------");
			System.out.println("Level ist beeits erfolgreich beendet.");
			System.out.println("--------------------------------------------");	
		}
	}

	@Override
	public void setGameFinished() {
		if(isGameOverFinished) {
			return;
		}
		
		if(!isGameOver) {
			isGameFinished = true;
			isGameOverFinished = true;
		}
		else {
			System.out.println("--------------------Message-----------------");
			System.out.println("Level ist beeits erfolglos beendet.");
			System.out.println("--------------------------------------------");
		}
		
	}

	@Override
	public String getWinConditionName() {
		return winCondName;
	}

	@Override
	public String getWinConditionDescription() {
		return winCondDescription;
	}

}