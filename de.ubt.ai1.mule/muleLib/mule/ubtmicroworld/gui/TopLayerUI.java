package mule.ubtmicroworld.gui;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.plaf.LayerUI;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.UBTMicroworld.LineOfSight;
import mule.ubtmicroworld.UBTMicroworld.MoveDirection;
import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.IntegerPair;
import mule.ubtmicroworld.data.Matchfield;
import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.gui.Texture.TEXTURE_ID;

/**
 * This class is a TopLayerUI.
 * @author Marco Jantos
 * 
 */
public class TopLayerUI extends LayerUI<JPanel> implements PanelEventListener{

	private static final long serialVersionUID = 1L;
	
	private final int tileSize;
	private final int dimension;
	
	private IGameState gameState;
	private GameBoardPanel boardPanel;
	private GameMode gameMode = GameMode.GAME_IN_ACTION;
	
	private List<IntegerPair> listObjectTiles;
	
	private Agent agentForReplay;
	private int stepsAgentForReplay = 0;

	private AffineTransform totalAffineTransform = new AffineTransform();
	
	public TopLayerUI(IGameState gameState, GameBoardPanel boardPanel) {
		this.tileSize = GuiCalculations.getTileSize();
		dimension = gameState.getMatchfield().getDimension();
		
		
		this.gameState = gameState;
		this.boardPanel = boardPanel;
		
		listObjectTiles = gameState.getMatchfield().getListObjectTiles();
			
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		Graphics2D g2 = (Graphics2D) g;
		
		
		this.totalAffineTransform = boardPanel.getTotalAffineTransform();
		g2.setTransform(totalAffineTransform);
		
		
		if(gameMode == GameMode.GAME_REPLAY) {
			drawReplay(g2);
			return;
		}

		Matchfield matchfield = (Matchfield) gameState.getMatchfield();
		
		for(int x = 0; x < dimension; x++) {
			for(int y = 0; y < dimension; y++) {								
				
				if(matchfield.isObjectOnTile(x, y)) {
					
					int xx = x * tileSize;
					int yy = y * tileSize;
					
					ObjectType objectType = matchfield.getObjectOnTile(x, y);
					drawObject(g2, xx, yy, objectType);
				}
			}
		}

		List<Agent> agentList = gameState.getAgentList();
		
		for(Agent agent : agentList) {
			drawAgent(g2, agent);
		}
		
		
	}
	
	
	private void drawReplay(Graphics2D g2) {
		
		for(IntegerPair pair : listObjectTiles) {
			int xxPos = pair.getFirst() * tileSize;
			int yyPos = pair.getSecond() * tileSize;
			
			BufferedImage image = Texture.getImage(TEXTURE_ID.KEY);
			BufferedImage imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
			imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
			g2.drawImage(imageNew, null, xxPos, yyPos);
		}
		
		int x = agentForReplay.getXstartPosition();
		int y = agentForReplay.getYstartPosition();
		LineOfSight lOsight = agentForReplay.getLineOfsightStart();
		
		int xPos = x * tileSize;
		int yPos = y * tileSize;
		
		BufferedImage image = Texture.getImage(TEXTURE_ID.PATH_MIDDLE);
		BufferedImage imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
		g2.drawImage(imageNew, null, xPos, yPos);
		
		int xOld= x;
		int yOld = y;
		LineOfSight lOfSightOld = lOsight;
		
		ReplayPathData data;
		int counter = 1;
		for(MoveDirection moveDirection : agentForReplay.getMoveDirectionList()) {
			if(counter > stepsAgentForReplay) {
				break;
			}
			
			data = generateNextPathStep(moveDirection, lOsight, x, y);
			x = data.getX();
			y = data.getY();
			lOsight = data.getLineOfSight();
			
			
			if(moveDirection == MoveDirection.FORWARD || moveDirection == MoveDirection.BACK) {
				
				TEXTURE_ID eId1;
				TEXTURE_ID eId2;
				switch (lOfSightOld) {
				case NORTH:
					eId1 = TEXTURE_ID.PATH_UP;
					eId2 = TEXTURE_ID.PATH_DOWN;
					break;
				case EAST:
					eId1 = TEXTURE_ID.PATH_RIGHT;
					eId2 = TEXTURE_ID.PATH_LEFT;
					break;
				case SOUTH:
					eId1 = TEXTURE_ID.PATH_DOWN;
					eId2 = TEXTURE_ID.PATH_UP;
					break;
				case WEST:
					eId1 = TEXTURE_ID.PATH_LEFT;
					eId2 = TEXTURE_ID.PATH_RIGHT;
					break;
				default:
					eId1 = TEXTURE_ID.PATH_NON;
					eId2 = TEXTURE_ID.PATH_NON;
					break;
				
				}
				
				if(moveDirection == MoveDirection.BACK) {
					TEXTURE_ID id = eId1;
					eId1 = eId2;
					eId2 = id;
				}
				
				xPos = xOld * tileSize;
				yPos = yOld * tileSize;
								
				image = Texture.getImage(eId1);
				imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
				imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
				g2.drawImage(imageNew, null, xPos, yPos);
				
				
				
				xPos = x * tileSize;
				yPos = y * tileSize;
				
				image = Texture.getImage(TEXTURE_ID.PATH_MIDDLE);
				imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
				imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
				g2.drawImage(imageNew, null, xPos, yPos);
								
				image = Texture.getImage(eId2);
				imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
				imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
				g2.drawImage(imageNew, null, xPos, yPos);
	
			}			
			
			counter++;
			xOld= x;
			yOld = y;
			lOfSightOld = lOsight;
		}
		drawAgent(g2, agentForReplay, x, y, lOsight);
	}
	
