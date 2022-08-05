package com.interfaces;

public class Masajista implements IntegrantesSeleccionFutbol{

	private String nombre;
	private String apellido;

	public Masajista(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	@Override
	public void entrenar() {
		System.out.println("Da asistencia en el entrenamiento (Clase Masajista)");
		
	}
	public void darMasaje() {
	      System.out.println("Da un Masaje");
	   }

	@Override
	public String toString() {
		return "" + nombre + " " + apellido +"";
	}

	@Override
	public void jugarPartido() {
		System.out.println("Asiste al Partido de Fútbol (Clase Masajista)");
		
	}
	
}
