package mule.ubtmicroworld.gui;

import java.awt.image.BufferedImage;
import java.util.EnumMap;

import mule.ubtmicroworld.UBTMicroworld.MoveDirection;
import mule.ubtmicroworld.data.AgentType;
import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;
import mule.ubtmicroworld.data.PathDirection;


/**
 * This class is responsible for holding and managing image files
 * @author Marco Jantos
 */
public class Texture {

	public enum TEXTURE_ID {
		
		//TerrainType
		TARGET("/mule/ubtmicroworld/img/tile_Target.png"),
		START("/mule/ubtmicroworld/img/tile_Start.png"),
		GRASS("/mule/ubtmicroworld/img/tile_Grass.png"),
		WATER("/mule/ubtmicroworld/img/tile_Water.png"),
		SAND("/mule/ubtmicroworld/img/tile_Sand.png"),
		PATH("/mule/ubtmicroworld/img/tile_Path.png"),
		STONE("/mule/ubtmicroworld/img/tile_Stone.png"),
		SNOW("/mule/ubtmicroworld/img/tile_Snow.png"),
		
		//Agents
		AGENT("/mule/ubtmicroworld/img/Agent.png"),
		AGENT0("/mule/ubtmicroworld/img/Agent0.png"),
		AGENT1("/mule/ubtmicroworld/img/Agent1.png"),
		AGENT2("/mule/ubtmicroworld/img/Agent2.png"),
		AGENT3("/mule/ubtmicroworld/img/Agent3.png"),
		AGENT4("/mule/ubtmicroworld/img/Agent4.png"),
		AGENT5("/mule/ubtmicroworld/img/Agent5.png"),
		AGENT6("/mule/ubtmicroworld/img/Agent6.png"),
		AGENT7("/mule/ubtmicroworld/img/Agent7.png"),
		AGENT8("/mule/ubtmicroworld/img/Agent8.png"),
		AGENT9("/mule/ubtmicroworld/img/Agent9.png"),
		
		//Objects
		KEY("/mule/ubtmicroworld/img/keyRot.png"),

		//Maps
		MAP0("/mule/ubtmicroworld/img/map0_Map.png"),
		MAP1("/mule/ubtmicroworld/img/map1_Map.png"),
		MAP2("/mule/ubtmicroworld/img/map2_Map.png"),
		MAP3("/mule/ubtmicroworld/img/map3_Map.png"),
		MAP4("/mule/ubtmicroworld/img/map4_Map.png"),
		MAP5("/mule/ubtmicroworld/img/map5_Map.png"),
		MAP6("/mule/ubtmicroworld/img/map6_Map.png"),
		MAP7("/mule/ubtmicroworld/img/map7_Map.png"),
		MAP8("/mule/ubtmicroworld/img/map8_Map.png"),
		MAP9("/mule/ubtmicroworld/img/map9_Map.png"),
		MAP10("/mule/ubtmicroworld/img/map10_Map.png"),
		MAP11("/mule/ubtmicroworld/img/map11_Map.png"),
		MAP12("/mule/ubtmicroworld/img/map12_Map.png"),
		MAP13("/mule/ubtmicroworld/img/map13_Map.png"),
		MAP14("/mule/ubtmicroworld/img/map14_Map.png"),
		MAP15("/mule/ubtmicroworld/img/map15_Map.png"),
		MAP16("/mule/ubtmicroworld/img/map16_Map.png"),
		
		
		//ObjectMaps
		MAP0_OBJECTS("/mule/ubtmicroworld/img/map0_MapObjects.png"),
		MAP1_OBJECTS("/mule/ubtmicroworld/img/map1_MapObjects.png"),
		MAP2_OBJECTS("/mule/ubtmicroworld/img/map2_MapObjects.png"),
		MAP3_OBJECTS("/mule/ubtmicroworld/img/map3_MapObjects.png"),
		MAP4_OBJECTS("/mule/ubtmicroworld/img/map4_MapObjects.png"),
		MAP5_OBJECTS("/mule/ubtmicroworld/img/map5_MapObjects.png"),
		MAP6_OBJECTS("/mule/ubtmicroworld/img/map6_MapObjects.png"),
		MAP7_OBJECTS("/mule/ubtmicroworld/img/map7_MapObjects.png"),
		MAP8_OBJECTS("/mule/ubtmicroworld/img/map8_MapObjects.png"),
		MAP9_OBJECTS("/mule/ubtmicroworld/img/map9_MapObjects.png"),
		MAP10_OBJECTS("/mule/ubtmicroworld/img/map10_MapObjects.png"),
		MAP11_OBJECTS("/mule/ubtmicroworld/img/map11_MapObjects.png"),
		MAP12_OBJECTS("/mule/ubtmicroworld/img/map12_MapObjects.png"),
		MAP13_OBJECTS("/mule/ubtmicroworld/img/map13_MapObjects.png"),
		MAP14_OBJECTS("/mule/ubtmicroworld/img/map14_MapObjects.png"),
		MAP15_OBJECTS("/mule/ubtmicroworld/img/map15_MapObjects.png"),
		MAP16_OBJECTS("/mule/ubtmicroworld/img/map16_MapObjects.png"),
		
		
		//creating
		MAP_CREATED("/mule/ubtmicroworld/img/mapCreated_Map.png"),
		MAP_CREATED_OBJECTS("/mule/ubtmicroworld/img/mapCreated_MapObjects.png"),
		
