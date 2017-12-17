package pickup;

import game.GameManager;
import javafx.scene.image.ImageView;
import objects.CollidableGameObject;

/**
 * Increases player's health.
 * @author H
 *
 */
public class HealthPickup extends Pickup {

	private static final int HEALTH_VALUE = 25;

	public static ImageView graphic;

	public HealthPickup(GameManager gameManager, double x, double y) {
		super(gameManager, x, y);
	}

	@Override
	public void onPickup() {
		gameManager.increaseHealth(HEALTH_VALUE);
	}

}
