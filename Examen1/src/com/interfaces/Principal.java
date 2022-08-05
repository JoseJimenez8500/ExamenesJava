package com.interfaces;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		List<IntegrantesSeleccionFutbol> integrantes = new ArrayList<IntegrantesSeleccionFutbol>();
		
		integrantes.add(new Futbolista("Javier","Hernández" ));
		integrantes.add(new Futbolista("Guillermo","Ochoa" ));
		integrantes.add(new Entrenador("Miguel","Herrera" ));
		integrantes.add(new Masajista("Juan","Pérez" ));
		
		System.out.println("Entrenamiento del equipo\n");
		for(IntegrantesSeleccionFutbol integ:integrantes) {
			System.out.print(integ+"->");
			integ.entrenar();
			if(integ instanceof Entrenador) {
				((Entrenador)integ).planificarEstrategia();
			}
		}
		System.out.println("\nPartido de Futbol\n");
		for(IntegrantesSeleccionFutbol integ:integrantes) {
			System.out.print(integ+"->");
			integ.jugarPartido();
			if(integ instanceof Futbolista) {
				((Futbolista)integ).entrevista();
			}
			if(integ instanceof Masajista) {
				((Masajista)integ).darMasaje();
			}
		}

	}
}																																																																												
																													