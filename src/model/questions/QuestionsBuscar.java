package model.questions;

public class QuestionsBuscar extends Questions {

	@Override
	public void init() {
		questionsText.add("Nif: ");
	}

	@Override
	public StatusResponse processResponse(int step, String response) {
		StatusResponse sr = new StatusResponse();
		sr.setIsok(true);
		sr.setResult(response);
		return sr;
	}

}
