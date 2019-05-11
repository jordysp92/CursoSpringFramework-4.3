<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>springweb_security_hibernate_userDetailsService</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- jquery -->
<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container">
		<c:if test="${not empty param.success}">
			<div class="alert alert-success">
				<p>Ha iniciado sesión con éxito!</p>
			</div>
		</c:if>
		<div class="panel panel-default">
			<div class="panel-heading">Ejemplo: Spring Security JDBC con Personalizado UserDetailsService</div>
			<div class="panel-body">
				<sec:authorize access="!isAuthenticated()">
					<div class="alert alert-info">
						Para comenzar con el ejemplo, por favor inicie sesión en el
						siguiente link: <a class="btn btn-info" role="button"
							href="<%=request.getContextPath()%>/mi_pagina_login">Login</a>
					</div>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">

					<div class="alert alert-success">
						<ul>
							<li>¡Felicitaciones! En este momento estás conectado como: <strong>${pageContext.request.userPrincipal.name}</strong></li>
							<sec:authorize access="hasRole('ROLE_SUPERVISOR')">
								<li>Excelente, usted tiene el role 'SUPERVISOR'.</li>
							</sec:authorize>

							<sec:authorize access="hasRole('ROLE_TELLER')">
								<li>Usted tiene el role 'TELLER'.</li>
							</sec:authorize>

							<sec:authorize access="hasRole('ROLE_USER')">
								<li>Usted tiene el role 'USER'.</li>
							</sec:authorize>
						</ul>
						<form id="logoutForm"
							action="${pageContext.request.contextPath}/logout" method="post">
							<input class="btn btn-warning" role="button" type="submit"
								value="Log out" /> <input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</div>
				</sec:authorize>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="holamundo">/holamundo</a></li>
					<li><a href="holamundo/hola-spring">/holamundo/hola-spring</a></li>
					<li><a href="holamundo/hola-springmvc">/holamundo/hola-springmvc</a></li>
					<li><a href="holamundo/hola-springcore">/holamundo/hola-springcore</a></li>
					<li><a href="holamundo/hola-springbatch">/holamundo/hola-springbatch</a></li>
				</ul>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		function formSubmit() {
			$("#logoutForm").submit();
		}
	</script>
</body>
</html>