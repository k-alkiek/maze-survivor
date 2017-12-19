package pickup;

import game.GameManager;

/**
 * @author H
 *
 */
public class FoodPickup extends Pickup {

	private static final int FOOD_VALUE = 250;

	public FoodPickup(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public void onPickup() {
		gameManager.increaseFood(FOOD_VALUE);
		picked = true;
	}

}
