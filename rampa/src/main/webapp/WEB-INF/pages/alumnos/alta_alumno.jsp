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
			<span>RAMPA - Dar de alta alumno</span>
			
			<h3>Nuevo alumno</h3>

			<f:form action="/rampa/alumnos/darAltaAlumno" method="post" modelAttribute="nuevoAlumno">
					<table border="0" cellspacing="0" cellpadding="6" style="padding:25px;">
					    
					    <tr>
							<td><label>Nombre:</label></td>
							<td><f:input path="nombre"/></td>
							<td><f:errors path="nombre"/></td>
						</tr>
						<tr>
							<td><label>Primer apellido:</label></td>
							<td><f:input path="apellido1"/></td>
							<td><f:errors path="apellido1"/></td>
						</tr>
						<tr>
							<td><label>Segundo apellido:</label></td>
							<td><f:input path="apellido2"/></td>
							<td><f:errors path="apellido2"/></td>
						</tr>
						<tr>
							<td><label>Curso:</label></td>
							<td><f:input path="curso" /></td>
							<td><f:errors path="curso"/></td>
						</tr>
						<tr>
							<td><label>Observaciones:</label></td>
							<td><f:textarea path="observaciones"  rows="5" cols ="30"/></td>
							<td><f:errors path="observaciones"/></td>
						</tr>
						<tr>
							<td><label>Fecha de nacimiento:</label></td>
							<td><input type="date" name ="fechaNacimiento"/></td>
							<td><f:errors path="fechaNacimiento"/></td>
						</tr>
						<tr>
							<td><label>Socio al que está asociado:</label></td>
							<td>
								<f:select path="socio">
									<f:option value="-1" label="--- Seleccionar número de socio ---"/>
									<c:forEach var="soc" items="${listaSocios}">
										<f:option value="${soc.numero}" label="${soc.numero}"/>
									</c:forEach>
								</f:select>
							</td>
							<td><f:errors path="socio"/></td>
						</tr>
					    
						<tr>
      						<td></td>
					     	<td><input type="submit" value="Enviar"/></td>
					    </tr>
					</table>
				</f:form>
			<a href="/rampa/alumnos/">Volver a Alumnos</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>