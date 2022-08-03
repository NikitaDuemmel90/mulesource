package mule.turtle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;


public class TurtleImpl implements Turtle{
	

	private State state;
	private TurtlePanel tp;
	private boolean penDown;
	TurtleFrame turtleFrame;
	private boolean processingPath = false;
	FilledPolygon polygon;
	private boolean animate = true;
	
	public TurtleImpl(){

		state = new State();
		state.setDirection(0);
		penDown = true;
		turtleFrame = new TurtleFrame(600, 400);
		tp = new TurtlePanel();
		tp.ti = this;
		setPosition(300, 200);
		turtleFrame.setSize(617, 440);
		turtleFrame.add(tp);
		turtleFrame.setVisible(true);
	}
	
	/**
	 * @return the tp
	 */
	public TurtlePanel getTp() {
		return tp;
	}

	public void setFrameSize(int width, int height){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		turtleFrame.setBounds(d.width/2 - width/2, d.height/2 - height/2, width, height);
		turtleFrame.setSize(width+17, height+40);
	}
	
	
	public void forward(double i) {

		double arc = state.getDirection();
		Line2D line;
		if(!processingPath){
			line = new Line2D.Double(state.getX(), state.getY(), state.getX()+ (Math.sin(Math.toRadians(arc))*i), state.getY()- (Math.cos(Math.toRadians(arc))*i));
			
			if(animate){
				if(penDown){
					tp.setAnimationObject(line);
					tp.startAnimation();
				}
				else{
					tp.setAnimationObject(new MoveForward(line));
					tp.startAnimation();
				}
			}
			else{
					if(penDown){
						tp.addShape(line);
					}
									
			}
			
		}
		
		
		state.setX(state.getX()+ (Math.sin(Math.toRadians(arc))*i));
		state.setY(state.getY()- (Math.cos(Math.toRadians(arc))*i));
		
		tp.moveTurtle(state.getX(), state.getY(), Math.toRadians(state.getDirection()));

		if(processingPath){
			polygon.addPoint(state.getX(), state.getY());
			polygon.addAngle(state.getDirection());
		}
		
		tp.repaint();	

	}

	public void backward(double i) {
		
		if(!processingPath){
		double arc = state.getDirection();
		
		BackLine backLine = new BackLine();
		backLine.setLine(new Line2D.Double(state.getX(), state.getY(), state.getX()- (Math.sin(Math.toRadians(arc))*i), state.getY()+ (Math.cos(Math.toRadians(arc))*i)));
		
		if(!processingPath){
			if(animate){
				if(penDown){
					tp.setAnimationObject(backLine);
					tp.startAnimation();
				}
				else{
					tp.setAnimationObject(backLine);
					tp.startAnimation();
				}
				
			}
			else{
				if(penDown){
					tp.addShape(backLine);
				}
				
			}
			state.setX(state.getX()- (Math.sin(Math.toRadians(arc))*i));
			state.setY(state.getY()+ (Math.cos(Math.toRadians(arc))*i));
			
			tp.moveTurtle(state.getX(), state.getY(), Math.toRadians(state.getDirection()));
		}
		
		tp.repaint();
		}
	}

	public void right(double degree) {
		state.setDirection(state.getDirection() + degree);
		State setState = new State();
		setState.setDirection(Math.toRadians(state.getDirection()));
		setState.setX(state.getX());
		setState.setY(state.getY());
		tp.setCurrentTurtleState(setState);
		tp.repaint();

	}
	
	public void left(double degree){

		double tempDegree = state.getDirection() -degree;
		if(tempDegree >= 0){
			state.setDirection(state.getDirection() - degree);
		}
		else{
			state.setDirection((tempDegree % 360) + 360);
		}
		State setState = new State();
		setState.setDirection(Math.toRadians(state.getDirection()));
		setState.setX(state.getX());
		setState.setY(state.getY());
		tp.setCurrentTurtleState(setState);

		tp.repaint();
	}
	
	
	public void penUp() {
		penDown = false;
		PenState penState = new PenState();
		penState.setPenDown(false);
		if(animate){
			tp.setAnimationObject(penState);
			tp.startAnimation();
		}
		else{
			tp.addShape(penState);
		}
		
	}

	public void penDown() {
		penDown = true;
		PenState penState = new PenState();
		penState.setPenDown(true);
		if(animate){
			tp.setAnimationObject(penState);
			tp.startAnimation();
		}
		else{
			tp.addShape(penState);
		}
	}

