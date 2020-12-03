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
import org.apache.commons.lang3.StringUtils;

public class oscarSearch {
  
  static ArrayList<String[]> catSearch(String searchWord, CSVReader reader, boolean filterWin) 
      throws CsvValidationException, IOException, FileNotFoundException{
    
    ArrayList<String[]> result = new ArrayList<String[]>();
    String[] nextLine;
    
    if(StringUtils.containsIgnoreCase(searchWord, "foreign")
          || StringUtils.containsIgnoreCase(searchWord, "international")) {
      
      while((nextLine = reader.peek()) != null) {
        
        if(StringUtils.containsIgnoreCase(nextLine[3], "foreign")
            || StringUtils.containsIgnoreCase(nextLine[3], "international"))  {
          
          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }else if(StringUtils.containsIgnoreCase(searchWord, "engineering")
              || (StringUtils.containsIgnoreCase(searchWord, "special") 
                  && StringUtils.containsIgnoreCase(searchWord, "effects"))) {
      
      while((nextLine = reader.peek()) != null) {

        if(StringUtils.containsIgnoreCase(nextLine[3], "engineering")
            || nextLine[3].equalsIgnoreCase("special effects") 
            || nextLine[3].equalsIgnoreCase("special visual effects"))  {
          
          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }else if(StringUtils.containsIgnoreCase(searchWord, "sound")
              && (StringUtils.containsIgnoreCase(searchWord, "effects") 
                  || StringUtils.containsIgnoreCase(searchWord, "editing"))) {
      
      while((nextLine = reader.peek()) != null) {

        if(StringUtils.containsIgnoreCase(nextLine[3], "sound")
            && (StringUtils.containsIgnoreCase(nextLine[3], "effects") 
                || StringUtils.containsIgnoreCase(nextLine[3], "editing")))  {
    
          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }else if(searchWord.equalsIgnoreCase("sound")
              || searchWord.equalsIgnoreCase("sound editing") 
              || StringUtils.containsIgnoreCase(searchWord, "mixing")) {
      
      while((nextLine = reader.peek()) != null) {

        if(nextLine[3].equalsIgnoreCase("sound")
            || nextLine[3].equalsIgnoreCase("sound editing") 
            || StringUtils.containsIgnoreCase(nextLine[3], "mixing"))  {

          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }else if(StringUtils.containsIgnoreCase(searchWord, "art direction")
              || searchWord.equalsIgnoreCase("production design")) {

      while((nextLine = reader.peek()) != null) {

        if(StringUtils.containsIgnoreCase(nextLine[3], "art direction")
            || nextLine[3].equalsIgnoreCase("production design"))  {

          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }else if((StringUtils.containsIgnoreCase(searchWord, "lead") 
              && StringUtils.containsIgnoreCase(searchWord, "actress"))
                || searchWord.equalsIgnoreCase("actress")) {

      while((nextLine = reader.peek()) != null) {

        if((StringUtils.containsIgnoreCase(nextLine[3], "lead") 
              && StringUtils.containsIgnoreCase(nextLine[3], "actress"))
                || nextLine[3].equalsIgnoreCase("actress"))  {

          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }else if((StringUtils.containsIgnoreCase(searchWord, "lead") 
              && StringUtils.containsIgnoreCase(searchWord, "actor"))
                || searchWord.equalsIgnoreCase("actor")) {

      while((nextLine = reader.peek()) != null) {

        if((StringUtils.containsIgnoreCase(nextLine[3], "lead") 
              && StringUtils.containsIgnoreCase(nextLine[3], "actor"))
                || nextLine[3].equalsIgnoreCase("actor"))  {

          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }else if(StringUtils.containsIgnoreCase(searchWord, "outstanding") 
              || (StringUtils.containsIgnoreCase(searchWord, "best")
                && StringUtils.containsIgnoreCase(searchWord, "picture"))) {

      while((nextLine = reader.peek()) != null) {

        if(StringUtils.containsIgnoreCase(nextLine[3], "outstanding") 
            || (StringUtils.containsIgnoreCase(nextLine[3], "best")
              && StringUtils.containsIgnoreCase(nextLine[3], "picture")))  {

          result.add(reader.readNext());
        } else {
          reader.skip(1);
        }
      }
    }
    
    if(filterWin) {
      
      result.removeIf(w -> !Boolean.valueOf(w[6]));       //removes all entries that didn't win
      
    }
    
    return result;
  }

  public static void main(String[] args) throws CsvValidationException, IOException, FileNotFoundException {
    
    /*DECLARE STRUCTURES*/
    CSVReader reader = new CSVReader(new FileReader("oscarData.csv"));  //object for CSV operations
    String[] nextLine;                                                  //temp storage for line being read
    ArrayList<String[]> result = new ArrayList<String[]>();             //ArrayList to hold results
    int searchParam;                                                    //indicates whether we search for year, category or title
    boolean filterWin = false;                                          //controls filter by winners in search
    char filter;                                                        //user input for filter by winner

/*GET SEARCH PARAM FROM USER*/
    Scanner input = new Scanner(System.in);
    
    /*FIND WHICH COLUMN WE WILL SEARCH*/
    /*LOOPS UNTIL EITHER 1, 2, OR 3 ARE ENTERED*/
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
    System.out.println("Enter search : ");
    String searchWord = input.nextLine();
    
    /*ONLY SEE WINNERS?*/
    /*LOOPS UNTIL INPUT IS CORRECT*/
    do {
      System.out.println("Would you like to only see films that won? (y) or (n)");
      filter = input.next().charAt(0);
      if(filter == 'y' || filter == 'Y') {
        filterWin = true;
      }
    }while(filter != 'y' && filter != 'n' && filter != 'Y' && filter != 'N');
    input.close();
        
    /*THE SEARCH*/
    if(searchParam == 3) {
      
      result = catSearch(searchWord, reader, filterWin);
      
    }else {  
      while((nextLine = reader.peek()) != null) {                         //peeks next line without advancing iterator
        if(filterWin) {
          if(StringUtils.containsIgnoreCase(nextLine[searchParam], searchWord) && Boolean.valueOf(nextLine[6])) {        //if category matches search
            result.add(reader.readNext());                                //populate result List
          } else {
            reader.skip(1);
          } 
        }else {
          if(StringUtils.containsIgnoreCase(nextLine[searchParam], searchWord)) {          //if category matches search
            result.add(reader.readNext());                                  //populate result List
          } else {
            reader.skip(1);
          }
        }
      }
    }
    
    System.out.println(result.size() + " matches found.");
    
    for(String temp[]: result) {
      
      System.out.println(Arrays.toString(temp));
    }
  }
}