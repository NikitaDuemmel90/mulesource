package mule.turtle;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;


public class KeyboardMode implements KeyListener, FocusListener {

	private TurtlePanel tp;
	private State state;
	private int speed;
	int arrayIndex;
	private FilledPolygon polygon = new FilledPolygon();
	boolean processingPolygon = false;
	private Color fillColor = Color.BLACK;
	private boolean controlFire = false;
	private boolean upFire = false;
	private boolean downFire = false;
	
	public KeyboardMode(int i){
		speed = i;
		TurtleImpl ti = Turtle.getTurtleImpl();
		this.tp = ti.getTp();
		tp.addShape(null);
		state = new State();
		state.setX(tp.getCurrentTurtleState().getX());
		state.setY(tp.getCurrentTurtleState().getY());
		state.setDirection(tp.getCurrentTurtleState().getDirection());
		xLine = state.getX();
		yLine = state.getY();
		xStart = state.getX();
		yStart = state.getY();
		
		computeOffsets();
		arrayIndex = tp.getCommands().size();
		tp.setFocusable(true);
		this.tp.addFocusListener(this);
		this.tp.addKeyListener(this);
		this.tp.requestFocusInWindow();
		
	}

	private void computeOffsets() {

		tempArc = state.getDirection();
		xOffset = Math.sin(state.getDirection())* speed;
		yOffset = -Math.cos(state.getDirection())* speed;
	}

