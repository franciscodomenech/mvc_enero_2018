package model.questions;

public class StatusResponse {
	private boolean isok;
	private boolean finish;
	private Object result;
	public boolean isIsok() {
		return isok;
	}
	public void setIsok(boolean isok) {
		this.isok = isok;
	}
	public boolean isFinish() {
		return finish;
	}

	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
		this.finish = true;
	}
	
}
