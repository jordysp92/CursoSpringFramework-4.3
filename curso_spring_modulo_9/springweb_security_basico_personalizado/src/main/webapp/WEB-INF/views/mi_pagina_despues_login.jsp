<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>springweb_security_basico_personalizado</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="alert alert-success">
			<p>Ha iniciado sesión con éxito!</p>
		</div>

		<div class="panel panel-success">
			<div class="panel-heading">Primera página después del login</div>
			<div class="panel-body">
				<p>Esto es la primera página justo después del login de inicio
					de sesión (mi_pagina_despues_login.jsp). Todo el mundo después de
					iniciar sesión, verá esta página.</p>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/index.jsp" role="button">Volver
					al index.jsp</a>
				<form action="${pageContext.request.contextPath}/logout" method="post">
					<input class="btn btn-warning" role="button" type="submit"
						value="Log out" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>