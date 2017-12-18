package pickup;

import game.GameManager;

/**
 * Pickups generator factory for ninja difficulty mode.
 * @author H
 *
 */
public class PickupNinjaFactory extends AbstractPickupFactory {

	public PickupNinjaFactory(GameManager gameManager) {
		super(gameManager);
		foodProb = 0.15;
		healthProb = 0.08;
		damageBoostProb = 0.05;
	}

}
