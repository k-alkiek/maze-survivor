package gun;

import characters.Player;

/**
 * For different types of guns.
 * 
 * @author H
 *
 */
public abstract class Weapon {

	protected final static long FIRE_COOLDOWN = 250;

	protected final static long RELOAD_COOLDOWN = 1500;

	protected boolean cooling;

	protected long lastReloadTime;

	protected long lastFireTime;

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

	protected boolean coolingNow() {
		boolean check = lastReloadTime + RELOAD_COOLDOWN > System.currentTimeMillis() || lastFireTime + FIRE_COOLDOWN > System.currentTimeMillis();
		if (!check) {
			cooling = false;
		}
		return check;
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
	public final void fire() {
		if (cooling) {
			if (coolingNow()) {
				return;
			}
		}
		lastFireTime = System.currentTimeMillis();
		cooling = true;
		mag.fire();
	}

	/**
	 * Reloads the gun and updates the magazine.
	 */
	public final void reload() {
		System.out.println("In pistol reload");
		if (cooling) {
			if (coolingNow()) {
				System.out.println("COOLING. CAN'T RELOAD.");
				return;
			}
		}
		cooling = true;
		lastReloadTime = System.currentTimeMillis();
		if (bullets == 0) {
			// TODO: RELOADING DOESN'T WORK.
			System.out.println("No ammo.");
		} else if (bullets > mag.getMagSize()) {
			bullets -= mag.reload();
		} else {
			bullets -= mag.reload(bullets);
		}
	}

	public void addBullets(final int addedBullets) {
		bullets += addedBullets;
	}

	/**
	 * @param bullets the bullets to set
	 */
	public void setBullets(Integer bullets) {
		this.bullets = bullets;
	}

	public int getBulletsInMag() {
		return mag.getBulletsInMag();
	}

	/**
	 * @return the shooter
	 */
	public Player getShooter() {
		return shooter;
	}

	
}
