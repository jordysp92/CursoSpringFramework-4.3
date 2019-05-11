<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>springweb_security_jdbc_basico</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container">
		<sec:authorize access="!isAuthenticated()">

			<div class="alert alert-info">
				<p>Nuestra página de inicio de sesión!</p>
			</div>

			<c:if test="${not empty error}">
				<div class="alert alert-danger">
					<p>${error}</p>
				</div>
			</c:if>

			<c:if test="${not empty msg}">
				<div class="alert alert-warning">
					<p>${msg}</p>
				</div>
			</c:if>

			<div class="panel panel-primary">
				<div class="panel-heading">Inicio de sesión</div>
				<div class="panel-body">

					<form name='f' action="${pageContext.request.contextPath}/login"
						method='post' class="form-horizontal" role="form">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
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
								<input style="width: 300px;" class="form-control"
									type='password' name='password' />
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
			<div class="alert alert-info">
				<p style="color: blue">Nota: Puedes iniciar sesión con
					cualquiera de los siguientes username/password:</p>
				<ul>
					<li>aguzman/demo</li>
					<li>rod/demo</li>
					<li>bruce/demo</li>
					<li>andres/demo</li>
				</ul>
			</div>
		</sec:authorize>
	</div>
</body>
</html>