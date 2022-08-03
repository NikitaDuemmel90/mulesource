package mule.ubtmicroworld.data;

/**
 * This class holds information for the construction of a new level.
 * @author Marco Jantos
 * 
 */
public class GameDescription implements IGameDescription {

	private IMatchfield matchfield;
	private IWinValidator winValidator;
	
	public GameDescription(IMatchfield matchfield, IWinValidator winValidator) {
		this.matchfield = matchfield;
		this.winValidator = winValidator;
	}

	@Override
	public Matchfield getMatchfield() {
		return (Matchfield) matchfield;
	}

	@Override
	public IWinValidator getWinValidator() {
		return winValidator;
	}

}
