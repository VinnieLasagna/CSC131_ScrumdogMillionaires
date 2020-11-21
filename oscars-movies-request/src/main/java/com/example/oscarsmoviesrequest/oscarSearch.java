package com.example.oscarsmoviesrequest;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.example.oscarsmoviesrequest.models.*;

public class oscarSearch {
  ArrayList<String[]> filteredList;
  
  public void makeFilteredList(ArrayList<String[]> list) {	//constructor for creating access to filtered list
	  this.filteredList = list;
  }
  
  public ArrayList<String[]> getFilteredList() {	//getter for receiving filtered list
	  return filteredList;
  }
  
  public static void main(String[] args) throws CsvValidationException, IOException, FileNotFoundException {
    
    /*Declare Structures*/
	File file = new File("C:\\Users\\donny\\git\\CSC131_ScrumdogMillionaires\\oscars-movies-request\\src\\main\\java\\com\\example\\oscarsmoviesrequest\\oscarData.csv");
    CSVReader reader = new CSVReader(new FileReader(file));  //object for CSV operations
    String[] nextLine;                                                  //temp storage for line being read
    ArrayList<String[]> result = new ArrayList<String[]>();             //ArrayList to hold results

    /*Get search param from user*/
    Scanner input = new Scanner(System.in);
    System.out.println("Enter award category to search for: ");
    String searchWord = input.nextLine();
    input.close();
        
    /*The Search*/
    while((nextLine = reader.peek()) != null) {                         //peeks next line without advancing iterator
      
      if(nextLine[3].equalsIgnoreCase(searchWord)) {                    //if category matches search
        
        result.add(reader.readNext());                                  //populate result List
      } else {
        
        reader.skip(1);
      }
    }
    
    System.out.println(result.size() + " matches found.");
    
    for(String temp[]: result) {
      
      System.out.println(Arrays.toString(temp));
    }
    /*
    oscarSearch oscars = new oscarSearch();			//stores filtered result list for public access
    oscars.makeFilteredList(result);
    ArrayList<String[]> list = oscars.getFilteredList();
    for(String temp[]: list) {
        
        System.out.println(Arrays.toString(temp));
    }
    */
    FillRequests fill = new FillRequests();
    //PostRequest[] requests = fill.createPostRequests(result);
    //fill.sendPostRequests(requests);
	fill.getEntityInfo(result);
  }
}