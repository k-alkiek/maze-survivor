package gun;

import character.Player;

/**
 * Represents the magazine that gets thrown on reload.
 * 
 * @author H
 *
 */
public class SeparateMag extends Magazine {

	public SeparateMag(Player shooter, Weapon weapon, int gunMagSize) {
		super(shooter, weapon, gunMagSize);
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
