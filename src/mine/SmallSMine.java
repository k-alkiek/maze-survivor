package mine;

import game.GameEngine;
import objects.CollidableGameObject;

/**
 * Small score mine.
 * 
 * @author H
 *
 */
public class SmallSMine extends CollidableGameObject implements ScoreMine {

	private static final int SCORELOST = 10;

	public SmallSMine(GameEngine gameEngine) {
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
