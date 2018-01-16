package model;

import java.util.HashMap;
import java.util.Iterator;

public class Curso implements ICurso {
	
	private HashMap<String,Alumno> alumnos;
	private Profesor profesor;
	
	public Curso() {
		alumnos = new HashMap<String,Alumno>();
	}

	@Override
	public void matricula(Alumno alumno) {
		alumnos.put(alumno.getNif(), alumno);
	}

	@Override
	public void pasarLista(HashMap<String, Boolean> asistencia) {
		Iterator<String> nifs = asistencia.keySet().iterator();
		while(nifs.hasNext()) {
			String nif = nifs.next();
			Alumno al = this.buscarAlumno(nif);
			if(al!=null)
				al.setAsistencia(asistencia.get(nif));
		}
	}

	@Override
	public void evaluar(int evaluacion, HashMap<String, Float> notas) {
		Iterator<String> nifs = notas.keySet().iterator();
		if(profesor!=null) {
			while(nifs.hasNext()) {
				String nif = nifs.next();
				profesor.evalua(this.buscarAlumno(nif),evaluacion,notas.get(nif));
			}
		}
		
	}

	@Override
	public Alumno buscarAlumno(String nif) {
		// TODO Auto-generated method stub
		return alumnos.get(nif);
	}

	@Override
	public void setProfesor(Profesor profe) {
		profesor = profe;
	}

}
