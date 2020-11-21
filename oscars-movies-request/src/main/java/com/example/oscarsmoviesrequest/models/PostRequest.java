package com.example.oscarsmoviesrequest.models;

public class PostRequest {
	//int id;
	//String name;
	public long year_film;
	public long year_ceremony;
	public long ceremony;	
	public String category;
	public String name;
	public String film;
	public boolean winner;
	
	public long getYearFilm() {
		return year_film;
	}
	
	public void setYearFilm(long year_film) {
		this.year_film = year_film;
	}
	
	public long getYearCeremony() {
		return year_ceremony;
	}
	
	public void setYearCeremony(long year_ceremony) {
		this.year_ceremony = year_ceremony;
	}
	
	public long getCeremony() {
		return ceremony;
	}
	
	public void setCeremony(long ceremony) {
		this.ceremony = ceremony;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}
	
	public boolean getWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	/*public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}*/

}