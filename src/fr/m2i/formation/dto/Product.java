package fr.m2i.formation.dto;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.api.Component;

public class Product {

	private int id;
	private String name;
	private Double sellingPrice;
	private List<Component> components = new ArrayList<Component>();

	public Product(int id, String name, Double sellingPrice, List<Component> components) {
		super();
		this.id = id;
		this.name = name;
		this.sellingPrice = sellingPrice;
		this.components = components;
	}

	public Product() {
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

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

}
