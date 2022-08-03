package mule.ubtmicroworld.data;

import mule.ubtmicroworld.UBTMicroworld.DelayTime;

/**
 * This class holds additional methods for the Agent. 
 * @author Marco Jantos
 * 
 */
public class AgentUtil {
	
	private static DelayTime delayTime = DelayTime.MEDIUM_DELAY;
	
	public static void setDelayTime(DelayTime newDelayTime) {
		delayTime = newDelayTime;
	}

	public static void waitAgent() {
		int delay = 0;
		switch(delayTime) {
		case LONG_DELAY:
			delay = 2000;
			break;
		case MEDIUM_DELAY:
			delay = 1000;
			break;
		case SHORT_DELAY:
			delay = 250;
			break;
		case NO_DELAY:
			delay = 0;
			break;
		default:
			break;
		
		}
			
		try {
			
			Thread.sleep(delay);
			
		}catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
}
