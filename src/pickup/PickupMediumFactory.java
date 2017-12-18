package pickup;

import game.GameManager;

/**
 * Pickups generator factory for medium difficulty mode.
 * @author H
 *
 */
public class PickupMediumFactory extends AbstractPickupFactory {

	public PickupMediumFactory(GameManager gameManager) {
		super(gameManager);
		foodProb = 0.40;
		healthProb = 0.20;
		damageBoostProb = 0.10;
	}

}
