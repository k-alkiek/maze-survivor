package pickup;

import game.GameManager;

/**
 * Pickups generator factory for easy difficulty mode.
 * @author H
 *
 */
public class PickupEasyFactory extends AbstractPickupFactory {

	public PickupEasyFactory(GameManager gameManager) {
		super(gameManager);
		foodProb = 0.60;
		healthProb = 0.20;
		damageBoostProb = 0.15;
	}

}
