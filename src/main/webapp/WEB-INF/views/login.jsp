<%@include file="/resources/includes/estilos.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container"></div>
	</div>

	<br />
	<br />
	<br />
	<br />
	<br />

	<table align="center">

		<tr>
			<td><img src="resources/img/principal.png" width="450"
				height="450"></td>
			<td><img src="resources/img/blanco.jpg" width="20" height="20"></td>
			<td align="center"><img src="resources/img/titulo.jpg"
				width="200" height="70"> <br /> <br />
				<form action="registro" method="post">
					<div class="form-group"><br/>
					<p align="center"><font color="red">${mensaje}</font></p>
						<input type="text" placeholder="Correo electronico" name="email"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
							class="form-control" style="width: 200px" required />
					</div>

					<div class="form-group">
						<input type="password" placeholder="Contraseña" name="password"
							class="form-control" style="width: 200px" required />
					</div>
					<br />
					<button type="submit" class="btn btn-success">Iniciar
						sesión</button>
				</form> <a data-toggle="modal" href="#exampleR"> <font size="1">
			<br />

				<div>
					<h4>
						<a href="registroUsuario">Registrate aqui</a>
					</h4>
				</div></td>



		</tr>

	</table>
	
	<%@include file="/resources/includes/scripts.jsp"%>
</body>
</html>