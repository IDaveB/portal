<%@include file="/resources/includes/estilos.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8' />
<title>Perfil</title>
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

	<table align="center">
		<tr>
			<td>
				<form action="updateUsuario" method="post">
					<div>
						<ul>

							<li>
									<label for="name">Nombre de usuario :</label>
								
								<input type="text" name="nombre" placeholder="Nombre"
								value="${usuario.nombre}" required /></li>
							<li>
									<label for="name">Apellidos :</label>
								</h3> <input type="text" name="apellidos" placeholder="Apellidos"
								value="${usuario.apellidos}" required /></li>
							<li>
									<label for="name">Telefono :</label>
								 <input type="text" name="telefono" placeholder="Telefono"
								pattern="[0-9]{9}" maxlength="9" value="${usuario.telefono}"
								required /></li>
							<li>
									<label for="name">Direccion :</label>
								 <input type="text" name="direccion" placeholder="Direccion"
								value="${usuario.direccion}" required /></li>
							<li>
									<label for="name">Correo electronico :</label>
								 <input type="text" name="email" placeholder="Email"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
								value="${usuario.email}" required /></li>

							<br />
							<center>
								<button type="submit" class="btn btn-success">Modificar
									usuario</button>
							</center>
						</ul>

					</div>
				</form>
			</td>
		</tr>
	</table>

	<%@include file="/resources/includes/scripts.jsp"%>
</body>
</html>