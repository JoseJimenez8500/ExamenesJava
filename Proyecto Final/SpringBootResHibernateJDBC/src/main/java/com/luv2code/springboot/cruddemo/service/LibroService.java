package com.luv2code.springboot.cruddemo.service;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Libro;

public interface LibroService {

	public List<Libro> findAll();
	
	public Libro findById(int theId);
	
	public void save(Libro libro);
	
	public void deleteById(int theId);
	
}
