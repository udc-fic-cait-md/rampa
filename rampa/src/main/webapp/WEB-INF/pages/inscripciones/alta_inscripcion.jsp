<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>RAMPA</title>
		<%@ page isELIgnored="false" %>
	</head>
	
	<body>
		<section>
			<span>RAMPA - Alta de inscripción</span>
			
			<h3>Nueva inscripción</h3>
			<f:form action="/rampa/inscripciones/darAltaInscripcion" method="post" modelAttribute="nuevaInscripcion">
					<table border="0" cellspacing="0" cellpadding="6" style="padding:25px;">
					    
						<tr>
							<td><label>Fecha de alta:</label></td>
							<td><input type="date" name ="fechaAlta"/></td>
							<td><f:errors path="fechaAlta"/></td>
						</tr>
						<tr>
							<td><label>Fecha de baja:</label></td>
							<td><input type="date" name ="fechaBaja"/></td>
							<td><f:errors path="fechaBaja"/></td>
						</tr>
						<tr>
							<td><label>Alumno a inscribir:</label></td>
							<td>
								<f:select path="alumno">
									<f:option value="-1" label="--- Seleccionar id de alumno ---"/>
									<c:forEach var="alu" items="${listaAlumnos}">
										<f:option value="${alu.id}" label="${alu.id}"/>
									</c:forEach>
								</f:select>
							</td>
							<td><f:errors path="alumno"/></td>
						</tr>
					    <tr>
							<td><label>Actividad en la que se inscribe:</label></td>
							<td>
								<f:select path="actividad">
									<f:option value="-1" label="--- Seleccionar codigo de actividad ---"/>
									<c:forEach var="act" items="${listaActividades}">
										<f:option value="${act.codigo}" label="${act.codigo}"/>
									</c:forEach>
								</f:select>
							</td>
							<td><f:errors path="actividad"/></td>
						</tr>
						<tr>
      						<td></td>
					     	<td><input type="submit" value="Enviar"/></td>
					    </tr>
					</table>
				</f:form>
			<a href="/rampa/inscripciones">Volver a inscripciones</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>