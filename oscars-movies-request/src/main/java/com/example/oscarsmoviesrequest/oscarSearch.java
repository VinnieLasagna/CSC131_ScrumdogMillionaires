package com.example.oscarsmoviesrequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.example.oscarsmoviesrequest.controller.WebController;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class oscarSearch {

	static ArrayList<String[]> catSearch(String searchWord, CSVReader reader, boolean filterWin)
            throws CsvValidationException, IOException, FileNotFoundException{

        ArrayList<String[]> result = new ArrayList<String[]>();
        
        if(StringUtils.containsIgnoreCase(searchWord, "foreign")
                || StringUtils.containsIgnoreCase(searchWord, "international")) {	//if category matches search

            result = WebController.getCategory(searchWord);		//populate result List
        }else if(StringUtils.containsIgnoreCase(searchWord, "engineering")
                || (StringUtils.containsIgnoreCase(searchWord, "special")
                && StringUtils.containsIgnoreCase(searchWord, "effects"))) {

            result = WebController.getCategory(searchWord);
        }else if(StringUtils.containsIgnoreCase(searchWord, "sound")
                && (StringUtils.containsIgnoreCase(searchWord, "effects")
                || StringUtils.containsIgnoreCase(searchWord, "editing"))) {

            result = WebController.getCategory(searchWord);
        }else if(searchWord.equalsIgnoreCase("sound")
                || searchWord.equalsIgnoreCase("sound editing")
                || StringUtils.containsIgnoreCase(searchWord, "mixing")) {

            result = WebController.getCategory(searchWord);
        }else if(StringUtils.containsIgnoreCase(searchWord, "art direction")
                || searchWord.equalsIgnoreCase("production design")) {

            result = WebController.getCategory(searchWord);
        }else if((StringUtils.containsIgnoreCase(searchWord, "lead")
                && StringUtils.containsIgnoreCase(searchWord, "actress"))
                || searchWord.equalsIgnoreCase("actress")) {

            result = WebController.getCategory(searchWord);
        } else if((StringUtils.containsIgnoreCase(searchWord, "lead")
                && StringUtils.containsIgnoreCase(searchWord, "actor"))
                || searchWord.equalsIgnoreCase("actor")) {
        	
            result = WebController.getCategory(searchWord);
        } else if(StringUtils.containsIgnoreCase(searchWord, "outstanding")
                || (StringUtils.containsIgnoreCase(searchWord, "best")
                && StringUtils.containsIgnoreCase(searchWord, "picture"))) {
        	
            result = WebController.getCategory(searchWord);
        } else {
            result = WebController.getCategory(searchWord);
        }

        if(filterWin) {
            result.removeIf(w -> !Boolean.valueOf(w[6]));       //removes all entries that didn't win
        }
        return result;
    }
	
	public static ArrayList<String[]> listOfMovies() throws CsvValidationException, IOException, FileNotFoundException {
		File file = new File("C:\\Users\\donny\\git\\CSC131_ScrumdogMillionaires\\oscars-movies-request\\src\\main\\java\\com\\example\\oscarsmoviesrequest\\oscarData.csv");
		CSVReader reader = new CSVReader(new FileReader(file)); // object for CSV operations
		ArrayList<String[]> result = new ArrayList<String[]>(); // ArrayList to hold results
		while((reader.peek()) != null) {
			result.add(reader.readNext());
		}
		return result;
	}
	
	public static ArrayList<String[]> search() throws CsvValidationException, IOException, FileNotFoundException {
		File file = new File("C:\\Users\\donny\\git\\CSC131_ScrumdogMillionaires\\oscars-movies-request\\src\\main\\java\\com\\example\\oscarsmoviesrequest\\oscarData.csv");
		CSVReader reader = new CSVReader(new FileReader(file)); // object for CSV operations
		ArrayList<String[]> result = new ArrayList<String[]>(); // ArrayList to hold results
		int searchParam;
		boolean filterWin = false;
		char filter;
		
		/* Get search param from user */
		Scanner input = new Scanner(System.in);
		do {
            System.out.println("Would you like to search :");
            System.out.println("                          (1)By year?");
            System.out.println("                          (2)By category?");
            System.out.println("                          (3)By title?");
            int tempParam = input.nextInt();
            if(tempParam == 1) {
                searchParam = 0;
            }else if(tempParam == 2) {
                searchParam = 3;
            }else if(tempParam ==3) {
                searchParam = 5;
            }else {
                searchParam = -1;
            }
        }while(searchParam < 0);

        /*GET STRING TO SEARCH FOR*/
        input.nextLine();
        System.out.print("Enter search : ");
        String searchWord = input.nextLine();
        /*ONLY SEE WINNERS?*/
        /*LOOPS UNTIL INPUT IS CORRECT*/
        do {
            System.out.print("Would you like to only see films that won? (y) or (n) ");
            filter = input.next().charAt(0);
            if(filter == 'y' || filter == 'Y') {
                filterWin = true;
            }
        } while(filter != 'y' && filter != 'n' && filter != 'Y' && filter != 'N');
        input.close();

        /*THE SEARCH*/
        if (searchParam == 3) {
            result = catSearch(searchWord, reader, filterWin);
        } else {
            if(filterWin) {
            	if (searchParam == 0) {
                	result = WebController.getTrueYearFilm(searchWord);
            	} else if (searchParam == 5) {
                	result = WebController.getTrueFilm(searchWord);
            	}
        	} else {
            	if (searchParam == 0) {
                	result = WebController.getYearFilm(searchWord);
            	} else if (searchParam == 5) {
                	result = WebController.getFilm(searchWord);
            	}
            }
        }

		System.out.println(result.size() + " matches found.");

		for (String temp[] : result) { // prints entries of CSV file as a string
			System.out.println(Arrays.toString(temp));
		}
		return result;
	}
	
	public static void main(String[] args) throws CsvValidationException, IOException, FileNotFoundException {
		/*
		// Declare Structures
		File file = new File(
				"C:\\Users\\donny\\git\\CSC131_ScrumdogMillionaires\\oscars-movies-request\\src\\main\\java\\com\\example\\oscarsmoviesrequest\\oscarData.csv");
		CSVReader reader = new CSVReader(new FileReader(file)); // object for CSV operations
		String[] nextLine; // temp storage for line being read
		ArrayList<String[]> result = new ArrayList<String[]>(); // ArrayList to hold results

		// Get search param from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter award category to search for: ");
		String searchWord = input.nextLine();
		input.close();

		// The Search
		while ((nextLine = reader.peek()) != null) { // peeks next line without advancing iterator

			if (nextLine[3].equalsIgnoreCase(searchWord)) { // if category matches search

				result.add(reader.readNext()); // populate result List
			} else {
				reader.skip(1);
			}
		}

		System.out.println(result.size() + " matches found.");

		for (String temp[] : result) { // prints entries of CSV file as a string
			System.out.println(Arrays.toString(temp));
		}
		*/
		//oscarSearch oscars = new oscarSearch();
		ArrayList<String[]> result = new ArrayList<String[]>();
		result = oscarSearch.search();
		//ArrayList<String[]> readSearch = fill.getEntityInfo(result); // calls getEntityInfo to call GET request and
																		// return entries
		
		System.out.println("JSON converted to string:");
		for (String[] search : result) {
			System.out.println(Arrays.toString(search));
		}
	}
}