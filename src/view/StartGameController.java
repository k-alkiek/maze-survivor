package view;

import java.io.IOException;

import com.jfoenix.controls.JFXRadioButton;

import characters.Player;
import characters.PlayerBuilder;
import game.GameEngine;
import game.GameManager;
import game.HeadsUpDisplayUI;
import gun.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import maze.drawer.*;
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
        Player dummyPlayer = new PlayerBuilder().preparePlayerWithPistol(75, 75, 30);
        gameEngine.setPlayer(dummyPlayer);
        ClonedObject.initializeClonedObjectDimension(80);
        
        Pane pane = gameEngine.getPane();
        ScrollPane scrollPane = gameEngine.getScrollPane();
        scrollPane.setContent(pane);

        Player player;
        if (chosenDifficulty.equalsIgnoreCase("easy")) {
        	player = new PlayerBuilder().buildPlayerWithWeapon(chosenWeapon, 75, 75, 0, true);
        } else if (chosenDifficulty.equalsIgnoreCase("medium")) {
        	player = new PlayerBuilder().buildPlayerWithWeapon(chosenWeapon, 75, 75, 0, true);
        } else if (chosenDifficulty.equalsIgnoreCase("hard")) {
        	player = new PlayerBuilder().buildPlayerWithWeapon(chosenWeapon, 75, 75, 0, false);
        } else { //Ninja level
        	player = new PlayerBuilder().buildPlayerWithWeapon(chosenWeapon, 75, 75, 0, false);
        }
        gameEngine.setPlayer(player);
        gameEngine.destroyGameObject(dummyPlayer);
        LevelGenerator mazeDrawer;
        if (chosenDifficulty.equalsIgnoreCase("easy")) {
            mazeDrawer= new EasyLevel(pane, 10, 0.03, 0.01);
        } else if (chosenDifficulty.equalsIgnoreCase("medium")) {
        	mazeDrawer = new MediumLevel(pane, 20, 0.03, 0.01);
        } else if (chosenDifficulty.equalsIgnoreCase("hard")) {
        	mazeDrawer = new HardLevel(pane, 30, 0.03, 0.01);
        } else { //Ninja level
        	mazeDrawer = new NinjaLevel(pane, 45, 0.03, 0.02);
        }
        gameEngine.setSoundHandler(new SoundHandler(player));
        mazeDrawer.constructMaze();
        mazeDrawer.displayMaze();
        player.getWeapon().setBullets((int)Math.floor((double)(mazeDrawer.getNumOfBullets() + mazeDrawer.getNumOfMonsters()) / 100 * player.getWeapon().getDamage())) ;

        System.out.println((int)Math.floor((double)(mazeDrawer.getNumOfBullets() + mazeDrawer.getNumOfMonsters()) / 100 * player.getWeapon().getDamage()));
        System.out.println(mazeDrawer.getNumOfBullets() + " " + mazeDrawer.getNumOfMonsters());

        Pane HUDPane = new Pane();
        new HeadsUpDisplayUI(mazeDrawer.gameManager, HUDPane);
        gameEngine.setHUDPane(HUDPane);

        StackPane stackPane = new StackPane(scrollPane, HUDPane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        

        Scene scene = new Scene(stackPane, 900, 800);
        Stage stage = (Stage) easy.getScene().getWindow();
        stage.setScene(scene);
        gameEngine.primaryStage = stage;

    }

    @FXML
    void quit(ActionEvent event) {
    	Stage stage = (Stage) easy.getScene().getWindow();
    	stage.close();
    }

}
