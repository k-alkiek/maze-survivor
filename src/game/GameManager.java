package game;

import java.io.IOException;

import characters.Player;
import gun.Weapon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.GameObject;

/**
 * Manages the game in terms of win/loss and score.
 * @author H
 *
 */
public class GameManager extends GameObject {

	private static final int MAX_HEALTH = 1000;

	private Player player;

	private int score;

	private int health;

	private Weapon weapon;

	/**
	 * Full is on MAX_HEALTH.
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
		GameEngine.lastScore = score + health + food;
		try {
    		Stage stage = GameEngine.primaryStage;
    		Parent root = FXMLLoader.load(getClass().getResource("LoseScreen.fxml"));
    		gameEngine.getGameObjects().clear();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		System.out.println("YOU LOSE!");
	}

	
	public void win() {
		GameEngine.lastScore = score + health + food;
		try {
    		Stage stage = GameEngine.primaryStage;
    		Parent root = FXMLLoader.load(getClass().getResource("WinScreen.fxml"));
    		gameEngine.getGameObjects().clear();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
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

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return the food
	 */
	public int getFood() {
		return food;
	}

	@Override
	public void update() {
		hungerEffect();
		if (food == 0) {
			health -= 1;
		}
		if (player.getX() > (gameEngine.mazeLength - 3) * 70 + 5 && player.getY() > (gameEngine.mazeLength - 3) * 70 + 5) {
			win();
		}
	}

}
