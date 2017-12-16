package gun;

import characters.Player;

/**
 * 
 * @author H
 *
 */
public class Shotgun extends Weapon {

	/**
	 * Full damage.
	 */
	private final static int DAMAGE = 300;

	/**
	 * Size of the full magazine.
	 */
	private final static int MAG_SIZE = 7;

	public Shotgun(final Player shooter, final int bullets) {
		super(shooter);
		mag = new InGunMag(shooter, Shotgun.MAG_SIZE);
		this.bullets = bullets;
		ranged = true;
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
		} else if (bullets > Shotgun.MAG_SIZE) {
			bullets -= mag.reload();
		} else {
			bullets -= mag.reload(bullets);
		}
	}

	@Override
	public String toString() {
		return "Shotgun";
	}

	@Override
	public int getDamage() {
		return DAMAGE;
	}

}
