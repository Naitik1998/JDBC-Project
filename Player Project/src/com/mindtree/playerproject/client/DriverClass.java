package com.mindtree.playerproject.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.playerproject.entity.Player;
import com.mindtree.playerproject.exception.PlayerProjectException;
import com.mindtree.playerproject.service.PlayerProjectService;
import com.mindtree.playerproject.service.serviceimplementation.PlayerProjectServiceImplementation;

public class DriverClass {

	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);

		PlayerProjectService service = new PlayerProjectServiceImplementation();

		do {
			System.out.println();
			System.out.println("1:	Add Player.");
			System.out.println("2: 	Display All Player.");
			System.out.println("3:	Sort All Players according to Matches Won of a particular clan.");
			System.out.println("4:	Search Player by username and print his matches won.");
			System.out.println("5:	Update Matches Won Of a player given his username");
			System.out.println("6:	Delete a Player given User Name.");
			System.out.println("7:	Sort Palyers ");
			System.out.println("8:	Exit");

			System.out.println("Enter the Choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				Player playerObj = new Player();
				System.out.println("Enter the player id:");
				int pid = sc.nextInt();
				System.out.println("Enter the player name:");
				sc.nextLine();
				String pName = sc.nextLine();
				System.out.println("Enter the player matches won:");
				int mWon = sc.nextInt();
				System.out.println("Enter the player clan:");
				sc.nextLine();
				String clan = sc.nextLine();

				playerObj.setId(pid);
				playerObj.setUsername(pName);
				playerObj.setMatches_won(mWon);
				playerObj.setClan(clan);

				try {
					String message = service.addPlayer(playerObj);
					System.out.println(message);
				} catch (PlayerProjectException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				List<Player> playerList = null;
				try {
					playerList = service.getAllPlayers();
					System.out.println("All Player in Db:");
					for (Player player : playerList) {
						System.out.println(player);

					}
				} catch (PlayerProjectException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				System.out.println("Enter the Clan name You want to sort:");
				sc.nextLine();
				String clanName = sc.nextLine();
				List<Player> sortedPlayerList = null;
				try {
					sortedPlayerList = service.sortingPlayers(clanName);
					System.out.println("All Players sorted according to Matches Won: ");
					for (Player player : sortedPlayerList) {
						System.out.println(player);
					}

				} catch (PlayerProjectException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
				System.out.println("Enter the player name you Want to search:");
				sc.nextLine();
				String playerString = sc.nextLine();
				try {
					int matchsWon = service.searchPlayer(playerString);
					System.out.println("Player Name: " + playerString + " Matches Won:" + matchsWon);
				} catch (PlayerProjectException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 5:
				System.out.println("Enter the player Name :");
				sc.nextLine();
				String playerName = sc.nextLine();
				System.out.println("Enter the player new matches won:");
				int matchWon = sc.nextInt();

				try {
					String message = service.updateMatchWonOFPlayer(playerName, matchWon);
					System.out.println(message);
				} catch (PlayerProjectException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 6:
				System.out.println("Enter the player Name you want delete:");
				sc.nextLine();
				String playerName1 = sc.nextLine();
				try {
					String meaaageString = service.deleteParticularPlayer(playerName1);
					System.out.println(meaaageString);
				} catch (PlayerProjectException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 7:
				System.out.println("Enter the Clan name You want to sort:");
				sc.nextLine();
				String clanName1 = sc.nextLine();
				List<Player> sortedPlayerList1 = null;
				try {
					sortedPlayerList1 = service.sortingPlayersBasedOnMatch(clanName1);
					System.out.println("All Players sorted according to Matches Won: ");
					for (Player player : sortedPlayerList1) {
						System.out.println(player);
					}

				} catch (PlayerProjectException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 8:
				System.out.println("Thank You !!!");
				flag = false;
				break;

			default:
				System.out.println("Invalid Choice !!!");
				break;
			}
			
		} while (flag);
		sc.close();
	}

}
