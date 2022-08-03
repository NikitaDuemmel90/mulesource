package mule.ubtmicroworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mule.ubtmicroworld.data.GameDescription;
import mule.ubtmicroworld.data.GameDescriptionFactory;
import mule.ubtmicroworld.data.IAgent;
import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.IMatchfield;
import mule.ubtmicroworld.data.ITile;
import mule.ubtmicroworld.data.IWinValidator;
import mule.util.MuLEReferenceType;

/**
 * This class is the main Interface for the UBTMicroworld library in MuLE.
 * 
 * @author Marco Jantos, Nikita Dümmel
 * 
 */
public class UBTMicroworld {
	static Controller c = new Controller();

	public static abstract class Agent implements IAgent {
		public int getNumberOfCollectedObjects() {
			return getCollectedObjects().size();
		}
	}

	public static enum DefaultLevelType {
		DEFAULT_LEVEL_0, DEFAULT_LEVEL_1, DEFAULT_LEVEL_2, DEFAULT_LEVEL_3, DEFAULT_LEVEL_4, DEFAULT_LEVEL_5,
		DEFAULT_LEVEL_6, DEFAULT_LEVEL_7, DEFAULT_LEVEL_8, DEFAULT_LEVEL_9, DEFAULT_LEVEL_10, DEFAULT_LEVEL_11,
		DEFAULT_LEVEL_12, DEFAULT_LEVEL_13, DEFAULT_LEVEL_14, DEFAULT_LEVEL_15, DEFAULT_LEVEL_16
	}

	public static enum TerrainType {
		GRASS(true), SAND(true), PATH(true), SNOW(true),

		STONE(false), WATER(false),

		TARGET(true), START(true),;

		private boolean isWalkable;

		TerrainType(boolean isWalkable) {
			this.isWalkable = isWalkable;
		}

		public boolean isWalkable() {
			return isWalkable;
		}
	}

	public static enum DelayTime {
		NO_DELAY, SHORT_DELAY, MEDIUM_DELAY, LONG_DELAY
	}

	public static enum MoveDirection {
		FORWARD, BACK, RIGHT, LEFT, NONE, INVALID, FORWARD_INVALID, BACK_INVALID
	}

	public static enum LineOfSight {
		NORTH, EAST, SOUTH, WEST
	}

	public static enum ObjectType {
		NO_OBJECT, KEY
	}

	public static enum WinValidatorType {
		VALIDATOR_1, VALIDATOR_2, VALIDATOR_3, CUSTOM
	}

	public static void initDefaultGame(DefaultLevelType defaultLevel0) {
		if (isGameRunning())
			System.out.println("A game is already running, please close it first.");
		else
			c.initDefaultGame(defaultLevel0);
	}

	public static void initCustomGame1(ArrayList<ArrayList<TerrainType>> terrain, WinValidatorType validator) {
		int size = terrain.size();
		if (size < 5 || size > 32) {
			System.out.println("Invalid terrain map size. The terrain map must be between 5x5 and 32x32.");
		} else if (isGameRunning()) {
			System.out.println("A game is already running, please close it first.");
		} else {
			IWinValidator winValidator = new CustomWinValidator(c);
			switch (validator) {
				case VALIDATOR_1: {
					winValidator = new WinValidator1(c); break;
				}
				case VALIDATOR_2: {
					winValidator = new WinValidator2(c); break;
				}
				case VALIDATOR_3: {
					winValidator = new WinValidator3(c); break;
				}
				case CUSTOM: {
					winValidator = new CustomWinValidator(c); break;
				}
			}
			TerrainType[][] terrainMap = new TerrainType[size][size];
			for (int i = 0; i < terrain.size(); i++) {
				for (int j = 0; j < terrain.size(); j++) {
					terrainMap[i][j] = terrain.get(i).get(j);
				}
			}
			GameDescription gameDescription = GameDescriptionFactory.generateGameDescription(terrainMap, winValidator);
			c.initGame(gameDescription);
		}
	}

