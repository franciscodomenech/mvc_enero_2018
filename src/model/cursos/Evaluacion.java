package model.cursos;

import java.util.Calendar;

public class Evaluacion {
	
	public static final int MAX = 3;
	
	private final int IND_NO_EVAL = -1;
	private String name;
	private Calendar fecha;
	private float nota;
	public Evaluacion() {
		this.name = "";
		this.nota = IND_NO_EVAL;
		fecha = Calendar.getInstance();
	}
	public Evaluacion(String name, float nota,int day,int month,int year) {
		this.name = name;
		this.nota = nota;
		fecha = Calendar.getInstance();
		fecha.set(year, month-1, day);
	}
	public Evaluacion(String name, float nota) {
		this.name = name;
		this.nota = nota;
		fecha = Calendar.getInstance();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public boolean isEval() {
		return nota!=IND_NO_EVAL;
	}
	
}
