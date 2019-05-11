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

		<c:if test="${not empty error}">
			<div class="alert alert-info">
				<p>Su intento de inicio de sesión ha fallado, vuelva a
					intentarlo!</p>
				<p>Causa:
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
			</div>

		</c:if>
		<div class="alert alert-info">
			<p>Nuestra página de inicio de sesión!</p>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">Inicio de sesión
				(mi_pagina_login.jsp)</div>
			<div class="panel-body">

				<form name='f' action="${pageContext.request.contextPath}/login" 
					method='post' class="form-horizontal" role="form">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">Username:</label>
						<div class="col-sm-10">
							<input style="width: 300px;" class="form-control" type='text'
								name='username' />
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Contraseña:</label>
						<div class="col-sm-10">
							<input style="width: 300px;" class="form-control" type='password'
								name='password' />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" value="Iniciar Sesión"
								class="btn btn-primary" role="button" /> <input type="reset"
								value="Reset" class="btn btn-primary" role="button" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>