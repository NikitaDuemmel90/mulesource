package mule.ubtmicroworld.gui;

import mule.ubtmicroworld.UBTMicroworld.LineOfSight;

/**
 * This class holds the current information for the replay.
 * @author Marco Jantos
 * 
 */
public class ReplayPathData {

	private LineOfSight lineOfSight;
	private int x;
	private int y;
	
	public ReplayPathData(LineOfSight lineOfSight, int x, int y) {
		this.lineOfSight = lineOfSight;
		this.x = x;
		this.y = y;
	}
	
	public LineOfSight getLineOfSight() {
		return lineOfSight;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
