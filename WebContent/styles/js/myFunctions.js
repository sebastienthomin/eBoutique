jQuery(function($){
		
		$.cookie.json=true;	
		
		if($(".nameProduct")){
			$(".nameProduct").click(function(){
				$("#inputId").val($(this).attr("data-id"));
				$("#formId").submit();
			});
			}
		
		
		//Affichage panier
		if($("#listeProducts")){
		var panier = $.cookie("panier");
		
		var total = 0;
		var numLigne = 0;
		
		
		
		for(idProduct in panier){						//idProduct correpond à l'indice du tableau qu'il parcourt
			var subtotal = 0;
			var nom = panier[idProduct].nom;
			var prix = panier[idProduct].prix;
			var qte = panier[idProduct].quantity;
			
			subtotal = prix * qte;
			$("#template").find(".modele").clone().appendTo("#listProducts");		//??
			
			var ligne = $("#listProducts").find(".modele").eq(numLigne);
			ligne.find(".libelle").text("Nom du produit : " + nom);
			ligne.find(".qteProduct").val(qte);
			ligne.find(".prixProduct").text("Prix : " + subtotal);
			ligne.find(".idProduct").attr("data-id", idProduct);
			
			numLigne++;
			total += subtotal;
		}
		
		}
		
		
	$(".btnDecrIncr").click(function(){
		var operation = 1;
		
		var qte = $(this).parents(".modele").find(".qteProduct");
		
		var valeur = parseInt(qte.val());
		if($(this).attr("data-id") == "moins"){
			operation = (valeur - 1 < 1)? 0 : -1;
		}
		valeur += operation;
		qte.val(valeur);
	})
	
	
	


	//<!-- Gestion ajout panier -->
	
	$("#addPanier").click(function(){
		//var id = $("#id").attr("id");
		
		
		var id = $("#id").data("id");
		var panier = $.cookie("panier") || {};			//ajoute le cookie au panier s'il existe, sinon création tableau vide
		var valeur = parseInt($("#qtePanier").val());	//#qtePanier => id de l'input
		
		if(panier[id]){
			valeur = panier[id].quantity + valeur;
		}
		
			var product={
					nom : $("#name").text(),
					prix : parseFloat($("#sellingPrice").data("sellingprice")),
					quantity : valeur,
					id : id
			}
			panier[id] = product;
			
			$.cookie("panier", panier);
			console.log(panier);
		
		
		})
	

	//<!-- "e" ? Argument ? -->

	$("#qtePanier").keypress(function(e){			
		return e.which > 47 && e.which < 58;		//e.which retourne le code ASCII, e correspond à l'événement (plein de propriétés)
	})												//47 et 58 (en réalité 48 et 57 car < et >) correpondent au code ASCII des nombre. Si true, écrit le nombre, sinon n'écrit rien
	
	
	//Redirection vers panier.jsp
	$("#goPanier").click(function(){
		location.href = "panier.jsp";
	})
	
	//Suppression d'un produit du panier
	$(".idProduct").click(function(){
		var panier = $.cookie("panier");
		var id = $(this).attr("data-id");
		var subtotal = panier[id].prix * panier[id].qte;
		
		var total = parseFloat($("#total").attr("data-total"));
		
		total = total - subtotal;
		
		delete panier[id];
		$.cookie("panier", panier);
		
		$(this).parents(".modele").remove();
		
		$("#total").attr("data-total", total).text(total + " euros");
	})
	
	$.post("url", data, function(response){				//data => {"panier" : JSON.stringify(panier)} 
		if(response == "OK"){
			
		}
		else{
			
		}
	})
	
	
	
	
	});