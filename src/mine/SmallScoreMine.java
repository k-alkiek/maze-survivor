package mine;

import game.GameEngine;
import game.GameManager;
import javafx.scene.image.ImageView;
import objects.CollidableGameObject;

/**
 * Small score mine.
 * 
 * @author H
 *
 */
public class SmallScoreMine extends ScoreMine {

	private static final int SCORELOST = 50;

	public static ImageView graphics;

	public SmallScoreMine(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public int getDamage() {
		return SCORELOST;
	}

}
