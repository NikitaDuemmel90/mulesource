package mule.ubtmicroworld.data;

import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;

/**
 * This class is a factory for a GameDescription. 
 * @author Marco Jantos
 * 
 */
public class GameDescriptionFactory {

	/**
	 * This method generates and returns a GameDescription.
	 * @param type  The MatchfieldTempType which defines how the level should be created.
	 * @param winValidator  The WinValidator who checks whether the level has been successfully passed.
	 * @return  The generated GameDescription.
	 */
	public static GameDescription generateGameDescription(MatchfieldTempType type, IWinValidator winValidator) {
		
		Matchfield matchfield = MatchfieldFactory.generateMatchfield(type);
		
		GameDescription gameDescription = new GameDescription(matchfield, winValidator);
		
		return gameDescription;
	}
	
	/**
	 * This method generates and returns a GameDescription.
	 * @param terrainMap  A two-dimensional array that defines the TerrainMap.
	 * @param objectMap  A two-dimensional array that defines the ObjectMap.
	 * @param winValidator  The WinValidator who checks whether the level has been successfully passed.
	 * @return  The generated GameDescription.
	 */
	public static GameDescription generateGameDescription(TerrainType[][] terrainMap, ObjectType[][] objectMap, IWinValidator winValidator) {
		Matchfield matchfield = MatchfieldFactory.generateMatchfield(terrainMap, objectMap);
		
		GameDescription gameDescription = new GameDescription(matchfield, winValidator);
		
		return gameDescription;
	}
	
	/**
	 * This method generates and returns a GameDescription.
	 * @param terrainMap  A two-dimensional array that defines the TerrainMap.
	 * @param winValidator  The WinValidator who checks whether the level has been successfully passed.
	 * @return  The generated GameDescription.
	 */
	public static GameDescription generateGameDescription(TerrainType[][] terrainMap, IWinValidator winValidator) {
		Matchfield matchfield = MatchfieldFactory.generateMatchfield(terrainMap);
		
		GameDescription gameDescription = new GameDescription(matchfield, winValidator);
		
		return gameDescription;
	}
	
	/**
	 * This method generates and returns a GameDescription.
	 * @param matchfield  The matchfield for the level.
	 * @param winValidator  The WinValidator who checks whether the level has been successfully passed.
	 * @return  The generated GameDescription.
	 */
	public static GameDescription generateGameDescription(Matchfield matchfield, IWinValidator winValidator) {
		
		GameDescription gameDescription = new GameDescription(matchfield, winValidator);
		
		return gameDescription;
	}
	
	/**
	 * This method generates and returns a GameDescription.
	 * @param terrainMapPath  The path to an image from which the TerrainMap is to be created.
	 * @param winValidator  The WinValidator who checks whether the level has been successfully passed.
	 * @return  The generated GameDescription.
	 */
	public static GameDescription generateGameDescription(String terrainMapPath, IWinValidator winValidator) {

		Matchfield matchfield = MatchfieldFactory.generateMatchfield(terrainMapPath);
		
		GameDescription gameDescription = new GameDescription(matchfield, winValidator);
		
		return gameDescription;
	}
	
	/**
	 * This method generates and returns a GameDescription.
	 * @param terrainMapPath  The path to an image from which the TerrainMap is to be created.
	 * @param objectMapPath  The path to an image from which the ObjectMap is to be created.
	 * @param winValidator  The WinValidator who checks whether the level has been successfully passed.
	 * @return  The generated GameDescription.
	 */
	public static GameDescription generateGameDescription(String terrainMapPath, String objectMapPath, IWinValidator winValidator) {
		
		Matchfield matchfield = MatchfieldFactory.generateMatchfield(terrainMapPath, objectMapPath);
		
		GameDescription gameDescription = new GameDescription(matchfield, winValidator);
		
		return gameDescription;
	}
}
