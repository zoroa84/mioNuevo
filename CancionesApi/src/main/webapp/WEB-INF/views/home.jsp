<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/styles.css" />

</head>
<body>

	<main role="main" class="container">

	<h1>Artistas</h1>
	<div class="row">
		<div class="col-6">
			<ul id="lista" class="list-group">
				<li class="list-group-item">No existen Artistas</li>
			</ul>

		</div>
		<div class="col-6">
			<div class="form-group">
				<label for="nombre" >crear nuevo artista</label><br>
				<input type="text" id="input_nombre" placeholder="nombre artista">
				<p class="error" id="error"></p>
				<button type="button" class="btn btn-secondary" id="btnNuevo" >añadir</button>
			</div>
		</div>

	</div>


	</main>


	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>

	<script src="resources/js/custom.js"></script>

</body>
</html>
