package com.example.oscarsmoviesrequest.models;

public class PostResponse {
	//int id;
	String message;
	//String extra;
	String category;
	String entity;
	boolean winner;
	long year;
	
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
	
	/*public String getExtra() {
		return extra;
	}
	
	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	public int getId() {
		return id;
	}
		
	public void setId(int id) {
		this.id = id;
	}*/
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}