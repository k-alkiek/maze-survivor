package objects;

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

	/**
	 * Checks whether this game object collides with another game object.
	 * 
	 * @param other
	 * @return
	 */
	public boolean collidesWith(CollidableGameObject other) {
		return fxShape.intersects(other.getFxShape().getBoundsInLocal());
	}

	/**
	 * @return the fxShape
	 */
	public final Shape getFxShape() {
		return fxShape;
	}

}
