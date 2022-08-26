<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Libro</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Tabla Libros</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Libro</h3>
	
		<form:form action="saveLibro" modelAttribute="libro" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>editorial:</label></td>
						<td><form:input path="editorial" /></td>
					</tr>

					<tr>
						<td><label>autor:</label></td>
						<td><form:input path="autor" /></td>
					</tr>
					
					<tr>
						<td><label>genero:</label></td>
						<td><form:input path="genero" /></td>
					</tr>
				
					<tr>
						<td><label>pais_del_autor:</label></td>
						<td><form:input path="pais_del_autor" /></td>
					</tr>

					<tr>
						<td><label>numero_paginas:</label></td>
						<td><form:input path="numero_paginas" /></td>
					</tr>
					
					<tr>
						<td><label>año_edicion:</label></td>
						<td><form:input path="anio_edicion" /></td>
					</tr>
				
					<tr>
						<td><label>precio:</label></td>
						<td><form:input path="precio" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/libro/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










