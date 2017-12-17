package objects;

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
	public boolean collidesWith(final CollidableGameObject other) {
		return graphics.intersects(other.getGraphics().getBoundsInLocal());
	}

	/**
	 * @return the fxShape
	 */
	public final ImageView getGraphics() {
		return graphics;
	}

}
