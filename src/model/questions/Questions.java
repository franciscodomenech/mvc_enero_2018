package model.questions;

import java.util.ArrayList;

import model.Centro;

public abstract class Questions implements IQuestions {

	protected ArrayList<String> questionsText;

	public Questions() {
		questionsText = new ArrayList<String>();
	}
	
	@Override
	public String getQuestion(int actual) {
		return questionsText!=null && actual<questionsText.size()?questionsText.get(actual):null;
	}

}
