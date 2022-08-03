package mule.ubtmicroworld;

public class ControllerUtil {

	public static void waitFor(int time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
}
