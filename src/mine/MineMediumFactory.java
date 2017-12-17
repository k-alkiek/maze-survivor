package mine;

import game.GameManager;

/**
 * @author H
 *
 */
public class MineMediumFactory extends AbstractMineFactory {

	public MineMediumFactory(GameManager gameManager) {
		super(gameManager);
		healthProb = 0.5;
		bigProb = 0.5;
		destroyableProb = 0.8;
	}

}
