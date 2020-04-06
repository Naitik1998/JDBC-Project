package com.mindtree.playerproject.entity;

public class Player implements Comparable<Player> {

	private int id;
	private String username;
	private int matches_won;
	private String clan;

	public Player() {

	}

	public Player(int id, String username, int matches_won, String clan) {
		this.id = id;
		this.username = username;
		this.matches_won = matches_won;
		this.clan = clan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMatches_won() {
		return matches_won;
	}

	public void setMatches_won(int matches_won) {
		this.matches_won = matches_won;
	}

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clan == null) ? 0 : clan.hashCode());
		result = prime * result + id;
		result = prime * result + matches_won;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (clan == null) {
			if (other.clan != null)
				return false;
		} else if (!clan.equals(other.clan))
			return false;
		if (id != other.id)
			return false;
		if (matches_won != other.matches_won)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "player [id=" + id + ", username=" + username + ", matches_won=" + matches_won + ", clan=" + clan + "]";
	}

	@Override
	public int compareTo(Player player) {
		
		return this.matches_won-player.matches_won ;
	}

}
