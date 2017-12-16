package game;

import characters.Player;

/**
 * Manages the game in terms of win/loss and score.
 * @author H
 *
 */
public class GameManager {

	private GameEngine gameEngine;

	private Player player;

	private int score;

	public GameManager(GameEngine gameEngine, Player player) {
		this.gameEngine = gameEngine;
		this.player = player;
	}

	public void incrementScore(int addedScore) {
		score += addedScore;
	}

	public void incrementHealth(int addedHealth) {
		player.incrementHealth(addedHealth);
	}

	public GameEngine getGameEngine() {
		return gameEngine;
	}

}
