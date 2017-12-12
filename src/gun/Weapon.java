package gun;

import characters.Player;

/**
 * For different types of guns.
 * 
 * @author H
 *
 */
public abstract class Weapon {

	/**
	 * The player who owns and controls this weapon.
	 */
	private Player shooter;

	/**
	 * Number of available bullets.
	 */
	protected int bullets;

	/**
	 * The magazine in the weapon.
	 */
	protected Magazine mag;

	public Weapon(Player shooter) {
		this.shooter = shooter;
	}

	/**
	 * Fires the gun.
	 */
	public void fire() {
		mag.fire();
	}

	/**
	 * Reloads the gun and updates the magazine.
	 */
	public abstract void reload();
}
