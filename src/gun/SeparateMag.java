package gun;

/**
 * Represents the magazine that gets thrown on reload.
 * @author H
 *
 */
public class SeparateMag extends Magazine {

	public SeparateMag(int gunMagSize) {
		super(gunMagSize);
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
		while (!objectsPool.isEmpty()) {
			bullets.push(objectsPool.pop());
		}
		return leftBullets;
	}

}
