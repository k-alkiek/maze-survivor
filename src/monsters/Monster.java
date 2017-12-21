package monsters;

import game.GameEngine;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import monsters.states.MonsterState;
import monsters.states.MonsterWalkingState;
import objects.CollidableGameObject;
import objects.Destructible;


/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class Monster extends CollidableGameObject implements Destructible {
    private MonsterState currentState;
    private static int speed = 3;
    private static int health = 100;

    public Monster(GameEngine gameEngine, int x, int y) {
        super(gameEngine, x, y);
        currentState = new MonsterWalkingState();
        imageView.setFitWidth(70);
    }

    @Override
    public void update() {
        imageView.setRotate(angle);
        currentState.update(this);
        imageView.setRotate(angle);
        imageView.toFront();
        draw(image);
        if (collidedWithPlayer())
            System.out.println("Die");
    }

    public void setCurrentState(MonsterState currentState) {
        this.currentState = currentState;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean collidedWithPlayer() {
        ImageView player = gameEngine.getPlayer().getImageView();
        if (player.getBoundsInLocal().intersects(this.getImageView().getBoundsInLocal())) {
            // player's health will affected by monster's damage factor
            return true;
        }
        return false;
    }

    @Override
    public void hit(int damage) {
        health -= damage;
        if (health <= 0)
            Platform.runLater(() -> gameEngine.destroyGameObject(this));
    }
}
