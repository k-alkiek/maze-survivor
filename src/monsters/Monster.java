package monsters;

import game.GameEngine;
import javafx.scene.image.Image;
import monsters.states.MonsterIdleState;
import monsters.states.MonsterState;
import monsters.states.MonsterWalkingState;
import objects.CollidableGameObject;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class Monster extends CollidableGameObject {
    // monster have an instance of Monster State -> currentState
    private MonsterState currentState;
    // and have a sprite image
    private Image sprite;

    public Monster(GameEngine gameEngine, int x, int y) {
        super(gameEngine, x, y);
        currentState = new MonsterWalkingState();
        imageView.setFitWidth(250);
    }

    @Override
    public void update() {
        angle = Math.toDegrees(Math.atan2(-1 * imageView.getY(), -1 * imageView.getX()));
        imageView.setRotate(angle);
        currentState.update(this);
        draw(sprite);
        if (this.getX() < 0) {
            this.setX(800);
            this.setY(800);
        }
    }

    // method to set current sprite
    public void setCurrentState(MonsterState currentState) {
        this.currentState = currentState;
    }

    // method to set current state
    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
}
