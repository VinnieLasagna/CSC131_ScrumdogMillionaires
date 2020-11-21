package project.oscarvision.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import project.oscarvision.models.PostRequest;
import project.oscarvision.models.PostResponse;
import project.oscarvision.models.SampleResponse;

@RestController
public class WebController{

   @RequestMapping("/sample")
   public SampleResponse Sample(@RequestParam(value = "film", defaultValue = "Blade Runner") String film){
      SampleResponse response = new SampleResponse();
      response.setYear(1982);
      response.setFilm("The movie is " + film);
      return response;
   }
   
   @RequestMapping(value = "/test", method = RequestMethod.POST)
   public PostResponse Test(@RequestBody PostRequest inputPayload){
      PostResponse response = new PostResponse();
      response.setCategory(inputPayload.getCategory());
      response.setEntity(inputPayload.getEntity());
      response.setWinner(inputPayload.getWinner());
      response.setYear(inputPayload.getYear());
      return response;
   }
}