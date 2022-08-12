package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			studentDbUtil = new ClienteDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listClientes(request, response);
				break;
				
			case "ADD":
				addCliente(request, response);
				break;
				
			case "LOAD":
				loadCliente(request, response);
				break;
				
			case "UPDATE":
				updateCliente(request, response);
				break;
			
			case "DELETE":
				deleteCliente(request, response);
				break;
				
			default:
				listClientes(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteCliente(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// delete student from database
		studentDbUtil.deleteStudent(theStudentId);
		
		// send them back to "list students" page
		listClientes(request, response);
	}

	private void updateCliente(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");
		
		// create a new student object
		Cliente theStudent = new Cliente(id, nombre, apellido, telefono);
		
		// perform update on database
		studentDbUtil.updateStudent(theStudent);
		
		// send them back to the "list students" page
		listClientes(request, response);
		
	}

	private void loadCliente(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// get student from database (db util)
		Cliente theStudent = studentDbUtil.getStudent(theStudentId);
		
		// place student in the request attribute
		request.setAttribute("THE_STUDENT", theStudent);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-cliente-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");		
		
		// create a new student object
		Cliente theStudent = new Cliente(nombre, apellido, telefono);
		
		// add the student to the database
		studentDbUtil.addStudent(theStudent);
				
		// send back to main page (the student list)
		listClientes(request, response);
	}

	private void listClientes(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Cliente> students = studentDbUtil.getStudents();
		
		// add students to the request
		request.setAttribute("STUDENT_LIST", students);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-clientes.jsp");
		dispatcher.forward(request, response);
	}

}













