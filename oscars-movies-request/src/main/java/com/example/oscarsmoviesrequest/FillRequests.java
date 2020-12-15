package com.example.oscarsmoviesrequest;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.oscarsmoviesrequest.controller.WebController;
import com.example.oscarsmoviesrequest.models.GetResponse;

@Service
public class FillRequests {
	private final WebController webController = new WebController();

	public ArrayList<String[]> postEntityInfo(ArrayList<String[]> requests) {
		ArrayList<String[]> results = new ArrayList<String[]>();

			/* if returning GetResponse
		for (int i = 0; i < requests.size(); i++) {
			String[] request = requests.get(i);
			String[] fillArray = new String[request.length];

			GetResponse json = webController.Get(request[0], request[1], request[2], request[3], request[4], request[5],
					request[6]);
			fillArray[0] = json.getYearFilm();
			fillArray[1] = json.getYearCeremony();
			fillArray[2] = json.getCeremony();
			fillArray[3] = json.getCategory();
			fillArray[4] = json.getName();
			fillArray[5] = json.getFilm();
			fillArray[6] = json.getWinner();

			results.add(fillArray);
		}*/
		// returning ArrayList<String[]>
		//results = webController.Get(request[0], request[1], request[2], request[3], request[4], request[5],
		//		request[6]);
		return results;
	}

	public ArrayList<String[]> getEntityInfo(ArrayList<String[]> requests) { // calls GET request and returns
		ArrayList<String[]> results = new ArrayList<String[]>();
			//requests now contains list of Movies
		for (int i = 0; i < requests.size(); i++) {
			String[] request = requests.get(i);
			String[] fillArray = new String[request.length];

			// calls Get method from WebController and returns JSON results
			/*
			GetResponse json = webController.Get(request[0], request[1], request[2], request[3], request[4], request[5],
					request[6]);
			fillArray[0] = json.getYearFilm();
			fillArray[1] = json.getYearCeremony();
			fillArray[2] = json.getCeremony();
			fillArray[3] = json.getCategory();
			fillArray[4] = json.getName();
			fillArray[5] = json.getFilm();
			fillArray[6] = json.getWinner();
			*/
			results.add(fillArray); // adds movie entries to array list
		}
		return results;
	}

	public static void main(String[] args) {
		// FillRequests fill = new FillRequests();
		// Test String[] objects for testing ArrayList<String[]>
		String[] fields = { "1927", "ACTOR", "True", "Emil Jannings" };
		String[] fields2 = { "1927", "ACTOR", "False", "Richard Barthelmess" };
		ArrayList<String[]> list = new ArrayList<String[]>();
		list.add(fields);
		list.add(fields2);

		for (String temp[] : list) {
			System.out.println(Arrays.toString(temp));
		}
	}
}