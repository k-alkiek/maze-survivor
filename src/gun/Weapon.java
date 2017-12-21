package gun;

import characters.Player;
import game.GameEngine;
import javafx.scene.media.AudioClip;
import java.io.File;
import java.net.URI;

/**
 * For different types of guns.
 * 
 * @author H
 *
 */
public abstract class Weapon {

	private final static AudioClip RELOAD_SOUND = new AudioClip(new File("src/assets/player/sounds/reload.wav").toURI().toString());
	private final static AudioClip SHOT_SOUND = new AudioClip(new File("src/assets/player/sounds/shot.aiff").toURI().toString());

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

		GameEngine.getInstanceOf().getSoundHandler().playSound(SHOT_SOUND, 0.5, true);
	}

	/**
	 * Reloads the gun and updates the magazine.
	 */
	public final void reload() {
        GameEngine.getInstanceOf().getSoundHandler().playSound(RELOAD_SOUND, 0.5, false);
		System.out.println("In pistol reload");
		if (cooling) {
			if (coolingNow()) {
				System.out.println("COOLING. CAN'T RELOAD.");
				return;
			}
		}
		System.out.println("OK I'LL RELOAD");
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

	protected boolean coolingNow() {
		boolean check = lastReloadTime + RELOAD_COOLDOWN > System.currentTimeMillis() || lastFireTime + FIRE_COOLDOWN > System.currentTimeMillis();
		if (!check) {
			cooling = false;
		}
		return check;
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
