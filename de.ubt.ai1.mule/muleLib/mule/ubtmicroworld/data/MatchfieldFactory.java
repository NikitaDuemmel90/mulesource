package mule.ubtmicroworld.data;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;
import mule.ubtmicroworld.gui.Texture;
import mule.ubtmicroworld.gui.Texture.TEXTURE_ID;

/**
 * This class is a factory for a Matchfield. 
 * @author Marco Jantos
 * 
 */
public class MatchfieldFactory {
	
	/*
	 * TerrainType  -  Color ( r - g - b)
	 * 		Gras	-	0,		255,	0	
	 * 		Sand	-	255, 	255, 	0
	 * 		Water	-	0,		0,		255	
	 * 		Stone	-	255,	0,		255
	 * 		Snow	-	0,		255,	255
	 * 		Path	-	255, 	0, 		0
	 * 		Target	-	0,		0, 		0
	 * 		Start	-	255,	255,	255
	 * 		
	 */	
	
	/*
	 * ObjectType  -  Color ( r - g - b)
	 * 		KEY	   -	0,		0,		0
	 */
	private static Map<Integer, TerrainType> mapRgbIntToTerrainType = new HashMap<Integer, TerrainType>(){
		{
			put(new Color(0, 255, 0).getRGB(), TerrainType.GRASS);
			put(new Color(255, 255, 0).getRGB(), TerrainType.SAND);
			put(new Color(0, 0, 255).getRGB(), TerrainType.WATER);
			put(new Color(255, 0, 255).getRGB(), TerrainType.STONE);
			put(new Color(0, 255, 255).getRGB(), TerrainType.SNOW);
			put(new Color(255, 0, 0).getRGB(), TerrainType.PATH);
			put(new Color(0, 0, 0).getRGB(), TerrainType.TARGET);
			put(new Color(255, 255, 255).getRGB(), TerrainType.START);
		}
	};
	
	
	private static Map<Integer, ObjectType> mapRgbIntToObjectType = new HashMap<Integer, ObjectType>(){
		{
			//put(new Color(255, 255, 255).getRGB(), ObjectType.NO_OBJECT);
			put(new Color(0, 0, 0).getRGB(), ObjectType.KEY);
		}
	};

	
	/**
	 * This method generates and returns a Matchfield by default MatchfieldtempType.
	 * @param type  MatchfieldTempType.
	 * @return  The generated Matchfield.
	 */
	public static Matchfield generateMatchfield(MatchfieldTempType type) {
		
		switch(type) {
		case LEVEL0:
			return generateMatchfieldLevel0();
		case LEVEL1:
			return generateMatchfieldLevel(TEXTURE_ID.MAP1);
		case LEVEL2:
			return generateMatchfieldLevel(TEXTURE_ID.MAP2);
		case LEVEL3:
			return generateMatchfieldLevel(TEXTURE_ID.MAP3);
		case LEVEL4:
			return generateMatchfieldLevel(TEXTURE_ID.MAP4);
		case LEVEL5:
			return generateMatchfieldLevel(TEXTURE_ID.MAP5);
		case LEVEL6:
			return generateMatchfieldLevel(TEXTURE_ID.MAP6, TEXTURE_ID.MAP6_OBJECTS);
		case LEVEL7:
			return generateMatchfieldLevel(TEXTURE_ID.MAP7, TEXTURE_ID.MAP7_OBJECTS);
		case LEVEL8:
			return generateMatchfieldLevel(TEXTURE_ID.MAP8, TEXTURE_ID.MAP8_OBJECTS);
		case LEVEL9:
			return generateMatchfieldLevel(TEXTURE_ID.MAP9, TEXTURE_ID.MAP9_OBJECTS);
		case LEVEL10:
			return generateMatchfieldLevel(TEXTURE_ID.MAP10);
		case LEVEL11:
			return generateMatchfieldLevel(TEXTURE_ID.MAP11);
		case LEVEL12:
			return generateMatchfieldLevel(TEXTURE_ID.MAP12, TEXTURE_ID.MAP12_OBJECTS);
		case LEVEL13:
			return generateMatchfieldLevel(TEXTURE_ID.MAP13);
		case LEVEL14:
			return generateMatchfieldLevel(TEXTURE_ID.MAP14, TEXTURE_ID.MAP14_OBJECTS);
		case LEVEL15:
			return generateMatchfieldLevel(TEXTURE_ID.MAP15, TEXTURE_ID.MAP15_OBJECTS);
		case LEVEL16:
			return generateMatchfieldLevel(TEXTURE_ID.MAP16, TEXTURE_ID.MAP16_OBJECTS);
		default:
			return generateMatchfieldLevel0();
		}
		
	}
	
