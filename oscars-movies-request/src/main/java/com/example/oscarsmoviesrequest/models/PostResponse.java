package com.example.oscarsmoviesrequest.models;

public class PostResponse {
	// int id;
	// String extra;
	String message;
	long year_film;
	long year_ceremony;
	long ceremony;
	String category;
	String name;
	String film;
	boolean winner;

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

	/*
	 * public String getExtra() { return extra; }
	 * 
	 * public void setExtra(String extra) { this.extra = extra; }
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 */

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}