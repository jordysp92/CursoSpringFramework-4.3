<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mvc_basico_HandlerArguments</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Ejemplo: Argumentos en los métodos handler de los @Controller</div>
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
				
					<li><a href="holamundo/hola/1">/holamundo/hola/1</a></li>
					<li><a href="holamundo/hola/2?miCiudad=Santiago">/holamundo/hola/2?miCiudad=Santiago</a></li>
					<li><a href="holamundo/hola/3?miCiudad=Madrid">/holamundo/hola/3?miCiudad=Madrid</a></li>
					<li><a href="holamundo/hola/4?miCiudad=Mexico DF">/holamundo/hola/4?miCiudad=Mexico DF</a></li>
					<li><a href="holamundo/mi-locale">/holamundo/mi-locale (Recibe una instancia Locale y HttpServletRequest)</a></li>
					<li><a href="holamundo/requestHeader1">/holamundo/requestHeader1 (Mostramos un request header con nombre explícito)</a></li>
					<li><a href="holamundo/requestHeader2">/holamundo/requestHeader2 (Mostramos un request header con nombre implícito)</a></li>

				</ul>
			</div>
		</div>

	</div>

</body>
</html>
