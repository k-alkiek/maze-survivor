package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Controller of the main menu.
 * 
 * @author H
 *
 */
public class MenuController {

	@FXML
	private AnchorPane pane;

	@FXML
	private JFXButton settingButton;

	@FXML
	void settingOnClick(MouseEvent event) {

		System.out.println("innnn");
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
			Scene menuScene = new Scene(root);
			Stage stage = (Stage) settingButton.getScene().getWindow();
			stage.setScene(menuScene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
