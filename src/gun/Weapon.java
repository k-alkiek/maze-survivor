package gun;

/**
 * For different types of guns.
 * @author H
 *
 */
public interface Weapon {
	/**
	 * Reloads the gun and updates the magazine.
	 */
	public void reload();

	/**
	 * Fires the gun.
	 */
	public void fire();
}
