package pickup;

import game.GameEngine;
import game.GameManager;
import objects.CollidableGameObject;

/**
 * @author H
 *
 */
public abstract class Pickup extends CollidableGameObject {

	/**
	 * Determines whether the object is picked yet.
	 * Normally set to true in onPickup method.
	 */
	protected boolean picked;

	protected GameManager gameManager;

	public Pickup(GameManager gameManager, double x, double y) {
		super(gameManager.getGameEngine(), x, y);
		this.gameManager = gameManager;
	}

	@Override
	public void update() {
		if (picked) {
			gameManager.getGameEngine().destroyGameObject(this);
		}
	}

	public abstract void onPickup();

}
