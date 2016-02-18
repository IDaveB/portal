<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/resources/includes/estilos.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8' />
<title>Usuarios</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container"></div>
	</div>
	<br />
	<br />
	<br />
	<br />
	<center>
		<div class="masthead">
			<ul class="nav nav-justified">
				<li><a href="menuUsuarios"><span
						class="glyphicon glyphicon-user"></span><span
						class="glyphicon glyphicon-user"></span> &nbsp;&nbsp;Usuarios</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" data-hover="dropdown"><span
						class="glyphicon glyphicon-chevron-down"></span>&nbsp;&nbsp;Menu</a>
					<ul class="dropdown-menu">
						<li><a href="menuPerfil"><center>
									<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Perfil
								</center></a></li>
						<li><a href="menuSalir"><center>
									<span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;Salir
								</center></a></li>
					</ul></li>
			</ul>

		</div>
	</center>
	<br />
	<br />
	<p align="center">
		<font color="red">${mensaje}</font>
	</p>
	<br />
	<br />
	<table class="table table-hover" align="center">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Email</th>
				<th>Telefono</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.nombre}</td>
					<td>${usuario.apellidos}</td>
					<td>${usuario.email}</td>
					<td>${usuario.telefono}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<%@include file="/resources/includes/modal_borrarUsuario.jsp"%>
	<%@include file="/resources/includes/scripts.jsp"%>
</body>
</html>