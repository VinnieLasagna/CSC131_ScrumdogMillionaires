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
		response.setId(1);
		response.setMessage("Your name is "+name);
		return response;

	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public PostResponse Post(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		response.setId(inputPayload.getId()*100);
		response.setMessage("Hello " + inputPayload.getName());
		response.setExtra("Some text");
		return response;
	}
}