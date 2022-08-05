package com.interfaces;

public class Entrenador implements SeleccionDeFutbol {
	
	String nombre;
	String apellido;
	
	
	public Entrenador(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public void partidoFutbol() {
		System.out.println("Dirige un Partido (Clase Entrenador)");
	}
	
	public void planificarEstrategia() {
	      System.out.println("Planificar Estrategia (Clase Entrenador)");
	   }


	@Override
	public void entrenamiento() {
		System.out.println("Dirige un entrenamiento (Clase Entrenador)");
	}
	@Override
	public String toString() {
		return "" + nombre + " " + apellido +"";
	}

}