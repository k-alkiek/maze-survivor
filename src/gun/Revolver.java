package gun;

import character.Player;

/**
 * 
 * @author H
 *
 */
public class Revolver extends Weapon {

	/**
	 * Full damage.
	 */
	private final static int DAMAGE = 100;

	/**
	 * Size of the full magazine.
	 */
	private final static int MAG_SIZE = 6;

	public Revolver(final Player shooter, final int bullets) {
		super(shooter);
		mag = new InGunMag(shooter, this, Revolver.MAG_SIZE);
		this.bullets = bullets;
		ranged = false;
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

	public void addBullets(final int addedBullets) {
		bullets += addedBullets;
	}

	@Override
	public int getDamage() {
		return DAMAGE;
	}

	@Override
	public String toString() {
		return "Revolver";
	}

}
