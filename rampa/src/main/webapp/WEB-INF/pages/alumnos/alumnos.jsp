<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>RAMPA</title>
		<%@ page isELIgnored="false" %>
	</head>
	
	<body>
		<section>
			<span>RAMPA - Actividades</span>
			
			<ul>
				<li><a href="/rampa/alumnos/alta">Crear alumno</a></li>
			</ul>
			
			<h3>Listado de alumnos</h3>
			<ul>
				<c:forEach var="alumno" items="${listaAlumnos}">
					<li><a href="/rampa/alumnos/perfil/${alumno.id}">${alumno.nombre} ${alumno.apellido1} ${alumno.apellido2} </a></li>
				</c:forEach>
			</ul>
		
			<a href="/rampa/">Volver a Portada</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>