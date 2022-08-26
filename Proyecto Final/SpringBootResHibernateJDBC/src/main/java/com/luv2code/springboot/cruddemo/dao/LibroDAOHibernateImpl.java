package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Libro;

@Repository
public class LibroDAOHibernateImpl implements LibroDAO {

	
	private EntityManager entityManager;
		
	// se configura la inyeccion de dependencias por spring boot
	@Autowired  
	public LibroDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Libro> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		// Se ejecuta una consulta apartir del entity en este caso LibroDAO
		Query<Libro> theQuery =
				currentSession.createQuery("from Libro", Libro.class); 
		
		// Se alamacenan los registros
		List<Libro> libro = theQuery.getResultList();
		
		// se devuelve el resultado		
		return libro;
	}


	@Override
	public Libro findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		// obtener un registro a partir del id
		Libro libro =
				currentSession.get(Libro.class, theId);

		return libro;
	}


	@Override
	public void save(Libro libro) {
		
		//se actualiza o se inserta segun sea el caso
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(libro);
	}


	@Override
	public void deleteById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
				
		// se elimina un registro a partir de un id usando el entity
		Query theQuery = 
				currentSession.createQuery(
						"delete from Libro where id=:clienteId");
		theQuery.setParameter("libroId", theId);
		
		theQuery.executeUpdate();
	}




}







