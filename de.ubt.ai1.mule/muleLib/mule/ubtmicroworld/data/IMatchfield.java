package mule.ubtmicroworld.data;

import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.ObjectType;
import mule.ubtmicroworld.UBTMicroworld.TerrainType;

/**
 * 
 * @author Marco Jantos
 *
 */
public interface IMatchfield {
	
	/**
	 * This method returns a tile of type ITile.
	 * @param x  x-position of the tile.
	 * @param y  y-position of the tile.
	 * @return  the tile itself.
	 */
	public ITile getTile(int x, int y);
	
	/**
	 * This method returns the TerrainType of a tile.
	 * @param x  x-position of the tile.
	 * @param y  y-position of the tile.
	 * @return  the TerrainType of the tile.
	 */
	public TerrainType getTerrainType(int x, int y);
	
	/**
	 * This method returns a two dimensional array of all TerrainTypes.
	 * @return  two dimensional array.
	 */
	public TerrainType[][] getTerrainTypeMap();
	
	/**
	 * This method returns the number of horizontal/vertical tiles in the matchfield.
	 * @return  number of horizontal/vertical tiles.
	 */
	public int getDimension();
	
	/**
	 * This method returns whether a tile is walkable.
	 * @param x  x-position of the tile.
	 * @param y  y-position of the tile.
	 * @return  true if that tile is walkable, false otherwise.
	 */
	public boolean isTileWalkable(int x, int y);
	
	/**
	 * This method returns a list of all tiles with terrainType Targt.
	 * @return  list of all target tiles.
	 */
	public List<ITile> getTargetTiles();
	
	/**
	 * This method returns a list of all tiles with terrainType Start.
	 * @return  list of all start tiles.
	 */
	public List<ITile> getStartTiles();
	
	/**
	 * This method returns whether there is a tile with a specific x- and y-coordinate.
	 * @param x  x-position of the tile.
	 * @param y  y-position of the tile.
	 * @return  true if there is this tile, false otherwise.
	 */
	public boolean isTile(int x, int y);
	
	/**
	 * This method returns whether there is an object on a specific tile.
	 * @param x  x-position of the tile.
	 * @param y  y-position of the tile.
	 * @return true if there is an object on that tile, false otherwise.
	 */
	public boolean isObjectOnTile(int x, int y);
	
	/**
	 * This method returns whether there is an object on at least one tile of the matchfield.
	 * @return  true if there is an object on at least one tile, false otherwise.
	 */
	public boolean isObjectOnFied();
	
	/**
	 * This method returns the ObjectType of a specific tile.
	 * The object is also deleted from the tile.
	 * @param x  x-position of the tile.
	 * @param y  y-position of the tile.
	 * @return  ObjectType
	 */
	public ObjectType pickUpObject(int x, int y);
	
	/**
	 * This method returns the ObjectType of a specific tile.
	 * @param x  x-position of the tile.
	 * @param y  y-position of the tile.
	 * @return  ObjectType
	 */
	public ObjectType getObjectOnTile(int x, int y);
	
	/**
	 * This method returns a list of IntegerPairs. The pairs holds the x- and y- coordinates of the object tiles.
	 * @return  list of pairs.
	 */
	public List<IntegerPair> getListObjectTiles();
	
}
