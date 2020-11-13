package com.example.oscarsmoviesrequest.models;
public class GetResponse {
	private String message;
	private String category;
	private String entity;
	private boolean winner;
	private long year;
	//private long id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public boolean getWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	public long getYear() {
		return year;
	}
	
	public void setYear(long year) {
		this.year = year;
	}
	
	/*public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

}