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
<title>mvc_form_etiquetas</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				Formulario Spring <small> Etiquetas Form de Spring y
					Validaciones usando Anotaciones</small>
			</h1>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">Resultado Estudiante</div>
			<div class="panel-body">
				<div class="container">
					<div class="row">

						<table class="table table-striped table-hover table-bordered"
							style="width: 800px;">
							<tbody>
								<tr>
									<td>User Name:</td>
									<td>${estudianteCommand.userName}</td>
								</tr>
								<tr>
									<td>Dirección:</td>
									<td>${estudianteCommand.direccion}</td>
								</tr>
								<tr>
									<td>Password:</td>
									<td>${estudianteCommand.password}</td>
								</tr>
								<tr>
									<td>Recibe newsletter:</td>
									<td>${estudianteCommand.recibeNewsletter}</td>
								</tr>
								<tr>
									<td>Temas favoritos:</td>
									<td><c:forEach items="${estudianteCommand.temas}"
											var="tema">
                                        [<c:out value="${tema}" />]
                                       </c:forEach></td>
								</tr>
								<tr>
									<td>Género:</td>
									<td>${estudianteCommand.genero}</td>
								</tr>
								<tr>
									<td>Número Favorito :</td>
									<td>${estudianteCommand.numeroFavorito}</td>
								</tr>
								<tr>
									<td>País:</td>
									<td>${estudianteCommand.pais}</td>
								</tr>
								<tr>
									<td>Habilidades de Spring:</td>
									<td>${estudianteCommand.experienciaSpring}</td>
								</tr>
								<tr>
									<td>Valor Secreto :</td>
									<td>${estudianteCommand.valorSecreto}</td>
								</tr>
							</tbody>
						</table>
						<a class="btn btn-default" href="<%=request.getContextPath() %>/estudiante" role="button">Volver</a>

					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>

