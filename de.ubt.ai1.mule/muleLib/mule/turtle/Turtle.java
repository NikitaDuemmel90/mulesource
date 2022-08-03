package mule.turtle;

/**
 * 
 *
 * @author Stefan Schill
 * @version 1.0
 */
public interface Turtle {
	TurtleImpl t = new TurtleImpl();

	/** Draws a line in the direction the turtle is pointing
	 * @param i the length of the line
	 */
	public static void forward(double i){
		t.forward(i);
	}
	
	/** Draws a line in the opposite direction the turtle is pointing
	 * @param i the length of the line
	 */
	public static void backward(double i){
		t.backward(i);
	}
	
	/** Turns the turtle to the right
	 * @param degree the degree to turn
	 */
	public static void right(double degree){
		t.right(degree);
	}
	
	/** Turns the turtle to the left
	 * @param degree degree to turn
	 */
	public static void left(double degree){
		t.left(degree);
	}
	
	/** Lifts the pen. Drawing is disabled
	 * 
	 */
	public static void penUp(){
		t.penUp();
	}
	
	/** Brings down the pen. Drawing is enabled
	 * 
	 */
	public static void penDown(){
		t.penDown();
	}
	
	/** Sets the Color of the lines being drawn
	 * @param color the color to set
	 */
	public static void setColor(Colors color){
		t.setColor(color);
	}
	
	/** Sets the color of the lines being drawn in RGB-representation
	 * @param r - the red component
	 * @param g - the green component
	 * @param b - the blue component
	 */
	public static void setColorRGB(int r, int g, int b){
		t.setColorRGB(r, g, b);
	}
	
	/** Sets the width of the stroke
	 * @param i width to be set
	 */
	public static void setThickness(int i){
		t.setThickness(i);
	}
	
	/** Draws a line to (x,y)
	 * @param x - the x-coordinate
	 * @param y - the y-coordinate
	 */
	public static void moveTo(double x, double y){
		t.moveTo(x, y);
	}
	
	/** Orientates the turtle to the given angle
	 * @param angle - the angel to set
	 */
	public static void setDirection(double angle){
		t.setDirection(angle);
	}

	/** Sets the position of the turtle to (x,y) without drawing
	 * @param x - the x-coordinate
	 * @param y - the y-coordinate
	 */
	public static void setPosition(double x, double y){
		t.setPosition(x, y);
	}
	
	/** Sets the Orientation of the turtle either to NORTH (0°), EAST (90°), SOUTH (180°) or WEST (270°)
	 * @param o - the orientation (NORTH, EAST, SOUTH, WEST)
	 */
	public static void setOrientation(Orientation o){
		t.setOrientation(o);
	}
	
	public enum Orientation{
		NORTH, SOUTH, EAST, WEST
	}
	
	/** Returns the current x-coordinate of the turtle
	 * @return the current x-coordinate
	 */
	public static double getX(){
		return t.getState().getX();
	}
	
	/** Returns the current y-coordinate of the turtle
	 * @return the current y-coordinate
	 */
	public static double getY(){
		return t.getState().getY();
	}
	
	/** Returns the current angel of the turtle
	 * @return the current angle
	 */
	public static double getAngle(){
		return t.getState().getDirection();
	}
	
	/** Set the frame size
	 * @param x - width
	 * @param y - height
	 */
	public static void setFrameSize(int x, int y){
		t.setFrameSize(x, y);
	}
	
	/** Starts a filled polygon. The movements of the turtle are added to the polygon until endFilledPolygon is called
	 * @param color - the color to fill the polygon
	 */
	public static void startFilledPolygon(Colors color){
		t.startFilledPolygon(color);
	}
	
	/** Starts a filled polygon. The movements of the turtle are added to the polygon until endFilledPolygon is called
	 * @param r - the red component
	 * @param g - the green component
	 * @param b - the blue component
	 */
	public static void startFilledPolygonRGB(int r, int g, int b){
//		Color color = new Color(r, g, b);
		t.startFilledPolygonRGB(r,g,b);
	}
	
	
	/** Finishes a filled Polygon
	 * 
	 */
	public static void endFilledPolygon(){
		t.endFilledPolygon();
	}
	
	/** Draws a circle with the midpoint lying in the alignment of the current turtle angel
	 * @param radius - radius of the circle
	 */
	public static void circle(double radius){
		t.circle(radius);
	}
	
	/** Draws a filled circle with the midpoint lying in the alignment of the current turtle angel
	 * @param radius - radius of the circle
	 * @param color - fill color
	 */
	public static void filledCircle(double radius, Colors color){
		t.filledCircle(radius, color);
	}
	
	/** Draws a filled circle with the midpoint lying in the alignment of the current turtle angel
	 * @param radius - radius of the circle
	 * @param r - the red component
	 * @param g - the green component
	 * @param b - the blue component
	 */
	public static void filledCircleRGB(double radius, int r, int g, int b){
		
		t.filledCircleRGB(radius, r, g, b);
	}
	

	public enum Colors{
		WHITE, BLACK, RED, GREEN, BLUE, YELLOW, MAGENTA, CYAN, PINK, ORANGE, LIGHT_GRAY, DARK_GRAY
	}
	
	
	
	
	/** Sets the speed of the animation.
	 * @param speed the speed to set (SLOW, MEDIUM, FAST, INSTANT)
	 */
	public static void setAnimationSpeed(Speed speed){
		t.startAnimation(speed);
		
	}
	

	
	/** Shows or hides the coordinate system
	 * @param bool Shows or hides the coordinate system
	 */
	public static void showCoordinateSystem (boolean bool){
		t.showCoordinateSystem(bool);
	}
	

	/** Activates the draw mode. You can control the turtle by keyboard.
	 * @param speed the speed of the turtle
	 */
	public static void activateKeyboardMode(Speed speed){
		t.activateKeyboardMode(speed);
	}
	
	public enum Speed{
		SLOW, MEDIUM, FAST, INSTANT
	}
	
	/** Adjusts the granularity of the coordinate system
	 * @param x - the x-granularity
	 * @param y - the y-granularity
	 */
	public static void scaleCoordinateSystem(int x, int y){
		t.scaleCoordinateSystem(x, y);
	}
	
	/** Shows or hides the turtle cursor
	 * @param bool Shows or hides the turtle cursor
	 */
	public static void showCursor(boolean bool){
		t.showCursor(bool);
	}
	
	/** Returns the TurtleImpl instance
	 * @return the TurtleImpl instance
	 */
	public static TurtleImpl getTurtleImpl(){
		return t;
	}
	
	/** Sets the background color of the panel
	 * @param color
	 */
	public static void setBackgroundColor(Colors color){
		t.setBackgroundColor(color);
	}
	
	/** Sets the background color of the panel in RGB representation
	 * @param r - the red component
	 * @param g - the green component
	 * @param b - the blue component
	 */
	public static void setBackgroundColorRGB(int r, int g, int b){
		t.setBackgroundColorRGB(r,g,b);
	}
}
