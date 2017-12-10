package gun;

/**
 * Gun with magazines carried by the player.
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

	private Magazine mag;

	public Revolver(final int bullets) {
		mag = new Magazine(MAG_SIZE);
		this.bullets = bullets;
	}

	@Override
	public void reload() {
		// TODO Fix reload time and make reloading state.
	}

	@Override
	public void fire() {
		mag.fire();
	}

}
