package model.questions;

import model.cursos.Alumno;

public class QuestionsAddAlumno extends Questions {
	
	private final int STEP_NOMBRE = 0;
	private final int STEP_APELLIDOS = 1;
	private final int STEP_NIF = 2;
	private final int STEP_FECHA = 3;
	
	private Alumno alumno;
	
	public QuestionsAddAlumno() {
		super();
		alumno = new Alumno();
	}

	@Override
	public void init() {
		this.questionsText.add("Nombre:");
		questionsText.add("Apellidos:");
		questionsText.add("Nif");
		questionsText.add("F. Nacimiento");
	}

	@Override
	public StatusResponse processResponse(int step, String value) {
		StatusResponse sr = new StatusResponse();
		sr.setIsok(true);
		switch(step) {
		case STEP_NOMBRE:
			alumno.setNombre(value);
			break;
		case STEP_APELLIDOS:
			alumno.setApellidos(value);
			break;
		case STEP_NIF:
			alumno.setNif(value);
			break;
		case STEP_FECHA:
			sr.setIsok(alumno.setDateString(value));
			sr.setResult(alumno);
			break;
		}
		return sr;
	}

}
