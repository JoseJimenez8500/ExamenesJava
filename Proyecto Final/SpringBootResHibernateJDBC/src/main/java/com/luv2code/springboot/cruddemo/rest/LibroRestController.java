package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Libro;

import com.luv2code.springboot.cruddemo.service.LibroService;

@RestController
@RequestMapping("/api")
public class LibroRestController {

	private LibroService libroService;
	
	@Autowired
	public LibroRestController(LibroService thelibroService) {
		libroService = thelibroService;
	}
	
	//se define el path para cada accion 
	@GetMapping("/libros")//path para seleccionar todos los registros
	public List<Libro> findAll() {
		return libroService.findAll();
	}
	
	@GetMapping("/libros/{libroId}")//path para seleccionar un solo registro
	public Libro getLibro(@PathVariable int libroId) {
		
		Libro theLibro = libroService.findById(libroId);
		
		if (theLibro == null) {
			throw new RuntimeException("Id del libro no encontrado - " + libroId);
		}
		
		return theLibro;
	}
	
	@PostMapping("/libros")//path para añadir un registro
	public Libro addLibro(@RequestBody Libro theLibro) {
		
		theLibro.setId(0);
		
		libroService.save(theLibro);
		
		return theLibro;
	}

	
	@PutMapping("/libros")//path para actualizar
	public Libro updateLibro(@RequestBody Libro theLibro) {
		
		libroService.save(theLibro);
		
		return theLibro;
	}

	
	@DeleteMapping("/libros/{libroId}")
	public String deleteLibro(@PathVariable int libroId) {
		
		Libro tempLibro = libroService.findById(libroId);
		
		if (tempLibro == null) {
			throw new RuntimeException("Id del libro no encontrado - " + libroId);
		}
		
		libroService.deleteById(libroId);
		
		return "Id del libro eliminado - " + libroId;
	}
	
}










