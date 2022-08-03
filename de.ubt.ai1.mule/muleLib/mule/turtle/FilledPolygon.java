package mule.turtle;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public class FilledPolygon {
	private Color color;
	private Polygon polygon;
	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Double> angles = new ArrayList<Double>();
	
	
	
	public void setPoint(int index, Point point){
		points.set(index, point);
		polygon.addPoint(point.x, point.y);
	}
	public void addAngle(double angle){
		angles.add(angle);
	}
	public void addnullAngle(){
		angles.add(null);
	}
	
	/**
	 * @return the arcs
	 */
	public ArrayList<Double> getAngles() {
		return angles;
	}



	public FilledPolygon(){
		polygon = new Polygon();
		
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
	/**
	 * @return the polygon
	 */
	public Polygon getPolygon() {
		return polygon;
	}

	/**
	 * @return the points
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}

	
	public void addPoint(double x, double y){
		Point point = new Point();
		point.setLocation(x, y);
		polygon.addPoint((int)Math.round(x), (int)Math.round(y));
		points.add(point);
	}
	public void addNull(){
		points.add(null);
	}

}
