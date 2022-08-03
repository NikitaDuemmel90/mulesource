package mule.turtle;

import java.awt.Color;
import java.awt.geom.Arc2D;

public class FilledArc {
	private Color color;
	private Arc2D arc;
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * @return the arc
	 */
	public Arc2D getArc() {
		return arc;
	}
	/**
	 * @param arc the arc to set
	 */
	public void setArc(Arc2D arc) {
		this.arc = arc;
	}

}
