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
			<c:set var="alumno" value="${alumno}"/>
			<h2>RAMPA - Perfil de alumno</h2>
			
			<h3>Alumno con id ${alumno.id}</h3>

			<b>Id:</b> ${alumno.id} <br/>
			
			<b>Nombre:</b> ${alumno.nombre} <br/>
			
			<b>Primer apellido:</b> ${alumno.apellido1} <br/>
			
			<b>Segundo apellido:</b> ${alumno.apellido2} <br/>
			
			<b>Observaciones:</b> ${alumno.observaciones} <br/>
			
 			<b>Fecha de nacimiento:</b> <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${alumno.fechaNacimiento}" /> <br/> 
			
			<b>Socio al que pertence:</b> ${alumno.socio.id}<br/>
			
<!-- 			<b>Inscripciones:</b> <br/> -->
<%-- 			<c:forEach var="inscripcion" items="${alumno.inscripciones}"> --%>
<%-- 				<i>&nbsp;${inscripcion.actividad.nombre} </i><br/> --%>
<%-- 			</c:forEach> --%>
			
			<br/>
			
			<a href="/rampa/alumnos/alumno/${alumno.id}/inscripciones">Ver inscripciones</a>
			
 			<a href="/rampa/socios/perfil/${alumno.socio.id}">Ver socio</a>
			
			<a href="/rampa/alumnos/">Volver a Alumnos</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>