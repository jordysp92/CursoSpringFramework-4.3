<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Carro de Compras 2</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">

		<div class="page-header">
			<h1>Carro de Compras 2</h1>
		</div>

		<h2>
			<span class="label label-primary">Detalle de compras</span>
		</h2>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Comprador</th>
					<th>Producto</th>
					<th>Precio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${itemList}">
					<tr>
						<td>${usuario.nombre}</td>
						<td>${item.descripcion}</td>
						<td>${item.precio}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="5">No hay ítems</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		
		<h2>
			<span class="label label-info">Detalle de compras 2</span>
		</h2>
		
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Comprador</th>
					<th>Producto</th>
					<th>Precio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${itemList2}">
					<tr>
						<td>${usuario.nombre}</td>
						<td>${item.descripcion}</td>
						<td>${item.precio}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty itemList2}">
					<tr>
						<td colspan="5">No hay ítems</td>
					</tr>
				</c:if>
			</tbody>
		</table>

	</div>

</body>
</html>