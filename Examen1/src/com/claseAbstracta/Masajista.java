package com.claseAbstracta;

public class Masajista extends IntegrantesSeleccionFutbol{

	public Masajista(String nombre, String apellido) {
		super(nombre, apellido);
		
	}

	@Override
	public void entrenar() {
		System.out.println("Da asistencia en el entrenamiento (Clase Masajista)");
		
	}
	public void darMasaje() {
	      System.out.println("Da un Masaje");
	   }

	
	
	
	
	
	
	
}
