package com.example.oscarsmoviesrequest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.oscarsmoviesrequest.models.PostRequest;
import com.example.oscarsmoviesrequest.models.PostResponse;
import com.example.oscarsmoviesrequest.models.GetResponse;

@RestController
public class WebController {
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)			//reads input and returns result as JSON object
	public GetResponse Get(String year_film, String year_ceremony, String ceremony, 
			@RequestParam(value = "category",defaultValue = "all") String category, String name, String film, String winner) {
		GetResponse response = new GetResponse();	
		
		response.setYearFilm(year_film);
		response.setYearCeremony(year_ceremony);
		response.setCeremony(ceremony);
		response.setCategory(category);
		response.setName(name);
		response.setFilm(film);
		response.setWinner(winner);
		response.setMessage("Got [" + response.getYearFilm() + ", " + response.getYearCeremony() + ", " + response.getCeremony()
				+ ", " + response.getCategory() + ", " + response.getName() + ", " + response.getFilm() + ", " + response.getWinner() + "]");
		return response;
	}
	
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public PostResponse Post(@RequestBody PostRequest inputPayload) {			//reads input and fills JSON object with entries
		PostResponse response = new PostResponse();
		
		response.setYearFilm(inputPayload.getYearFilm());
		response.setYearCeremony(inputPayload.getYearCeremony());
		response.setCeremony(inputPayload.getCeremony());
		response.setCategory(inputPayload.getCategory());
		response.setName(inputPayload.getName());
		response.setFilm(inputPayload.getFilm());
		response.setWinner(inputPayload.getWinner());
		
		return response;
	}
}