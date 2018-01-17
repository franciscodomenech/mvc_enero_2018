package model.questions;

import java.util.ArrayList;

import model.Centro;

public abstract class Questions implements IQuestions {

	protected ArrayList<String> questionsText;

	public Questions() {
		questionsText = new ArrayList<String>();
		//Inicializar todos los objetos questions
		//Para inicializar las preguntas
		init();
	}
	
	@Override
	public String getQuestion(int actual) {
		return questionsText!=null && actual<questionsText.size()?questionsText.get(actual):null;
	}

}
