package mule.ubtmicroworld.data;

import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;

public interface ITile {
	
	/**
	 * This method returns the TerrainType of the tile.
	 * @return  TerrainType.
	 */
	public TerrainType getTerrainType();
	
	/**
	 * This method returns the x position of the tile.
	 * @return  x position.
	 */
	public int getXPos();

	/**
	 * This method returns the y position of the tile.
	 * @return  y position.
	 */
	public int getYPos();
	
	/**
	 * This method returns whether there is an object on the tile.
	 * @return  true if there is an object on the tile, false otherwise.
	 */
	public boolean isObjectOnTile();
	
	/**
	 * This method returns the ObjectType of the tile.
	 * The object is also deleted from the tile.
	 * @return  ObjectType.
	 */
	public ObjectType pickUpObject();
	
	/**
	 * This method returns the ObjectType of the tile.
	 * @return  ObjectType.
	 */
	public ObjectType getObject();
}
