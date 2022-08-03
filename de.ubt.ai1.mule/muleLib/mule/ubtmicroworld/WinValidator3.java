package mule.ubtmicroworld;

import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.ITile;
import mule.ubtmicroworld.data.IWinValidator;
import mule.ubtmicroworld.data.Matchfield;

public class WinValidator3 implements IWinValidator{
	
	private final String winConditionName = "WinValidator3";
	
	private final String description = "To win the level, all agents must reach the target tiles. \n\n"
			+ "Additionally, they must gather all of the objects."
			+ "\n\nGood Luck!";
	
	
	
	private Controller controller;
	
	public WinValidator3(Controller controller) {
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
		
		
		boolean isReachedPart1 = true;
		
		for(Agent player : playerList) {
			boolean tileFound = false;
			for(ITile tile : targetList) {
				if(player.getXPosition() == tile.getXPos() && player.getYPosition() == tile.getYPos()) {
					tileFound = true;
					break;
				}
			}
			
			if(!tileFound) {
				isReachedPart1 = false;
			}
		}		
		
		boolean isReachedPart2 = false;
		boolean part2Done = false;
		
		int dimension = matchfield.getDimension();
		
		for(int y = 0; y < dimension; y++) {
			for(int x = 0; x < dimension; x++) {
				
				if(matchfield.getTile(x, y).isObjectOnTile()) {
					isReachedPart2 = false;
					part2Done = true;
				}
			}
		}
		
		if(!part2Done) {
			isReachedPart2 = true;
		}

		
		if(isReachedPart1 && isReachedPart2) {
			controller.setGameFinished();
		}

		
	}

	@Override
	public String getDescription() {
		return description;
	}

	
}
