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
    while((nextLine = reader.peek()) != null) {                         //peeks next line without advancing iterator
      if(filterWin) {
        if(nextLine[searchParam].equalsIgnoreCase(searchWord) && Boolean.valueOf(nextLine[6])) {        //if category matches search
          result.add(reader.readNext());                                //populate result List
        } else {
          reader.skip(1);
        }
      }else {
        if(nextLine[searchParam].equalsIgnoreCase(searchWord)) {          //if category matches search
          result.add(reader.readNext());                                  //populate result List
        } else {
          reader.skip(1);
        }
      }
    }

    System.out.println(result.size() + " matches found.");

    for(String temp[]: result) {

      System.out.println(Arrays.toString(temp));
    }
  }
}
