package mine;

import game.GameManager;

/**
 * Easy mines factory that generates easy destroyable mines affecting score more than health.
 * @author H
 *
 */
public class MineEasyFactory extends AbstractMineFactory {

	public MineEasyFactory(GameManager gameManager) {
		super(gameManager);
		healthProb = 0.3;
		bigProb = 0.2;
		destroyableProb = 1.0;
	}

}
