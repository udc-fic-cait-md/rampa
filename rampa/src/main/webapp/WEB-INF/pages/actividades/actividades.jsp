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
				<li><a href="/rampa/actividades/alta">Crear actividad</a></li>
			</ul>
			
			<h3>Listado de actividades</h3>
			<ul>
				<c:forEach var="actividad" items="${listaActividades}">
					<b>Código:</b> ${actividad.codigo} <br/>
					<b>Nombre:</b> ${actividad.nombre} <br/>
					<b>Descripción:</b> ${actividad.descripcion} <br/>
					<b>Cuota:</b> ${actividad.cuota} euros <br/>
					<b>Fecha de inicio:</b> <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${actividad.fechaInicio}" /> <br/>
					<b>Fecha de fin:</b> <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${actividad.fechaInicio}" /> <br/>
					<b>Alumnos inscritos:</b> <br/>
					<c:forEach var="inscripcion" items="${actividad.inscripciones}">
						<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${inscripcion.alumno.nombre} ${inscripcion.alumno.apellido1} ${inscripcion.alumno.apellido2}</i><br/>
					</c:forEach>
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