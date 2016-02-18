<%@include file="/resources/includes/estilos.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8' />
<title>Registrarse</title>
</head>
<body>
	<br />
	<br />
	<center>
		<p align="center">
			<font color="red">${mensaje}</font>
		</p>
	</center>
	<br />
	<br />



	<table align="center">
		<tr>
			<td>
				<form action="registroUsuarioDatos" method="post">
					<div>
						<ul>

							<li><label for="name">Nombre de usuario :</label> <input
								type="text" name="nombre" placeholder="Nombre" required /></li>
							<li><label for="name">Apellidos :</label>
								</h3> <input type="text" name="apellidos" placeholder="Apellidos"
								required /></li>
							<li><label for="name">Telefono :</label> <input type="text"
								name="telefono" placeholder="Telefono" pattern="[0-9]{9}"
								maxlength="9" required /></li>
							<li><label for="name">Direccion :</label> <input type="text"
								name="direccion" placeholder="Direccion" required /></li>
							<li><label for="name">Correo electronico :</label> <input
								type="text" name="email" placeholder="Email"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required /></li>
							<li><label for="name">Password :</label> <input
								type="password" name="password" placeholder="Nombre" required /></li>

							<br />

							<center>
								<button type="submit" class="btn btn-success">Registrarse
								</button>
							</center>
						</ul>

					</div>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>