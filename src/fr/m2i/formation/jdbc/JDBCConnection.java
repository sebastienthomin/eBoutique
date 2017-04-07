package fr.m2i.formation.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_eboutique", "root",
				"Pa$$w0rd");
		return connection;
	}

	/*public static void main(String[] argv) {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_eboutique", "root",
					"Pa$$w0rd");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");

			PreparedStatement prep1;
			try {
				prep1 = connection.prepareStatement("select * from product");
				ResultSet rs = prep1.executeQuery();

				Product product = new Product();

				while (rs.next()) {

					int idProduct = rs.getInt("id");
					System.out.println("id product : " + idProduct);
					product.setId(idProduct);

					String name = rs.getString("name");
					System.out.println("name product : " + name);
					product.setName(name);

					Double price = rs.getDouble("selling_price");
					System.out.println("product selling price : " + price);
					product.setSellingPrice(price);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Failed to make connection!");
		}
	}*/
}