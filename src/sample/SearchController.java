package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

    public SearchController() {
    }

    public void handleEnterKey(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            String input = this.searchField.getText();
            this.displaySearchLabel.setText(input);
            this.displaySearchLabel.setVisible(true);
        }

    }

    public void handleSearchButton(ActionEvent e) {
        try {
            String input = this.searchField.getText();
            this.displaySearchLabel.setText(input);
            this.displaySearchLabel.setVisible(true);
            this.movieTextArea.appendText(input);
        } catch (NullPointerException var3) {
            System.out.println("please enter a movie or actor name");
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void display() {
        String path = "C:\\Users\\Admin\\Desktop\\movie app\\src\\sample\\datahubio_oscar_data_csv.csv";

        try {
            Scanner s = (new Scanner(new File(path))).useDelimiter(",");

            while(s.hasNext()) {
                if (s.hasNextInt()) {
                    this.movieTextArea.appendText(s.nextInt() + " ");
                    System.out.println("int" + s.nextInt());
                } else {
                    this.movieTextArea.appendText(s.next() + " ");
                }
            }
        } catch (FileNotFoundException var3) {
            System.err.println(var3);
        }

    }
}