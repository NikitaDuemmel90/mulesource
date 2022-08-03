package mule.ubtmicroworld.data;


public interface BibKeyEventEmmitter {

	/**
	 * This method registers a listener
	 * @param listener  listener itself
	 */
	public void registerListener(BibKeyEventListener listener);

	/**
	 * This method removes a listener
	 * @param listener  listener itself
	 */
	public void removeListener(BibKeyEventListener listener);
}
