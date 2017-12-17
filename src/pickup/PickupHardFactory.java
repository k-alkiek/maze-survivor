package pickup;

import game.GameManager;

/**
 * Pickups generator factory for hard difficulty mode.
 * @author H
 *
 */
public class PickupHardFactory extends AbstractPickupFactory {

	public PickupHardFactory(GameManager gameManager) {
		super(gameManager);
		foodProb = 0.20;
		healthProb = 0.10;
		damageBoostProb = 0.08;
	}

}
