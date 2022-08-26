package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "autor")
    private String autor;
    @Column(name = "genero")
    private String genero;
    @Column(name = "pais_del_autor")
    private String pais_del_autor;
    @Column(name = "numero_paginas")
    private String numero_paginas;
    @Column(name = "anio_edicion")
    private String anio_edicion;
    @Column(name = "precio")
    private String precio;
    
    
    
}