	public void setColor(Colors colors) {
		Color color = transformColor(colors);
		if(animate){
			tp.setAnimationObject(color);
			tp.startAnimation();
		}
		else{
			tp.addShape(color);
		}
		
		tp.repaint();
		}
	
	public void setColorRGB(int r, int g, int b){
		Color color = new Color(r,g,b);
		if(animate){
			tp.setAnimationObject(color);
			tp.startAnimation();
		}
		else{
			tp.addShape(color);
		}
		
		tp.repaint();
	}


	public void setThickness(int i) {
		if(animate){
			tp.setAnimationObject(i);
			tp.startAnimation();
		}
		else{
			tp.addShape(i);
		}
		
		tp.repaint();
	}




	public State getState() {
		return state;
		
	}


	public void setPosition(double x, double y) {
		if(!processingPath){
		state.setX(x);
		state.setY(y);

		tp.getCurrentTurtleState().setX(state.getX());
		tp.getCurrentTurtleState().setY(state.getY());
		tp.repaint();
		}
	}


	public void setOrientation(Orientation o) {
		switch(o){
		case NORTH:
			state.setDirection(0);
			break;
			
		case SOUTH:
			state.setDirection(180);
			break;
			
		case EAST:
			state.setDirection(90);
			break;
			
		case WEST:
			state.setDirection(270);
			break;
		}
		State setState = new State();
		setState.setDirection(Math.toRadians(state.getDirection()));
		setState.setX(state.getX());
		setState.setY(state.getY());
		tp.setCurrentTurtleState(setState);
		tp.repaint();
	}

	public void startFilledPolygon(Colors colors) {
		Color color = transformColor(colors);
		processingPath = true;
		polygon = new FilledPolygon();
		
		polygon.addPoint(state.getX(), state.getY());

		polygon.setColor(color);
		tp.setPolygonFillColor(color);
		tp.repaint();
	}
	
	public void startFilledPolygonRGB(int r, int g, int b){
		Color color = new Color(r, g, b);
		processingPath = true;
		polygon = new FilledPolygon();
		
		polygon.addPoint(state.getX(), state.getY());

		polygon.setColor(color);
		tp.setPolygonFillColor(color);
		tp.repaint();
	}
	
	public void endFilledPolygon(){
		polygon.addAngle(state.getDirection());
		
		processingPath = false;
		if(animate){
			tp.setAnimationObject(polygon);
			tp.startAnimation();
		}
		else{
			tp.addShape(polygon);
		}
		
		polygon = null;
		tp.repaint();
	}

	public Color transformColor(Colors color){
		switch(color){
		case BLACK:
			return Color.BLACK;
			
			
		case WHITE:
			return Color.WHITE;
		
			
		case RED:
			return Color.RED;
			
			
		case GREEN:
			return Color.GREEN;
			
			
		case BLUE:
			return Color.BLUE;
		
			
		case YELLOW:
			return Color.YELLOW;
			
			
		case MAGENTA:
			return Color.MAGENTA;
		
			
		case CYAN:
			return Color.CYAN;
	
			
		case PINK:
			return Color.PINK;
		
			
		case ORANGE:
			return Color.ORANGE;
		
		case LIGHT_GRAY:
			return Color.LIGHT_GRAY;
		
			
		case DARK_GRAY:
			return Color.DARK_GRAY;
	
		default:
			return null;
			
		}
		
	}

	public void circle(double radius) {
		if(!processingPath){
		double x = state.getX() + radius*Math.sin(Math.toRadians(state.getDirection()));
		double y = state.getY() - radius*Math.cos(Math.toRadians(state.getDirection()));

		Ellipse2D circle = new Ellipse2D.Double(x-radius, y-radius , 2*radius, 2*radius);
		if(animate){
			Circle animateCircle = new Circle();
			animateCircle.setCircle(circle);
			animateCircle.setStartArc(Math.toRadians(state.getDirection()));

			tp.setAnimationObject(animateCircle);
			tp.startAnimation();
		}
		else{
			tp.addShape(circle);
		}
		
		tp.repaint();
		}
	}

