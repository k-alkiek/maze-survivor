package gun;

import java.util.Stack;

import character.Player;

/**
 * Pool of bullets following the Pool Design Pattern.
 * 
 * @author H
 *
 */
public class BulletPool {

	private static BulletPool instance;

	private static Player shooter;

	public static BulletPool getInstance(Player shooterIn) {
		if (BulletPool.instance == null || shooter != shooterIn) {
			shooter = shooterIn;
			BulletPool.instance = new BulletPool();
		}
		return BulletPool.instance;
	}

	private final Stack<Bullet> pool;

	private BulletPool() {
		pool = new Stack<>();
	}

	public Bullet acquireReusable() {
		if (pool.isEmpty()) {
			return new Bullet(shooter.getGameEngine());
		} else {
			return pool.pop();
		}
	}

	public void releaseReusable(final Bullet returned) {
		pool.add(returned);
	}
}