	double xLine;
	double yLine;
	double xOffset;
	double yOffset;
	double xStart;
	double yStart;
	double tempArc;
	Line2D line = new Line2D.Double();
	int polyIndex;
	
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_CONTROL){
			if(!controlFire && !processingPolygon){
				controlFire = true;
				System.out.println("penUp()");
			}
			
		}

		if(e.getKeyCode() == KeyEvent.VK_UP){
			upFire = true;
			xLine = xLine + xOffset;
			yLine = yLine + yOffset;
			if(!processingPolygon){
			
			line.setLine(xStart, yStart, xLine, yLine);
			if(!e.isControlDown()){
				tp.getCommands().set(arrayIndex-1, line);
			}
			}
			
			if(processingPolygon){
				polygon.setPoint(polyIndex, new Point((int)xLine,(int) yLine));
					
				
			}
			tp.moveTurtle(xLine, yLine, state.getDirection());
			tp.repaint();	
			state.setX((int)xLine);
			state.setY((int)yLine);
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			downFire = true;
			xLine = xLine - xOffset;
			yLine = yLine - yOffset;
			if(!processingPolygon){
				
				line.setLine(xStart, yStart, xLine, yLine);
				if(!e.isControlDown()){
					tp.getCommands().set(arrayIndex -1, line);
				}
			}
			
			
			
			tp.moveTurtle(xLine, yLine, state.getDirection());
			tp.repaint();
			state.setX((int) xLine);
			state.setY((int) yLine);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){

				state.setDirection(state.getDirection() + Math.toRadians(1*speed));
				tp.moveTurtle(state.getX(), state.getY(), state.getDirection());

			tp.repaint();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			state.setDirection(state.getDirection() - Math.toRadians(1*speed));
			tp.moveTurtle(state.getX(), state.getY(), state.getDirection());
			tp.repaint();
		}
		
		
		
		//POLYGON
		if(e.getKeyCode() == KeyEvent.VK_P && e.isAltDown()){
			polyIndex = 0;

			if(!processingPolygon){
				
				processingPolygon = true;
				System.out.println("startFilledPolygon(Colors."+ getColorName(fillColor)+")");
				polygon.addPoint(state.getX(), state.getY());
				polygon.addAngle(state.getDirection());
				polygon.addNull();
				polygon.addnullAngle();
				polygon.setColor(fillColor);
				tp.getCommands().set(arrayIndex-1, polygon);
				polyIndex = polyIndex +1;
			}
			
			else if(processingPolygon){
				processingPolygon = false;
				tp.addShape(null);
				polygon = null;
				polygon = new FilledPolygon();
				tp.getCommands().add(null);
				System.out.println("endFilledPolygon()");
				arrayIndex = arrayIndex +1;
			}
			
			
		}
		
		
		// FARBEN
		if(e.getKeyCode() == KeyEvent.VK_F1){
			if(!e.isShiftDown()){
				tp.getCommands().set(arrayIndex -1, Color.BLACK);
				tp.addShape(null);
				arrayIndex = arrayIndex +1;
				System.out.println("setColor(Colors.BLACK)");
			}
			
			
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.BLACK);
				fillColor = Color.BLACK;
			}
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F2){
			if(!e.isShiftDown()){
				tp.getCommands().set(arrayIndex -1, Color.WHITE);
				tp.addShape(null);
				arrayIndex = arrayIndex +1;
				System.out.println("setColor(Colors.WHITE)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.WHITE);
				fillColor = Color.WHITE;
			}
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F3){
			if(!e.isShiftDown()){
				tp.getCommands().set(arrayIndex -1, Color.RED);
				tp.addShape(null);
				arrayIndex = arrayIndex +1;
				System.out.println("setColor(Colors.RED)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.RED);
				fillColor = Color.RED;
			}
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F4){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.GREEN);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.GREEN)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.GREEN);
				fillColor = Color.GREEN;
			}
			
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F5){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.BLUE);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.BLUE)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.BLUE);
				fillColor = Color.BLUE;
			}
			
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F6){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.YELLOW);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.YELLOW)");
			}
			
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.YELLOW);
				fillColor = Color.YELLOW;
			}
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F7){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.MAGENTA);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.MAGENTA)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.MAGENTA);
				fillColor = Color.MAGENTA;
			}
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F8){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.CYAN);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.CYAN)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.CYAN);
				fillColor = Color.CYAN;
			}
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F9){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.PINK);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.PINK)");
			}
			
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.PINK);
				fillColor = Color.PINK;
			}
			
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F10){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.ORANGE);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.ORANGE)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.ORANGE);
				fillColor = Color.ORANGE;
			}
		
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F11){
			if(!e.isShiftDown()){
			tp.getCommands().set(arrayIndex -1, Color.LIGHT_GRAY);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setColor(Colors.LIGHT_GRAY)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.LIGHT_GRAY);
				fillColor = Color.LIGHT_GRAY;
			}
	
			tp.repaint();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F12){
			if(!e.isShiftDown()){
				tp.getCommands().set(arrayIndex -1, Color.DARK_GRAY);
				tp.addShape(null);
				arrayIndex = arrayIndex +1;
				System.out.println("setColor(Colors.DARK_GRAY)");
			}
			if(e.isShiftDown() && !processingPolygon){
				polygon.setColor(Color.DARK_GRAY);
				fillColor = Color.DARK_GRAY;
			}
			
			tp.repaint();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_1){
			tp.getCommands().set(arrayIndex-1, 1);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(1)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_2){
			tp.getCommands().set(arrayIndex-1, 2);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(2)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_3){
			tp.getCommands().set(arrayIndex-1, 3);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(3)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_4){
			tp.getCommands().set(arrayIndex-1, 4);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(4)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_5){
			tp.getCommands().set(arrayIndex-1, 5);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(5)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_6){
			tp.getCommands().set(arrayIndex-1, 6);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(6)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_7){
			tp.getCommands().set(arrayIndex-1, 7);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(7)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_8){
			tp.getCommands().set(arrayIndex-1, 8);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(8)");
			tp.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_9){
			tp.getCommands().set(arrayIndex-1, 9);
			tp.addShape(null);
			arrayIndex = arrayIndex +1;
			System.out.println("setThickness(9)");
			tp.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_CONTROL){
			if(controlFire && !processingPolygon){
				controlFire = false;
				System.out.println("penDown()");
				
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP){
			double x = xLine - xStart;
			double y = yLine - yStart;
			
			int length =(int) Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) );
			System.out.println("forward(" + length + ")");
			
			state.setX((int)xLine);
			state.setY((int)yLine);
			xStart = state.getX();
			yStart = state.getY();
			arrayIndex = arrayIndex +1;
			line = null;
			line = new Line2D.Double();
			
			tp.addShape(null);
			upFire = false;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			double x = xLine - xStart;
			double y = yLine - yStart;
			
			int length =(int) Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) );

			System.out.println("backward(" + length +")");
			state.setX((int) xLine);
			state.setY((int) yLine);
			xStart = state.getX();
			yStart = state.getY();
			arrayIndex = arrayIndex + 1;
			line = null;
			line = new Line2D.Double();
			
			tp.addShape(null);
			downFire = false;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){

			double arc = Math.round((Math.toDegrees(state.getDirection()) - Math.toDegrees(tempArc))*10.0) / 10.0;
			System.out.println("right(" + arc + ")");
			computeOffsets();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){

			double arc = Math.round((Math.toDegrees(tempArc) - Math.toDegrees(state.getDirection()))*10.0) /10.0;
			System.out.println("left(" + arc + ")");
			
			computeOffsets();
		}
		

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
	}

	private String getColorName(Color col){
		if(col == Color.BLACK){
			return "BLACK";
		}
		else if(col == Color.WHITE){
			return "WHITE";
		}
		else if(col == Color.RED){
			return "RED";
		}
		else if(col == Color.GREEN){
			return "GREEN";
		}
		else if(col == Color.BLUE){
			return "BLUE";
		}
		else if(col == Color.YELLOW){
			return "YELLOW";
		}
		else if(col == Color.MAGENTA){
			return "MAGENTA";
		}
		else if(col == Color.CYAN){
			return "CYAN";
		}
		else if(col == Color.PINK){
			return "PINK";
		}
		else if(col == Color.ORANGE){
			return "ORGANGE";
		}
		else if(col == Color.LIGHT_GRAY){
			return "LIGHT_GRAY";
		}
		else if(col == Color.DARK_GRAY){
			return "DARK_GRAY";
		}
		else return null;
	}
}
