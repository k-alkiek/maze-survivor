package gun;

import characters.Player;
import game.GameEngine;

/**
 * Rifle gun.
 * 
 * @author H
 *
 */
public class Pistol extends Weapon {

	/**
	 * Full damage.
	 */
	private final static int DAMAGE = 60;

	/**
	 * Size of the full magazine.
	 */
	private final static int MAG_SIZE = 10;

	public Pistol(final int bullets) {
		shooter = GameEngine.getInstanceOf().getPlayer();
		mag = new SeparateMag(shooter, this, Pistol.MAG_SIZE);
		this.bullets = bullets;
		ranged = false;
	}

	@Override
	public int getDamage() {
		return DAMAGE;
	}

	@Override
	public String toString() {
		return "Pistol";
	}

}
