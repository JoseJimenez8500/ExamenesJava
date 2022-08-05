package com.claseAbstracta;

public abstract class IntegrantesSeleccionFutbol {
	
	private String nombre;
	private String apellido;

	public IntegrantesSeleccionFutbol(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public abstract void entrenar();
	
	public void jugarPartido() {
	     System.out.println("Asiste al Partido de Fútbol (Clase Padre)");
	}

	@Override
	public String toString() {
		return "" + nombre + " " + apellido +"";
	}
	
	
	
}
