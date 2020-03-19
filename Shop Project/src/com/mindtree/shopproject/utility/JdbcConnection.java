package com.mindtree.shopproject.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.shopproject.exception.dao.ConnectionException;
import com.mindtree.shopproject.exception.dao.DaoException;

public class JdbcConnection {
	private static final String DBURL = "jdbc:mysql://localhost:3306/shopdb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Welcome123";

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;

	}

	public static Connection closeConnection(Connection connection) throws DaoException {

		try {

			connection.close();

		} catch (SQLException e) {
			throw new ConnectionException("Error In Connection");
		}

		return connection;

	}

}
