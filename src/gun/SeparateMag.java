package gun;

import characters.Player;

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
	public int reload(int leftBullets) {
		while (bullets.size() < leftBullets) {
			bullets.push(objectsPool.pop());
		}
		while (bullets.size() > leftBullets) {
			objectsPool.push(bullets.pop());
		}
		return leftBullets;
	}

	@Override
	public String toString() {
		return "Separate Magazine";
	}

}
