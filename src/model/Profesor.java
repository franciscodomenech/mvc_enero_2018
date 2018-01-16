package model;

public class Profesor extends Persona {
	public boolean evalua(Alumno alumno,int evaluacion,float nota) {
		if(alumno!=null) {
			alumno.setNotaEvaluacion(evaluacion, nota);
			return true;
		}else
			return false;
	}
}
