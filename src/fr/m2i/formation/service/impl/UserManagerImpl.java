package fr.m2i.formation.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.m2i.formation.dto.Commercial;
import fr.m2i.formation.dto.Internaute;
import fr.m2i.formation.dto.User;
import fr.m2i.formation.jdbc.JDBCConnection;
import fr.m2i.formation.service.IUserManager;

public class UserManagerImpl implements IUserManager {

	Connection conn;

	@Override
	public User authenticate(String login, String pwd) {

		User user = null;
		try {
			conn = JDBCConnection.getConnection();

			String sql = "SELECT u.login, password, group_id FROM emarket_user u, user_has_group g where u.login = g.login and u.login = ? and u.password = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, login);
			statement.setString(2, pwd);

			ResultSet rs = statement.executeQuery();

			// statement = conn.createStatement();

			// executeQuery retourne un ResultSet sur l'on peut parcourir

			while (rs.next()) {

				login = rs.getString(1);
				pwd = rs.getString(2);
				String groupe = rs.getString(3);

				if ("Commercial".equals(groupe)) {

					user = new Commercial();
					user.setRole(groupe);

				}
				else if ("Internaute".equals(groupe)) {

					user = new Internaute();
					user.setRole(groupe);

				}
				
				

			}
			
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		if(user == null){
			user = new User();
			user.setRole("inconnu");
		}

		user.setLogin(login);
		user.setPwd(pwd);
		
		return user;

	}
	

}
