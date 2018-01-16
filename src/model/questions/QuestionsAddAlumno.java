package model.questions;

public class QuestionsAddAlumno extends Questions {

	@Override
	public void init() {
		this.questionsText.add("Nombre:");
		questionsText.add("Apellidos:");
		questionsText.add("Nif");
		questionsText.add("F. Nacimiento");
	}

}
