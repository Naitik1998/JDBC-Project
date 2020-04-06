package com.mindtree.playerproject.service.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.playerproject.dao.PlayerProjectDao;
import com.mindtree.playerproject.dao.daoImplementation.PlayerProjectDaoImplemantation;
import com.mindtree.playerproject.entity.Player;
import com.mindtree.playerproject.exception.dao.PlayerProjectDaoException;
import com.mindtree.playerproject.exception.service.PlayerProjectServiceException;
import com.mindtree.playerproject.exception.service.servicecustom.SearchedPlayerNameIsNotFoundException;
import com.mindtree.playerproject.service.PlayerProjectService;

public class PlayerProjectServiceImplementation implements PlayerProjectService {

	List<Player> playerListService = new ArrayList<Player>();

	PlayerProjectDao playerDaoObj = new PlayerProjectDaoImplemantation();

	/* Adding Player into DB */
	@Override
	public String addPlayer(Player playerObj) throws PlayerProjectServiceException {

		String messgae = null;
		try {
			messgae = playerDaoObj.insertPlayer(playerObj);
		} catch (PlayerProjectDaoException e) {
			throw new PlayerProjectServiceException(e.getMessage(), e);
		}

		return messgae;

	}

	/* Retrieving Players Details form DB into list */
	public List<Player> getAllPlayers() throws PlayerProjectServiceException {

		try {
			playerListService = playerDaoObj.getAllPlayersFromDao();
		} catch (PlayerProjectDaoException e) {
			throw new PlayerProjectServiceException(e.getMessage(), e);
		}

		return playerListService;
	}

	/* Sorting a particular clan using Insertion Sort */

	public List<Player> sortingPlayers(String clanName) throws PlayerProjectServiceException {
		List<Player> currentPlayerList = new ArrayList<Player>();

		try {
			currentPlayerList = playerDaoObj.getAParticularClanDetail(clanName);
		} catch (PlayerProjectDaoException e) {
			throw new PlayerProjectServiceException(e.getMessage(), e);
		}

		for (int i = 1; i < currentPlayerList.size(); i++) {
			int key = currentPlayerList.get(i).getMatches_won();
			int j = i - 1;

			while (j >= 0 && currentPlayerList.get(j).getMatches_won() > key) {
				currentPlayerList.set(j + 1, currentPlayerList.get(j));
				j = j - 1;
			
			}
			currentPlayerList.set(j + 1, currentPlayerList.get(i));

		}

		return currentPlayerList;

	}

	/* update Match Won OF Player */
	@Override
	public String updateMatchWonOFPlayer(String playerName, int matchWon) throws PlayerProjectServiceException {

		String message = null;
		try {
			message = playerDaoObj.updatePlayer(playerName, matchWon);
		} catch (PlayerProjectDaoException e) {
			throw new PlayerProjectServiceException(e.getMessage(), e);
		}
		return message;
	}

	/* search Player and return match won */
	@Override
	public int searchPlayer(String playerString) throws PlayerProjectServiceException {
		List<Player> currentPlayerList1 = new ArrayList<Player>();

		try {
			currentPlayerList1 = playerDaoObj.getAllPlayersFromDao();
		} catch (PlayerProjectDaoException e) {
			throw new PlayerProjectServiceException(e.getMessage(), e);
		}

		/* Insertion Sort */
		for (int i = 1; i < currentPlayerList1.size(); i++) {
			int key = currentPlayerList1.get(i).getMatches_won();
			int j = i - 1;

			while (j >= 0 && currentPlayerList1.get(j).getMatches_won() > key) {
				currentPlayerList1.set(j + 1, currentPlayerList1.get(j));
				j--;
			}
			currentPlayerList1.set(j + 1, currentPlayerList1.get(i));

		}

		/* Binary Search */

		int l = 0;
		int r = currentPlayerList1.size();
		int result = 0;
		int mid=0;
		while (r >= 1) {
			mid = (l + r) / 2;

			if (currentPlayerList1.get(mid).getUsername().compareToIgnoreCase(playerString) < 0) {
				l = mid + 1;
			} else if (currentPlayerList1.get(mid).getUsername().compareToIgnoreCase(playerString) > 0) {
				r = mid - 1;
			} else {
				result = mid;
			}
		}

		if (result < 0) {
			throw new SearchedPlayerNameIsNotFoundException("Searched Player Name Is Not Found");
		}

		return currentPlayerList1.get(mid).getMatches_won();

	}

	/*Delete a player*/
	@Override
	public String deleteParticularPlayer(String playerName1) throws PlayerProjectServiceException {
		String mString=null;
		try {
			mString=playerDaoObj.deletePlayerfromDB(playerName1);
		} catch (PlayerProjectDaoException e) {
			throw new PlayerProjectServiceException(e.getMessage(),e);
		}
		
		return mString;
	}

	/*Sorting players Based on match*/
	@Override
	public List<Player> sortingPlayersBasedOnMatch(String clanName1) throws PlayerProjectServiceException {
		List<Player> currentPlayerList2 = new ArrayList<Player>();

		try {
			currentPlayerList2 = playerDaoObj.sortingPlayersUsingOrderBy(clanName1);
		} catch (PlayerProjectDaoException e) {
			throw new PlayerProjectServiceException(e.getMessage(),e);
		}
		return currentPlayerList2;
	}

}
