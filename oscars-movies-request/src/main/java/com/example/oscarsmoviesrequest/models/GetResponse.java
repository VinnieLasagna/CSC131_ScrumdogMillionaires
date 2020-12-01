package com.example.oscarsmoviesrequest.models;

public class GetResponse {
	// private long id;
	private String message;
	String year_film;
	String year_ceremony;
	String ceremony;
	String category;
	String name;
	String film;
	String winner;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getYearFilm() {
		return year_film;
	}

	public void setYearFilm(String year_film) {
		this.year_film = year_film;
	}

	public String getYearCeremony() {
		return year_ceremony;
	}

	public void setYearCeremony(String year_ceremony) {
		this.year_ceremony = year_ceremony;
	}

	public String getCeremony() {
		return ceremony;
	}

	public void setCeremony(String ceremony) {
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

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	/*
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 */

}