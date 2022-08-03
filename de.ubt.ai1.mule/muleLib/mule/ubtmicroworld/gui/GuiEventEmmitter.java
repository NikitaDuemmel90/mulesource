package mule.ubtmicroworld.gui;

/**
 * This interface specifies a GuiEventEmmitter.
 * @author Marco Jantos
 * 
 */
public interface GuiEventEmmitter {
	/**
	 * This method registers a listener
	 * @param listener  listener itself
	 */
	public void registerListener(GuiEventListener listener);
	
	/**
	 * This method removes a listener
	 * @param listener  listener itself
	 */
	public void removeListener(GuiEventListener listener);
}
