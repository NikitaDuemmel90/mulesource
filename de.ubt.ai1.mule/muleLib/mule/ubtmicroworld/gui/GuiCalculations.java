package mule.ubtmicroworld.gui;

import mule.ubtmicroworld.UBTMicroworld.LineOfSight;

/**
 * This class holds methods for the GUI.
 * @author Marco Jantos
 * 
 */
public class GuiCalculations {
	
	private final static int tileSize = 64;

	public static int lineOfSightToDeg(LineOfSight lineOfSight) {
		switch(lineOfSight) {
		case NORTH:
			return 0;
		case EAST:
			return 90;
		case SOUTH:
			return 180;
		case WEST:
			return 270;
		default:
			return 0;
		
		}
	}
	
	public final static int getTileSize() {
		return tileSize;
	}
}
