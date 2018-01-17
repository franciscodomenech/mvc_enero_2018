package model.questions;

import model.cursos.Asistencia;

public class QuestionsAsistencia extends Questions {

	private final int STEP_NIF = 0;
	private final int STEP_ASISTE = 1;
	
	private Asistencia asistencia;
	
	public QuestionsAsistencia() {
		super();
		asistencia = new Asistencia();
	}
	
	@Override
	public void init() {
		questionsText.add("Nif:");
		questionsText.add("Asiste (Si/No):");
	}

	@Override
	public StatusResponse processResponse(int step, String response) {
		StatusResponse sr = new StatusResponse();
		sr.setIsok(true);
		switch(step) {
		case STEP_NIF:
			asistencia.setNif(response);
			break;
		case STEP_ASISTE:
			if(response.equals("Si"))
				sr.setResult(true);
			else if(response.equals("No"))
				sr.setResult(true);
			else
				sr.setIsok(false);
			break;
		}
		return sr;
	}

}
