package mule.turtle;

public class State {

	private double x;
	private double y;
	private double direction;
	
	public State(){
		this.x = 0;
		this.y = 0;
		this.direction = 0;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param d the x to set
	 */
	public void setX(double d) {
		this.x = d;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param d the y to set
	 */
	public void setY(double d) {
		this.y = d;
	}

	/**
	 * @return the direction
	 */
	public double getDirection() {
		return direction;
	}
	
	/**
	 * @param d the direction to set
	 */
	public void setDirection(double d) {
		this.direction = ((d % 360)) % 360;
	}
	
}
