package mule.ubtmicroworld.data;

public interface BibKeyEventListener {

	/**
	 * This method handles an incoming KeyEvent
	 * @param event  incoming event 
	 */
	public void handle(BibKeyEvent event);
}
