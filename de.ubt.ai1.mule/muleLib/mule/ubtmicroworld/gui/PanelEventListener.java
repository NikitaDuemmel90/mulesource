package mule.ubtmicroworld.gui;

/**
 * This interface specifies a PanelEventListener.
 * @author Marco Jantos
 * 
 */
public interface PanelEventListener {

	/**
	 * This method handles an incoming PanelEvent
	 * @param event  incoming event 
	 */
	public void handle(PanelEvent event);
	
}
