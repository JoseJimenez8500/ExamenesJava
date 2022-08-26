package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.LibroDAO;
import com.luv2code.springboot.cruddemo.entity.Libro;


@Service
public class ClienteServiceImpl implements LibroService {

	private LibroDAO libroDAO;
	
	@Autowired
	//se defien a traves de @Qualifier que se desea implementar 
	public ClienteServiceImpl(@Qualifier("libroDAOHibernateImpl")LibroDAO theLibroDAO) {
		libroDAO = theLibroDAO;
	}
	
	@Override
	@Transactional
	public List<Libro> findAll() {
		return libroDAO.findAll();
	}

	@Override
	@Transactional
	public Libro findById(int theId) {
		return libroDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Libro theEmployee) {
		libroDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		libroDAO.deleteById(theId);
	}

}