		//MoveDirection
		MOVE_FORWARD("/mule/ubtmicroworld/img/directionForward.png"),
		MOVE_BACK("/mule/ubtmicroworld/img/directionBack.png"),
		MOVE_RIGHT("/mule/ubtmicroworld/img/directionRight.png"),
		MOVE_LEFT("/mule/ubtmicroworld/img/directionLeft.png"),
		MOVE_NONE("/mule/ubtmicroworld/img/directionNone.png"),
		MOVE_INVALID("/mule/ubtmicroworld/img/directionInvalid.png"),
		MOVE_FORWARD_INVALID("/mule/ubtmicroworld/img/directionForwardInvalid.png"),
		MOVE_BACK_INVALID("/mule/ubtmicroworld/img/directionBackInvalid.png"),

		//Path
		PATH_UP("/mule/ubtmicroworld/img/path_up.png"),
		PATH_DOWN("/mule/ubtmicroworld/img/path_down.png"),
		PATH_RIGHT("/mule/ubtmicroworld/img/path_right.png"),
		PATH_LEFT("/mule/ubtmicroworld/img/path_left.png"),
		PATH_MIDDLE("/mule/ubtmicroworld/img/path_middle.png"),
		PATH_NON("/mule/ubtmicroworld/img/path_non.png"),
		
		;
		
		private String fileName;
		private String fileNameNew = "";
		private boolean isSetFileNameNew = false;


		/**
		 * This method generates a new TEXTURE_ID
		 * @param fileName  the fileName
		 */
		TEXTURE_ID(String fileName) {
			this.fileName = fileName;
		}
		
		/**
		 * This method changes the path of an image.
		 * @param path
		 */
		public void changeImagePath(String path) {
			fileNameNew = path;
			isSetFileNameNew = true;			
		}
		

		/**
		 * This method returns the file name
		 * @return fileName
		 */
		String getFileName() {
			return fileName;
		}
		
		String getFileNameNew() {
			return fileNameNew;
		}
		
		boolean isSetFileNameNew() {
			return isSetFileNameNew;
		}
	}
	
	private static EnumMap<TEXTURE_ID, BufferedImage> imageMap = new EnumMap<TEXTURE_ID, BufferedImage>(TEXTURE_ID.class);

	/**
	 * This method returns a BufferedImage
	 * @param id  the TEXTURE_ID
	 * @return BufferedImage
	 */
	public static BufferedImage getImage(TEXTURE_ID id) {
		
		boolean isNewName = false;
		if (!imageMap.containsKey(id)) {
			String path = "";
			try {
				if(id.isSetFileNameNew()) {
					path = id.getFileNameNew();
					isNewName = true;
				}
				else {
					path = id.getFileName();
				}
				
				imageMap.put(id, Imageloader.loadImage(path));
			} catch (IllegalArgumentException ex) {
				
				if(!isNewName) {
					System.out.println("--------------Error-Message-----------------");
					System.out.println("Schwerwiegender Fehler.");
					System.out.println("Bild: " + id.toString());
					System.out.println("Pfad: " + path + " konnte nicht geladen werden.");
					System.out.println("Anwendung muss geschlossen werden.");
					System.out.println("--------------------------------------------");
					System.exit(0);
				}
				
				if(id == TEXTURE_ID.MAP_CREATED || id == TEXTURE_ID.MAP_CREATED_OBJECTS) {
					System.out.println("--------------Error-Message-----------------");
					System.out.println("Bild: " + id.toString());
					System.out.println("Pfad: " + path + " konnte nicht geladen werden.");
					System.out.println("--------------------------------------------");
					throw ex;
				}
				String errorPath = path;
				path = id.getFileName();
				try {
					imageMap.put(id, Imageloader.loadImage(path));
					System.out.println("--------------Error-Message-----------------");
					System.out.println("Problem beim Laden eines veränderten Bildes.");
					System.out.println("Bild: " + id.toString());
					System.out.println("Pfad: " + errorPath + " konnte nicht geladen werden.");
					System.out.println("Stattdessen wird das ursprüngliche Bild geladen.");
					System.out.println("--------------------------------------------");
					
				} catch (IllegalArgumentException exx) {
					System.out.println("--------------Error-Message-----------------");
					System.out.println("Schwerwiegender Fehler.");
					System.out.println("Bild: " + id.toString());
					System.out.println("Pfad: " + path + " konnte nicht geladen werden.");
					System.out.println("Anwendung muss geschlossen werden.");
					System.out.println("--------------------------------------------");
					System.exit(0);		
				}

			}
			
		}
		return imageMap.get(id);
		
	}
	
