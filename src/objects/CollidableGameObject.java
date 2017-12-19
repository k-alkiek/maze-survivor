package objects;

import java.util.List;

import game.GameEngine;
import javafx.scene.image.ImageView;
import mine.Mine;
import wall.Wall;

/**
 * Represents a game object that may collide with other objects.
 *
 * @author H
 */
public abstract class CollidableGameObject extends GameObject {


	public CollidableGameObject(GameEngine gameEngine) {
		super(gameEngine);
	}

	public CollidableGameObject(GameEngine gameEngine, double x, double y) {
		super(gameEngine, x, y);
	}


    /**
     * Checks whether this game object collides with another game object.
     *
     * @param other
     * @return
     */
    public boolean collidesWith(final GameObject other) {
        return this.getImageView().getBoundsInParent().intersects(other.getImageView().getBoundsInParent());
    }

	public boolean isCollided(final ImageView objectImage) {
		List<GameObject> gameObjects = gameEngine.getGameObjects();
		for (GameObject gameObject : gameObjects) {
			if (this != gameObject && Wall.class.isInstance(gameObject) && this.collides(objectImage, gameObject)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean collides(final ImageView objectColne, GameObject other) {
		return objectColne.getBoundsInLocal().intersects(other.getImageView().getBoundsInLocal());
	}

	/**
	 * @return the fxShape
	 */

}
