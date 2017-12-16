package gun;

import character.Player;

/**
 * Proxy for bullet representing a bullet in the player's magazine before
 * firing. Following the Proxy design pattern.
 * 
 * @author H
 *
 */
public class BulletProxy {

	private Weapon weapon;

	public BulletProxy(Weapon weapon) {
		this.weapon = weapon;
	}

	public void fire(Player shooter) {
		final BulletPool pool = BulletPool.getInstance(shooter);
		final Bullet firedBullet = pool.acquireReusable();
		firedBullet.fire(shooter, weapon);
	}

}
