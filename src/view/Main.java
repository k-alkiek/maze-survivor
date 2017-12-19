package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Main application class.
 * 
 * @author H
 *
 */
public class Main extends Application {

	@Override
	public void start(final Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Maze Survivor");
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.setOnKeyPressed(e -> {
			        try {
						Parent menuRoot = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
						Scene menuScene = new Scene(menuRoot);
						primaryStage.setScene(menuScene);
						primaryStage.show();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			});
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main function.
	 * 
	 * @param args
	 *            arguments for main.
	 */
	public static void main(final String[] args) {
		Application.launch(args);
	}
}
