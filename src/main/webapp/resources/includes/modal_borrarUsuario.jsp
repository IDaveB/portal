<script type="text/javascript">
	function deleteUser(id, nombre, apellidos) {
		console.log(id);

		document.getElementById('ID').setAttribute("value", id);
		document.getElementById('CONFIRMACION').innerHTML = "Desea borrar a " + nombre
				+ " " + apellidos + "?";

	}
</script>

<div id="delete" class="modal fade" style="display: none;">
		<div class="modal-header">

			<a data-dismiss="modal" class="close">×</a>
			<h3>Eliminar usuario</h3>
		</div>
		<form class="formulario" role="form" action="deleteUsuario"
			method="post">
			<div class="modal-body">
				<input id="ID" name="id" type="hidden"/>
				<div id='CONFIRMACION'></div>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-success">Eliminar</button>
				<a href="#" data-dismiss="modal" class="btn">Cerrar</a>

			</div>
		</form>

	</div>