package pickup;

import game.GameEngine;
import game.GameManager;
import objects.CollidableGameObject;
import objects.Destructible;

/**
 * @author H
 *
 */
public abstract class Pickup extends CollidableGameObject implements Destructible {

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
			System.out.println("PICKED ANND DESTROYIIINGNGNGG HAHAAHHAHAHA!!!");
			gameManager.getGameEngine().destroyGameObject(this);
		} else if (this.collidesWith(gameManager.getPlayer())) {
			onPickup();
		}
	}

	public abstract void onPickup();

	@Override
	public void hit(int damage) {
		gameEngine.destroyGameObject(this);
	}

}
