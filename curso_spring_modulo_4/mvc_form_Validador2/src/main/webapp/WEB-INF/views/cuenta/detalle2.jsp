<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mvc_form_Validador2</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>
				Ejemplo Validación usando dos clases CuentaValidator y CuentaValidator2 <small>mvc_form_Validador2</small>
			</h1>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">Resultado datos enviados</div>
			<div class="panel-body">

				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Email</th>
							<th>Saldo</th>
							<th>Endeudamiento</th>
							<th>Fecha</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${cuenta.id}</td>
							<td>${cuenta.email}</td>
							<td>${cuenta.nombre}</td>
							<td>${cuenta.saldo}</td>
							<td>${cuenta.nivelEndeudamiento}</td>
							<td>${cuenta.fechaRenovacion}</td>
						</tr>
					</tbody>
				</table>

				<a class="btn btn-default" href=".." role="button">Volver</a>
			</div>
		</div>

	</div>

</body>
</html>