<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mvc_basico_interceptor</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
	
		<div class="page-header">
			<h1>${mensaje3}</h1>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">Ejemplo: Interceptor que calcula el
				tiempo transcurrido</div>
			<div class="panel-body">

				<div class="alert alert-success" role="alert">
					<p>Tiempo Transcurrido: ${tiempoTranscurrido} milisegundos</p>
				</div>

			</div>
		</div>

	</div>

</body>
</html>