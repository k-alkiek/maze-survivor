package gun;

import characters.Player;

/**
 * Proxy for bullet representing a bullet in the player's magazine before
 * firing. Following the Proxy design pattern.
 * 
 * @author H
 *
 */
public class BulletProxy {

	public void fire(Player shooter) {
		final BulletPool pool = BulletPool.getInstance(shooter);
		final Bullet firedBullet = pool.acquireReusable();
		firedBullet.fire(shooter);
	}

}
