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
		<div class="alert alert-danger">
			<p>El login ha fallado!.</p>
		</div>

		<div class="panel panel-danger">
			<div class="panel-heading">Página de error</div>
			<div class="panel-body">
				<p>Esta es mi_pagina_errorlogin.jsp. Indica que el login ha fallado.</p>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/index.jsp" role="button">Ir a index.jsp</a>
			</div>
		</div>
	</div>
</body>
</html>