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
			<span>RAMPA - Inscripciones</span>
			
			<ul>
				<li><a href="/rampa/inscripciones/alta">Crear inscripcion</a></li>
			</ul>
			
			<h3>Listado de inscripciones</h3>
			<ul>
				<c:forEach var="inscripcion" items="${listaInscripciones}">
					<b>Actividad:</b> ${inscripcion.actividad.codigo} <br/>
					<b>Alumno:</b> ${inscripcion.alumno.nombre} ${inscripcion.alumno.apellido1} ${inscripcion.alumno.apellido2}<br/>
					<b>Pago al día:</b> ${inscripcion.pagoAlDia} <br/>
					<b>Fecha Alta:</b> <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${inscripcion.fechaAlta}" /> <br/>
					<b>Fecha Baja:</b> <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${inscripcion.fechaBaja}" /> <br/>
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