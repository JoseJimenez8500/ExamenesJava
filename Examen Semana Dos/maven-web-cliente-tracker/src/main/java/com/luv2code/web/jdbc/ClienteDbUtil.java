package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ClienteDbUtil {

	private DataSource dataSource;

	public ClienteDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Cliente> getStudents() throws Exception {
		
		List<Cliente> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from cliente order by nombre";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String telefono = myRs.getString("telefono");
				
				// create new student object
				Cliente tempStudent = new Cliente(id, nombre, apellido, telefono);
				
				// add it to the list of students
				students.add(tempStudent);				
			}
			
			return students;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addStudent(Cliente theStudent) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into cliente "
					   + "(nombre, apellido, telefono) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theStudent.getNombre());
			myStmt.setString(2, theStudent.getApellido());
			myStmt.setString(3, theStudent.getTelefono());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Cliente getStudent(String theStudentId) throws Exception {

		Cliente theStudent = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			// convert student id to int
			studentId = Integer.parseInt(theStudentId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from cliente where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String telefono = myRs.getString("telefono");
				
				// use the studentId during construction
				theStudent = new Cliente(studentId, nombre, apellido, telefono);
			}
			else {
				throw new Exception("Could not find student id: " + studentId);
			}				
			
			return theStudent;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateStudent(Cliente theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update cliente "
						+ "set nombre=?, apellido=?, telefono=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theStudent.getNombre());
			myStmt.setString(2, theStudent.getApellido());
			myStmt.setString(3, theStudent.getTelefono());
			myStmt.setInt(4, theStudent.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteStudent(String theStudentId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int studentId = Integer.parseInt(theStudentId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from cliente where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















