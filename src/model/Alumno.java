package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Alumno extends Persona {
	
	//private ArrayList<Evaluacion> evaluaciones;
	//private Evaluacion[] evaluaciones;
	
	private HashMap<Integer,Evaluacion> evaluaciones;
	private boolean asistencia;
	
	public Alumno() {
		super();
		//evaluaciones = new ArrayList<Evaluacion>();
		//evaluaciones = new Evaluacion[Evaluacion.MAX];
		evaluaciones = new HashMap<Integer,Evaluacion>();
	}
	
	public Alumno(String nombre,String apellidos,String nif,int day, int month, int year) {
		super(nombre,apellidos,nif,day,month,year);
		//evaluaciones = new ArrayList<Evaluacion>();
		//evaluaciones = new Evaluacion[Evaluacion.MAX];
		evaluaciones = new HashMap<Integer,Evaluacion>();
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
		//evaluaciones[evaluacion] = new Evaluacion("Evaluación "+(evaluacion+1),nota);
		evaluaciones.put(evaluacion, new Evaluacion("Evaluación "+(evaluacion+1),nota));
	}

	public HashMap<Integer, Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(HashMap<Integer, Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public boolean isAsistencia() {
		return asistencia;
	}

	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}
	
	

}
