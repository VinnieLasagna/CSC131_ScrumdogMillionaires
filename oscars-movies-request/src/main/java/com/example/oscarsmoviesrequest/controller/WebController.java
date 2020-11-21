package com.example.oscarsmoviesrequest.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.oscarsmoviesrequest.models.PostRequest;
import com.example.oscarsmoviesrequest.models.PostResponse;
import com.example.oscarsmoviesrequest.FillRequests;
import com.example.oscarsmoviesrequest.models.GetResponse;

@RestController
public class WebController {
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public GetResponse Get(String year_film, String year_ceremony, String ceremony, 
			@RequestParam(value = "category",defaultValue = "all") String category, String name, String film, String winner) {
		GetResponse response = new GetResponse();
		//response.setId(1);
		//response.setMessage("Your name is "+name);		
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
	
	/*@RequestMapping("/get/category")
	public GetResponse GetByCategory(@PathVariable("category") String category) {
		GetResponse response = new GetResponse();
		//response.setId(1);
		//response.setMessage("Your name is "+name);
		//System.out.print(year + " ");
		
		response.setCategory(category);
		//response.setEntity(entity);
		//response.setWinner(winner);
		//response.setYear(year);
		response.setMessage("Got: " + response.getCategory());
		//response.setMessage("Got [" + response.getYear() + ", " + response.getCategory()
		//		+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		return response;

	}*/
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public PostResponse Post(@RequestBody PostRequest inputPayload) {			//change this method to using array
		PostResponse response = new PostResponse();
		//response.setId(inputPayload.getId());
		//response.setMessage("Hello " + inputPayload.getName());
		//response.setExtra("Some text");
		response.setYearFilm(inputPayload.year_film);
		response.setYearCeremony(inputPayload.year_ceremony);
		response.setCeremony(inputPayload.ceremony);
		response.setCategory(inputPayload.category);
		response.setName(inputPayload.name);
		response.setFilm(inputPayload.film);
		response.setWinner(inputPayload.winner);
		//response.setCategory(inputPayload.getCategory());
		//response.setEntity(inputPayload.getEntity());
		//response.setWinner(inputPayload.getWinner());
		//response.setYear(inputPayload.getYear());
		//response.setMessage("Implemented [" + response.getYear() + ", " + response.getCategory()
		//+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		
		return response;
	}
}