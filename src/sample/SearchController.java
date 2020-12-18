package sample;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchController {
    @FXML
    private TextField searchField;
    @FXML
    private TextField catField;
    @FXML
    private Label displaySearchLabel;
    @FXML
    private Button searchButton;
    @FXML
    private TextArea movieTextArea;
    @FXML
    private TextArea catTextArea;
    @FXML
    private CheckBox filterCheck;


    int count = 0;  //counter to keep track of amount of times search was done{
    public SearchController() throws FileNotFoundException {
    }


    public void zeroCount() throws IOException, CsvValidationException {
        movieTextArea.setText(" ");
        String input = searchField.getText();
        displaySearchLabel.setText(input);
        displaySearchLabel.setVisible(true);
        if (filterCheck.isSelected()) {
            movieTextArea.replaceText(0, 1, "Showing winning results for: " + input + "\n");
        }
        else {
            movieTextArea.replaceText(0, 1, "Showing results for: " + input + "\n");
        }
        display();
        count += 1;

    }

    public void nCount() throws IOException, CsvValidationException {
        movieTextArea.setText(" ");     //clear the search output
        String input = searchField.getText();
        displaySearchLabel.setText(input);
        displaySearchLabel.setVisible(true);
        if (filterCheck.isSelected()) {
            movieTextArea.replaceText(0, 1, "Showing winning results for: " + input + "\n");
        }
        else {
            movieTextArea.replaceText(0, 1, "Showing results for: " + input + "\n");
        }
        display();

    }

    public void handleEnterKey(KeyEvent e) throws IOException, CsvValidationException {
        if (e.getCode() == KeyCode.ENTER) {
            if (count == 0) {
                count += 1;
                zeroCount();
            } else if (count >= 1) {
                nCount();
            }
        }

    }


    public void handleSearchButton(ActionEvent e) throws IOException, CsvValidationException {
        try {
            if (count == 0) {
                count += 1;
                zeroCount();
            } else if (count >= 1) {
                nCount();
            }
        } catch (NullPointerException ne) {
            System.out.println("test");
        }
    }
    public void display() throws CsvValidationException, IOException
    {
        String name= searchField.getText();
        int searchParam = 5;

        oscarSearch os = new oscarSearch();
        if (StringUtils.isNumeric(name))
        {
            searchParam = 0;
        }
        ArrayList<String[]> list = os.search(name, filterCheck.isSelected(), searchParam);
        ArrayList<String[]> catList = os.catSearch(name, filterCheck.isSelected());


            //display results by category search
            for (String[] arr : catList) {
                //check to see what category user searched for
                if (arr[3].equalsIgnoreCase(name))
                    if (arr[6].equalsIgnoreCase("true")) {
                        movieTextArea.appendText(arr[5] + " (" + arr[0] + ") \u2606 \n");
                    } else
                        movieTextArea.appendText(arr[5] + " (" + arr[0] + ") \n");
            }

            //iterate over list of arrays to display results by name search
            for (String[] arr : list) {
                if (arr[6].equalsIgnoreCase("true")) {
                    movieTextArea.appendText(arr[5] + " (" + arr[0] + ") \u2606 \n");
                } else
                    movieTextArea.appendText(arr[5] + " (" + arr[0] + ") \n");
            }




    }

    public boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public void displayByCategories() throws CsvValidationException, IOException
    {
        String cat = catField.getText();
        oscarSearch os = new oscarSearch();
        ArrayList<String[]> list = os.catSearch(cat, filterCheck.isSelected());
        for (String[] arr: list)
        {
            if (arr[6].equalsIgnoreCase("true")) {
                movieTextArea.appendText(arr[5] + " (" + arr[0] + ") \u2606 \n");
            } else
                movieTextArea.appendText(arr[5] + " (" + arr[0] + ") \n");

        }

    }


}


