package game;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.sun.javafx.fxml.builder.JavaFXFontBuilder;

import gun.Weapon;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import objects.GameObject;

import java.util.Stack;

/**
 * Created by khaled on 12/20/17.
 */
public class HeadsUpDisplayUI extends GameObject {
    private Pane parentPane;
    private Pane pane;

    private ProgressBar healthBar;
    private ProgressBar hungerBar;
    private Label scoreLabel;
    private Label ammoLabel;

    private GameManager gameManager;

    private Weapon weapon;

    public HeadsUpDisplayUI(GameManager gameManager, Pane pane) {
        super(GameEngine.getInstanceOf());
        this.gameManager = gameManager;
        weapon = gameEngine.getPlayer().getWeapon();
    	DBLogger.getInstance().log.info(this.getClass().getSimpleName() + " created.");
        this.pane = pane;
        parentPane = GameEngine.getInstanceOf().getPane();
        initializeBars();
        initializeLabels();
    }

    @Override
    public void update() {
        // TODO Khaled Barie
        Platform.runLater(() -> {
            healthBar.setProgress((double) gameManager.getHealth() / gameManager.getMaxHealth());
            hungerBar.setProgress((double) gameManager.getFood() / gameManager.getMaxHealth());
        });
        scoreLabel.setText("" + gameManager.getScore());
        ammoLabel.setText("Ammo: " + weapon.getBulletsInMag() + "/" + weapon.getBullets());
        scoreLabel.setLayoutX(parentPane.getWidth() / 2);
        ammoLabel.setLayoutX(parentPane.getWidth() - 120);
    }

    private void initializeLabels() {
        scoreLabel = new Label("Score");
        scoreLabel.setTextFill(Color.WHITE);
        scoreLabel.setLayoutY(20);
        pane.getChildren().add(scoreLabel);

        ammoLabel = new Label("Ammo: 20/23");
        ammoLabel.setTextFill(Color.WHITE);
        ammoLabel.setLayoutY(20);
        pane.getChildren().add(ammoLabel);
    }

    private void initializeBars() {
        healthBar = new ProgressBar(1);
        healthBar.setStyle("-fx-box-border: black; -fx-accent: red;");
        healthBar.setPrefWidth(200);
        healthBar.setLayoutX(65);
        healthBar.setLayoutY(10);
        Label healthLabel= new Label("Health");
        healthLabel.setTextFill(Color.WHITE);
        healthLabel.setLayoutX(10);
        healthLabel.setLayoutY(10);
        pane.getChildren().add(healthBar);
        pane.getChildren().add(healthLabel);

        hungerBar = new ProgressBar(1);
        hungerBar.setStyle("-fx-box-border: black; -fx-accent: brown;");
        hungerBar.setPrefWidth(200);
        hungerBar.setLayoutX(65);
        hungerBar.setLayoutY(35);
        Label hungerLabel= new Label("Hunger");
        hungerLabel.setTextFill(Color.WHITE);
        hungerLabel.setLayoutX(10);
        hungerLabel.setLayoutY(35);
        pane.getChildren().add(hungerBar);
        pane.getChildren().add(hungerLabel);

    }
}
