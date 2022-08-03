package mule.ubtmicroworld.data;

import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import mule.ubtmicroworld.UBTMicroworld.LineOfSight;
import mule.ubtmicroworld.UBTMicroworld.MoveDirection;
import mule.ubtmicroworld.UBTMicroworld.ObjectType;

/**
 * This interface specializes the agents.
 * @author Marco Jantos
 *
 */
public interface IAgent {
	
	/**
	 * This method returns the x position of the agent.
	 * @return  The x position of the agent.
	 */
	public int getXPosition();
	
	/**
	 * This method returns the y position of the agent.
	 * @return  The y position of the agent.
	 */
	public int getYPosition();
	
	/**
	 * This method returns the LineOfSight of the agent.
	 * @return  The LineOfSight of the agent.
	 */
	public LineOfSight getLineOfSight();
	
	/**
	 * This method moves the agent one tile forward if possible.
	 */
	public void moveForward();
	
	/**
	 * This method moves the agent one tile backward if possible.
	 */
	public void moveBackward();
	
	/**
	 * This method rotates the agent to the right if possible.
	 */
	public void rotateRight();
	
	/**
	 * This method rotates the agent to the left if possible.
	 */
	public void rotateLeft();
	
	/**
	 * This method makes the agent wait if possible.
	 */
	public void doNothing();
	
	/**
	 * This method returns whether the tile in front of the agent is walkable. 
	 * @return  true if the tile in front of the agent is walkable. 
	 */
	public boolean isTileInFrontOfWalkable();
	
	/**
	 * This method returns whether the tile behind the agent is walkable. 
	 * @return  true if the tile behind the agent is walkable. 
	 */
	public boolean isTileBehindWalkable();
	
	/**
	 * This method returns the id of the agent.
	 * @return  The id of the agent.
	 */
	public int getID();
	
	/**
	 * This method returns a list of all objects the agent collected.
	 * @return  list of all objects.
	 */
	public List<ObjectType> getCollectedObjects();
	
	/**
	 * This method returns the number of made steps.
	 * @return  number of made steps.
	 */
	public int getStepsMade();
	
	/**
	 * This method returns the last MoveDirection the agent made.
	 * @return  last MoveDirection.
	 */
	public MoveDirection getLastMoveDirection();
	
	/**
	 * This method returns a list of all MoveDirections the agent made.
	 * @return  list of all MoveDirections the agent made.
	 */
	public List<MoveDirection> getMoveDirectionList();
	
	/**
	 * This method returns the x position of the start tile of the agent.
	 * @return  The x position of the start tile of the agent.
	 */
	public int getXstartPosition();
	
	/**
	 * This method returns the y position of the start tile of the agent.
	 * @return  The y position of the start tile of the agent.
	 */
	public int getYstartPosition();
	
	/**
	 * This method returns the number of input the agent got until the game ended.
	 * @return  number of input.
	 */
	public int getNumberInputs();
	
	/**
	 * This method returns the number of invalid inputs the agent got until the game ended.
	 * Invalid inputs are those whose subsequent movement would not have been valid.
	 * @return  number of invalid input
	 */
	public int getNumberInvalidInputs();
	
	/**
	 * This method returns the LineOfSight of the start position of the agent.
	 * @return  The LineOfSight of the start position of the agent.
	 */
	public LineOfSight getLineOfsightStart();
	
}
