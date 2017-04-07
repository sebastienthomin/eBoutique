package fr.m2i.formation.dto;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

	private List<Product> listProduct = new ArrayList<Product>();

	public Catalogue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catalogue(List<Product> listProduct) {
		super();
		this.listProduct = listProduct;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
