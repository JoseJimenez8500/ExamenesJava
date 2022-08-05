package com.interfaces;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		List<SeleccionDeFutbol> integrantes = new ArrayList<SeleccionDeFutbol>();
		
		integrantes.add(new Futbolista("Javier","Hernández" ));
		integrantes.add(new Futbolista("Guillermo","Ochoa" ));
		integrantes.add(new Entrenador("Miguel","Herrera" ));
		integrantes.add(new Masajista("Juan","Pérez" ));
		
		System.out.println("Entrenamiento del equipo\n");
		for(SeleccionDeFutbol integ:integrantes) {
			System.out.print(integ+"->");
			integ.entrenamiento();
			if(integ instanceof Entrenador) {
				((Entrenador)integ).planificarEstrategia();
			}
		}
		System.out.println("\nPartido de Futbol\n");
		for(SeleccionDeFutbol integ:integrantes) {
			System.out.print(integ+"->");
			integ.partidoFutbol();
			if(integ instanceof Futbolista) {
				((Futbolista)integ).entrevista();
			}
			if(integ instanceof Masajista) {
				((Masajista)integ).darMasaje();
			}
		}

	}
}																																																																												
																													