package characters;

import characters.states.IdleState;
import characters.states.State;
import game.GameEngine;
import game.Keyboard;
import game.Mouse;
import gun.Weapon;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import objects.*;

import java.security.Key;

/**
 * Class representing the player of the game.
 *
 * @author H
 */
public class Player extends CollidableGameObject {
    private Weapon weapon;
    private State currentState;
    private Image sprite;

    public Player(GameEngine gameEngine, double x, double y, Weapon weapon) {
        super(gameEngine, x, y);
        this.weapon = weapon;
        currentState = new IdleState();

        imageView.setFitWidth(100);
        System.out.println(imageView.getBoundsInLocal());
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    @Override
    public void update() {
        int speed = 5;
        imageView.setFitWidth(250);
        Mouse mouse = gameEngine.getMouse();
        Keyboard keyboard = gameEngine.getKeyboard();

        if (keyboard.isPressed(KeyCode.W)) {
            y -= speed;
        }
        if (keyboard.isPressed(KeyCode.S)) {
            y += speed;
        }
        if (keyboard.isPressed(KeyCode.A)) {
            x -= speed;
        }
        if (keyboard.isPressed(KeyCode.D)) {
            x += speed;
        }
        // TODO REFACTOR khaled barie
        angle = Math.toDegrees(Math.atan2(mouse.getY() - imageView.getY(), mouse.getX() - imageView.getX()));
        imageView.setRotate(angle);
        currentState.update(this);
        draw(sprite);

    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

}
