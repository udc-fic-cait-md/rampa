<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>RAMPA</title>
	</head>
	
	<body>
		<section>
			<h2>RAMPA - Alta de socio</h2>
	
			<c:if test="${not empty infoMsg}">
				<s:message code="${infoMsg}" />
			</c:if>

		<f:form method="POST" modelAttribute="nuevoSocio" action="/rampa/socios/darAltaSocio">
				<table>
					<tr>
						<td>Nombre:</td>
						<td><f:input path="nombre"/></td>
						<td><f:errors path="nombre" /></td>
					</tr>
					<tr>
						<td>Primer apellido:</td>
						<td><f:input path="apellido1"/></td>
						<td><f:errors path="apellido1" /></td>
					</tr>
					<tr>
						<td>Segundo apellido:</td>
						<td><f:input path="apellido2"/></td>
						<td><f:errors path="apellido2" /></td>
					</tr>
					<tr>
						<td>Dirección</td>
						<td><f:input path="direccion"/></td>
						<td><f:errors path="direccion" /></td>
					</tr>
					<tr>
						<td>Teléfono:</td>
						<td><f:input path="telefono"/></td>
						<td><f:errors path="telefono" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><f:input path="email"/></td>
						<td><f:errors path="email" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Registrar"/></td>
					</tr>
				</table>
			</f:form>
			<a href="/rampa/socios">Volver a Socios</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>