<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mvc_views_excel</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>ContentNegotiatingViewResolver!</h1>
			<p>El ContentNegotiatingViewResolver selecciona el View Resolver m�s apropiado para manejar el request comparando el "media type" (conocido tambi�n como Content-Type) para seleccionar la vista adecuada seg�n el "media type" enviado en la URL (como extensi�n)</p>
			<p>Si el request URL es con extensi�n .xls, entonces se seleccionar� la vista ExcelView de la lista DefaultViews independientemente del nombre de la vista retornada.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="cuentas.html" role="button">Ver en HTML</a>
				<a class="btn btn-success btn-lg" href="cuentas.xls" role="button">Exportar a Excel</a>
			</p>
		</div>

	</div>

</body>
</html>