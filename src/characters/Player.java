package characters;

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

	public Player(double x, double y, Weapon weapon) {
		super(x, y);
		this.weapon = weapon;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