	private ReplayPathData generateNextPathStep(MoveDirection moveDirection, LineOfSight lineOfSight, int x, int y) {
		
		switch(moveDirection) {
		case BACK:
			//lineOfSight 
			switch(lineOfSight) {
			case NORTH:
				y++;
				break;
			case EAST:
				x--;
				break;
			case SOUTH:
				y--;
				break;
			case WEST:
				x++;
				break;
			default:
				break;
			}
			break;
		case FORWARD:
			//lineOfSight 
			switch(lineOfSight) {
			case NORTH:
				y--;
				break;
			case EAST:
				x++;
				break;
			case SOUTH:
				y++;
				break;
			case WEST:
				x--;
			default:
				break;
			}
			break;
		case LEFT:
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
			break;
		case RIGHT:
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
			break;
		case NONE:
			//lineOfSight
			break;
		case INVALID:
			//lineOfSight
			break;
		default:
			break;
		
		}
		return new ReplayPathData(lineOfSight, x, y);
	}

	
	private void drawAgent(Graphics2D g2, Agent agent, int agentX, int agentY, LineOfSight lineOfSight) {
		
		int tansformX = (agentX ) * tileSize + tileSize / 2;
		int tansformY = (agentY ) * tileSize + tileSize / 2;
		
		g2.translate(tansformX, tansformY);
		g2.rotate(Math.toRadians(GuiCalculations.lineOfSightToDeg(lineOfSight)));
		
		TEXTURE_ID eId = Texture.agentIdToTextureId(agent.getID());
		BufferedImage image = Texture.getImage(eId);
		BufferedImage imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
		g2.drawImage(imageNew, null, - tileSize / 2, - tileSize / 2 );
		
		g2.rotate(-Math.toRadians(GuiCalculations.lineOfSightToDeg(lineOfSight)));
		g2.translate(-tansformX, -tansformY);
	
	}
	

	private void drawAgent(Graphics2D g2, Agent agent) {
		
		int agentX = agent.getXPosition();
		int agentY = agent.getYPosition();
		LineOfSight lineOfSight = agent.getLineOfSight();
		
		int tansformX = (agentX ) * tileSize + tileSize / 2;
		int tansformY = (agentY ) * tileSize + tileSize / 2;
		
		g2.translate(tansformX, tansformY);
		g2.rotate(Math.toRadians(GuiCalculations.lineOfSightToDeg(lineOfSight)));
		
		TEXTURE_ID eId = Texture.agentIdToTextureId(agent.getID());
		BufferedImage image = Texture.getImage(eId);
		BufferedImage imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
		g2.drawImage(imageNew, null, - tileSize / 2, - tileSize / 2 );
		
		g2.rotate(-Math.toRadians(GuiCalculations.lineOfSightToDeg(lineOfSight)));
		g2.translate(-tansformX, -tansformY);
	
	}
	
	private void drawObject(Graphics2D g2, int x, int y, ObjectType objectType) {
		
		if(objectType == ObjectType.NO_OBJECT) {
			return;
		}
		
		TEXTURE_ID tId = Texture.objectTypeToTextureId(objectType);
		
		BufferedImage image;
		try {
			image = Texture.getImage(tId);
		} catch (IllegalArgumentException ex) {
			System.out.println("Object -->  "  + ex.getMessage());
			return;
		}
		
		BufferedImage imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
		g2.drawImage(imageNew, null, x, y);

	}
	
	

	@Override
	public void handle(PanelEvent event) {
		switch(event.getType()) {
		case GAME_PANEL:
			break;
		case START_REPLAY:
			int agentId = event.getFirstAttributeInteger(PanelEventEnumKey.AGENT_ID);
			int steps = event.getFirstAttributeInteger(PanelEventEnumKey.STEPS);
			
			agentForReplay = gameState.getAgentList().get(agentId);
			this.stepsAgentForReplay = steps;
			
			
			this.gameMode = GameMode.GAME_REPLAY;
			break;
		case STOP_REPLAY:
			this.gameMode = GameMode.GAME_IN_ACTION;
			break;
		case TILE_REQUEST_ANSWER:
			break;
		default:
			break;
			
		}	
	}
}