package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Libro;

public interface LibroService {

	public List<Libro> getLibros();

	public void saveLibro(Libro theLibro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
