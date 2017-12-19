package pickup;

import game.GameManager;

/**
 * Increases the number of bullets the player has by half of a mag.
 * @author H
 *
 */
public class BulletPickup extends Pickup {

	public BulletPickup(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public void onPickup() {
		gameManager.increaseBullets();
		picked = true;
	}

}
