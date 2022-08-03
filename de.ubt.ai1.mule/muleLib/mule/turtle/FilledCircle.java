package mule.turtle;

import java.awt.Color;
import java.awt.geom.Ellipse2D;



public class FilledCircle {
	private Ellipse2D circle;
	private Color color;
	private double startArc;
	
	/**
	 * @return the startArc
	 */
	public double getStartArc() {
		return startArc;
	}


	public FilledCircle(Ellipse2D circle, Color color){
		this.circle = circle;
		this.color = color;
	}
	
	public FilledCircle(Ellipse2D circle, Color color, double startArc){
		this.circle = circle;
		this.color = color;
		this.startArc = startArc;
	}

	/**
	 * @return the circle
	 */
	public Ellipse2D getCircle() {
		return circle;
	}

	/**
	 * @param circle the circle to set
	 */
	public void setCircle(Ellipse2D circle) {
		this.circle = circle;
	}

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

}