	public static TEXTURE_ID agentTypeToTextureId(AgentType agentType) {
		
		switch(agentType) {
		case AGENT0:
			return TEXTURE_ID.AGENT0;
		case AGENT1:
			return TEXTURE_ID.AGENT1;
		case AGENT2:
			return TEXTURE_ID.AGENT2;
		case AGENT3:
			return TEXTURE_ID.AGENT3;
		case AGENT4:
			return TEXTURE_ID.AGENT4;
		case AGENT5:
			return TEXTURE_ID.AGENT5;
		case AGENT6:
			return TEXTURE_ID.AGENT6;
		case AGENT7:
			return TEXTURE_ID.AGENT7;
		case AGENT8:
			return TEXTURE_ID.AGENT8;
		case AGENT9:
			return TEXTURE_ID.AGENT9;
		case AGENT:
			return TEXTURE_ID.AGENT;
		default:
			return TEXTURE_ID.AGENT;
		
		}
	}
	
	public static TEXTURE_ID agentIdToTextureId(int id) {
		if(id == 0) {
			return TEXTURE_ID.AGENT0;
		}
		else if(id == 1) {
			return TEXTURE_ID.AGENT1;
		}
		else if(id == 2) {
			return TEXTURE_ID.AGENT2;
		}
		else if(id == 3) {
			return TEXTURE_ID.AGENT3;
		}
		else if(id == 4) {
			return TEXTURE_ID.AGENT4;
		}
		else if(id == 5) {
			return TEXTURE_ID.AGENT5;
		}
		else if(id == 6) {
			return TEXTURE_ID.AGENT6;
		}
		else if(id == 7) {
			return TEXTURE_ID.AGENT7;
		}
		else if(id == 8) {
			return TEXTURE_ID.AGENT8;
		}
		else if(id == 9) {
			return TEXTURE_ID.AGENT9;
		}
		return TEXTURE_ID.AGENT;
	}
	
	public static TEXTURE_ID terrainTypeToTextureId(TerrainType type) {
		switch (type) {
		case GRASS:
			return TEXTURE_ID.GRASS;
		case PATH:
			return TEXTURE_ID.PATH;
		case SAND:
			return TEXTURE_ID.SAND;
		case WATER:
			return TEXTURE_ID.WATER;
		case STONE:
			return TEXTURE_ID.STONE;
		case TARGET:
			return TEXTURE_ID.TARGET;
		case SNOW:
			return TEXTURE_ID.SNOW;
		case START:
			return TEXTURE_ID.START;
		default:
			break;
		
		}
		return TEXTURE_ID.WATER;
	}
	
	public static TEXTURE_ID objectTypeToTextureId(ObjectType type) {
		switch(type) {
		case NO_OBJECT:
			return null;
		case KEY:
			return TEXTURE_ID.KEY;
		default:
			return TEXTURE_ID.KEY;
		}
	}
	
	public static TEXTURE_ID moveDirectionToTextureId(MoveDirection type) {
		switch(type) {
		case BACK:
			return TEXTURE_ID.MOVE_BACK;
		case FORWARD:
			return TEXTURE_ID.MOVE_FORWARD;
		case LEFT:
			return TEXTURE_ID.MOVE_LEFT;
		case NONE:
			return TEXTURE_ID.MOVE_NONE;
		case RIGHT:
			return TEXTURE_ID.MOVE_RIGHT;
		case INVALID:
			return TEXTURE_ID.MOVE_INVALID;
		case BACK_INVALID:
			return TEXTURE_ID.MOVE_BACK_INVALID;
		case FORWARD_INVALID:
			return TEXTURE_ID.MOVE_FORWARD_INVALID;
		default:
			return TEXTURE_ID.MOVE_NONE;
		
		}
	}
	
	public static TEXTURE_ID pathDirectionToTextureId(PathDirection type) {
		switch(type) {
		case DOWN:
			return TEXTURE_ID.PATH_DOWN;
		case LEFT:
			return TEXTURE_ID.PATH_LEFT;
		case RIGTH:
			return TEXTURE_ID.PATH_RIGHT;
		case UP:
			return TEXTURE_ID.PATH_UP;
		default:

			throw new IllegalArgumentException("Fehler in pathDirectionToTextureId");		
		}
	}
}