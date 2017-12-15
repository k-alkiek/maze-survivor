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

    /**
     * @return a list of all keys that are currently pressed
     */
    public List<KeyCode> getKeysPressed() {
        return keysPressed;
    }

    /**
     * Checks if a key on the keyboard is currently pressed
     * @param keyCode KeyCode of the key to be checked
     */
    public boolean IsPressed(KeyCode keyCode) {
        return keysPressed.contains(keyCode);
    }

    private void initialize() {
        Pane pane = gameEngine.getPane();

        pane.setOnKeyPressed(event -> {
            if (!keysPressed.contains(event.getCode())) {
                keysPressed.add(event.getCode());
            }
        });

        pane.setOnKeyReleased(event -> {
            if (keysPressed.contains(event.getCode())) {
                keysPressed.remove(event.getCode());
            }
        });
    }

    public void refresh() {}

}