	public void filledCircle(double radius, Colors colors) {
		Color color = transformColor(colors);
		if(!processingPath){
		double x = state.getX() + radius*Math.sin(Math.toRadians(state.getDirection()));
		double y = state.getY() - radius*Math.cos(Math.toRadians(state.getDirection()));
		
		
		
		Ellipse2D circle = new Ellipse2D.Double(x-radius, y-radius , 2*radius, 2*radius);
		if(animate){
			
			tp.setAnimationObject(new FilledCircle(circle, color, Math.toRadians(state.getDirection())));
			tp.startAnimation();
		}
		else{
			tp.addShape(new FilledCircle(circle, color));
		}
		
		tp.repaint();
		}
	}

	public void filledCircleRGB(double radius, int r, int g, int b){
		Color color = new Color(r,g,b);
		if(!processingPath){
			double x = state.getX() + radius*Math.sin(Math.toRadians(state.getDirection()));
			double y = state.getY() - radius*Math.cos(Math.toRadians(state.getDirection()));
			
			
			
			Ellipse2D circle = new Ellipse2D.Double(x-radius, y-radius , 2*radius, 2*radius);
			if(animate){
				
				tp.setAnimationObject(new FilledCircle(circle, color, Math.toRadians(state.getDirection())));
				tp.startAnimation();
			}
			else{
				tp.addShape(new FilledCircle(circle, color));
			}
			
			tp.repaint();
			}
	}
	
	public void setAnimationSpeed(Speed speed){
		startAnimation(speed);
	}
	
	public void startAnimation(Speed speed) {
		animate = true;

		switch(speed){
		case SLOW:
			tp.setAnimationSpeed(10);
			break;
			
		case MEDIUM:
			tp.setAnimationSpeed(5);
			break;
			
		case FAST:
			tp.setAnimationSpeed(3);
			break;
		
		case INSTANT:
			t.stopAnimation();
		}
		
	}
	
	public void stopAnimation(){
		animate=false;
	}
	
	public void showCoordinateSystem(boolean bool){
		tp.setCoordinateSystem(bool);
	}

	public void showCursor(boolean boo) {
		if(animate){
			tp.setAnimationObject(boo);
			tp.startAnimation();
			}
		else{
			tp.addShape(boo);
		}
		
		tp.repaint();
	}
	
	public void moveTo(double x, double y){
		double xStart = state.getX();
		double yStart = state.getY();
		
		double xLine = x-xStart;
		double yLine = y-yStart;
		
		double length = Math.sqrt(Math.pow(xLine, 2)+Math.pow(yLine, 2));
		
		double co = (-yLine)/length;
		double arc;
		if(xLine > 0){
		
			arc = Math.toDegrees(Math.acos(co));
		}
		else{
		
			arc = 360 - Math.toDegrees(Math.acos(co));
		}
	
		setDirection(arc);
		
		Line2D line = new Line2D.Double();
		line.setLine(state.getX(), state.getY(), x, y);
		if(!processingPath){
			if(animate){
				if(penDown){
					tp.setAnimationObject(line);
					tp.startAnimation();
				}
				else{
					tp.setAnimationObject(new MoveForward(line));
					tp.startAnimation();
				}
			}
			else{
					if(penDown){
						tp.addShape(line);
					}
									
			}
		}
		
		state.setX(x);
		state.setY(y);
		
		tp.moveTurtle(state.getX(), state.getY(), Math.toRadians(state.getDirection()));		
		if(processingPath){
			polygon.addPoint(state.getX(), state.getY());
			polygon.addAngle(state.getDirection());
		}

		tp.repaint();
	}
	
	public void scaleCoordinateSystem(int x, int y){
		tp.setCoordinateScale(x, y);
	}
	
	public void setBackgroundColor(Colors colors){
		Color color = transformColor(colors);
		tp.setBackground(color);
	}

	public void setDirection(double arc){

		state.setDirection(arc);
		
		State setState = new State();
		setState.setDirection(Math.toRadians(state.getDirection()));
		setState.setX(state.getX());
		setState.setY(state.getY());
		tp.setCurrentTurtleState(setState);
		tp.repaint();
	}
	public void activateKeyboardMode(Speed speed) {
		
		switch(speed){
		case SLOW:
			new KeyboardMode(1);
			break;
			
		case MEDIUM:
			new KeyboardMode(2);
			break;
			
		case FAST:
			new KeyboardMode(4);
			break;
		}
		
	}

	public void setBackgroundColorRGB(int r, int g, int b) {
		Color color = new Color(r,g,b);
		tp.setBackground(color);
		
	}


	



}
