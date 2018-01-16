package model.questions;

import model.Centro;

public class MainQuestions {
	
	private Questions actualQD;
	private int actual;
	private final int STARTQ = 0;
	private final int STARTQD = 3;
	
	public MainQuestions() {
		actual = STARTQ;
		actualQD = null;
	}
	
	public String next(int op) {
		actual++;
		String q = "";
		switch(actual) {
		case STARTQ+1:
			q = getQuestionInitial();
			break;
		case STARTQ+2:
			q = getQuestionOp();
			break;
		default:
			if(actualQD!=null)
				q = actualQD.getQuestion(actual-STARTQD);
			break;
			
		}
		if(q==null) {
			actualQD = null;
			actual = STARTQ;
			q = next(op);
		}
		return q;
	}
	
	private void setQuestionsForOp(int op) {
		switch(op) {
		case Centro.OP_ADD_ALUMNO:
			actualQD = new QuestionsAddAlumno();
			break;
		case Centro.OP_EVALUAR:
			actualQD = new QuestionsEvalua();
			break;
		case Centro.OP_MARCAR_ASISTENCIA:
			actualQD = new QuestionsAsistencia();
			break;
		case Centro.OP_MOSTRAR_ALUMNO:
			actualQD = new QuestionsBuscar();
			break;
		}
	}

	private String getQuestionInitial() {
		// TODO Auto-generated method stub
		return "Elige Curso(0,"+Centro.NUM_CURSOS+"):";
	}

	private String getQuestionOp() {
		return null;
	}

}
