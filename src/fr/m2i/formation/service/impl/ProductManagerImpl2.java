package fr.m2i.formation.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;
import fr.m2i.formation.jdbc.JDBCConnection;
import fr.m2i.formation.service.IProductManager;

public class ProductManagerImpl2 implements IProductManager {								//Avec connexion BDD datasource

	// JDBCConnection jdbc = new JDBCConnection();
	private DataSource ds;											

	Connection conn;

	public void createProduct(Catalogue cat, String name, double price) {

		int id = 0;

		String sql = "INSERT INTO Product(name, selling_price) VALUES(?,?)";
		PreparedStatement statement;

		try {
			
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:com/env/jdbc/projet_eboutique");
			Connection conn = ds.getConnection();
		
			
			
		
//			conn = JDBCConnection.getConnection();
		
		
			ResultSet rs;

			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, name);
			statement.setDouble(2, price);

			int nbLignes = statement.executeUpdate(); // executeUpdate retourne
														// un int, le nombre de
														// lignes modifiées

			if (nbLignes != 0) {
				rs = statement.getGeneratedKeys();
				while (rs.next()) {
					id = rs.getInt(1);
				}
			}

			Product prod = new Product();
			prod.setId(id);
			prod.setName(name);
			prod.setSellingPrice(price);

			// List<Product> list = cat.getListProduct();
			// list.add(prod);
			// cat.setListProduct(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e)
		{
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
			//statement = conn.createStatement();

			rs = statement.executeQuery();

			while (rs.next()) {
				
				Product product = new Product();
				
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setSellingPrice(rs.getDouble(3));

				products.add(product);
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
		// TODO Auto-generated method stub				//TODO
		return null;
	}

}
