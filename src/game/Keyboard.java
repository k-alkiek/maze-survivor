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
    private static Keyboard keyboard;
    public List<KeyCode> keysPressed;

    private Keyboard() {
        this.keysPressed = new ArrayList<>();
    }

    public static Keyboard getInstanceOf() {
        if (keyboard == null) {
            keyboard = new Keyboard();
        }
        return keyboard;
    }

    /**
     * @return a list of all keys that are currently pressed
     */
    public List<KeyCode> getKeysPressed() {
        return keysPressed;
    }

    /**
     * Checks if a key on the keyboard is currently pressed
     *
     * @param keyCode KeyCode of the key to be checked
     */
    public boolean isPressed(KeyCode keyCode) {
        return keysPressed.contains(keyCode);
    }

    public void initialize(Pane pane) {
        pane.setOnKeyPressed(event -> {
            if (!keysPressed.contains(event.getCode())) {
                keysPressed.add(event.getCode());
            }
            event.consume();
        });

        pane.setOnKeyReleased(event -> {
            if (keysPressed.contains(event.getCode())) {
                keysPressed.remove(event.getCode());
            }
            event.consume();
        });
    }

    public void refresh() {
    }

}
