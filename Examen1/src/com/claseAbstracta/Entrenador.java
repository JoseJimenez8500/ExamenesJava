package com.claseAbstracta;

public class Entrenador extends IntegrantesSeleccionFutbol {

	public Entrenador(String nombre, String apellido) {
		super(nombre, apellido);
		
	}
	@Override
	public void jugarPartido() {
		System.out.println("Dirige un Partido (Clase Entrenador)");
	}
	
	public void planificarEstrategia() {
	      System.out.println("Planificar Estrategia (Clase Entrenador)");
	   }


	@Override
	public void entrenar() {
		System.out.println("Dirige un entrenamiento (Clase Entrenador)");
	}

}
