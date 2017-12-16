package game;

import characters.Player;
import gun.Weapon;

/**
 * Manages the game in terms of win/loss and score.
 * @author H
 *
 */
public class GameManager {

	private GameEngine gameEngine;

	private Player player;

	private Integer score;

	private Integer health;

	private Weapon weapon;

	/**
	 * Full is on 1000.
	 */
	private int food;

	public GameManager(GameEngine gameEngine, Player player) {
		this.gameEngine = gameEngine;
		this.player = player;
		food = 1000;
		weapon = gameEngine.getWeapon();
	}

	public void incrementScore(int addedScore) {
		score += addedScore;
	}

	public void incrementHealth(int addedHealth) {
		player.incrementHealth(addedHealth);
	}

	public void incrementFood(int addedFood) {
		food += addedFood;
	}

	public void incrementBullets() {
		weapon.setBullets(weapon.getBullets() + weapon.getMag().getMagSize() / 2);
	}

	public GameEngine getGameEngine() {
		return gameEngine;
	}

}
