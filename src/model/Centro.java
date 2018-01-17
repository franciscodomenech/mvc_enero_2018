package model;

import model.cursos.Alumno;
import model.cursos.Asistencia;
import model.cursos.Curso;
import model.cursos.InfoEvaluacion;
import model.cursos.Profesor;
import model.questions.MainQuestions;
import model.questions.StatusResponse;

public class Centro implements ICentro {
	
	public static final int NUM_CURSOS = 10;
	
	public static final int OP_ADD_ALUMNO = 1;
	public static final int OP_MARCAR_ASISTENCIA = 2;
	public static final int OP_EVALUAR = 3;
	public static final int OP_MOSTRAR_ALUMNO = 4;
	public static final int OP_DELETE_ALUMNO = 5;
	
	private MainQuestions questions;
	
	private Curso[] cursos;
	
	public Centro() {
		cursos = new Curso[NUM_CURSOS];
		for(int i=0;i<cursos.length;i++) {
			Curso c = new Curso();
			Profesor profe = new Profesor();
			profe.setNombre("Profe "+i);
			c.setProfesor(profe);
			cursos[i] = c;
		}
		questions = new MainQuestions();
	}

	@Override
	public String nextQuestion() {
		return questions.next();
	}

	@Override
	public String processResponse(String response) {
		String r = null;
		StatusResponse sr = questions.processResponse(response);
		if(sr.isFinish() && sr.isIsok() && questions.getStatus()>MainQuestions.SECOND_STEP) {
			r = checkStResponse(sr);
		}
		return r;
	}
	
	private String checkStResponse(StatusResponse sr) {
		String r = null;
		int c = questions.getCurso();
		if(c>=0 && c<cursos.length)
			r = cursos[c].processResponse(sr.getResult(), questions.getOp());
		return r;
	}
	
	

}
