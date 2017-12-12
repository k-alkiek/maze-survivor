package gun;

import java.util.Stack;

/**
 * Pool of bullets following the Pool Design Pattern.
 * 
 * @author H
 *
 */
public class BulletPool {

	private static BulletPool instance;

	public static BulletPool getInstance() {
		if (BulletPool.instance == null) {
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
			return new Bullet();
		} else {
			return pool.pop();
		}
	}

	public void releaseReusable(final Bullet returned) {
		pool.add(returned);
	}
}
