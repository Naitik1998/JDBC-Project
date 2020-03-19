package com.mindtree.shopproject.dao.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import com.mindtree.shopproject.dao.ShopDao;
import com.mindtree.shopproject.entity.Shop;
import com.mindtree.shopproject.exception.dao.DaoException;
import com.mindtree.shopproject.utility.JdbcConnection;

public class ShopDaoImp implements ShopDao {

	public String insertShopDetail(Shop shopObj) throws DaoException {
		Connection connection = JdbcConnection.getConnection();

		String sql = "insert into shop values (?,?,?)";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, shopObj.getShopId());
			statement.setString(2, shopObj.getShopName());
			statement.setInt(3, shopObj.getTotalProduct());

			int a = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcConnection.closeConnection(connection);

		}
		return "New shop is Added";
	}

}
