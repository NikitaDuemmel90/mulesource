package mule.turtle;

public class MoveBackward {

	private BackLine backline;
	
	public MoveBackward(){
		
	}
	
	public MoveBackward(BackLine backline){
		this.backline = backline;
	}

	/**
	 * @return the backline
	 */
	public BackLine getBackline() {
		return backline;
	}

	/**
	 * @param backline the backline to set
	 */
	public void setBackline(BackLine backline) {
		this.backline = backline;
	}
}
