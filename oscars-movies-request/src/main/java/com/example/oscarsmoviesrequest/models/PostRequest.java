package com.example.oscarsmoviesrequest.models;

public class PostRequest {
	//int id;
	//String name;
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