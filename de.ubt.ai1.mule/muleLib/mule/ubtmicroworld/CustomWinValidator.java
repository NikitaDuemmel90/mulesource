package mule.ubtmicroworld;

import java.util.List;

import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.IWinValidator;


/**
 * This class is a custom WinValidator.
 * @author Marco Jantos, Nikita Dümmel
 *
 */
public class CustomWinValidator implements IWinValidator{
	
	private final String winConditionName = "CustomWinValidator";
	private final String description = "This is an empty win validator, \n"
			+ "please define the win conditions\ndirectly in the logic of the program."
			+ "\n\nGood Luck!";
	private Controller controller;
		
	public CustomWinValidator(Controller controller) {
		this.controller = controller;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getWinConditionName() {
		return winConditionName;
	}


	@Override
	public void validate(IGameState gameState) {}
}
