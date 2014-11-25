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
			<h2>RAMPA - Socios</h2>
			
			<ul>
				<li><a href="/rampa/socios/alta">Crear nuevo socio</a></li>
			</ul>
			
			<c:choose>
				<c:when test="${empty listaSocios}">
					<h3>Actualmente no hay ningún socio en el sistema</h3>
				</c:when>
				<c:otherwise>
					<h3>Listado de socios</h3>
					<ul>
						<c:forEach items="${listaSocios}" var="socio">
							<li>
								<a href="/rampa/socios/perfil/${socio.numero}">
									<c:out value="${socio.numero}"/>
									<c:out value="${socio.nombre}"/>
									<c:out value="${socio.apellido1}"/>
									<c:out value="${socio.apellido2}"/>
								</a>
							</li>
						</c:forEach>
					</ul>
				</c:otherwise>
			</c:choose>
			
			<a href="/rampa/">Volver a Portada</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>