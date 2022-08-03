package mule.ubtmicroworld;

import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.UBTMicroworld.DefaultLevelType;
import mule.ubtmicroworld.UBTMicroworld.DelayTime;
import mule.ubtmicroworld.UBTMicroworld.MoveDirection;
import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;
import mule.ubtmicroworld.data.AgentImpl;
import mule.ubtmicroworld.data.AgentType;
import mule.ubtmicroworld.data.BibKeyEventListener;
import mule.ubtmicroworld.data.BibKeyListening;
import mule.ubtmicroworld.data.DataController;
import mule.ubtmicroworld.data.GameDescription;
import mule.ubtmicroworld.data.IAgent;
import mule.ubtmicroworld.data.IGameDescription;
import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.IMatchfield;
import mule.ubtmicroworld.gui.GuiController;
import mule.ubtmicroworld.gui.Texture;
import mule.ubtmicroworld.gui.Texture.TEXTURE_ID;

/**
 * This class is the main class to interact with the UbtMicroworld library. 
 * @author Marco Jantos
 * 
 */
public class Controller {
		
	private final int firstWaitTime = 1200;
	
	private GuiController guiController;
	private DataController dataController = new DataController();
	private BibKeyListening bibKeyListening;
	
	private boolean gameInit = false;	
	private boolean isSetKeyListener = false;
	
	
	/**
	 * Constructor to init a new Controller
	 */
	public Controller() {
		
		dataController = new DataController();
		
	}
	
	/**
	 * This method initializes a new default game.
	 * @param type  The DefaultLevelType to initialize the game.
	 */
	public void initDefaultGame(UBTMicroworld.DefaultLevelType type) {
		GameDescription gameDescription = DefaultGameDescriptionFactory.generateDefaultLevel(type, this);
		
		initGame(gameDescription);

	}
	
	
	/**
	 * This method initializes a new game.
	 * @param gameDescription  The GameDescription that holds the level data.
	 */
	public void initGame(IGameDescription gameDescription) {
		
		dataController.setWinValidator(gameDescription.getWinValidator());
		dataController.generateNewGameState(gameDescription.getMatchfield());
		
		IGameState gameStateNew = dataController.getGameState();
		
		guiController = new GuiController(this, gameStateNew);
		dataController.registerListener(guiController);
		
		gameInit = true;
		
		ControllerUtil.waitFor(firstWaitTime);	
		
		dataController.validate();
	}
	
	/**
	 * This method sets the time for the delay after moving an agent.
	 * @param delayTime  The new DelayTime.
	 */
	public void setDelayTime(DelayTime delayTime) {
		dataController.setDelayTime(delayTime);
	}
	
	/**
	 * This method registers an agent for a KeyListener.
	 * @param agent  The agent to be taken over for the KeyListener.
	 */
	public void registerAgentForKeyListener(Agent agent) {
		if(!gameInit) {
			System.out.println("Bitte erst Level initialisieren.");
			return;
		}
		if(isSetKeyListener) {
			System.out.println("KeyListener bereits gesetzt.");
			return;
		}
		bibKeyListening = new BibKeyListening(agent);
		
		guiController.registerBibKeyListener(bibKeyListening);
		
		isSetKeyListener = true;
	}	
	
	/**
	 * This method registers two agents for a KeyListener.
	 * @param agent1  The first agent to be taken over for the KeyListener.
	 * @param agent2  The second agent to be taken over for the KeyListener.
	 */
	public void registerAgentForKeyListener(Agent agent1, Agent agent2) {
		if(!gameInit) {
			System.out.println("Bitte erst Level initialisieren.");
			return;
		}
		if(isSetKeyListener) {
			System.out.println("KeyListener bereits gesetzt.");
			return;
		}
		bibKeyListening = new BibKeyListening(agent1, agent2);
		
		guiController.registerBibKeyListener(bibKeyListening);
		
		isSetKeyListener = true;
	}
	
	/**
	 * This method registers a BibKeyListener to get BibKeyEvents.
	 * @param listener  The listener to register.
	 */
	public void registerBibKeyListener(BibKeyEventListener listener) {
		if(!gameInit) {
			System.out.println("Bitte erst Level initialisieren.");
			return;
		}
		guiController.registerBibKeyListener(listener);
	}

	/**
	 * This method changes the path to the TerrainType tile image.
	 * @param terrainType  The TerrainType to change the image of.
	 * @param newPath  The path to the new image.
	 */
	public void changeImagePath(TerrainType terrainType, String newPath) {
		TEXTURE_ID tId = Texture.terrainTypeToTextureId(terrainType);
		tId.changeImagePath(newPath);
	}
	
	/**
	 * This method changes the path to the ObjectType tile image.
	 * @param objectType  The ObjectType to change the image of.
	 * @param newPath  The path to the new image.
	 */
	public void changeImagePath(ObjectType objectType, String newPath) {
		if(objectType.equals(ObjectType.NO_OBJECT)) {
			return;
		}
		
		TEXTURE_ID tId = Texture.objectTypeToTextureId(objectType);
		tId.changeImagePath(newPath);
	}
	
	/**
	 * This method changes the path to the MoveDirection tile image.
	 * @param moveDirection  The MoveDirection to change the image of.
	 * @param newPath  The path to the new image. 
	 */
	public void changeImagePath(MoveDirection moveDirection, String newPath) {
		TEXTURE_ID tId = Texture.moveDirectionToTextureId(moveDirection);
		tId.changeImagePath(newPath);
	}
	
	/**
	 * This method changes the path to the AgentType tile image.
	 * @param agentType  The AgentType to change the image of.
	 * @param newPath  The path to the new image.
	 */
	public void changeImagePath(AgentType agentType, String newPath) {
		TEXTURE_ID tId = Texture.agentTypeToTextureId(agentType);
		tId.changeImagePath(newPath);
	}

	/**
	 * This method returns the list of agents.
	 * @return  The list of agents.
	 */
	public List<Agent> getAgentList(){
		
		return dataController.getAgentList();
	}
	 
	/**
	 * This method ends the game. This failed.
	 */
	public void setGameOver() {
		dataController.setGameOver();
	}
	
	/**
	 * This method ends the game. This is passed.
	 */
	public void setGameFinished() {
		dataController.setGameFinished();
	}
	
	/**
	 * This method returns whether the game is running or not.
	 */
	public boolean isGameRunning() {
		if (dataController == null)	
			return false;
		IGameState gameState = dataController.getGameState();
		if (gameState == null)	
			return false;
		if (gameState.isGameFinished()) 
			return false;
		if (gameState.isGameOver())
			return false;
		return true;
	}
	
	/**
	 * This method returns the current GameState.
	 * @return  The current GameState.
	 */
	public IMatchfield getMatchfield() {
		if(!gameInit) {
			System.out.println("Bitte erst Level initialisieren.");
			return null;
		}
		return dataController.getMatchfield();
	}
	
}
