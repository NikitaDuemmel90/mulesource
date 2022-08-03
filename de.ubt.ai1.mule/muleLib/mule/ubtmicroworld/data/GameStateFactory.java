package mule.ubtmicroworld.data;

import java.util.ArrayList;
import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.UBTMicroworld.LineOfSight;

/**
 * This class is a factory for a GameState. 
 * @author Marco Jantos
 * 
 */
public class GameStateFactory {
	
	public static GameState generateGameState(IMatchfield matchfield, DataController dataController) {
		
		int counterID = 0;
		
		List<Agent> playerList = new ArrayList<Agent>();
		List<ITile> startTiles = matchfield.getStartTiles();
		
		int playerX;
		int playerY;
		LineOfSight playerLineOfSight = LineOfSight.EAST;
		
		for(ITile tile : startTiles) {
			playerX = tile.getXPos();
			playerY = tile.getYPos();
			
			Agent player = new AgentImpl(playerX, playerY, playerLineOfSight, (Matchfield) matchfield, dataController, counterID);
			playerList.add(player);
			counterID++;
		}

		GameState gameState = new GameState(matchfield, playerList, dataController.getWinCondName(), dataController.getWinCondDescription());
		return gameState;
		
		
	}
	
}