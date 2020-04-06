package com.mindtree.playerproject.dao.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.playerproject.dao.PlayerProjectDao;
import com.mindtree.playerproject.entity.Player;
import com.mindtree.playerproject.exception.dao.PlayerProjectDaoException;
import com.mindtree.playerproject.utility.DBConnection;

public class PlayerProjectDaoImplemantation implements PlayerProjectDao {

	@Override
	public String insertPlayer(Player playerObj) throws PlayerProjectDaoException {

		Connection connection = DBConnection.getConnection();

		String sql = "Insert into playertable values (?,?,?,?)";
		int a = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, playerObj.getId());
			stmt.setString(2, playerObj.getUsername());
			stmt.setInt(3, playerObj.getMatches_won());
			stmt.setString(4, playerObj.getClan());

			a = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error while inserting", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (a == 1)
			return "New Player Added Sucessfully";
		else
			return "Query is not excuted";

	}

	public List<Player> getAllPlayersFromDao() throws PlayerProjectDaoException {

		List<Player> playerListDao = new ArrayList<Player>();

		Connection connection = DBConnection.getConnection();

		String sql = "select * from playertable";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Player playerobj = new Player();

				playerobj.setId(resultSet.getInt(1));
				playerobj.setUsername(resultSet.getString(2));
				playerobj.setMatches_won(resultSet.getInt(3));
				playerobj.setClan(resultSet.getString(4));

				playerListDao.add(playerobj);
			}
		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error while Retrieving Player Data.", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		return playerListDao;
	}

	@Override
	public String updatePlayer(String playerName, int matchWon) throws PlayerProjectDaoException {

		Connection connection = DBConnection.getConnection();

		String sql = "update playertable set matches_won=? where username=? ";
		int a = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, matchWon);
			stmt.setString(2, playerName);
			a = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error While Upadating", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (a == 1)
			return "Player Updated with new Match won Sucessfully";
		else
			return "Query is not excuted";
	}

	@Override
	public List<Player> getAParticularClanDetail(String clanName) throws PlayerProjectDaoException {
		List<Player> playerListDao1 = new ArrayList<Player>();

		Connection connection = DBConnection.getConnection();

		String sql = "select * from playertable where clan=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, clanName);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Player playerobj = new Player();

				playerobj.setId(resultSet.getInt(1));
				playerobj.setUsername(resultSet.getString(2));
				playerobj.setMatches_won(resultSet.getInt(3));
				playerobj.setClan(resultSet.getString(4));

				playerListDao1.add(playerobj);
			}
		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error while Retrieving Players with clan Data.", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (playerListDao1.isEmpty()) {
			throw new PlayerProjectDaoException("Clan not found");
		}

		return playerListDao1;

	}

	@Override
	public String deletePlayerfromDB(String playerName1) throws PlayerProjectDaoException {
		Connection connection = DBConnection.getConnection();

		String sql = "Delete from playertable where username=?";
		int a = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, playerName1);

			a = stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error Occur while deleting", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (a == 1)
			return "Player Deleted Sucessfully";
		else
			return "Query is not excuted";

	}

	@Override
	public List<Player> sortingPlayersUsingOrderBy(String clanName1) throws PlayerProjectDaoException {

		List<Player> playerListDao1 = new ArrayList<Player>();

		Connection connection = DBConnection.getConnection();

		String sql = "select * from playertable where clan=? order by matches_won ASC ";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, clanName1);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Player playerobj = new Player();

				playerobj.setId(resultSet.getInt(1));
				playerobj.setUsername(resultSet.getString(2));
				playerobj.setMatches_won(resultSet.getInt(3));
				playerobj.setClan(resultSet.getString(4));

				playerListDao1.add(playerobj);
			}
		} catch (SQLException e) {
			throw new PlayerProjectDaoException("Error while Retrieving Players with clan Data.", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (playerListDao1.isEmpty()) {
			throw new PlayerProjectDaoException("Clan not found");
		}

		return playerListDao1;
		 
	}

}
