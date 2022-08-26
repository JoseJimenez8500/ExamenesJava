<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista libros</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CTabla Libros</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Libro"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>nombre</th>
					<th>editorial</th>
					<th>autor</th>
					<th>genero</th>
					<th>pais_del_autor</th>
					<th>numero_paginas</th>
					<th>año_edicion</th>
					<th>precio</th>
				
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempLibro" items="${libros}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/libro/showFormForUpdate">
						<c:param name="libroId" value="${tempLibro.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/libro/delete">
						<c:param name="libroId" value="${tempLibro.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempLibro.nombre} </td>
						<td> ${tempLibro.editorial} </td>
						<td> ${tempLibro.autor} </td>
						<td> ${tempLibro.genero} </td>
						<td> ${tempLibro.pais_del_autor} </td>
						<td> ${tempLibro.numero_paginas} </td>
						<td> ${tempLibro.anio_edicion} </td>
						<td> ${tempLibro.precio} </td>
						
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this libro?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









