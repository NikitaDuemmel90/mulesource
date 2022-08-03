package mule.ubtmicroworld.data;

/**
 * This interface specializes the GameDescription to init a new game.
 * @author Marco Jantos
 *
 */
public interface IGameDescription {
	
	/**
	 * This method returns the matchfield to create the game with.
	 * @return  matchfield for the game.
	 */
	public Matchfield getMatchfield();
	
	/**
	 * This method returns the WinValidator for the game.
	 * @return  WinValidator.
	 */
	public IWinValidator getWinValidator();
	
	
}