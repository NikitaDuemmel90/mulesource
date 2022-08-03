package mule.ubtmicroworld.data;

import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;

/**
 * This interface specializes the GameState on which the game is based
 * @author Marco Jantos
 *
 */
public interface IGameState {
	
	/**
	 * This method returns the matchfield of type IMatchfield.
	 * @return  matchfield of type IMatchfield.
	 */
	public IMatchfield getMatchfield();
	
	/**
	 * This method returns a list of all agents.
	 * @return  list of all agents.
	 */
	public List<Agent> getAgentList();
	
	/**
	 * This method returns whether the game is over.
	 * @return  True if the game is over - False otherwise.
	 */
	public boolean isGameOver();
	
	/**
	 * This method returns whether the game is finished.
	 * @return  True if the game is finished - False otherwise.
	 */
	public boolean isGameFinished();
	
	/**
	 * This method ends the game. This was not successfully passed
	 */
	public void setGameOver();
	
	/**
	 * This method ends the game. This was successfully passed
	 */
	public void setGameFinished();
	
	/**
	 * This method returns the name of the WinCondition.
	 * @return  name of the WinCondition
	 */
	public String getWinConditionName();
	
	/**
	 * This method returns the description of the WinCondition.
	 * @return  description of the WinCondition
	 */
	public String getWinConditionDescription();
	
}
