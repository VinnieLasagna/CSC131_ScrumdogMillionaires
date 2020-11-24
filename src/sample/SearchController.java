package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SearchController {
    @FXML
    private TextField searchField;
    @FXML
    private Label displaySearchLabel;
    @FXML
    private Button searchButton;
    @FXML
    private TextArea movieTextArea;
    @FXML
    private ListView movieList;
    @FXML
    private Tab tab1;

    oscarSearch os = new oscarSearch();


    int count = 0;  //counter to keep track of amount of times search was done


    public SearchController() {
    }

    public void handleEnterKey(KeyEvent e) throws IOException, CsvValidationException {
        if (e.getCode() == KeyCode.ENTER) {
            if (count == 0) {
                String input = searchField.getText();
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.insertText(0, "Showing results for: " + input +"\n");
                tab1.setText(" " + input + " ");
                display();
                count += 1;
            }
            else if (count >= 1)
            {
                movieTextArea.setText(" ");     //clear the search output
                String input = searchField.getText();
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.replaceText(0, 1, "Showing results for: " + input +"\n");
                tab1.setText(input);
                display();

            }
        }
        //display();

    }

    public void handleSearchButton(ActionEvent e) {
        try {
            if (count == 0) {
                String input = searchField.getText();
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.insertText(0, "Showing results for: " + input +"\n");
                display();
                count += 1;
            }
            else if ( count >= 1)
            {
                movieTextArea.setText(" ");
                String input = searchField.getText();
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.replaceText(0, 1, "Showing results for: " + input +"\n");
                display();
            }

        } catch (NullPointerException var3) {
            var3.printStackTrace();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void display() throws IOException, CsvValidationException {
        oscarSearch os = new oscarSearch();
        ArrayList<String[]> list = os.search(searchField.getText());
        //int i = 10;
        for (String[] arr : list )  //iterate over list of arrays
        {
            movieTextArea.appendText(arr[5] + ", (" + arr[0] + ") \n");

            /*for (String s : arr )   //then iterate over each string in array
            {
                if (s.equalsIgnoreCase(searchField.getText()))    //if what the user searched for is found
                {
                    //System.out.println(s);
                    for ( int i = 0; i < arr.length; i++)
                    {
                        movieTextArea.insertText(1, arr[i]);
                        //movieTextArea.insertText(i+1, "\n");
                        if (arr[i].equalsIgnoreCase("true") || arr[i].equalsIgnoreCase("false") )
                        {
                            movieTextArea.insertText(i, "\n");
                        }
                    }
                }*/

        }


    }
}