package mule.ubtmicroworld;

import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.ITile;
import mule.ubtmicroworld.data.IWinValidator;
import mule.ubtmicroworld.data.Matchfield;
import mule.ubtmicroworld.data.Tile;

public class WinValidator1 implements IWinValidator{
	
	private final String winConditionName = "WinValidator1";
	
	private final String description = "To win the level, all agents must reach the target tiles."
			+ "\n\nSeveral agents can be on the same tile at the same time."
			+ "\n\nGood Luck!";
	
	private Controller controller;
	
	
	public WinValidator1(Controller controller) {
		this.controller = controller;
	}

	@Override
	public String getWinConditionName() {
		return winConditionName;
	}

	@Override
	public void validate(IGameState gameState) {
		
		List<Agent> playerList = gameState.getAgentList();
		
		Matchfield matchfield = (Matchfield) gameState.getMatchfield();
		List<ITile> targetList = matchfield.getTargetTiles();
		
		boolean isReached = true;
		
		for(Agent player : playerList) {
			boolean tileFound = false;
			for(ITile tile : targetList) {
				if(player.getXPosition() == tile.getXPos() && player.getYPosition() == tile.getYPos()) {
					tileFound = true;
					break;
				}
			}
			
			if(!tileFound) {
				isReached = false;
			}
			
		}
		
		if(isReached) {
			controller.setGameFinished();
		}

		
	}

	@Override
	public String getDescription() {
		return description;
	}

	
}
