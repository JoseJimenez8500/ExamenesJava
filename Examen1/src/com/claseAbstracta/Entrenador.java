package com.claseAbstracta;

public class Entrenador extends SeleccionDeFutbol {

	public Entrenador(String nombre, String apellido) {
		super(nombre, apellido);
		
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

}
