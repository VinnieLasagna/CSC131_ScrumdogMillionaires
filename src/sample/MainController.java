package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    private void handleMenuSearchButton(ActionEvent e) throws IOException {
        //AnchorPane pane = FXMLLoader.load(this.getClass().getResource("SearchController.fxml"));
        //rootPane.getChildren().setAll(pane);

    }
}
