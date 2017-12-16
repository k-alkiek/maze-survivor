package gun;

import character.Player;

/**
 * Magazine of a shotgun.
 * 
 * @author H
 *
 */
public class InGunMag extends Magazine {


	public InGunMag(Player shooter, Weapon weapon, int gunMagSize) {
		super(shooter, weapon, gunMagSize);
	}

	@Override
	public int reload() {
		final int usedBullets = objectsPool.size();
		while (!objectsPool.isEmpty()) {
			bullets.push(objectsPool.pop());
		}
		return usedBullets;
	}

	@Override
	public int reload(int leftBullets) {
		int usedBullets = 0;
		while (!objectsPool.isEmpty() && leftBullets-- != 0) {
			bullets.push(objectsPool.pop());
			usedBullets++;
		}
		return usedBullets;
	}

	@Override
	public String toString() {
		return "In-Gun Magazine";
	}

}
