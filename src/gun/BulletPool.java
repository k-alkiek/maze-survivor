package gun;

import java.util.Stack;

/**
 * Pool of bullets following the Pool Design Pattern.
 * @author H
 *
 */
public class BulletPool {

	private static final int BULLET_POOL_SIZE = 3;
	private static BulletPool instance;
	private Stack<Bullet> pool;

	private BulletPool() {
		pool = new Stack<Bullet>();
		for (int i = 0; i < BULLET_POOL_SIZE; i++) {
			pool.add(new Bullet());
		}
	}

	public static BulletPool getInstance() {
		if (instance == null) {
			instance = new BulletPool();
		}
		return instance;
	}

	public void releaseReusable(final Bullet returned) {
		pool.add(returned);
	}

	public Bullet acquireReusable() {
		if (pool.isEmpty()) {
			return null;
		} else {
			return pool.pop();
		}
	}
}
