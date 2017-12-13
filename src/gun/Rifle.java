package gun;

import characters.Player;

/**
 * Rifle gun.
 * 
 * @author H
 *
 */
public class Rifle extends Weapon {

	/**
	 * Full damage.
	 */
	private final static int DAMAGE = 70;

	/**
	 * Size of the full magazine.
	 */
	private final static int MAG_SIZE = 10;

	public Rifle(final Player shooter, final int bullets) {
		super(shooter);
		mag = new SeparateMag(shooter, this, Rifle.MAG_SIZE);
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
		} else if (bullets > Rifle.MAG_SIZE) {
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
		return "Rifle";
	}

}
