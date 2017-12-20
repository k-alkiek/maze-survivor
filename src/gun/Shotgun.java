package gun;

import characters.Player;
import game.GameEngine;

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

	public Shotgun(final int bullets) {
		shooter = GameEngine.getInstanceOf().getPlayer();
		mag = new InGunMag(shooter, this, Shotgun.MAG_SIZE);
		this.bullets = bullets;
		ranged = true;
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
