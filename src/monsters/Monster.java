package monsters;

import game.DBLogger;
import game.GameEngine;
import game.GameManager;
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
    private GameManager gameManager;


    public Monster(GameManager gameManager, int x, int y) {
        super(GameEngine.getInstanceOf(), x, y);
        this.gameManager = gameManager;
    	DBLogger.getInstance().log.info(this.getClass().getSimpleName() + " created.");
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
        if (collidedWithPlayer()) {
        	//TODO:LOG.
        }
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
            gameManager.decreaseHealth(1);
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
