package game;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 12/15/17.
 * Handles keyboard input in the game.
 */
public final class Keyboard {
    private GameEngine gameEngine;

    public List<KeyCode> keysPressed;

    public Keyboard(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this. keysPressed = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        Pane pane = gameEngine.getPane();
        System.out.println("adsasd");

        pane.setOnMousePressed(event -> System.out.println("press"));
        pane.setOnKeyPressed(event -> {
            System.out.println("asdasd");
            keysPressed.add(event.getCode());
        });

        pane.setOnKeyReleased(event -> {
            System.out.println("asdasd");
            if (keysPressed.contains(event.getCode())) {
                keysPressed.remove(event.getCode());
            }
        });
    }

}
