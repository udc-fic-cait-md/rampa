<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>RAMPA</title>
	</head>
	
	<body>
		<section>
			<h2>RAMPA - Perfil de socio</h2>
			
			<table>
				<tr>
					<td>Numero de socio:</td>
					<td>${socio.numero}</td>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td>${socio.nombre}</td>
				</tr>
				<tr>
					<td>Apellidos:</td>
					<td>${socio.apellido1} ${socio.apellido2}</td>
				</tr>
				<tr>
					<td>Telefono:</td>
					<td>${socio.telefono}</td>
				</tr>
				<tr>
					<td>Direccion:</td>
					<td>${socio.direccion}</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>${socio.email}</td>
				</tr>
			</table>
			
			<a href="/rampa/socios/">Volver a Socios</a>
		</section>
	
		<footer>
			<p>Copyright 2014 Rampa</p>
		</footer>
	
	</body>
</html>