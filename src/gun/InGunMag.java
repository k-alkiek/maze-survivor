package gun;

/**
 * Magazine of a shotgun.
 * @author H
 *
 */
public class InGunMag extends Magazine {

	public InGunMag(int gunMagSize) {
		super(gunMagSize);
	}

	@Override
	public int reload() {
		int usedBullets = objectsPool.size();
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

}
