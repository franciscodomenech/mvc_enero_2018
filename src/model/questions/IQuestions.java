package model.questions;

public interface IQuestions {
	public void init();
	public String getQuestion(int actual);
	public StatusResponse processResponse(int step,String response);
}
