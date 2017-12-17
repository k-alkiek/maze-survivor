package mine;

import game.GameManager;

/**
 * The factory that generates mines in the maze.
 * Probability of generating a health mine = healthProb.
 * Probability of generating a score mine = 1 - healthProb.
 * Probability of generating an fixed mine = 1.0 - destroyableProb.
 * Probability of generating a big mine = bigProb.
 * Probability of generating a small mine = destroyableProb - bigProb.
 * @author H
 *
 */
public abstract class AbstractMineFactory {

	protected GameManager gameManager;

	protected double healthProb;

	protected double bigProb;

	protected double destroyableProb;

	public AbstractMineFactory(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	public final Mine createMine(double x, double y) {
		double rand = Math.random();
		if (rand < healthProb) {
			return createHealthMine(x, y);
		} else {
			return createScoreMine(x, y);
		}
	}

	protected Mine createHealthMine(double x, double y) {
		double rand = Math.random();
		if (rand < destroyableProb) {
			if (rand < bigProb) {
				return new BigHealthMine(gameManager, x, y);
			} else {
				return new SmallHealthMine(gameManager, x, y);
			}
		} else {
			return new FixedHealthMine(gameManager, x, y);
		}
	}

	protected Mine createScoreMine(double x, double y) {
		double rand = Math.random();
		if (rand < destroyableProb) {
			if (rand < bigProb) {
				return new BigScoreMine(gameManager, x, y);
			} else {
				return new SmallScoreMine(gameManager, x, y);
			}
		} else {
			return new FixedScoreMine(gameManager, x, y);
		}
	}

}
