package com.example.oscarsmoviesrequest;

import java.io.Console;

public class AutomatePost {
	public static void main(String[] args) {
		double version = 0.1;
		String url = "https://automatepost.com/api.php";
		String[] fields = {
			"username: bob;",
			"password: 123;",
			"email: bob@example.com;",
			"purchase: plan1;"
		};
		
		ConnectionFactory connection = new ConnectionFactory(fields, url, version);
		//System.out.println(connection.getEndpoints());
		connection.setUserAgent("Mozilla/4.0");
		String response = connection.buildConnection();
	}
}