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

	@RequestMapping("/get")
	public GetResponse Get(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		GetResponse response = new GetResponse();
		//response.setId(1);
		//response.setMessage("Your name is "+name);
		response.setMessage("[" + response.getYear() + ", " + response.getCategory()
				+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		return response;

	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public PostResponse Post(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		//response.setId(inputPayload.getId());
		//response.setMessage("Hello " + inputPayload.getName());
		//response.setExtra("Some text");
		response.setMessage("Implemented [" + response.getYear() + ", " + response.getCategory()
		+ ", " + response.getWinner() + ", " + response.getEntity() + "]");
		response.setCategory(inputPayload.getCategory());
		response.setEntity(inputPayload.getEntity());
		response.setWinner(inputPayload.getWinner());
		response.setYear(inputPayload.getYear());
		return response;
	}
}