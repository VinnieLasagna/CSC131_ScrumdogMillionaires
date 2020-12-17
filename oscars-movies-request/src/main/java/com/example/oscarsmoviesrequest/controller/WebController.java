package com.example.oscarsmoviesrequest.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.oscarsmoviesrequest.oscarSearch;
import com.opencsv.exceptions.CsvValidationException;

@RestController
public class WebController {

	private static ArrayList<String[]> oscarsMovies = new ArrayList<String[]>();
	
	// reads input and returns result as JSON object
	@RequestMapping(value = "/movies/all", method = RequestMethod.GET) 
	public static ArrayList<String[]> getAll() throws CsvValidationException, IOException, FileNotFoundException {
		oscarsMovies = oscarSearch.listOfMovies();
		return oscarsMovies;
	}
	
	@RequestMapping(value = "/movies/year_film/{year_film}", method = RequestMethod.GET) 
	public static ArrayList<String[]> getYearFilm(@PathVariable("year_film") String year_film)
			throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[0], year_film)) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/year_film/{year_film}/true", method = RequestMethod.GET) 
	public static ArrayList<String[]> getTrueYearFilm(@PathVariable("year_film") String year_film) throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {			
			if (StringUtils.containsIgnoreCase(movieEntry[0], year_film) && Boolean.valueOf(movieEntry[6])) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/year_ceremony/{year_ceremony}", method = RequestMethod.GET) 
	public static ArrayList<String[]> getYearCeremony(@PathVariable("year_ceremony") String year_ceremony) 
					throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[1], year_ceremony)) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/year_ceremony/{year_ceremony}/true", method = RequestMethod.GET) 
	public static ArrayList<String[]> getTrueYearCeremony(@PathVariable("year_ceremony") String year_ceremony) throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[1], year_ceremony) && Boolean.valueOf(movieEntry[6])) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/ceremony/{ceremony}", method = RequestMethod.GET) 
	public static ArrayList<String[]> getCeremony(@PathVariable("ceremony") String ceremony) 
					throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[2], ceremony)) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/category/{category}", method = RequestMethod.GET) 
	public static ArrayList<String[]> getCategory(@PathVariable("category") String category) 
					throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[3], category)) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/name/{name}", method = RequestMethod.GET) 
	public static ArrayList<String[]> getName(@PathVariable("name") String name) 
					throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[4], name)) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/film/{film}", method = RequestMethod.GET) 
	public static ArrayList<String[]> getFilm(@PathVariable("film") String film) 
					throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[5], film)) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/film/{film}/true", method = RequestMethod.GET) 
	public static ArrayList<String[]> getTrueFilm(@PathVariable("film") String film) throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[5], film) && Boolean.valueOf(movieEntry[6])) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
	
	@RequestMapping(value = "/movies/winner/{winner}", method = RequestMethod.GET) 
	public static ArrayList<String[]> getWinner(@PathVariable("winner") String winner) 
					throws CsvValidationException, IOException, FileNotFoundException {
		
		oscarsMovies = oscarSearch.listOfMovies();
		ArrayList<String[]> searchedMovies = new ArrayList<String[]>();

		for (String[] movieEntry : oscarsMovies) {
			if (StringUtils.containsIgnoreCase(movieEntry[6], winner)) {
				searchedMovies.add(movieEntry);
			}
		}
		return searchedMovies;
	}
}