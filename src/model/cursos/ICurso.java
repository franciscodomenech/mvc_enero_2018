package model.cursos;

import java.util.HashMap;

public interface ICurso {
	public void matricula(Alumno alumno);
	public void pasarLista(HashMap<String,Boolean> asistencia);
	public void evaluar(int evaluacion,HashMap<String,Float> notas);
	//Devuelve null en caso de no econtrarlo
	public Alumno buscarAlumno(String nif);
	
	public void setProfesor(Profesor profe);
}
