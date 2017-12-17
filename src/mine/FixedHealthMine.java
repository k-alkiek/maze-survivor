package mine;

import game.GameManager;

/**
 * Fixed health mine that constantly damages health of the passing player.
 * @author H
 *
 */
public class FixedHealthMine extends ScoreMine {

	public FixedHealthMine(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
		destroyable = false;
	}

	@Override
	public int getDamage() {
		return 1;
	}

}
