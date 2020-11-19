package com.example.oscarsmoviesrequest;

import java.util.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.oscarsmoviesrequest.models.GetResponse;
import com.example.oscarsmoviesrequest.models.Post;
import com.example.oscarsmoviesrequest.models.PostRequest;
import com.example.oscarsmoviesrequest.models.PostResponse;
import com.example.oscarsmoviesrequest.controller.WebController;

@Service
public class FillList {
	private final RestTemplate restTemplate = new RestTemplate();
	private final WebController webController = new WebController();
	
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
	
	public PostRequest createPost(List<String[]> list) {
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	    Map<String, Object> entriesMap = new HashMap<String, Object>();
	    for (String[] entries : list) {
	    	//for (Object categories : entries) {
	    		
	    	//}
	    	entriesMap.put("year", entries[0]);
	    	entriesMap.put("category", entries[1]);
	    	entriesMap.put("winner", entries[2]);
	    	entriesMap.put("entity", entries[3]);
	    }
	    Map<String, Object> map = new HashMap<>();
	    map.put("userId", 0);
	    map.put("title", "Introduction to Spring Boot");
	    map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");

	    // build the request
	    //HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(entriesMap, headers);
	    
	    // send POST request
	    //ResponseEntity<Post> response = this.restTemplate.postForEntity(url, entity, Post.class);
	    ResponseEntity<PostRequest> response = this.restTemplate.postForEntity(url, entity, PostRequest.class);
	    
	    // check response status code
	    if (response.getStatusCode() == HttpStatus.CREATED) {
	        return response.getBody();
	    } else {
	        return null;
	    }
	}
	
	public PostRequest[] getPostsAsObject() {
		String url = "https://jsonplaceholder.typicode.com/posts";
		return this.restTemplate.getForObject(url, PostRequest[].class);	//
	}
	
	public Post[] getPostsWithUrlParameters(int userId) {
		String url = "https://jsonplaceholder.typicode.com/posts?userId=2";
		return this.restTemplate.getForObject(url, Post[].class, userId);
	}
	
	public void sendPostRequests(PostRequest[] requests) {
		for (int k = 0; k < requests.length; k++) {
			PostResponse tester = webController.Post(requests[k]);
			//GetResponse get = webController.Get(name)
			System.out.println(tester.getMessage());
		}	
	}
	
	public void getEntityInfo(PostRequest[] requests) {
		
		for (int k = 0; k < requests.length; k++) {
			PostRequest request = requests[k];
			System.out.print(request.getYear() + " ");
			System.out.print(request.getCategory() + " ");
			System.out.print(request.getWinner() + " ");
			System.out.println(request.getEntity() + " ");
			System.out.println("Got here");
		}
		
		for (int k = 0; k < requests.length; k++) {
			PostRequest request = requests[k];
			GetResponse tester = webController.Get(request.getYear(),
					request.getCategory(),request.getWinner(),request.getEntity());
			//GetResponse get = webController.Get(name)
			System.out.println(tester.getMessage());
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
		
		//PostRequest test = fill.createPost(list);
		//System.out.println(test);
		//PostRequest[] post = fill.getPostsAsObject();
		//System.out.println(post);
		//must call PostResponse and then GetResponse
		
		//use the postrequest array that's returned to call PostCheck
		fill.sendPostRequests(requests);
		fill.getEntityInfo(requests);
		System.out.println("Successful");
	}
	
	
}