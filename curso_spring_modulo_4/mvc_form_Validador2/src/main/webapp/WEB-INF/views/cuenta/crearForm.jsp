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

		<ul class="nav nav-tabs">
			<li role="presentation"><a href="?locale=en_us">us</a></li>
			<li role="presentation" class="active"><a href="?locale=es_es">es</a></li>
			<li role="presentation"><a href="?locale=de_de">de</a></li>
		</ul>

		<div class="page-header">
			<h1>
				Ejemplo Validación usando dos clases CuentaValidator y CuentaValidator2
			</h1>
		</div>
		<h3>Crear Cuenta - <small>Probar el validador: ingrese una fecha de
			renovación en tiempo pasado (ejemplo 03/04/15) para forzar el error.
			Agregamos un segundo validador que revisa que el saldo sea mayor a
			2000.</small></h3>
		<div class="panel panel-primary">
			<div class="panel-heading">Crear Cuenta</div>
			<div class="panel-body">
				<div class="container">
					<div class="row">
						<!-- El objeto del model "cuenta" se crea dentro del metodo "crearCuentaForm(Model model)"
			de la clase controladora "CuentaController". -->
						<form:form modelAttribute="cuenta" action="cuenta" method="post"
							cssClass="form-horizontal" role="form">
							<div class="form-group">
								<form:label for="nombre" path="nombre"
									cssClass="col-sm-2 control-label">Nombre</form:label>
								<div class="col-sm-10">
									<form:input path="nombre" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="nombre" />
								</div>
							</div>

							<div class="form-group">
								<form:label for="email" path="email"
									cssClass="col-sm-2 control-label">Email</form:label>
								<div class="col-sm-10">
									<form:input path="email" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="email" />
								</div>
							</div>

							<div class="form-group">
								<form:label for="saldo" path="saldo"
									cssClass="col-sm-2 control-label">Saldo</form:label>
								<div class="col-sm-10">
									<form:input path="saldo" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="saldo" />
								</div>
							</div>
							<div class="form-group">
								<form:label for="nivelEndeudamiento" path="nivelEndeudamiento"
									cssClass="col-sm-2 control-label">Nivel Endeudamiento</form:label>
								<div class="col-sm-10">
									<form:input path="nivelEndeudamiento" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="nivelEndeudamiento" />
								</div>
							</div>
							<div class="form-group">
								<form:label for="fechaRenovacion" path="fechaRenovacion"
									cssClass="col-sm-2 control-label">Fecha Renovación</form:label>
								<div class="col-sm-10">
									<form:input path="fechaRenovacion" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="fechaRenovacion" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="submit" value="Crear Cuenta"
										class="btn btn-primary" role="button" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>