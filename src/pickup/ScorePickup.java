package pickup;

import game.GameManager;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import objects.CollidableGameObject;

/**
 * @author H
 *
 */
public class ScorePickup extends Pickup {

	private static final int SCORE_VALUE = 25;

	public static ImageView graphic;

	public ScorePickup(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public void onPickup() {
		if (!picked) {
			gameManager.incrementScore(SCORE_VALUE);
			picked = true;
		}
	}

}
