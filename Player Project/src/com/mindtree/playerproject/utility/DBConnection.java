package com.mindtree.playerproject.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.playerproject.exception.dao.PlayerProjectDaoException;

public class DBConnection {

	private static final String DBURL = "jdbc:mysql://localhost:3306/player";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Welcome123";

	public static Connection getConnection() throws  PlayerProjectDaoException {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			throw new PlayerProjectDaoException(e.getMessage(), e);

		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error in Connection", e);
		}

		return connection;

	}

	public static Connection closeConnection(Connection connection) throws PlayerProjectDaoException {

		try {
			connection.close();
		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error in Connection", e);
		}

		return connection;

	}
}
