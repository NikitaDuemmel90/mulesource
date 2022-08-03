package mule.ubtmicroworld.data;

import java.awt.event.KeyEvent;

/**
 * This class holds the KeyEvent.
 * @author Marco Jantos
 *
 */
public class BibKeyEvent {

	protected KeyEvent type;
	
	public BibKeyEvent(KeyEvent type) {
		this.type = type;
	}
	
	/**
	 * This method returns the KeyEvent.
	 * @return  KeyEvent.
	 */
	public KeyEvent getKeyEvent() {
		return type;
	}

}
