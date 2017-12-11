package gun;

import objects.CollidableGameObject;

/**
 * A single fired bullet.
 * @author H
 *
 */
public class Bullet extends CollidableGameObject {

	public Bullet() {
		//TODO: Make fxShape.
	}

	/**
	 * Flag for whether this bullet is on action for collision with something.
	 */
	private boolean onFire;

	/**
	 * @return the onFire
	 */
	public final boolean isOnFire() {
		return onFire;
	}

	/**
	 * @param onFire the onFire to set
	 */
	public final void setOnFire(boolean onFire) {
		this.onFire = onFire;
	}

	@Override
	public void update() {
		if (onFire) {
			// TODO Check if the bullet hit any other collidable object.
		}
	}

}
