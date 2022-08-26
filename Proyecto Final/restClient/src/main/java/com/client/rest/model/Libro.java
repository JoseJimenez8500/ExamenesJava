package com.client.rest.model;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Data
public class Libro {

	private int id;
	private String nombre;
	private String editorial;	
	private String autor;
	private String genero;
	private String pais_del_autor;
	private String numero_paginas;	
	private String anio_edicion;
	private String precio;
	
}