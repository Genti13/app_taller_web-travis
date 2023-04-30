<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ejemplo Spring MVC</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">    
			<div class="panel panel-default">
			<div class="panel-body">
				<h2>Nombre: ${nombre}</h1>
			    <h2>Apellido: ${apellido}</h2>
			    <h2>EMAIL: ${mail}</h2>
			    <a href="${pageContext.request.contextPath}" ><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Volver</a>
			</div>
		</div>
    </div>
</body>
</html>