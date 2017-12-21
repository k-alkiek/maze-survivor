package view;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controller of the main menu.
 * @author H
 *
 */
public class WinAndLoseController {

    @FXML
    AnchorPane pane;
    @FXML
    void startGame(ActionEvent event) {
    	try {
    		Stage stage = (Stage) pane.getScene().getWindow();
    		stage.hide();
    		Parent root = FXMLLoader.load(getClass().getResource("WinScreen.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
