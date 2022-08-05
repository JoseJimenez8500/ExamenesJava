package com.interfaces;

public class Futbolista implements SeleccionDeFutbol {

	String nombre;
	String apellido;

	public Futbolista(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public void partidoFutbol() {
		System.out.println("Juega un Partido (Clase Futbolista)");
		
	}
	
	public void entrevista() {
	      System.out.println("Da una Entrevista");
	   }

	@Override
	public void entrenamiento() {
		System.out.println("Realiza un entrenamiento (Clase Futbolista)");
		
	}
	@Override
	public String toString() {
		return "" + nombre + " " + apellido +"";
	}
	
	
}
