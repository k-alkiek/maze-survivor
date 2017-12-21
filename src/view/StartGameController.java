package view;

import java.io.IOException;

import com.jfoenix.controls.JFXRadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Controller for the page of starting a new game.
 * @author H
 *
 */
public class StartGameController {


    @FXML
    private JFXRadioButton easy;

    @FXML
    private JFXRadioButton medium;

    @FXML
    private JFXRadioButton hard;

    @FXML
    private JFXRadioButton ninja;

    @FXML
    private ToggleGroup difficulty;

    @FXML
    void mainMenu(ActionEvent event) {
    	try {
    		Stage stage = (Stage) easy.getScene().getWindow();
    		stage.hide();
    		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void play(ActionEvent event) {
    	//TODO: PLAY. START GAME.
    }

    @FXML
    void quit(ActionEvent event) {
    	Stage stage = (Stage) easy.getScene().getWindow();
    	stage.close();
    }

}
