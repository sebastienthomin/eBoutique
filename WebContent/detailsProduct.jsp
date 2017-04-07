<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="styles/ico/favicon.png">

<title>Catalogue des produits</title>

<!-- Bootstrap core CSS -->
<link href="styles/css/bootstrap.css" rel="stylesheet">
<link href="styles/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="styles/css/main.css" rel="stylesheet">


<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SP<i class="fa fa-circle"></i>T
				</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp">Accueil</a></li>
					<!-- <li><a href="authenticate">Authentification</a></li> -->
					<li class="active"><a href="viewCatalog">Catalogue des
							produits</a></li>
					<li><a href="works.jsp">WORKS</a></li>
					<li><a data-toggle="modal" data-target="#myModal"
						href="#myModal"><i class="fa fa-envelope-o"></i></a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div id="blue">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-8 col-lg-offset-2">
					<h4>
						D�tail du produit</b>
					</h4>
					<p>Acc�dez � toutes les informations sur le produit</p>
				</div>
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- blue wrap -->


	<div class="container desc">
		<div class="row">
			<br>
			<br>
			<div class="col-lg-4 centered">
				<img width="160" height="200" src="assets/img/ordi1.png" />
			</div>
			<div class="col-lg-5">
				<c:if test="${!empty produit}">
					<input type="hidden" id="id" data-id="${produit.id}" />
					<h1 id="name">${produit.name}</h1>
					<h2 id="sellingPrice" data-sellingprice="${produit.sellingPrice}">
						prix:
						<c:out value="${produit.sellingPrice}" />
					</h2>
					<div class="modele">
					<button class="btnDecrIncr" data-id="plus">+</button>
					<input type="text" class="qteProduct" id="qtePanier" value="1"/>
					<button class="btnDecrIncr" data-id="moins">-</button>
					<button id="addPanier">Ajouter</button>
					</div>
				</c:if>
				
				<button class="btn btn-success" id="goPanier">Voir ce fuckin' panier</button>
				
				
			</div>
		</div>
	</div>




	<div id="r">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-8 col-lg-offset-2">
					<h4>Vous �tes sur la page de consultation du catalogue.</h4>
					<p>Vous pouvez y trouver tous les produits r�f�renc�s : leur
						nom ainsi que leur prix.</p>
				</div>
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- r wrap -->


	<!-- FOOTER -->
	<div id="f">
		<div class="container">
			<div class="row centered">
				<a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
					class="fa fa-facebook"></i></a><a href="#"><i
					class="fa fa-dribbble"></i></a>

			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- Footer -->


	<!-- MODAL FOR CONTACT -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">contact us</h4>
				</div>
				<div class="modal-body">
					<div class="row centered">
						<p>N'h�sitez pas � nous contacter</p>
						<p>
							51 rue des 3 fr�res Barth�l�my<br /> 13006 Marseille<br />
							04.91.51..51.51<br /> sebastien.thomin@gmail.com
						</p>
						<div id="mapwrap">
							<iframe height="300" width="100%" frameborder="0" scrolling="no"
								marginheight="0" marginwidth="0"
								src="https://www.google.es/maps?t=m&amp;ie=UTF8&amp;ll=52.752693,22.791016&amp;spn=67.34552,156.972656&amp;z=2&amp;output=embed"></iframe>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Save
						& Go</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="styles/js/jquery.cookie.js"></script>
	<script src="styles/js/bootstrap.min.js"></script>
	<script src="styles/js/myFunctions.js"></script>
	
	






	

</body>
</html>
