package mule.ubtmicroworld.data;

import java.awt.event.KeyEvent;

/**
 * This class offers a Key-Listener for the Agent-Class,
 * @author Marco Jantos
 * 
 */
public class BibKeyListening extends Thread implements BibKeyEventListener {
	
	private IAgent agent1;
	private IAgent agent2;
	
	private boolean isSetAgent1 = false;
	private boolean isSetAgent2 = false;

	public BibKeyListening(IAgent agent) {
		this.agent1 = agent;
		isSetAgent1 = true;
	}
	
	public BibKeyListening(IAgent agent1, IAgent agent2) {
		this.agent1 = agent1;
		isSetAgent1 = true;
		
		this.agent2 = agent2;
		isSetAgent2 = true;
	}
	

	@Override
	public void handle(BibKeyEvent event) {
		
		switch(event.getKeyEvent().getKeyCode()) {
		case KeyEvent.VK_LEFT:
			agent1.rotateLeft();
			break;
		case KeyEvent.VK_UP:
			agent1.moveForward();
			break;
		case KeyEvent.VK_RIGHT:
			agent1.rotateRight();
			break;
		case KeyEvent.VK_DOWN:
			agent1.moveBackward();
			break;	
		case KeyEvent.VK_A:
			if(isSetAgent2) {
				agent2.rotateLeft();
			}
			break;
		case KeyEvent.VK_W:
			if(isSetAgent2) {
				agent2.moveForward();
			}
			break;
		case KeyEvent.VK_D:
			if(isSetAgent2) {
				agent2.rotateRight();
			}
			break;
		case KeyEvent.VK_S:
			if(isSetAgent2) {
				agent2.moveBackward();
			}
			break;			
		default:
			break;
		}
		
	}

}
