package sample;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    @FXML
    private CheckBox filterCheck;
    //oscarSearch os = new oscarSearch();
    CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Admin\\Desktop\\CSC131_ScrumdogMillionaires\\src\\sample\\OscarData.csv"));

    int count = 0;  //counter to keep track of amount of times search was done{
    private Object IOException;
    private Object CsvValidationException;

    public SearchController() throws FileNotFoundException {
    }


    public void zeroCount() throws IOException, CsvValidationException {
        String input = searchField.getText();
        displaySearchLabel.setText(input);
        displaySearchLabel.setVisible(true);
        movieTextArea.insertText(0, "Showing results for: " + input + "\n");
        tab1.setText(" " + input + " ");
        //display();
        count += 1;

    }

    public void nCount() throws IOException, CsvValidationException {
        movieTextArea.setText(" ");     //clear the search output
        String input = searchField.getText();
        displaySearchLabel.setText(input);
        displaySearchLabel.setVisible(true);
        movieTextArea.replaceText(0, 1, "Showing results for: " + input + "\n");
        tab1.setText(input);
        //display();

    }

    public void handleEnterKey(KeyEvent e) throws IOException, CsvValidationException {
        if (e.getCode() == KeyCode.ENTER) {
            if (count == 0) {
                String input = searchField.getText();
                movieTextArea.setText("");
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.setText("Showing results for: " + input + "\n");
                tab1.setText(" " + input + " ");
                display();
                count += 1;
                zeroCount();
            } else if (count >= 1) {
                movieTextArea.setText(" ");     //clear the search output
                String input = searchField.getText();
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.replaceText(0, 1, "Showing results for: " + input + "\n");
                tab1.setText(input);
                display();

                nCount();
            }
        }

    }


    public void handleSearchButton(ActionEvent e) throws IOException, CsvValidationException {
        try {
            if (count == 0) {
                String input = searchField.getText();
                movieTextArea.setText("");
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.setText("Showing results for: " + input + "\n");
                display();
                count += 1;
                zeroCount();
            } else if (count >= 1) {
                movieTextArea.setText(" ");
                String input = searchField.getText();
                displaySearchLabel.setText(input);
                displaySearchLabel.setVisible(true);
                movieTextArea.replaceText(0, 1, "Showing results for: " + input + "\n");
                display();
                nCount();
            }
        } catch (NullPointerException ne) {
            System.out.println("test");
        }
    }
        /*public void display() throws CsvValidationException
        {
            oscarSearch os = new oscarSearch();
            //ArrayList<String[]> list = os.search(searchField.getText());
            ArrayList<String[]> list = os.searchCategory(searchField.getText());
            //int i = 10;
            for (String[] arr : list)  //iterate over list of arrays
            {
                movieTextArea.appendText(arr[5] + ", (" + arr[0] + ") \n");
            }

            /*for (String s : arr )   //then iterate over each string in array
            if (filterCheck.isSelected())
            {
                if (s.equalsIgnoreCase(searchField.getText()))    //if what the user searched for is found
                for (String s : arr)
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
                    if (s.equalsIgnoreCase("true")) {
                        movieTextArea.appendText(arr[5] + ", (" + arr[0] + ") \u2606 \n");
                    }
                }*/
                 /*      }

                    }
            else {
                        movieTextArea.appendText(arr[5] + ", (" + arr[0] + ") \n");
                    }


                }*/

        public void display() throws IOException, CsvValidationException {
            oscarSearch os = new oscarSearch();
            //search by category
            ArrayList<String[]> catList = os.catSearch(searchField.getText(), reader, filterCheck.isSelected());
            ArrayList<String[]> list = os.search(searchField.getText());

            for (String[] arr : list)  //iterate over list of arrays
            {
                movieTextArea.appendText(arr[5] + ", (" + arr[0] + ") \n");
            }

        }

}


