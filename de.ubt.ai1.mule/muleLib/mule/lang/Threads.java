package mule.lang;

public class Threads {
	public static abstract class Thread extends java.lang.Thread {
		
		public void waitOnFinish() {
			try {
				this.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
