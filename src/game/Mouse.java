package game;

import javafx.scene.input.MouseEvent;

/**
 * Created by khaled on 12/15/17.
 * Handles mouseEvent input in the game.
 */
public final class Mouse {
    private GameEngine gameEngine;

    private double x;
    private double y;

    public Mouse(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.x = 0;
        this.y = 0;
        initialize();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private void initialize() {
        gameEngine.getPane().setOnMouseMoved(event -> {
            x = event.getX();
            y = event.getY();
        });
    }
}
