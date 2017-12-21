package view;

import java.io.IOException;

import com.jfoenix.controls.JFXRadioButton;

import characters.Player;
import characters.PlayerBuilder;
import game.GameEngine;
import game.HeadsUpDisplayUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import maze.drawer.MazeDrawer;
import objects.ClonedObject;
import sound.SoundHandler;

/**
 * Controller for the page of starting a new game.
 * @author H
 *
 */
public class StartGameController {

	@FXML
    private JFXRadioButton easy;

    @FXML
    private ToggleGroup difficulty;

    @FXML
    private JFXRadioButton medium;

    @FXML
    private JFXRadioButton hard;

    @FXML
    private JFXRadioButton ninja;

    @FXML
    private JFXRadioButton shotgun;

    @FXML
    private ToggleGroup weapon;

    @FXML
    private JFXRadioButton handgun;

    @FXML
    private JFXRadioButton rifle;

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
    	JFXRadioButton chosenDifficulty = (JFXRadioButton) difficulty.getSelectedToggle();
    	JFXRadioButton chosenWeapon = (JFXRadioButton) weapon.getSelectedToggle();
    	initialiseGameElements(chosenWeapon.getText(), chosenDifficulty.getText());
    }

    private void initialiseGameElements(String chosenWeapon, String chosenDifficulty) {
    	GameEngine gameEngine = GameEngine.getInstanceOf();
        ClonedObject.initializeClonedObjectDimension(80);
        Player player = new PlayerBuilder().buildPlayerWithWeapon(chosenWeapon, 75, 75, 0);
        player.setChoosingCharacter(chosenWeapon);
        gameEngine.setPlayer(player);
        gameEngine.setSoundHandler(new SoundHandler(player));

        Pane pane = gameEngine.getPane();
        MazeDrawer mazeDrawer = new MazeDrawer(pane, 10, 0.03, 0.01 /2);
        mazeDrawer.constructMaze();
        mazeDrawer.displayMaze();
        player.getWeapon().setBullets(15);

        Pane HUDPane = new Pane();
        new HeadsUpDisplayUI(gameEngine, HUDPane);
        gameEngine.setHUDPane(HUDPane);
        StackPane stackPane = new StackPane(pane, HUDPane);

        Scene scene = new Scene(stackPane, 900, 800);
        Stage stage = (Stage) easy.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void quit(ActionEvent event) {
    	Stage stage = (Stage) easy.getScene().getWindow();
    	stage.close();
    }

}
