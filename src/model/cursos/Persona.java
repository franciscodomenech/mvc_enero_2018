package model.cursos;

import java.util.Calendar;

public class Persona {
	
	protected String nombre;
	protected String apellidos;
	protected String nif;
	protected Calendar fecha;
	
	public Persona() {
		nombre = "";
		apellidos = "";
		nif = "";
		fecha = Calendar.getInstance();
	}
	
	public Persona(String nombre,String apellidos,String nif,int day, int month, int year) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		fecha = Calendar.getInstance();
		fecha.set(year, month-1, day, 0, 0, 0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public int getEdad() {
		Calendar fechaActual = Calendar.getInstance();
		int edad = fechaActual.get(Calendar.YEAR)-fecha.get(Calendar.YEAR);
		edad -=  fechaActual.get(Calendar.DAY_OF_YEAR)<fecha.get(Calendar.DAY_OF_YEAR)?1:0;
		/*if(fechaActual.get(Calendar.MONTH)<fecha.get(Calendar.MONTH))
			edad--;
		else if(fechaActual.get(Calendar.MONTH)==fecha.get(Calendar.MONTH)) {
			edad -=  fechaActual.get(Calendar.DAY_OF_MONTH)<fecha.get(Calendar.DAY_OF_MONTH)?1:0;
		}*/
		/*long time = fechaActual.getTimeInMillis()-fecha.getTimeInMillis();
		fechaActual.setTimeInMillis(time);
		Calendar yearCero = Calendar.getInstance();
		yearCero.setTimeInMillis(0);
		int edad = fechaActual.get(Calendar.YEAR)-yearCero.get(Calendar.YEAR);*/
		return edad;
	}
	
	public boolean setDateString(String value) {
		boolean isok = false;
		String[] tks = value.split("/");
		if(tks.length>2) {
			try {
				fecha.set(Integer.parseInt(tks[2]), Integer.parseInt(tks[1])-1, Integer.parseInt(tks[0]));
				isok = true;
			}catch(NumberFormatException nfe) {}
		}
		return isok;
	}

}
