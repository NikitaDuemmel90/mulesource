package mule.ubtmicroworld.data;

import java.util.ArrayList;
import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;

/**
 * This class holds the current matchfield.
 * @author Marco Jantos
 * 
 */
public class Matchfield implements IMatchfield{
	
	private int dimension;
	
	private ITile[][] tileMap;
	
	private List<ITile> targetTiles;	
	private List<ITile> startTiles;
	
	private TerrainType[][] terrainMap;
	
	private List<IntegerPair> listObjectTiles = new ArrayList<IntegerPair>();
	
	
	public Matchfield(int dimension, TerrainType[][] terrainMap) {
		
		this.terrainMap = terrainMap;
		
		targetTiles = new ArrayList<ITile>();
		
		startTiles = new ArrayList<ITile>();
		
		this.dimension = dimension;
		tileMap = new ITile[dimension][dimension]; 
		
		for(int y = 0; y < dimension; y++) {
			for(int x = 0; x < dimension; x++) {
				
				
				Tile tile = new Tile(terrainMap[y][x], x, y);
				
				tileMap[y][x] = tile;
				
				if(tile.getTerrainType() == TerrainType.TARGET) {
					targetTiles.add(tile);
				}	
				
				if(tile.getTerrainType() == TerrainType.START) {
					startTiles.add(tile);
				}
			}
		}
	}

	
	
	public Matchfield(int dimension, TerrainType[][] terrainMap, ObjectType[][] objectMap) {
		
		this.terrainMap = terrainMap;
		
		targetTiles = new ArrayList<ITile>();
		
		startTiles = new ArrayList<ITile>();
		
		this.dimension = dimension;
		tileMap = new ITile[dimension][dimension]; 
		
		
		for(int y = 0; y < dimension; y++) {
			for(int x = 0; x < dimension; x++) {
				
				Tile tile;
				
				if(objectMap[y][x] != ObjectType.NO_OBJECT) {
					tile = new Tile(terrainMap[y][x], x, y, objectMap[y][x]);
					listObjectTiles.add(new IntegerPair(x, y));
				}
				else {
					tile = new Tile(terrainMap[y][x], x, y);
	
				}
				
				tileMap[y][x] = tile;
				
				if(tile.getTerrainType() == TerrainType.TARGET) {
					targetTiles.add(tile);
				}	
				
				if(tile.getTerrainType() == TerrainType.START) {
					startTiles.add(tile);
				}
			}
		}
	}
	
	@Override
	public List<IntegerPair> getListObjectTiles(){
		return listObjectTiles;
	}


	@Override
	public ITile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= dimension || y >= dimension)
			throw new IllegalArgumentException("Diese Kachel ist nicht gültig.");
		
		return tileMap[y][x];
	}
	

	@Override
	public TerrainType getTerrainType(int x, int y) {
		if(x < 0 || y < 0 || x >= dimension || y >= dimension)
			throw new IllegalArgumentException("Diese Kachel ist nicht gültig.");
		
		return tileMap[y][x].getTerrainType();
	}

	@Override
	public int getDimension() {
		return dimension;
	}

	@Override
	public boolean isTileWalkable(int x, int y) {

		if(x < 0 || y < 0)
			return false;
		
		if(x >= dimension || y >= dimension)
			return false;
		
		if(!getTile(x, y).getTerrainType().isWalkable()) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean isTile(int x, int y) {
		
		if(x < 0 || y < 0)
			return false;
		
		if(x >= dimension || y >= dimension)
			return false;
		
		return true;
	}
	
	@Override
	public List<ITile> getTargetTiles(){
		return targetTiles;
	}
	
	@Override
	public List<ITile> getStartTiles(){
		return startTiles;
	}


	@Override
	public TerrainType[][] getTerrainTypeMap() {
		return terrainMap;
	}


	@Override
	public boolean isObjectOnTile(int x, int y) {
		if(x < 0 || y < 0)
			return false;
		
		if(x >= dimension || y >= dimension)
			return false;
		
		return tileMap[y][x].isObjectOnTile();
	}

	

	@Override
	public ObjectType pickUpObject(int x, int y) {
		
		if(x < 0 || y < 0 || x >= dimension || y >= dimension)
			throw new IllegalArgumentException("Diese Kachel ist nicht gültig.");
		
		return tileMap[y][x].pickUpObject();
	}
	
	@Override
	public ObjectType getObjectOnTile(int x, int y) {
		if(x < 0 || y < 0 || x >= dimension || y >= dimension)
			throw new IllegalArgumentException("Diese Kachel ist nicht gültig.");
		
		return tileMap[y][x].getObject();
	}


	@Override
	public boolean isObjectOnFied() {
		for(int y = 0; y < dimension; y++) {
			for(int x = 0; x < dimension; x++) {
				if(tileMap[y][x].isObjectOnTile()) {
					return true;
				}
			}
		}
		return false;
	}

}