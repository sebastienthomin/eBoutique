package fr.m2i.formation.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;
import fr.m2i.formation.jdbc.JDBCConnection;
import fr.m2i.formation.service.IProductManager;

public class ProductManagerImpl implements IProductManager {

	// JDBCConnection jdbc = new JDBCConnection();

	Connection conn;

	public void createProduct(Catalogue cat, String name, double price) {

		int id = 0;

		String sql = "INSERT INTO Product(name, selling_price) VALUES(?,?)";
		PreparedStatement statement;

		try {
			conn = JDBCConnection.getConnection();

			ResultSet rs;

			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Retourner
																						// clés
																						// générées
																						// ?
																						// du
																						// coup,
																						// l'id
																						// ?
			statement.setString(1, name); // Met le name de la BDD à la valeur
											// de la variable name
			statement.setDouble(2, price); // Met le selling_price de la BDD à
											// la valeur de la variable price

			int nbLignes = statement.executeUpdate(); // executeUpdate éxécute
														// la requête et
														// retourne
														// un int, le nombre de
														// lignes modifiées

			if (nbLignes != 0) {
				rs = statement.getGeneratedKeys();
				while (rs.next()) { // On est obligé de parcourir le ResultSet
					id = rs.getInt(1);
				}
			}

			Product prod = new Product(); // Création nouvel objet Product et
											// allocation des variables
			prod.setId(id);
			prod.setName(name);
			prod.setSellingPrice(price);

			// List<Product> list = cat.getListProduct();
			// list.add(prod);
			// cat.setListProduct(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProduct() {

	}

	@Override
	public Product updateProduct(int id, double price) {

		return null;
	}

	@Override
	public List<Product> getProducts() {

		List<Product> products = new ArrayList<Product>();

		// int id = 0;
		// String name;
		// Double price;

		String sql = "SELECT * FROM product";
		PreparedStatement statement;

		try {
			conn = JDBCConnection.getConnection();

			ResultSet rs;

			statement = conn.prepareStatement(sql);
			// statement = conn.createStatement();

			rs = statement.executeQuery(); // executeQuery retourne un ResultSet
											// sur l'on peut parcourir

			while (rs.next()) {

				Product product = new Product();

				product.setId(rs.getInt(1)); // Récupère l'id (car l'id est la
												// première colonne)
				product.setName(rs.getString(2)); // *********le
													// nom******************deuxième*********
				product.setSellingPrice(rs.getDouble(3)); // *********le
															// prix*****************troisième********

				products.add(product); // Ajoute le Product product avec les
										// valeurs "settées" ci-dessus
			}

			// Product prod = new Product();
			// prod.setId(id);
			// prod.setName(name);
			// prod.setSellingPrice(price);

			// List<Product> list = cat.getListProduct();
			// list.add(prod);
			// cat.setListProduct(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub

		Product product = new Product();

		String sql = "SELECT * from product where id = ?";

		PreparedStatement statement;

		try {
			Connection conn = JDBCConnection.getConnection();

			ResultSet rs;

			statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			rs = statement.executeQuery();

			while (rs.next()) {

				product.setId(rs.getInt(1)); // Récupère l'id (car l'id est la
												// première colonne)
				product.setName(rs.getString(2)); // *********le
													// nom******************deuxième*********
				product.setSellingPrice(rs.getDouble(3));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

}
