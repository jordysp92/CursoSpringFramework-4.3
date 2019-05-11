<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>springweb_security_basico</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse">
			<ul id="barramenu" class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/login">Login</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Ejemplo: Spring Security Básico</div>
			<div class="panel-body">
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

</body>
</html>