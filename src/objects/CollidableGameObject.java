package objects;

import game.GameEngine;
import javafx.scene.shape.Shape;

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
	protected Shape fxShape;

	public CollidableGameObject (GameEngine gameEngine) {
		super(gameEngine);
	}

	public CollidableGameObject (GameEngine gameEngine, double x, double y) {
		super(gameEngine, x, y);
	}

	/**
	 * Checks whether this game object collides with another game object.
	 *
	 * @param other
	 * @return
	 */
	public boolean collidesWith(final CollidableGameObject other) {
		return fxShape.intersects(other.getFxShape().getBoundsInLocal());
	}

	/**
	 * @return the fxShape
	 */
	public final Shape getFxShape() {
		return fxShape;
	}

}
