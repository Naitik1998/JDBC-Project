package com.mindtree.playerproject.service;

import java.util.List;

import com.mindtree.playerproject.entity.Player;
import com.mindtree.playerproject.exception.service.PlayerProjectServiceException;

public interface PlayerProjectService {

	public String addPlayer(Player playerObj) throws PlayerProjectServiceException;

	public List<Player> getAllPlayers() throws PlayerProjectServiceException ;

	public List<Player> sortingPlayers(String clanName) throws PlayerProjectServiceException;

	public String updateMatchWonOFPlayer(String playerName, int matchWon) throws PlayerProjectServiceException;

	public int searchPlayer(String playerString) throws PlayerProjectServiceException;

	public String deleteParticularPlayer(String playerName1) throws PlayerProjectServiceException;

	public List<Player> sortingPlayersBasedOnMatch(String clanName1) throws PlayerProjectServiceException;    
}
