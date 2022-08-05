package com.claseAbstracta;

public abstract class SeleccionDeFutbol {
	
	private String nombre;
	private String apellido;

	public SeleccionDeFutbol(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public abstract void entrenamiento();
	
	public void partidoFutbol() {
	     System.out.println("Asiste al Partido de Fútbol (Clase Padre)");
	}

	@Override
	public String toString() {
		return "" + nombre + " " + apellido +"";
	}
	
	
	
}
