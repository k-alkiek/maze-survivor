package characters;

import characters.states.IdleState;
import characters.states.State;
import game.GameEngine;
import game.Mouse;
import gun.Weapon;
import javafx.scene.image.Image;
import objects.*;

/**
 * Class representing the player of the game.
 *
 * @author H
 */
public class Player extends CollidableGameObject {
    private Weapon weapon;
    private State currentState;
    private Image sprite;


    private int speed = 5;

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
        imageView.setFitWidth(250);
        Mouse mouse = gameEngine.getMouse();
        // TODO REFACTOR khaled barie
        angle = Math.toDegrees(Math.atan2(mouse.getY() - imageView.getY(), mouse.getX() - imageView.getX()));
        imageView.setRotate(angle);
        currentState.update(this);
        draw(sprite);

    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getSpeed() {
        return speed;
    }
}
