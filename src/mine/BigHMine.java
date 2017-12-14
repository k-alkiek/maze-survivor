package mine;

import game.GameEngine;
import objects.CollidableGameObject;

/**
 * Big health mine.
 * @author H
 *
 */
public class BigHMine extends CollidableGameObject implements HealthMine {

	public BigHMine(GameEngine gameEngine) {
		super(gameEngine);
		// TODO Auto-generated constructor stub
	}

	private final static int DAMAGE = 100;

	@Override
	public int getDamage() {
		return DAMAGE;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
