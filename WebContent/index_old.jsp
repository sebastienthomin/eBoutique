<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue sur le site eBoutique !</title>

	<h1>Accueil du site</h1>
	<p>Bienvenue sur l'application de commande en ligne eBoutique</p>
	
<%-- 	<c:url value ="WEB-INF/views/Catalogue.jsp" /> --%>
<%-- 	<c:url value ="WEB-INF/views/Panier.jsp">Panier</c:url> --%>
<%-- 	<c:url value ="WEB-INF/views/createProduct.jsp">Panier</c:url> --%>
	
	<a href="createProduct.jsp"/>"TEST</a>
	<a href="catalogue.jsp"/>"TEST</a>
	<a href="panier.jsp"/>"TEST</a>
	
	
	<p>Bienvenue sur l'appication de commande en ligne Eboutique<br/>
pour creer des produits rendez vous ici :<br/></p>

<a href="<c:url value="/createProduct" />">Creer un Produit</a> 					<!-- On utilise l'url pattern du fichier web.xml -->

<p> pour acceder au catalogue : <br/></p>

<a href="<c:url value="/viewCatalog" />" method = "get">Catalogue des produits</a> 	


<p> Pour se connecter : <br/></p>
<a href="<c:url value="/authenticate" />">Authentification</a> 	
	
	
	
</head>
<body>

</body>
</html>