package model.cursos;

import java.util.ArrayList;
import java.util.HashMap;

public class Alumno extends Persona {
	
	//private ArrayList<Evaluacion> evaluaciones;
	private Evaluacion[] evaluaciones;
	
	//private HashMap<Integer,Evaluacion> evaluaciones;
	private boolean asistencia;
	
	private Evaluacion pendEval;
	
	public Alumno() {
		super();
		//evaluaciones = new ArrayList<Evaluacion>();
		evaluaciones = new Evaluacion[Evaluacion.MAX];
		//evaluaciones = new HashMap<Integer,Evaluacion>();
	}
	
	public Alumno(String nombre,String apellidos,String nif,int day, int month, int year) {
		super(nombre,apellidos,nif,day,month,year);
		//evaluaciones = new ArrayList<Evaluacion>();
		evaluaciones = new Evaluacion[Evaluacion.MAX];
		//evaluaciones = new HashMap<Integer,Evaluacion>();
	}
	
	public void setNotaEvaluacion(int evaluacion,float nota) {
		/*if(evaluacion<evaluaciones.size()&&evaluaciones.get(evaluacion)!=null)
			evaluaciones.get(evaluacion).setNota(nota);
		else {
			Evaluacion ev = new Evaluacion("Evaluación "+(evaluacion+1),nota);
			if(evaluacion<evaluaciones.size())
				evaluaciones.remove(evaluacion);
			evaluaciones.add(evaluacion, ev);
		}*/
		evaluaciones[evaluacion] = new Evaluacion("Evaluación "+(evaluacion+1),nota);
		//evaluaciones.put(evaluacion, new Evaluacion("Evaluación "+(evaluacion+1),nota));
	}

	/*public HashMap<Integer, Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(HashMap<Integer, Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}*/

	public boolean isAsistencia() {
		return asistencia;
	}

	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}
	
	@Override
	public String toString() {
		String tevals = "";
		for(int i=0;i<evaluaciones.length;i++) {
			if(i>0)
				tevals+="/";
			Evaluacion ev = evaluaciones[i];
			if(ev!=null)
				tevals+=ev.getNota();
		}
		return apellidos+", "+nombre+". Asistencia: "+(asistencia?"Si":"No")+". Evaluaciones: "+tevals;
	}

}
