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
					<b>Id:</b> ${alumno.id} <br/>
					<b>Nombre y apellidos:</b> ${alumno.nombre} ${alumno.apellido1} ${alumno.apellido2}<br/>
					<b>Fecha de nacimiento:</b> <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${alumno.fechaNacimiento}" /> <br/>
					<b>Curso:</b> ${alumno.curso} <br/>
					<b>Observaciones:</b> ${alumno.observaciones} <br/>
					<b>Socio al que está asociado:</b> <br/>
					<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Número:</i> ${alumno.socio.numero}<br/>
					<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nombre y apellidos:</i> ${alumno.socio.nombre} ${alumno.socio.apellido1} ${alumno.socio.apellido2}<br/>
					<b>----------------------------------------------------------------</b>
					<br/>
				</c:forEach>
			</ul>
		
			<a href="/rampa/">Volver a Portada</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>