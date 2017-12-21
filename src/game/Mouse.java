package game;

import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 12/15/17.
 * Handles mouse input in the game.
 */
public final class Mouse {
    private static Mouse mouse;

    private List<MouseButton> buttonsPressed;

    private double x;
    private double y;

    private boolean isScrollingUp;
    private boolean isScrollingDown;

    private Mouse() {
        this.x = 0;
        this.y = 0;
        this.isScrollingUp = false;
        this.isScrollingDown = false;
        this.buttonsPressed = new ArrayList<>();
    }

    public static Mouse getInstanceOf() {
        if (mouse == null) {
            mouse = new Mouse();
        }
        return mouse;
    }

    /**
     * @return current X position of the mouse
     */
    public double getX() {
        return x;
    }

    /**
     * @return current Y position of the mouse
     */
    public double getY() {
        return y;
    }

    /**
     * @return a list of all mouse buttons that are currently pressed
     */
    public List<MouseButton> getButtonsPressed() {
        return buttonsPressed;
    }

    /**
     * Checks if a mouse button is currently pressed
     *
     * @param mouseButton KeyCode of the key to be checked
     */
    public boolean isPressed(MouseButton mouseButton) {
        return buttonsPressed.contains(mouseButton);
    }

    public boolean isScrollingUp() {
        return isScrollingUp;
    }

    public boolean isScrollingDown() {
        return isScrollingDown;
    }

    public void initialize(Pane hUDPane) {
        hUDPane.setOnMouseMoved(event -> {
            x = event.getX();
            y = event.getY();
            event.consume();
        });
        hUDPane.setOnMouseDragged(event -> {
            x = event.getX();
            y = event.getY();
            event.consume();
        });
        hUDPane.setOnMousePressed(event -> {
            if (!buttonsPressed.contains(event.getButton())) {
                buttonsPressed.add(event.getButton());
            }
            event.consume();
        });
        hUDPane.setOnMouseReleased(event -> {
            if (buttonsPressed.contains(event.getButton())) {
                buttonsPressed.remove(event.getButton());
            }
            event.consume();
        });

        hUDPane.setOnScroll(event -> {
            if (event.getDeltaY() < 0) {
                isScrollingDown = true;
                isScrollingUp = false;
            } else if (event.getDeltaY() > 0) {
                isScrollingDown = false;
                isScrollingUp = true;
            }
            event.consume();
        });
    }

    public void refresh() {
        isScrollingDown = false;
        isScrollingUp = false;
    }


}
