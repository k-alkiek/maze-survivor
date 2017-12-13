package characters;

import characters.states.IdleState;
import characters.states.State;
import game.GameEngine;
import gun.Weapon;
import objects.*;

/**
 * Class representing the player of the game.
 * 
 * @author H
 *
 */
public class Player extends CollidableGameObject {
	private Weapon weapon;

	private State currentState;

	public Player(GameEngine gameEngine, double x, double y, Weapon weapon) {
		super(gameEngine, x, y);
		this.weapon = weapon;
		currentState = new IdleState();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

}
