package fr.m2i.formation.dto;

import java.util.HashSet;
import java.util.Set;

public class Component {

	private int id;
	private String name;
	private String supplier;
	private Set<Product> products = new HashSet<Product>();

	public Component(int id, String name, String supplier, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.products = products;
	}

	public Component() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
