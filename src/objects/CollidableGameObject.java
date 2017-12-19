package objects;

import java.util.List;

import game.GameEngine;
import javafx.scene.image.ImageView;

/**
 * Represents a game object that may collide with other objects.
 *
 * @author H
 *
 */
public abstract class CollidableGameObject extends GameObject {

	/**
	 * Representation of the javafx shape used for handling collisions.
	 */
	protected ImageView graphics;

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
	public synchronized boolean collidesWith(final GameObject other) {
		System.out.println("in11111111111");
		return this.getImageView().getBoundsInParent().intersects(other.getImageView().getBoundsInParent());
	}
	
	public synchronized boolean isCollided() {
		List<GameObject> gameObjects = gameEngine.getGameObjects();
		for (GameObject gameObject : gameObjects) {
			if (this != gameObject && this.collidesWith(gameObject)) {
				System.out.println("in22222222222");
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the fxShape
	 */
	public final ImageView getGraphics() {
		return graphics;
	}

}
