package gun;

import character.Player;
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

	/**
	 * The weapon to be fired.
	 */
	private Weapon weapon;

	public Bullet(GameEngine gameEngine) {
		super(gameEngine);
		this.weapon = gameEngine.getWeapon();
		// TODO: Make fxImage.
	}

	public void fire(Player shooter) {
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
