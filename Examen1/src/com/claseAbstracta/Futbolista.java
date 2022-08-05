package com.claseAbstracta;

public class Futbolista extends IntegrantesSeleccionFutbol {

	public Futbolista(String nombre, String apellido) {
		super(nombre, apellido);
		
	}

	@Override
	public void jugarPartido() {
		System.out.println("Juega un Partido (Clase Futbolista)");
		
	}
	
	public void entrevista() {
	      System.out.println("Da una Entrevista");
	   }

	@Override
	public void entrenar() {
		System.out.println("Realiza un entrenamiento (Clase Futbolista)");
		
	}
	
	
}
