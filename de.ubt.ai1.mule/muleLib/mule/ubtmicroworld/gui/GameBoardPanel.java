package mule.ubtmicroworld.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import mule.ubtmicroworld.UBTMicroworld.LineOfSight;
import mule.ubtmicroworld.data.AgentImpl;
import mule.ubtmicroworld.data.BibKeyEvent;
import mule.ubtmicroworld.data.BibKeyEventEmmitter;
import mule.ubtmicroworld.data.BibKeyEventListener;
import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.data.Matchfield;
import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;
import mule.ubtmicroworld.gui.Texture.TEXTURE_ID;

/**
 * This class represents the GameBoardPanel.
 * @author Marco Jantos
 * 
 */
public class GameBoardPanel  extends JPanel implements GuiEventEmmitter, PanelEventListener, 
		MouseListener, MouseWheelListener, MouseMotionListener, KeyListener, BibKeyEventEmmitter{

	private static final long serialVersionUID = 1L;
	
	private final int tileSize;
	
	private IGameState gameState;
	
	private AffineTransform displayToWorld;
	private Point2D.Double translation = new Point2D.Double(0, 0);
	private Double zoom = 1.0;
	private Double lastZoom = zoom;
	private Double minZoom = 1.0;
	private Double maxZoom = 1.0;
	
	private Double zoomAdaptation = 1.0;
	
	
	private Point2D.Double transForScale = new Point2D.Double(0, 0);
	private Point2D.Double zoomNorm = new Point2D.Double(1.0, 1.0);
	
	private AffineTransform affineTransform = new AffineTransform();
	private AffineTransform totalAffineTransform = new AffineTransform();
	
	private Point clickPos = new Point();
	
	private Point2D.Double MousePos = new Point2D.Double();
	private Point2D.Double offset = new Point2D.Double();
	

	private int currentWidth;
	private int currentHeight;
	
	private int dimension;
	
	private GameMode gameMode = GameMode.GAME_IN_ACTION;
	
	
	protected List<GuiEventListener> listeners = new Vector<GuiEventListener>();
	protected List<BibKeyEventListener> keyListeners = new Vector<BibKeyEventListener>();
	

	public GameBoardPanel(IGameState gameState) {
		this.tileSize = GuiCalculations.getTileSize();
		
		this.gameState = gameState;
		
		this.setMinimumSize(new Dimension(730, 730));
		this.setPreferredSize(new Dimension(730, 730));
		this.setSize(new Dimension(730, 730));
		this.setMaximumSize(new Dimension(730, 730));

		dimension = gameState.getMatchfield().getDimension();
		
		addMouseListener(this);
		addMouseWheelListener(this);
		addMouseMotionListener(this);
		
		this.setFocusable(true);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;	
		
		// Controlling Rendering Quality
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.clearRect(0, 0, getWidth(), getHeight());
		
		// Fix for high- and lowres displays
		final AffineTransform trans = g2.getDeviceConfiguration().getNormalizingTransform();
		g2.setTransform(g2.getDeviceConfiguration().getDefaultTransform());
		g2.transform(trans);
		
		affineTransform = trans;
		
		double scaleNormX = trans.getScaleX();
		double scaleNormY = trans.getScaleY();
		
		// dpiFactor
		double dpiFactorX = g2.getTransform().getScaleX() / trans.getScaleX();
		double dpiFactorY = g2.getTransform().getScaleY() / trans.getScaleY();

		
		//width & height
		int w = this.getWidth();
		int h = this.getHeight();
		
		
		zoomAdaptation = ((double) w / (dimension * tileSize ));
		zoomNorm.x = (zoomAdaptation / scaleNormX) ;
		zoomNorm.y = (zoomAdaptation / scaleNormY) ;
		
		transForScale.x = (int) dimension * tileSize / 2;
		transForScale.y = (int) dimension * tileSize / 2;
		
		// Scale and Translate
		g2.scale(zoomNorm.x, zoomNorm.y);
		g2.translate(transForScale.x , transForScale.y);
		g2.scale(zoom, zoom);
		g2.translate(-transForScale.x + translation.x, -transForScale.y + translation.y);
		
		totalAffineTransform = g2.getTransform();
		

		// displayToWorld (AffineTransform)
		try {
			displayToWorld = g2.getTransform().createInverse();
			displayToWorld.scale(dpiFactorX, dpiFactorY);
		} catch (NoninvertibleTransformException e) {
			displayToWorld = null;
		}
		
		currentWidth = w;
		currentHeight = h;
		
		Matchfield matchfield = (Matchfield) gameState.getMatchfield();
		
		//calculation maxZoom
		int pixel3Tiles = tileSize * 4;
		maxZoom = (double) (((double) dimension * tileSize )/ (double) pixel3Tiles);
		

		for(int x = 0; x < dimension; x++) {
			for(int y = 0; y < dimension; y++) {
				
				TerrainType terrainType = matchfield.getTerrainType(x, y);
				TEXTURE_ID id = Texture.terrainTypeToTextureId(terrainType);
				
				BufferedImage image;
				try {
					image = Texture.getImage(id);
				} catch (IllegalArgumentException ex) {
					System.out.println("Tile -->  "  + ex.getMessage());
					continue;
				}
								
				
				int xx = x * tileSize;
				int yy = y * tileSize;

				BufferedImage imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
				imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
				
				g2.drawImage(imageNew, null, xx, yy);
			
			}
		}
		
		
		for(int x = 0; x < dimension; x++) {
			for(int y = 0; y < dimension; y++) {
				
				g2.setColor(Color.black);
				
				g2.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
				
			}
		}
		
		
	}
	
	public AffineTransform getTotalAffineTransform() {
		return totalAffineTransform;
	}
	
	private void drawAgent(Graphics2D g2, AgentImpl agent) {
		
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
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Object -->  "  + ex.getMessage());
			System.out.println("--------------------------------------------");	
			return;
		}
		
		BufferedImage imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
		g2.drawImage(imageNew, null, x, y);

	}
	

	
	/**
	 * This method tells all registered listeners about an event.
	 * 
	 * @param event   the guiEvent, that should be published
	 */
	private void tellAllListeners(GuiEvent event) {
		listeners.forEach(l -> l.handle(event));
	}


	@Override
	public void handle(PanelEvent event) {
		
	}


	@Override
	public void registerListener(GuiEventListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(GuiEventListener listener) {
		this.listeners.remove(listener);
	}
	
	/**
	 * This method starts the animations
	 */
	public void runAnnimation() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(30);
						revalidate();
						repaint();
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {

		zoom += (-0.04) * arg0.getWheelRotation();
		if (zoom < minZoom)
			zoom = minZoom;
		if (zoom > maxZoom)
			zoom = maxZoom;
		
		repaint();
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		 
		Point2D.Double pointNew = new Point2D.Double(0 , 0);
		displayToWorld.transform(arg0.getPoint(), pointNew);
		
		Point2D.Double clickNew = new Point2D.Double(0 , 0);
		displayToWorld.transform(clickPos, clickNew);
		
			
		translation.x += pointNew.getX() - clickNew.getX();
		translation.y += pointNew.getY() - clickNew.getY();

		clickPos = arg0.getPoint();
		repaint();	
	}
	
	private void tileClicked(Point p) {
		
		if(p.x < 0 || p.y < 0) {
			return;
		}
		
		int tileX = p.x / tileSize;
		int tileY = p.y / tileSize;
		
		if(!gameState.getMatchfield().isTile(tileX, tileY)) {
			return;
		}
		
		GuiEvent guiEvent = new GuiEvent(GuiEventType.TILE_REQUEST);
		guiEvent.addAtribute(GuiEventEnumKey.TILE_POS_X, tileX);
		guiEvent.addAtribute(GuiEventEnumKey.TILE_POS_Y, tileY);
		
		tellAllListeners(guiEvent);
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {

		this.grabFocus();
		
		if (displayToWorld != null) {
			displayToWorld.transform(arg0.getPoint(), MousePos);
			
		}
		

		offset.x = arg0.getX();
		offset.y = arg0.getY();
		
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		clickPos = arg0.getPoint();	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (displayToWorld != null) {
			displayToWorld.transform(arg0.getPoint(), MousePos);
			
			Point p = new Point((int) MousePos.x, (int) MousePos.y);
			
			tileClicked(p);
		}
		repaint();
	}
	
	private void setNormalView() {
		zoom = 1.0;
		translation.x = 0;
		translation.y = 0;
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		//nothing to do here
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		//nothing to do here
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//nothing to do here
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
	}


	@Override
	public void keyReleased(KeyEvent e) {		
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			setNormalView(); 
			break;
		default:
			tellAllListeners(new BibKeyEvent(e));
			break;
		}
	
	}


	@Override
	public void keyTyped(KeyEvent e) {
		//nothing to do here
	}


	@Override
	public void registerListener(BibKeyEventListener listener) {
		this.keyListeners.add(listener);
	}


	@Override
	public void removeListener(BibKeyEventListener listener) {
		this.keyListeners.remove(listener);
	}
	
	/**
	 * This method tells all registered listeners about an event.
	 * 
	 * @param event   the guiEvent, that should be published
	 */
	private void tellAllListeners(BibKeyEvent event) {
		keyListeners.forEach(l -> l.handle(event));
	}
	
}