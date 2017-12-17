package mine;

import game.GameManager;

/**
 * Fixed score mine that constantly decreases score of the passing player.
 * @author H
 *
 */
public class FixedScoreMine extends ScoreMine {

	public FixedScoreMine(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
		destroyable = false;
	}

	@Override
	public int getDamage() {
		return 1;
	}

}
