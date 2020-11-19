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
import com.example.oscarsmoviesrequest.FillList;
import com.example.oscarsmoviesrequest.models.GetResponse;

@RestController
public class WebController {

	@Autowired
	private FillList fillList;
	
	//change Get method parameters to the category filtered
	//original copy of Get method
	/*@RequestMapping("/get")
	public GetResponse Get(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		GetResponse response = new GetResponse();
		//response.setId(1);
		//response.setMessage("Your name is "+name);
		response.setMessage("[" + response.getYear() + ", " + response.getCategory()
				+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		return response;

	}*/
	
	//Test copy of Get method
	@GetMapping("/user")
	public GetResponse Get(@RequestParam(value = "year") long year, String category, boolean winner, String entity) {
		GetResponse response = new GetResponse();
		//response.setId(1);
		//response.setMessage("Your name is "+name);
		System.out.print(year + " ");
		System.out.print(category + " ");
		System.out.print(winner + " ");
		System.out.println(entity + " ");
		System.out.println("Got here");
		
		response.setCategory(category);
		response.setEntity(entity);
		response.setWinner(winner);
		response.setYear(year);
		response.setMessage("Got [" + response.getYear() + ", " + response.getCategory()
				+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		return response;

	}
	
	@RequestMapping("/user/category")
	public GetResponse GetByCategory(@PathVariable("category") String category) {
		GetResponse response = new GetResponse();
		//response.setId(1);
		//response.setMessage("Your name is "+name);
		//System.out.print(year + " ");
		System.out.print(category + " ");
		//System.out.print(winner + " ");
		//System.out.println(entity + " ");
		System.out.println("Got here");
		
		response.setCategory(category);
		//response.setEntity(entity);
		//response.setWinner(winner);
		//response.setYear(year);
		response.setMessage("Got: " + response.getCategory());
		//response.setMessage("Got [" + response.getYear() + ", " + response.getCategory()
		//		+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		return response;

	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public PostResponse Post(@RequestBody PostRequest inputPayload) {			//change this method to using array
		PostResponse response = new PostResponse();
		//response.setId(inputPayload.getId());
		//response.setMessage("Hello " + inputPayload.getName());
		//response.setExtra("Some text");
		response.setCategory(inputPayload.getCategory());
		response.setEntity(inputPayload.getEntity());
		response.setWinner(inputPayload.getWinner());
		response.setYear(inputPayload.getYear());
		response.setMessage("Implemented [" + response.getYear() + ", " + response.getCategory()
		+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		
		return response;
	}
	
	/*@RequestMapping(value = "/post", method = RequestMethod.POST)
	public PostResponse PostCheck(@RequestBody PostRequest inputPayload) {			//change this method to using array
		PostResponse response = new PostResponse();
		//response.setId(inputPayload.getId());
		//response.setMessage("Hello " + inputPayload.getName());
		//response.setExtra("Some text");
		response.setCategory(inputPayload.getCategory());
		response.setEntity(inputPayload.getEntity());
		response.setWinner(inputPayload.getWinner());
		response.setYear(inputPayload.getYear());
		response.setMessage("Implemented [" + response.getYear() + ", " + response.getCategory()
		+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		
		return response;
	}*/
}