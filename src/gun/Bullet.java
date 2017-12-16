package gun;

import characters.Player;
import game.GameEngine;
import objects.CollidableGameObject;

/**
 * A single fired bullet.
 * 
 * @author H
 *
 */
public class Bullet extends CollidableGameObject {

	/**
	 * Flag for whether this bullet is on action for collision with something.
	 */
	private boolean onFire;

	public Bullet(GameEngine gameEngine) {
		super(gameEngine);
		// TODO: Make fxShape.
	}

	public void fire(Player shooter, Weapon weapon) {
		x = shooter.getX();
		y = shooter.getY();
		angle = shooter.getAngle();
		onFire = true;
		//TODO: Set damage.
	}

	/**
	 * @return the onFire
	 */
	public final boolean isOnFire() {
		return onFire;
	}

	@Override
	public void update() {
		if (onFire) {
			// TODO Check if the bullet hit any other collidable object.
		}
	}

}
