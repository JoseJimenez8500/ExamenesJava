package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Libro;

@Repository
public class LibroDAOJdbcImpl implements LibroDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Libro> findAll() {

		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Libro> listaLibros = new ArrayList<>();

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from libros");) {

			// process result set
			while (myRs.next()) {

				// se hace la consulta en la tabla 
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String editorial = myRs.getString("editorial");
				String autor = myRs.getString("autor");
				String genero = myRs.getString("genero");
				String pais_del_autor = myRs.getString("pais_del_autor");
				String numero_paginas = myRs.getString("numero_paginas");
				String anio_edicion = myRs.getString("anio_edicion");
				String precio = myRs.getString("precio");

				Libro tempLibro = new Libro(id, nombre, editorial, autor,genero,pais_del_autor,numero_paginas,anio_edicion,precio);

				// se guradan los registros
				listaLibros.add(tempLibro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaLibros;
	}

	@Override
	public Libro findById(int theId) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		Libro theLibro = null;
		try (
				// Se crea la conexion a la tabla 
				Connection myConn = dataSource.getConnection();
				// se crea el query para insertar 
				PreparedStatement myStmt = myConn.prepareStatement("select * from libros where id=?");

		) {
			myStmt.setInt(1, theId);
			
			try(ResultSet myRs = myStmt.executeQuery()){
				
				// se hace una sola consulta a traves del id
				if (myRs.next()) {
					String nombre = myRs.getString("nombre");
					String editorial = myRs.getString("editorial");
					String autor = myRs.getString("autor");
					String genero = myRs.getString("genero");
					String pais_del_autor = myRs.getString("pais_del_autor");
					String numero_paginas = myRs.getString("numero_paginas");
					String anio_edicion = myRs.getString("anio_edicion");
					String precio = myRs.getString("precio");

					Libro tempLibro = new Libro(theId, nombre, editorial, autor,genero,pais_del_autor,numero_paginas,anio_edicion,precio);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theLibro;

	}

	@Override
	public void save(Libro theLibro) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);
		
		if (theLibro.getId()==0) {
		try (
				Connection myConn = dataSource.getConnection();

				// sql para insertar
				PreparedStatement myStmt = myConn.prepareStatement(
						"insert into libros " + "(nombre, editorial, autor, genero, pais_del_autor, numero_paginas, anio_edicion, precio) " + "values (?, ?, ?)");) {
	
			myStmt.setString(1, theLibro.getNombre());
			myStmt.setString(2, theLibro.getEditorial());
			myStmt.setString(3, theLibro.getAutor());
			myStmt.setString(4, theLibro.getGenero());
			myStmt.setString(5, theLibro.getPais_del_autor());
			myStmt.setString(6, theLibro.getNumero_paginas());
			myStmt.setString(7, theLibro.getAnio_edicion());
			myStmt.setString(8, theLibro.getPrecio());
			

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}else {
			try (
	
					Connection myConn = dataSource.getConnection();

					PreparedStatement myStmt = myConn.prepareStatement("update libros set nombre=?, editorial=?, autor=?, genero=?, pais_del_autor=?, numero_paginas=?, anio_edicion=?, precio=?, where id=?");) {

				myStmt.setString(1, theLibro.getNombre());
				myStmt.setString(2, theLibro.getEditorial());
				myStmt.setString(3, theLibro.getAutor());
				myStmt.setString(4, theLibro.getGenero());
				myStmt.setString(5, theLibro.getPais_del_autor());
				myStmt.setString(6, theLibro.getNumero_paginas());
				myStmt.setString(7, theLibro.getAnio_edicion());
				myStmt.setString(8, theLibro.getPrecio());

				myStmt.execute();
				//se ejecuta la instruccion para actualizar
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int theId) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		try (

				Connection myConn = dataSource.getConnection();
	
				PreparedStatement myStmt = myConn.prepareStatement("delete from libros where id=?")) {

			myStmt.setInt(1, theId);

			// se ejecuta la instruccion para eliminar
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
