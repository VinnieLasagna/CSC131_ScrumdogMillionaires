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

public class oscarSearch {

  public static void main(String[] args) throws CsvValidationException, IOException, FileNotFoundException {
    
    /*Declare Structures*/
    CSVReader reader = new CSVReader(new FileReader("oscarData.csv"));  //object for CSV operations
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
  }
}