package characters;

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

	public Player(GameEngine gameEngine, double x, double y, Weapon weapon) {
		super(gameEngine, x, y);
		this.weapon = weapon;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
