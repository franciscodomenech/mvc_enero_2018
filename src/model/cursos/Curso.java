package model.cursos;

import java.util.HashMap;
import java.util.Iterator;

import model.Centro;
import model.questions.StatusResponse;

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

	@Override
	public void setAsistencia(Asistencia asistencia) {
		Alumno al = buscarAlumno(asistencia.getNif());
		if(al!=null)
			al.setAsistencia(asistencia.isAsistencia());
	}

	@Override
	public void setEvaluacion(InfoEvaluacion ev) {
		if(profesor!=null)
			profesor.evalua(buscarAlumno(ev.getNif()), ev.getEvaluacion(), ev.getNota());
	}

	@Override
	public boolean borrarAlumno(String nif) {
		if(alumnos.containsKey(nif)) {
			alumnos.remove(nif);
			return true;
		}else
			return false;
	}

	@Override
	public String processResponse(Object result,int op) {
		String r = null;
		switch(op) {
		case Centro.OP_ADD_ALUMNO:
			matricula((Alumno) result);
			break;
		case Centro.OP_MARCAR_ASISTENCIA:
			setAsistencia((Asistencia) result);
			break;
		case Centro.OP_EVALUAR:
			setEvaluacion((InfoEvaluacion) result);
			break;
		case Centro.OP_MOSTRAR_ALUMNO:
			r = processSearchAlumn(result);
			break;
		case Centro.OP_DELETE_ALUMNO:
			r = processDeleteAlumn(result);
			break;
		}
		return r;
	}
	
	private String processSearchAlumn(Object result) {
		Alumno al = buscarAlumno((String) result);
		if(al!=null)
			return al.toString();
		else
			return "No existe";
	}
	
	private String processDeleteAlumn(Object result) {
		if(result==null)
			return "";
		else if(alumnos.containsKey((String)result)) {
			alumnos.remove((String)result);
			return "Borrado";
		}else
			return "No encontrado";
	}
	

}
