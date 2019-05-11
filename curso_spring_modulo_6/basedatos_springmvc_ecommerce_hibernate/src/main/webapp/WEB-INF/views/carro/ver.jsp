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
<title>${titulo}</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="page-header">
		<h1>${titulo}</h1>
	</div>
	<div class="container">


		<c:choose>
			<c:when test="${carro.size > 0}">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<c:out value="${titulo}" />
					</div>
					<div class="panel-body">
						<div class="container">
							<div class="row">

								<form name="formcarro" action="actualizar.htm" method="post">
									<table style="width: 600px;"
										class="table table-striped table-hover table-bordered">
										<thead>
											<tr>
												<th>Producto</th>
												<th>Cantidad</th>
												<th>Precio</th>
												<th>Total</th>
												<th>Borrar</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${carro.items}" var="item">
												<tr>
													<td><c:out value="${item.nombre}" /></td>
													<td><input type="text" maxlength="4" size="4"
														name="cant_<c:out value="${item.id}" />"
														value="<c:out value="${item.cantidad}" />" /></td>
													<td><strong><c:out value="${item.basePrecio}" /></strong></td>
													<td><strong><c:out value="${item.importe}" /></strong></td>
													<td><input type="checkbox"
														value="<c:out value="${item.id}" />"
														name="deleteProductos" /></td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="5" style="text-align: right;"><strong>Total:
														<c:out value="${carro.totalPrecio}" />
												</strong></td>
											</tr>
										</tbody>
									</table>
									<p>
										<a class="btn btn-success" role="button"
											href="javascript:document.formcarro.submit();">Actualizar</a>
										<a class="btn btn-primary" role="button"
											href="<c:url value="/catalogo/listado.htm"/>">Continuar
											comprando</a>
									</p>
								</form>

							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-warning" role="alert">
					<ul>
						<li>No hay item en el carro</li>
						<li><a href="<c:url value="/catalogo/listado.htm"/>">Continuar
								comprando</a></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>
