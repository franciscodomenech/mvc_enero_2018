package model;

import model.cursos.Curso;

public class Centro implements ICentro {
	
	public static final int NUM_CURSOS = 10;
	
	public static final int OP_ADD_ALUMNO = 1;
	public static final int OP_MARCAR_ASISTENCIA = 2;
	public static final int OP_EVALUAR = 3;
	public static final int OP_MOSTRAR_ALUMNO = 4;
	
	private Curso[] cursos;
	
	private Curso cursoActual;
	

	@Override
	public void setCurso(int curso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOp(int op) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String nextQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

}
