package com.mindtree.playerproject.dao;

import java.util.List;

import com.mindtree.playerproject.entity.Player;
import com.mindtree.playerproject.exception.dao.PlayerProjectDaoException;

public interface PlayerProjectDao {

	public String insertPlayer(Player playerObj) throws PlayerProjectDaoException;

	public List<Player> getAllPlayersFromDao() throws PlayerProjectDaoException;

	public String updatePlayer(String playerName, int matchWon) throws PlayerProjectDaoException;

	public List<Player> getAParticularClanDetail(String clanName) throws PlayerProjectDaoException;

	public String deletePlayerfromDB(String playerName1) throws PlayerProjectDaoException;

	public List<Player> sortingPlayersUsingOrderBy(String clanName1) throws PlayerProjectDaoException; 
 
	
}
