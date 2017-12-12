package gun;

/**
 * Gun with magazines carried by the player.
 * 
 * @author H
 *
 */
public class Revolver implements Weapon {

	/**
	 * Size of the full magazine.
	 */
	private final static int MAG_SIZE = 6;

	/**
	 * Number of available bullets.
	 */
	private int bullets;

	private final Magazine mag;

	public Revolver(final int bullets) {
		mag = new InGunMag(Revolver.MAG_SIZE);
		this.bullets = bullets;
	}

	@Override
	public void fire() {
		mag.fire();
	}

	@Override
	public void reload() {
		// TODO: Fix reload time and make reloading state.
		if (bullets == 0) {
			// TODO: RELOADING DOESN'T WORK.
		} else if (bullets > Revolver.MAG_SIZE) {
			bullets -= mag.reload();
		} else {
			bullets -= mag.reload(bullets);
		}
	}

	@Override
	public String toString() {
		return "Revolver";
	}

}
