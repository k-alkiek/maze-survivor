package game;

import characters.Player;
import gun.Weapon;
import objects.GameObject;

/**
 * Manages the game in terms of win/loss and score.
 * @author H
 *
 */
public class GameManager extends GameObject {

	private static final int MAX_HEALTH = 10000;

	private Player player;

	private int score;

	private int health;

	private Weapon weapon;

	/**
	 * Full is on 1000.
	 */
	private int food;

	public GameManager(GameEngine gameEngine, Player player) {
		super(gameEngine);
		this.player = player;
		food = MAX_HEALTH;
		weapon = player.getWeapon();
		health = MAX_HEALTH;
	}

	public void increaseScore(int addedScore) {
		score += addedScore;
	}

	public void increaseHealth(int addedHealth) {
		health += addedHealth;
		if (health > MAX_HEALTH) {
			health = MAX_HEALTH;
		}
	}

	public void increaseFood(int addedFood) {
		food += addedFood;
	}

	public void increaseBullets() {
		weapon.setBullets(weapon.getBullets() + weapon.getMag().getMagSize() / 2);
	}

	public void hungerEffect() {
		if (food > 0) {
			food -= 1;
		}
	}

	public void decreaseHealth(int decreasedHealth) {
		health -= decreasedHealth;
		if (health < 0) {
			health = 0;
		}
		if (health == 0) {
			lose();
		}
	}

	public void decreaseScore(int decreasedScore) {
		score -= decreasedScore;
	}
	
	
	public void lose() {
		//TODO: lose.
		System.out.println("YOU LOSE!");
	}

	
	public void win() {
		//TODO: win.
	}
	

	public GameEngine getGameEngine() {
		return gameEngine;
	}

	/**
	 * @return the maxHealth
	 */
	public static int getMaxHealth() {
		return MAX_HEALTH;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	@Override
	public void update() {
		hungerEffect();
		if (food == 0) {
			health -= 1;
		}
	}

}
