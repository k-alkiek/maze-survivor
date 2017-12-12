package gun;

/**
 * For different types of guns.
 * 
 * @author H
 *
 */
public interface Weapon {
	/**
	 * Fires the gun.
	 */
	public void fire();

	/**
	 * Reloads the gun and updates the magazine.
	 */
	public void reload();
}
