package mine;

import game.GameEngine;
import objects.CollidableGameObject;

/**
 * Big Score Mine.
 * 
 * @author H
 *
 */
public class BigSMine extends CollidableGameObject implements ScoreMine {
	private static final int SCORELOST = 50;

	public BigSMine(GameEngine gameEngine) {
		super(gameEngine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getScoreLost() {
		return SCORELOST;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
