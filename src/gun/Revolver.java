package gun;

import characters.Player;
import game.GameEngine;

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

	public Revolver(final int bullets) {
		shooter = GameEngine.getInstanceOf().getPlayer();
		mag = new InGunMag(shooter, this, Revolver.MAG_SIZE);
		this.bullets = bullets;
		ranged = false;
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
