package game;

import java.io.FileWriter;
import java.io.IOException;

import com.jfoenix.controls.JFXTextField;

import characters.Player;
import gun.Weapon;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.GameObject;
import view.Main;
import view.WinAndLoseController;

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
    	DBLogger.getInstance().log.info(this.getClass().getSimpleName() + " created.");
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
    		FileWriter fw = new FileWriter("RESULTS.txt");
    		fw.write("Unfortunately, you lost with score " + GameEngine.lastScore + ". However, we know how this game is addictive and you will start it up again ^^ Thank you for playing.");
    		fw.close();
    		stage.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		System.out.println("YOU LOSE!");
	}

	
	public void win() {
		GameEngine.lastScore = score + health + food;
		try {
    		Stage stage = GameEngine.primaryStage;
    		FileWriter fw = new FileWriter("RESULTS.txt");
    		fw.write("Actually, you won with score " + GameEngine.lastScore + ". However, we know how this game is addictive and you will start it up again ^^ Thank you for playing.");
    		fw.close();
    		stage.close();
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
