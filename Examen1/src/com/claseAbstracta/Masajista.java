package com.claseAbstracta;

public class Masajista extends SeleccionDeFutbol{

	public Masajista(String nombre, String apellido) {
		super(nombre, apellido);
		
	}

	@Override
	public void entrenamiento() {
		System.out.println("Da asistencia en el entrenamiento (Clase Masajista)");
		
	}
	public void darMasaje() {
	      System.out.println("Da un Masaje");
	   }

	
	
	
	
	
	
	
}
