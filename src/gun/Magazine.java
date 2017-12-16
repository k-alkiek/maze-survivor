package gun;

import java.util.Stack;

import character.Player;

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
		final BulletProxy fired = bullets.pop();
		fired.fire(shooter);
	}

	public abstract int reload();

	public abstract int reload(int leftBullets);

}
