package mule.ubtmicroworld.data;

import java.util.ArrayList;
import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.UBTMicroworld.LineOfSight;
import mule.ubtmicroworld.UBTMicroworld.MoveDirection;
import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;


/**
 * This class symbolizes a Agent.
 * @author Marco Jantos
 * 
 */
public class AgentImpl extends Agent implements IAgent{
	
	private final int iD;
	
	private int xPosStart;
	private int yPosStart;	
	private int xPos;
	private int yPos;
	private int stepsMade = 0;
	private int numberInputs = 0;
	private int numberInvalidInputs = 0;
	
	private IMatchfield matchfield;
	
	private LineOfSight lineOfSight = LineOfSight.NORTH;	
	
	private DataController dataController;
	
	private List<ObjectType> objects = new ArrayList<ObjectType>();

	private LineOfSight lineOfSightStart = LineOfSight.NORTH;
	private MoveDirection lastMoveDirection = MoveDirection.NONE;
	
	private List<MoveDirection> moveDirectionList = new ArrayList<MoveDirection>();
	
	public AgentImpl(int x, int y, LineOfSight lineOfSight, Matchfield matchfield, DataController dataController, int iD) {
		this.iD = iD;
		xPos = x;
		yPos = y;
		xPosStart = x;
		yPosStart = y;
		this.lineOfSight = lineOfSight;
		this.lineOfSightStart = lineOfSight;
		this.matchfield = matchfield;
		this.dataController = dataController;
		
		if(matchfield.isObjectOnTile(xPos, yPos)) {
			objects.add(matchfield.pickUpObject(xPos, yPos));
		}
	}

	@Override
	public int getXPosition() {
		return xPos;
	}

	@Override
	public int getYPosition() {
		return yPos;
	}

	@Override
	public LineOfSight getLineOfSight() {
		return lineOfSight;
	}

	@Override
	public void moveForward() {

		boolean isAllowedToMove = dataController.isAgentAllowedToMove(this);
		if(!isAllowedToMove) {
			return;
		}
		
		numberInputs++;
		
		int dim = matchfield.getDimension();
				
		
		if(!matchfield.isTileWalkable(xPos, yPos)) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Ungewöhnlicher Fehler aufgetreten.");
			System.out.println("Agent befindet sich auf unbegehbarer Kachel.");
			System.out.println("--------------------------------------------");
			lastMoveDirection = MoveDirection.INVALID;
			moveDirectionList.add(lastMoveDirection);
			numberInvalidInputs++;
			
			waitTime();
			return;
		}
		
		int xPosWalk = xPos;
		int yPosWalk = yPos;
		
		switch(lineOfSight) {
		case NORTH:
			yPosWalk--;
			break;
		case EAST:
			xPosWalk++;
			break;
		case SOUTH:
			yPosWalk++;
			break;
		case WEST:
			xPosWalk--;
			break;
		default:
			return;
		}
		
		
		if(!matchfield.isTileWalkable(xPosWalk, yPosWalk)) {
			lastMoveDirection = MoveDirection.FORWARD_INVALID;
			moveDirectionList.add(lastMoveDirection);
			numberInvalidInputs++;
			waitTime();
			return;
		}
		
		xPos = xPosWalk;
		yPos = yPosWalk;
		
		lastMoveDirection = MoveDirection.FORWARD;
		
		moveDirectionList.add(lastMoveDirection);
		
		stepsMade++;
		

		if(matchfield.isObjectOnTile(xPos, yPos)) {
			objects.add(matchfield.pickUpObject(xPos, yPos));
		}
		
		dataController.validate();
		
