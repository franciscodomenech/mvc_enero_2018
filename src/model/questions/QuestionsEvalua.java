package model.questions;

import model.cursos.Evaluacion;
import model.cursos.InfoEvaluacion;

public class QuestionsEvalua extends Questions {
	
	private InfoEvaluacion info;
	
	private final int STEP_NIF = 0;
	private final int STEP_EV = 1;
	private final int STEP_NOTA = 2;
	
	public QuestionsEvalua() {
		super();
		info = new InfoEvaluacion();
	}

	@Override
	public void init() {
		questionsText.add("Nif: ");
		questionsText.add("Evaluación: ");
		questionsText.add("Nota: ");
		
	}

	@Override
	public StatusResponse processResponse(int step, String response) {
		StatusResponse sr = new StatusResponse();
		sr.setIsok(false);
		switch(step) {
		case STEP_NIF:
			info.setNif(response);
			break;
		case STEP_EV:
			int ev = Integer.parseInt(response);
			if(ev<Evaluacion.MAX) {
				info.setEvaluacion(ev);
				sr.setIsok(true);
			}
			break;
		case STEP_NOTA:
			info.setNota(Float.parseFloat(response));
			sr.setIsok(true);
			sr.setResult(info);
			break;
		}
		return sr;
	}

}
