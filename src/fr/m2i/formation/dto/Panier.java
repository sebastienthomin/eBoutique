package fr.m2i.formation.dto;

public class Panier {

	private int id, productId, quantite;
	private String login;

	public Panier(int id, int productId, int quantite, String login) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantite = quantite;
		this.login = login;
	}

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
