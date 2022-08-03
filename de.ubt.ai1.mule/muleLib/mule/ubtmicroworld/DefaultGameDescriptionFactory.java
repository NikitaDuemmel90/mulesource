package mule.ubtmicroworld;

import mule.ubtmicroworld.UBTMicroworld.DefaultLevelType;
import mule.ubtmicroworld.data.GameDescription;
import mule.ubtmicroworld.data.GameDescriptionFactory;
import mule.ubtmicroworld.data.IWinValidator;
import mule.ubtmicroworld.data.MatchfieldTempType;

/**
 * This class can be used as a factory for a new GameDescription.
 * @author Marco Jantos
 * @version 26.04.2020
 */
public class DefaultGameDescriptionFactory {

	/**
	 * This method generates a new GameDescription.
	 * @param type  The DefaultLevelType.
	 * @param controller  An instance of the upper class Controller.
	 * @return GameDescription  The new GameDescription
	 */
	public static GameDescription generateDefaultLevel(DefaultLevelType type, Controller controller) {
		
		switch(type) {
		case DEFAULT_LEVEL_0:
			return generateDefaultLevel0(controller);
		case DEFAULT_LEVEL_1:
			return generateDefaultLevel1(controller);
		case DEFAULT_LEVEL_2:
			return generateDefaultLevel2(controller);
		case DEFAULT_LEVEL_3:
			return generateDefaultLevel3(controller);
		case DEFAULT_LEVEL_4:
			return generateDefaultLevel4(controller);
		case DEFAULT_LEVEL_5:
			return generateDefaultLevel5(controller);
		case DEFAULT_LEVEL_6:
			return generateDefaultLevel6(controller);
		case DEFAULT_LEVEL_7:
			return generateDefaultLevel7(controller);
		case DEFAULT_LEVEL_8:
			return generateDefaultLevel8(controller);
		case DEFAULT_LEVEL_9:
			return generateDefaultLevel9(controller);
		case DEFAULT_LEVEL_10:
			return generateDefaultLevel10(controller);
		case DEFAULT_LEVEL_11:
			return generateDefaultLevel11(controller);
		case DEFAULT_LEVEL_12:
			return generateDefaultLevel12(controller);
		case DEFAULT_LEVEL_13:
			return generateDefaultLevel13(controller);
		case DEFAULT_LEVEL_14:
			return generateDefaultLevel14(controller);
		case DEFAULT_LEVEL_15:
			return generateDefaultLevel15(controller);
		case DEFAULT_LEVEL_16:
			return generateDefaultLevel16(controller);
		default:
			return generateDefaultLevel0(controller);
		
		}
		
	}
	
	private static GameDescription generateDefaultGameDescription(MatchfieldTempType type, IWinValidator winValidator) {
		
		return GameDescriptionFactory.generateGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel0(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL0;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel1(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL1;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel2(Controller controller) {
			
		MatchfieldTempType type = MatchfieldTempType.LEVEL2;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel3(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL3;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel4(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL4;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel5(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL5;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel6(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL6;
		IWinValidator winValidator = new WinValidator2(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel7(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL7;
		IWinValidator winValidator = new WinValidator2(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel8(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL8;
		IWinValidator winValidator = new WinValidator3(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel9(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL9;
		IWinValidator winValidator = new WinValidator3(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
	private static GameDescription generateDefaultLevel10(Controller controller) {
		
		MatchfieldTempType type = MatchfieldTempType.LEVEL10;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}

	private static GameDescription generateDefaultLevel11(Controller controller) {
	
		MatchfieldTempType type = MatchfieldTempType.LEVEL11;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}

	private static GameDescription generateDefaultLevel12(Controller controller) {
	
		MatchfieldTempType type = MatchfieldTempType.LEVEL12;
		IWinValidator winValidator = new WinValidator3(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}

	private static GameDescription generateDefaultLevel13(Controller controller) {
	
		MatchfieldTempType type = MatchfieldTempType.LEVEL13;
		IWinValidator winValidator = new WinValidator1(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}

	private static GameDescription generateDefaultLevel14(Controller controller) {
	
		MatchfieldTempType type = MatchfieldTempType.LEVEL14;
		IWinValidator winValidator = new WinValidator3(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}

	private static GameDescription generateDefaultLevel15(Controller controller) {
	
		MatchfieldTempType type = MatchfieldTempType.LEVEL15;
		IWinValidator winValidator = new WinValidator3(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}

	private static GameDescription generateDefaultLevel16(Controller controller) {
	
		MatchfieldTempType type = MatchfieldTempType.LEVEL16;
		IWinValidator winValidator = new WinValidator2(controller);
		
		return generateDefaultGameDescription(type, winValidator);
	}
	
}
