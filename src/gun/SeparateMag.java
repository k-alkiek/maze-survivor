package gun;

import characters.Player;

/**
 * Represents the magazine that gets thrown on reload.
 * 
 * @author H
 *
 */
public class SeparateMag extends Magazine {

	public SeparateMag(Player shooter, int gunMagSize) {
		super(shooter, gunMagSize);
	}

	@Override
	public int reload() {
		while (!objectsPool.isEmpty()) {
			bullets.push(objectsPool.pop());
		}
		return magSize;
	}

	@Override
	public int reload(final int leftBullets) {
		while (!objectsPool.isEmpty()) {
			bullets.push(objectsPool.pop());
		}
		return leftBullets;
	}

	@Override
	public String toString() {
		return "Separate Magazine";
	}

}
