<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>RAMPA</title>
	</head>
	
	<body>
		<section>
			<span>RAMPA - Crear actividad</span>
			
			<h3>Nueva actividad</h3>
			<f:form  action="/rampa/actividades/darAltaActividad" method="post" modelAttribute="nuevaActividad">
					<table border="0" cellspacing="0" cellpadding="6"  style="padding:25px;  ">
					    
					    <tr>
							<td><label>Nombre:</label></td>
							<td><f:input path="nombre"  /></td>
							<td><f:errors path="nombre" /></td>
						</tr>
						<tr>
							<td><label>Código:</label></td>
							<td><f:input path="codigo"  /></td>
							<td><f:errors path="codigo" /></td>
						</tr>
												<tr>
							<td><label>Cuota:</label></td>
							<td><f:input path="cuota" /></td>
							<td><f:errors path="cuota"  /></td>
						</tr>
																		<tr>
							<td><label>Descripción:</label></td>
							<td><f:textarea path="descripcion"  rows="5" cols ="30"/></td>
							<td><f:errors path="descripcion"  /></td>
						</tr>
						<tr>
							<td><label>Fecha de Inicio:</label></td>
							<td><input type="date" name ="fechadeInicio"  /></td>
							<td><f:errors path="fechaInicio" /></td>
						</tr>
						<tr>
							<td><label>Fecha de Fin:</label></td>
							<td><input type="date" name ="fechadeFin" /></td>
							<td><f:errors path="fechaFin"  /></td>
						</tr>
					    
						<tr>
      						<td></td>
					     	<td><input type="submit" value="Enviar" /></td>
					    </tr>
					</table>
				</f:form>
			<a href="/rampa/actividades/">Volver a Actividades</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>