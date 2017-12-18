package mine;

import game.GameManager;

/**
 * @author H
 *
 */
public class MineHardFactory extends AbstractMineFactory {

	public MineHardFactory(GameManager gameManager) {
		super(gameManager);
		healthProb = 0.7;
		bigProb = 0.7;
		destroyableProb = 0.6;
	}

}
