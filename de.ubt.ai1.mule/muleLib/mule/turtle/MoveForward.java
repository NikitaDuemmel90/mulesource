package mule.turtle;

import java.awt.geom.Line2D;

public class MoveForward {
	private Line2D line;
	
	
	public MoveForward(){
		
	}
	
	public MoveForward(Line2D line){
		this.line = line;
	}

	/**
	 * @return the line
	 */
	public Line2D getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(Line2D line) {
		this.line = line;
	}

}
