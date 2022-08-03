package mule.ubtmicroworld.data;

public interface IWinValidator {
	
	/**
	 * This method returns the name of the WinValidator.
	 * @return  name of the WinValidator.
	 */
	public String getWinConditionName();
	
	/**
	 * This method returns the description of the WinValidator.
	 * @return  description of the WinValidator.
	 */
	public String getDescription();
	
	/**
	 * This method validates the gameState.
	 * Here it is decided whether the goal of the game is reached.
	 * @param gameState  the current IGameState.
	 */
	public void validate(IGameState gameState);
	
}
