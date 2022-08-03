package mule.turtle;

import java.awt.geom.Ellipse2D;

public class Circle {
	private Ellipse2D circle;
	private double startArc;
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
	 * @return the startArc
	 */
	public double getStartArc() {
		return startArc;
	}
	/**
	 * @param startArc the startArc to set
	 */
	public void setStartArc(double startArc) {
		this.startArc = startArc;
	}

}
