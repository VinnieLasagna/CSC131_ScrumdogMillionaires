package com.example.oscarsmoviesrequest;

import java.util.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.oscarsmoviesrequest.models.PostRequest;

public class FillList {
	private final RestTemplate restTemplate = new RestTemplate();

	public PostRequest[] createPostRequests(List<String[]> list) {
		ListIterator<String[]> itr = list.listIterator();
		
		int listSize = list.size();
		System.out.println("Successful 1 " + listSize);
		PostRequest[] requests = new PostRequest[listSize];
		for (int i = 0; i < listSize; i++) {
			PostRequest entries = new PostRequest();
			
			String[] stringFields = list.get(i);
			for (int j = 0; j < stringFields.length; j++) {
				switch (j) {
					case 0:
						entries.setYear(Long.valueOf(stringFields[0]));
					case 1:
						entries.setCategory(stringFields[1]);
					case 2:
						entries.setWinner(Boolean.valueOf(stringFields[2]));
					case 3:
						entries.setEntity(stringFields[3]);		
				}
			}
			System.out.print(entries.getYear() + " ");
			System.out.print(entries.getCategory() + " ");
			System.out.print(entries.getWinner() + " ");
			System.out.println(entries.getEntity() + " ");
			requests[i] = entries;
			itr.next();
		}
		return requests;	
	}
	
	public Post createPost() {
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	    Map<String, Object> map = new HashMap<>();
	    map.put("userId", 1);
	    map.put("title", "Introduction to Spring Boot");
	    map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");

	    // build the request
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

	    // send POST request
	    ResponseEntity<Post> response = this.restTemplate.postForEntity(url, entity, Post.class);

	    // check response status code
	    if (response.getStatusCode() == HttpStatus.CREATED) {
	        return response.getBody();
	    } else {
	        return null;
	    }
	}
	
	public static void main(String[] args) {
		FillList fill = new FillList();
		String[] fields = {"1927","ACTOR","True","Emil Jannings"};
		String[] fields2 = {"1927","ACTOR","False","Richard Barthelmess"};
		List<String[]> list = new ArrayList<String[]>();
		list.add(fields);
		list.add(fields2);
		
		for (int i = 0; i < list.size(); i++) {
			String[] readOut = list.get(i);
			for (int j = 0; j < readOut.length; j++) {
				System.out.print(readOut[j] + " ");
			}
			System.out.println("");
		}
		
		PostRequest[] requests = fill.createPostRequests(list);
		System.out.println("Successful" + requests.length);
		
		for (int k = 0; k < requests.length; k++) {
			PostRequest request = requests[k];
			System.out.print(request.getYear() + " ");
			System.out.print(request.getCategory() + " ");
			System.out.print(request.getWinner() + " ");
			System.out.println(request.getEntity() + " ");
		}
		
		fill.createPost();
		//must call PostResponse and then GetResponse
		
	}
	
	
}