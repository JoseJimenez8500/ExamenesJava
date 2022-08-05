package com.claseAbstracta;

public class Futbolista extends SeleccionDeFutbol {

	public Futbolista(String nombre, String apellido) {
		super(nombre, apellido);
		
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
	
	
}
