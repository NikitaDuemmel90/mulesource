package mule.ubtmicroworld.data;

import mule.ubtmicroworld.UBTMicroworld.TerrainType;

/**
 * This class holds arithmetic rules.
 * @author Marco Jantos
 * 
 */
public class Terrain {
	
	/**
	 * This method returns the TerrainType fitting to an integer value.
	 * < 0 - GRAS 
	 * 0 - START
	 * 1 - TARGET
	 * 2 - GRAS
	 * 3 - STONE
	 * 4 - SNOW
	 * 5 - PATH
	 * 6 - WATER
	 * 7 - SAND
	 * > 0 - GRAS 
	 * @param terrain  The integer value.
	 * @return  The TerrainType.
	 */
	public static TerrainType intToTerrainType(int terrain) {
		switch(terrain) {
		case 0:
			return TerrainType.START;
		case 1:
			return TerrainType.TARGET;
		case 2:
			return TerrainType.GRASS;
		case 3:
			return TerrainType.STONE;
		case 4:
			return TerrainType.SNOW;
		case 5:
			return TerrainType.PATH;
		case 6:
			return TerrainType.WATER;
		case 7:
			return TerrainType.SAND;
		default:
			return TerrainType.GRASS;
			
		}
	}
}
