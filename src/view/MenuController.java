package view;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller of the main menu.
 * @author H
 *
 */
public class MenuController {

    @FXML
    private JFXButton playButton;

    @FXML
    void startGame(ActionEvent event) {
    	try {
    		Stage stage = (Stage) playButton.getScene().getWindow();
    		stage.hide();
    		Parent root = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void quit(ActionEvent event) {
    	Stage stage = (Stage) playButton.getScene().getWindow();
    	stage.close();
    }

}
