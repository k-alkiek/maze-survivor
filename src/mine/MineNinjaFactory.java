package mine;

import game.GameManager;

/**
 * @author H
 *
 */
public class MineNinjaFactory extends AbstractMineFactory {

	public MineNinjaFactory(GameManager gameManager) {
		super(gameManager);
		healthProb = 0.9;
		bigProb = 0.9;
		destroyableProb = 0.3;
	}

}
