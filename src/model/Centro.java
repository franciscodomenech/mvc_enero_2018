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
	public static final int OP_BORRAR_ALUMNO = 5;
	
	private MainQuestions questions;
	
	private Curso[] cursos;
	private Boolean logged;
	//login (usuario) y si es correcto me lleva a una lista de articulos donde tengo buscar, eliminar y ver ficha articulo. los articulos tienen descripcion y precio y ruta de imagen
	public Centro() {
		logged=true;
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
		// if(questions.getStatus()>MainQuestions.SECOND_STEP) {
			StatusResponse sr = questions.processResponse(response);
			if(sr.isFinish() && sr.isIsok() && questions.getStatus()>MainQuestions.SECOND_STEP) {
				r = checkStResponse(sr);
			} else if (!sr.isIsok()){
				r = "Mal formato";
			} else if (questions.getStatus()==MainQuestions.EXIT_STEP && ((Boolean)sr.getResult())) {
				logged=false;
				r="Hasta pronto";
			}
		//}
		return r;
	}
	
	private String checkStResponse(StatusResponse sr) {
		String r = null;
		int c = questions.getCurso();
		if(c>=0 && c<cursos.length) {
			Curso curso = cursos[c];
			switch(questions.getOp()) {
			case OP_ADD_ALUMNO:
				curso.matricula((Alumno) sr.getResult());
				break;
			case OP_MARCAR_ASISTENCIA:
				curso.setAsistencia((Asistencia) sr.getResult());
				break;
			case OP_EVALUAR:
				curso.setEvaluacion((InfoEvaluacion) sr.getResult());
				break;
			case OP_MOSTRAR_ALUMNO:
				Alumno al = curso.buscarAlumno((String) sr.getResult());
				if(al!=null)
					r = al.toString();
				else
					r = "No existe";
				break;
			case OP_BORRAR_ALUMNO:
				if(sr.getResult()!=null) {
					if(curso.borrarAlumno((String) sr.getResult())!=false) {
						r="Alumno borrado";
					} else {
						r="No existe el alumno, no se ha podido eliminar";
					}
				}else if(sr.getResult()==null) {
					r="Borrar cancelado";
				}		
				break;
			}
		}
		return r;
	}

	@Override
	public Boolean isLogged() {
		return logged;
	}

}
