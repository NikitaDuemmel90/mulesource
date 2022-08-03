package mule.ubtmicroworld;

import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.IWinValidator;
import mule.ubtmicroworld.data.Matchfield;

public class WinValidator2 implements IWinValidator{
	
	private final String winConditionName = "WinValidator2";
	
	private final String description = "To win the level the agents must gather all of the object."
	+ "\n\nGood Luck!";
	
	private Controller controller;
	
	public WinValidator2(Controller controller) {
		this.controller = controller;
	}

	@Override
	public String getWinConditionName() {
		return winConditionName;
	}

	@Override
	public void validate(IGameState gameState) {
		
		boolean isReached = false;
		
		Matchfield matchfield = (Matchfield) gameState.getMatchfield();
		int dimension = matchfield.getDimension();
		
		for(int y = 0; y < dimension; y++) {
			for(int x = 0; x < dimension; x++) {
				
				if(matchfield.getTile(x, y).isObjectOnTile()) {
					return;
					//isReached = false;
				}
			}
		}
		
		isReached = true;
		
		if(isReached) {
			controller.setGameFinished();
		}

		
	}

	@Override
	public String getDescription() {
		return description;
	}

	
}
