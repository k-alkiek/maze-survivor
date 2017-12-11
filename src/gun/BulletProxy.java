package gun;

/**
 * Proxy for bullet representing a bullet in the player's magazine before firing.
 * Following the Proxy design pattern.
 * @author H
 *
 */
public class BulletProxy {

	public void fire() {
		BulletPool pool = BulletPool.getInstance();
		Bullet firedBullet = pool.acquireReusable();
		firedBullet.setOnFire(true);
	}

}
