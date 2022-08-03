package mule.ubtmicroworld.data;

import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;

/**
 * This class specifies a tile.
 * @author Marco Jantos
 * 
 */
public class Tile implements ITile{
	
	private TerrainType terrainType;
	
	private int xPos;
	private int yPos;
	
	private boolean objectIsOnTile = false;
	private ObjectType object = ObjectType.NO_OBJECT;
	
	public Tile(TerrainType terrainType, int x, int y) {
		this.terrainType = terrainType;
		this.xPos = x;
		this.yPos = y;
		this.objectIsOnTile = false;
	}
	
	public Tile(TerrainType terrainType, int x, int y, ObjectType objectType) {
		this.terrainType = terrainType;
		this.xPos = x;
		this.yPos = y;
		this.objectIsOnTile = true;
		this.object = objectType;
	}
	
	
	@Override
	public TerrainType getTerrainType() {
		return this.terrainType;
	}

	@Override
	public int getXPos() {
		return xPos;
	}

	@Override
	public int getYPos() {
		return yPos;
	}

	@Override
	public boolean isObjectOnTile() {
		return objectIsOnTile;
	}

	@Override
	public ObjectType pickUpObject() {
		if(isObjectOnTile()) {
			ObjectType type = object;
			object = ObjectType.NO_OBJECT;
			objectIsOnTile = false;
			return type;
		}
		return null;
	}
	
	private void setIsObjectOnTile(boolean objectOnTile) {
		objectIsOnTile = objectOnTile;
	}

	@Override
	public ObjectType getObject() {
		return object;
	}

}