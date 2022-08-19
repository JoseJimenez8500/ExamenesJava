package com.Lambdas;

import java.util.*;
import java.util.function.*;

import javax.swing.JOptionPane;


public class CalculadoraLambdas {

	
	public static void main(String[] args) {

		//Se crea la lista de operaciones de tipo DoubleBinaryOperator
		List<DoubleBinaryOperator> listOperaciones = new ArrayList<>();
		
		/*
		 DoubleBinaryOperator toma 2 parametros de tipo double y el return del mismo tipo
		 como el programa fue de una calculadora, es la interface apropiada de usar 
		*/
		
		// Se crea la lista de lambdas 
		DoubleBinaryOperator suma = (x,y) -> x+y;
		DoubleBinaryOperator resta = (x,y) -> x-y;
		DoubleBinaryOperator multi = (x,y) -> x*y;
		DoubleBinaryOperator div = (x,y) -> x/y;
		DoubleBinaryOperator max = (x,y) -> Math.max(x, y);
		DoubleBinaryOperator min = (x,y) -> Math.min(x, y);
		DoubleBinaryOperator raiz = (x,y) -> Math.pow(x, 1 / y);
		DoubleBinaryOperator potencia = (x,y) -> Math.pow(x, y);

		//se agregan las lambdas a la lista
		listOperaciones.add(suma);
		listOperaciones.add(resta);
		listOperaciones.add(multi);
		listOperaciones.add(div);
		listOperaciones.add(potencia);
		listOperaciones.add(raiz);
		listOperaciones.add(max);
		listOperaciones.add(min);

		// Metodo en el que se ejecutan las operaciones lambda
		ejecutaOperaciones(listOperaciones, 3.5, 4.0);
	}
	
		/*
	 	En este metodo ocurre el polimorfismo, cuando se ejecuta la instruccion applyAsDouble
	 	ya que aunque ejecuta la misma instruccion se obtiene diferentes resultados 
		*/
	static void ejecutaOperaciones(List<DoubleBinaryOperator> listOperaciones, double x, double y) {
		for (DoubleBinaryOperator ope:listOperaciones) { 
			
			//Se coloca un try Catch por si ocurre algun error en una operacion
			try {
				
				System.out.println(ope.applyAsDouble(x, y));
			}catch(ArithmeticException e) {
				System.out.println("La división no se pudo realizar");
			}
		}
	}
	
}
