package gun;

import java.util.Stack;

/**
 * Magazine holding the bullets inside the player's gun.
 * 
 * @author H
 *
 */
public abstract class Magazine {

	protected int magSize;
	protected Stack<BulletProxy> bullets;
	protected Stack<BulletProxy> objectsPool;

	public Magazine(int gunMagSize) {
		magSize = gunMagSize;
		bullets = new Stack<>();
		objectsPool = new Stack<>();
		while (gunMagSize-- != 0) {
			objectsPool.push(new BulletProxy());
		}
	}

	public void fire() {
		final BulletProxy fired = bullets.pop();
		fired.fire();
	}

	public abstract int reload();

	public abstract int reload(int leftBullets);

}
