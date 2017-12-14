package mine;

import game.GameEngine;
import objects.CollidableGameObject;

/**
 * Small health mine.
 * @author H
 *
 */
public class SmallHMine extends CollidableGameObject implements HealthMine {

	public SmallHMine(GameEngine gameEngine) {
		super(gameEngine);
		// TODO Auto-generated constructor stub
	}

	private final static int DAMAGE = 50;

	

	@Override
	public int getDamage() {
		return DAMAGE;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
