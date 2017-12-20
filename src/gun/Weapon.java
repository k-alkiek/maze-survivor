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
	 * Number of available bullets.
	 */
	protected Integer bullets;

	/**
	 * The magazine in the weapon.
	 */
	protected Magazine mag;

	/**
	 * The player who owns and controls this weapon.
	 */
	protected Player shooter;

	/**
	 * Flag to whether the weapon's damage decays over distance.
	 */
	protected boolean ranged;

	/**
	 * @return the ranged
	 */
	public boolean isRanged() {
		return ranged;
	}

	/**
	 * @return the damage
	 */
	public abstract int getDamage();

	/**
	 * @return the bullets
	 */
	public Integer getBullets() {
		return bullets;
	}

	/**
	 * @return the mag
	 */
	public Magazine getMag() {
		return mag;
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

	/**
	 * @param bullets the bullets to set
	 */
	public void setBullets(Integer bullets) {
		this.bullets = bullets;
	}

	/**
	 * @return the shooter
	 */
	public Player getShooter() {
		return shooter;
	}

	
}
