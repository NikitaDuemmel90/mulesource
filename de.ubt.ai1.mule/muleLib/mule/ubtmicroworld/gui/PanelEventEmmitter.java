package mule.ubtmicroworld.gui;

/**
 * This interface specifies a PanelEventEmmitter.
 * @author Marco Jantos
 * 
 */
public interface PanelEventEmmitter {
	/**
	 * This method registers a listener
	 * @param listener  listener itself
	 */
	public void registerListener(PanelEventListener listener);

	/**
	 * This method removes a listener
	 * @param listener  listener itself
	 */
	public void removeListener(PanelEventListener listener);
}
