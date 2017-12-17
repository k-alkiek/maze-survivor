package pickup;

import game.GameManager;
import mine.BigHealthMine;
import mine.BigScoreMine;
import mine.FixedHealthMine;
import mine.FixedScoreMine;
import mine.Mine;
import mine.SmallHealthMine;
import mine.SmallScoreMine;

/**
 * The factory that generates pickups in the maze.
 * Probability of generating a food pickup = foodProb.
 * Probability of generating a health pickup = healthProb.
 * Probability of generating a damage boost pickup = damageBoostProb.
 * Probability of generating a score pickup = 1.0 - (foodProb + healthProb + damageBoostProb).
 * @author H
 *
 */
public class AbstractPickupFactory {

	protected GameManager gameManager;

	protected double foodProb;

	protected double healthProb;

	protected double damageBoostProb;

	public AbstractPickupFactory(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	public final Pickup createPickup(double x, double y) {
		double rand = Math.random();
		if (rand < foodProb) {
			return new FoodPickup(gameManager, x, y);
		} else if (rand < foodProb + healthProb) {
			return new HealthPickup(gameManager, x, y);
		} else if (rand < foodProb + healthProb + damageBoostProb) {
			return new DamageBoostPickup(gameManager, x, y);
		} else {
			return new ScorePickup(gameManager, x, y);
		}
	}

}
