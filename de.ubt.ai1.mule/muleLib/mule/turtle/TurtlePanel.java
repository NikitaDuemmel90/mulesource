package mule.turtle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class TurtlePanel extends JPanel implements Runnable{
	
	private ArrayList<Object> commands = new ArrayList<Object>();
	private Object animationObject;

	private int currentThickness;
	private boolean penDown = true;
	private Color fillColor;
	private Color tempColor;
	private Color currentColor = Color.BLACK;
	public TurtleImpl ti;
	BufferedImage coordinateSystemImage;


	Thread th;
	private int animationSpeed;
	private State currentTurtleState = new State();
	private int coordinateScaleX = 10;
	private int coordinateScaleY = 10;
	private boolean coordinateSystem = false;
	
	
	/**
	 * @param cursor the cursor to set
	 */
//	public void setCursor(boolean cursor) {
//		this.cursor = cursor;
//	}


	double offsetX = 0;
	double offsetY = 0;
	
	public TurtlePanel (){
		super();
		currentThickness = 1;
		animationSpeed = 5;
		this.setBackground(Color.WHITE);
		coordinateSystemImage = createCoordinateSystem();
		commands.add(null);
		currentTurtleState.setDirection(Math.toRadians(0));
		this.setFocusable(true);
		this.setVisible(true);
	}

	/**
	 * @return the coordinateSystem
	 */
	public boolean isCoordinateSystem() {
		return coordinateSystem;
	}


	/**
	 * @param coordinateSystem the coordinateSystem to set
	 */
	public void setCoordinateSystem(boolean coordinateSystem) {
		this.coordinateSystem = coordinateSystem;
	}

	public void setCoordinateScale(int x, int y){
		coordinateScaleX = x;
		coordinateScaleY = y;
		coordinateSystemImage = createCoordinateSystem();
	}

	private BufferedImage createCoordinateSystem() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage coordinateSystem = new BufferedImage((int)d.getWidth(), (int)d.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D gCoordinateSystem = (Graphics2D) coordinateSystem.getGraphics();
		gCoordinateSystem.setColor(Color.LIGHT_GRAY);
		for(int i = 0; i<d.getHeight(); i += coordinateScaleX){
			if(i%50 == 0){
				gCoordinateSystem.setColor(Color.DARK_GRAY);
				Line2D xLine = new Line2D.Double();
				xLine.setLine(0, i, d.getWidth(), i);
				gCoordinateSystem.draw(xLine);
				gCoordinateSystem.drawString(String.valueOf(i), 4, i+5);
				gCoordinateSystem.setColor(Color.LIGHT_GRAY);
			}
			else{
				Line2D xLine = new Line2D.Double();
				xLine.setLine(0, i, d.getWidth(), i);
				gCoordinateSystem.draw(xLine);
			}
			
		}
		for(int i = 0; i<d.getWidth(); i+=coordinateScaleY){
			
			if(i%50 == 0){
				gCoordinateSystem.setColor(Color.DARK_GRAY);
				Line2D yLine = new Line2D.Double();
				yLine.setLine(i, 0, i, d.getHeight());
				gCoordinateSystem.draw(yLine);
				if(i<100){
					gCoordinateSystem.drawString(String.valueOf(i), i-6, 12);
				}
				else{
					gCoordinateSystem.drawString(String.valueOf(i), i-10, 12);
				}
				
				gCoordinateSystem.setColor(Color.LIGHT_GRAY);
			}
			else{
				Line2D yLine = new Line2D.Double();
				yLine.setLine(i, 0, i, d.getHeight());
				gCoordinateSystem.draw(yLine);
			}
			
		}
		return coordinateSystem;
	}





	public void paintComponent(Graphics g){
		super.paintComponent(g);
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2 = (Graphics2D) g;
		boolean cursor = true;
		
		Graphics2D gDraw = image.createGraphics();
		gDraw.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gDraw.setColor(Color.BLACK);
		synchronized (commands){
			for(Object sh: commands){
				
				if (sh instanceof Color){
					gDraw.setColor((Color) sh);
					currentColor = (Color) sh;
				}
				else if(sh instanceof Line2D){
					gDraw.draw((Line2D)sh);

				}
				
				else if(sh instanceof BackLine){
					BackLine backLine = (BackLine) sh;
					gDraw.draw(backLine.getLine());
				}

				else if(sh instanceof FilledPolygon){
					FilledPolygon polygon = (FilledPolygon) sh;
					
					currentColor = gDraw.getColor();
					gDraw.setColor(polygon.getColor());
					gDraw.fillPolygon(polygon.getPolygon());
					
					gDraw.setColor(currentColor);
					gDraw.draw(polygon.getPolygon());
				}
				
				else if (sh instanceof Integer){
					currentThickness = (int) sh;
					gDraw.setStroke(new BasicStroke((Integer) sh));
				}
				else if (sh instanceof Ellipse2D){
					gDraw.draw((Ellipse2D) sh);
				}
				else if(sh instanceof PenState){
					PenState penState = (PenState) sh;
					if (penState.isPenDown()){
						penDown = true;
					}
					else {
						penDown = false;
					}
				}
				
				else if (sh instanceof FilledCircle){
				
					tempColor = currentColor;
					currentColor = gDraw.getColor();
					
					gDraw.setColor(((FilledCircle) sh).getColor());
					gDraw.fill(((FilledCircle) sh).getCircle());
					gDraw.setColor(currentColor);
					gDraw.draw(((FilledCircle) sh).getCircle());
					gDraw.setColor(tempColor);
				}
				else if (sh instanceof Arc2D){
					Arc2D arc = (Arc2D) sh;
					gDraw.draw(arc);
				}
				
				
				
				else if (sh instanceof FilledArc){
					FilledArc filledArc = (FilledArc) sh;
					Arc2D arc = filledArc.getArc();
					Color color = filledArc.getColor();
					
					currentColor = gDraw.getColor();
					gDraw.setColor(color);
					gDraw.fill(arc);
					gDraw.setColor(currentColor);
					gDraw.draw(arc);
					gDraw.setColor(currentColor);
					
				}
				
				else if (sh instanceof Boolean){
					cursor = (boolean) sh;
				}
				
				else if (sh instanceof Shape){
					gDraw.draw((Shape)sh);
				}
				
				
			}
		}
		
		if(cursor){
			drawTurtleArrow(gDraw);
		}
		
		if(coordinateSystem){
			g2.drawImage(coordinateSystemImage, null, 0 ,0);
		}
		
		
		g2.drawImage(image, null, 0, 0);
		
		
	}
	
	private void drawTurtleArrow(Graphics2D gDraw) {
		double turtleX = currentTurtleState.getX();
		double turtleY = currentTurtleState.getY();
		double turtleArc = currentTurtleState.getDirection();
		AffineTransform at = new AffineTransform();
		
		Polygon arrow = new Polygon();
		
		arrow.addPoint(-5, 0);
		arrow.addPoint(0, -15);
		arrow.addPoint(5, 0);
		at.translate(turtleX, turtleY);
		at.rotate(turtleArc);
		gDraw.setTransform(at);
		gDraw.draw(arrow);
		gDraw.fillPolygon(arrow);
		
	}





	public void addShape(Object shape){
		synchronized(commands){
			commands.add(shape);
		}
		
	}

	
	/**
	 * @return the polygonFillColor
	 */
	public Color getPolygonFillColor() {
		return fillColor;
	}


	/**
	 * @param polygonFillColor the polygonFillColor to set
	 */
	public void setPolygonFillColor(Color polygonFillColor) {
		this.fillColor = polygonFillColor;
	}


	/**
	 * @return the tempColor
	 */
	public Color getTempColor() {
		return tempColor;
	}


	/**
	 * @param tempColor the tempColor to set
	 */
	public void setTempColor(Color tempColor) {
		this.tempColor = tempColor;
	}


	public void startAnimation(){
		th = new Thread(this);
		th.start();
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {

		int i = commands.size();

			synchronized(commands){
				commands.add(null);
			}
			
			
			if(animationObject instanceof Line2D){
				Line2D line = (Line2D) animationObject;
				animateLine(line, i);
				synchronized(commands){
					commands.set(i, line);
				}
				
				repaint();
			}
			else if(animationObject instanceof MoveForward){
				MoveForward mf = (MoveForward)animationObject;
				animateLine(mf.getLine(), i);
				synchronized(commands){
					commands.set(i, mf);
				}
			}
			
			else if(animationObject instanceof MoveBackward){
				MoveBackward mb = (MoveBackward) animationObject;
				animateBackLine(mb.getBackline(), i);
				synchronized(commands){
					commands.set(i, mb);
				}
			}
			
			else if(animationObject instanceof BackLine){
				BackLine backLine = (BackLine) animationObject;
				animateBackLine(backLine, i);
				synchronized(commands){
					commands.set(i, backLine);
				}
				
				repaint();
			} 
			
			else if(animationObject instanceof Ellipse2D){
				animateCircle(animationObject, i);
				synchronized(commands){
					commands.set(i, (Ellipse2D)animationObject);
				}
				
				repaint();
			}
			

			else if(animationObject instanceof Circle){
				animateCircle(animationObject, i);
				synchronized(commands){
					Circle cir = (Circle)animationObject;
					commands.set(i, cir.getCircle());
				}
			}
			else if(animationObject instanceof FilledCircle){
				FilledCircle fcircle = (FilledCircle) animationObject;
				animateFilledCircle(fcircle, i);
				synchronized(commands){
					commands.set(i, (FilledCircle) animationObject);
				}
				
				repaint();
			}
			else if (animationObject instanceof FilledPolygon){
				FilledPolygon polygon = (FilledPolygon) animationObject;
				animateFilledPolygon(polygon, i);
				synchronized(commands){
					commands.set(i, polygon);
				}
				
				repaint();
			}
			else if(animationObject instanceof Position){
				Position position = (Position)animationObject;
				currentTurtleState.setX(position.getX());
				currentTurtleState.setY(position.getY());
			}
			
			else{
				synchronized(commands){
					commands.set(i, animationObject);
				}
			
			
		}
			i++;
	}



	private void animateFilledPolygon(FilledPolygon polygon, int index) {
		ArrayList<Point> points = polygon.getPoints();
		int i = 0;
		FilledPolygon filledPolygon = new FilledPolygon();
		filledPolygon.setColor(polygon.getColor());
		filledPolygon.addNull();


		while (i+1 <= points.size()-1){
			
			Point p1 = points.get(i);
			Point p2 = points.get(i+1);
			Line2D line = new Line2D.Double();
			line.setLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());


			//animateLine(line, index);
			filledPolygon.setPoint(i, p1);
			filledPolygon.addNull();

			
			double x1 = p1.getX();
			double y1 = p1.getY();
			double x2 = p2.getX();
			double y2 = p2.getY();
			
			double vectorX = x2 - x1;
			double vectorY = y2 - y1;
			
			double vectorLength = Math.sqrt(Math.pow(vectorX, 2)+ Math.pow(vectorY, 2));
			
			double xValue = vectorX/vectorLength;
			double yValue = vectorY/vectorLength;
			double offsetX = 0;
			double offsetY = 0;

			double tempArc = polygon.getAngles().get(i);
			
			int j = 0;
			
			if(tempArc >= 90 && tempArc <=180){
				while(x1 + offsetX <= x2 && y1 + offsetY <= y2){
				
					Point point = new Point();
					point.setLocation(x1 + offsetX, y1 + offsetY);
					filledPolygon.setPoint(i+1, point);
					commands.set(index, filledPolygon);
					moveTurtle(x1 + offsetX, y1 + offsetY, Math.toRadians(polygon.getAngles().get(i)));
					repaint();
					try{
						Thread.sleep(animationSpeed);
					}
					catch(InterruptedException e){};
					
					offsetX = offsetX + xValue;
					offsetY = offsetY + yValue;
//					j++;
				}
				
				
			}
			else if (tempArc >180 && tempArc <= 270){
				while(x1 + offsetX >= x2 && y1 + offsetY <= y2){
					
					Point point = new Point();
					point.setLocation(x1 + offsetX, y1 + offsetY);
					filledPolygon.setPoint(i+1, point);
					commands.set(index, filledPolygon);
					moveTurtle(x1 + offsetX, y1 + offsetY, Math.toRadians(polygon.getAngles().get(i)));
					repaint();
					try{
						Thread.sleep(animationSpeed);
					}
					catch(InterruptedException e){};
					
					offsetX = offsetX + xValue;
					offsetY = offsetY + yValue;
//					j++;
				}
				
				
			}
			
			else if(tempArc >270 && tempArc <= 360){
				while(x1 + offsetX >= x2 && y1 + offsetY >= y2){
					Point point = new Point();
					point.setLocation(x1 + offsetX, y1 + offsetY);
					filledPolygon.setPoint(i+1, point);
					commands.set(index, filledPolygon);
					moveTurtle(x1 + offsetX, y1 + offsetY, Math.toRadians(polygon.getAngles().get(i)));
					repaint();
					try{
						Thread.sleep(animationSpeed);
					}
					catch(InterruptedException e){};
					
					offsetX = offsetX + xValue;
					offsetY = offsetY + yValue;
//					j++;
				}
				
			}
			else {
				while(x1 + offsetX <= x2 && y1 + offsetY >= y2){
			
					Point point = new Point();
					point.setLocation(x1 + offsetX, y1 + offsetY);
					filledPolygon.setPoint(i+1, point);
					commands.set(index, filledPolygon);
					moveTurtle(x1 + offsetX, y1 + offsetY, Math.toRadians(polygon.getAngles().get(i)));
					repaint();
					try{
						Thread.sleep(animationSpeed);
					}
					catch(InterruptedException e){};
					
					offsetX = offsetX + xValue;
					offsetY = offsetY + yValue;
//					j++;
				}
				
				
			}
			
			commands.set(index, filledPolygon);
			i++;
		}
		
	}





	private void animateFilledCircle(FilledCircle filledCircle, int index) {
		double preArc = currentTurtleState.getDirection();
		currentTurtleState.setDirection(Math.toRadians(180));
		Ellipse2D circle = filledCircle.getCircle();
		Arc2D.Double arc = new Arc2D.Double();
		double startArc = filledCircle.getStartArc();
		double tempArc = 0;
		double arcOffset = 180/(circle.getWidth()/2*Math.PI);
		fillColor = filledCircle.getColor();
		while(tempArc <= 360){

			arc.setArc(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight(),  -(Math.toDegrees(startArc)%360+360)+270, tempArc, Arc2D.OPEN);

			FilledArc filledArc = new FilledArc();
			filledArc.setArc(arc);
			filledArc.setColor(filledCircle.getColor());
			commands.set(index, filledArc);
			double midX = circle.getX() + circle.getWidth()/2;
			double midY = circle.getY() + circle.getHeight()/2;
			
			double x = midX - circle.getWidth()/2 * Math.sin(Math.toRadians(tempArc));
			double y = midY - circle.getHeight()/2 * Math.cos(Math.toRadians(tempArc));
			

			x = midX + circle.getWidth()/2 * Math.sin(Math.toRadians(Math.toDegrees(startArc)%360+180-tempArc));
			y = midY - circle.getHeight()/2 * Math.cos(Math.toRadians(Math.toDegrees(startArc)%360+180-tempArc));
			moveTurtle(x, y,startArc + Math.PI/2 - Math.toRadians(tempArc));
			
			repaint();
			try{
				Thread.sleep(animationSpeed);
			}
			catch(InterruptedException e){};
			tempArc = tempArc + arcOffset;
		}
		currentTurtleState.setDirection(preArc);
		
	}


	private void animateCircle(Object o, int index) {
		double preArc = currentTurtleState.getDirection();
		currentTurtleState.setDirection(Math.toRadians(180));
		Ellipse2D circle;
		double startArc;

		Circle cir = (Circle)o;
		circle = cir.getCircle();
		startArc = cir.getStartArc();
		Arc2D.Double arc = new Arc2D.Double();
		double tempArc = 0;
//		double arcOffset = 1.5;
		double arcOffset = 180/(circle.getWidth()/2*Math.PI);
		while(tempArc <= 360){
//			if(Math.toDegrees(startArc) <=180){
//				arc.setArc(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight(),  270 - (Math.toDegrees(startArc)%360+360), tempArc, Arc2D.OPEN);
//			}
//			else{
//				arc.setArc(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight(),  630 - (Math.toDegrees(startArc)%360+360), tempArc, Arc2D.OPEN);
//			}
//			arc.setArc(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight(),  630 - (Math.toDegrees(startArc)%360+360), tempArc, Arc2D.OPEN);
			arc.setArc(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight(),  -(Math.toDegrees(startArc)%360+360)+270, tempArc, Arc2D.OPEN);
			commands.set(index, arc);
			double midX = circle.getX() + circle.getWidth()/2;
			double midY = circle.getY() + circle.getHeight()/2;
			
			double x;
			double y;
			
			
			x = midX + circle.getWidth()/2 * Math.sin(Math.toRadians(Math.toDegrees(startArc)%360+180-tempArc));
			y = midY - circle.getHeight()/2 * Math.cos(Math.toRadians(Math.toDegrees(startArc)%360+180-tempArc));

			
			moveTurtle(x, y,startArc  + Math.PI/2 - Math.toRadians(tempArc));
			repaint();
			try{
				Thread.sleep(animationSpeed);
			}
			catch(InterruptedException e){};
			tempArc = tempArc + arcOffset;
		}
		
		currentTurtleState.setDirection(startArc);
		repaint();
	}


	private void animateLine(Line2D line, int index) {
		
		double x1 = line.getX1();
		double y1 = line.getY1();
		double x2 = line.getX2();
		double y2 = line.getY2();
		
		
		double vectorX = x2 - x1;
		double vectorY = y2 - y1;
		
		double vectorLength = Math.sqrt(Math.pow(vectorX, 2)+ Math.pow(vectorY, 2));
		
		double xValue = vectorX/vectorLength;
		double yValue = -vectorY/vectorLength;
		

		double offset = 0;
		double arc;
		if(vectorX >= 0){
			arc = Math.acos(yValue);
		}
		else{
			arc = 2*Math.PI - Math.acos(yValue);
		}
		

		
		double factor = 1/vectorLength;
		Shape shape = null;
		while(offset <= 1){
			AffineTransform atf = new AffineTransform();
			atf.translate(line.getX1() * (1-offset), line.getY1() * (1-offset));
			atf.scale(offset, offset);
			shape = atf.createTransformedShape(line);
			
			if(penDown){
				commands.set(index, shape);
			}
			
			
		
			moveTurtle(x1 + offset*vectorLength*Math.sin(arc), y1 - offset*vectorLength*Math.cos(arc), arc);
			
			
			

			
			repaint();
			try {
				Thread.sleep(animationSpeed);
			} catch (InterruptedException e) {
			}
			
			offset = offset + factor;
		}
		
	}
	
	private void animateBackLine(BackLine backline, int index){
		Line2D o = backline.getLine();
		
		int x1 = (int) Math.round(o.getX1());
		int y1 = (int) Math.round(o.getY1());
		int x2 = (int) Math.round(o.getX2());
		int y2 = (int) Math.round(o.getY2());
		
		
		int vectorX = x2 - x1;
		int vectorY = y2 - y1;
		
		double vectorLength = Math.sqrt(Math.pow(vectorX, 2)+ Math.pow(vectorY, 2));
		
		double xValue = vectorX/vectorLength;
		double yValue = -vectorY/vectorLength;
		
		double offset = 0;
		double arc;
		if(vectorX >= 0){
			arc = Math.acos(yValue);
		}
		else{
			arc = 2*Math.PI - Math.acos(yValue);
		}
		
		double factor = 1/vectorLength;
		Shape shape = null;
		while(offset <= 1){
			AffineTransform atf = new AffineTransform();
			atf.translate(o.getX1() * (1-offset), o.getY1() * (1-offset));
			atf.scale(offset, offset);
			shape = atf.createTransformedShape(o);
			
			if(penDown){
				commands.set(index, shape);
			}
			
			
			moveTurtle(x1 + offset*vectorLength*Math.sin(arc), y1 - offset*vectorLength*Math.cos(arc), arc + Math.PI);

			

			
			repaint();
			try {
				Thread.sleep(animationSpeed);
			} catch (InterruptedException e) {
			}
			
			offset = offset + factor;
		}
		
	}


	
	/**
	 * @return the paintables
	 */
	public ArrayList<Object> getCommands() {
		return commands;
	}


	/**
	 * @return the currentTurtleState
	 */
	public State getCurrentTurtleState() {
		return currentTurtleState;
	}



	/**
	 * @param currentTurtleState the currentTurtleState to set
	 */
	public void setCurrentTurtleState(State currentTurtleState) {
		this.currentTurtleState = currentTurtleState;
	}
	
	/**
	 * @return the animationSpeed
	 */
	public int getAnimationSpeed() {
		return animationSpeed;
	}


	/**
	 * @param animationSpeed the animationSpeed to set
	 */
	public void setAnimationSpeed(int animationSpeed) {
		this.animationSpeed = animationSpeed;
	}
	
	public void moveTurtle(double x, double y, double arc) {
		
		currentTurtleState.setX((int)Math.round(x));
		currentTurtleState.setY((int)Math.round(y));
		currentTurtleState.setDirection(arc);
		
	}
	/**
	 * @return the animationObject
	 */
	public Object getAnimationObject() {
		return animationObject;
	}

	/**
	 * @param animationObject the animationObject to set
	 */
	public void setAnimationObject(Object animationObject) {
		this.animationObject = animationObject;
	}
}
