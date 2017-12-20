package gun;

import java.util.Stack;

import characters.Player;

/**
 * Magazine holding the bullets inside the player's gun.
 * 
 * @author H
 *
 */
public abstract class Magazine {

	protected Weapon weapon;
	protected Player shooter;
	protected int magSize;

	protected Stack<BulletProxy> bullets;
	protected Stack<BulletProxy> objectsPool;

	public Magazine(final Player shooter, final Weapon weapon, int gunMagSize) {
		this.weapon = weapon;
		this.shooter = shooter;
		magSize = gunMagSize;
		bullets = new Stack<>();
		objectsPool = new Stack<>();
		while (gunMagSize-- != 0) {
			objectsPool.push(new BulletProxy(weapon));
		}
	}

	public void fire() {
		if (!bullets.isEmpty()) {
			final BulletProxy fired = bullets.pop();
			fired.fire(shooter);
		} else {
			reload();
		}
	}

	public abstract int reload();

	public abstract int reload(int leftBullets);

	/**
	 * @return the magSize
	 */
	public int getMagSize() {
		return magSize;
	}

}
