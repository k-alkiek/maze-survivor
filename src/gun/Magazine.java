package gun;

import java.util.Stack;

/**
 * Magazine holding the bullets inside the player's gun.
 * @author H
 *
 */
public class Magazine {
	private int magSize;
	private Stack<BulletProxy> bullets;

	public Magazine(int gunMagSize) {
		magSize = gunMagSize;
	}

	public void fire() {
		BulletProxy fired = bullets.pop();
		fired.fire();
	}
}
