package com.luv2code.springboot.cruddemo.dao;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Libro;

//Capa de persistencia
public interface LibroDAO {   

	List<Libro> findAll();
	
	Libro findById(int theId);
	
	void save(Libro libro);
	
	void deleteById(int theId);
	
}
