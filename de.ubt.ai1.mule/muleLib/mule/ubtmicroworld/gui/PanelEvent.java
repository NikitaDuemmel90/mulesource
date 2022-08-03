package mule.ubtmicroworld.gui;

/**
 * This class specifies a GuiEvent.
 * @author Marco Jantos
 * 
 */
public class PanelEvent {

	protected PanelEventType type;

	java.util.List<java.util.Map.Entry<PanelEventEnumKey, Integer>> pairListInteger = new java.util.ArrayList<>();


	/**
	 * Constructor to create a event
	 * values are kept in a map
	 * @param type  type of the event
	 */
	public PanelEvent(PanelEventType type) {
		this.type = type;
	}
	
	/**
	 * This method returns the type of the event
	 * @return type of event
	 */
	public PanelEventType getType() {
		return type;
	}
	
	/**
	 * This method adds values to the event (only int)
	 * @param key  key oft the value
	 * @param val  the value itself
	 */
	public void addAtribute(PanelEventEnumKey key, int val) {
		java.util.Map.Entry<PanelEventEnumKey, Integer> pair1 = new java.util.AbstractMap.SimpleEntry<>(key, val);
		pairListInteger.add(pair1);

	}
	
	/**
	 * This method returns the first value depending of a key
	 * @param key  key of the value
	 * @return first value depending of the key
	 */
	public Integer getFirstAttributeInteger(PanelEventEnumKey key) {
		for (int i = 0; i < pairListInteger.size(); i++) {
			if (pairListInteger.get(i).getKey() == key) {
				return pairListInteger.get(i).getValue();
			}
		}

		return null;
	}
	
}
