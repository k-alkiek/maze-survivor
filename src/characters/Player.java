package characters;

import characters.states.*;
import game.GameEngine;
import game.Keyboard;
import game.Mouse;
import gun.Weapon;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import objects.*;

/**
 * Class representing the player of the game.
 *
 * @author H
 */
public class Player extends CollidableGameObject {
    private Weapon weapon;
    private State currentState;
    private String choosingCharacter = "handgun";
    private int speed = 5;

    public Player(GameEngine gameEngine, double x, double y) {
        super(gameEngine, x, y);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.toFront();
        System.out.println(imageView.getBoundsInLocal());
        StatesPool.setStatesPool(choosingCharacter);
        currentState = StatesPool.getNextState("IdleState");
    }

    @Override
    public void update() {
        //imageView.setFitWidth(250);

        Mouse mouse = gameEngine.getMouse();
        // TODO REFACTOR khaled barie
//        angle = Math.toDegrees(Math.atan2(mouse.getY() - imageView.getY(), mouse.getX() - imageView.getX()));
        Keyboard keyboard =  Keyboard.getInstanceOf();
        if (keyboard.isPressed(KeyCode.W))
            angle = 270;
        else if (keyboard.isPressed(KeyCode.D))
            angle = 0;
        else if (keyboard.isPressed(KeyCode.A))
            angle = 180;
        else if (keyboard.isPressed(KeyCode.S))
            angle = 90;
        imageView.setRotate(angle);
        currentState.update(this);
        draw(image);
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    /**
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getSpeed() {
        return speed;
    }

    public void setChoosingCharacter(String choosingCharacter) {
        this.choosingCharacter = choosingCharacter;
    }
}
