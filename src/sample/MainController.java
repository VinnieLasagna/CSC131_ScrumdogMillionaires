package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button menuSearchButton;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    private void handleMenuSearchButton(ActionEvent e) throws IOException {
        FXMLLoader loader = FXMLLoader.load(this.getClass().getResource("SearchMenu.fxml"));
        Parent root;
        loader.setRoot(this);
        loader.setController(this);
        //rootPane.getChildren().setAll(pane);
        try{
            root = loader.load();
        }
        catch (IOException exc)
        {
            throw new RuntimeException(exc);
        }

    }
}