	public static void initCustomGame2(ArrayList<ArrayList<TerrainType>> terrain,
			ArrayList<ArrayList<ObjectType>> objects, WinValidatorType validator) {
		int size = terrain.size();
		if (size < 5 || size > 32) {
			System.out.println("Invalid terrain map size. The terrain map must be between 5x5 and 32x32.");
		} else if (objects.size() != size) {
			System.out.println("Invalid object map size. The object map have same dimensions as the terrain map.");
		} else if (isGameRunning()) {
			System.out.println("A game is already running, please close it first.");
		} else {
			IWinValidator winValidator = new CustomWinValidator(c);
			switch (validator) {
				case VALIDATOR_1: {
					winValidator = new WinValidator1(c); break;
				}
				case VALIDATOR_2: {
					winValidator = new WinValidator2(c); break;
				}
				case VALIDATOR_3: {
					winValidator = new WinValidator3(c); break;
				}
				case CUSTOM: {
					winValidator = new CustomWinValidator(c); break;
				}
			}
			TerrainType[][] terrainMap = new TerrainType[size][size];
			ObjectType[][] objectMap = new ObjectType[size][size];
			for (int i = 0; i < terrain.size(); i++) {
				for (int j = 0; j < terrain.size(); j++) {
					terrainMap[i][j] = terrain.get(i).get(j);
					objectMap[i][j] = objects.get(i).get(j);
				}
			}
			GameDescription gameDescription = GameDescriptionFactory.generateGameDescription(terrainMap, objectMap, winValidator);
			c.initGame(gameDescription);
		}
	}
	
	public static void initCustomGame3(String terrainMapPath, WinValidatorType validator) {
		IWinValidator winValidator = new CustomWinValidator(c);
		switch (validator) {
			case VALIDATOR_1: {
				winValidator = new WinValidator1(c); break;
			}
			case VALIDATOR_2: {
				winValidator = new WinValidator2(c); break;
			}
			case VALIDATOR_3: {
				winValidator = new WinValidator3(c); break;
			}
			case CUSTOM: {
				winValidator = new CustomWinValidator(c); break;
			}
		}
		GameDescription gameDescription = GameDescriptionFactory.generateGameDescription(terrainMapPath,  winValidator);
		c.initGame(gameDescription);
	}
	
	public static void initCustomGame4(String terrainMapPath, String objectsMapPath, WinValidatorType validator) {
		IWinValidator winValidator = new CustomWinValidator(c);
		switch (validator) {
			case VALIDATOR_1: {
				winValidator = new WinValidator1(c); break;
			}
			case VALIDATOR_2: {
				winValidator = new WinValidator2(c); break;
			}
			case VALIDATOR_3: {
				winValidator = new WinValidator3(c); break;
			}
			case CUSTOM: {
				winValidator = new CustomWinValidator(c); break;
			}
		}
		GameDescription gameDescription = GameDescriptionFactory.generateGameDescription(terrainMapPath, objectsMapPath,  winValidator);
		c.initGame(gameDescription);
	}

	public static List<MuLEReferenceType<? extends Agent>> getAgentList() {
		List<Agent> origList = c.getAgentList();
		List<MuLEReferenceType<? extends Agent>> newList = new ArrayList<MuLEReferenceType<? extends Agent>>();
		for (Agent a : origList) {
			newList.add(new MuLEReferenceType<Agent>(a));
		}
		return newList;
	}

	public static void setDelayTime(DelayTime delayTime) {
		c.setDelayTime(delayTime);
	}

	public static void registerAgentForKeyListener(MuLEReferenceType<? extends Agent> agent) {
		c.registerAgentForKeyListener(agent.value);
	}

	public static boolean isGameRunning() {
		return c.isGameRunning();
	}

	public static void setGameOver() {
		c.setGameOver();
	}

	public static void setGameFinished() {
		c.setGameFinished();
	}

	public static ArrayList<ArrayList<String>> getNavMap() {
		IMatchfield mf = c.getMatchfield();
		int dim = mf.getDimension();
		String[][] navMapArray = new String[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (mf.isTileWalkable(j, i)) {
					navMapArray[i][j] = "[ ]";
				} else {
					navMapArray[i][j] = "[X]";
				}
			}
		}

		for (ITile tile : mf.getStartTiles()) {
			navMapArray[tile.getYPos()][tile.getXPos()] = "[S]";
		}
		for (ITile tile : mf.getTargetTiles()) {
			navMapArray[tile.getYPos()][tile.getXPos()] = "[F]";
		}

		ArrayList<ArrayList<String>> navMap = new ArrayList<ArrayList<String>>();
		for (String[] line : navMapArray) {
			ArrayList<String> listLine = new ArrayList<String>(Arrays.asList(line));
			navMap.add(listLine);
		}
		return navMap;
	}
	
	public static TerrainType getTerrainType(int x, int y) {
		return c.getMatchfield().getTerrainType(x, y);
	}
}
