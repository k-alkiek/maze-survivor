package mine;

import game.GameEngine;
import game.GameManager;
import javafx.scene.image.ImageView;
import objects.CollidableGameObject;

/**
 * Big Score Mine.
 * 
 * @author H
 *
 */
public class BigScoreMine extends ScoreMine {

	private static final int SCORELOST = 100;

	public static ImageView graphics;

	public BigScoreMine(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public int getDamage() {
		return SCORELOST;
	}

}
