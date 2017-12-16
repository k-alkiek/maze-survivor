package character;

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

	private int health;

	public Player(GameEngine gameEngine, double x, double y, Weapon weapon) {
		super(gameEngine, x, y);
		this.weapon = weapon;
		health = 100;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void incrementHealth(int addedHealth) {
		health += addedHealth;
		if (health > 100) {
			health = 100;
		}
	}

}
