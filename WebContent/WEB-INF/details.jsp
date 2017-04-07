<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="styles/ico/favicon.png">

    <title>Accueil</title>

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
	
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">SP<i class="fa fa-circle"></i>T</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<li class="active" style="visibility:hidden"><a href="details.jsp">Fiche produit</a></li>
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="commercial.jsp">Mon compte Commercial</a></li>
            <li><a href="deconnexion.jsp">Deconnexion</a></li>
            <li><a data-toggle="modal" data-target="#myModal" href="#myModal"><i class="fa fa-envelope-o"></i></a></li>
          </ul>
        </div>
      </div>
    </div>

	<div id="blue">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-8 col-lg-offset-2">
				<h4>Fiche du produit</h4>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container desc">
		<div class="row">
			<br><br>
			<div class="col-lg-4 centered">	<img width="160" height="200" src="assets/img/ordi1.png"/> </div>
			<div class="col-lg-5">
				<c:if test ="${!empty produit}">
					<h1> ${produit.name} </h1>
					<h2>prix: <c:out value ="${produit.sellingPrice}" /></h2>
				</c:if>					
			</div>
		</div>	
		
		
		<br><br>
		
		<div id="r">
			<div class="container">
				<div class="row centered">
					<div class="col-lg-8 col-lg-offset-2">
						<h4>L'eBoutique magique</h4>
						<p>Commandez ce qu'il vous plait</p>
					</div>
				</div><!-- row -->
			</div><!-- container -->
		</div>
	
	</div>
	

<div id="f">
		<div class="container">
			<div class="row centered">
				<a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-dribbble"></i></a>
		
			</div><!-- row -->
		</div><!-- container -->
	</div><!-- Footer -->
	    
  </body>
</html>