	/**
	 * This method generates and returns a Matchfield.
	 * @param terrainMap A two-dimensional array that defines the TerrainMap.
	 * @param objectMap  A two-dimensional array that defines the ObjectMap.
	 * @return  The generated Matchfield.
	 */
	public static Matchfield generateMatchfield(TerrainType[][] terrainMap, ObjectType[][] objectMap) {
		int terrainX = terrainMap.length;
		int terrainY = terrainMap[0].length;
		
		int objectX = objectMap.length;
		int objectY = objectMap[0].length;
		
		if(!testImageWidthHeight(terrainX, terrainY)) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Fehler TerrainType[][]-Map.");
			System.out.println("Stattdessen wird Matchfield Level0 geladen.");
			System.out.println("--------------------------------------------");
			return generateMatchfieldLevel0();
		}
		
		if(!testImageWidthHeight(objectX, objectY)) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Fehler ObjectType[][]-Map.");
			System.out.println("Stattdessen wird Matchfield Level0 geladen.");
			System.out.println("--------------------------------------------");
			return generateMatchfieldLevel0();
		}
		
		
		if(terrainX != objectX || terrainY != objectY) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Fehler: #TerrainType[][] != #ObjectType[][]");
			System.out.println("Stattdessen wird Matchfield Level0 geladen.");
			System.out.println("--------------------------------------------");
			return generateMatchfieldLevel0();
		}
		
		
		Matchfield matchfield = new Matchfield(terrainX, terrainMap, objectMap);
		
		return matchfield;
	}
	
	/**
	 * This method generates and returns a Matchfield.
	 * @param terrainMap  A two-dimensional array that defines the TerrainMap.
	 * @return  The generated Matchfield.
	 */
	public static Matchfield generateMatchfield(TerrainType[][] terrainMap) {
		int terrainX = terrainMap.length;
		int terrainY = terrainMap[0].length;
		
		if(!testImageWidthHeight(terrainX, terrainY)) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Fehler TerrainType[][]-Map.");
			System.out.println("Stattdessen wird Matchfield Level0 geladen.");
			System.out.println("--------------------------------------------");
			return generateMatchfieldLevel0();
		}		
		
		Matchfield matchfield = new Matchfield(terrainX, terrainMap);
		
		return matchfield;
	}
	
	/**
	 * This method generates and returns a Matchfield.
	 * @param terrainMapPath  The path to an image from which the TerrainMap is to be created.
	 * @return  The generated Matchfield.
	 */
	public static Matchfield generateMatchfield(String terrainMapPath) {
		
		Texture.TEXTURE_ID.MAP_CREATED.changeImagePath(terrainMapPath);
		
		TerrainType[][] terrainMap = generateTerrainMapFromImageMap(TEXTURE_ID.MAP_CREATED);
		int dimensionTerrain = terrainMap.length;
		
		Matchfield matchfield = new Matchfield(dimensionTerrain, terrainMap);

		return matchfield;
	}
	
	/**
	 * This method generates and returns a Matchfield.
	 * @param terrainMapPath  The path to an image from which the TerrainMap is to be created.
	 * @param objectMapPath  The path to an image from which the ObjectMap is to be created.
	 * @return  The generated Matchfield.
	 */
	public static Matchfield generateMatchfield(String terrainMapPath, String objectMapPath) {
		
		Texture.TEXTURE_ID.MAP_CREATED.changeImagePath(terrainMapPath);
		Texture.TEXTURE_ID.MAP_CREATED_OBJECTS.changeImagePath(objectMapPath);
		
		TerrainType[][] terrainMap = generateTerrainMapFromImageMap(TEXTURE_ID.MAP_CREATED);
		int dimensionTerrain = terrainMap.length;
		
		ObjectType[][] objectMap = generateObjectMapFromImageMap(TEXTURE_ID.MAP_CREATED_OBJECTS);
		int dimensionObjects = objectMap.length;
		
		if(dimensionTerrain != dimensionObjects) {
			Matchfield matchfield = new Matchfield(dimensionTerrain, terrainMap);
			return matchfield;
		}
		
		Matchfield matchfield = new Matchfield(dimensionTerrain, terrainMap, objectMap);
		
		return matchfield;
	}

	/*
	 * Only for demo
	 */
	private static Matchfield generateMatchfieldLevel0() {
		
		int dimension = 7;
		TerrainType[][] terrainMap = generateBasicTerrainMap(dimension);
		
		terrainMap[3][5] = TerrainType.TARGET;
		terrainMap[3][1] = TerrainType.START;
				
		Matchfield matchfield = new Matchfield(dimension, terrainMap);
		
		return matchfield;
	}
	
	
	private static Matchfield generateMatchfieldLevel(TEXTURE_ID terrainMapIn, TEXTURE_ID objectMapIn) {
		TerrainType[][] terrainMap = generateTerrainMapFromImageMap(terrainMapIn);
		int dimensionTerrain = terrainMap.length;
		
		ObjectType[][] objectMap = generateObjectMapFromImageMap(objectMapIn);
		int dimensionObjects = objectMap.length;
		
		if(dimensionTerrain != dimensionObjects) {
			Matchfield matchfield = new Matchfield(dimensionTerrain, terrainMap);
			return matchfield;
		}
		
		Matchfield matchfield = new Matchfield(dimensionTerrain, terrainMap, objectMap);
		
		return matchfield;
	}
	
	
	private static Matchfield generateMatchfieldLevel(TEXTURE_ID terrainMapIn) {
		TerrainType[][] terrainMap = generateTerrainMapFromImageMap(terrainMapIn);
		int dimensionTerrain = terrainMap.length;
		
		Matchfield matchfield = new Matchfield(dimensionTerrain, terrainMap);

		return matchfield;
	}
	
	
	private static TerrainType[][] generateBasicTerrainMap(int dimension){

		TerrainType[][] terrainMap = new TerrainType[dimension][dimension];
		for(int i = 0; i < dimension; i++) {
			for(int u = 0; u < dimension; u++) {
				terrainMap[i][u] = TerrainType.GRASS;
				
			}
		}
		
		return terrainMap;
	}
	
	
	private static ObjectType[][] generateBasicObjectMap(int dimension){

		ObjectType[][] terrainMap = new ObjectType[dimension][dimension];
		for(int i = 0; i < dimension; i++) {
			for(int u = 0; u < dimension; u++) {
				terrainMap[i][u] = ObjectType.NO_OBJECT;
			}
		}
		
		return terrainMap;
	}
	
	private static ObjectType[][] generateObjectMapFromImageMap(TEXTURE_ID tId){
		
		BufferedImage image = null;
		boolean isImage = true;
		
		try {
			image = Texture.getImage(tId);
		}
		catch(Exception e) {
			isImage = false;
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Fehler beim Erstellen der ObjectType[][]-Map.");
			System.out.println("Stattdessen wird BasicMap geladen.");
			System.out.println("--------------------------------------------");
		}
		
		ObjectType[][] objectMap;
		
		if(!isImage || image == null) {
			int dimension = 5;
			objectMap = generateBasicObjectMap(dimension);
			return objectMap;
		}
		
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		
		if(!testImageWidthHeight(imageWidth, imageHeight)) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println(tId + " Bild entspricht nicht dem Standard.");
			System.out.println("Stattdessen wird BasicMap geladen.");
			System.out.println("--------------------------------------------");
			
			int dimension = 5;
			objectMap = generateBasicObjectMap(dimension);
			return objectMap;
		}
		
		int dimension = imageWidth; // == imgageHeight
		
		objectMap = generateBasicObjectMap(dimension); //Vorbelegung
		
		for(int xx = 0; xx < dimension; xx++) {
			for(int yy = 0; yy < dimension; yy++) {
				
				int rgbComparison = image.getRGB(xx, yy);
				if(!mapRgbIntToObjectType.containsKey(rgbComparison)) {
					continue;
				}
				
				ObjectType objectType = mapRgbIntToObjectType.get(rgbComparison);
				objectMap[yy][xx] = objectType;
				
			}
		}
		
		return objectMap;
	}
	
	private static TerrainType[][] generateTerrainMapFromImageMap(TEXTURE_ID tId){
		
		BufferedImage image = null;
		boolean isImage = true;
		
		try {
			image = Texture.getImage(tId);
		}
		catch(Exception e) {
			isImage = false;
			
			System.out.println("--------------Error-Message-----------------");
			System.out.println("Fehler beim Erstellen der TerrainType[][]-Map.");
			System.out.println("Stattdessen wird BasicMap geladen.");
			System.out.println("--------------------------------------------");	
		}
		
		TerrainType[][] terrainMap;
		
		if(!isImage) {
			int dimension = 5;
			terrainMap = generateBasicTerrainMap(dimension);
			return terrainMap;
		}
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		
		if(!testImageWidthHeight(imageWidth, imageHeight)) {
			System.out.println("--------------Error-Message-----------------");
			System.out.println(tId + " Bild entspricht nicht dem Standard.");
			System.out.println("Stattdessen wird BasicMap geladen.");
			System.out.println("--------------------------------------------");
			
			int dimension = 5;
			terrainMap = generateBasicTerrainMap(dimension);
			return terrainMap;
		}
		
		int dimension = imageWidth; // == imgageHeight
		
		terrainMap = generateBasicTerrainMap(dimension); //Vorbelegung
		
		for(int xx = 0; xx < dimension; xx++) {
			for(int yy = 0; yy < dimension; yy++) {
				
				int rgbComparison = image.getRGB(xx, yy);
				if(!mapRgbIntToTerrainType.containsKey(rgbComparison)) {
					System.out.println("Fehler bei (x/y) - " + xx + "  /  " + yy);
					continue;
				}
				
				TerrainType terrainType = mapRgbIntToTerrainType.get(rgbComparison);
				terrainMap[yy][xx] = terrainType;
				
			}
		}
		
		return terrainMap;
	}
	
	private static boolean testImageWidthHeight(int width, int height) {
		if(width < 5 || height < 5 || width > 32 || height > 32 || width != height) {
			return false;
		}
		return true;
	}	
	
}