		waitTime();
	}

	@Override
	public void moveBackward() {
		
		
		boolean isAllowedToMove = dataController.isAgentAllowedToMove(this);
		if(!isAllowedToMove) {
			return;
		}
		
		numberInputs++;
		
		int dim = matchfield.getDimension();
				
		
		if(!matchfield.isTileWalkable(xPos, yPos)) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Ungewöhnlicher Fehler aufgetreten.");
			System.out.println("Agent befindet sich auf unbegehbarer Kachel.");
			System.out.println("--------------------------------------------");
			
			lastMoveDirection = MoveDirection.INVALID;
			moveDirectionList.add(lastMoveDirection);
			numberInvalidInputs++;
			waitTime();
			return;
		}
		
		int xPosWalk = xPos;
		int yPosWalk = yPos;
		
		switch(lineOfSight) {
		case NORTH:
			yPosWalk++;
			break;
		case EAST:
			xPosWalk--;
			break;
		case SOUTH:
			yPosWalk--;
			break;
		case WEST:
			xPosWalk++;
			break;
		default:
			return;
		}
		
		
		if(!matchfield.isTileWalkable(xPosWalk, yPosWalk)) {
			lastMoveDirection = MoveDirection.BACK_INVALID;
			moveDirectionList.add(lastMoveDirection);
			numberInvalidInputs++;
			waitTime();
			return;
		}
		
		xPos = xPosWalk;
		yPos = yPosWalk;
		lastMoveDirection = MoveDirection.BACK;
		moveDirectionList.add(lastMoveDirection);
		stepsMade++;
		
		if(matchfield.isObjectOnTile(xPos, yPos)) {
			objects.add(matchfield.pickUpObject(xPos, yPos));
		}
		
		dataController.validate();
		
		waitTime();
		
	}

	@Override
	public void rotateRight() {
		
		
		boolean isAllowedToMove = dataController.isAgentAllowedToMove(this);
		if(!isAllowedToMove) {
			return;
		}
		
		numberInputs++;		
		
		switch(lineOfSight) {
		case NORTH:
			lineOfSight = LineOfSight.EAST;
			break;
		case EAST:
			lineOfSight = LineOfSight.SOUTH;
			break;
		case SOUTH:
			lineOfSight = LineOfSight.WEST;
			break;
		case WEST:
			lineOfSight = LineOfSight.NORTH;
			break;
		default:
			break;
		}
		
		stepsMade++;
		lastMoveDirection = MoveDirection.RIGHT;
		moveDirectionList.add(lastMoveDirection);
		
		dataController.validate();
		
		waitTime();
	}

	@Override
	public void rotateLeft() {
		
		
		boolean isAllowedToMove = dataController.isAgentAllowedToMove(this);
		if(!isAllowedToMove) {
			return;
		}
		
		numberInputs++;
		
		switch(lineOfSight) {
		case NORTH:
			lineOfSight = LineOfSight.WEST;
			break;
		case EAST:
			lineOfSight = LineOfSight.NORTH;
			break;
		case SOUTH:
			lineOfSight = LineOfSight.EAST;
			break;
		case WEST:
			lineOfSight = LineOfSight.SOUTH;
			break;
		default:
			break;
		}
		
		stepsMade++;
		
		lastMoveDirection = MoveDirection.LEFT;
		moveDirectionList.add(lastMoveDirection);
		
		dataController.validate();
		
		waitTime();
		
	}

	@Override
	public void doNothing() {
		
		
		boolean isAllowedToMove = dataController.isAgentAllowedToMove(this);
		if(!isAllowedToMove) {
			waitTime();	
			return;
		}
		
		numberInputs++;
		
		stepsMade++;
		
		lastMoveDirection = MoveDirection.NONE;
		moveDirectionList.add(lastMoveDirection);
		
		dataController.validate();
		
		waitTime();		
	}
	
	
	private void waitTime() {		
				
		AgentUtil.waitAgent();
	
	}

	@Override
	public boolean isTileInFrontOfWalkable() {
		TerrainType terrainType;
		
		int dim = matchfield.getDimension();
		
		int positionX = xPos;
		int positionY = yPos;
		
		switch (lineOfSight) {
		case NORTH:
			positionY--;
			break;
		case EAST:
			positionX++;
			break;
		case SOUTH:
			positionY++;
			break;
		case WEST:
			positionX--;
			break;
		default:
			break;
		}
		
		if(positionX < 0 || positionY < 0 || positionX >=  dim || positionY >= dim) {
			return false;
		}
		
		return matchfield.isTileWalkable(positionX, positionY);
	}

	@Override
	public boolean isTileBehindWalkable() {
		TerrainType terrainType;
		
		int dim = matchfield.getDimension();
		
		int positionX = xPos;
		int positionY = yPos;
		
		switch (lineOfSight) {
		case NORTH:
			positionY++;
			break;
		case EAST:
			positionX--;
			break;
		case SOUTH:
			positionY--;
			break;
		case WEST:
			positionX++;
			break;
		default:
			break;
		}
		
		if(positionX < 0 || positionY < 0 || positionX >=  dim || positionY >= dim) {
			return false;
		}
		
		return matchfield.isTileWalkable(positionX, positionY);	
	}

	@Override
	public int getID() {
		return iD;
	}

	@Override
	public List<ObjectType> getCollectedObjects() {
		return objects;
	}

	@Override
	public int getStepsMade() {
		return stepsMade;
	}

	@Override
	public MoveDirection getLastMoveDirection() {
		return lastMoveDirection;
	}

	@Override
	public List<MoveDirection> getMoveDirectionList() {
		return moveDirectionList;
	}

	@Override
	public int getXstartPosition() {
		return xPosStart;
	}

	@Override
	public int getYstartPosition() {
		return yPosStart;
	}

	@Override
	public int getNumberInputs() {
		return numberInputs;
	}

	@Override
	public LineOfSight getLineOfsightStart() {
		return lineOfSightStart;
	}

	@Override
	public int getNumberInvalidInputs() {
		return numberInvalidInputs;
	}

}
