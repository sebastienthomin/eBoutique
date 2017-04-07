package fr.m2i.formation.service;

import java.util.List;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;

public interface IProductManager {
	
	//Cr�ation du produit
	//Ajout du produit en catalogue
	public void createProduct(Catalogue cat, String name, double price);
	
	
	//Suppression du produit : 
	//- du Catalogue
	//- de la BDD
	public void deleteProduct();
	
	
	//R�cup�re le produit de la BDD
	//Modifie son prix
	//L'ins�re en base
	public Product updateProduct(int id, double price);
	
	
	public List<Product> getProducts();
	
	public Product getProduct(int id);

}
